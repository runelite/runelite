import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
@Implements("StudioGame")
public enum StudioGame implements Enumerated {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lht;"
	)
	@Export("runescape")
	runescape("runescape", "RuneScape", 0),
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lht;"
	)
	@Export("stellardawn")
	stellardawn("stellardawn", "Stellar Dawn", 1),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lht;"
	)
	@Export("game3")
	game3("game3", "Game 3", 2),
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lht;"
	)
	@Export("game4")
	game4("game4", "Game 4", 3),
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lht;"
	)
	@Export("game5")
	game5("game5", "Game 5", 4),
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lht;"
	)
	@Export("oldscape")
	oldscape("oldscape", "RuneScape 2007", 5);

	@ObfuscatedName("j")
	@Export("name")
	public final String name;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 933814381
	)
	@Export("id")
	final int id;

	StudioGame(String var3, String var4, int var5) {
		this.name = var3;
		this.id = var5;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1410702910"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("t")
	@Export("base37DecodeLong")
	public static String base37DecodeLong(long var0) {
		if (var0 > 0L && var0 < 6582952005840035281L) {
			if (0L == var0 % 37L) {
				return null;
			} else {
				int var2 = 0;

				for (long var3 = var0; 0L != var3; var3 /= 37L) {
					++var2;
				}

				StringBuilder var5;
				char var8;
				for (var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
					long var6 = var0;
					var0 /= 37L;
					var8 = class288.base37Table[(int)(var6 - var0 * 37L)];
					if (var8 == '_') {
						int var9 = var5.length() - 1;
						var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
						var8 = 160;
					}
				}

				var5.reverse();
				var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
				return var5.toString();
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("gc")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-508732522"
	)
	static final void method4131(boolean var0) {
		ModelData0.playPcmPlayers();
		++Client.packetWriter.pendingWrites;
		if (Client.packetWriter.pendingWrites >= 50 || var0) {
			Client.packetWriter.pendingWrites = 0;
			if (!Client.field772 && Client.packetWriter.getSocket() != null) {
				PacketBufferNode var1 = MenuAction.getPacketBufferNode(ClientPacket.field2185, Client.packetWriter.isaacCipher);
				Client.packetWriter.addNode(var1);

				try {
					Client.packetWriter.flush();
				} catch (IOException var3) {
					Client.field772 = true;
				}
			}

		}
	}
}
