import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("bw")
public class class53 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;I)V",
      garbageValue = "1008043309"
   )
   public static void method813(Applet var0, String var1) throws Throwable {
      JSObject.getWindow(var0).eval(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;[Ljava/lang/Object;I)Ljava/lang/Object;",
      garbageValue = "1825166945"
   )
   public static Object method815(Applet var0, String var1, Object[] var2) throws Throwable {
      return JSObject.getWindow(var0).call(var1, var2);
   }
}
