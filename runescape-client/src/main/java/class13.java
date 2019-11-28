import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public class class13 {
	@ObfuscatedName("br")
	@ObfuscatedGetter(
		intValue = 1914182179
	)
	static int field91;
	@ObfuscatedName("dd")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive19")
	static Archive archive19;

	@ObfuscatedName("fa")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "507388741"
	)
	@Export("doCheat")
	static final void doCheat(String var0) {
		if (var0.equalsIgnoreCase("toggleroof")) {
			UserComparator10.clientPreferences.roofsHidden = !UserComparator10.clientPreferences.roofsHidden;
			class40.savePreferences();
			if (UserComparator10.clientPreferences.roofsHidden) {
				GrandExchangeOfferAgeComparator.addGameMessage(99, "", "Roofs are now all hidden");
			} else {
				GrandExchangeOfferAgeComparator.addGameMessage(99, "", "Roofs will only be removed selectively");
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
				WorldMapRegion.worldMap.showCoord = !WorldMapRegion.worldMap.showCoord;
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
				Projectile.method2137();
			}
		}

		PacketBufferNode var1 = ModelData0.getPacketBufferNode(ClientPacket.field2246, Client.packetWriter.isaacCipher);
		var1.packetBuffer.writeByte(var0.length() + 1);
		var1.packetBuffer.writeStringCp1252NullTerminated(var0);
		Client.packetWriter.addNode(var1);
	}
}
