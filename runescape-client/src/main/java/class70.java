import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
public class class70 extends class168 {
   @ObfuscatedName("r")
   @Export("colorsToReplace")
   public static short[][] colorsToReplace;
   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   @Export("indexTrack2")
   static IndexData indexTrack2;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIILfg;I)Z",
      garbageValue = "1026250334"
   )
   public boolean vmethod3287(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field2197 && var3 == super.field2194;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lik;Lik;I)I",
      garbageValue = "-1748605138"
   )
   static int method1124(IndexDataBase var0, IndexDataBase var1) {
      int var2 = 0;
      if(var0.tryLoadRecordByNames("title.jpg", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("logo", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("titlebox", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("titlebutton", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("runes", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("title_mute", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("options_radio_buttons,0", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("options_radio_buttons,2", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("options_radio_buttons,4", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("options_radio_buttons,6", "")) {
         ++var2;
      }

      var1.tryLoadRecordByNames("sl_back", "");
      var1.tryLoadRecordByNames("sl_flags", "");
      var1.tryLoadRecordByNames("sl_arrows", "");
      var1.tryLoadRecordByNames("sl_stars", "");
      var1.tryLoadRecordByNames("sl_button", "");
      return var2;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "463953250"
   )
   static int method1125(int var0, Script var1, boolean var2) {
      byte var3;
      int var4;
      int var5;
      int var6;
      int var9;
      Widget var31;
      Widget var44;
      Widget var55;
      Widget var56;
      if(var0 < 1000) {
         if(var0 == 100) {
            class80.intStackSize -= 3;
            var4 = class80.intStack[class80.intStackSize];
            var5 = class80.intStack[class80.intStackSize + 1];
            var6 = class80.intStack[class80.intStackSize + 2];
            if(var5 == 0) {
               throw new RuntimeException();
            }

            var31 = class35.getWidget(var4);
            if(var31.children == null) {
               var31.children = new Widget[var6 + 1];
            }

            if(var31.children.length <= var6) {
               Widget[] var34 = new Widget[var6 + 1];

               for(var9 = 0; var9 < var31.children.length; ++var9) {
                  var34[var9] = var31.children[var9];
               }

               var31.children = var34;
            }

            if(var6 > 0 && var31.children[var6 - 1] == null) {
               throw new RuntimeException("" + (var6 - 1));
            }

            Widget var35 = new Widget();
            var35.type = var5;
            var35.parentId = var35.id = var31.id;
            var35.index = var6;
            var35.hasScript = true;
            var31.children[var6] = var35;
            if(var2) {
               class23.field331 = var35;
            } else {
               GrandExchangeOffer.field297 = var35;
            }

            class60.method1015(var31);
            var3 = 1;
         } else if(var0 == 101) {
            var55 = var2?class23.field331:GrandExchangeOffer.field297;
            var56 = class35.getWidget(var55.id);
            var56.children[var55.index] = null;
            class60.method1015(var56);
            var3 = 1;
         } else if(var0 == 102) {
            var55 = class35.getWidget(class80.intStack[--class80.intStackSize]);
            var55.children = null;
            class60.method1015(var55);
            var3 = 1;
         } else if(var0 == 200) {
            class80.intStackSize -= 2;
            var4 = class80.intStack[class80.intStackSize];
            var5 = class80.intStack[class80.intStackSize + 1];
            var44 = class31.getWidgetChild(var4, var5);
            if(var44 != null && var5 != -1) {
               class80.intStack[++class80.intStackSize - 1] = 1;
               if(var2) {
                  class23.field331 = var44;
               } else {
                  GrandExchangeOffer.field297 = var44;
               }
            } else {
               class80.intStack[++class80.intStackSize - 1] = 0;
            }

            var3 = 1;
         } else if(var0 == 201) {
            var55 = class35.getWidget(class80.intStack[--class80.intStackSize]);
            if(var55 != null) {
               class80.intStack[++class80.intStackSize - 1] = 1;
               if(var2) {
                  class23.field331 = var55;
               } else {
                  GrandExchangeOffer.field297 = var55;
               }
            } else {
               class80.intStack[++class80.intStackSize - 1] = 0;
            }

            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 1100) {
         return CombatInfo1.method1600(var0, var1, var2);
      } else if(var0 < 1200) {
         return Spotanim.method4609(var0, var1, var2);
      } else if(var0 < 1300) {
         return class34.method498(var0, var1, var2);
      } else if(var0 < 1400) {
         return FaceNormal.method3003(var0, var1, var2);
      } else if(var0 < 1500) {
         return NetWriter.method2024(var0, var1, var2);
      } else if(var0 < 1600) {
         return class175.method3327(var0, var1, var2);
      } else if(var0 < 1700) {
         return TotalQuantityComparator.method109(var0, var1, var2);
      } else if(var0 < 1800) {
         return class39.method544(var0, var1, var2);
      } else if(var0 < 1900) {
         var55 = var2?class23.field331:GrandExchangeOffer.field297;
         if(var0 == 1800) {
            class80.intStack[++class80.intStackSize - 1] = CollisionData.method3282(class60.getWidgetConfig(var55));
            var3 = 1;
         } else if(var0 == 1801) {
            var5 = class80.intStack[--class80.intStackSize];
            --var5;
            if(var55.actions != null && var5 < var55.actions.length && var55.actions[var5] != null) {
               class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var55.actions[var5];
            } else {
               class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
            }

            var3 = 1;
         } else if(var0 == 1802) {
            if(var55.name == null) {
               class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
            } else {
               class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var55.name;
            }

            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else {
         ScriptEvent var47;
         if(var0 < 2000) {
            var4 = var0;
            if(var0 >= 2000) {
               var4 = var0 - 1000;
               var56 = class35.getWidget(class80.intStack[--class80.intStackSize]);
            } else {
               var56 = var2?class23.field331:GrandExchangeOffer.field297;
            }

            if(var4 == 1927) {
               if(class80.field1227 >= 10) {
                  throw new RuntimeException();
               }

               if(var56.field2744 == null) {
                  var3 = 0;
               } else {
                  var47 = new ScriptEvent();
                  var47.widget = var56;
                  var47.objs = var56.field2744;
                  var47.field755 = class80.field1227 + 1;
                  Client.field1006.addFront(var47);
                  var3 = 1;
               }
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 2100) {
            return CombatInfo1.method1600(var0, var1, var2);
         } else if(var0 < 2200) {
            return Spotanim.method4609(var0, var1, var2);
         } else if(var0 < 2300) {
            return class34.method498(var0, var1, var2);
         } else if(var0 < 2400) {
            return FaceNormal.method3003(var0, var1, var2);
         } else if(var0 < 2500) {
            return NetWriter.method2024(var0, var1, var2);
         } else if(var0 < 2600) {
            var55 = class35.getWidget(class80.intStack[--class80.intStackSize]);
            if(var0 == 2500) {
               class80.intStack[++class80.intStackSize - 1] = var55.relativeX;
               var3 = 1;
            } else if(var0 == 2501) {
               class80.intStack[++class80.intStackSize - 1] = var55.relativeY;
               var3 = 1;
            } else if(var0 == 2502) {
               class80.intStack[++class80.intStackSize - 1] = var55.width;
               var3 = 1;
            } else if(var0 == 2503) {
               class80.intStack[++class80.intStackSize - 1] = var55.height;
               var3 = 1;
            } else if(var0 == 2504) {
               class80.intStack[++class80.intStackSize - 1] = var55.isHidden?1:0;
               var3 = 1;
            } else if(var0 == 2505) {
               class80.intStack[++class80.intStackSize - 1] = var55.parentId;
               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 2700) {
            return class35.method500(var0, var1, var2);
         } else if(var0 < 2800) {
            if(var0 == 2700) {
               var55 = class35.getWidget(class80.intStack[--class80.intStackSize]);
               class80.intStack[++class80.intStackSize - 1] = var55.itemId;
               var3 = 1;
            } else if(var0 == 2701) {
               var55 = class35.getWidget(class80.intStack[--class80.intStackSize]);
               if(var55.itemId != -1) {
                  class80.intStack[++class80.intStackSize - 1] = var55.itemQuantity;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = 0;
               }

               var3 = 1;
            } else if(var0 == 2702) {
               var4 = class80.intStack[--class80.intStackSize];
               WidgetNode var57 = (WidgetNode)Client.componentTable.get((long)var4);
               if(var57 != null) {
                  class80.intStack[++class80.intStackSize - 1] = 1;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = 0;
               }

               var3 = 1;
            } else if(var0 == 2706) {
               class80.intStack[++class80.intStackSize - 1] = Client.widgetRoot;
               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 2900) {
            var55 = class35.getWidget(class80.intStack[--class80.intStackSize]);
            if(var0 == 2800) {
               class80.intStack[++class80.intStackSize - 1] = CollisionData.method3282(class60.getWidgetConfig(var55));
               var3 = 1;
            } else if(var0 == 2801) {
               var5 = class80.intStack[--class80.intStackSize];
               --var5;
               if(var55.actions != null && var5 < var55.actions.length && var55.actions[var5] != null) {
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var55.actions[var5];
               } else {
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
               }

               var3 = 1;
            } else if(var0 == 2802) {
               if(var55.name == null) {
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
               } else {
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var55.name;
               }

               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 3000) {
            var4 = var0;
            if(var0 >= 2000) {
               var4 = var0 - 1000;
               var56 = class35.getWidget(class80.intStack[--class80.intStackSize]);
            } else {
               var56 = var2?class23.field331:GrandExchangeOffer.field297;
            }

            if(var4 == 1927) {
               if(class80.field1227 >= 10) {
                  throw new RuntimeException();
               }

               if(var56.field2744 == null) {
                  var3 = 0;
               } else {
                  var47 = new ScriptEvent();
                  var47.widget = var56;
                  var47.objs = var56.field2744;
                  var47.field755 = class80.field1227 + 1;
                  Client.field1006.addFront(var47);
                  var3 = 1;
               }
            } else {
               var3 = 2;
            }

            return var3;
         } else {
            String var16;
            int var18;
            boolean var29;
            String var42;
            boolean var48;
            if(var0 < 3200) {
               if(var0 == 3100) {
                  var42 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
                  class240.sendGameMessage(0, "", var42);
                  var3 = 1;
               } else if(var0 == 3101) {
                  class80.intStackSize -= 2;
                  Size.method188(class36.localPlayer, class80.intStack[class80.intStackSize], class80.intStack[class80.intStackSize + 1]);
                  var3 = 1;
               } else if(var0 == 3103) {
                  UrlRequest.method3037();
                  var3 = 1;
               } else {
                  PacketNode var30;
                  if(var0 == 3104) {
                     var42 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
                     var5 = 0;
                     boolean var51 = false;
                     boolean var36 = false;
                     int var10 = 0;
                     int var11 = var42.length();
                     int var12 = 0;

                     while(true) {
                        if(var12 >= var11) {
                           var48 = var36;
                           break;
                        }

                        label1614: {
                           char var13 = var42.charAt(var12);
                           if(var12 == 0) {
                              if(var13 == '-') {
                                 var51 = true;
                                 break label1614;
                              }

                              if(var13 == '+') {
                                 break label1614;
                              }
                           }

                           int var37;
                           if(var13 >= '0' && var13 <= '9') {
                              var37 = var13 - '0';
                           } else if(var13 >= 'A' && var13 <= 'Z') {
                              var37 = var13 - '7';
                           } else {
                              if(var13 < 'a' || var13 > 'z') {
                                 var48 = false;
                                 break;
                              }

                              var37 = var13 - 'W';
                           }

                           if(var37 >= 10) {
                              var48 = false;
                              break;
                           }

                           if(var51) {
                              var37 = -var37;
                           }

                           int var14 = var10 * 10 + var37;
                           if(var10 != var14 / 10) {
                              var48 = false;
                              break;
                           }

                           var10 = var14;
                           var36 = true;
                        }

                        ++var12;
                     }

                     if(var48) {
                        var18 = BoundingBox3DDrawMode.parseInt(var42, 10, true);
                        var5 = var18;
                     }

                     var30 = class35.method501(ClientPacket.field2356, Client.field867.field1439);
                     var30.packetBuffer.putInt(var5);
                     Client.field867.method2021(var30);
                     var3 = 1;
                  } else {
                     PacketNode var54;
                     if(var0 == 3105) {
                        var42 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
                        var54 = class35.method501(ClientPacket.field2311, Client.field867.field1439);
                        var54.packetBuffer.putByte(var42.length() + 1);
                        var54.packetBuffer.putString(var42);
                        Client.field867.method2021(var54);
                        var3 = 1;
                     } else if(var0 == 3106) {
                        var42 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
                        var54 = class35.method501(ClientPacket.field2318, Client.field867.field1439);
                        var54.packetBuffer.putByte(var42.length() + 1);
                        var54.packetBuffer.putString(var42);
                        Client.field867.method2021(var54);
                        var3 = 1;
                     } else if(var0 == 3107) {
                        var4 = class80.intStack[--class80.intStackSize];
                        var16 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
                        class232.method4328(var4, var16);
                        var3 = 1;
                     } else if(var0 == 3108) {
                        class80.intStackSize -= 3;
                        var4 = class80.intStack[class80.intStackSize];
                        var5 = class80.intStack[class80.intStackSize + 1];
                        var6 = class80.intStack[class80.intStackSize + 2];
                        var31 = class35.getWidget(var6);
                        class89.method1874(var31, var4, var5);
                        var3 = 1;
                     } else if(var0 == 3109) {
                        class80.intStackSize -= 2;
                        var4 = class80.intStack[class80.intStackSize];
                        var5 = class80.intStack[class80.intStackSize + 1];
                        var44 = var2?class23.field331:GrandExchangeOffer.field297;
                        class89.method1874(var44, var4, var5);
                        var3 = 1;
                     } else if(var0 == 3110) {
                        Client.middleMouseMovesCamera = class80.intStack[--class80.intStackSize] == 1;
                        var3 = 1;
                     } else if(var0 == 3111) {
                        class80.intStack[++class80.intStackSize - 1] = class221.preferences.hideRoofs?1:0;
                        var3 = 1;
                     } else if(var0 == 3112) {
                        class221.preferences.hideRoofs = class80.intStack[--class80.intStackSize] == 1;
                        method1121();
                        var3 = 1;
                     } else if(var0 == 3113) {
                        var42 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
                        var29 = class80.intStack[--class80.intStackSize] == 1;
                        class18.method153(var42, var29, "openjs", false);
                        var3 = 1;
                     } else if(var0 == 3115) {
                        var4 = class80.intStack[--class80.intStackSize];
                        var54 = class35.method501(ClientPacket.field2290, Client.field867.field1439);
                        var54.packetBuffer.putShort(var4);
                        Client.field867.method2021(var54);
                        var3 = 1;
                     } else if(var0 == 3116) {
                        var4 = class80.intStack[--class80.intStackSize];
                        WorldComparator.scriptStringStackSize -= 2;
                        var16 = class80.scriptStringStack[WorldComparator.scriptStringStackSize];
                        String var46 = class80.scriptStringStack[WorldComparator.scriptStringStackSize + 1];
                        if(var16.length() > 500) {
                           var3 = 1;
                        } else if(var46.length() > 500) {
                           var3 = 1;
                        } else {
                           var30 = class35.method501(ClientPacket.field2360, Client.field867.field1439);
                           var30.packetBuffer.putShort(1 + ContextMenuRow.getLength(var16) + ContextMenuRow.getLength(var46));
                           var30.packetBuffer.putString(var16);
                           var30.packetBuffer.putString(var46);
                           var30.packetBuffer.method3430(var4);
                           Client.field867.method2021(var30);
                           var3 = 1;
                        }
                     } else if(var0 == 3117) {
                        Client.field954 = class80.intStack[--class80.intStackSize] == 1;
                        var3 = 1;
                     } else {
                        var3 = 2;
                     }
                  }
               }

               return var3;
            } else if(var0 < 3300) {
               if(var0 == 3200) {
                  class80.intStackSize -= 3;
                  var4 = class80.intStack[class80.intStackSize];
                  var5 = class80.intStack[class80.intStackSize + 1];
                  var6 = class80.intStack[class80.intStackSize + 2];
                  if(Client.field1008 != 0 && var5 != 0 && Client.queuedSoundEffectCount < 50) {
                     Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = var4;
                     Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var5;
                     Client.unknownSoundValues2[Client.queuedSoundEffectCount] = var6;
                     Client.audioEffects[Client.queuedSoundEffectCount] = null;
                     Client.soundLocations[Client.queuedSoundEffectCount] = 0;
                     ++Client.queuedSoundEffectCount;
                  }

                  var3 = 1;
               } else if(var0 == 3201) {
                  ItemContainer.method1067(class80.intStack[--class80.intStackSize]);
                  var3 = 1;
               } else if(var0 == 3202) {
                  class80.intStackSize -= 2;
                  var4 = class80.intStack[class80.intStackSize];
                  var5 = class80.intStack[class80.intStackSize + 1];
                  if(Client.field1040 != 0 && var4 != -1) {
                     class163.method3202(indexTrack2, var4, 0, Client.field1040, false);
                     Client.field1014 = true;
                  }

                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 3400) {
               return class20.method166(var0, var1, var2);
            } else if(var0 < 3500) {
               return class84.method1839(var0, var1, var2);
            } else if(var0 < 3700) {
               return class23.method180(var0, var1, var2);
            } else if(var0 < 4000) {
               return class186.method3626(var0, var1, var2);
            } else {
               int var20;
               if(var0 < 4100) {
                  if(var0 == 4000) {
                     class80.intStackSize -= 2;
                     var4 = class80.intStack[class80.intStackSize];
                     var5 = class80.intStack[class80.intStackSize + 1];
                     class80.intStack[++class80.intStackSize - 1] = var4 + var5;
                     var3 = 1;
                  } else if(var0 == 4001) {
                     class80.intStackSize -= 2;
                     var4 = class80.intStack[class80.intStackSize];
                     var5 = class80.intStack[class80.intStackSize + 1];
                     class80.intStack[++class80.intStackSize - 1] = var4 - var5;
                     var3 = 1;
                  } else if(var0 == 4002) {
                     class80.intStackSize -= 2;
                     var4 = class80.intStack[class80.intStackSize];
                     var5 = class80.intStack[class80.intStackSize + 1];
                     class80.intStack[++class80.intStackSize - 1] = var5 * var4;
                     var3 = 1;
                  } else if(var0 == 4003) {
                     class80.intStackSize -= 2;
                     var4 = class80.intStack[class80.intStackSize];
                     var5 = class80.intStack[class80.intStackSize + 1];
                     class80.intStack[++class80.intStackSize - 1] = var4 / var5;
                     var3 = 1;
                  } else if(var0 == 4004) {
                     var4 = class80.intStack[--class80.intStackSize];
                     class80.intStack[++class80.intStackSize - 1] = (int)(Math.random() * (double)var4);
                     var3 = 1;
                  } else if(var0 == 4005) {
                     var4 = class80.intStack[--class80.intStackSize];
                     class80.intStack[++class80.intStackSize - 1] = (int)(Math.random() * (double)(var4 + 1));
                     var3 = 1;
                  } else if(var0 == 4006) {
                     class80.intStackSize -= 5;
                     var4 = class80.intStack[class80.intStackSize];
                     var5 = class80.intStack[class80.intStackSize + 1];
                     var6 = class80.intStack[class80.intStackSize + 2];
                     var18 = class80.intStack[class80.intStackSize + 3];
                     var20 = class80.intStack[class80.intStackSize + 4];
                     class80.intStack[++class80.intStackSize - 1] = var4 + (var5 - var4) * (var20 - var6) / (var18 - var6);
                     var3 = 1;
                  } else if(var0 == 4007) {
                     class80.intStackSize -= 2;
                     var4 = class80.intStack[class80.intStackSize];
                     var5 = class80.intStack[class80.intStackSize + 1];
                     class80.intStack[++class80.intStackSize - 1] = var4 + var4 * var5 / 100;
                     var3 = 1;
                  } else if(var0 == 4008) {
                     class80.intStackSize -= 2;
                     var4 = class80.intStack[class80.intStackSize];
                     var5 = class80.intStack[class80.intStackSize + 1];
                     class80.intStack[++class80.intStackSize - 1] = var4 | 1 << var5;
                     var3 = 1;
                  } else if(var0 == 4009) {
                     class80.intStackSize -= 2;
                     var4 = class80.intStack[class80.intStackSize];
                     var5 = class80.intStack[class80.intStackSize + 1];
                     class80.intStack[++class80.intStackSize - 1] = var4 & -1 - (1 << var5);
                     var3 = 1;
                  } else if(var0 == 4010) {
                     class80.intStackSize -= 2;
                     var4 = class80.intStack[class80.intStackSize];
                     var5 = class80.intStack[class80.intStackSize + 1];
                     class80.intStack[++class80.intStackSize - 1] = (var4 & 1 << var5) != 0?1:0;
                     var3 = 1;
                  } else if(var0 == 4011) {
                     class80.intStackSize -= 2;
                     var4 = class80.intStack[class80.intStackSize];
                     var5 = class80.intStack[class80.intStackSize + 1];
                     class80.intStack[++class80.intStackSize - 1] = var4 % var5;
                     var3 = 1;
                  } else if(var0 == 4012) {
                     class80.intStackSize -= 2;
                     var4 = class80.intStack[class80.intStackSize];
                     var5 = class80.intStack[class80.intStackSize + 1];
                     if(var4 == 0) {
                        class80.intStack[++class80.intStackSize - 1] = 0;
                     } else {
                        class80.intStack[++class80.intStackSize - 1] = (int)Math.pow((double)var4, (double)var5);
                     }

                     var3 = 1;
                  } else if(var0 == 4013) {
                     class80.intStackSize -= 2;
                     var4 = class80.intStack[class80.intStackSize];
                     var5 = class80.intStack[class80.intStackSize + 1];
                     if(var4 == 0) {
                        class80.intStack[++class80.intStackSize - 1] = 0;
                        var3 = 1;
                     } else {
                        switch(var5) {
                        case 0:
                           class80.intStack[++class80.intStackSize - 1] = Integer.MAX_VALUE;
                           break;
                        case 1:
                           class80.intStack[++class80.intStackSize - 1] = var4;
                           break;
                        case 2:
                           class80.intStack[++class80.intStackSize - 1] = (int)Math.sqrt((double)var4);
                           break;
                        case 3:
                           class80.intStack[++class80.intStackSize - 1] = (int)Math.cbrt((double)var4);
                           break;
                        case 4:
                           class80.intStack[++class80.intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var4));
                           break;
                        default:
                           class80.intStack[++class80.intStackSize - 1] = (int)Math.pow((double)var4, 1.0D / (double)var5);
                        }

                        var3 = 1;
                     }
                  } else if(var0 == 4014) {
                     class80.intStackSize -= 2;
                     var4 = class80.intStack[class80.intStackSize];
                     var5 = class80.intStack[class80.intStackSize + 1];
                     class80.intStack[++class80.intStackSize - 1] = var4 & var5;
                     var3 = 1;
                  } else if(var0 == 4015) {
                     class80.intStackSize -= 2;
                     var4 = class80.intStack[class80.intStackSize];
                     var5 = class80.intStack[class80.intStackSize + 1];
                     class80.intStack[++class80.intStackSize - 1] = var4 | var5;
                     var3 = 1;
                  } else if(var0 == 4018) {
                     class80.intStackSize -= 3;
                     long var23 = (long)class80.intStack[class80.intStackSize];
                     long var25 = (long)class80.intStack[class80.intStackSize + 1];
                     long var27 = (long)class80.intStack[class80.intStackSize + 2];
                     class80.intStack[++class80.intStackSize - 1] = (int)(var23 * var27 / var25);
                     var3 = 1;
                  } else {
                     var3 = 2;
                  }

                  return var3;
               } else if(var0 < 4200) {
                  if(var0 == 4100) {
                     var42 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
                     var5 = class80.intStack[--class80.intStackSize];
                     class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var42 + var5;
                     var3 = 1;
                  } else if(var0 == 4101) {
                     WorldComparator.scriptStringStackSize -= 2;
                     var42 = class80.scriptStringStack[WorldComparator.scriptStringStackSize];
                     var16 = class80.scriptStringStack[WorldComparator.scriptStringStackSize + 1];
                     class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var42 + var16;
                     var3 = 1;
                  } else if(var0 == 4102) {
                     var42 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
                     var5 = class80.intStack[--class80.intStackSize];
                     String[] var43 = class80.scriptStringStack;
                     var18 = ++WorldComparator.scriptStringStackSize - 1;
                     String var19;
                     if(var5 < 0) {
                        var19 = Integer.toString(var5);
                     } else {
                        var19 = class185.method3622(var5, 10, true);
                     }

                     var43[var18] = var42 + var19;
                     var3 = 1;
                  } else if(var0 == 4103) {
                     var42 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
                     class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var42.toLowerCase();
                     var3 = 1;
                  } else if(var0 == 4104) {
                     var4 = class80.intStack[--class80.intStackSize];
                     long var21 = ((long)var4 + 11745L) * 86400000L;
                     class80.field1228.setTime(new Date(var21));
                     var18 = class80.field1228.get(5);
                     var20 = class80.field1228.get(2);
                     var9 = class80.field1228.get(1);
                     class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var18 + "-" + class80.field1229[var20] + "-" + var9;
                     var3 = 1;
                  } else if(var0 == 4105) {
                     WorldComparator.scriptStringStackSize -= 2;
                     var42 = class80.scriptStringStack[WorldComparator.scriptStringStackSize];
                     var16 = class80.scriptStringStack[WorldComparator.scriptStringStackSize + 1];
                     if(class36.localPlayer.composition != null && class36.localPlayer.composition.isFemale) {
                        class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var16;
                     } else {
                        class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var42;
                     }

                     var3 = 1;
                  } else if(var0 == 4106) {
                     var4 = class80.intStack[--class80.intStackSize];
                     class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = Integer.toString(var4);
                     var3 = 1;
                  } else if(var0 == 4107) {
                     WorldComparator.scriptStringStackSize -= 2;
                     class80.intStack[++class80.intStackSize - 1] = CombatInfo1.method1606(WorldMapType2.method516(class80.scriptStringStack[WorldComparator.scriptStringStackSize], class80.scriptStringStack[WorldComparator.scriptStringStackSize + 1], Client.languageId));
                     var3 = 1;
                  } else {
                     byte[] var7;
                     Font var8;
                     if(var0 == 4108) {
                        var42 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
                        class80.intStackSize -= 2;
                        var5 = class80.intStack[class80.intStackSize];
                        var6 = class80.intStack[class80.intStackSize + 1];
                        var7 = class304.indexCache13.getConfigData(var6, 0);
                        var8 = new Font(var7);
                        class80.intStack[++class80.intStackSize - 1] = var8.method5208(var42, var5);
                        var3 = 1;
                     } else if(var0 == 4109) {
                        var42 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
                        class80.intStackSize -= 2;
                        var5 = class80.intStack[class80.intStackSize];
                        var6 = class80.intStack[class80.intStackSize + 1];
                        var7 = class304.indexCache13.getConfigData(var6, 0);
                        var8 = new Font(var7);
                        class80.intStack[++class80.intStackSize - 1] = var8.method5210(var42, var5);
                        var3 = 1;
                     } else if(var0 == 4110) {
                        WorldComparator.scriptStringStackSize -= 2;
                        var42 = class80.scriptStringStack[WorldComparator.scriptStringStackSize];
                        var16 = class80.scriptStringStack[WorldComparator.scriptStringStackSize + 1];
                        if(class80.intStack[--class80.intStackSize] == 1) {
                           class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var42;
                        } else {
                           class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var16;
                        }

                        var3 = 1;
                     } else if(var0 == 4111) {
                        var42 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
                        class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = FontTypeFace.appendTags(var42);
                        var3 = 1;
                     } else if(var0 == 4112) {
                        var42 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
                        var5 = class80.intStack[--class80.intStackSize];
                        class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var42 + (char)var5;
                        var3 = 1;
                     } else {
                        char var49;
                        int[] var52;
                        if(var0 == 4113) {
                           var4 = class80.intStack[--class80.intStackSize];
                           var52 = class80.intStack;
                           var6 = ++class80.intStackSize - 1;
                           var49 = (char)var4;
                           if(var49 >= ' ' && var49 <= '~') {
                              var48 = true;
                           } else if(var49 >= 160 && var49 <= 255) {
                              var48 = true;
                           } else if(var49 != 8364 && var49 != 338 && var49 != 8212 && var49 != 339 && var49 != 376) {
                              var48 = false;
                           } else {
                              var48 = true;
                           }

                           var52[var6] = var48?1:0;
                           var3 = 1;
                        } else if(var0 == 4114) {
                           var4 = class80.intStack[--class80.intStackSize];
                           class80.intStack[++class80.intStackSize - 1] = MilliTimer.method3053((char)var4)?1:0;
                           var3 = 1;
                        } else if(var0 == 4115) {
                           var4 = class80.intStack[--class80.intStackSize];
                           var52 = class80.intStack;
                           var6 = ++class80.intStackSize - 1;
                           var49 = (char)var4;
                           var48 = var49 >= 'A' && var49 <= 'Z' || var49 >= 'a' && var49 <= 'z';
                           var52[var6] = var48?1:0;
                           var3 = 1;
                        } else if(var0 == 4116) {
                           var4 = class80.intStack[--class80.intStackSize];
                           var52 = class80.intStack;
                           var6 = ++class80.intStackSize - 1;
                           var49 = (char)var4;
                           var48 = var49 >= '0' && var49 <= '9';
                           var52[var6] = var48?1:0;
                           var3 = 1;
                        } else if(var0 == 4117) {
                           var42 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
                           if(var42 != null) {
                              class80.intStack[++class80.intStackSize - 1] = var42.length();
                           } else {
                              class80.intStack[++class80.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        } else if(var0 == 4118) {
                           var42 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
                           class80.intStackSize -= 2;
                           var5 = class80.intStack[class80.intStackSize];
                           var6 = class80.intStack[class80.intStackSize + 1];
                           class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var42.substring(var5, var6);
                           var3 = 1;
                        } else if(var0 == 4119) {
                           var42 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
                           StringBuilder var53 = new StringBuilder(var42.length());
                           boolean var32 = false;

                           for(var18 = 0; var18 < var42.length(); ++var18) {
                              var49 = var42.charAt(var18);
                              if(var49 == '<') {
                                 var32 = true;
                              } else if(var49 == '>') {
                                 var32 = false;
                              } else if(!var32) {
                                 var53.append(var49);
                              }
                           }

                           class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var53.toString();
                           var3 = 1;
                        } else if(var0 == 4120) {
                           var42 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
                           var5 = class80.intStack[--class80.intStackSize];
                           class80.intStack[++class80.intStackSize - 1] = var42.indexOf(var5);
                           var3 = 1;
                        } else if(var0 == 4121) {
                           WorldComparator.scriptStringStackSize -= 2;
                           var42 = class80.scriptStringStack[WorldComparator.scriptStringStackSize];
                           var16 = class80.scriptStringStack[WorldComparator.scriptStringStackSize + 1];
                           var6 = class80.intStack[--class80.intStackSize];
                           class80.intStack[++class80.intStackSize - 1] = var42.indexOf(var16, var6);
                           var3 = 1;
                        } else {
                           var3 = 2;
                        }
                     }
                  }

                  return var3;
               } else if(var0 < 4300) {
                  return BoundingBox.method62(var0, var1, var2);
               } else if(var0 < 5100) {
                  return class5.method19(var0, var1, var2);
               } else if(var0 >= 5400) {
                  if(var0 < 5600) {
                     if(var0 == 5504) {
                        class80.intStackSize -= 2;
                        var18 = class80.intStack[class80.intStackSize];
                        var20 = class80.intStack[class80.intStackSize + 1];
                        if(!Client.field1051) {
                           Client.field889 = var18;
                           Client.mapAngle = var20;
                        }

                        var3 = 1;
                     } else if(var0 == 5505) {
                        class80.intStack[++class80.intStackSize - 1] = Client.field889;
                        var3 = 1;
                     } else if(var0 == 5506) {
                        class80.intStack[++class80.intStackSize - 1] = Client.mapAngle;
                        var3 = 1;
                     } else if(var0 == 5530) {
                        var18 = class80.intStack[--class80.intStackSize];
                        if(var18 < 0) {
                           var18 = 0;
                        }

                        Client.field895 = var18;
                        var3 = 1;
                     } else if(var0 == 5531) {
                        class80.intStack[++class80.intStackSize - 1] = Client.field895;
                        var3 = 1;
                     } else {
                        var3 = 2;
                     }

                     return var3;
                  } else if(var0 < 5700) {
                     if(var0 == 5630) {
                        Client.field1043 = 250;
                        var3 = 1;
                     } else {
                        var3 = 2;
                     }

                     return var3;
                  } else if(var0 < 6300) {
                     if(var0 == 6200) {
                        class80.intStackSize -= 2;
                        Client.field1057 = (short)class80.intStack[class80.intStackSize];
                        if(Client.field1057 <= 0) {
                           Client.field1057 = 256;
                        }

                        Client.field1058 = (short)class80.intStack[class80.intStackSize + 1];
                        if(Client.field1058 <= 0) {
                           Client.field1058 = 205;
                        }

                        var3 = 1;
                     } else if(var0 == 6201) {
                        class80.intStackSize -= 2;
                        Client.field856 = (short)class80.intStack[class80.intStackSize];
                        if(Client.field856 <= 0) {
                           Client.field856 = 256;
                        }

                        Client.field1060 = (short)class80.intStack[class80.intStackSize + 1];
                        if(Client.field1060 <= 0) {
                           Client.field1060 = 320;
                        }

                        var3 = 1;
                     } else if(var0 == 6202) {
                        class80.intStackSize -= 4;
                        Client.field1061 = (short)class80.intStack[class80.intStackSize];
                        if(Client.field1061 <= 0) {
                           Client.field1061 = 1;
                        }

                        Client.field1062 = (short)class80.intStack[class80.intStackSize + 1];
                        if(Client.field1062 <= 0) {
                           Client.field1062 = 32767;
                        } else if(Client.field1062 < Client.field1061) {
                           Client.field1062 = Client.field1061;
                        }

                        Client.field1063 = (short)class80.intStack[class80.intStackSize + 2];
                        if(Client.field1063 <= 0) {
                           Client.field1063 = 1;
                        }

                        Client.field1064 = (short)class80.intStack[class80.intStackSize + 3];
                        if(Client.field1064 <= 0) {
                           Client.field1064 = 32767;
                        } else if(Client.field1064 < Client.field1063) {
                           Client.field1064 = Client.field1063;
                        }

                        var3 = 1;
                     } else if(var0 == 6203) {
                        if(Client.field979 != null) {
                           class65.method1069(0, 0, Client.field979.width, Client.field979.height, false);
                           class80.intStack[++class80.intStackSize - 1] = Client.viewportWidth;
                           class80.intStack[++class80.intStackSize - 1] = Client.viewportHeight;
                        } else {
                           class80.intStack[++class80.intStackSize - 1] = -1;
                           class80.intStack[++class80.intStackSize - 1] = -1;
                        }

                        var3 = 1;
                     } else if(var0 == 6204) {
                        class80.intStack[++class80.intStackSize - 1] = Client.field856;
                        class80.intStack[++class80.intStackSize - 1] = Client.field1060;
                        var3 = 1;
                     } else if(var0 == 6205) {
                        class80.intStack[++class80.intStackSize - 1] = Client.field1057;
                        class80.intStack[++class80.intStackSize - 1] = Client.field1058;
                        var3 = 1;
                     } else {
                        var3 = 2;
                     }

                     return var3;
                  } else if(var0 < 6600) {
                     return class233.execute6500(var0, var1, var2);
                  } else if(var0 < 6700) {
                     if(var0 == 6600) {
                        var4 = MessageNode.plane;
                        var5 = (class36.localPlayer.x >> 7) + WorldMapType1.baseX;
                        var6 = (class36.localPlayer.y >> 7) + class85.baseY;
                        GrandExchangeEvent.method97().method5670(var4, var5, var6, true);
                        var3 = 1;
                     } else {
                        WorldMapData var17;
                        if(var0 == 6601) {
                           var4 = class80.intStack[--class80.intStackSize];
                           var16 = "";
                           var17 = GrandExchangeEvent.method97().method5686(var4);
                           if(var17 != null) {
                              var16 = var17.method300();
                           }

                           class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var16;
                           var3 = 1;
                        } else if(var0 == 6602) {
                           var4 = class80.intStack[--class80.intStackSize];
                           GrandExchangeEvent.method97().method5671(var4);
                           var3 = 1;
                        } else if(var0 == 6603) {
                           class80.intStack[++class80.intStackSize - 1] = GrandExchangeEvent.method97().method5683();
                           var3 = 1;
                        } else if(var0 == 6604) {
                           var4 = class80.intStack[--class80.intStackSize];
                           GrandExchangeEvent.method97().method5680(var4);
                           var3 = 1;
                        } else if(var0 == 6605) {
                           class80.intStack[++class80.intStackSize - 1] = GrandExchangeEvent.method97().method5837()?1:0;
                           var3 = 1;
                        } else {
                           Coordinates var15;
                           if(var0 == 6606) {
                              var15 = new Coordinates(class80.intStack[--class80.intStackSize]);
                              GrandExchangeEvent.method97().method5785(var15.worldX, var15.worldY);
                              var3 = 1;
                           } else if(var0 == 6607) {
                              var15 = new Coordinates(class80.intStack[--class80.intStackSize]);
                              GrandExchangeEvent.method97().method5820(var15.worldX, var15.worldY);
                              var3 = 1;
                           } else if(var0 == 6608) {
                              var15 = new Coordinates(class80.intStack[--class80.intStackSize]);
                              GrandExchangeEvent.method97().method5689(var15.plane, var15.worldX, var15.worldY);
                              var3 = 1;
                           } else if(var0 == 6609) {
                              var15 = new Coordinates(class80.intStack[--class80.intStackSize]);
                              GrandExchangeEvent.method97().method5661(var15.plane, var15.worldX, var15.worldY);
                              var3 = 1;
                           } else if(var0 == 6610) {
                              class80.intStack[++class80.intStackSize - 1] = GrandExchangeEvent.method97().method5840();
                              class80.intStack[++class80.intStackSize - 1] = GrandExchangeEvent.method97().method5784();
                              var3 = 1;
                           } else {
                              WorldMapData var38;
                              if(var0 == 6611) {
                                 var4 = class80.intStack[--class80.intStackSize];
                                 var38 = GrandExchangeEvent.method97().method5686(var4);
                                 if(var38 == null) {
                                    class80.intStack[++class80.intStackSize - 1] = 0;
                                 } else {
                                    class80.intStack[++class80.intStackSize - 1] = var38.method309().method4196();
                                 }

                                 var3 = 1;
                              } else if(var0 == 6612) {
                                 var4 = class80.intStack[--class80.intStackSize];
                                 var38 = GrandExchangeEvent.method97().method5686(var4);
                                 if(var38 == null) {
                                    class80.intStack[++class80.intStackSize - 1] = 0;
                                    class80.intStack[++class80.intStackSize - 1] = 0;
                                 } else {
                                    class80.intStack[++class80.intStackSize - 1] = (var38.method304() - var38.method358() + 1) * 64;
                                    class80.intStack[++class80.intStackSize - 1] = (var38.method307() - var38.method305() + 1) * 64;
                                 }

                                 var3 = 1;
                              } else if(var0 == 6613) {
                                 var4 = class80.intStack[--class80.intStackSize];
                                 var38 = GrandExchangeEvent.method97().method5686(var4);
                                 if(var38 == null) {
                                    class80.intStack[++class80.intStackSize - 1] = 0;
                                    class80.intStack[++class80.intStackSize - 1] = 0;
                                    class80.intStack[++class80.intStackSize - 1] = 0;
                                    class80.intStack[++class80.intStackSize - 1] = 0;
                                 } else {
                                    class80.intStack[++class80.intStackSize - 1] = var38.method358() * 64;
                                    class80.intStack[++class80.intStackSize - 1] = var38.method305() * 64;
                                    class80.intStack[++class80.intStackSize - 1] = var38.method304() * 64 + 64 - 1;
                                    class80.intStack[++class80.intStackSize - 1] = var38.method307() * 64 + 64 - 1;
                                 }

                                 var3 = 1;
                              } else if(var0 == 6614) {
                                 var4 = class80.intStack[--class80.intStackSize];
                                 var38 = GrandExchangeEvent.method97().method5686(var4);
                                 if(var38 == null) {
                                    class80.intStack[++class80.intStackSize - 1] = -1;
                                 } else {
                                    class80.intStack[++class80.intStackSize - 1] = var38.method302();
                                 }

                                 var3 = 1;
                              } else if(var0 == 6615) {
                                 var15 = GrandExchangeEvent.method97().method5693();
                                 if(var15 == null) {
                                    class80.intStack[++class80.intStackSize - 1] = -1;
                                    class80.intStack[++class80.intStackSize - 1] = -1;
                                 } else {
                                    class80.intStack[++class80.intStackSize - 1] = var15.worldX;
                                    class80.intStack[++class80.intStackSize - 1] = var15.worldY;
                                 }

                                 var3 = 1;
                              } else if(var0 == 6616) {
                                 class80.intStack[++class80.intStackSize - 1] = GrandExchangeEvent.method97().method5672();
                                 var3 = 1;
                              } else if(var0 == 6617) {
                                 var15 = new Coordinates(class80.intStack[--class80.intStackSize]);
                                 var38 = GrandExchangeEvent.method97().method5673();
                                 if(var38 == null) {
                                    class80.intStack[++class80.intStackSize - 1] = -1;
                                    class80.intStack[++class80.intStackSize - 1] = -1;
                                    var3 = 1;
                                 } else {
                                    int[] var39 = var38.method294(var15.plane, var15.worldX, var15.worldY);
                                    if(var39 == null) {
                                       class80.intStack[++class80.intStackSize - 1] = -1;
                                       class80.intStack[++class80.intStackSize - 1] = -1;
                                    } else {
                                       class80.intStack[++class80.intStackSize - 1] = var39[0];
                                       class80.intStack[++class80.intStackSize - 1] = var39[1];
                                    }

                                    var3 = 1;
                                 }
                              } else {
                                 Coordinates var40;
                                 if(var0 == 6618) {
                                    var15 = new Coordinates(class80.intStack[--class80.intStackSize]);
                                    var38 = GrandExchangeEvent.method97().method5673();
                                    if(var38 == null) {
                                       class80.intStack[++class80.intStackSize - 1] = -1;
                                       class80.intStack[++class80.intStackSize - 1] = -1;
                                       var3 = 1;
                                    } else {
                                       var40 = var38.method295(var15.worldX, var15.worldY);
                                       if(var40 == null) {
                                          class80.intStack[++class80.intStackSize - 1] = -1;
                                       } else {
                                          class80.intStack[++class80.intStackSize - 1] = var40.method4196();
                                       }

                                       var3 = 1;
                                    }
                                 } else {
                                    Coordinates var45;
                                    if(var0 == 6619) {
                                       class80.intStackSize -= 2;
                                       var4 = class80.intStack[class80.intStackSize];
                                       var45 = new Coordinates(class80.intStack[class80.intStackSize + 1]);
                                       class2.method4(var4, var45, false);
                                       var3 = 1;
                                    } else if(var0 == 6620) {
                                       class80.intStackSize -= 2;
                                       var4 = class80.intStack[class80.intStackSize];
                                       var45 = new Coordinates(class80.intStack[class80.intStackSize + 1]);
                                       class2.method4(var4, var45, true);
                                       var3 = 1;
                                    } else if(var0 == 6621) {
                                       class80.intStackSize -= 2;
                                       var4 = class80.intStack[class80.intStackSize];
                                       var45 = new Coordinates(class80.intStack[class80.intStackSize + 1]);
                                       var17 = GrandExchangeEvent.method97().method5686(var4);
                                       if(var17 == null) {
                                          class80.intStack[++class80.intStackSize - 1] = 0;
                                          var3 = 1;
                                       } else {
                                          class80.intStack[++class80.intStackSize - 1] = var17.method292(var45.plane, var45.worldX, var45.worldY)?1:0;
                                          var3 = 1;
                                       }
                                    } else if(var0 == 6622) {
                                       class80.intStack[++class80.intStackSize - 1] = GrandExchangeEvent.method97().method5694();
                                       class80.intStack[++class80.intStackSize - 1] = GrandExchangeEvent.method97().method5687();
                                       var3 = 1;
                                    } else if(var0 == 6623) {
                                       var15 = new Coordinates(class80.intStack[--class80.intStackSize]);
                                       var38 = GrandExchangeEvent.method97().method5836(var15.plane, var15.worldX, var15.worldY);
                                       if(var38 == null) {
                                          class80.intStack[++class80.intStackSize - 1] = -1;
                                       } else {
                                          class80.intStack[++class80.intStackSize - 1] = var38.method297();
                                       }

                                       var3 = 1;
                                    } else if(var0 == 6624) {
                                       GrandExchangeEvent.method97().method5696(class80.intStack[--class80.intStackSize]);
                                       var3 = 1;
                                    } else if(var0 == 6625) {
                                       GrandExchangeEvent.method97().method5697();
                                       var3 = 1;
                                    } else if(var0 == 6626) {
                                       GrandExchangeEvent.method97().method5806(class80.intStack[--class80.intStackSize]);
                                       var3 = 1;
                                    } else if(var0 == 6627) {
                                       GrandExchangeEvent.method97().method5705();
                                       var3 = 1;
                                    } else {
                                       boolean var33;
                                       if(var0 == 6628) {
                                          var33 = class80.intStack[--class80.intStackSize] == 1;
                                          GrandExchangeEvent.method97().method5700(var33);
                                          var3 = 1;
                                       } else if(var0 == 6629) {
                                          var4 = class80.intStack[--class80.intStackSize];
                                          GrandExchangeEvent.method97().method5701(var4);
                                          var3 = 1;
                                       } else if(var0 == 6630) {
                                          var4 = class80.intStack[--class80.intStackSize];
                                          GrandExchangeEvent.method97().method5702(var4);
                                          var3 = 1;
                                       } else if(var0 == 6631) {
                                          GrandExchangeEvent.method97().method5703();
                                          var3 = 1;
                                       } else if(var0 == 6632) {
                                          var33 = class80.intStack[--class80.intStackSize] == 1;
                                          GrandExchangeEvent.method97().method5779(var33);
                                          var3 = 1;
                                       } else if(var0 == 6633) {
                                          class80.intStackSize -= 2;
                                          var4 = class80.intStack[class80.intStackSize];
                                          var29 = class80.intStack[class80.intStackSize + 1] == 1;
                                          GrandExchangeEvent.method97().method5707(var4, var29);
                                          var3 = 1;
                                       } else if(var0 == 6634) {
                                          class80.intStackSize -= 2;
                                          var4 = class80.intStack[class80.intStackSize];
                                          var29 = class80.intStack[class80.intStackSize + 1] == 1;
                                          GrandExchangeEvent.method97().method5794(var4, var29);
                                          var3 = 1;
                                       } else if(var0 == 6635) {
                                          class80.intStack[++class80.intStackSize - 1] = GrandExchangeEvent.method97().method5731()?1:0;
                                          var3 = 1;
                                       } else if(var0 == 6636) {
                                          var4 = class80.intStack[--class80.intStackSize];
                                          class80.intStack[++class80.intStackSize - 1] = GrandExchangeEvent.method97().method5708(var4)?1:0;
                                          var3 = 1;
                                       } else if(var0 == 6637) {
                                          var4 = class80.intStack[--class80.intStackSize];
                                          class80.intStack[++class80.intStackSize - 1] = GrandExchangeEvent.method97().method5709(var4)?1:0;
                                          var3 = 1;
                                       } else if(var0 == 6638) {
                                          class80.intStackSize -= 2;
                                          var4 = class80.intStack[class80.intStackSize];
                                          var45 = new Coordinates(class80.intStack[class80.intStackSize + 1]);
                                          var40 = GrandExchangeEvent.method97().method5728(var4, var45);
                                          if(var40 == null) {
                                             class80.intStack[++class80.intStackSize - 1] = -1;
                                          } else {
                                             class80.intStack[++class80.intStackSize - 1] = var40.method4196();
                                          }

                                          var3 = 1;
                                       } else {
                                          class39 var41;
                                          if(var0 == 6639) {
                                             var41 = GrandExchangeEvent.method97().method5714();
                                             if(var41 == null) {
                                                class80.intStack[++class80.intStackSize - 1] = -1;
                                                class80.intStack[++class80.intStackSize - 1] = -1;
                                             } else {
                                                class80.intStack[++class80.intStackSize - 1] = var41.field495;
                                                class80.intStack[++class80.intStackSize - 1] = var41.field496.method4196();
                                             }

                                             var3 = 1;
                                          } else if(var0 == 6640) {
                                             var41 = GrandExchangeEvent.method97().method5715();
                                             if(var41 == null) {
                                                class80.intStack[++class80.intStackSize - 1] = -1;
                                                class80.intStack[++class80.intStackSize - 1] = -1;
                                             } else {
                                                class80.intStack[++class80.intStackSize - 1] = var41.field495;
                                                class80.intStack[++class80.intStackSize - 1] = var41.field496.method4196();
                                             }

                                             var3 = 1;
                                          } else {
                                             Area var50;
                                             if(var0 == 6693) {
                                                var4 = class80.intStack[--class80.intStackSize];
                                                var50 = Area.mapAreaType[var4];
                                                if(var50.name == null) {
                                                   class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
                                                } else {
                                                   class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var50.name;
                                                }

                                                var3 = 1;
                                             } else if(var0 == 6694) {
                                                var4 = class80.intStack[--class80.intStackSize];
                                                var50 = Area.mapAreaType[var4];
                                                class80.intStack[++class80.intStackSize - 1] = var50.field3352;
                                                var3 = 1;
                                             } else if(var0 == 6695) {
                                                var4 = class80.intStack[--class80.intStackSize];
                                                var50 = Area.mapAreaType[var4];
                                                if(var50 == null) {
                                                   class80.intStack[++class80.intStackSize - 1] = -1;
                                                } else {
                                                   class80.intStack[++class80.intStackSize - 1] = var50.field3373;
                                                }

                                                var3 = 1;
                                             } else if(var0 == 6696) {
                                                var4 = class80.intStack[--class80.intStackSize];
                                                var50 = Area.mapAreaType[var4];
                                                if(var50 == null) {
                                                   class80.intStack[++class80.intStackSize - 1] = -1;
                                                } else {
                                                   class80.intStack[++class80.intStackSize - 1] = var50.spriteId;
                                                }

                                                var3 = 1;
                                             } else if(var0 == 6697) {
                                                class80.intStack[++class80.intStackSize - 1] = class137.field1992.field556;
                                                var3 = 1;
                                             } else if(var0 == 6698) {
                                                class80.intStack[++class80.intStackSize - 1] = class137.field1992.field554.method4196();
                                                var3 = 1;
                                             } else if(var0 == 6699) {
                                                class80.intStack[++class80.intStackSize - 1] = class137.field1992.field555.method4196();
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
                     }

                     return var3;
                  } else {
                     return 2;
                  }
               } else {
                  if(var0 == 5306) {
                     class80.intStack[++class80.intStackSize - 1] = World.method1644();
                     var3 = 1;
                  } else if(var0 == 5307) {
                     var4 = class80.intStack[--class80.intStackSize];
                     if(var4 == 1 || var4 == 2) {
                        class80.method1775(var4);
                     }

                     var3 = 1;
                  } else if(var0 == 5308) {
                     class80.intStack[++class80.intStackSize - 1] = class221.preferences.screenType;
                     var3 = 1;
                  } else if(var0 == 5309) {
                     var4 = class80.intStack[--class80.intStackSize];
                     if(var4 == 1 || var4 == 2) {
                        class221.preferences.screenType = var4;
                        method1121();
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "17"
   )
   static void method1122(int var0, int var1, int var2, int var3) {
      for(class79 var4 = (class79)class79.field1208.getFront(); var4 != null; var4 = (class79)class79.field1208.getNext()) {
         if(var4.field1207 != -1 || var4.field1212 != null) {
            int var5 = 0;
            if(var1 > var4.field1202) {
               var5 += var1 - var4.field1202;
            } else if(var1 < var4.field1210) {
               var5 += var4.field1210 - var1;
            }

            if(var2 > var4.field1206) {
               var5 += var2 - var4.field1206;
            } else if(var2 < var4.field1205) {
               var5 += var4.field1205 - var2;
            }

            if(var5 - 64 <= var4.field1204 && Client.field879 != 0 && var0 == var4.field1201) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field1204 - var5) * Client.field879 / var4.field1204;
               if(var4.field1209 == null) {
                  if(var4.field1207 >= 0) {
                     SoundEffect var7 = SoundEffect.getTrack(class23.indexCache4, var4.field1207, 0);
                     if(var7 != null) {
                        RawAudioNode var8 = var7.method2109().applyResampler(PacketNode.field2406);
                        class114 var9 = class114.method2285(var8, 100, var6);
                        var9.method2288(-1);
                        CombatInfoListHolder.field1251.method2080(var9);
                        var4.field1209 = var9;
                     }
                  }
               } else {
                  var4.field1209.method2289(var6);
               }

               if(var4.field1214 == null) {
                  if(var4.field1212 != null && (var4.field1213 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.field1212.length);
                     SoundEffect var12 = SoundEffect.getTrack(class23.indexCache4, var4.field1212[var11], 0);
                     if(var12 != null) {
                        RawAudioNode var13 = var12.method2109().applyResampler(PacketNode.field2406);
                        class114 var10 = class114.method2285(var13, 100, var6);
                        var10.method2288(0);
                        CombatInfoListHolder.field1251.method2080(var10);
                        var4.field1214 = var10;
                        var4.field1213 = var4.field1203 + (int)(Math.random() * (double)(var4.field1211 - var4.field1203));
                     }
                  }
               } else {
                  var4.field1214.method2289(var6);
                  if(!var4.field1214.linked()) {
                     var4.field1214 = null;
                  }
               }
            } else {
               if(var4.field1209 != null) {
                  CombatInfoListHolder.field1251.method2082(var4.field1209);
                  var4.field1209 = null;
               }

               if(var4.field1214 != null) {
                  CombatInfoListHolder.field1251.method2082(var4.field1214);
                  var4.field1214 = null;
               }
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "902226277"
   )
   static void method1121() {
      FileOnDisk var0 = null;

      try {
         var0 = UrlRequester.getPreferencesFile("", WorldComparator.field261.name, true);
         Buffer var1 = class221.preferences.serialize();
         var0.write(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.closeSync(true);
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-24551029"
   )
   static void method1123() {
      if(class89.field1320) {
         class89.field1302 = null;
         class89.field1303 = null;
         ScriptState.runeSprites = null;
         class89.field1316 = null;
         class295.field3780 = null;
         class7.logoSprite = null;
         class18.titlemuteSprite = null;
         class89.field1305 = null;
         TextureProvider.field1658 = null;
         class56.field618 = null;
         class157.slFlagSprites = null;
         class46.slArrowSprites = null;
         class263.slStarSprites = null;
         CombatInfo2.field3434 = null;
         UnitPriceComparator.field300 = null;
         class238.field3223 = null;
         class239.field3236 = null;
         TotalQuantityComparator.field284 = null;
         ScriptState.field708 = null;
         class94.field1404 = null;
         NetWriter.field1440 = null;
         Client.field1080 = null;
         class214.field2596 = 1;
         Item.field1369 = null;
         GZipDecompressor.field2420 = -1;
         class186.field2505 = -1;
         class214.field2597 = 0;
         class214.field2594 = false;
         class85.field1268 = 2;
         class31.sendConInfo(true);
         class89.field1320 = false;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1184196489"
   )
   public static void method1126() {
      Area.areaSpriteCache.reset();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-284640927"
   )
   static final boolean method1117(int var0, int var1) {
      ObjectComposition var2 = TextureProvider.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method4791(var1);
   }
}
