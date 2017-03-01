import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.IOException;
import java.net.URI;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public class class181 extends CacheableNode {
   @ObfuscatedName("f")
   static int[] field2701;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2091265801
   )
   int field2702;
   @ObfuscatedName("x")
   class184 field2704;
   @ObfuscatedName("g")
   byte field2707;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)LWorld;",
      garbageValue = "779798698"
   )
   static World method3349() {
      World.field676 = 0;
      return ScriptState.method159();
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "2007543518"
   )
   static final void method3350(boolean var0) {
      class112.method2179();
      ++Client.field338;
      if(Client.field338 >= 50 || var0) {
         Client.field338 = 0;
         if(!Client.field343 && null != XGrandExchangeOffer.field30) {
            Client.field332.method3144(25);

            try {
               XGrandExchangeOffer.field30.method2148(Client.field332.payload, 0, Client.field332.offset);
               Client.field332.offset = 0;
            } catch (IOException var2) {
               Client.field343 = true;
            }
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LGameEngine;I)V",
      garbageValue = "1814479068"
   )
   static void method3351(GameEngine var0) {
      int var1;
      int var2;
      int var3;
      int var19;
      if(class41.worldSelectShown) {
         if(class115.field1811 == 1 || !Client.field291 && class115.field1811 == 4) {
            var1 = 280 + class41.field822;
            if(class115.field1812 >= var1 && class115.field1812 <= 14 + var1 && class115.field1813 >= 4 && class115.field1813 <= 18) {
               class186.method3494(0, 0);
            } else if(class115.field1812 >= var1 + 15 && class115.field1812 <= var1 + 80 && class115.field1813 >= 4 && class115.field1813 <= 18) {
               class186.method3494(0, 1);
            } else {
               var2 = class41.field822 + 390;
               if(class115.field1812 >= var2 && class115.field1812 <= 14 + var2 && class115.field1813 >= 4 && class115.field1813 <= 18) {
                  class186.method3494(1, 0);
               } else if(class115.field1812 >= 15 + var2 && class115.field1812 <= 80 + var2 && class115.field1813 >= 4 && class115.field1813 <= 18) {
                  class186.method3494(1, 1);
               } else {
                  var3 = class41.field822 + 500;
                  if(class115.field1812 >= var3 && class115.field1812 <= 14 + var3 && class115.field1813 >= 4 && class115.field1813 <= 18) {
                     class186.method3494(2, 0);
                  } else if(class115.field1812 >= 15 + var3 && class115.field1812 <= 80 + var3 && class115.field1813 >= 4 && class115.field1813 <= 18) {
                     class186.method3494(2, 1);
                  } else {
                     var19 = 610 + class41.field822;
                     if(class115.field1812 >= var19 && class115.field1812 <= 14 + var19 && class115.field1813 >= 4 && class115.field1813 <= 18) {
                        class186.method3494(3, 0);
                     } else if(class115.field1812 >= 15 + var19 && class115.field1812 <= var19 + 80 && class115.field1813 >= 4 && class115.field1813 <= 18) {
                        class186.method3494(3, 1);
                     } else if(class115.field1812 >= 708 + class41.field822 && class115.field1813 >= 4 && class115.field1812 <= 50 + 708 + class41.field822 && class115.field1813 <= 20) {
                        class41.worldSelectShown = false;
                        class41.field824.method4172(class41.field822, 0);
                        class41.field825.method4172(class41.field822 + 382, 0);
                        class168.field2191.method4115(class41.field822 + 382 - class168.field2191.originalWidth / 2, 18);
                     } else if(class41.field823 != -1) {
                        World var5 = CombatInfoListHolder.worldList[class41.field823];
                        Frames.method1994(var5);
                        class41.worldSelectShown = false;
                        class41.field824.method4172(class41.field822, 0);
                        class41.field825.method4172(class41.field822 + 382, 0);
                        class168.field2191.method4115(class41.field822 + 382 - class168.field2191.originalWidth / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((class115.field1811 == 1 || !Client.field291 && class115.field1811 == 4) && class115.field1812 >= class41.field822 + 765 - 50 && class115.field1813 >= 453) {
            ObjectComposition.field2944.field691 = !ObjectComposition.field2944.field691;
            class146.method2811();
            if(!ObjectComposition.field2944.field691) {
               class184 var9 = Client.field306;
               var2 = var9.method3426("scape main");
               var3 = var9.method3370(var2, "");
               class44.method892(var9, var2, var3, 255, false);
            } else {
               class138.field1919.method2672();
               class138.field1921 = 1;
               class138.field1924 = null;
            }
         }

         if(Client.gameState != 5) {
            ++class41.field834;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.field428 == 0) {
                  if(class115.field1811 == 1 || !Client.field291 && class115.field1811 == 4) {
                     var1 = class41.field822 + 5;
                     short var16 = 463;
                     byte var17 = 100;
                     byte var4 = 35;
                     if(class115.field1812 >= var1 && class115.field1812 <= var1 + var17 && class115.field1813 >= var16 && class115.field1813 <= var16 + var4) {
                        if(class162.loadWorlds()) {
                           class41.worldSelectShown = true;
                        }

                        return;
                     }
                  }

                  if(class22.worldServersDownload != null && class162.loadWorlds()) {
                     class41.worldSelectShown = true;
                  }
               }

               var1 = class115.field1811;
               var2 = class115.field1812;
               var3 = class115.field1813;
               if(!Client.field291 && var1 == 4) {
                  var1 = 1;
               }

               short var6;
               int var10;
               if(class41.loginIndex == 0) {
                  boolean var18 = false;

                  while(class16.method196()) {
                     if(class13.field131 == 84) {
                        var18 = true;
                     }
                  }

                  var10 = class41.loginWindowX + 180 - 80;
                  var6 = 291;
                  if(var1 == 1 && var2 >= var10 - 75 && var2 <= var10 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                     label922: {
                        String var7 = class0.method11("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws";
                        if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                           try {
                              Desktop.getDesktop().browse(new URI(var7));
                              break label922;
                           } catch (Exception var15) {
                              ;
                           }
                        }

                        if(class114.field1786.startsWith("win")) {
                           class49.method976(var7, 0, "openjs");
                        } else if(class114.field1786.startsWith("mac")) {
                           class49.method976(var7, 1, "openjs");
                        } else {
                           class49.method976(var7, 2, "openjs");
                        }
                     }
                  }

                  var10 = 180 + class41.loginWindowX + 80;
                  if(var1 == 1 && var2 >= var10 - 75 && var2 <= 75 + var10 && var3 >= var6 - 20 && var3 <= 20 + var6 || var18) {
                     if((Client.flags & 33554432) != 0) {
                        class41.field840 = "";
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

                        class41.field840 = "Warning!";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class41.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class41.loginMessage2 = "The Protect Item prayer will";
                        class41.loginMessage3 = "not work on this world.";
                        class41.field840 = "Warning!";
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
               } else {
                  short var22;
                  if(class41.loginIndex != 1) {
                     short var20;
                     if(class41.loginIndex == 2) {
                        var20 = 231;
                        var19 = var20 + 30;
                        if(var1 == 1 && var3 >= var19 - 15 && var3 < var19) {
                           class41.loginIndex2 = 0;
                        }

                        var19 += 15;
                        if(var1 == 1 && var3 >= var19 - 15 && var3 < var19) {
                           class41.loginIndex2 = 1;
                        }

                        var19 += 15;
                        var20 = 361;
                        if(var1 == 1 && var3 >= var20 - 15 && var3 < var20) {
                           class41.method864("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class41.loginIndex = 5;
                           return;
                        }

                        var10 = 180 + class41.loginWindowX - 80;
                        var6 = 321;
                        if(var1 == 1 && var2 >= var10 - 75 && var2 <= 75 + var10 && var3 >= var6 - 20 && var3 <= 20 + var6) {
                           class41.username = class41.username.trim();
                           if(class41.username.length() == 0) {
                              class41.method864("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class41.field845.length() == 0) {
                              class41.method864("", "Please enter your password.", "");
                              return;
                           }

                           class41.method864("", "Connecting to server...", "");
                           class41.field846 = ObjectComposition.field2944.field692.containsKey(Integer.valueOf(Tile.method1640(class41.username)))?class97.field1639:class97.field1637;
                           World.setGameState(20);
                           return;
                        }

                        var10 = 180 + class41.loginWindowX + 80;
                        if(var1 == 1 && var2 >= var10 - 75 && var2 <= 75 + var10 && var3 >= var6 - 20 && var3 <= 20 + var6) {
                           class41.loginIndex = 0;
                           class41.username = "";
                           class41.field845 = "";
                           class6.field54 = 0;
                           XItemContainer.authCode = "";
                           class41.field847 = true;
                        }

                        while(true) {
                           while(class16.method196()) {
                              boolean var11 = false;

                              for(int var12 = 0; var12 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var12) {
                                 if(class1.field8 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var12)) {
                                    var11 = true;
                                    break;
                                 }
                              }

                              if(class13.field131 == 13) {
                                 class41.loginIndex = 0;
                                 class41.username = "";
                                 class41.field845 = "";
                                 class6.field54 = 0;
                                 XItemContainer.authCode = "";
                                 class41.field847 = true;
                              } else if(class41.loginIndex2 == 0) {
                                 if(class13.field131 == 85 && class41.username.length() > 0) {
                                    class41.username = class41.username.substring(0, class41.username.length() - 1);
                                 }

                                 if(class13.field131 == 84 || class13.field131 == 80) {
                                    class41.loginIndex2 = 1;
                                 }

                                 if(var11 && class41.username.length() < 320) {
                                    class41.username = class41.username + class1.field8;
                                 }
                              } else if(class41.loginIndex2 == 1) {
                                 if(class13.field131 == 85 && class41.field845.length() > 0) {
                                    class41.field845 = class41.field845.substring(0, class41.field845.length() - 1);
                                 }

                                 if(class13.field131 == 84 || class13.field131 == 80) {
                                    class41.loginIndex2 = 0;
                                 }

                                 if(class13.field131 == 84) {
                                    class41.username = class41.username.trim();
                                    if(class41.username.length() == 0) {
                                       class41.method864("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class41.field845.length() == 0) {
                                       class41.method864("", "Please enter your password.", "");
                                       return;
                                    }

                                    class41.method864("", "Connecting to server...", "");
                                    class41.field846 = ObjectComposition.field2944.field692.containsKey(Integer.valueOf(Tile.method1640(class41.username)))?class97.field1639:class97.field1637;
                                    World.setGameState(20);
                                    return;
                                 }

                                 if(var11 && class41.field845.length() < 20) {
                                    class41.field845 = class41.field845 + class1.field8;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class41.loginIndex == 3) {
                        var19 = class41.loginWindowX + 180;
                        var22 = 276;
                        if(var1 == 1 && var2 >= var19 - 75 && var2 <= 75 + var19 && var3 >= var22 - 20 && var3 <= var22 + 20) {
                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                        }

                        var19 = class41.loginWindowX + 180;
                        var22 = 326;
                        if(var1 == 1 && var2 >= var19 - 75 && var2 <= 75 + var19 && var3 >= var22 - 20 && var3 <= 20 + var22) {
                           class41.method864("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class41.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var21;
                        int var23;
                        if(class41.loginIndex == 4) {
                           var19 = class41.loginWindowX + 180 - 80;
                           var22 = 321;
                           if(var1 == 1 && var2 >= var19 - 75 && var2 <= var19 + 75 && var3 >= var22 - 20 && var3 <= var22 + 20) {
                              XItemContainer.authCode.trim();
                              if(XItemContainer.authCode.length() != 6) {
                                 class41.method864("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              class6.field54 = Integer.parseInt(XItemContainer.authCode);
                              XItemContainer.authCode = "";
                              class41.field846 = class41.field847?class97.field1635:class97.field1641;
                              class41.method864("", "Connecting to server...", "");
                              World.setGameState(20);
                              return;
                           }

                           if(var1 == 1 && var2 >= 180 + class41.loginWindowX - 9 && var2 <= 180 + class41.loginWindowX + 130 && var3 >= 263 && var3 <= 296) {
                              class41.field847 = !class41.field847;
                           }

                           if(var1 == 1 && var2 >= 180 + class41.loginWindowX - 34 && var2 <= 34 + class41.loginWindowX + 180 && var3 >= 351 && var3 <= 363) {
                              label937: {
                                 String var13 = class0.method11("secure", true) + "m=totp-authenticator/disableTOTPRequest";
                                 if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                                    try {
                                       Desktop.getDesktop().browse(new URI(var13));
                                       break label937;
                                    } catch (Exception var14) {
                                       ;
                                    }
                                 }

                                 if(class114.field1786.startsWith("win")) {
                                    class49.method976(var13, 0, "openjs");
                                 } else if(class114.field1786.startsWith("mac")) {
                                    class49.method976(var13, 1, "openjs");
                                 } else {
                                    class49.method976(var13, 2, "openjs");
                                 }
                              }
                           }

                           var19 = 80 + 180 + class41.loginWindowX;
                           if(var1 == 1 && var2 >= var19 - 75 && var2 <= var19 + 75 && var3 >= var22 - 20 && var3 <= 20 + var22) {
                              class41.loginIndex = 0;
                              class41.username = "";
                              class41.field845 = "";
                              class6.field54 = 0;
                              XItemContainer.authCode = "";
                           }

                           while(class16.method196()) {
                              var21 = false;

                              for(var23 = 0; var23 < "1234567890".length(); ++var23) {
                                 if(class1.field8 == "1234567890".charAt(var23)) {
                                    var21 = true;
                                    break;
                                 }
                              }

                              if(class13.field131 == 13) {
                                 class41.loginIndex = 0;
                                 class41.username = "";
                                 class41.field845 = "";
                                 class6.field54 = 0;
                                 XItemContainer.authCode = "";
                              } else {
                                 if(class13.field131 == 85 && XItemContainer.authCode.length() > 0) {
                                    XItemContainer.authCode = XItemContainer.authCode.substring(0, XItemContainer.authCode.length() - 1);
                                 }

                                 if(class13.field131 == 84) {
                                    XItemContainer.authCode.trim();
                                    if(XItemContainer.authCode.length() != 6) {
                                       class41.method864("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    class6.field54 = Integer.parseInt(XItemContainer.authCode);
                                    XItemContainer.authCode = "";
                                    class41.field846 = class41.field847?class97.field1635:class97.field1641;
                                    class41.method864("", "Connecting to server...", "");
                                    World.setGameState(20);
                                    return;
                                 }

                                 if(var21 && XItemContainer.authCode.length() < 6) {
                                    XItemContainer.authCode = XItemContainer.authCode + class1.field8;
                                 }
                              }
                           }
                        } else if(class41.loginIndex == 5) {
                           var19 = class41.loginWindowX + 180 - 80;
                           var22 = 321;
                           if(var1 == 1 && var2 >= var19 - 75 && var2 <= 75 + var19 && var3 >= var22 - 20 && var3 <= 20 + var22) {
                              class118.method2380();
                              return;
                           }

                           var19 = 80 + class41.loginWindowX + 180;
                           if(var1 == 1 && var2 >= var19 - 75 && var2 <= var19 + 75 && var3 >= var22 - 20 && var3 <= var22 + 20) {
                              class41.loginMessage1 = "";
                              class41.loginMessage2 = "Enter your username/email & password.";
                              class41.loginMessage3 = "";
                              class41.loginIndex = 2;
                              class41.loginIndex2 = 0;
                              class41.field845 = "";
                           }

                           while(class16.method196()) {
                              var21 = false;

                              for(var23 = 0; var23 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var23) {
                                 if(class1.field8 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var23)) {
                                    var21 = true;
                                    break;
                                 }
                              }

                              if(class13.field131 == 13) {
                                 class41.loginMessage1 = "";
                                 class41.loginMessage2 = "Enter your username/email & password.";
                                 class41.loginMessage3 = "";
                                 class41.loginIndex = 2;
                                 class41.loginIndex2 = 0;
                                 class41.field845 = "";
                              } else {
                                 if(class13.field131 == 85 && class41.username.length() > 0) {
                                    class41.username = class41.username.substring(0, class41.username.length() - 1);
                                 }

                                 if(class13.field131 == 84) {
                                    class118.method2380();
                                    return;
                                 }

                                 if(var21 && class41.username.length() < 320) {
                                    class41.username = class41.username + class1.field8;
                                 }
                              }
                           }
                        } else if(class41.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!class16.method196()) {
                                    var20 = 321;
                                    if(var1 == 1 && var3 >= var20 - 20 && var3 <= var20 + 20) {
                                       class41.loginMessage1 = "";
                                       class41.loginMessage2 = "Enter your username/email & password.";
                                       class41.loginMessage3 = "";
                                       class41.loginIndex = 2;
                                       class41.loginIndex2 = 0;
                                       class41.field845 = "";
                                    }

                                    return;
                                 }
                              } while(class13.field131 != 84 && class13.field131 != 13);

                              class41.loginMessage1 = "";
                              class41.loginMessage2 = "Enter your username/email & password.";
                              class41.loginMessage3 = "";
                              class41.loginIndex = 2;
                              class41.loginIndex2 = 0;
                              class41.field845 = "";
                           }
                        }
                     }
                  } else {
                     while(class16.method196()) {
                        if(class13.field131 == 84) {
                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                        } else if(class13.field131 == 13) {
                           class41.loginIndex = 0;
                        }
                     }

                     var19 = class41.loginWindowX + 180 - 80;
                     var22 = 321;
                     if(var1 == 1 && var2 >= var19 - 75 && var2 <= var19 + 75 && var3 >= var22 - 20 && var3 <= var22 + 20) {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     }

                     var19 = 80 + 180 + class41.loginWindowX;
                     if(var1 == 1 && var2 >= var19 - 75 && var2 <= 75 + var19 && var3 >= var22 - 20 && var3 <= var22 + 20) {
                        class41.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }
}
