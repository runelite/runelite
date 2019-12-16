import java.io.IOException;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
@Implements("Buddy")
public class Buddy extends User {
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 945410251
	)
	@Export("world")
	public int world;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 509966379
	)
	@Export("int2")
	public int int2;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1815065489
	)
	@Export("rank")
	public int rank;

	Buddy() {
		this.world = -1;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-309378639"
	)
	@Export("set")
	void set(int var1, int var2) {
		this.world = var1;
		this.int2 = var2;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1803035811"
	)
	@Export("getWorld")
	public int getWorld() {
		return this.world;
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1364700600"
	)
	@Export("hasWorld")
	public boolean hasWorld() {
		return this.world > 0;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "1663251439"
	)
	public static String method5214(String var0) {
		int var1 = var0.length();
		char[] var2 = new char[var1];
		byte var3 = 2;

		for (int var4 = 0; var4 < var1; ++var4) {
			char var5 = var0.charAt(var4);
			if (var3 == 0) {
				var5 = Character.toLowerCase(var5);
			} else if (var3 == 2 || Character.isUpperCase(var5)) {
				var5 = ScriptFrame.method1110(var5);
			}

			if (Character.isLetter(var5)) {
				var3 = 0;
			} else if (var5 != '.' && var5 != '?' && var5 != '!') {
				if (Character.isSpaceChar(var5)) {
					if (var3 != 2) {
						var3 = 1;
					}
				} else {
					var3 = 1;
				}
			} else {
				var3 = 2;
			}

			var2[var4] = var5;
		}

		return new String(var2);
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(Ljava/net/Socket;III)Lky;",
		garbageValue = "62058076"
	)
	public static AbstractSocket method5215(Socket var0, int var1, int var2) throws IOException {
		return new BufferedNetSocket(var0, var1, var2);
	}

	@ObfuscatedName("kt")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-16"
	)
	static void method5211() {
		for (InterfaceParent var0 = (InterfaceParent)Client.interfaceParents.first(); var0 != null; var0 = (InterfaceParent)Client.interfaceParents.next()) {
			int var1 = var0.group;
			if (MusicPatch.loadInterface(var1)) {
				boolean var2 = true;
				Widget[] var3 = UserComparator7.Widget_interfaceComponents[var1];

				int var4;
				for (var4 = 0; var4 < var3.length; ++var4) {
					if (var3[var4] != null) {
						var2 = var3[var4].isIf3;
						break;
					}
				}

				if (!var2) {
					var4 = (int)var0.key;
					Widget var5 = Tile.getWidget(var4);
					if (var5 != null) {
						LoginPacket.invalidateWidget(var5);
					}
				}
			}
		}

	}
}
