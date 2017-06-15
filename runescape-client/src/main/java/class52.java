import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("bg")
public class class52 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;[Ljava/lang/Object;B)Ljava/lang/Object;",
      garbageValue = "-29"
   )
   public static Object method733(Applet var0, String var1, Object[] var2) throws Throwable {
      return JSObject.getWindow(var0).call(var1, var2);
   }
}
