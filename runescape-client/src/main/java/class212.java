import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class class212 {
   @ObfuscatedName("gv")
   public static final int[] field3144 = new int[]{0, 0, 0, 10, 7, 0, 0, 0, 0, 8, 3, 6, 4, 0, 2, 4, 0, 2, 0, 0, 0, 4, 4, 0, -2, 0, 6, 0, 0, 12, 0, 0, 0, -2, 8, -2, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 8, -1, 0, 0, -2, 0, -2, 0, 0, 0, 0, 0, -1, 0, 6, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 5, 0, 0, 7, 0, 0, 2, 0, 6, 0, -2, 0, -2, -2, 0, 1, 0, -2, 0, 1, 0, 6, 0, 14, 0, 0, -2, 0, 0, 0, -2, 0, 0, -1, 0, -2, 0, 0, 0, 0, 0, 0, 0, 20, 0, 3, 0, 0, 0, 0, 0, 0, 6, 0, 0, 2, 0, 0, 2, 0, -1, 2, 10, 0, -2, 1, 0, 0, 0, 6, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 15, 0, 0, 6, 0, 0, 6, 2, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 2, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 6, 4, 0, 0, 0, 0, -2, 28, 2, 0, 0, 0, 0, 0, -1, 0, 0, 4, 0, 0, 0, 0, 0, 6, 6, 0, 0, 0};
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = 1536484391
   )
   @Export("menuHeight")
   static int menuHeight;

   class212() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-298070329"
   )
   static final void method4061() {
      for(class33 var0 = (class33)Client.field418.method2472(); null != var0; var0 = (class33)Client.field418.method2479()) {
         if(class156.plane == var0.field737 && !var0.field747) {
            if(Client.gameCycle >= var0.field736) {
               var0.method757(Client.field477);
               if(var0.field747) {
                  var0.unlink();
               } else {
                  Varbit.region.method1838(var0.field737, var0.field738, var0.field739, var0.field740, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.unlink();
         }
      }

   }
}
