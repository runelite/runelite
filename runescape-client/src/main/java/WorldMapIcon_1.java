import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
@Implements("WorldMapIcon_1")
public class WorldMapIcon_1 extends AbstractWorldMapIcon {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 52552105
	)
	@Export("objectDefId")
	final int objectDefId;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lax;"
	)
	@Export("region")
	final WorldMapRegion region;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1871075417
	)
	@Export("element")
	int element;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Laz;"
	)
	@Export("label")
	WorldMapLabel label;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -260537351
	)
	@Export("subWidth")
	int subWidth;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -753416785
	)
	@Export("subHeight")
	int subHeight;

	@ObfuscatedSignature(
		signature = "(Lhj;Lhj;ILax;)V"
	)
	WorldMapIcon_1(Coord var1, Coord var2, int var3, WorldMapRegion var4) {
		super(var1, var2);
		this.objectDefId = var3;
		this.region = var4;
		this.init();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1499764486"
	)
	@Export("getElement")
	public int getElement() {
		return this.element;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)Laz;",
		garbageValue = "124"
	)
	@Export("getLabel")
	WorldMapLabel getLabel() {
		return this.label;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "-26101"
	)
	@Export("getSubWidth")
	int getSubWidth() {
		return this.subWidth;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "1"
	)
	@Export("getSubHeight")
	int getSubHeight() {
		return this.subHeight;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1452393190"
	)
	@Export("init")
	void init() {
		this.element = Occluder.getObjectDefinition(this.objectDefId).transform().mapIconId;
		this.label = this.region.createMapLabel(PacketBufferNode.WorldMapElement_get(this.element));
		WorldMapElement var1 = PacketBufferNode.WorldMapElement_get(this.getElement());
		Sprite var2 = var1.getSpriteBool(false);
		if (var2 != null) {
			this.subWidth = var2.subWidth;
			this.subHeight = var2.subHeight;
		} else {
			this.subWidth = 0;
			this.subHeight = 0;
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "([BILjava/lang/CharSequence;B)I",
		garbageValue = "112"
	)
	public static int method310(byte[] var0, int var1, CharSequence var2) {
		int var3 = var2.length();
		int var4 = var1;

		for (int var5 = 0; var5 < var3; ++var5) {
			char var6 = var2.charAt(var5);
			if (var6 <= 127) {
				var0[var4++] = (byte)var6;
			} else if (var6 <= 2047) {
				var0[var4++] = (byte)(192 | var6 >> 6);
				var0[var4++] = (byte)(128 | var6 & '?');
			} else {
				var0[var4++] = (byte)(224 | var6 >> '\f');
				var0[var4++] = (byte)(128 | var6 >> 6 & 63);
				var0[var4++] = (byte)(128 | var6 & '?');
			}
		}

		return var4 - var1;
	}

	@ObfuscatedName("fg")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-8"
	)
	static final void method308() {
		if (Client.logoutTimer > 0) {
			class30.logOut();
		} else {
			Client.timer.method5045();
			Projectile.updateGameState(40);
			ClientPreferences.field1052 = Client.packetWriter.getSocket();
			Client.packetWriter.removeSocket();
		}
	}

	@ObfuscatedName("il")
	@ObfuscatedSignature(
		signature = "([Lhn;Lhn;ZB)V",
		garbageValue = "42"
	)
	@Export("revalidateWidgetScroll")
	static void revalidateWidgetScroll(Widget[] var0, Widget var1, boolean var2) {
		int var3 = var1.scrollWidth != 0 ? var1.scrollWidth : var1.width;
		int var4 = var1.scrollHeight != 0 ? var1.scrollHeight : var1.height;
		FloorUnderlayDefinition.resizeInterface(var0, var1.id, var3, var4, var2);
		if (var1.children != null) {
			FloorUnderlayDefinition.resizeInterface(var1.children, var1.id, var3, var4, var2);
		}

		InterfaceParent var5 = (InterfaceParent)Client.interfaceParents.get((long)var1.id);
		if (var5 != null) {
			GrandExchangeOfferUnitPriceComparator.method135(var5.group, var3, var4, var2);
		}

		if (var1.contentType == 1337) {
		}

	}
}
