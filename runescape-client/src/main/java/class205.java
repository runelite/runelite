import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
public class class205 extends Node {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 871227759
   )
   int field2554;
   @ObfuscatedName("m")
   class207 field2555;
   @ObfuscatedName("t")
   class202 field2557;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -127279831
   )
   int field2558;
   @ObfuscatedName("e")
   class107 field2559;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1399795853
   )
   int field2560;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1671288737
   )
   int field2561;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -208872177
   )
   int field2562;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -819412185
   )
   int field2563;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1230166401
   )
   int field2564;
   @ObfuscatedName("r")
   class117 field2565;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1962620881
   )
   int field2566;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1394897813
   )
   int field2567;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1054924967
   )
   int field2568;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 898252365
   )
   int field2569;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1150938243
   )
   int field2570;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1222325269
   )
   int field2571;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -249745095
   )
   int field2572;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1406518677
   )
   int field2573;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1846264799
   )
   int field2574;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1901286011
   )
   int field2575;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1032280438"
   )
   static int method3703(int var0, Script var1, boolean var2) {
      if(var0 == 3600) {
         if(Client.field1172 == 0) {
            class83.intStack[++class83.intStackSize - 1] = -2;
         } else if(Client.field1172 == 1) {
            class83.intStack[++class83.intStackSize - 1] = -1;
         } else {
            class83.intStack[++class83.intStackSize - 1] = Client.friendCount;
         }

         return 1;
      } else {
         int var3;
         if(var0 == 3601) {
            var3 = class83.intStack[--class83.intStackSize];
            if(Client.field1172 == 2 && var3 < Client.friendCount) {
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = Client.friends[var3].name;
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = Client.friends[var3].previousName;
            } else {
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
               class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 3602) {
            var3 = class83.intStack[--class83.intStackSize];
            if(Client.field1172 == 2 && var3 < Client.friendCount) {
               class83.intStack[++class83.intStackSize - 1] = Client.friends[var3].world;
            } else {
               class83.intStack[++class83.intStackSize - 1] = 0;
            }

            return 1;
         } else if(var0 == 3603) {
            var3 = class83.intStack[--class83.intStackSize];
            if(Client.field1172 == 2 && var3 < Client.friendCount) {
               class83.intStack[++class83.intStackSize - 1] = Client.friends[var3].rank;
            } else {
               class83.intStack[++class83.intStackSize - 1] = 0;
            }

            return 1;
         } else {
            String var4;
            int var5;
            if(var0 == 3604) {
               var4 = class83.scriptStringStack[--class24.scriptStringStackSize];
               var5 = class83.intStack[--class83.intStackSize];
               class169.method3003(var4, var5);
               return 1;
            } else {
               Friend var6;
               String var7;
               String var8;
               String var9;
               if(var0 == 3605) {
                  var4 = class83.scriptStringStack[--class24.scriptStringStackSize];
                  if(var4 != null) {
                     if((Client.friendCount < 200 || Client.field1176 == 1) && Client.friendCount < 400) {
                        var9 = class109.method1965(var4, class33.field482);
                        if(var9 != null) {
                           var5 = 0;

                           while(true) {
                              if(var5 >= Client.friendCount) {
                                 for(var5 = 0; var5 < Client.ignoreCount; ++var5) {
                                    Ignore var15 = Client.ignores[var5];
                                    var8 = class109.method1965(var15.name, class33.field482);
                                    if(var8 != null && var8.equals(var9)) {
                                       class5.sendGameMessage(30, "", "Please remove " + var4 + " from your ignore list first");
                                       return 1;
                                    }

                                    if(var15.previousName != null) {
                                       var7 = class109.method1965(var15.previousName, class33.field482);
                                       if(var7 != null && var7.equals(var9)) {
                                          class5.sendGameMessage(30, "", "Please remove " + var4 + " from your ignore list first");
                                          return 1;
                                       }
                                    }
                                 }

                                 if(class109.method1965(class20.localPlayer.name, class33.field482).equals(var9)) {
                                    class5.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
                                 } else {
                                    Client.secretPacketBuffer1.putOpcode(186);
                                    Client.secretPacketBuffer1.putByte(Friend.method1023(var4));
                                    Client.secretPacketBuffer1.method3125(var4);
                                 }
                                 break;
                              }

                              var6 = Client.friends[var5];
                              var8 = class109.method1965(var6.name, class33.field482);
                              if(var8 != null && var8.equals(var9)) {
                                 class5.sendGameMessage(30, "", var4 + " is already on your friend list");
                                 break;
                              }

                              if(var6.previousName != null) {
                                 var7 = class109.method1965(var6.previousName, class33.field482);
                                 if(var7 != null && var7.equals(var9)) {
                                    class5.sendGameMessage(30, "", var4 + " is already on your friend list");
                                    break;
                                 }
                              }

                              ++var5;
                           }
                        }
                     } else {
                        class5.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                     }
                  }

                  return 1;
               } else if(var0 == 3606) {
                  var4 = class83.scriptStringStack[--class24.scriptStringStackSize];
                  if(var4 != null) {
                     var9 = class109.method1965(var4, class33.field482);
                     if(var9 != null) {
                        for(var5 = 0; var5 < Client.friendCount; ++var5) {
                           var6 = Client.friends[var5];
                           var8 = var6.name;
                           var7 = class109.method1965(var8, class33.field482);
                           if(class269.method4758(var4, var9, var8, var7)) {
                              --Client.friendCount;

                              for(int var14 = var5; var14 < Client.friendCount; ++var14) {
                                 Client.friends[var14] = Client.friends[var14 + 1];
                              }

                              Client.field1099 = Client.field1091;
                              Client.secretPacketBuffer1.putOpcode(22);
                              Client.secretPacketBuffer1.putByte(Friend.method1023(var4));
                              Client.secretPacketBuffer1.method3125(var4);
                              break;
                           }
                        }
                     }
                  }

                  return 1;
               } else if(var0 == 3607) {
                  var4 = class83.scriptStringStack[--class24.scriptStringStackSize];
                  ItemLayer.method2307(var4, false);
                  return 1;
               } else if(var0 == 3608) {
                  var4 = class83.scriptStringStack[--class24.scriptStringStackSize];
                  class211.method3820(var4);
                  return 1;
               } else if(var0 == 3609) {
                  var4 = class83.scriptStringStack[--class24.scriptStringStackSize];
                  class230[] var10 = new class230[]{class230.field3180, class230.field3178, class230.field3187, class230.field3182, class230.field3179, class230.field3181};
                  class230[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     class230 var13 = var11[var12];
                     if(var13.field3184 != -1 && var4.startsWith(RSCanvas.method741(var13.field3184))) {
                        var4 = var4.substring(Integer.toString(var13.field3184).length() + 6);
                        break;
                     }
                  }

                  class83.intStack[++class83.intStackSize - 1] = class162.method2946(var4, false)?1:0;
                  return 1;
               } else if(var0 == 3611) {
                  if(Client.clanChatOwner != null) {
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = class1.method2(Client.clanChatOwner);
                  } else {
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 3612) {
                  if(Client.clanChatOwner != null) {
                     class83.intStack[++class83.intStackSize - 1] = XGrandExchangeOffer.clanChatCount;
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3613) {
                  var3 = class83.intStack[--class83.intStackSize];
                  if(Client.clanChatOwner != null && var3 < XGrandExchangeOffer.clanChatCount) {
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = class177.clanMembers[var3].username;
                  } else {
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 3614) {
                  var3 = class83.intStack[--class83.intStackSize];
                  if(Client.clanChatOwner != null && var3 < XGrandExchangeOffer.clanChatCount) {
                     class83.intStack[++class83.intStackSize - 1] = class177.clanMembers[var3].world;
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3615) {
                  var3 = class83.intStack[--class83.intStackSize];
                  if(Client.clanChatOwner != null && var3 < XGrandExchangeOffer.clanChatCount) {
                     class83.intStack[++class83.intStackSize - 1] = class177.clanMembers[var3].rank;
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3616) {
                  class83.intStack[++class83.intStackSize - 1] = class22.field359;
                  return 1;
               } else if(var0 == 3617) {
                  var4 = class83.scriptStringStack[--class24.scriptStringStackSize];
                  Client.method1358(var4);
                  return 1;
               } else if(var0 == 3618) {
                  class83.intStack[++class83.intStackSize - 1] = class226.clanChatRank;
                  return 1;
               } else if(var0 == 3619) {
                  var4 = class83.scriptStringStack[--class24.scriptStringStackSize];
                  CombatInfoListHolder.method1584(var4);
                  return 1;
               } else if(var0 == 3620) {
                  MessageNode.method1056();
                  return 1;
               } else if(var0 == 3621) {
                  if(Client.field1172 == 0) {
                     class83.intStack[++class83.intStackSize - 1] = -1;
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = Client.ignoreCount;
                  }

                  return 1;
               } else if(var0 == 3622) {
                  var3 = class83.intStack[--class83.intStackSize];
                  if(Client.field1172 != 0 && var3 < Client.ignoreCount) {
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = Client.ignores[var3].name;
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = Client.ignores[var3].previousName;
                  } else {
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                     class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 3623) {
                  var4 = class83.scriptStringStack[--class24.scriptStringStackSize];
                  if(var4.startsWith(RSCanvas.method741(0)) || var4.startsWith(RSCanvas.method741(1))) {
                     var4 = var4.substring(7);
                  }

                  class83.intStack[++class83.intStackSize - 1] = class87.method1604(var4)?1:0;
                  return 1;
               } else if(var0 != 3624) {
                  if(var0 == 3625) {
                     if(Client.clanChatName != null) {
                        class83.scriptStringStack[++class24.scriptStringStackSize - 1] = class1.method2(Client.clanChatName);
                     } else {
                        class83.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                     }

                     return 1;
                  } else {
                     return 2;
                  }
               } else {
                  var3 = class83.intStack[--class83.intStackSize];
                  if(class177.clanMembers != null && var3 < XGrandExchangeOffer.clanChatCount && class177.clanMembers[var3].username.equalsIgnoreCase(class20.localPlayer.name)) {
                     class83.intStack[++class83.intStackSize - 1] = 1;
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = 0;
                  }

                  return 1;
               }
            }
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;II)I",
      garbageValue = "276469879"
   )
   public static int method3705(CharSequence var0, CharSequence var1, int var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      byte var7 = 0;
      byte var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if(var5 - var7 >= var3) {
            return -1;
         }

         if(var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if(var7 != 0) {
            var9 = (char)var7;
            boolean var10 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var14;
         if(var8 != 0) {
            var14 = (char)var8;
            boolean var11 = false;
         } else {
            var14 = var1.charAt(var6++);
         }

         byte var16;
         if(var9 == 198) {
            var16 = 69;
         } else if(var9 == 230) {
            var16 = 101;
         } else if(var9 == 223) {
            var16 = 115;
         } else if(var9 == 338) {
            var16 = 69;
         } else if(var9 == 339) {
            var16 = 101;
         } else {
            var16 = 0;
         }

         var7 = var16;
         byte var12;
         if(var14 == 198) {
            var12 = 69;
         } else if(var14 == 230) {
            var12 = 101;
         } else if(var14 == 223) {
            var12 = 115;
         } else if(var14 == 338) {
            var12 = 69;
         } else if(var14 == 339) {
            var12 = 101;
         } else {
            var12 = 0;
         }

         var8 = var12;
         var9 = PendingSpawn.method1435(var9, var2);
         var14 = PendingSpawn.method1435(var14, var2);
         if(var9 != var14 && Character.toUpperCase(var9) != Character.toUpperCase(var14)) {
            var9 = Character.toLowerCase(var9);
            var14 = Character.toLowerCase(var14);
            if(var14 != var9) {
               return Renderable.method2756(var9, var2) - Renderable.method2756(var14, var2);
            }
         }
      }

      int var15 = Math.min(var3, var4);

      int var17;
      char var18;
      for(var17 = 0; var17 < var15; ++var17) {
         char var19 = var0.charAt(var17);
         var18 = var1.charAt(var17);
         if(var19 != var18 && Character.toUpperCase(var19) != Character.toUpperCase(var18)) {
            var19 = Character.toLowerCase(var19);
            var18 = Character.toLowerCase(var18);
            if(var18 != var19) {
               return Renderable.method2756(var19, var2) - Renderable.method2756(var18, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var20 = 0; var20 < var15; ++var20) {
            var18 = var0.charAt(var20);
            char var13 = var1.charAt(var20);
            if(var13 != var18) {
               return Renderable.method2756(var18, var2) - Renderable.method2756(var13, var2);
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "513127625"
   )
   static final void method3706(Actor var0, int var1) {
      class152.method2815(var0.x, var0.y, var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "49"
   )
   void method3707() {
      this.field2555 = null;
      this.field2559 = null;
      this.field2557 = null;
      this.field2565 = null;
   }
}
