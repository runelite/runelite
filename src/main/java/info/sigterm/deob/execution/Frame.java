package info.sigterm.deob.execution;

import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.Code;

public class Frame
{
	private Execution execution;
	private Method method;
	private Stack stack;
	private Variables variables;

	public Frame(Execution execution, Method method)
	{
		Code code = method.getCode();

		this.execution = execution;
		this.method = method;

		stack = new Stack(code.getMaxStack());
		variables = new Variables(code.getMaxLocals());
	}
}
