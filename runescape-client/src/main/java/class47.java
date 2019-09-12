import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("az")
public class class47 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/applet/Applet;Ljava/lang/String;I)Ljava/lang/Object;",
		garbageValue = "606173703"
	)
	public static Object method812(Applet var0, String var1) throws Throwable {
		return JSObject.getWindow(var0).call(var1, (Object[])null);
	}
}
