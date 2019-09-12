import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
@Implements("StructDefinition")
public class StructDefinition extends DualNode {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("StructDefinition_archive")
	static AbstractArchive StructDefinition_archive;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Let;"
	)
	@Export("StructDefinition_cached")
	public static EvictingDualNodeHashTable StructDefinition_cached;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Llj;"
	)
	@Export("params")
	IterableNodeHashTable params;

	static {
		StructDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	StructDefinition() {
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "115"
	)
	@Export("postDecode")
	void postDecode() {
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lkz;I)V",
		garbageValue = "583710412"
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

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lkz;II)V",
		garbageValue = "-636119543"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 249) {
			this.params = FloorOverlayDefinition.readStringIntParameters(var1, this.params);
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-2063775576"
	)
	@Export("getIntParam")
	public int getIntParam(int var1, int var2) {
		return class65.method1177(this.params, var1, var2);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)Ljava/lang/String;",
		garbageValue = "915337596"
	)
	@Export("getStringParam")
	public String getStringParam(int var1, String var2) {
		IterableNodeHashTable var4 = this.params;
		String var3;
		if (var4 == null) {
			var3 = var2;
		} else {
			ObjectNode var5 = (ObjectNode)var4.get((long)var1);
			if (var5 == null) {
				var3 = var2;
			} else {
				var3 = (String)var5.obj;
			}
		}

		return var3;
	}

	@ObfuscatedName("jm")
	@ObfuscatedSignature(
		signature = "(Lbw;ZI)V",
		garbageValue = "1941630609"
	)
	@Export("closeInterface")
	static final void closeInterface(InterfaceParent var0, boolean var1) {
		int var2 = var0.group;
		int var3 = (int)var0.key;
		var0.remove();
		if (var1) {
			TileItemPile.method2728(var2);
		}

		WorldMapSectionType.method224(var2);
		Widget var4 = Player.getWidget(var3);
		if (var4 != null) {
			WorldMapID.invalidateWidget(var4);
		}

		for (int var5 = 0; var5 < Client.menuOptionsCount; ++var5) {
			int var7 = Client.menuOpcodes[var5];
			boolean var6 = var7 == 57 || var7 == 58 || var7 == 1007 || var7 == 25 || var7 == 30;
			if (var6) {
				if (var5 < Client.menuOptionsCount - 1) {
					for (int var8 = var5; var8 < Client.menuOptionsCount - 1; ++var8) {
						Client.menuActions[var8] = Client.menuActions[var8 + 1];
						Client.menuTargets[var8] = Client.menuTargets[var8 + 1];
						Client.menuOpcodes[var8] = Client.menuOpcodes[var8 + 1];
						Client.menuIdentifiers[var8] = Client.menuIdentifiers[var8 + 1];
						Client.menuArguments1[var8] = Client.menuArguments1[var8 + 1];
						Client.menuArguments2[var8] = Client.menuArguments2[var8 + 1];
						Client.menuShiftClick[var8] = Client.menuShiftClick[var8 + 1];
					}
				}

				--var5;
				--Client.menuOptionsCount;
			}
		}

		WorldMapRegion.calculateMenuBounds();
		if (Client.rootInterface != -1) {
			WorldMapRectangle.runIntfCloseListeners(Client.rootInterface, 1);
		}

	}
}
