package net.runelite.deob.deobfuscators.transformers;

import java.util.ListIterator;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.PushConstantInstruction;
import net.runelite.asm.attributes.code.instructions.GetStatic;
import net.runelite.asm.attributes.code.instructions.ILoad;
import net.runelite.asm.attributes.code.instructions.IfICmpEq;
import net.runelite.asm.attributes.code.instructions.IfICmpNe;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.attributes.code.instructions.PutStatic;
import net.runelite.asm.attributes.code.instructions.VReturn;
import net.runelite.asm.pool.Class;
import net.runelite.asm.signature.Signature;
import net.runelite.deob.Transformer;
import net.runelite.deob.deobfuscators.transformers.scriptopcodes.ScriptOpcode;
import org.objectweb.asm.Opcodes;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;

public class ScriptOpcodesTransformer implements Transformer // robots in disguise
{
	private static final String SCRIPT_OPCODES = "net/runelite/rs/ScriptOpcodes";

	@Override
	public void transform(ClassGroup group)
	{
		initializeOpcodesClassFile(group);

		for (ClassFile cf : group.getClasses())
		{
			if (cf.getName().startsWith("net/runelite/rs"))
			{
				continue;
			}

			for (Method m : cf.getMethods())
			{
				if (!m.isStatic())
				{
					continue;
				}

				if (!m.getDescriptor().getArguments().contains(new Type("LScript;")) && !m.getDescriptor().getArguments().contains(new Type("LScriptEvent;")))
				{
					continue;
				}

				boolean varIndexIsKnownAnd0 = m.getDescriptor().getArguments().contains(new Type("LScript;"));

				Code code = m.getCode();
				Instructions ins = code.getInstructions();
				ListIterator<Instruction> it = ins.getInstructions().listIterator();

				Instruction i;
				while (it.hasNext())
				{
					i = it.next();

					if (!(i instanceof ILoad) || (varIndexIsKnownAnd0 && ((ILoad) i).getVariableIndex() != 0))
					{
						continue;
					}

					i = it.next();

					if (!(i instanceof PushConstantInstruction) ||
						!(((PushConstantInstruction) i).getConstant() instanceof Number))
					{
						continue;
					}

					int val = ((Number) ((PushConstantInstruction) i).getConstant()).intValue();
					String name = ScriptOpcode.nameFromID(val);

					i = it.next();

					if (name == null || !(i instanceof IfICmpNe || i instanceof IfICmpEq))
					{
						continue;
					}

					it.previous();
					it.previous();

					net.runelite.asm.pool.Field pool = new net.runelite.asm.pool.Field(
						new Class(SCRIPT_OPCODES),
						name,
						Type.INT
					);

					GetStatic getStatic = new GetStatic(ins, pool);
					it.set(getStatic);
				}
			}
		}
	}

	private static void initializeOpcodesClassFile(ClassGroup group)
	{
		ClassFile scriptOpcodes = group.findClass(SCRIPT_OPCODES);
		if (scriptOpcodes == null)
		{
			scriptOpcodes = new ClassFile(group);
			scriptOpcodes.setName(SCRIPT_OPCODES);
			scriptOpcodes.setSuperName(Type.OBJECT.getInternalName());
			scriptOpcodes.setAccess(Opcodes.ACC_PUBLIC);
			group.addClass(scriptOpcodes);
		}
		else
		{
			scriptOpcodes.getFields().clear();
		}

		Method clinit = scriptOpcodes.findMethod("<clinit>");
		if (clinit == null)
		{
			clinit = new Method(scriptOpcodes, "<clinit>", new Signature("()V"));
			clinit.setStatic(true);
			Code code = new Code(clinit);
			code.setMaxStack(1);
			clinit.setCode(code);
			scriptOpcodes.addMethod(clinit);
		}

		Code code = clinit.getCode();
		Instructions ins = code.getInstructions();

		for (ScriptOpcode opcode : ScriptOpcode.values())
		{
			Field field = new Field(scriptOpcodes, opcode.name(), Type.INT);
			field.setAccessFlags(ACC_PUBLIC | ACC_STATIC | ACC_FINAL);
			field.setValue(opcode.opcode);
			scriptOpcodes.addField(field);

			LDC ldc = new LDC(ins, opcode.opcode);
			PutStatic put = new PutStatic(ins, field);
			ins.addInstruction(0, ldc);
			ins.addInstruction(1, put);
		}

		ins.addInstruction(new VReturn(ins));
	}
}
