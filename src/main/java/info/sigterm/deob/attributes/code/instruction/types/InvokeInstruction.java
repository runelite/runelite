package info.sigterm.deob.attributes.code.instruction.types;

import java.util.List;

import info.sigterm.deob.Method;
import info.sigterm.deob.pool.PoolEntry;

public interface InvokeInstruction
{
	public void removeParameter(int idx);
	
	public PoolEntry getMethod();
	
	public List<Method> getMethods();
}
