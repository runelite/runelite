import java.awt.Canvas;
import java.awt.Container;
import java.awt.Insets;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -247655901
   )
   @Export("y")
   int y;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 948830125
   )
   @Export("z")
   int z;
   @ObfuscatedName("i")
   static ModIcon field1568;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = -1314085189
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("nm")
   static class57 field1570;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1825433987
   )
   @Export("x")
   int x;

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIII)V",
      garbageValue = "-656137500"
   )
   static final void method1987(Player var0, int var1, int var2, int var3) {
      if(WidgetNode.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.field240 == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + class168.method3274(var0.combatLevel, WidgetNode.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.field240 + ")" + var0.actions[2];
            }

            int var5;
            if(Client.field416 == 1) {
               class6.addMenuEntry("Use", Client.field443 + " " + "->" + " " + class37.method813(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.field444) {
               if((CombatInfoListHolder.field759 & 8) == 8) {
                  class6.addMenuEntry(Client.field353, Client.field448 + " " + "->" + " " + class37.method813(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(Client.playerOptions[var5] != null) {
                     short var6 = 0;
                     if(Client.playerOptions[var5].equalsIgnoreCase("Attack")) {
                        if(Client.field313 == class40.field814) {
                           continue;
                        }

                        if(Client.field313 == class40.field812 || class40.field816 == Client.field313 && var0.combatLevel > WidgetNode.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(WidgetNode.localPlayer.team != 0 && var0.team != 0) {
                           if(WidgetNode.localPlayer.team == var0.team) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriority[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = Client.field414[var5] + var6;
                     class6.addMenuEntry(Client.playerOptions[var5], class37.method813(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = class37.method813(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-86618299"
   )
   static void method1988() {
      Client var0 = Client.field556;
      synchronized(Client.field556) {
         Container var1 = Client.field556.method2202();
         if(null != var1) {
            class63.field1106 = Math.max(var1.getSize().width, class72.field1193);
            Friend.field149 = Math.max(var1.getSize().height, class104.field1698);
            if(CollisionData.field1835 == var1) {
               Insets var2 = CollisionData.field1835.getInsets();
               class63.field1106 -= var2.right + var2.left;
               Friend.field149 -= var2.bottom + var2.top;
            }

            if(class63.field1106 <= 0) {
               class63.field1106 = 1;
            }

            if(Friend.field149 <= 0) {
               Friend.field149 = 1;
            }

            int var12 = Client.isResized?2:1;
            if(var12 == 1) {
               RSCanvas.field1756 = Client.field504;
               class65.field1128 = Client.field362 * 503;
            } else {
               RSCanvas.field1756 = Math.min(class63.field1106, 7680);
               class65.field1128 = Math.min(Friend.field149, 2160);
            }

            GameEngine.field1776 = (class63.field1106 - RSCanvas.field1756) / 2;
            GameEngine.field1777 = 0;
            class110.canvas.setSize(RSCanvas.field1756, class65.field1128);
            int var4 = RSCanvas.field1756;
            int var5 = class65.field1128;
            Canvas var6 = class110.canvas;

            Object var3;
            try {
               MainBufferProvider var7 = new MainBufferProvider();
               var7.init(var4, var5, var6);
               var3 = var7;
            } catch (Throwable var16) {
               SecondaryBufferProvider var8 = new SecondaryBufferProvider();
               var8.init(var4, var5, var6);
               var3 = var8;
            }

            class57.bufferProvider = (BufferProvider)var3;
            if(var1 == CollisionData.field1835) {
               Insets var18 = CollisionData.field1835.getInsets();
               class110.canvas.setLocation(GameEngine.field1776 + var18.left, var18.top + GameEngine.field1777);
            } else {
               class110.canvas.setLocation(GameEngine.field1776, GameEngine.field1777);
            }

            int var13 = RSCanvas.field1756;
            int var14 = class65.field1128;
            if(class63.field1106 < var13) {
               var13 = class63.field1106;
            }

            if(Friend.field149 < var14) {
               var14 = Friend.field149;
            }

            if(ObjectComposition.field2944 != null) {
               try {
                  Client var9 = Client.field556;
                  int var10 = Client.isResized?2:1;
                  class100.method2040(var9, "resize", new Object[]{Integer.valueOf(var10)});
               } catch (Throwable var15) {
                  ;
               }
            }

            if(Client.widgetRoot != -1) {
               class143.method2789(Client.widgetRoot, RSCanvas.field1756, class65.field1128, true);
            }

            class9.method111();
         }
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1749918871"
   )
   static final void method1989(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = (Client.field545 - Client.field472) * var5 / 100 + Client.field472;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field550) {
         var15 = Client.field550;
         var6 = var2 * var15 * 334 / (var3 * 512);
         if(var6 > Client.field549) {
            var6 = Client.field549;
            var8 = 512 * var3 * var6 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.method4018();
               Rasterizer2D.method4056(var0, var1, var9, var3, -16777216);
               Rasterizer2D.method4056(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= 2 * var9;
         }
      } else if(var7 > Client.field551) {
         var15 = Client.field551;
         var6 = 334 * var2 * var15 / (var3 * 512);
         if(var6 < Client.field548) {
            var6 = Client.field548;
            var8 = var15 * var2 * 334 / (512 * var6);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.method4018();
               Rasterizer2D.method4056(var0, var1, var2, var9, -16777216);
               Rasterizer2D.method4056(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= 2 * var9;
         }
      }

      var8 = Client.field571 + var5 * (Client.field547 - Client.field571) / 100;
      Client.scale = var3 * var6 * var8 / 85504 << 1;
      if(Client.camera2 != var2 || Client.camera3 != var3) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 15 + 128 + var10 * 32;
            int var12 = var11 * 3 + 600;
            int var13 = class84.field1460[var11];
            var14[var10] = var12 * var13 >> 16;
         }

         Region.method1824(var14, 500, 800, var2, var3);
      }

      Client.field552 = var0;
      Client.field553 = var1;
      Client.camera2 = var2;
      Client.camera3 = var3;
   }
}
