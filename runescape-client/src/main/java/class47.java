import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("ay")
public class class47 {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljava/applet/Applet;Ljava/lang/String;I)Ljava/lang/Object;",
		garbageValue = "1388321520"
	)
	public static Object method864(Applet var0, String var1) throws Throwable {
		return JSObject.getWindow(var0).call(var1, (Object[])null);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ljava/applet/Applet;Ljava/lang/String;[Ljava/lang/Object;I)Ljava/lang/Object;",
		garbageValue = "1922524077"
	)
	public static Object method865(Applet var0, String var1, Object[] var2) throws Throwable {
		return JSObject.getWindow(var0).call(var1, var2);
	}
}
