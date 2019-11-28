import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
@Implements("InterfaceParent")
public class InterfaceParent extends Node {
	@ObfuscatedName("pe")
	@ObfuscatedSignature(
		signature = "Ljg;"
	)
	@Export("clanChat")
	static ClanChat clanChat;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Llm;"
	)
	@Export("options_buttons_0Sprite")
	static IndexedSprite options_buttons_0Sprite;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -827675327
	)
	@Export("group")
	int group;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -207646309
	)
	@Export("type")
	int type;
	@ObfuscatedName("b")
	boolean field561;

	InterfaceParent() {
		this.field561 = false;
	}

	@ObfuscatedName("fr")
	@ObfuscatedSignature(
		signature = "(Liy;IIIB)V",
		garbageValue = "-6"
	)
	@Export("addSequenceSoundEffect")
	static void addSequenceSoundEffect(SequenceDefinition var0, int var1, int var2, int var3) {
		if (Client.soundEffectCount < 50 && Client.areaSoundEffectVolume != 0) {
			if (var0.soundEffects != null && var1 < var0.soundEffects.length) {
				int var4 = var0.soundEffects[var1];
				if (var4 != 0) {
					int var5 = var4 >> 8;
					int var6 = var4 >> 4 & 7;
					int var7 = var4 & 15;
					Client.soundEffectIds[Client.soundEffectCount] = var5;
					Client.queuedSoundEffectLoops[Client.soundEffectCount] = var6;
					Client.queuedSoundEffectDelays[Client.soundEffectCount] = 0;
					Client.soundEffects[Client.soundEffectCount] = null;
					int var8 = (var2 - 64) / 128;
					int var9 = (var3 - 64) / 128;
					Client.soundLocations[Client.soundEffectCount] = var7 + (var9 << 8) + (var8 << 16);
					++Client.soundEffectCount;
				}
			}
		}
	}

	@ObfuscatedName("hn")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "1179821355"
	)
	static final void method1197(boolean var0) {
		Tiles.playPcmPlayers();
		++Client.packetWriter.pendingWrites;
		if (Client.packetWriter.pendingWrites >= 50 || var0) {
			Client.packetWriter.pendingWrites = 0;
			if (!Client.field691 && Client.packetWriter.getSocket() != null) {
				PacketBufferNode var1 = ModelData0.getPacketBufferNode(ClientPacket.field2278, Client.packetWriter.isaacCipher);
				Client.packetWriter.addNode(var1);

				try {
					Client.packetWriter.flush();
				} catch (IOException var3) {
					Client.field691 = true;
				}
			}

		}
	}
}
