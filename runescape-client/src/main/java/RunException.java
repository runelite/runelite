import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("mo")
@Implements("RunException")
public class RunException extends RuntimeException {
	@ObfuscatedName("c")
	@Export("RunException_applet")
	public static Applet RunException_applet;
	@ObfuscatedName("o")
	@Export("localPlayerName")
	public static String localPlayerName;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 83275543
	)
	@Export("clientType")
	public static int clientType;
	@ObfuscatedName("g")
	@Export("message")
	String message;
	@ObfuscatedName("d")
	@Export("throwable")
	Throwable throwable;

	RunException(Throwable var1, String var2) {
		this.message = var2;
		this.throwable = var1;
	}
}
