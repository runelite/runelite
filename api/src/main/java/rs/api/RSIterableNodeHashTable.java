package rs.api;

import api.IterableHashTable;
import net.runelite.mapping.Import;

public interface RSIterableNodeHashTable extends IterableHashTable
{
	@Import("get")
	@Override
	RSNode get(long hash);
}
