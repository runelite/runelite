import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("kq")
@Implements("FontName")
public class FontName {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lkq;"
	)
	@Export("FontName_plain11")
	public static final FontName FontName_plain11;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lkq;"
	)
	@Export("FontName_plain12")
	public static final FontName FontName_plain12;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lkq;"
	)
	@Export("FontName_bold12")
	public static final FontName FontName_bold12;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lkq;"
	)
	@Export("FontName_verdana11")
	public static final FontName FontName_verdana11;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lkq;"
	)
	@Export("FontName_verdana13")
	public static final FontName FontName_verdana13;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lkq;"
	)
	@Export("FontName_verdana15")
	public static final FontName FontName_verdana15;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Llx;"
	)
	@Export("rightTitleSprite")
	static Sprite rightTitleSprite;
	@ObfuscatedName("c")
	@Export("name")
	String name;

	static {
		FontName_plain11 = new FontName("p11_full");
		FontName_plain12 = new FontName("p12_full");
		FontName_bold12 = new FontName("b12_full");
		FontName_verdana11 = new FontName("verdana_11pt_regular");
		FontName_verdana13 = new FontName("verdana_13pt_regular");
		FontName_verdana15 = new FontName("verdana_15pt_regular");
	}

	FontName(String var1) {
		this.name = var1;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
		garbageValue = "703814886"
	)
	@Export("loadClassFromDescriptor")
	static Class loadClassFromDescriptor(String var0) throws ClassNotFoundException {
		if (var0.equals("B")) {
			return Byte.TYPE;
		} else if (var0.equals("I")) {
			return Integer.TYPE;
		} else if (var0.equals("S")) {
			return Short.TYPE;
		} else if (var0.equals("J")) {
			return Long.TYPE;
		} else if (var0.equals("Z")) {
			return Boolean.TYPE;
		} else if (var0.equals("F")) {
			return Float.TYPE;
		} else if (var0.equals("D")) {
			return Double.TYPE;
		} else if (var0.equals("C")) {
			return Character.TYPE;
		} else {
			return var0.equals("void") ? Void.TYPE : Reflection.findClass(var0);
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "348293638"
	)
	@Export("clearItemContainer")
	static void clearItemContainer(int var0) {
		ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var1 != null) {
			for (int var2 = 0; var2 < var1.ids.length; ++var2) {
				var1.ids[var2] = -1;
				var1.quantities[var2] = 0;
			}

		}
	}

	@ObfuscatedName("gh")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-837375180"
	)
	@Export("setWindowedMode")
	static void setWindowedMode(int var0) {
		Client.field736 = 0L;
		if (var0 >= 2) {
			Client.isResizable = true;
		} else {
			Client.isResizable = false;
		}

		if (WallDecoration.getWindowedMode() == 1) {
			WorldMapID.client.setMaxCanvasSize(765, 503);
		} else {
			WorldMapID.client.setMaxCanvasSize(7680, 2160);
		}

		if (Client.gameState >= 25) {
			PacketBufferNode var1 = SoundSystem.getPacketBufferNode(ClientPacket.field2257, Client.packetWriter.isaacCipher);
			var1.packetBuffer.writeByte(WallDecoration.getWindowedMode());
			var1.packetBuffer.writeShort(class286.canvasWidth);
			var1.packetBuffer.writeShort(FloorUnderlayDefinition.canvasHeight);
			Client.packetWriter.addNode(var1);
		}

	}

	@ObfuscatedName("hw")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1528266884"
	)
	static final void method5442() {
		for (GraphicsObject var0 = (GraphicsObject)Client.graphicsObjects.last(); var0 != null; var0 = (GraphicsObject)Client.graphicsObjects.previous()) {
			if (var0.plane == Player.Client_plane && !var0.isFinished) {
				if (Client.cycle >= var0.cycleStart) {
					var0.advance(Client.field693);
					if (var0.isFinished) {
						var0.remove();
					} else {
						WorldMapArea.scene.drawEntity(var0.plane, var0.x, var0.y, var0.height, 60, var0, 0, -1L, false);
					}
				}
			} else {
				var0.remove();
			}
		}

	}

	@ObfuscatedName("lp")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1324423171"
	)
	static void method5443() {
		if (Client.field645 && class215.localPlayer != null) {
			int var0 = class215.localPlayer.pathX[0];
			int var1 = class215.localPlayer.pathY[0];
			if (var0 < 0 || var1 < 0 || var0 >= 104 || var1 >= 104) {
				return;
			}

			IgnoreList.oculusOrbFocalPointX = class215.localPlayer.x;
			int var2 = GraphicsObject.getTileHeight(class215.localPlayer.x, class215.localPlayer.y, Player.Client_plane) - Client.camFollowHeight;
			if (var2 < Tiles.field497) {
				Tiles.field497 = var2;
			}

			AbstractArchive.oculusOrbFocalPointY = class215.localPlayer.y;
			Client.field645 = false;
		}

	}
}
