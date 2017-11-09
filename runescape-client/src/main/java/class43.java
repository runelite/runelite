import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class43 {
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = 1702302157
   )
   static int field551;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ldn;"
   )
   public static class111 field539;
   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "Let;"
   )
   @Export("socket")
   static Task socket;
   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("indexScripts")
   static IndexData indexScripts;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 756918405
   )
   int field541;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1752171689
   )
   int field540;
   @ObfuscatedName("i")
   int[][] field552;
   @ObfuscatedName("j")
   int[][] field542;
   @ObfuscatedName("v")
   int[][] field543;
   @ObfuscatedName("x")
   int[][] field553;

   class43(int var1, int var2) {
      this.field541 = var1;
      this.field540 = var2;
      this.field552 = new int[var1][var2];
      this.field542 = new int[var1][var2];
      this.field543 = new int[var1][var2];
      this.field553 = new int[var1][var2];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIILiw;I)V",
      garbageValue = "-254511913"
   )
   void method677(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field541 && var2 - var3 <= this.field540) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field541, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field540, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field552[var9][var10] += var4.hue * 256 / var4.hueMultiplier;
                     this.field542[var9][var10] += var4.saturation;
                     this.field543[var9][var10] += var4.lightness;
                     ++this.field553[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1702866139"
   )
   int method672(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field541 && var2 < this.field540) {
         if(this.field543[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field552[var1][var2] / this.field553[var1][var2];
            int var4 = this.field542[var1][var2] / this.field553[var1][var2];
            int var5 = this.field543[var1][var2] / this.field553[var1][var2];
            double var7 = (double)var3 / 256.0D;
            double var9 = (double)var4 / 256.0D;
            double var11 = (double)var5 / 256.0D;
            double var13 = var11;
            double var15 = var11;
            double var17 = var11;
            if(var9 != 0.0D) {
               double var19;
               if(var11 < 0.5D) {
                  var19 = (1.0D + var9) * var11;
               } else {
                  var19 = var9 + var11 - var11 * var9;
               }

               double var21 = var11 * 2.0D - var19;
               double var23 = 0.3333333333333333D + var7;
               if(var23 > 1.0D) {
                  --var23;
               }

               double var27 = var7 - 0.3333333333333333D;
               if(var27 < 0.0D) {
                  ++var27;
               }

               if(6.0D * var23 < 1.0D) {
                  var13 = var21 + 6.0D * (var19 - var21) * var23;
               } else if(var23 * 2.0D < 1.0D) {
                  var13 = var19;
               } else if(var23 * 3.0D < 2.0D) {
                  var13 = var21 + 6.0D * (0.6666666666666666D - var23) * (var19 - var21);
               } else {
                  var13 = var21;
               }

               if(6.0D * var7 < 1.0D) {
                  var15 = 6.0D * (var19 - var21) * var7 + var21;
               } else if(var7 * 2.0D < 1.0D) {
                  var15 = var19;
               } else if(3.0D * var7 < 2.0D) {
                  var15 = var21 + (0.6666666666666666D - var7) * (var19 - var21) * 6.0D;
               } else {
                  var15 = var21;
               }

               if(var27 * 6.0D < 1.0D) {
                  var17 = 6.0D * (var19 - var21) * var27 + var21;
               } else if(2.0D * var27 < 1.0D) {
                  var17 = var19;
               } else if(3.0D * var27 < 2.0D) {
                  var17 = 6.0D * (var19 - var21) * (0.6666666666666666D - var27) + var21;
               } else {
                  var17 = var21;
               }
            }

            int var29 = (int)(var13 * 256.0D);
            int var20 = (int)(var15 * 256.0D);
            int var30 = (int)(var17 * 256.0D);
            int var22 = var30 + (var20 << 8) + (var29 << 16);
            return var22;
         }
      } else {
         return 0;
      }
   }
}
