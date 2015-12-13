package net.runelite.deob.execution;

public class ParallellMappingExecutor
{
	private Execution e, e2;
	private InstructionContext p1, p2;

	public ParallellMappingExecutor(Execution one, Execution two)
	{
		this.e = one;
		this.e2 = two;
	}
	
	public boolean step()
	{
		assert e.frames.size() == e2.frames.size();
		
		p1 = p2 = null;
		
		if (e.frames.isEmpty())
			return false;
		
		Frame f1 = e.frames.get(0), f2 = e2.frames.get(0);

		assert f1.other == f2;
		assert f2.other == f1;

		assert f1.isExecuting() == f2.isExecuting();

		// this will happen because conditional branches will create their frame
		// before realizing its already executed it before, so it will set the frame
		// as not executing
		if (!f1.isExecuting())
		{
			assert e.frames.get(0) == f1;
			assert e2.frames.get(0) == f2;

			e.frames.remove(0);
			e2.frames.remove(0);
			
			return step();
		}

		// step frame
		f1.execute();
		f2.execute();

		// get what each frame is paused/exited on
		p1 = f1.getInstructions().get(f1.getInstructions().size() - 1);
		p2 = f2.getInstructions().get(f2.getInstructions().size() - 1);

		// frames can stop executing at different times if one sees a jump
		// that has been done before, so stop both and remove the pending branch
		// of the jump
		if (!f1.isExecuting() || !f2.isExecuting())
		{
			for (Frame branch : p1.getBranches())
			{
				e.frames.remove(branch);
			}
			for (Frame branch : p2.getBranches())
			{
				e2.frames.remove(branch);
			}

		//	System.out.println("Something exited " + f1 + " " + f2);

			assert e.frames.get(0) == f1;
			assert e2.frames.get(0) == f2;

			e.frames.remove(0);
			e2.frames.remove(0);
			
			return step();
		}

		assert e.paused;
		assert e2.paused;
		
		return true;
	}

	public InstructionContext getP1()
	{
		return p1;
	}

	public InstructionContext getP2()
	{
		return p2;
	}
}
