import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("mf")
@Implements("RunException")
public class RunException extends RuntimeException {
	@ObfuscatedName("a")
	@Export("RunException_applet")
	public static Applet RunException_applet;
	@ObfuscatedName("n")
	@Export("localPlayerName")
	public static String localPlayerName;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 2085181929
	)
	@Export("RunException_revision")
	public static int RunException_revision;
	@ObfuscatedName("l")
	@Export("message")
	String message;
	@ObfuscatedName("c")
	@Export("throwable")
	Throwable throwable;

	RunException(Throwable var1, String var2) {
		this.message = var2;
		this.throwable = var1;
	}
}
