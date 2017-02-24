import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
public class class108 {
   class108() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "79297487"
   )
   public static void method2104(class182 var0) {
      Overlay.field3038 = var0;
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "524241330"
   )
   static void method2105(Widget var0) {
      Widget var1 = var0.parentId == -1?null:class179.method3296(var0.parentId);
      int var2;
      int var3;
      if(var1 == null) {
         var2 = class32.field758;
         var3 = class47.field950;
      } else {
         var2 = var1.width;
         var3 = var1.height;
      }

      class140.method2662(var0, var2, var3, false);
      ObjectComposition.method3660(var0, var2, var3);
   }
}
