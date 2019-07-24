package net.runelite.mixins;

import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSTileModel;

@Mixin(RSTileModel.class)
public abstract class RSTileModelMixin implements RSTileModel
{
	@Inject
	private int rl$modelBufferOffset;

	@Inject
	private int rl$modelUvBufferOffset;

	@Inject
	private int rl$modelBufferLen;

	@Inject
	@Override
	public int getBufferOffset()
	{
		return rl$modelBufferOffset;
	}

	@Inject
	@Override
	public void setBufferOffset(int bufferOffset)
	{
		rl$modelBufferOffset = bufferOffset;
	}

	@Inject
	@Override
	public int getUvBufferOffset()
	{
		return rl$modelUvBufferOffset;
	}

	@Inject
	@Override
	public void setUvBufferOffset(int bufferOffset)
	{
		rl$modelUvBufferOffset = bufferOffset;
	}

	@Inject
	@Override
	public int getBufferLen()
	{
		return rl$modelBufferLen;
	}

	@Inject
	@Override
	public void setBufferLen(int bufferLen)
	{
		rl$modelBufferLen = bufferLen;
	}
}
