import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
public class class252 extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   static NodeCache field3378;
   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "[Lkn;"
   )
   @Export("pkIcons")
   static SpritePixels[] pkIcons;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   public static IndexDataBase field3384;
   @ObfuscatedName("g")
   char field3377;
   @ObfuscatedName("k")
   boolean field3382;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 725861433
   )
   public int field3380;
   @ObfuscatedName("w")
   public String field3381;

   static {
      field3378 = new NodeCache(64);
   }

   class252() {
      this.field3382 = true;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lfh;IB)V",
      garbageValue = "76"
   )
   void method4449(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3377 = Enum.method4494(var1.readByte());
      } else if(var2 == 2) {
         this.field3380 = var1.readInt();
      } else if(var2 == 4) {
         this.field3382 = false;
      } else if(var2 == 5) {
         this.field3381 = var1.readString();
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "992740533"
   )
   void method4452() {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfh;I)V",
      garbageValue = "318454278"
   )
   void method4448(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4449(var1, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-92"
   )
   public boolean method4447() {
      return this.field3377 == 115;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Z",
      garbageValue = "-895076037"
   )
   public static boolean method4461(CharSequence var0) {
      boolean var2 = false;
      boolean var3 = false;
      int var4 = 0;
      int var5 = var0.length();
      int var6 = 0;

      boolean var1;
      while(true) {
         if(var6 >= var5) {
            var1 = var3;
            break;
         }

         label83: {
            char var7 = var0.charAt(var6);
            if(var6 == 0) {
               if(var7 == 45) {
                  var2 = true;
                  break label83;
               }

               if(var7 == 43) {
                  break label83;
               }
            }

            int var9;
            if(var7 >= 48 && var7 <= 57) {
               var9 = var7 - 48;
            } else if(var7 >= 65 && var7 <= 90) {
               var9 = var7 - 55;
            } else {
               if(var7 < 97 || var7 > 122) {
                  var1 = false;
                  break;
               }

               var9 = var7 - 87;
            }

            if(var9 >= 10) {
               var1 = false;
               break;
            }

            if(var2) {
               var9 = -var9;
            }

            int var8 = var4 * 10 + var9;
            if(var4 != var8 / 10) {
               var1 = false;
               break;
            }

            var4 = var8;
            var3 = true;
         }

         ++var6;
      }

      return var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILcc;ZI)I",
      garbageValue = "36939268"
   )
   static int method4462(int var0, Script var1, boolean var2) {
      if(var0 < 1000) {
         return MilliTimer.method2955(var0, var1, var2);
      } else if(var0 < 1100) {
         return class66.method1091(var0, var1, var2);
      } else if(var0 < 1200) {
         return FaceNormal.method2909(var0, var1, var2);
      } else if(var0 < 1300) {
         return class23.method174(var0, var1, var2);
      } else if(var0 < 1400) {
         return class10.method51(var0, var1, var2);
      } else if(var0 < 1500) {
         return class31.method281(var0, var1, var2);
      } else if(var0 < 1600) {
         return class5.method15(var0, var1, var2);
      } else if(var0 < 1700) {
         return MessageNode.method1125(var0, var1, var2);
      } else {
         byte var3;
         Widget var29;
         if(var0 < 1800) {
            var29 = var2?class269.field3661:DecorativeObject.field2164;
            if(var0 == 1700) {
               class84.intStack[++class84.intStackSize - 1] = var29.itemId;
               var3 = 1;
            } else if(var0 == 1701) {
               if(var29.itemId != -1) {
                  class84.intStack[++class84.intStackSize - 1] = var29.itemQuantity;
               } else {
                  class84.intStack[++class84.intStackSize - 1] = 0;
               }

               var3 = 1;
            } else if(var0 == 1702) {
               class84.intStack[++class84.intStackSize - 1] = var29.index;
               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 1900) {
            return class82.method1611(var0, var1, var2);
         } else if(var0 < 2000) {
            return RSCanvas.method787(var0, var1, var2);
         } else if(var0 < 2100) {
            return class66.method1091(var0, var1, var2);
         } else if(var0 < 2200) {
            return FaceNormal.method2909(var0, var1, var2);
         } else if(var0 < 2300) {
            return class23.method174(var0, var1, var2);
         } else if(var0 < 2400) {
            return class10.method51(var0, var1, var2);
         } else if(var0 < 2500) {
            return class31.method281(var0, var1, var2);
         } else if(var0 < 2600) {
            return class74.method1139(var0, var1, var2);
         } else {
            Widget var52;
            if(var0 < 2700) {
               var52 = class266.method4862(class84.intStack[--class84.intStackSize]);
               if(var0 == 2600) {
                  class84.intStack[++class84.intStackSize - 1] = var52.scrollX;
                  var3 = 1;
               } else if(var0 == 2601) {
                  class84.intStack[++class84.intStackSize - 1] = var52.scrollY;
                  var3 = 1;
               } else if(var0 == 2602) {
                  class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var52.text;
                  var3 = 1;
               } else if(var0 == 2603) {
                  class84.intStack[++class84.intStackSize - 1] = var52.scrollWidth;
                  var3 = 1;
               } else if(var0 == 2604) {
                  class84.intStack[++class84.intStackSize - 1] = var52.scrollHeight;
                  var3 = 1;
               } else if(var0 == 2605) {
                  class84.intStack[++class84.intStackSize - 1] = var52.modelZoom;
                  var3 = 1;
               } else if(var0 == 2606) {
                  class84.intStack[++class84.intStackSize - 1] = var52.rotationX;
                  var3 = 1;
               } else if(var0 == 2607) {
                  class84.intStack[++class84.intStackSize - 1] = var52.rotationY;
                  var3 = 1;
               } else if(var0 == 2608) {
                  class84.intStack[++class84.intStackSize - 1] = var52.rotationZ;
                  var3 = 1;
               } else if(var0 == 2609) {
                  class84.intStack[++class84.intStackSize - 1] = var52.opacity;
                  var3 = 1;
               } else if(var0 == 2610) {
                  class84.intStack[++class84.intStackSize - 1] = var52.field2644;
                  var3 = 1;
               } else if(var0 == 2611) {
                  class84.intStack[++class84.intStackSize - 1] = var52.textColor;
                  var3 = 1;
               } else if(var0 == 2612) {
                  class84.intStack[++class84.intStackSize - 1] = var52.field2649;
                  var3 = 1;
               } else if(var0 == 2613) {
                  class84.intStack[++class84.intStackSize - 1] = var52.field2653.rsOrdinal();
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 2800) {
               return class45.method652(var0, var1, var2);
            } else {
               int var6;
               int var8;
               int var37;
               int var39;
               if(var0 < 2900) {
                  var52 = class266.method4862(class84.intStack[--class84.intStackSize]);
                  if(var0 == 2800) {
                     int[] var49 = class84.intStack;
                     var6 = ++class84.intStackSize - 1;
                     var8 = class15.getWidgetConfig(var52);
                     var37 = var8 >> 11 & 63;
                     var49[var6] = var37;
                     var3 = 1;
                  } else if(var0 == 2801) {
                     var39 = class84.intStack[--class84.intStackSize];
                     --var39;
                     if(var52.actions != null && var39 < var52.actions.length && var52.actions[var39] != null) {
                        class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var52.actions[var39];
                     } else {
                        class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
                     }

                     var3 = 1;
                  } else if(var0 == 2802) {
                     if(var52.name == null) {
                        class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
                     } else {
                        class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var52.name;
                     }

                     var3 = 1;
                  } else {
                     var3 = 2;
                  }

                  return var3;
               } else if(var0 < 3000) {
                  return RSCanvas.method787(var0, var1, var2);
               } else {
                  int var4;
                  boolean var14;
                  String var25;
                  String var43;
                  String var50;
                  if(var0 < 3200) {
                     if(var0 == 3100) {
                        var43 = class84.scriptStringStack[--class84.scriptStringStackSize];
                        WorldMapType3.sendGameMessage(0, "", var43);
                        var3 = 1;
                     } else if(var0 == 3101) {
                        class84.intStackSize -= 2;
                        class244.method4319(class54.localPlayer, class84.intStack[class84.intStackSize], class84.intStack[class84.intStackSize + 1]);
                        var3 = 1;
                     } else if(var0 == 3103) {
                        class34.method462();
                        var3 = 1;
                     } else if(var0 == 3104) {
                        var43 = class84.scriptStringStack[--class84.scriptStringStackSize];
                        var39 = 0;
                        if(method4461(var43)) {
                           var6 = class245.parseInt(var43, 10, true);
                           var39 = var6;
                        }

                        Client.secretPacketBuffer1.putOpcode(251);
                        Client.secretPacketBuffer1.putInt(var39);
                        var3 = 1;
                     } else if(var0 == 3105) {
                        var43 = class84.scriptStringStack[--class84.scriptStringStackSize];
                        Client.secretPacketBuffer1.putOpcode(34);
                        Client.secretPacketBuffer1.putByte(var43.length() + 1);
                        Client.secretPacketBuffer1.putString(var43);
                        var3 = 1;
                     } else if(var0 == 3106) {
                        var43 = class84.scriptStringStack[--class84.scriptStringStackSize];
                        Client.secretPacketBuffer1.putOpcode(240);
                        Client.secretPacketBuffer1.putByte(var43.length() + 1);
                        Client.secretPacketBuffer1.putString(var43);
                        var3 = 1;
                     } else if(var0 == 3107) {
                        var4 = class84.intStack[--class84.intStackSize];
                        var25 = class84.scriptStringStack[--class84.scriptStringStackSize];
                        class66.method1090(var4, var25);
                        var3 = 1;
                     } else if(var0 == 3108) {
                        class84.intStackSize -= 3;
                        var4 = class84.intStack[class84.intStackSize];
                        var39 = class84.intStack[class84.intStackSize + 1];
                        var6 = class84.intStack[class84.intStackSize + 2];
                        var29 = class266.method4862(var6);
                        class5.method14(var29, var4, var39);
                        var3 = 1;
                     } else if(var0 == 3109) {
                        class84.intStackSize -= 2;
                        var4 = class84.intStack[class84.intStackSize];
                        var39 = class84.intStack[class84.intStackSize + 1];
                        Widget var51 = var2?class269.field3661:DecorativeObject.field2164;
                        class5.method14(var51, var4, var39);
                        var3 = 1;
                     } else if(var0 == 3110) {
                        class51.field645 = class84.intStack[--class84.intStackSize] == 1;
                        var3 = 1;
                     } else if(var0 == 3111) {
                        class84.intStack[++class84.intStackSize - 1] = MilliTimer.preferences.hideRoofs?1:0;
                        var3 = 1;
                     } else if(var0 == 3112) {
                        MilliTimer.preferences.hideRoofs = class84.intStack[--class84.intStackSize] == 1;
                        Projectile.method1782();
                        var3 = 1;
                     } else if(var0 == 3113) {
                        var43 = class84.scriptStringStack[--class84.scriptStringStackSize];
                        var14 = class84.intStack[--class84.intStackSize] == 1;
                        class9.method46(var43, var14, false);
                        var3 = 1;
                     } else if(var0 == 3115) {
                        var4 = class84.intStack[--class84.intStackSize];
                        Client.secretPacketBuffer1.putOpcode(174);
                        Client.secretPacketBuffer1.putShort(var4);
                        var3 = 1;
                     } else if(var0 == 3116) {
                        var4 = class84.intStack[--class84.intStackSize];
                        class84.scriptStringStackSize -= 2;
                        var25 = class84.scriptStringStack[class84.scriptStringStackSize];
                        var50 = class84.scriptStringStack[class84.scriptStringStackSize + 1];
                        if(var25.length() > 500) {
                           var3 = 1;
                        } else if(var50.length() > 500) {
                           var3 = 1;
                        } else {
                           Client.secretPacketBuffer1.putOpcode(212);
                           Client.secretPacketBuffer1.putShort(1 + class45.getLength(var25) + class45.getLength(var50));
                           Client.secretPacketBuffer1.putString(var50);
                           Client.secretPacketBuffer1.method3199(var4);
                           Client.secretPacketBuffer1.putString(var25);
                           var3 = 1;
                        }
                     } else if(var0 == 3117) {
                        Client.field1009 = class84.intStack[--class84.intStackSize] == 1;
                        var3 = 1;
                     } else {
                        var3 = 2;
                     }

                     return var3;
                  } else if(var0 < 3300) {
                     if(var0 == 3200) {
                        class84.intStackSize -= 3;
                        var4 = class84.intStack[class84.intStackSize];
                        var39 = class84.intStack[class84.intStackSize + 1];
                        var6 = class84.intStack[class84.intStackSize + 2];
                        if(Client.field1109 != 0 && var39 != 0 && Client.field1144 < 50) {
                           Client.field1175[Client.field1144] = var4;
                           Client.field1146[Client.field1144] = var39;
                           Client.field1147[Client.field1144] = var6;
                           Client.audioEffects[Client.field1144] = null;
                           Client.field1148[Client.field1144] = 0;
                           ++Client.field1144;
                        }

                        var3 = 1;
                     } else if(var0 == 3201) {
                        var4 = class84.intStack[--class84.intStackSize];
                        if(var4 == -1 && !Client.field1141) {
                           class204.field2486.method3738();
                           class204.field2487 = 1;
                           class204.field2488 = null;
                        } else if(var4 != -1 && var4 != Client.field1140 && Client.field1060 != 0 && !Client.field1141) {
                           IndexData var47 = class244.indexTrack1;
                           var6 = Client.field1060;
                           class204.field2487 = 1;
                           class204.field2488 = var47;
                           class12.field273 = var4;
                           class204.field2489 = 0;
                           class204.field2490 = var6;
                           class33.field472 = false;
                           class204.field2491 = 2;
                        }

                        Client.field1140 = var4;
                        var3 = 1;
                     } else if(var0 == 3202) {
                        class84.intStackSize -= 2;
                        var4 = class84.intStack[class84.intStackSize];
                        var39 = class84.intStack[class84.intStackSize + 1];
                        if(Client.field1060 != 0 && var4 != -1) {
                           WorldMapType1.method276(class33.indexTrack2, var4, 0, Client.field1060, false);
                           Client.field1141 = true;
                        }

                        var3 = 1;
                     } else {
                        var3 = 2;
                     }

                     return var3;
                  } else if(var0 < 3400) {
                     return World.method1595(var0, var1, var2);
                  } else if(var0 < 3500) {
                     return class82.method1619(var0, var1, var2);
                  } else {
                     int var23;
                     if(var0 < 3700) {
                        if(var0 == 3600) {
                           if(Client.field1170 == 0) {
                              class84.intStack[++class84.intStackSize - 1] = -2;
                           } else if(Client.field1170 == 1) {
                              class84.intStack[++class84.intStackSize - 1] = -1;
                           } else {
                              class84.intStack[++class84.intStackSize - 1] = Client.friendCount;
                           }

                           var3 = 1;
                        } else if(var0 == 3601) {
                           var4 = class84.intStack[--class84.intStackSize];
                           if(Client.field1170 == 2 && var4 < Client.friendCount) {
                              class84.scriptStringStack[++class84.scriptStringStackSize - 1] = Client.friends[var4].name;
                              class84.scriptStringStack[++class84.scriptStringStackSize - 1] = Client.friends[var4].previousName;
                           } else {
                              class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
                              class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
                           }

                           var3 = 1;
                        } else if(var0 == 3602) {
                           var4 = class84.intStack[--class84.intStackSize];
                           if(Client.field1170 == 2 && var4 < Client.friendCount) {
                              class84.intStack[++class84.intStackSize - 1] = Client.friends[var4].world;
                           } else {
                              class84.intStack[++class84.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        } else if(var0 == 3603) {
                           var4 = class84.intStack[--class84.intStackSize];
                           if(Client.field1170 == 2 && var4 < Client.friendCount) {
                              class84.intStack[++class84.intStackSize - 1] = Client.friends[var4].rank;
                           } else {
                              class84.intStack[++class84.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        } else if(var0 == 3604) {
                           var43 = class84.scriptStringStack[--class84.scriptStringStackSize];
                           var39 = class84.intStack[--class84.intStackSize];
                           class156.method2987(var43, var39);
                           var3 = 1;
                        } else if(var0 == 3605) {
                           var43 = class84.scriptStringStack[--class84.scriptStringStackSize];
                           class18.method130(var43);
                           var3 = 1;
                        } else if(var0 == 3606) {
                           var43 = class84.scriptStringStack[--class84.scriptStringStackSize];
                           ScriptVarType.method19(var43);
                           var3 = 1;
                        } else if(var0 == 3607) {
                           var43 = class84.scriptStringStack[--class84.scriptStringStackSize];
                           class218.method4054(var43, false);
                           var3 = 1;
                        } else {
                           String var24;
                           String var33;
                           if(var0 == 3608) {
                              var43 = class84.scriptStringStack[--class84.scriptStringStackSize];
                              if(var43 != null) {
                                 var25 = class9.method50(var43, class29.field422);
                                 if(var25 != null) {
                                    for(var6 = 0; var6 < Client.ignoreCount; ++var6) {
                                       Ignore var27 = Client.ignores[var6];
                                       var24 = var27.name;
                                       var33 = class9.method50(var24, class29.field422);
                                       if(class93.method1781(var43, var25, var24, var33)) {
                                          --Client.ignoreCount;

                                          for(var23 = var6; var23 < Client.ignoreCount; ++var23) {
                                             Client.ignores[var23] = Client.ignores[var23 + 1];
                                          }

                                          Client.field1091 = Client.cycleCntr;
                                          Client.secretPacketBuffer1.putOpcode(255);
                                          Client.secretPacketBuffer1.putByte(class45.getLength(var43));
                                          Client.secretPacketBuffer1.putString(var43);
                                          break;
                                       }
                                    }
                                 }
                              }

                              var3 = 1;
                           } else if(var0 == 3609) {
                              var43 = class84.scriptStringStack[--class84.scriptStringStackSize];
                              Permission[] var46 = ScriptEvent.method1111();

                              for(var6 = 0; var6 < var46.length; ++var6) {
                                 Permission var28 = var46[var6];
                                 if(var28.field3158 != -1) {
                                    var23 = var28.field3158;
                                    var33 = "<img=" + var23 + ">";
                                    if(var43.startsWith(var33)) {
                                       var43 = var43.substring(6 + Integer.toString(var28.field3158).length());
                                       break;
                                    }
                                 }
                              }

                              class84.intStack[++class84.intStackSize - 1] = class9.isFriended(var43, false)?1:0;
                              var3 = 1;
                           } else if(var0 == 3611) {
                              if(Client.clanChatOwner != null) {
                                 class84.scriptStringStack[++class84.scriptStringStackSize - 1] = class5.method13(Client.clanChatOwner);
                              } else {
                                 class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else if(var0 == 3612) {
                              if(Client.clanChatOwner != null) {
                                 class84.intStack[++class84.intStackSize - 1] = class5.clanChatCount;
                              } else {
                                 class84.intStack[++class84.intStackSize - 1] = 0;
                              }

                              var3 = 1;
                           } else if(var0 == 3613) {
                              var4 = class84.intStack[--class84.intStackSize];
                              if(Client.clanChatOwner != null && var4 < class5.clanChatCount) {
                                 class84.scriptStringStack[++class84.scriptStringStackSize - 1] = WorldMapData.clanMembers[var4].username;
                              } else {
                                 class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else if(var0 == 3614) {
                              var4 = class84.intStack[--class84.intStackSize];
                              if(Client.clanChatOwner != null && var4 < class5.clanChatCount) {
                                 class84.intStack[++class84.intStackSize - 1] = WorldMapData.clanMembers[var4].world;
                              } else {
                                 class84.intStack[++class84.intStackSize - 1] = 0;
                              }

                              var3 = 1;
                           } else if(var0 == 3615) {
                              var4 = class84.intStack[--class84.intStackSize];
                              if(Client.clanChatOwner != null && var4 < class5.clanChatCount) {
                                 class84.intStack[++class84.intStackSize - 1] = WorldMapData.clanMembers[var4].rank;
                              } else {
                                 class84.intStack[++class84.intStackSize - 1] = 0;
                              }

                              var3 = 1;
                           } else if(var0 == 3616) {
                              class84.intStack[++class84.intStackSize - 1] = Client.field1137;
                              var3 = 1;
                           } else if(var0 == 3617) {
                              var43 = class84.scriptStringStack[--class84.scriptStringStackSize];
                              class36.method499(var43);
                              var3 = 1;
                           } else if(var0 == 3618) {
                              class84.intStack[++class84.intStackSize - 1] = Friend.clanChatRank;
                              var3 = 1;
                           } else if(var0 == 3619) {
                              var43 = class84.scriptStringStack[--class84.scriptStringStackSize];
                              if(!var43.equals("")) {
                                 Client.secretPacketBuffer1.putOpcode(59);
                                 Client.secretPacketBuffer1.putByte(class45.getLength(var43));
                                 Client.secretPacketBuffer1.putString(var43);
                              }

                              var3 = 1;
                           } else if(var0 == 3620) {
                              class88.method1728();
                              var3 = 1;
                           } else if(var0 == 3621) {
                              if(Client.field1170 == 0) {
                                 class84.intStack[++class84.intStackSize - 1] = -1;
                              } else {
                                 class84.intStack[++class84.intStackSize - 1] = Client.ignoreCount;
                              }

                              var3 = 1;
                           } else if(var0 == 3622) {
                              var4 = class84.intStack[--class84.intStackSize];
                              if(Client.field1170 != 0 && var4 < Client.ignoreCount) {
                                 class84.scriptStringStack[++class84.scriptStringStackSize - 1] = Client.ignores[var4].name;
                                 class84.scriptStringStack[++class84.scriptStringStackSize - 1] = Client.ignores[var4].previousName;
                              } else {
                                 class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
                                 class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else if(var0 == 3623) {
                              label1580: {
                                 var43 = class84.scriptStringStack[--class84.scriptStringStackSize];
                                 var50 = "<img=0>";
                                 if(!var43.startsWith(var50)) {
                                    var24 = "<img=1>";
                                    if(!var43.startsWith(var24)) {
                                       break label1580;
                                    }
                                 }

                                 var43 = var43.substring(7);
                              }

                              class84.intStack[++class84.intStackSize - 1] = class23.isIgnored(var43)?1:0;
                              var3 = 1;
                           } else if(var0 == 3624) {
                              var4 = class84.intStack[--class84.intStackSize];
                              if(WorldMapData.clanMembers != null && var4 < class5.clanChatCount && WorldMapData.clanMembers[var4].username.equalsIgnoreCase(class54.localPlayer.name)) {
                                 class84.intStack[++class84.intStackSize - 1] = 1;
                              } else {
                                 class84.intStack[++class84.intStackSize - 1] = 0;
                              }

                              var3 = 1;
                           } else if(var0 == 3625) {
                              if(Client.clanChatName != null) {
                                 class84.scriptStringStack[++class84.scriptStringStackSize - 1] = class5.method13(Client.clanChatName);
                              } else {
                                 class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else {
                              var3 = 2;
                           }
                        }

                        return var3;
                     } else {
                        long var18;
                        boolean var31;
                        if(var0 < 4000) {
                           if(var0 == 3903) {
                              var4 = class84.intStack[--class84.intStackSize];
                              class84.intStack[++class84.intStackSize - 1] = Client.grandExchangeOffers[var4].method101();
                              var3 = 1;
                           } else if(var0 == 3904) {
                              var4 = class84.intStack[--class84.intStackSize];
                              class84.intStack[++class84.intStackSize - 1] = Client.grandExchangeOffers[var4].itemId;
                              var3 = 1;
                           } else if(var0 == 3905) {
                              var4 = class84.intStack[--class84.intStackSize];
                              class84.intStack[++class84.intStackSize - 1] = Client.grandExchangeOffers[var4].price;
                              var3 = 1;
                           } else if(var0 == 3906) {
                              var4 = class84.intStack[--class84.intStackSize];
                              class84.intStack[++class84.intStackSize - 1] = Client.grandExchangeOffers[var4].totalQuantity;
                              var3 = 1;
                           } else if(var0 == 3907) {
                              var4 = class84.intStack[--class84.intStackSize];
                              class84.intStack[++class84.intStackSize - 1] = Client.grandExchangeOffers[var4].quantitySold;
                              var3 = 1;
                           } else if(var0 == 3908) {
                              var4 = class84.intStack[--class84.intStackSize];
                              class84.intStack[++class84.intStackSize - 1] = Client.grandExchangeOffers[var4].spent;
                              var3 = 1;
                           } else if(var0 == 3910) {
                              var4 = class84.intStack[--class84.intStackSize];
                              var39 = Client.grandExchangeOffers[var4].method97();
                              class84.intStack[++class84.intStackSize - 1] = var39 == 0?1:0;
                              var3 = 1;
                           } else if(var0 == 3911) {
                              var4 = class84.intStack[--class84.intStackSize];
                              var39 = Client.grandExchangeOffers[var4].method97();
                              class84.intStack[++class84.intStackSize - 1] = var39 == 2?1:0;
                              var3 = 1;
                           } else if(var0 == 3912) {
                              var4 = class84.intStack[--class84.intStackSize];
                              var39 = Client.grandExchangeOffers[var4].method97();
                              class84.intStack[++class84.intStackSize - 1] = var39 == 5?1:0;
                              var3 = 1;
                           } else if(var0 == 3913) {
                              var4 = class84.intStack[--class84.intStackSize];
                              var39 = Client.grandExchangeOffers[var4].method97();
                              class84.intStack[++class84.intStackSize - 1] = var39 == 1?1:0;
                              var3 = 1;
                           } else if(var0 == 3914) {
                              var31 = class84.intStack[--class84.intStackSize] == 1;
                              if(class170.field2327 != null) {
                                 class170.field2327.method64(class13.field277, var31);
                              }

                              var3 = 1;
                           } else if(var0 == 3915) {
                              var31 = class84.intStack[--class84.intStackSize] == 1;
                              if(class170.field2327 != null) {
                                 class170.field2327.method64(class13.field278, var31);
                              }

                              var3 = 1;
                           } else if(var0 == 3916) {
                              class84.intStackSize -= 2;
                              var31 = class84.intStack[class84.intStackSize] == 1;
                              var14 = class84.intStack[class84.intStackSize + 1] == 1;
                              if(class170.field2327 != null) {
                                 class170.field2327.method64(new class96(var14), var31);
                              }

                              var3 = 1;
                           } else if(var0 == 3917) {
                              var31 = class84.intStack[--class84.intStackSize] == 1;
                              if(class170.field2327 != null) {
                                 class170.field2327.method64(class13.field280, var31);
                              }

                              var3 = 1;
                           } else if(var0 == 3918) {
                              var31 = class84.intStack[--class84.intStackSize] == 1;
                              if(class170.field2327 != null) {
                                 class170.field2327.method64(class13.field285, var31);
                              }

                              var3 = 1;
                           } else if(var0 == 3919) {
                              class84.intStack[++class84.intStackSize - 1] = class170.field2327 == null?0:class170.field2327.field279.size();
                              var3 = 1;
                           } else {
                              class14 var40;
                              if(var0 == 3920) {
                                 var4 = class84.intStack[--class84.intStackSize];
                                 var40 = (class14)class170.field2327.field279.get(var4);
                                 class84.intStack[++class84.intStackSize - 1] = var40.field293;
                                 var3 = 1;
                              } else if(var0 == 3921) {
                                 var4 = class84.intStack[--class84.intStackSize];
                                 var40 = (class14)class170.field2327.field279.get(var4);
                                 class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var40.method71();
                                 var3 = 1;
                              } else if(var0 == 3922) {
                                 var4 = class84.intStack[--class84.intStackSize];
                                 var40 = (class14)class170.field2327.field279.get(var4);
                                 class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var40.method75();
                                 var3 = 1;
                              } else if(var0 == 3923) {
                                 var4 = class84.intStack[--class84.intStackSize];
                                 var40 = (class14)class170.field2327.field279.get(var4);
                                 var18 = class170.currentTimeMs() - class56.field665 - var40.field287;
                                 var8 = (int)(var18 / 3600000L);
                                 int var22 = (int)((var18 - (long)(var8 * 3600000)) / 60000L);
                                 var23 = (int)((var18 - (long)(var8 * 3600000) - (long)(var22 * '\uea60')) / 1000L);
                                 String var34 = var8 + ":" + var22 / 10 + var22 % 10 + ":" + var23 / 10 + var23 % 10;
                                 class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var34;
                                 var3 = 1;
                              } else if(var0 == 3924) {
                                 var4 = class84.intStack[--class84.intStackSize];
                                 var40 = (class14)class170.field2327.field279.get(var4);
                                 class84.intStack[++class84.intStackSize - 1] = var40.field288.totalQuantity;
                                 var3 = 1;
                              } else if(var0 == 3925) {
                                 var4 = class84.intStack[--class84.intStackSize];
                                 var40 = (class14)class170.field2327.field279.get(var4);
                                 class84.intStack[++class84.intStackSize - 1] = var40.field288.price;
                                 var3 = 1;
                              } else if(var0 == 3926) {
                                 var4 = class84.intStack[--class84.intStackSize];
                                 var40 = (class14)class170.field2327.field279.get(var4);
                                 class84.intStack[++class84.intStackSize - 1] = var40.field288.itemId;
                                 var3 = 1;
                              } else {
                                 var3 = 2;
                              }
                           }

                           return var3;
                        } else if(var0 < 4100) {
                           if(var0 == 4000) {
                              class84.intStackSize -= 2;
                              var4 = class84.intStack[class84.intStackSize];
                              var39 = class84.intStack[class84.intStackSize + 1];
                              class84.intStack[++class84.intStackSize - 1] = var39 + var4;
                              var3 = 1;
                           } else if(var0 == 4001) {
                              class84.intStackSize -= 2;
                              var4 = class84.intStack[class84.intStackSize];
                              var39 = class84.intStack[class84.intStackSize + 1];
                              class84.intStack[++class84.intStackSize - 1] = var4 - var39;
                              var3 = 1;
                           } else if(var0 == 4002) {
                              class84.intStackSize -= 2;
                              var4 = class84.intStack[class84.intStackSize];
                              var39 = class84.intStack[class84.intStackSize + 1];
                              class84.intStack[++class84.intStackSize - 1] = var39 * var4;
                              var3 = 1;
                           } else if(var0 == 4003) {
                              class84.intStackSize -= 2;
                              var4 = class84.intStack[class84.intStackSize];
                              var39 = class84.intStack[class84.intStackSize + 1];
                              class84.intStack[++class84.intStackSize - 1] = var4 / var39;
                              var3 = 1;
                           } else if(var0 == 4004) {
                              var4 = class84.intStack[--class84.intStackSize];
                              class84.intStack[++class84.intStackSize - 1] = (int)(Math.random() * (double)var4);
                              var3 = 1;
                           } else if(var0 == 4005) {
                              var4 = class84.intStack[--class84.intStackSize];
                              class84.intStack[++class84.intStackSize - 1] = (int)(Math.random() * (double)(var4 + 1));
                              var3 = 1;
                           } else if(var0 == 4006) {
                              class84.intStackSize -= 5;
                              var4 = class84.intStack[class84.intStackSize];
                              var39 = class84.intStack[class84.intStackSize + 1];
                              var6 = class84.intStack[class84.intStackSize + 2];
                              var37 = class84.intStack[class84.intStackSize + 3];
                              var8 = class84.intStack[class84.intStackSize + 4];
                              class84.intStack[++class84.intStackSize - 1] = var4 + (var39 - var4) * (var8 - var6) / (var37 - var6);
                              var3 = 1;
                           } else if(var0 == 4007) {
                              class84.intStackSize -= 2;
                              var4 = class84.intStack[class84.intStackSize];
                              var39 = class84.intStack[class84.intStackSize + 1];
                              class84.intStack[++class84.intStackSize - 1] = var4 + var4 * var39 / 100;
                              var3 = 1;
                           } else if(var0 == 4008) {
                              class84.intStackSize -= 2;
                              var4 = class84.intStack[class84.intStackSize];
                              var39 = class84.intStack[class84.intStackSize + 1];
                              class84.intStack[++class84.intStackSize - 1] = var4 | 1 << var39;
                              var3 = 1;
                           } else if(var0 == 4009) {
                              class84.intStackSize -= 2;
                              var4 = class84.intStack[class84.intStackSize];
                              var39 = class84.intStack[class84.intStackSize + 1];
                              class84.intStack[++class84.intStackSize - 1] = var4 & -1 - (1 << var39);
                              var3 = 1;
                           } else if(var0 == 4010) {
                              class84.intStackSize -= 2;
                              var4 = class84.intStack[class84.intStackSize];
                              var39 = class84.intStack[class84.intStackSize + 1];
                              class84.intStack[++class84.intStackSize - 1] = (var4 & 1 << var39) != 0?1:0;
                              var3 = 1;
                           } else if(var0 == 4011) {
                              class84.intStackSize -= 2;
                              var4 = class84.intStack[class84.intStackSize];
                              var39 = class84.intStack[class84.intStackSize + 1];
                              class84.intStack[++class84.intStackSize - 1] = var4 % var39;
                              var3 = 1;
                           } else if(var0 == 4012) {
                              class84.intStackSize -= 2;
                              var4 = class84.intStack[class84.intStackSize];
                              var39 = class84.intStack[class84.intStackSize + 1];
                              if(var4 == 0) {
                                 class84.intStack[++class84.intStackSize - 1] = 0;
                              } else {
                                 class84.intStack[++class84.intStackSize - 1] = (int)Math.pow((double)var4, (double)var39);
                              }

                              var3 = 1;
                           } else if(var0 == 4013) {
                              class84.intStackSize -= 2;
                              var4 = class84.intStack[class84.intStackSize];
                              var39 = class84.intStack[class84.intStackSize + 1];
                              if(var4 == 0) {
                                 class84.intStack[++class84.intStackSize - 1] = 0;
                              } else if(var39 == 0) {
                                 class84.intStack[++class84.intStackSize - 1] = Integer.MAX_VALUE;
                              } else {
                                 class84.intStack[++class84.intStackSize - 1] = (int)Math.pow((double)var4, 1.0D / (double)var39);
                              }

                              var3 = 1;
                           } else if(var0 == 4014) {
                              class84.intStackSize -= 2;
                              var4 = class84.intStack[class84.intStackSize];
                              var39 = class84.intStack[class84.intStackSize + 1];
                              class84.intStack[++class84.intStackSize - 1] = var4 & var39;
                              var3 = 1;
                           } else if(var0 == 4015) {
                              class84.intStackSize -= 2;
                              var4 = class84.intStack[class84.intStackSize];
                              var39 = class84.intStack[class84.intStackSize + 1];
                              class84.intStack[++class84.intStackSize - 1] = var4 | var39;
                              var3 = 1;
                           } else if(var0 == 4018) {
                              class84.intStackSize -= 3;
                              long var16 = (long)class84.intStack[class84.intStackSize];
                              var18 = (long)class84.intStack[class84.intStackSize + 1];
                              long var20 = (long)class84.intStack[class84.intStackSize + 2];
                              class84.intStack[++class84.intStackSize - 1] = (int)(var20 * var16 / var18);
                              var3 = 1;
                           } else {
                              var3 = 2;
                           }

                           return var3;
                        } else if(var0 < 4200) {
                           return TextureProvider.method2404(var0, var1, var2);
                        } else if(var0 < 4300) {
                           if(var0 == 4200) {
                              var4 = class84.intStack[--class84.intStackSize];
                              class84.scriptStringStack[++class84.scriptStringStackSize - 1] = ClassInfo.getItemDefinition(var4).name;
                              var3 = 1;
                           } else {
                              ItemComposition var48;
                              if(var0 == 4201) {
                                 class84.intStackSize -= 2;
                                 var4 = class84.intStack[class84.intStackSize];
                                 var39 = class84.intStack[class84.intStackSize + 1];
                                 var48 = ClassInfo.getItemDefinition(var4);
                                 if(var39 >= 1 && var39 <= 5 && var48.groundActions[var39 - 1] != null) {
                                    class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var48.groundActions[var39 - 1];
                                 } else {
                                    class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
                                 }

                                 var3 = 1;
                              } else if(var0 == 4202) {
                                 class84.intStackSize -= 2;
                                 var4 = class84.intStack[class84.intStackSize];
                                 var39 = class84.intStack[class84.intStackSize + 1];
                                 var48 = ClassInfo.getItemDefinition(var4);
                                 if(var39 >= 1 && var39 <= 5 && var48.inventoryActions[var39 - 1] != null) {
                                    class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var48.inventoryActions[var39 - 1];
                                 } else {
                                    class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
                                 }

                                 var3 = 1;
                              } else if(var0 == 4203) {
                                 var4 = class84.intStack[--class84.intStackSize];
                                 class84.intStack[++class84.intStackSize - 1] = ClassInfo.getItemDefinition(var4).price;
                                 var3 = 1;
                              } else if(var0 == 4204) {
                                 var4 = class84.intStack[--class84.intStackSize];
                                 class84.intStack[++class84.intStackSize - 1] = ClassInfo.getItemDefinition(var4).isStackable == 1?1:0;
                                 var3 = 1;
                              } else {
                                 ItemComposition var38;
                                 if(var0 == 4205) {
                                    var4 = class84.intStack[--class84.intStackSize];
                                    var38 = ClassInfo.getItemDefinition(var4);
                                    if(var38.notedTemplate == -1 && var38.note >= 0) {
                                       class84.intStack[++class84.intStackSize - 1] = var38.note;
                                    } else {
                                       class84.intStack[++class84.intStackSize - 1] = var4;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 4206) {
                                    var4 = class84.intStack[--class84.intStackSize];
                                    var38 = ClassInfo.getItemDefinition(var4);
                                    if(var38.notedTemplate >= 0 && var38.note >= 0) {
                                       class84.intStack[++class84.intStackSize - 1] = var38.note;
                                    } else {
                                       class84.intStack[++class84.intStackSize - 1] = var4;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 4207) {
                                    var4 = class84.intStack[--class84.intStackSize];
                                    class84.intStack[++class84.intStackSize - 1] = ClassInfo.getItemDefinition(var4).isMembers?1:0;
                                    var3 = 1;
                                 } else if(var0 == 4208) {
                                    var4 = class84.intStack[--class84.intStackSize];
                                    var38 = ClassInfo.getItemDefinition(var4);
                                    if(var38.field3530 == -1 && var38.field3529 >= 0) {
                                       class84.intStack[++class84.intStackSize - 1] = var38.field3529;
                                    } else {
                                       class84.intStack[++class84.intStackSize - 1] = var4;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 4209) {
                                    var4 = class84.intStack[--class84.intStackSize];
                                    var38 = ClassInfo.getItemDefinition(var4);
                                    if(var38.field3530 >= 0 && var38.field3529 >= 0) {
                                       class84.intStack[++class84.intStackSize - 1] = var38.field3529;
                                    } else {
                                       class84.intStack[++class84.intStackSize - 1] = var4;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 4210) {
                                    var43 = class84.scriptStringStack[--class84.scriptStringStackSize];
                                    var39 = class84.intStack[--class84.intStackSize];
                                    class13.method67(var43, var39 == 1);
                                    class84.intStack[++class84.intStackSize - 1] = class25.field373;
                                    var3 = 1;
                                 } else if(var0 == 4211) {
                                    if(MilliTimer.field2190 != null && WidgetNode.field827 < class25.field373) {
                                       class84.intStack[++class84.intStackSize - 1] = MilliTimer.field2190[++WidgetNode.field827 - 1] & '\uffff';
                                    } else {
                                       class84.intStack[++class84.intStackSize - 1] = -1;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 4212) {
                                    WidgetNode.field827 = 0;
                                    var3 = 1;
                                 } else {
                                    var3 = 2;
                                 }
                              }
                           }

                           return var3;
                        } else if(var0 < 5100) {
                           return XClanMember.method1175(var0, var1, var2);
                        } else if(var0 < 5400) {
                           return class20.method157(var0, var1, var2);
                        } else if(var0 < 5600) {
                           if(var0 == 5504) {
                              class84.intStackSize -= 2;
                              var37 = class84.intStack[class84.intStackSize];
                              var8 = class84.intStack[class84.intStackSize + 1];
                              if(!Client.field939) {
                                 Client.field985 = var37;
                                 Client.mapAngle = var8;
                              }

                              var3 = 1;
                           } else if(var0 == 5505) {
                              class84.intStack[++class84.intStackSize - 1] = Client.field985;
                              var3 = 1;
                           } else if(var0 == 5506) {
                              class84.intStack[++class84.intStackSize - 1] = Client.mapAngle;
                              var3 = 1;
                           } else if(var0 == 5530) {
                              var37 = class84.intStack[--class84.intStackSize];
                              if(var37 < 0) {
                                 var37 = 0;
                              }

                              Client.field978 = var37;
                              var3 = 1;
                           } else if(var0 == 5531) {
                              class84.intStack[++class84.intStackSize - 1] = Client.field978;
                              var3 = 1;
                           } else {
                              var3 = 2;
                           }

                           return var3;
                        } else if(var0 < 5700) {
                           if(var0 == 5630) {
                              Client.field1040 = 250;
                              var3 = 1;
                           } else {
                              var3 = 2;
                           }

                           return var3;
                        } else if(var0 < 6300) {
                           if(var0 == 6200) {
                              class84.intStackSize -= 2;
                              Client.field1183 = (short)class84.intStack[class84.intStackSize];
                              if(Client.field1183 <= 0) {
                                 Client.field1183 = 256;
                              }

                              Client.field1157 = (short)class84.intStack[class84.intStackSize + 1];
                              if(Client.field1157 <= 0) {
                                 Client.field1157 = 205;
                              }

                              var3 = 1;
                           } else if(var0 == 6201) {
                              class84.intStackSize -= 2;
                              Client.field1158 = (short)class84.intStack[class84.intStackSize];
                              if(Client.field1158 <= 0) {
                                 Client.field1158 = 256;
                              }

                              Client.field1062 = (short)class84.intStack[class84.intStackSize + 1];
                              if(Client.field1062 <= 0) {
                                 Client.field1062 = 320;
                              }

                              var3 = 1;
                           } else if(var0 == 6202) {
                              class84.intStackSize -= 4;
                              Client.field964 = (short)class84.intStack[class84.intStackSize];
                              if(Client.field964 <= 0) {
                                 Client.field964 = 1;
                              }

                              Client.field1161 = (short)class84.intStack[class84.intStackSize + 1];
                              if(Client.field1161 <= 0) {
                                 Client.field1161 = 32767;
                              } else if(Client.field1161 < Client.field964) {
                                 Client.field1161 = Client.field964;
                              }

                              Client.field1162 = (short)class84.intStack[class84.intStackSize + 2];
                              if(Client.field1162 <= 0) {
                                 Client.field1162 = 1;
                              }

                              Client.field1163 = (short)class84.intStack[class84.intStackSize + 3];
                              if(Client.field1163 <= 0) {
                                 Client.field1163 = 32767;
                              } else if(Client.field1163 < Client.field1162) {
                                 Client.field1163 = Client.field1162;
                              }

                              var3 = 1;
                           } else if(var0 == 6203) {
                              if(Client.field1169 != null) {
                                 XGrandExchangeOffer.method98(0, 0, Client.field1169.width, Client.field1169.height, false);
                                 class84.intStack[++class84.intStackSize - 1] = Client.viewportHeight;
                                 class84.intStack[++class84.intStackSize - 1] = Client.viewportWidth;
                              } else {
                                 class84.intStack[++class84.intStackSize - 1] = -1;
                                 class84.intStack[++class84.intStackSize - 1] = -1;
                              }

                              var3 = 1;
                           } else if(var0 == 6204) {
                              class84.intStack[++class84.intStackSize - 1] = Client.field1158;
                              class84.intStack[++class84.intStackSize - 1] = Client.field1062;
                              var3 = 1;
                           } else if(var0 == 6205) {
                              class84.intStack[++class84.intStackSize - 1] = Client.field1183;
                              class84.intStack[++class84.intStackSize - 1] = Client.field1157;
                              var3 = 1;
                           } else {
                              var3 = 2;
                           }

                           return var3;
                        } else if(var0 >= 6600) {
                           if(var0 < 6700) {
                              if(var0 == 6600) {
                                 var4 = class29.plane;
                                 var39 = (class54.localPlayer.x >> 7) + class25.baseX;
                                 var6 = (class54.localPlayer.y >> 7) + ScriptEvent.baseY;
                                 class23.method172().method5288(var4, var39, var6, true);
                                 var3 = 1;
                              } else {
                                 WorldMapData var42;
                                 if(var0 == 6601) {
                                    var4 = class84.intStack[--class84.intStackSize];
                                    var25 = "";
                                    var42 = class23.method172().method5249(var4);
                                    if(var42 != null) {
                                       var25 = var42.method294();
                                    }

                                    class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var25;
                                    var3 = 1;
                                 } else if(var0 == 6602) {
                                    var4 = class84.intStack[--class84.intStackSize];
                                    class23.method172().method5234(var4);
                                    var3 = 1;
                                 } else if(var0 == 6603) {
                                    class84.intStack[++class84.intStackSize - 1] = class23.method172().method5397();
                                    var3 = 1;
                                 } else if(var0 == 6604) {
                                    var4 = class84.intStack[--class84.intStackSize];
                                    class23.method172().method5243(var4);
                                    var3 = 1;
                                 } else if(var0 == 6605) {
                                    class84.intStack[++class84.intStackSize - 1] = class23.method172().method5286()?1:0;
                                    var3 = 1;
                                 } else {
                                    Coordinates var36;
                                    if(var0 == 6606) {
                                       var36 = new Coordinates(class84.intStack[--class84.intStackSize]);
                                       class23.method172().method5256(var36.worldX, var36.worldY);
                                       var3 = 1;
                                    } else if(var0 == 6607) {
                                       var36 = new Coordinates(class84.intStack[--class84.intStackSize]);
                                       class23.method172().method5251(var36.worldX, var36.worldY);
                                       var3 = 1;
                                    } else if(var0 == 6608) {
                                       var36 = new Coordinates(class84.intStack[--class84.intStackSize]);
                                       class23.method172().method5274(var36.plane, var36.worldX, var36.worldY);
                                       var3 = 1;
                                    } else if(var0 == 6609) {
                                       var36 = new Coordinates(class84.intStack[--class84.intStackSize]);
                                       class23.method172().method5253(var36.plane, var36.worldX, var36.worldY);
                                       var3 = 1;
                                    } else if(var0 == 6610) {
                                       class84.intStack[++class84.intStackSize - 1] = class23.method172().method5348();
                                       class84.intStack[++class84.intStackSize - 1] = class23.method172().method5297();
                                       var3 = 1;
                                    } else {
                                       WorldMapData var30;
                                       if(var0 == 6611) {
                                          var4 = class84.intStack[--class84.intStackSize];
                                          var30 = class23.method172().method5249(var4);
                                          if(var30 == null) {
                                             class84.intStack[++class84.intStackSize - 1] = 0;
                                          } else {
                                             class84.intStack[++class84.intStackSize - 1] = var30.method311().method3935();
                                          }

                                          var3 = 1;
                                       } else if(var0 == 6612) {
                                          var4 = class84.intStack[--class84.intStackSize];
                                          var30 = class23.method172().method5249(var4);
                                          if(var30 == null) {
                                             class84.intStack[++class84.intStackSize - 1] = 0;
                                             class84.intStack[++class84.intStackSize - 1] = 0;
                                          } else {
                                             class84.intStack[++class84.intStackSize - 1] = (var30.method298() - var30.method297() + 1) * 64;
                                             class84.intStack[++class84.intStackSize - 1] = (var30.method345() - var30.method299() + 1) * 64;
                                          }

                                          var3 = 1;
                                       } else if(var0 == 6613) {
                                          var4 = class84.intStack[--class84.intStackSize];
                                          var30 = class23.method172().method5249(var4);
                                          if(var30 == null) {
                                             class84.intStack[++class84.intStackSize - 1] = 0;
                                             class84.intStack[++class84.intStackSize - 1] = 0;
                                             class84.intStack[++class84.intStackSize - 1] = 0;
                                             class84.intStack[++class84.intStackSize - 1] = 0;
                                          } else {
                                             class84.intStack[++class84.intStackSize - 1] = var30.method297() * 64;
                                             class84.intStack[++class84.intStackSize - 1] = var30.method299() * 64;
                                             class84.intStack[++class84.intStackSize - 1] = var30.method298() * 64 + 64 - 1;
                                             class84.intStack[++class84.intStackSize - 1] = var30.method345() * 64 + 64 - 1;
                                          }

                                          var3 = 1;
                                       } else if(var0 == 6614) {
                                          var4 = class84.intStack[--class84.intStackSize];
                                          var30 = class23.method172().method5249(var4);
                                          if(var30 == null) {
                                             class84.intStack[++class84.intStackSize - 1] = -1;
                                          } else {
                                             class84.intStack[++class84.intStackSize - 1] = var30.method296();
                                          }

                                          var3 = 1;
                                       } else if(var0 == 6615) {
                                          var36 = class23.method172().method5254();
                                          if(var36 == null) {
                                             class84.intStack[++class84.intStackSize - 1] = -1;
                                             class84.intStack[++class84.intStackSize - 1] = -1;
                                          } else {
                                             class84.intStack[++class84.intStackSize - 1] = var36.worldX;
                                             class84.intStack[++class84.intStackSize - 1] = var36.worldY;
                                          }

                                          var3 = 1;
                                       } else if(var0 == 6616) {
                                          class84.intStack[++class84.intStackSize - 1] = class23.method172().method5233();
                                          var3 = 1;
                                       } else if(var0 == 6617) {
                                          var36 = new Coordinates(class84.intStack[--class84.intStackSize]);
                                          var30 = class23.method172().method5236();
                                          if(var30 == null) {
                                             class84.intStack[++class84.intStackSize - 1] = -1;
                                             class84.intStack[++class84.intStackSize - 1] = -1;
                                             var3 = 1;
                                          } else {
                                             int[] var44 = var30.method288(var36.plane, var36.worldX, var36.worldY);
                                             if(var44 == null) {
                                                class84.intStack[++class84.intStackSize - 1] = -1;
                                                class84.intStack[++class84.intStackSize - 1] = -1;
                                             } else {
                                                class84.intStack[++class84.intStackSize - 1] = var44[0];
                                                class84.intStack[++class84.intStackSize - 1] = var44[1];
                                             }

                                             var3 = 1;
                                          }
                                       } else {
                                          Coordinates var45;
                                          if(var0 == 6618) {
                                             var36 = new Coordinates(class84.intStack[--class84.intStackSize]);
                                             var30 = class23.method172().method5236();
                                             if(var30 == null) {
                                                class84.intStack[++class84.intStackSize - 1] = -1;
                                                class84.intStack[++class84.intStackSize - 1] = -1;
                                                var3 = 1;
                                             } else {
                                                var45 = var30.method289(var36.worldX, var36.worldY);
                                                if(var45 == null) {
                                                   class84.intStack[++class84.intStackSize - 1] = -1;
                                                } else {
                                                   class84.intStack[++class84.intStackSize - 1] = var45.method3935();
                                                }

                                                var3 = 1;
                                             }
                                          } else {
                                             Coordinates var32;
                                             if(var0 == 6619) {
                                                class84.intStackSize -= 2;
                                                var4 = class84.intStack[class84.intStackSize];
                                                var32 = new Coordinates(class84.intStack[class84.intStackSize + 1]);
                                                WorldMapType3.method214(var4, var32, false);
                                                var3 = 1;
                                             } else if(var0 == 6620) {
                                                class84.intStackSize -= 2;
                                                var4 = class84.intStack[class84.intStackSize];
                                                var32 = new Coordinates(class84.intStack[class84.intStackSize + 1]);
                                                WorldMapType3.method214(var4, var32, true);
                                                var3 = 1;
                                             } else if(var0 == 6621) {
                                                class84.intStackSize -= 2;
                                                var4 = class84.intStack[class84.intStackSize];
                                                var32 = new Coordinates(class84.intStack[class84.intStackSize + 1]);
                                                var42 = class23.method172().method5249(var4);
                                                if(var42 == null) {
                                                   class84.intStack[++class84.intStackSize - 1] = 0;
                                                   var3 = 1;
                                                } else {
                                                   class84.intStack[++class84.intStackSize - 1] = var42.method286(var32.plane, var32.worldX, var32.worldY)?1:0;
                                                   var3 = 1;
                                                }
                                             } else if(var0 == 6622) {
                                                class84.intStack[++class84.intStackSize - 1] = class23.method172().method5257();
                                                class84.intStack[++class84.intStackSize - 1] = class23.method172().method5258();
                                                var3 = 1;
                                             } else if(var0 == 6623) {
                                                var36 = new Coordinates(class84.intStack[--class84.intStackSize]);
                                                var30 = class23.method172().method5232(var36.plane, var36.worldX, var36.worldY);
                                                if(var30 == null) {
                                                   class84.intStack[++class84.intStackSize - 1] = -1;
                                                } else {
                                                   class84.intStack[++class84.intStackSize - 1] = var30.method348();
                                                }

                                                var3 = 1;
                                             } else if(var0 == 6624) {
                                                class23.method172().method5259(class84.intStack[--class84.intStackSize]);
                                                var3 = 1;
                                             } else if(var0 == 6625) {
                                                class23.method172().method5260();
                                                var3 = 1;
                                             } else if(var0 == 6626) {
                                                class23.method172().method5261(class84.intStack[--class84.intStackSize]);
                                                var3 = 1;
                                             } else if(var0 == 6627) {
                                                class23.method172().method5262();
                                                var3 = 1;
                                             } else if(var0 == 6628) {
                                                var31 = class84.intStack[--class84.intStackSize] == 1;
                                                class23.method172().method5263(var31);
                                                var3 = 1;
                                             } else if(var0 == 6629) {
                                                var4 = class84.intStack[--class84.intStackSize];
                                                class23.method172().method5264(var4);
                                                var3 = 1;
                                             } else if(var0 == 6630) {
                                                var4 = class84.intStack[--class84.intStackSize];
                                                class23.method172().method5265(var4);
                                                var3 = 1;
                                             } else if(var0 == 6631) {
                                                class23.method172().method5266();
                                                var3 = 1;
                                             } else if(var0 == 6632) {
                                                var31 = class84.intStack[--class84.intStackSize] == 1;
                                                class23.method172().method5267(var31);
                                                var3 = 1;
                                             } else if(var0 == 6633) {
                                                class84.intStackSize -= 2;
                                                var4 = class84.intStack[class84.intStackSize];
                                                var14 = 1 == class84.intStack[class84.intStackSize + 1];
                                                class23.method172().method5224(var4, var14);
                                                var3 = 1;
                                             } else if(var0 == 6634) {
                                                class84.intStackSize -= 2;
                                                var4 = class84.intStack[class84.intStackSize];
                                                var14 = class84.intStack[class84.intStackSize + 1] == 1;
                                                class23.method172().method5269(var4, var14);
                                                var3 = 1;
                                             } else if(var0 == 6635) {
                                                class84.intStack[++class84.intStackSize - 1] = class23.method172().method5378()?1:0;
                                                var3 = 1;
                                             } else if(var0 == 6636) {
                                                var4 = class84.intStack[--class84.intStackSize];
                                                class84.intStack[++class84.intStackSize - 1] = class23.method172().method5271(var4)?1:0;
                                                var3 = 1;
                                             } else if(var0 == 6637) {
                                                var4 = class84.intStack[--class84.intStackSize];
                                                class84.intStack[++class84.intStackSize - 1] = class23.method172().method5376(var4)?1:0;
                                                var3 = 1;
                                             } else if(var0 == 6638) {
                                                class84.intStackSize -= 2;
                                                var4 = class84.intStack[class84.intStackSize];
                                                var32 = new Coordinates(class84.intStack[class84.intStackSize + 1]);
                                                var45 = class23.method172().method5283(var4, var32);
                                                if(var45 == null) {
                                                   class84.intStack[++class84.intStackSize - 1] = -1;
                                                } else {
                                                   class84.intStack[++class84.intStackSize - 1] = var45.method3935();
                                                }

                                                var3 = 1;
                                             } else {
                                                class39 var41;
                                                if(var0 == 6639) {
                                                   var41 = class23.method172().method5371();
                                                   if(var41 == null) {
                                                      class84.intStack[++class84.intStackSize - 1] = -1;
                                                      class84.intStack[++class84.intStackSize - 1] = -1;
                                                   } else {
                                                      class84.intStack[++class84.intStackSize - 1] = var41.field534;
                                                      class84.intStack[++class84.intStackSize - 1] = var41.field530.method3935();
                                                   }

                                                   var3 = 1;
                                                } else if(var0 == 6640) {
                                                   var41 = class23.method172().method5270();
                                                   if(var41 == null) {
                                                      class84.intStack[++class84.intStackSize - 1] = -1;
                                                      class84.intStack[++class84.intStackSize - 1] = -1;
                                                   } else {
                                                      class84.intStack[++class84.intStackSize - 1] = var41.field534;
                                                      class84.intStack[++class84.intStackSize - 1] = var41.field530.method3935();
                                                   }

                                                   var3 = 1;
                                                } else {
                                                   Area var35;
                                                   if(var0 == 6693) {
                                                      var4 = class84.intStack[--class84.intStackSize];
                                                      var35 = Area.field3276[var4];
                                                      if(var35.name == null) {
                                                         class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
                                                      } else {
                                                         class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var35.name;
                                                      }

                                                      var3 = 1;
                                                   } else if(var0 == 6694) {
                                                      var4 = class84.intStack[--class84.intStackSize];
                                                      var35 = Area.field3276[var4];
                                                      class84.intStack[++class84.intStackSize - 1] = var35.field3284;
                                                      var3 = 1;
                                                   } else if(var0 == 6695) {
                                                      var4 = class84.intStack[--class84.intStackSize];
                                                      var35 = Area.field3276[var4];
                                                      if(var35 == null) {
                                                         class84.intStack[++class84.intStackSize - 1] = -1;
                                                      } else {
                                                         class84.intStack[++class84.intStackSize - 1] = var35.field3296;
                                                      }

                                                      var3 = 1;
                                                   } else if(var0 == 6696) {
                                                      var4 = class84.intStack[--class84.intStackSize];
                                                      var35 = Area.field3276[var4];
                                                      if(var35 == null) {
                                                         class84.intStack[++class84.intStackSize - 1] = -1;
                                                      } else {
                                                         class84.intStack[++class84.intStackSize - 1] = var35.spriteId;
                                                      }

                                                      var3 = 1;
                                                   } else if(var0 == 6697) {
                                                      class84.intStack[++class84.intStackSize - 1] = class40.field541.field600;
                                                      var3 = 1;
                                                   } else if(var0 == 6698) {
                                                      class84.intStack[++class84.intStackSize - 1] = class40.field541.field597.method3935();
                                                      var3 = 1;
                                                   } else if(var0 == 6699) {
                                                      class84.intStack[++class84.intStackSize - 1] = class40.field541.field598.method3935();
                                                      var3 = 1;
                                                   } else {
                                                      var3 = 2;
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
                              }

                              return var3;
                           } else {
                              return 2;
                           }
                        } else {
                           if(var0 == 6500) {
                              class84.intStack[++class84.intStackSize - 1] = Signlink.loadWorlds()?1:0;
                              var3 = 1;
                           } else {
                              World var5;
                              if(var0 == 6501) {
                                 World.field1277 = 0;
                                 if(World.field1277 < World.worldCount) {
                                    var5 = class51.worldList[++World.field1277 - 1];
                                 } else {
                                    var5 = null;
                                 }

                                 if(var5 != null) {
                                    class84.intStack[++class84.intStackSize - 1] = var5.id;
                                    class84.intStack[++class84.intStackSize - 1] = var5.mask;
                                    class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var5.activity;
                                    class84.intStack[++class84.intStackSize - 1] = var5.location;
                                    class84.intStack[++class84.intStackSize - 1] = var5.playerCount;
                                    class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var5.address;
                                 } else {
                                    class84.intStack[++class84.intStackSize - 1] = -1;
                                    class84.intStack[++class84.intStackSize - 1] = 0;
                                    class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
                                    class84.intStack[++class84.intStackSize - 1] = 0;
                                    class84.intStack[++class84.intStackSize - 1] = 0;
                                    class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
                                 }

                                 var3 = 1;
                              } else if(var0 == 6502) {
                                 World var12;
                                 if(World.field1277 < World.worldCount) {
                                    var12 = class51.worldList[++World.field1277 - 1];
                                 } else {
                                    var12 = null;
                                 }

                                 if(var12 != null) {
                                    class84.intStack[++class84.intStackSize - 1] = var12.id;
                                    class84.intStack[++class84.intStackSize - 1] = var12.mask;
                                    class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var12.activity;
                                    class84.intStack[++class84.intStackSize - 1] = var12.location;
                                    class84.intStack[++class84.intStackSize - 1] = var12.playerCount;
                                    class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var12.address;
                                 } else {
                                    class84.intStack[++class84.intStackSize - 1] = -1;
                                    class84.intStack[++class84.intStackSize - 1] = 0;
                                    class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
                                    class84.intStack[++class84.intStackSize - 1] = 0;
                                    class84.intStack[++class84.intStackSize - 1] = 0;
                                    class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
                                 }

                                 var3 = 1;
                              } else if(var0 == 6506) {
                                 var4 = class84.intStack[--class84.intStackSize];
                                 var5 = null;

                                 for(var6 = 0; var6 < World.worldCount; ++var6) {
                                    if(var4 == class51.worldList[var6].id) {
                                       var5 = class51.worldList[var6];
                                       break;
                                    }
                                 }

                                 if(var5 != null) {
                                    class84.intStack[++class84.intStackSize - 1] = var5.id;
                                    class84.intStack[++class84.intStackSize - 1] = var5.mask;
                                    class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var5.activity;
                                    class84.intStack[++class84.intStackSize - 1] = var5.location;
                                    class84.intStack[++class84.intStackSize - 1] = var5.playerCount;
                                    class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var5.address;
                                 } else {
                                    class84.intStack[++class84.intStackSize - 1] = -1;
                                    class84.intStack[++class84.intStackSize - 1] = 0;
                                    class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
                                    class84.intStack[++class84.intStackSize - 1] = 0;
                                    class84.intStack[++class84.intStackSize - 1] = 0;
                                    class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
                                 }

                                 var3 = 1;
                              } else if(var0 == 6507) {
                                 class84.intStackSize -= 4;
                                 var4 = class84.intStack[class84.intStackSize];
                                 var14 = class84.intStack[class84.intStackSize + 1] == 1;
                                 var6 = class84.intStack[class84.intStackSize + 2];
                                 boolean var13 = class84.intStack[class84.intStackSize + 3] == 1;
                                 class19.method153(var4, var14, var6, var13);
                                 var3 = 1;
                              } else if(var0 == 6511) {
                                 var4 = class84.intStack[--class84.intStackSize];
                                 if(var4 >= 0 && var4 < World.worldCount) {
                                    var5 = class51.worldList[var4];
                                    class84.intStack[++class84.intStackSize - 1] = var5.id;
                                    class84.intStack[++class84.intStackSize - 1] = var5.mask;
                                    class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var5.activity;
                                    class84.intStack[++class84.intStackSize - 1] = var5.location;
                                    class84.intStack[++class84.intStackSize - 1] = var5.playerCount;
                                    class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var5.address;
                                 } else {
                                    class84.intStack[++class84.intStackSize - 1] = -1;
                                    class84.intStack[++class84.intStackSize - 1] = 0;
                                    class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
                                    class84.intStack[++class84.intStackSize - 1] = 0;
                                    class84.intStack[++class84.intStackSize - 1] = 0;
                                    class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
                                 }

                                 var3 = 1;
                              } else if(var0 == 6512) {
                                 Client.field1142 = class84.intStack[--class84.intStackSize] == 1;
                                 var3 = 1;
                              } else {
                                 class252 var15;
                                 if(var0 == 6513) {
                                    class84.intStackSize -= 2;
                                    var4 = class84.intStack[class84.intStackSize];
                                    var39 = class84.intStack[class84.intStackSize + 1];
                                    var15 = Coordinates.method3948(var39);
                                    if(var15.method4447()) {
                                       class84.scriptStringStack[++class84.scriptStringStackSize - 1] = class19.getNpcDefinition(var4).method4681(var39, var15.field3381);
                                    } else {
                                       class84.intStack[++class84.intStackSize - 1] = class19.getNpcDefinition(var4).method4664(var39, var15.field3380);
                                    }

                                    var3 = 1;
                                 } else if(var0 == 6514) {
                                    class84.intStackSize -= 2;
                                    var4 = class84.intStack[class84.intStackSize];
                                    var39 = class84.intStack[class84.intStackSize + 1];
                                    var15 = Coordinates.method3948(var39);
                                    if(var15.method4447()) {
                                       class84.scriptStringStack[++class84.scriptStringStackSize - 1] = WorldMapType1.getObjectDefinition(var4).method4532(var39, var15.field3381);
                                    } else {
                                       class84.intStack[++class84.intStackSize - 1] = WorldMapType1.getObjectDefinition(var4).method4543(var39, var15.field3380);
                                    }

                                    var3 = 1;
                                 } else if(var0 == 6515) {
                                    class84.intStackSize -= 2;
                                    var4 = class84.intStack[class84.intStackSize];
                                    var39 = class84.intStack[class84.intStackSize + 1];
                                    var15 = Coordinates.method3948(var39);
                                    if(var15.method4447()) {
                                       class84.scriptStringStack[++class84.scriptStringStackSize - 1] = ClassInfo.getItemDefinition(var4).method4597(var39, var15.field3381);
                                    } else {
                                       class84.intStack[++class84.intStackSize - 1] = ClassInfo.getItemDefinition(var4).method4596(var39, var15.field3380);
                                    }

                                    var3 = 1;
                                 } else if(var0 == 6516) {
                                    class84.intStackSize -= 2;
                                    var4 = class84.intStack[class84.intStackSize];
                                    var39 = class84.intStack[class84.intStackSize + 1];
                                    var15 = Coordinates.method3948(var39);
                                    class253 var9;
                                    class253 var10;
                                    byte[] var11;
                                    if(var15.method4447()) {
                                       String[] var7 = class84.scriptStringStack;
                                       var8 = ++class84.scriptStringStackSize - 1;
                                       var10 = (class253)class253.field3388.get((long)var4);
                                       if(var10 != null) {
                                          var9 = var10;
                                       } else {
                                          var11 = class253.field3387.getConfigData(34, var4);
                                          var10 = new class253();
                                          if(var11 != null) {
                                             var10.method4465(new Buffer(var11));
                                          }

                                          var10.method4464();
                                          class253.field3388.put(var10, (long)var4);
                                          var9 = var10;
                                       }

                                       var7[var8] = var9.method4474(var39, var15.field3381);
                                    } else {
                                       int[] var26 = class84.intStack;
                                       var8 = ++class84.intStackSize - 1;
                                       var10 = (class253)class253.field3388.get((long)var4);
                                       if(var10 != null) {
                                          var9 = var10;
                                       } else {
                                          var11 = class253.field3387.getConfigData(34, var4);
                                          var10 = new class253();
                                          if(var11 != null) {
                                             var10.method4465(new Buffer(var11));
                                          }

                                          var10.method4464();
                                          class253.field3388.put(var10, (long)var4);
                                          var9 = var10;
                                       }

                                       var26[var8] = var9.method4467(var39, var15.field3380);
                                    }

                                    var3 = 1;
                                 } else {
                                    var3 = 2;
                                 }
                              }
                           }

                           return var3;
                        }
                     }
                  }
               }
            }
         }
      }
   }
}
