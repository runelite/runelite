import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("mr")
@Implements("RunException")
public class RunException extends RuntimeException {
	@ObfuscatedName("u")
	@Export("RunException_applet")
	public static Applet RunException_applet;
	@ObfuscatedName("f")
	@Export("localPlayerName")
	public static String localPlayerName;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -177601011
	)
	@Export("RunException_revision")
	public static int RunException_revision;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -768179773
	)
	@Export("clientType")
	public static int clientType;
	@ObfuscatedName("z")
	@Export("message")
	String message;
	@ObfuscatedName("p")
	@Export("throwable")
	Throwable throwable;

	RunException(Throwable var1, String var2) {
		this.message = var2;
		this.throwable = var1;
	}
}
