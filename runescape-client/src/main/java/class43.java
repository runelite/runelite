import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class43 {
   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "[Lks;"
   )
   static IndexedSprite[] field527;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 757241259
   )
   int field532;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1110126103
   )
   int field526;
   @ObfuscatedName("r")
   int[][] field525;
   @ObfuscatedName("g")
   int[][] field528;
   @ObfuscatedName("x")
   int[][] field530;
   @ObfuscatedName("f")
   int[][] field533;

   class43(int var1, int var2) {
      this.field532 = var1;
      this.field526 = var2;
      this.field525 = new int[var1][var2];
      this.field528 = new int[var1][var2];
      this.field530 = new int[var1][var2];
      this.field533 = new int[var1][var2];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIILie;I)V",
      garbageValue = "-4232440"
   )
   void method580(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field532 && var2 - var3 <= this.field526) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field532, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field526, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field525[var9][var10] += var4.hue * 256 / var4.hueMultiplier;
                     this.field528[var9][var10] += var4.saturation;
                     this.field530[var9][var10] += var4.lightness;
                     ++this.field533[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1823300680"
   )
   int method581(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field532 && var2 < this.field526) {
         if(this.field530[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field525[var1][var2] / this.field533[var1][var2];
            int var4 = this.field528[var1][var2] / this.field533[var1][var2];
            int var5 = this.field530[var1][var2] / this.field533[var1][var2];
            double var7 = (double)var3 / 256.0D;
            double var9 = (double)var4 / 256.0D;
            double var11 = (double)var5 / 256.0D;
            double var13 = var11;
            double var15 = var11;
            double var17 = var11;
            if(0.0D != var9) {
               double var19;
               if(var11 < 0.5D) {
                  var19 = var11 * (var9 + 1.0D);
               } else {
                  var19 = var9 + var11 - var9 * var11;
               }

               double var21 = 2.0D * var11 - var19;
               double var23 = 0.3333333333333333D + var7;
               if(var23 > 1.0D) {
                  --var23;
               }

               double var27 = var7 - 0.3333333333333333D;
               if(var27 < 0.0D) {
                  ++var27;
               }

               if(6.0D * var23 < 1.0D) {
                  var13 = var21 + var23 * (var19 - var21) * 6.0D;
               } else if(2.0D * var23 < 1.0D) {
                  var13 = var19;
               } else if(var23 * 3.0D < 2.0D) {
                  var13 = 6.0D * (var19 - var21) * (0.6666666666666666D - var23) + var21;
               } else {
                  var13 = var21;
               }

               if(6.0D * var7 < 1.0D) {
                  var15 = var21 + var7 * (var19 - var21) * 6.0D;
               } else if(2.0D * var7 < 1.0D) {
                  var15 = var19;
               } else if(3.0D * var7 < 2.0D) {
                  var15 = var21 + 6.0D * (0.6666666666666666D - var7) * (var19 - var21);
               } else {
                  var15 = var21;
               }

               if(var27 * 6.0D < 1.0D) {
                  var17 = 6.0D * (var19 - var21) * var27 + var21;
               } else if(2.0D * var27 < 1.0D) {
                  var17 = var19;
               } else if(3.0D * var27 < 2.0D) {
                  var17 = var21 + (0.6666666666666666D - var27) * (var19 - var21) * 6.0D;
               } else {
                  var17 = var21;
               }
            }

            int var29 = (int)(256.0D * var13);
            int var20 = (int)(var15 * 256.0D);
            int var30 = (int)(256.0D * var17);
            int var22 = var30 + (var20 << 8) + (var29 << 16);
            return var22;
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lij;Ljava/lang/String;Ljava/lang/String;B)[Lkb;",
      garbageValue = "33"
   )
   public static SpritePixels[] method589(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return class268.method4747(var0, var3, var4);
   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "1"
   )
   static final void method587(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class64.loadWidget(var0)) {
         class14.field271 = null;
         class27.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class14.field271 != null) {
            class27.gameDraw(class14.field271, -1412584499, var1, var2, var3, var4, class25.field340, class35.field457, var7);
            class14.field271 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1052[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1052[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "(Lhx;IB)Ljava/lang/String;",
      garbageValue = "60"
   )
   static String method588(Widget var0, int var1) {
      int var3 = class12.getWidgetConfig(var0);
      boolean var2 = (var3 >> var1 + 1 & 1) != 0;
      return !var2 && var0.field2813 == null?null:(var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }
}
