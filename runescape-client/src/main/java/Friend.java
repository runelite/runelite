import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1238224047
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("c")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("t")
   boolean field152;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -963256029
   )
   @Export("world")
   int world;
   @ObfuscatedName("u")
   public static short[] field155;
   @ObfuscatedName("ai")
   static class102 field156;
   @ObfuscatedName("lv")
   static class220 field157;
   @ObfuscatedName("p")
   boolean field159;
   @ObfuscatedName("cq")
   @Export("rssocket")
   static RSSocket rssocket;
   @ObfuscatedName("d")
   @Export("name")
   String name;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "8"
   )
   static int method180(int var0, Script var1, boolean var2) {
      Widget var3 = class128.method2364(class32.field720[--class32.field715]);
      if(var0 == 2600) {
         class32.field720[++class32.field715 - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 2601) {
         class32.field720[++class32.field715 - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 2602) {
         class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 2603) {
         class32.field720[++class32.field715 - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 2604) {
         class32.field720[++class32.field715 - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 2605) {
         class32.field720[++class32.field715 - 1] = var3.field2244;
         return 1;
      } else if(var0 == 2606) {
         class32.field720[++class32.field715 - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 2607) {
         class32.field720[++class32.field715 - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 2608) {
         class32.field720[++class32.field715 - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 2609) {
         class32.field720[++class32.field715 - 1] = var3.opacity;
         return 1;
      } else if(var0 == 2610) {
         class32.field720[++class32.field715 - 1] = var3.field2248;
         return 1;
      } else if(var0 == 2611) {
         class32.field720[++class32.field715 - 1] = var3.textColor;
         return 1;
      } else if(var0 == 2612) {
         class32.field720[++class32.field715 - 1] = var3.field2279;
         return 1;
      } else if(var0 == 2613) {
         class32.field720[++class32.field715 - 1] = var3.field2238.vmethod4163();
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1273390526"
   )
   static final void method181(int var0) {
      short var1 = 256;
      class41.field824 += var0 * 128;
      int var2;
      if(class41.field824 > class94.field1580.length) {
         class41.field824 -= class94.field1580.length;
         var2 = (int)(Math.random() * 12.0D);
         class59.method1138(class126.field1909[var2]);
      }

      var2 = 0;
      int var3 = var0 * 128;
      int var4 = (var1 - var0) * 128;

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = class2.field24[var3 + var2] - class94.field1580[var2 + class41.field824 & class94.field1580.length - 1] * var0 / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         class2.field24[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = var5 * 128;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               class2.field24[var6 + var7] = 255;
            } else {
               class2.field24[var7 + var6] = 0;
            }
         }
      }

      if(class41.field822 > 0) {
         class41.field822 -= var0 * 4;
      }

      if(class41.field845 > 0) {
         class41.field845 -= var0 * 4;
      }

      if(class41.field822 == 0 && class41.field845 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class41.field822 = 1024;
         }

         if(var5 == 1) {
            class41.field845 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class41.field820[var5] = class41.field820[var5 + var0];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class41.field820[var5] = (int)(Math.sin((double)class41.field828 / 14.0D) * 16.0D + Math.sin((double)class41.field828 / 15.0D) * 14.0D + Math.sin((double)class41.field828 / 16.0D) * 12.0D);
         ++class41.field828;
      }

      class41.field838 += var0;
      var5 = (var0 + (Client.gameCycle & 1)) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class41.field838 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            class2.field24[var7 + (var8 << 7)] = 192;
         }

         class41.field838 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = var6 * 128;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var9 + var5 < 128) {
                  var7 += class2.field24[var8 + var9 + var5];
               }

               if(var9 - (var5 + 1) >= 0) {
                  var7 -= class2.field24[var8 + var9 - (var5 + 1)];
               }

               if(var9 >= 0) {
                  class133.field1983[var8 + var9] = var7 / (var5 * 2 + 1);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = var8 * 128;
               if(var5 + var8 < var1) {
                  var7 += class133.field1983[var6 + var9 + var5 * 128];
               }

               if(var8 - (var5 + 1) >= 0) {
                  var7 -= class133.field1983[var6 + var9 - (var5 + 1) * 128];
               }

               if(var8 >= 0) {
                  class2.field24[var9 + var6] = var7 / (var5 * 2 + 1);
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-2012330685"
   )
   static int method182(int var0, Script var1, boolean var2) {
      if(var0 == 3600) {
         if(Client.field554 == 0) {
            class32.field720[++class32.field715 - 1] = -2;
         } else if(Client.field554 == 1) {
            class32.field720[++class32.field715 - 1] = -1;
         } else {
            class32.field720[++class32.field715 - 1] = Client.friendCount;
         }

         return 1;
      } else {
         int var3;
         if(var0 == 3601) {
            var3 = class32.field720[--class32.field715];
            if(Client.field554 == 2 && var3 < Client.friendCount) {
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = Client.friends[var3].name;
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = Client.friends[var3].previousName;
            } else {
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 3602) {
            var3 = class32.field720[--class32.field715];
            if(Client.field554 == 2 && var3 < Client.friendCount) {
               class32.field720[++class32.field715 - 1] = Client.friends[var3].world;
            } else {
               class32.field720[++class32.field715 - 1] = 0;
            }

            return 1;
         } else if(var0 == 3603) {
            var3 = class32.field720[--class32.field715];
            if(Client.field554 == 2 && var3 < Client.friendCount) {
               class32.field720[++class32.field715 - 1] = Client.friends[var3].rank;
            } else {
               class32.field720[++class32.field715 - 1] = 0;
            }

            return 1;
         } else {
            String var10;
            if(var0 == 3604) {
               var10 = class32.scriptStringStack[--class32.scriptStringStackSize];
               int var4 = class32.field720[--class32.field715];
               Client.secretPacketBuffer1.putOpcode(91);
               Client.secretPacketBuffer1.putByte(class36.method753(var10) + 1);
               Client.secretPacketBuffer1.method2504(var10);
               Client.secretPacketBuffer1.method2499(var4);
               return 1;
            } else if(var0 == 3605) {
               var10 = class32.scriptStringStack[--class32.scriptStringStackSize];
               class105.method2036(var10);
               return 1;
            } else {
               int var5;
               String var7;
               String var8;
               Friend var13;
               String var14;
               if(var0 == 3606) {
                  var10 = class32.scriptStringStack[--class32.scriptStringStackSize];
                  if(var10 != null) {
                     var14 = class108.method2059(var10, NPC.field757);
                     if(var14 != null) {
                        for(var5 = 0; var5 < Client.friendCount; ++var5) {
                           var13 = Client.friends[var5];
                           var7 = var13.name;
                           var8 = class108.method2059(var7, NPC.field757);
                           if(TextureProvider.method1474(var10, var14, var7, var8)) {
                              --Client.friendCount;

                              for(int var9 = var5; var9 < Client.friendCount; ++var9) {
                                 Client.friends[var9] = Client.friends[var9 + 1];
                              }

                              Client.field478 = Client.field311;
                              Client.secretPacketBuffer1.putOpcode(22);
                              Client.secretPacketBuffer1.putByte(class36.method753(var10));
                              Client.secretPacketBuffer1.method2504(var10);
                              break;
                           }
                        }
                     }
                  }

                  return 1;
               } else if(var0 == 3607) {
                  var10 = class32.scriptStringStack[--class32.scriptStringStackSize];
                  if(var10 != null) {
                     if((Client.ignoreCount < 100 || Client.field406 == 1) && Client.ignoreCount < 400) {
                        var14 = class108.method2059(var10, NPC.field757);
                        if(var14 != null) {
                           var5 = 0;

                           while(true) {
                              if(var5 >= Client.ignoreCount) {
                                 for(var5 = 0; var5 < Client.friendCount; ++var5) {
                                    var13 = Client.friends[var5];
                                    var7 = class108.method2059(var13.name, NPC.field757);
                                    if(var7 != null && var7.equals(var14)) {
                                       WidgetNode.sendGameMessage(31, "", "Please remove " + var10 + " from your friend list first");
                                       return 1;
                                    }

                                    if(var13.previousName != null) {
                                       var8 = class108.method2059(var13.previousName, NPC.field757);
                                       if(var8 != null && var8.equals(var14)) {
                                          WidgetNode.sendGameMessage(31, "", "Please remove " + var10 + " from your friend list first");
                                          return 1;
                                       }
                                    }
                                 }

                                 if(class108.method2059(class22.localPlayer.name, NPC.field757).equals(var14)) {
                                    WidgetNode.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
                                 } else {
                                    Client.secretPacketBuffer1.putOpcode(47);
                                    Client.secretPacketBuffer1.putByte(class36.method753(var10));
                                    Client.secretPacketBuffer1.method2504(var10);
                                 }
                                 break;
                              }

                              Ignore var12 = Client.ignores[var5];
                              var7 = class108.method2059(var12.name, NPC.field757);
                              if(var7 != null && var7.equals(var14)) {
                                 WidgetNode.sendGameMessage(31, "", var10 + " is already on your ignore list");
                                 break;
                              }

                              if(var12.previousName != null) {
                                 var8 = class108.method2059(var12.previousName, NPC.field757);
                                 if(var8 != null && var8.equals(var14)) {
                                    WidgetNode.sendGameMessage(31, "", var10 + " is already on your ignore list");
                                    break;
                                 }
                              }

                              ++var5;
                           }
                        }
                     } else {
                        WidgetNode.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                     }
                  }

                  return 1;
               } else if(var0 == 3608) {
                  var10 = class32.scriptStringStack[--class32.scriptStringStackSize];
                  class118.method2290(var10);
                  return 1;
               } else if(var0 == 3609) {
                  var10 = class32.scriptStringStack[--class32.scriptStringStackSize];
                  class179[] var11 = ItemLayer.method1475();

                  for(var5 = 0; var5 < var11.length; ++var5) {
                     class179 var6 = var11[var5];
                     if(var6.field2661 != -1 && var10.startsWith(TextureProvider.method1472(var6.field2661))) {
                        var10 = var10.substring(Integer.toString(var6.field2661).length() + 6);
                        break;
                     }
                  }

                  class32.field720[++class32.field715 - 1] = WidgetNode.method199(var10, false)?1:0;
                  return 1;
               } else if(var0 == 3611) {
                  if(Client.field485 != null) {
                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = class103.method1963(Client.field485);
                  } else {
                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 3612) {
                  if(Client.field485 != null) {
                     class32.field720[++class32.field715 - 1] = class85.clanChatCount;
                  } else {
                     class32.field720[++class32.field715 - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3613) {
                  var3 = class32.field720[--class32.field715];
                  if(Client.field485 != null && var3 < class85.clanChatCount) {
                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = Client.clanMembers[var3].username;
                  } else {
                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 3614) {
                  var3 = class32.field720[--class32.field715];
                  if(Client.field485 != null && var3 < class85.clanChatCount) {
                     class32.field720[++class32.field715 - 1] = Client.clanMembers[var3].world;
                  } else {
                     class32.field720[++class32.field715 - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3615) {
                  var3 = class32.field720[--class32.field715];
                  if(Client.field485 != null && var3 < class85.clanChatCount) {
                     class32.field720[++class32.field715 - 1] = Client.clanMembers[var3].rank;
                  } else {
                     class32.field720[++class32.field715 - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3616) {
                  class32.field720[++class32.field715 - 1] = Client.field332;
                  return 1;
               } else if(var0 == 3617) {
                  var10 = class32.scriptStringStack[--class32.scriptStringStackSize];
                  class125.method2354(var10);
                  return 1;
               } else if(var0 == 3618) {
                  class32.field720[++class32.field715 - 1] = Player.field242;
                  return 1;
               } else if(var0 == 3619) {
                  var10 = class32.scriptStringStack[--class32.scriptStringStackSize];
                  World.method640(var10);
                  return 1;
               } else if(var0 == 3620) {
                  Client.secretPacketBuffer1.putOpcode(117);
                  Client.secretPacketBuffer1.putByte(0);
                  return 1;
               } else if(var0 == 3621) {
                  if(Client.field554 == 0) {
                     class32.field720[++class32.field715 - 1] = -1;
                  } else {
                     class32.field720[++class32.field715 - 1] = Client.ignoreCount;
                  }

                  return 1;
               } else if(var0 == 3622) {
                  var3 = class32.field720[--class32.field715];
                  if(Client.field554 != 0 && var3 < Client.ignoreCount) {
                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = Client.ignores[var3].name;
                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = Client.ignores[var3].previousName;
                  } else {
                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 3623) {
                  var10 = class32.scriptStringStack[--class32.scriptStringStackSize];
                  if(var10.startsWith(TextureProvider.method1472(0)) || var10.startsWith(TextureProvider.method1472(1))) {
                     var10 = var10.substring(7);
                  }

                  class32.field720[++class32.field715 - 1] = class2.method27(var10)?1:0;
                  return 1;
               } else if(var0 != 3624) {
                  if(var0 == 3625) {
                     if(Client.clanChatOwner != null) {
                        class32.scriptStringStack[++class32.scriptStringStackSize - 1] = class103.method1963(Client.clanChatOwner);
                     } else {
                        class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                     }

                     return 1;
                  } else {
                     return 2;
                  }
               } else {
                  var3 = class32.field720[--class32.field715];
                  if(Client.clanMembers != null && var3 < class85.clanChatCount && Client.clanMembers[var3].username.equalsIgnoreCase(class22.localPlayer.name)) {
                     class32.field720[++class32.field715 - 1] = 1;
                  } else {
                     class32.field720[++class32.field715 - 1] = 0;
                  }

                  return 1;
               }
            }
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "682221706"
   )
   public static int method183(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "2121530951"
   )
   static String method184(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.field283 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field283 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field283 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field283 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field283 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(Client.field287 != null) {
         var3 = "/p=" + Client.field287;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field286 + "/a=" + class10.field97 + var3 + "/";
   }
}
