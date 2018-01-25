package net.runelite.client.plugins.zoom;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Script;

@Slf4j
class FindAndReplace
{
	private static final int OPCODE_ICONST = 0;

	private final IntPredicate find;
	private final IntSupplier replace;
	private final Map<Long, int[]> hashToOffset = new HashMap<>();

	public FindAndReplace(IntPredicate find, IntSupplier replace, long... hashes)
	{
		this.find = find;
		this.replace = replace;
		for (long hash : hashes)
		{
			hashToOffset.put(hash, null);
		}
	}

	public void apply(Script s)
	{
		long hash = s.getHash();
		if (!hashToOffset.containsKey(hash))
		{
			return;
		}

		int[] offsets = hashToOffset.get(hash);
		if (offsets == null)
		{
			int[] operands = s.getIntOperands();
			int[] opcodes = s.getInstructions();

			offsets = IntStream.range(0, operands.length)
				.filter(i -> opcodes[i] == OPCODE_ICONST && find.test(operands[i]))
				.toArray();

			log.debug("Found offsets {} in {}", offsets, hash);
			hashToOffset.put(hash, offsets);
		}

		int value = replace.getAsInt();
		int[] operands = s.getIntOperands();
		for (int i : offsets)
		{
			operands[i] = value;
		}
	}
}
