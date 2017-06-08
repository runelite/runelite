import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
final class class2 implements class0 {
   @ObfuscatedName("q")
   static String field14;
   @ObfuscatedName("ou")
   @Export("clanMembers")
   static XClanMember[] clanMembers;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1213022357
   )
   public static int field17;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = 288097581
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("pb")
   @ObfuscatedGetter(
      intValue = 436460057
   )
   static int field19;
   @ObfuscatedName("i")
   public static IndexDataBase field20;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -514844899
   )
   protected static int field21;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2031243995
   )
   static int field22;

   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "606906814"
   )
   static void method5(int var0) {
      if(var0 == -3) {
         class15.method115("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class15.method115("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class15.method115("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class92.loginIndex = 3;
      } else if(var0 == 4) {
         class15.method115("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class15.method115("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         class15.method115("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class15.method115("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class15.method115("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class15.method115("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class15.method115("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class15.method115("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class15.method115("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class15.method115("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class15.method115("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class15.method115("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class15.method115("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class15.method115("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class15.method115("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class15.method115("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class15.method115("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class15.method115("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class15.method115("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class15.method115("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class15.method115("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class15.method115("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class15.method115("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class15.method115("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class15.method115("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class15.method115("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class15.method115("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class15.method115("Enter the 6-digit code generated by your", "authenticator app.", "");
            class3.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class15.method115("The code you entered was incorrect.", "Please try again.", "");
            class3.setGameState(11);
            return;
         }

         class15.method115("Unexpected server response", "Please try using a different world.", "");
      }

      class3.setGameState(10);
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIII)V",
      garbageValue = "1315883125"
   )
   static final void method6(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2732 || class251.method4472(var9) != 0 || var9 == Client.field973 || var9.contentType == 1338) && var1 == var9.parentId && (!var9.hasScript || !Ignore.method1079(var9))) {
            int var10 = var6 + var9.relativeX;
            int var11 = var7 + var9.relativeY;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var19;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               int var18 = var10 + var9.width;
               var19 = var9.height + var11;
               if(var18 < var10) {
                  var16 = var18;
                  var18 = var10;
               }

               if(var19 < var11) {
                  var17 = var19;
                  var19 = var11;
               }

               ++var18;
               ++var19;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var18 < var4?var18:var4;
               var15 = var19 < var5?var19:var5;
            } else {
               var16 = var10 + var9.width;
               var17 = var9.height + var11;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(var9 == Client.field1089) {
               Client.field1097 = true;
               Client.field1098 = var10;
               Client.field1099 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = class59.field729;
               var17 = class59.field715;
               if(class59.field713 != 0) {
                  var16 = class59.field723;
                  var17 = class59.field724;
               }

               boolean var45 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               int var20;
               int var22;
               int var23;
               int var24;
               int var25;
               int var35;
               int var38;
               int var39;
               int var54;
               byte var58;
               int var59;
               if(var9.contentType == 1337) {
                  if(!Client.field921 && !Client.isMenuOpen && var45) {
                     if(Client.field1068 == 0 && !Client.field1071) {
                        Enum.addMenuEntry("Walk here", "", 23, 0, var16 - var12, var17 - var13);
                     }

                     var19 = -1;
                     var20 = -1;

                     for(var35 = 0; var35 < class134.field2009; ++var35) {
                        var22 = class134.field2002[var35];
                        var23 = var22 & 127;
                        var24 = var22 >> 7 & 127;
                        var25 = var22 >> 29 & 3;
                        int var26 = var22 >> 14 & 32767;
                        if(var22 != var20) {
                           var20 = var22;
                           if(var25 == 2 && class61.region.method2770(class92.plane, var23, var24, var22) >= 0) {
                              ObjectComposition var50 = class61.getObjectDefinition(var26);
                              if(var50.impostorIds != null) {
                                 var50 = var50.getImpostor();
                              }

                              if(var50 == null) {
                                 continue;
                              }

                              if(Client.field1068 == 1) {
                                 Enum.addMenuEntry("Use", Client.field988 + " " + "->" + " " + class60.method996('\uffff') + var50.name, 1, var22, var23, var24);
                              } else if(Client.field1071) {
                                 if((class221.field2836 & 4) == 4) {
                                    Enum.addMenuEntry(Client.field1074, Client.field1075 + " " + "->" + " " + class60.method996('\uffff') + var50.name, 2, var22, var23, var24);
                                 }
                              } else {
                                 String[] var28 = var50.actions;
                                 if(Client.field1087) {
                                    var28 = class10.method69(var28);
                                 }

                                 if(var28 != null) {
                                    for(var38 = 4; var38 >= 0; --var38) {
                                       if(var28[var38] != null) {
                                          short var56 = 0;
                                          if(var38 == 0) {
                                             var56 = 3;
                                          }

                                          if(var38 == 1) {
                                             var56 = 4;
                                          }

                                          if(var38 == 2) {
                                             var56 = 5;
                                          }

                                          if(var38 == 3) {
                                             var56 = 6;
                                          }

                                          if(var38 == 4) {
                                             var56 = 1001;
                                          }

                                          Enum.addMenuEntry(var28[var38], class60.method996('\uffff') + var50.name, var56, var22, var23, var24);
                                       }
                                    }
                                 }

                                 Enum.addMenuEntry("Examine", class60.method996('\uffff') + var50.name, 1002, var50.field3449 << 14, var23, var24);
                              }
                           }

                           NPC var29;
                           Player var31;
                           int[] var51;
                           if(var25 == 1) {
                              NPC var52 = Client.cachedNPCs[var26];
                              if(var52 == null) {
                                 continue;
                              }

                              if(var52.composition.field3577 == 1 && (var52.x & 127) == 64 && (var52.y & 127) == 64) {
                                 for(var39 = 0; var39 < Client.field952; ++var39) {
                                    var29 = Client.cachedNPCs[Client.field953[var39]];
                                    if(var29 != null && var52 != var29 && var29.composition.field3577 == 1 && var52.x == var29.x && var29.y == var52.y) {
                                       WorldMapType1.method263(var29.composition, Client.field953[var39], var23, var24);
                                    }
                                 }

                                 var39 = class96.field1499;
                                 var51 = class96.field1501;

                                 for(var54 = 0; var54 < var39; ++var54) {
                                    var31 = Client.cachedPlayers[var51[var54]];
                                    if(var31 != null && var52.x == var31.x && var52.y == var31.y) {
                                       class210.method3942(var31, var51[var54], var23, var24);
                                    }
                                 }
                              }

                              WorldMapType1.method263(var52.composition, var26, var23, var24);
                           }

                           if(var25 == 0) {
                              Player var55 = Client.cachedPlayers[var26];
                              if(var55 == null) {
                                 continue;
                              }

                              if((var55.x & 127) == 64 && (var55.y & 127) == 64) {
                                 for(var39 = 0; var39 < Client.field952; ++var39) {
                                    var29 = Client.cachedNPCs[Client.field953[var39]];
                                    if(var29 != null && var29.composition.field3577 == 1 && var55.x == var29.x && var55.y == var29.y) {
                                       WorldMapType1.method263(var29.composition, Client.field953[var39], var23, var24);
                                    }
                                 }

                                 var39 = class96.field1499;
                                 var51 = class96.field1501;

                                 for(var54 = 0; var54 < var39; ++var54) {
                                    var31 = Client.cachedPlayers[var51[var54]];
                                    if(var31 != null && var55 != var31 && var31.x == var55.x && var55.y == var31.y) {
                                       class210.method3942(var31, var51[var54], var23, var24);
                                    }
                                 }
                              }

                              if(var26 != Client.field1044) {
                                 class210.method3942(var55, var26, var23, var24);
                              } else {
                                 var19 = var22;
                              }
                           }

                           if(var25 == 3) {
                              Deque var57 = Client.groundItemDeque[class92.plane][var23][var24];
                              if(var57 != null) {
                                 for(Item var49 = (Item)var57.method3629(); var49 != null; var49 = (Item)var57.method3609()) {
                                    ItemComposition var53 = ItemComposition.getItemDefinition(var49.id);
                                    if(Client.field1068 == 1) {
                                       Enum.addMenuEntry("Use", Client.field988 + " " + "->" + " " + class60.method996(16748608) + var53.name, 16, var49.id, var23, var24);
                                    } else if(Client.field1071) {
                                       if((class221.field2836 & 1) == 1) {
                                          Enum.addMenuEntry(Client.field1074, Client.field1075 + " " + "->" + " " + class60.method996(16748608) + var53.name, 17, var49.id, var23, var24);
                                       }
                                    } else {
                                       String[] var37 = var53.groundActions;
                                       if(Client.field1087) {
                                          var37 = class10.method69(var37);
                                       }

                                       for(var59 = 4; var59 >= 0; --var59) {
                                          if(var37 != null && var37[var59] != null) {
                                             var58 = 0;
                                             if(var59 == 0) {
                                                var58 = 18;
                                             }

                                             if(var59 == 1) {
                                                var58 = 19;
                                             }

                                             if(var59 == 2) {
                                                var58 = 20;
                                             }

                                             if(var59 == 3) {
                                                var58 = 21;
                                             }

                                             if(var59 == 4) {
                                                var58 = 22;
                                             }

                                             Enum.addMenuEntry(var37[var59], class60.method996(16748608) + var53.name, var58, var49.id, var23, var24);
                                          } else if(var59 == 2) {
                                             Enum.addMenuEntry("Take", class60.method996(16748608) + var53.name, 20, var49.id, var23, var24);
                                          }
                                       }

                                       Enum.addMenuEntry("Examine", class60.method996(16748608) + var53.name, 1004, var49.id, var23, var24);
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if(var19 != -1) {
                        var35 = var19 & 127;
                        var22 = var19 >> 7 & 127;
                        Player var43 = Client.cachedPlayers[Client.field1044];
                        class210.method3942(var43, Client.field1044, var35, var22);
                     }
                  }
               } else if(var9.contentType == 1338) {
                  class211.method3949(var9, var10, var11);
               } else {
                  if(var9.contentType == 1400) {
                     FaceNormal.field2146.method5372(class59.field729, class59.field715, var45, var10, var11, var9.width, var9.height);
                  }

                  boolean var60;
                  if(!Client.isMenuOpen && var45) {
                     if(var9.contentType == 1400) {
                        FaceNormal.field2146.method5298(var10, var11, var9.width, var9.height, var16, var17);
                     } else {
                        var19 = var16 - var10;
                        var20 = var17 - var11;
                        if(var9.field2655 == 1) {
                           Enum.addMenuEntry(var9.tooltip, "", 24, 0, 0, var9.id);
                        }

                        String var21;
                        if(var9.field2655 == 2 && !Client.field1071) {
                           if(GameEngine.method844(class251.method4472(var9)) == 0) {
                              var21 = null;
                           } else if(var9.field2780 != null && var9.field2780.trim().length() != 0) {
                              var21 = var9.field2780;
                           } else {
                              var21 = null;
                           }

                           if(var21 != null) {
                              Enum.addMenuEntry(var21, class60.method996('\uff00') + var9.field2727, 25, 0, -1, var9.id);
                           }
                        }

                        if(var9.field2655 == 3) {
                           Enum.addMenuEntry("Close", "", 26, 0, 0, var9.id);
                        }

                        if(var9.field2655 == 4) {
                           Enum.addMenuEntry(var9.tooltip, "", 28, 0, 0, var9.id);
                        }

                        if(var9.field2655 == 5) {
                           Enum.addMenuEntry(var9.tooltip, "", 29, 0, 0, var9.id);
                        }

                        if(var9.field2655 == 6 && Client.field1147 == null) {
                           Enum.addMenuEntry(var9.tooltip, "", 30, 0, -1, var9.id);
                        }

                        if(var9.type == 2) {
                           var35 = 0;

                           for(var22 = 0; var22 < var9.height; ++var22) {
                              for(var23 = 0; var23 < var9.width; ++var23) {
                                 var24 = var23 * (var9.paddingX + 32);
                                 var25 = var22 * (var9.paddingY + 32);
                                 if(var35 < 20) {
                                    var24 += var9.field2656[var35];
                                    var25 += var9.field2721[var35];
                                 }

                                 if(var19 >= var24 && var20 >= var25 && var19 < var24 + 32 && var20 < var25 + 32) {
                                    Client.field1031 = var35;
                                    class76.field1204 = var9;
                                    if(var9.itemIds[var35] > 0) {
                                       ItemComposition var40 = ItemComposition.getItemDefinition(var9.itemIds[var35] - 1);
                                       if(Client.field1068 == 1 && XClanMember.method1126(class251.method4472(var9))) {
                                          if(Frames.field2152 != var9.id || Client.field1090 != var35) {
                                             Enum.addMenuEntry("Use", Client.field988 + " " + "->" + " " + class60.method996(16748608) + var40.name, 31, var40.id, var35, var9.id);
                                          }
                                       } else if(Client.field1071 && XClanMember.method1126(class251.method4472(var9))) {
                                          if((class221.field2836 & 16) == 16) {
                                             Enum.addMenuEntry(Client.field1074, Client.field1075 + " " + "->" + " " + class60.method996(16748608) + var40.name, 32, var40.id, var35, var9.id);
                                          }
                                       } else {
                                          String[] var27 = var40.inventoryActions;
                                          if(Client.field1087) {
                                             var27 = class10.method69(var27);
                                          }

                                          var39 = var40.method4607();
                                          if(XClanMember.method1126(class251.method4472(var9))) {
                                             for(var38 = 4; var38 >= 3; --var38) {
                                                boolean var30 = var39 == var38;
                                                if(var27 != null && var27[var38] != null) {
                                                   byte var34;
                                                   if(var38 == 3) {
                                                      var34 = 36;
                                                   } else {
                                                      var34 = 37;
                                                   }

                                                   class44.method615(var27[var38], class60.method996(16748608) + var40.name, var34, var40.id, var35, var9.id, var30);
                                                } else if(var38 == 4) {
                                                   class44.method615("Drop", class60.method996(16748608) + var40.name, 37, var40.id, var35, var9.id, var30);
                                                }
                                             }
                                          }

                                          var54 = class251.method4472(var9);
                                          boolean var62 = (var54 >> 31 & 1) != 0;
                                          if(var62) {
                                             Enum.addMenuEntry("Use", class60.method996(16748608) + var40.name, 38, var40.id, var35, var9.id);
                                          }

                                          Object var10000 = null;
                                          if(XClanMember.method1126(class251.method4472(var9)) && var27 != null) {
                                             for(var59 = 2; var59 >= 0; --var59) {
                                                boolean var32 = var59 == var39;
                                                if(var27[var59] != null) {
                                                   byte var33 = 0;
                                                   if(var59 == 0) {
                                                      var33 = 33;
                                                   }

                                                   if(var59 == 1) {
                                                      var33 = 34;
                                                   }

                                                   if(var59 == 2) {
                                                      var33 = 35;
                                                   }

                                                   class44.method615(var27[var59], class60.method996(16748608) + var40.name, var33, var40.id, var35, var9.id, var32);
                                                }
                                             }
                                          }

                                          var27 = var9.field2723;
                                          if(Client.field1087) {
                                             var27 = class10.method69(var27);
                                          }

                                          if(var27 != null) {
                                             for(var59 = 4; var59 >= 0; --var59) {
                                                if(var27[var59] != null) {
                                                   var58 = 0;
                                                   if(var59 == 0) {
                                                      var58 = 39;
                                                   }

                                                   if(var59 == 1) {
                                                      var58 = 40;
                                                   }

                                                   if(var59 == 2) {
                                                      var58 = 41;
                                                   }

                                                   if(var59 == 3) {
                                                      var58 = 42;
                                                   }

                                                   if(var59 == 4) {
                                                      var58 = 43;
                                                   }

                                                   Enum.addMenuEntry(var27[var59], class60.method996(16748608) + var40.name, var58, var40.id, var35, var9.id);
                                                }
                                             }
                                          }

                                          Enum.addMenuEntry("Examine", class60.method996(16748608) + var40.name, 1005, var40.id, var35, var9.id);
                                       }
                                    }
                                 }

                                 ++var35;
                              }
                           }
                        }

                        if(var9.hasScript) {
                           if(Client.field1071) {
                              var22 = class251.method4472(var9);
                              var60 = (var22 >> 21 & 1) != 0;
                              if(var60 && (class221.field2836 & 32) == 32) {
                                 Enum.addMenuEntry(Client.field1074, Client.field1075 + " " + "->" + " " + var9.name, 58, 0, var9.index, var9.id);
                              }
                           } else {
                              for(var35 = 9; var35 >= 5; --var35) {
                                 String var42 = NPC.method1672(var9, var35);
                                 if(var42 != null) {
                                    Enum.addMenuEntry(var42, var9.name, 1007, var35 + 1, var9.index, var9.id);
                                 }
                              }

                              if(GameEngine.method844(class251.method4472(var9)) == 0) {
                                 var21 = null;
                              } else if(var9.field2780 != null && var9.field2780.trim().length() != 0) {
                                 var21 = var9.field2780;
                              } else {
                                 var21 = null;
                              }

                              if(var21 != null) {
                                 Enum.addMenuEntry(var21, var9.name, 25, 0, var9.index, var9.id);
                              }

                              for(var23 = 4; var23 >= 0; --var23) {
                                 String var41 = NPC.method1672(var9, var23);
                                 if(var41 != null) {
                                    Enum.addMenuEntry(var41, var9.name, 57, var23 + 1, var9.index, var9.id);
                                 }
                              }

                              if(class22.method188(class251.method4472(var9))) {
                                 Enum.addMenuEntry("Continue", "", 30, 0, var9.index, var9.id);
                              }
                           }
                        }
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.hasScript && Ignore.method1079(var9) && class83.field1354 != var9) {
                        continue;
                     }

                     method6(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method6(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var36 = (WidgetNode)Client.componentTable.method3545((long)var9.id);
                     if(var36 != null) {
                        if(var36.field816 == 0 && class59.field729 >= var12 && class59.field715 >= var13 && class59.field729 < var14 && class59.field715 < var15 && !Client.isMenuOpen && !Client.field1086) {
                           for(class69 var44 = (class69)Client.field1115.method3622(); var44 != null; var44 = (class69)Client.field1115.method3608()) {
                              if(var44.field823) {
                                 var44.unlink();
                                 var44.field824.field2674 = false;
                              }
                           }

                           if(class31.field452 == 0) {
                              Client.field1089 = null;
                              Client.field973 = null;
                           }

                           if(!Client.isMenuOpen) {
                              class89.method1695();
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuOptionCount = 1;
                           }
                        }

                        class227.method4102(var36.id, var12, var13, var14, var15, var10, var11);
                     }
                  }

                  if(var9.hasScript) {
                     class69 var61;
                     if(!var9.field2678) {
                        if(var9.field2786 && class59.field729 >= var12 && class59.field715 >= var13 && class59.field729 < var14 && class59.field715 < var15) {
                           for(var61 = (class69)Client.field1115.method3622(); var61 != null; var61 = (class69)Client.field1115.method3608()) {
                              if(var61.field823 && var61.field833 == var61.field824.field2753) {
                                 var61.unlink();
                              }
                           }
                        }
                     } else if(class59.field729 >= var12 && class59.field715 >= var13 && class59.field729 < var14 && class59.field715 < var15) {
                        for(var61 = (class69)Client.field1115.method3622(); var61 != null; var61 = (class69)Client.field1115.method3608()) {
                           if(var61.field823) {
                              var61.unlink();
                              var61.field824.field2674 = false;
                           }
                        }

                        if(class31.field452 == 0) {
                           Client.field1089 = null;
                           Client.field973 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.menuOptionCount = 1;
                        }
                     }

                     if(class59.field729 >= var12 && class59.field715 >= var13 && class59.field729 < var14 && class59.field715 < var15) {
                        var45 = true;
                     } else {
                        var45 = false;
                     }

                     boolean var47 = false;
                     if((class59.field716 == 1 || !ItemLayer.field1798 && class59.field716 == 4) && var45) {
                        var47 = true;
                     }

                     boolean var46 = false;
                     if((class59.field713 == 1 || !ItemLayer.field1798 && class59.field713 == 4) && class59.field723 >= var12 && class59.field724 >= var13 && class59.field723 < var14 && class59.field724 < var15) {
                        var46 = true;
                     }

                     if(var46) {
                        class51.method750(var9, class59.field723 - var10, class59.field724 - var11);
                     }

                     if(var9.contentType == 1400) {
                        FaceNormal.field2146.method5256(class59.field729, class59.field715, var45 & var47);
                     }

                     if(Client.field1089 != null && var9 != Client.field1089 && var45) {
                        var22 = class251.method4472(var9);
                        var60 = (var22 >> 20 & 1) != 0;
                        if(var60) {
                           Client.field1093 = var9;
                        }
                     }

                     if(var9 == Client.field973) {
                        Client.field927 = true;
                        Client.field1095 = var10;
                        Client.field1096 = var11;
                     }

                     if(var9.field2732) {
                        class69 var48;
                        if(var45 && Client.field940 != 0 && var9.field2753 != null) {
                           var48 = new class69();
                           var48.field823 = true;
                           var48.field824 = var9;
                           var48.field826 = Client.field940;
                           var48.field833 = var9.field2753;
                           Client.field1115.method3634(var48);
                        }

                        if(Client.field1089 != null || class98.field1529 != null || Client.isMenuOpen) {
                           var46 = false;
                           var47 = false;
                           var45 = false;
                        }

                        if(!var9.field2778 && var46) {
                           var9.field2778 = true;
                           if(var9.field2734 != null) {
                              var48 = new class69();
                              var48.field823 = true;
                              var48.field824 = var9;
                              var48.field822 = class59.field723 - var10;
                              var48.field826 = class59.field724 - var11;
                              var48.field833 = var9.field2734;
                              Client.field1115.method3634(var48);
                           }
                        }

                        if(var9.field2778 && var47 && var9.field2735 != null) {
                           var48 = new class69();
                           var48.field823 = true;
                           var48.field824 = var9;
                           var48.field822 = class59.field729 - var10;
                           var48.field826 = class59.field715 - var11;
                           var48.field833 = var9.field2735;
                           Client.field1115.method3634(var48);
                        }

                        if(var9.field2778 && !var47) {
                           var9.field2778 = false;
                           if(var9.field2707 != null) {
                              var48 = new class69();
                              var48.field823 = true;
                              var48.field824 = var9;
                              var48.field822 = class59.field729 - var10;
                              var48.field826 = class59.field715 - var11;
                              var48.field833 = var9.field2707;
                              Client.field1117.method3634(var48);
                           }
                        }

                        if(var47 && var9.field2737 != null) {
                           var48 = new class69();
                           var48.field823 = true;
                           var48.field824 = var9;
                           var48.field822 = class59.field729 - var10;
                           var48.field826 = class59.field715 - var11;
                           var48.field833 = var9.field2737;
                           Client.field1115.method3634(var48);
                        }

                        if(!var9.field2674 && var45) {
                           var9.field2674 = true;
                           if(var9.field2738 != null) {
                              var48 = new class69();
                              var48.field823 = true;
                              var48.field824 = var9;
                              var48.field822 = class59.field729 - var10;
                              var48.field826 = class59.field715 - var11;
                              var48.field833 = var9.field2738;
                              Client.field1115.method3634(var48);
                           }
                        }

                        if(var9.field2674 && var45 && var9.field2739 != null) {
                           var48 = new class69();
                           var48.field823 = true;
                           var48.field824 = var9;
                           var48.field822 = class59.field729 - var10;
                           var48.field826 = class59.field715 - var11;
                           var48.field833 = var9.field2739;
                           Client.field1115.method3634(var48);
                        }

                        if(var9.field2674 && !var45) {
                           var9.field2674 = false;
                           if(var9.field2755 != null) {
                              var48 = new class69();
                              var48.field823 = true;
                              var48.field824 = var9;
                              var48.field822 = class59.field729 - var10;
                              var48.field826 = class59.field715 - var11;
                              var48.field833 = var9.field2755;
                              Client.field1117.method3634(var48);
                           }
                        }

                        if(var9.field2751 != null) {
                           var48 = new class69();
                           var48.field824 = var9;
                           var48.field833 = var9.field2751;
                           Client.field1116.method3634(var48);
                        }

                        class69 var63;
                        if(var9.field2682 != null && Client.field1103 > var9.field2770) {
                           if(var9.field2731 != null && Client.field1103 - var9.field2770 <= 32) {
                              label1360:
                              for(var35 = var9.field2770; var35 < Client.field1103; ++var35) {
                                 var22 = Client.field1102[var35 & 31];

                                 for(var23 = 0; var23 < var9.field2731.length; ++var23) {
                                    if(var22 == var9.field2731[var23]) {
                                       var63 = new class69();
                                       var63.field824 = var9;
                                       var63.field833 = var9.field2682;
                                       Client.field1115.method3634(var63);
                                       break label1360;
                                    }
                                 }
                              }
                           } else {
                              var48 = new class69();
                              var48.field824 = var9;
                              var48.field833 = var9.field2682;
                              Client.field1115.method3634(var48);
                           }

                           var9.field2770 = Client.field1103;
                        }

                        if(var9.field2747 != null && Client.field924 > var9.field2781) {
                           if(var9.field2748 != null && Client.field924 - var9.field2781 <= 32) {
                              label1336:
                              for(var35 = var9.field2781; var35 < Client.field924; ++var35) {
                                 var22 = Client.interfaceItemTriggers[var35 & 31];

                                 for(var23 = 0; var23 < var9.field2748.length; ++var23) {
                                    if(var9.field2748[var23] == var22) {
                                       var63 = new class69();
                                       var63.field824 = var9;
                                       var63.field833 = var9.field2747;
                                       Client.field1115.method3634(var63);
                                       break label1336;
                                    }
                                 }
                              }
                           } else {
                              var48 = new class69();
                              var48.field824 = var9;
                              var48.field833 = var9.field2747;
                              Client.field1115.method3634(var48);
                           }

                           var9.field2781 = Client.field924;
                        }

                        if(var9.field2740 != null && Client.field1120 > var9.field2773) {
                           if(var9.field2750 != null && Client.field1120 - var9.field2773 <= 32) {
                              label1312:
                              for(var35 = var9.field2773; var35 < Client.field1120; ++var35) {
                                 var22 = Client.field1106[var35 & 31];

                                 for(var23 = 0; var23 < var9.field2750.length; ++var23) {
                                    if(var22 == var9.field2750[var23]) {
                                       var63 = new class69();
                                       var63.field824 = var9;
                                       var63.field833 = var9.field2740;
                                       Client.field1115.method3634(var63);
                                       break label1312;
                                    }
                                 }
                              }
                           } else {
                              var48 = new class69();
                              var48.field824 = var9;
                              var48.field833 = var9.field2740;
                              Client.field1115.method3634(var48);
                           }

                           var9.field2773 = Client.field1120;
                        }

                        if(Client.field932 > var9.field2779 && var9.field2754 != null) {
                           var48 = new class69();
                           var48.field824 = var9;
                           var48.field833 = var9.field2754;
                           Client.field1115.method3634(var48);
                        }

                        if(Client.field1109 > var9.field2779 && var9.field2756 != null) {
                           var48 = new class69();
                           var48.field824 = var9;
                           var48.field833 = var9.field2756;
                           Client.field1115.method3634(var48);
                        }

                        if(Client.field1013 > var9.field2779 && var9.field2757 != null) {
                           var48 = new class69();
                           var48.field824 = var9;
                           var48.field833 = var9.field2757;
                           Client.field1115.method3634(var48);
                        }

                        if(Client.field1111 > var9.field2779 && var9.field2762 != null) {
                           var48 = new class69();
                           var48.field824 = var9;
                           var48.field833 = var9.field2762;
                           Client.field1115.method3634(var48);
                        }

                        if(Client.field1112 > var9.field2779 && var9.field2763 != null) {
                           var48 = new class69();
                           var48.field824 = var9;
                           var48.field833 = var9.field2763;
                           Client.field1115.method3634(var48);
                        }

                        if(Client.field1113 > var9.field2779 && var9.field2758 != null) {
                           var48 = new class69();
                           var48.field824 = var9;
                           var48.field833 = var9.field2758;
                           Client.field1115.method3634(var48);
                        }

                        var9.field2779 = Client.field1110;
                        if(var9.field2649 != null) {
                           for(var35 = 0; var35 < Client.field1137; ++var35) {
                              class69 var64 = new class69();
                              var64.field824 = var9;
                              var64.field829 = Client.field1139[var35];
                              var64.field830 = Client.field1138[var35];
                              var64.field833 = var9.field2649;
                              Client.field1115.method3634(var64);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && Client.field1089 == null && class98.field1529 == null && !Client.isMenuOpen) {
                     if((var9.field2657 >= 0 || var9.field2764 != 0) && class59.field729 >= var12 && class59.field715 >= var13 && class59.field729 < var14 && class59.field715 < var15) {
                        if(var9.field2657 >= 0) {
                           class83.field1354 = var0[var9.field2657];
                        } else {
                           class83.field1354 = var9;
                        }
                     }

                     if(var9.type == 8 && class59.field729 >= var12 && class59.field715 >= var13 && class59.field729 < var14 && class59.field715 < var15) {
                        Preferences.field1319 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        class37.method496(var9, var10 + var9.width, var11, var9.height, var9.scrollHeight, class59.field729, class59.field715);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(LActor;IIIIIB)V",
      garbageValue = "0"
   )
   static final void method7(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(var0 != null && var0.vmethod1669()) {
         if(var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).composition;
            if(var6.configs != null) {
               var6 = var6.method4685();
            }

            if(var6 == null) {
               return;
            }
         }

         int var74 = class96.field1499;
         int[] var7 = class96.field1501;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.combatInfoList.method3568()) {
            FileOnDisk.method2384(var0, var0.field1276 + 15);

            for(CombatInfoListHolder var9 = (CombatInfoListHolder)var0.combatInfoList.method3571(); var9 != null; var9 = (CombatInfoListHolder)var0.combatInfoList.method3573()) {
               CombatInfo1 var10 = var9.method1660(Client.gameCycle);
               if(var10 == null) {
                  if(var9.method1661()) {
                     var9.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var9.combatInfo2;
                  SpritePixels var12 = var11.method4416();
                  SpritePixels var13 = var11.method4422();
                  int var15 = 0;
                  if(var12 != null && var13 != null) {
                     if(var11.field3376 * 2 < var13.width) {
                        var15 = var11.field3376;
                     }

                     var14 = var13.width - var15 * 2;
                  } else {
                     var14 = var11.healthScale;
                  }

                  int var16 = 255;
                  boolean var76 = true;
                  int var18 = Client.gameCycle - var10.field1293;
                  int var19 = var14 * var10.health / var11.healthScale;
                  int var75;
                  int var89;
                  if(var10.field1291 > var18) {
                     var75 = var11.field3372 == 0?0:var11.field3372 * (var18 / var11.field3372);
                     var21 = var10.healthRatio * var14 / var11.healthScale;
                     var89 = var75 * (var19 - var21) / var10.field1291 + var21;
                  } else {
                     var89 = var19;
                     var75 = var11.field3370 + var10.field1291 - var18;
                     if(var11.field3371 >= 0) {
                        var16 = (var75 << 8) / (var11.field3370 - var11.field3371);
                     }
                  }

                  if(var10.health > 0 && var89 < 1) {
                     var89 = 1;
                  }

                  var75 = Client.field1020 + var2 - (var14 >> 1);
                  var21 = Client.field1163 + var3 - var8;
                  if(var12 != null && var13 != null) {
                     var75 -= var15;
                     if(var89 == var14) {
                        var89 += var15 * 2;
                     } else {
                        var89 += var15;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.method5103(var75, var21, var16);
                        Rasterizer2D.method4962(var75, var21, var89 + var75, var22 + var21);
                        var13.method5103(var75, var21, var16);
                     } else {
                        var12.method5097(var75, var21);
                        Rasterizer2D.method4962(var75, var21, var75 + var89, var22 + var21);
                        var13.method5097(var75, var21);
                     }

                     Rasterizer2D.method4961(var2, var3, var4 + var2, var5 + var3);
                     var8 += 2;
                  } else {
                     if(Client.field1020 > -1) {
                        Rasterizer2D.method5040(var75, var21, var89, 5, '\uff00');
                        Rasterizer2D.method5040(var75 + var89, var21, var14 - var89, 5, 16711680);
                     }

                     var8 += 7;
                  }
               }
            }
         }

         if(var8 < 30) {
            var8 = 30;
         }

         if(var1 < var74) {
            Player var85 = (Player)var0;
            if(var85.field890) {
               return;
            }

            if(var85.skullIcon != -1 || var85.overheadIcon != -1) {
               FileOnDisk.method2384(var0, var0.field1276 + 15);
               if(Client.field1020 > -1) {
                  if(var85.skullIcon != -1) {
                     WorldMapType3.field396[var85.skullIcon].method5097(var2 + Client.field1020 - 12, Client.field1163 + var3 - var8);
                     var8 += 25;
                  }

                  if(var85.overheadIcon != -1) {
                     class15.field297[var85.overheadIcon].method5097(var2 + Client.field1020 - 12, var3 + Client.field1163 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field930 == 10 && Client.field1166 == var7[var1]) {
               FileOnDisk.method2384(var0, var0.field1276 + 15);
               if(Client.field1020 > -1) {
                  class60.field732[1].method5097(Client.field1020 + var2 - 12, var3 + Client.field1163 - var8);
               }
            }
         } else {
            NPCComposition var86 = ((NPC)var0).composition;
            if(var86.configs != null) {
               var86 = var86.method4685();
            }

            if(var86.field3583 >= 0 && var86.field3583 < class15.field297.length) {
               FileOnDisk.method2384(var0, var0.field1276 + 15);
               if(Client.field1020 > -1) {
                  class15.field297[var86.field3583].method5097(Client.field1020 + var2 - 12, Client.field1163 + var3 - 30);
               }
            }

            if(Client.field930 == 1 && Client.field953[var1 - var74] == Client.field931 && Client.gameCycle % 20 < 10) {
               FileOnDisk.method2384(var0, var0.field1276 + 15);
               if(Client.field1020 > -1) {
                  class60.field732[0].method5097(Client.field1020 + var2 - 12, var3 + Client.field1163 - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var74 || !var0.inSequence && (Client.field938 == 4 || !var0.field1240 && (Client.field938 == 0 || Client.field938 == 3 || Client.field938 == 1 && class7.method29(((Player)var0).name, false))))) {
            FileOnDisk.method2384(var0, var0.field1276);
            if(Client.field1020 > -1 && Client.field1008 < Client.field1009) {
               Client.field1038[Client.field1008] = class241.field3288.method4780(var0.overhead) / 2;
               Client.field1012[Client.field1008] = class241.field3288.field3652;
               Client.field1010[Client.field1008] = Client.field1020;
               Client.field1105[Client.field1008] = Client.field1163;
               Client.field982[Client.field1008] = var0.field1243;
               Client.field1017[Client.field1008] = var0.field1244;
               Client.field1085[Client.field1008] = var0.field1266;
               Client.field968[Client.field1008] = var0.overhead;
               ++Client.field1008;
            }
         }

         for(int var77 = 0; var77 < 4; ++var77) {
            int var81 = var0.field1263[var77];
            int var83 = var0.field1246[var77];
            class254 var87 = null;
            int var82 = 0;
            if(var83 >= 0) {
               if(var81 <= Client.gameCycle) {
                  continue;
               }

               var87 = class270.method4936(var0.field1246[var77]);
               var82 = var87.field3426;
               if(var87 != null && var87.field3417 != null) {
                  var87 = var87.method4507();
                  if(var87 == null) {
                     var0.field1263[var77] = -1;
                     continue;
                  }
               }
            } else if(var81 < 0) {
               continue;
            }

            var14 = var0.field1262[var77];
            class254 var80 = null;
            if(var14 >= 0) {
               var80 = class270.method4936(var14);
               if(var80 != null && var80.field3417 != null) {
                  var80 = var80.method4507();
               }
            }

            if(var81 - var82 <= Client.gameCycle) {
               if(var87 == null) {
                  var0.field1263[var77] = -1;
               } else {
                  FileOnDisk.method2384(var0, var0.field1276 / 2);
                  if(Client.field1020 > -1) {
                     if(var77 == 1) {
                        Client.field1163 -= 20;
                     }

                     if(var77 == 2) {
                        Client.field1020 -= 15;
                        Client.field1163 -= 10;
                     }

                     if(var77 == 3) {
                        Client.field1020 += 15;
                        Client.field1163 -= 10;
                     }

                     SpritePixels var17 = null;
                     SpritePixels var79 = null;
                     SpritePixels var84 = null;
                     SpritePixels var20 = null;
                     var21 = 0;
                     var22 = 0;
                     int var23 = 0;
                     int var24 = 0;
                     int var25 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     int var28 = 0;
                     SpritePixels var29 = null;
                     SpritePixels var30 = null;
                     SpritePixels var31 = null;
                     SpritePixels var32 = null;
                     int var33 = 0;
                     int var34 = 0;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     int var41 = 0;
                     var17 = var87.method4505();
                     int var42;
                     if(var17 != null) {
                        var21 = var17.width;
                        var42 = var17.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var25 = var17.offsetX;
                     }

                     var79 = var87.method4506();
                     if(var79 != null) {
                        var22 = var79.width;
                        var42 = var79.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var26 = var79.offsetX;
                     }

                     var84 = var87.method4502();
                     if(var84 != null) {
                        var23 = var84.width;
                        var42 = var84.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var27 = var84.offsetX;
                     }

                     var20 = var87.method4508();
                     if(var20 != null) {
                        var24 = var20.width;
                        var42 = var20.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var28 = var20.offsetX;
                     }

                     if(var80 != null) {
                        var29 = var80.method4505();
                        if(var29 != null) {
                           var33 = var29.width;
                           var42 = var29.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var37 = var29.offsetX;
                        }

                        var30 = var80.method4506();
                        if(var30 != null) {
                           var34 = var30.width;
                           var42 = var30.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var80.method4502();
                        if(var31 != null) {
                           var35 = var31.width;
                           var42 = var31.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var80.method4508();
                        if(var32 != null) {
                           var36 = var32.width;
                           var42 = var32.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var40 = var32.offsetX;
                        }
                     }

                     Font var78 = var87.method4509();
                     if(var78 == null) {
                        var78 = class261.field3629;
                     }

                     Font var43;
                     if(var80 != null) {
                        var43 = var80.method4509();
                        if(var43 == null) {
                           var43 = class261.field3629;
                        }
                     } else {
                        var43 = class261.field3629;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method4511(var0.field1251[var77]);
                     int var88 = var78.method4780(var44);
                     if(var80 != null) {
                        var45 = var80.method4511(var0.field1250[var77]);
                        var47 = var43.method4780(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(var84 == null && var20 == null) {
                           var48 = 1;
                        } else {
                           var48 = var88 / var22 + 1;
                        }
                     }

                     if(var80 != null && var34 > 0) {
                        if(var31 == null && var32 == null) {
                           var49 = 1;
                        } else {
                           var49 = var47 / var34 + 1;
                        }
                     }

                     int var50 = 0;
                     int var51 = var50;
                     if(var21 > 0) {
                        var50 += var21;
                     }

                     var50 += 2;
                     int var52 = var50;
                     if(var23 > 0) {
                        var50 += var23;
                     }

                     int var53 = var50;
                     int var54 = var50;
                     int var55;
                     if(var22 > 0) {
                        var55 = var22 * var48;
                        var50 += var55;
                        var54 += (var55 - var88) / 2;
                     } else {
                        var50 += var88;
                     }

                     var55 = var50;
                     if(var24 > 0) {
                        var50 += var24;
                     }

                     int var56 = 0;
                     int var57 = 0;
                     int var58 = 0;
                     int var59 = 0;
                     int var60 = 0;
                     int var61;
                     if(var80 != null) {
                        var50 += 2;
                        var56 = var50;
                        if(var33 > 0) {
                           var50 += var33;
                        }

                        var50 += 2;
                        var57 = var50;
                        if(var35 > 0) {
                           var50 += var35;
                        }

                        var58 = var50;
                        var60 = var50;
                        if(var34 > 0) {
                           var61 = var34 * var49;
                           var50 += var61;
                           var60 += (var61 - var47) / 2;
                        } else {
                           var50 += var47;
                        }

                        var59 = var50;
                        if(var36 > 0) {
                           var50 += var36;
                        }
                     }

                     var61 = var0.field1263[var77] - Client.gameCycle;
                     int var62 = var87.field3431 - var87.field3431 * var61 / var87.field3426;
                     int var63 = var61 * var87.field3432 / var87.field3426 + -var87.field3432;
                     int var64 = var62 + (Client.field1020 + var2 - (var50 >> 1));
                     int var65 = var3 + Client.field1163 - 12 + var63;
                     int var66 = var65;
                     int var67 = var65 + var41;
                     int var68 = var65 + 15 + var87.field3418;
                     int var69 = var68 - var78.field3667;
                     int var70 = var78.field3654 + var68;
                     if(var69 < var65) {
                        var66 = var69;
                     }

                     if(var70 > var67) {
                        var67 = var70;
                     }

                     int var71 = 0;
                     int var72;
                     int var73;
                     if(var80 != null) {
                        var71 = var65 + 15 + var80.field3418;
                        var72 = var71 - var43.field3667;
                        var73 = var71 + var43.field3654;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var87.field3429 >= 0) {
                        var72 = (var61 << 8) / (var87.field3426 - var87.field3429);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(var17 != null) {
                           var17.method5103(var51 + var64 - var25, var65, var72);
                        }

                        if(var84 != null) {
                           var84.method5103(var64 + var52 - var27, var65, var72);
                        }

                        if(var79 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var79.method5103(var64 + var53 - var26 + var73 * var22, var65, var72);
                           }
                        }

                        if(var20 != null) {
                           var20.method5103(var55 + var64 - var28, var65, var72);
                        }

                        var78.method4786(var44, var64 + var54, var68, var87.field3425, 0, var72);
                        if(var80 != null) {
                           if(var29 != null) {
                              var29.method5103(var64 + var56 - var37, var65, var72);
                           }

                           if(var31 != null) {
                              var31.method5103(var57 + var64 - var39, var65, var72);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method5103(var58 + var64 - var38 + var34 * var73, var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.method5103(var64 + var59 - var40, var65, var72);
                           }

                           var43.method4786(var45, var60 + var64, var71, var80.field3425, 0, var72);
                        }
                     } else {
                        if(var17 != null) {
                           var17.method5097(var64 + var51 - var25, var65);
                        }

                        if(var84 != null) {
                           var84.method5097(var64 + var52 - var27, var65);
                        }

                        if(var79 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var79.method5097(var53 + var64 - var26 + var73 * var22, var65);
                           }
                        }

                        if(var20 != null) {
                           var20.method5097(var55 + var64 - var28, var65);
                        }

                        var78.method4785(var44, var54 + var64, var68, var87.field3425 | -16777216, 0);
                        if(var80 != null) {
                           if(var29 != null) {
                              var29.method5097(var56 + var64 - var37, var65);
                           }

                           if(var31 != null) {
                              var31.method5097(var64 + var57 - var39, var65);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method5097(var73 * var34 + (var64 + var58 - var38), var65);
                              }
                           }

                           if(var32 != null) {
                              var32.method5097(var59 + var64 - var40, var65);
                           }

                           var43.method4785(var45, var64 + var60, var71, var80.field3425 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
