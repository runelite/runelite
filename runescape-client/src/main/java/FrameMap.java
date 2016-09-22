import java.awt.FontMetrics;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -849049467
   )
   int field1843;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1276094125
   )
   int field1844;
   @ObfuscatedName("bf")
   static FontMetrics field1845;
   @ObfuscatedName("r")
   int[][] field1846;
   @ObfuscatedName("v")
   int[] field1847;

   FrameMap(int var1, byte[] var2) {
      this.field1843 = var1;
      Buffer var3 = new Buffer(var2);
      this.field1844 = var3.method2528();
      this.field1847 = new int[this.field1844];
      this.field1846 = new int[this.field1844][];

      int var4;
      for(var4 = 0; var4 < this.field1844; ++var4) {
         this.field1847[var4] = var3.method2528();
      }

      for(var4 = 0; var4 < this.field1844; ++var4) {
         this.field1846[var4] = new int[var3.method2528()];
      }

      for(var4 = 0; var4 < this.field1844; ++var4) {
         for(int var5 = 0; var5 < this.field1846[var4].length; ++var5) {
            this.field1846[var4][var5] = var3.method2528();
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)Z",
      garbageValue = "-1751100555"
   )
   static boolean method2303(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  return false;
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               return false;
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var1 * var5 + var10;
            if(var5 != var9 / var1) {
               return false;
            }

            var5 = var9;
            var4 = true;
         }

         return var4;
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-3"
   )
   static final boolean method2304(char var0) {
      return var0 == 160 || var0 == 32 || var0 == 95 || var0 == 45;
   }
}
