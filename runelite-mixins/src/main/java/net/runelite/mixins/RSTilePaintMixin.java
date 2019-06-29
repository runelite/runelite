package net.runelite.mixins;

import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSTilePaint;

@Mixin(RSTilePaint.class)
public abstract class RSTilePaintMixin implements RSTilePaint
{
	@Inject
	private int rl$paintModelBufferOffset;

	@Inject
	private int rl$paintModelUvBufferOffset;

	@Inject
	private int rl$paintModelBufferLen;

	@Inject
	@Override
	public int getBufferOffset()
	{
		return rl$paintModelBufferOffset;
	}

	@Inject
	@Override
	public void setBufferOffset(int bufferOffset)
	{
		rl$paintModelBufferOffset = bufferOffset;
	}

	@Inject
	@Override
	public int getUvBufferOffset()
	{
		return rl$paintModelUvBufferOffset;
	}

	@Inject
	@Override
	public void setUvBufferOffset(int bufferOffset)
	{
		rl$paintModelUvBufferOffset = bufferOffset;
	}

	@Inject
	@Override
	public int getBufferLen()
	{
		return rl$paintModelBufferLen;
	}

	@Inject
	@Override
	public void setBufferLen(int bufferLen)
	{
		rl$paintModelBufferLen = bufferLen;
	}
}
