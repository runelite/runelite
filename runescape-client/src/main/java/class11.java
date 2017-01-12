import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public class class11 {
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = -45899979
   )
   protected static int field115;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1909590459
   )
   int field116 = -1;
   @ObfuscatedName("i")
   int[] field117;
   @ObfuscatedName("a")
   String[] field118;
   @ObfuscatedName("ao")
   static class184 field120;
   @ObfuscatedName("jy")
   static Widget[] field122;
   @ObfuscatedName("pg")
   static class1 field123;
   @ObfuscatedName("u")
   class48 field124;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "802435825"
   )
   static final void method150() {
      if(class37.field774 != null) {
         class37.field774.method2026();
         class37.field774 = null;
      }

      Tile.method1512();
      class6.region.method1775();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].method2229();
      }

      System.gc();
      class138.field1900 = 1;
      class138.field1903 = null;
      class47.field920 = -1;
      class0.field2 = -1;
      FrameMap.field1466 = 0;
      ChatMessages.field916 = false;
      class138.field1904 = 2;
      Client.field444 = -1;
      Client.field519 = false;
      class173.method3237();
      Friend.setGameState(10);
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIII)V",
      garbageValue = "1360186488"
   )
   static final void method151(Player var0, int var1, int var2, int var3) {
      if(class148.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            int var7;
            if(var0.field248 == 0) {
               String var5 = var0.actions[0] + var0.name + var0.actions[1];
               var7 = var0.combatLevel;
               int var8 = class148.localPlayer.combatLevel;
               int var9 = var8 - var7;
               String var10;
               if(var9 < -9) {
                  var10 = class32.method691(16711680);
               } else if(var9 < -6) {
                  var10 = class32.method691(16723968);
               } else if(var9 < -3) {
                  var10 = class32.method691(16740352);
               } else if(var9 < 0) {
                  var10 = class32.method691(16756736);
               } else if(var9 > 9) {
                  var10 = class32.method691('\uff00');
               } else if(var9 > 6) {
                  var10 = class32.method691(4259584);
               } else if(var9 > 3) {
                  var10 = class32.method691(8453888);
               } else if(var9 > 0) {
                  var10 = class32.method691(12648192);
               } else {
                  var10 = class32.method691(16776960);
               }

               var4 = var5 + var10 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.field248 + ")" + var0.actions[2];
            }

            int var11;
            if(Client.field447 == 1) {
               GroundObject.addMenuEntry("Use", Client.field468 + " " + "->" + " " + class32.method691(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.field435) {
               if((class214.field3158 & 8) == 8) {
                  GroundObject.addMenuEntry(Client.field438, Client.field282 + " " + "->" + " " + class32.method691(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var11 = 7; var11 >= 0; --var11) {
                  if(null != Client.field466[var11]) {
                     short var6 = 0;
                     if(Client.field466[var11].equalsIgnoreCase("Attack")) {
                        if(class40.field798 == Client.field306) {
                           continue;
                        }

                        if(Client.field306 == class40.field802 || Client.field306 == class40.field799 && var0.combatLevel > class148.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(class148.localPlayer.team != 0 && var0.team != 0) {
                           if(class148.localPlayer.team == var0.team) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(Client.field410[var11]) {
                        var6 = 2000;
                     }

                     boolean var12 = false;
                     var7 = var6 + Client.field408[var11];
                     GroundObject.addMenuEntry(Client.field466[var11], class32.method691(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var11 = 0; var11 < Client.menuOptionCount; ++var11) {
               if(Client.menuTypes[var11] == 23) {
                  Client.menuTargets[var11] = class32.method691(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LGameEngine;I)V",
      garbageValue = "147772728"
   )
   static void method152(GameEngine var0) {
      int var1;
      int var2;
      int var3;
      int var14;
      if(class41.worldSelectShown) {
         if(class115.field1794 == 1 || !GroundObject.field1297 && class115.field1794 == 4) {
            var1 = class41.field846 + 280;
            if(class115.field1791 >= var1 && class115.field1791 <= 14 + var1 && class115.field1796 >= 4 && class115.field1796 <= 18) {
               class161.method3070(0, 0);
            } else if(class115.field1791 >= 15 + var1 && class115.field1791 <= 80 + var1 && class115.field1796 >= 4 && class115.field1796 <= 18) {
               class161.method3070(0, 1);
            } else {
               var2 = 390 + class41.field846;
               if(class115.field1791 >= var2 && class115.field1791 <= 14 + var2 && class115.field1796 >= 4 && class115.field1796 <= 18) {
                  class161.method3070(1, 0);
               } else if(class115.field1791 >= 15 + var2 && class115.field1791 <= 80 + var2 && class115.field1796 >= 4 && class115.field1796 <= 18) {
                  class161.method3070(1, 1);
               } else {
                  var3 = 500 + class41.field846;
                  if(class115.field1791 >= var3 && class115.field1791 <= var3 + 14 && class115.field1796 >= 4 && class115.field1796 <= 18) {
                     class161.method3070(2, 0);
                  } else if(class115.field1791 >= 15 + var3 && class115.field1791 <= 80 + var3 && class115.field1796 >= 4 && class115.field1796 <= 18) {
                     class161.method3070(2, 1);
                  } else {
                     var14 = class41.field846 + 610;
                     if(class115.field1791 >= var14 && class115.field1791 <= 14 + var14 && class115.field1796 >= 4 && class115.field1796 <= 18) {
                        class161.method3070(3, 0);
                     } else if(class115.field1791 >= var14 + 15 && class115.field1791 <= 80 + var14 && class115.field1796 >= 4 && class115.field1796 <= 18) {
                        class161.method3070(3, 1);
                     } else if(class115.field1791 >= 708 + class41.field846 && class115.field1796 >= 4 && class115.field1791 <= class41.field846 + 708 + 50 && class115.field1796 <= 20) {
                        class41.worldSelectShown = false;
                        class41.field809.method4123(class41.field846, 0);
                        class41.field840.method4123(382 + class41.field846, 0);
                        class229.field3246.method4066(class41.field846 + 382 - class229.field3246.originalWidth / 2, 18);
                     } else if(class41.field841 != -1) {
                        World var9 = World.worldList[class41.field841];
                        class139.selectWorld(var9);
                        class41.worldSelectShown = false;
                        class41.field809.method4123(class41.field846, 0);
                        class41.field840.method4123(382 + class41.field846, 0);
                        class229.field3246.method4066(382 + class41.field846 - class229.field3246.originalWidth / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((class115.field1794 == 1 || !GroundObject.field1297 && class115.field1794 == 4) && class115.field1791 >= class41.field846 + 765 - 50 && class115.field1796 >= 453) {
            class2.field21.field692 = !class2.field21.field692;
            class7.method108();
            if(!class2.field21.field692) {
               class184 var10 = class37.field781;
               var2 = var10.method3277("scape main");
               var3 = var10.method3278(var2, "");
               class107.method2001(var10, var2, var3, 255, false);
            } else {
               class9.method118();
            }
         }

         if(Client.gameState != 5) {
            ++class41.field823;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.field472 == 0) {
                  if(class115.field1794 == 1 || !GroundObject.field1297 && class115.field1794 == 4) {
                     var1 = class41.field846 + 5;
                     short var12 = 463;
                     byte var13 = 100;
                     byte var4 = 35;
                     if(class115.field1791 >= var1 && class115.field1791 <= var1 + var13 && class115.field1796 >= var12 && class115.field1796 <= var12 + var4) {
                        class161.method3072();
                        return;
                     }
                  }

                  if(null != Friend.worldServersDownload) {
                     class161.method3072();
                  }
               }

               var1 = class115.field1794;
               var2 = class115.field1791;
               var3 = class115.field1796;
               if(!GroundObject.field1297 && var1 == 4) {
                  var1 = 1;
               }

               short var5;
               if(class41.loginIndex == 0) {
                  var14 = 180 + class41.loginWindowX - 80;
                  var5 = 291;
                  if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                     class156.method2998(class164.method3113("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var14 = 180 + class41.loginWindowX + 80;
                  if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                     if((Client.flags & 33554432) != 0) {
                        class41.field828 = "";
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

                        class41.field828 = "Warning!";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class41.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class41.loginMessage2 = "The Protect Item prayer will";
                        class41.loginMessage3 = "not work on this world.";
                        class41.field828 = "Warning!";
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
                  short var15;
                  if(class41.loginIndex == 2) {
                     var15 = 231;
                     var14 = var15 + 30;
                     if(var1 == 1 && var3 >= var14 - 15 && var3 < var14) {
                        class41.loginIndex2 = 0;
                     }

                     var14 += 15;
                     if(var1 == 1 && var3 >= var14 - 15 && var3 < var14) {
                        class41.loginIndex2 = 1;
                     }

                     var14 += 15;
                     var15 = 361;
                     if(var1 == 1 && var3 >= var15 - 15 && var3 < var15) {
                        class116.method2225("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class41.loginIndex = 5;
                        return;
                     }

                     int var16 = 180 + class41.loginWindowX - 80;
                     short var6 = 321;
                     if(var1 == 1 && var2 >= var16 - 75 && var2 <= 75 + var16 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                        class41.username = class41.username.trim();
                        if(class41.username.length() == 0) {
                           class116.method2225("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class41.field833.length() == 0) {
                           class116.method2225("", "Please enter your password.", "");
                           return;
                        }

                        class116.method2225("", "Connecting to server...", "");
                        class41.field834 = class2.field21.field691.containsKey(Integer.valueOf(CombatInfo2.method3531(class41.username)))?class97.field1619:class97.field1620;
                        Friend.setGameState(20);
                        return;
                     }

                     var16 = 80 + 180 + class41.loginWindowX;
                     if(var1 == 1 && var2 >= var16 - 75 && var2 <= var16 + 75 && var3 >= var6 - 20 && var3 <= 20 + var6) {
                        class41.loginIndex = 0;
                        class41.username = "";
                        class41.field833 = "";
                        RSCanvas.field1747 = 0;
                        XClanMember.authCode = "";
                        class41.field835 = true;
                     }

                     while(true) {
                        while(class196.method3554()) {
                           boolean var7 = false;

                           for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                              if(class175.field2631 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                 var7 = true;
                                 break;
                              }
                           }

                           if(class162.field2134 == 13) {
                              class41.loginIndex = 0;
                              class41.username = "";
                              class41.field833 = "";
                              RSCanvas.field1747 = 0;
                              XClanMember.authCode = "";
                              class41.field835 = true;
                           } else if(class41.loginIndex2 == 0) {
                              if(class162.field2134 == 85 && class41.username.length() > 0) {
                                 class41.username = class41.username.substring(0, class41.username.length() - 1);
                              }

                              if(class162.field2134 == 84 || class162.field2134 == 80) {
                                 class41.loginIndex2 = 1;
                              }

                              if(var7 && class41.username.length() < 320) {
                                 class41.username = class41.username + class175.field2631;
                              }
                           } else if(class41.loginIndex2 == 1) {
                              if(class162.field2134 == 85 && class41.field833.length() > 0) {
                                 class41.field833 = class41.field833.substring(0, class41.field833.length() - 1);
                              }

                              if(class162.field2134 == 84 || class162.field2134 == 80) {
                                 class41.loginIndex2 = 0;
                              }

                              if(class162.field2134 == 84) {
                                 class41.username = class41.username.trim();
                                 if(class41.username.length() == 0) {
                                    class116.method2225("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class41.field833.length() == 0) {
                                    class116.method2225("", "Please enter your password.", "");
                                    return;
                                 }

                                 class116.method2225("", "Connecting to server...", "");
                                 class41.field834 = class2.field21.field691.containsKey(Integer.valueOf(CombatInfo2.method3531(class41.username)))?class97.field1619:class97.field1620;
                                 Friend.setGameState(20);
                                 return;
                              }

                              if(var7 && class41.field833.length() < 20) {
                                 class41.field833 = class41.field833 + class175.field2631;
                              }
                           }
                        }

                        return;
                     }
                  } else if(class41.loginIndex == 3) {
                     var14 = class41.loginWindowX + 180;
                     var5 = 276;
                     if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     }

                     var14 = 180 + class41.loginWindowX;
                     var5 = 326;
                     if(var1 == 1 && var2 >= var14 - 75 && var2 <= 75 + var14 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                        class116.method2225("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class41.loginIndex = 5;
                        return;
                     }
                  } else {
                     boolean var17;
                     int var18;
                     if(class41.loginIndex == 4) {
                        var14 = 180 + class41.loginWindowX - 80;
                        var5 = 321;
                        if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                           XClanMember.authCode.trim();
                           if(XClanMember.authCode.length() != 6) {
                              class116.method2225("", "Please enter a 6-digit PIN.", "");
                              return;
                           }

                           RSCanvas.field1747 = Integer.parseInt(XClanMember.authCode);
                           XClanMember.authCode = "";
                           class41.field834 = class41.field835?class97.field1625:class97.field1624;
                           class116.method2225("", "Connecting to server...", "");
                           Friend.setGameState(20);
                           return;
                        }

                        if(var1 == 1 && var2 >= class41.loginWindowX + 180 - 9 && var2 <= 130 + class41.loginWindowX + 180 && var3 >= 263 && var3 <= 296) {
                           class41.field835 = !class41.field835;
                        }

                        if(var1 == 1 && var2 >= 180 + class41.loginWindowX - 34 && var2 <= 34 + 180 + class41.loginWindowX && var3 >= 351 && var3 <= 363) {
                           String var11 = class164.method3113("secure", true) + "m=totp-authenticator/disableTOTPRequest";
                           class2.method24(var11, true, "openjs", false);
                        }

                        var14 = 80 + 180 + class41.loginWindowX;
                        if(var1 == 1 && var2 >= var14 - 75 && var2 <= 75 + var14 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                           class41.loginIndex = 0;
                           class41.username = "";
                           class41.field833 = "";
                           RSCanvas.field1747 = 0;
                           XClanMember.authCode = "";
                        }

                        while(class196.method3554()) {
                           var17 = false;

                           for(var18 = 0; var18 < "1234567890".length(); ++var18) {
                              if(class175.field2631 == "1234567890".charAt(var18)) {
                                 var17 = true;
                                 break;
                              }
                           }

                           if(class162.field2134 == 13) {
                              class41.loginIndex = 0;
                              class41.username = "";
                              class41.field833 = "";
                              RSCanvas.field1747 = 0;
                              XClanMember.authCode = "";
                           } else {
                              if(class162.field2134 == 85 && XClanMember.authCode.length() > 0) {
                                 XClanMember.authCode = XClanMember.authCode.substring(0, XClanMember.authCode.length() - 1);
                              }

                              if(class162.field2134 == 84) {
                                 XClanMember.authCode.trim();
                                 if(XClanMember.authCode.length() != 6) {
                                    class116.method2225("", "Please enter a 6-digit PIN.", "");
                                    return;
                                 }

                                 RSCanvas.field1747 = Integer.parseInt(XClanMember.authCode);
                                 XClanMember.authCode = "";
                                 class41.field834 = class41.field835?class97.field1625:class97.field1624;
                                 class116.method2225("", "Connecting to server...", "");
                                 Friend.setGameState(20);
                                 return;
                              }

                              if(var17 && XClanMember.authCode.length() < 6) {
                                 XClanMember.authCode = XClanMember.authCode + class175.field2631;
                              }
                           }
                        }
                     } else if(class41.loginIndex == 5) {
                        var14 = 180 + class41.loginWindowX - 80;
                        var5 = 321;
                        if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                           KitDefinition.method3507();
                           return;
                        }

                        var14 = 180 + class41.loginWindowX + 80;
                        if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                           class41.field833 = "";
                        }

                        while(class196.method3554()) {
                           var17 = false;

                           for(var18 = 0; var18 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var18) {
                              if(class175.field2631 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var18)) {
                                 var17 = true;
                                 break;
                              }
                           }

                           if(class162.field2134 == 13) {
                              class41.loginMessage1 = "";
                              class41.loginMessage2 = "Enter your username/email & password.";
                              class41.loginMessage3 = "";
                              class41.loginIndex = 2;
                              class41.loginIndex2 = 0;
                              class41.field833 = "";
                           } else {
                              if(class162.field2134 == 85 && class41.username.length() > 0) {
                                 class41.username = class41.username.substring(0, class41.username.length() - 1);
                              }

                              if(class162.field2134 == 84) {
                                 KitDefinition.method3507();
                                 return;
                              }

                              if(var17 && class41.username.length() < 320) {
                                 class41.username = class41.username + class175.field2631;
                              }
                           }
                        }
                     } else if(class41.loginIndex == 6) {
                        while(true) {
                           do {
                              if(!class196.method3554()) {
                                 var15 = 321;
                                 if(var1 == 1 && var3 >= var15 - 20 && var3 <= var15 + 20) {
                                    class41.loginMessage1 = "";
                                    class41.loginMessage2 = "Enter your username/email & password.";
                                    class41.loginMessage3 = "";
                                    class41.loginIndex = 2;
                                    class41.loginIndex2 = 0;
                                    class41.field833 = "";
                                 }

                                 return;
                              }
                           } while(class162.field2134 != 84 && class162.field2134 != 13);

                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                           class41.field833 = "";
                        }
                     }
                  }
               } else {
                  while(class196.method3554()) {
                     if(class162.field2134 == 84) {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     } else if(class162.field2134 == 13) {
                        class41.loginIndex = 0;
                     }
                  }

                  var14 = class41.loginWindowX + 180 - 80;
                  var5 = 321;
                  if(var1 == 1 && var2 >= var14 - 75 && var2 <= 75 + var14 && var3 >= var5 - 20 && var3 <= var5 + 20) {
                     class41.loginMessage1 = "";
                     class41.loginMessage2 = "Enter your username/email & password.";
                     class41.loginMessage3 = "";
                     class41.loginIndex = 2;
                     class41.loginIndex2 = 0;
                  }

                  var14 = 80 + 180 + class41.loginWindowX;
                  if(var1 == 1 && var2 >= var14 - 75 && var2 <= 75 + var14 && var3 >= var5 - 20 && var3 <= 20 + var5) {
                     class41.loginIndex = 0;
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass159;II)V",
      garbageValue = "-622559813"
   )
   static void method153(class159 var0, int var1) {
      boolean var2 = var0.method3032(1) == 1;
      if(var2) {
         class45.field904[++class45.field895 - 1] = var1;
      }

      int var3 = var0.method3032(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field263 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class45.field889[var1] = (XItemContainer.baseY + var4.pathY[0] >> 6) + (var4.field261 << 28) + (FrameMap.baseX + var4.pathX[0] >> 6 << 14);
            if(var4.field627 != -1) {
               class45.field883[var1] = var4.field627;
            } else {
               class45.field883[var1] = var4.field650;
            }

            class45.field894[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.method3032(1) != 0) {
               class30.method673(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method3032(3);
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
               var4.method218(var6, var7);
               var4.field263 = false;
            } else if(var2) {
               var4.field263 = true;
               var4.field264 = var6;
               var4.field265 = var7;
            } else {
               var4.field263 = false;
               var4.method217(var6, var7, class45.field886[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.method3032(4);
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

            if(var1 == Client.localInteractingIndex && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method218(var6, var7);
               var4.field263 = false;
            } else if(var2) {
               var4.field263 = true;
               var4.field264 = var6;
               var4.field265 = var7;
            } else {
               var4.field263 = false;
               var4.method217(var6, var7, class45.field886[var1]);
            }

         } else {
            var5 = var0.method3032(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method3032(12);
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
               var11 = var9 + var4.pathY[0];
               if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field263 = true;
                     var4.field264 = var10;
                     var4.field265 = var11;
                  } else {
                     var4.field263 = false;
                     var4.method217(var10, var11, class45.field886[var1]);
                  }
               } else {
                  var4.method218(var10, var11);
                  var4.field263 = false;
               }

               var4.field261 = (byte)(var7 + var4.field261 & 3);
               if(var1 == Client.localInteractingIndex) {
                  class60.plane = var4.field261;
               }

            } else {
               var6 = var0.method3032(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + FrameMap.baseX + var4.pathX[0] & 16383) - FrameMap.baseX;
               var11 = (XItemContainer.baseY + var4.pathY[0] + var9 & 16383) - XItemContainer.baseY;
               if(var1 == Client.localInteractingIndex && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method218(var10, var11);
                  var4.field263 = false;
               } else if(var2) {
                  var4.field263 = true;
                  var4.field264 = var10;
                  var4.field265 = var11;
               } else {
                  var4.field263 = false;
                  var4.method217(var10, var11, class45.field886[var1]);
               }

               var4.field261 = (byte)(var7 + var4.field261 & 3);
               if(var1 == Client.localInteractingIndex) {
                  class60.plane = var4.field261;
               }

            }
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)[Lclass178;",
      garbageValue = "1253620742"
   )
   static class178[] method154() {
      return new class178[]{class178.field2659, class178.field2657, class178.field2654, class178.field2655};
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "-74"
   )
   public static String method155(CharSequence var0) {
      String var1 = class174.method3238(class191.method3479(var0));
      if(var1 == null) {
         var1 = "";
      }

      return var1;
   }
}
