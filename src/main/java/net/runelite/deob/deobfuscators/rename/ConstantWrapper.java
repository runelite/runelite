package net.runelite.deob.deobfuscators.rename;

import java.util.Objects;
import net.runelite.deob.attributes.code.instruction.types.PushConstantInstruction;

public class ConstantWrapper
{
	private Object object;
	private PushConstantInstruction pci;

	public ConstantWrapper(Object object, PushConstantInstruction pci)
	{
		this.object = object;
		this.pci = pci;
	}
	
	@Override
	public String toString()
	{
		return "constant " + object.getClass().getName() + " " + object + " from instruction " + pci;
	}

	@Override
	public int hashCode()
	{
		int hash = 3;
		hash = 53 * hash + Objects.hashCode(this.object);
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final ConstantWrapper other = (ConstantWrapper) obj;
		if (!Objects.equals(this.object, other.object))
		{
			return false;
		}
		return true;
	}

	
}
