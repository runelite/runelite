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

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import net.runelite.api.widgets.Widget;

public class WidgetInfoTableModel extends AbstractTableModel
{
	private static final int COL_FIELD = 0;
	private static final int COL_VALUE = 1;

	private static final List<WidgetField> fields = populateWidgetFields();

	private Widget widget = null;

	public void setWidget(Widget w)
	{
		this.widget = w;
		fireTableStructureChanged();
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
		if (widget == null)
		{
			return 0;
		}
		return fields.size();
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
				return field.getValue(widget);
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
		field.setValue(widget, value);
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
		out.add(new WidgetField<>("Name", w -> w.getName().trim(), Widget::setName, String.class));
		out.add(new WidgetField<>("ItemId", Widget::getItemId));
		out.add(new WidgetField<>("ItemQuantity", Widget::getItemQuantity));
		out.add(new WidgetField<>("ModelId", Widget::getModelId));
		out.add(new WidgetField<>("SpriteId", Widget::getSpriteId, Widget::setSpriteId, Integer.class));
		out.add(new WidgetField<>("Width", Widget::getWidth, Widget::setWidth, Integer.class));
		out.add(new WidgetField<>("Height", Widget::getHeight, Widget::setHeight, Integer.class));
		out.add(new WidgetField<>("RelativeX", Widget::getRelativeX, Widget::setRelativeX, Integer.class));
		out.add(new WidgetField<>("RelativeY", Widget::getRelativeY, Widget::setRelativeY, Integer.class));
		out.add(new WidgetField<>("CanvasLocation", Widget::getCanvasLocation));
		out.add(new WidgetField<>("Bounds", Widget::getBounds));
		out.add(new WidgetField<>("ScrollX", Widget::getScrollX));
		out.add(new WidgetField<>("ScrollY", Widget::getScrollY));
		out.add(new WidgetField<>("OriginalX", Widget::getOriginalX));
		out.add(new WidgetField<>("OriginalY", Widget::getOriginalY));
		out.add(new WidgetField<>("PaddingX", Widget::getPaddingX));
		out.add(new WidgetField<>("PaddingY", Widget::getPaddingY));

		return out;
	}
}
