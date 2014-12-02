package info.sigterm.deob.execution;

import info.sigterm.deob.Method;
import info.sigterm.deob.attributes.Code;

public class Frame
{
	private Path path;
	private Method method;
	private Stack stack;
	private Variables variables;

	public Frame(Path path, Method method)
	{
		Code code = method.getCode();

		this.path = path;
		this.method = method;

		stack = new Stack(code.getMaxStack());
		variables = new Variables(code.getMaxLocals());
	}

	public Stack getStack()
	{
		return stack;
	}

	public Variables getVariables()
	{
		return variables;
	}

	public void init(Method method, Object[] args)
	{
		for (Object o : args)
			stack.push(o);

		Code code = method.getCode();
		code.execute(this);
	}
}
