import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
@Implements("WorldMapIcon_1")
public class WorldMapIcon_1 extends AbstractWorldMapIcon {
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -2092116219
	)
	@Export("objectDefId")
	final int objectDefId;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lai;"
	)
	@Export("region")
	final WorldMapRegion region;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1422868001
	)
	@Export("element")
	int element;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lam;"
	)
	@Export("label")
	WorldMapLabel label;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -900902157
	)
	@Export("subWidth")
	int subWidth;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -673960603
	)
	@Export("subHeight")
	int subHeight;

	@ObfuscatedSignature(
		signature = "(Lhx;Lhx;ILai;)V"
	)
	WorldMapIcon_1(Coord var1, Coord var2, int var3, WorldMapRegion var4) {
		super(var1, var2);
		this.objectDefId = var3;
		this.region = var4;
		this.init();
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-871583687"
	)
	@Export("getElement")
	public int getElement() {
		return this.element;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)Lam;",
		garbageValue = "969160497"
	)
	@Export("getLabel")
	WorldMapLabel getLabel() {
		return this.label;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-55298135"
	)
	@Export("getSubWidth")
	int getSubWidth() {
		return this.subWidth;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-51"
	)
	@Export("getSubHeight")
	int getSubHeight() {
		return this.subHeight;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1280762110"
	)
	@Export("init")
	void init() {
		this.element = Occluder.getObjectDefinition(this.objectDefId).transform().mapIconId;
		this.label = this.region.createMapLabel(Varcs.WorldMapElement_get(this.element));
		WorldMapElement var1 = Varcs.WorldMapElement_get(this.getElement());
		Sprite var2 = var1.getSpriteBool(false);
		if (var2 != null) {
			this.subWidth = var2.subWidth;
			this.subHeight = var2.subHeight;
		} else {
			this.subWidth = 0;
			this.subHeight = 0;
		}

	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "80"
	)
	static int method309(int var0) {
		return (int)Math.pow(2.0D, (double)((float)var0 / 256.0F + 7.0F));
	}

	@ObfuscatedName("gx")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZI)V",
		garbageValue = "58684745"
	)
	@Export("drawLoadingMessage")
	static final void drawLoadingMessage(String var0, boolean var1) {
		if (Client.showLoadingMessages) {
			byte var2 = 4;
			int var3 = var2 + 6;
			int var4 = var2 + 6;
			int var5 = Player.fontPlain12.lineWidth(var0, 250);
			int var6 = Player.fontPlain12.lineCount(var0, 250) * 13;
			Rasterizer2D.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
			Rasterizer2D.Rasterizer2D_drawRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2, 16777215);
			Player.fontPlain12.drawLines(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
			int var7 = var3 - var2;
			int var8 = var4 - var2;
			int var9 = var2 + var5 + var2;
			int var10 = var2 + var6 + var2;

			int var11;
			for (var11 = 0; var11 < Client.rootWidgetCount; ++var11) {
				if (Client.rootWidgetWidths[var11] + Client.rootWidgetXs[var11] > var7 && Client.rootWidgetXs[var11] < var9 + var7 && Client.rootWidgetYs[var11] + Client.rootWidgetHeights[var11] > var8 && Client.rootWidgetYs[var11] < var10 + var8) {
					Client.field847[var11] = true;
				}
			}

			if (var1) {
				DirectByteArrayCopier.rasterProvider.drawFull(0, 0);
			} else {
				var11 = var3;
				int var12 = var4;
				int var13 = var5;
				int var14 = var6;

				for (int var15 = 0; var15 < Client.rootWidgetCount; ++var15) {
					if (Client.rootWidgetXs[var15] + Client.rootWidgetWidths[var15] > var11 && Client.rootWidgetXs[var15] < var13 + var11 && Client.rootWidgetYs[var15] + Client.rootWidgetHeights[var15] > var12 && Client.rootWidgetYs[var15] < var14 + var12) {
						Client.field837[var15] = true;
					}
				}
			}

		}
	}

	@ObfuscatedName("hy")
	@ObfuscatedSignature(
		signature = "(III)Lfg;",
		garbageValue = "1189073530"
	)
	static RouteStrategy method321(int var0, int var1) {
		Client.field915.approxDestinationX = var0;
		Client.field915.approxDestinationY = var1;
		Client.field915.approxDestinationSizeX = 1;
		Client.field915.approxDestinationSizeY = 1;
		return Client.field915;
	}

	@ObfuscatedName("kf")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "826026682"
	)
	@Export("FriendSystem_invalidateFriends")
	static final void FriendSystem_invalidateFriends() {
		for (int var0 = 0; var0 < Players.Players_count; ++var0) {
			Player var1 = Client.players[Players.Players_indices[var0]];
			var1.clearIsFriend();
		}

		Iterator var2 = Messages.Messages_hashTable.iterator();

		while (var2.hasNext()) {
			Message var3 = (Message)var2.next();
			var3.clearIsFromFriend();
		}

		if (InterfaceParent.clanChat != null) {
			InterfaceParent.clanChat.clearFriends();
		}

	}
}
