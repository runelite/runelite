import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cg")
public final class class80 extends class79 {
   @ObfuscatedName("d")
   public int field1419;
   @ObfuscatedName("c")
   public int field1420;
   @ObfuscatedName("y")
   public int field1421;
   @ObfuscatedName("a")
   public byte[] field1422;
   @ObfuscatedName("w")
   public int[] field1423;
   @ObfuscatedName("k")
   public int field1424;
   @ObfuscatedName("r")
   public int field1425;
   @ObfuscatedName("p")
   public int field1426;

   @ObfuscatedName("c")
   static void method1960(int[] var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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

   @ObfuscatedName("w")
   public void method1961(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1423.length; ++var4) {
         int var5 = this.field1423[var4] >> 16 & 255;
         var5 += var1;
         if(var5 < 0) {
            var5 = 0;
         } else if(var5 > 255) {
            var5 = 255;
         }

         int var6 = this.field1423[var4] >> 8 & 255;
         var6 += var2;
         if(var6 < 0) {
            var6 = 0;
         } else if(var6 > 255) {
            var6 = 255;
         }

         int var7 = this.field1423[var4] & 255;
         var7 += var3;
         if(var7 < 0) {
            var7 = 0;
         } else if(var7 > 255) {
            var7 = 255;
         }

         this.field1423[var4] = (var5 << 16) + (var6 << 8) + var7;
      }

   }

   @ObfuscatedName("d")
   public void method1962(int var1, int var2) {
      var1 += this.field1421;
      var2 += this.field1424;
      int var3 = var1 + var2 * class79.field1417;
      int var4 = 0;
      int var5 = this.field1420;
      int var6 = this.field1419;
      int var7 = class79.field1417 - var6;
      int var8 = 0;
      int var9;
      if(var2 < class79.field1415) {
         var9 = class79.field1415 - var2;
         var5 -= var9;
         var2 = class79.field1415;
         var4 += var9 * var6;
         var3 += var9 * class79.field1417;
      }

      if(var2 + var5 > class79.field1416) {
         var5 -= var2 + var5 - class79.field1416;
      }

      if(var1 < class79.field1412) {
         var9 = class79.field1412 - var1;
         var6 -= var9;
         var1 = class79.field1412;
         var4 += var9;
         var3 += var9;
         var8 += var9;
         var7 += var9;
      }

      if(var1 + var6 > class79.field1418) {
         var9 = var1 + var6 - class79.field1418;
         var6 -= var9;
         var8 += var9;
         var7 += var9;
      }

      if(var6 > 0 && var5 > 0) {
         method1960(class79.field1413, this.field1422, this.field1423, var4, var3, var6, var5, var7, var8);
      }
   }

   @ObfuscatedName("a")
   public void method1967() {
      if(this.field1419 != this.field1425 || this.field1420 != this.field1426) {
         byte[] var1 = new byte[this.field1425 * this.field1426];
         int var2 = 0;

         for(int var3 = 0; var3 < this.field1420; ++var3) {
            for(int var4 = 0; var4 < this.field1419; ++var4) {
               var1[var4 + this.field1421 + (var3 + this.field1424) * this.field1425] = this.field1422[var2++];
            }
         }

         this.field1422 = var1;
         this.field1419 = this.field1425;
         this.field1420 = this.field1426;
         this.field1421 = 0;
         this.field1424 = 0;
      }
   }
}
