import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("q")
@Implements("WorldMapLabelSize")
public class WorldMapLabelSize {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lq;"
	)
	@Export("WorldMapLabelSize_small")
	public static final WorldMapLabelSize WorldMapLabelSize_small;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lq;"
	)
	@Export("WorldMapLabelSize_medium")
	public static final WorldMapLabelSize WorldMapLabelSize_medium;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lq;"
	)
	@Export("WorldMapLabelSize_large")
	public static final WorldMapLabelSize WorldMapLabelSize_large;
	@ObfuscatedName("gy")
	@ObfuscatedSignature(
		signature = "[Lli;"
	)
	@Export("mapMarkerSprites")
	static Sprite[] mapMarkerSprites;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -776092595
	)
	final int field113;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1063281473
	)
	final int field114;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1099337759
	)
	final int field116;

	static {
		WorldMapLabelSize_small = new WorldMapLabelSize(1, 0, 4);
		WorldMapLabelSize_medium = new WorldMapLabelSize(2, 1, 2);
		WorldMapLabelSize_large = new WorldMapLabelSize(0, 2, 0);
	}

	WorldMapLabelSize(int var1, int var2, int var3) {
		this.field113 = var1;
		this.field114 = var2;
		this.field116 = var3;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(FB)Z",
		garbageValue = "104"
	)
	boolean method167(float var1) {
		return var1 >= (float)this.field116;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "966574081"
	)
	static int method166(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = Player.getWidget(Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? UserComparator9.field1941 : MidiPcmStream.field2410;
		}

		WorldMapID.invalidateWidget(var3);
		if (var0 != ScriptOpcodes.CC_SETOBJECT && var0 != ScriptOpcodes.CC_SETOBJECT_NONUM && var0 != ScriptOpcodes.CC_SETOBJECT_ALWAYS_NUM) {
			if (var0 == ScriptOpcodes.CC_SETNPCHEAD) {
				var3.modelType = 2;
				var3.modelId = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETPLAYERHEAD_SELF) {
				var3.modelType = 3;
				var3.modelId = Varps.localPlayer.appearance.getChatHeadId();
				return 1;
			} else {
				return 2;
			}
		} else {
			class160.Interpreter_intStackSize -= 2;
			int var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
			int var5 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
			var3.itemId = var4;
			var3.itemQuantity = var5;
			ItemDefinition var6 = Player.ItemDefinition_get(var4);
			var3.modelAngleX = var6.xan2d;
			var3.modelAngleY = var6.yan2d;
			var3.modelAngleZ = var6.zan2d;
			var3.modelOffsetX = var6.offsetX2d;
			var3.modelOffsetY = var6.offsetY2d;
			var3.modelZoom = var6.zoom2d;
			if (var0 == ScriptOpcodes.CC_SETOBJECT_NONUM) {
				var3.itemQuantityMode = 0;
			} else if (var0 == ScriptOpcodes.CC_SETOBJECT_ALWAYS_NUM | 1 == var6.isStackable) {
				var3.itemQuantityMode = 1;
			} else {
				var3.itemQuantityMode = 2;
			}

			if (var3.field2582 > 0) {
				var3.modelZoom = var3.modelZoom * 32 / var3.field2582;
			} else if (var3.rawWidth > 0) {
				var3.modelZoom = var3.modelZoom * 32 / var3.rawWidth;
			}

			return 1;
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-55"
	)
	static final void method172(String var0) {
		PacketBufferNode var1 = MenuAction.getPacketBufferNode(ClientPacket.field2190, Client.packetWriter.isaacCipher);
		var1.packetBuffer.writeByte(Varcs.stringCp1252NullTerminatedByteSize(var0));
		var1.packetBuffer.writeStringCp1252NullTerminated(var0);
		Client.packetWriter.addNode(var1);
	}

	@ObfuscatedName("hp")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "408332868"
	)
	static final void method173() {
		int var0 = FileSystem.menuX;
		int var1 = class83.menuY;
		int var2 = class173.menuWidth;
		int var3 = FaceNormal.menuHeight;
		int var4 = 6116423;
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, var4);
		Rasterizer2D.Rasterizer2D_fillRectangle(var0 + 1, var1 + 1, var2 - 2, 16, 0);
		Rasterizer2D.Rasterizer2D_drawRectangle(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
		HealthBar.fontBold12.draw("Choose Option", var0 + 3, var1 + 14, var4, -1);
		int var5 = MouseHandler.MouseHandler_x;
		int var6 = MouseHandler.MouseHandler_y;

		for (int var7 = 0; var7 < Client.menuOptionsCount; ++var7) {
			int var8 = var1 + (Client.menuOptionsCount - 1 - var7) * 15 + 31;
			int var9 = 16777215;
			if (var5 > var0 && var5 < var2 + var0 && var6 > var8 - 13 && var6 < var8 + 3) {
				var9 = 16776960;
			}

			HealthBar.fontBold12.draw(class188.method3620(var7), var0 + 3, var8, var9, 0);
		}

		WorldMapElement.method4392(FileSystem.menuX, class83.menuY, class173.menuWidth, FaceNormal.menuHeight);
	}
}
