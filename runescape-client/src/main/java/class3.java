import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
final class class3 implements class0 {
   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("indexTrack2")
   static IndexData indexTrack2;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2109150793
   )
   public static int field22;

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      signature = "(Lhn;I)Lhn;",
      garbageValue = "-1088218912"
   )
   static Widget method6(Widget var0) {
      int var2 = class169.getWidgetConfig(var0);
      int var1 = var2 >> 17 & 7;
      int var3 = var1;
      if(var1 == 0) {
         return null;
      } else {
         for(int var4 = 0; var4 < var3; ++var4) {
            var0 = WallObject.method2901(var0.parentId);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }
}
