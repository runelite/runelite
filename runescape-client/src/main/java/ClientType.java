import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ln")
@Implements("ClientType")
public class ClientType
{
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 2052078695
	)
	@Export("clientType")
	public static int clientType;
}
