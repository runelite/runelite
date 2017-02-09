import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("cq")
public class class100 {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;I)Ljava/lang/Object;",
      garbageValue = "802655564"
   )
   public static Object method1929(Applet var0, String var1) throws Throwable {
      return JSObject.getWindow(var0).call(var1, (Object[])null);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;[Ljava/lang/Object;I)Ljava/lang/Object;",
      garbageValue = "144006311"
   )
   public static Object method1930(Applet var0, String var1, Object[] var2) throws Throwable {
      return JSObject.getWindow(var0).call(var1, var2);
   }

   class100() throws Throwable {
      throw new Error();
   }
}
