import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public class class23 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "-1724081186"
   )
   public static void method165(String var0, Throwable var1) {
      var1.printStackTrace();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljt;Ljt;B)V",
      garbageValue = "125"
   )
   static void method163(Font var0, Font var1) {
      if(class92.field1424 == null) {
         class92.field1424 = class267.method4867(CombatInfo1.indexSprites, "sl_back", "");
      }

      if(class29.field400 == null) {
         class29.field400 = class211.method3938(CombatInfo1.indexSprites, "sl_flags", "");
      }

      if(class40.field517 == null) {
         class40.field517 = class211.method3938(CombatInfo1.indexSprites, "sl_arrows", "");
      }

      if(class88.field1359 == null) {
         class88.field1359 = class211.method3938(CombatInfo1.indexSprites, "sl_stars", "");
      }

      Rasterizer2D.method4937(class92.field1416, 23, 765, 480, 0);
      Rasterizer2D.method4942(class92.field1416, 0, 125, 23, 12425273, 9135624);
      Rasterizer2D.method4942(class92.field1416 + 125, 0, 640, 23, 5197647, 2697513);
      var0.method4742("Select a world", class92.field1416 + 62, 15, 0, -1);
      if(class88.field1359 != null) {
         class88.field1359[1].method5034(class92.field1416 + 140, 1);
         var1.method4751("Members only world", class92.field1416 + 152, 10, 16777215, -1);
         class88.field1359[0].method5034(class92.field1416 + 140, 12);
         var1.method4751("Free world", class92.field1416 + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(class40.field517 != null) {
         int var2 = class92.field1416 + 280;
         if(World.field1266[0] == 0 && World.field1265[0] == 0) {
            class40.field517[2].method5034(var2, 4);
         } else {
            class40.field517[0].method5034(var2, 4);
         }

         if(World.field1266[0] == 0 && World.field1265[0] == 1) {
            class40.field517[3].method5034(var2 + 15, 4);
         } else {
            class40.field517[1].method5034(var2 + 15, 4);
         }

         var0.method4751("World", var2 + 32, 17, 16777215, -1);
         int var3 = class92.field1416 + 390;
         if(World.field1266[0] == 1 && World.field1265[0] == 0) {
            class40.field517[2].method5034(var3, 4);
         } else {
            class40.field517[0].method5034(var3, 4);
         }

         if(World.field1266[0] == 1 && World.field1265[0] == 1) {
            class40.field517[3].method5034(var3 + 15, 4);
         } else {
            class40.field517[1].method5034(var3 + 15, 4);
         }

         var0.method4751("Players", var3 + 32, 17, 16777215, -1);
         var4 = class92.field1416 + 500;
         if(World.field1266[0] == 2 && World.field1265[0] == 0) {
            class40.field517[2].method5034(var4, 4);
         } else {
            class40.field517[0].method5034(var4, 4);
         }

         if(World.field1266[0] == 2 && World.field1265[0] == 1) {
            class40.field517[3].method5034(var4 + 15, 4);
         } else {
            class40.field517[1].method5034(var4 + 15, 4);
         }

         var0.method4751("Location", var4 + 32, 17, 16777215, -1);
         var5 = class92.field1416 + 610;
         if(World.field1266[0] == 3 && World.field1265[0] == 0) {
            class40.field517[2].method5034(var5, 4);
         } else {
            class40.field517[0].method5034(var5, 4);
         }

         if(World.field1266[0] == 3 && World.field1265[0] == 1) {
            class40.field517[3].method5034(var5 + 15, 4);
         } else {
            class40.field517[1].method5034(var5 + 15, 4);
         }

         var0.method4751("Type", var5 + 32, 17, 16777215, -1);
      }

      Rasterizer2D.method4937(class92.field1416 + 708, 4, 50, 16, 0);
      var1.method4742("Cancel", class92.field1416 + 708 + 25, 16, 16777215, -1);
      class92.field1404 = -1;
      if(class92.field1424 != null) {
         byte var21 = 88;
         byte var22 = 19;
         var4 = 765 / (var21 + 1);
         var5 = 480 / (var22 + 1);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if((var4 - 1) * var5 >= World.worldCount) {
               --var4;
            }

            if((var5 - 1) * var4 >= World.worldCount) {
               --var5;
            }

            if((var5 - 1) * var4 >= World.worldCount) {
               --var5;
            }
         } while(var6 != var5 || var7 != var4);

         var6 = (765 - var21 * var4) / (var4 + 1);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var5 * var22) / (var5 + 1);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var21 * var4 - (var4 - 1) * var6) / 2;
         int var9 = (480 - var5 * var22 - (var5 - 1) * var7) / 2;
         int var10 = var9 + 23;
         int var11 = var8 + class92.field1416;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < World.worldCount; ++var14) {
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
            if(var15.method1560()) {
               if(var15.method1596()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method1563()) {
               var19 = 16711680;
               if(var15.method1596()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method1584()) {
               if(var15.method1596()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method1596()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(MouseInput.field696 >= var11 && MouseInput.field705 >= var10 && MouseInput.field696 < var21 + var11 && MouseInput.field705 < var22 + var10 && var16) {
               class92.field1404 = var14;
               class92.field1424[var18].method5073(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               class92.field1424[var18].method5067(var11, var10);
            }

            if(class29.field400 != null) {
               class29.field400[(var15.method1596()?8:0) + var15.location].method5034(var11 + 29, var10);
            }

            var0.method4742(Integer.toString(var15.id), var11 + 15, var10 + var22 / 2 + 5, var19, -1);
            var1.method4742(var17, var11 + 60, var10 + var22 / 2 + 5, 268435455, -1);
            var10 = var10 + var7 + var22;
            ++var12;
            if(var12 >= var5) {
               var10 = var9 + 23;
               var11 = var11 + var6 + var21;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method4820(World.worldList[class92.field1404].activity) + 6;
            int var20 = var1.verticalSpace + 8;
            Rasterizer2D.method4937(MouseInput.field696 - var14 / 2, MouseInput.field705 + 5 + 20, var14, var20, 16777120);
            Rasterizer2D.drawRectangle(MouseInput.field696 - var14 / 2, MouseInput.field705 + 5 + 20, var14, var20, 0);
            var1.method4742(World.worldList[class92.field1404].activity, MouseInput.field696, MouseInput.field705 + var1.verticalSpace + 4 + 5 + 20, 0, -1);
         }
      }

      class48.field582.vmethod5019(0, 0);
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1226138315"
   )
   static final void method164(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field1086; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field971[var4] = true;
         }
      }

   }
}
