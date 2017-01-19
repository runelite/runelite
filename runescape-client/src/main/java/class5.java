import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
final class class5 implements Comparator {
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = 1870310761
   )
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("j")
   static String field54;
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = 1502508391
   )
   static int field57;
   @ObfuscatedName("nr")
   @ObfuscatedGetter(
      intValue = -1445372427
   )
   static int field59;
   @ObfuscatedName("bw")
   static class184 field60;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;B)I",
      garbageValue = "49"
   )
   int method62(class2 var1, class2 var2) {
      return var1.field23.price < var2.field23.price?-1:(var1.field23.price == var2.field23.price?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method62((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LGameEngine;B)V",
      garbageValue = "39"
   )
   static void method67(GameEngine var0) {
      if(class41.worldSelectShown) {
         class57.method1045(var0);
      } else {
         int var2;
         int var3;
         if((class115.field1807 == 1 || !class10.field110 && class115.field1807 == 4) && class115.field1809 >= class41.field814 + 765 - 50 && class115.field1796 >= 453) {
            class38.field794.field702 = !class38.field794.field702;
            PlayerComposition.method3057();
            if(!class38.field794.field702) {
               class184 var9 = class164.field2170;
               var2 = var9.method3197("scape main");
               var3 = var9.method3198(var2, "");
               WallObject.method1833(var9, var2, var3, 255, false);
            } else {
               class211.method3825();
            }
         }

         if(Client.gameState != 5) {
            ++class41.field826;
            if(Client.gameState == 10 || Client.gameState == 11) {
               int var1;
               if(Client.field300 == 0) {
                  if(class115.field1807 == 1 || !class10.field110 && class115.field1807 == 4) {
                     var1 = 5 + class41.field814;
                     short var10 = 463;
                     byte var11 = 100;
                     byte var4 = 35;
                     if(class115.field1809 >= var1 && class115.field1809 <= var11 + var1 && class115.field1796 >= var10 && class115.field1796 <= var4 + var10) {
                        if(class10.loadWorlds()) {
                           class41.worldSelectShown = true;
                        }

                        return;
                     }
                  }

                  if(World.worldServersDownload != null && class10.loadWorlds()) {
                     class41.worldSelectShown = true;
                  }
               }

               var1 = class115.field1807;
               var2 = class115.field1809;
               var3 = class115.field1796;
               if(!class10.field110 && var1 == 4) {
                  var1 = 1;
               }

               short var5;
               int var12;
               if(class41.loginIndex == 0) {
                  var12 = 180 + class41.loginWindowX - 80;
                  var5 = 291;
                  if(var1 == 1 && var2 >= var12 - 75 && var2 <= 75 + var12 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                     class48.method850(class146.method2660("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var12 = class41.loginWindowX + 180 + 80;
                  if(var1 == 1 && var2 >= var12 - 75 && var2 <= 75 + var12 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                     if((Client.flags & 33554432) != 0) {
                        class41.field831 = "";
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

                        class41.field831 = "Warning!";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class41.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class41.loginMessage2 = "The Protect Item prayer will";
                        class41.loginMessage3 = "not work on this world.";
                        class41.field831 = "Warning!";
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
                  short var13;
                  if(class41.loginIndex == 2) {
                     var13 = 231;
                     var12 = var13 + 30;
                     if(var1 == 1 && var3 >= var12 - 15 && var3 < var12) {
                        class41.loginIndex2 = 0;
                     }

                     var12 += 15;
                     if(var1 == 1 && var3 >= var12 - 15 && var3 < var12) {
                        class41.loginIndex2 = 1;
                     }

                     var12 += 15;
                     var13 = 361;
                     if(var1 == 1 && var3 >= var13 - 15 && var3 < var13) {
                        class1.method8("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class41.loginIndex = 5;
                        return;
                     }

                     int var14 = 180 + class41.loginWindowX - 80;
                     short var6 = 321;
                     if(var1 == 1 && var2 >= var14 - 75 && var2 <= 75 + var14 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                        class41.username = class41.username.trim();
                        if(class41.username.length() == 0) {
                           class1.method8("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class41.field810.length() == 0) {
                           class1.method8("", "Please enter your password.", "");
                           return;
                        }

                        class1.method8("", "Connecting to server...", "");
                        class41.field847 = class38.field794.field697.containsKey(Integer.valueOf(class180.method3176(class41.username)))?class97.field1637:class97.field1636;
                        class103.setGameState(20);
                        return;
                     }

                     var14 = 80 + class41.loginWindowX + 180;
                     if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var6 - 20 && var3 <= 20 + var6) {
                        class41.loginIndex = 0;
                        class41.username = "";
                        class41.field810 = "";
                        class10.field108 = 0;
                        class41.authCode = "";
                        class41.field837 = true;
                     }

                     while(true) {
                        while(GameObject.method1863()) {
                           boolean var7 = false;

                           for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                              if(Item.field880 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                 var7 = true;
                                 break;
                              }
                           }

                           if(class15.field175 == 13) {
                              class41.loginIndex = 0;
                              class41.username = "";
                              class41.field810 = "";
                              class10.field108 = 0;
                              class41.authCode = "";
                              class41.field837 = true;
                           } else if(class41.loginIndex2 == 0) {
                              if(class15.field175 == 85 && class41.username.length() > 0) {
                                 class41.username = class41.username.substring(0, class41.username.length() - 1);
                              }

                              if(class15.field175 == 84 || class15.field175 == 80) {
                                 class41.loginIndex2 = 1;
                              }

                              if(var7 && class41.username.length() < 320) {
                                 class41.username = class41.username + Item.field880;
                              }
                           } else if(class41.loginIndex2 == 1) {
                              if(class15.field175 == 85 && class41.field810.length() > 0) {
                                 class41.field810 = class41.field810.substring(0, class41.field810.length() - 1);
                              }

                              if(class15.field175 == 84 || class15.field175 == 80) {
                                 class41.loginIndex2 = 0;
                              }

                              if(class15.field175 == 84) {
                                 class41.username = class41.username.trim();
                                 if(class41.username.length() == 0) {
                                    class1.method8("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class41.field810.length() == 0) {
                                    class1.method8("", "Please enter your password.", "");
                                    return;
                                 }

                                 class1.method8("", "Connecting to server...", "");
                                 class41.field847 = class38.field794.field697.containsKey(Integer.valueOf(class180.method3176(class41.username)))?class97.field1637:class97.field1636;
                                 class103.setGameState(20);
                                 return;
                              }

                              if(var7 && class41.field810.length() < 20) {
                                 class41.field810 = class41.field810 + Item.field880;
                              }
                           }
                        }

                        return;
                     }
                  } else if(class41.loginIndex == 3) {
                     var12 = 180 + class41.loginWindowX;
                     var5 = 276;
                     if(var1 == 1 && var2 >= var12 - 75 && var2 <= 75 + var12 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     }

                     var12 = 180 + class41.loginWindowX;
                     var5 = 326;
                     if(var1 == 1 && var2 >= var12 - 75 && var2 <= 75 + var12 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                        class1.method8("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class41.loginIndex = 5;
                        return;
                     }
                  } else {
                     boolean var15;
                     int var16;
                     if(class41.loginIndex == 4) {
                        var12 = class41.loginWindowX + 180 - 80;
                        var5 = 321;
                        if(var1 == 1 && var2 >= var12 - 75 && var2 <= var12 + 75 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                           class41.authCode.trim();
                           if(class41.authCode.length() != 6) {
                              class1.method8("", "Please enter a 6-digit PIN.", "");
                              return;
                           }

                           class10.field108 = Integer.parseInt(class41.authCode);
                           class41.authCode = "";
                           class41.field847 = class41.field837?class97.field1629:class97.field1632;
                           class1.method8("", "Connecting to server...", "");
                           class103.setGameState(20);
                           return;
                        }

                        if(var1 == 1 && var2 >= 180 + class41.loginWindowX - 9 && var2 <= 130 + class41.loginWindowX + 180 && var3 >= 263 && var3 <= 296) {
                           class41.field837 = !class41.field837;
                        }

                        if(var1 == 1 && var2 >= class41.loginWindowX + 180 - 34 && var2 <= class41.loginWindowX + 180 + 34 && var3 >= 351 && var3 <= 363) {
                           class48.method850(class146.method2660("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                        }

                        var12 = class41.loginWindowX + 180 + 80;
                        if(var1 == 1 && var2 >= var12 - 75 && var2 <= var12 + 75 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                           class41.loginIndex = 0;
                           class41.username = "";
                           class41.field810 = "";
                           class10.field108 = 0;
                           class41.authCode = "";
                        }

                        while(GameObject.method1863()) {
                           var15 = false;

                           for(var16 = 0; var16 < "1234567890".length(); ++var16) {
                              if(Item.field880 == "1234567890".charAt(var16)) {
                                 var15 = true;
                                 break;
                              }
                           }

                           if(class15.field175 == 13) {
                              class41.loginIndex = 0;
                              class41.username = "";
                              class41.field810 = "";
                              class10.field108 = 0;
                              class41.authCode = "";
                           } else {
                              if(class15.field175 == 85 && class41.authCode.length() > 0) {
                                 class41.authCode = class41.authCode.substring(0, class41.authCode.length() - 1);
                              }

                              if(class15.field175 == 84) {
                                 class41.authCode.trim();
                                 if(class41.authCode.length() != 6) {
                                    class1.method8("", "Please enter a 6-digit PIN.", "");
                                    return;
                                 }

                                 class10.field108 = Integer.parseInt(class41.authCode);
                                 class41.authCode = "";
                                 class41.field847 = class41.field837?class97.field1629:class97.field1632;
                                 class1.method8("", "Connecting to server...", "");
                                 class103.setGameState(20);
                                 return;
                              }

                              if(var15 && class41.authCode.length() < 6) {
                                 class41.authCode = class41.authCode + Item.field880;
                              }
                           }
                        }
                     } else if(class41.loginIndex == 5) {
                        var12 = class41.loginWindowX + 180 - 80;
                        var5 = 321;
                        if(var1 == 1 && var2 >= var12 - 75 && var2 <= 75 + var12 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                           class10.method120();
                           return;
                        }

                        var12 = 180 + class41.loginWindowX + 80;
                        if(var1 == 1 && var2 >= var12 - 75 && var2 <= var12 + 75 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                           class41.field810 = "";
                        }

                        while(GameObject.method1863()) {
                           var15 = false;

                           for(var16 = 0; var16 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var16) {
                              if(Item.field880 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var16)) {
                                 var15 = true;
                                 break;
                              }
                           }

                           if(class15.field175 == 13) {
                              class41.loginMessage1 = "";
                              class41.loginMessage2 = "Enter your username/email & password.";
                              class41.loginMessage3 = "";
                              class41.loginIndex = 2;
                              class41.loginIndex2 = 0;
                              class41.field810 = "";
                           } else {
                              if(class15.field175 == 85 && class41.username.length() > 0) {
                                 class41.username = class41.username.substring(0, class41.username.length() - 1);
                              }

                              if(class15.field175 == 84) {
                                 class10.method120();
                                 return;
                              }

                              if(var15 && class41.username.length() < 320) {
                                 class41.username = class41.username + Item.field880;
                              }
                           }
                        }
                     } else if(class41.loginIndex == 6) {
                        while(true) {
                           do {
                              if(!GameObject.method1863()) {
                                 var13 = 321;
                                 if(var1 == 1 && var3 >= var13 - 20 && var3 <= var13 + 20) {
                                    class41.loginMessage1 = "";
                                    class41.loginMessage2 = "Enter your username/email & password.";
                                    class41.loginMessage3 = "";
                                    class41.loginIndex = 2;
                                    class41.loginIndex2 = 0;
                                    class41.field810 = "";
                                 }

                                 return;
                              }
                           } while(class15.field175 != 84 && class15.field175 != 13);

                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                           class41.field810 = "";
                        }
                     }
                  }
               } else {
                  while(GameObject.method1863()) {
                     if(class15.field175 == 84) {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     } else if(class15.field175 == 13) {
                        class41.loginIndex = 0;
                     }
                  }

                  var12 = 180 + class41.loginWindowX - 80;
                  var5 = 321;
                  if(var1 == 1 && var2 >= var12 - 75 && var2 <= 75 + var12 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                     class41.loginMessage1 = "";
                     class41.loginMessage2 = "Enter your username/email & password.";
                     class41.loginMessage3 = "";
                     class41.loginIndex = 2;
                     class41.loginIndex2 = 0;
                  }

                  var12 = 80 + 180 + class41.loginWindowX;
                  if(var1 == 1 && var2 >= var12 - 75 && var2 <= var12 + 75 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                     class41.loginIndex = 0;
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-94624163"
   )
   static final void method69(boolean var0) {
      while(true) {
         if(Client.field352.method2968(Client.field339) >= 27) {
            int var1 = Client.field352.method2973(15);
            if(var1 != 32767) {
               boolean var2 = false;
               if(Client.cachedNPCs[var1] == null) {
                  Client.cachedNPCs[var1] = new NPC();
                  var2 = true;
               }

               NPC var3 = Client.cachedNPCs[var1];
               Client.field333[++Client.field332 - 1] = var1;
               var3.field653 = Client.gameCycle;
               var3.composition = Buffer.getNpcDefinition(Client.field352.method2973(14));
               int var4 = Client.field421[Client.field352.method2973(3)];
               if(var2) {
                  var3.angle = var4 * 708214139;
                  var3.field655 = var4;
               }

               int var5 = Client.field352.method2973(1);
               int var6;
               if(var0) {
                  var6 = Client.field352.method2973(8);
                  if(var6 > 127) {
                     var6 -= 256;
                  }
               } else {
                  var6 = Client.field352.method2973(5);
                  if(var6 > 15) {
                     var6 -= 32;
                  }
               }

               int var7;
               if(var0) {
                  var7 = Client.field352.method2973(8);
                  if(var7 > 127) {
                     var7 -= 256;
                  }
               } else {
                  var7 = Client.field352.method2973(5);
                  if(var7 > 15) {
                     var7 -= 32;
                  }
               }

               int var8 = Client.field352.method2973(1);
               if(var8 == 1) {
                  Client.field335[++Client.field334 - 1] = var1;
               }

               var3.field645 = var3.composition.field3010;
               var3.field646 = var3.composition.field3014;
               if(var3.field646 == 0) {
                  var3.angle = 0;
               }

               var3.field636 = var3.composition.field3016;
               var3.field613 = var3.composition.field3017;
               var3.field614 = var3.composition.field3018;
               var3.field615 = var3.composition.field3019;
               var3.idlePoseAnimation = var3.composition.field3013;
               var3.field610 = var3.composition.field3036;
               var3.field611 = var3.composition.field3033;
               var3.method704(var7 + XItemContainer.localPlayer.pathX[0], var6 + XItemContainer.localPlayer.pathY[0], var5 == 1);
               continue;
            }
         }

         Client.field352.method2967();
         return;
      }
   }
}
