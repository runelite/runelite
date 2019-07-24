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
import lombok.NonNull;
import lombok.Setter;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;
import net.runelite.client.ui.overlay.components.TextComponent;

@Setter
public class TableComponent implements LayoutableRenderableEntity
{
	private static final TableElement EMPTY_ELEMENT = TableElement.builder().build();

	@Getter
	private final List<TableElement> columns = new ArrayList<>();
	@Getter
	private final List<TableRow> rows = new ArrayList<>();

	@Getter
	private final Rectangle bounds = new Rectangle();

	private TableAlignment defaultAlignment = TableAlignment.LEFT;
	private Color defaultColor = Color.WHITE;
	private Dimension gutter = new Dimension(3, 0);
	private Point preferredLocation = new Point();
	private Dimension preferredSize = new Dimension(ComponentConstants.STANDARD_WIDTH, 0);

	@Override
	public Dimension render(final Graphics2D graphics)
	{
		final FontMetrics metrics = graphics.getFontMetrics();
		final TableRow colRow = TableRow.builder().elements(this.columns).build();
		final int[] columnWidths = getColumnWidths(metrics, colRow);

		graphics.translate(preferredLocation.x, preferredLocation.y);

		// Display the columns first
		int height = displayRow(graphics, colRow, 0, columnWidths, metrics);

		for (TableRow row : this.rows)
		{
			height = displayRow(graphics, row, height, columnWidths, metrics);
		}

		graphics.translate(-preferredLocation.x, -preferredLocation.y);

		final Dimension dimension = new Dimension(preferredSize.width, height);
		bounds.setLocation(preferredLocation);
		bounds.setSize(dimension);

		return dimension;
	}

	private int displayRow(Graphics2D graphics, TableRow row, int height, int[] columnWidths, FontMetrics metrics)
	{
		int x = 0;
		int startingRowHeight = height;

		final List<TableElement> elements = row.getElements();
		for (int i = 0; i < elements.size(); i++)
		{
			int y = startingRowHeight;
			final TableElement cell = elements.get(i);

			final String content = cell.getContent();
			if (content == null)
			{
				continue;
			}

			final String[] lines = lineBreakText(content, columnWidths[i], metrics);
			final TableAlignment alignment = getCellAlignment(row, i);
			final Color color = getCellColor(row, i);

			for (String line : lines)
			{
				final int alignmentOffset = getAlignedPosition(line, alignment, columnWidths[i], metrics);
				final TextComponent leftLineComponent = new TextComponent();
				y += metrics.getHeight();

				leftLineComponent.setPosition(new Point(x + alignmentOffset, y));
				leftLineComponent.setText(line);
				leftLineComponent.setColor(color);
				leftLineComponent.render(graphics);
			}
			height = Math.max(height, y);
			x += columnWidths[i] + gutter.width;
		}

		return height + gutter.height;
	}

	/**
	 * Returns the width that each column should take up
	 * Based on https://stackoverflow.com/questions/22206825/algorithm-for-calculating-variable-column-widths-for-set-table-width
	 * @param metrics
	 * @return int[] of column width
	 */
	private int[] getColumnWidths(final FontMetrics metrics, final TableRow columnRow)
	{
		int numCols = columns.size();
		for (final TableRow r : rows)
		{
			numCols = Math.max(r.getElements().size(), numCols);
		}

		int[] maxtextw = new int[numCols];      // max text width over all rows
		int[] maxwordw = new int[numCols];      // max width of longest word
		boolean[] flex = new boolean[numCols];  // is column flexible?
		boolean[] wrap = new boolean[numCols];  // can column be wrapped?
		int[] finalcolw = new int[numCols];     // final width of columns

		final List<TableRow> rows = new ArrayList<>(this.rows);
		rows.add(columnRow);

		for (final TableRow r : rows)
		{
			final List<TableElement> elements = r.getElements();
			for (int col = 0; col < elements.size(); col++)
			{
				final TableElement ele = elements.get(col);
				final String cell = ele.getContent();
				if (cell == null)
				{
					continue;
				}

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

	public boolean isEmpty()
	{
		return columns.size() == 0 || rows.size() == 0;
	}

	private void ensureColumnSize(final int size)
	{
		while (size > columns.size())
		{
			columns.add(TableElement.builder().build());
		}
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

	/**
	 * Returns the color for the specified table element.
	 * Priority order: cell->row->column->default
	 * @param row TableRow element
	 * @param colIndex column index
	 */
	private Color getCellColor(final TableRow row, final int colIndex)
	{
		final List<TableElement> rowElements = row.getElements();
		final TableElement cell = colIndex < rowElements.size() ? rowElements.get(colIndex) : EMPTY_ELEMENT;
		final TableElement column = colIndex < columns.size() ? columns.get(colIndex) : EMPTY_ELEMENT;

		return firstNonNull(
			cell.getColor(),
			row.getRowColor(),
			column.getColor(),
			defaultColor);
	}

	private void setColumnAlignment(final int col, final TableAlignment alignment)
	{
		assert columns.size() > col;
		columns.get(col).setAlignment(alignment);
	}

	public void setColumnAlignments(@Nonnull final TableAlignment... alignments)
	{
		ensureColumnSize(alignments.length);
		for (int i = 0; i < alignments.length; i++)
		{
			setColumnAlignment(i, alignments[i]);
		}
	}

	/**
	 * Returns the alignment for the specified table element.
	 * Priority order: cell->row->column->default
	 * @param row TableRow element
	 * @param colIndex column index
	 */
	private TableAlignment getCellAlignment(final TableRow row, final int colIndex)
	{
		final List<TableElement> rowElements = row.getElements();
		final TableElement cell = colIndex < rowElements.size() ? rowElements.get(colIndex) : EMPTY_ELEMENT;
		final TableElement column = colIndex < columns.size() ? columns.get(colIndex) : EMPTY_ELEMENT;

		return firstNonNull(
			cell.getAlignment(),
			row.getRowAlignment(),
			column.getAlignment(),
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

	// Helper functions for cleaner overlay code
	public void addRow(@Nonnull final String... cells)
	{
		final List<TableElement> elements = new ArrayList<>();
		for (final String cell : cells)
		{
			elements.add(TableElement.builder().content(cell).build());
		}

		final TableRow row = TableRow.builder().build();
		row.setElements(elements);

		this.rows.add(row);
	}

	private void addRows(@Nonnull final String[]... rows)
	{
		for (String[] row : rows)
		{
			addRow(row);
		}
	}

	public void addRows(@NonNull final TableRow... rows)
	{
		this.rows.addAll(Arrays.asList(rows));
	}

	public void setRows(@Nonnull final String[]... elements)
	{
		this.rows.clear();
		addRows(elements);
	}

	public void setRows(@Nonnull final TableRow... elements)
	{
		this.rows.clear();
		this.rows.addAll(Arrays.asList(elements));
	}

	private void addColumn(@Nonnull final String col)
	{
		this.columns.add(TableElement.builder().content(col).build());
	}

	public void addColumns(@NonNull final TableElement... columns)
	{
		this.columns.addAll(Arrays.asList(columns));
	}

	public void setColumns(@Nonnull final TableElement... elements)
	{
		this.columns.clear();
		this.columns.addAll(Arrays.asList(elements));
	}

	public void setColumns(@Nonnull final String... columns)
	{
		this.columns.clear();
		for (String col : columns)
		{
			addColumn(col);
		}
	}
}
