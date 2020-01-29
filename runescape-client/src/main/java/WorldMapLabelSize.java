import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
@Implements("WorldMapLabelSize")
public class WorldMapLabelSize {
	@ObfuscatedName("qw")
	@ObfuscatedSignature(
		signature = "Ldw;"
	)
	@Export("pcmPlayer0")
	static PcmPlayer pcmPlayer0;
	@ObfuscatedName("rn")
	@ObfuscatedGetter(
		intValue = 1439744000
	)
	static int field139;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lq;"
	)
	@Export("WorldMapLabelSize_small")
	public static final WorldMapLabelSize WorldMapLabelSize_small;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lq;"
	)
	@Export("WorldMapLabelSize_medium")
	public static final WorldMapLabelSize WorldMapLabelSize_medium;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lq;"
	)
	@Export("WorldMapLabelSize_large")
	public static final WorldMapLabelSize WorldMapLabelSize_large;
	@ObfuscatedName("d")
	public static short[] field128;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lbz;"
	)
	@Export("loginScreenRunesAnimation")
	static LoginScreenAnimation loginScreenRunesAnimation;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lal;"
	)
	@Export("worldMapEvent")
	static WorldMapEvent worldMapEvent;
	@ObfuscatedName("er")
	@ObfuscatedGetter(
		intValue = 1639032335
	)
	@Export("port1")
	static int port1;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -147452209
	)
	final int field127;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -10868609
	)
	final int field132;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 984617173
	)
	final int field131;

	static {
		WorldMapLabelSize_small = new WorldMapLabelSize(0, 0, 4);
		WorldMapLabelSize_medium = new WorldMapLabelSize(2, 1, 2);
		WorldMapLabelSize_large = new WorldMapLabelSize(1, 2, 0);
	}

	WorldMapLabelSize(int var1, int var2, int var3) {
		this.field127 = var1;
		this.field132 = var2;
		this.field131 = var3;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(FI)Z",
		garbageValue = "-680427426"
	)
	boolean method192(float var1) {
		return var1 >= (float)this.field131;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1845192428"
	)
	static void method198() {
		ItemContainer.itemContainers = new NodeHashTable(32);
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-1220899418"
	)
	public static void method197(boolean var0) {
		if (var0 != class298.ItemDefinition_inMembersWorld) {
			ItemDefinition.ItemDefinition_cached.clear();
			ItemDefinition.ItemDefinition_cachedModels.clear();
			ItemDefinition.ItemDefinition_cachedSprites.clear();
			class298.ItemDefinition_inMembersWorld = var0;
		}

	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "2070539914"
	)
	@Export("runWidgetOnLoadListener")
	static void runWidgetOnLoadListener(int var0) {
		if (var0 != -1) {
			if (ScriptFrame.loadInterface(var0)) {
				Widget[] var1 = WorldMapLabel.Widget_interfaceComponents[var0];

				for (int var2 = 0; var2 < var1.length; ++var2) {
					Widget var3 = var1[var2];
					if (var3.onLoad != null) {
						ScriptEvent var4 = new ScriptEvent();
						var4.widget = var3;
						var4.args = var3.onLoad;
						WorldMapID.runScript(var4, 5000000);
					}
				}

			}
		}
	}
}
