/*
 * Copyright (c) 2018, Kamiel, <https://github.com/Kamielvf>
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.screenmarkers.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;
import net.runelite.client.plugins.screenmarkers.ScreenMarkerOverlay;
import net.runelite.client.plugins.screenmarkers.ScreenMarkerPlugin;
import net.runelite.client.ui.components.colorpicker.RuneliteColorPicker;
import net.runelite.client.util.ImageUtil;

class ScreenMarkerPanel extends ContainerPanel
{
	private static final int DEFAULT_FILL_OPACITY = 75;

	private static final ImageIcon BORDER_COLOR_ICON;
	private static final ImageIcon BORDER_COLOR_HOVER_ICON;
	private static final ImageIcon NO_BORDER_COLOR_ICON;
	private static final ImageIcon NO_BORDER_COLOR_HOVER_ICON;

	private static final ImageIcon FILL_COLOR_ICON;
	private static final ImageIcon FILL_COLOR_HOVER_ICON;
	private static final ImageIcon NO_FILL_COLOR_ICON;
	private static final ImageIcon NO_FILL_COLOR_HOVER_ICON;

	private static final ImageIcon FULL_OPACITY_ICON;
	private static final ImageIcon FULL_OPACITY_HOVER_ICON;
	private static final ImageIcon NO_OPACITY_ICON;
	private static final ImageIcon NO_OPACITY_HOVER_ICON;

	private final ScreenMarkerOverlay marker;

	private final JLabel borderColorIndicator = new JLabel();
	private final JLabel fillColorIndicator = new JLabel();
	private final JLabel opacityIndicator = new JLabel();

	private final SpinnerModel spinnerModel = new SpinnerNumberModel(5, 0, Integer.MAX_VALUE, 1);
	private final JSpinner thicknessSpinner = new JSpinner(spinnerModel);

	private boolean visible;

	static
	{
		final BufferedImage borderImg = ImageUtil.getResourceStreamFromClass(ScreenMarkerPlugin.class, "border_color_icon.png");
		final BufferedImage borderImgHover = ImageUtil.luminanceOffset(borderImg, -150);
		BORDER_COLOR_ICON = new ImageIcon(borderImg);
		BORDER_COLOR_HOVER_ICON = new ImageIcon(borderImgHover);

		NO_BORDER_COLOR_ICON = new ImageIcon(borderImgHover);
		NO_BORDER_COLOR_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(borderImgHover, -100));

		final BufferedImage fillImg = ImageUtil.getResourceStreamFromClass(ScreenMarkerPlugin.class, "fill_color_icon.png");
		final BufferedImage fillImgHover = ImageUtil.luminanceOffset(fillImg, -150);
		FILL_COLOR_ICON = new ImageIcon(fillImg);
		FILL_COLOR_HOVER_ICON = new ImageIcon(fillImgHover);

		NO_FILL_COLOR_ICON = new ImageIcon(fillImgHover);
		NO_FILL_COLOR_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(fillImgHover, -100));

		final BufferedImage opacityImg = ImageUtil.getResourceStreamFromClass(ScreenMarkerPlugin.class, "opacity_icon.png");
		final BufferedImage opacityImgHover = ImageUtil.luminanceOffset(opacityImg, -150);
		FULL_OPACITY_ICON = new ImageIcon(opacityImg);
		FULL_OPACITY_HOVER_ICON = new ImageIcon(opacityImgHover);

		NO_OPACITY_ICON = new ImageIcon(opacityImgHover);
		NO_OPACITY_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(opacityImgHover, -100));
	}

	ScreenMarkerPanel(ScreenMarkerPlugin plugin, ScreenMarkerOverlay marker)
	{
		super(plugin, marker.getMarker().getName());

		this.marker = marker;

		borderColorIndicator.setToolTipText("Edit border colour");
		borderColorIndicator.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				openBorderColorPicker();
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				borderColorIndicator.setIcon(marker.getMarker().getBorderThickness() == 0 ? NO_BORDER_COLOR_HOVER_ICON : BORDER_COLOR_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				borderColorIndicator.setIcon(marker.getMarker().getBorderThickness() == 0 ? NO_BORDER_COLOR_ICON : BORDER_COLOR_ICON);
			}
		});

		fillColorIndicator.setToolTipText("Edit fill colour");
		fillColorIndicator.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				openFillColorPicker();
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				fillColorIndicator.setIcon(marker.getMarker().getFill().getAlpha() == 0 ? NO_FILL_COLOR_HOVER_ICON : FILL_COLOR_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				fillColorIndicator.setIcon(marker.getMarker().getFill().getAlpha() == 0 ? NO_FILL_COLOR_ICON : FILL_COLOR_ICON);
			}
		});

		thicknessSpinner.setValue(marker.getMarker().getBorderThickness());
		thicknessSpinner.setPreferredSize(new Dimension(50, 20));
		thicknessSpinner.addChangeListener(ce -> updateThickness(true));

		opacityIndicator.setToolTipText("Toggle background transparency");
		opacityIndicator.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				final Color fill = marker.getMarker().getFill();

				marker.getMarker().setFill(
					new Color(fill.getRed(), fill.getGreen(), fill.getBlue(), fill.getAlpha() == 0 ? DEFAULT_FILL_OPACITY : 0));

				updateFill();
				plugin.updateConfig();
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				opacityIndicator.setIcon(marker.getMarker().getFill().getAlpha() == 0 ? NO_OPACITY_HOVER_ICON : FULL_OPACITY_HOVER_ICON);
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				opacityIndicator.setIcon(marker.getMarker().getFill().getAlpha() == 0 ? NO_OPACITY_ICON : FULL_OPACITY_ICON);
			}
		});

		leftActions.add(borderColorIndicator);
		leftActions.add(fillColorIndicator);
		leftActions.add(opacityIndicator);
		leftActions.add(thicknessSpinner);

		updateFill();
		updateBorder();
	}

	protected void preview(boolean on)
	{
		if (visible)
		{
			return;
		}

		marker.getMarker().setVisible(on);
	}

	protected void toggle(boolean on)
	{
		visible = on;
		marker.getMarker().setVisible(visible);
		plugin.updateConfig();
		updateVisibility();
	}

	protected void save()
	{
		marker.getMarker().setName(nameInput.getText());
		plugin.updateConfig();

		nameInput.setEditable(false);
		updateNameActions(false);
		requestFocusInWindow();
	}

	protected void cancel()
	{
		nameInput.setEditable(false);
		nameInput.setText(marker.getMarker().getName());
		updateNameActions(false);
		requestFocusInWindow();
	}

	/* Updates the thickness without saving on config */
	private void updateThickness(boolean save)
	{
		marker.getMarker().setBorderThickness((Integer) thicknessSpinner.getValue());
		updateBorder();
		if (save)
		{
			plugin.updateConfig();
		}
	}

	private void updateFill()
	{
		final boolean isFullyTransparent = marker.getMarker().getFill().getAlpha() == 0;

		if (isFullyTransparent)
		{
			fillColorIndicator.setBorder(null);
		}
		else
		{
			Color color = marker.getMarker().getFill();
			Color fullColor = new Color(color.getRed(), color.getGreen(), color.getBlue());
			fillColorIndicator.setBorder(new MatteBorder(0, 0, 3, 0, fullColor));
		}

		fillColorIndicator.setIcon(isFullyTransparent ? NO_FILL_COLOR_ICON : FILL_COLOR_ICON);
		opacityIndicator.setIcon(isFullyTransparent ? NO_OPACITY_ICON : FULL_OPACITY_ICON);
	}

	private void updateBorder()
	{
		if (marker.getMarker().getBorderThickness() == 0)
		{
			borderColorIndicator.setBorder(null);
		}
		else
		{
			Color color = marker.getMarker().getColor();
			borderColorIndicator.setBorder(new MatteBorder(0, 0, 3, 0, color));
		}

		borderColorIndicator.setIcon(marker.getMarker().getBorderThickness() == 0 ? NO_BORDER_COLOR_ICON : BORDER_COLOR_ICON);
	}

	private void openFillColorPicker()
	{
		RuneliteColorPicker colorPicker = plugin.getColorPickerManager().create(
			SwingUtilities.windowForComponent(this),
			marker.getMarker().getFill(),
			marker.getMarker().getName() + " Fill",
			false);
		colorPicker.setLocation(getLocationOnScreen());
		colorPicker.setOnColorChange(c ->
		{
			marker.getMarker().setFill(c);
			updateFill();
		});
		colorPicker.setOnClose(c -> plugin.updateConfig());
		colorPicker.setVisible(true);
	}

	private void openBorderColorPicker()
	{
		RuneliteColorPicker colorPicker = plugin.getColorPickerManager().create(
			SwingUtilities.windowForComponent(this),
			marker.getMarker().getColor(),
			marker.getMarker().getName() + " Border",
			false);
		colorPicker.setLocation(getLocationOnScreen());
		colorPicker.setOnColorChange(c ->
		{
			marker.getMarker().setColor(c);
			updateBorder();
		});
		colorPicker.setOnClose(c -> plugin.updateConfig());
		colorPicker.setVisible(true);
	}

	protected void delete()
	{
		plugin.deleteMarker(marker);
	}
}
