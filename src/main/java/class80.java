import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ch")
public final class class80 extends class79 {
   @ObfuscatedName("j")
   public byte[] field1429;
   @ObfuscatedName("m")
   public int field1430;
   @ObfuscatedName("a")
   public int field1431;
   @ObfuscatedName("l")
   public int[] field1432;
   @ObfuscatedName("f")
   public int field1433;
   @ObfuscatedName("i")
   public int field1434;
   @ObfuscatedName("o")
   public int field1435;
   @ObfuscatedName("h")
   public int field1436;

   @ObfuscatedName("l")
   public void method1830(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1432.length; ++var4) {
         int var5 = this.field1432[var4] >> 16 & 255;
         var5 += var1;
         if(var5 < 0) {
            var5 = 0;
         } else if(var5 > 255) {
            var5 = 255;
         }

         int var6 = this.field1432[var4] >> 8 & 255;
         var6 += var2;
         if(var6 < 0) {
            var6 = 0;
         } else if(var6 > 255) {
            var6 = 255;
         }

         int var7 = this.field1432[var4] & 255;
         var7 += var3;
         if(var7 < 0) {
            var7 = 0;
         } else if(var7 > 255) {
            var7 = 255;
         }

         this.field1432[var4] = (var5 << 16) + (var6 << 8) + var7;
      }

   }

   @ObfuscatedName("j")
   public void method1831() {
      if(this.field1431 != this.field1435 || this.field1434 != this.field1436) {
         byte[] var1 = new byte[this.field1435 * this.field1436];
         int var2 = 0;

         for(int var3 = 0; var3 < this.field1434; ++var3) {
            for(int var4 = 0; var4 < this.field1431; ++var4) {
               var1[var4 + this.field1433 + (var3 + this.field1430) * this.field1435] = this.field1429[var2++];
            }
         }

         this.field1429 = var1;
         this.field1431 = this.field1435;
         this.field1434 = this.field1436;
         this.field1433 = 0;
         this.field1430 = 0;
      }
   }

   @ObfuscatedName("i")
   static void method1832(int[] var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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
   public void method1838(int var1, int var2) {
      var1 += this.field1433;
      var2 += this.field1430;
      int var3 = var1 + var2 * class79.field1423;
      int var4 = 0;
      int var5 = this.field1434;
      int var6 = this.field1431;
      int var7 = class79.field1423 - var6;
      int var8 = 0;
      int var9;
      if(var2 < class79.field1425) {
         var9 = class79.field1425 - var2;
         var5 -= var9;
         var2 = class79.field1425;
         var4 += var9 * var6;
         var3 += var9 * class79.field1423;
      }

      if(var2 + var5 > class79.field1422) {
         var5 -= var2 + var5 - class79.field1422;
      }

      if(var1 < class79.field1427) {
         var9 = class79.field1427 - var1;
         var6 -= var9;
         var1 = class79.field1427;
         var4 += var9;
         var3 += var9;
         var8 += var9;
         var7 += var9;
      }

      if(var1 + var6 > class79.field1428) {
         var9 = var1 + var6 - class79.field1428;
         var6 -= var9;
         var8 += var9;
         var7 += var9;
      }

      if(var6 > 0 && var5 > 0) {
         method1832(class79.field1426, this.field1429, this.field1432, var4, var3, var6, var5, var7, var8);
      }
   }
}
