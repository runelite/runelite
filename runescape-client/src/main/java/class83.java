import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cc")
@Implements("ModIcon")
public final class class83 extends class82 {
   @ObfuscatedName("u")
   @Export("originalHeight")
   public int field1484;
   @ObfuscatedName("b")
   @Export("width")
   public int field1485;
   @ObfuscatedName("c")
   @Export("originalWidth")
   public int field1486;
   @ObfuscatedName("l")
   @Export("palette")
   public int[] field1487;
   @ObfuscatedName("r")
   @Export("offsetX")
   public int field1488;
   @ObfuscatedName("h")
   @Export("height")
   public int field1489;
   @ObfuscatedName("e")
   @Export("pixels")
   public byte[] field1490;
   @ObfuscatedName("a")
   @Export("offsetY")
   public int field1491;

   @ObfuscatedName("e")
   public void method1951() {
      if(this.field1486 != this.field1485 || this.field1489 != this.field1484) {
         byte[] var1 = new byte[this.field1485 * this.field1484];
         int var2 = 0;

         for(int var3 = 0; var3 < this.field1489; ++var3) {
            for(int var4 = 0; var4 < this.field1486; ++var4) {
               var1[var4 + this.field1488 + (var3 + this.field1491) * this.field1485] = this.field1490[var2++];
            }
         }

         this.field1490 = var1;
         this.field1486 = this.field1485;
         this.field1489 = this.field1484;
         this.field1488 = 0;
         this.field1491 = 0;
      }
   }

   @ObfuscatedName("c")
   public void method1952(int var1, int var2) {
      var1 += this.field1488;
      var2 += this.field1491;
      int var3 = var1 + var2 * class82.field1478;
      int var4 = 0;
      int var5 = this.field1489;
      int var6 = this.field1486;
      int var7 = class82.field1478 - var6;
      int var8 = 0;
      int var9;
      if(var2 < class82.field1480) {
         var9 = class82.field1480 - var2;
         var5 -= var9;
         var2 = class82.field1480;
         var4 += var9 * var6;
         var3 += var9 * class82.field1478;
      }

      if(var2 + var5 > class82.field1479) {
         var5 -= var2 + var5 - class82.field1479;
      }

      if(var1 < class82.field1481) {
         var9 = class82.field1481 - var1;
         var6 -= var9;
         var1 = class82.field1481;
         var4 += var9;
         var3 += var9;
         var8 += var9;
         var7 += var9;
      }

      if(var1 + var6 > class82.field1483) {
         var9 = var1 + var6 - class82.field1483;
         var6 -= var9;
         var8 += var9;
         var7 += var9;
      }

      if(var6 > 0 && var5 > 0) {
         method1963(class82.field1482, this.field1490, this.field1487, var4, var3, var6, var5, var7, var8);
      }
   }

   @ObfuscatedName("l")
   public void method1954(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1487.length; ++var4) {
         int var5 = this.field1487[var4] >> 16 & 255;
         var5 += var1;
         if(var5 < 0) {
            var5 = 0;
         } else if(var5 > 255) {
            var5 = 255;
         }

         int var6 = this.field1487[var4] >> 8 & 255;
         var6 += var2;
         if(var6 < 0) {
            var6 = 0;
         } else if(var6 > 255) {
            var6 = 255;
         }

         int var7 = this.field1487[var4] & 255;
         var7 += var3;
         if(var7 < 0) {
            var7 = 0;
         } else if(var7 > 255) {
            var7 = 255;
         }

         this.field1487[var4] = (var5 << 16) + (var6 << 8) + var7;
      }

   }

   @ObfuscatedName("h")
   static void method1963(int[] var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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
