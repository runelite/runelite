import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
@Implements("WorldMapID")
public class WorldMapID {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Laj;"
	)
	static final WorldMapID field260;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Laj;"
	)
	static final WorldMapID field257;
	@ObfuscatedName("aw")
	@Export("client")
	@ObfuscatedSignature(
		signature = "Lclient;"
	)
	static Client client;
	@ObfuscatedName("di")
	@ObfuscatedSignature(
		signature = "Lid;"
	)
	@Export("archive13")
	static Archive archive13;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -2063866403
	)
	@Export("value")
	final int value;

	static {
		field260 = new WorldMapID(0);
		field257 = new WorldMapID(1);
	}

	WorldMapID(int var1) {
		this.value = var1;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lhz;IIB)[Lls;",
		garbageValue = "32"
	)
	@Export("SpriteBuffer_getSpriteArray")
	public static Sprite[] SpriteBuffer_getSpriteArray(AbstractArchive var0, int var1, int var2) {
		return !World.SpriteBuffer_bufferFile(var0, var1, var2) ? null : GameShell.method897();
	}

	@ObfuscatedName("ic")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "-6260"
	)
	@Export("sortMenuEntries")
	static final void sortMenuEntries() {
		boolean var0 = false;

		while (!var0) {
			var0 = true;

			for (int var1 = 0; var1 < Client.menuOptionsCount - 1; ++var1) {
				if (Client.menuOpcodes[var1] < 1000 && Client.menuOpcodes[var1 + 1] > 1000) {
					String var2 = Client.menuTargets[var1];
					Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
					Client.menuTargets[var1 + 1] = var2;
					String var3 = Client.menuActions[var1];
					Client.menuActions[var1] = Client.menuActions[var1 + 1];
					Client.menuActions[var1 + 1] = var3;
					int var4 = Client.menuOpcodes[var1];
					Client.menuOpcodes[var1] = Client.menuOpcodes[var1 + 1];
					Client.menuOpcodes[var1 + 1] = var4;
					var4 = Client.menuArguments1[var1];
					Client.menuArguments1[var1] = Client.menuArguments1[var1 + 1];
					Client.menuArguments1[var1 + 1] = var4;
					var4 = Client.menuArguments2[var1];
					Client.menuArguments2[var1] = Client.menuArguments2[var1 + 1];
					Client.menuArguments2[var1 + 1] = var4;
					var4 = Client.menuIdentifiers[var1];
					Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
					Client.menuIdentifiers[var1 + 1] = var4;
					boolean var5 = Client.menuShiftClick[var1];
					Client.menuShiftClick[var1] = Client.menuShiftClick[var1 + 1];
					Client.menuShiftClick[var1 + 1] = var5;
					var0 = false;
				}
			}
		}

	}
}
