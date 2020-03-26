import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
public class class60 {
	@ObfuscatedName("x")
	@Export("applet")
	public static Applet applet;
	@ObfuscatedName("m")
	public static String field462;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 200770361
	)
	@Export("graphicsTickTimeIdx")
	static int graphicsTickTimeIdx;

	static {
		applet = null;
		field462 = "";
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)Lif;",
		garbageValue = "-696554810"
	)
	public static FloorUnderlayDefinition method995(int var0) {
		FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.FloorUnderlayDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = FloorUnderlayDefinition.FloorUnderlayDefinition_archive.takeFile(1, var0);
			var1 = new FloorUnderlayDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2), var0);
			}

			var1.postDecode();
			FloorUnderlayDefinition.FloorUnderlayDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("fm")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-9"
	)
	@Export("doCheat")
	static final void doCheat(String var0) {
		if (var0.equalsIgnoreCase("toggleroof")) {
			GrandExchangeOfferOwnWorldComparator.clientPreferences.roofsHidden = !GrandExchangeOfferOwnWorldComparator.clientPreferences.roofsHidden;
			WorldMapArea.savePreferences();
			if (GrandExchangeOfferOwnWorldComparator.clientPreferences.roofsHidden) {
				Skeleton.addGameMessage(99, "", "Roofs are now all hidden");
			} else {
				Skeleton.addGameMessage(99, "", "Roofs will only be removed selectively");
			}
		}

		if (var0.equalsIgnoreCase("displayfps")) {
			Client.displayFps = !Client.displayFps;
		}

		if (var0.equalsIgnoreCase("renderself")) {
			Client.renderSelf = !Client.renderSelf;
		}

		if (var0.equalsIgnoreCase("mouseovertext")) {
			Client.showMouseOverText = !Client.showMouseOverText;
		}

		if (Client.staffModLevel >= 2) {
			if (var0.equalsIgnoreCase("errortest")) {
				throw new RuntimeException();
			}

			if (var0.equalsIgnoreCase("showcoord")) {
				GrandExchangeOfferAgeComparator.worldMap.showCoord = !GrandExchangeOfferAgeComparator.worldMap.showCoord;
			}

			if (var0.equalsIgnoreCase("fpson")) {
				Client.displayFps = true;
			}

			if (var0.equalsIgnoreCase("fpsoff")) {
				Client.displayFps = false;
			}

			if (var0.equalsIgnoreCase("gc")) {
				System.gc();
			}

			if (var0.equalsIgnoreCase("clientdrop")) {
				VertexNormal.method3093();
			}
		}

		PacketBufferNode var1 = FaceNormal.getPacketBufferNode(ClientPacket.field2246, Client.packetWriter.isaacCipher);
		var1.packetBuffer.writeByte(var0.length() + 1);
		var1.packetBuffer.writeStringCp1252NullTerminated(var0);
		Client.packetWriter.addNode(var1);
	}

	@ObfuscatedName("it")
	@ObfuscatedSignature(
		signature = "(IIIIIII)V",
		garbageValue = "-228702425"
	)
	static final void method997(int var0, int var1, int var2, int var3, int var4, int var5) {
		int var6 = var2 - var0;
		int var7 = var3 - var1;
		int var8 = var6 >= 0 ? var6 : -var6;
		int var9 = var7 >= 0 ? var7 : -var7;
		int var10 = var8;
		if (var8 < var9) {
			var10 = var9;
		}

		if (var10 != 0) {
			int var11 = (var6 << 16) / var10;
			int var12 = (var7 << 16) / var10;
			if (var12 <= var11) {
				var11 = -var11;
			} else {
				var12 = -var12;
			}

			int var13 = var5 * var12 >> 17;
			int var14 = var5 * var12 + 1 >> 17;
			int var15 = var5 * var11 >> 17;
			int var16 = var5 * var11 + 1 >> 17;
			var0 -= Rasterizer2D.Rasterizer2D_xClipStart;
			var1 -= Rasterizer2D.Rasterizer2D_yClipStart;
			int var17 = var0 + var13;
			int var18 = var0 - var14;
			int var19 = var0 + var6 - var14;
			int var20 = var0 + var13 + var6;
			int var21 = var15 + var1;
			int var22 = var1 - var16;
			int var23 = var7 + var1 - var16;
			int var24 = var7 + var15 + var1;
			Rasterizer3D.method3110(var17, var18, var19);
			Rasterizer3D.method3107(var21, var22, var23, var17, var18, var19, var4);
			Rasterizer3D.method3110(var17, var19, var20);
			Rasterizer3D.method3107(var21, var23, var24, var17, var19, var20, var4);
		}
	}
}
