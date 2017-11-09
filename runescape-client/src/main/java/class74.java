import java.util.Comparator;
import java.util.Date;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
public class class74 implements Comparator {
   @ObfuscatedName("m")
   boolean field859;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lk;Lk;B)I",
      garbageValue = "8"
   )
   int method1210(class14 var1, class14 var2) {
      if(var2.field291 == var1.field291) {
         return 0;
      } else {
         if(this.field859) {
            if(Client.world == var1.field291) {
               return -1;
            }

            if(var2.field291 == Client.world) {
               return 1;
            }
         }

         return var1.field291 < var2.field291?-1:1;
      }
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method1210((class14)var1, (class14)var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "-1475792866"
   )
   public static int method1226(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0 - (var3 - 1):7 - var1 - (var4 - 1)));
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILcw;ZI)I",
      garbageValue = "-2018219730"
   )
   static int method1224(int var0, Script var1, boolean var2) {
      if(var0 < 1000) {
         return class27.method241(var0, var1, var2);
      } else if(var0 < 1100) {
         return class87.method1793(var0, var1, var2);
      } else if(var0 < 1200) {
         return class246.method4442(var0, var1, var2);
      } else if(var0 < 1300) {
         return class36.method544(var0, var1, var2);
      } else if(var0 < 1400) {
         return PacketNode.method3195(var0, var1, var2);
      } else if(var0 < 1500) {
         return MessageNode.method1175(var0, var1, var2);
      } else {
         byte var3;
         Widget var48;
         if(var0 < 1600) {
            var48 = var2?class285.field3789:Friend.field768;
            if(var0 == 1500) {
               class82.intStack[++class56.intStackSize - 1] = var48.relativeX;
               var3 = 1;
            } else if(var0 == 1501) {
               class82.intStack[++class56.intStackSize - 1] = var48.relativeY;
               var3 = 1;
            } else if(var0 == 1502) {
               class82.intStack[++class56.intStackSize - 1] = var48.width;
               var3 = 1;
            } else if(var0 == 1503) {
               class82.intStack[++class56.intStackSize - 1] = var48.height;
               var3 = 1;
            } else if(var0 == 1504) {
               class82.intStack[++class56.intStackSize - 1] = var48.isHidden?1:0;
               var3 = 1;
            } else if(var0 == 1505) {
               class82.intStack[++class56.intStackSize - 1] = var48.parentId;
               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else {
            Widget var77;
            if(var0 < 1700) {
               var77 = var2?class285.field3789:Friend.field768;
               if(var0 == 1600) {
                  class82.intStack[++class56.intStackSize - 1] = var77.scrollX;
                  var3 = 1;
               } else if(var0 == 1601) {
                  class82.intStack[++class56.intStackSize - 1] = var77.scrollY;
                  var3 = 1;
               } else if(var0 == 1602) {
                  class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var77.text;
                  var3 = 1;
               } else if(var0 == 1603) {
                  class82.intStack[++class56.intStackSize - 1] = var77.scrollWidth;
                  var3 = 1;
               } else if(var0 == 1604) {
                  class82.intStack[++class56.intStackSize - 1] = var77.scrollHeight;
                  var3 = 1;
               } else if(var0 == 1605) {
                  class82.intStack[++class56.intStackSize - 1] = var77.modelZoom;
                  var3 = 1;
               } else if(var0 == 1606) {
                  class82.intStack[++class56.intStackSize - 1] = var77.rotationX;
                  var3 = 1;
               } else if(var0 == 1607) {
                  class82.intStack[++class56.intStackSize - 1] = var77.rotationY;
                  var3 = 1;
               } else if(var0 == 1608) {
                  class82.intStack[++class56.intStackSize - 1] = var77.rotationZ;
                  var3 = 1;
               } else if(var0 == 1609) {
                  class82.intStack[++class56.intStackSize - 1] = var77.opacity;
                  var3 = 1;
               } else if(var0 == 1610) {
                  class82.intStack[++class56.intStackSize - 1] = var77.field2758;
                  var3 = 1;
               } else if(var0 == 1611) {
                  class82.intStack[++class56.intStackSize - 1] = var77.textColor;
                  var3 = 1;
               } else if(var0 == 1612) {
                  class82.intStack[++class56.intStackSize - 1] = var77.field2753;
                  var3 = 1;
               } else if(var0 == 1613) {
                  class82.intStack[++class56.intStackSize - 1] = var77.field2756.rsOrdinal();
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 1800) {
               return GrandExchangeOffer.method123(var0, var1, var2);
            } else if(var0 < 1900) {
               return FrameMap.method2778(var0, var1, var2);
            } else if(var0 < 2000) {
               return class215.method4055(var0, var1, var2);
            } else if(var0 < 2100) {
               return class87.method1793(var0, var1, var2);
            } else if(var0 < 2200) {
               return class246.method4442(var0, var1, var2);
            } else if(var0 < 2300) {
               return class36.method544(var0, var1, var2);
            } else if(var0 < 2400) {
               return PacketNode.method3195(var0, var1, var2);
            } else if(var0 < 2500) {
               return MessageNode.method1175(var0, var1, var2);
            } else if(var0 < 2600) {
               return class13.method78(var0, var1, var2);
            } else if(var0 < 2700) {
               var77 = PendingSpawn.method1612(class82.intStack[--class56.intStackSize]);
               if(var0 == 2600) {
                  class82.intStack[++class56.intStackSize - 1] = var77.scrollX;
                  var3 = 1;
               } else if(var0 == 2601) {
                  class82.intStack[++class56.intStackSize - 1] = var77.scrollY;
                  var3 = 1;
               } else if(var0 == 2602) {
                  class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var77.text;
                  var3 = 1;
               } else if(var0 == 2603) {
                  class82.intStack[++class56.intStackSize - 1] = var77.scrollWidth;
                  var3 = 1;
               } else if(var0 == 2604) {
                  class82.intStack[++class56.intStackSize - 1] = var77.scrollHeight;
                  var3 = 1;
               } else if(var0 == 2605) {
                  class82.intStack[++class56.intStackSize - 1] = var77.modelZoom;
                  var3 = 1;
               } else if(var0 == 2606) {
                  class82.intStack[++class56.intStackSize - 1] = var77.rotationX;
                  var3 = 1;
               } else if(var0 == 2607) {
                  class82.intStack[++class56.intStackSize - 1] = var77.rotationY;
                  var3 = 1;
               } else if(var0 == 2608) {
                  class82.intStack[++class56.intStackSize - 1] = var77.rotationZ;
                  var3 = 1;
               } else if(var0 == 2609) {
                  class82.intStack[++class56.intStackSize - 1] = var77.opacity;
                  var3 = 1;
               } else if(var0 == 2610) {
                  class82.intStack[++class56.intStackSize - 1] = var77.field2758;
                  var3 = 1;
               } else if(var0 == 2611) {
                  class82.intStack[++class56.intStackSize - 1] = var77.textColor;
                  var3 = 1;
               } else if(var0 == 2612) {
                  class82.intStack[++class56.intStackSize - 1] = var77.field2753;
                  var3 = 1;
               } else if(var0 == 2613) {
                  class82.intStack[++class56.intStackSize - 1] = var77.field2756.rsOrdinal();
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else {
               int var4;
               WidgetNode var52;
               if(var0 < 2800) {
                  if(var0 == 2700) {
                     var77 = PendingSpawn.method1612(class82.intStack[--class56.intStackSize]);
                     class82.intStack[++class56.intStackSize - 1] = var77.itemId;
                     var3 = 1;
                  } else if(var0 == 2701) {
                     var77 = PendingSpawn.method1612(class82.intStack[--class56.intStackSize]);
                     if(var77.itemId != -1) {
                        class82.intStack[++class56.intStackSize - 1] = var77.itemQuantity;
                     } else {
                        class82.intStack[++class56.intStackSize - 1] = 0;
                     }

                     var3 = 1;
                  } else if(var0 == 2702) {
                     var4 = class82.intStack[--class56.intStackSize];
                     var52 = (WidgetNode)Client.componentTable.get((long)var4);
                     if(var52 != null) {
                        class82.intStack[++class56.intStackSize - 1] = 1;
                     } else {
                        class82.intStack[++class56.intStackSize - 1] = 0;
                     }

                     var3 = 1;
                  } else if(var0 == 2706) {
                     class82.intStack[++class56.intStackSize - 1] = Client.widgetRoot;
                     var3 = 1;
                  } else {
                     var3 = 2;
                  }

                  return var3;
               } else if(var0 < 2900) {
                  return class33.method395(var0, var1, var2);
               } else if(var0 < 3000) {
                  return class215.method4055(var0, var1, var2);
               } else {
                  int var6;
                  int var9;
                  boolean var16;
                  int[] var32;
                  String var33;
                  PacketNode var47;
                  String var57;
                  int var58;
                  PacketNode var63;
                  String var64;
                  if(var0 < 3200) {
                     if(var0 == 3100) {
                        var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                        class96.sendGameMessage(0, "", var57);
                        var3 = 1;
                     } else if(var0 == 3101) {
                        class56.intStackSize -= 2;
                        class34.method503(class48.localPlayer, class82.intStack[class56.intStackSize], class82.intStack[class56.intStackSize + 1]);
                        var3 = 1;
                     } else if(var0 == 3103) {
                        PacketNode var76 = Actor.method1628(ClientPacket.field2374, Client.field952.field1478);
                        Client.field952.method1951(var76);

                        for(var52 = (WidgetNode)Client.componentTable.method3721(); var52 != null; var52 = (WidgetNode)Client.componentTable.method3728()) {
                           if(var52.owner == 0 || var52.owner == 3) {
                              Frames.method2984(var52, true);
                           }
                        }

                        if(Client.field1013 != null) {
                           WorldMapData.method394(Client.field1013);
                           Client.field1013 = null;
                        }

                        var3 = 1;
                     } else if(var0 == 3104) {
                        var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                        var58 = 0;
                        if(Buffer.method3504(var57)) {
                           var58 = class94.method1871(var57);
                        }

                        var63 = Actor.method1628(ClientPacket.field2375, Client.field952.field1478);
                        var63.packetBuffer.putInt(var58);
                        Client.field952.method1951(var63);
                        var3 = 1;
                     } else {
                        PacketNode var54;
                        if(var0 == 3105) {
                           var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                           var54 = Actor.method1628(ClientPacket.field2394, Client.field952.field1478);
                           var54.packetBuffer.putByte(var57.length() + 1);
                           var54.packetBuffer.putString(var57);
                           Client.field952.method1951(var54);
                           var3 = 1;
                        } else if(var0 == 3106) {
                           var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                           var54 = Actor.method1628(ClientPacket.field2382, Client.field952.field1478);
                           var54.packetBuffer.putByte(var57.length() + 1);
                           var54.packetBuffer.putString(var57);
                           Client.field952.method1951(var54);
                           var3 = 1;
                        } else if(var0 == 3107) {
                           var4 = class82.intStack[--class56.intStackSize];
                           var33 = class82.scriptStringStack[--class24.scriptStringStackSize];
                           var6 = class94.playerIndexesCount;
                           var32 = class94.playerIndices;
                           boolean var59 = false;

                           for(var9 = 0; var9 < var6; ++var9) {
                              Player var53 = Client.cachedPlayers[var32[var9]];
                              if(var53 != null && var53 != class48.localPlayer && var53.name != null && var53.name.equalsIgnoreCase(var33)) {
                                 if(var4 == 1) {
                                    var47 = Actor.method1628(ClientPacket.field2350, Client.field952.field1478);
                                    var47.packetBuffer.method3403(0);
                                    var47.packetBuffer.putShortLE(var32[var9]);
                                    Client.field952.method1951(var47);
                                 } else if(var4 == 4) {
                                    var47 = Actor.method1628(ClientPacket.field2343, Client.field952.field1478);
                                    var47.packetBuffer.method3319(var32[var9]);
                                    var47.packetBuffer.method3311(0);
                                    Client.field952.method1951(var47);
                                 } else if(var4 == 6) {
                                    var47 = Actor.method1628(ClientPacket.field2355, Client.field952.field1478);
                                    var47.packetBuffer.method3311(0);
                                    var47.packetBuffer.method3319(var32[var9]);
                                    Client.field952.method1951(var47);
                                 } else if(var4 == 7) {
                                    var47 = Actor.method1628(ClientPacket.field2356, Client.field952.field1478);
                                    var47.packetBuffer.method3374(0);
                                    var47.packetBuffer.putShortLE(var32[var9]);
                                    Client.field952.method1951(var47);
                                 }

                                 var59 = true;
                                 break;
                              }
                           }

                           if(!var59) {
                              class96.sendGameMessage(4, "", "Unable to find " + var33);
                           }

                           var3 = 1;
                        } else if(var0 == 3108) {
                           class56.intStackSize -= 3;
                           var4 = class82.intStack[class56.intStackSize];
                           var58 = class82.intStack[class56.intStackSize + 1];
                           var6 = class82.intStack[class56.intStackSize + 2];
                           var48 = PendingSpawn.method1612(var6);
                           Tile.method2608(var48, var4, var58);
                           var3 = 1;
                        } else if(var0 == 3109) {
                           class56.intStackSize -= 2;
                           var4 = class82.intStack[class56.intStackSize];
                           var58 = class82.intStack[class56.intStackSize + 1];
                           Widget var72 = var2?class285.field3789:Friend.field768;
                           Tile.method2608(var72, var4, var58);
                           var3 = 1;
                        } else if(var0 == 3110) {
                           Item.field1399 = class82.intStack[--class56.intStackSize] == 1;
                           var3 = 1;
                        } else if(var0 == 3111) {
                           class82.intStack[++class56.intStackSize - 1] = Buffer.preferences.hideRoofs?1:0;
                           var3 = 1;
                        } else if(var0 == 3112) {
                           Buffer.preferences.hideRoofs = class82.intStack[--class56.intStackSize] == 1;
                           class169.method3187();
                           var3 = 1;
                        } else if(var0 == 3113) {
                           var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                           var16 = class82.intStack[--class56.intStackSize] == 1;
                           class139.method2967(var57, var16, false);
                           var3 = 1;
                        } else if(var0 == 3115) {
                           var4 = class82.intStack[--class56.intStackSize];
                           var54 = Actor.method1628(ClientPacket.field2379, Client.field952.field1478);
                           var54.packetBuffer.putShort(var4);
                           Client.field952.method1951(var54);
                           var3 = 1;
                        } else if(var0 == 3116) {
                           var4 = class82.intStack[--class56.intStackSize];
                           class24.scriptStringStackSize -= 2;
                           var33 = class82.scriptStringStack[class24.scriptStringStackSize];
                           var64 = class82.scriptStringStack[class24.scriptStringStackSize + 1];
                           if(var33.length() > 500) {
                              var3 = 1;
                           } else if(var64.length() > 500) {
                              var3 = 1;
                           } else {
                              PacketNode var49 = Actor.method1628(ClientPacket.field2367, Client.field952.field1478);
                              var49.packetBuffer.putShort(1 + Projectile.getLength(var33) + Projectile.getLength(var64));
                              var49.packetBuffer.putByte(var4);
                              var49.packetBuffer.putString(var33);
                              var49.packetBuffer.putString(var64);
                              Client.field952.method1951(var49);
                              var3 = 1;
                           }
                        } else if(var0 == 3117) {
                           Client.field997 = class82.intStack[--class56.intStackSize] == 1;
                           var3 = 1;
                        } else {
                           var3 = 2;
                        }
                     }

                     return var3;
                  } else if(var0 < 3300) {
                     if(var0 == 3200) {
                        class56.intStackSize -= 3;
                        var4 = class82.intStack[class56.intStackSize];
                        var58 = class82.intStack[class56.intStackSize + 1];
                        var6 = class82.intStack[class56.intStackSize + 2];
                        if(Client.field1089 != 0 && var58 != 0 && Client.field1091 < 50) {
                           Client.field910[Client.field1091] = var4;
                           Client.field1093[Client.field1091] = var58;
                           Client.field1094[Client.field1091] = var6;
                           Client.audioEffects[Client.field1091] = null;
                           Client.field1033[Client.field1091] = 0;
                           ++Client.field1091;
                        }

                        var3 = 1;
                     } else if(var0 == 3201) {
                        class13.method84(class82.intStack[--class56.intStackSize]);
                        var3 = 1;
                     } else if(var0 == 3202) {
                        class56.intStackSize -= 2;
                        var4 = class82.intStack[class56.intStackSize];
                        var58 = class82.intStack[class56.intStackSize + 1];
                        if(Client.field1059 != 0 && var4 != -1) {
                           class182.method3518(class236.indexTrack2, var4, 0, Client.field1059, false);
                           Client.field1088 = true;
                        }

                        var3 = 1;
                     } else {
                        var3 = 2;
                     }

                     return var3;
                  } else {
                     int var8;
                     int var21;
                     int var22;
                     int var61;
                     if(var0 < 3400) {
                        if(var0 == 3300) {
                           class82.intStack[++class56.intStackSize - 1] = Client.gameCycle;
                           var3 = 1;
                        } else if(var0 == 3301) {
                           class56.intStackSize -= 2;
                           var4 = class82.intStack[class56.intStackSize];
                           var58 = class82.intStack[class56.intStackSize + 1];
                           class82.intStack[++class56.intStackSize - 1] = MessageNode.method1177(var4, var58);
                           var3 = 1;
                        } else {
                           int[] var68;
                           ItemContainer var75;
                           if(var0 == 3302) {
                              class56.intStackSize -= 2;
                              var4 = class82.intStack[class56.intStackSize];
                              var58 = class82.intStack[class56.intStackSize + 1];
                              var68 = class82.intStack;
                              var61 = ++class56.intStackSize - 1;
                              var75 = (ItemContainer)ItemContainer.itemContainers.get((long)var4);
                              if(var75 == null) {
                                 var8 = 0;
                              } else if(var58 >= 0 && var58 < var75.stackSizes.length) {
                                 var8 = var75.stackSizes[var58];
                              } else {
                                 var8 = 0;
                              }

                              var68[var61] = var8;
                              var3 = 1;
                           } else if(var0 == 3303) {
                              class56.intStackSize -= 2;
                              var4 = class82.intStack[class56.intStackSize];
                              var58 = class82.intStack[class56.intStackSize + 1];
                              var68 = class82.intStack;
                              var61 = ++class56.intStackSize - 1;
                              var75 = (ItemContainer)ItemContainer.itemContainers.get((long)var4);
                              if(var75 == null) {
                                 var8 = 0;
                              } else if(var58 == -1) {
                                 var8 = 0;
                              } else {
                                 var21 = 0;

                                 for(var22 = 0; var22 < var75.stackSizes.length; ++var22) {
                                    if(var58 == var75.itemIds[var22]) {
                                       var21 += var75.stackSizes[var22];
                                    }
                                 }

                                 var8 = var21;
                              }

                              var68[var61] = var8;
                              var3 = 1;
                           } else if(var0 == 3304) {
                              var4 = class82.intStack[--class56.intStackSize];
                              class82.intStack[++class56.intStackSize - 1] = class153.method3052(var4).size;
                              var3 = 1;
                           } else if(var0 == 3305) {
                              var4 = class82.intStack[--class56.intStackSize];
                              class82.intStack[++class56.intStackSize - 1] = Client.boostedSkillLevels[var4];
                              var3 = 1;
                           } else if(var0 == 3306) {
                              var4 = class82.intStack[--class56.intStackSize];
                              class82.intStack[++class56.intStackSize - 1] = Client.realSkillLevels[var4];
                              var3 = 1;
                           } else if(var0 == 3307) {
                              var4 = class82.intStack[--class56.intStackSize];
                              class82.intStack[++class56.intStackSize - 1] = Client.skillExperiences[var4];
                              var3 = 1;
                           } else if(var0 == 3308) {
                              var4 = Ignore.plane;
                              var58 = (class48.localPlayer.x >> 7) + ItemLayer.baseX;
                              var6 = (class48.localPlayer.y >> 7) + ItemLayer.baseY;
                              class82.intStack[++class56.intStackSize - 1] = (var58 << 14) + var6 + (var4 << 28);
                              var3 = 1;
                           } else if(var0 == 3309) {
                              var4 = class82.intStack[--class56.intStackSize];
                              class82.intStack[++class56.intStackSize - 1] = var4 >> 14 & 16383;
                              var3 = 1;
                           } else if(var0 == 3310) {
                              var4 = class82.intStack[--class56.intStackSize];
                              class82.intStack[++class56.intStackSize - 1] = var4 >> 28;
                              var3 = 1;
                           } else if(var0 == 3311) {
                              var4 = class82.intStack[--class56.intStackSize];
                              class82.intStack[++class56.intStackSize - 1] = var4 & 16383;
                              var3 = 1;
                           } else if(var0 == 3312) {
                              class82.intStack[++class56.intStackSize - 1] = Client.isMembers?1:0;
                              var3 = 1;
                           } else if(var0 == 3313) {
                              class56.intStackSize -= 2;
                              var4 = class82.intStack[class56.intStackSize] + 32768;
                              var58 = class82.intStack[class56.intStackSize + 1];
                              class82.intStack[++class56.intStackSize - 1] = MessageNode.method1177(var4, var58);
                              var3 = 1;
                           } else if(var0 == 3314) {
                              class56.intStackSize -= 2;
                              var4 = class82.intStack[class56.intStackSize] + 32768;
                              var58 = class82.intStack[class56.intStackSize + 1];
                              var68 = class82.intStack;
                              var61 = ++class56.intStackSize - 1;
                              var75 = (ItemContainer)ItemContainer.itemContainers.get((long)var4);
                              if(var75 == null) {
                                 var8 = 0;
                              } else if(var58 >= 0 && var58 < var75.stackSizes.length) {
                                 var8 = var75.stackSizes[var58];
                              } else {
                                 var8 = 0;
                              }

                              var68[var61] = var8;
                              var3 = 1;
                           } else if(var0 == 3315) {
                              class56.intStackSize -= 2;
                              var4 = class82.intStack[class56.intStackSize] + 32768;
                              var58 = class82.intStack[class56.intStackSize + 1];
                              var68 = class82.intStack;
                              var61 = ++class56.intStackSize - 1;
                              var75 = (ItemContainer)ItemContainer.itemContainers.get((long)var4);
                              if(var75 == null) {
                                 var8 = 0;
                              } else if(var58 == -1) {
                                 var8 = 0;
                              } else {
                                 var21 = 0;

                                 for(var22 = 0; var22 < var75.stackSizes.length; ++var22) {
                                    if(var58 == var75.itemIds[var22]) {
                                       var21 += var75.stackSizes[var22];
                                    }
                                 }

                                 var8 = var21;
                              }

                              var68[var61] = var8;
                              var3 = 1;
                           } else if(var0 == 3316) {
                              if(Client.rights >= 2) {
                                 class82.intStack[++class56.intStackSize - 1] = Client.rights;
                              } else {
                                 class82.intStack[++class56.intStackSize - 1] = 0;
                              }

                              var3 = 1;
                           } else if(var0 == 3317) {
                              class82.intStack[++class56.intStackSize - 1] = Client.field1095;
                              var3 = 1;
                           } else if(var0 == 3318) {
                              class82.intStack[++class56.intStackSize - 1] = Client.world;
                              var3 = 1;
                           } else if(var0 == 3321) {
                              class82.intStack[++class56.intStackSize - 1] = Client.energy;
                              var3 = 1;
                           } else if(var0 == 3322) {
                              class82.intStack[++class56.intStackSize - 1] = Client.weight;
                              var3 = 1;
                           } else if(var0 == 3323) {
                              if(Client.field1018) {
                                 class82.intStack[++class56.intStackSize - 1] = 1;
                              } else {
                                 class82.intStack[++class56.intStackSize - 1] = 0;
                              }

                              var3 = 1;
                           } else if(var0 == 3324) {
                              class82.intStack[++class56.intStackSize - 1] = Client.flags;
                              var3 = 1;
                           } else if(var0 == 3325) {
                              class56.intStackSize -= 4;
                              var4 = class82.intStack[class56.intStackSize];
                              var58 = class82.intStack[class56.intStackSize + 1];
                              var6 = class82.intStack[class56.intStackSize + 2];
                              var61 = class82.intStack[class56.intStackSize + 3];
                              var4 += var58 << 14;
                              var4 += var6 << 28;
                              var4 += var61;
                              class82.intStack[++class56.intStackSize - 1] = var4;
                              var3 = 1;
                           } else {
                              var3 = 2;
                           }
                        }

                        return var3;
                     } else if(var0 < 3500) {
                        if(var0 == 3400) {
                           class56.intStackSize -= 2;
                           var4 = class82.intStack[class56.intStackSize];
                           var58 = class82.intStack[class56.intStackSize + 1];
                           Enum var43 = (Enum)Enum.field3452.get((long)var4);
                           Enum var65;
                           if(var43 != null) {
                              var65 = var43;
                           } else {
                              byte[] var70 = Enum.field3456.getConfigData(8, var4);
                              var43 = new Enum();
                              if(var70 != null) {
                                 var43.decode(new Buffer(var70));
                              }

                              Enum.field3452.put(var43, (long)var4);
                              var65 = var43;
                           }

                           var43 = var65;
                           if(var65.valType != 's') {
                              ;
                           }

                           for(var8 = 0; var8 < var43.size; ++var8) {
                              if(var58 == var43.keys[var8]) {
                                 class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var43.stringVals[var8];
                                 var43 = null;
                                 break;
                              }
                           }

                           if(var43 != null) {
                              class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var43.defaultString;
                           }

                           var3 = 1;
                        } else if(var0 == 3408) {
                           class56.intStackSize -= 4;
                           var4 = class82.intStack[class56.intStackSize];
                           var58 = class82.intStack[class56.intStackSize + 1];
                           var6 = class82.intStack[class56.intStackSize + 2];
                           var61 = class82.intStack[class56.intStackSize + 3];
                           Enum var73 = (Enum)Enum.field3452.get((long)var6);
                           Enum var71;
                           if(var73 != null) {
                              var71 = var73;
                           } else {
                              byte[] var50 = Enum.field3456.getConfigData(8, var6);
                              var73 = new Enum();
                              if(var50 != null) {
                                 var73.decode(new Buffer(var50));
                              }

                              Enum.field3452.put(var73, (long)var6);
                              var71 = var73;
                           }

                           var73 = var71;
                           if(var4 == var71.keyType && var58 == var71.valType) {
                              for(var21 = 0; var21 < var73.size; ++var21) {
                                 if(var61 == var73.keys[var21]) {
                                    if(var58 == 115) {
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var73.stringVals[var21];
                                    } else {
                                       class82.intStack[++class56.intStackSize - 1] = var73.intVals[var21];
                                    }

                                    var73 = null;
                                    break;
                                 }
                              }

                              if(var73 != null) {
                                 if(var58 == 115) {
                                    class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var73.defaultString;
                                 } else {
                                    class82.intStack[++class56.intStackSize - 1] = var73.defaultInt;
                                 }
                              }

                              var3 = 1;
                           } else {
                              if(var58 == 115) {
                                 class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "null";
                              } else {
                                 class82.intStack[++class56.intStackSize - 1] = 0;
                              }

                              var3 = 1;
                           }
                        } else {
                           var3 = 2;
                        }

                        return var3;
                     } else {
                        String var67;
                        if(var0 < 3700) {
                           if(var0 == 3600) {
                              if(Client.field1021 == 0) {
                                 class82.intStack[++class56.intStackSize - 1] = -2;
                              } else if(Client.field1021 == 1) {
                                 class82.intStack[++class56.intStackSize - 1] = -1;
                              } else {
                                 class82.intStack[++class56.intStackSize - 1] = Client.friendCount;
                              }

                              var3 = 1;
                           } else if(var0 == 3601) {
                              var4 = class82.intStack[--class56.intStackSize];
                              if(Client.field1021 == 2 && var4 < Client.friendCount) {
                                 class82.scriptStringStack[++class24.scriptStringStackSize - 1] = Client.friends[var4].name;
                                 class82.scriptStringStack[++class24.scriptStringStackSize - 1] = Client.friends[var4].previousName;
                              } else {
                                 class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                                 class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else if(var0 == 3602) {
                              var4 = class82.intStack[--class56.intStackSize];
                              if(Client.field1021 == 2 && var4 < Client.friendCount) {
                                 class82.intStack[++class56.intStackSize - 1] = Client.friends[var4].world;
                              } else {
                                 class82.intStack[++class56.intStackSize - 1] = 0;
                              }

                              var3 = 1;
                           } else if(var0 == 3603) {
                              var4 = class82.intStack[--class56.intStackSize];
                              if(Client.field1021 == 2 && var4 < Client.friendCount) {
                                 class82.intStack[++class56.intStackSize - 1] = Client.friends[var4].rank;
                              } else {
                                 class82.intStack[++class56.intStackSize - 1] = 0;
                              }

                              var3 = 1;
                           } else if(var0 == 3604) {
                              var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                              var58 = class82.intStack[--class56.intStackSize];
                              var63 = Actor.method1628(ClientPacket.field2383, Client.field952.field1478);
                              var63.packetBuffer.putByte(Projectile.getLength(var57) + 1);
                              var63.packetBuffer.method3374(var58);
                              var63.packetBuffer.putString(var57);
                              Client.field952.method1951(var63);
                              var3 = 1;
                           } else {
                              Friend var35;
                              String var66;
                              if(var0 == 3605) {
                                 var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                                 if(var57 != null) {
                                    if((Client.friendCount < 200 || Client.field971 == 1) && Client.friendCount < 400) {
                                       var33 = PacketBuffer.method3598(var57, class60.field718);
                                       if(var33 != null) {
                                          var6 = 0;

                                          label2006:
                                          while(true) {
                                             if(var6 >= Client.friendCount) {
                                                for(var6 = 0; var6 < Client.ignoreCount; ++var6) {
                                                   Ignore var36 = Client.ignores[var6];
                                                   var66 = PacketBuffer.method3598(var36.name, class60.field718);
                                                   if(var66 != null && var66.equals(var33)) {
                                                      class96.sendGameMessage(30, "", "Please remove " + var57 + " from your ignore list first");
                                                      break label2006;
                                                   }

                                                   if(var36.previousName != null) {
                                                      var67 = PacketBuffer.method3598(var36.previousName, class60.field718);
                                                      if(var67 != null && var67.equals(var33)) {
                                                         class96.sendGameMessage(30, "", "Please remove " + var57 + " from your ignore list first");
                                                         break label2006;
                                                      }
                                                   }
                                                }

                                                if(PacketBuffer.method3598(class48.localPlayer.name, class60.field718).equals(var33)) {
                                                   class96.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
                                                } else {
                                                   var63 = Actor.method1628(ClientPacket.field2397, Client.field952.field1478);
                                                   var63.packetBuffer.putByte(Projectile.getLength(var57));
                                                   var63.packetBuffer.putString(var57);
                                                   Client.field952.method1951(var63);
                                                }
                                                break;
                                             }

                                             var35 = Client.friends[var6];
                                             var66 = PacketBuffer.method3598(var35.name, class60.field718);
                                             if(var66 != null && var66.equals(var33)) {
                                                class96.sendGameMessage(30, "", var57 + " is already on your friend list");
                                                break;
                                             }

                                             if(var35.previousName != null) {
                                                var67 = PacketBuffer.method3598(var35.previousName, class60.field718);
                                                if(var67 != null && var67.equals(var33)) {
                                                   class96.sendGameMessage(30, "", var57 + " is already on your friend list");
                                                   break;
                                                }
                                             }

                                             ++var6;
                                          }
                                       }
                                    } else {
                                       class96.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                                    }
                                 }

                                 var3 = 1;
                              } else if(var0 == 3606) {
                                 var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                                 if(var57 != null) {
                                    var33 = PacketBuffer.method3598(var57, class60.field718);
                                    if(var33 != null) {
                                       for(var6 = 0; var6 < Client.friendCount; ++var6) {
                                          var35 = Client.friends[var6];
                                          var66 = var35.name;
                                          var67 = PacketBuffer.method3598(var66, class60.field718);
                                          boolean var69;
                                          if(var57 != null && var66 != null) {
                                             if(!var57.startsWith("#") && !var66.startsWith("#")) {
                                                var69 = var33.equals(var67);
                                             } else {
                                                var69 = var57.equals(var66);
                                             }
                                          } else {
                                             var69 = false;
                                          }

                                          if(var69) {
                                             --Client.friendCount;

                                             for(var22 = var6; var22 < Client.friendCount; ++var22) {
                                                Client.friends[var22] = Client.friends[var22 + 1];
                                             }

                                             Client.field1042 = Client.cycleCntr;
                                             var47 = Actor.method1628(ClientPacket.field2396, Client.field952.field1478);
                                             var47.packetBuffer.putByte(Projectile.getLength(var57));
                                             var47.packetBuffer.putString(var57);
                                             Client.field952.method1951(var47);
                                             break;
                                          }
                                       }
                                    }
                                 }

                                 var3 = 1;
                              } else if(var0 == 3607) {
                                 var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                                 class34.method534(var57, false);
                                 var3 = 1;
                              } else if(var0 == 3608) {
                                 var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                                 class17.method143(var57);
                                 var3 = 1;
                              } else if(var0 == 3609) {
                                 var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                                 Permission[] var51 = class15.method112();

                                 for(var6 = 0; var6 < var51.length; ++var6) {
                                    Permission var38 = var51[var6];
                                    if(var38.field3240 != -1) {
                                       var21 = var38.field3240;
                                       var67 = "<img=" + var21 + ">";
                                       if(var57.startsWith(var67)) {
                                          var57 = var57.substring(6 + Integer.toString(var38.field3240).length());
                                          break;
                                       }
                                    }
                                 }

                                 class82.intStack[++class56.intStackSize - 1] = Client.isFriended(var57, false)?1:0;
                                 var3 = 1;
                              } else {
                                 int var12;
                                 int var13;
                                 char var14;
                                 long var25;
                                 String var41;
                                 String var45;
                                 String[] var74;
                                 if(var0 == 3611) {
                                    if(Client.clanChatOwner == null) {
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                                    } else {
                                       var74 = class82.scriptStringStack;
                                       var58 = ++class24.scriptStringStackSize - 1;
                                       var41 = Client.clanChatOwner;
                                       var25 = 0L;
                                       var12 = var41.length();

                                       for(var13 = 0; var13 < var12; ++var13) {
                                          var25 *= 37L;
                                          var14 = var41.charAt(var13);
                                          if(var14 >= 'A' && var14 <= 'Z') {
                                             var25 += (long)(var14 + 1 - 65);
                                          } else if(var14 >= 'a' && var14 <= 'z') {
                                             var25 += (long)(var14 + 1 - 97);
                                          } else if(var14 >= '0' && var14 <= '9') {
                                             var25 += (long)(var14 + 27 - 48);
                                          }

                                          if(var25 >= 177917621779460413L) {
                                             break;
                                          }
                                       }

                                       while(0L == var25 % 37L && 0L != var25) {
                                          var25 /= 37L;
                                       }

                                       var45 = Preferences.method1686(var25);
                                       if(var45 == null) {
                                          var45 = "";
                                       }

                                       var74[var58] = var45;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 3612) {
                                    if(Client.clanChatOwner != null) {
                                       class82.intStack[++class56.intStackSize - 1] = Client.clanChatCount;
                                    } else {
                                       class82.intStack[++class56.intStackSize - 1] = 0;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 3613) {
                                    var4 = class82.intStack[--class56.intStackSize];
                                    if(Client.clanChatOwner != null && var4 < Client.clanChatCount) {
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = DynamicObject.clanMembers[var4].username;
                                    } else {
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                                    }

                                    var3 = 1;
                                 } else if(var0 == 3614) {
                                    var4 = class82.intStack[--class56.intStackSize];
                                    if(Client.clanChatOwner != null && var4 < Client.clanChatCount) {
                                       class82.intStack[++class56.intStackSize - 1] = DynamicObject.clanMembers[var4].world;
                                    } else {
                                       class82.intStack[++class56.intStackSize - 1] = 0;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 3615) {
                                    var4 = class82.intStack[--class56.intStackSize];
                                    if(Client.clanChatOwner != null && var4 < Client.clanChatCount) {
                                       class82.intStack[++class56.intStackSize - 1] = DynamicObject.clanMembers[var4].rank;
                                    } else {
                                       class82.intStack[++class56.intStackSize - 1] = 0;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 3616) {
                                    class82.intStack[++class56.intStackSize - 1] = class70.field805;
                                    var3 = 1;
                                 } else if(var0 == 3617) {
                                    var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                                    class8.method45(var57);
                                    var3 = 1;
                                 } else if(var0 == 3618) {
                                    class82.intStack[++class56.intStackSize - 1] = class9.clanChatRank;
                                    var3 = 1;
                                 } else if(var0 == 3619) {
                                    var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                                    class18.method157(var57);
                                    var3 = 1;
                                 } else if(var0 == 3620) {
                                    Varcs.method1904();
                                    var3 = 1;
                                 } else if(var0 == 3621) {
                                    if(Client.field1021 == 0) {
                                       class82.intStack[++class56.intStackSize - 1] = -1;
                                    } else {
                                       class82.intStack[++class56.intStackSize - 1] = Client.ignoreCount;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 3622) {
                                    var4 = class82.intStack[--class56.intStackSize];
                                    if(Client.field1021 != 0 && var4 < Client.ignoreCount) {
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = Client.ignores[var4].name;
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = Client.ignores[var4].previousName;
                                    } else {
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                                    }

                                    var3 = 1;
                                 } else if(var0 == 3623) {
                                    label1856: {
                                       var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                                       var64 = "<img=0>";
                                       if(!var57.startsWith(var64)) {
                                          var66 = "<img=1>";
                                          if(!var57.startsWith(var66)) {
                                             break label1856;
                                          }
                                       }

                                       var57 = var57.substring(7);
                                    }

                                    class82.intStack[++class56.intStackSize - 1] = Tile.isIgnored(var57)?1:0;
                                    var3 = 1;
                                 } else if(var0 == 3624) {
                                    var4 = class82.intStack[--class56.intStackSize];
                                    if(DynamicObject.clanMembers != null && var4 < Client.clanChatCount && DynamicObject.clanMembers[var4].username.equalsIgnoreCase(class48.localPlayer.name)) {
                                       class82.intStack[++class56.intStackSize - 1] = 1;
                                    } else {
                                       class82.intStack[++class56.intStackSize - 1] = 0;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 3625) {
                                    if(Client.clanChatName == null) {
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                                    } else {
                                       var74 = class82.scriptStringStack;
                                       var58 = ++class24.scriptStringStackSize - 1;
                                       var41 = Client.clanChatName;
                                       var25 = 0L;
                                       var12 = var41.length();

                                       for(var13 = 0; var13 < var12; ++var13) {
                                          var25 *= 37L;
                                          var14 = var41.charAt(var13);
                                          if(var14 >= 'A' && var14 <= 'Z') {
                                             var25 += (long)(var14 + 1 - 65);
                                          } else if(var14 >= 'a' && var14 <= 'z') {
                                             var25 += (long)(var14 + 1 - 97);
                                          } else if(var14 >= '0' && var14 <= '9') {
                                             var25 += (long)(var14 + 27 - 48);
                                          }

                                          if(var25 >= 177917621779460413L) {
                                             break;
                                          }
                                       }

                                       while(var25 % 37L == 0L && 0L != var25) {
                                          var25 /= 37L;
                                       }

                                       var45 = Preferences.method1686(var25);
                                       if(var45 == null) {
                                          var45 = "";
                                       }

                                       var74[var58] = var45;
                                    }

                                    var3 = 1;
                                 } else {
                                    var3 = 2;
                                 }
                              }
                           }

                           return var3;
                        } else if(var0 < 4000) {
                           if(var0 == 3903) {
                              var4 = class82.intStack[--class56.intStackSize];
                              class82.intStack[++class56.intStackSize - 1] = Client.grandExchangeOffers[var4].method117();
                              var3 = 1;
                           } else if(var0 == 3904) {
                              var4 = class82.intStack[--class56.intStackSize];
                              class82.intStack[++class56.intStackSize - 1] = Client.grandExchangeOffers[var4].itemId;
                              var3 = 1;
                           } else if(var0 == 3905) {
                              var4 = class82.intStack[--class56.intStackSize];
                              class82.intStack[++class56.intStackSize - 1] = Client.grandExchangeOffers[var4].price;
                              var3 = 1;
                           } else if(var0 == 3906) {
                              var4 = class82.intStack[--class56.intStackSize];
                              class82.intStack[++class56.intStackSize - 1] = Client.grandExchangeOffers[var4].totalQuantity;
                              var3 = 1;
                           } else if(var0 == 3907) {
                              var4 = class82.intStack[--class56.intStackSize];
                              class82.intStack[++class56.intStackSize - 1] = Client.grandExchangeOffers[var4].quantitySold;
                              var3 = 1;
                           } else if(var0 == 3908) {
                              var4 = class82.intStack[--class56.intStackSize];
                              class82.intStack[++class56.intStackSize - 1] = Client.grandExchangeOffers[var4].spent;
                              var3 = 1;
                           } else if(var0 == 3910) {
                              var4 = class82.intStack[--class56.intStackSize];
                              var58 = Client.grandExchangeOffers[var4].method116();
                              class82.intStack[++class56.intStackSize - 1] = var58 == 0?1:0;
                              var3 = 1;
                           } else if(var0 == 3911) {
                              var4 = class82.intStack[--class56.intStackSize];
                              var58 = Client.grandExchangeOffers[var4].method116();
                              class82.intStack[++class56.intStackSize - 1] = var58 == 2?1:0;
                              var3 = 1;
                           } else if(var0 == 3912) {
                              var4 = class82.intStack[--class56.intStackSize];
                              var58 = Client.grandExchangeOffers[var4].method116();
                              class82.intStack[++class56.intStackSize - 1] = var58 == 5?1:0;
                              var3 = 1;
                           } else if(var0 == 3913) {
                              var4 = class82.intStack[--class56.intStackSize];
                              var58 = Client.grandExchangeOffers[var4].method116();
                              class82.intStack[++class56.intStackSize - 1] = var58 == 1?1:0;
                              var3 = 1;
                           } else {
                              boolean var56;
                              if(var0 == 3914) {
                                 var56 = class82.intStack[--class56.intStackSize] == 1;
                                 if(class175.field2446 != null) {
                                    class175.field2446.method82(class13.field277, var56);
                                 }

                                 var3 = 1;
                              } else if(var0 == 3915) {
                                 var56 = class82.intStack[--class56.intStackSize] == 1;
                                 if(class175.field2446 != null) {
                                    class175.field2446.method82(class13.field276, var56);
                                 }

                                 var3 = 1;
                              } else if(var0 == 3916) {
                                 class56.intStackSize -= 2;
                                 var56 = class82.intStack[class56.intStackSize] == 1;
                                 var16 = class82.intStack[class56.intStackSize + 1] == 1;
                                 if(class175.field2446 != null) {
                                    Client.field1126.field859 = var16;
                                    class175.field2446.method82(Client.field1126, var56);
                                 }

                                 var3 = 1;
                              } else if(var0 == 3917) {
                                 var56 = class82.intStack[--class56.intStackSize] == 1;
                                 if(class175.field2446 != null) {
                                    class175.field2446.method82(class13.field278, var56);
                                 }

                                 var3 = 1;
                              } else if(var0 == 3918) {
                                 var56 = class82.intStack[--class56.intStackSize] == 1;
                                 if(class175.field2446 != null) {
                                    class175.field2446.method82(class13.field274, var56);
                                 }

                                 var3 = 1;
                              } else if(var0 == 3919) {
                                 class82.intStack[++class56.intStackSize - 1] = class175.field2446 == null?0:class175.field2446.field275.size();
                                 var3 = 1;
                              } else {
                                 class14 var44;
                                 if(var0 == 3920) {
                                    var4 = class82.intStack[--class56.intStackSize];
                                    var44 = (class14)class175.field2446.field275.get(var4);
                                    class82.intStack[++class56.intStackSize - 1] = var44.field291;
                                    var3 = 1;
                                 } else if(var0 == 3921) {
                                    var4 = class82.intStack[--class56.intStackSize];
                                    var44 = (class14)class175.field2446.field275.get(var4);
                                    class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var44.method96();
                                    var3 = 1;
                                 } else if(var0 == 3922) {
                                    var4 = class82.intStack[--class56.intStackSize];
                                    var44 = (class14)class175.field2446.field275.get(var4);
                                    class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var44.method87();
                                    var3 = 1;
                                 } else if(var0 == 3923) {
                                    var4 = class82.intStack[--class56.intStackSize];
                                    var44 = (class14)class175.field2446.field275.get(var4);
                                    long var29 = class268.currentTimeMs() - class61.field735 - var44.field284;
                                    var8 = (int)(var29 / 3600000L);
                                    var9 = (int)((var29 - (long)(var8 * 3600000)) / 60000L);
                                    var21 = (int)((var29 - (long)(var8 * 3600000) - (long)(var9 * 60000)) / 1000L);
                                    String var46 = var8 + ":" + var9 / 10 + var9 % 10 + ":" + var21 / 10 + var21 % 10;
                                    class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var46;
                                    var3 = 1;
                                 } else if(var0 == 3924) {
                                    var4 = class82.intStack[--class56.intStackSize];
                                    var44 = (class14)class175.field2446.field275.get(var4);
                                    class82.intStack[++class56.intStackSize - 1] = var44.field285.totalQuantity;
                                    var3 = 1;
                                 } else if(var0 == 3925) {
                                    var4 = class82.intStack[--class56.intStackSize];
                                    var44 = (class14)class175.field2446.field275.get(var4);
                                    class82.intStack[++class56.intStackSize - 1] = var44.field285.price;
                                    var3 = 1;
                                 } else if(var0 == 3926) {
                                    var4 = class82.intStack[--class56.intStackSize];
                                    var44 = (class14)class175.field2446.field275.get(var4);
                                    class82.intStack[++class56.intStackSize - 1] = var44.field285.itemId;
                                    var3 = 1;
                                 } else {
                                    var3 = 2;
                                 }
                              }
                           }

                           return var3;
                        } else if(var0 < 4100) {
                           return class189.method3617(var0, var1, var2);
                        } else {
                           boolean var18;
                           if(var0 < 4200) {
                              if(var0 == 4100) {
                                 var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                                 var58 = class82.intStack[--class56.intStackSize];
                                 class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var57 + var58;
                                 var3 = 1;
                              } else if(var0 == 4101) {
                                 class24.scriptStringStackSize -= 2;
                                 var57 = class82.scriptStringStack[class24.scriptStringStackSize];
                                 var33 = class82.scriptStringStack[class24.scriptStringStackSize + 1];
                                 class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var57 + var33;
                                 var3 = 1;
                              } else if(var0 == 4102) {
                                 var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                                 var58 = class82.intStack[--class56.intStackSize];
                                 String[] var62 = class82.scriptStringStack;
                                 var61 = ++class24.scriptStringStackSize - 1;
                                 if(var58 < 0) {
                                    var67 = Integer.toString(var58);
                                 } else {
                                    var67 = class224.method4211(var58, 10, true);
                                 }

                                 var62[var61] = var57 + var67;
                                 var3 = 1;
                              } else if(var0 == 4103) {
                                 var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                                 class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var57.toLowerCase();
                                 var3 = 1;
                              } else if(var0 == 4104) {
                                 var4 = class82.intStack[--class56.intStackSize];
                                 long var23 = 86400000L * (11745L + (long)var4);
                                 class82.field1261.setTime(new Date(var23));
                                 var61 = class82.field1261.get(5);
                                 var8 = class82.field1261.get(2);
                                 var9 = class82.field1261.get(1);
                                 class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var61 + "-" + class82.field1266[var8] + "-" + var9;
                                 var3 = 1;
                              } else if(var0 == 4105) {
                                 class24.scriptStringStackSize -= 2;
                                 var57 = class82.scriptStringStack[class24.scriptStringStackSize];
                                 var33 = class82.scriptStringStack[class24.scriptStringStackSize + 1];
                                 if(class48.localPlayer.composition != null && class48.localPlayer.composition.isFemale) {
                                    class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var33;
                                 } else {
                                    class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var57;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4106) {
                                 var4 = class82.intStack[--class56.intStackSize];
                                 class82.scriptStringStack[++class24.scriptStringStackSize - 1] = Integer.toString(var4);
                                 var3 = 1;
                              } else if(var0 == 4107) {
                                 class24.scriptStringStackSize -= 2;
                                 class82.intStack[++class56.intStackSize - 1] = Friend.method1151(NPCComposition.method4836(class82.scriptStringStack[class24.scriptStringStackSize], class82.scriptStringStack[class24.scriptStringStackSize + 1], Client.languageId));
                                 var3 = 1;
                              } else {
                                 Font var20;
                                 byte[] var34;
                                 if(var0 == 4108) {
                                    var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                                    class56.intStackSize -= 2;
                                    var58 = class82.intStack[class56.intStackSize];
                                    var6 = class82.intStack[class56.intStackSize + 1];
                                    var34 = class27.field382.getConfigData(var6, 0);
                                    var20 = new Font(var34);
                                    class82.intStack[++class56.intStackSize - 1] = var20.method4929(var57, var58);
                                    var3 = 1;
                                 } else if(var0 == 4109) {
                                    var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                                    class56.intStackSize -= 2;
                                    var58 = class82.intStack[class56.intStackSize];
                                    var6 = class82.intStack[class56.intStackSize + 1];
                                    var34 = class27.field382.getConfigData(var6, 0);
                                    var20 = new Font(var34);
                                    class82.intStack[++class56.intStackSize - 1] = var20.method4956(var57, var58);
                                    var3 = 1;
                                 } else if(var0 == 4110) {
                                    class24.scriptStringStackSize -= 2;
                                    var57 = class82.scriptStringStack[class24.scriptStringStackSize];
                                    var33 = class82.scriptStringStack[class24.scriptStringStackSize + 1];
                                    if(class82.intStack[--class56.intStackSize] == 1) {
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var57;
                                    } else {
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var33;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 4111) {
                                    var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                                    class82.scriptStringStack[++class24.scriptStringStackSize - 1] = FontTypeFace.appendTags(var57);
                                    var3 = 1;
                                 } else if(var0 == 4112) {
                                    var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                                    var58 = class82.intStack[--class56.intStackSize];
                                    class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var57 + (char)var58;
                                    var3 = 1;
                                 } else if(var0 == 4113) {
                                    var4 = class82.intStack[--class56.intStackSize];
                                    class82.intStack[++class56.intStackSize - 1] = class40.method597((char)var4)?1:0;
                                    var3 = 1;
                                 } else {
                                    int[] var37;
                                    char var39;
                                    if(var0 == 4114) {
                                       var4 = class82.intStack[--class56.intStackSize];
                                       var37 = class82.intStack;
                                       var6 = ++class56.intStackSize - 1;
                                       var39 = (char)var4;
                                       var18 = var39 >= '0' && var39 <= '9' || var39 >= 'A' && var39 <= 'Z' || var39 >= 'a' && var39 <= 'z';
                                       var37[var6] = var18?1:0;
                                       var3 = 1;
                                    } else if(var0 == 4115) {
                                       var4 = class82.intStack[--class56.intStackSize];
                                       var37 = class82.intStack;
                                       var6 = ++class56.intStackSize - 1;
                                       var39 = (char)var4;
                                       var18 = var39 >= 'A' && var39 <= 'Z' || var39 >= 'a' && var39 <= 'z';
                                       var37[var6] = var18?1:0;
                                       var3 = 1;
                                    } else if(var0 == 4116) {
                                       var4 = class82.intStack[--class56.intStackSize];
                                       var37 = class82.intStack;
                                       var6 = ++class56.intStackSize - 1;
                                       var39 = (char)var4;
                                       var18 = var39 >= '0' && var39 <= '9';
                                       var37[var6] = var18?1:0;
                                       var3 = 1;
                                    } else if(var0 == 4117) {
                                       var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                                       if(var57 != null) {
                                          class82.intStack[++class56.intStackSize - 1] = var57.length();
                                       } else {
                                          class82.intStack[++class56.intStackSize - 1] = 0;
                                       }

                                       var3 = 1;
                                    } else if(var0 == 4118) {
                                       var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                                       class56.intStackSize -= 2;
                                       var58 = class82.intStack[class56.intStackSize];
                                       var6 = class82.intStack[class56.intStackSize + 1];
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var57.substring(var58, var6);
                                       var3 = 1;
                                    } else if(var0 == 4119) {
                                       var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                                       StringBuilder var42 = new StringBuilder(var57.length());
                                       boolean var40 = false;

                                       for(var61 = 0; var61 < var57.length(); ++var61) {
                                          var39 = var57.charAt(var61);
                                          if(var39 == '<') {
                                             var40 = true;
                                          } else if(var39 == '>') {
                                             var40 = false;
                                          } else if(!var40) {
                                             var42.append(var39);
                                          }
                                       }

                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var42.toString();
                                       var3 = 1;
                                    } else if(var0 == 4120) {
                                       var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                                       var58 = class82.intStack[--class56.intStackSize];
                                       class82.intStack[++class56.intStackSize - 1] = var57.indexOf(var58);
                                       var3 = 1;
                                    } else if(var0 == 4121) {
                                       class24.scriptStringStackSize -= 2;
                                       var57 = class82.scriptStringStack[class24.scriptStringStackSize];
                                       var33 = class82.scriptStringStack[class24.scriptStringStackSize + 1];
                                       var6 = class82.intStack[--class56.intStackSize];
                                       class82.intStack[++class56.intStackSize - 1] = var57.indexOf(var33, var6);
                                       var3 = 1;
                                    } else {
                                       var3 = 2;
                                    }
                                 }
                              }

                              return var3;
                           } else if(var0 < 4300) {
                              if(var0 == 4200) {
                                 var4 = class82.intStack[--class56.intStackSize];
                                 class82.scriptStringStack[++class24.scriptStringStackSize - 1] = class250.getItemDefinition(var4).name;
                                 var3 = 1;
                              } else {
                                 ItemComposition var60;
                                 if(var0 == 4201) {
                                    class56.intStackSize -= 2;
                                    var4 = class82.intStack[class56.intStackSize];
                                    var58 = class82.intStack[class56.intStackSize + 1];
                                    var60 = class250.getItemDefinition(var4);
                                    if(var58 >= 1 && var58 <= 5 && var60.groundActions[var58 - 1] != null) {
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var60.groundActions[var58 - 1];
                                    } else {
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                                    }

                                    var3 = 1;
                                 } else if(var0 == 4202) {
                                    class56.intStackSize -= 2;
                                    var4 = class82.intStack[class56.intStackSize];
                                    var58 = class82.intStack[class56.intStackSize + 1];
                                    var60 = class250.getItemDefinition(var4);
                                    if(var58 >= 1 && var58 <= 5 && var60.inventoryActions[var58 - 1] != null) {
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var60.inventoryActions[var58 - 1];
                                    } else {
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                                    }

                                    var3 = 1;
                                 } else if(var0 == 4203) {
                                    var4 = class82.intStack[--class56.intStackSize];
                                    class82.intStack[++class56.intStackSize - 1] = class250.getItemDefinition(var4).price;
                                    var3 = 1;
                                 } else if(var0 == 4204) {
                                    var4 = class82.intStack[--class56.intStackSize];
                                    class82.intStack[++class56.intStackSize - 1] = class250.getItemDefinition(var4).isStackable == 1?1:0;
                                    var3 = 1;
                                 } else {
                                    ItemComposition var31;
                                    if(var0 == 4205) {
                                       var4 = class82.intStack[--class56.intStackSize];
                                       var31 = class250.getItemDefinition(var4);
                                       if(var31.notedTemplate == -1 && var31.note >= 0) {
                                          class82.intStack[++class56.intStackSize - 1] = var31.note;
                                       } else {
                                          class82.intStack[++class56.intStackSize - 1] = var4;
                                       }

                                       var3 = 1;
                                    } else if(var0 == 4206) {
                                       var4 = class82.intStack[--class56.intStackSize];
                                       var31 = class250.getItemDefinition(var4);
                                       if(var31.notedTemplate >= 0 && var31.note >= 0) {
                                          class82.intStack[++class56.intStackSize - 1] = var31.note;
                                       } else {
                                          class82.intStack[++class56.intStackSize - 1] = var4;
                                       }

                                       var3 = 1;
                                    } else if(var0 == 4207) {
                                       var4 = class82.intStack[--class56.intStackSize];
                                       class82.intStack[++class56.intStackSize - 1] = class250.getItemDefinition(var4).isMembers?1:0;
                                       var3 = 1;
                                    } else if(var0 == 4208) {
                                       var4 = class82.intStack[--class56.intStackSize];
                                       var31 = class250.getItemDefinition(var4);
                                       if(var31.field3594 == -1 && var31.field3593 >= 0) {
                                          class82.intStack[++class56.intStackSize - 1] = var31.field3593;
                                       } else {
                                          class82.intStack[++class56.intStackSize - 1] = var4;
                                       }

                                       var3 = 1;
                                    } else if(var0 == 4209) {
                                       var4 = class82.intStack[--class56.intStackSize];
                                       var31 = class250.getItemDefinition(var4);
                                       if(var31.field3594 >= 0 && var31.field3593 >= 0) {
                                          class82.intStack[++class56.intStackSize - 1] = var31.field3593;
                                       } else {
                                          class82.intStack[++class56.intStackSize - 1] = var4;
                                       }

                                       var3 = 1;
                                    } else if(var0 == 4210) {
                                       var57 = class82.scriptStringStack[--class24.scriptStringStackSize];
                                       var58 = class82.intStack[--class56.intStackSize];
                                       class20.method172(var57, var58 == 1);
                                       class82.intStack[++class56.intStackSize - 1] = class43.field551;
                                       var3 = 1;
                                    } else if(var0 == 4211) {
                                       if(class54.field635 != null && Player.field843 < class43.field551) {
                                          class82.intStack[++class56.intStackSize - 1] = class54.field635[++Player.field843 - 1] & '\uffff';
                                       } else {
                                          class82.intStack[++class56.intStackSize - 1] = -1;
                                       }

                                       var3 = 1;
                                    } else if(var0 == 4212) {
                                       Player.field843 = 0;
                                       var3 = 1;
                                    } else {
                                       var3 = 2;
                                    }
                                 }
                              }

                              return var3;
                           } else if(var0 < 5100) {
                              return class8.method44(var0, var1, var2);
                           } else if(var0 < 5400) {
                              if(var0 == 5306) {
                                 int[] var55 = class82.intStack;
                                 var58 = ++class56.intStackSize - 1;
                                 var6 = Client.isResized?2:1;
                                 var55[var58] = var6;
                                 var3 = 1;
                              } else if(var0 == 5307) {
                                 var4 = class82.intStack[--class56.intStackSize];
                                 if(var4 == 1 || var4 == 2) {
                                    class23.method191(var4);
                                 }

                                 var3 = 1;
                              } else if(var0 == 5308) {
                                 class82.intStack[++class56.intStackSize - 1] = Buffer.preferences.screenType;
                                 var3 = 1;
                              } else if(var0 == 5309) {
                                 var4 = class82.intStack[--class56.intStackSize];
                                 if(var4 == 1 || var4 == 2) {
                                    Buffer.preferences.screenType = var4;
                                    class169.method3187();
                                 }

                                 var3 = 1;
                              } else {
                                 var3 = 2;
                              }

                              return var3;
                           } else if(var0 < 5600) {
                              if(var0 == 5504) {
                                 class56.intStackSize -= 2;
                                 var61 = class82.intStack[class56.intStackSize];
                                 var8 = class82.intStack[class56.intStackSize + 1];
                                 if(!Client.field1097) {
                                    Client.field932 = var61;
                                    Client.mapAngle = var8;
                                 }

                                 var3 = 1;
                              } else if(var0 == 5505) {
                                 class82.intStack[++class56.intStackSize - 1] = Client.field932;
                                 var3 = 1;
                              } else if(var0 == 5506) {
                                 class82.intStack[++class56.intStackSize - 1] = Client.mapAngle;
                                 var3 = 1;
                              } else if(var0 == 5530) {
                                 var61 = class82.intStack[--class56.intStackSize];
                                 if(var61 < 0) {
                                    var61 = 0;
                                 }

                                 Client.field950 = var61;
                                 var3 = 1;
                              } else if(var0 == 5531) {
                                 class82.intStack[++class56.intStackSize - 1] = Client.field950;
                                 var3 = 1;
                              } else {
                                 var3 = 2;
                              }

                              return var3;
                           } else if(var0 < 5700) {
                              if(var0 == 5630) {
                                 Client.field912 = 250;
                                 var3 = 1;
                              } else {
                                 var3 = 2;
                              }

                              return var3;
                           } else if(var0 < 6300) {
                              return class51.method840(var0, var1, var2);
                           } else if(var0 >= 6600) {
                              return var0 < 6700?class14.method93(var0, var1, var2):2;
                           } else {
                              if(var0 == 6500) {
                                 class82.intStack[++class56.intStackSize - 1] = class8.loadWorlds()?1:0;
                                 var3 = 1;
                              } else {
                                 World var15;
                                 if(var0 == 6501) {
                                    var15 = Frames.method2978();
                                    if(var15 != null) {
                                       class82.intStack[++class56.intStackSize - 1] = var15.id;
                                       class82.intStack[++class56.intStackSize - 1] = var15.mask;
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var15.activity;
                                       class82.intStack[++class56.intStackSize - 1] = var15.location;
                                       class82.intStack[++class56.intStackSize - 1] = var15.playerCount;
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var15.address;
                                    } else {
                                       class82.intStack[++class56.intStackSize - 1] = -1;
                                       class82.intStack[++class56.intStackSize - 1] = 0;
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                                       class82.intStack[++class56.intStackSize - 1] = 0;
                                       class82.intStack[++class56.intStackSize - 1] = 0;
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                                    }

                                    var3 = 1;
                                 } else if(var0 == 6502) {
                                    var15 = ItemComposition.method4799();
                                    if(var15 != null) {
                                       class82.intStack[++class56.intStackSize - 1] = var15.id;
                                       class82.intStack[++class56.intStackSize - 1] = var15.mask;
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var15.activity;
                                       class82.intStack[++class56.intStackSize - 1] = var15.location;
                                       class82.intStack[++class56.intStackSize - 1] = var15.playerCount;
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var15.address;
                                    } else {
                                       class82.intStack[++class56.intStackSize - 1] = -1;
                                       class82.intStack[++class56.intStackSize - 1] = 0;
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                                       class82.intStack[++class56.intStackSize - 1] = 0;
                                       class82.intStack[++class56.intStackSize - 1] = 0;
                                       class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                                    }

                                    var3 = 1;
                                 } else {
                                    World var5;
                                    if(var0 == 6506) {
                                       var4 = class82.intStack[--class56.intStackSize];
                                       var5 = null;

                                       for(var6 = 0; var6 < World.worldCount; ++var6) {
                                          if(var4 == Coordinates.worldList[var6].id) {
                                             var5 = Coordinates.worldList[var6];
                                             break;
                                          }
                                       }

                                       if(var5 != null) {
                                          class82.intStack[++class56.intStackSize - 1] = var5.id;
                                          class82.intStack[++class56.intStackSize - 1] = var5.mask;
                                          class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var5.activity;
                                          class82.intStack[++class56.intStackSize - 1] = var5.location;
                                          class82.intStack[++class56.intStackSize - 1] = var5.playerCount;
                                          class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var5.address;
                                       } else {
                                          class82.intStack[++class56.intStackSize - 1] = -1;
                                          class82.intStack[++class56.intStackSize - 1] = 0;
                                          class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                                          class82.intStack[++class56.intStackSize - 1] = 0;
                                          class82.intStack[++class56.intStackSize - 1] = 0;
                                          class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                                       }

                                       var3 = 1;
                                    } else if(var0 == 6507) {
                                       class56.intStackSize -= 4;
                                       var4 = class82.intStack[class56.intStackSize];
                                       var16 = class82.intStack[class56.intStackSize + 1] == 1;
                                       var6 = class82.intStack[class56.intStackSize + 2];
                                       var18 = class82.intStack[class56.intStackSize + 3] == 1;
                                       if(Coordinates.worldList != null) {
                                          class232.method4241(0, Coordinates.worldList.length - 1, var4, var16, var6, var18);
                                       }

                                       var3 = 1;
                                    } else if(var0 == 6511) {
                                       var4 = class82.intStack[--class56.intStackSize];
                                       if(var4 >= 0 && var4 < World.worldCount) {
                                          var5 = Coordinates.worldList[var4];
                                          class82.intStack[++class56.intStackSize - 1] = var5.id;
                                          class82.intStack[++class56.intStackSize - 1] = var5.mask;
                                          class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var5.activity;
                                          class82.intStack[++class56.intStackSize - 1] = var5.location;
                                          class82.intStack[++class56.intStackSize - 1] = var5.playerCount;
                                          class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var5.address;
                                       } else {
                                          class82.intStack[++class56.intStackSize - 1] = -1;
                                          class82.intStack[++class56.intStackSize - 1] = 0;
                                          class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                                          class82.intStack[++class56.intStackSize - 1] = 0;
                                          class82.intStack[++class56.intStackSize - 1] = 0;
                                          class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                                       }

                                       var3 = 1;
                                    } else if(var0 == 6512) {
                                       Client.field996 = class82.intStack[--class56.intStackSize] == 1;
                                       var3 = 1;
                                    } else {
                                       class258 var17;
                                       if(var0 == 6513) {
                                          class56.intStackSize -= 2;
                                          var4 = class82.intStack[class56.intStackSize];
                                          var58 = class82.intStack[class56.intStackSize + 1];
                                          var17 = PacketBuffer.method3597(var58);
                                          if(var17.method4611()) {
                                             class82.scriptStringStack[++class24.scriptStringStackSize - 1] = class94.getNpcDefinition(var4).method4828(var58, var17.field3442);
                                          } else {
                                             class82.intStack[++class56.intStackSize - 1] = class94.getNpcDefinition(var4).method4830(var58, var17.field3443);
                                          }

                                          var3 = 1;
                                       } else if(var0 == 6514) {
                                          class56.intStackSize -= 2;
                                          var4 = class82.intStack[class56.intStackSize];
                                          var58 = class82.intStack[class56.intStackSize + 1];
                                          var17 = PacketBuffer.method3597(var58);
                                          if(var17.method4611()) {
                                             class82.scriptStringStack[++class24.scriptStringStackSize - 1] = class24.getObjectDefinition(var4).method4705(var58, var17.field3442);
                                          } else {
                                             class82.intStack[++class56.intStackSize - 1] = class24.getObjectDefinition(var4).method4714(var58, var17.field3443);
                                          }

                                          var3 = 1;
                                       } else if(var0 == 6515) {
                                          class56.intStackSize -= 2;
                                          var4 = class82.intStack[class56.intStackSize];
                                          var58 = class82.intStack[class56.intStackSize + 1];
                                          var17 = PacketBuffer.method3597(var58);
                                          if(var17.method4611()) {
                                             class82.scriptStringStack[++class24.scriptStringStackSize - 1] = class250.getItemDefinition(var4).method4761(var58, var17.field3442);
                                          } else {
                                             class82.intStack[++class56.intStackSize - 1] = class250.getItemDefinition(var4).method4760(var58, var17.field3443);
                                          }

                                          var3 = 1;
                                       } else if(var0 == 6516) {
                                          class56.intStackSize -= 2;
                                          var4 = class82.intStack[class56.intStackSize];
                                          var58 = class82.intStack[class56.intStackSize + 1];
                                          var17 = PacketBuffer.method3597(var58);
                                          class259 var10;
                                          byte[] var11;
                                          class259 var19;
                                          if(var17.method4611()) {
                                             String[] var7 = class82.scriptStringStack;
                                             var8 = ++class24.scriptStringStackSize - 1;
                                             var10 = (class259)class259.field3448.get((long)var4);
                                             if(var10 != null) {
                                                var19 = var10;
                                             } else {
                                                var11 = class259.field3447.getConfigData(34, var4);
                                                var10 = new class259();
                                                if(var11 != null) {
                                                   var10.method4637(new Buffer(var11));
                                                }

                                                var10.method4644();
                                                class259.field3448.put(var10, (long)var4);
                                                var19 = var10;
                                             }

                                             var7[var8] = var19.method4640(var58, var17.field3442);
                                          } else {
                                             var32 = class82.intStack;
                                             var8 = ++class56.intStackSize - 1;
                                             var10 = (class259)class259.field3448.get((long)var4);
                                             if(var10 != null) {
                                                var19 = var10;
                                             } else {
                                                var11 = class259.field3447.getConfigData(34, var4);
                                                var10 = new class259();
                                                if(var11 != null) {
                                                   var10.method4637(new Buffer(var11));
                                                }

                                                var10.method4644();
                                                class259.field3448.put(var10, (long)var4);
                                                var19 = var10;
                                             }

                                             var32[var8] = var19.method4634(var58, var17.field3443);
                                          }

                                          var3 = 1;
                                       } else if(var0 == 6518) {
                                          class82.intStack[++class56.intStackSize - 1] = 0;
                                          var3 = 1;
                                       } else if(var0 == 6520) {
                                          var3 = 1;
                                       } else if(var0 == 6521) {
                                          var3 = 1;
                                       } else {
                                          var3 = 2;
                                       }
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lcd;I)V",
      garbageValue = "658480364"
   )
   static void method1222(World var0) {
      if(var0.method1640() != Client.isMembers) {
         Client.isMembers = var0.method1640();
         boolean var1 = var0.method1640();
         if(var1 != class246.isMembersWorld) {
            Client.method1500();
            class246.isMembersWorld = var1;
         }
      }

      MilliTimer.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      DynamicObject.field1456 = Client.socketType == 0?43594:var0.id + 40000;
      MessageNode.field815 = Client.socketType == 0?443:var0.id + 50000;
      class9.myWorldPort = DynamicObject.field1456;
   }
}
