import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("bb")
public class class52 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;B)Ljava/lang/Object;",
      garbageValue = "-104"
   )
   public static Object method755(Applet var0, String var1) throws Throwable {
      return JSObject.getWindow(var0).call(var1, (Object[])null);
   }
}
