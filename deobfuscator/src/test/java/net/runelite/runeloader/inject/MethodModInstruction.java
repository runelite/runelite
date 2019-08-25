package net.runelite.runeloader.inject;

import java.util.Iterator;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodNode;

public class MethodModInstruction
{
	private final int startIndex;
	private final AbstractInsnNode[] nodes;
	public final String owner;
	public final String method;
	public final String desc;

	public MethodModInstruction(int var1, AbstractInsnNode[] var2, String var3, String var4, String var5)
	{
		this.startIndex = var1;
		this.nodes = var2;
		this.owner = var3;
		this.method = var4;
		this.desc = var5;
	}

	public boolean valid(ClassNode var1)
	{
		return var1.name.equalsIgnoreCase(this.owner);
	}

	public void inject(ClassNode var1)
	{
		Iterator var3 = var1.methods.iterator();

		while (true)
		{
			MethodNode var2;
			do
			{
				do
				{
					if (!var3.hasNext())
					{
						return;
					}

					var2 = (MethodNode) var3.next();
				} while (!var2.name.equalsIgnoreCase(this.method));
			} while (!var2.desc.equalsIgnoreCase(this.desc));

			InsnList var4 = var2.instructions;

			try
			{
				AbstractInsnNode var5 = var4.get(this.startIndex);
				AbstractInsnNode var6 = null;

				for (int var7 = 0; var7 < this.nodes.length; ++var7)
				{
					if (var6 == null)
					{
						var4.insertBefore(var5, this.nodes[var7]);
					}
					else
					{
						var4.insert(var6, this.nodes[var7]);
					}

					var6 = this.nodes[var7];
				}
			}
			catch (Exception var8)
			{
				System.err.println("Failed on " + this.startIndex + " @ " + this.owner + "." + this.method + " " + this.desc);
				var8.printStackTrace();
			}
		}
	}
}
