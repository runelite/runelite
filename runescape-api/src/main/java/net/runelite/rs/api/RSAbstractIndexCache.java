package net.runelite.rs.api;

import net.runelite.api.IndexDataBase;
import net.runelite.mapping.Import;

public interface RSAbstractIndexCache extends IndexDataBase
{
	@Import("takeRecord")
	byte[] getConfigData(int archiveId, int fileId);
}
