import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
public class class224 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lbx;B)V",
      garbageValue = "4"
   )
   static void method4102(GameEngine var0) {
      if(class91.worldSelectShown) {
         class60.method1069(var0);
      } else {
         int var2;
         int var3;
         if((MouseInput.field754 == 1 || !Client.field951 && MouseInput.field754 == 4) && MouseInput.field753 >= class91.field1435 + 765 - 50 && MouseInput.field739 >= 453) {
            Buffer.preferences.muted = !Buffer.preferences.muted;
            class20.method176();
            if(!Buffer.preferences.muted) {
               IndexData var1 = class45.indexTrack1;
               var2 = var1.getFile("scape main");
               var3 = var1.getChild(var2, "");
               CacheFile.method2339(var1, var2, var3, 255, false);
            } else {
               class165.method3158();
            }
         }

         if(Client.gameState != 5) {
            ++class91.field1446;
            if(Client.gameState == 10 || Client.gameState == 11) {
               int var9;
               if(Client.languageId == 0) {
                  if(MouseInput.field754 == 1 || !Client.field951 && MouseInput.field754 == 4) {
                     var9 = class91.field1435 + 5;
                     short var10 = 463;
                     byte var11 = 100;
                     byte var4 = 35;
                     if(MouseInput.field753 >= var9 && MouseInput.field753 <= var9 + var11 && MouseInput.field739 >= var10 && MouseInput.field739 <= var10 + var4) {
                        class15.method108();
                        return;
                     }
                  }

                  if(class73.listFetcher != null) {
                     class15.method108();
                  }
               }

               var9 = MouseInput.field754;
               var2 = MouseInput.field753;
               var3 = MouseInput.field739;
               if(var9 == 0) {
                  var2 = MouseInput.field752;
                  var3 = MouseInput.field747;
               }

               if(!Client.field951 && var9 == 4) {
                  var9 = 1;
               }

               int var5;
               short var6;
               if(class91.loginIndex == 0) {
                  boolean var12 = false;

                  while(class20.method175()) {
                     if(class203.field2493 == 84) {
                        var12 = true;
                     }
                  }

                  var5 = Ignore.field874 - 80;
                  var6 = 291;
                  if(var9 == 1 && var2 >= var5 - 75 && var2 <= var5 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                     class35.method517(class86.method1709("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var5 = Ignore.field874 + 80;
                  if(var9 == 1 && var2 >= var5 - 75 && var2 <= var5 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20 || var12) {
                     if((Client.flags & 33554432) != 0) {
                        class91.field1451 = "";
                        class91.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class91.loginMessage2 = "Your normal account will not be affected.";
                        class91.loginMessage3 = "";
                        class91.loginIndex = 1;
                        class40.method575();
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class91.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class91.loginMessage2 = "Players can attack each other almost everywhere";
                           class91.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class91.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class91.loginMessage2 = "Players can attack each other";
                           class91.loginMessage3 = "almost everywhere.";
                        }

                        class91.field1451 = "Warning!";
                        class91.loginIndex = 1;
                        class40.method575();
                     } else if((Client.flags & 1024) != 0) {
                        class91.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class91.loginMessage2 = "The Protect Item prayer will";
                        class91.loginMessage3 = "not work on this world.";
                        class91.field1451 = "Warning!";
                        class91.loginIndex = 1;
                        class40.method575();
                     } else {
                        class39.method573(false);
                     }
                  }
               } else {
                  int var13;
                  short var15;
                  if(class91.loginIndex != 1) {
                     short var14;
                     if(class91.loginIndex == 2) {
                        var14 = 201;
                        var13 = var14 + 52;
                        if(var9 == 1 && var3 >= var13 - 12 && var3 < var13 + 2) {
                           class91.field1461 = 0;
                        }

                        var13 += 15;
                        if(var9 == 1 && var3 >= var13 - 12 && var3 < var13 + 2) {
                           class91.field1461 = 1;
                        }

                        var13 += 15;
                        var14 = 361;
                        if(var9 == 1 && var3 >= var14 - 15 && var3 < var14) {
                           class228.method4112("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class91.loginIndex = 5;
                           return;
                        }

                        var5 = Ignore.field874 - 80;
                        var6 = 321;
                        if(var9 == 1 && var2 >= var5 - 75 && var2 <= var5 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                           class91.username = class91.username.trim();
                           if(class91.username.length() == 0) {
                              class228.method4112("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class91.password.length() == 0) {
                              class228.method4112("", "Please enter your password.", "");
                              return;
                           }

                           class228.method4112("", "Connecting to server...", "");
                           class81.method1615(false);
                           WorldMapType2.setGameState(20);
                           return;
                        }

                        var5 = class91.loginWindowX + 180 + 80;
                        if(var9 == 1 && var2 >= var5 - 75 && var2 <= var5 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                           class91.loginIndex = 0;
                           class91.username = "";
                           class91.password = "";
                           GroundObject.field1875 = 0;
                           class13.field282 = "";
                           class91.field1447 = true;
                        }

                        var5 = Ignore.field874 + -117;
                        class91.field1438 = var2 >= var5 && var2 < var5 + class86.field1391 && var3 >= 277 && var3 < class29.field433 + 277;
                        if(var9 == 1 && class91.field1438) {
                           class91.field1457 = !class91.field1457;
                           if(!class91.field1457 && Buffer.preferences.field1319 != null) {
                              Buffer.preferences.field1319 = null;
                              class20.method176();
                           }
                        }

                        var5 = Ignore.field874 + 24;
                        class91.field1459 = var2 >= var5 && var2 < var5 + class86.field1391 && var3 >= 277 && var3 < class29.field433 + 277;
                        if(var9 == 1 && class91.field1459) {
                           Buffer.preferences.field1320 = !Buffer.preferences.field1320;
                           if(!Buffer.preferences.field1320) {
                              class91.username = "";
                              Buffer.preferences.field1319 = null;
                              class40.method575();
                           }

                           class20.method176();
                        }

                        while(true) {
                           while(class20.method175()) {
                              boolean var7 = false;

                              for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                                 if(WorldMapType1.field444 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                    var7 = true;
                                    break;
                                 }
                              }

                              if(class203.field2493 == 13) {
                                 class91.loginIndex = 0;
                                 class91.username = "";
                                 class91.password = "";
                                 GroundObject.field1875 = 0;
                                 class13.field282 = "";
                                 class91.field1447 = true;
                              } else if(class91.field1461 == 0) {
                                 if(class203.field2493 == 85 && class91.username.length() > 0) {
                                    class91.username = class91.username.substring(0, class91.username.length() - 1);
                                 }

                                 if(class203.field2493 == 84 || class203.field2493 == 80) {
                                    class91.field1461 = 1;
                                 }

                                 if(var7 && class91.username.length() < 320) {
                                    class91.username = class91.username + WorldMapType1.field444;
                                 }
                              } else if(class91.field1461 == 1) {
                                 if(class203.field2493 == 85 && class91.password.length() > 0) {
                                    class91.password = class91.password.substring(0, class91.password.length() - 1);
                                 }

                                 if(class203.field2493 == 84 || class203.field2493 == 80) {
                                    class91.field1461 = 0;
                                 }

                                 if(class203.field2493 == 84) {
                                    class91.username = class91.username.trim();
                                    if(class91.username.length() == 0) {
                                       class228.method4112("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class91.password.length() == 0) {
                                       class228.method4112("", "Please enter your password.", "");
                                       return;
                                    }

                                    class228.method4112("", "Connecting to server...", "");
                                    class81.method1615(false);
                                    WorldMapType2.setGameState(20);
                                    return;
                                 }

                                 if(var7 && class91.password.length() < 20) {
                                    class91.password = class91.password + WorldMapType1.field444;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class91.loginIndex == 3) {
                        var13 = class91.loginWindowX + 180;
                        var15 = 276;
                        if(var9 == 1 && var2 >= var13 - 75 && var2 <= var13 + 75 && var3 >= var15 - 20 && var3 <= var15 + 20) {
                           class39.method573(false);
                        }

                        var13 = class91.loginWindowX + 180;
                        var15 = 326;
                        if(var9 == 1 && var2 >= var13 - 75 && var2 <= var13 + 75 && var3 >= var15 - 20 && var3 <= var15 + 20) {
                           class228.method4112("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class91.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var16;
                        int var17;
                        if(class91.loginIndex == 4) {
                           var13 = class91.loginWindowX + 180 - 80;
                           var15 = 321;
                           if(var9 == 1 && var2 >= var13 - 75 && var2 <= var13 + 75 && var3 >= var15 - 20 && var3 <= var15 + 20) {
                              class13.field282.trim();
                              if(class13.field282.length() != 6) {
                                 class228.method4112("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              GroundObject.field1875 = Integer.parseInt(class13.field282);
                              class13.field282 = "";
                              class81.method1615(true);
                              class228.method4112("", "Connecting to server...", "");
                              WorldMapType2.setGameState(20);
                              return;
                           }

                           if(var9 == 1 && var2 >= class91.loginWindowX + 180 - 9 && var2 <= class91.loginWindowX + 180 + 130 && var3 >= 263 && var3 <= 296) {
                              class91.field1447 = !class91.field1447;
                           }

                           if(var9 == 1 && var2 >= class91.loginWindowX + 180 - 34 && var2 <= class91.loginWindowX + 34 + 180 && var3 >= 351 && var3 <= 363) {
                              class35.method517(class86.method1709("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                           }

                           var13 = class91.loginWindowX + 180 + 80;
                           if(var9 == 1 && var2 >= var13 - 75 && var2 <= var13 + 75 && var3 >= var15 - 20 && var3 <= var15 + 20) {
                              class91.loginIndex = 0;
                              class91.username = "";
                              class91.password = "";
                              GroundObject.field1875 = 0;
                              class13.field282 = "";
                           }

                           while(class20.method175()) {
                              var16 = false;

                              for(var17 = 0; var17 < "1234567890".length(); ++var17) {
                                 if(WorldMapType1.field444 == "1234567890".charAt(var17)) {
                                    var16 = true;
                                    break;
                                 }
                              }

                              if(class203.field2493 == 13) {
                                 class91.loginIndex = 0;
                                 class91.username = "";
                                 class91.password = "";
                                 GroundObject.field1875 = 0;
                                 class13.field282 = "";
                              } else {
                                 if(class203.field2493 == 85 && class13.field282.length() > 0) {
                                    class13.field282 = class13.field282.substring(0, class13.field282.length() - 1);
                                 }

                                 if(class203.field2493 == 84) {
                                    class13.field282.trim();
                                    if(class13.field282.length() != 6) {
                                       class228.method4112("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    GroundObject.field1875 = Integer.parseInt(class13.field282);
                                    class13.field282 = "";
                                    class81.method1615(true);
                                    class228.method4112("", "Connecting to server...", "");
                                    WorldMapType2.setGameState(20);
                                    return;
                                 }

                                 if(var16 && class13.field282.length() < 6) {
                                    class13.field282 = class13.field282 + WorldMapType1.field444;
                                 }
                              }
                           }
                        } else if(class91.loginIndex == 5) {
                           var13 = class91.loginWindowX + 180 - 80;
                           var15 = 321;
                           if(var9 == 1 && var2 >= var13 - 75 && var2 <= var13 + 75 && var3 >= var15 - 20 && var3 <= var15 + 20) {
                              SceneTilePaint.method2706();
                              return;
                           }

                           var13 = class91.loginWindowX + 180 + 80;
                           if(var9 == 1 && var2 >= var13 - 75 && var2 <= var13 + 75 && var3 >= var15 - 20 && var3 <= var15 + 20) {
                              class39.method573(true);
                           }

                           while(class20.method175()) {
                              var16 = false;

                              for(var17 = 0; var17 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var17) {
                                 if(WorldMapType1.field444 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var17)) {
                                    var16 = true;
                                    break;
                                 }
                              }

                              if(class203.field2493 == 13) {
                                 class39.method573(true);
                              } else {
                                 if(class203.field2493 == 85 && class91.username.length() > 0) {
                                    class91.username = class91.username.substring(0, class91.username.length() - 1);
                                 }

                                 if(class203.field2493 == 84) {
                                    SceneTilePaint.method2706();
                                    return;
                                 }

                                 if(var16 && class91.username.length() < 320) {
                                    class91.username = class91.username + WorldMapType1.field444;
                                 }
                              }
                           }
                        } else if(class91.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!class20.method175()) {
                                    var14 = 321;
                                    if(var9 == 1 && var3 >= var14 - 20 && var3 <= var14 + 20) {
                                       class39.method573(true);
                                    }

                                    return;
                                 }
                              } while(class203.field2493 != 84 && class203.field2493 != 13);

                              class39.method573(true);
                           }
                        }
                     }
                  } else {
                     while(class20.method175()) {
                        if(class203.field2493 == 84) {
                           class39.method573(false);
                        } else if(class203.field2493 == 13) {
                           class91.loginIndex = 0;
                        }
                     }

                     var13 = Ignore.field874 - 80;
                     var15 = 321;
                     if(var9 == 1 && var2 >= var13 - 75 && var2 <= var13 + 75 && var3 >= var15 - 20 && var3 <= var15 + 20) {
                        class39.method573(false);
                     }

                     var13 = Ignore.field874 + 80;
                     if(var9 == 1 && var2 >= var13 - 75 && var2 <= var13 + 75 && var3 >= var15 - 20 && var3 <= var15 + 20) {
                        class91.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }
}
