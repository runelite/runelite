import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -741542225
   )
   @Export("modelHeight")
   public int modelHeight = 1000;
   @ObfuscatedName("pj")
   static short[] field1544;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1358507550"
   )
   public static void method1875(boolean var0) {
      if(class185.field2748 != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.method2912(var0?2:3);
            var1.method2914(0);
            class185.field2748.method2054(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class185.field2748.method2064();
            } catch (Exception var3) {
               ;
            }

            ++class185.field2746;
            class185.field2748 = null;
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "637530507"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("co")
   void vmethod1879(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(null != var10) {
         this.modelHeight = var10.modelHeight;
         var10.vmethod1879(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(IIIS)I",
      garbageValue = "-27277"
   )
   static final int method1883(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class11.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = var6 * class11.tileHeights[var5][var3 + 1][var4] + class11.tileHeights[var5][var3][var4] * (128 - var6) >> 7;
         int var9 = var6 * class11.tileHeights[var5][var3 + 1][1 + var4] + (128 - var6) * class11.tileHeights[var5][var3][var4 + 1] >> 7;
         return var7 * var9 + var8 * (128 - var7) >> 7;
      } else {
         return 0;
      }
   }
}
