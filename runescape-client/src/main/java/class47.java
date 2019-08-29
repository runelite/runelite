import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("al")
public class class47 {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Ljava/applet/Applet;Ljava/lang/String;B)V",
		garbageValue = "16"
	)
	public static void method796(Applet var0, String var1) throws Throwable {
		JSObject.getWindow(var0).eval(var1);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Ljava/applet/Applet;Ljava/lang/String;[Ljava/lang/Object;I)Ljava/lang/Object;",
		garbageValue = "-2054466950"
	)
	public static Object method795(Applet var0, String var1, Object[] var2) throws Throwable {
		return JSObject.getWindow(var0).call(var1, var2);
	}
}
