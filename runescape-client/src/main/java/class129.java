import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
public class class129 {
   @ObfuscatedName("f")
   static int[] field2119;
   @ObfuscatedName("w")
   public static String[] field2120;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -584408953
   )
   static int field2122;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "619423768"
   )
   public static int method2856(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + ItemComposition.method1174(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass139;Ljava/lang/Object;B)V",
      garbageValue = "-23"
   )
   public static void method2857(class139 var0, Object var1) {
      if(var0.field2166 != null) {
         for(int var2 = 0; var2 < 50 && var0.field2166.peekEvent() != null; ++var2) {
            Item.method681(1L);
         }

         if(null != var1) {
            var0.field2166.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LGameEngine;I)V",
      garbageValue = "1404762745"
   )
   static void method2858(GameEngine var0) {
      int var1;
      int var10;
      int var11;
      int var12;
      if(class33.worldSelectShown) {
         if(class143.field2227 == 1 || !class24.field626 && class143.field2227 == 4) {
            var1 = 280 + class33.field736;
            if(class143.field2223 >= var1 && class143.field2223 <= 14 + var1 && class143.field2226 >= 4 && class143.field2226 <= 18) {
               class16.method181(0, 0);
            } else if(class143.field2223 >= 15 + var1 && class143.field2223 <= var1 + 80 && class143.field2226 >= 4 && class143.field2226 <= 18) {
               class16.method181(0, 1);
            } else {
               var10 = 390 + class33.field736;
               if(class143.field2223 >= var10 && class143.field2223 <= var10 + 14 && class143.field2226 >= 4 && class143.field2226 <= 18) {
                  class16.method181(1, 0);
               } else if(class143.field2223 >= 15 + var10 && class143.field2223 <= var10 + 80 && class143.field2226 >= 4 && class143.field2226 <= 18) {
                  class16.method181(1, 1);
               } else {
                  var11 = 500 + class33.field736;
                  if(class143.field2223 >= var11 && class143.field2223 <= 14 + var11 && class143.field2226 >= 4 && class143.field2226 <= 18) {
                     class16.method181(2, 0);
                  } else if(class143.field2223 >= 15 + var11 && class143.field2223 <= 80 + var11 && class143.field2226 >= 4 && class143.field2226 <= 18) {
                     class16.method181(2, 1);
                  } else {
                     var12 = 610 + class33.field736;
                     if(class143.field2223 >= var12 && class143.field2223 <= 14 + var12 && class143.field2226 >= 4 && class143.field2226 <= 18) {
                        class16.method181(3, 0);
                     } else if(class143.field2223 >= 15 + var12 && class143.field2223 <= 80 + var12 && class143.field2226 >= 4 && class143.field2226 <= 18) {
                        class16.method181(3, 1);
                     } else if(class143.field2223 >= class33.field736 + 708 && class143.field2226 >= 4 && class143.field2223 <= 50 + 708 + class33.field736 && class143.field2226 <= 20) {
                        class33.worldSelectShown = false;
                        class130.field2124.method1807(class33.field736, 0);
                        class137.field2153.method1807(class33.field736 + 382, 0);
                        class33.field739.method1900(382 + class33.field736 - class33.field739.originalWidth / 2, 18);
                     } else if(class33.field765 != -1) {
                        World var5 = World.worldList[class33.field765];
                        class110.selectWorld(var5);
                        class33.worldSelectShown = false;
                        class130.field2124.method1807(class33.field736, 0);
                        class137.field2153.method1807(class33.field736 + 382, 0);
                        class33.field739.method1900(class33.field736 + 382 - class33.field739.originalWidth / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((class143.field2227 == 1 || !class24.field626 && class143.field2227 == 4) && class143.field2223 >= 765 + class33.field736 - 50 && class143.field2226 >= 453) {
            class116.field2039.field133 = !class116.field2039.field133;
            class79.method1710();
            if(!class116.field2039.field133) {
               class169.method3304(class8.field140, "scape main", "", 255, false);
            } else {
               class186.field3015.method3671();
               class186.field3016 = 1;
               class186.field3017 = null;
            }
         }

         if(Client.gameState != 5) {
            ++class33.field745;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.field489 == 0) {
                  if(class143.field2227 == 1 || !class24.field626 && class143.field2227 == 4) {
                     var1 = class33.field736 + 5;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(class143.field2223 >= var1 && class143.field2223 <= var1 + var3 && class143.field2226 >= var2 && class143.field2226 <= var4 + var2) {
                        if(class18.loadWorlds()) {
                           class33.worldSelectShown = true;
                        }

                        return;
                     }
                  }

                  if(null != class133.worldServersDownload && class18.loadWorlds()) {
                     class33.worldSelectShown = true;
                  }
               }

               var1 = class143.field2227;
               var10 = class143.field2223;
               var11 = class143.field2226;
               if(!class24.field626 && var1 == 4) {
                  var1 = 1;
               }

               short var9;
               if(class33.loginIndex == 0) {
                  var12 = 180 + class33.loginWindowX - 80;
                  var9 = 291;
                  if(var1 == 1 && var10 >= var12 - 75 && var10 <= var12 + 75 && var11 >= var9 - 20 && var11 <= 20 + var9) {
                     SecondaryBufferProvider.method1682(Friend.method189("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var12 = 80 + 180 + class33.loginWindowX;
                  if(var1 == 1 && var10 >= var12 - 75 && var10 <= 75 + var12 && var11 >= var9 - 20 && var11 <= var9 + 20) {
                     if((Client.flags & 33554432) != 0) {
                        class33.field767 = "";
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

                        class33.field767 = "Warning!";
                        class33.loginIndex = 1;
                        class33.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class33.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class33.loginMessage2 = "The Protect Item prayer will";
                        class33.loginMessage3 = "not work on this world.";
                        class33.field767 = "Warning!";
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
                  short var13;
                  if(class33.loginIndex == 2) {
                     var13 = 231;
                     var12 = var13 + 30;
                     if(var1 == 1 && var11 >= var12 - 15 && var11 < var12) {
                        class33.loginIndex2 = 0;
                     }

                     var12 += 15;
                     if(var1 == 1 && var11 >= var12 - 15 && var11 < var12) {
                        class33.loginIndex2 = 1;
                     }

                     var12 += 15;
                     var13 = 361;
                     if(var1 == 1 && var11 >= var13 - 15 && var11 < var13) {
                        class192.method3774("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class33.loginIndex = 5;
                        return;
                     }

                     int var16 = class33.loginWindowX + 180 - 80;
                     short var6 = 321;
                     if(var1 == 1 && var10 >= var16 - 75 && var10 <= 75 + var16 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                        class33.username = class33.username.trim();
                        if(class33.username.length() == 0) {
                           class192.method3774("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class33.field758.length() == 0) {
                           class192.method3774("", "Please enter your password.", "");
                           return;
                        }

                        class192.method3774("", "Connecting to server...", "");
                        class33.field759 = class116.field2039.field136.containsKey(Integer.valueOf(class107.method2313(class33.username)))?class162.field2671:class162.field2665;
                        XItemContainer.setGameState(20);
                        return;
                     }

                     var16 = 80 + class33.loginWindowX + 180;
                     if(var1 == 1 && var10 >= var16 - 75 && var10 <= 75 + var16 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                        class33.loginIndex = 0;
                        class33.username = "";
                        class33.field758 = "";
                        class10.field156 = 0;
                        SecondaryBufferProvider.authCode = "";
                        class33.field747 = true;
                     }

                     while(true) {
                        while(XClanMember.method602()) {
                           boolean var7 = false;

                           for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                              if(class24.field615 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                 var7 = true;
                                 break;
                              }
                           }

                           if(class117.field2047 == 13) {
                              class33.loginIndex = 0;
                              class33.username = "";
                              class33.field758 = "";
                              class10.field156 = 0;
                              SecondaryBufferProvider.authCode = "";
                              class33.field747 = true;
                           } else if(class33.loginIndex2 == 0) {
                              if(class117.field2047 == 85 && class33.username.length() > 0) {
                                 class33.username = class33.username.substring(0, class33.username.length() - 1);
                              }

                              if(class117.field2047 == 84 || class117.field2047 == 80) {
                                 class33.loginIndex2 = 1;
                              }

                              if(var7 && class33.username.length() < 320) {
                                 class33.username = class33.username + class24.field615;
                              }
                           } else if(class33.loginIndex2 == 1) {
                              if(class117.field2047 == 85 && class33.field758.length() > 0) {
                                 class33.field758 = class33.field758.substring(0, class33.field758.length() - 1);
                              }

                              if(class117.field2047 == 84 || class117.field2047 == 80) {
                                 class33.loginIndex2 = 0;
                              }

                              if(class117.field2047 == 84) {
                                 class33.username = class33.username.trim();
                                 if(class33.username.length() == 0) {
                                    class192.method3774("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class33.field758.length() == 0) {
                                    class192.method3774("", "Please enter your password.", "");
                                    return;
                                 }

                                 class192.method3774("", "Connecting to server...", "");
                                 class33.field759 = class116.field2039.field136.containsKey(Integer.valueOf(class107.method2313(class33.username)))?class162.field2671:class162.field2665;
                                 XItemContainer.setGameState(20);
                                 return;
                              }

                              if(var7 && class33.field758.length() < 20) {
                                 class33.field758 = class33.field758 + class24.field615;
                              }
                           }
                        }

                        return;
                     }
                  } else if(class33.loginIndex == 3) {
                     var12 = class33.loginWindowX + 180;
                     var9 = 276;
                     if(var1 == 1 && var10 >= var12 - 75 && var10 <= var12 + 75 && var11 >= var9 - 20 && var11 <= var9 + 20) {
                        class33.loginMessage1 = "";
                        class33.loginMessage2 = "Enter your username/email & password.";
                        class33.loginMessage3 = "";
                        class33.loginIndex = 2;
                        class33.loginIndex2 = 0;
                     }

                     var12 = class33.loginWindowX + 180;
                     var9 = 326;
                     if(var1 == 1 && var10 >= var12 - 75 && var10 <= 75 + var12 && var11 >= var9 - 20 && var11 <= var9 + 20) {
                        class192.method3774("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class33.loginIndex = 5;
                        return;
                     }
                  } else {
                     boolean var14;
                     int var15;
                     if(class33.loginIndex == 4) {
                        var12 = 180 + class33.loginWindowX - 80;
                        var9 = 321;
                        if(var1 == 1 && var10 >= var12 - 75 && var10 <= 75 + var12 && var11 >= var9 - 20 && var11 <= var9 + 20) {
                           SecondaryBufferProvider.authCode.trim();
                           if(SecondaryBufferProvider.authCode.length() != 6) {
                              class192.method3774("", "Please enter a 6-digin PIN.", "");
                              return;
                           }

                           class10.field156 = Integer.parseInt(SecondaryBufferProvider.authCode);
                           SecondaryBufferProvider.authCode = "";
                           class33.field759 = class33.field747?class162.field2669:class162.field2668;
                           class192.method3774("", "Connecting to server...", "");
                           XItemContainer.setGameState(20);
                           return;
                        }

                        if(var1 == 1 && var10 >= class33.loginWindowX + 180 - 9 && var10 <= 180 + class33.loginWindowX + 130 && var11 >= 263 && var11 <= 296) {
                           class33.field747 = !class33.field747;
                        }

                        if(var1 == 1 && var10 >= 180 + class33.loginWindowX - 34 && var10 <= 180 + class33.loginWindowX + 34 && var11 >= 351 && var11 <= 363) {
                           SecondaryBufferProvider.method1682(Friend.method189("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                        }

                        var12 = 180 + class33.loginWindowX + 80;
                        if(var1 == 1 && var10 >= var12 - 75 && var10 <= 75 + var12 && var11 >= var9 - 20 && var11 <= var9 + 20) {
                           class33.loginIndex = 0;
                           class33.username = "";
                           class33.field758 = "";
                           class10.field156 = 0;
                           SecondaryBufferProvider.authCode = "";
                        }

                        while(XClanMember.method602()) {
                           var14 = false;

                           for(var15 = 0; var15 < "1234567890".length(); ++var15) {
                              if(class24.field615 == "1234567890".charAt(var15)) {
                                 var14 = true;
                                 break;
                              }
                           }

                           if(class117.field2047 == 13) {
                              class33.loginIndex = 0;
                              class33.username = "";
                              class33.field758 = "";
                              class10.field156 = 0;
                              SecondaryBufferProvider.authCode = "";
                           } else {
                              if(class117.field2047 == 85 && SecondaryBufferProvider.authCode.length() > 0) {
                                 SecondaryBufferProvider.authCode = SecondaryBufferProvider.authCode.substring(0, SecondaryBufferProvider.authCode.length() - 1);
                              }

                              if(class117.field2047 == 84) {
                                 SecondaryBufferProvider.authCode.trim();
                                 if(SecondaryBufferProvider.authCode.length() != 6) {
                                    class192.method3774("", "Please enter a 6-digin PIN.", "");
                                    return;
                                 }

                                 class10.field156 = Integer.parseInt(SecondaryBufferProvider.authCode);
                                 SecondaryBufferProvider.authCode = "";
                                 class33.field759 = class33.field747?class162.field2669:class162.field2668;
                                 class192.method3774("", "Connecting to server...", "");
                                 XItemContainer.setGameState(20);
                                 return;
                              }

                              if(var14 && SecondaryBufferProvider.authCode.length() < 6) {
                                 SecondaryBufferProvider.authCode = SecondaryBufferProvider.authCode + class24.field615;
                              }
                           }
                        }
                     } else if(class33.loginIndex == 5) {
                        var12 = 180 + class33.loginWindowX - 80;
                        var9 = 321;
                        if(var1 == 1 && var10 >= var12 - 75 && var10 <= 75 + var12 && var11 >= var9 - 20 && var11 <= 20 + var9) {
                           class119.method2480();
                           return;
                        }

                        var12 = 80 + class33.loginWindowX + 180;
                        if(var1 == 1 && var10 >= var12 - 75 && var10 <= 75 + var12 && var11 >= var9 - 20 && var11 <= var9 + 20) {
                           class33.loginMessage1 = "";
                           class33.loginMessage2 = "Enter your username/email & password.";
                           class33.loginMessage3 = "";
                           class33.loginIndex = 2;
                           class33.loginIndex2 = 0;
                           class33.field758 = "";
                        }

                        while(XClanMember.method602()) {
                           var14 = false;

                           for(var15 = 0; var15 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var15) {
                              if(class24.field615 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var15)) {
                                 var14 = true;
                                 break;
                              }
                           }

                           if(class117.field2047 == 13) {
                              class33.loginMessage1 = "";
                              class33.loginMessage2 = "Enter your username/email & password.";
                              class33.loginMessage3 = "";
                              class33.loginIndex = 2;
                              class33.loginIndex2 = 0;
                              class33.field758 = "";
                           } else {
                              if(class117.field2047 == 85 && class33.username.length() > 0) {
                                 class33.username = class33.username.substring(0, class33.username.length() - 1);
                              }

                              if(class117.field2047 == 84) {
                                 class119.method2480();
                                 return;
                              }

                              if(var14 && class33.username.length() < 320) {
                                 class33.username = class33.username + class24.field615;
                              }
                           }
                        }
                     } else if(class33.loginIndex == 6) {
                        while(true) {
                           do {
                              if(!XClanMember.method602()) {
                                 var13 = 321;
                                 if(var1 == 1 && var11 >= var13 - 20 && var11 <= var13 + 20) {
                                    class33.loginMessage1 = "";
                                    class33.loginMessage2 = "Enter your username/email & password.";
                                    class33.loginMessage3 = "";
                                    class33.loginIndex = 2;
                                    class33.loginIndex2 = 0;
                                    class33.field758 = "";
                                 }

                                 return;
                              }
                           } while(class117.field2047 != 84 && class117.field2047 != 13);

                           class33.loginMessage1 = "";
                           class33.loginMessage2 = "Enter your username/email & password.";
                           class33.loginMessage3 = "";
                           class33.loginIndex = 2;
                           class33.loginIndex2 = 0;
                           class33.field758 = "";
                        }
                     }
                  }
               } else {
                  while(XClanMember.method602()) {
                     if(class117.field2047 == 84) {
                        class33.loginMessage1 = "";
                        class33.loginMessage2 = "Enter your username/email & password.";
                        class33.loginMessage3 = "";
                        class33.loginIndex = 2;
                        class33.loginIndex2 = 0;
                     } else if(class117.field2047 == 13) {
                        class33.loginIndex = 0;
                     }
                  }

                  var12 = class33.loginWindowX + 180 - 80;
                  var9 = 321;
                  if(var1 == 1 && var10 >= var12 - 75 && var10 <= 75 + var12 && var11 >= var9 - 20 && var11 <= 20 + var9) {
                     class33.loginMessage1 = "";
                     class33.loginMessage2 = "Enter your username/email & password.";
                     class33.loginMessage3 = "";
                     class33.loginIndex = 2;
                     class33.loginIndex2 = 0;
                  }

                  var12 = 80 + class33.loginWindowX + 180;
                  if(var1 == 1 && var10 >= var12 - 75 && var10 <= var12 + 75 && var11 >= var9 - 20 && var11 <= 20 + var9) {
                     class33.loginIndex = 0;
                  }
               }

            }
         }
      }
   }
}
