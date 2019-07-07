package net.runelite.rs.api;

import net.runelite.api.IndexDataBase;
import net.runelite.mapping.Import;

public interface RSAbstractArchive extends IndexDataBase
{
	@Import("takeFile")
	byte[] getConfigData(int archiveId, int fileId);
}
