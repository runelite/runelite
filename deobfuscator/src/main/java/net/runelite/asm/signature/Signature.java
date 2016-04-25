package net.runelite.asm.signature;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signature
{
	private static Pattern paramRetPattern = Pattern.compile("\\((.*)\\)(.*)"),
			paramsPattern = Pattern.compile("(\\[*(?:B|C|Z|S|I|J|F|D|(?:L[^;]*;)))");
	
	private List<Type> arguments = new ArrayList<>();
	private Type rv;
	
	public Signature()
	{
	}
	
	public Signature(String str)
	{
		Matcher m = paramRetPattern.matcher(str);
		if (!m.find())
			throw new IllegalArgumentException("Signature has no arguments");
		
		String args = m.group(1), ret = m.group(2);
		
		m = paramsPattern.matcher(args);
		while (m.find())
		{
			String arg = m.group(1);
			arguments.add(new Type(arg));
		}
		
		rv = new Type(ret);
	}
	
	public Signature(Signature other)
	{
		rv = new Type(other.rv);
		for (Type t : other.arguments)
			arguments.add(new Type(t));
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof Signature))
			return false;
		
		Signature a = (Signature) other;
		return arguments.equals(a.arguments) && rv.equals(a.rv);
	}

	@Override
	public int hashCode()
	{
		int hash = 5;
		hash = 97 * hash + Objects.hashCode(this.arguments);
		hash = 97 * hash + Objects.hashCode(this.rv);
		return hash;
	}
	
	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append('(');
		for (Type a : arguments)
			sb.append(a.getFullType());
		sb.append(')');
		sb.append(rv.getFullType());
		return sb.toString();
	}
	
	public int size()
	{
		return arguments.size();
	}
	
	public void remove(int i)
	{
		arguments.remove(i);
	}
	
	public Type getTypeOfArg(int i)
	{
		return arguments.get(i);
	}
	
	public void setTypeOfArg(int i, Type type)
	{
		arguments.set(i, type);
	}
	
	public void addArg(Type type)
	{
		arguments.add(type);
	}
	
	public Type getReturnValue()
	{
		return rv;
	}
	
	public void setTypeOfReturnValue(Type type)
	{
		rv = type;
	}
	
	public List<Type> getArguments()
	{
		return arguments;
	}
}
