/*
 * Copyright (c) 2019 Abex
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
package net.runelite.api.geometry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RectangleUnion
{
	private RectangleUnion()
	{
	}

	@RequiredArgsConstructor
	@Getter
	@ToString
	public static class Rectangle
	{
		private final int x1, y1, x2, y2;
	}

	/**
	 * Returns a polygon representing the union of all of the passed rectangles.
	 * the passed List will be modified
	 */
	@Nullable
	public static Shapes<SimplePolygon> union(List<Rectangle> lefts)
	{
		// https://stackoverflow.com/a/35362615/2977136
		if (lefts.size() == 0)
		{
			return null;
		}

		boolean trace = log.isTraceEnabled();

		// Sort all of the rectangles so they are ordered by their left edge
		lefts.sort(Comparator.comparing(Rectangle::getX1));

		// Again, but for the right edge
		// this should be relatively fast if the rectangles are similar sizes because timsort deals with partially
		// presorted data well
		List<Rectangle> rights = new ArrayList<>(lefts);
		rights.sort(Comparator.comparing(Rectangle::getX2));

		// ranges of our scan line with how many rectangles it is occluding
		Segments segments = new Segments();
		Shapes<SimplePolygon> out = new Shapes<>(new ArrayList<>());
		ChangingState cs = new ChangingState(out);

		// Walk a beam left to right, colliding with any vertical edges of rectangles
		for (int l = 0, r = 0; ; )
		{
			Rectangle lr = null, rr = null;
			if (l < lefts.size())
			{
				lr = lefts.get(l);
			}
			if (r < rights.size())
			{
				rr = rights.get(r);
			}
			if (lr == null && rr == null)
			{
				break;
			}

			// get the next edge, preferring + edges
			Rectangle rect;
			boolean remove = lr == null || (rr != null && rr.x2 < lr.x1);
			if (remove)
			{
				cs.delta = -1;
				cs.x = rr.x2;
				r++;
				rect = rr;
			}
			else
			{
				cs.delta = 1;
				cs.x = lr.x1;
				l++;
				rect = lr;
			}
			if (trace)
			{
				log.trace("{}{}", remove ? "-" : "+", rect);
			}

			int y1 = rect.y1;
			int y2 = rect.y2;

			// Find or create the y1 edge
			Segment n = segments.findLE(y1);
			if (n == null)
			{
				n = segments.insertAfter(null, y1);
			}
			if (n.y != y1)
			{
				n = segments.insertAfter(n, y1);
				n.value = n.previous.value;
			}

			for (; ; )
			{
				// create the y2 edge if the next edge is past
				if (n.next == null || n.next.y > y2)
				{
					segments.insertAfter(n, y2);
				}
				cs.touch(n);
				n = n.next;
				if (n.y == y2)
				{
					cs.finish(n);

					if (trace)
					{
						for (Segment s = segments.first; s != null; s = s.next)
						{
							String chunk = "";
							if (s.chunk != null)
							{
								chunk = (s.left ? ">" : "[") + System.identityHashCode(s.chunk) + (s.left ? "]" : "<");
							}
							log.trace("{} = {} {}", s.y, s.value, chunk);
						}
						log.trace("");
					}
					break;
				}
			}
		}

		assert segments.allZero();

		return out;
	}

	@RequiredArgsConstructor
	private static class ChangingState
	{
		final Shapes<SimplePolygon> out;

		int x;
		int delta;

		Segment first;

		void touch(Segment s)
		{
			int oldValue = s.value;
			s.value += delta;
			if (oldValue <= 0 ^ s.value <= 0)
			{
				if (first == null)
				{
					first = s;
				}
			}
			else
			{
				finish(s);
			}
		}

		void finish(Segment s)
		{
			if (first == null)
			{
				return;
			}

			if (first.chunk != null && s.chunk != null)
			{
				push(first);
				push(s);

				if (first.chunk == s.chunk)
				{
					Chunk c = first.chunk;
					first.chunk = null;
					s.chunk = null;
					c.left = null;
					c.right = null;
					out.getShapes().add(c);
				}
				else
				{
					Chunk leftChunk, rightChunk;
					if (!s.left)
					{
						leftChunk = s.chunk;
						rightChunk = first.chunk;
					}
					else
					{
						leftChunk = first.chunk;
						rightChunk = s.chunk;
					}

					log.trace("Joining {} onto {}", System.identityHashCode(rightChunk), System.identityHashCode(leftChunk));
					if (first.left == s.left)
					{
						log.trace("reverse");
						if (first.left)
						{
							leftChunk.reverse();
						}
						else
						{
							rightChunk.reverse();
						}
					}
					log.trace("{} {}", first.y, s.y);
					rightChunk.appendTo(leftChunk);

					first.chunk = null;
					s.chunk = null;
					leftChunk.right.chunk = null;
					rightChunk.left.chunk = null;
					leftChunk.right = rightChunk.right;
					leftChunk.left.chunk = leftChunk;
					leftChunk.right.chunk = leftChunk;
				}
			}
			else if (first.chunk == null && s.chunk == null)
			{
				first.chunk = new Chunk();
				first.chunk.right = first;
				first.left = false;
				s.chunk = first.chunk;
				first.chunk.left = s;
				s.left = true;

				push(first);
				push(s);
			}
			else if (first.chunk == null)
			{
				push(s);
				move(first, s);
				push(first);
			}
			else
			{
				push(first);
				move(s, first);
				push(s);
			}

			first = null;
		}

		private void move(Segment dst, Segment src)
		{
			dst.chunk = src.chunk;
			dst.left = src.left;
			src.chunk = null;
			if (dst.left)
			{
				assert dst.chunk.left == src;
				dst.chunk.left = dst;
			}
			else
			{
				assert dst.chunk.right == src;
				dst.chunk.right = dst;
			}
		}

		private void push(Segment s)
		{
			if (s.left)
			{
				s.chunk.pushLeft(x, s.y);
				assert s.chunk.left == s;
			}
			else
			{
				s.chunk.pushRight(x, s.y);
				assert s.chunk.right == s;
			}
		}
	}

	@NoArgsConstructor
	private static class Segment
	{
		Segment next, previous;

		Chunk chunk;
		boolean left;
		int y;
		int value;
	}

	@NoArgsConstructor
	private static class Segments
	{
		Segment first;

		Segment findLE(int y)
		{
			Segment s = first;
			if (s == null || s.y > y)
			{
				return null;
			}
			for (; ; )
			{
				if (s.y == y)
				{
					return s;
				}

				Segment n = s.next;
				if (n == null || n.y > y)
				{
					return s;
				}

				s = n;
			}
		}

		Segment insertAfter(Segment before, int y)
		{
			Segment n = new Segment();
			n.y = y;
			if (before != null)
			{
				if (before.next != null)
				{
					n.next = before.next;
					n.next.previous = n;
				}
				n.value = before.value;
				before.next = n;
				n.previous = before;
			}
			else
			{
				if (first != null)
				{
					n.next = first;
					first.previous = n;
				}
				first = n;
			}
			return n;
		}

		boolean allZero()
		{
			for (Segment s = first; s != null; s = s.next)
			{
				if (s.value != 0 || s.chunk != null)
				{
					return false;
				}
			}
			return true;
		}
	}

	private static class Chunk extends SimplePolygon
	{
		Segment left, right;

		@Override
		public void reverse()
		{
			super.reverse();
			assert right.left == false;
			assert left.left == true;
			Segment tr = left;
			left = right;
			right = tr;
			right.left = false;
			left.left = true;
		}
	}
}
