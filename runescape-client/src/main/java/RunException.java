import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("mf")
@Implements("RunException")
public class RunException extends RuntimeException {
	@ObfuscatedName("x")
	@Export("RunException_applet")
	public static Applet RunException_applet;
	@ObfuscatedName("m")
	@Export("localPlayerName")
	public static String localPlayerName;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 858852849
	)
	@Export("RunException_revision")
	public static int RunException_revision;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -834136847
	)
	@Export("clientType")
	public static int clientType;
	@ObfuscatedName("q")
	@Export("ByteArrayPool_alternativeSizes")
	public static int[] ByteArrayPool_alternativeSizes;
	@ObfuscatedName("w")
	@Export("message")
	String message;
	@ObfuscatedName("v")
	@Export("throwable")
	Throwable throwable;

	RunException(Throwable var1, String var2) {
		this.message = var2;
		this.throwable = var1;
	}
}
