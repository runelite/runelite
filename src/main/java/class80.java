import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cr")
public final class class80 extends class79 {
   @ObfuscatedName("z")
   public int field1401;
   @ObfuscatedName("j")
   public byte[] field1402;
   @ObfuscatedName("m")
   public int field1403;
   @ObfuscatedName("e")
   public int field1404;
   @ObfuscatedName("h")
   public int[] field1405;
   @ObfuscatedName("x")
   public int field1406;
   @ObfuscatedName("i")
   public int field1407;
   @ObfuscatedName("c")
   public int field1408;

   @ObfuscatedName("h")
   public void method1856(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1405.length; ++var4) {
         int var5 = this.field1405[var4] >> 16 & 255;
         var5 += var1;
         if(var5 < 0) {
            var5 = 0;
         } else if(var5 > 255) {
            var5 = 255;
         }

         int var6 = this.field1405[var4] >> 8 & 255;
         var6 += var2;
         if(var6 < 0) {
            var6 = 0;
         } else if(var6 > 255) {
            var6 = 255;
         }

         int var7 = this.field1405[var4] & 255;
         var7 += var3;
         if(var7 < 0) {
            var7 = 0;
         } else if(var7 > 255) {
            var7 = 255;
         }

         this.field1405[var4] = (var5 << 16) + (var6 << 8) + var7;
      }

   }

   @ObfuscatedName("j")
   public void method1857() {
      if(this.field1403 != this.field1407 || this.field1401 != this.field1408) {
         byte[] var1 = new byte[this.field1407 * this.field1408];
         int var2 = 0;

         for(int var3 = 0; var3 < this.field1401; ++var3) {
            for(int var4 = 0; var4 < this.field1403; ++var4) {
               var1[var4 + this.field1406 + (var3 + this.field1404) * this.field1407] = this.field1402[var2++];
            }
         }

         this.field1402 = var1;
         this.field1403 = this.field1407;
         this.field1401 = this.field1408;
         this.field1406 = 0;
         this.field1404 = 0;
      }
   }

   @ObfuscatedName("z")
   static void method1860(int[] var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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

   @ObfuscatedName("m")
   public void method1867(int var1, int var2) {
      var1 += this.field1406;
      var2 += this.field1404;
      int var3 = var1 + var2 * class79.field1397;
      int var4 = 0;
      int var5 = this.field1401;
      int var6 = this.field1403;
      int var7 = class79.field1397 - var6;
      int var8 = 0;
      int var9;
      if(var2 < class79.field1400) {
         var9 = class79.field1400 - var2;
         var5 -= var9;
         var2 = class79.field1400;
         var4 += var9 * var6;
         var3 += var9 * class79.field1397;
      }

      if(var2 + var5 > class79.field1395) {
         var5 -= var2 + var5 - class79.field1395;
      }

      if(var1 < class79.field1399) {
         var9 = class79.field1399 - var1;
         var6 -= var9;
         var1 = class79.field1399;
         var4 += var9;
         var3 += var9;
         var8 += var9;
         var7 += var9;
      }

      if(var1 + var6 > class79.field1394) {
         var9 = var1 + var6 - class79.field1394;
         var6 -= var9;
         var8 += var9;
         var7 += var9;
      }

      if(var6 > 0 && var5 > 0) {
         method1860(class79.field1398, this.field1402, this.field1405, var4, var3, var6, var5, var7, var8);
      }
   }
}
