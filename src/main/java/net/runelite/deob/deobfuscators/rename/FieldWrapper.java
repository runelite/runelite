package net.runelite.deob.deobfuscators.rename;

import java.util.Objects;
import net.runelite.deob.Field;
import net.runelite.deob.attributes.code.instruction.types.FieldInstruction;
import net.runelite.deob.signature.Type;

public class FieldWrapper
{
	private static final int FIELD_MASK = Field.ACC_FINAL | Field.ACC_STATIC;
	
	private FieldInstruction fi;
	public Field field;
	private Type type;
	private short accessFlags;

	public FieldWrapper(FieldInstruction fi ,Field field)
	{
		this.fi = fi;
		this.field = field;
		this.type = field.getType();
		this.accessFlags = field.getAccessFlags();
	}
	
	@Override
	public String toString()
	{
		return field.toString() + " access from instruction " + fi;
	}

	@Override
	public int hashCode()
	{
		int hash = 3;
		hash = 29 * hash + Objects.hashCode(this.type);
		hash = 29 * hash + (this.accessFlags & FIELD_MASK);
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
		final FieldWrapper other = (FieldWrapper) obj;
		if (!Objects.equals(this.type, other.type))
		{
			return false;
		}
		if ((this.accessFlags & FIELD_MASK) != (other.accessFlags & FIELD_MASK))
		{
			return false;
		}
		return true;
	}
}
