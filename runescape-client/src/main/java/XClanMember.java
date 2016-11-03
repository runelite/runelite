import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1958994049
   )
   @Export("world")
   int world;
   @ObfuscatedName("c")
   @Export("rank")
   byte rank;
   @ObfuscatedName("ef")
   static SpritePixels[] field623;
   @ObfuscatedName("q")
   String field625;
   @ObfuscatedName("k")
   @Export("username")
   String username;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass170;IIS)Z",
      garbageValue = "-256"
   )
   static boolean method604(class170 var0, int var1, int var2) {
      byte[] var3 = var0.method3305(var1, var2);
      if(null == var3) {
         return false;
      } else {
         class38.method771(var3);
         return true;
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static final void method605() {
      int var0;
      if(Client.widgetRoot != -1) {
         var0 = Client.widgetRoot;
         if(class85.method1938(var0)) {
            class24.method602(Widget.widgets[var0], -1);
         }
      }

      for(var0 = 0; var0 < Client.field483; ++var0) {
         if(Client.field485[var0]) {
            Client.field486[var0] = true;
         }

         Client.field487[var0] = Client.field485[var0];
         Client.field485[var0] = false;
      }

      Client.field484 = Client.gameCycle;
      Client.field429 = -1;
      Client.field437 = -1;
      class117.field2030 = null;
      if(Client.widgetRoot != -1) {
         Client.field483 = 0;
         class53.method1098(Client.widgetRoot, 0, 0, GroundObject.field1652, VertexNormal.field1689, 0, 0, -1);
      }

      class82.method1833();
      int var1;
      if(!Client.isMenuOpen) {
         if(Client.field429 != -1) {
            var0 = Client.field429;
            var1 = Client.field437;
            if(Client.menuOptionCount >= 2 || Client.field497 != 0 || Client.field435) {
               String var2;
               if(Client.field497 == 1 && Client.menuOptionCount < 2) {
                  var2 = "Use" + " " + Client.field434 + " " + "->";
               } else if(Client.field435 && Client.menuOptionCount < 2) {
                  var2 = Client.field328 + " " + Client.field439 + " " + "->";
               } else {
                  int var12 = Client.menuOptionCount - 1;
                  String var3;
                  if(Client.menuTargets[var12].length() > 0) {
                     var3 = Client.menuOptions[var12] + " " + Client.menuTargets[var12];
                  } else {
                     var3 = Client.menuOptions[var12];
                  }

                  var2 = var3;
               }

               if(Client.menuOptionCount > 2) {
                  var2 = var2 + class144.method3013(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2) + " more options";
               }

               PlayerComposition.field2977.method4079(var2, 4 + var0, var1 + 15, 16777215, 0, Client.gameCycle / 1000);
            }
         }
      } else {
         class157.method3190();
      }

      if(Client.field492 == 3) {
         for(var0 = 0; var0 < Client.field483; ++var0) {
            if(Client.field487[var0]) {
               class82.method1864(Client.widgetPositionX[var0], Client.widgetPositionY[var0], Client.widgetBoundsWidth[var0], Client.widgetBoundsHeight[var0], 16711935, 128);
            } else if(Client.field486[var0]) {
               class82.method1864(Client.widgetPositionX[var0], Client.widgetPositionY[var0], Client.widgetBoundsWidth[var0], Client.widgetBoundsHeight[var0], 16711680, 128);
            }
         }
      }

      var0 = class145.plane;
      var1 = class165.localPlayer.x;
      int var11 = class165.localPlayer.y;
      int var13 = Client.field357;

      for(class24 var4 = (class24)class24.field609.method3864(); null != var4; var4 = (class24)class24.field609.method3851()) {
         if(var4.field608 != -1 || null != var4.field612) {
            int var5 = 0;
            if(var1 > var4.field605) {
               var5 += var1 - var4.field605;
            } else if(var1 < var4.field603) {
               var5 += var4.field603 - var1;
            }

            if(var11 > var4.field607) {
               var5 += var11 - var4.field607;
            } else if(var11 < var4.field604) {
               var5 += var4.field604 - var11;
            }

            if(var5 - 64 <= var4.field606 && Client.field518 != 0 && var4.field616 == var0) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field606 - var5) * Client.field518 / var4.field606;
               Object var10000;
               if(var4.field601 == null) {
                  if(var4.field608 >= 0) {
                     var10000 = null;
                     class61 var7 = class61.method1292(class13.field195, var4.field608, 0);
                     if(null != var7) {
                        class65 var8 = var7.method1284().method1322(class166.field2695);
                        class67 var9 = class67.method1425(var8, 100, var6);
                        var9.method1347(-1);
                        class112.field1970.method1176(var9);
                        var4.field601 = var9;
                     }
                  }
               } else {
                  var4.field601.method1348(var6);
               }

               if(var4.field614 == null) {
                  if(null != var4.field612 && (var4.field613 -= var13) <= 0) {
                     int var14 = (int)(Math.random() * (double)var4.field612.length);
                     var10000 = null;
                     class61 var15 = class61.method1292(class13.field195, var4.field612[var14], 0);
                     if(null != var15) {
                        class65 var16 = var15.method1284().method1322(class166.field2695);
                        class67 var10 = class67.method1425(var16, 100, var6);
                        var10.method1347(0);
                        class112.field1970.method1176(var10);
                        var4.field614 = var10;
                        var4.field613 = var4.field610 + (int)(Math.random() * (double)(var4.field611 - var4.field610));
                     }
                  }
               } else {
                  var4.field614.method1348(var6);
                  if(!var4.field614.linked()) {
                     var4.field614 = null;
                  }
               }
            } else {
               if(null != var4.field601) {
                  class112.field1970.method1177(var4.field601);
                  var4.field601 = null;
               }

               if(null != var4.field614) {
                  class112.field1970.method1177(var4.field614);
                  var4.field614 = null;
               }
            }
         }
      }

      Client.field357 = 0;
   }
}
