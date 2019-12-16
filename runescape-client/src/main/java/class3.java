import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class3 implements Enumerated {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lw;"
	)
	public static final class3 field19;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lw;"
	)
	public static final class3 field10;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lw;"
	)
	public static final class3 field9;
	@ObfuscatedName("dc")
	@ObfuscatedSignature(
		signature = "Lif;"
	)
	@Export("archive8")
	static Archive archive8;
	@ObfuscatedName("fg")
	@ObfuscatedSignature(
		signature = "Lko;"
	)
	@Export("fontPlain11")
	static Font fontPlain11;
	@ObfuscatedName("gz")
	@ObfuscatedGetter(
		intValue = 1624533233
	)
	static int field7;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 55070651
	)
	final int field15;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1265968075
	)
	public final int field11;
	@ObfuscatedName("b")
	public final Class field12;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lf;"
	)
	final class0 field13;

	static {
		field19 = new class3(1, 0, Integer.class, new class1());
		field10 = new class3(2, 1, Long.class, new class2());
		field9 = new class3(0, 2, String.class, new class4());
	}

	@ObfuscatedSignature(
		signature = "(IILjava/lang/Class;Lf;)V"
	)
	class3(int var1, int var2, Class var3, class0 var4) {
		this.field15 = var1;
		this.field11 = var2;
		this.field12 = var3;
		this.field13 = var4;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-57"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field11;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Lkq;I)Ljava/lang/Object;",
		garbageValue = "868872918"
	)
	public Object method38(Buffer var1) {
		return this.field13.vmethod60(var1);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;B)I",
		garbageValue = "-26"
	)
	public static int method35(CharSequence var0) {
		int var1 = var0.length();
		int var2 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			char var4 = var0.charAt(var3);
			if (var4 <= 127) {
				++var2;
			} else if (var4 <= 2047) {
				var2 += 2;
			} else {
				var2 += 3;
			}
		}

		return var2;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkq;I)V",
		garbageValue = "911012912"
	)
	public static void method36(Object var0, Buffer var1) {
		Class var3 = var0.getClass();
		class3[] var5 = new class3[]{field19, field9, field10};
		class3[] var6 = var5;
		int var7 = 0;

		class3 var4;
		while (true) {
			if (var7 >= var6.length) {
				var4 = null;
				break;
			}

			class3 var8 = var6[var7];
			if (var3 == var8.field12) {
				var4 = var8;
				break;
			}

			++var7;
		}

		if (var4 == null) {
			throw new IllegalArgumentException();
		} else {
			class0 var2 = var4.field13;
			var2.vmethod53(var0, var1);
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ljava/applet/Applet;Ljava/lang/String;I)V",
		garbageValue = "1416761199"
	)
	public static void method39(Applet var0, String var1) {
		class50.applet = var0;
		if (var1 != null) {
			class50.field410 = var1;
		}

	}

	@ObfuscatedName("gf")
	@ObfuscatedSignature(
		signature = "(Lbv;I)V",
		garbageValue = "-6957395"
	)
	static final void method48(Actor var0) {
		if (var0.field968 != 0) {
			if (var0.targetIndex != -1) {
				Object var1 = null;
				if (var0.targetIndex < 32768) {
					var1 = Client.npcs[var0.targetIndex];
				} else if (var0.targetIndex >= 32768) {
					var1 = Client.players[var0.targetIndex - 32768];
				}

				if (var1 != null) {
					int var2 = var0.x - ((Actor)var1).x;
					int var3 = var0.y - ((Actor)var1).y;
					if (var2 != 0 || var3 != 0) {
						var0.orientation = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
					}
				} else if (var0.false0) {
					var0.targetIndex = -1;
					var0.false0 = false;
				}
			}

			if (var0.field960 != -1 && (var0.pathLength == 0 || var0.field980 > 0)) {
				var0.orientation = var0.field960;
				var0.field960 = -1;
			}

			int var4 = var0.orientation - var0.rotation & 2047;
			if (var4 == 0 && var0.false0) {
				var0.targetIndex = -1;
				var0.false0 = false;
			}

			if (var4 != 0) {
				++var0.field974;
				boolean var6;
				if (var4 > 1024) {
					var0.rotation -= var0.field968;
					var6 = true;
					if (var4 < var0.field968 || var4 > 2048 - var0.field968) {
						var0.rotation = var0.orientation;
						var6 = false;
					}

					if (var0.readySequence == var0.movementSequence && (var0.field974 > 25 || var6)) {
						if (var0.turnLeftSequence != -1) {
							var0.movementSequence = var0.turnLeftSequence;
						} else {
							var0.movementSequence = var0.walkSequence;
						}
					}
				} else {
					var0.rotation += var0.field968;
					var6 = true;
					if (var4 < var0.field968 || var4 > 2048 - var0.field968) {
						var0.rotation = var0.orientation;
						var6 = false;
					}

					if (var0.readySequence == var0.movementSequence && (var0.field974 > 25 || var6)) {
						if (var0.turnRightSequence != -1) {
							var0.movementSequence = var0.turnRightSequence;
						} else {
							var0.movementSequence = var0.walkSequence;
						}
					}
				}

				var0.rotation &= 2047;
			} else {
				var0.field974 = 0;
			}

		}
	}

	@ObfuscatedName("kw")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1387375929"
	)
	@Export("Clan_leaveChat")
	static final void Clan_leaveChat() {
		PacketBufferNode var0 = class2.getPacketBufferNode(ClientPacket.field2259, Client.packetWriter.isaacCipher);
		var0.packetBuffer.writeByte(0);
		Client.packetWriter.addNode(var0);
	}
}
