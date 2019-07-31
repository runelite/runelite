package net.runelite.deob.updater.mappingdumper;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.Parameter;
import net.runelite.asm.attributes.code.instruction.types.GetFieldInstruction;
import net.runelite.asm.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.asm.attributes.code.instruction.types.SetFieldInstruction;
import net.runelite.asm.pool.Class;
import net.runelite.asm.pool.Field;
import net.runelite.deob.DeobAnnotations;
import net.runelite.deob.updater.MappingDumper;

public class MappedMethod
{
	@SerializedName("method")
	public String exportedName;
	public String owner;
	@SerializedName("name")
	public String obfuscatedName;
	public int access;
	public List<String> parameters;
	public String descriptor;
	public String garbageValue;
	public List<Integer> lineNumbers;
	public Map<Field, Integer> fieldGets = new HashMap<>();
	public Map<Field, Integer> fieldPuts = new HashMap<>();
	public Map<net.runelite.asm.pool.Method, Integer> dependencies = new HashMap<>();

	public MappedMethod visitMethod(final Method m, final MappingDump dump)
	{
		MappingDumper.putMap(m.getPoolMethod(), this);
		exportedName = DeobAnnotations.getExportedName(m.getAnnotations());

		owner = MappingDumper.getMap(m.getClassFile()).obfuscatedName;

		obfuscatedName = DeobAnnotations.getObfuscatedName(m.getAnnotations());
		if (obfuscatedName == null)
		{
			obfuscatedName = m.getName();
		}

		access = m.getAccessFlags();

		parameters = m.getParameters()
			.stream()
			.map(Parameter::getName)
			.collect(Collectors.toList());

		descriptor = m.getObfuscatedSignature().toString();

		garbageValue = DeobAnnotations.getDecoder(m);

		Code c = m.getCode();
		if (c != null)
		{
			visitCode(c);
		}

		return this;
	}

	private void visitCode(Code c)
	{
		lineNumbers = c.getLineNumbers();

		Instructions ins = c.getInstructions();
		for (Instruction i : ins.getInstructions())
		{
			if (i instanceof GetFieldInstruction)
			{
				Field k = ((GetFieldInstruction) i).getField();
				int v = fieldGets.getOrDefault(k, 0) + 1;
				fieldGets.put(k, v);
			}
			else if (i instanceof SetFieldInstruction)
			{
				Field k = ((SetFieldInstruction) i).getField();
				int v = fieldPuts.getOrDefault(k, 0) + 1;
				fieldPuts.put(k, v);
			}
			else if (i instanceof InvokeInstruction)
			{
				List<Method> met = ((InvokeInstruction) i).getMethods();
				net.runelite.asm.pool.Method k;
				if (met.size() > 0)
				{
					Method mme = met.get(0);
					k = new net.runelite.asm.pool.Method(
						new Class(DeobAnnotations.getObfuscatedName(mme.getClassFile().getAnnotations())),
						DeobAnnotations.getObfuscatedName(mme.getAnnotations()),
						mme.getObfuscatedSignature() != null ? mme.getObfuscatedSignature() : mme.getDescriptor()
					);
				}
				else
				{
					k = ((InvokeInstruction) i).getMethod();
				}

				int v = dependencies.getOrDefault(k, 0) + 1;
				dependencies.put(k, v);
			}
		}
	}
}
