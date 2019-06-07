package rs.api;

import api.HashTable;
import net.runelite.mapping.Import;

public interface RSNodeHashTable extends HashTable
{
	@Import("get")
	@Override
	RSNode get(long value);

	@Import("size")
	int getSize();

	@Import("buckets")
	RSNode[] getBuckets();
}
