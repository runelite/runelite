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
	private int underlaySwColor;

	@Inject
	private int underlaySeColor;

	@Inject
	private int underlayNeColor;

	@Inject
	private int underlayNwColor;

	@Inject
	private int overlaySwColor;

	@Inject
	private int overlaySeColor;

	@Inject
	private int overlayNeColor;

	@Inject
	private int overlayNwColor;

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

	@Inject
	@Override
	public int getUnderlaySwColor()
	{
		return underlaySwColor;
	}

	@Inject
	@Override
	public void setUnderlaySwColor(int color)
	{
		underlaySwColor = color;
	}

	@Inject
	@Override
	public int getUnderlaySeColor()
	{
		return underlaySeColor;
	}

	@Inject
	@Override
	public void setUnderlaySeColor(int color)
	{
		underlaySeColor = color;
	}

	@Inject
	@Override
	public int getUnderlayNeColor()
	{
		return underlayNeColor;
	}

	@Inject
	@Override
	public void setUnderlayNeColor(int color)
	{
		underlayNeColor = color;
	}

	@Inject
	@Override
	public int getUnderlayNwColor()
	{
		return underlayNwColor;
	}

	@Inject
	@Override
	public void setUnderlayNwColor(int color)
	{
		underlayNwColor = color;
	}

	@Inject
	@Override
	public int getOverlaySwColor()
	{
		return overlaySwColor;
	}

	@Inject
	@Override
	public void setOverlaySwColor(int color)
	{
		overlaySwColor = color;
	}

	@Inject
	@Override
	public int getOverlaySeColor()
	{
		return overlaySeColor;
	}

	@Inject
	@Override
	public void setOverlaySeColor(int color)
	{
		overlaySeColor = color;
	}

	@Inject
	@Override
	public int getOverlayNeColor()
	{
		return overlayNeColor;
	}

	@Inject
	@Override
	public void setOverlayNeColor(int color)
	{
		overlayNeColor = color;
	}

	@Inject
	@Override
	public int getOverlayNwColor()
	{
		return overlayNwColor;
	}

	@Inject
	@Override
	public void setOverlayNwColor(int color)
	{
		overlayNwColor = color;
	}
}
