import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cf")
@Implements("ModIcon")
public final class class83 extends class82 {
   @ObfuscatedName("m")
   @Export("pixels")
   public byte[] field1494;
   @ObfuscatedName("w")
   @Export("palette")
   public int[] field1495;
   @ObfuscatedName("j")
   @Export("width")
   public int field1496;
   @ObfuscatedName("o")
   @Export("height")
   public int field1497;
   @ObfuscatedName("g")
   @Export("offsetX")
   public int field1498;
   @ObfuscatedName("l")
   @Export("offsetY")
   public int field1499;
   @ObfuscatedName("e")
   @Export("originalWidth")
   public int field1500;
   @ObfuscatedName("r")
   @Export("originalHeight")
   public int field1501;

   @ObfuscatedName("m")
   public void method1944() {
      if(this.field1500 != this.field1496 || this.field1497 != this.field1501) {
         byte[] var1 = new byte[this.field1496 * this.field1501];
         int var2 = 0;

         for(int var3 = 0; var3 < this.field1497; ++var3) {
            for(int var4 = 0; var4 < this.field1500; ++var4) {
               var1[var4 + this.field1498 + (var3 + this.field1499) * this.field1496] = this.field1494[var2++];
            }
         }

         this.field1494 = var1;
         this.field1500 = this.field1496;
         this.field1497 = this.field1501;
         this.field1498 = 0;
         this.field1499 = 0;
      }
   }

   @ObfuscatedName("w")
   public void method1945(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field1495.length; ++var4) {
         int var5 = this.field1495[var4] >> 16 & 255;
         var5 += var1;
         if(var5 < 0) {
            var5 = 0;
         } else if(var5 > 255) {
            var5 = 255;
         }

         int var6 = this.field1495[var4] >> 8 & 255;
         var6 += var2;
         if(var6 < 0) {
            var6 = 0;
         } else if(var6 > 255) {
            var6 = 255;
         }

         int var7 = this.field1495[var4] & 255;
         var7 += var3;
         if(var7 < 0) {
            var7 = 0;
         } else if(var7 > 255) {
            var7 = 255;
         }

         this.field1495[var4] = (var5 << 16) + (var6 << 8) + var7;
      }

   }

   @ObfuscatedName("e")
   public void method1946(int var1, int var2) {
      var1 += this.field1498;
      var2 += this.field1499;
      int var3 = var1 + var2 * class82.field1488;
      int var4 = 0;
      int var5 = this.field1497;
      int var6 = this.field1500;
      int var7 = class82.field1488 - var6;
      int var8 = 0;
      int var9;
      if(var2 < class82.field1490) {
         var9 = class82.field1490 - var2;
         var5 -= var9;
         var2 = class82.field1490;
         var4 += var9 * var6;
         var3 += var9 * class82.field1488;
      }

      if(var2 + var5 > class82.field1491) {
         var5 -= var2 + var5 - class82.field1491;
      }

      if(var1 < class82.field1493) {
         var9 = class82.field1493 - var1;
         var6 -= var9;
         var1 = class82.field1493;
         var4 += var9;
         var3 += var9;
         var8 += var9;
         var7 += var9;
      }

      if(var1 + var6 > class82.field1487) {
         var9 = var1 + var6 - class82.field1487;
         var6 -= var9;
         var8 += var9;
         var7 += var9;
      }

      if(var6 > 0 && var5 > 0) {
         method1947(class82.field1492, this.field1494, this.field1495, var4, var3, var6, var5, var7, var8);
      }
   }

   @ObfuscatedName("o")
   static void method1947(int[] var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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
