import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public class class25 {
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 1573902207
   )
   static int field371;
   @ObfuscatedName("rl")
   @ObfuscatedGetter(
      intValue = 622654361
   )
   static int field370;
   @ObfuscatedName("ko")
   @ObfuscatedGetter(
      intValue = 616094407
   )
   static int field372;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 512909363
   )
   int field376;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   Coordinates field377;

   @ObfuscatedSignature(
      signature = "(ILhl;)V"
   )
   class25(int var1, Coordinates var2) {
      this.field376 = var1;
      this.field377 = var2;
   }

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "(Lhj;S)V",
      garbageValue = "255"
   )
   static void method172(Widget var0) {
      if(var0.loopCycle == Client.field1117) {
         Client.field1118[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lju;Lju;B)V",
      garbageValue = "1"
   )
   static void method173(Font var0, Font var1) {
      if(ClanMember.field916 == null) {
         ClanMember.field916 = class45.method666(class37.indexSprites, "sl_back", "");
      }

      if(class33.field488 == null) {
         class33.field488 = Ignore.method1147(class37.indexSprites, "sl_flags", "");
      }

      if(class177.field2431 == null) {
         class177.field2431 = Ignore.method1147(class37.indexSprites, "sl_arrows", "");
      }

      if(class149.field2214 == null) {
         class149.field2214 = Ignore.method1147(class37.indexSprites, "sl_stars", "");
      }

      Rasterizer2D.method5129(class90.field1419, 23, 765, 480, 0);
      Rasterizer2D.method5059(class90.field1419, 0, 125, 23, 12425273, 9135624);
      Rasterizer2D.method5059(class90.field1419 + 125, 0, 640, 23, 5197647, 2697513);
      var0.method4843("Select a world", class90.field1419 + 62, 15, 0, -1);
      if(class149.field2214 != null) {
         class149.field2214[1].method5147(class90.field1419 + 140, 1);
         var1.method4840("Members only world", class90.field1419 + 152, 10, 16777215, -1);
         class149.field2214[0].method5147(class90.field1419 + 140, 12);
         var1.method4840("Free world", class90.field1419 + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(class177.field2431 != null) {
         int var2 = class90.field1419 + 280;
         if(World.field1280[0] == 0 && World.field1285[0] == 0) {
            class177.field2431[2].method5147(var2, 4);
         } else {
            class177.field2431[0].method5147(var2, 4);
         }

         if(World.field1280[0] == 0 && World.field1285[0] == 1) {
            class177.field2431[3].method5147(var2 + 15, 4);
         } else {
            class177.field2431[1].method5147(var2 + 15, 4);
         }

         var0.method4840("World", var2 + 32, 17, 16777215, -1);
         int var3 = class90.field1419 + 390;
         if(World.field1280[0] == 1 && World.field1285[0] == 0) {
            class177.field2431[2].method5147(var3, 4);
         } else {
            class177.field2431[0].method5147(var3, 4);
         }

         if(World.field1280[0] == 1 && World.field1285[0] == 1) {
            class177.field2431[3].method5147(var3 + 15, 4);
         } else {
            class177.field2431[1].method5147(var3 + 15, 4);
         }

         var0.method4840("Players", var3 + 32, 17, 16777215, -1);
         var4 = class90.field1419 + 500;
         if(World.field1280[0] == 2 && World.field1285[0] == 0) {
            class177.field2431[2].method5147(var4, 4);
         } else {
            class177.field2431[0].method5147(var4, 4);
         }

         if(World.field1280[0] == 2 && World.field1285[0] == 1) {
            class177.field2431[3].method5147(var4 + 15, 4);
         } else {
            class177.field2431[1].method5147(var4 + 15, 4);
         }

         var0.method4840("Location", var4 + 32, 17, 16777215, -1);
         var5 = class90.field1419 + 610;
         if(World.field1280[0] == 3 && World.field1285[0] == 0) {
            class177.field2431[2].method5147(var5, 4);
         } else {
            class177.field2431[0].method5147(var5, 4);
         }

         if(World.field1280[0] == 3 && World.field1285[0] == 1) {
            class177.field2431[3].method5147(var5 + 15, 4);
         } else {
            class177.field2431[1].method5147(var5 + 15, 4);
         }

         var0.method4840("Type", var5 + 32, 17, 16777215, -1);
      }

      Rasterizer2D.method5129(class90.field1419 + 708, 4, 50, 16, 0);
      var1.method4843("Cancel", class90.field1419 + 708 + 25, 16, 16777215, -1);
      class90.field1429 = -1;
      if(ClanMember.field916 != null) {
         byte var21 = 88;
         byte var22 = 19;
         var4 = 765 / (var21 + 1);
         var5 = 480 / (var22 + 1);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if(var5 * (var4 - 1) >= World.worldCount) {
               --var4;
            }

            if(var4 * (var5 - 1) >= World.worldCount) {
               --var5;
            }

            if(var4 * (var5 - 1) >= World.worldCount) {
               --var5;
            }
         } while(var6 != var5 || var4 != var7);

         var6 = (765 - var4 * var21) / (var4 + 1);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var22 * var5) / (var5 + 1);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var21 * var4 - var6 * (var4 - 1)) / 2;
         int var9 = (480 - var5 * var22 - var7 * (var5 - 1)) / 2;
         int var10 = var9 + 23;
         int var11 = var8 + class90.field1419;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < World.worldCount; ++var14) {
            World var15 = class138.worldList[var14];
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
            if(var15.method1635()) {
               if(var15.method1638()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method1617()) {
               var19 = 16711680;
               if(var15.method1638()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method1615()) {
               if(var15.method1638()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method1638()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(MouseInput.field745 >= var11 && MouseInput.field746 >= var10 && MouseInput.field745 < var11 + var21 && MouseInput.field746 < var10 + var22 && var16) {
               class90.field1429 = var14;
               ClanMember.field916[var18].method5179(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               ClanMember.field916[var18].method5173(var11, var10);
            }

            if(class33.field488 != null) {
               class33.field488[(var15.method1638()?8:0) + var15.location].method5147(var11 + 29, var10);
            }

            var0.method4843(Integer.toString(var15.id), var11 + 15, var22 / 2 + var10 + 5, var19, -1);
            var1.method4843(var17, var11 + 60, var22 / 2 + var10 + 5, 268435455, -1);
            var10 = var10 + var22 + var7;
            ++var12;
            if(var12 >= var5) {
               var10 = var9 + 23;
               var11 = var11 + var6 + var21;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method4918(class138.worldList[class90.field1429].activity) + 6;
            int var20 = var1.verticalSpace + 8;
            Rasterizer2D.method5129(MouseInput.field745 - var14 / 2, MouseInput.field746 + 20 + 5, var14, var20, 16777120);
            Rasterizer2D.drawRectangle(MouseInput.field745 - var14 / 2, MouseInput.field746 + 20 + 5, var14, var20, 0);
            var1.method4843(class138.worldList[class90.field1429].activity, MouseInput.field745, MouseInput.field746 + var1.verticalSpace + 20 + 5 + 4, 0, -1);
         }
      }

      class12.field275.vmethod5136(0, 0);
   }
}
