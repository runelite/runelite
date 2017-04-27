import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
public class class124 {
   @ObfuscatedName("u")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "-2112317716"
   )
   static void method2350(Widget var0) {
      if(var0.field2339 == Client.field385) {
         Client.field368[var0.boundsIndex] = true;
      }

   }

   class124() throws Throwable {
      throw new Error();
   }

   static {
      new HashMap();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2006745568"
   )
   public static int method2352(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }
}
