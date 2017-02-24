import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public class class15 {
   @ObfuscatedName("d")
   static final class15 field169 = new class15();
   @ObfuscatedName("h")
   static final class15 field170 = new class15();
   @ObfuscatedName("p")
   static final class15 field171 = new class15();
   @ObfuscatedName("aw")
   static boolean field173;
   @ObfuscatedName("q")
   static final class15 field177 = new class15();

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)[Lclass177;",
      garbageValue = "1579833388"
   )
   public static class177[] method179() {
      return new class177[]{class177.field2664, class177.field2667, class177.field2673, class177.field2663, class177.field2662, class177.field2665};
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILclass48;ZB)I",
      garbageValue = "82"
   )
   static int method180(int var0, class48 var1, boolean var2) {
      if(var0 == 3600) {
         if(Client.field573 == 0) {
            class32.field747[++class103.field1686 - 1] = -2;
         } else if(Client.field573 == 1) {
            class32.field747[++class103.field1686 - 1] = -1;
         } else {
            class32.field747[++class103.field1686 - 1] = Client.friendCount;
         }

         return 1;
      } else {
         int var3;
         if(var0 == 3601) {
            var3 = class32.field747[--class103.field1686];
            if(Client.field573 == 2 && var3 < Client.friendCount) {
               class32.chatboxSegments[++class32.field749 - 1] = Client.friends[var3].name;
               class32.chatboxSegments[++class32.field749 - 1] = Client.friends[var3].previousName;
            } else {
               class32.chatboxSegments[++class32.field749 - 1] = "";
               class32.chatboxSegments[++class32.field749 - 1] = "";
            }

            return 1;
         } else if(var0 == 3602) {
            var3 = class32.field747[--class103.field1686];
            if(Client.field573 == 2 && var3 < Client.friendCount) {
               class32.field747[++class103.field1686 - 1] = Client.friends[var3].world;
            } else {
               class32.field747[++class103.field1686 - 1] = 0;
            }

            return 1;
         } else if(var0 == 3603) {
            var3 = class32.field747[--class103.field1686];
            if(Client.field573 == 2 && var3 < Client.friendCount) {
               class32.field747[++class103.field1686 - 1] = Client.friends[var3].rank;
            } else {
               class32.field747[++class103.field1686 - 1] = 0;
            }

            return 1;
         } else {
            String var11;
            if(var0 == 3604) {
               var11 = class32.chatboxSegments[--class32.field749];
               int var12 = class32.field747[--class103.field1686];
               class172.method3273(var11, var12);
               return 1;
            } else {
               int var5;
               String var7;
               String var8;
               String var14;
               Ignore var15;
               Friend var16;
               if(var0 == 3605) {
                  var11 = class32.chatboxSegments[--class32.field749];
                  if(null != var11) {
                     if((Client.friendCount < 200 || Client.field427 == 1) && Client.friendCount < 400) {
                        var14 = GroundObject.method1594(var11, MessageNode.field244);
                        if(var14 != null) {
                           var5 = 0;

                           while(true) {
                              if(var5 >= Client.friendCount) {
                                 for(var5 = 0; var5 < Client.ignoreCount; ++var5) {
                                    var15 = Client.ignores[var5];
                                    var7 = GroundObject.method1594(var15.name, MessageNode.field244);
                                    if(var7 != null && var7.equals(var14)) {
                                       class16.sendGameMessage(30, "", "Please remove " + var11 + " from your ignore list first");
                                       return 1;
                                    }

                                    if(null != var15.previousName) {
                                       var8 = GroundObject.method1594(var15.previousName, MessageNode.field244);
                                       if(null != var8 && var8.equals(var14)) {
                                          class16.sendGameMessage(30, "", "Please remove " + var11 + " from your ignore list first");
                                          return 1;
                                       }
                                    }
                                 }

                                 if(GroundObject.method1594(class36.localPlayer.name, MessageNode.field244).equals(var14)) {
                                    class16.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
                                 } else {
                                    Client.field348.method3073(238);
                                    Client.field348.method2918(class119.method2340(var11));
                                    Client.field348.method2824(var11);
                                 }
                                 break;
                              }

                              var16 = Client.friends[var5];
                              var7 = GroundObject.method1594(var16.name, MessageNode.field244);
                              if(var7 != null && var7.equals(var14)) {
                                 class16.sendGameMessage(30, "", var11 + " is already on your friend list");
                                 break;
                              }

                              if(var16.previousName != null) {
                                 var8 = GroundObject.method1594(var16.previousName, MessageNode.field244);
                                 if(var8 != null && var8.equals(var14)) {
                                    class16.sendGameMessage(30, "", var11 + " is already on your friend list");
                                    break;
                                 }
                              }

                              ++var5;
                           }
                        }
                     } else {
                        class16.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                     }
                  }

                  return 1;
               } else {
                  int var10;
                  boolean var17;
                  if(var0 == 3606) {
                     var11 = class32.chatboxSegments[--class32.field749];
                     if(null != var11) {
                        var14 = GroundObject.method1594(var11, MessageNode.field244);
                        if(null != var14) {
                           for(var5 = 0; var5 < Client.friendCount; ++var5) {
                              var16 = Client.friends[var5];
                              var7 = var16.name;
                              var8 = GroundObject.method1594(var7, MessageNode.field244);
                              if(var11 != null && var7 != null) {
                                 if(!var11.startsWith("#") && !var7.startsWith("#")) {
                                    var17 = var14.equals(var8);
                                 } else {
                                    var17 = var11.equals(var7);
                                 }
                              } else {
                                 var17 = false;
                              }

                              if(var17) {
                                 --Client.friendCount;

                                 for(var10 = var5; var10 < Client.friendCount; ++var10) {
                                    Client.friends[var10] = Client.friends[1 + var10];
                                 }

                                 Client.field451 = Client.field490;
                                 Client.field348.method3073(1);
                                 Client.field348.method2918(class119.method2340(var11));
                                 Client.field348.method2824(var11);
                                 break;
                              }
                           }
                        }
                     }

                     return 1;
                  } else if(var0 == 3607) {
                     var11 = class32.chatboxSegments[--class32.field749];
                     if(var11 != null) {
                        if((Client.ignoreCount < 100 || Client.field427 == 1) && Client.ignoreCount < 400) {
                           var14 = GroundObject.method1594(var11, MessageNode.field244);
                           if(var14 != null) {
                              var5 = 0;

                              while(true) {
                                 if(var5 >= Client.ignoreCount) {
                                    for(var5 = 0; var5 < Client.friendCount; ++var5) {
                                       var16 = Client.friends[var5];
                                       var7 = GroundObject.method1594(var16.name, MessageNode.field244);
                                       if(null != var7 && var7.equals(var14)) {
                                          class16.sendGameMessage(31, "", "Please remove " + var11 + " from your friend list first");
                                          return 1;
                                       }

                                       if(var16.previousName != null) {
                                          var8 = GroundObject.method1594(var16.previousName, MessageNode.field244);
                                          if(var8 != null && var8.equals(var14)) {
                                             class16.sendGameMessage(31, "", "Please remove " + var11 + " from your friend list first");
                                             return 1;
                                          }
                                       }
                                    }

                                    if(GroundObject.method1594(class36.localPlayer.name, MessageNode.field244).equals(var14)) {
                                       class16.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
                                    } else {
                                       Client.field348.method3073(105);
                                       Client.field348.method2918(class119.method2340(var11));
                                       Client.field348.method2824(var11);
                                    }
                                    break;
                                 }

                                 var15 = Client.ignores[var5];
                                 var7 = GroundObject.method1594(var15.name, MessageNode.field244);
                                 if(null != var7 && var7.equals(var14)) {
                                    class16.sendGameMessage(31, "", var11 + " is already on your ignore list");
                                    break;
                                 }

                                 if(null != var15.previousName) {
                                    var8 = GroundObject.method1594(var15.previousName, MessageNode.field244);
                                    if(null != var8 && var8.equals(var14)) {
                                       class16.sendGameMessage(31, "", var11 + " is already on your ignore list");
                                       break;
                                    }
                                 }

                                 ++var5;
                              }
                           }
                        } else {
                           class16.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                        }
                     }

                     return 1;
                  } else if(var0 == 3608) {
                     var11 = class32.chatboxSegments[--class32.field749];
                     if(null != var11) {
                        var14 = GroundObject.method1594(var11, MessageNode.field244);
                        if(var14 != null) {
                           for(var5 = 0; var5 < Client.ignoreCount; ++var5) {
                              var15 = Client.ignores[var5];
                              var7 = var15.name;
                              var8 = GroundObject.method1594(var7, MessageNode.field244);
                              if(var11 != null && var7 != null) {
                                 if(!var11.startsWith("#") && !var7.startsWith("#")) {
                                    var17 = var14.equals(var8);
                                 } else {
                                    var17 = var11.equals(var7);
                                 }
                              } else {
                                 var17 = false;
                              }

                              if(var17) {
                                 --Client.ignoreCount;

                                 for(var10 = var5; var10 < Client.ignoreCount; ++var10) {
                                    Client.ignores[var10] = Client.ignores[var10 + 1];
                                 }

                                 Client.field451 = Client.field490;
                                 Client.field348.method3073(150);
                                 Client.field348.method2918(class119.method2340(var11));
                                 Client.field348.method2824(var11);
                                 break;
                              }
                           }
                        }
                     }

                     return 1;
                  } else if(var0 == 3609) {
                     var11 = class32.chatboxSegments[--class32.field749];
                     class177[] var4 = method179();

                     for(var5 = 0; var5 < var4.length; ++var5) {
                        class177 var6 = var4[var5];
                        if(var6.field2669 != -1) {
                           int var9 = var6.field2669;
                           var8 = "<img=" + var9 + ">";
                           if(var11.startsWith(var8)) {
                              var11 = var11.substring(6 + Integer.toString(var6.field2669).length());
                              break;
                           }
                        }
                     }

                     class32.field747[++class103.field1686 - 1] = method183(var11, false)?1:0;
                     return 1;
                  } else if(var0 == 3611) {
                     if(Client.field532 != null) {
                        class32.chatboxSegments[++class32.field749 - 1] = class150.method2805(Client.field532);
                     } else {
                        class32.chatboxSegments[++class32.field749 - 1] = "";
                     }

                     return 1;
                  } else if(var0 == 3612) {
                     if(null != Client.field532) {
                        class32.field747[++class103.field1686 - 1] = Player.clanChatCount;
                     } else {
                        class32.field747[++class103.field1686 - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 3613) {
                     var3 = class32.field747[--class103.field1686];
                     if(Client.field532 != null && var3 < Player.clanChatCount) {
                        class32.chatboxSegments[++class32.field749 - 1] = class72.clanMembers[var3].username;
                     } else {
                        class32.chatboxSegments[++class32.field749 - 1] = "";
                     }

                     return 1;
                  } else if(var0 == 3614) {
                     var3 = class32.field747[--class103.field1686];
                     if(null != Client.field532 && var3 < Player.clanChatCount) {
                        class32.field747[++class103.field1686 - 1] = class72.clanMembers[var3].world;
                     } else {
                        class32.field747[++class103.field1686 - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 3615) {
                     var3 = class32.field747[--class103.field1686];
                     if(null != Client.field532 && var3 < Player.clanChatCount) {
                        class32.field747[++class103.field1686 - 1] = class72.clanMembers[var3].rank;
                     } else {
                        class32.field747[++class103.field1686 - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 3616) {
                     class32.field747[++class103.field1686 - 1] = class115.field1805;
                     return 1;
                  } else if(var0 == 3617) {
                     var11 = class32.chatboxSegments[--class32.field749];
                     if(null != class72.clanMembers) {
                        Client.field348.method3073(194);
                        Client.field348.method2918(class119.method2340(var11));
                        Client.field348.method2824(var11);
                     }

                     return 1;
                  } else if(var0 == 3618) {
                     class32.field747[++class103.field1686 - 1] = ObjectComposition.field2942;
                     return 1;
                  } else if(var0 == 3619) {
                     var11 = class32.chatboxSegments[--class32.field749];
                     if(!var11.equals("")) {
                        Client.field348.method3073(152);
                        Client.field348.method2918(class119.method2340(var11));
                        Client.field348.method2824(var11);
                     }

                     return 1;
                  } else if(var0 == 3620) {
                     XClanMember.method253();
                     return 1;
                  } else if(var0 == 3621) {
                     if(Client.field573 == 0) {
                        class32.field747[++class103.field1686 - 1] = -1;
                     } else {
                        class32.field747[++class103.field1686 - 1] = Client.ignoreCount;
                     }

                     return 1;
                  } else if(var0 == 3622) {
                     var3 = class32.field747[--class103.field1686];
                     if(Client.field573 != 0 && var3 < Client.ignoreCount) {
                        class32.chatboxSegments[++class32.field749 - 1] = Client.ignores[var3].name;
                        class32.chatboxSegments[++class32.field749 - 1] = Client.ignores[var3].previousName;
                     } else {
                        class32.chatboxSegments[++class32.field749 - 1] = "";
                        class32.chatboxSegments[++class32.field749 - 1] = "";
                     }

                     return 1;
                  } else if(var0 == 3623) {
                     label609: {
                        var11 = class32.chatboxSegments[--class32.field749];
                        String var13 = "<img=0>";
                        if(!var11.startsWith(var13)) {
                           var7 = "<img=1>";
                           if(!var11.startsWith(var7)) {
                              break label609;
                           }
                        }

                        var11 = var11.substring(7);
                     }

                     class32.field747[++class103.field1686 - 1] = Ignore.method206(var11)?1:0;
                     return 1;
                  } else if(var0 != 3624) {
                     if(var0 == 3625) {
                        if(null != Client.clanChatOwner) {
                           class32.chatboxSegments[++class32.field749 - 1] = class150.method2805(Client.clanChatOwner);
                        } else {
                           class32.chatboxSegments[++class32.field749 - 1] = "";
                        }

                        return 1;
                     } else {
                        return 2;
                     }
                  } else {
                     var3 = class32.field747[--class103.field1686];
                     if(class72.clanMembers != null && var3 < Player.clanChatCount && class72.clanMembers[var3].username.equalsIgnoreCase(class36.localPlayer.name)) {
                        class32.field747[++class103.field1686 - 1] = 1;
                     } else {
                        class32.field747[++class103.field1686 - 1] = 0;
                     }

                     return 1;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "473595096"
   )
   static final void method181(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class10.tileHeights[var0][var1 + var3][var4 + var2] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class10.tileHeights[var0][var1][var3 + var2] = class10.tileHeights[var0][var1 - 1][var2 + var3];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class10.tileHeights[var0][var1 + var3][var2] = class10.tileHeights[var0][var3 + var1][var2 - 1];
         }
      }

      if(var1 > 0 && class10.tileHeights[var0][var1 - 1][var2] != 0) {
         class10.tileHeights[var0][var1][var2] = class10.tileHeights[var0][var1 - 1][var2];
      } else if(var2 > 0 && class10.tileHeights[var0][var1][var2 - 1] != 0) {
         class10.tileHeights[var0][var1][var2] = class10.tileHeights[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class10.tileHeights[var0][var1 - 1][var2 - 1] != 0) {
         class10.tileHeights[var0][var1][var2] = class10.tileHeights[var0][var1 - 1][var2 - 1];
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)J",
      garbageValue = "20"
   )
   static long method182(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 65 && var5 <= 90) {
            var1 += (long)(1 + var5 - 65);
         } else if(var5 >= 97 && var5 <= 122) {
            var1 += (long)(1 + var5 - 97);
         } else if(var5 >= 48 && var5 <= 57) {
            var1 += (long)(27 + var5 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(var1 % 37L == 0L && 0L != var1) {
         var1 /= 37L;
      }

      return var1;
   }

   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "2146233668"
   )
   static boolean method183(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = GroundObject.method1594(var0, MessageNode.field244);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(GroundObject.method1594(Client.friends[var3].name, MessageNode.field244)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(GroundObject.method1594(class36.localPlayer.name, MessageNode.field244))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "572892400"
   )
   public static void method184() {
      NPCComposition.field3004.reset();
      NPCComposition.npcModelCache.reset();
   }
}
