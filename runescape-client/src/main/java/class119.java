import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
public abstract class class119 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1822348495
   )
   public int field1857;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1540935091
   )
   public int field1860;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1676674607
   )
   public int field1862;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 288518191
   )
   public int field1864;
   @ObfuscatedName("g")
   public static int[] field1865;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "-961327271"
   )
   protected abstract boolean vmethod2219(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "2047697431"
   )
   static boolean method2222(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = class137.method2397(var0, class1.field15);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(class137.method2397(var3.name, class1.field15))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class137.method2397(var3.previousName, class1.field15))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LFont;LFont;B)V",
      garbageValue = "5"
   )
   static void method2223(Font var0, Font var1) {
      if(null == Ignore.field222) {
         Ignore.field222 = class215.method3829(class40.field807, "sl_back", "");
      }

      if(class85.field1462 == null) {
         class85.field1462 = Renderable.method1831(class40.field807, "sl_flags", "");
      }

      if(VertexNormal.field1426 == null) {
         VertexNormal.field1426 = Renderable.method1831(class40.field807, "sl_arrows", "");
      }

      if(class41.field845 == null) {
         class41.field845 = Renderable.method1831(class40.field807, "sl_stars", "");
      }

      Rasterizer2D.method3876(class41.field814, 23, 765, 480, 0);
      Rasterizer2D.method3855(class41.field814, 0, 125, 23, 12425273, 9135624);
      Rasterizer2D.method3855(125 + class41.field814, 0, 640, 23, 5197647, 2697513);
      var0.method3739("Select a world", 62 + class41.field814, 15, 0, -1);
      if(class41.field845 != null) {
         class41.field845[1].method3919(140 + class41.field814, 1);
         var1.method3727("Members only world", class41.field814 + 152, 10, 16777215, -1);
         class41.field845[0].method3919(class41.field814 + 140, 12);
         var1.method3727("Free world", class41.field814 + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(VertexNormal.field1426 != null) {
         int var2 = class41.field814 + 280;
         if(World.field680[0] == 0 && World.field673[0] == 0) {
            VertexNormal.field1426[2].method3919(var2, 4);
         } else {
            VertexNormal.field1426[0].method3919(var2, 4);
         }

         if(World.field680[0] == 0 && World.field673[0] == 1) {
            VertexNormal.field1426[3].method3919(15 + var2, 4);
         } else {
            VertexNormal.field1426[1].method3919(15 + var2, 4);
         }

         var0.method3727("World", var2 + 32, 17, 16777215, -1);
         int var3 = 390 + class41.field814;
         if(World.field680[0] == 1 && World.field673[0] == 0) {
            VertexNormal.field1426[2].method3919(var3, 4);
         } else {
            VertexNormal.field1426[0].method3919(var3, 4);
         }

         if(World.field680[0] == 1 && World.field673[0] == 1) {
            VertexNormal.field1426[3].method3919(15 + var3, 4);
         } else {
            VertexNormal.field1426[1].method3919(15 + var3, 4);
         }

         var0.method3727("Players", var3 + 32, 17, 16777215, -1);
         var4 = class41.field814 + 500;
         if(World.field680[0] == 2 && World.field673[0] == 0) {
            VertexNormal.field1426[2].method3919(var4, 4);
         } else {
            VertexNormal.field1426[0].method3919(var4, 4);
         }

         if(World.field680[0] == 2 && World.field673[0] == 1) {
            VertexNormal.field1426[3].method3919(15 + var4, 4);
         } else {
            VertexNormal.field1426[1].method3919(var4 + 15, 4);
         }

         var0.method3727("Location", var4 + 32, 17, 16777215, -1);
         var5 = class41.field814 + 610;
         if(World.field680[0] == 3 && World.field673[0] == 0) {
            VertexNormal.field1426[2].method3919(var5, 4);
         } else {
            VertexNormal.field1426[0].method3919(var5, 4);
         }

         if(World.field680[0] == 3 && World.field673[0] == 1) {
            VertexNormal.field1426[3].method3919(15 + var5, 4);
         } else {
            VertexNormal.field1426[1].method3919(15 + var5, 4);
         }

         var0.method3727("Type", var5 + 32, 17, 16777215, -1);
      }

      Rasterizer2D.method3876(class41.field814 + 708, 4, 50, 16, 0);
      var1.method3739("Cancel", 708 + class41.field814 + 25, 16, 16777215, -1);
      class41.field846 = -1;
      if(Ignore.field222 != null) {
         byte var23 = 88;
         byte var24 = 19;
         var4 = 765 / (1 + var23);
         var5 = 480 / (1 + var24);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if((var4 - 1) * var5 >= World.field682) {
               --var4;
            }

            if(var4 * (var5 - 1) >= World.field682) {
               --var5;
            }

            if(var4 * (var5 - 1) >= World.field682) {
               --var5;
            }
         } while(var6 != var5 || var4 != var7);

         var6 = (765 - var4 * var23) / (1 + var4);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var5 * var24) / (var5 + 1);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var23 * var4 - (var4 - 1) * var6) / 2;
         int var9 = (480 - var24 * var5 - var7 * (var5 - 1)) / 2;
         int var10 = var9 + 23;
         int var11 = class41.field814 + var8;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < World.field682; ++var14) {
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
            if(var15.method609()) {
               if(var15.method621()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method634()) {
               var19 = 16711680;
               if(var15.method621()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method599()) {
               if(var15.method621()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method621()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(class115.field1810 >= var11 && class115.field1803 >= var10 && class115.field1810 < var23 + var11 && class115.field1803 < var24 + var10 && var16) {
               class41.field846 = var14;
               Ignore.field222[var18].method3975(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               Ignore.field222[var18].method3969(var11, var10);
            }

            if(null != class85.field1462) {
               class85.field1462[(var15.method621()?8:0) + var15.location].method3919(29 + var11, var10);
            }

            var0.method3739(Integer.toString(var15.id), var11 + 15, 5 + var10 + var24 / 2, var19, -1);
            var1.method3739(var17, var11 + 60, 5 + var10 + var24 / 2, 268435455, -1);
            var10 += var7 + var24;
            ++var12;
            if(var12 >= var5) {
               var10 = 23 + var9;
               var11 += var6 + var23;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method3722(World.worldList[class41.field846].activity) + 6;
            int var20 = var1.field3102 + 8;
            Rasterizer2D.method3876(class115.field1810 - var14 / 2, 5 + 20 + class115.field1803, var14, var20, 16777120);
            Rasterizer2D.method3863(class115.field1810 - var14 / 2, 5 + class115.field1803 + 20, var14, var20, 0);
            var1.method3739(World.worldList[class41.field846].activity, class115.field1810, 20 + class115.field1803 + 5 + var1.field3102 + 4, 0, -1);
         }
      }

      try {
         Graphics var21 = class25.canvas.getGraphics();
         class57.bufferProvider.draw(var21, 0, 0);
      } catch (Exception var22) {
         class25.canvas.repaint();
      }

   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(IIIZB)V",
      garbageValue = "3"
   )
   static final void method2225(int var0, int var1, int var2, boolean var3) {
      if(class109.method1999(var0)) {
         class41.method754(Widget.widgets[var0], -1, var1, var2, var3);
      }
   }
}
