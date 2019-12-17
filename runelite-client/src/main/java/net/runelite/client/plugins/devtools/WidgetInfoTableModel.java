/*
 * Copyright (c) 2018 Abex
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
package net.runelite.client.plugins.devtools;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;

public class WidgetInfoTableModel extends AbstractTableModel
{
	@Inject
	private ClientThread clientThread;

	private static final int COL_FIELD = 0;
	private static final int COL_VALUE = 1;

	private static final List<WidgetField> fields = populateWidgetFields();

	private Widget widget = null;
	private Map<WidgetField, Object> values = null;

	public void setWidget(Widget w)
	{
		clientThread.invoke(() ->
		{
			Map<WidgetField, Object> newValues = w == null ? null : fields.stream().collect(ImmutableMap.toImmutableMap(
				Function.identity(),
				i -> i.getValue(w)
			));
			SwingUtilities.invokeLater(() ->
			{
				widget = w;
				values = newValues;
				fireTableStructureChanged();
			});
		});
	}

	@Override
	public String getColumnName(int col)
	{
		switch (col)
		{
			case COL_FIELD:
				return "Field";
			case COL_VALUE:
				return "Value";
			default:
				return null;
		}
	}

	@Override
	public int getColumnCount()
	{
		return 2;
	}

	@Override
	public int getRowCount()
	{
		if (values == null)
		{
			return 0;
		}
		return values.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		WidgetField<?> field = fields.get(rowIndex);
		switch (columnIndex)
		{
			case COL_FIELD:
				return field.getName();
			case COL_VALUE:
				return values.get(field);
			default:
				return null;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex)
	{
		if (columnIndex == COL_VALUE)
		{
			WidgetField<?> field = fields.get(rowIndex);
			return field.isSettable();
		}
		return false;
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex)
	{
		WidgetField<?> field = fields.get(rowIndex);
		clientThread.invoke(() ->
		{
			field.setValue(widget, value);
			setWidget(widget);
		});
	}

	private static List<WidgetField> populateWidgetFields()
	{
		List<WidgetField> out = new ArrayList<>();

		out.add(new WidgetField<>("Id", Widget::getId));
		out.add(new WidgetField<>("Type", Widget::getType, Widget::setType, Integer.class));
		out.add(new WidgetField<>("ContentType", Widget::getContentType, Widget::setContentType, Integer.class));
		out.add(new WidgetField<>("ParentId", Widget::getParentId));
		out.add(new WidgetField<>("SelfHidden", Widget::isSelfHidden, Widget::setHidden, Boolean.class));
		out.add(new WidgetField<>("Hidden", Widget::isHidden));
		out.add(new WidgetField<>("Text", Widget::getText, Widget::setText, String.class));
		out.add(new WidgetField<>("TextColor",
			w -> Integer.toString(w.getTextColor(), 16),
			(w, str) -> w.setTextColor(Integer.parseInt(str, 16)),
			String.class
		));
		out.add(new WidgetField<>("Opacity", Widget::getOpacity, Widget::setOpacity, Integer.class));
		out.add(new WidgetField<>("FontId", Widget::getFontId, Widget::setFontId, Integer.class));
		out.add(new WidgetField<>("TextShadowed", Widget::getTextShadowed, Widget::setTextShadowed, Boolean.class));
		out.add(new WidgetField<>("Name", w -> w.getName().trim(), Widget::setName, String.class));
		out.add(new WidgetField<>("ItemId", Widget::getItemId, Widget::setItemId, Integer.class));
		out.add(new WidgetField<>("ItemQuantity", Widget::getItemQuantity, Widget::setItemQuantity, Integer.class));
		out.add(new WidgetField<>("ItemQuantityMode", Widget::getItemQuantityMode, Widget::setItemQuantityMode, Integer.class));
		out.add(new WidgetField<>("ModelId", Widget::getModelId));
		out.add(new WidgetField<>("SpriteId", Widget::getSpriteId, Widget::setSpriteId, Integer.class));
		out.add(new WidgetField<>("BorderType", Widget::getBorderType, Widget::setBorderType, Integer.class));
		out.add(new WidgetField<>("IsIf3", Widget::isIf3));
		out.add(new WidgetField<>("HasListener", Widget::hasListener, Widget::setHasListener, Boolean.class));
		out.add(new WidgetField<>("Filled", Widget::isFilled, Widget::setFilled, Boolean.class));
		out.add(new WidgetField<>("OriginalX", Widget::getOriginalX, Widget::setOriginalX, Integer.class));
		out.add(new WidgetField<>("OriginalY", Widget::getOriginalY, Widget::setOriginalY, Integer.class));
		out.add(new WidgetField<>("OriginalWidth", Widget::getOriginalWidth, Widget::setOriginalWidth, Integer.class));
		out.add(new WidgetField<>("OriginalHeight", Widget::getOriginalHeight, Widget::setOriginalHeight, Integer.class));
		out.add(new WidgetField<>("XPositionMode", Widget::getXPositionMode, Widget::setXPositionMode, Integer.class));
		out.add(new WidgetField<>("YPositionMode", Widget::getYPositionMode, Widget::setYPositionMode, Integer.class));
		out.add(new WidgetField<>("WidthMode", Widget::getWidthMode, Widget::setWidthMode, Integer.class));
		out.add(new WidgetField<>("HeightMode", Widget::getHeightMode, Widget::setHeightMode, Integer.class));
		out.add(new WidgetField<>("XTextAlignment", Widget::getXTextAlignment, Widget::setXTextAlignment, Integer.class));
		out.add(new WidgetField<>("YTextAlignment", Widget::getYTextAlignment, Widget::setYTextAlignment, Integer.class));
		out.add(new WidgetField<>("RelativeX", Widget::getRelativeX, Widget::setRelativeX, Integer.class));
		out.add(new WidgetField<>("RelativeY", Widget::getRelativeY, Widget::setRelativeY, Integer.class));
		out.add(new WidgetField<>("Width", Widget::getWidth, Widget::setWidth, Integer.class));
		out.add(new WidgetField<>("Height", Widget::getHeight, Widget::setHeight, Integer.class));
		out.add(new WidgetField<>("CanvasLocation", Widget::getCanvasLocation));
		out.add(new WidgetField<>("Bounds", Widget::getBounds));
		out.add(new WidgetField<>("ScrollX", Widget::getScrollX, Widget::setScrollX, Integer.class));
		out.add(new WidgetField<>("ScrollY", Widget::getScrollY, Widget::setScrollY, Integer.class));
		out.add(new WidgetField<>("ScrollWidth", Widget::getScrollWidth, Widget::setScrollWidth, Integer.class));
		out.add(new WidgetField<>("ScrollHeight", Widget::getScrollHeight, Widget::setScrollHeight, Integer.class));
		out.add(new WidgetField<>("DragDeadZone", Widget::getDragDeadZone, Widget::setDragDeadZone, Integer.class));
		out.add(new WidgetField<>("DragDeadTime", Widget::getDragDeadTime, Widget::setDragDeadTime, Integer.class));
		out.add(new WidgetField<>("NoClickThrough", Widget::getNoClickThrough, Widget::setNoClickThrough, Boolean.class));
		out.add(new WidgetField<>("NoScrollThrough", Widget::getNoScrollThrough, Widget::setNoScrollThrough, Boolean.class));
		out.add(new WidgetField<>("TargetVerb", Widget::getTargetVerb, Widget::setTargetVerb, String.class));

		return out;
	}
}
