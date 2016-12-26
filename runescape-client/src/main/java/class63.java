import java.awt.Canvas;
import java.awt.Container;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public class class63 implements Runnable {
   @ObfuscatedName("f")
   volatile boolean field1089 = false;
   @ObfuscatedName("e")
   volatile class57[] field1090 = new class57[2];
   @ObfuscatedName("k")
   volatile boolean field1091 = false;
   @ObfuscatedName("i")
   class103 field1092;
   @ObfuscatedName("eh")
   static SpritePixels field1095;

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "5"
   )
   static void method1131() {
      Client var0 = Client.field282;
      synchronized(Client.field282) {
         Container var1 = Client.field282.method2084();
         if(var1 != null) {
            class118.field1849 = Math.max(var1.getSize().width, class108.field1726);
            class104.field1679 = Math.max(var1.getSize().height, Item.field896);
            if(var1 == class164.field2162) {
               Insets var2 = class164.field2162.getInsets();
               class118.field1849 -= var2.right + var2.left;
               class104.field1679 -= var2.bottom + var2.top;
            }

            if(class118.field1849 <= 0) {
               class118.field1849 = 1;
            }

            if(class104.field1679 <= 0) {
               class104.field1679 = 1;
            }

            if(XGrandExchangeOffer.method57() == 1) {
               ItemLayer.field1223 = Client.field501;
               class112.field1755 = Client.field477 * 503;
            } else {
               ItemLayer.field1223 = Math.min(class118.field1849, 7680);
               class112.field1755 = Math.min(class104.field1679, 2160);
            }

            GameEngine.field1773 = (class118.field1849 - ItemLayer.field1223) / 2;
            GameEngine.field1774 = 0;
            class110.canvas.setSize(ItemLayer.field1223, class112.field1755);
            int var3 = ItemLayer.field1223;
            int var4 = class112.field1755;
            Canvas var5 = class110.canvas;

            Object var11;
            try {
               MainBufferProvider var6 = new MainBufferProvider();
               var6.init(var3, var4, var5);
               var11 = var6;
            } catch (Throwable var9) {
               SecondaryBufferProvider var7 = new SecondaryBufferProvider();
               var7.init(var3, var4, var5);
               var11 = var7;
            }

            ChatMessages.bufferProvider = (BufferProvider)var11;
            if(var1 == class164.field2162) {
               Insets var12 = class164.field2162.getInsets();
               class110.canvas.setLocation(GameEngine.field1773 + var12.left, GameEngine.field1774 + var12.top);
            } else {
               class110.canvas.setLocation(GameEngine.field1773, GameEngine.field1774);
            }

            class38.method704();
            if(Client.widgetRoot != -1) {
               class39.method710(true);
            }

            TextureProvider.method1423();
         }
      }
   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-1509047138"
   )
   static final void method1133(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class212.method3870(var0)) {
         class186.field2772 = null;
         class30.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class186.field2772 != null) {
            class30.gameDraw(class186.field2772, -1412584499, var1, var2, var3, var4, class116.field1815, Overlay.field3047, var7);
            class186.field2772 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field524[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field524[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Lclass178;",
      garbageValue = "-411876456"
   )
   public static class178 method1134(int var0) {
      class178[] var1 = class187.method3372();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class178 var3 = var1[var2];
         if(var0 == var3.field2677) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1362548304"
   )
   public static void method1135() {
      class105 var0 = class105.keyboard;
      synchronized(class105.keyboard) {
         ++class105.keyboardIdleTicks;
         class105.field1701 = class105.field1696;
         class105.field1692 = 0;
         int var1;
         if(class105.field1703 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               class105.field1693[var1] = false;
            }

            class105.field1703 = class105.field1695;
         } else {
            while(class105.field1695 != class105.field1703) {
               var1 = class105.field1694[class105.field1695];
               class105.field1695 = 1 + class105.field1695 & 127;
               if(var1 < 0) {
                  class105.field1693[~var1] = false;
               } else {
                  if(!class105.field1693[var1] && class105.field1692 < class105.field1699.length - 1) {
                     class105.field1699[++class105.field1692 - 1] = var1;
                  }

                  class105.field1693[var1] = true;
               }
            }
         }

         class105.field1696 = class105.field1702;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass159;IB)V",
      garbageValue = "107"
   )
   static void method1137(class159 var0, int var1) {
      boolean var2 = var0.method2978(1) == 1;
      if(var2) {
         class45.field917[++class45.field924 - 1] = var1;
      }

      int var3 = var0.method2978(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field263 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class45.field912[var1] = (var4.pathX[0] + class15.baseX >> 6 << 14) + (var4.field261 << 28) + (class20.baseY + var4.pathY[0] >> 6);
            if(var4.field626 != -1) {
               class45.field915[var1] = var4.field626;
            } else {
               class45.field915[var1] = var4.field649;
            }

            class45.field904[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.method2978(1) != 0) {
               class118.method2250(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method2978(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(var1 == Client.localInteractingIndex && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method235(var6, var7);
               var4.field263 = false;
            } else if(var2) {
               var4.field263 = true;
               var4.field264 = var6;
               var4.field265 = var7;
            } else {
               var4.field263 = false;
               var4.method221(var6, var7, class45.field913[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.method2978(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method235(var6, var7);
               var4.field263 = false;
            } else if(var2) {
               var4.field263 = true;
               var4.field264 = var6;
               var4.field265 = var7;
            } else {
               var4.field263 = false;
               var4.method221(var6, var7, class45.field913[var1]);
            }

         } else {
            var5 = var0.method2978(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method2978(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var4.pathX[0] + var8;
               var11 = var4.pathY[0] + var9;
               if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field263 = true;
                     var4.field264 = var10;
                     var4.field265 = var11;
                  } else {
                     var4.field263 = false;
                     var4.method221(var10, var11, class45.field913[var1]);
                  }
               } else {
                  var4.method235(var10, var11);
                  var4.field263 = false;
               }

               var4.field261 = (byte)(var4.field261 + var7 & 3);
               if(Client.localInteractingIndex == var1) {
                  class171.plane = var4.field261;
               }

            } else {
               var6 = var0.method2978(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + class15.baseX + var4.pathX[0] & 16383) - class15.baseX;
               var11 = (class20.baseY + var4.pathY[0] + var9 & 16383) - class20.baseY;
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field263 = true;
                     var4.field264 = var10;
                     var4.field265 = var11;
                  } else {
                     var4.field263 = false;
                     var4.method221(var10, var11, class45.field913[var1]);
                  }
               } else {
                  var4.method235(var10, var11);
                  var4.field263 = false;
               }

               var4.field261 = (byte)(var4.field261 + var7 & 3);
               if(var1 == Client.localInteractingIndex) {
                  class171.plane = var4.field261;
               }

            }
         }
      }
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIII)V",
      garbageValue = "1912434990"
   )
   static final void method1138(Player var0, int var1, int var2, int var3) {
      if(var0 != class39.localPlayer) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.field256 == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + class65.method1154(var0.combatLevel, class39.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.field256 + ")" + var0.actions[2];
            }

            int var5;
            if(Client.field526 == 1) {
               class184.addMenuEntry("Use", Client.field375 + " " + "->" + " " + class155.method2949(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.field523) {
               if((class187.field2780 & 8) == 8) {
                  class184.addMenuEntry(Client.field444, Client.field327 + " " + "->" + " " + class155.method2949(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(Client.field415[var5] != null) {
                     short var6 = 0;
                     if(Client.field415[var5].equalsIgnoreCase("Attack")) {
                        if(Client.field309 == class40.field815) {
                           continue;
                        }

                        if(Client.field309 == class40.field814 || class40.field817 == Client.field309 && var0.combatLevel > class39.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(class39.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == class39.localPlayer.team) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(Client.field416[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = var6 + Client.field487[var5];
                     class184.addMenuEntry(Client.field415[var5], class155.method2949(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = class155.method2949(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   public void run() {
      this.field1091 = true;

      try {
         while(!this.field1089) {
            for(int var1 = 0; var1 < 2; ++var1) {
               class57 var2 = this.field1090[var1];
               if(null != var2) {
                  var2.method1016();
               }
            }

            class10.method149(10L);
            class108.method2014(this.field1092, (Object)null);
         }
      } catch (Exception var7) {
         FaceNormal.method1864((String)null, var7);
      } finally {
         this.field1091 = false;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)[Lclass221;",
      garbageValue = "-1723148125"
   )
   public static class221[] method1139() {
      return new class221[]{class221.field3186, class221.field3185, class221.field3183, class221.field3184, class221.field3182};
   }
}
