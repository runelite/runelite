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
            class32.field743[++class30.field713 - 1] = -2;
         } else if(Client.field571 == 1) {
            class32.field743[++class30.field713 - 1] = -1;
         } else {
            class32.field743[++class30.field713 - 1] = Client.friendCount;
         }

         return 1;
      } else {
         int var11;
         if(var0 == 3601) {
            var11 = class32.field743[--class30.field713];
            if(Client.field571 == 2 && var11 < Client.friendCount) {
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = Client.friends[var11].name;
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = Client.friends[var11].previousName;
            } else {
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 3602) {
            var11 = class32.field743[--class30.field713];
            if(Client.field571 == 2 && var11 < Client.friendCount) {
               class32.field743[++class30.field713 - 1] = Client.friends[var11].world;
            } else {
               class32.field743[++class30.field713 - 1] = 0;
            }

            return 1;
         } else if(var0 == 3603) {
            var11 = class32.field743[--class30.field713];
            if(Client.field571 == 2 && var11 < Client.friendCount) {
               class32.field743[++class30.field713 - 1] = Client.friends[var11].rank;
            } else {
               class32.field743[++class30.field713 - 1] = 0;
            }

            return 1;
         } else {
            int var12;
            String var14;
            if(var0 == 3604) {
               var14 = class32.scriptStringStack[--class32.scriptStringStackSize];
               var12 = class32.field743[--class30.field713];
               Client.secretCipherBuffer1.putOpcode(32);
               Client.secretCipherBuffer1.putByte(class72.method1439(var14) + 1);
               Client.secretCipherBuffer1.method2931(var14);
               Client.secretCipherBuffer1.method2892(var12);
               return 1;
            } else {
               int var5;
               String var7;
               String var8;
               String var15;
               Ignore var17;
               Friend var18;
               if(var0 == 3605) {
                  var14 = class32.scriptStringStack[--class32.scriptStringStackSize];
                  if(null != var14) {
                     if((Client.friendCount < 200 || Client.field313 == 1) && Client.friendCount < 400) {
                        var15 = class187.method3483(var14, Ignore.field214);
                        if(null != var15) {
                           var5 = 0;

                           while(true) {
                              if(var5 >= Client.friendCount) {
                                 for(var5 = 0; var5 < Client.ignoreCount; ++var5) {
                                    var17 = Client.ignores[var5];
                                    var7 = class187.method3483(var17.name, Ignore.field214);
                                    if(var7 != null && var7.equals(var15)) {
                                       Player.sendGameMessage(30, "", "Please remove " + var14 + " from your ignore list first");
                                       return 1;
                                    }

                                    if(null != var17.previousName) {
                                       var8 = class187.method3483(var17.previousName, Ignore.field214);
                                       if(var8 != null && var8.equals(var15)) {
                                          Player.sendGameMessage(30, "", "Please remove " + var14 + " from your ignore list first");
                                          return 1;
                                       }
                                    }
                                 }

                                 if(class187.method3483(Projectile.localPlayer.name, Ignore.field214).equals(var15)) {
                                    Player.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
                                 } else {
                                    Client.secretCipherBuffer1.putOpcode(228);
                                    Client.secretCipherBuffer1.putByte(class72.method1439(var14));
                                    Client.secretCipherBuffer1.method2931(var14);
                                 }
                                 break;
                              }

                              var18 = Client.friends[var5];
                              var7 = class187.method3483(var18.name, Ignore.field214);
                              if(null != var7 && var7.equals(var15)) {
                                 Player.sendGameMessage(30, "", var14 + " is already on your friend list");
                                 break;
                              }

                              if(null != var18.previousName) {
                                 var8 = class187.method3483(var18.previousName, Ignore.field214);
                                 if(null != var8 && var8.equals(var15)) {
                                    Player.sendGameMessage(30, "", var14 + " is already on your friend list");
                                    break;
                                 }
                              }

                              ++var5;
                           }
                        }
                     } else {
                        Player.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                     }
                  }

                  return 1;
               } else {
                  boolean var9;
                  int var10;
                  if(var0 == 3606) {
                     var14 = class32.scriptStringStack[--class32.scriptStringStackSize];
                     if(var14 != null) {
                        var15 = class187.method3483(var14, Ignore.field214);
                        if(null != var15) {
                           for(var5 = 0; var5 < Client.friendCount; ++var5) {
                              var18 = Client.friends[var5];
                              var7 = var18.name;
                              var8 = class187.method3483(var7, Ignore.field214);
                              if(var14 != null && null != var7) {
                                 if(!var14.startsWith("#") && !var7.startsWith("#")) {
                                    var9 = var15.equals(var8);
                                 } else {
                                    var9 = var14.equals(var7);
                                 }
                              } else {
                                 var9 = false;
                              }

                              if(var9) {
                                 --Client.friendCount;

                                 for(var10 = var5; var10 < Client.friendCount; ++var10) {
                                    Client.friends[var10] = Client.friends[var10 + 1];
                                 }

                                 Client.field496 = Client.field561;
                                 Client.secretCipherBuffer1.putOpcode(89);
                                 Client.secretCipherBuffer1.putByte(class72.method1439(var14));
                                 Client.secretCipherBuffer1.method2931(var14);
                                 break;
                              }
                           }
                        }
                     }

                     return 1;
                  } else if(var0 == 3607) {
                     var14 = class32.scriptStringStack[--class32.scriptStringStackSize];
                     if(null != var14) {
                        if((Client.ignoreCount < 100 || Client.field313 == 1) && Client.ignoreCount < 400) {
                           var15 = class187.method3483(var14, Ignore.field214);
                           if(null != var15) {
                              var5 = 0;

                              while(true) {
                                 if(var5 >= Client.ignoreCount) {
                                    for(var5 = 0; var5 < Client.friendCount; ++var5) {
                                       var18 = Client.friends[var5];
                                       var7 = class187.method3483(var18.name, Ignore.field214);
                                       if(var7 != null && var7.equals(var15)) {
                                          Player.sendGameMessage(31, "", "Please remove " + var14 + " from your friend list first");
                                          return 1;
                                       }

                                       if(var18.previousName != null) {
                                          var8 = class187.method3483(var18.previousName, Ignore.field214);
                                          if(var8 != null && var8.equals(var15)) {
                                             Player.sendGameMessage(31, "", "Please remove " + var14 + " from your friend list first");
                                             return 1;
                                          }
                                       }
                                    }

                                    if(class187.method3483(Projectile.localPlayer.name, Ignore.field214).equals(var15)) {
                                       Player.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
                                    } else {
                                       Client.secretCipherBuffer1.putOpcode(95);
                                       Client.secretCipherBuffer1.putByte(class72.method1439(var14));
                                       Client.secretCipherBuffer1.method2931(var14);
                                    }
                                    break;
                                 }

                                 var17 = Client.ignores[var5];
                                 var7 = class187.method3483(var17.name, Ignore.field214);
                                 if(var7 != null && var7.equals(var15)) {
                                    Player.sendGameMessage(31, "", var14 + " is already on your ignore list");
                                    break;
                                 }

                                 if(var17.previousName != null) {
                                    var8 = class187.method3483(var17.previousName, Ignore.field214);
                                    if(null != var8 && var8.equals(var15)) {
                                       Player.sendGameMessage(31, "", var14 + " is already on your ignore list");
                                       break;
                                    }
                                 }

                                 ++var5;
                              }
                           }
                        } else {
                           Player.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                        }
                     }

                     return 1;
                  } else if(var0 == 3608) {
                     var14 = class32.scriptStringStack[--class32.scriptStringStackSize];
                     if(var14 != null) {
                        var15 = class187.method3483(var14, Ignore.field214);
                        if(null != var15) {
                           for(var5 = 0; var5 < Client.ignoreCount; ++var5) {
                              var17 = Client.ignores[var5];
                              var7 = var17.name;
                              var8 = class187.method3483(var7, Ignore.field214);
                              if(null != var14 && var7 != null) {
                                 if(!var14.startsWith("#") && !var7.startsWith("#")) {
                                    var9 = var15.equals(var8);
                                 } else {
                                    var9 = var14.equals(var7);
                                 }
                              } else {
                                 var9 = false;
                              }

                              if(var9) {
                                 --Client.ignoreCount;

                                 for(var10 = var5; var10 < Client.ignoreCount; ++var10) {
                                    Client.ignores[var10] = Client.ignores[1 + var10];
                                 }

                                 Client.field496 = Client.field561;
                                 Client.secretCipherBuffer1.putOpcode(64);
                                 Client.secretCipherBuffer1.putByte(class72.method1439(var14));
                                 Client.secretCipherBuffer1.method2931(var14);
                                 break;
                              }
                           }
                        }
                     }

                     return 1;
                  } else if(var0 == 3609) {
                     var14 = class32.scriptStringStack[--class32.scriptStringStackSize];
                     class177[] var4 = class3.method23();

                     for(var5 = 0; var5 < var4.length; ++var5) {
                        class177 var16 = var4[var5];
                        if(var16.field2695 != -1 && var14.startsWith(class30.method648(var16.field2695))) {
                           var14 = var14.substring(6 + Integer.toString(var16.field2695).length());
                           break;
                        }
                     }

                     class32.field743[++class30.field713 - 1] = class10.method137(var14, false)?1:0;
                     return 1;
                  } else {
                     String[] var3;
                     String var6;
                     if(var0 == 3611) {
                        if(null != Client.field530) {
                           var3 = class32.scriptStringStack;
                           var12 = ++class32.scriptStringStackSize - 1;
                           var6 = Client.field530;
                           var7 = class7.method80(class38.method765(var6));
                           if(null == var7) {
                              var7 = "";
                           }

                           var3[var12] = var7;
                        } else {
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                        }

                        return 1;
                     } else if(var0 == 3612) {
                        if(Client.field530 != null) {
                           class32.field743[++class30.field713 - 1] = VertexNormal.clanChatCount;
                        } else {
                           class32.field743[++class30.field713 - 1] = 0;
                        }

                        return 1;
                     } else if(var0 == 3613) {
                        var11 = class32.field743[--class30.field713];
                        if(Client.field530 != null && var11 < VertexNormal.clanChatCount) {
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = class156.clanMembers[var11].username;
                        } else {
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                        }

                        return 1;
                     } else if(var0 == 3614) {
                        var11 = class32.field743[--class30.field713];
                        if(Client.field530 != null && var11 < VertexNormal.clanChatCount) {
                           class32.field743[++class30.field713 - 1] = class156.clanMembers[var11].world;
                        } else {
                           class32.field743[++class30.field713 - 1] = 0;
                        }

                        return 1;
                     } else if(var0 == 3615) {
                        var11 = class32.field743[--class30.field713];
                        if(Client.field530 != null && var11 < VertexNormal.clanChatCount) {
                           class32.field743[++class30.field713 - 1] = class156.clanMembers[var11].rank;
                        } else {
                           class32.field743[++class30.field713 - 1] = 0;
                        }

                        return 1;
                     } else if(var0 == 3616) {
                        class32.field743[++class30.field713 - 1] = class47.field959;
                        return 1;
                     } else if(var0 == 3617) {
                        var14 = class32.scriptStringStack[--class32.scriptStringStackSize];
                        class181.method3331(var14);
                        return 1;
                     } else if(var0 == 3618) {
                        class32.field743[++class30.field713 - 1] = class9.field75;
                        return 1;
                     } else if(var0 == 3619) {
                        var14 = class32.scriptStringStack[--class32.scriptStringStackSize];
                        class39.method769(var14);
                        return 1;
                     } else if(var0 == 3620) {
                        Buffer.method3066();
                        return 1;
                     } else if(var0 == 3621) {
                        if(Client.field571 == 0) {
                           class32.field743[++class30.field713 - 1] = -1;
                        } else {
                           class32.field743[++class30.field713 - 1] = Client.ignoreCount;
                        }

                        return 1;
                     } else if(var0 == 3622) {
                        var11 = class32.field743[--class30.field713];
                        if(Client.field571 != 0 && var11 < Client.ignoreCount) {
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = Client.ignores[var11].name;
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = Client.ignores[var11].previousName;
                        } else {
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                        }

                        return 1;
                     } else if(var0 == 3623) {
                        var14 = class32.scriptStringStack[--class32.scriptStringStackSize];
                        if(var14.startsWith(class30.method648(0)) || var14.startsWith(class30.method648(1))) {
                           var14 = var14.substring(7);
                        }

                        class32.field743[++class30.field713 - 1] = class94.method1951(var14)?1:0;
                        return 1;
                     } else if(var0 != 3624) {
                        if(var0 == 3625) {
                           if(Client.clanChatOwner != null) {
                              var3 = class32.scriptStringStack;
                              var12 = ++class32.scriptStringStackSize - 1;
                              var6 = Client.clanChatOwner;
                              var7 = class7.method80(class38.method765(var6));
                              if(null == var7) {
                                 var7 = "";
                              }

                              var3[var12] = var7;
                           } else {
                              class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                           }

                           return 1;
                        } else {
                           return 2;
                        }
                     } else {
                        var11 = class32.field743[--class30.field713];
                        if(null != class156.clanMembers && var11 < VertexNormal.clanChatCount && class156.clanMembers[var11].username.equalsIgnoreCase(Projectile.localPlayer.name)) {
                           class32.field743[++class30.field713 - 1] = 1;
                        } else {
                           class32.field743[++class30.field713 - 1] = 0;
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
   public static void method1999(class182 var0, class182 var1) {
      KitDefinition.field2834 = var0;
      class138.field1943 = var1;
      KitDefinition.field2831 = KitDefinition.field2834.method3346(3);
   }
}
