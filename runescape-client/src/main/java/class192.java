import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class192 {
   @ObfuscatedName("nr")
   @ObfuscatedGetter(
      intValue = -322232451
   )
   @Export("clanChatCount")
   static int clanChatCount;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lep;"
   )
   @Export("listFetcher")
   static UrlRequest listFetcher;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgr;ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "979957177"
   )
   static String method3599(IterableHashTable var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         ObjectNode var3 = (ObjectNode)var0.get((long)var1);
         return var3 == null?var2:(String)var3.value;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lbe;B)V",
      garbageValue = "3"
   )
   static void method3596(GameEngine var0) {
      if(class91.worldSelectShown) {
         class25.method179(var0);
      } else {
         int var2;
         int var3;
         if((MouseInput.mouseLastButton == 1 || !class34.field455 && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= class91.field1351 + 765 - 50 && MouseInput.mouseLastPressedY >= 453) {
            class2.preferences.muted = !class2.preferences.muted;
            WorldComparator.method63();
            if(!class2.preferences.muted) {
               IndexData var1 = class29.indexTrack1;
               var2 = var1.getFile("scape main");
               var3 = var1.getChild(var2, "");
               class2.method3(var1, var2, var3, 255, false);
            } else {
               class282.field3753.method3849();
               class214.field2620 = 1;
               class214.field2623 = null;
            }
         }

         if(Client.gameState != 5) {
            ++class91.field1330;
            if(Client.gameState == 10 || Client.gameState == 11) {
               int var9;
               if(Client.languageId == 0) {
                  if(MouseInput.mouseLastButton == 1 || !class34.field455 && MouseInput.mouseLastButton == 4) {
                     var9 = class91.field1351 + 5;
                     short var15 = 463;
                     byte var16 = 100;
                     byte var4 = 35;
                     if(MouseInput.mouseLastPressedX >= var9 && MouseInput.mouseLastPressedX <= var16 + var9 && MouseInput.mouseLastPressedY >= var15 && MouseInput.mouseLastPressedY <= var15 + var4) {
                        class44.method627();
                        return;
                     }
                  }

                  if(listFetcher != null) {
                     class44.method627();
                  }
               }

               var9 = MouseInput.mouseLastButton;
               var2 = MouseInput.mouseLastPressedX;
               var3 = MouseInput.mouseLastPressedY;
               if(var9 == 0) {
                  var2 = MouseInput.field679;
                  var3 = MouseInput.field682 * -469125321;
               }

               if(!class34.field455 && var9 == 4) {
                  var9 = 1;
               }

               int var5;
               short var6;
               if(class91.loginIndex == 0) {
                  boolean var17 = false;

                  while(class230.method4200()) {
                     if(FileRequest.field3304 == 84) {
                        var17 = true;
                     }
                  }

                  var5 = Preferences.field1217 - 80;
                  var6 = 291;
                  if(var9 == 1 && var2 >= var5 - 75 && var2 <= var5 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                     label876: {
                        String var10 = class22.method167("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws";
                        if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                           try {
                              Desktop.getDesktop().browse(new URI(var10));
                              break label876;
                           } catch (Exception var14) {
                              ;
                           }
                        }

                        if(class56.field621.startsWith("win")) {
                           class54.method766(var10, 0);
                        } else if(class56.field621.startsWith("mac")) {
                           class35.method492(var10, 1, "openjs");
                        } else {
                           class54.method766(var10, 2);
                        }
                     }
                  }

                  var5 = Preferences.field1217 + 80;
                  if(var9 == 1 && var2 >= var5 - 75 && var2 <= var5 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20 || var17) {
                     if((Client.flags & 33554432) != 0) {
                        class91.Login_response0 = "";
                        class91.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class91.loginMessage2 = "Your normal account will not be affected.";
                        class91.loginMessage3 = "";
                        class91.loginIndex = 1;
                        MouseInput.method959();
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

                        class91.Login_response0 = "Warning!";
                        class91.loginIndex = 1;
                        MouseInput.method959();
                     } else if((Client.flags & 1024) != 0) {
                        class91.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class91.loginMessage2 = "The Protect Item prayer will";
                        class91.loginMessage3 = "not work on this world.";
                        class91.Login_response0 = "Warning!";
                        class91.loginIndex = 1;
                        MouseInput.method959();
                     } else {
                        FloorUnderlayDefinition.method4509(false);
                     }
                  }
               } else {
                  int var18;
                  short var20;
                  if(class91.loginIndex != 1) {
                     short var19;
                     if(class91.loginIndex == 2) {
                        var19 = 201;
                        var18 = var19 + 52;
                        if(var9 == 1 && var3 >= var18 - 12 && var3 < var18 + 2) {
                           class91.field1345 = 0;
                        }

                        var18 += 15;
                        if(var9 == 1 && var3 >= var18 - 12 && var3 < var18 + 2) {
                           class91.field1345 = 1;
                        }

                        var18 += 15;
                        var19 = 361;
                        if(var9 == 1 && var3 >= var19 - 15 && var3 < var19) {
                           class64.method1033("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class91.loginIndex = 5;
                           return;
                        }

                        var5 = Preferences.field1217 - 80;
                        var6 = 321;
                        if(var9 == 1 && var2 >= var5 - 75 && var2 <= var5 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                           class91.username = class91.username.trim();
                           if(class91.username.length() == 0) {
                              class64.method1033("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class91.password.length() == 0) {
                              class64.method1033("", "Please enter your password.", "");
                              return;
                           }

                           class64.method1033("", "Connecting to server...", "");
                           class150.method2932(false);
                           Friend.setGameState(20);
                           return;
                        }

                        var5 = class91.loginWindowX + 180 + 80;
                        if(var9 == 1 && var2 >= var5 - 75 && var2 <= var5 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                           class91.loginIndex = 0;
                           class91.username = "";
                           class91.password = "";
                           BoundingBox.field240 = 0;
                           class237.field3245 = "";
                           class91.field1346 = true;
                        }

                        var5 = Preferences.field1217 + -117;
                        var6 = 277;
                        class91.field1331 = var2 >= var5 && var2 < var5 + MouseInput.field683 && var3 >= var6 && var3 < var6 + BoundingBox.field239;
                        if(var9 == 1 && class91.field1331) {
                           class91.Login_isUsernameRemembered = !class91.Login_isUsernameRemembered;
                           if(!class91.Login_isUsernameRemembered && class2.preferences.rememberedUsername != null) {
                              class2.preferences.rememberedUsername = null;
                              WorldComparator.method63();
                           }
                        }

                        var5 = Preferences.field1217 + 24;
                        var6 = 277;
                        class91.field1318 = var2 >= var5 && var2 < var5 + MouseInput.field683 && var3 >= var6 && var3 < var6 + BoundingBox.field239;
                        if(var9 == 1 && class91.field1318) {
                           class2.preferences.hideUsername = !class2.preferences.hideUsername;
                           if(!class2.preferences.hideUsername) {
                              class91.username = "";
                              class2.preferences.rememberedUsername = null;
                              MouseInput.method959();
                           }

                           WorldComparator.method63();
                        }

                        while(true) {
                           while(class230.method4200()) {
                              boolean var7 = false;

                              for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                                 if(RSSocket.field2186 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                    var7 = true;
                                    break;
                                 }
                              }

                              if(FileRequest.field3304 == 13) {
                                 class91.loginIndex = 0;
                                 class91.username = "";
                                 class91.password = "";
                                 BoundingBox.field240 = 0;
                                 class237.field3245 = "";
                                 class91.field1346 = true;
                              } else if(class91.field1345 == 0) {
                                 if(FileRequest.field3304 == 85 && class91.username.length() > 0) {
                                    class91.username = class91.username.substring(0, class91.username.length() - 1);
                                 }

                                 if(FileRequest.field3304 == 84 || FileRequest.field3304 == 80) {
                                    class91.field1345 = 1;
                                 }

                                 if(var7 && class91.username.length() < 320) {
                                    class91.username = class91.username + RSSocket.field2186;
                                 }
                              } else if(class91.field1345 == 1) {
                                 if(FileRequest.field3304 == 85 && class91.password.length() > 0) {
                                    class91.password = class91.password.substring(0, class91.password.length() - 1);
                                 }

                                 if(FileRequest.field3304 == 84 || FileRequest.field3304 == 80) {
                                    class91.field1345 = 0;
                                 }

                                 if(FileRequest.field3304 == 84) {
                                    class91.username = class91.username.trim();
                                    if(class91.username.length() == 0) {
                                       class64.method1033("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class91.password.length() == 0) {
                                       class64.method1033("", "Please enter your password.", "");
                                       return;
                                    }

                                    class64.method1033("", "Connecting to server...", "");
                                    class150.method2932(false);
                                    Friend.setGameState(20);
                                    return;
                                 }

                                 if(var7 && class91.password.length() < 20) {
                                    class91.password = class91.password + RSSocket.field2186;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class91.loginIndex == 3) {
                        var18 = class91.loginWindowX + 180;
                        var20 = 276;
                        if(var9 == 1 && var2 >= var18 - 75 && var2 <= var18 + 75 && var3 >= var20 - 20 && var3 <= var20 + 20) {
                           FloorUnderlayDefinition.method4509(false);
                        }

                        var18 = class91.loginWindowX + 180;
                        var20 = 326;
                        if(var9 == 1 && var2 >= var18 - 75 && var2 <= var18 + 75 && var3 >= var20 - 20 && var3 <= var20 + 20) {
                           class64.method1033("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class91.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var21;
                        int var22;
                        if(class91.loginIndex == 4) {
                           var18 = class91.loginWindowX + 180 - 80;
                           var20 = 321;
                           if(var9 == 1 && var2 >= var18 - 75 && var2 <= var18 + 75 && var3 >= var20 - 20 && var3 <= var20 + 20) {
                              class237.field3245.trim();
                              if(class237.field3245.length() != 6) {
                                 class64.method1033("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              BoundingBox.field240 = Integer.parseInt(class237.field3245);
                              class237.field3245 = "";
                              class150.method2932(true);
                              class64.method1033("", "Connecting to server...", "");
                              Friend.setGameState(20);
                              return;
                           }

                           if(var9 == 1 && var2 >= class91.loginWindowX + 180 - 9 && var2 <= class91.loginWindowX + 180 + 130 && var3 >= 263 && var3 <= 296) {
                              class91.field1346 = !class91.field1346;
                           }

                           if(var9 == 1 && var2 >= class91.loginWindowX + 180 - 34 && var2 <= class91.loginWindowX + 34 + 180 && var3 >= 351 && var3 <= 363) {
                              label889: {
                                 String var11 = class22.method167("secure", true) + "m=totp-authenticator/disableTOTPRequest";
                                 if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                                    try {
                                       Desktop.getDesktop().browse(new URI(var11));
                                       break label889;
                                    } catch (Exception var13) {
                                       ;
                                    }
                                 }

                                 if(class56.field621.startsWith("win")) {
                                    class54.method766(var11, 0);
                                 } else if(class56.field621.startsWith("mac")) {
                                    class35.method492(var11, 1, "openjs");
                                 } else {
                                    class54.method766(var11, 2);
                                 }
                              }
                           }

                           var18 = class91.loginWindowX + 180 + 80;
                           if(var9 == 1 && var2 >= var18 - 75 && var2 <= var18 + 75 && var3 >= var20 - 20 && var3 <= var20 + 20) {
                              class91.loginIndex = 0;
                              class91.username = "";
                              class91.password = "";
                              BoundingBox.field240 = 0;
                              class237.field3245 = "";
                           }

                           while(class230.method4200()) {
                              var21 = false;

                              for(var22 = 0; var22 < "1234567890".length(); ++var22) {
                                 if(RSSocket.field2186 == "1234567890".charAt(var22)) {
                                    var21 = true;
                                    break;
                                 }
                              }

                              if(FileRequest.field3304 == 13) {
                                 class91.loginIndex = 0;
                                 class91.username = "";
                                 class91.password = "";
                                 BoundingBox.field240 = 0;
                                 class237.field3245 = "";
                              } else {
                                 if(FileRequest.field3304 == 85 && class237.field3245.length() > 0) {
                                    class237.field3245 = class237.field3245.substring(0, class237.field3245.length() - 1);
                                 }

                                 if(FileRequest.field3304 == 84) {
                                    class237.field3245.trim();
                                    if(class237.field3245.length() != 6) {
                                       class64.method1033("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    BoundingBox.field240 = Integer.parseInt(class237.field3245);
                                    class237.field3245 = "";
                                    class150.method2932(true);
                                    class64.method1033("", "Connecting to server...", "");
                                    Friend.setGameState(20);
                                    return;
                                 }

                                 if(var21 && class237.field3245.length() < 6) {
                                    class237.field3245 = class237.field3245 + RSSocket.field2186;
                                 }
                              }
                           }
                        } else if(class91.loginIndex == 5) {
                           var18 = class91.loginWindowX + 180 - 80;
                           var20 = 321;
                           if(var9 == 1 && var2 >= var18 - 75 && var2 <= var18 + 75 && var3 >= var20 - 20 && var3 <= var20 + 20) {
                              class5.method13();
                              return;
                           }

                           var18 = class91.loginWindowX + 180 + 80;
                           if(var9 == 1 && var2 >= var18 - 75 && var2 <= var18 + 75 && var3 >= var20 - 20 && var3 <= var20 + 20) {
                              FloorUnderlayDefinition.method4509(true);
                           }

                           while(class230.method4200()) {
                              var21 = false;

                              for(var22 = 0; var22 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var22) {
                                 if(RSSocket.field2186 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var22)) {
                                    var21 = true;
                                    break;
                                 }
                              }

                              if(FileRequest.field3304 == 13) {
                                 FloorUnderlayDefinition.method4509(true);
                              } else {
                                 if(FileRequest.field3304 == 85 && class91.username.length() > 0) {
                                    class91.username = class91.username.substring(0, class91.username.length() - 1);
                                 }

                                 if(FileRequest.field3304 == 84) {
                                    class5.method13();
                                    return;
                                 }

                                 if(var21 && class91.username.length() < 320) {
                                    class91.username = class91.username + RSSocket.field2186;
                                 }
                              }
                           }
                        } else if(class91.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!class230.method4200()) {
                                    var19 = 321;
                                    if(var9 == 1 && var3 >= var19 - 20 && var3 <= var19 + 20) {
                                       FloorUnderlayDefinition.method4509(true);
                                    }

                                    return;
                                 }
                              } while(FileRequest.field3304 != 84 && FileRequest.field3304 != 13);

                              FloorUnderlayDefinition.method4509(true);
                           }
                        }
                     }
                  } else {
                     while(class230.method4200()) {
                        if(FileRequest.field3304 == 84) {
                           FloorUnderlayDefinition.method4509(false);
                        } else if(FileRequest.field3304 == 13) {
                           class91.loginIndex = 0;
                        }
                     }

                     var18 = Preferences.field1217 - 80;
                     var20 = 321;
                     if(var9 == 1 && var2 >= var18 - 75 && var2 <= var18 + 75 && var3 >= var20 - 20 && var3 <= var20 + 20) {
                        FloorUnderlayDefinition.method4509(false);
                     }

                     var18 = Preferences.field1217 + 80;
                     if(var9 == 1 && var2 >= var18 - 75 && var2 <= var18 + 75 && var3 >= var20 - 20 && var3 <= var20 + 20) {
                        class91.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }
}
