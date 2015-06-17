package info.sigterm.deob.attributes.code;

import java.util.ArrayList;
import java.util.List;

public class Block
{
	public Instruction begin, end;
	public List<Instruction> instructions = new ArrayList<>();
	public List<Exception> exceptions = new ArrayList<>(); // is an instruction in the handlers try { }
	public List<Exception> handlers = new ArrayList<>(); // first ins is a handler for exception
}
