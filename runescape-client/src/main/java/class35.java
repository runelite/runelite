import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class35 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   static final class35 field472;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   static final class35 field469;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1757737519
   )
   static int field475;
   @ObfuscatedName("ax")
   protected static boolean field474;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1203380503
   )
   final int field468;

   static {
      field472 = new class35(0);
      field469 = new class35(1);
   }

   class35(int var1) {
      this.field468 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljt;Ljt;I)V",
      garbageValue = "-905701926"
   )
   static void method540(Font var0, Font var1) {
      if(class29.field410 == null) {
         class29.field410 = Buffer.method3496(class96.indexSprites, "sl_back", "");
      }

      if(class256.field3431 == null) {
         class256.field3431 = class150.method3023(class96.indexSprites, "sl_flags", "");
      }

      if(class56.field651 == null) {
         class56.field651 = class150.method3023(class96.indexSprites, "sl_arrows", "");
      }

      if(class24.field350 == null) {
         class24.field350 = class150.method3023(class96.indexSprites, "sl_stars", "");
      }

      Rasterizer2D.method5151(class91.field1332, 23, 765, 480, 0);
      Rasterizer2D.method5155(class91.field1332, 0, 125, 23, 12425273, 9135624);
      Rasterizer2D.method5155(class91.field1332 + 125, 0, 640, 23, 5197647, 2697513);
      var0.method4934("Select a world", class91.field1332 + 62, 15, 0, -1);
      if(class24.field350 != null) {
         class24.field350[1].method5246(class91.field1332 + 140, 1);
         var1.method4931("Members only world", class91.field1332 + 152, 10, 16777215, -1);
         class24.field350[0].method5246(class91.field1332 + 140, 12);
         var1.method4931("Free world", class91.field1332 + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(class56.field651 != null) {
         int var2 = class91.field1332 + 280;
         if(World.field1213[0] == 0 && World.field1219[0] == 0) {
            class56.field651[2].method5246(var2, 4);
         } else {
            class56.field651[0].method5246(var2, 4);
         }

         if(World.field1213[0] == 0 && World.field1219[0] == 1) {
            class56.field651[3].method5246(var2 + 15, 4);
         } else {
            class56.field651[1].method5246(var2 + 15, 4);
         }

         var0.method4931("World", var2 + 32, 17, 16777215, -1);
         int var3 = class91.field1332 + 390;
         if(World.field1213[0] == 1 && World.field1219[0] == 0) {
            class56.field651[2].method5246(var3, 4);
         } else {
            class56.field651[0].method5246(var3, 4);
         }

         if(World.field1213[0] == 1 && World.field1219[0] == 1) {
            class56.field651[3].method5246(var3 + 15, 4);
         } else {
            class56.field651[1].method5246(var3 + 15, 4);
         }

         var0.method4931("Players", var3 + 32, 17, 16777215, -1);
         var4 = class91.field1332 + 500;
         if(World.field1213[0] == 2 && World.field1219[0] == 0) {
            class56.field651[2].method5246(var4, 4);
         } else {
            class56.field651[0].method5246(var4, 4);
         }

         if(World.field1213[0] == 2 && World.field1219[0] == 1) {
            class56.field651[3].method5246(var4 + 15, 4);
         } else {
            class56.field651[1].method5246(var4 + 15, 4);
         }

         var0.method4931("Location", var4 + 32, 17, 16777215, -1);
         var5 = class91.field1332 + 610;
         if(World.field1213[0] == 3 && World.field1219[0] == 0) {
            class56.field651[2].method5246(var5, 4);
         } else {
            class56.field651[0].method5246(var5, 4);
         }

         if(World.field1213[0] == 3 && World.field1219[0] == 1) {
            class56.field651[3].method5246(var5 + 15, 4);
         } else {
            class56.field651[1].method5246(var5 + 15, 4);
         }

         var0.method4931("Type", var5 + 32, 17, 16777215, -1);
      }

      Rasterizer2D.method5151(class91.field1332 + 708, 4, 50, 16, 0);
      var1.method4934("Cancel", class91.field1332 + 708 + 25, 16, 16777215, -1);
      class91.field1355 = -1;
      if(class29.field410 != null) {
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
         } while(var5 != var6 || var4 != var7);

         var6 = (765 - var21 * var4) / (var4 + 1);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var22 * var5) / (var5 + 1);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var4 * var21 - var6 * (var4 - 1)) / 2;
         int var9 = (480 - var22 * var5 - var7 * (var5 - 1)) / 2;
         int var10 = var9 + 23;
         int var11 = var8 + class91.field1332;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < World.worldCount; ++var14) {
            World var15 = Coordinates.worldList[var14];
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
            if(var15.method1639()) {
               if(var15.method1640()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method1656()) {
               var19 = 16711680;
               if(var15.method1640()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method1637()) {
               if(var15.method1640()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method1640()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(MouseInput.field704 >= var11 && MouseInput.field708 >= var10 && MouseInput.field704 < var21 + var11 && MouseInput.field708 < var10 + var22 && var16) {
               class91.field1355 = var14;
               class29.field410[var18].method5282(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               class29.field410[var18].method5276(var11, var10);
            }

            if(class256.field3431 != null) {
               class256.field3431[(var15.method1640()?8:0) + var15.location].method5246(var11 + 29, var10);
            }

            var0.method4934(Integer.toString(var15.id), var11 + 15, var22 / 2 + var10 + 5, var19, -1);
            var1.method4934(var17, var11 + 60, var22 / 2 + var10 + 5, 268435455, -1);
            var10 = var10 + var7 + var22;
            ++var12;
            if(var12 >= var5) {
               var10 = var9 + 23;
               var11 = var11 + var6 + var21;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method4926(Coordinates.worldList[class91.field1355].activity) + 6;
            int var20 = var1.verticalSpace + 8;
            Rasterizer2D.method5151(MouseInput.field704 - var14 / 2, MouseInput.field708 + 20 + 5, var14, var20, 16777120);
            Rasterizer2D.drawRectangle(MouseInput.field704 - var14 / 2, MouseInput.field708 + 20 + 5, var14, var20, 0);
            var1.method4934(Coordinates.worldList[class91.field1355].activity, MouseInput.field704, MouseInput.field708 + var1.verticalSpace + 20 + 5 + 4, 0, -1);
         }
      }

      class66.field779.vmethod5235(0, 0);
   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-35"
   )
   static void method541(int var0, int var1) {
      PacketNode var2 = Actor.method1628(ClientPacket.field2339, Client.field952.field1478);
      var2.packetBuffer.method3289(var0);
      var2.packetBuffer.method3319(var1);
      Client.field952.method1951(var2);
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "696875325"
   )
   static void method542() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3721(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3728()) {
         int var1 = var0.id;
         if(CombatInfoListHolder.loadWidget(var1)) {
            boolean var2 = true;
            Widget[] var3 = class243.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = PendingSpawn.method1612(var4);
               if(var5 != null) {
                  WorldMapData.method394(var5);
               }
            }
         }
      }

   }
}
