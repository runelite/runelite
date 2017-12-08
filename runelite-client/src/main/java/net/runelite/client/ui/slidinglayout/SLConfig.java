package net.runelite.client.ui.slidinglayout;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A configuration lets you easily layout the children of a {@link SLPanel}.
 * Its root is a grid, which can have any number of columns and rows. In each
 * col/row pair, you can either place a component, or create a sub-grid. This
 * sub-grid works the same as the first. This powerful layout lets you quickly
 * build great UIs. Gaps between components are customizable, and colums and
 * rows can be either fixed or flexible.
 *
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class SLConfig
{
	private final SLPanel panel;
	private final Map<Component, Tile> tiles = new HashMap<Component, Tile>();
	private Grid rootGrid = new Grid(), currentGrid = rootGrid;
	private int hgap = 0, vgap = 0;

	public SLConfig(SLPanel panel)
	{
		this.panel = panel;
	}

	// -------------------------------------------------------------------------
	// Public API
	// -------------------------------------------------------------------------

	/**
	 * Sets the global horizontal and vertical gaps between components, in
	 * pixels. Default to 0 for both.
	 */
	public SLConfig gap(int hgap, int vgap)
	{
		this.hgap = hgap;
		this.vgap = vgap;
		return this;
	}

	/**
	 * Adds a flexible column to the current grid that will resize according
	 * to the application resize events. The relative width that has to be given
	 * controls how large the column should be compared to the other flexible
	 * columns. Give it "1f" to have every flexible column the same width.
	 */
	public SLConfig col(float relativeWidth)
	{
		Column column = new Column();
		column.fixedWidth = false;
		column.relWidth = relativeWidth;
		column.w = 0;
		currentGrid.cols.add(column);
		return this;
	}

	/**
	 * Adds a column with a fixed width, in pixels.
	 */
	public SLConfig col(int width)
	{
		Column column = new Column();
		column.fixedWidth = true;
		column.relWidth = 1;
		column.w = width;
		currentGrid.cols.add(column);
		return this;
	}

	/**
	 * Adds a flexible row to the current grid that will resize according
	 * to the application resize events. The relative height that has to be
	 * given controls how large the row should be compared to the other
	 * flexible rows. Give it "1f" to have every flexible row the same height.
	 */
	public SLConfig row(float relativeHeight)
	{
		Row row = new Row();
		row.fixedHeight = false;
		row.relHeight = relativeHeight;
		row.h = 0;
		currentGrid.rows.add(row);
		return this;
	}

	/**
	 * Adds a row with a fixed height, in pixels.
	 */
	public SLConfig row(int height)
	{
		Row row = new Row();
		row.fixedHeight = true;
		row.relHeight = 1;
		row.h = height;
		currentGrid.rows.add(row);
		return this;
	}

	/**
	 * Places a sub-grid in the specified region of the current grid.
	 */
	public SLConfig beginGrid(int row, int col)
	{
		Grid grid = new Grid();
		grid.parent = currentGrid;
		grid.row = row;
		grid.col = col;
		currentGrid.tiles.add(grid);
		currentGrid = grid;
		return this;
	}

	/**
	 * Ends the current grid, and returns to its parent.
	 */
	public SLConfig endGrid()
	{
		currentGrid = currentGrid.parent;
		return this;
	}

	/**
	 * Places a component in the specified region of the current grid.
	 */
	public SLConfig place(int row, int col, Component cmp)
	{
		Tile tile = new Tile();
		tile.parent = currentGrid;
		tile.row = row;
		tile.col = col;
		currentGrid.tiles.add(tile);
		tiles.put(cmp, tile);
		return this;
	}

	// -------------------------------------------------------------------------
	// Package API
	// -------------------------------------------------------------------------

	static class Tile
	{
		Grid parent;
		int row, col;
		int x, y, w, h;

		@Override
		public Tile clone()
		{
			Tile t = new Tile();
			t.parent = parent;
			t.row = row;
			t.col = col;
			t.x = x;
			t.y = y;
			t.w = w;
			t.h = h;
			return t;
		}
	}

	SLPanel getPanel()
	{
		return panel;
	}

	List<Component> getCmps()
	{
		return new ArrayList<>(tiles.keySet());
	}

	Tile getTile(Component cmp)
	{
		return tiles.get(cmp);
	}

	List<Tile> getTiles(List<Component> cmps)
	{
		List<Tile> ts = new ArrayList<>();
		for (Component c : cmps) ts.add(tiles.get(c));
		return ts;
	}

	void placeAndRoute()
	{
		rootGrid.x = hgap;
		rootGrid.y = vgap;
		rootGrid.w = panel.getWidth() - hgap * 2;
		rootGrid.h = panel.getHeight() - vgap * 2;
		placeAndRoute(rootGrid);
	}

	// -------------------------------------------------------------------------
	// Private API
	// -------------------------------------------------------------------------

	private static class Grid extends Tile
	{
		final List<Row> rows = new ArrayList<>();
		final List<Column> cols = new ArrayList<>();
		final List<Tile> tiles = new ArrayList<>();
	}

	private static class Row
	{
		boolean fixedHeight;
		float relHeight;
		int h;
	}

	private static class Column
	{
		boolean fixedWidth;
		float relWidth;
		int w;
	}

	private void placeAndRoute(Grid grid)
	{
		// Place rows

		float totalRelHeight = 0;
		int totalHeight = grid.h - vgap * (grid.rows.size() - 1);

		for (Row r : grid.rows)
		{
			if (r.fixedHeight) totalHeight -= r.h;
			else totalRelHeight += r.relHeight;
		}

		for (Row r : grid.rows)
		{
			if (!r.fixedHeight) r.h = (int) (totalHeight * r.relHeight / totalRelHeight);
		}

		// Place columns

		float totalRelWidth = 0;
		int totalWidth = grid.w - hgap * (grid.cols.size() - 1);

		for (Column c : grid.cols)
		{
			if (c.fixedWidth) totalWidth -= c.w;
			else totalRelWidth += c.relWidth;
		}

		for (Column c : grid.cols)
		{
			if (!c.fixedWidth) c.w = (int) (totalWidth * c.relWidth / totalRelWidth);
		}

		// Place tiles

		int x = grid.x, y = grid.y;

		for (int iRow = 0; iRow < grid.rows.size(); iRow++)
		{
			for (int iCol = 0; iCol < grid.cols.size(); iCol++)
			{
				for (Tile t : grid.tiles)
				{
					if (t.row != iRow || t.col != iCol) continue;
					t.x = x;
					t.y = y;
					t.w = grid.cols.get(t.col).w;
					t.h = grid.rows.get(t.row).h;
					if (t instanceof Grid) placeAndRoute((Grid) t);
				}
				x += grid.cols.get(iCol).w + hgap;
			}
			x = grid.x;
			y += grid.rows.get(iRow).h + vgap;
		}
	}
}
