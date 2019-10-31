import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("Script")
public class Script extends DualNode {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("Script_cached")
	static EvictingDualNodeHashTable Script_cached;
	@ObfuscatedName("t")
	@Export("opcodes")
	int[] opcodes;
	@ObfuscatedName("n")
	@Export("intOperands")
	int[] intOperands;
	@ObfuscatedName("q")
	@Export("stringOperands")
	String[] stringOperands;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -435727749
	)
	@Export("localIntCount")
	int localIntCount;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -291180187
	)
	@Export("localStringCount")
	int localStringCount;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 970489761
	)
	@Export("intArgumentCount")
	int intArgumentCount;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1827947623
	)
	@Export("stringArgumentCount")
	int stringArgumentCount;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "[Llr;"
	)
	@Export("switches")
	IterableNodeHashTable[] switches;

	static {
		Script_cached = new EvictingDualNodeHashTable(128);
	}

	Script() {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IB)[Llr;",
		garbageValue = "-39"
	)
	@Export("newIterableNodeHashTable")
	IterableNodeHashTable[] newIterableNodeHashTable(int var1) {
		return new IterableNodeHashTable[var1];
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lhq;Lhq;I)V",
		garbageValue = "-1167924124"
	)
	public static void method2373(AbstractArchive var0, AbstractArchive var1) {
		NPCDefinition.NpcDefinition_archive = var0;
		NPCDefinition.NpcDefinition_modelArchive = var1;
	}

	@ObfuscatedName("gn")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "3316"
	)
	static final void method2383() {
		int var0 = class14.field88 * 128 + 64;
		int var1 = class42.field360 * 128 + 64;
		int var2 = GraphicsObject.getTileHeight(var0, var1, Player.Client_plane) - WorldMapLabel.field231;
		if (UrlRequester.cameraX < var0) {
			UrlRequester.cameraX = (var0 - UrlRequester.cameraX) * Interpreter.field1068 / 1000 + UrlRequester.cameraX + WorldMapAreaData.field323;
			if (UrlRequester.cameraX > var0) {
				UrlRequester.cameraX = var0;
			}
		}

		if (UrlRequester.cameraX > var0) {
			UrlRequester.cameraX -= Interpreter.field1068 * (UrlRequester.cameraX - var0) / 1000 + WorldMapAreaData.field323;
			if (UrlRequester.cameraX < var0) {
				UrlRequester.cameraX = var0;
			}
		}

		if (class16.cameraY < var2) {
			class16.cameraY = (var2 - class16.cameraY) * Interpreter.field1068 / 1000 + class16.cameraY + WorldMapAreaData.field323;
			if (class16.cameraY > var2) {
				class16.cameraY = var2;
			}
		}

		if (class16.cameraY > var2) {
			class16.cameraY -= Interpreter.field1068 * (class16.cameraY - var2) / 1000 + WorldMapAreaData.field323;
			if (class16.cameraY < var2) {
				class16.cameraY = var2;
			}
		}

		if (GrandExchangeOfferAgeComparator.cameraZ < var1) {
			GrandExchangeOfferAgeComparator.cameraZ = (var1 - GrandExchangeOfferAgeComparator.cameraZ) * Interpreter.field1068 / 1000 + GrandExchangeOfferAgeComparator.cameraZ + WorldMapAreaData.field323;
			if (GrandExchangeOfferAgeComparator.cameraZ > var1) {
				GrandExchangeOfferAgeComparator.cameraZ = var1;
			}
		}

		if (GrandExchangeOfferAgeComparator.cameraZ > var1) {
			GrandExchangeOfferAgeComparator.cameraZ -= Interpreter.field1068 * (GrandExchangeOfferAgeComparator.cameraZ - var1) / 1000 + WorldMapAreaData.field323;
			if (GrandExchangeOfferAgeComparator.cameraZ < var1) {
				GrandExchangeOfferAgeComparator.cameraZ = var1;
			}
		}

		var0 = AbstractUserComparator.field3583 * 16384 + 64;
		var1 = class49.field401 * 128 + 64;
		var2 = GraphicsObject.getTileHeight(var0, var1, Player.Client_plane) - ViewportMouse.field1713;
		int var3 = var0 - UrlRequester.cameraX;
		int var4 = var2 - class16.cameraY;
		int var5 = var1 - GrandExchangeOfferAgeComparator.cameraZ;
		int var6 = (int)Math.sqrt((double)(var5 * var5 + var3 * var3));
		int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
		int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
		if (var7 < 128) {
			var7 = 128;
		}

		if (var7 > 383) {
			var7 = 383;
		}

		if (class247.cameraPitch < var7) {
			class247.cameraPitch = (var7 - class247.cameraPitch) * SecureRandomCallable.field510 / 1000 + class247.cameraPitch + Clock.field2036;
			if (class247.cameraPitch > var7) {
				class247.cameraPitch = var7;
			}
		}

		if (class247.cameraPitch > var7) {
			class247.cameraPitch -= SecureRandomCallable.field510 * (class247.cameraPitch - var7) / 1000 + Clock.field2036;
			if (class247.cameraPitch < var7) {
				class247.cameraPitch = var7;
			}
		}

		int var9 = var8 - WorldMapData_1.cameraYaw;
		if (var9 > 1024) {
			var9 -= 2048;
		}

		if (var9 < -1024) {
			var9 += 2048;
		}

		if (var9 > 0) {
			WorldMapData_1.cameraYaw = var9 * SecureRandomCallable.field510 / 1000 + WorldMapData_1.cameraYaw + Clock.field2036;
			WorldMapData_1.cameraYaw &= 2047;
		}

		if (var9 < 0) {
			WorldMapData_1.cameraYaw -= Clock.field2036 + -var9 * SecureRandomCallable.field510 / 1000;
			WorldMapData_1.cameraYaw &= 2047;
		}

		int var10 = var8 - WorldMapData_1.cameraYaw;
		if (var10 > 1024) {
			var10 -= 2048;
		}

		if (var10 < -1024) {
			var10 += 2048;
		}

		if (var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
			WorldMapData_1.cameraYaw = var8;
		}

	}

	@ObfuscatedName("kh")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1862071000"
	)
	static void method2384(int var0) {
		StudioGame.tempMenuAction = new MenuAction();
		StudioGame.tempMenuAction.argument1 = Client.menuArguments1[var0];
		StudioGame.tempMenuAction.argument2 = Client.menuArguments2[var0];
		StudioGame.tempMenuAction.opcode = Client.menuOpcodes[var0];
		StudioGame.tempMenuAction.argument0 = Client.menuIdentifiers[var0];
		StudioGame.tempMenuAction.action = Client.menuActions[var0];
	}
}
