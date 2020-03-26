import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public class class69 {
	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		signature = "[Lla;"
	)
	@Export("worldSelectBackSprites")
	static Sprite[] worldSelectBackSprites;
	@ObfuscatedName("fm")
	@ObfuscatedGetter(
		intValue = 731242929
	)
	@Export("baseX")
	static int baseX;
	@ObfuscatedName("gx")
	@ObfuscatedGetter(
		intValue = 471245099
	)
	static int field585;

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "573845052"
	)
	static void method1277() {
		IntHashTable.field4034 = new int[2000];
		int var0 = 0;
		int var1 = 240;

		int var3;
		for (byte var2 = 12; var0 < 16; var1 -= var2) {
			var3 = NPC.method2146((double)((float)var1 / 360.0F), 0.9998999834060669D, (double)(0.425F * (float)var0 / 16.0F + 0.075F));
			IntHashTable.field4034[var0] = var3;
			++var0;
		}

		var1 = 48;

		for (int var5 = var1 / 6; var0 < IntHashTable.field4034.length; var1 -= var5) {
			var3 = var0 * 2;

			for (int var4 = NPC.method2146((double)((float)var1 / 360.0F), 0.9998999834060669D, 0.5D); var0 < var3 && var0 < IntHashTable.field4034.length; ++var0) {
				IntHashTable.field4034[var0] = var4;
			}
		}

	}

	@ObfuscatedName("ir")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "4"
	)
	static final void method1275() {
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

	@ObfuscatedName("kz")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZB)V",
		garbageValue = "-93"
	)
	@Export("findItemDefinitions")
	static void findItemDefinitions(String var0, boolean var1) {
		var0 = var0.toLowerCase();
		short[] var2 = new short[16];
		int var3 = 0;

		for (int var4 = 0; var4 < class336.ItemDefinition_fileCount; ++var4) {
			ItemDefinition var5 = AbstractWorldMapData.ItemDefinition_get(var4);
			if ((!var1 || var5.isTradable) && var5.noteTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
				if (var3 >= 250) {
					TextureProvider.foundItemIdCount = -1;
					WorldMapEvent.foundItemIds = null;
					return;
				}

				if (var3 >= var2.length) {
					short[] var6 = new short[var2.length * 2];

					for (int var7 = 0; var7 < var3; ++var7) {
						var6[var7] = var2[var7];
					}

					var2 = var6;
				}

				var2[var3++] = (short)var4;
			}
		}

		WorldMapEvent.foundItemIds = var2;
		AbstractWorldMapIcon.foundItemIndex = 0;
		TextureProvider.foundItemIdCount = var3;
		String[] var8 = new String[TextureProvider.foundItemIdCount];

		for (int var9 = 0; var9 < TextureProvider.foundItemIdCount; ++var9) {
			var8[var9] = AbstractWorldMapData.ItemDefinition_get(var2[var9]).name;
		}

		class234.method4221(var8, WorldMapEvent.foundItemIds);
	}
}
