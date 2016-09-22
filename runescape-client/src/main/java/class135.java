import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("eb")
public class class135 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;S)Ljava/lang/Object;",
      garbageValue = "-14074"
   )
   public static Object method2889(Applet var0, String var1) throws Throwable {
      return JSObject.getWindow(var0).call(var1, (Object[])null);
   }
}
