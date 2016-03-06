import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import netscape.javascript.JSObject;

@ObfuscatedName("et")
public class class131 {
   @ObfuscatedName("j")
   public static void method2775(Applet var0, String var1) throws Throwable {
      JSObject.getWindow(var0).eval(var1);
   }

   @ObfuscatedName("l")
   public static Object method2776(Applet var0, String var1) throws Throwable {
      return JSObject.getWindow(var0).call(var1, (Object[])null);
   }
}
