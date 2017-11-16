import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
public class class87 {
   @ObfuscatedName("eq")
   @Export("mapRegions")
   @Hook("mapRegionsChanged")
   static int[] mapRegions;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Liu;IIIBZI)V",
      garbageValue = "-1021112225"
   )
   static void method1678(IndexData var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      FileRequest var8 = (FileRequest)class245.field3318.get(var6);
      if(var8 == null) {
         var8 = (FileRequest)class245.field3309.get(var6);
         if(var8 == null) {
            var8 = (FileRequest)class245.field3313.get(var6);
            if(var8 != null) {
               if(var5) {
                  var8.unlinkDual();
                  class245.field3318.put(var8, var6);
                  --class245.field3322;
                  ++class245.field3308;
               }

            } else {
               if(!var5) {
                  var8 = (FileRequest)class245.field3314.get(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new FileRequest();
               var8.index = var0;
               var8.crc = var3;
               var8.padding = var4;
               if(var5) {
                  class245.field3318.put(var8, var6);
                  ++class245.field3308;
               } else {
                  class245.field3305.push(var8);
                  class245.field3313.put(var8, var6);
                  ++class245.field3322;
               }

            }
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lbt;I)V",
      garbageValue = "-541668249"
   )
   static void method1677(GameEngine var0) {
      if(class91.worldSelectShown) {
         class10.method60(var0);
      } else {
         if((MouseInput.field687 == 1 || !Signlink.field2142 && MouseInput.field687 == 4) && MouseInput.field674 >= class91.field1361 + 765 - 50 && MouseInput.field688 >= 453) {
            class70.preferences.muted = !class70.preferences.muted;
            GameEngine.method925();
            if(!class70.preferences.muted) {
               class23.method163(class45.indexTrack1, "scape main", "", 255, false);
            } else {
               WorldMapData.method319();
            }
         }

         if(Client.gameState != 5) {
            ++class91.field1341;
            if(Client.gameState == 10 || Client.gameState == 11) {
               int var1;
               if(Client.languageId == 0) {
                  if(MouseInput.field687 == 1 || !Signlink.field2142 && MouseInput.field687 == 4) {
                     var1 = class91.field1361 + 5;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(MouseInput.field674 >= var1 && MouseInput.field674 <= var1 + var3 && MouseInput.field688 >= var2 && MouseInput.field688 <= var2 + var4) {
                        ScriptState.method998();
                        return;
                     }
                  }

                  if(SoundTask.listFetcher != null) {
                     ScriptState.method998();
                  }
               }

               var1 = MouseInput.field687;
               int var14 = MouseInput.field674;
               int var15 = MouseInput.field688;
               if(var1 == 0) {
                  var14 = MouseInput.field681;
                  var15 = MouseInput.field676;
               }

               if(!Signlink.field2142 && var1 == 4) {
                  var1 = 1;
               }

               int var5;
               short var6;
               if(class91.loginIndex == 0) {
                  boolean var16 = false;

                  while(class251.method4307()) {
                     if(class96.field1426 == 84) {
                        var16 = true;
                     }
                  }

                  var5 = class256.field3426 - 80;
                  var6 = 291;
                  if(var1 == 1 && var14 >= var5 - 75 && var14 <= var5 + 75 && var15 >= var6 - 20 && var15 <= var6 + 20) {
                     label873: {
                        String var7 = GZipDecompressor.method3130("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws";
                        if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                           try {
                              Desktop.getDesktop().browse(new URI(var7));
                              break label873;
                           } catch (Exception var13) {
                              ;
                           }
                        }

                        if(class56.field629.startsWith("win")) {
                           World.method1561(var7, 0);
                        } else if(class56.field629.startsWith("mac")) {
                           ScriptState.method1000(var7, 1, "openjs");
                        } else {
                           World.method1561(var7, 2);
                        }
                     }
                  }

                  var5 = class256.field3426 + 80;
                  if(var1 == 1 && var14 >= var5 - 75 && var14 <= var5 + 75 && var15 >= var6 - 20 && var15 <= var6 + 20 || var16) {
                     if((Client.flags & 33554432) != 0) {
                        class91.field1334 = "";
                        class91.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class91.loginMessage2 = "Your normal account will not be affected.";
                        class91.loginMessage3 = "";
                        class91.loginIndex = 1;
                        class60.method970();
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

                        class91.field1334 = "Warning!";
                        class91.loginIndex = 1;
                        class60.method970();
                     } else if((Client.flags & 1024) != 0) {
                        class91.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class91.loginMessage2 = "The Protect Item prayer will";
                        class91.loginMessage3 = "not work on this world.";
                        class91.field1334 = "Warning!";
                        class91.loginIndex = 1;
                        class60.method970();
                     } else {
                        class20.method147(false);
                     }
                  }
               } else {
                  int var17;
                  short var19;
                  if(class91.loginIndex != 1) {
                     short var18;
                     if(class91.loginIndex == 2) {
                        var18 = 201;
                        var17 = var18 + 52;
                        if(var1 == 1 && var15 >= var17 - 12 && var15 < var17 + 2) {
                           class91.field1356 = 0;
                        }

                        var17 += 15;
                        if(var1 == 1 && var15 >= var17 - 12 && var15 < var17 + 2) {
                           class91.field1356 = 1;
                        }

                        var17 += 15;
                        var18 = 361;
                        if(var1 == 1 && var15 >= var18 - 15 && var15 < var18) {
                           BaseVarType.method14("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class91.loginIndex = 5;
                           return;
                        }

                        var5 = class256.field3426 - 80;
                        var6 = 321;
                        if(var1 == 1 && var14 >= var5 - 75 && var14 <= var5 + 75 && var15 >= var6 - 20 && var15 <= var6 + 20) {
                           class91.username = class91.username.trim();
                           if(class91.username.length() == 0) {
                              BaseVarType.method14("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class91.password.length() == 0) {
                              BaseVarType.method14("", "Please enter your password.", "");
                              return;
                           }

                           BaseVarType.method14("", "Connecting to server...", "");
                           class24.method172(false);
                           class2.setGameState(20);
                           return;
                        }

                        var5 = class91.loginWindowX + 180 + 80;
                        if(var1 == 1 && var14 >= var5 - 75 && var14 <= var5 + 75 && var15 >= var6 - 20 && var15 <= var6 + 20) {
                           class91.loginIndex = 0;
                           class91.username = "";
                           class91.password = "";
                           class51.field609 = 0;
                           class44.field538 = "";
                           class91.field1355 = true;
                        }

                        var5 = class256.field3426 + -117;
                        var6 = 277;
                        class91.field1346 = var14 >= var5 && var14 < var5 + GrandExchangeOffer.field288 && var15 >= var6 && var15 < var6 + class163.field2207;
                        if(var1 == 1 && class91.field1346) {
                           class91.field1352 = !class91.field1352;
                           if(!class91.field1352 && class70.preferences.field1232 != null) {
                              class70.preferences.field1232 = null;
                              GameEngine.method925();
                           }
                        }

                        var5 = class256.field3426 + 24;
                        var6 = 277;
                        class91.field1354 = var14 >= var5 && var14 < var5 + GrandExchangeOffer.field288 && var15 >= var6 && var15 < var6 + class163.field2207;
                        if(var1 == 1 && class91.field1354) {
                           class70.preferences.field1235 = !class70.preferences.field1235;
                           if(!class70.preferences.field1235) {
                              class91.username = "";
                              class70.preferences.field1232 = null;
                              class60.method970();
                           }

                           GameEngine.method925();
                        }

                        while(true) {
                           while(class251.method4307()) {
                              boolean var9 = false;

                              for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                                 if(class233.field3200 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                    var9 = true;
                                    break;
                                 }
                              }

                              if(class96.field1426 == 13) {
                                 class91.loginIndex = 0;
                                 class91.username = "";
                                 class91.password = "";
                                 class51.field609 = 0;
                                 class44.field538 = "";
                                 class91.field1355 = true;
                              } else if(class91.field1356 == 0) {
                                 if(class96.field1426 == 85 && class91.username.length() > 0) {
                                    class91.username = class91.username.substring(0, class91.username.length() - 1);
                                 }

                                 if(class96.field1426 == 84 || class96.field1426 == 80) {
                                    class91.field1356 = 1;
                                 }

                                 if(var9 && class91.username.length() < 320) {
                                    class91.username = class91.username + class233.field3200;
                                 }
                              } else if(class91.field1356 == 1) {
                                 if(class96.field1426 == 85 && class91.password.length() > 0) {
                                    class91.password = class91.password.substring(0, class91.password.length() - 1);
                                 }

                                 if(class96.field1426 == 84 || class96.field1426 == 80) {
                                    class91.field1356 = 0;
                                 }

                                 if(class96.field1426 == 84) {
                                    class91.username = class91.username.trim();
                                    if(class91.username.length() == 0) {
                                       BaseVarType.method14("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class91.password.length() == 0) {
                                       BaseVarType.method14("", "Please enter your password.", "");
                                       return;
                                    }

                                    BaseVarType.method14("", "Connecting to server...", "");
                                    class24.method172(false);
                                    class2.setGameState(20);
                                    return;
                                 }

                                 if(var9 && class91.password.length() < 20) {
                                    class91.password = class91.password + class233.field3200;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class91.loginIndex == 3) {
                        var17 = class91.loginWindowX + 180;
                        var19 = 276;
                        if(var1 == 1 && var14 >= var17 - 75 && var14 <= var17 + 75 && var15 >= var19 - 20 && var15 <= var19 + 20) {
                           class20.method147(false);
                        }

                        var17 = class91.loginWindowX + 180;
                        var19 = 326;
                        if(var1 == 1 && var14 >= var17 - 75 && var14 <= var17 + 75 && var15 >= var19 - 20 && var15 <= var19 + 20) {
                           BaseVarType.method14("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class91.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var20;
                        int var21;
                        if(class91.loginIndex == 4) {
                           var17 = class91.loginWindowX + 180 - 80;
                           var19 = 321;
                           if(var1 == 1 && var14 >= var17 - 75 && var14 <= var17 + 75 && var15 >= var19 - 20 && var15 <= var19 + 20) {
                              class44.field538.trim();
                              if(class44.field538.length() != 6) {
                                 BaseVarType.method14("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              class51.field609 = Integer.parseInt(class44.field538);
                              class44.field538 = "";
                              class24.method172(true);
                              BaseVarType.method14("", "Connecting to server...", "");
                              class2.setGameState(20);
                              return;
                           }

                           if(var1 == 1 && var14 >= class91.loginWindowX + 180 - 9 && var14 <= class91.loginWindowX + 180 + 130 && var15 >= 263 && var15 <= 296) {
                              class91.field1355 = !class91.field1355;
                           }

                           if(var1 == 1 && var14 >= class91.loginWindowX + 180 - 34 && var14 <= class91.loginWindowX + 34 + 180 && var15 >= 351 && var15 <= 363) {
                              label886: {
                                 String var10 = GZipDecompressor.method3130("secure", true) + "m=totp-authenticator/disableTOTPRequest";
                                 if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                                    try {
                                       Desktop.getDesktop().browse(new URI(var10));
                                       break label886;
                                    } catch (Exception var12) {
                                       ;
                                    }
                                 }

                                 if(class56.field629.startsWith("win")) {
                                    World.method1561(var10, 0);
                                 } else if(class56.field629.startsWith("mac")) {
                                    ScriptState.method1000(var10, 1, "openjs");
                                 } else {
                                    World.method1561(var10, 2);
                                 }
                              }
                           }

                           var17 = class91.loginWindowX + 180 + 80;
                           if(var1 == 1 && var14 >= var17 - 75 && var14 <= var17 + 75 && var15 >= var19 - 20 && var15 <= var19 + 20) {
                              class91.loginIndex = 0;
                              class91.username = "";
                              class91.password = "";
                              class51.field609 = 0;
                              class44.field538 = "";
                           }

                           while(class251.method4307()) {
                              var20 = false;

                              for(var21 = 0; var21 < "1234567890".length(); ++var21) {
                                 if(class233.field3200 == "1234567890".charAt(var21)) {
                                    var20 = true;
                                    break;
                                 }
                              }

                              if(class96.field1426 == 13) {
                                 class91.loginIndex = 0;
                                 class91.username = "";
                                 class91.password = "";
                                 class51.field609 = 0;
                                 class44.field538 = "";
                              } else {
                                 if(class96.field1426 == 85 && class44.field538.length() > 0) {
                                    class44.field538 = class44.field538.substring(0, class44.field538.length() - 1);
                                 }

                                 if(class96.field1426 == 84) {
                                    class44.field538.trim();
                                    if(class44.field538.length() != 6) {
                                       BaseVarType.method14("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    class51.field609 = Integer.parseInt(class44.field538);
                                    class44.field538 = "";
                                    class24.method172(true);
                                    BaseVarType.method14("", "Connecting to server...", "");
                                    class2.setGameState(20);
                                    return;
                                 }

                                 if(var20 && class44.field538.length() < 6) {
                                    class44.field538 = class44.field538 + class233.field3200;
                                 }
                              }
                           }
                        } else if(class91.loginIndex == 5) {
                           var17 = class91.loginWindowX + 180 - 80;
                           var19 = 321;
                           if(var1 == 1 && var14 >= var17 - 75 && var14 <= var17 + 75 && var15 >= var19 - 20 && var15 <= var19 + 20) {
                              class21.method153();
                              return;
                           }

                           var17 = class91.loginWindowX + 180 + 80;
                           if(var1 == 1 && var14 >= var17 - 75 && var14 <= var17 + 75 && var15 >= var19 - 20 && var15 <= var19 + 20) {
                              class20.method147(true);
                           }

                           while(class251.method4307()) {
                              var20 = false;

                              for(var21 = 0; var21 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var21) {
                                 if(class233.field3200 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var21)) {
                                    var20 = true;
                                    break;
                                 }
                              }

                              if(class96.field1426 == 13) {
                                 class20.method147(true);
                              } else {
                                 if(class96.field1426 == 85 && class91.username.length() > 0) {
                                    class91.username = class91.username.substring(0, class91.username.length() - 1);
                                 }

                                 if(class96.field1426 == 84) {
                                    class21.method153();
                                    return;
                                 }

                                 if(var20 && class91.username.length() < 320) {
                                    class91.username = class91.username + class233.field3200;
                                 }
                              }
                           }
                        } else if(class91.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!class251.method4307()) {
                                    var18 = 321;
                                    if(var1 == 1 && var15 >= var18 - 20 && var15 <= var18 + 20) {
                                       class20.method147(true);
                                    }

                                    return;
                                 }
                              } while(class96.field1426 != 84 && class96.field1426 != 13);

                              class20.method147(true);
                           }
                        }
                     }
                  } else {
                     while(class251.method4307()) {
                        if(class96.field1426 == 84) {
                           class20.method147(false);
                        } else if(class96.field1426 == 13) {
                           class91.loginIndex = 0;
                        }
                     }

                     var17 = class256.field3426 - 80;
                     var19 = 321;
                     if(var1 == 1 && var14 >= var17 - 75 && var14 <= var17 + 75 && var15 >= var19 - 20 && var15 <= var19 + 20) {
                        class20.method147(false);
                     }

                     var17 = class256.field3426 + 80;
                     if(var1 == 1 && var14 >= var17 - 75 && var14 <= var17 + 75 && var15 >= var19 - 20 && var15 <= var19 + 20) {
                        class91.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }
}
