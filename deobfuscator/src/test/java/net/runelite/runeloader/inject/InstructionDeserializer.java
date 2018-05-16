package net.runelite.runeloader.inject;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.VarInsnNode;

public class InstructionDeserializer implements JsonDeserializer
{
	@Override
	public AbstractInsnNode deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3)
	{
		JsonObject var4 = (JsonObject) var1;
		int var5 = var4.get("opcode").getAsInt();
		if (var5 != 21 && var5 != 25 && var5 != 58 && var5 != 54 && var5 != 22 && var5 != 55)
		{
			String var7;
			String var8;
			String var10;
			if (var5 != 184 && var5 != 182 && var5 != 183)
			{
				if (var5 == 18)
				{
					try
					{
						return new LdcInsnNode(Integer.valueOf(var4.get("cst").getAsInt()));
					}
					catch (Exception var9)
					{
						return new LdcInsnNode(var4.get("cst").getAsString());
					}
				}
				else if (var5 != 187 && var5 != 189)
				{
					if (var5 != 16 && var5 != 17)
					{
						if (var5 != 179 && var5 != 178 && var5 != 180 && var5 != 181)
						{
							return new InsnNode(var5);
						}
						else
						{
							var10 = var4.get("owner").getAsString();
							var7 = var4.get("name").getAsString();
							var8 = var4.get("desc").getAsString();
							return new FieldInsnNode(var5, var10, var7, var8);
						}
					}
					else
					{
						return new IntInsnNode(var5, var4.get("operand").getAsInt());
					}
				}
				else
				{
					return new TypeInsnNode(var5, var4.get("desc").getAsString());
				}
			}
			else
			{
				var10 = var4.get("owner").getAsString();
				var7 = var4.get("name").getAsString();
				var8 = var4.get("desc").getAsString();
				return new MethodInsnNode(var5, var10, var7, var8);
			}
		}
		else
		{
			int var6 = var4.get("var").getAsInt();
			return new VarInsnNode(var5, var6);
		}
	}
}
