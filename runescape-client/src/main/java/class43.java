import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class43 {
   @ObfuscatedName("l")
   static int[] field545;
   @ObfuscatedName("ac")
   protected static boolean field548;
   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "[Lky;"
   )
   @Export("headIconsPk")
   static SpritePixels[] headIconsPk;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 449431729
   )
   int field539;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -779907783
   )
   int field540;
   @ObfuscatedName("k")
   int[][] field541;
   @ObfuscatedName("z")
   int[][] field542;
   @ObfuscatedName("v")
   int[][] field543;
   @ObfuscatedName("m")
   int[][] field544;

   class43(int var1, int var2) {
      this.field539 = var1;
      this.field540 = var2;
      this.field541 = new int[var1][var2];
      this.field542 = new int[var1][var2];
      this.field543 = new int[var1][var2];
      this.field544 = new int[var1][var2];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIILiw;B)V",
      garbageValue = "69"
   )
   void method622(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field539 && var2 - var3 <= this.field540) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field539, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field540, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field541[var9][var10] += var4.hue * 256 / var4.hueMultiplier;
                     this.field542[var9][var10] += var4.saturation;
                     this.field543[var9][var10] += var4.lightness;
                     ++this.field544[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1167798863"
   )
   int method623(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field539 && var2 < this.field540) {
         if(this.field543[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field541[var1][var2] / this.field544[var1][var2];
            int var4 = this.field542[var1][var2] / this.field544[var1][var2];
            int var5 = this.field543[var1][var2] / this.field544[var1][var2];
            double var7 = (double)var3 / 256.0D;
            double var9 = (double)var4 / 256.0D;
            double var11 = (double)var5 / 256.0D;
            double var13 = var11;
            double var15 = var11;
            double var17 = var11;
            if(0.0D != var9) {
               double var19;
               if(var11 < 0.5D) {
                  var19 = (var9 + 1.0D) * var11;
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
                  var13 = var23 * (var19 - var21) * 6.0D + var21;
               } else if(var23 * 2.0D < 1.0D) {
                  var13 = var19;
               } else if(var23 * 3.0D < 2.0D) {
                  var13 = var21 + 6.0D * (0.6666666666666666D - var23) * (var19 - var21);
               } else {
                  var13 = var21;
               }

               if(var7 * 6.0D < 1.0D) {
                  var15 = var7 * (var19 - var21) * 6.0D + var21;
               } else if(var7 * 2.0D < 1.0D) {
                  var15 = var19;
               } else if(var7 * 3.0D < 2.0D) {
                  var15 = (var19 - var21) * (0.6666666666666666D - var7) * 6.0D + var21;
               } else {
                  var15 = var21;
               }

               if(6.0D * var27 < 1.0D) {
                  var17 = (var19 - var21) * 6.0D * var27 + var21;
               } else if(2.0D * var27 < 1.0D) {
                  var17 = var19;
               } else if(var27 * 3.0D < 2.0D) {
                  var17 = var21 + 6.0D * (var19 - var21) * (0.6666666666666666D - var27);
               } else {
                  var17 = var21;
               }
            }

            int var29 = (int)(var13 * 256.0D);
            int var20 = (int)(256.0D * var15);
            int var30 = (int)(256.0D * var17);
            int var22 = var30 + (var20 << 8) + (var29 << 16);
            return var22;
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "112"
   )
   static void method621() {
      class3.method7(class181.localPlayer, false);
   }
}
