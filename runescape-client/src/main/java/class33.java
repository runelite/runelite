import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public final class class33 extends Renderable {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1147887679
   )
   int field731;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 710029935
   )
   int field732;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1658813367
   )
   int field733;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 832111423
   )
   int field734;
   @ObfuscatedName("c")
   Sequence field735;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -444334337
   )
   int field736;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2091172853
   )
   int field737;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 707151471
   )
   int field738 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1591352005
   )
   int field739 = 0;
   @ObfuscatedName("z")
   boolean field740 = false;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1378419321"
   )
   final void method707(int var1) {
      if(!this.field740) {
         this.field739 += var1;

         while(this.field739 > this.field735.frameLenghts[this.field738]) {
            this.field739 -= this.field735.frameLenghts[this.field738];
            ++this.field738;
            if(this.field738 >= this.field735.frameIDs.length) {
               this.field740 = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "1672156994"
   )
   protected final Model getModel() {
      class190 var1 = class179.method3320(this.field737);
      Model var2;
      if(!this.field740) {
         var2 = var1.method3510(this.field738);
      } else {
         var2 = var1.method3510(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass208;Lclass208;B)V",
      garbageValue = "-82"
   )
   static void method712(class208 var0, class208 var1) {
      if(null == Friend.field150) {
         Friend.field150 = class138.method2548(class156.field2240, "sl_back", "");
      }

      if(class137.field1911 == null) {
         class137.field1911 = class183.method3419(class156.field2240, "sl_flags", "");
      }

      if(class139.field1924 == null) {
         class139.field1924 = class183.method3419(class156.field2240, "sl_arrows", "");
      }

      if(class171.field2358 == null) {
         class171.field2358 = class183.method3419(class156.field2240, "sl_stars", "");
      }

      class219.method4071(class41.field848, 23, 765, 480, 0);
      class219.method4092(class41.field848, 0, 125, 23, 12425273, 9135624);
      class219.method4092(125 + class41.field848, 0, 640, 23, 5197647, 2697513);
      var0.method3907("Select a world", class41.field848 + 62, 15, 0, -1);
      if(class171.field2358 != null) {
         class171.field2358[1].method4146(class41.field848 + 140, 1);
         var1.method3920("Members only world", class41.field848 + 152, 10, 16777215, -1);
         class171.field2358[0].method4146(140 + class41.field848, 12);
         var1.method3920("Free world", class41.field848 + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(class139.field1924 != null) {
         int var2 = 280 + class41.field848;
         if(World.field686[0] == 0 && World.field674[0] == 0) {
            class139.field1924[2].method4146(var2, 4);
         } else {
            class139.field1924[0].method4146(var2, 4);
         }

         if(World.field686[0] == 0 && World.field674[0] == 1) {
            class139.field1924[3].method4146(var2 + 15, 4);
         } else {
            class139.field1924[1].method4146(15 + var2, 4);
         }

         var0.method3920("World", 32 + var2, 17, 16777215, -1);
         int var3 = class41.field848 + 390;
         if(World.field686[0] == 1 && World.field674[0] == 0) {
            class139.field1924[2].method4146(var3, 4);
         } else {
            class139.field1924[0].method4146(var3, 4);
         }

         if(World.field686[0] == 1 && World.field674[0] == 1) {
            class139.field1924[3].method4146(var3 + 15, 4);
         } else {
            class139.field1924[1].method4146(var3 + 15, 4);
         }

         var0.method3920("Players", 32 + var3, 17, 16777215, -1);
         var4 = class41.field848 + 500;
         if(World.field686[0] == 2 && World.field674[0] == 0) {
            class139.field1924[2].method4146(var4, 4);
         } else {
            class139.field1924[0].method4146(var4, 4);
         }

         if(World.field686[0] == 2 && World.field674[0] == 1) {
            class139.field1924[3].method4146(15 + var4, 4);
         } else {
            class139.field1924[1].method4146(15 + var4, 4);
         }

         var0.method3920("Location", var4 + 32, 17, 16777215, -1);
         var5 = class41.field848 + 610;
         if(World.field686[0] == 3 && World.field674[0] == 0) {
            class139.field1924[2].method4146(var5, 4);
         } else {
            class139.field1924[0].method4146(var5, 4);
         }

         if(World.field686[0] == 3 && World.field674[0] == 1) {
            class139.field1924[3].method4146(15 + var5, 4);
         } else {
            class139.field1924[1].method4146(15 + var5, 4);
         }

         var0.method3920("Type", var5 + 32, 17, 16777215, -1);
      }

      class219.method4071(708 + class41.field848, 4, 50, 16, 0);
      var1.method3907("Cancel", 25 + class41.field848 + 708, 16, 16777215, -1);
      class41.field849 = -1;
      if(null != Friend.field150) {
         byte var23 = 88;
         byte var24 = 19;
         var4 = 765 / (1 + var23);
         var5 = 480 / (1 + var24);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if((var4 - 1) * var5 >= World.field672) {
               --var4;
            }

            if((var5 - 1) * var4 >= World.field672) {
               --var5;
            }

            if((var5 - 1) * var4 >= World.field672) {
               --var5;
            }
         } while(var5 != var6 || var4 != var7);

         var6 = (765 - var23 * var4) / (1 + var4);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var5 * var24) / (1 + var5);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var23 * var4 - (var4 - 1) * var6) / 2;
         int var9 = (480 - var24 * var5 - var7 * (var5 - 1)) / 2;
         int var10 = var9 + 23;
         int var11 = class41.field848 + var8;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < World.field672; ++var14) {
            World var15 = World.worldList[var14];
            boolean var16 = true;
            String var17 = Integer.toString(var15.playerCount);
            if(var15.playerCount == -1) {
               var17 = "OFF";
               var16 = false;
            } else if(var15.playerCount > 1980) {
               var17 = "FULL";
               var16 = false;
            }

            int var19 = 0;
            byte var18;
            if(var15.method667()) {
               if(var15.method637()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method642()) {
               var19 = 16711680;
               if(var15.method637()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method639()) {
               if(var15.method637()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method637()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(class115.field1811 >= var11 && class115.field1810 >= var10 && class115.field1811 < var23 + var11 && class115.field1810 < var24 + var10 && var16) {
               class41.field849 = var14;
               Friend.field150[var18].method4194(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               Friend.field150[var18].method4190(var11, var10);
            }

            if(class137.field1911 != null) {
               class137.field1911[(var15.method637()?8:0) + var15.location].method4146(var11 + 29, var10);
            }

            var0.method3907(Integer.toString(var15.id), var11 + 15, var24 / 2 + var10 + 5, var19, -1);
            var1.method3907(var17, var11 + 60, var10 + var24 / 2 + 5, 268435455, -1);
            var10 += var7 + var24;
            ++var12;
            if(var12 >= var5) {
               var10 = var9 + 23;
               var11 += var6 + var23;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method3912(World.worldList[class41.field849].activity) + 6;
            int var20 = 8 + var1.field3091;
            class219.method4071(class115.field1811 - var14 / 2, 5 + class115.field1810 + 20, var14, var20, 16777120);
            class219.method4053(class115.field1811 - var14 / 2, 5 + 20 + class115.field1810, var14, var20, 0);
            var1.method3907(World.worldList[class41.field849].activity, class115.field1811, 4 + var1.field3091 + 5 + class115.field1810 + 20, 0, -1);
         }
      }

      try {
         Graphics var21 = class107.canvas.getGraphics();
         class34.bufferProvider.draw(var21, 0, 0);
      } catch (Exception var22) {
         class107.canvas.repaint();
      }

   }

   class33(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field737 = var1;
      this.field733 = var2;
      this.field734 = var3;
      this.field731 = var4;
      this.field736 = var5;
      this.field732 = var7 + var6;
      int var8 = class179.method3320(this.field737).field2800;
      if(var8 != -1) {
         this.field740 = false;
         this.field735 = class9.getAnimation(var8);
      } else {
         this.field740 = true;
      }

   }

   @ObfuscatedName("ef")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "1770242365"
   )
   static boolean method715(Widget var0) {
      if(Client.field455) {
         if(class185.method3463(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }
}
