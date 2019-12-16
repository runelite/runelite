import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("mg")
@Implements("RunException")
public class RunException extends RuntimeException {
	@ObfuscatedName("f")
	@Export("RunException_applet")
	public static Applet RunException_applet;
	@ObfuscatedName("i")
	@Export("localPlayerName")
	public static String localPlayerName;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1500109333
	)
	@Export("RunException_revision")
	public static int RunException_revision;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -706960701
	)
	@Export("clientType")
	public static int clientType;
	@ObfuscatedName("p")
	@Export("message")
	String message;
	@ObfuscatedName("b")
	@Export("throwable")
	Throwable throwable;

	RunException(Throwable var1, String var2) {
		this.message = var2;
		this.throwable = var1;
	}
}
