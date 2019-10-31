import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
@Implements("Entity")
public abstract class Entity extends DualNode {
	@ObfuscatedName("dl")
	@ObfuscatedSignature(
		signature = "Lfw;"
	)
	@Export("js5SocketTask")
	static Task js5SocketTask;
	@ObfuscatedName("cq")
	@ObfuscatedGetter(
		intValue = 1761306051
	)
	@Export("height")
	public int height;

	protected Entity() {
		this.height = 1000;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)Ldv;",
		garbageValue = "-40"
	)
	@Export("getModel")
	protected Model getModel() {
		return null;
	}

	@ObfuscatedName("ci")
	@Export("draw")
	void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9) {
		Model var11 = this.getModel();
		if (var11 != null) {
			this.height = var11.height;
			var11.draw(var1, var2, var3, var4, var5, var6, var7, var8, var9);
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "([BILjava/lang/CharSequence;I)I",
		garbageValue = "-1230334360"
	)
	public static int method3390(byte[] var0, int var1, CharSequence var2) {
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

	@ObfuscatedName("hh")
	@ObfuscatedSignature(
		signature = "(Lbz;II)V",
		garbageValue = "781315687"
	)
	@Export("getActorScreenLocation")
	static final void getActorScreenLocation(Actor var0, int var1) {
		WorldMapCacheName.worldToScreen(var0.x, var0.y, var1);
	}

	@ObfuscatedName("la")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-43"
	)
	@Export("Clan_joinChat")
	static final void Clan_joinChat(String var0) {
		if (!var0.equals("")) {
			PacketBufferNode var1 = SoundSystem.getPacketBufferNode(ClientPacket.field2267, Client.packetWriter.isaacCipher);
			var1.packetBuffer.writeByte(UserComparator6.stringCp1252NullTerminatedByteSize(var0));
			var1.packetBuffer.writeStringCp1252NullTerminated(var0);
			Client.packetWriter.addNode(var1);
		}
	}
}
