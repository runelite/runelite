/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.deob.deobfuscators.arithmetic;

import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.ArrayLoad;
import net.runelite.asm.attributes.code.instruction.types.ArrayStoreInstruction;
import net.runelite.asm.attributes.code.instruction.types.DivisionInstruction;
import net.runelite.asm.attributes.code.instruction.types.FieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.asm.attributes.code.instructions.IAdd;
import net.runelite.asm.attributes.code.instructions.IMul;
import net.runelite.asm.attributes.code.instructions.IShR;
import net.runelite.asm.attributes.code.instructions.ISub;
import net.runelite.asm.attributes.code.instructions.If;
import net.runelite.asm.attributes.code.instructions.If0;
import net.runelite.asm.attributes.code.instructions.LAdd;
import net.runelite.asm.attributes.code.instructions.LCmp;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.attributes.code.instructions.LMul;
import net.runelite.asm.attributes.code.instructions.LSub;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.execution.MethodContext;
import net.runelite.asm.execution.StackContext;
import net.runelite.deob.DeobAnnotations;
import net.runelite.deob.Deobfuscator;
import static net.runelite.deob.deobfuscators.arithmetic.DMath.modInverse;
import static net.runelite.deob.deobfuscators.arithmetic.DMath.multiply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModArith implements Deobfuscator
{
	private static final Logger logger = LoggerFactory.getLogger(ModArith.class);

	private ClassGroup group;
	private Execution execution;
	private final Map<Field, FieldInfo> fieldInfo = new HashMap<>();
	private List<Pair> pairs = new ArrayList<>();
	private Encryption encryption = new Encryption();

	private FieldInfo getFieldInfo(Field field)
	{
		FieldInfo f = fieldInfo.get(field);
		if (f == null)
		{
			f = new FieldInfo();
			fieldInfo.put(field, f);
		}
		return f;
	}

	private static List<InstructionContext> getInsInExpr(InstructionContext ctx, Set<Instruction> set, boolean imul)
	{
		List<InstructionContext> l = new ArrayList<>();

		if (ctx == null || set.contains(ctx.getInstruction()))
		{
			return l;
		}

		set.add(ctx.getInstruction());

		if (imul)
		{
			if (!(ctx.getInstruction() instanceof IMul) & !(ctx.getInstruction() instanceof LMul))
			{
				l.add(ctx);
				return l;
			}
		}
		else
		{
			// invoke and array store pops are unrelated to each other
			if (ctx.getInstruction() instanceof InvokeInstruction
				|| ctx.getInstruction() instanceof ArrayStoreInstruction
				|| ctx.getInstruction() instanceof ArrayLoad
				|| ctx.getInstruction() instanceof If
				|| ctx.getInstruction() instanceof If0
				|| ctx.getInstruction() instanceof LCmp
				|| ctx.getInstruction() instanceof DivisionInstruction
				|| ctx.getInstruction() instanceof IShR)
			{
				return l;
			}

			l.add(ctx);
		}

		for (StackContext s : ctx.getPops())
		{
			l.addAll(getInsInExpr(s.getPushed(), set, imul));
		}
		for (StackContext s : ctx.getPushes())
		{
			for (InstructionContext i : s.getPopped())
			{
				l.addAll(getInsInExpr(i, set, imul));
			}
		}

		return l;
	}

	// find associated constants with each field
	private void findConstants(MethodContext mctx)
	{
		for (InstructionContext ctx : mctx.getInstructionContexts())
		{
			if (ctx.getInstruction() instanceof FieldInstruction)
			{
				FieldInstruction fi = (FieldInstruction) ctx.getInstruction();

				if (fi.getMyField() == null)
				{
					continue;
				}

				if ((!fi.getField().getType().equals(Type.INT)
					&& !fi.getField().getType().equals(Type.LONG))
					|| fi.getField().getType().isArray())
				{
					continue;
				}

				FieldInfo fieldInfo = getFieldInfo(fi.getMyField());

				List<InstructionContext> l = getInsInExpr(ctx, new HashSet(), false);
				boolean other = false; // check if this contains another field
				boolean getter = false, setter = false;
				for (InstructionContext i : l)
				{
					if (i.getInstruction() instanceof FieldInstruction)
					{
						FieldInstruction fi2 = (FieldInstruction) i.getInstruction();
						Field myField = fi2.getMyField();

						if (myField != null && myField != fi.getMyField())
						{
							Type t = myField.getType();
							if (t.equals(fi.getMyField().getType()))
							{
								other = true;
							}
						}

						else if (myField != null && myField == fi.getMyField())
						{
							if (fi2 instanceof SetFieldInstruction)
							{
								setter = true;
							}
							else
							{
								getter = true;
							}
						}
					}
				}

				// check if this is a constant assignment
				boolean constant = false;
				if (fi instanceof SetFieldInstruction)
				{
					InstructionContext pushedsfi = ctx.getPops().get(0).getPushed(); // value being set
					pushedsfi = pushedsfi.resolve(ctx.getPops().get(0));

					if (pushedsfi.getInstruction() instanceof LDC)
					{
						constant = true;
					}
				}

				for (InstructionContext i : l)
				{
					if (i.getInstruction() instanceof LDC)
					{
						PushConstantInstruction w = (PushConstantInstruction) i.getInstruction();
						if (w.getConstant() instanceof Integer || w.getConstant() instanceof Long)
						{
							AssociatedConstant n = new AssociatedConstant();
							n.value = (Number) w.getConstant();
							n.other = other;
							n.constant = constant;
							n.getter = getter;
							n.setter = setter;
							fieldInfo.constants.add(n);
						}
					}
				}
			}
		}
	}

	// find potential getters/setters for each field
	private void findUses(MethodContext mctx)
	{
		for (InstructionContext ctx : mctx.getInstructionContexts())
		{
			if (ctx.getInstruction() instanceof IMul || ctx.getInstruction() instanceof LMul)
			{
				Instruction one = ctx.getPops().get(0).getPushed().getInstruction();
				Instruction two = ctx.getPops().get(1).getPushed().getInstruction();

				PushConstantInstruction pc = null;
				GetFieldInstruction gf = null;
				if (one instanceof PushConstantInstruction && two instanceof GetFieldInstruction)
				{
					pc = (PushConstantInstruction) one;
					gf = (GetFieldInstruction) two;
				}
				else if (two instanceof PushConstantInstruction && one instanceof GetFieldInstruction)
				{
					pc = (PushConstantInstruction) two;
					gf = (GetFieldInstruction) one;
				}

				if (pc == null)
				{
					continue;
				}

				Field field = gf.getMyField();
				if (field == null)
				{
					continue;
				}

				FieldInfo fieldInfo = getFieldInfo(field);

				// parse the full multiplication expression to
				// get all associated constants
				List<InstructionContext> insInExpr = getInsInExpr(ctx, new HashSet(), true);

				for (InstructionContext ctx2 : insInExpr)
				{
					if (!(ctx2.getInstruction() instanceof PushConstantInstruction))
					{
						continue;
					}

					PushConstantInstruction pci3 = (PushConstantInstruction) ctx2.getInstruction();
					Number value = (Number) pci3.getConstant();

					// field * constant
					if (value instanceof Integer || value instanceof Long)
					{
						fieldInfo.getters.add(value);
					}
				}
			}
			else if (ctx.getInstruction() instanceof SetFieldInstruction)
			{
				SetFieldInstruction sf = (SetFieldInstruction) ctx.getInstruction();

				Field field = sf.getMyField();
				if (field == null)
				{
					continue;
				}

				FieldInfo fieldInfo = getFieldInfo(field);

				InstructionContext pushedsfi = ctx.getPops().get(0).getPushed(); // value being set
				pushedsfi = pushedsfi.resolve(ctx.getPops().get(0));

				if (!(pushedsfi.getInstruction() instanceof IMul) && !(pushedsfi.getInstruction() instanceof LMul)
					&& !(pushedsfi.getInstruction() instanceof IAdd) && !(pushedsfi.getInstruction() instanceof LAdd)
					&& !(pushedsfi.getInstruction() instanceof ISub) && !(pushedsfi.getInstruction() instanceof LSub))
				{
					if (pushedsfi.getInstruction() instanceof LDC)
					{
						PushConstantInstruction ldc = (PushConstantInstruction) pushedsfi.getInstruction();

						if (ldc.getConstant() instanceof Integer || ldc.getConstant() instanceof Long)
						{
							Number i = (Number) ldc.getConstant();

							// field = constant
							fieldInfo.setters.add(i);
						}
					}
					continue;
				}

				Instruction one = pushedsfi.getPops().get(0).getPushed().getInstruction();
				Instruction two = pushedsfi.getPops().get(1).getPushed().getInstruction();

				// field = field + imul
				if (pushedsfi.getInstruction() instanceof IAdd)
				{
					if (one instanceof IMul && two instanceof GetFieldInstruction)
					{
						one = pushedsfi.getPops().get(0).getPushed().getPops().get(0).getPushed().getInstruction();
						two = pushedsfi.getPops().get(0).getPushed().getPops().get(1).getPushed().getInstruction();
					}
				}

				// if both one and two are constants then one of them must not be a setter
				PushConstantInstruction pc = null;
				if (one instanceof PushConstantInstruction
					&& !(two instanceof PushConstantInstruction))
				{
					pc = (PushConstantInstruction) one;
				}
				else if (two instanceof PushConstantInstruction
					&& !(one instanceof PushConstantInstruction))
				{
					pc = (PushConstantInstruction) two;
				}

				if (pc == null)
				{
					continue;
				}

				Number value2 = (Number) pc.getConstant();

				// field = something * constant
				if (value2 instanceof Integer || value2 instanceof Long)
				{
					fieldInfo.setters.add(value2);
				}
			}
		}
	}

	private Pair guess(Field field, Collection<Number> constants)
	{
		if (constants.isEmpty())
		{
			return null;
		}

		// multiply each by each,
		// lowest number wins
		Number s1 = 0, s2 = 0;
		Number smallest = 0;
		for (Number i : constants)
		{
			for (Number i2 : constants)
			{
				if (DMath.equals(i, 0) || DMath.equals(i2, 0)
					|| DMath.equals(i, 1) || DMath.equals(i2, 1))
				{
					continue;
				}

				if (i.equals(i2))
				{
					// it is never i*i. if there is only one constant,
					// prefer i*inverse(i) if possible by setting i2
					// to 1
					if (i2 instanceof Integer)
					{
						i2 = 1;
					}
					else if (i2 instanceof Long)
					{
						i2 = 1L;
					}
				}

				Number result = multiply(i, i2);

				if (DMath.equals(result, 0))
				{
					continue;
				}

				boolean smaller;
				if (smallest.longValue() == 0L
					// abs(MIN_VALUE) is MIN_VALUE - it is not the smallest
					|| (result instanceof Long && Long.MIN_VALUE == result.longValue())
					|| (result instanceof Integer && Integer.MIN_VALUE == result.intValue()))
				{
					smaller = false;
				}
				else if (i instanceof Long)
				{
					smaller = Math.abs((long) result) < Math.abs((long) smallest);
				}
				else
				{
					smaller = Math.abs((int) result) < Math.abs((int) smallest);
				}

				if (DMath.equals(smallest, 0) || DMath.equals(result, 1) || smaller)
				{
					s1 = i;
					s2 = i2;
					smallest = result;
				}
			}
		}

		if (!DMath.equals(smallest, 1))
		{
			// smallest s1*s2 is not 1
			if (DMath.isInversable(smallest))
			{
				// s1*s2=smallest
				// divide both sides by inverse(smallest)
				// to make the right hand side 1

				// pick s1/s2 depending on which one isn't inversible
				if (DMath.isInversable(s1))
				{
					s2 = multiply(s2, modInverse(smallest));
					smallest = 1; // rhs goes to one
					assert multiply(s1, s2).intValue() == 1;
				}
				else if (DMath.isInversable(s2))
				{
					s1 = multiply(s1, modInverse(smallest));
					smallest = 1;
					assert multiply(s1, s2).intValue() == 1;
				}
				else
				{
					return null;
				}
			}
			else
			{
				// s1*s2 is not 1 and smallest is not inversible
				// calculate a new s1 or s2 if one is inversible
				if (DMath.isInversable(s1))
				{
					// assume this is s1 * (s2 * constant) = 1 * constant
					Number newTwo = modInverse(s1); // we guess s2 is actually this
					// check if s2 * constant = old value of s2
					if (multiply(newTwo, smallest).equals(s2))
					{
						s2 = newTwo; // s2 changes to new value
						smallest = 1; // rhs goes to 1
						assert multiply(s1, s2).intValue() == 1;
					}
				}
				else if (DMath.isInversable(s2))
				{
					Number newOne = modInverse(s2);
					if (multiply(newOne, smallest).equals(s1))
					{
						s1 = newOne;
						smallest = 1;
						assert multiply(s1, s2).intValue() == 1;
					}
				}
				else
				{
					return null;
				}
			}
		}

		// Now that we have two constants, figure out which one is
		// the getter and which is the setter
		boolean g = isGetterOrSetter(field, true, s1),
			g2 = isGetterOrSetter(field, true, s2);

		boolean inverse = false;
		if (g == g2)
		{
			// both are getters
			inverse = true;
			g = isGetterOrSetter(field, false, s1);
			g2 = isGetterOrSetter(field, false, s2);
		}

		if (g == g2)
		{
			// special case, when the guessted value is correct but
			// negated, setters and getters will both contain -1,
			// and the guess will be -1/-1.
			if (s1.longValue() == -1L && s2.longValue() == -1L)
			{
				Pair p = new Pair();
				p.field = field.getPoolField();
				p.getter = s1;
				p.setter = s2;
				return p;
			}
			// both are also setters
		}
		else
		{
			Pair p = new Pair();
			p.field = field.getPoolField();
			if (g != inverse)
			{
				p.getter = s1;
				p.setter = s2;
			}
			else
			{
				p.getter = s2;
				p.setter = s1;
			}
			return p;
		}
		return null;
	}

	// figure out if value is a getter or setter
	private boolean isGetterOrSetter(Field field, boolean getter, Number value)
	{
		FieldInfo fieldInfo = getFieldInfo(field);

		Collection<Number> c;
		if (getter)
		{
			c = fieldInfo.getters;
		}
		else
		{
			c = fieldInfo.setters;
		}
		if (c == null)
		{
			return false;
		}

		if (c.contains(value))
		{
			return true;
		}

		return false;
	}

	private void guess()
	{
		for (ClassFile cf : group.getClasses())
		{
			for (Field f : cf.getFields())
			{
				FieldInfo fieldInfo = getFieldInfo(f);

				Collection<AssociatedConstant> col = fieldInfo.constants; // all constants in instructions associated with the field
				if (col.isEmpty())
				{
					continue;
				}

				Type type = f.getType();
				assert type.equals(Type.INT) || type.equals(Type.LONG);

				Class typeOfField = type.equals(Type.INT) ? Integer.class : Long.class;

				// filter collect constants of the correct type
				Collection<AssociatedConstant> col2 = col.stream()
					.filter(i -> i.value.getClass() == typeOfField)
					.collect(Collectors.toList());

				// filer out ones that have another field in the expression
				List<Number> noOther = col2.stream()
					.filter(i -> !i.other && !i.constant)
					.map(i -> i.value)
					.distinct()
					.collect(Collectors.toList());
				List<Number> other = col2.stream()
					.filter(i -> i.other || i.constant)
					.map(i -> i.value)
					.collect(Collectors.toList());
				other.addAll(noOther);
				other = ImmutableSet.copyOf(other).asList();

				// guess with constants not associated with other fields
				Pair p = this.guess(f, noOther);
				if (p == null)
				{
					p = this.guess(f, other); // fall back to all constants
				}

				// check that this guess doesn't increase constants
				if (p != null && !fieldInfo.guessDecreasesConstants(p))
				{
					continue;
				}
				if (p != null)
				{
					pairs.add(p);
				}
			}
		}
	}

	@Override
	public void run(ClassGroup group)
	{
		this.group = group;
	}

	private void insertGetterSetterMuls(Encryption encr)
	{
		// after getfield insert imul * setter
		// before setfield insert imul * getter
		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods())
			{
				Code code = m.getCode();
				if (code == null)
				{
					continue;
				}

				Instructions ins = code.getInstructions();
				List<Instruction> ilist = ins.getInstructions();

				for (int i = 0; i < ilist.size(); ++i)
				{
					Instruction in = ilist.get(i);

					if (in instanceof SetFieldInstruction)
					{
						SetFieldInstruction sfi = (SetFieldInstruction) in;
						Field f = sfi.getMyField();

						if (f == null)
						{
							continue;
						}

						Pair p = encr.getField(f.getPoolField());
						if (p == null)
						{
							continue;
						}

						// insert push getter
						// insert imul
						if (p.getType() == Integer.class)
						{
							ilist.add(i++, new LDC(ins, (int) p.getter));
							ilist.add(i++, new IMul(ins));
						}
						else if (p.getType() == Long.class)
						{
							ilist.add(i++, new LDC(ins, (long) p.getter));
							ilist.add(i++, new LMul(ins));
						}
						else
						{
							throw new IllegalStateException();
						}
					}
					else if (in instanceof GetFieldInstruction)
					{
						GetFieldInstruction sfi = (GetFieldInstruction) in;
						Field f = sfi.getMyField();

						if (f == null)
						{
							continue;
						}

						Pair p = encr.getField(f.getPoolField());
						if (p == null)
						{
							continue;
						}

						// add after:
						// push setter
						// imul
						if (p.getType() == Integer.class)
						{
							ilist.add(++i, new LDC(ins, (int) p.setter));
							ilist.add(++i, new IMul(ins));
						}
						else if (p.getType() == Long.class)
						{
							ilist.add(++i, new LDC(ins, (long) p.setter));
							ilist.add(++i, new LMul(ins));
						}
						else
						{
							throw new IllegalStateException();
						}
					}
				}
			}
		}
	}

	public int runOnce()
	{
		group.buildClassGraph();

		pairs.clear();
		fieldInfo.clear();

		execution = new Execution(group);
		execution.addMethodContextVisitor(i -> findUses(i));
		execution.addMethodContextVisitor(i -> findConstants(i));
		execution.populateInitialMethods();
		execution.run();

		guess();

		int i = 0;
		Encryption encr = new Encryption();
		for (Pair pair : pairs)
		{
			logger.debug("Processing {} getter {} setter {}", pair.field.getName(), pair.getter, pair.setter);

			encr.addPair(pair);
			encryption.addPair(pair); // sum total
			++i;
		}

		logger.info("Done processing {}", i);

		if (i > 0)
		{
			insertGetterSetterMuls(encr);
		}

		return i;
	}

	public void annotateEncryption()
	{
		for (ClassFile cf : group.getClasses())
		{
			for (Field f : cf.getFields())
			{
				Pair pair = encryption.getField(f.getPoolField());
				if (pair == null)
				{
					continue;
				}

				if (pair.getter.longValue() == 1L)
				{
					continue;
				}

				String ename = pair.getType() == Long.class
					? "longValue"
					: "intValue";
				f.getAnnotations().addAnnotation(DeobAnnotations.OBFUSCATED_GETTER, ename, pair.getter);
			}
		}
	}

	Encryption getEncryption()
	{
		return encryption;
	}
}
