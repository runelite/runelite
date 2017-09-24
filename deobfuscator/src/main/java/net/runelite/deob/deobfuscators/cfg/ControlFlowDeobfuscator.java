/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.deob.deobfuscators.cfg;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Exception;
import net.runelite.asm.attributes.code.Exceptions;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.Label;
import net.runelite.asm.attributes.code.instructions.Goto;
import net.runelite.deob.Deobfuscator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControlFlowDeobfuscator implements Deobfuscator
{
	private static final Logger logger = LoggerFactory.getLogger(ControlFlowDeobfuscator.class);

	private int insertedJump;
	private int placedBlocks;
	private int removedJumps;

	@Override
	public void run(ClassGroup group)
	{
		int catchesBefore = countCatches(group);

		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods())
			{
				Code code = m.getCode();
				if (code == null)
				{
					continue;
				}

				split(code);
				run(code);
				runJumpLabel(code);
			}
		}

		int catchesAfter = countCatches(group);

		logger.info("Inserted {} jumps, reordered {} blocks, and removed {} jumps. jump delta {}, .catch delta: {}",
			insertedJump, placedBlocks, removedJumps, insertedJump - removedJumps, catchesAfter - catchesBefore);
	}

	/**
	 * count the number of .catches in a classgroup
	 *
	 * @param group
	 * @return
	 */
	private int countCatches(ClassGroup group)
	{
		int count = 0;

		for (ClassFile cf : group.getClasses())
		{
			for (Method m : cf.getMethods())
			{
				Code code = m.getCode();
				if (code == null)
				{
					continue;
				}

				count += code.getExceptions().getExceptions().size();
			}
		}

		return count;
	}

	/**
	 * Add gotos at the end of blocks without terminal instructions
	 *
	 * @param code
	 */
	private void split(Code code)
	{
		Instructions ins = code.getInstructions();
		Exceptions exceptions = code.getExceptions();

		ControlFlowGraph graph = new ControlFlowGraph.Builder().build(code);

		List<Exception> exc = new ArrayList<>(exceptions.getExceptions());

		exceptions.clear(); // Must clear this before ins.clear() runs
		ins.clear();

		// insert jumps where blocks flow into others
		for (Block block : graph.getBlocks())
		{
			if (block.getFlowsInto() == null)
			{
				continue;
			}

			Block into = block.getFlowsInto();
			assert into.getFlowsFrom() == block;

			Instruction first = into.getInstructions().get(0);
			Label label;
			if (!(first instanceof Label))
			{
				label = new Label(null);
				into.addInstruction(0, label);
			}
			else
			{
				label = (Label) first;
			}

			Goto g = new Goto(null, label);
			block.addInstruction(g);

			block.setFlowsInto(null);
			into.setFlowsFrom(null);

			++insertedJump;
		}

		// Readd instructions from modified blocks
		for (Block block : graph.getBlocks())
		{
			for (Instruction i : block.getInstructions())
			{
				assert i.getInstructions() == null;
				i.setInstructions(ins); // I shouldn't have to do this here
				ins.addInstruction(i);
			}
		}

		// Readd exceptions
		for (Exception ex : exc)
		{
			exceptions.add(ex);
		}
	}

	private int compareBlock(Block o1, Block o2)
	{
		if (o1.isHandler() && !o2.isHandler())
		{
			// higher numbers have the lowest priority
			// o1 is greater
			return 1;
		}
		if (o2.isHandler() && !o1.isHandler())
		{
			return -1;
		}

		// prioritize blocks with the most exceptions
		int i = Integer.compare(o2.getExceptions().size(), o1.getExceptions().size());
		if (i != 0)
		{
			return i;
		}

		if (o1.isJumptarget() && !o2.isJumptarget())
		{
			return -1;
		}
		if (o2.isJumptarget() && !o1.isJumptarget())
		{
			return 1;
		}

		return 0;
	}

	private void run(Code code)
	{
		Instructions ins = code.getInstructions();
		Exceptions exceptions = code.getExceptions();

		ControlFlowGraph graph = new ControlFlowGraph.Builder().build(code);

		for (Block block : graph.getBlocks())
		{
			assert block.getFlowsFrom() == null;
			assert block.getFlowsInto() == null;
		}

		if (logger.isDebugEnabled()) // graph.toString() is expensive
		{
			logger.debug(graph.toString());
		}

		List<Exception> originalExceptions = new ArrayList<>(exceptions.getExceptions());

		// Clear existing exceptions and instructions as we are going to
		// rebuild them
		exceptions.clear();
		ins.clear();

		List<Block> done = new ArrayList<>();
		Queue<Block> queue = new PriorityQueue<>(this::compareBlock);

		// add handlers since they aren't reachable normally
		for (Exception ex : originalExceptions)
		{
			Block handler = graph.getBlock(ex.getHandler());
			handler.setHandler(true); // mark as handler for priority queue
			queue.add(handler);
		}

		// add initial code block
		queue.add(graph.getHead());

		while (!queue.isEmpty())
		{
			Block block = queue.remove();

			if (done.contains(block))
			{
				continue;
			}

			done.add(block);
			++placedBlocks;

			logger.debug("Placed block {} with {} exceptions", block.getId(), block.getExceptions().size());

			List<Block> next = block.getNext();

			if (next.isEmpty() == false)
			{
				// jumps are added in order their instructions are reached by ControlFlowGraph,
				// so the last jump is the goto.
				//
				// removing this line causes the priority queue (due to implementation detail on how
				// it handles objects with equal priority) to try to optimize for block closeness
				// (how close blocks which are neighbors are to each other in bytecode).
				// I get a jump delta of ~+14k with this on 143, vs ~-47k when priotiziing optimizing
				// out jumps. I can't tell which is better.
				next.get(next.size() - 1).setJumptarget(true);
			}

			// add next reachable blocks
			for (Block bl : next)
			{
				queue.add(bl);
			}

			for (Instruction i : block.getInstructions())
			{
				assert i.getInstructions() == null;
				i.setInstructions(ins); // I shouldn't have to do this here
				ins.addInstruction(i);
			}
		}

		List<Exception> currentExceptions = new ArrayList<>(),
			finishedExceptions = new ArrayList<>();

		// Now all blocks have been placed, build new exception ranges
		for (Block cur : done)
		{
			assert cur.getExceptions() != null;

			// find exceptions to create
			outer:
			for (ExceptionHandler ex : cur.getExceptions())
			{
				Exception ex2 = new Exception(exceptions);

				// if block is covered by an exception handler,
				// it must begin with a label.
				assert cur.getInstructions().get(0) instanceof Label;

				ex2.setStart((Label) cur.getInstructions().get(0));
				ex2.setHandler(ex.getHandler());
				ex2.setCatchType(ex.getCatchType());

				// Is there already an exception for this?
				for (Exception ex3 : currentExceptions)
				{
					if (ex3.getHandler() == ex2.getHandler()
						&& Objects.equals(ex3.getCatchType(), ex2.getCatchType()))
					{
						continue outer;
					}
				}

				logger.debug("Beginning exception at block {} type {} handler {}: {}", cur.getId(), ex.getCatchType(), ex.getHandler(), ex2);

				currentExceptions.add(ex2);
			}

			// find exceptions to end
			outer:
			for (Exception ex : new ArrayList<>(currentExceptions))
			{
				// still in the exception?
				for (ExceptionHandler ex2 : cur.getExceptions())
				{
					if (ex.getHandler() == ex2.getHandler()
						&& Objects.equals(ex.getCatchType(), ex2.getCatchType()))
					{
						continue outer;
					}
				}

				logger.debug("Ending exception at block {}: {}", cur.getId(), ex);

				// ex has ended
				assert ex.getEnd() == null;
				ex.setEnd((Label) cur.getInstructions().get(0));
				currentExceptions.remove(ex);

				finishedExceptions.add(ex);
			}
		}

		Block last = done.get(done.size() - 1);
		for (Exception ex : new ArrayList<>(currentExceptions))
		{
			logger.debug("Ending exception at end of method: {}", ex);

			Instruction il = last.getInstructions().get(last.getInstructions().size() - 1);
			Label lbl;
			if (il instanceof Label)
			{
				lbl = (Label) il;
			}
			else
			{
				assert il.isTerminal();
				lbl = ins.createLabelFor(il);
			}

			// ex has ended
			assert ex.getEnd() == null;
			ex.setEnd(lbl);
			currentExceptions.remove(ex);

			finishedExceptions.add(ex);
		}

		assert currentExceptions.isEmpty();

		// add exceptions
		for (Exception ex : finishedExceptions)
		{
			assert ex.getEnd() != null;
			assert ex.getStart() != ex.getEnd();

			exceptions.add(ex);
		}
	}

	/**
	 * remove jumps followed immediately by the label they are jumping to
	 *
	 * @param code
	 */
	private void runJumpLabel(Code code)
	{
		Instructions ins = code.getInstructions();
		List<Instruction> instructions = ins.getInstructions();

		for (int i = 0; i < instructions.size() - 1; ++i)
		{
			Instruction i1 = instructions.get(i),
				i2 = instructions.get(i + 1);

			if (!(i1 instanceof Goto))
			{
				continue;
			}

			Goto g = (Goto) i1;
			assert g.getJumps().size() == 1;
			if (g.getJumps().get(0) != i2)
			{
				continue;
			}

			ins.remove(i1); // remove jump
			++removedJumps;

			// i now points to i2, so next loop we go to next instruction
		}
	}
}
