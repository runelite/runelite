import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("WorldMapIcon_0")
public class WorldMapIcon_0 extends AbstractWorldMapIcon {
	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		signature = "Lmx;"
	)
	@Export("loginType")
	static LoginType loginType;
	@ObfuscatedName("dr")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	@Export("archive5")
	static Archive archive5;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -602879945
	)
	@Export("element")
	final int element;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lau;"
	)
	@Export("label")
	final WorldMapLabel label;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1634028725
	)
	@Export("subWidth")
	final int subWidth;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 497212545
	)
	@Export("subHeight")
	final int subHeight;

	@ObfuscatedSignature(
		signature = "(Lhj;Lhj;ILau;)V"
	)
	WorldMapIcon_0(Coord var1, Coord var2, int var3, WorldMapLabel var4) {
		super(var1, var2);
		this.element = var3;
		this.label = var4;
		WorldMapElement var5 = class25.WorldMapElement_get(this.getElement());
		Sprite var6 = var5.getSpriteBool(false);
		if (var6 != null) {
			this.subWidth = var6.subWidth;
			this.subHeight = var6.subHeight;
		} else {
			this.subWidth = 0;
			this.subHeight = 0;
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "16"
	)
	@Export("getElement")
	public int getElement() {
		return this.element;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)Lau;",
		garbageValue = "2077771117"
	)
	@Export("getLabel")
	WorldMapLabel getLabel() {
		return this.label;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "650401890"
	)
	@Export("getSubWidth")
	int getSubWidth() {
		return this.subWidth;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1828864081"
	)
	@Export("getSubHeight")
	int getSubHeight() {
		return this.subHeight;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;II)Z",
		garbageValue = "-1457680622"
	)
	static boolean method306(String var0, int var1) {
		return ItemContainer.method1274(var0, var1, "openjs");
	}

	@ObfuscatedName("hk")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1081049793"
	)
	static final void method304() {
		PacketBuffer var0 = Client.packetWriter.packetBuffer;
		var0.importIndex();
		int var1 = var0.readBits(8);
		int var2;
		if (var1 < Client.npcCount) {
			for (var2 = var1; var2 < Client.npcCount; ++var2) {
				Client.field918[++Client.field801 - 1] = Client.npcIndices[var2];
			}
		}

		if (var1 > Client.npcCount) {
			throw new RuntimeException("");
		} else {
			Client.npcCount = 0;

			for (var2 = 0; var2 < var1; ++var2) {
				int var3 = Client.npcIndices[var2];
				NPC var4 = Client.npcs[var3];
				int var5 = var0.readBits(1);
				if (var5 == 0) {
					Client.npcIndices[++Client.npcCount - 1] = var3;
					var4.npcCycle = Client.cycle;
				} else {
					int var6 = var0.readBits(2);
					if (var6 == 0) {
						Client.npcIndices[++Client.npcCount - 1] = var3;
						var4.npcCycle = Client.cycle;
						Client.field725[++Client.field851 - 1] = var3;
					} else {
						int var7;
						int var8;
						if (var6 == 1) {
							Client.npcIndices[++Client.npcCount - 1] = var3;
							var4.npcCycle = Client.cycle;
							var7 = var0.readBits(3);
							var4.method2133(var7, (byte)1);
							var8 = var0.readBits(1);
							if (var8 == 1) {
								Client.field725[++Client.field851 - 1] = var3;
							}
						} else if (var6 == 2) {
							Client.npcIndices[++Client.npcCount - 1] = var3;
							var4.npcCycle = Client.cycle;
							var7 = var0.readBits(3);
							var4.method2133(var7, (byte)2);
							var8 = var0.readBits(3);
							var4.method2133(var8, (byte)2);
							int var9 = var0.readBits(1);
							if (var9 == 1) {
								Client.field725[++Client.field851 - 1] = var3;
							}
						} else if (var6 == 3) {
							Client.field918[++Client.field801 - 1] = var3;
						}
					}
				}
			}

		}
	}
}
