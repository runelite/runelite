package info.sigterm.deob.attributes.code;

import java.util.ArrayList;
import java.util.List;

public class Block
{
	public Instruction begin, end;
	public List<Instruction> instructions = new ArrayList<>();
}
