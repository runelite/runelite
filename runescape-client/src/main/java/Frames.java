import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1087061465
   )
   public static int field1569;
   @ObfuscatedName("p")
   Frame[] field1570;
   @ObfuscatedName("g")
   static class182 field1571;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1916080975"
   )
   public boolean method1897(int var1) {
      return this.field1570[var1].field1325;
   }

   Frames(class182 var1, class182 var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.method3309(var3);
      this.field1570 = new Frame[var6];
      int[] var7 = var1.method3280(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.getConfigData(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.method2412(); var12 != null; var12 = (FrameMap)var5.method2426()) {
            if(var11 == var12.field1465) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13;
            if(var4) {
               var13 = var2.method3344(0, var11);
            } else {
               var13 = var2.method3344(var11, 0);
            }

            var10 = new FrameMap(var11, var13);
            var5.method2407(var10);
         }

         this.field1570[var7[var8]] = new Frame(var9, var10);
      }

   }
}
