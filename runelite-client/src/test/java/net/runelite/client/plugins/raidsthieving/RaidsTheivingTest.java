/*
 * Copyright (c) 2018, Tim Lehner <Timothy.Lehner.2011@live.rhul.ac.uk>
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
package net.runelite.client.plugins.raidsthieving;

import net.runelite.api.Point;
import net.runelite.client.plugins.raidsthieving.BatSolver.BatSolver;
import net.runelite.client.plugins.raidsthieving.BatSolver.ThievingRoomType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.TreeSet;

@RunWith(MockitoJUnitRunner.class)
public class RaidsTheivingTest
{
	private boolean compare(TreeSet<Integer> set1, TreeSet<Integer> set2) {
		return set1.containsAll(set2) && set2.containsAll(set1);
	}

	@Test
	public void testBatFinderCHECK_GRUBS_INVALIDATES_SOLN()
	{
		BatSolver solver = new BatSolver(ThievingRoomType.LEFT_TURN);

		solver.addEmptyChest(1);

		TreeSet<Integer> compareSet1 = new TreeSet<>(Arrays.asList(1, 16, 17, 38, 54, 55));
		TreeSet<Integer> compareSet2 = new TreeSet<>(Arrays.asList(1, 17, 38, 54));

		Assert.assertTrue(compare(compareSet1, solver.matchSolutions()));

		solver.addGrubsChest(16);
		Assert.assertFalse(compare(compareSet1, solver.matchSolutions()));
		Assert.assertTrue(compare(compareSet2, solver.matchSolutions()));
	}

	@Test
	public void testBatFinderLEFT_TURN1()
	{
		BatSolver solver = new BatSolver(ThievingRoomType.LEFT_TURN);

		solver.addEmptyChest(1);

		TreeSet<Integer> compareSet1 = new TreeSet<>(Arrays.asList(1, 16, 17, 38, 54, 55));
		TreeSet<Integer> compareSet2 = new TreeSet<>(Arrays.asList(1, 16, 17, 55));

		Assert.assertTrue(compare(compareSet1, solver.matchSolutions()));

		solver.addEmptyChest(16);
		Assert.assertFalse(compare(compareSet1, solver.matchSolutions()));
		Assert.assertTrue(compare(compareSet2, solver.matchSolutions()));
	}


	@Test
	public void testBatFinderLEFT_TURN2()
	{
		BatSolver solver = new BatSolver(ThievingRoomType.LEFT_TURN);

		solver.addEmptyChest(1);

		TreeSet<Integer> compareSet1 = new TreeSet<>(Arrays.asList(1, 16, 17, 38, 54, 55));

		Assert.assertTrue(compare(compareSet1, solver.matchSolutions()));

		solver.addGrubsChest(17);
		Assert.assertFalse(compare(compareSet1, solver.matchSolutions()));
	}

	@Test
	public void testBatFinderLEFT_TURN3()
	{
		BatSolver solver = new BatSolver(ThievingRoomType.LEFT_TURN);

		solver.addEmptyChest(32);

		TreeSet<Integer> compareSet1 = new TreeSet<>(Arrays.asList(6, 10, 20, 25, 26, 30, 32, 34, 52, 59));
		TreeSet<Integer> compareSet2 = new TreeSet<>(Arrays.asList(10, 30, 32, 59));

		Assert.assertTrue(compare(compareSet1, solver.matchSolutions()));

		solver.addEmptyChest(30);
		Assert.assertFalse(compare(compareSet1, solver.matchSolutions()));
		Assert.assertTrue(compare(compareSet2, solver.matchSolutions()));
	}

	@Test
	public void testBatFinderRIGHT_TURN()
	{
		BatSolver solver = new BatSolver(ThievingRoomType.RIGHT_TURN);

		solver.addEmptyChest(61);

		TreeSet<Integer> compareSet1 = new TreeSet<>(Arrays.asList(61, 22, 29, 38, 56, 70));
		TreeSet<Integer> compareSet2 = new TreeSet<>(Arrays.asList(61, 29, 22, 56));

		Assert.assertTrue(compare(compareSet1, solver.matchSolutions()));

		solver.addEmptyChest(29);
		Assert.assertFalse(compare(compareSet1, solver.matchSolutions()));
		Assert.assertTrue(compare(compareSet2, solver.matchSolutions()));
	}


	@Test
	public void testBatFinderSTRAIGHT()
	{
		BatSolver solver = new BatSolver(ThievingRoomType.STRAIGHT);

		solver.addEmptyChest(25);

		TreeSet<Integer> compareSet1 = new TreeSet<>(Arrays.asList(25, 55, 46, 13, 30, 22, 31));
		TreeSet<Integer> compareSet2 = new TreeSet<>(Arrays.asList(25, 30, 13, 31));

		Assert.assertTrue(compare(compareSet1, solver.matchSolutions()));

		solver.addEmptyChest(30);
		Assert.assertFalse(compare(compareSet1, solver.matchSolutions()));
		Assert.assertTrue(compare(compareSet2, solver.matchSolutions()));
	}


	@Test
	public void testBatFinderUNKNOWN()
	{
		BatSolver solver = new BatSolver(ThievingRoomType.STRAIGHT);
		TreeSet<Integer> matches = solver.matchSolutions();

		Assert.assertEquals(0, matches.size());
		solver.addEmptyChest(1);
		Assert.assertNotEquals(0, solver.matchSolutions().size());
		solver.addEmptyChest(2);
		Assert.assertEquals(0, solver.matchSolutions().size());
	}


	@Test
	public void testChestChance()
	{
		BatSolver solver = new BatSolver(ThievingRoomType.STRAIGHT);
		Assert.assertTrue(solver.relativeLikelihoodPoison(1) < 0.20);
		Assert.assertTrue(solver.relativeLikelihoodPoison(25) < 0.9);
		Assert.assertTrue(solver.relativeLikelihoodPoison(34) > 0.99);
		solver = new BatSolver(ThievingRoomType.LEFT_TURN);
		Assert.assertTrue(solver.relativeLikelihoodPoison(11) < 0.10);
		Assert.assertTrue(solver.relativeLikelihoodPoison(1) < 0.6);
		Assert.assertTrue(solver.relativeLikelihoodPoison(13) < 0.99 && solver.relativeLikelihoodPoison(13) > 0.92);
		Assert.assertTrue(solver.relativeLikelihoodPoison(45) > 0.99);
	}

	@Test
	public void testInstancePoint()
	{

		Point[] bases = {
			new Point(9896, 9640),
			new Point(8744, 10792),
			new Point(9704, 10600),
			new Point(12008, 10792)
		};

		Point[] tiles = {
			new Point(9939, 9684),
			new Point(8788, 10836),
			new Point(9748, 10643),
			new Point(12051, 10835)
		};

		Point origin = new Point(0, 0);

		for (int i = 0; i < 4; i++) {
			InstancePoint point = InstancePoint.buildFromTile(bases[i], tiles[i], i, origin);
			Assert.assertEquals(3, point.getX());
			Assert.assertEquals(4, point.getY());
		}
	}

	@Test
	public void testInstancePointFar()
	{

		Point[] bases = {
			new Point(7016, 2728),
			new Point(7784, 3304),
			new Point(9128, 3496),
			new Point(9704, 3688)
		};

		Point[] tiles = {
			new Point(7071, 2783),
			new Point(7839, 3352),
			new Point(9176, 3544),
			new Point(9752, 3743)
		};

		Point origin = new Point(0, 0);

		for (int i = 0; i < 4; i++) {
			InstancePoint point = InstancePoint.buildFromTile(bases[i], tiles[i], i, origin);
			Assert.assertEquals(7, point.getX());
			Assert.assertEquals(7, point.getY());
		}
	}

}