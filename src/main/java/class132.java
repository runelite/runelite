import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import netscape.javascript.JSObject;

@ObfuscatedName("ek")
public class class132 {
   @ObfuscatedName("e")
   public static Object method2836(Applet var0, String var1) throws Throwable {
      return JSObject.getWindow(var0).call(var1, (Object[])null);
   }

   @ObfuscatedName("w")
   public static Object method2837(Applet var0, String var1, Object[] var2) throws Throwable {
      return JSObject.getWindow(var0).call(var1, var2);
   }
}
