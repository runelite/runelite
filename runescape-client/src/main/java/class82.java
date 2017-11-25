import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
public class class82 {
   @ObfuscatedName("k")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;
   @ObfuscatedName("v")
   static int[] field1262;
   @ObfuscatedName("m")
   @Export("SHAPE_VERTICES")
   static int[][] SHAPE_VERTICES;
   @ObfuscatedName("b")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("p")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1447236997
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1167454807
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "[Lbl;"
   )
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field1265;
   @ObfuscatedName("y")
   static Calendar field1260;
   @ObfuscatedName("j")
   static final String[] field1271;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1171611611
   )
   static int field1272;
   @ObfuscatedName("ax")
   static int[] field1274;
   @ObfuscatedName("aq")
   static int[] field1275;

   static {
      field1262 = new int[5];
      SHAPE_VERTICES = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1260 = Calendar.getInstance();
      field1271 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1272 = 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Z",
      garbageValue = "-1541905721"
   )
   public static boolean method1695(CharSequence var0) {
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
               if(var7 == '-') {
                  var2 = true;
                  break label83;
               }

               if(var7 == '+') {
                  break label83;
               }
            }

            int var9;
            if(var7 >= '0' && var7 <= '9') {
               var9 = var7 - '0';
            } else if(var7 >= 'A' && var7 <= 'Z') {
               var9 = var7 - '7';
            } else {
               if(var7 < 'a' || var7 > 'z') {
                  var1 = false;
                  break;
               }

               var9 = var7 - 'W';
            }

            if(var9 >= 10) {
               var1 = false;
               break;
            }

            if(var2) {
               var9 = -var9;
            }

            int var8 = var9 + var4 * 10;
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILce;ZI)I",
      garbageValue = "-1711735650"
   )
   static int method1715(int var0, Script var1, boolean var2) {
      if(var0 < 1000) {
         return GroundObject.method2601(var0, var1, var2);
      } else if(var0 < 1100) {
         return class19.method162(var0, var1, var2);
      } else if(var0 < 1200) {
         return class10.method63(var0, var1, var2);
      } else if(var0 < 1300) {
         return GrandExchangeOffer.method119(var0, var1, var2);
      } else if(var0 < 1400) {
         return class48.method740(var0, var1, var2);
      } else if(var0 < 1500) {
         return class18.method152(var0, var1, var2);
      } else if(var0 < 1600) {
         return class148.method3021(var0, var1, var2);
      } else {
         byte var3;
         Widget var29;
         if(var0 < 1700) {
            var29 = var2?class54.field636:field1265;
            if(var0 == 1600) {
               intStack[++class13.intStackSize - 1] = var29.scrollX;
               var3 = 1;
            } else if(var0 == 1601) {
               intStack[++class13.intStackSize - 1] = var29.scrollY;
               var3 = 1;
            } else if(var0 == 1602) {
               scriptStringStack[++scriptStringStackSize - 1] = var29.text;
               var3 = 1;
            } else if(var0 == 1603) {
               intStack[++class13.intStackSize - 1] = var29.scrollWidth;
               var3 = 1;
            } else if(var0 == 1604) {
               intStack[++class13.intStackSize - 1] = var29.scrollHeight;
               var3 = 1;
            } else if(var0 == 1605) {
               intStack[++class13.intStackSize - 1] = var29.modelZoom;
               var3 = 1;
            } else if(var0 == 1606) {
               intStack[++class13.intStackSize - 1] = var29.rotationX;
               var3 = 1;
            } else if(var0 == 1607) {
               intStack[++class13.intStackSize - 1] = var29.rotationY;
               var3 = 1;
            } else if(var0 == 1608) {
               intStack[++class13.intStackSize - 1] = var29.rotationZ;
               var3 = 1;
            } else if(var0 == 1609) {
               intStack[++class13.intStackSize - 1] = var29.opacity;
               var3 = 1;
            } else if(var0 == 1610) {
               intStack[++class13.intStackSize - 1] = var29.field2729;
               var3 = 1;
            } else if(var0 == 1611) {
               intStack[++class13.intStackSize - 1] = var29.textColor;
               var3 = 1;
            } else if(var0 == 1612) {
               intStack[++class13.intStackSize - 1] = var29.field2750;
               var3 = 1;
            } else if(var0 == 1613) {
               intStack[++class13.intStackSize - 1] = var29.field2754.rsOrdinal();
               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else {
            Widget var25;
            if(var0 < 1800) {
               var25 = var2?class54.field636:field1265;
               if(var0 == 1700) {
                  intStack[++class13.intStackSize - 1] = var25.itemId;
                  var3 = 1;
               } else if(var0 == 1701) {
                  if(var25.itemId != -1) {
                     intStack[++class13.intStackSize - 1] = var25.itemQuantity;
                  } else {
                     intStack[++class13.intStackSize - 1] = 0;
                  }

                  var3 = 1;
               } else if(var0 == 1702) {
                  intStack[++class13.intStackSize - 1] = var25.index;
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 1900) {
               return class27.method219(var0, var1, var2);
            } else {
               int var12;
               Widget var31;
               ScriptEvent var37;
               if(var0 < 2000) {
                  var12 = var0;
                  if(var0 >= 2000) {
                     var12 = var0 - 1000;
                     var31 = class87.method1762(intStack[--class13.intStackSize]);
                  } else {
                     var31 = var2?class54.field636:field1265;
                  }

                  if(var12 == 1927) {
                     if(field1272 >= 10) {
                        throw new RuntimeException();
                     }

                     if(var31.field2833 == null) {
                        var3 = 0;
                     } else {
                        var37 = new ScriptEvent();
                        var37.widget = var31;
                        var37.field797 = var31.field2833;
                        var37.field807 = field1272 + 1;
                        Client.field1010.addFront(var37);
                        var3 = 1;
                     }
                  } else {
                     var3 = 2;
                  }

                  return var3;
               } else if(var0 < 2100) {
                  return class19.method162(var0, var1, var2);
               } else if(var0 < 2200) {
                  return class10.method63(var0, var1, var2);
               } else if(var0 < 2300) {
                  return GrandExchangeOffer.method119(var0, var1, var2);
               } else if(var0 < 2400) {
                  return class48.method740(var0, var1, var2);
               } else if(var0 < 2500) {
                  return class18.method152(var0, var1, var2);
               } else if(var0 < 2600) {
                  var29 = class87.method1762(intStack[--class13.intStackSize]);
                  if(var0 == 2500) {
                     intStack[++class13.intStackSize - 1] = var29.relativeX;
                     var3 = 1;
                  } else if(var0 == 2501) {
                     intStack[++class13.intStackSize - 1] = var29.relativeY;
                     var3 = 1;
                  } else if(var0 == 2502) {
                     intStack[++class13.intStackSize - 1] = var29.width;
                     var3 = 1;
                  } else if(var0 == 2503) {
                     intStack[++class13.intStackSize - 1] = var29.height;
                     var3 = 1;
                  } else if(var0 == 2504) {
                     intStack[++class13.intStackSize - 1] = var29.isHidden?1:0;
                     var3 = 1;
                  } else if(var0 == 2505) {
                     intStack[++class13.intStackSize - 1] = var29.parentId;
                     var3 = 1;
                  } else {
                     var3 = 2;
                  }

                  return var3;
               } else if(var0 < 2700) {
                  return class18.method155(var0, var1, var2);
               } else if(var0 < 2800) {
                  if(var0 == 2700) {
                     var29 = class87.method1762(intStack[--class13.intStackSize]);
                     intStack[++class13.intStackSize - 1] = var29.itemId;
                     var3 = 1;
                  } else if(var0 == 2701) {
                     var29 = class87.method1762(intStack[--class13.intStackSize]);
                     if(var29.itemId != -1) {
                        intStack[++class13.intStackSize - 1] = var29.itemQuantity;
                     } else {
                        intStack[++class13.intStackSize - 1] = 0;
                     }

                     var3 = 1;
                  } else if(var0 == 2702) {
                     var12 = intStack[--class13.intStackSize];
                     WidgetNode var33 = (WidgetNode)Client.componentTable.get((long)var12);
                     if(var33 != null) {
                        intStack[++class13.intStackSize - 1] = 1;
                     } else {
                        intStack[++class13.intStackSize - 1] = 0;
                     }

                     var3 = 1;
                  } else if(var0 == 2706) {
                     intStack[++class13.intStackSize - 1] = Client.widgetRoot;
                     var3 = 1;
                  } else {
                     var3 = 2;
                  }

                  return var3;
               } else {
                  int var6;
                  int var8;
                  int var14;
                  int var15;
                  if(var0 < 2900) {
                     var29 = class87.method1762(intStack[--class13.intStackSize]);
                     if(var0 == 2800) {
                        int[] var32 = intStack;
                        var6 = ++class13.intStackSize - 1;
                        var8 = ClanMember.getWidgetConfig(var29);
                        var14 = var8 >> 11 & 63;
                        var32[var6] = var14;
                        var3 = 1;
                     } else if(var0 == 2801) {
                        var15 = intStack[--class13.intStackSize];
                        --var15;
                        if(var29.actions != null && var15 < var29.actions.length && var29.actions[var15] != null) {
                           scriptStringStack[++scriptStringStackSize - 1] = var29.actions[var15];
                        } else {
                           scriptStringStack[++scriptStringStackSize - 1] = "";
                        }

                        var3 = 1;
                     } else if(var0 == 2802) {
                        if(var29.name == null) {
                           scriptStringStack[++scriptStringStackSize - 1] = "";
                        } else {
                           scriptStringStack[++scriptStringStackSize - 1] = var29.name;
                        }

                        var3 = 1;
                     } else {
                        var3 = 2;
                     }

                     return var3;
                  } else if(var0 < 3000) {
                     var12 = var0;
                     if(var0 >= 2000) {
                        var12 = var0 - 1000;
                        var31 = class87.method1762(intStack[--class13.intStackSize]);
                     } else {
                        var31 = var2?class54.field636:field1265;
                     }

                     if(var12 == 1927) {
                        if(field1272 >= 10) {
                           throw new RuntimeException();
                        }

                        if(var31.field2833 == null) {
                           var3 = 0;
                        } else {
                           var37 = new ScriptEvent();
                           var37.widget = var31;
                           var37.field797 = var31.field2833;
                           var37.field807 = field1272 + 1;
                           Client.field1010.addFront(var37);
                           var3 = 1;
                        }
                     } else {
                        var3 = 2;
                     }

                     return var3;
                  } else {
                     String var4;
                     PacketNode var5;
                     String var27;
                     PacketNode var34;
                     boolean var38;
                     if(var0 < 3200) {
                        if(var0 == 3100) {
                           var4 = scriptStringStack[--scriptStringStackSize];
                           class54.sendGameMessage(0, "", var4);
                           var3 = 1;
                        } else if(var0 == 3101) {
                           class13.intStackSize -= 2;
                           class70.method1130(class181.localPlayer, intStack[class13.intStackSize], intStack[class13.intStackSize + 1]);
                           var3 = 1;
                        } else if(var0 == 3103) {
                           WorldMapType1.method268();
                           var3 = 1;
                        } else if(var0 == 3104) {
                           var4 = scriptStringStack[--scriptStringStackSize];
                           var15 = 0;
                           if(method1695(var4)) {
                              var15 = class37.method510(var4);
                           }

                           var34 = class218.method4105(ClientPacket.field2376, Client.field916.field1470);
                           var34.packetBuffer.putInt(var15);
                           Client.field916.method1925(var34);
                           var3 = 1;
                        } else if(var0 == 3105) {
                           var4 = scriptStringStack[--scriptStringStackSize];
                           var5 = class218.method4105(ClientPacket.field2307, Client.field916.field1470);
                           var5.packetBuffer.putByte(var4.length() + 1);
                           var5.packetBuffer.putString(var4);
                           Client.field916.method1925(var5);
                           var3 = 1;
                        } else if(var0 == 3106) {
                           var4 = scriptStringStack[--scriptStringStackSize];
                           var5 = class218.method4105(ClientPacket.field2394, Client.field916.field1470);
                           var5.packetBuffer.putByte(var4.length() + 1);
                           var5.packetBuffer.putString(var4);
                           Client.field916.method1925(var5);
                           var3 = 1;
                        } else if(var0 == 3107) {
                           var12 = intStack[--class13.intStackSize];
                           var27 = scriptStringStack[--scriptStringStackSize];
                           class11.method65(var12, var27);
                           var3 = 1;
                        } else if(var0 == 3108) {
                           class13.intStackSize -= 3;
                           var12 = intStack[class13.intStackSize];
                           var15 = intStack[class13.intStackSize + 1];
                           var6 = intStack[class13.intStackSize + 2];
                           var25 = class87.method1762(var6);
                           class90.method1767(var25, var12, var15);
                           var3 = 1;
                        } else if(var0 == 3109) {
                           class13.intStackSize -= 2;
                           var12 = intStack[class13.intStackSize];
                           var15 = intStack[class13.intStackSize + 1];
                           Widget var35 = var2?class54.field636:field1265;
                           class90.method1767(var35, var12, var15);
                           var3 = 1;
                        } else if(var0 == 3110) {
                           Client.field956 = intStack[--class13.intStackSize] == 1;
                           var3 = 1;
                        } else if(var0 == 3111) {
                           intStack[++class13.intStackSize - 1] = RSCanvas.preferences.hideRoofs?1:0;
                           var3 = 1;
                        } else if(var0 == 3112) {
                           RSCanvas.preferences.hideRoofs = intStack[--class13.intStackSize] == 1;
                           class64.method1103();
                           var3 = 1;
                        } else if(var0 == 3113) {
                           var4 = scriptStringStack[--scriptStringStackSize];
                           var38 = intStack[--class13.intStackSize] == 1;
                           MessageNode.method1132(var4, var38, false);
                           var3 = 1;
                        } else if(var0 == 3115) {
                           var12 = intStack[--class13.intStackSize];
                           var5 = class218.method4105(ClientPacket.field2314, Client.field916.field1470);
                           var5.packetBuffer.putShort(var12);
                           Client.field916.method1925(var5);
                           var3 = 1;
                        } else if(var0 == 3116) {
                           var12 = intStack[--class13.intStackSize];
                           scriptStringStackSize -= 2;
                           var27 = scriptStringStack[scriptStringStackSize];
                           String var36 = scriptStringStack[scriptStringStackSize + 1];
                           if(var27.length() > 500) {
                              var3 = 1;
                           } else if(var36.length() > 500) {
                              var3 = 1;
                           } else {
                              PacketNode var26 = class218.method4105(ClientPacket.field2383, Client.field916.field1470);
                              var26.packetBuffer.putShort(1 + AbstractSoundSystem.getLength(var27) + AbstractSoundSystem.getLength(var36));
                              var26.packetBuffer.putString(var27);
                              var26.packetBuffer.putString(var36);
                              var26.packetBuffer.putByte(var12);
                              Client.field916.method1925(var26);
                              var3 = 1;
                           }
                        } else if(var0 == 3117) {
                           Client.field1002 = intStack[--class13.intStackSize] == 1;
                           var3 = 1;
                        } else {
                           var3 = 2;
                        }

                        return var3;
                     } else if(var0 < 3300) {
                        return class9.method55(var0, var1, var2);
                     } else if(var0 < 3400) {
                        return class209.method3828(var0, var1, var2);
                     } else if(var0 < 3500) {
                        return class285.method5112(var0, var1, var2);
                     } else if(var0 < 3700) {
                        if(var0 == 3600) {
                           if(Client.field1022 == 0) {
                              intStack[++class13.intStackSize - 1] = -2;
                           } else if(Client.field1022 == 1) {
                              intStack[++class13.intStackSize - 1] = -1;
                           } else {
                              intStack[++class13.intStackSize - 1] = Client.friendCount;
                           }

                           var3 = 1;
                        } else if(var0 == 3601) {
                           var12 = intStack[--class13.intStackSize];
                           if(Client.field1022 == 2 && var12 < Client.friendCount) {
                              scriptStringStack[++scriptStringStackSize - 1] = Client.friends[var12].name;
                              scriptStringStack[++scriptStringStackSize - 1] = Client.friends[var12].previousName;
                           } else {
                              scriptStringStack[++scriptStringStackSize - 1] = "";
                              scriptStringStack[++scriptStringStackSize - 1] = "";
                           }

                           var3 = 1;
                        } else if(var0 == 3602) {
                           var12 = intStack[--class13.intStackSize];
                           if(Client.field1022 == 2 && var12 < Client.friendCount) {
                              intStack[++class13.intStackSize - 1] = Client.friends[var12].world;
                           } else {
                              intStack[++class13.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        } else if(var0 == 3603) {
                           var12 = intStack[--class13.intStackSize];
                           if(Client.field1022 == 2 && var12 < Client.friendCount) {
                              intStack[++class13.intStackSize - 1] = Client.friends[var12].rank;
                           } else {
                              intStack[++class13.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        } else if(var0 == 3604) {
                           var4 = scriptStringStack[--scriptStringStackSize];
                           var15 = intStack[--class13.intStackSize];
                           var34 = class218.method4105(ClientPacket.field2348, Client.field916.field1470);
                           var34.packetBuffer.putByte(AbstractSoundSystem.getLength(var4) + 1);
                           var34.packetBuffer.method3322(var15);
                           var34.packetBuffer.putString(var4);
                           Client.field916.method1925(var34);
                           var3 = 1;
                        } else {
                           String var9;
                           String var16;
                           Ignore var23;
                           if(var0 == 3605) {
                              var4 = scriptStringStack[--scriptStringStackSize];
                              if(var4 != null) {
                                 if((Client.friendCount < 200 || Client.field976 == 1) && Client.friendCount < 400) {
                                    var27 = GraphicsObject.method1726(var4, class236.field3239);
                                    if(var27 != null) {
                                       var6 = 0;

                                       label1269:
                                       while(true) {
                                          if(var6 >= Client.friendCount) {
                                             for(var6 = 0; var6 < Client.ignoreCount; ++var6) {
                                                var23 = Client.ignores[var6];
                                                var16 = GraphicsObject.method1726(var23.name, class236.field3239);
                                                if(var16 != null && var16.equals(var27)) {
                                                   class54.sendGameMessage(30, "", "Please remove " + var4 + " from your ignore list first");
                                                   break label1269;
                                                }

                                                if(var23.previousName != null) {
                                                   var9 = GraphicsObject.method1726(var23.previousName, class236.field3239);
                                                   if(var9 != null && var9.equals(var27)) {
                                                      class54.sendGameMessage(30, "", "Please remove " + var4 + " from your ignore list first");
                                                      break label1269;
                                                   }
                                                }
                                             }

                                             if(GraphicsObject.method1726(class181.localPlayer.name, class236.field3239).equals(var27)) {
                                                class54.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
                                             } else {
                                                var34 = class218.method4105(ClientPacket.field2310, Client.field916.field1470);
                                                var34.packetBuffer.putByte(AbstractSoundSystem.getLength(var4));
                                                var34.packetBuffer.putString(var4);
                                                Client.field916.method1925(var34);
                                             }
                                             break;
                                          }

                                          Friend var7 = Client.friends[var6];
                                          var16 = GraphicsObject.method1726(var7.name, class236.field3239);
                                          if(var16 != null && var16.equals(var27)) {
                                             class54.sendGameMessage(30, "", var4 + " is already on your friend list");
                                             break;
                                          }

                                          if(var7.previousName != null) {
                                             var9 = GraphicsObject.method1726(var7.previousName, class236.field3239);
                                             if(var9 != null && var9.equals(var27)) {
                                                class54.sendGameMessage(30, "", var4 + " is already on your friend list");
                                                break;
                                             }
                                          }

                                          ++var6;
                                       }
                                    }
                                 } else {
                                    class54.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                                 }
                              }

                              var3 = 1;
                           } else if(var0 == 3606) {
                              var4 = scriptStringStack[--scriptStringStackSize];
                              class188.method3609(var4);
                              var3 = 1;
                           } else if(var0 == 3607) {
                              var4 = scriptStringStack[--scriptStringStackSize];
                              GrandExchangeOffer.method131(var4, false);
                              var3 = 1;
                           } else if(var0 == 3608) {
                              var4 = scriptStringStack[--scriptStringStackSize];
                              if(var4 != null) {
                                 var27 = GraphicsObject.method1726(var4, class236.field3239);
                                 if(var27 != null) {
                                    for(var6 = 0; var6 < Client.ignoreCount; ++var6) {
                                       var23 = Client.ignores[var6];
                                       var16 = var23.name;
                                       var9 = GraphicsObject.method1726(var16, class236.field3239);
                                       boolean var30;
                                       if(var4 != null && var16 != null) {
                                          if(!var4.startsWith("#") && !var16.startsWith("#")) {
                                             var30 = var27.equals(var9);
                                          } else {
                                             var30 = var4.equals(var16);
                                          }
                                       } else {
                                          var30 = false;
                                       }

                                       if(var30) {
                                          --Client.ignoreCount;

                                          for(int var11 = var6; var11 < Client.ignoreCount; ++var11) {
                                             Client.ignores[var11] = Client.ignores[var11 + 1];
                                          }

                                          Client.field977 = Client.cycleCntr;
                                          PacketNode var39 = class218.method4105(ClientPacket.field2342, Client.field916.field1470);
                                          var39.packetBuffer.putByte(AbstractSoundSystem.getLength(var4));
                                          var39.packetBuffer.putString(var4);
                                          Client.field916.method1925(var39);
                                          break;
                                       }
                                    }
                                 }
                              }

                              var3 = 1;
                           } else if(var0 == 3609) {
                              var4 = scriptStringStack[--scriptStringStackSize];
                              Permission[] var28 = class61.method1087();

                              for(var6 = 0; var6 < var28.length; ++var6) {
                                 Permission var24 = var28[var6];
                                 if(var24.field3251 != -1 && var4.startsWith(Client.method1570(var24.field3251))) {
                                    var4 = var4.substring(6 + Integer.toString(var24.field3251).length());
                                    break;
                                 }
                              }

                              intStack[++class13.intStackSize - 1] = class2.isFriended(var4, false)?1:0;
                              var3 = 1;
                           } else if(var0 == 3611) {
                              if(Client.clanChatOwner != null) {
                                 scriptStringStack[++scriptStringStackSize - 1] = class29.method245(Client.clanChatOwner);
                              } else {
                                 scriptStringStack[++scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else if(var0 == 3612) {
                              if(Client.clanChatOwner != null) {
                                 intStack[++class13.intStackSize - 1] = class61.clanChatCount;
                              } else {
                                 intStack[++class13.intStackSize - 1] = 0;
                              }

                              var3 = 1;
                           } else if(var0 == 3613) {
                              var12 = intStack[--class13.intStackSize];
                              if(Client.clanChatOwner != null && var12 < class61.clanChatCount) {
                                 scriptStringStack[++scriptStringStackSize - 1] = class188.clanMembers[var12].username;
                              } else {
                                 scriptStringStack[++scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else if(var0 == 3614) {
                              var12 = intStack[--class13.intStackSize];
                              if(Client.clanChatOwner != null && var12 < class61.clanChatCount) {
                                 intStack[++class13.intStackSize - 1] = class188.clanMembers[var12].world;
                              } else {
                                 intStack[++class13.intStackSize - 1] = 0;
                              }

                              var3 = 1;
                           } else if(var0 == 3615) {
                              var12 = intStack[--class13.intStackSize];
                              if(Client.clanChatOwner != null && var12 < class61.clanChatCount) {
                                 intStack[++class13.intStackSize - 1] = class188.clanMembers[var12].rank;
                              } else {
                                 intStack[++class13.intStackSize - 1] = 0;
                              }

                              var3 = 1;
                           } else if(var0 == 3616) {
                              intStack[++class13.intStackSize - 1] = class60.field720;
                              var3 = 1;
                           } else if(var0 == 3617) {
                              var4 = scriptStringStack[--scriptStringStackSize];
                              if(class188.clanMembers != null) {
                                 var5 = class218.method4105(ClientPacket.field2374, Client.field916.field1470);
                                 var5.packetBuffer.putByte(AbstractSoundSystem.getLength(var4));
                                 var5.packetBuffer.putString(var4);
                                 Client.field916.method1925(var5);
                              }

                              var3 = 1;
                           } else if(var0 == 3618) {
                              intStack[++class13.intStackSize - 1] = class14.clanChatRank;
                              var3 = 1;
                           } else if(var0 == 3619) {
                              var4 = scriptStringStack[--scriptStringStackSize];
                              Coordinates.method4122(var4);
                              var3 = 1;
                           } else if(var0 == 3620) {
                              class19.method168();
                              var3 = 1;
                           } else if(var0 == 3621) {
                              if(Client.field1022 == 0) {
                                 intStack[++class13.intStackSize - 1] = -1;
                              } else {
                                 intStack[++class13.intStackSize - 1] = Client.ignoreCount;
                              }

                              var3 = 1;
                           } else if(var0 == 3622) {
                              var12 = intStack[--class13.intStackSize];
                              if(Client.field1022 != 0 && var12 < Client.ignoreCount) {
                                 scriptStringStack[++scriptStringStackSize - 1] = Client.ignores[var12].name;
                                 scriptStringStack[++scriptStringStackSize - 1] = Client.ignores[var12].previousName;
                              } else {
                                 scriptStringStack[++scriptStringStackSize - 1] = "";
                                 scriptStringStack[++scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else if(var0 == 3623) {
                              var4 = scriptStringStack[--scriptStringStackSize];
                              if(var4.startsWith(Client.method1570(0)) || var4.startsWith(Client.method1570(1))) {
                                 var4 = var4.substring(7);
                              }

                              intStack[++class13.intStackSize - 1] = class29.isIgnored(var4)?1:0;
                              var3 = 1;
                           } else if(var0 == 3624) {
                              var12 = intStack[--class13.intStackSize];
                              if(class188.clanMembers != null && var12 < class61.clanChatCount && class188.clanMembers[var12].username.equalsIgnoreCase(class181.localPlayer.name)) {
                                 intStack[++class13.intStackSize - 1] = 1;
                              } else {
                                 intStack[++class13.intStackSize - 1] = 0;
                              }

                              var3 = 1;
                           } else if(var0 == 3625) {
                              if(Client.clanChatName != null) {
                                 scriptStringStack[++scriptStringStackSize - 1] = class29.method245(Client.clanChatName);
                              } else {
                                 scriptStringStack[++scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else {
                              var3 = 2;
                           }
                        }

                        return var3;
                     } else if(var0 < 4000) {
                        if(var0 == 3903) {
                           var12 = intStack[--class13.intStackSize];
                           intStack[++class13.intStackSize - 1] = Client.grandExchangeOffers[var12].method110();
                           var3 = 1;
                        } else if(var0 == 3904) {
                           var12 = intStack[--class13.intStackSize];
                           intStack[++class13.intStackSize - 1] = Client.grandExchangeOffers[var12].itemId;
                           var3 = 1;
                        } else if(var0 == 3905) {
                           var12 = intStack[--class13.intStackSize];
                           intStack[++class13.intStackSize - 1] = Client.grandExchangeOffers[var12].price;
                           var3 = 1;
                        } else if(var0 == 3906) {
                           var12 = intStack[--class13.intStackSize];
                           intStack[++class13.intStackSize - 1] = Client.grandExchangeOffers[var12].totalQuantity;
                           var3 = 1;
                        } else if(var0 == 3907) {
                           var12 = intStack[--class13.intStackSize];
                           intStack[++class13.intStackSize - 1] = Client.grandExchangeOffers[var12].quantitySold;
                           var3 = 1;
                        } else if(var0 == 3908) {
                           var12 = intStack[--class13.intStackSize];
                           intStack[++class13.intStackSize - 1] = Client.grandExchangeOffers[var12].spent;
                           var3 = 1;
                        } else if(var0 == 3910) {
                           var12 = intStack[--class13.intStackSize];
                           var15 = Client.grandExchangeOffers[var12].method109();
                           intStack[++class13.intStackSize - 1] = var15 == 0?1:0;
                           var3 = 1;
                        } else if(var0 == 3911) {
                           var12 = intStack[--class13.intStackSize];
                           var15 = Client.grandExchangeOffers[var12].method109();
                           intStack[++class13.intStackSize - 1] = var15 == 2?1:0;
                           var3 = 1;
                        } else if(var0 == 3912) {
                           var12 = intStack[--class13.intStackSize];
                           var15 = Client.grandExchangeOffers[var12].method109();
                           intStack[++class13.intStackSize - 1] = var15 == 5?1:0;
                           var3 = 1;
                        } else if(var0 == 3913) {
                           var12 = intStack[--class13.intStackSize];
                           var15 = Client.grandExchangeOffers[var12].method109();
                           intStack[++class13.intStackSize - 1] = var15 == 1?1:0;
                           var3 = 1;
                        } else {
                           boolean var40;
                           if(var0 == 3914) {
                              var40 = intStack[--class13.intStackSize] == 1;
                              if(BaseVarType.field27 != null) {
                                 BaseVarType.field27.method84(class13.field264, var40);
                              }

                              var3 = 1;
                           } else if(var0 == 3915) {
                              var40 = intStack[--class13.intStackSize] == 1;
                              if(BaseVarType.field27 != null) {
                                 BaseVarType.field27.method84(class13.field271, var40);
                              }

                              var3 = 1;
                           } else if(var0 == 3916) {
                              class13.intStackSize -= 2;
                              var40 = intStack[class13.intStackSize] == 1;
                              var38 = intStack[class13.intStackSize + 1] == 1;
                              if(BaseVarType.field27 != null) {
                                 Client.field1129.field863 = var38;
                                 BaseVarType.field27.method84(Client.field1129, var40);
                              }

                              var3 = 1;
                           } else if(var0 == 3917) {
                              var40 = intStack[--class13.intStackSize] == 1;
                              if(BaseVarType.field27 != null) {
                                 BaseVarType.field27.method84(class13.field266, var40);
                              }

                              var3 = 1;
                           } else if(var0 == 3918) {
                              var40 = intStack[--class13.intStackSize] == 1;
                              if(BaseVarType.field27 != null) {
                                 BaseVarType.field27.method84(class13.field263, var40);
                              }

                              var3 = 1;
                           } else if(var0 == 3919) {
                              intStack[++class13.intStackSize - 1] = BaseVarType.field27 == null?0:BaseVarType.field27.field265.size();
                              var3 = 1;
                           } else {
                              class14 var22;
                              if(var0 == 3920) {
                                 var12 = intStack[--class13.intStackSize];
                                 var22 = (class14)BaseVarType.field27.field265.get(var12);
                                 intStack[++class13.intStackSize - 1] = var22.field280;
                                 var3 = 1;
                              } else if(var0 == 3921) {
                                 var12 = intStack[--class13.intStackSize];
                                 var22 = (class14)BaseVarType.field27.field265.get(var12);
                                 scriptStringStack[++scriptStringStackSize - 1] = var22.method93();
                                 var3 = 1;
                              } else if(var0 == 3922) {
                                 var12 = intStack[--class13.intStackSize];
                                 var22 = (class14)BaseVarType.field27.field265.get(var12);
                                 scriptStringStack[++scriptStringStackSize - 1] = var22.method94();
                                 var3 = 1;
                              } else if(var0 == 3923) {
                                 var12 = intStack[--class13.intStackSize];
                                 var22 = (class14)BaseVarType.field27.field265.get(var12);
                                 long var18 = ServerPacket.currentTimeMs() - ISAACCipher.field2533 - var22.field273;
                                 var8 = (int)(var18 / 3600000L);
                                 int var20 = (int)((var18 - (long)(var8 * 3600000)) / 60000L);
                                 int var10 = (int)((var18 - (long)(var8 * 3600000) - (long)(var20 * 60000)) / 1000L);
                                 String var17 = var8 + ":" + var20 / 10 + var20 % 10 + ":" + var10 / 10 + var10 % 10;
                                 scriptStringStack[++scriptStringStackSize - 1] = var17;
                                 var3 = 1;
                              } else if(var0 == 3924) {
                                 var12 = intStack[--class13.intStackSize];
                                 var22 = (class14)BaseVarType.field27.field265.get(var12);
                                 intStack[++class13.intStackSize - 1] = var22.field274.totalQuantity;
                                 var3 = 1;
                              } else if(var0 == 3925) {
                                 var12 = intStack[--class13.intStackSize];
                                 var22 = (class14)BaseVarType.field27.field265.get(var12);
                                 intStack[++class13.intStackSize - 1] = var22.field274.price;
                                 var3 = 1;
                              } else if(var0 == 3926) {
                                 var12 = intStack[--class13.intStackSize];
                                 var22 = (class14)BaseVarType.field27.field265.get(var12);
                                 intStack[++class13.intStackSize - 1] = var22.field274.itemId;
                                 var3 = 1;
                              } else {
                                 var3 = 2;
                              }
                           }
                        }

                        return var3;
                     } else if(var0 < 4100) {
                        return class5.method19(var0, var1, var2);
                     } else if(var0 < 4200) {
                        return class258.method4611(var0, var1, var2);
                     } else if(var0 < 4300) {
                        if(var0 == 4200) {
                           var12 = intStack[--class13.intStackSize];
                           scriptStringStack[++scriptStringStackSize - 1] = WorldMapType2.getItemDefinition(var12).name;
                           var3 = 1;
                        } else {
                           ItemComposition var13;
                           if(var0 == 4201) {
                              class13.intStackSize -= 2;
                              var12 = intStack[class13.intStackSize];
                              var15 = intStack[class13.intStackSize + 1];
                              var13 = WorldMapType2.getItemDefinition(var12);
                              if(var15 >= 1 && var15 <= 5 && var13.groundActions[var15 - 1] != null) {
                                 scriptStringStack[++scriptStringStackSize - 1] = var13.groundActions[var15 - 1];
                              } else {
                                 scriptStringStack[++scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else if(var0 == 4202) {
                              class13.intStackSize -= 2;
                              var12 = intStack[class13.intStackSize];
                              var15 = intStack[class13.intStackSize + 1];
                              var13 = WorldMapType2.getItemDefinition(var12);
                              if(var15 >= 1 && var15 <= 5 && var13.inventoryActions[var15 - 1] != null) {
                                 scriptStringStack[++scriptStringStackSize - 1] = var13.inventoryActions[var15 - 1];
                              } else {
                                 scriptStringStack[++scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else if(var0 == 4203) {
                              var12 = intStack[--class13.intStackSize];
                              intStack[++class13.intStackSize - 1] = WorldMapType2.getItemDefinition(var12).price;
                              var3 = 1;
                           } else if(var0 == 4204) {
                              var12 = intStack[--class13.intStackSize];
                              intStack[++class13.intStackSize - 1] = WorldMapType2.getItemDefinition(var12).isStackable == 1?1:0;
                              var3 = 1;
                           } else {
                              ItemComposition var21;
                              if(var0 == 4205) {
                                 var12 = intStack[--class13.intStackSize];
                                 var21 = WorldMapType2.getItemDefinition(var12);
                                 if(var21.notedTemplate == -1 && var21.note >= 0) {
                                    intStack[++class13.intStackSize - 1] = var21.note;
                                 } else {
                                    intStack[++class13.intStackSize - 1] = var12;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4206) {
                                 var12 = intStack[--class13.intStackSize];
                                 var21 = WorldMapType2.getItemDefinition(var12);
                                 if(var21.notedTemplate >= 0 && var21.note >= 0) {
                                    intStack[++class13.intStackSize - 1] = var21.note;
                                 } else {
                                    intStack[++class13.intStackSize - 1] = var12;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4207) {
                                 var12 = intStack[--class13.intStackSize];
                                 intStack[++class13.intStackSize - 1] = WorldMapType2.getItemDefinition(var12).isMembers?1:0;
                                 var3 = 1;
                              } else if(var0 == 4208) {
                                 var12 = intStack[--class13.intStackSize];
                                 var21 = WorldMapType2.getItemDefinition(var12);
                                 if(var21.field3605 == -1 && var21.field3557 >= 0) {
                                    intStack[++class13.intStackSize - 1] = var21.field3557;
                                 } else {
                                    intStack[++class13.intStackSize - 1] = var12;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4209) {
                                 var12 = intStack[--class13.intStackSize];
                                 var21 = WorldMapType2.getItemDefinition(var12);
                                 if(var21.field3605 >= 0 && var21.field3557 >= 0) {
                                    intStack[++class13.intStackSize - 1] = var21.field3557;
                                 } else {
                                    intStack[++class13.intStackSize - 1] = var12;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4210) {
                                 var4 = scriptStringStack[--scriptStringStackSize];
                                 var15 = intStack[--class13.intStackSize];
                                 Frames.method3000(var4, var15 == 1);
                                 intStack[++class13.intStackSize - 1] = class229.field2911;
                                 var3 = 1;
                              } else if(var0 == 4211) {
                                 if(class51.field626 != null && class20.field321 < class229.field2911) {
                                    intStack[++class13.intStackSize - 1] = class51.field626[++class20.field321 - 1] & '\uffff';
                                 } else {
                                    intStack[++class13.intStackSize - 1] = -1;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4212) {
                                 class20.field321 = 0;
                                 var3 = 1;
                              } else {
                                 var3 = 2;
                              }
                           }
                        }

                        return var3;
                     } else if(var0 < 5100) {
                        return class11.method67(var0, var1, var2);
                     } else if(var0 >= 5400) {
                        if(var0 < 5600) {
                           if(var0 == 5504) {
                              class13.intStackSize -= 2;
                              var14 = intStack[class13.intStackSize];
                              var8 = intStack[class13.intStackSize + 1];
                              if(!Client.field1100) {
                                 Client.field997 = var14;
                                 Client.mapAngle = var8;
                              }

                              var3 = 1;
                           } else if(var0 == 5505) {
                              intStack[++class13.intStackSize - 1] = Client.field997;
                              var3 = 1;
                           } else if(var0 == 5506) {
                              intStack[++class13.intStackSize - 1] = Client.mapAngle;
                              var3 = 1;
                           } else if(var0 == 5530) {
                              var14 = intStack[--class13.intStackSize];
                              if(var14 < 0) {
                                 var14 = 0;
                              }

                              Client.field943 = var14;
                              var3 = 1;
                           } else if(var0 == 5531) {
                              intStack[++class13.intStackSize - 1] = Client.field943;
                              var3 = 1;
                           } else {
                              var3 = 2;
                           }

                           return var3;
                        } else if(var0 < 5700) {
                           if(var0 == 5630) {
                              Client.field1108 = 250;
                              var3 = 1;
                           } else {
                              var3 = 2;
                           }

                           return var3;
                        } else {
                           return var0 < 6300?WidgetNode.method1114(var0, var1, var2):(var0 < 6600?class47.method712(var0, var1, var2):(var0 < 6700?ItemLayer.method2507(var0, var1, var2):2));
                        }
                     } else {
                        if(var0 == 5306) {
                           intStack[++class13.intStackSize - 1] = ISAACCipher.method3604();
                           var3 = 1;
                        } else if(var0 == 5307) {
                           var12 = intStack[--class13.intStackSize];
                           if(var12 == 1 || var12 == 2) {
                              Client.field1067 = 0L;
                              if(var12 >= 2) {
                                 Client.isResized = true;
                              } else {
                                 Client.isResized = false;
                              }

                              if(ISAACCipher.method3604() == 1) {
                                 class287.clientInstance.method854(765, 503);
                              } else {
                                 class287.clientInstance.method854(7680, 2160);
                              }

                              if(Client.gameState >= 25) {
                                 var5 = class218.method4105(ClientPacket.field2321, Client.field916.field1470);
                                 var5.packetBuffer.putByte(ISAACCipher.method3604());
                                 var5.packetBuffer.putShort(class86.canvasWidth);
                                 var5.packetBuffer.putShort(GameEngine.canvasHeight);
                                 Client.field916.method1925(var5);
                              }
                           }

                           var3 = 1;
                        } else if(var0 == 5308) {
                           intStack[++class13.intStackSize - 1] = RSCanvas.preferences.screenType;
                           var3 = 1;
                        } else if(var0 == 5309) {
                           var12 = intStack[--class13.intStackSize];
                           if(var12 == 1 || var12 == 2) {
                              RSCanvas.preferences.screenType = var12;
                              class64.method1103();
                           }

                           var3 = 1;
                        } else {
                           var3 = 2;
                        }

                        return var3;
                     }
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-945104773"
   )
   @Export("adjustHSLListness0")
   static final int adjustHSLListness0(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lcw;B)V",
      garbageValue = "-108"
   )
   static void method1683(World var0) {
      if(var0.method1624() != Client.isMembers) {
         Client.isMembers = var0.method1624();
         boolean var1 = var0.method1624();
         if(var1 != MessageNode.isMembersWorld) {
            Varbit.method4577();
            MessageNode.isMembersWorld = var1;
         }
      }

      class19.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class48.field591 = Client.socketType == 0?43594:var0.id + 40000;
      Client.field909 = Client.socketType == 0?443:var0.id + 50000;
      class184.myWorldPort = class48.field591;
   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "457112581"
   )
   static final void method1692(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = (Client.field1107 - Client.field1106) * var5 / 100 + Client.field1106;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field1112) {
         var15 = Client.field1112;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field1111) {
            var6 = Client.field1111;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.method5173(var0, var1, var9, var3, -16777216);
               Rasterizer2D.method5173(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field1061) {
         var15 = Client.field1061;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field926) {
            var6 = Client.field926;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.method5173(var0, var1, var2, var9, -16777216);
               Rasterizer2D.method5173(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field1109 - Client.field1036) * var5 / 100 + Client.field1036;
      Client.scale = var3 * var6 * var8 / 85504 << 1;
      if(var2 != Client.viewportHeight || var3 != Client.viewportWidth) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 15 + 128;
            int var12 = var11 * 3 + 600;
            int var13 = Graphics3D.SINE[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         Region.method2831(var14, 500, 800, var2, var3);
      }

      Client.field1114 = var0;
      Client.field1115 = var1;
      Client.viewportHeight = var2;
      Client.viewportWidth = var3;
   }
}
