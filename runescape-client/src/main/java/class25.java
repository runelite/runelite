import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public final class class25 extends Node {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1298207065
   )
   int field570;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1625880137
   )
   int field571;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -635059801
   )
   int field572;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 110646619
   )
   int field573;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1531216477
   )
   int field574;
   @ObfuscatedName("ao")
   static SpritePixels[] field575;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1593864519
   )
   int field576;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 989218325
   )
   int field577;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2023357491
   )
   int field578;
   @ObfuscatedName("pr")
   public static class103 field579;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2111071413
   )
   int field581 = -1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 322377403
   )
   int field582 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 437501079
   )
   int field583;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -25254481
   )
   int field587;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "404155031"
   )
   static int method612(int var0, Script var1, boolean var2) {
      if(var0 == 3600) {
         if(Client.field553 == 0) {
            class32.field729[++class101.field1648 - 1] = -2;
         } else if(Client.field553 == 1) {
            class32.field729[++class101.field1648 - 1] = -1;
         } else {
            class32.field729[++class101.field1648 - 1] = Client.friendCount;
         }

         return 1;
      } else {
         int var10;
         if(var0 == 3601) {
            var10 = class32.field729[--class101.field1648];
            if(Client.field553 == 2 && var10 < Client.friendCount) {
               class32.scriptStringStack[++World.scriptStringStackSize - 1] = Client.friends[var10].name;
               class32.scriptStringStack[++World.scriptStringStackSize - 1] = Client.friends[var10].previousName;
            } else {
               class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
               class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 3602) {
            var10 = class32.field729[--class101.field1648];
            if(Client.field553 == 2 && var10 < Client.friendCount) {
               class32.field729[++class101.field1648 - 1] = Client.friends[var10].world;
            } else {
               class32.field729[++class101.field1648 - 1] = 0;
            }

            return 1;
         } else if(var0 == 3603) {
            var10 = class32.field729[--class101.field1648];
            if(Client.field553 == 2 && var10 < Client.friendCount) {
               class32.field729[++class101.field1648 - 1] = Client.friends[var10].rank;
            } else {
               class32.field729[++class101.field1648 - 1] = 0;
            }

            return 1;
         } else {
            String var3;
            if(var0 == 3604) {
               var3 = class32.scriptStringStack[--World.scriptStringStackSize];
               int var4 = class32.field729[--class101.field1648];
               class16.method194(var3, var4);
               return 1;
            } else {
               String var8;
               Ignore var11;
               int var12;
               String var14;
               Friend var15;
               String var16;
               if(var0 == 3605) {
                  var3 = class32.scriptStringStack[--World.scriptStringStackSize];
                  if(null != var3) {
                     if((Client.friendCount < 200 || Client.field407 == 1) && Client.friendCount < 400) {
                        var16 = class9.method122(var3, Client.field286);
                        if(var16 != null) {
                           var12 = 0;

                           while(true) {
                              if(var12 >= Client.friendCount) {
                                 for(var12 = 0; var12 < Client.ignoreCount; ++var12) {
                                    var11 = Client.ignores[var12];
                                    var14 = class9.method122(var11.name, Client.field286);
                                    if(var14 != null && var14.equals(var16)) {
                                       class140.sendGameMessage(30, "", "Please remove " + var3 + " from your ignore list first");
                                       return 1;
                                    }

                                    if(var11.previousName != null) {
                                       var8 = class9.method122(var11.previousName, Client.field286);
                                       if(null != var8 && var8.equals(var16)) {
                                          class140.sendGameMessage(30, "", "Please remove " + var3 + " from your ignore list first");
                                          return 1;
                                       }
                                    }
                                 }

                                 if(class9.method122(class9.localPlayer.name, Client.field286).equals(var16)) {
                                    class140.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
                                 } else {
                                    Client.field327.method3124(228);
                                    Client.field327.method3010(method615(var3));
                                    Client.field327.method2893(var3);
                                 }
                                 break;
                              }

                              var15 = Client.friends[var12];
                              var14 = class9.method122(var15.name, Client.field286);
                              if(null != var14 && var14.equals(var16)) {
                                 class140.sendGameMessage(30, "", var3 + " is already on your friend list");
                                 break;
                              }

                              if(null != var15.previousName) {
                                 var8 = class9.method122(var15.previousName, Client.field286);
                                 if(null != var8 && var8.equals(var16)) {
                                    class140.sendGameMessage(30, "", var3 + " is already on your friend list");
                                    break;
                                 }
                              }

                              ++var12;
                           }
                        }
                     } else {
                        class140.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                     }
                  }

                  return 1;
               } else {
                  int var9;
                  if(var0 == 3606) {
                     var3 = class32.scriptStringStack[--World.scriptStringStackSize];
                     if(var3 != null) {
                        var16 = class9.method122(var3, Client.field286);
                        if(null != var16) {
                           for(var12 = 0; var12 < Client.friendCount; ++var12) {
                              var15 = Client.friends[var12];
                              var14 = var15.name;
                              var8 = class9.method122(var14, Client.field286);
                              if(class211.method4060(var3, var16, var14, var8)) {
                                 --Client.friendCount;

                                 for(var9 = var12; var9 < Client.friendCount; ++var9) {
                                    Client.friends[var9] = Client.friends[1 + var9];
                                 }

                                 Client.field285 = Client.field470;
                                 Client.field327.method3124(120);
                                 Client.field327.method3010(method615(var3));
                                 Client.field327.method2893(var3);
                                 break;
                              }
                           }
                        }
                     }

                     return 1;
                  } else if(var0 == 3607) {
                     var3 = class32.scriptStringStack[--World.scriptStringStackSize];
                     class101.method2015(var3, false);
                     return 1;
                  } else if(var0 == 3608) {
                     var3 = class32.scriptStringStack[--World.scriptStringStackSize];
                     if(null != var3) {
                        var16 = class9.method122(var3, Client.field286);
                        if(var16 != null) {
                           for(var12 = 0; var12 < Client.ignoreCount; ++var12) {
                              var11 = Client.ignores[var12];
                              var14 = var11.name;
                              var8 = class9.method122(var14, Client.field286);
                              if(class211.method4060(var3, var16, var14, var8)) {
                                 --Client.ignoreCount;

                                 for(var9 = var12; var9 < Client.ignoreCount; ++var9) {
                                    Client.ignores[var9] = Client.ignores[1 + var9];
                                 }

                                 Client.field285 = Client.field470;
                                 Client.field327.method3124(249);
                                 Client.field327.method3010(method615(var3));
                                 Client.field327.method2893(var3);
                                 break;
                              }
                           }
                        }
                     }

                     return 1;
                  } else if(var0 == 3609) {
                     var3 = class32.scriptStringStack[--World.scriptStringStackSize];
                     class177[] var13 = new class177[]{class177.field2658, class177.field2661, class177.field2668, class177.field2657, class177.field2663, class177.field2664};
                     class177[] var5 = var13;

                     for(int var6 = 0; var6 < var5.length; ++var6) {
                        class177 var7 = var5[var6];
                        if(var7.field2660 != -1 && var3.startsWith(method614(var7.field2660))) {
                           var3 = var3.substring(6 + Integer.toString(var7.field2660).length());
                           break;
                        }
                     }

                     class32.field729[++class101.field1648 - 1] = ChatLineBuffer.method983(var3, false)?1:0;
                     return 1;
                  } else if(var0 == 3611) {
                     if(null != Client.field512) {
                        class32.scriptStringStack[++World.scriptStringStackSize - 1] = Script.method962(Client.field512);
                     } else {
                        class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                     }

                     return 1;
                  } else if(var0 == 3612) {
                     if(null != Client.field512) {
                        class32.field729[++class101.field1648 - 1] = class1.clanChatCount;
                     } else {
                        class32.field729[++class101.field1648 - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 3613) {
                     var10 = class32.field729[--class101.field1648];
                     if(null != Client.field512 && var10 < class1.clanChatCount) {
                        class32.scriptStringStack[++World.scriptStringStackSize - 1] = ObjectComposition.clanMembers[var10].username;
                     } else {
                        class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                     }

                     return 1;
                  } else if(var0 == 3614) {
                     var10 = class32.field729[--class101.field1648];
                     if(Client.field512 != null && var10 < class1.clanChatCount) {
                        class32.field729[++class101.field1648 - 1] = ObjectComposition.clanMembers[var10].world;
                     } else {
                        class32.field729[++class101.field1648 - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 3615) {
                     var10 = class32.field729[--class101.field1648];
                     if(Client.field512 != null && var10 < class1.clanChatCount) {
                        class32.field729[++class101.field1648 - 1] = ObjectComposition.clanMembers[var10].rank;
                     } else {
                        class32.field729[++class101.field1648 - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 3616) {
                     class32.field729[++class101.field1648 - 1] = class57.field1026;
                     return 1;
                  } else if(var0 == 3617) {
                     var3 = class32.scriptStringStack[--World.scriptStringStackSize];
                     if(null != ObjectComposition.clanMembers) {
                        Client.field327.method3124(110);
                        Client.field327.method3010(method615(var3));
                        Client.field327.method2893(var3);
                     }

                     return 1;
                  } else if(var0 == 3618) {
                     class32.field729[++class101.field1648 - 1] = class180.field2700;
                     return 1;
                  } else if(var0 == 3619) {
                     var3 = class32.scriptStringStack[--World.scriptStringStackSize];
                     SecondaryBufferProvider.method4240(var3);
                     return 1;
                  } else if(var0 == 3620) {
                     Client.field327.method3124(177);
                     Client.field327.method3010(0);
                     return 1;
                  } else if(var0 == 3621) {
                     if(Client.field553 == 0) {
                        class32.field729[++class101.field1648 - 1] = -1;
                     } else {
                        class32.field729[++class101.field1648 - 1] = Client.ignoreCount;
                     }

                     return 1;
                  } else if(var0 == 3622) {
                     var10 = class32.field729[--class101.field1648];
                     if(Client.field553 != 0 && var10 < Client.ignoreCount) {
                        class32.scriptStringStack[++World.scriptStringStackSize - 1] = Client.ignores[var10].name;
                        class32.scriptStringStack[++World.scriptStringStackSize - 1] = Client.ignores[var10].previousName;
                     } else {
                        class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                        class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                     }

                     return 1;
                  } else if(var0 == 3623) {
                     var3 = class32.scriptStringStack[--World.scriptStringStackSize];
                     if(var3.startsWith(method614(0)) || var3.startsWith(method614(1))) {
                        var3 = var3.substring(7);
                     }

                     class32.field729[++class101.field1648 - 1] = class5.method82(var3)?1:0;
                     return 1;
                  } else if(var0 != 3624) {
                     if(var0 == 3625) {
                        if(Client.clanChatOwner != null) {
                           class32.scriptStringStack[++World.scriptStringStackSize - 1] = Script.method962(Client.clanChatOwner);
                        } else {
                           class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                        }

                        return 1;
                     } else {
                        return 2;
                     }
                  } else {
                     var10 = class32.field729[--class101.field1648];
                     if(ObjectComposition.clanMembers != null && var10 < class1.clanChatCount && ObjectComposition.clanMembers[var10].username.equalsIgnoreCase(class9.localPlayer.name)) {
                        class32.field729[++class101.field1648 - 1] = 1;
                     } else {
                        class32.field729[++class101.field1648 - 1] = 0;
                     }

                     return 1;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILclass182;IIIZI)V",
      garbageValue = "-229031230"
   )
   public static void method613(int var0, class182 var1, int var2, int var3, int var4, boolean var5) {
      class138.field1915 = 1;
      class138.field1918 = var1;
      class20.field205 = var2;
      class85.field1446 = var3;
      FaceNormal.field1561 = var4;
      class105.field1713 = var5;
      class138.field1917 = var0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1373662722"
   )
   static String method614(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-935860968"
   )
   public static int method615(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)LOverlay;",
      garbageValue = "99982602"
   )
   public static Overlay method616(int var0) {
      Overlay var1 = (Overlay)Overlay.field3053.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Overlay.field3051.getConfigData(4, var0);
         var1 = new Overlay();
         if(var2 != null) {
            var1.method3848(new Buffer(var2), var0);
         }

         var1.method3836();
         Overlay.field3053.put(var1, (long)var0);
         return var1;
      }
   }
}
