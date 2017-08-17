import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
@Implements("VarPlayerType")
public class VarPlayerType extends CacheableNode {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("varplayers")
   static NodeCache varplayers;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 269950909
   )
   static int field3274;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("varplayer_ref")
   static IndexDataBase varplayer_ref;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1680750789
   )
   @Export("configType")
   public int configType;

   static {
      varplayers = new NodeCache(64);
   }

   VarPlayerType() {
      this.configType = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfb;II)V",
      garbageValue = "78631343"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      if(var2 == 5) {
         this.configType = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfb;I)V",
      garbageValue = "-1705881076"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.decode(var1, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   static void method4302(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.get((long)var0);
      if(var1 != null) {
         for(int var2 = 0; var2 < var1.itemIds.length; ++var2) {
            var1.itemIds[var2] = -1;
            var1.stackSizes[var2] = 0;
         }

      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-2035360863"
   )
   public static String method4301(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            char var6;
            if(var5 != 181 && var5 != 131) {
               var6 = Character.toTitleCase(var5);
            } else {
               var6 = var5;
            }

            var5 = var6;
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "1687764160"
   )
   static int method4287(int var0, Script var1, boolean var2) {
      byte var3;
      int var4;
      int var6;
      int var9;
      int var32;
      Widget var40;
      Widget var63;
      Widget var68;
      if(var0 < 1000) {
         if(var0 == 100) {
            class84.intStackSize -= 3;
            var4 = class84.intStack[class84.intStackSize];
            var32 = class84.intStack[class84.intStackSize + 1];
            var6 = class84.intStack[class84.intStackSize + 2];
            if(var32 == 0) {
               throw new RuntimeException();
            }

            var40 = class84.method1670(var4);
            if(var40.children == null) {
               var40.children = new Widget[var6 + 1];
            }

            if(var40.children.length <= var6) {
               Widget[] var43 = new Widget[var6 + 1];

               for(var9 = 0; var9 < var40.children.length; ++var9) {
                  var43[var9] = var40.children[var9];
               }

               var40.children = var43;
            }

            if(var6 > 0 && var40.children[var6 - 1] == null) {
               throw new RuntimeException("" + (var6 - 1));
            }

            Widget var45 = new Widget();
            var45.type = var32;
            var45.parentId = var45.id = var40.id;
            var45.index = var6;
            var45.hasScript = true;
            var40.children[var6] = var45;
            if(var2) {
               class43.field582 = var45;
            } else {
               class208.field2580 = var45;
            }

            class90.method1723(var40);
            var3 = 1;
         } else if(var0 == 101) {
            var68 = var2?class43.field582:class208.field2580;
            Widget var67 = class84.method1670(var68.id);
            var67.children[var68.index] = null;
            class90.method1723(var67);
            var3 = 1;
         } else if(var0 == 102) {
            var68 = class84.method1670(class84.intStack[--class84.intStackSize]);
            var68.children = null;
            class90.method1723(var68);
            var3 = 1;
         } else if(var0 == 200) {
            class84.intStackSize -= 2;
            var4 = class84.intStack[class84.intStackSize];
            var32 = class84.intStack[class84.intStackSize + 1];
            var63 = class205.method3812(var4, var32);
            if(var63 != null && var32 != -1) {
               class84.intStack[++class84.intStackSize - 1] = 1;
               if(var2) {
                  class43.field582 = var63;
               } else {
                  class208.field2580 = var63;
               }
            } else {
               class84.intStack[++class84.intStackSize - 1] = 0;
            }

            var3 = 1;
         } else if(var0 == 201) {
            var68 = class84.method1670(class84.intStack[--class84.intStackSize]);
            if(var68 != null) {
               class84.intStack[++class84.intStackSize - 1] = 1;
               if(var2) {
                  class43.field582 = var68;
               } else {
                  class208.field2580 = var68;
               }
            } else {
               class84.intStack[++class84.intStackSize - 1] = 0;
            }

            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 1100) {
         return class66.method1145(var0, var1, var2);
      } else if(var0 < 1200) {
         return class1.method1(var0, var1, var2);
      } else if(var0 < 1300) {
         return class12.method59(var0, var1, var2);
      } else if(var0 < 1400) {
         return class36.method509(var0, var1, var2);
      } else if(var0 < 1500) {
         return RSCanvas.method823(var0, var1, var2);
      } else if(var0 < 1600) {
         return class39.method556(var0, var1, var2);
      } else if(var0 < 1700) {
         return class18.method142(var0, var1, var2);
      } else if(var0 < 1800) {
         var40 = var2?class43.field582:class208.field2580;
         if(var0 == 1700) {
            class84.intStack[++class84.intStackSize - 1] = var40.itemId;
            var3 = 1;
         } else if(var0 == 1701) {
            if(var40.itemId != -1) {
               class84.intStack[++class84.intStackSize - 1] = var40.itemQuantity;
            } else {
               class84.intStack[++class84.intStackSize - 1] = 0;
            }

            var3 = 1;
         } else if(var0 == 1702) {
            class84.intStack[++class84.intStackSize - 1] = var40.index;
            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else {
         int var17;
         int var49;
         int[] var53;
         if(var0 < 1900) {
            var68 = var2?class43.field582:class208.field2580;
            if(var0 == 1800) {
               var53 = class84.intStack;
               var6 = ++class84.intStackSize - 1;
               var17 = class262.getWidgetConfig(var68);
               var49 = var17 >> 11 & 63;
               var53[var6] = var49;
               var3 = 1;
            } else if(var0 == 1801) {
               var32 = class84.intStack[--class84.intStackSize];
               --var32;
               if(var68.actions != null && var32 < var68.actions.length && var68.actions[var32] != null) {
                  class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var68.actions[var32];
               } else {
                  class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
               }

               var3 = 1;
            } else if(var0 == 1802) {
               if(var68.name == null) {
                  class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
               } else {
                  class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var68.name;
               }

               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 2000) {
            return ScriptState.method1122(var0, var1, var2);
         } else if(var0 < 2100) {
            return class66.method1145(var0, var1, var2);
         } else if(var0 < 2200) {
            return class1.method1(var0, var1, var2);
         } else if(var0 < 2300) {
            return class12.method59(var0, var1, var2);
         } else if(var0 < 2400) {
            return class36.method509(var0, var1, var2);
         } else if(var0 < 2500) {
            return RSCanvas.method823(var0, var1, var2);
         } else if(var0 < 2600) {
            var68 = class84.method1670(class84.intStack[--class84.intStackSize]);
            if(var0 == 2500) {
               class84.intStack[++class84.intStackSize - 1] = var68.relativeX;
               var3 = 1;
            } else if(var0 == 2501) {
               class84.intStack[++class84.intStackSize - 1] = var68.relativeY;
               var3 = 1;
            } else if(var0 == 2502) {
               class84.intStack[++class84.intStackSize - 1] = var68.width;
               var3 = 1;
            } else if(var0 == 2503) {
               class84.intStack[++class84.intStackSize - 1] = var68.height;
               var3 = 1;
            } else if(var0 == 2504) {
               class84.intStack[++class84.intStackSize - 1] = var68.isHidden?1:0;
               var3 = 1;
            } else if(var0 == 2505) {
               class84.intStack[++class84.intStackSize - 1] = var68.parentId;
               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 2700) {
            return class13.method75(var0, var1, var2);
         } else if(var0 < 2800) {
            if(var0 == 2700) {
               var68 = class84.method1670(class84.intStack[--class84.intStackSize]);
               class84.intStack[++class84.intStackSize - 1] = var68.itemId;
               var3 = 1;
            } else if(var0 == 2701) {
               var68 = class84.method1670(class84.intStack[--class84.intStackSize]);
               if(var68.itemId != -1) {
                  class84.intStack[++class84.intStackSize - 1] = var68.itemQuantity;
               } else {
                  class84.intStack[++class84.intStackSize - 1] = 0;
               }

               var3 = 1;
            } else if(var0 == 2702) {
               var4 = class84.intStack[--class84.intStackSize];
               WidgetNode var66 = (WidgetNode)Client.componentTable.get((long)var4);
               if(var66 != null) {
                  class84.intStack[++class84.intStackSize - 1] = 1;
               } else {
                  class84.intStack[++class84.intStackSize - 1] = 0;
               }

               var3 = 1;
            } else if(var0 == 2706) {
               class84.intStack[++class84.intStackSize - 1] = Client.widgetRoot;
               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 2900) {
            var68 = class84.method1670(class84.intStack[--class84.intStackSize]);
            if(var0 == 2800) {
               var53 = class84.intStack;
               var6 = ++class84.intStackSize - 1;
               var17 = class262.getWidgetConfig(var68);
               var49 = var17 >> 11 & 63;
               var53[var6] = var49;
               var3 = 1;
            } else if(var0 == 2801) {
               var32 = class84.intStack[--class84.intStackSize];
               --var32;
               if(var68.actions != null && var32 < var68.actions.length && var68.actions[var32] != null) {
                  class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var68.actions[var32];
               } else {
                  class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
               }

               var3 = 1;
            } else if(var0 == 2802) {
               if(var68.name == null) {
                  class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
               } else {
                  class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var68.name;
               }

               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 3000) {
            return ScriptState.method1122(var0, var1, var2);
         } else {
            boolean var5;
            String var46;
            String var51;
            if(var0 < 3200) {
               if(var0 == 3100) {
                  var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                  NPC.sendGameMessage(0, "", var46);
                  var3 = 1;
               } else if(var0 == 3101) {
                  class84.intStackSize -= 2;
                  class3.method6(XGrandExchangeOffer.localPlayer, class84.intStack[class84.intStackSize], class84.intStack[class84.intStackSize + 1]);
                  var3 = 1;
               } else if(var0 == 3103) {
                  Actor.method1543();
                  var3 = 1;
               } else if(var0 == 3104) {
                  var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                  var32 = 0;
                  if(class141.method2889(var46)) {
                     var32 = class255.method4554(var46);
                  }

                  Client.secretPacketBuffer1.putOpcode(5);
                  Client.secretPacketBuffer1.putInt(var32);
                  var3 = 1;
               } else if(var0 == 3105) {
                  var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                  Client.secretPacketBuffer1.putOpcode(251);
                  Client.secretPacketBuffer1.putByte(var46.length() + 1);
                  Client.secretPacketBuffer1.putString(var46);
                  var3 = 1;
               } else if(var0 == 3106) {
                  var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                  Client.secretPacketBuffer1.putOpcode(0);
                  Client.secretPacketBuffer1.putByte(var46.length() + 1);
                  Client.secretPacketBuffer1.putString(var46);
                  var3 = 1;
               } else if(var0 == 3107) {
                  var4 = class84.intStack[--class84.intStackSize];
                  var51 = class84.scriptStringStack[--class91.scriptStringStackSize];
                  var6 = class97.field1510;
                  int[] var39 = class97.field1511;
                  boolean var60 = false;

                  for(var9 = 0; var9 < var6; ++var9) {
                     Player var44 = Client.cachedPlayers[var39[var9]];
                     if(var44 != null && var44 != XGrandExchangeOffer.localPlayer && var44.name != null && var44.name.equalsIgnoreCase(var51)) {
                        if(var4 == 1) {
                           Client.secretPacketBuffer1.putOpcode(190);
                           Client.secretPacketBuffer1.method3208(var39[var9]);
                           Client.secretPacketBuffer1.putLEInt(0);
                        } else if(var4 == 4) {
                           Client.secretPacketBuffer1.putOpcode(154);
                           Client.secretPacketBuffer1.method3312(var39[var9]);
                           Client.secretPacketBuffer1.putLEInt(0);
                        } else if(var4 == 6) {
                           Client.secretPacketBuffer1.putOpcode(114);
                           Client.secretPacketBuffer1.putLEInt(0);
                           Client.secretPacketBuffer1.putShortLE(var39[var9]);
                        } else if(var4 == 7) {
                           Client.secretPacketBuffer1.putOpcode(26);
                           Client.secretPacketBuffer1.method3262(0);
                           Client.secretPacketBuffer1.method3208(var39[var9]);
                        }

                        var60 = true;
                        break;
                     }
                  }

                  if(!var60) {
                     NPC.sendGameMessage(4, "", "Unable to find " + var51);
                  }

                  var3 = 1;
               } else if(var0 == 3108) {
                  class84.intStackSize -= 3;
                  var4 = class84.intStack[class84.intStackSize];
                  var32 = class84.intStack[class84.intStackSize + 1];
                  var6 = class84.intStack[class84.intStackSize + 2];
                  var40 = class84.method1670(var6);
                  class61.method1117(var40, var4, var32);
                  var3 = 1;
               } else if(var0 == 3109) {
                  class84.intStackSize -= 2;
                  var4 = class84.intStack[class84.intStackSize];
                  var32 = class84.intStack[class84.intStackSize + 1];
                  var63 = var2?class43.field582:class208.field2580;
                  class61.method1117(var63, var4, var32);
                  var3 = 1;
               } else if(var0 == 3110) {
                  XGrandExchangeOffer.field302 = class84.intStack[--class84.intStackSize] == 1;
                  var3 = 1;
               } else if(var0 == 3111) {
                  class84.intStack[++class84.intStackSize - 1] = class3.preferences.hideRoofs?1:0;
                  var3 = 1;
               } else if(var0 == 3112) {
                  class3.preferences.hideRoofs = class84.intStack[--class84.intStackSize] == 1;
                  class33.method372();
                  var3 = 1;
               } else if(var0 == 3113) {
                  var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                  var5 = class84.intStack[--class84.intStackSize] == 1;
                  class31.method292(var46, var5, false);
                  var3 = 1;
               } else if(var0 == 3115) {
                  var4 = class84.intStack[--class84.intStackSize];
                  Client.secretPacketBuffer1.putOpcode(69);
                  Client.secretPacketBuffer1.putShort(var4);
                  var3 = 1;
               } else if(var0 == 3116) {
                  var4 = class84.intStack[--class84.intStackSize];
                  class91.scriptStringStackSize -= 2;
                  var51 = class84.scriptStringStack[class91.scriptStringStackSize];
                  String var64 = class84.scriptStringStack[class91.scriptStringStackSize + 1];
                  if(var51.length() > 500) {
                     var3 = 1;
                  } else if(var64.length() > 500) {
                     var3 = 1;
                  } else {
                     Client.secretPacketBuffer1.putOpcode(200);
                     Client.secretPacketBuffer1.putShort(1 + class169.getLength(var51) + class169.getLength(var64));
                     Client.secretPacketBuffer1.method3200(var4);
                     Client.secretPacketBuffer1.putString(var51);
                     Client.secretPacketBuffer1.putString(var64);
                     var3 = 1;
                  }
               } else if(var0 == 3117) {
                  Client.field1074 = class84.intStack[--class84.intStackSize] == 1;
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 3300) {
               return RSCanvas.method830(var0, var1, var2);
            } else {
               int var11;
               if(var0 < 3400) {
                  if(var0 == 3300) {
                     class84.intStack[++class84.intStackSize - 1] = Client.gameCycle;
                     var3 = 1;
                  } else if(var0 == 3301) {
                     class84.intStackSize -= 2;
                     var4 = class84.intStack[class84.intStackSize];
                     var32 = class84.intStack[class84.intStackSize + 1];
                     class84.intStack[++class84.intStackSize - 1] = Item.method1779(var4, var32);
                     var3 = 1;
                  } else {
                     int[] var58;
                     XItemContainer var59;
                     if(var0 == 3302) {
                        class84.intStackSize -= 2;
                        var4 = class84.intStack[class84.intStackSize];
                        var32 = class84.intStack[class84.intStackSize + 1];
                        var58 = class84.intStack;
                        var49 = ++class84.intStackSize - 1;
                        var59 = (XItemContainer)XItemContainer.itemContainers.get((long)var4);
                        if(var59 == null) {
                           var17 = 0;
                        } else if(var32 >= 0 && var32 < var59.stackSizes.length) {
                           var17 = var59.stackSizes[var32];
                        } else {
                           var17 = 0;
                        }

                        var58[var49] = var17;
                        var3 = 1;
                     } else {
                        int var62;
                        if(var0 == 3303) {
                           class84.intStackSize -= 2;
                           var4 = class84.intStack[class84.intStackSize];
                           var32 = class84.intStack[class84.intStackSize + 1];
                           var58 = class84.intStack;
                           var49 = ++class84.intStackSize - 1;
                           var59 = (XItemContainer)XItemContainer.itemContainers.get((long)var4);
                           if(var59 == null) {
                              var17 = 0;
                           } else if(var32 == -1) {
                              var17 = 0;
                           } else {
                              var62 = 0;

                              for(var11 = 0; var11 < var59.stackSizes.length; ++var11) {
                                 if(var32 == var59.itemIds[var11]) {
                                    var62 += var59.stackSizes[var11];
                                 }
                              }

                              var17 = var62;
                           }

                           var58[var49] = var17;
                           var3 = 1;
                        } else if(var0 == 3304) {
                           var4 = class84.intStack[--class84.intStackSize];
                           class84.intStack[++class84.intStackSize - 1] = class1.method2(var4).size;
                           var3 = 1;
                        } else if(var0 == 3305) {
                           var4 = class84.intStack[--class84.intStackSize];
                           class84.intStack[++class84.intStackSize - 1] = Client.boostedSkillLevels[var4];
                           var3 = 1;
                        } else if(var0 == 3306) {
                           var4 = class84.intStack[--class84.intStackSize];
                           class84.intStack[++class84.intStackSize - 1] = Client.realSkillLevels[var4];
                           var3 = 1;
                        } else if(var0 == 3307) {
                           var4 = class84.intStack[--class84.intStackSize];
                           class84.intStack[++class84.intStackSize - 1] = Client.skillExperiences[var4];
                           var3 = 1;
                        } else if(var0 == 3308) {
                           var4 = class35.plane;
                           var32 = (XGrandExchangeOffer.localPlayer.x >> 7) + class47.baseX;
                           var6 = (XGrandExchangeOffer.localPlayer.y >> 7) + class44.baseY;
                           class84.intStack[++class84.intStackSize - 1] = (var32 << 14) + var6 + (var4 << 28);
                           var3 = 1;
                        } else if(var0 == 3309) {
                           var4 = class84.intStack[--class84.intStackSize];
                           class84.intStack[++class84.intStackSize - 1] = var4 >> 14 & 16383;
                           var3 = 1;
                        } else if(var0 == 3310) {
                           var4 = class84.intStack[--class84.intStackSize];
                           class84.intStack[++class84.intStackSize - 1] = var4 >> 28;
                           var3 = 1;
                        } else if(var0 == 3311) {
                           var4 = class84.intStack[--class84.intStackSize];
                           class84.intStack[++class84.intStackSize - 1] = var4 & 16383;
                           var3 = 1;
                        } else if(var0 == 3312) {
                           class84.intStack[++class84.intStackSize - 1] = Client.isMembers?1:0;
                           var3 = 1;
                        } else if(var0 == 3313) {
                           class84.intStackSize -= 2;
                           var4 = class84.intStack[class84.intStackSize] + '耀';
                           var32 = class84.intStack[class84.intStackSize + 1];
                           class84.intStack[++class84.intStackSize - 1] = Item.method1779(var4, var32);
                           var3 = 1;
                        } else if(var0 == 3314) {
                           class84.intStackSize -= 2;
                           var4 = class84.intStack[class84.intStackSize] + '耀';
                           var32 = class84.intStack[class84.intStackSize + 1];
                           class84.intStack[++class84.intStackSize - 1] = Enum.method4509(var4, var32);
                           var3 = 1;
                        } else if(var0 == 3315) {
                           class84.intStackSize -= 2;
                           var4 = class84.intStack[class84.intStackSize] + '耀';
                           var32 = class84.intStack[class84.intStackSize + 1];
                           var58 = class84.intStack;
                           var49 = ++class84.intStackSize - 1;
                           var59 = (XItemContainer)XItemContainer.itemContainers.get((long)var4);
                           if(var59 == null) {
                              var17 = 0;
                           } else if(var32 == -1) {
                              var17 = 0;
                           } else {
                              var62 = 0;

                              for(var11 = 0; var11 < var59.stackSizes.length; ++var11) {
                                 if(var32 == var59.itemIds[var11]) {
                                    var62 += var59.stackSizes[var11];
                                 }
                              }

                              var17 = var62;
                           }

                           var58[var49] = var17;
                           var3 = 1;
                        } else if(var0 == 3316) {
                           if(Client.rights >= 2) {
                              class84.intStack[++class84.intStackSize - 1] = Client.rights;
                           } else {
                              class84.intStack[++class84.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        } else if(var0 == 3317) {
                           class84.intStack[++class84.intStackSize - 1] = Client.field950;
                           var3 = 1;
                        } else if(var0 == 3318) {
                           class84.intStack[++class84.intStackSize - 1] = Client.world;
                           var3 = 1;
                        } else if(var0 == 3321) {
                           class84.intStack[++class84.intStackSize - 1] = Client.energy;
                           var3 = 1;
                        } else if(var0 == 3322) {
                           class84.intStack[++class84.intStackSize - 1] = Client.weight;
                           var3 = 1;
                        } else if(var0 == 3323) {
                           if(Client.field1158) {
                              class84.intStack[++class84.intStackSize - 1] = 1;
                           } else {
                              class84.intStack[++class84.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        } else if(var0 == 3324) {
                           class84.intStack[++class84.intStackSize - 1] = Client.flags;
                           var3 = 1;
                        } else if(var0 == 3325) {
                           class84.intStackSize -= 4;
                           var4 = class84.intStack[class84.intStackSize];
                           var32 = class84.intStack[class84.intStackSize + 1];
                           var6 = class84.intStack[class84.intStackSize + 2];
                           var49 = class84.intStack[class84.intStackSize + 3];
                           var4 += var32 << 14;
                           var4 += var6 << 28;
                           var4 += var49;
                           class84.intStack[++class84.intStackSize - 1] = var4;
                           var3 = 1;
                        } else {
                           var3 = 2;
                        }
                     }
                  }

                  return var3;
               } else if(var0 < 3500) {
                  if(var0 == 3400) {
                     class84.intStackSize -= 2;
                     var4 = class84.intStack[class84.intStackSize];
                     var32 = class84.intStack[class84.intStackSize + 1];
                     Enum var57 = class224.method4086(var4);
                     if(var57.valType != 115) {
                        ;
                     }

                     for(var49 = 0; var49 < var57.size; ++var49) {
                        if(var32 == var57.keys[var49]) {
                           class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var57.stringVals[var49];
                           var57 = null;
                           break;
                        }
                     }

                     if(var57 != null) {
                        class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var57.defaultString;
                     }

                     var3 = 1;
                  } else if(var0 == 3408) {
                     class84.intStackSize -= 4;
                     var4 = class84.intStack[class84.intStackSize];
                     var32 = class84.intStack[class84.intStackSize + 1];
                     var6 = class84.intStack[class84.intStackSize + 2];
                     var49 = class84.intStack[class84.intStackSize + 3];
                     Enum var42 = class224.method4086(var6);
                     if(var4 == var42.keyType && var32 == var42.valType) {
                        for(var9 = 0; var9 < var42.size; ++var9) {
                           if(var49 == var42.keys[var9]) {
                              if(var32 == 115) {
                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var42.stringVals[var9];
                              } else {
                                 class84.intStack[++class84.intStackSize - 1] = var42.intVals[var9];
                              }

                              var42 = null;
                              break;
                           }
                        }

                        if(var42 != null) {
                           if(var32 == 115) {
                              class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var42.defaultString;
                           } else {
                              class84.intStack[++class84.intStackSize - 1] = var42.defaultInt;
                           }
                        }

                        var3 = 1;
                     } else {
                        if(var32 == 115) {
                           class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "null";
                        } else {
                           class84.intStack[++class84.intStackSize - 1] = 0;
                        }

                        var3 = 1;
                     }
                  } else {
                     var3 = 2;
                  }

                  return var3;
               } else {
                  String var20;
                  if(var0 < 3700) {
                     if(var0 == 3600) {
                        if(Client.field1192 == 0) {
                           class84.intStack[++class84.intStackSize - 1] = -2;
                        } else if(Client.field1192 == 1) {
                           class84.intStack[++class84.intStackSize - 1] = -1;
                        } else {
                           class84.intStack[++class84.intStackSize - 1] = Client.friendCount;
                        }

                        var3 = 1;
                     } else if(var0 == 3601) {
                        var4 = class84.intStack[--class84.intStackSize];
                        if(Client.field1192 == 2 && var4 < Client.friendCount) {
                           class84.scriptStringStack[++class91.scriptStringStackSize - 1] = Client.friends[var4].name;
                           class84.scriptStringStack[++class91.scriptStringStackSize - 1] = Client.friends[var4].previousName;
                        } else {
                           class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
                           class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
                        }

                        var3 = 1;
                     } else if(var0 == 3602) {
                        var4 = class84.intStack[--class84.intStackSize];
                        if(Client.field1192 == 2 && var4 < Client.friendCount) {
                           class84.intStack[++class84.intStackSize - 1] = Client.friends[var4].world;
                        } else {
                           class84.intStack[++class84.intStackSize - 1] = 0;
                        }

                        var3 = 1;
                     } else if(var0 == 3603) {
                        var4 = class84.intStack[--class84.intStackSize];
                        if(Client.field1192 == 2 && var4 < Client.friendCount) {
                           class84.intStack[++class84.intStackSize - 1] = Client.friends[var4].rank;
                        } else {
                           class84.intStack[++class84.intStackSize - 1] = 0;
                        }

                        var3 = 1;
                     } else if(var0 == 3604) {
                        var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                        var32 = class84.intStack[--class84.intStackSize];
                        class69.method1157(var46, var32);
                        var3 = 1;
                     } else {
                        Friend var34;
                        Ignore var35;
                        String var36;
                        if(var0 == 3605) {
                           var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                           if(var46 != null) {
                              if((Client.friendCount < 200 || Client.field1120 == 1) && Client.friendCount < 400) {
                                 var51 = FloorUnderlayDefinition.method4398(var46, class22.field354);
                                 if(var51 != null) {
                                    var6 = 0;

                                    label2009:
                                    while(true) {
                                       if(var6 >= Client.friendCount) {
                                          for(var6 = 0; var6 < Client.ignoreCount; ++var6) {
                                             var35 = Client.ignores[var6];
                                             var36 = FloorUnderlayDefinition.method4398(var35.name, class22.field354);
                                             if(var36 != null && var36.equals(var51)) {
                                                NPC.sendGameMessage(30, "", "Please remove " + var46 + " from your ignore list first");
                                                break label2009;
                                             }

                                             if(var35.previousName != null) {
                                                var20 = FloorUnderlayDefinition.method4398(var35.previousName, class22.field354);
                                                if(var20 != null && var20.equals(var51)) {
                                                   NPC.sendGameMessage(30, "", "Please remove " + var46 + " from your ignore list first");
                                                   break label2009;
                                                }
                                             }
                                          }

                                          if(FloorUnderlayDefinition.method4398(XGrandExchangeOffer.localPlayer.name, class22.field354).equals(var51)) {
                                             NPC.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
                                          } else {
                                             Client.secretPacketBuffer1.putOpcode(226);
                                             Client.secretPacketBuffer1.putByte(class169.getLength(var46));
                                             Client.secretPacketBuffer1.putString(var46);
                                          }
                                          break;
                                       }

                                       var34 = Client.friends[var6];
                                       var36 = FloorUnderlayDefinition.method4398(var34.name, class22.field354);
                                       if(var36 != null && var36.equals(var51)) {
                                          NPC.sendGameMessage(30, "", var46 + " is already on your friend list");
                                          break;
                                       }

                                       if(var34.previousName != null) {
                                          var20 = FloorUnderlayDefinition.method4398(var34.previousName, class22.field354);
                                          if(var20 != null && var20.equals(var51)) {
                                             NPC.sendGameMessage(30, "", var46 + " is already on your friend list");
                                             break;
                                          }
                                       }

                                       ++var6;
                                    }
                                 }
                              } else {
                                 NPC.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
                              }
                           }

                           var3 = 1;
                        } else {
                           boolean var21;
                           if(var0 == 3606) {
                              var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                              if(var46 != null) {
                                 var51 = FloorUnderlayDefinition.method4398(var46, class22.field354);
                                 if(var51 != null) {
                                    for(var6 = 0; var6 < Client.friendCount; ++var6) {
                                       var34 = Client.friends[var6];
                                       var36 = var34.name;
                                       var20 = FloorUnderlayDefinition.method4398(var36, class22.field354);
                                       if(var46 != null && var36 != null) {
                                          if(!var46.startsWith("#") && !var36.startsWith("#")) {
                                             var21 = var51.equals(var20);
                                          } else {
                                             var21 = var46.equals(var36);
                                          }
                                       } else {
                                          var21 = false;
                                       }

                                       if(var21) {
                                          --Client.friendCount;

                                          for(var11 = var6; var11 < Client.friendCount; ++var11) {
                                             Client.friends[var11] = Client.friends[var11 + 1];
                                          }

                                          Client.field1119 = Client.cycleCntr;
                                          Client.secretPacketBuffer1.putOpcode(175);
                                          Client.secretPacketBuffer1.putByte(class169.getLength(var46));
                                          Client.secretPacketBuffer1.putString(var46);
                                          break;
                                       }
                                    }
                                 }
                              }

                              var3 = 1;
                           } else if(var0 == 3607) {
                              var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                              if(var46 != null) {
                                 if((Client.ignoreCount < 100 || Client.field1120 == 1) && Client.ignoreCount < 400) {
                                    var51 = FloorUnderlayDefinition.method4398(var46, class22.field354);
                                    if(var51 != null) {
                                       var6 = 0;

                                       label1947:
                                       while(true) {
                                          if(var6 >= Client.ignoreCount) {
                                             for(var6 = 0; var6 < Client.friendCount; ++var6) {
                                                var34 = Client.friends[var6];
                                                var36 = FloorUnderlayDefinition.method4398(var34.name, class22.field354);
                                                if(var36 != null && var36.equals(var51)) {
                                                   NPC.sendGameMessage(31, "", "Please remove " + var46 + " from your friend list first");
                                                   break label1947;
                                                }

                                                if(var34.previousName != null) {
                                                   var20 = FloorUnderlayDefinition.method4398(var34.previousName, class22.field354);
                                                   if(var20 != null && var20.equals(var51)) {
                                                      NPC.sendGameMessage(31, "", "Please remove " + var46 + " from your friend list first");
                                                      break label1947;
                                                   }
                                                }
                                             }

                                             if(FloorUnderlayDefinition.method4398(XGrandExchangeOffer.localPlayer.name, class22.field354).equals(var51)) {
                                                NPC.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
                                             } else {
                                                Client.secretPacketBuffer1.putOpcode(64);
                                                Client.secretPacketBuffer1.putByte(class169.getLength(var46));
                                                Client.secretPacketBuffer1.putString(var46);
                                             }
                                             break;
                                          }

                                          var35 = Client.ignores[var6];
                                          var36 = FloorUnderlayDefinition.method4398(var35.name, class22.field354);
                                          if(var36 != null && var36.equals(var51)) {
                                             NPC.sendGameMessage(31, "", var46 + " is already on your ignore list");
                                             break;
                                          }

                                          if(var35.previousName != null) {
                                             var20 = FloorUnderlayDefinition.method4398(var35.previousName, class22.field354);
                                             if(var20 != null && var20.equals(var51)) {
                                                NPC.sendGameMessage(31, "", var46 + " is already on your ignore list");
                                                break;
                                             }
                                          }

                                          ++var6;
                                       }
                                    }
                                 } else {
                                    NPC.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                                 }
                              }

                              var3 = 1;
                           } else if(var0 == 3608) {
                              var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                              if(var46 != null) {
                                 var51 = FloorUnderlayDefinition.method4398(var46, class22.field354);
                                 if(var51 != null) {
                                    for(var6 = 0; var6 < Client.ignoreCount; ++var6) {
                                       var35 = Client.ignores[var6];
                                       var36 = var35.name;
                                       var20 = FloorUnderlayDefinition.method4398(var36, class22.field354);
                                       if(var46 != null && var36 != null) {
                                          if(!var46.startsWith("#") && !var36.startsWith("#")) {
                                             var21 = var51.equals(var20);
                                          } else {
                                             var21 = var46.equals(var36);
                                          }
                                       } else {
                                          var21 = false;
                                       }

                                       if(var21) {
                                          --Client.ignoreCount;

                                          for(var11 = var6; var11 < Client.ignoreCount; ++var11) {
                                             Client.ignores[var11] = Client.ignores[var11 + 1];
                                          }

                                          Client.field1119 = Client.cycleCntr;
                                          Client.secretPacketBuffer1.putOpcode(180);
                                          Client.secretPacketBuffer1.putByte(class169.getLength(var46));
                                          Client.secretPacketBuffer1.putString(var46);
                                          break;
                                       }
                                    }
                                 }
                              }

                              var3 = 1;
                           } else if(var0 == 3609) {
                              var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                              Permission[] var61 = new Permission[]{Permission.field3168, Permission.field3169, Permission.field3164, Permission.field3167, Permission.field3166, Permission.field3165};
                              Permission[] var55 = var61;

                              for(var49 = 0; var49 < var55.length; ++var49) {
                                 Permission var41 = var55[var49];
                                 if(var41.field3170 != -1 && var46.startsWith(class89.method1717(var41.field3170))) {
                                    var46 = var46.substring(6 + Integer.toString(var41.field3170).length());
                                    break;
                                 }
                              }

                              class84.intStack[++class84.intStackSize - 1] = WorldMapType2.isFriended(var46, false)?1:0;
                              var3 = 1;
                           } else {
                              String var10;
                              int var12;
                              int var13;
                              char var14;
                              long var30;
                              String var37;
                              String[] var65;
                              if(var0 == 3611) {
                                 if(Client.clanChatOwner == null) {
                                    class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
                                 } else {
                                    var65 = class84.scriptStringStack;
                                    var32 = ++class91.scriptStringStackSize - 1;
                                    var37 = Client.clanChatOwner;
                                    var30 = 0L;
                                    var12 = var37.length();

                                    for(var13 = 0; var13 < var12; ++var13) {
                                       var30 *= 37L;
                                       var14 = var37.charAt(var13);
                                       if(var14 >= 65 && var14 <= 90) {
                                          var30 += (long)(var14 + 1 - 65);
                                       } else if(var14 >= 97 && var14 <= 122) {
                                          var30 += (long)(var14 + 1 - 97);
                                       } else if(var14 >= 48 && var14 <= 57) {
                                          var30 += (long)(var14 + 27 - 48);
                                       }

                                       if(var30 >= 177917621779460413L) {
                                          break;
                                       }
                                    }

                                    while(var30 % 37L == 0L && var30 != 0L) {
                                       var30 /= 37L;
                                    }

                                    var10 = class22.method181(var30);
                                    if(var10 == null) {
                                       var10 = "";
                                    }

                                    var65[var32] = var10;
                                 }

                                 var3 = 1;
                              } else if(var0 == 3612) {
                                 if(Client.clanChatOwner != null) {
                                    class84.intStack[++class84.intStackSize - 1] = class82.clanChatCount;
                                 } else {
                                    class84.intStack[++class84.intStackSize - 1] = 0;
                                 }

                                 var3 = 1;
                              } else if(var0 == 3613) {
                                 var4 = class84.intStack[--class84.intStackSize];
                                 if(Client.clanChatOwner != null && var4 < class82.clanChatCount) {
                                    class84.scriptStringStack[++class91.scriptStringStackSize - 1] = class28.clanMembers[var4].username;
                                 } else {
                                    class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
                                 }

                                 var3 = 1;
                              } else if(var0 == 3614) {
                                 var4 = class84.intStack[--class84.intStackSize];
                                 if(Client.clanChatOwner != null && var4 < class82.clanChatCount) {
                                    class84.intStack[++class84.intStackSize - 1] = class28.clanMembers[var4].world;
                                 } else {
                                    class84.intStack[++class84.intStackSize - 1] = 0;
                                 }

                                 var3 = 1;
                              } else if(var0 == 3615) {
                                 var4 = class84.intStack[--class84.intStackSize];
                                 if(Client.clanChatOwner != null && var4 < class82.clanChatCount) {
                                    class84.intStack[++class84.intStackSize - 1] = class28.clanMembers[var4].rank;
                                 } else {
                                    class84.intStack[++class84.intStackSize - 1] = 0;
                                 }

                                 var3 = 1;
                              } else if(var0 == 3616) {
                                 class84.intStack[++class84.intStackSize - 1] = MouseInput.field728;
                                 var3 = 1;
                              } else if(var0 == 3617) {
                                 var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                                 if(class28.clanMembers != null) {
                                    Client.secretPacketBuffer1.putOpcode(12);
                                    Client.secretPacketBuffer1.putByte(class169.getLength(var46));
                                    Client.secretPacketBuffer1.putString(var46);
                                 }

                                 var3 = 1;
                              } else if(var0 == 3618) {
                                 class84.intStack[++class84.intStackSize - 1] = class84.clanChatRank;
                                 var3 = 1;
                              } else if(var0 == 3619) {
                                 var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                                 if(!var46.equals("")) {
                                    Client.secretPacketBuffer1.putOpcode(136);
                                    Client.secretPacketBuffer1.putByte(class169.getLength(var46));
                                    Client.secretPacketBuffer1.putString(var46);
                                 }

                                 var3 = 1;
                              } else if(var0 == 3620) {
                                 Client.secretPacketBuffer1.putOpcode(136);
                                 Client.secretPacketBuffer1.putByte(0);
                                 var3 = 1;
                              } else if(var0 == 3621) {
                                 if(Client.field1192 == 0) {
                                    class84.intStack[++class84.intStackSize - 1] = -1;
                                 } else {
                                    class84.intStack[++class84.intStackSize - 1] = Client.ignoreCount;
                                 }

                                 var3 = 1;
                              } else if(var0 == 3622) {
                                 var4 = class84.intStack[--class84.intStackSize];
                                 if(Client.field1192 != 0 && var4 < Client.ignoreCount) {
                                    class84.scriptStringStack[++class91.scriptStringStackSize - 1] = Client.ignores[var4].name;
                                    class84.scriptStringStack[++class91.scriptStringStackSize - 1] = Client.ignores[var4].previousName;
                                 } else {
                                    class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
                                    class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
                                 }

                                 var3 = 1;
                              } else if(var0 == 3623) {
                                 var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                                 if(var46.startsWith(class89.method1717(0)) || var46.startsWith(class89.method1717(1))) {
                                    var46 = var46.substring(7);
                                 }

                                 class84.intStack[++class84.intStackSize - 1] = class27.isIgnored(var46)?1:0;
                                 var3 = 1;
                              } else if(var0 == 3624) {
                                 var4 = class84.intStack[--class84.intStackSize];
                                 if(class28.clanMembers != null && var4 < class82.clanChatCount && class28.clanMembers[var4].username.equalsIgnoreCase(XGrandExchangeOffer.localPlayer.name)) {
                                    class84.intStack[++class84.intStackSize - 1] = 1;
                                 } else {
                                    class84.intStack[++class84.intStackSize - 1] = 0;
                                 }

                                 var3 = 1;
                              } else if(var0 == 3625) {
                                 if(Client.clanChatName == null) {
                                    class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
                                 } else {
                                    var65 = class84.scriptStringStack;
                                    var32 = ++class91.scriptStringStackSize - 1;
                                    var37 = Client.clanChatName;
                                    var30 = 0L;
                                    var12 = var37.length();

                                    for(var13 = 0; var13 < var12; ++var13) {
                                       var30 *= 37L;
                                       var14 = var37.charAt(var13);
                                       if(var14 >= 65 && var14 <= 90) {
                                          var30 += (long)(var14 + 1 - 65);
                                       } else if(var14 >= 97 && var14 <= 122) {
                                          var30 += (long)(var14 + 1 - 97);
                                       } else if(var14 >= 48 && var14 <= 57) {
                                          var30 += (long)(var14 + 27 - 48);
                                       }

                                       if(var30 >= 177917621779460413L) {
                                          break;
                                       }
                                    }

                                    while(var30 % 37L == 0L && 0L != var30) {
                                       var30 /= 37L;
                                    }

                                    var10 = class22.method181(var30);
                                    if(var10 == null) {
                                       var10 = "";
                                    }

                                    var65[var32] = var10;
                                 }

                                 var3 = 1;
                              } else {
                                 var3 = 2;
                              }
                           }
                        }
                     }

                     return var3;
                  } else if(var0 < 4000) {
                     return class222.method4084(var0, var1, var2);
                  } else if(var0 < 4100) {
                     if(var0 == 4000) {
                        class84.intStackSize -= 2;
                        var4 = class84.intStack[class84.intStackSize];
                        var32 = class84.intStack[class84.intStackSize + 1];
                        class84.intStack[++class84.intStackSize - 1] = var32 + var4;
                        var3 = 1;
                     } else if(var0 == 4001) {
                        class84.intStackSize -= 2;
                        var4 = class84.intStack[class84.intStackSize];
                        var32 = class84.intStack[class84.intStackSize + 1];
                        class84.intStack[++class84.intStackSize - 1] = var4 - var32;
                        var3 = 1;
                     } else if(var0 == 4002) {
                        class84.intStackSize -= 2;
                        var4 = class84.intStack[class84.intStackSize];
                        var32 = class84.intStack[class84.intStackSize + 1];
                        class84.intStack[++class84.intStackSize - 1] = var32 * var4;
                        var3 = 1;
                     } else if(var0 == 4003) {
                        class84.intStackSize -= 2;
                        var4 = class84.intStack[class84.intStackSize];
                        var32 = class84.intStack[class84.intStackSize + 1];
                        class84.intStack[++class84.intStackSize - 1] = var4 / var32;
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
                        var32 = class84.intStack[class84.intStackSize + 1];
                        var6 = class84.intStack[class84.intStackSize + 2];
                        var49 = class84.intStack[class84.intStackSize + 3];
                        var17 = class84.intStack[class84.intStackSize + 4];
                        class84.intStack[++class84.intStackSize - 1] = (var17 - var6) * (var32 - var4) / (var49 - var6) + var4;
                        var3 = 1;
                     } else if(var0 == 4007) {
                        class84.intStackSize -= 2;
                        var4 = class84.intStack[class84.intStackSize];
                        var32 = class84.intStack[class84.intStackSize + 1];
                        class84.intStack[++class84.intStackSize - 1] = var4 + var4 * var32 / 100;
                        var3 = 1;
                     } else if(var0 == 4008) {
                        class84.intStackSize -= 2;
                        var4 = class84.intStack[class84.intStackSize];
                        var32 = class84.intStack[class84.intStackSize + 1];
                        class84.intStack[++class84.intStackSize - 1] = var4 | 1 << var32;
                        var3 = 1;
                     } else if(var0 == 4009) {
                        class84.intStackSize -= 2;
                        var4 = class84.intStack[class84.intStackSize];
                        var32 = class84.intStack[class84.intStackSize + 1];
                        class84.intStack[++class84.intStackSize - 1] = var4 & -1 - (1 << var32);
                        var3 = 1;
                     } else if(var0 == 4010) {
                        class84.intStackSize -= 2;
                        var4 = class84.intStack[class84.intStackSize];
                        var32 = class84.intStack[class84.intStackSize + 1];
                        class84.intStack[++class84.intStackSize - 1] = (var4 & 1 << var32) != 0?1:0;
                        var3 = 1;
                     } else if(var0 == 4011) {
                        class84.intStackSize -= 2;
                        var4 = class84.intStack[class84.intStackSize];
                        var32 = class84.intStack[class84.intStackSize + 1];
                        class84.intStack[++class84.intStackSize - 1] = var4 % var32;
                        var3 = 1;
                     } else if(var0 == 4012) {
                        class84.intStackSize -= 2;
                        var4 = class84.intStack[class84.intStackSize];
                        var32 = class84.intStack[class84.intStackSize + 1];
                        if(var4 == 0) {
                           class84.intStack[++class84.intStackSize - 1] = 0;
                        } else {
                           class84.intStack[++class84.intStackSize - 1] = (int)Math.pow((double)var4, (double)var32);
                        }

                        var3 = 1;
                     } else if(var0 == 4013) {
                        class84.intStackSize -= 2;
                        var4 = class84.intStack[class84.intStackSize];
                        var32 = class84.intStack[class84.intStackSize + 1];
                        if(var4 == 0) {
                           class84.intStack[++class84.intStackSize - 1] = 0;
                        } else if(var32 == 0) {
                           class84.intStack[++class84.intStackSize - 1] = Integer.MAX_VALUE;
                        } else {
                           class84.intStack[++class84.intStackSize - 1] = (int)Math.pow((double)var4, 1.0D / (double)var32);
                        }

                        var3 = 1;
                     } else if(var0 == 4014) {
                        class84.intStackSize -= 2;
                        var4 = class84.intStack[class84.intStackSize];
                        var32 = class84.intStack[class84.intStackSize + 1];
                        class84.intStack[++class84.intStackSize - 1] = var4 & var32;
                        var3 = 1;
                     } else if(var0 == 4015) {
                        class84.intStackSize -= 2;
                        var4 = class84.intStack[class84.intStackSize];
                        var32 = class84.intStack[class84.intStackSize + 1];
                        class84.intStack[++class84.intStackSize - 1] = var4 | var32;
                        var3 = 1;
                     } else if(var0 == 4018) {
                        class84.intStackSize -= 3;
                        long var24 = (long)class84.intStack[class84.intStackSize];
                        long var26 = (long)class84.intStack[class84.intStackSize + 1];
                        long var28 = (long)class84.intStack[class84.intStackSize + 2];
                        class84.intStack[++class84.intStackSize - 1] = (int)(var24 * var28 / var26);
                        var3 = 1;
                     } else {
                        var3 = 2;
                     }

                     return var3;
                  } else {
                     boolean var18;
                     if(var0 < 4200) {
                        if(var0 == 4100) {
                           var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                           var32 = class84.intStack[--class84.intStackSize];
                           class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var46 + var32;
                           var3 = 1;
                        } else if(var0 == 4101) {
                           class91.scriptStringStackSize -= 2;
                           var46 = class84.scriptStringStack[class91.scriptStringStackSize];
                           var51 = class84.scriptStringStack[class91.scriptStringStackSize + 1];
                           class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var46 + var51;
                           var3 = 1;
                        } else if(var0 == 4102) {
                           var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                           var32 = class84.intStack[--class84.intStackSize];
                           String[] var54 = class84.scriptStringStack;
                           var49 = ++class91.scriptStringStackSize - 1;
                           if(var32 < 0) {
                              var20 = Integer.toString(var32);
                           } else {
                              var20 = method4300(var32, 10, true);
                           }

                           var54[var49] = var46 + var20;
                           var3 = 1;
                        } else if(var0 == 4103) {
                           var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                           class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var46.toLowerCase();
                           var3 = 1;
                        } else if(var0 == 4104) {
                           var4 = class84.intStack[--class84.intStackSize];
                           long var22 = ((long)var4 + 11745L) * 86400000L;
                           class84.field1351.setTime(new Date(var22));
                           var49 = class84.field1351.get(5);
                           var17 = class84.field1351.get(2);
                           var9 = class84.field1351.get(1);
                           class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var49 + "-" + class84.field1348[var17] + "-" + var9;
                           var3 = 1;
                        } else if(var0 == 4105) {
                           class91.scriptStringStackSize -= 2;
                           var46 = class84.scriptStringStack[class91.scriptStringStackSize];
                           var51 = class84.scriptStringStack[class91.scriptStringStackSize + 1];
                           if(XGrandExchangeOffer.localPlayer.composition != null && XGrandExchangeOffer.localPlayer.composition.isFemale) {
                              class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var51;
                           } else {
                              class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var46;
                           }

                           var3 = 1;
                        } else if(var0 == 4106) {
                           var4 = class84.intStack[--class84.intStackSize];
                           class84.scriptStringStack[++class91.scriptStringStackSize - 1] = Integer.toString(var4);
                           var3 = 1;
                        } else if(var0 == 4107) {
                           class91.scriptStringStackSize -= 2;
                           int[] var48 = class84.intStack;
                           var32 = ++class84.intStackSize - 1;
                           var49 = class84.method1669(class84.scriptStringStack[class91.scriptStringStackSize], class84.scriptStringStack[class91.scriptStringStackSize + 1], Client.languageId);
                           byte var33;
                           if(var49 > 0) {
                              var33 = 1;
                           } else if(var49 < 0) {
                              var33 = -1;
                           } else {
                              var33 = 0;
                           }

                           var48[var32] = var33;
                           var3 = 1;
                        } else {
                           byte[] var7;
                           Font var8;
                           if(var0 == 4108) {
                              var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                              class84.intStackSize -= 2;
                              var32 = class84.intStack[class84.intStackSize];
                              var6 = class84.intStack[class84.intStackSize + 1];
                              var7 = class262.field3617.getConfigData(var6, 0);
                              var8 = new Font(var7);
                              class84.intStack[++class84.intStackSize - 1] = var8.method4778(var46, var32);
                              var3 = 1;
                           } else if(var0 == 4109) {
                              var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                              class84.intStackSize -= 2;
                              var32 = class84.intStack[class84.intStackSize];
                              var6 = class84.intStack[class84.intStackSize + 1];
                              var7 = class262.field3617.getConfigData(var6, 0);
                              var8 = new Font(var7);
                              class84.intStack[++class84.intStackSize - 1] = var8.method4777(var46, var32);
                              var3 = 1;
                           } else if(var0 == 4110) {
                              class91.scriptStringStackSize -= 2;
                              var46 = class84.scriptStringStack[class91.scriptStringStackSize];
                              var51 = class84.scriptStringStack[class91.scriptStringStackSize + 1];
                              if(class84.intStack[--class84.intStackSize] == 1) {
                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var46;
                              } else {
                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var51;
                              }

                              var3 = 1;
                           } else if(var0 == 4111) {
                              var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                              class84.scriptStringStack[++class91.scriptStringStackSize - 1] = FontTypeFace.appendTags(var46);
                              var3 = 1;
                           } else if(var0 == 4112) {
                              var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                              var32 = class84.intStack[--class84.intStackSize];
                              class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var46 + (char)var32;
                              var3 = 1;
                           } else if(var0 == 4113) {
                              var4 = class84.intStack[--class84.intStackSize];
                              class84.intStack[++class84.intStackSize - 1] = class35.method507((char)var4)?1:0;
                              var3 = 1;
                           } else if(var0 == 4114) {
                              var4 = class84.intStack[--class84.intStackSize];
                              class84.intStack[++class84.intStackSize - 1] = DecorativeObject.method2923((char)var4)?1:0;
                              var3 = 1;
                           } else {
                              char var47;
                              if(var0 == 4115) {
                                 var4 = class84.intStack[--class84.intStackSize];
                                 var53 = class84.intStack;
                                 var6 = ++class84.intStackSize - 1;
                                 var47 = (char)var4;
                                 var18 = var47 >= 65 && var47 <= 90 || var47 >= 97 && var47 <= 122;
                                 var53[var6] = var18?1:0;
                                 var3 = 1;
                              } else if(var0 == 4116) {
                                 var4 = class84.intStack[--class84.intStackSize];
                                 var53 = class84.intStack;
                                 var6 = ++class84.intStackSize - 1;
                                 var47 = (char)var4;
                                 var18 = var47 >= 48 && var47 <= 57;
                                 var53[var6] = var18?1:0;
                                 var3 = 1;
                              } else if(var0 == 4117) {
                                 var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                                 if(var46 != null) {
                                    class84.intStack[++class84.intStackSize - 1] = var46.length();
                                 } else {
                                    class84.intStack[++class84.intStackSize - 1] = 0;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4118) {
                                 var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                                 class84.intStackSize -= 2;
                                 var32 = class84.intStack[class84.intStackSize];
                                 var6 = class84.intStack[class84.intStackSize + 1];
                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var46.substring(var32, var6);
                                 var3 = 1;
                              } else if(var0 == 4119) {
                                 var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                                 StringBuilder var56 = new StringBuilder(var46.length());
                                 boolean var38 = false;

                                 for(var49 = 0; var49 < var46.length(); ++var49) {
                                    var47 = var46.charAt(var49);
                                    if(var47 == 60) {
                                       var38 = true;
                                    } else if(var47 == 62) {
                                       var38 = false;
                                    } else if(!var38) {
                                       var56.append(var47);
                                    }
                                 }

                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var56.toString();
                                 var3 = 1;
                              } else if(var0 == 4120) {
                                 var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                                 var32 = class84.intStack[--class84.intStackSize];
                                 class84.intStack[++class84.intStackSize - 1] = var46.indexOf(var32);
                                 var3 = 1;
                              } else if(var0 == 4121) {
                                 class91.scriptStringStackSize -= 2;
                                 var46 = class84.scriptStringStack[class91.scriptStringStackSize];
                                 var51 = class84.scriptStringStack[class91.scriptStringStackSize + 1];
                                 var6 = class84.intStack[--class84.intStackSize];
                                 class84.intStack[++class84.intStackSize - 1] = var46.indexOf(var51, var6);
                                 var3 = 1;
                              } else {
                                 var3 = 2;
                              }
                           }
                        }

                        return var3;
                     } else if(var0 < 4300) {
                        if(var0 == 4200) {
                           var4 = class84.intStack[--class84.intStackSize];
                           class84.scriptStringStack[++class91.scriptStringStackSize - 1] = SoundTask.getItemDefinition(var4).name;
                           var3 = 1;
                        } else {
                           ItemComposition var52;
                           if(var0 == 4201) {
                              class84.intStackSize -= 2;
                              var4 = class84.intStack[class84.intStackSize];
                              var32 = class84.intStack[class84.intStackSize + 1];
                              var52 = SoundTask.getItemDefinition(var4);
                              if(var32 >= 1 && var32 <= 5 && var52.groundActions[var32 - 1] != null) {
                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var52.groundActions[var32 - 1];
                              } else {
                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else if(var0 == 4202) {
                              class84.intStackSize -= 2;
                              var4 = class84.intStack[class84.intStackSize];
                              var32 = class84.intStack[class84.intStackSize + 1];
                              var52 = SoundTask.getItemDefinition(var4);
                              if(var32 >= 1 && var32 <= 5 && var52.inventoryActions[var32 - 1] != null) {
                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var52.inventoryActions[var32 - 1];
                              } else {
                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else if(var0 == 4203) {
                              var4 = class84.intStack[--class84.intStackSize];
                              class84.intStack[++class84.intStackSize - 1] = SoundTask.getItemDefinition(var4).price;
                              var3 = 1;
                           } else if(var0 == 4204) {
                              var4 = class84.intStack[--class84.intStackSize];
                              class84.intStack[++class84.intStackSize - 1] = SoundTask.getItemDefinition(var4).isStackable == 1?1:0;
                              var3 = 1;
                           } else {
                              ItemComposition var50;
                              if(var0 == 4205) {
                                 var4 = class84.intStack[--class84.intStackSize];
                                 var50 = SoundTask.getItemDefinition(var4);
                                 if(var50.notedTemplate == -1 && var50.note >= 0) {
                                    class84.intStack[++class84.intStackSize - 1] = var50.note;
                                 } else {
                                    class84.intStack[++class84.intStackSize - 1] = var4;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4206) {
                                 var4 = class84.intStack[--class84.intStackSize];
                                 var50 = SoundTask.getItemDefinition(var4);
                                 if(var50.notedTemplate >= 0 && var50.note >= 0) {
                                    class84.intStack[++class84.intStackSize - 1] = var50.note;
                                 } else {
                                    class84.intStack[++class84.intStackSize - 1] = var4;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4207) {
                                 var4 = class84.intStack[--class84.intStackSize];
                                 class84.intStack[++class84.intStackSize - 1] = SoundTask.getItemDefinition(var4).isMembers?1:0;
                                 var3 = 1;
                              } else if(var0 == 4208) {
                                 var4 = class84.intStack[--class84.intStackSize];
                                 var50 = SoundTask.getItemDefinition(var4);
                                 if(var50.field3530 == -1 && var50.field3529 >= 0) {
                                    class84.intStack[++class84.intStackSize - 1] = var50.field3529;
                                 } else {
                                    class84.intStack[++class84.intStackSize - 1] = var4;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4209) {
                                 var4 = class84.intStack[--class84.intStackSize];
                                 var50 = SoundTask.getItemDefinition(var4);
                                 if(var50.field3530 >= 0 && var50.field3529 >= 0) {
                                    class84.intStack[++class84.intStackSize - 1] = var50.field3529;
                                 } else {
                                    class84.intStack[++class84.intStackSize - 1] = var4;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4210) {
                                 var46 = class84.scriptStringStack[--class91.scriptStringStackSize];
                                 var32 = class84.intStack[--class84.intStackSize];
                                 class39.method564(var46, var32 == 1);
                                 class84.intStack[++class84.intStackSize - 1] = class22.field349;
                                 var3 = 1;
                              } else if(var0 == 4211) {
                                 if(class212.field2607 != null && class169.field2340 < class22.field349) {
                                    class84.intStack[++class84.intStackSize - 1] = class212.field2607[++class169.field2340 - 1] & '\uffff';
                                 } else {
                                    class84.intStack[++class84.intStackSize - 1] = -1;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4212) {
                                 class169.field2340 = 0;
                                 var3 = 1;
                              } else {
                                 var3 = 2;
                              }
                           }
                        }

                        return var3;
                     } else if(var0 < 5100) {
                        return CombatInfo1.method1549(var0, var1, var2);
                     } else if(var0 < 5400) {
                        return class11.method52(var0, var1, var2);
                     } else if(var0 < 5600) {
                        if(var0 == 5504) {
                           class84.intStackSize -= 2;
                           var49 = class84.intStack[class84.intStackSize];
                           var17 = class84.intStack[class84.intStackSize + 1];
                           if(!Client.field1172) {
                              Client.field1068 = var49;
                              Client.mapAngle = var17;
                           }

                           var3 = 1;
                        } else if(var0 == 5505) {
                           class84.intStack[++class84.intStackSize - 1] = Client.field1068;
                           var3 = 1;
                        } else if(var0 == 5506) {
                           class84.intStack[++class84.intStackSize - 1] = Client.mapAngle;
                           var3 = 1;
                        } else if(var0 == 5530) {
                           var49 = class84.intStack[--class84.intStackSize];
                           if(var49 < 0) {
                              var49 = 0;
                           }

                           Client.field1199 = var49;
                           var3 = 1;
                        } else if(var0 == 5531) {
                           class84.intStack[++class84.intStackSize - 1] = Client.field1199;
                           var3 = 1;
                        } else {
                           var3 = 2;
                        }

                        return var3;
                     } else if(var0 < 5700) {
                        return class176.method3390(var0, var1, var2);
                     } else if(var0 < 6300) {
                        if(var0 == 6200) {
                           class84.intStackSize -= 2;
                           Client.field1178 = (short)class84.intStack[class84.intStackSize];
                           if(Client.field1178 <= 0) {
                              Client.field1178 = 256;
                           }

                           Client.field1152 = (short)class84.intStack[class84.intStackSize + 1];
                           if(Client.field1152 <= 0) {
                              Client.field1152 = 205;
                           }

                           var3 = 1;
                        } else if(var0 == 6201) {
                           class84.intStackSize -= 2;
                           Client.field1180 = (short)class84.intStack[class84.intStackSize];
                           if(Client.field1180 <= 0) {
                              Client.field1180 = 256;
                           }

                           Client.field1200 = (short)class84.intStack[class84.intStackSize + 1];
                           if(Client.field1200 <= 0) {
                              Client.field1200 = 320;
                           }

                           var3 = 1;
                        } else if(var0 == 6202) {
                           class84.intStackSize -= 4;
                           Client.field1126 = (short)class84.intStack[class84.intStackSize];
                           if(Client.field1126 <= 0) {
                              Client.field1126 = 1;
                           }

                           Client.field1183 = (short)class84.intStack[class84.intStackSize + 1];
                           if(Client.field1183 <= 0) {
                              Client.field1183 = 32767;
                           } else if(Client.field1183 < Client.field1126) {
                              Client.field1183 = Client.field1126;
                           }

                           Client.field1184 = (short)class84.intStack[class84.intStackSize + 2];
                           if(Client.field1184 <= 0) {
                              Client.field1184 = 1;
                           }

                           Client.field1086 = (short)class84.intStack[class84.intStackSize + 3];
                           if(Client.field1086 <= 0) {
                              Client.field1086 = 32767;
                           } else if(Client.field1086 < Client.field1184) {
                              Client.field1086 = Client.field1184;
                           }

                           var3 = 1;
                        } else if(var0 == 6203) {
                           if(Client.field1098 != null) {
                              class67.method1146(0, 0, Client.field1098.width, Client.field1098.height, false);
                              class84.intStack[++class84.intStackSize - 1] = Client.viewportHeight;
                              class84.intStack[++class84.intStackSize - 1] = Client.viewportWidth;
                           } else {
                              class84.intStack[++class84.intStackSize - 1] = -1;
                              class84.intStack[++class84.intStackSize - 1] = -1;
                           }

                           var3 = 1;
                        } else if(var0 == 6204) {
                           class84.intStack[++class84.intStackSize - 1] = Client.field1180;
                           class84.intStack[++class84.intStackSize - 1] = Client.field1200;
                           var3 = 1;
                        } else if(var0 == 6205) {
                           class84.intStack[++class84.intStackSize - 1] = Client.field1178;
                           class84.intStack[++class84.intStackSize - 1] = Client.field1152;
                           var3 = 1;
                        } else {
                           var3 = 2;
                        }

                        return var3;
                     } else if(var0 >= 6600) {
                        return var0 < 6700?class218.method4066(var0, var1, var2):2;
                     } else {
                        if(var0 == 6500) {
                           class84.intStack[++class84.intStackSize - 1] = Ignore.loadWorlds()?1:0;
                           var3 = 1;
                        } else {
                           World var16;
                           if(var0 == 6501) {
                              World.field1291 = 0;
                              if(World.field1291 < World.worldCount) {
                                 var16 = World.worldList[++World.field1291 - 1];
                              } else {
                                 var16 = null;
                              }

                              if(var16 != null) {
                                 class84.intStack[++class84.intStackSize - 1] = var16.id;
                                 class84.intStack[++class84.intStackSize - 1] = var16.mask;
                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var16.activity;
                                 class84.intStack[++class84.intStackSize - 1] = var16.location;
                                 class84.intStack[++class84.intStackSize - 1] = var16.playerCount;
                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var16.address;
                              } else {
                                 class84.intStack[++class84.intStackSize - 1] = -1;
                                 class84.intStack[++class84.intStackSize - 1] = 0;
                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
                                 class84.intStack[++class84.intStackSize - 1] = 0;
                                 class84.intStack[++class84.intStackSize - 1] = 0;
                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else if(var0 == 6502) {
                              World var15;
                              if(World.field1291 < World.worldCount) {
                                 var15 = World.worldList[++World.field1291 - 1];
                              } else {
                                 var15 = null;
                              }

                              if(var15 != null) {
                                 class84.intStack[++class84.intStackSize - 1] = var15.id;
                                 class84.intStack[++class84.intStackSize - 1] = var15.mask;
                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var15.activity;
                                 class84.intStack[++class84.intStackSize - 1] = var15.location;
                                 class84.intStack[++class84.intStackSize - 1] = var15.playerCount;
                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var15.address;
                              } else {
                                 class84.intStack[++class84.intStackSize - 1] = -1;
                                 class84.intStack[++class84.intStackSize - 1] = 0;
                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
                                 class84.intStack[++class84.intStackSize - 1] = 0;
                                 class84.intStack[++class84.intStackSize - 1] = 0;
                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else if(var0 == 6506) {
                              var4 = class84.intStack[--class84.intStackSize];
                              var16 = null;

                              for(var6 = 0; var6 < World.worldCount; ++var6) {
                                 if(var4 == World.worldList[var6].id) {
                                    var16 = World.worldList[var6];
                                    break;
                                 }
                              }

                              if(var16 != null) {
                                 class84.intStack[++class84.intStackSize - 1] = var16.id;
                                 class84.intStack[++class84.intStackSize - 1] = var16.mask;
                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var16.activity;
                                 class84.intStack[++class84.intStackSize - 1] = var16.location;
                                 class84.intStack[++class84.intStackSize - 1] = var16.playerCount;
                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var16.address;
                              } else {
                                 class84.intStack[++class84.intStackSize - 1] = -1;
                                 class84.intStack[++class84.intStackSize - 1] = 0;
                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
                                 class84.intStack[++class84.intStackSize - 1] = 0;
                                 class84.intStack[++class84.intStackSize - 1] = 0;
                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else if(var0 == 6507) {
                              class84.intStackSize -= 4;
                              var4 = class84.intStack[class84.intStackSize];
                              var5 = class84.intStack[class84.intStackSize + 1] == 1;
                              var6 = class84.intStack[class84.intStackSize + 2];
                              var18 = class84.intStack[class84.intStackSize + 3] == 1;
                              class31.method294(var4, var5, var6, var18);
                              var3 = 1;
                           } else if(var0 == 6511) {
                              var4 = class84.intStack[--class84.intStackSize];
                              if(var4 >= 0 && var4 < World.worldCount) {
                                 var16 = World.worldList[var4];
                                 class84.intStack[++class84.intStackSize - 1] = var16.id;
                                 class84.intStack[++class84.intStackSize - 1] = var16.mask;
                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var16.activity;
                                 class84.intStack[++class84.intStackSize - 1] = var16.location;
                                 class84.intStack[++class84.intStackSize - 1] = var16.playerCount;
                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = var16.address;
                              } else {
                                 class84.intStack[++class84.intStackSize - 1] = -1;
                                 class84.intStack[++class84.intStackSize - 1] = 0;
                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
                                 class84.intStack[++class84.intStackSize - 1] = 0;
                                 class84.intStack[++class84.intStackSize - 1] = 0;
                                 class84.scriptStringStack[++class91.scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else if(var0 == 6512) {
                              Client.field1046 = class84.intStack[--class84.intStackSize] == 1;
                              var3 = 1;
                           } else {
                              class252 var19;
                              if(var0 == 6513) {
                                 class84.intStackSize -= 2;
                                 var4 = class84.intStack[class84.intStackSize];
                                 var32 = class84.intStack[class84.intStackSize + 1];
                                 var19 = BuildType.method4100(var32);
                                 if(var19.method4458()) {
                                    class84.scriptStringStack[++class91.scriptStringStackSize - 1] = class183.getNpcDefinition(var4).method4673(var32, var19.field3374);
                                 } else {
                                    class84.intStack[++class84.intStackSize - 1] = class183.getNpcDefinition(var4).method4672(var32, var19.field3377);
                                 }

                                 var3 = 1;
                              } else if(var0 == 6514) {
                                 class84.intStackSize -= 2;
                                 var4 = class84.intStack[class84.intStackSize];
                                 var32 = class84.intStack[class84.intStackSize + 1];
                                 var19 = BuildType.method4100(var32);
                                 if(var19.method4458()) {
                                    class84.scriptStringStack[++class91.scriptStringStackSize - 1] = class37.getObjectDefinition(var4).method4567(var32, var19.field3374);
                                 } else {
                                    class84.intStack[++class84.intStackSize - 1] = class37.getObjectDefinition(var4).method4566(var32, var19.field3377);
                                 }

                                 var3 = 1;
                              } else if(var0 == 6515) {
                                 class84.intStackSize -= 2;
                                 var4 = class84.intStack[class84.intStackSize];
                                 var32 = class84.intStack[class84.intStackSize + 1];
                                 var19 = BuildType.method4100(var32);
                                 if(var19.method4458()) {
                                    class84.scriptStringStack[++class91.scriptStringStackSize - 1] = SoundTask.getItemDefinition(var4).method4657(var32, var19.field3374);
                                 } else {
                                    class84.intStack[++class84.intStackSize - 1] = SoundTask.getItemDefinition(var4).method4607(var32, var19.field3377);
                                 }

                                 var3 = 1;
                              } else if(var0 == 6516) {
                                 class84.intStackSize -= 2;
                                 var4 = class84.intStack[class84.intStackSize];
                                 var32 = class84.intStack[class84.intStackSize + 1];
                                 var19 = BuildType.method4100(var32);
                                 if(var19.method4458()) {
                                    class84.scriptStringStack[++class91.scriptStringStackSize - 1] = class47.method738(var4).method4472(var32, var19.field3374);
                                 } else {
                                    class84.intStack[++class84.intStackSize - 1] = class47.method738(var4).method4479(var32, var19.field3377);
                                 }

                                 var3 = 1;
                              } else if(var0 == 6518) {
                                 class84.intStack[++class84.intStackSize - 1] = 0;
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

                        return var3;
                     }
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIZI)Ljava/lang/String;",
      garbageValue = "-1938446747"
   )
   public static String method4300(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var0 < 0) {
            return Integer.toString(var0, var1);
         } else {
            int var3 = 2;

            for(int var4 = var0 / var1; var4 != 0; ++var3) {
               var4 /= var1;
            }

            char[] var5 = new char[var3];
            var5[0] = 43;

            for(int var6 = var3 - 1; var6 > 0; --var6) {
               int var7 = var0;
               var0 /= var1;
               int var8 = var7 - var0 * var1;
               if(var8 >= 10) {
                  var5[var6] = (char)(var8 + 87);
               } else {
                  var5[var6] = (char)(var8 + 48);
               }
            }

            return new String(var5);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
