import java.io.DataInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class3 implements Enumerated {
	@ObfuscatedName("qt")
	@ObfuscatedGetter(
		intValue = 112869376
	)
	static int field24;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lk;"
	)
	static final class3 field19;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lk;"
	)
	static final class3 field14;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lk;"
	)
	static final class3 field15;
	@ObfuscatedName("f")
	@Export("Tiles_saturation")
	static int[] Tiles_saturation;
	@ObfuscatedName("ay")
	@Export("hasFocus")
	protected static boolean hasFocus;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 244177539
	)
	final int field16;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 950508435
	)
	public final int field18;
	@ObfuscatedName("n")
	public final Class field29;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Ls;"
	)
	public final class0 field13;

	static {
		field19 = new class3(2, 0, Integer.class, new class1());
		field14 = new class3(0, 1, Long.class, new class2());
		field15 = new class3(1, 2, String.class, new class4());
	}

	@ObfuscatedSignature(
		signature = "(IILjava/lang/Class;Ls;)V"
	)
	class3(int var1, int var2, Class var3, class0 var4) {
		this.field16 = var1;
		this.field18 = var2;
		this.field29 = var3;
		this.field13 = var4;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-32"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field18;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lky;I)Ljava/lang/Object;",
		garbageValue = "982910801"
	)
	public Object method43(Buffer var1) {
		return this.field13.vmethod70(var1);
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
		garbageValue = "1743466142"
	)
	@Export("RunException_sendStackTrace")
	public static void RunException_sendStackTrace(String var0, Throwable var1) {
		if (var1 != null) {
			var1.printStackTrace();
		} else {
			try {
				String var2 = "";
				if (var1 != null) {
					var2 = WallDecoration.shortenStackTrace(var1);
				}

				if (var0 != null) {
					if (var1 != null) {
						var2 = var2 + " | ";
					}

					var2 = var2 + var0;
				}

				System.out.println("Error: " + var2);
				var2 = var2.replace(':', '.');
				var2 = var2.replace('@', '_');
				var2 = var2.replace('&', '_');
				var2 = var2.replace('#', '_');
				if (RunException.RunException_applet == null) {
					return;
				}

				URL var3 = new URL(RunException.RunException_applet.getCodeBase(), "clienterror.ws?c=" + class208.RunException_revision + "&u=" + RunException.localPlayerName + "&v1=" + TaskHandler.javaVendor + "&v2=" + TaskHandler.javaVersion + "&ct=" + GZipDecompressor.field4007 + "&e=" + var2);
				DataInputStream var4 = new DataInputStream(var3.openStream());
				var4.read();
				var4.close();
			} catch (Exception var5) {
			}

		}
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)[Lk;",
		garbageValue = "-69"
	)
	public static class3[] method44() {
		return new class3[]{field15, field19, field14};
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Z",
		garbageValue = "-1165508811"
	)
	@Export("isValidURL")
	static boolean isValidURL(String var0) {
		if (var0 == null) {
			return false;
		} else {
			try {
				new URL(var0);
				return true;
			} catch (MalformedURLException var2) {
				return false;
			}
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "68"
	)
	static final void method53() {
		Object var10000 = null;
		String var0 = "Your friend list is full. Max of 200 for free users, and 400 for members";
		DirectByteArrayCopier.addGameMessage(30, "", var0);
	}

	@ObfuscatedName("kz")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1569353890"
	)
	@Export("FriendSystem_invalidateFriends")
	static final void FriendSystem_invalidateFriends() {
		for (int var0 = 0; var0 < Players.Players_count; ++var0) {
			Player var1 = Client.players[Players.Players_indices[var0]];
			var1.clearIsFriend();
		}

		LoginScreenAnimation.method1758();
		if (Client.clanChat != null) {
			Client.clanChat.clearFriends();
		}

	}
}
