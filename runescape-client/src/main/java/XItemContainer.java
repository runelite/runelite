import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("g")
   @Export("itemIds")
   int[] itemIds = new int[]{-1};
   @ObfuscatedName("p")
   static String field223;
   @ObfuscatedName("r")
   @Export("stackSizes")
   int[] stackSizes = new int[]{0};
   @ObfuscatedName("l")
   @Export("itemContainers")
   static XHashTable itemContainers = new XHashTable(32);
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1891841803
   )
   public static int field227;

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2022311415"
   )
   static final void method187(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field496; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var2 + var0 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var1 + var3) {
            Client.field499[var4] = true;
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LGameEngine;I)V",
      garbageValue = "14240292"
   )
   static void method201(GameEngine var0) {
      if(class33.worldSelectShown) {
         class18.method217(var0);
      } else {
         if((class143.field2217 == 1 || !class214.field3188 && class143.field2217 == 4) && class143.field2215 >= 765 + class33.field741 - 50 && class143.field2216 >= 453) {
            class136.field2123.field148 = !class136.field2123.field148;
            ObjectComposition.method886();
            if(!class136.field2123.field148) {
               class35.method757(class188.field3051, "scape main", "", 255, false);
            } else {
               class59.field1266.method3754();
               class186.field3010 = 1;
               CollisionData.field1970 = null;
            }
         }

         if(Client.gameState != 5) {
            ++class33.field775;
            if(Client.gameState == 10 || Client.gameState == 11) {
               int var1;
               if(Client.field326 == 0) {
                  if(class143.field2217 == 1 || !class214.field3188 && class143.field2217 == 4) {
                     var1 = 5 + class33.field741;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(class143.field2215 >= var1 && class143.field2215 <= var3 + var1 && class143.field2216 >= var2 && class143.field2216 <= var2 + var4) {
                        if(Player.loadWorlds()) {
                           class33.worldSelectShown = true;
                        }

                        return;
                     }
                  }

                  if(class117.worldServersDownload != null && Player.loadWorlds()) {
                     class33.worldSelectShown = true;
                  }
               }

               var1 = class143.field2217;
               int var11 = class143.field2215;
               int var12 = class143.field2216;
               if(!class214.field3188 && var1 == 4) {
                  var1 = 1;
               }

               int var5;
               short var13;
               if(class33.loginIndex == 0) {
                  var5 = 180 + class33.loginWindowX - 80;
                  var13 = 291;
                  if(var1 == 1 && var11 >= var5 - 75 && var11 <= var5 + 75 && var12 >= var13 - 20 && var12 <= var13 + 20) {
                     FrameMap.method2384(class138.method3023("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var5 = 80 + class33.loginWindowX + 180;
                  if(var1 == 1 && var11 >= var5 - 75 && var11 <= 75 + var5 && var12 >= var13 - 20 && var12 <= var13 + 20) {
                     if((Client.flags & 33554432) != 0) {
                        class33.field740 = "";
                        class33.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class33.loginMessage2 = "Your normal account will not be affected.";
                        class33.loginMessage3 = "";
                        class33.loginIndex = 1;
                        class33.loginIndex2 = 0;
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class33.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class33.loginMessage2 = "Players can attack each other almost everywhere";
                           class33.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class33.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class33.loginMessage2 = "Players can attack each other";
                           class33.loginMessage3 = "almost everywhere.";
                        }

                        class33.field740 = "Warning!";
                        class33.loginIndex = 1;
                        class33.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class33.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class33.loginMessage2 = "The Protect Item prayer will";
                        class33.loginMessage3 = "not work on this world.";
                        class33.field740 = "Warning!";
                        class33.loginIndex = 1;
                        class33.loginIndex2 = 0;
                     } else {
                        class33.loginMessage1 = "";
                        class33.loginMessage2 = "Enter your username/email & password.";
                        class33.loginMessage3 = "";
                        class33.loginIndex = 2;
                        class33.loginIndex2 = 0;
                     }
                  }
               } else if(class33.loginIndex != 1) {
                  short var6;
                  if(class33.loginIndex == 2) {
                     var6 = 231;
                     var5 = var6 + 30;
                     if(var1 == 1 && var12 >= var5 - 15 && var12 < var5) {
                        class33.loginIndex2 = 0;
                     }

                     var5 += 15;
                     if(var1 == 1 && var12 >= var5 - 15 && var12 < var5) {
                        class33.loginIndex2 = 1;
                     }

                     var5 += 15;
                     var6 = 361;
                     if(var1 == 1 && var12 >= var6 - 15 && var12 < var6) {
                        MessageNode.method781("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class33.loginIndex = 5;
                        return;
                     }

                     int var14 = 180 + class33.loginWindowX - 80;
                     short var15 = 321;
                     if(var1 == 1 && var11 >= var14 - 75 && var11 <= 75 + var14 && var12 >= var15 - 20 && var12 <= var15 + 20) {
                        class33.username = class33.username.trim();
                        if(class33.username.length() == 0) {
                           MessageNode.method781("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class33.field765.length() == 0) {
                           MessageNode.method781("", "Please enter your password.", "");
                           return;
                        }

                        MessageNode.method781("", "Connecting to server...", "");
                        class33.field766 = class136.field2123.field147.containsKey(Integer.valueOf(ItemComposition.method1234(class33.username)))?class162.field2664:class162.field2661;
                        class138.setGameState(20);
                        return;
                     }

                     var14 = 180 + class33.loginWindowX + 80;
                     if(var1 == 1 && var11 >= var14 - 75 && var11 <= var14 + 75 && var12 >= var15 - 20 && var12 <= var15 + 20) {
                        class33.loginIndex = 0;
                        class33.username = "";
                        class33.field765 = "";
                        class174.field2788 = 0;
                        class33.authCode = "";
                        class33.field768 = true;
                     }

                     while(true) {
                        while(class151.method3275()) {
                           boolean var9 = false;

                           for(int var10 = 0; var10 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var10) {
                              if(class51.field1146 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var10)) {
                                 var9 = true;
                                 break;
                              }
                           }

                           if(XClanMember.field643 == 13) {
                              class33.loginIndex = 0;
                              class33.username = "";
                              class33.field765 = "";
                              class174.field2788 = 0;
                              class33.authCode = "";
                              class33.field768 = true;
                           } else if(class33.loginIndex2 == 0) {
                              if(XClanMember.field643 == 85 && class33.username.length() > 0) {
                                 class33.username = class33.username.substring(0, class33.username.length() - 1);
                              }

                              if(XClanMember.field643 == 84 || XClanMember.field643 == 80) {
                                 class33.loginIndex2 = 1;
                              }

                              if(var9 && class33.username.length() < 320) {
                                 class33.username = class33.username + class51.field1146;
                              }
                           } else if(class33.loginIndex2 == 1) {
                              if(XClanMember.field643 == 85 && class33.field765.length() > 0) {
                                 class33.field765 = class33.field765.substring(0, class33.field765.length() - 1);
                              }

                              if(XClanMember.field643 == 84 || XClanMember.field643 == 80) {
                                 class33.loginIndex2 = 0;
                              }

                              if(XClanMember.field643 == 84) {
                                 class33.username = class33.username.trim();
                                 if(class33.username.length() == 0) {
                                    MessageNode.method781("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class33.field765.length() == 0) {
                                    MessageNode.method781("", "Please enter your password.", "");
                                    return;
                                 }

                                 MessageNode.method781("", "Connecting to server...", "");
                                 class33.field766 = class136.field2123.field147.containsKey(Integer.valueOf(ItemComposition.method1234(class33.username)))?class162.field2664:class162.field2661;
                                 class138.setGameState(20);
                                 return;
                              }

                              if(var9 && class33.field765.length() < 20) {
                                 class33.field765 = class33.field765 + class51.field1146;
                              }
                           }
                        }

                        return;
                     }
                  }

                  if(class33.loginIndex == 3) {
                     var5 = 180 + class33.loginWindowX;
                     var13 = 276;
                     if(var1 == 1 && var11 >= var5 - 75 && var11 <= var5 + 75 && var12 >= var13 - 20 && var12 <= var13 + 20) {
                        class33.loginMessage1 = "";
                        class33.loginMessage2 = "Enter your username/email & password.";
                        class33.loginMessage3 = "";
                        class33.loginIndex = 2;
                        class33.loginIndex2 = 0;
                     }

                     var5 = 180 + class33.loginWindowX;
                     var13 = 326;
                     if(var1 == 1 && var11 >= var5 - 75 && var11 <= 75 + var5 && var12 >= var13 - 20 && var12 <= var13 + 20) {
                        MessageNode.method781("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class33.loginIndex = 5;
                        return;
                     }
                  } else {
                     boolean var7;
                     int var8;
                     if(class33.loginIndex == 4) {
                        var5 = 180 + class33.loginWindowX - 80;
                        var13 = 321;
                        if(var1 == 1 && var11 >= var5 - 75 && var11 <= var5 + 75 && var12 >= var13 - 20 && var12 <= var13 + 20) {
                           class33.authCode.trim();
                           if(class33.authCode.length() != 6) {
                              MessageNode.method781("", "Please enter a 6-digin PIN.", "");
                              return;
                           }

                           class174.field2788 = Integer.parseInt(class33.authCode);
                           class33.authCode = "";
                           class33.field766 = class33.field768?class162.field2660:class162.field2662;
                           MessageNode.method781("", "Connecting to server...", "");
                           class138.setGameState(20);
                           return;
                        }

                        if(var1 == 1 && var11 >= 180 + class33.loginWindowX - 9 && var11 <= 130 + class33.loginWindowX + 180 && var12 >= 263 && var12 <= 296) {
                           class33.field768 = !class33.field768;
                        }

                        if(var1 == 1 && var11 >= 180 + class33.loginWindowX - 34 && var11 <= 34 + class33.loginWindowX + 180 && var12 >= 351 && var12 <= 363) {
                           FrameMap.method2384(class138.method3023("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                        }

                        var5 = class33.loginWindowX + 180 + 80;
                        if(var1 == 1 && var11 >= var5 - 75 && var11 <= 75 + var5 && var12 >= var13 - 20 && var12 <= 20 + var13) {
                           class33.loginIndex = 0;
                           class33.username = "";
                           class33.field765 = "";
                           class174.field2788 = 0;
                           class33.authCode = "";
                        }

                        while(class151.method3275()) {
                           var7 = false;

                           for(var8 = 0; var8 < "1234567890".length(); ++var8) {
                              if(class51.field1146 == "1234567890".charAt(var8)) {
                                 var7 = true;
                                 break;
                              }
                           }

                           if(XClanMember.field643 == 13) {
                              class33.loginIndex = 0;
                              class33.username = "";
                              class33.field765 = "";
                              class174.field2788 = 0;
                              class33.authCode = "";
                           } else {
                              if(XClanMember.field643 == 85 && class33.authCode.length() > 0) {
                                 class33.authCode = class33.authCode.substring(0, class33.authCode.length() - 1);
                              }

                              if(XClanMember.field643 == 84) {
                                 class33.authCode.trim();
                                 if(class33.authCode.length() != 6) {
                                    MessageNode.method781("", "Please enter a 6-digin PIN.", "");
                                    return;
                                 }

                                 class174.field2788 = Integer.parseInt(class33.authCode);
                                 class33.authCode = "";
                                 class33.field766 = class33.field768?class162.field2660:class162.field2662;
                                 MessageNode.method781("", "Connecting to server...", "");
                                 class138.setGameState(20);
                                 return;
                              }

                              if(var7 && class33.authCode.length() < 6) {
                                 class33.authCode = class33.authCode + class51.field1146;
                              }
                           }
                        }
                     } else if(class33.loginIndex == 5) {
                        var5 = class33.loginWindowX + 180 - 80;
                        var13 = 321;
                        if(var1 == 1 && var11 >= var5 - 75 && var11 <= 75 + var5 && var12 >= var13 - 20 && var12 <= var13 + 20) {
                           class109.method2475();
                           return;
                        }

                        var5 = 260 + class33.loginWindowX;
                        if(var1 == 1 && var11 >= var5 - 75 && var11 <= 75 + var5 && var12 >= var13 - 20 && var12 <= 20 + var13) {
                           class33.loginMessage1 = "";
                           class33.loginMessage2 = "Enter your username/email & password.";
                           class33.loginMessage3 = "";
                           class33.loginIndex = 2;
                           class33.loginIndex2 = 0;
                           class33.field765 = "";
                        }

                        while(class151.method3275()) {
                           var7 = false;

                           for(var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                              if(class51.field1146 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                 var7 = true;
                                 break;
                              }
                           }

                           if(XClanMember.field643 == 13) {
                              class33.loginMessage1 = "";
                              class33.loginMessage2 = "Enter your username/email & password.";
                              class33.loginMessage3 = "";
                              class33.loginIndex = 2;
                              class33.loginIndex2 = 0;
                              class33.field765 = "";
                           } else {
                              if(XClanMember.field643 == 85 && class33.username.length() > 0) {
                                 class33.username = class33.username.substring(0, class33.username.length() - 1);
                              }

                              if(XClanMember.field643 == 84) {
                                 class109.method2475();
                                 return;
                              }

                              if(var7 && class33.username.length() < 320) {
                                 class33.username = class33.username + class51.field1146;
                              }
                           }
                        }
                     } else if(class33.loginIndex == 6) {
                        while(true) {
                           do {
                              if(!class151.method3275()) {
                                 var6 = 321;
                                 if(var1 == 1 && var12 >= var6 - 20 && var12 <= 20 + var6) {
                                    class33.loginMessage1 = "";
                                    class33.loginMessage2 = "Enter your username/email & password.";
                                    class33.loginMessage3 = "";
                                    class33.loginIndex = 2;
                                    class33.loginIndex2 = 0;
                                    class33.field765 = "";
                                 }

                                 return;
                              }
                           } while(XClanMember.field643 != 84 && XClanMember.field643 != 13);

                           class33.loginMessage1 = "";
                           class33.loginMessage2 = "Enter your username/email & password.";
                           class33.loginMessage3 = "";
                           class33.loginIndex = 2;
                           class33.loginIndex2 = 0;
                           class33.field765 = "";
                        }
                     }
                  }
               } else {
                  while(class151.method3275()) {
                     if(XClanMember.field643 == 84) {
                        class33.loginMessage1 = "";
                        class33.loginMessage2 = "Enter your username/email & password.";
                        class33.loginMessage3 = "";
                        class33.loginIndex = 2;
                        class33.loginIndex2 = 0;
                     } else if(XClanMember.field643 == 13) {
                        class33.loginIndex = 0;
                     }
                  }

                  var5 = 180 + class33.loginWindowX - 80;
                  var13 = 321;
                  if(var1 == 1 && var11 >= var5 - 75 && var11 <= 75 + var5 && var12 >= var13 - 20 && var12 <= 20 + var13) {
                     class33.loginMessage1 = "";
                     class33.loginMessage2 = "Enter your username/email & password.";
                     class33.loginMessage3 = "";
                     class33.loginIndex = 2;
                     class33.loginIndex2 = 0;
                  }

                  var5 = class33.loginWindowX + 180 + 80;
                  if(var1 == 1 && var11 >= var5 - 75 && var11 <= var5 + 75 && var12 >= var13 - 20 && var12 <= 20 + var13) {
                     class33.loginIndex = 0;
                  }
               }
            }
         }
      }

   }
}
