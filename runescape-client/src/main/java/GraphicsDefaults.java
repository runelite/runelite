import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kk")
@Implements("GraphicsDefaults")
public class GraphicsDefaults {
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1326295971
	)
	@Export("canvasWidth")
	public static int canvasWidth;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 743645305
	)
	@Export("compass")
	public int compass;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1263393423
	)
	public int field3794;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -222158885
	)
	@Export("mapScenes")
	public int mapScenes;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 293018585
	)
	@Export("headIconsPk")
	public int headIconsPk;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 59968597
	)
	public int field3797;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 407705871
	)
	public int field3798;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 24582741
	)
	public int field3800;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1990585073
	)
	public int field3804;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 309369313
	)
	public int field3801;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -328738669
	)
	public int field3802;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1048737749
	)
	public int field3799;

	public GraphicsDefaults() {
		this.compass = -1;
		this.field3794 = -1;
		this.mapScenes = -1;
		this.headIconsPk = -1;
		this.field3797 = -1;
		this.field3798 = -1;
		this.field3800 = -1;
		this.field3804 = -1;
		this.field3801 = -1;
		this.field3802 = -1;
		this.field3799 = -1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lhz;I)V",
		garbageValue = "361058639"
	)
	@Export("decode")
	public void decode(AbstractArchive var1) {
		byte[] var2 = var1.takeFileFlat(DefaultsGroup.field3792.group);
		Buffer var3 = new Buffer(var2);

		while (true) {
			int var4 = var3.readUnsignedByte();
			if (var4 == 0) {
				return;
			}

			switch(var4) {
			case 1:
				var3.readMedium();
				break;
			case 2:
				this.compass = var3.method5623();
				this.field3794 = var3.method5623();
				this.mapScenes = var3.method5623();
				this.headIconsPk = var3.method5623();
				this.field3797 = var3.method5623();
				this.field3798 = var3.method5623();
				this.field3800 = var3.method5623();
				this.field3804 = var3.method5623();
				this.field3801 = var3.method5623();
				this.field3802 = var3.method5623();
				this.field3799 = var3.method5623();
			}
		}
	}

	@ObfuscatedName("ji")
	@ObfuscatedSignature(
		signature = "(IIII)Lbw;",
		garbageValue = "-1376012645"
	)
	static final InterfaceParent method5875(int var0, int var1, int var2) {
		InterfaceParent var3 = new InterfaceParent();
		var3.group = var1;
		var3.type = var2;
		Client.interfaceParents.put(var3, (long)var0);
		DevicePcmPlayerProvider.Widget_resetModelFrames(var1);
		Widget var4 = Player.getWidget(var0);
		WorldMapID.invalidateWidget(var4);
		if (Client.meslayerContinueWidget != null) {
			WorldMapID.invalidateWidget(Client.meslayerContinueWidget);
			Client.meslayerContinueWidget = null;
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
		class197.revalidateWidgetScroll(class289.Widget_interfaceComponents[var0 >> 16], var4, false);
		Tile.runWidgetOnLoadListener(var1);
		if (Client.rootInterface != -1) {
			WorldMapRectangle.runIntfCloseListeners(Client.rootInterface, 1);
		}

		return var3;
	}
}
