package info.sigterm.deob.execution;

import info.sigterm.deob.ClassGroup;
import java.util.ArrayList;
import java.util.List;

public class Execution
{
	private ClassGroup group;
	public List<Frame> frames = new ArrayList<>(),
			processedFrames = new ArrayList<>();

	public Execution(ClassGroup group)
	{
		this.group = group;
	}
	
	public int run()
	{
		int fcount = 0;
		
		while (!frames.isEmpty())
		{
			Frame frame = frames.remove(0);
			++fcount;
			frame.execute();
			processedFrames.add(frame);
		}
		
		return fcount;
	}
}
