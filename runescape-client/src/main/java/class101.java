import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
public class class101 extends RuntimeException {
   @ObfuscatedName("r")
   Throwable field1674;
   @ObfuscatedName("i")
   public static String field1675;
   @ObfuscatedName("h")
   String field1677;
   @ObfuscatedName("f")
   static Applet field1680;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 72842679
   )
   @Export("revision")
   static int revision;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "4"
   )
   static int method1998(int var0, Script var1, boolean var2) {
      if(var0 == 3600) {
         if(Client.field571 == 0) {
            class32.field743[++Preferences.field713 - 1] = -2;
         } else if(Client.field571 == 1) {
            class32.field743[++Preferences.field713 - 1] = -1;
         } else {
            class32.field743[++Preferences.field713 - 1] = Client.friendCount;
         }

         return 1;
      } else {
         int var3;
         if(var0 == 3601) {
            var3 = class32.field743[--Preferences.field713];
            if(Client.field571 == 2 && var3 < Client.friendCount) {
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = Client.friends[var3].name;
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = Client.friends[var3].previousName;
            } else {
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 3602) {
            var3 = class32.field743[--Preferences.field713];
            if(Client.field571 == 2 && var3 < Client.friendCount) {
               class32.field743[++Preferences.field713 - 1] = Client.friends[var3].world;
            } else {
               class32.field743[++Preferences.field713 - 1] = 0;
            }

            return 1;
         } else if(var0 == 3603) {
            var3 = class32.field743[--Preferences.field713];
            if(Client.field571 == 2 && var3 < Client.friendCount) {
               class32.field743[++Preferences.field713 - 1] = Client.friends[var3].rank;
            } else {
               class32.field743[++Preferences.field713 - 1] = 0;
            }

            return 1;
         } else {
            int var4;
            String var5;
            if(var0 == 3604) {
               var5 = class32.scriptStringStack[--class32.scriptStringStackSize];
               var4 = class32.field743[--Preferences.field713];
               Client.secretCipherBuffer1.putOpcode(32);
               Client.secretCipherBuffer1.putByte(class72.method1439(var5) + 1);
               Client.secretCipherBuffer1.method2931(var5);
               Client.secretCipherBuffer1.method2892(var4);
               return 1;
            } else {
               int var6;
               String var7;
               String var8;
               String var9;
               Ignore var10;
               Friend var11;
               if(var0 == 3605) {
                  var5 = class32.scriptStringStack[--class32.scriptStringStackSize];
                  if(var5 != null) {
                     if((Client.friendCount < 200 || Client.field313 == 1) && Client.friendCount < 400) {
                        var9 = class187.method3483(var5, Ignore.field214);
                        if(var9 != null) {
                           var6 = 0;

                           while(true) {
                              if(var6 >= Client.friendCount) {
                                 for(var6 = 0; var6 < Client.ignoreCount; ++var6) {
                                    var10 = Client.ignores[var6];
                                    var7 = class187.method3483(var10.name, Ignore.field214);
                                    if(var7 != null && var7.equals(var9)) {
                                       Player.sendGameMessage(30, "", "Please remove " + var5 + " from your ignore list first");
                                       return 1;
                                    }

                                    if(var10.previousName != null) {
                                       var8 = class187.method3483(var10.previousName, Ignore.field214);
                                       if(var8 != null && var8.equals(var9)) {
                                          Player.sendGameMessage(30, "", "Please remove " + var5 + " from your ignore list first");
                                          return 1;
                                       }
                                    }
                                 }

                                 if(class187.method3483(Projectile.localPlayer.name, Ignore.field214).equals(var9)) {
                                    Player.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
                                 } else {
                                    Client.secretCipherBuffer1.putOpcode(228);
                                    Client.secretCipherBuffer1.putByte(class72.method1439(var5));
                                    Client.secretCipherBuffer1.method2931(var5);
                                 }
                                 break;
                              }

                              var11 = Client.friends[var6];
                              var7 = class187.method3483(var11.name, Ignore.field214);
                              if(var7 != null && var7.equals(var9)) {
                                 Player.sendGameMessage(30, "", var5 + " is already on your friend list");
                                 break;
                              }

                              if(var11.previousName != null) {
                                 var8 = class187.method3483(var11.previousName, Ignore.field214);
                                 if(var8 != null && var8.equals(var9)) {
                                    Player.sendGameMessage(30, "", var5 + " is already on your friend list");
                                    break;
                                 }
                              }

                              ++var6;
                           }
                        }
                     } else {
                        Player.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                     }
                  }

                  return 1;
               } else {
                  boolean var12;
                  int var13;
                  if(var0 == 3606) {
                     var5 = class32.scriptStringStack[--class32.scriptStringStackSize];
                     if(var5 != null) {
                        var9 = class187.method3483(var5, Ignore.field214);
                        if(var9 != null) {
                           for(var6 = 0; var6 < Client.friendCount; ++var6) {
                              var11 = Client.friends[var6];
                              var7 = var11.name;
                              var8 = class187.method3483(var7, Ignore.field214);
                              if(var5 != null && var7 != null) {
                                 if(!var5.startsWith("#") && !var7.startsWith("#")) {
                                    var12 = var9.equals(var8);
                                 } else {
                                    var12 = var5.equals(var7);
                                 }
                              } else {
                                 var12 = false;
                              }

                              if(var12) {
                                 --Client.friendCount;

                                 for(var13 = var6; var13 < Client.friendCount; ++var13) {
                                    Client.friends[var13] = Client.friends[var13 + 1];
                                 }

                                 Client.field496 = Client.field561;
                                 Client.secretCipherBuffer1.putOpcode(89);
                                 Client.secretCipherBuffer1.putByte(class72.method1439(var5));
                                 Client.secretCipherBuffer1.method2931(var5);
                                 break;
                              }
                           }
                        }
                     }

                     return 1;
                  } else if(var0 == 3607) {
                     var5 = class32.scriptStringStack[--class32.scriptStringStackSize];
                     if(var5 != null) {
                        if((Client.ignoreCount < 100 || Client.field313 == 1) && Client.ignoreCount < 400) {
                           var9 = class187.method3483(var5, Ignore.field214);
                           if(var9 != null) {
                              var6 = 0;

                              while(true) {
                                 if(var6 >= Client.ignoreCount) {
                                    for(var6 = 0; var6 < Client.friendCount; ++var6) {
                                       var11 = Client.friends[var6];
                                       var7 = class187.method3483(var11.name, Ignore.field214);
                                       if(var7 != null && var7.equals(var9)) {
                                          Player.sendGameMessage(31, "", "Please remove " + var5 + " from your friend list first");
                                          return 1;
                                       }

                                       if(var11.previousName != null) {
                                          var8 = class187.method3483(var11.previousName, Ignore.field214);
                                          if(var8 != null && var8.equals(var9)) {
                                             Player.sendGameMessage(31, "", "Please remove " + var5 + " from your friend list first");
                                             return 1;
                                          }
                                       }
                                    }

                                    if(class187.method3483(Projectile.localPlayer.name, Ignore.field214).equals(var9)) {
                                       Player.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
                                    } else {
                                       Client.secretCipherBuffer1.putOpcode(95);
                                       Client.secretCipherBuffer1.putByte(class72.method1439(var5));
                                       Client.secretCipherBuffer1.method2931(var5);
                                    }
                                    break;
                                 }

                                 var10 = Client.ignores[var6];
                                 var7 = class187.method3483(var10.name, Ignore.field214);
                                 if(var7 != null && var7.equals(var9)) {
                                    Player.sendGameMessage(31, "", var5 + " is already on your ignore list");
                                    break;
                                 }

                                 if(var10.previousName != null) {
                                    var8 = class187.method3483(var10.previousName, Ignore.field214);
                                    if(var8 != null && var8.equals(var9)) {
                                       Player.sendGameMessage(31, "", var5 + " is already on your ignore list");
                                       break;
                                    }
                                 }

                                 ++var6;
                              }
                           }
                        } else {
                           Player.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                        }
                     }

                     return 1;
                  } else if(var0 == 3608) {
                     var5 = class32.scriptStringStack[--class32.scriptStringStackSize];
                     if(var5 != null) {
                        var9 = class187.method3483(var5, Ignore.field214);
                        if(var9 != null) {
                           for(var6 = 0; var6 < Client.ignoreCount; ++var6) {
                              var10 = Client.ignores[var6];
                              var7 = var10.name;
                              var8 = class187.method3483(var7, Ignore.field214);
                              if(var5 != null && var7 != null) {
                                 if(!var5.startsWith("#") && !var7.startsWith("#")) {
                                    var12 = var9.equals(var8);
                                 } else {
                                    var12 = var5.equals(var7);
                                 }
                              } else {
                                 var12 = false;
                              }

                              if(var12) {
                                 --Client.ignoreCount;

                                 for(var13 = var6; var13 < Client.ignoreCount; ++var13) {
                                    Client.ignores[var13] = Client.ignores[var13 + 1];
                                 }

                                 Client.field496 = Client.field561;
                                 Client.secretCipherBuffer1.putOpcode(64);
                                 Client.secretCipherBuffer1.putByte(class72.method1439(var5));
                                 Client.secretCipherBuffer1.method2931(var5);
                                 break;
                              }
                           }
                        }
                     }

                     return 1;
                  } else if(var0 == 3609) {
                     var5 = class32.scriptStringStack[--class32.scriptStringStackSize];
                     class177[] var16 = class3.method23();

                     for(var6 = 0; var6 < var16.length; ++var6) {
                        class177 var17 = var16[var6];
                        if(var17.field2695 != -1 && var5.startsWith(Preferences.method648(var17.field2695))) {
                           var5 = var5.substring(Integer.toString(var17.field2695).length() + 6);
                           break;
                        }
                     }

                     class32.field743[++Preferences.field713 - 1] = class10.method137(var5, false)?1:0;
                     return 1;
                  } else {
                     String[] var14;
                     String var15;
                     if(var0 == 3611) {
                        if(Client.field530 != null) {
                           var14 = class32.scriptStringStack;
                           var4 = ++class32.scriptStringStackSize - 1;
                           var15 = Client.field530;
                           var7 = class7.method80(class38.method765(var15));
                           if(var7 == null) {
                              var7 = "";
                           }

                           var14[var4] = var7;
                        } else {
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                        }

                        return 1;
                     } else if(var0 == 3612) {
                        if(Client.field530 != null) {
                           class32.field743[++Preferences.field713 - 1] = VertexNormal.clanChatCount;
                        } else {
                           class32.field743[++Preferences.field713 - 1] = 0;
                        }

                        return 1;
                     } else if(var0 == 3613) {
                        var3 = class32.field743[--Preferences.field713];
                        if(Client.field530 != null && var3 < VertexNormal.clanChatCount) {
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = class156.clanMembers[var3].username;
                        } else {
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                        }

                        return 1;
                     } else if(var0 == 3614) {
                        var3 = class32.field743[--Preferences.field713];
                        if(Client.field530 != null && var3 < VertexNormal.clanChatCount) {
                           class32.field743[++Preferences.field713 - 1] = class156.clanMembers[var3].world;
                        } else {
                           class32.field743[++Preferences.field713 - 1] = 0;
                        }

                        return 1;
                     } else if(var0 == 3615) {
                        var3 = class32.field743[--Preferences.field713];
                        if(Client.field530 != null && var3 < VertexNormal.clanChatCount) {
                           class32.field743[++Preferences.field713 - 1] = class156.clanMembers[var3].rank;
                        } else {
                           class32.field743[++Preferences.field713 - 1] = 0;
                        }

                        return 1;
                     } else if(var0 == 3616) {
                        class32.field743[++Preferences.field713 - 1] = class47.field959;
                        return 1;
                     } else if(var0 == 3617) {
                        var5 = class32.scriptStringStack[--class32.scriptStringStackSize];
                        class181.method3331(var5);
                        return 1;
                     } else if(var0 == 3618) {
                        class32.field743[++Preferences.field713 - 1] = class9.field75;
                        return 1;
                     } else if(var0 == 3619) {
                        var5 = class32.scriptStringStack[--class32.scriptStringStackSize];
                        class39.method769(var5);
                        return 1;
                     } else if(var0 == 3620) {
                        Buffer.method3066();
                        return 1;
                     } else if(var0 == 3621) {
                        if(Client.field571 == 0) {
                           class32.field743[++Preferences.field713 - 1] = -1;
                        } else {
                           class32.field743[++Preferences.field713 - 1] = Client.ignoreCount;
                        }

                        return 1;
                     } else if(var0 == 3622) {
                        var3 = class32.field743[--Preferences.field713];
                        if(Client.field571 != 0 && var3 < Client.ignoreCount) {
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = Client.ignores[var3].name;
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = Client.ignores[var3].previousName;
                        } else {
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                        }

                        return 1;
                     } else if(var0 == 3623) {
                        var5 = class32.scriptStringStack[--class32.scriptStringStackSize];
                        if(var5.startsWith(Preferences.method648(0)) || var5.startsWith(Preferences.method648(1))) {
                           var5 = var5.substring(7);
                        }

                        class32.field743[++Preferences.field713 - 1] = class94.method1951(var5)?1:0;
                        return 1;
                     } else if(var0 != 3624) {
                        if(var0 == 3625) {
                           if(Client.clanChatOwner != null) {
                              var14 = class32.scriptStringStack;
                              var4 = ++class32.scriptStringStackSize - 1;
                              var15 = Client.clanChatOwner;
                              var7 = class7.method80(class38.method765(var15));
                              if(var7 == null) {
                                 var7 = "";
                              }

                              var14[var4] = var7;
                           } else {
                              class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                           }

                           return 1;
                        } else {
                           return 2;
                        }
                     } else {
                        var3 = class32.field743[--Preferences.field713];
                        if(class156.clanMembers != null && var3 < VertexNormal.clanChatCount && class156.clanMembers[var3].username.equalsIgnoreCase(Projectile.localPlayer.name)) {
                           class32.field743[++Preferences.field713 - 1] = 1;
                        } else {
                           class32.field743[++Preferences.field713 - 1] = 0;
                        }

                        return 1;
                     }
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;I)V",
      garbageValue = "1548125708"
   )
   public static void method1999(IndexDataBase var0, IndexDataBase var1) {
      KitDefinition.field2834 = var0;
      class138.field1943 = var1;
      KitDefinition.field2831 = KitDefinition.field2834.method3346(3);
   }
}
