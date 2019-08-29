import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("mv")
@Implements("RunException")
public class RunException extends RuntimeException {
	@ObfuscatedName("s")
	@Export("RunException_applet")
	public static Applet RunException_applet;
	@ObfuscatedName("j")
	@Export("localPlayerName")
	public static String localPlayerName;
	@ObfuscatedName("u")
	@Export("message")
	String message;
	@ObfuscatedName("n")
	@Export("throwable")
	Throwable throwable;

	RunException(Throwable var1, String var2) {
		this.message = var2;
		this.throwable = var1;
	}
}
