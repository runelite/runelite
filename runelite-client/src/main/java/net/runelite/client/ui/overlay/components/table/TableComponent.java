/*
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
 * Copyright (c) 2019, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.client.ui.overlay.components.table;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;
import net.runelite.client.ui.overlay.components.TextComponent;

@Setter
public class TableComponent implements LayoutableRenderableEntity
{
	private static final TableRow EMPTY_ROW = TableRow.builder().build();
	private static final TableElement EMPTY_ELEMENT = TableElement.builder().build();

	@Getter
	private final Rectangle bounds = new Rectangle();

	@Getter
	private final List<TableElement> columns = new ArrayList<>();
	@Getter
	private final List<TableRow> rows = new ArrayList<>();

	@Nonnull
	private TableAlignment defaultAlignment = TableAlignment.LEFT;
	@Nonnull
	private Color defaultColor = Color.WHITE;
	@Nonnull
	private Dimension gutter = new Dimension(3, 0);
	@Nonnull
	private Point preferredLocation = new Point();
	@Nonnull
	private Dimension preferredSize = new Dimension(ComponentConstants.STANDARD_WIDTH, 0);

	@Override
	public Dimension render(final Graphics2D graphics)
	{
		final FontMetrics metrics = graphics.getFontMetrics();
		final int[] columnWidths = getColumnWidths(metrics);
		int height = 0;

		graphics.translate(preferredLocation.x, preferredLocation.y);

		final int numRows = rows.size();
		final int numCols = columns.size();

		for (int row = 0; row < numRows; row++)
		{
			int x = 0;
			int startingRowHeight = height;
			for (int col = 0; col < numCols; col++)
			{
				int y = startingRowHeight;
				final String[] lines = lineBreakText(getCellText(col, row), columnWidths[col], metrics);
				for (String line : lines)
				{
					final TableAlignment alignment = getCellAlignment(row, col);
					final int alignmentOffset = getAlignedPosition(line, alignment, columnWidths[col], metrics);
					final TextComponent leftLineComponent = new TextComponent();
					y += metrics.getHeight();

					final Color lineColor = getCellColor(row, col);

					leftLineComponent.setPosition(new Point(x + alignmentOffset, y));
					leftLineComponent.setText(line);
					leftLineComponent.setColor(lineColor);
					leftLineComponent.render(graphics);
				}
				height = Math.max(height, y);
				x += columnWidths[col] + gutter.width;
			}
			height += gutter.height;
		}

		graphics.translate(-preferredLocation.x, -preferredLocation.y);
		final Dimension dimension = new Dimension(preferredSize.width, height);
		bounds.setLocation(preferredLocation);
		bounds.setSize(dimension);
		return dimension;
	}

	public void setColumnColor(final int col, final Color color)
	{
		assert columns.size() > col;
		columns.get(col).setColor(color);
	}

	public void setColumnAlignment(final int col, final TableAlignment alignment)
	{
		assert columns.size() > col;
		columns.get(col).setAlignment(alignment);
	}

	public void setColumnColors(@Nonnull final Color... colors)
	{
		for (int i = 0; i < colors.length; i++)
		{
			setColumnColor(i, colors[i]);
		}
	}

	public void addRow(@Nonnull final String... cells)
	{
		final TableElement[] elements = new TableElement[cells.length];
		for (int i = 0; i < cells.length; i++)
		{
			elements[i] = TableElement.builder().content(cells[i]).build();
		}

		final TableRow row = TableRow.builder().build();
		row.setElements(elements);

		this.rows.add(row);
	}

	public void addRows(@Nonnull final String[]... rows)
	{
		for (String[] row : rows)
		{
			addRow(row);
		}
	}

	public void addColumn(@Nonnull TableElement element)
	{
		this.columns.add(element);
	}

	public void setColumns(@Nonnull final TableElement... elements)
	{
		this.columns.clear();
		this.columns.addAll(Arrays.asList(elements));
	}

	public void addColumn(@Nonnull final String col)
	{
		this.columns.add(TableElement.builder().content(col).build());
	}

	public void setColumns(@Nonnull final String... columns)
	{
		this.columns.clear();
		for (String col : columns)
		{
			addColumn(col);
		}
	}

	public void addRow(@Nonnull TableRow row)
	{
		this.rows.add(row);
	}

	public void addRows(@Nonnull final TableRow... rows)
	{
		for (TableRow row : rows)
		{
			addRow(row);
		}
	}

	private String getCellText(final int col, final int row)
	{
		assert col < columns.size() && row < rows.size();

		if (row == -1)
		{
			return columns.get(col).getContent();
		}

		TableElement[] elements = rows.get(row).getElements();
		if (col >= elements.length)
		{
			return "";
		}

		final String result = elements[col].content;
		return result != null ? result : "";
	}

	private int[] getColumnWidths(final FontMetrics metrics)
	{
		final int numRows = rows.size();
		final int numCols = columns.size();

		// Based on https://stackoverflow.com/questions/22206825/algorithm-for-calculating-variable-column-widths-for-set-table-width
		int[] maxtextw = new int[numCols];      // max text width over all rows
		int[] maxwordw = new int[numCols];      // max width of longest word
		boolean[] flex = new boolean[numCols];  // is column flexible?
		boolean[] wrap = new boolean[numCols];  // can column be wrapped?
		int[] finalcolw = new int[numCols];     // final width of columns

		for (int col = 0; col < numCols; col++)
		{
			for (int row = 0; row < numRows; row++)
			{
				final String cell = getCellText(col, row);
				final int cellWidth = getTextWidth(metrics, cell);

				maxtextw[col] = Math.max(maxtextw[col], cellWidth);
				for (String word : cell.split(" "))
				{
					maxwordw[col] = Math.max(maxwordw[col], getTextWidth(metrics, word));
				}

				if (maxtextw[col] == cellWidth)
				{
					wrap[col] = cell.contains(" ");
				}
			}
		}

		int left = preferredSize.width - (numCols - 1) * gutter.width;
		final double avg = left / numCols;
		int nflex = 0;

		// Determine whether columns should be flexible and assign width of non-flexible cells
		for (int col = 0; col < numCols; col++)
		{
			// This limit can be adjusted as needed
			final double maxNonFlexLimit = 1.5 * avg;

			flex[col] = maxtextw[col] > maxNonFlexLimit;
			if (flex[col])
			{
				nflex++;
			}
			else
			{
				finalcolw[col] = maxtextw[col];
				left -= finalcolw[col];
			}
		}

		// If there is not enough space, make columns that could be word-wrapped flexible too
		if (left < nflex * avg)
		{
			for (int col = 0; col < numCols; col++)
			{
				if (!flex[col] && wrap[col])
				{
					left += finalcolw[col];
					finalcolw[col] = 0;
					flex[col] = true;
					nflex++;
				}
			}
		}

		// Calculate weights for flexible columns. The max width is capped at the table width to
		// treat columns that have to be wrapped more or less equal
		int tot = 0;
		for (int col = 0; col < numCols; col++)
		{
			if (flex[col])
			{
				maxtextw[col] = Math.min(maxtextw[col], preferredSize.width);
				tot += maxtextw[col];
			}
		}

		// Now assign the actual width for flexible columns. Make sure that it is at least as long
		// as the longest word length
		for (int col = 0; col < numCols; col++)
		{
			if (flex[col])
			{
				finalcolw[col] = left * maxtextw[col] / tot;
				finalcolw[col] = Math.max(finalcolw[col], maxwordw[col]);
				left -= finalcolw[col];
			}
		}

		// When the sum of column widths is less than the total space available, distribute the
		// extra space equally across all columns
		final int extraPerCol = left / numCols;
		for (int col = 0; col < numCols; col++)
		{
			finalcolw[col] += extraPerCol;
			left -= extraPerCol;
		}
		// Add any remainder to the right-most column
		finalcolw[finalcolw.length - 1] += left;

		return finalcolw;
	}

	private static int getTextWidth(final FontMetrics metrics, final String cell)
	{
		return metrics.stringWidth(TextComponent.textWithoutColTags(cell));
	}

	private static String[] lineBreakText(final String text, final int maxWidth, final FontMetrics metrics)
	{
		final String[] words = text.split(" ");

		if (words.length == 0)
		{
			return new String[0];
		}

		final StringBuilder wrapped = new StringBuilder(words[0]);
		int spaceLeft = maxWidth - getTextWidth(metrics, wrapped.toString());

		for (int i = 1; i < words.length; i++)
		{
			final String word = words[i];
			final int wordLen = getTextWidth(metrics, word);
			final int spaceWidth = metrics.stringWidth(" ");

			if (wordLen + spaceWidth > spaceLeft)
			{
				wrapped.append("\n").append(word);
				spaceLeft = maxWidth - wordLen;
			}
			else
			{
				wrapped.append(" ").append(word);
				spaceLeft -= spaceWidth + wordLen;
			}
		}

		return wrapped.toString().split("\n");
	}

	private static int getAlignedPosition(final String str, final TableAlignment alignment, final int columnWidth, final FontMetrics metrics)
	{
		final int stringWidth = getTextWidth(metrics, str);
		int offset = 0;

		switch (alignment)
		{
			case LEFT:
				break;
			case CENTER:
				offset = (columnWidth / 2) - (stringWidth / 2);
				break;
			case RIGHT:
				offset = columnWidth - stringWidth;
				break;
		}
		return offset;
	}

	private Color getCellColor(final int row, final int column)
	{
		assert row < rows.size() && column < columns.size();

		// Row should be -1 for columns so use a empty TableRow
		final TableRow rowEle = row != -1 ? rows.get(row) : EMPTY_ROW;
		final TableElement columnElement = columns.get(column);
		final TableElement[] elements = rowEle.getElements();

		// Some rows may not have every element, even though they should..
		final TableElement ele = column < elements.length ? elements[column] : EMPTY_ELEMENT;

		// Color priorities goes as follow: cell->row->column->default
		return firstNonNull(
			ele.getColor(),
			rowEle.getRowColor(),
			columnElement.getColor(),
			defaultColor);
	}

	private TableAlignment getCellAlignment(final int row, final int column)
	{
		assert row < rows.size() && column < columns.size();

		// Row should be -1 for columns so use a empty TableRow
		final TableRow rowEle = row != -1 ? rows.get(row) : EMPTY_ROW;
		final TableElement columnElement = columns.get(column);
		final TableElement[] elements = rowEle.getElements();

		// Some rows may not have every element, even though they should..
		final TableElement ele = column < elements.length ? elements[column] : EMPTY_ELEMENT;

		// Alignment priorities goes as follow: cell->row->column->default
		return firstNonNull(
			ele.getAlignment(),
			rowEle.getRowAlignment(),
			columnElement.getAlignment(),
			defaultAlignment);
	}

	@SafeVarargs
	private static <T> T firstNonNull(@Nullable T... elements)
	{
		if (elements == null || elements.length == 0)
		{
			return null;
		}

		int i = 0;
		T cur = elements[0];
		while (cur == null && i < elements.length)
		{
			cur = elements[i];
			i++;
		}

		return cur;
	}
}
