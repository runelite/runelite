import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public class class43 {
   @ObfuscatedName("aw")
   protected static boolean field595;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = 2042058967
   )
   static int field589;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1426206751
   )
   int field591;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2116971115
   )
   int field590;
   @ObfuscatedName("e")
   int[][] field596;
   @ObfuscatedName("q")
   int[][] field593;
   @ObfuscatedName("p")
   int[][] field592;
   @ObfuscatedName("s")
   int[][] field594;

   class43(int var1, int var2) {
      this.field591 = var1;
      this.field590 = var2;
      this.field596 = new int[var1][var2];
      this.field592 = new int[var1][var2];
      this.field593 = new int[var1][var2];
      this.field594 = new int[var1][var2];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1994855412"
   )
   int method620(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field591 && var2 < this.field590) {
         if(this.field593[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field596[var1][var2] / this.field594[var1][var2];
            int var4 = this.field592[var1][var2] / this.field594[var1][var2];
            int var5 = this.field593[var1][var2] / this.field594[var1][var2];
            double var7 = (double)var3 / 256.0D;
            double var9 = (double)var4 / 256.0D;
            double var11 = (double)var5 / 256.0D;
            double var13 = var11;
            double var15 = var11;
            double var17 = var11;
            if(var9 != 0.0D) {
               double var19;
               if(var11 < 0.5D) {
                  var19 = var11 * (var9 + 1.0D);
               } else {
                  var19 = var9 + var11 - var9 * var11;
               }

               double var21 = 2.0D * var11 - var19;
               double var23 = var7 + 0.3333333333333333D;
               if(var23 > 1.0D) {
                  --var23;
               }

               double var27 = var7 - 0.3333333333333333D;
               if(var27 < 0.0D) {
                  ++var27;
               }

               if(var23 * 6.0D < 1.0D) {
                  var13 = var21 + (var19 - var21) * 6.0D * var23;
               } else if(2.0D * var23 < 1.0D) {
                  var13 = var19;
               } else if(3.0D * var23 < 2.0D) {
                  var13 = var21 + (var19 - var21) * (0.6666666666666666D - var23) * 6.0D;
               } else {
                  var13 = var21;
               }

               if(var7 * 6.0D < 1.0D) {
                  var15 = (var19 - var21) * 6.0D * var7 + var21;
               } else if(var7 * 2.0D < 1.0D) {
                  var15 = var19;
               } else if(3.0D * var7 < 2.0D) {
                  var15 = (0.6666666666666666D - var7) * (var19 - var21) * 6.0D + var21;
               } else {
                  var15 = var21;
               }

               if(var27 * 6.0D < 1.0D) {
                  var17 = var21 + 6.0D * (var19 - var21) * var27;
               } else if(2.0D * var27 < 1.0D) {
                  var17 = var19;
               } else if(var27 * 3.0D < 2.0D) {
                  var17 = var21 + 6.0D * (var19 - var21) * (0.6666666666666666D - var27);
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIILiv;I)V",
      garbageValue = "298648702"
   )
   void method619(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field591 && var2 - var3 <= this.field590) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field591, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field590, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field596[var9][var10] += var4.hue * 256 / var4.hueMultiplier;
                     this.field592[var9][var10] += var4.saturation;
                     this.field593[var9][var10] += var4.lightness;
                     ++this.field594[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Liw;",
      garbageValue = "-1760143346"
   )
   public static Overlay method626(int var0) {
      Overlay var1 = (Overlay)Overlay.overlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Overlay.overlay_ref.getConfigData(4, var0);
         var1 = new Overlay();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         Overlay.overlays.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "4"
   )
   static void method622() {
      if(class90.field1414 && class90.username != null && class90.username.length() > 0) {
         class90.field1439 = 1;
      } else {
         class90.field1439 = 0;
      }

   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "(IIIILkr;Lhu;B)V",
      garbageValue = "20"
   )
   @Export("drawDot")
   static final void drawDot(int var0, int var1, int var2, int var3, SpritePixels var4, class210 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = Graphics3D.SINE[var6];
            int var9 = Graphics3D.COSINE[var6];
            int var10 = var3 * var8 + var9 * var2 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method5185(var10 + var5.field2615 / 2 - var4.maxWidth / 2, var5.field2611 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2615, var5.field2611, var5.field2616, var5.field2613);
            } else {
               var4.method5172(var0 + var10 + var5.field2615 / 2 - var4.maxWidth / 2, var5.field2611 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2055799304"
   )
   public static void method627(int var0) {
      if(class203.field2521 != 0) {
         class148.field2203 = var0;
      } else {
         class203.field2523.method3797(var0);
      }

   }
}
