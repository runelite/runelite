import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("cf")
public class class100 {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;B)Ljava/lang/Object;",
      garbageValue = "58"
   )
   public static Object method1901(Applet var0, String var1) throws Throwable {
      return JSObject.getWindow(var0).call(var1, (Object[])null);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;[Ljava/lang/Object;B)Ljava/lang/Object;",
      garbageValue = "127"
   )
   public static Object method1902(Applet var0, String var1, Object[] var2) throws Throwable {
      return JSObject.getWindow(var0).call(var1, var2);
   }
}
