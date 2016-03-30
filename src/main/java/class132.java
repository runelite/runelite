import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import netscape.javascript.JSObject;

@ObfuscatedName("ey")
public class class132 {
   @ObfuscatedName("w")
   public static void method2848(Applet var0, String var1) throws Throwable {
      JSObject.getWindow(var0).eval(var1);
   }

   @ObfuscatedName("x")
   public static Object method2849(Applet var0, String var1, Object[] var2) throws Throwable {
      return JSObject.getWindow(var0).call(var1, var2);
   }
}
