package rs.api;

import api.IndexDataBase;
import net.runelite.mapping.Import;

public interface RSAbstractIndexCache extends IndexDataBase
{
	@Import("takeRecord")
	byte[] getConfigData(int archiveId, int fileId);
}
