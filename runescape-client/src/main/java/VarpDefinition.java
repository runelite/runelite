import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
@Implements("VarpDefinition")
public class VarpDefinition extends DualNode {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("VarpDefinition_archive")
	static AbstractArchive VarpDefinition_archive;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1812370505
	)
	@Export("VarpDefinition_fileCount")
	public static int VarpDefinition_fileCount;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("VarpDefinition_cached")
	static EvictingDualNodeHashTable VarpDefinition_cached;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -559924911
	)
	@Export("type")
	public int type;

	static {
		VarpDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	VarpDefinition() {
		this.type = 0;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lky;B)V",
		garbageValue = "-60"
	)
	@Export("decode")
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lky;IB)V",
		garbageValue = "-93"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 5) {
			this.type = var1.readUnsignedShort();
		}

	}

	@ObfuscatedName("jv")
	@ObfuscatedSignature(
		signature = "(Lbq;ZI)V",
		garbageValue = "50109421"
	)
	@Export("closeInterface")
	static final void closeInterface(InterfaceParent var0, boolean var1) {
		int var2 = var0.group;
		int var3 = (int)var0.key;
		var0.remove();
		if (var1) {
			UrlRequester.method3250(var2);
		}

		for (IntegerNode var4 = (IntegerNode)Client.widgetClickMasks.first(); var4 != null; var4 = (IntegerNode)Client.widgetClickMasks.next()) {
			if ((long)var2 == (var4.key >> 48 & 65535L)) {
				var4.remove();
			}
		}

		Widget var7 = WorldMapElement.getWidget(var3);
		if (var7 != null) {
			FriendSystem.invalidateWidget(var7);
		}

		for (int var5 = 0; var5 < Client.menuOptionsCount; ++var5) {
			if (PendingSpawn.isWidgetMenuOpcode(Client.menuOpcodes[var5])) {
				if (var5 < Client.menuOptionsCount - 1) {
					for (int var6 = var5; var6 < Client.menuOptionsCount - 1; ++var6) {
						Client.menuActions[var6] = Client.menuActions[var6 + 1];
						Client.menuTargets[var6] = Client.menuTargets[var6 + 1];
						Client.menuOpcodes[var6] = Client.menuOpcodes[var6 + 1];
						Client.menuIdentifiers[var6] = Client.menuIdentifiers[var6 + 1];
						Client.menuArguments1[var6] = Client.menuArguments1[var6 + 1];
						Client.menuArguments2[var6] = Client.menuArguments2[var6 + 1];
						Client.menuShiftClick[var6] = Client.menuShiftClick[var6 + 1];
					}
				}

				--var5;
				--Client.menuOptionsCount;
			}
		}

		GrandExchangeOfferNameComparator.calculateMenuBounds();
		if (Client.rootInterface != -1) {
			UserComparator6.runIntfCloseListeners(Client.rootInterface, 1);
		}

	}
}
