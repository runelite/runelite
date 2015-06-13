package info.sigterm.deob.execution;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Method;

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
	
	public void run()
	{
		int count = 0, fcount = 0;
		for (ClassFile cf : group.getClasses())
			for (Method method : cf.getMethods().getMethods())
			{
				if (method.getCode() == null)
					continue;
				Frame f = new Frame(this, method);
				frames.add(f);
				fcount += this.runFrames();
				++count;
			}
		
		System.out.println("Processed " + count + " methods and " + fcount + " paths");
	}
	
	private int runFrames()
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
