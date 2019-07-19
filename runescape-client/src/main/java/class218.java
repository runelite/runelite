import java.applet.Applet;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
public class class218 {
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1717114817
	)
	public static int field2707;

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljava/applet/Applet;Ljava/lang/String;I)V",
		garbageValue = "-1987450780"
	)
	public static void method4110(Applet var0, String var1) {
		class51.applet = var0;
		if (var1 != null) {
			class51.field434 = var1;
		}

	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-205887653"
	)
	public static final boolean method4109() {
		synchronized(KeyHandler.KeyHandler_instance) {
			if (KeyHandler.field385 == KeyHandler.field396) {
				return false;
			} else {
				ReflectionCheck.field1338 = KeyHandler.field400[KeyHandler.field396];
				Calendar.field2508 = KeyHandler.field399[KeyHandler.field396];
				KeyHandler.field396 = KeyHandler.field396 + 1 & 127;
				return true;
			}
		}
	}
}
