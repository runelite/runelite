import java.awt.datatransfer.Clipboard;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
public class class56 extends CacheableNode {
   @ObfuscatedName("j")
   static NodeCache field1210 = new NodeCache(64);
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1536249867
   )
   public int field1211 = 0;
   @ObfuscatedName("x")
   static class170 field1214;
   @ObfuscatedName("pm")
   static Clipboard field1216;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-78666497"
   )
   public static void method1164() {
      class49.field1076.reset();
      class49.field1074.reset();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1633277900"
   )
   void method1165(Buffer var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method1166(var1, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "55"
   )
   void method1166(Buffer var1, int var2) {
      if(var2 == 5) {
         this.field1211 = var1.method2551();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LGameEngine;I)V",
      garbageValue = "403091342"
   )
   static void method1176(GameEngine var0) {
      if(class33.worldSelectShown) {
         class133.method2883(var0);
      } else {
         if((class143.field2198 == 1 || !class134.field2117 && class143.field2198 == 4) && class143.field2211 >= 765 + class33.field745 - 50 && class143.field2213 >= 453) {
            class161.field2659.field136 = !class161.field2659.field136;
            class5.method80();
            if(!class161.field2659.field136) {
               SecondaryBufferProvider.method1639(class192.field3108, "scape main", "", 255, false);
            } else {
               class186.field3008.method3670();
               class186.field3009 = 1;
               class186.field3010 = null;
            }
         }

         if(Client.gameState != 5) {
            ++class33.field751;
            if(Client.gameState == 10 || Client.gameState == 11) {
               int var1;
               if(Client.field281 == 0) {
                  if(class143.field2198 == 1 || !class134.field2117 && class143.field2198 == 4) {
                     var1 = 5 + class33.field745;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(class143.field2211 >= var1 && class143.field2211 <= var3 + var1 && class143.field2213 >= var2 && class143.field2213 <= var2 + var4) {
                        class140.method2950();
                        return;
                     }
                  }

                  if(class173.worldServersDownload != null) {
                     class140.method2950();
                  }
               }

               var1 = class143.field2198;
               int var9 = class143.field2211;
               int var10 = class143.field2213;
               if(!class134.field2117 && var1 == 4) {
                  var1 = 1;
               }

               short var5;
               int var11;
               if(class33.loginIndex == 0) {
                  var11 = class33.loginWindowX + 180 - 80;
                  var5 = 291;
                  if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                     class114.method2482(class127.method2847("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var11 = 80 + class33.loginWindowX + 180;
                  if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= var5 + 20) {
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
                  short var12;
                  if(class33.loginIndex == 2) {
                     var12 = 231;
                     var11 = var12 + 30;
                     if(var1 == 1 && var10 >= var11 - 15 && var10 < var11) {
                        class33.loginIndex2 = 0;
                     }

                     var11 += 15;
                     if(var1 == 1 && var10 >= var11 - 15 && var10 < var11) {
                        class33.loginIndex2 = 1;
                     }

                     var11 += 15;
                     var12 = 361;
                     if(var1 == 1 && var10 >= var12 - 15 && var10 < var12) {
                        class20.method546("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class33.loginIndex = 5;
                        return;
                     }

                     int var13 = 180 + class33.loginWindowX - 80;
                     short var6 = 321;
                     if(var1 == 1 && var9 >= var13 - 75 && var9 <= 75 + var13 && var10 >= var6 - 20 && var10 <= 20 + var6) {
                        class33.username = class33.username.trim();
                        if(class33.username.length() == 0) {
                           class20.method546("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class33.field733.length() == 0) {
                           class20.method546("", "Please enter your password.", "");
                           return;
                        }

                        class20.method546("", "Connecting to server...", "");
                        class33.field746 = class161.field2659.field137.containsKey(Integer.valueOf(XClanMember.method580(class33.username)))?class162.field2667:class162.field2662;
                        class130.setGameState(20);
                        return;
                     }

                     var13 = 80 + class33.loginWindowX + 180;
                     if(var1 == 1 && var9 >= var13 - 75 && var9 <= 75 + var13 && var10 >= var6 - 20 && var10 <= 20 + var6) {
                        class33.loginIndex = 0;
                        class33.username = "";
                        class33.field733 = "";
                        class159.field2362 = 0;
                        SecondaryBufferProvider.authCode = "";
                        class33.field731 = true;
                     }

                     while(true) {
                        while(class10.method129()) {
                           boolean var7 = false;

                           for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                              if(class113.field2009 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                 var7 = true;
                                 break;
                              }
                           }

                           if(class132.field2102 == 13) {
                              class33.loginIndex = 0;
                              class33.username = "";
                              class33.field733 = "";
                              class159.field2362 = 0;
                              SecondaryBufferProvider.authCode = "";
                              class33.field731 = true;
                           } else if(class33.loginIndex2 == 0) {
                              if(class132.field2102 == 85 && class33.username.length() > 0) {
                                 class33.username = class33.username.substring(0, class33.username.length() - 1);
                              }

                              if(class132.field2102 == 84 || class132.field2102 == 80) {
                                 class33.loginIndex2 = 1;
                              }

                              if(var7 && class33.username.length() < 320) {
                                 class33.username = class33.username + class113.field2009;
                              }
                           } else if(class33.loginIndex2 == 1) {
                              if(class132.field2102 == 85 && class33.field733.length() > 0) {
                                 class33.field733 = class33.field733.substring(0, class33.field733.length() - 1);
                              }

                              if(class132.field2102 == 84 || class132.field2102 == 80) {
                                 class33.loginIndex2 = 0;
                              }

                              if(class132.field2102 == 84) {
                                 class33.username = class33.username.trim();
                                 if(class33.username.length() == 0) {
                                    class20.method546("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class33.field733.length() == 0) {
                                    class20.method546("", "Please enter your password.", "");
                                    return;
                                 }

                                 class20.method546("", "Connecting to server...", "");
                                 class33.field746 = class161.field2659.field137.containsKey(Integer.valueOf(XClanMember.method580(class33.username)))?class162.field2667:class162.field2662;
                                 class130.setGameState(20);
                                 return;
                              }

                              if(var7 && class33.field733.length() < 20) {
                                 class33.field733 = class33.field733 + class113.field2009;
                              }
                           }
                        }

                        return;
                     }
                  } else if(class33.loginIndex == 3) {
                     var11 = 180 + class33.loginWindowX;
                     var5 = 276;
                     if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                        class33.loginMessage1 = "";
                        class33.loginMessage2 = "Enter your username/email & password.";
                        class33.loginMessage3 = "";
                        class33.loginIndex = 2;
                        class33.loginIndex2 = 0;
                     }

                     var11 = class33.loginWindowX + 180;
                     var5 = 326;
                     if(var1 == 1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                        class20.method546("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class33.loginIndex = 5;
                        return;
                     }
                  } else {
                     boolean var14;
                     int var15;
                     if(class33.loginIndex == 4) {
                        var11 = class33.loginWindowX + 180 - 80;
                        var5 = 321;
                        if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                           SecondaryBufferProvider.authCode.trim();
                           if(SecondaryBufferProvider.authCode.length() != 6) {
                              class20.method546("", "Please enter a 6-digin PIN.", "");
                              return;
                           }

                           class159.field2362 = Integer.parseInt(SecondaryBufferProvider.authCode);
                           SecondaryBufferProvider.authCode = "";
                           class33.field746 = class33.field731?class162.field2661:class162.field2669;
                           class20.method546("", "Connecting to server...", "");
                           class130.setGameState(20);
                           return;
                        }

                        if(var1 == 1 && var9 >= 180 + class33.loginWindowX - 9 && var9 <= 130 + 180 + class33.loginWindowX && var10 >= 263 && var10 <= 296) {
                           class33.field731 = !class33.field731;
                        }

                        if(var1 == 1 && var9 >= 180 + class33.loginWindowX - 34 && var9 <= 34 + 180 + class33.loginWindowX && var10 >= 351 && var10 <= 363) {
                           class114.method2482(class127.method2847("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                        }

                        var11 = class33.loginWindowX + 180 + 80;
                        if(var1 == 1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                           class33.loginIndex = 0;
                           class33.username = "";
                           class33.field733 = "";
                           class159.field2362 = 0;
                           SecondaryBufferProvider.authCode = "";
                        }

                        while(class10.method129()) {
                           var14 = false;

                           for(var15 = 0; var15 < "1234567890".length(); ++var15) {
                              if(class113.field2009 == "1234567890".charAt(var15)) {
                                 var14 = true;
                                 break;
                              }
                           }

                           if(class132.field2102 == 13) {
                              class33.loginIndex = 0;
                              class33.username = "";
                              class33.field733 = "";
                              class159.field2362 = 0;
                              SecondaryBufferProvider.authCode = "";
                           } else {
                              if(class132.field2102 == 85 && SecondaryBufferProvider.authCode.length() > 0) {
                                 SecondaryBufferProvider.authCode = SecondaryBufferProvider.authCode.substring(0, SecondaryBufferProvider.authCode.length() - 1);
                              }

                              if(class132.field2102 == 84) {
                                 SecondaryBufferProvider.authCode.trim();
                                 if(SecondaryBufferProvider.authCode.length() != 6) {
                                    class20.method546("", "Please enter a 6-digin PIN.", "");
                                    return;
                                 }

                                 class159.field2362 = Integer.parseInt(SecondaryBufferProvider.authCode);
                                 SecondaryBufferProvider.authCode = "";
                                 class33.field746 = class33.field731?class162.field2661:class162.field2669;
                                 class20.method546("", "Connecting to server...", "");
                                 class130.setGameState(20);
                                 return;
                              }

                              if(var14 && SecondaryBufferProvider.authCode.length() < 6) {
                                 SecondaryBufferProvider.authCode = SecondaryBufferProvider.authCode + class113.field2009;
                              }
                           }
                        }
                     } else if(class33.loginIndex == 5) {
                        var11 = 180 + class33.loginWindowX - 80;
                        var5 = 321;
                        if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                           class14.method166();
                           return;
                        }

                        var11 = 80 + 180 + class33.loginWindowX;
                        if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                           class33.loginMessage1 = "";
                           class33.loginMessage2 = "Enter your username/email & password.";
                           class33.loginMessage3 = "";
                           class33.loginIndex = 2;
                           class33.loginIndex2 = 0;
                           class33.field733 = "";
                        }

                        while(class10.method129()) {
                           var14 = false;

                           for(var15 = 0; var15 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var15) {
                              if(class113.field2009 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var15)) {
                                 var14 = true;
                                 break;
                              }
                           }

                           if(class132.field2102 == 13) {
                              class33.loginMessage1 = "";
                              class33.loginMessage2 = "Enter your username/email & password.";
                              class33.loginMessage3 = "";
                              class33.loginIndex = 2;
                              class33.loginIndex2 = 0;
                              class33.field733 = "";
                           } else {
                              if(class132.field2102 == 85 && class33.username.length() > 0) {
                                 class33.username = class33.username.substring(0, class33.username.length() - 1);
                              }

                              if(class132.field2102 == 84) {
                                 class14.method166();
                                 return;
                              }

                              if(var14 && class33.username.length() < 320) {
                                 class33.username = class33.username + class113.field2009;
                              }
                           }
                        }
                     } else if(class33.loginIndex == 6) {
                        while(true) {
                           do {
                              if(!class10.method129()) {
                                 var12 = 321;
                                 if(var1 == 1 && var10 >= var12 - 20 && var10 <= var12 + 20) {
                                    class33.loginMessage1 = "";
                                    class33.loginMessage2 = "Enter your username/email & password.";
                                    class33.loginMessage3 = "";
                                    class33.loginIndex = 2;
                                    class33.loginIndex2 = 0;
                                    class33.field733 = "";
                                 }

                                 return;
                              }
                           } while(class132.field2102 != 84 && class132.field2102 != 13);

                           class33.loginMessage1 = "";
                           class33.loginMessage2 = "Enter your username/email & password.";
                           class33.loginMessage3 = "";
                           class33.loginIndex = 2;
                           class33.loginIndex2 = 0;
                           class33.field733 = "";
                        }
                     }
                  }
               } else {
                  while(class10.method129()) {
                     if(class132.field2102 == 84) {
                        class33.loginMessage1 = "";
                        class33.loginMessage2 = "Enter your username/email & password.";
                        class33.loginMessage3 = "";
                        class33.loginIndex = 2;
                        class33.loginIndex2 = 0;
                     } else if(class132.field2102 == 13) {
                        class33.loginIndex = 0;
                     }
                  }

                  var11 = 180 + class33.loginWindowX - 80;
                  var5 = 321;
                  if(var1 == 1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                     class33.loginMessage1 = "";
                     class33.loginMessage2 = "Enter your username/email & password.";
                     class33.loginMessage3 = "";
                     class33.loginIndex = 2;
                     class33.loginIndex2 = 0;
                  }

                  var11 = 80 + 180 + class33.loginWindowX;
                  if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                     class33.loginIndex = 0;
                  }
               }

            }
         }
      }
   }
}
