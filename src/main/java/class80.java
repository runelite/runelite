import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cj")
public final class class80 extends class79 {
   @ObfuscatedName("m")
   public int field1416;
   @ObfuscatedName("s")
   public int field1417;
   @ObfuscatedName("f")
   public int field1418;
   @ObfuscatedName("y")
   public int field1419;
   @ObfuscatedName("r")
   public int[] field1420;
   @ObfuscatedName("e")
   public int field1421;
   @ObfuscatedName("g")
   public int field1422;
   @ObfuscatedName("a")
   public byte[] field1423;

   @ObfuscatedName("r")
   public void method1882(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1420.length; ++var4) {
         int var5 = this.field1420[var4] >> 16 & 255;
         var5 += var1;
         if(var5 < 0) {
            var5 = 0;
         } else if(var5 > 255) {
            var5 = 255;
         }

         int var6 = this.field1420[var4] >> 8 & 255;
         var6 += var2;
         if(var6 < 0) {
            var6 = 0;
         } else if(var6 > 255) {
            var6 = 255;
         }

         int var7 = this.field1420[var4] & 255;
         var7 += var3;
         if(var7 < 0) {
            var7 = 0;
         } else if(var7 > 255) {
            var7 = 255;
         }

         this.field1420[var4] = (var5 << 16) + (var6 << 8) + var7;
      }

   }

   @ObfuscatedName("f")
   public void method1883(int var1, int var2) {
      var1 += this.field1419;
      var2 += this.field1421;
      int var3 = var1 + var2 * class79.field1412;
      int var4 = 0;
      int var5 = this.field1417;
      int var6 = this.field1418;
      int var7 = class79.field1412 - var6;
      int var8 = 0;
      int var9;
      if(var2 < class79.field1409) {
         var9 = class79.field1409 - var2;
         var5 -= var9;
         var2 = class79.field1409;
         var4 += var9 * var6;
         var3 += var9 * class79.field1412;
      }

      if(var2 + var5 > class79.field1413) {
         var5 -= var2 + var5 - class79.field1413;
      }

      if(var1 < class79.field1414) {
         var9 = class79.field1414 - var1;
         var6 -= var9;
         var1 = class79.field1414;
         var4 += var9;
         var3 += var9;
         var8 += var9;
         var7 += var9;
      }

      if(var1 + var6 > class79.field1415) {
         var9 = var1 + var6 - class79.field1415;
         var6 -= var9;
         var8 += var9;
         var7 += var9;
      }

      if(var6 > 0 && var5 > 0) {
         method1889(class79.field1410, this.field1423, this.field1420, var4, var3, var6, var5, var7, var8);
      }
   }

   @ObfuscatedName("s")
   static void method1889(int[] var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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

   @ObfuscatedName("a")
   public void method1891() {
      if(this.field1418 != this.field1422 || this.field1417 != this.field1416) {
         byte[] var1 = new byte[this.field1422 * this.field1416];
         int var2 = 0;

         for(int var3 = 0; var3 < this.field1417; ++var3) {
            for(int var4 = 0; var4 < this.field1418; ++var4) {
               var1[var4 + this.field1419 + (var3 + this.field1421) * this.field1422] = this.field1423[var2++];
            }
         }

         this.field1423 = var1;
         this.field1418 = this.field1422;
         this.field1417 = this.field1416;
         this.field1419 = 0;
         this.field1421 = 0;
      }
   }
}
