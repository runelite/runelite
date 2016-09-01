import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("eo")
public class class135 {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;B)V",
      garbageValue = "1"
   )
   public static void method2897(Applet var0, String var1) throws Throwable {
      JSObject.getWindow(var0).eval(var1);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;[Ljava/lang/Object;B)Ljava/lang/Object;",
      garbageValue = "0"
   )
   public static Object method2898(Applet var0, String var1, Object[] var2) throws Throwable {
      return JSObject.getWindow(var0).call(var1, var2);
   }
}
