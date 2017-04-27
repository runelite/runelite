import java.awt.Canvas;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
public class class65 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 264024161
   )
   int field1087;
   @ObfuscatedName("qz")
   @Export("canvas")
   public static Canvas canvas;
   @ObfuscatedName("p")
   int[][] field1090;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1145977587
   )
   int field1094;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "2053233760"
   )
   byte[] method1185(byte[] var1) {
      if(this.field1090 != null) {
         int var2 = (int)((long)this.field1094 * (long)var1.length / (long)this.field1087) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1090[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var7 * var8[var9];
            }

            var5 += this.field1094;
            var9 = var5 / this.field1087;
            var4 += var9;
            var5 -= var9 * this.field1087;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = var3[var6] + '耀' >> 16;
            if(var10 < -128) {
               var1[var6] = -128;
            } else if(var10 > 127) {
               var1[var6] = 127;
            } else {
               var1[var6] = (byte)var10;
            }
         }
      }

      return var1;
   }

   public class65(int var1, int var2) {
      if(var2 != var1) {
         int var3 = class61.method1174(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.field1087 = var1;
         this.field1094 = var2;
         this.field1090 = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.field1090[var4];
            double var6 = (double)var4 / (double)var1 + 6.0D;
            int var8 = (int)Math.floor(1.0D + (var6 - 7.0D));
            if(var8 < 0) {
               var8 = 0;
            }

            int var9 = (int)Math.ceil(7.0D + var6);
            if(var9 > 14) {
               var9 = 14;
            }

            for(double var10 = (double)var2 / (double)var1; var8 < var9; ++var8) {
               double var12 = ((double)var8 - var6) * 3.141592653589793D;
               double var14 = var10;
               if(var12 < -1.0E-4D || var12 > 1.0E-4D) {
                  var14 = var10 * (Math.sin(var12) / var12);
               }

               var14 *= 0.54D + 0.46D * Math.cos(((double)var8 - var6) * 0.2243994752564138D);
               var5[var8] = (int)Math.floor(65536.0D * var14 + 0.5D);
            }
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1720799014"
   )
   int method1186(int var1) {
      if(this.field1090 != null) {
         var1 = (int)((long)this.field1094 * (long)var1 / (long)this.field1087);
      }

      return var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1005316189"
   )
   int method1187(int var1) {
      if(this.field1090 != null) {
         var1 = (int)((long)this.field1094 * (long)var1 / (long)this.field1087) + 6;
      }

      return var1;
   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(LWidget;B)LWidget;",
      garbageValue = "42"
   )
   static Widget method1189(Widget var0) {
      Widget var1 = class105.method2027(var0);
      if(var1 == null) {
         var1 = var0.dragParent;
      }

      return var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-520987872"
   )
   static final int method1193(int var0, int var1) {
      int var2 = var0 + var1 * 57;
      var2 ^= var2 << 13;
      int var3 = (var2 * var2 * 15731 + 789221) * var2 + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1824884066"
   )
   static final int method1194(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-69"
   )
   static void method1195(Buffer var0) {
      if(Client.field297 != null) {
         var0.putBytes(Client.field297, 0, Client.field297.length);
      } else {
         byte[] var1 = class20.method215();
         var0.putBytes(var1, 0, var1.length);
      }
   }
}
