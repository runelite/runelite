import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
public class class245 {
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1759871724"
   )
   public static void method4509(boolean var0) {
      if(var0 != ItemComposition.isMembersWorld) {
         ItemComposition.items.reset();
         ItemComposition.itemModelCache.reset();
         ItemComposition.itemSpriteCache.reset();
         ItemComposition.isMembersWorld = var0;
      }

   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "124"
   )
   static final void method4508(int var0) {
      if(class2.loadWidget(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2899 = 0;
               var3.field2800 = 0;
            }
         }

      }
   }
}
