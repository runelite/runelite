import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class37 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1490194549
   )
   @Export("revision")
   public static int revision;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("widgetIndex")
   static IndexDataBase widgetIndex;
   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "[Lkg;"
   )
   @Export("slStarSprites")
   static IndexedSprite[] slStarSprites;
   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("indexModels")
   static IndexData indexModels;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILck;ZS)I",
      garbageValue = "2706"
   )
   static int method507(int var0, Script var1, boolean var2) {
      if(var0 == 3600) {
         if(Client.field1094 == 0) {
            class82.intStack[++class82.intStackSize - 1] = -2;
         } else if(Client.field1094 == 1) {
            class82.intStack[++class82.intStackSize - 1] = -1;
         } else {
            class82.intStack[++class82.intStackSize - 1] = Client.friendCount;
         }

         return 1;
      } else {
         int var3;
         if(var0 == 3601) {
            var3 = class82.intStack[--class82.intStackSize];
            if(Client.field1094 == 2 && var3 < Client.friendCount) {
               class82.scriptStringStack[++class35.scriptStringStackSize - 1] = Client.friends[var3].name;
               class82.scriptStringStack[++class35.scriptStringStackSize - 1] = Client.friends[var3].previousName;
            } else {
               class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
               class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 3602) {
            var3 = class82.intStack[--class82.intStackSize];
            if(Client.field1094 == 2 && var3 < Client.friendCount) {
               class82.intStack[++class82.intStackSize - 1] = Client.friends[var3].world;
            } else {
               class82.intStack[++class82.intStackSize - 1] = 0;
            }

            return 1;
         } else if(var0 == 3603) {
            var3 = class82.intStack[--class82.intStackSize];
            if(Client.field1094 == 2 && var3 < Client.friendCount) {
               class82.intStack[++class82.intStackSize - 1] = Client.friends[var3].rank;
            } else {
               class82.intStack[++class82.intStackSize - 1] = 0;
            }

            return 1;
         } else {
            String var11;
            PacketNode var15;
            if(var0 == 3604) {
               var11 = class82.scriptStringStack[--class35.scriptStringStackSize];
               int var4 = class82.intStack[--class82.intStackSize];
               var15 = FileSystem.method4252(ClientPacket.field2396, Client.field888.field1449);
               var15.packetBuffer.putByte(Ignore.getLength(var11) + 1);
               var15.packetBuffer.method3286(var4);
               var15.packetBuffer.putString(var11);
               Client.field888.method1862(var15);
               return 1;
            } else if(var0 == 3605) {
               var11 = class82.scriptStringStack[--class35.scriptStringStackSize];
               class7.method34(var11);
               return 1;
            } else if(var0 == 3606) {
               var11 = class82.scriptStringStack[--class35.scriptStringStackSize];
               GameEngine.method857(var11);
               return 1;
            } else {
               String var7;
               String var8;
               int var13;
               Ignore var16;
               String var20;
               if(var0 == 3607) {
                  var11 = class82.scriptStringStack[--class35.scriptStringStackSize];
                  if(var11 != null) {
                     if((Client.ignoreCount < 100 || Client.field918 == 1) && Client.ignoreCount < 400) {
                        var20 = class221.cleanUsername(var11, PendingSpawn.jagexLoginType);
                        if(var20 != null) {
                           var13 = 0;

                           while(true) {
                              if(var13 >= Client.ignoreCount) {
                                 for(var13 = 0; var13 < Client.friendCount; ++var13) {
                                    Friend var17 = Client.friends[var13];
                                    var7 = class221.cleanUsername(var17.name, PendingSpawn.jagexLoginType);
                                    if(var7 != null && var7.equals(var20)) {
                                       class25.sendGameMessage(31, "", "Please remove " + var11 + " from your friend list first");
                                       return 1;
                                    }

                                    if(var17.previousName != null) {
                                       var8 = class221.cleanUsername(var17.previousName, PendingSpawn.jagexLoginType);
                                       if(var8 != null && var8.equals(var20)) {
                                          class25.sendGameMessage(31, "", "Please remove " + var11 + " from your friend list first");
                                          return 1;
                                       }
                                    }
                                 }

                                 if(class221.cleanUsername(UrlRequest.localPlayer.name, PendingSpawn.jagexLoginType).equals(var20)) {
                                    class25.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
                                 } else {
                                    var15 = FileSystem.method4252(ClientPacket.field2398, Client.field888.field1449);
                                    var15.packetBuffer.putByte(Ignore.getLength(var11));
                                    var15.packetBuffer.putString(var11);
                                    Client.field888.method1862(var15);
                                 }
                                 break;
                              }

                              var16 = Client.ignores[var13];
                              var7 = class221.cleanUsername(var16.name, PendingSpawn.jagexLoginType);
                              if(var7 != null && var7.equals(var20)) {
                                 class25.sendGameMessage(31, "", var11 + " is already on your ignore list");
                                 break;
                              }

                              if(var16.previousName != null) {
                                 var8 = class221.cleanUsername(var16.previousName, PendingSpawn.jagexLoginType);
                                 if(var8 != null && var8.equals(var20)) {
                                    class25.sendGameMessage(31, "", var11 + " is already on your ignore list");
                                    break;
                                 }
                              }

                              ++var13;
                           }
                        }
                     } else {
                        class25.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                     }
                  }

                  return 1;
               } else if(var0 == 3608) {
                  var11 = class82.scriptStringStack[--class35.scriptStringStackSize];
                  if(var11 != null) {
                     var20 = class221.cleanUsername(var11, PendingSpawn.jagexLoginType);
                     if(var20 != null) {
                        for(var13 = 0; var13 < Client.ignoreCount; ++var13) {
                           var16 = Client.ignores[var13];
                           var7 = var16.name;
                           var8 = class221.cleanUsername(var7, PendingSpawn.jagexLoginType);
                           boolean var18;
                           if(var11 != null && var7 != null) {
                              if(!var11.startsWith("#") && !var7.startsWith("#")) {
                                 var18 = var20.equals(var8);
                              } else {
                                 var18 = var11.equals(var7);
                              }
                           } else {
                              var18 = false;
                           }

                           if(var18) {
                              --Client.ignoreCount;

                              for(int var10 = var13; var10 < Client.ignoreCount; ++var10) {
                                 Client.ignores[var10] = Client.ignores[var10 + 1];
                              }

                              Client.field1041 = Client.cycleCntr;
                              PacketNode var14 = FileSystem.method4252(ClientPacket.field2401, Client.field888.field1449);
                              var14.packetBuffer.putByte(Ignore.getLength(var11));
                              var14.packetBuffer.putString(var11);
                              Client.field888.method1862(var14);
                              break;
                           }
                        }
                     }
                  }

                  return 1;
               } else if(var0 == 3609) {
                  var11 = class82.scriptStringStack[--class35.scriptStringStackSize];
                  Permission[] var19 = GroundObject.method2493();

                  for(var13 = 0; var13 < var19.length; ++var13) {
                     Permission var6 = var19[var13];
                     if(var6.field3279 != -1) {
                        int var9 = var6.field3279;
                        var8 = "<img=" + var9 + ">";
                        if(var11.startsWith(var8)) {
                           var11 = var11.substring(6 + Integer.toString(var6.field3279).length());
                           break;
                        }
                     }
                  }

                  class82.intStack[++class82.intStackSize - 1] = class48.isFriended(var11, false)?1:0;
                  return 1;
               } else if(var0 == 3611) {
                  if(Client.clanChatOwner != null) {
                     class82.scriptStringStack[++class35.scriptStringStackSize - 1] = class265.method4657(Client.clanChatOwner);
                  } else {
                     class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 3612) {
                  if(Client.clanChatOwner != null) {
                     class82.intStack[++class82.intStackSize - 1] = class192.clanChatCount;
                  } else {
                     class82.intStack[++class82.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3613) {
                  var3 = class82.intStack[--class82.intStackSize];
                  if(Client.clanChatOwner != null && var3 < class192.clanChatCount) {
                     class82.scriptStringStack[++class35.scriptStringStackSize - 1] = GameEngine.clanMembers[var3].username;
                  } else {
                     class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 3614) {
                  var3 = class82.intStack[--class82.intStackSize];
                  if(Client.clanChatOwner != null && var3 < class192.clanChatCount) {
                     class82.intStack[++class82.intStackSize - 1] = GameEngine.clanMembers[var3].world;
                  } else {
                     class82.intStack[++class82.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3615) {
                  var3 = class82.intStack[--class82.intStackSize];
                  if(Client.clanChatOwner != null && var3 < class192.clanChatCount) {
                     class82.intStack[++class82.intStackSize - 1] = GameEngine.clanMembers[var3].rank;
                  } else {
                     class82.intStack[++class82.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3616) {
                  class82.intStack[++class82.intStackSize - 1] = CollisionData.field2209;
                  return 1;
               } else {
                  PacketNode var12;
                  if(var0 == 3617) {
                     var11 = class82.scriptStringStack[--class35.scriptStringStackSize];
                     if(GameEngine.clanMembers != null) {
                        var12 = FileSystem.method4252(ClientPacket.field2312, Client.field888.field1449);
                        var12.packetBuffer.putByte(Ignore.getLength(var11));
                        var12.packetBuffer.putString(var11);
                        Client.field888.method1862(var12);
                     }

                     return 1;
                  } else if(var0 == 3618) {
                     class82.intStack[++class82.intStackSize - 1] = VertexNormal.clanChatRank;
                     return 1;
                  } else if(var0 == 3619) {
                     var11 = class82.scriptStringStack[--class35.scriptStringStackSize];
                     if(!var11.equals("")) {
                        var12 = FileSystem.method4252(ClientPacket.field2342, Client.field888.field1449);
                        var12.packetBuffer.putByte(Ignore.getLength(var11));
                        var12.packetBuffer.putString(var11);
                        Client.field888.method1862(var12);
                     }

                     return 1;
                  } else if(var0 == 3620) {
                     SceneTilePaint.method2684();
                     return 1;
                  } else if(var0 == 3621) {
                     if(Client.field1094 == 0) {
                        class82.intStack[++class82.intStackSize - 1] = -1;
                     } else {
                        class82.intStack[++class82.intStackSize - 1] = Client.ignoreCount;
                     }

                     return 1;
                  } else if(var0 == 3622) {
                     var3 = class82.intStack[--class82.intStackSize];
                     if(Client.field1094 != 0 && var3 < Client.ignoreCount) {
                        class82.scriptStringStack[++class35.scriptStringStackSize - 1] = Client.ignores[var3].name;
                        class82.scriptStringStack[++class35.scriptStringStackSize - 1] = Client.ignores[var3].previousName;
                     } else {
                        class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
                        class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
                     }

                     return 1;
                  } else if(var0 == 3623) {
                     label403: {
                        var11 = class82.scriptStringStack[--class35.scriptStringStackSize];
                        String var5 = "<img=0>";
                        if(!var11.startsWith(var5)) {
                           var7 = "<img=1>";
                           if(!var11.startsWith(var7)) {
                              break label403;
                           }
                        }

                        var11 = var11.substring(7);
                     }

                     class82.intStack[++class82.intStackSize - 1] = class27.isIgnored(var11)?1:0;
                     return 1;
                  } else if(var0 != 3624) {
                     if(var0 == 3625) {
                        if(Client.clanChatName != null) {
                           class82.scriptStringStack[++class35.scriptStringStackSize - 1] = class265.method4657(Client.clanChatName);
                        } else {
                           class82.scriptStringStack[++class35.scriptStringStackSize - 1] = "";
                        }

                        return 1;
                     } else {
                        return 2;
                     }
                  } else {
                     var3 = class82.intStack[--class82.intStackSize];
                     if(GameEngine.clanMembers != null && var3 < class192.clanChatCount && GameEngine.clanMembers[var3].username.equalsIgnoreCase(UrlRequest.localPlayer.name)) {
                        class82.intStack[++class82.intStackSize - 1] = 1;
                     } else {
                        class82.intStack[++class82.intStackSize - 1] = 0;
                     }

                     return 1;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "(Lbj;III)V",
      garbageValue = "1165271735"
   )
   static void method509(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = Permission.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field1156 = 0;
            var0.actionAnimationDisable = var2;
            var0.field1124 = 0;
         }

         if(var3 == 2) {
            var0.field1124 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || Permission.getAnimation(var1).forcedPriority >= Permission.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field1156 = 0;
         var0.actionAnimationDisable = var2;
         var0.field1124 = 0;
         var0.field1155 = var0.queueSize;
      }

   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "1809213542"
   )
   @Export("addMenuEntry")
   @Hook("addMenuEntry")
   public static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      Varcs.method1806(var0, var1, var2, var3, var4, var5, false);
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "(IIIILks;Lhy;B)V",
      garbageValue = "-55"
   )
   @Export("drawDot")
   static final void drawDot(int var0, int var1, int var2, int var3, SpritePixels var4, class221 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = Graphics3D.SINE[var6];
            int var9 = Graphics3D.COSINE[var6];
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method5215(var10 + var5.field2715 / 2 - var4.maxWidth / 2, var5.field2716 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2715, var5.field2716, var5.field2717, var5.field2714);
            } else {
               var4.drawAt(var0 + var10 + var5.field2715 / 2 - var4.maxWidth / 2, var5.field2716 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }
}
