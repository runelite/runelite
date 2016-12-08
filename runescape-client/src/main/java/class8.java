import java.awt.Canvas;
import java.awt.Container;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class8 {
   @ObfuscatedName("m")
   public static class182 field60;
   @ObfuscatedName("nr")
   static class57 field62;
   @ObfuscatedName("en")
   static SpritePixels[] field63;

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1039626419"
   )
   static void method89() {
      Client var0 = Client.field540;
      synchronized(Client.field540) {
         Container var1 = Client.field540.method2069();
         if(null != var1) {
            class105.field1720 = Math.max(var1.getSize().width, class38.field809);
            class45.field914 = Math.max(var1.getSize().height, WidgetNode.field185);
            if(class112.field1777 == var1) {
               Insets var2 = class112.field1777.getInsets();
               class105.field1720 -= var2.right + var2.left;
               class45.field914 -= var2.bottom + var2.top;
            }

            if(class105.field1720 <= 0) {
               class105.field1720 = 1;
            }

            if(class45.field914 <= 0) {
               class45.field914 = 1;
            }

            if(class47.method871() == 1) {
               TextureProvider.field1200 = Client.field499;
               class94.field1584 = Client.field383 * 503;
            } else {
               TextureProvider.field1200 = Math.min(class105.field1720, 7680);
               class94.field1584 = Math.min(class45.field914, 2160);
            }

            GameEngine.field1788 = (class105.field1720 - TextureProvider.field1200) / 2;
            GameEngine.field1793 = 0;
            class36.canvas.setSize(TextureProvider.field1200, class94.field1584);
            int var3 = TextureProvider.field1200;
            int var4 = class94.field1584;
            Canvas var5 = class36.canvas;

            Object var15;
            try {
               MainBufferProvider var6 = new MainBufferProvider();
               var6.init(var3, var4, var5);
               var15 = var6;
            } catch (Throwable var13) {
               SecondaryBufferProvider var7 = new SecondaryBufferProvider();
               var7.init(var3, var4, var5);
               var15 = var7;
            }

            TextureProvider.bufferProvider = (BufferProvider)var15;
            if(class112.field1777 == var1) {
               Insets var16 = class112.field1777.getInsets();
               class36.canvas.setLocation(GameEngine.field1788 + var16.left, var16.top + GameEngine.field1793);
            } else {
               class36.canvas.setLocation(GameEngine.field1788, GameEngine.field1793);
            }

            int var10 = TextureProvider.field1200;
            int var11 = class94.field1584;
            if(class105.field1720 < var10) {
               var10 = class105.field1720;
            }

            if(class45.field914 < var11) {
               var11 = class45.field914;
            }

            if(XGrandExchangeOffer.field35 != null) {
               try {
                  class100.method1901(Client.field540, "resize", new Object[]{Integer.valueOf(class47.method871())});
               } catch (Throwable var12) {
                  ;
               }
            }

            if(Client.widgetRoot != -1) {
               class112.method2051(true);
            }

            KitDefinition.method3429();
         }
      }
   }

   @ObfuscatedName("ef")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-1521400559"
   )
   static boolean method90(Widget var0) {
      if(Client.field454) {
         if(class217.method3874(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   @ObfuscatedName("qt")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "51"
   )
   protected static final void method91() {
      DecorativeObject.field1597 = null;
      class10.field103 = null;
      FaceNormal.field1555 = null;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-695162247"
   )
   static final void method92(boolean var0) {
      Client.field316 = 0;
      Client.field328 = 0;
      Client.field332.method2969();
      int var1 = Client.field332.method2986(8);
      int var2;
      if(var1 < Client.field492) {
         for(var2 = var1; var2 < Client.field492; ++var2) {
            Client.field287[++Client.field316 - 1] = Client.field327[var2];
         }
      }

      if(var1 > Client.field492) {
         throw new RuntimeException("");
      } else {
         Client.field492 = 0;

         int var5;
         int var6;
         int var7;
         int var8;
         for(var2 = 0; var2 < var1; ++var2) {
            int var10 = Client.field327[var2];
            NPC var4 = Client.cachedNPCs[var10];
            var5 = Client.field332.method2986(1);
            if(var5 == 0) {
               Client.field327[++Client.field492 - 1] = var10;
               var4.field653 = Client.gameCycle;
            } else {
               var6 = Client.field332.method2986(2);
               if(var6 == 0) {
                  Client.field327[++Client.field492 - 1] = var10;
                  var4.field653 = Client.gameCycle;
                  Client.field384[++Client.field328 - 1] = var10;
               } else if(var6 == 1) {
                  Client.field327[++Client.field492 - 1] = var10;
                  var4.field653 = Client.gameCycle;
                  var7 = Client.field332.method2986(3);
                  var4.method691(var7, (byte)1);
                  var8 = Client.field332.method2986(1);
                  if(var8 == 1) {
                     Client.field384[++Client.field328 - 1] = var10;
                  }
               } else if(var6 == 2) {
                  Client.field327[++Client.field492 - 1] = var10;
                  var4.field653 = Client.gameCycle;
                  var7 = Client.field332.method2986(3);
                  var4.method691(var7, (byte)2);
                  var8 = Client.field332.method2986(3);
                  var4.method691(var8, (byte)2);
                  int var9 = Client.field332.method2986(1);
                  if(var9 == 1) {
                     Client.field384[++Client.field328 - 1] = var10;
                  }
               } else if(var6 == 3) {
                  Client.field287[++Client.field316 - 1] = var10;
               }
            }
         }

         while(Client.field332.method2971(Client.field523) >= 27) {
            var1 = Client.field332.method2986(15);
            if(var1 == 32767) {
               break;
            }

            boolean var12 = false;
            if(null == Client.cachedNPCs[var1]) {
               Client.cachedNPCs[var1] = new NPC();
               var12 = true;
            }

            NPC var3 = Client.cachedNPCs[var1];
            Client.field327[++Client.field492 - 1] = var1;
            var3.field653 = Client.gameCycle;
            int var11 = Client.field332.method2986(1);
            if(var11 == 1) {
               Client.field384[++Client.field328 - 1] = var1;
            }

            var5 = Client.field415[Client.field332.method2986(3)];
            if(var12) {
               var3.angle = var5 * -1194406285;
               var3.field655 = var5;
            }

            var3.composition = class30.getNpcDefinition(Client.field332.method2986(14));
            if(var0) {
               var6 = Client.field332.method2986(8);
               if(var6 > 127) {
                  var6 -= 256;
               }
            } else {
               var6 = Client.field332.method2986(5);
               if(var6 > 15) {
                  var6 -= 32;
               }
            }

            var7 = Client.field332.method2986(1);
            if(var0) {
               var8 = Client.field332.method2986(8);
               if(var8 > 127) {
                  var8 -= 256;
               }
            } else {
               var8 = Client.field332.method2986(5);
               if(var8 > 15) {
                  var8 -= 32;
               }
            }

            var3.field612 = var3.composition.field2999;
            var3.field657 = var3.composition.field3011;
            if(var3.field657 == 0) {
               var3.angle = 0;
            }

            var3.field624 = var3.composition.field3005;
            var3.field640 = var3.composition.field3006;
            var3.field615 = var3.composition.field3007;
            var3.field648 = var3.composition.field3008;
            var3.idlePoseAnimation = var3.composition.field3002;
            var3.field646 = var3.composition.field3003;
            var3.field610 = var3.composition.field3024;
            var3.method697(var8 + class5.localPlayer.pathX[0], class5.localPlayer.pathY[0] + var6, var7 == 1);
         }

         Client.field332.method2992();
         class11.method146();

         for(var1 = 0; var1 < Client.field316; ++var1) {
            var2 = Client.field287[var1];
            if(Client.cachedNPCs[var2].field653 != Client.gameCycle) {
               Client.cachedNPCs[var2].composition = null;
               Client.cachedNPCs[var2] = null;
            }
         }

         if(Client.field523 != Client.field332.offset) {
            throw new RuntimeException(Client.field332.offset + "," + Client.field523);
         } else {
            for(var1 = 0; var1 < Client.field492; ++var1) {
               if(Client.cachedNPCs[Client.field327[var1]] == null) {
                  throw new RuntimeException(var1 + "," + Client.field492);
               }
            }

         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LGameEngine;B)V",
      garbageValue = "50"
   )
   static void method93(GameEngine var0) {
      if(class41.worldSelectShown) {
         class47.method864(var0);
      } else {
         if((class115.field1820 == 1 || !class148.field2047 && class115.field1820 == 4) && class115.field1823 >= class41.field860 + 765 - 50 && class115.field1825 >= 453) {
            XGrandExchangeOffer.field35.field700 = !XGrandExchangeOffer.field35.field700;
            class119.method2234();
            if(!XGrandExchangeOffer.field35.field700) {
               class1.method16(class119.field1864, "scape main", "", 255, false);
            } else {
               class138.field1926.method2488();
               class138.field1929 = 1;
               class138.field1930 = null;
            }
         }

         if(Client.gameState != 5) {
            ++class41.field834;
            if(Client.gameState == 10 || Client.gameState == 11) {
               int var1;
               if(Client.field509 == 0) {
                  if(class115.field1820 == 1 || !class148.field2047 && class115.field1820 == 4) {
                     var1 = 5 + class41.field860;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(class115.field1823 >= var1 && class115.field1823 <= var1 + var3 && class115.field1825 >= var2 && class115.field1825 <= var4 + var2) {
                        if(class25.loadWorlds()) {
                           class41.worldSelectShown = true;
                        }

                        return;
                     }
                  }

                  if(World.worldServersDownload != null && class25.loadWorlds()) {
                     class41.worldSelectShown = true;
                  }
               }

               var1 = class115.field1820;
               int var9 = class115.field1823;
               int var10 = class115.field1825;
               if(!class148.field2047 && var1 == 4) {
                  var1 = 1;
               }

               short var5;
               int var11;
               if(class41.loginIndex == 0) {
                  var11 = class41.loginWindowX + 180 - 80;
                  var5 = 291;
                  if(var1 == 1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                     Tile.method1518(class65.method1162("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var11 = 80 + class41.loginWindowX + 180;
                  if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                     if((Client.flags & 33554432) != 0) {
                        class41.field845 = "";
                        class41.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class41.loginMessage2 = "Your normal account will not be affected.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class41.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class41.loginMessage2 = "Players can attack each other almost everywhere";
                           class41.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class41.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class41.loginMessage2 = "Players can attack each other";
                           class41.loginMessage3 = "almost everywhere.";
                        }

                        class41.field845 = "Warning!";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class41.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class41.loginMessage2 = "The Protect Item prayer will";
                        class41.loginMessage3 = "not work on this world.";
                        class41.field845 = "Warning!";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     }
                  }
               } else if(class41.loginIndex != 1) {
                  short var12;
                  if(class41.loginIndex == 2) {
                     var12 = 231;
                     var11 = var12 + 30;
                     if(var1 == 1 && var10 >= var11 - 15 && var10 < var11) {
                        class41.loginIndex2 = 0;
                     }

                     var11 += 15;
                     if(var1 == 1 && var10 >= var11 - 15 && var10 < var11) {
                        class41.loginIndex2 = 1;
                     }

                     var11 += 15;
                     var12 = 361;
                     if(var1 == 1 && var10 >= var12 - 15 && var10 < var12) {
                        class47.method861("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class41.loginIndex = 5;
                        return;
                     }

                     int var13 = class41.loginWindowX + 180 - 80;
                     short var6 = 321;
                     if(var1 == 1 && var9 >= var13 - 75 && var9 <= var13 + 75 && var10 >= var6 - 20 && var10 <= var6 + 20) {
                        class41.username = class41.username.trim();
                        if(class41.username.length() == 0) {
                           class47.method861("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class41.field850.length() == 0) {
                           class47.method861("", "Please enter your password.", "");
                           return;
                        }

                        class47.method861("", "Connecting to server...", "");
                        class41.field844 = XGrandExchangeOffer.field35.field706.containsKey(Integer.valueOf(Friend.method172(class41.username)))?class97.field1632:class97.field1622;
                        class20.setGameState(20);
                        return;
                     }

                     var13 = 80 + 180 + class41.loginWindowX;
                     if(var1 == 1 && var9 >= var13 - 75 && var9 <= 75 + var13 && var10 >= var6 - 20 && var10 <= 20 + var6) {
                        class41.loginIndex = 0;
                        class41.username = "";
                        class41.field850 = "";
                        class206.field3091 = 0;
                        ChatMessages.authCode = "";
                        class41.field852 = true;
                     }

                     while(true) {
                        while(class11.method147()) {
                           boolean var7 = false;

                           for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                              if(class88.field1529 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                 var7 = true;
                                 break;
                              }
                           }

                           if(class177.field2670 == 13) {
                              class41.loginIndex = 0;
                              class41.username = "";
                              class41.field850 = "";
                              class206.field3091 = 0;
                              ChatMessages.authCode = "";
                              class41.field852 = true;
                           } else if(class41.loginIndex2 == 0) {
                              if(class177.field2670 == 85 && class41.username.length() > 0) {
                                 class41.username = class41.username.substring(0, class41.username.length() - 1);
                              }

                              if(class177.field2670 == 84 || class177.field2670 == 80) {
                                 class41.loginIndex2 = 1;
                              }

                              if(var7 && class41.username.length() < 320) {
                                 class41.username = class41.username + class88.field1529;
                              }
                           } else if(class41.loginIndex2 == 1) {
                              if(class177.field2670 == 85 && class41.field850.length() > 0) {
                                 class41.field850 = class41.field850.substring(0, class41.field850.length() - 1);
                              }

                              if(class177.field2670 == 84 || class177.field2670 == 80) {
                                 class41.loginIndex2 = 0;
                              }

                              if(class177.field2670 == 84) {
                                 class41.username = class41.username.trim();
                                 if(class41.username.length() == 0) {
                                    class47.method861("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class41.field850.length() == 0) {
                                    class47.method861("", "Please enter your password.", "");
                                    return;
                                 }

                                 class47.method861("", "Connecting to server...", "");
                                 class41.field844 = XGrandExchangeOffer.field35.field706.containsKey(Integer.valueOf(Friend.method172(class41.username)))?class97.field1632:class97.field1622;
                                 class20.setGameState(20);
                                 return;
                              }

                              if(var7 && class41.field850.length() < 20) {
                                 class41.field850 = class41.field850 + class88.field1529;
                              }
                           }
                        }

                        return;
                     }
                  } else if(class41.loginIndex == 3) {
                     var11 = 180 + class41.loginWindowX;
                     var5 = 276;
                     if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     }

                     var11 = class41.loginWindowX + 180;
                     var5 = 326;
                     if(var1 == 1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                        class47.method861("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class41.loginIndex = 5;
                        return;
                     }
                  } else {
                     boolean var14;
                     int var15;
                     if(class41.loginIndex == 4) {
                        var11 = class41.loginWindowX + 180 - 80;
                        var5 = 321;
                        if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                           ChatMessages.authCode.trim();
                           if(ChatMessages.authCode.length() != 6) {
                              class47.method861("", "Please enter a 6-digin PIN.", "");
                              return;
                           }

                           class206.field3091 = Integer.parseInt(ChatMessages.authCode);
                           ChatMessages.authCode = "";
                           class41.field844 = class41.field852?class97.field1628:class97.field1623;
                           class47.method861("", "Connecting to server...", "");
                           class20.setGameState(20);
                           return;
                        }

                        if(var1 == 1 && var9 >= 180 + class41.loginWindowX - 9 && var9 <= 130 + 180 + class41.loginWindowX && var10 >= 263 && var10 <= 296) {
                           class41.field852 = !class41.field852;
                        }

                        if(var1 == 1 && var9 >= class41.loginWindowX + 180 - 34 && var9 <= 34 + 180 + class41.loginWindowX && var10 >= 351 && var10 <= 363) {
                           Tile.method1518(class65.method1162("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                        }

                        var11 = 80 + 180 + class41.loginWindowX;
                        if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                           class41.loginIndex = 0;
                           class41.username = "";
                           class41.field850 = "";
                           class206.field3091 = 0;
                           ChatMessages.authCode = "";
                        }

                        while(class11.method147()) {
                           var14 = false;

                           for(var15 = 0; var15 < "1234567890".length(); ++var15) {
                              if(class88.field1529 == "1234567890".charAt(var15)) {
                                 var14 = true;
                                 break;
                              }
                           }

                           if(class177.field2670 == 13) {
                              class41.loginIndex = 0;
                              class41.username = "";
                              class41.field850 = "";
                              class206.field3091 = 0;
                              ChatMessages.authCode = "";
                           } else {
                              if(class177.field2670 == 85 && ChatMessages.authCode.length() > 0) {
                                 ChatMessages.authCode = ChatMessages.authCode.substring(0, ChatMessages.authCode.length() - 1);
                              }

                              if(class177.field2670 == 84) {
                                 ChatMessages.authCode.trim();
                                 if(ChatMessages.authCode.length() != 6) {
                                    class47.method861("", "Please enter a 6-digin PIN.", "");
                                    return;
                                 }

                                 class206.field3091 = Integer.parseInt(ChatMessages.authCode);
                                 ChatMessages.authCode = "";
                                 class41.field844 = class41.field852?class97.field1628:class97.field1623;
                                 class47.method861("", "Connecting to server...", "");
                                 class20.setGameState(20);
                                 return;
                              }

                              if(var14 && ChatMessages.authCode.length() < 6) {
                                 ChatMessages.authCode = ChatMessages.authCode + class88.field1529;
                              }
                           }
                        }
                     } else if(class41.loginIndex == 5) {
                        var11 = class41.loginWindowX + 180 - 80;
                        var5 = 321;
                        if(var1 == 1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                           class167.method3096();
                           return;
                        }

                        var11 = class41.loginWindowX + 180 + 80;
                        if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                           class41.field850 = "";
                        }

                        while(class11.method147()) {
                           var14 = false;

                           for(var15 = 0; var15 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var15) {
                              if(class88.field1529 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var15)) {
                                 var14 = true;
                                 break;
                              }
                           }

                           if(class177.field2670 == 13) {
                              class41.loginMessage1 = "";
                              class41.loginMessage2 = "Enter your username/email & password.";
                              class41.loginMessage3 = "";
                              class41.loginIndex = 2;
                              class41.loginIndex2 = 0;
                              class41.field850 = "";
                           } else {
                              if(class177.field2670 == 85 && class41.username.length() > 0) {
                                 class41.username = class41.username.substring(0, class41.username.length() - 1);
                              }

                              if(class177.field2670 == 84) {
                                 class167.method3096();
                                 return;
                              }

                              if(var14 && class41.username.length() < 320) {
                                 class41.username = class41.username + class88.field1529;
                              }
                           }
                        }
                     } else if(class41.loginIndex == 6) {
                        while(true) {
                           do {
                              if(!class11.method147()) {
                                 var12 = 321;
                                 if(var1 == 1 && var10 >= var12 - 20 && var10 <= 20 + var12) {
                                    class41.loginMessage1 = "";
                                    class41.loginMessage2 = "Enter your username/email & password.";
                                    class41.loginMessage3 = "";
                                    class41.loginIndex = 2;
                                    class41.loginIndex2 = 0;
                                    class41.field850 = "";
                                 }

                                 return;
                              }
                           } while(class177.field2670 != 84 && class177.field2670 != 13);

                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                           class41.field850 = "";
                        }
                     }
                  }
               } else {
                  while(class11.method147()) {
                     if(class177.field2670 == 84) {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     } else if(class177.field2670 == 13) {
                        class41.loginIndex = 0;
                     }
                  }

                  var11 = 180 + class41.loginWindowX - 80;
                  var5 = 321;
                  if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                     class41.loginMessage1 = "";
                     class41.loginMessage2 = "Enter your username/email & password.";
                     class41.loginMessage3 = "";
                     class41.loginIndex = 2;
                     class41.loginIndex2 = 0;
                  }

                  var11 = class41.loginWindowX + 180 + 80;
                  if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                     class41.loginIndex = 0;
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "-1256195618"
   )
   static void method94(Widget var0) {
      Widget var1 = var0.parentId == -1?null:class174.method3178(var0.parentId);
      int var2;
      int var3;
      if(var1 == null) {
         var2 = TextureProvider.field1200;
         var3 = class94.field1584;
      } else {
         var2 = var1.width;
         var3 = var1.height;
      }

      class138.method2445(var0, var2, var3, false);
      WallObject.method1839(var0, var2, var3);
   }
}
