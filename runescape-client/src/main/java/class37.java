import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class37 {
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = -1434387975
   )
   static int field529;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-1631753114"
   )
   static final void method526(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int[] var7 = Region.method2764(var0, var1, var2);
      int[] var8 = Region.method2764(var3, var4, var5);
      Rasterizer2D.drawLine(var7[0], var7[1], var8[0], var8[1], var6);
   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(Lhx;I)Z",
      garbageValue = "-1645496955"
   )
   static final boolean method528(Widget var0) {
      if(var0.tableActions == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.tableActions.length; ++var1) {
            int var2 = GameObject.method2942(var0, var1);
            int var3 = var0.field2772[var1];
            if(var0.tableActions[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1762720937"
   )
   public static void method527() {
      ItemComposition.itemSpriteCache.reset();
   }
}
