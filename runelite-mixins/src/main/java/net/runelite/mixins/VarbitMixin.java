package net.runelite.mixins;

import net.runelite.api.VarClientInt;
import net.runelite.api.VarClientStr;
import net.runelite.api.Varbits;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.Map;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSEvictingDualNodeHashTable;
import net.runelite.rs.api.RSVarbitDefinition;

@Mixin(RSClient.class)
public abstract class VarbitMixin implements RSClient
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	private Cache<Integer, RSVarbitDefinition> varbitCache = CacheBuilder.newBuilder()
		.maximumSize(128)
		.build();

	@Inject
	VarbitMixin()
	{
	}

	@Inject
	@Override
	public int getVar(Varbits varbit)
	{
		int varbitId = varbit.getId();
		return getVarbitValue(getVarps(), varbitId);
	}

	@Inject
	@Override
	public void setVarbit(Varbits varbit, int value)
	{
		int varbitId = varbit.getId();
		setVarbitValue(getVarps(), varbitId, value);
	}

	@Inject
	@Override
	public int getVarbitValue(int[] varps, int varbitId)
	{
		assert client.isClientThread();

		RSVarbitDefinition v = varbitCache.getIfPresent(varbitId);
		if (v == null)
		{
			client.getVarbit(varbitId); // load varbit into cache
			RSEvictingDualNodeHashTable varbits = client.getVarbitCache();
			v = (RSVarbitDefinition) varbits.get(varbitId); // get from cache
			varbitCache.put(varbitId, v);
		}

		if (v.getIndex() == 0 && v.getLeastSignificantBit() == 0 && v.getMostSignificantBit() == 0)
		{
			throw new IndexOutOfBoundsException("Varbit " + varbitId + " does not exist");
		}

		int value = varps[v.getIndex()];
		int lsb = v.getLeastSignificantBit();
		int msb = v.getMostSignificantBit();
		int mask = (1 << ((msb - lsb) + 1)) - 1;
		return (value >> lsb) & mask;
	}

	@Inject
	@Override
	public void setVarbitValue(int[] varps, int varbitId, int value)
	{
		RSVarbitDefinition v = varbitCache.getIfPresent(varbitId);
		if (v == null)
		{
			client.getVarbit(varbitId); // load varbit into cache
			RSEvictingDualNodeHashTable varbits = client.getVarbitCache();
			v = (RSVarbitDefinition) varbits.get(varbitId); // get from cache
			varbitCache.put(varbitId, v);
		}

		int lsb = v.getLeastSignificantBit();
		int msb = v.getMostSignificantBit();
		int mask = (1 << ((msb - lsb) + 1)) - 1;
		varps[v.getIndex()] = (varps[v.getIndex()] & ~(mask << lsb)) | ((value & mask) << lsb);
	}

	@Inject
	@Override
	public int getVar(VarClientInt varClientInt)
	{
		Map<Integer, Object> varcmap = getVarcMap();
		Object object = varcmap.get(varClientInt.getIndex());
		return object instanceof Integer ? (Integer) object : 0;
	}

	@Inject
	@Override
	public String getVar(VarClientStr varClientStr)
	{
		Map<Integer, Object> varcmap = getVarcMap();
		Object var2 = varcmap.get(varClientStr.getIndex());
		return var2 instanceof String ? (String) var2 : "";
	}

	@Inject
	@Override
	public void setVar(VarClientStr varClientStr, String value)
	{
		Map<Integer, Object> varcmap = getVarcMap();
		varcmap.put(varClientStr.getIndex(), value);
	}

	@Inject
	@Override
	public void setVar(VarClientInt varClientInt, int value)
	{
		Map<Integer, Object> varcmap = getVarcMap();
		varcmap.put(varClientInt.getIndex(), value);
	}

	@Inject
	@Override
	public Map<Integer, Object> getVarcMap()
	{
		return getVarcs().getVarcMap();
	}
}
