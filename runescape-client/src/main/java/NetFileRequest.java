import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
@Implements("NetFileRequest")
public class NetFileRequest extends DualNode {
	@ObfuscatedName("cv")
	@Export("mouseCam")
	static boolean mouseCam;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lif;"
	)
	@Export("archive")
	public Archive archive;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1793018397
	)
	@Export("crc")
	public int crc;
	@ObfuscatedName("y")
	@Export("padding")
	public byte padding;

	NetFileRequest() {
	}

	@ObfuscatedName("kz")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
		garbageValue = "1995619175"
	)
	static String method4121(String var0, boolean var1) {
		String var2 = var1 ? "https://" : "http://";
		if (Client.gameBuild == 1) {
			var0 = var0 + "-wtrc";
		} else if (Client.gameBuild == 2) {
			var0 = var0 + "-wtqa";
		} else if (Client.gameBuild == 3) {
			var0 = var0 + "-wtwip";
		} else if (Client.gameBuild == 5) {
			var0 = var0 + "-wti";
		} else if (Client.gameBuild == 4) {
			var0 = "local";
		}

		String var3 = "";
		if (UserComparator10.field1943 != null) {
			var3 = "/p=" + UserComparator10.field1943;
		}

		String var4 = "runescape.com";
		return var2 + var0 + "." + var4 + "/l=" + Varps.clientLanguage + "/a=" + MouseRecorder.field564 + var3 + "/";
	}
}
