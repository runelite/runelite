import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cr")
@Implements("ModIcon")
public final class class80 extends class79 {
   @ObfuscatedName("c")
   @Export("originalHeight")
   public int field1388;
   @ObfuscatedName("g")
   @Export("palette")
   public int[] field1389;
   @ObfuscatedName("j")
   @Export("originalWidth")
   public int field1390;
   @ObfuscatedName("d")
   @Export("height")
   public int field1391;
   @ObfuscatedName("x")
   @Export("offsetX")
   public int field1392;
   @ObfuscatedName("r")
   @Export("width")
   public int field1393;
   @ObfuscatedName("b")
   @Export("pixels")
   public byte[] field1394;
   @ObfuscatedName("y")
   @Export("offsetY")
   public int field1395;

   @ObfuscatedName("g")
   public void method1866(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1389.length; ++var4) {
         int var5 = this.field1389[var4] >> 16 & 255;
         var5 += var1;
         if(var5 < 0) {
            var5 = 0;
         } else if(var5 > 255) {
            var5 = 255;
         }

         int var6 = this.field1389[var4] >> 8 & 255;
         var6 += var2;
         if(var6 < 0) {
            var6 = 0;
         } else if(var6 > 255) {
            var6 = 255;
         }

         int var7 = this.field1389[var4] & 255;
         var7 += var3;
         if(var7 < 0) {
            var7 = 0;
         } else if(var7 > 255) {
            var7 = 255;
         }

         this.field1389[var4] = (var5 << 16) + (var6 << 8) + var7;
      }

   }

   @ObfuscatedName("b")
   public void method1867() {
      if(this.field1390 != this.field1393 || this.field1391 != this.field1388) {
         byte[] var1 = new byte[this.field1393 * this.field1388];
         int var2 = 0;

         for(int var3 = 0; var3 < this.field1391; ++var3) {
            for(int var4 = 0; var4 < this.field1390; ++var4) {
               var1[var4 + this.field1392 + (var3 + this.field1395) * this.field1393] = this.field1394[var2++];
            }
         }

         this.field1394 = var1;
         this.field1390 = this.field1393;
         this.field1391 = this.field1388;
         this.field1392 = 0;
         this.field1395 = 0;
      }
   }

   @ObfuscatedName("d")
   static void method1870(int[] var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var9 = -(var5 >> 2);
      var5 = -(var5 & 3);

      for(int var10 = -var6; var10 < 0; ++var10) {
         int var11;
         byte var12;
         for(var11 = var9; var11 < 0; ++var11) {
            var12 = var1[var3++];
            if(var12 != 0) {
               var0[var4++] = var2[var12 & 255];
            } else {
               ++var4;
            }

            var12 = var1[var3++];
            if(var12 != 0) {
               var0[var4++] = var2[var12 & 255];
            } else {
               ++var4;
            }

            var12 = var1[var3++];
            if(var12 != 0) {
               var0[var4++] = var2[var12 & 255];
            } else {
               ++var4;
            }

            var12 = var1[var3++];
            if(var12 != 0) {
               var0[var4++] = var2[var12 & 255];
            } else {
               ++var4;
            }
         }

         for(var11 = var5; var11 < 0; ++var11) {
            var12 = var1[var3++];
            if(var12 != 0) {
               var0[var4++] = var2[var12 & 255];
            } else {
               ++var4;
            }
         }

         var4 += var7;
         var3 += var8;
      }

   }

   @ObfuscatedName("j")
   public void method1873(int var1, int var2) {
      var1 += this.field1392;
      var2 += this.field1395;
      int var3 = var1 + var2 * class79.field1382;
      int var4 = 0;
      int var5 = this.field1391;
      int var6 = this.field1390;
      int var7 = class79.field1382 - var6;
      int var8 = 0;
      int var9;
      if(var2 < class79.field1384) {
         var9 = class79.field1384 - var2;
         var5 -= var9;
         var2 = class79.field1384;
         var4 += var9 * var6;
         var3 += var9 * class79.field1382;
      }

      if(var2 + var5 > class79.field1385) {
         var5 -= var2 + var5 - class79.field1385;
      }

      if(var1 < class79.field1386) {
         var9 = class79.field1386 - var1;
         var6 -= var9;
         var1 = class79.field1386;
         var4 += var9;
         var3 += var9;
         var8 += var9;
         var7 += var9;
      }

      if(var1 + var6 > class79.field1381) {
         var9 = var1 + var6 - class79.field1381;
         var6 -= var9;
         var8 += var9;
         var7 += var9;
      }

      if(var6 > 0 && var5 > 0) {
         method1870(class79.field1383, this.field1394, this.field1389, var4, var3, var6, var5, var7, var8);
      }
   }
}
