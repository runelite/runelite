import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ma")
@Implements("RunException")
public class RunException extends RuntimeException {
	@ObfuscatedName("c")
	@Export("RunException_applet")
	public static Applet RunException_applet;
	@ObfuscatedName("x")
	@Export("localPlayerName")
	public static String localPlayerName;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -242879535
	)
	@Export("RunException_revision")
	public static int RunException_revision;
	@ObfuscatedName("u")
	@Export("message")
	String message;
	@ObfuscatedName("j")
	@Export("throwable")
	Throwable throwable;

	RunException(Throwable var1, String var2) {
		this.message = var2;
		this.throwable = var1;
	}
}
