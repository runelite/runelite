import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cz")
public final class class80 extends class79 {
   @ObfuscatedName("e")
   public byte[] field1389;
   @ObfuscatedName("f")
   public int field1390;
   @ObfuscatedName("s")
   public int field1391;
   @ObfuscatedName("a")
   public int field1392;
   @ObfuscatedName("p")
   public int field1393;
   @ObfuscatedName("h")
   public int field1394;
   @ObfuscatedName("g")
   public int field1395;
   @ObfuscatedName("w")
   public int[] field1396;

   @ObfuscatedName("e")
   public void method1870() {
      if(this.field1390 != this.field1395 || this.field1391 != this.field1392) {
         byte[] var1 = new byte[this.field1395 * this.field1392];
         int var2 = 0;

         for(int var3 = 0; var3 < this.field1391; ++var3) {
            for(int var4 = 0; var4 < this.field1390; ++var4) {
               var1[var4 + this.field1393 + (var3 + this.field1394) * this.field1395] = this.field1389[var2++];
            }
         }

         this.field1389 = var1;
         this.field1390 = this.field1395;
         this.field1391 = this.field1392;
         this.field1393 = 0;
         this.field1394 = 0;
      }
   }

   @ObfuscatedName("w")
   public void method1871(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1396.length; ++var4) {
         int var5 = this.field1396[var4] >> 16 & 255;
         var5 += var1;
         if(var5 < 0) {
            var5 = 0;
         } else if(var5 > 255) {
            var5 = 255;
         }

         int var6 = this.field1396[var4] >> 8 & 255;
         var6 += var2;
         if(var6 < 0) {
            var6 = 0;
         } else if(var6 > 255) {
            var6 = 255;
         }

         int var7 = this.field1396[var4] & 255;
         var7 += var3;
         if(var7 < 0) {
            var7 = 0;
         } else if(var7 > 255) {
            var7 = 255;
         }

         this.field1396[var4] = (var5 << 16) + (var6 << 8) + var7;
      }

   }

   @ObfuscatedName("f")
   public void method1880(int var1, int var2) {
      var1 += this.field1393;
      var2 += this.field1394;
      int var3 = var1 + var2 * class79.field1387;
      int var4 = 0;
      int var5 = this.field1391;
      int var6 = this.field1390;
      int var7 = class79.field1387 - var6;
      int var8 = 0;
      int var9;
      if(var2 < class79.field1385) {
         var9 = class79.field1385 - var2;
         var5 -= var9;
         var2 = class79.field1385;
         var4 += var9 * var6;
         var3 += var9 * class79.field1387;
      }

      if(var2 + var5 > class79.field1386) {
         var5 -= var2 + var5 - class79.field1386;
      }

      if(var1 < class79.field1382) {
         var9 = class79.field1382 - var1;
         var6 -= var9;
         var1 = class79.field1382;
         var4 += var9;
         var3 += var9;
         var8 += var9;
         var7 += var9;
      }

      if(var1 + var6 > class79.field1388) {
         var9 = var1 + var6 - class79.field1388;
         var6 -= var9;
         var8 += var9;
         var7 += var9;
      }

      if(var6 > 0 && var5 > 0) {
         method1883(class79.field1383, this.field1389, this.field1396, var4, var3, var6, var5, var7, var8);
      }
   }

   @ObfuscatedName("s")
   static void method1883(int[] var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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
}
