import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mf")
@Implements("RunException")
public class RunException extends RuntimeException {
	@ObfuscatedName("z")
	@Export("RunException_applet")
	public static Applet RunException_applet;
	@ObfuscatedName("n")
	@Export("localPlayerName")
	public static String localPlayerName;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1228960845
	)
	@Export("RunException_revision")
	public static int RunException_revision;
	@ObfuscatedName("q")
	@Export("SpriteBuffer_spriteHeights")
	public static int[] SpriteBuffer_spriteHeights;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Ldn;"
	)
	@Export("soundSystem")
	static SoundSystem soundSystem;
	@ObfuscatedName("r")
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
