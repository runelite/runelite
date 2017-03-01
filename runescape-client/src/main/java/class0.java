import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import java.util.Comparator;
import java.util.Date;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
final class class0 implements Comparator {
   @ObfuscatedName("am")
   static class184 field0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -515239105
   )
   public static int field2;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "-348268599"
   )
   int method1(class2 var1, class2 var2) {
      return var1.field16 < var2.field16?-1:(var1.field16 == var2.field16?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method1((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1814154154"
   )
   static int method8(int var0, Script var1, boolean var2) {
      byte var3;
      int var4;
      int var5;
      int var6;
      int var9;
      Widget var37;
      Widget var61;
      Widget var71;
      if(var0 < 1000) {
         if(var0 == 100) {
            class32.field735 -= 3;
            var4 = class32.field726[class32.field735];
            var5 = class32.field726[1 + class32.field735];
            var6 = class32.field726[2 + class32.field735];
            if(var5 == 0) {
               throw new RuntimeException();
            }

            var37 = ChatLineBuffer.method993(var4);
            if(var37.children == null) {
               var37.children = new Widget[1 + var6];
            }

            if(var37.children.length <= var6) {
               Widget[] var43 = new Widget[1 + var6];

               for(var9 = 0; var9 < var37.children.length; ++var9) {
                  var43[var9] = var37.children[var9];
               }

               var37.children = var43;
            }

            if(var6 > 0 && null == var37.children[var6 - 1]) {
               throw new RuntimeException("" + (var6 - 1));
            }

            Widget var44 = new Widget();
            var44.type = var5;
            var44.parentId = var44.id = var37.id;
            var44.index = var6;
            var44.hasScript = true;
            var37.children[var6] = var44;
            if(var2) {
               class32.field731 = var44;
            } else {
               class108.field1738 = var44;
            }

            ChatLineBuffer.method996(var37);
            var3 = 1;
         } else if(var0 == 101) {
            var71 = var2?class32.field731:class108.field1738;
            Widget var67 = ChatLineBuffer.method993(var71.id);
            var67.children[var71.index] = null;
            ChatLineBuffer.method996(var67);
            var3 = 1;
         } else if(var0 == 102) {
            var71 = ChatLineBuffer.method993(class32.field726[--class32.field735]);
            var71.children = null;
            ChatLineBuffer.method996(var71);
            var3 = 1;
         } else if(var0 == 200) {
            class32.field735 -= 2;
            var4 = class32.field726[class32.field735];
            var5 = class32.field726[1 + class32.field735];
            var61 = class33.method774(var4, var5);
            if(var61 != null && var5 != -1) {
               class32.field726[++class32.field735 - 1] = 1;
               if(var2) {
                  class32.field731 = var61;
               } else {
                  class108.field1738 = var61;
               }
            } else {
               class32.field726[++class32.field735 - 1] = 0;
            }

            var3 = 1;
         } else if(var0 == 201) {
            var71 = ChatLineBuffer.method993(class32.field726[--class32.field735]);
            if(var71 != null) {
               class32.field726[++class32.field735 - 1] = 1;
               if(var2) {
                  class32.field731 = var71;
               } else {
                  class108.field1738 = var71;
               }
            } else {
               class32.field726[++class32.field735 - 1] = 0;
            }

            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 1100) {
         return PlayerComposition.method3255(var0, var1, var2);
      } else if(var0 < 1200) {
         return ScriptState.method161(var0, var1, var2);
      } else if(var0 < 1300) {
         return class22.method223(var0, var1, var2);
      } else if(var0 < 1400) {
         return class152.method2868(var0, var1, var2);
      } else if(var0 < 1500) {
         return class8.method107(var0, var1, var2);
      } else if(var0 < 1600) {
         var37 = var2?class32.field731:class108.field1738;
         if(var0 == 1500) {
            class32.field726[++class32.field735 - 1] = var37.relativeX;
            var3 = 1;
         } else if(var0 == 1501) {
            class32.field726[++class32.field735 - 1] = var37.relativeY;
            var3 = 1;
         } else if(var0 == 1502) {
            class32.field726[++class32.field735 - 1] = var37.width;
            var3 = 1;
         } else if(var0 == 1503) {
            class32.field726[++class32.field735 - 1] = var37.height;
            var3 = 1;
         } else if(var0 == 1504) {
            class32.field726[++class32.field735 - 1] = var37.isHidden?1:0;
            var3 = 1;
         } else if(var0 == 1505) {
            class32.field726[++class32.field735 - 1] = var37.parentId;
            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 1700) {
         var71 = var2?class32.field731:class108.field1738;
         if(var0 == 1600) {
            class32.field726[++class32.field735 - 1] = var71.scrollX;
            var3 = 1;
         } else if(var0 == 1601) {
            class32.field726[++class32.field735 - 1] = var71.scrollY;
            var3 = 1;
         } else if(var0 == 1602) {
            class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var71.text;
            var3 = 1;
         } else if(var0 == 1603) {
            class32.field726[++class32.field735 - 1] = var71.scrollWidth;
            var3 = 1;
         } else if(var0 == 1604) {
            class32.field726[++class32.field735 - 1] = var71.scrollHeight;
            var3 = 1;
         } else if(var0 == 1605) {
            class32.field726[++class32.field735 - 1] = var71.field2260;
            var3 = 1;
         } else if(var0 == 1606) {
            class32.field726[++class32.field735 - 1] = var71.rotationX;
            var3 = 1;
         } else if(var0 == 1607) {
            class32.field726[++class32.field735 - 1] = var71.rotationY;
            var3 = 1;
         } else if(var0 == 1608) {
            class32.field726[++class32.field735 - 1] = var71.rotationZ;
            var3 = 1;
         } else if(var0 == 1609) {
            class32.field726[++class32.field735 - 1] = var71.opacity;
            var3 = 1;
         } else if(var0 == 1610) {
            class32.field726[++class32.field735 - 1] = var71.field2196;
            var3 = 1;
         } else if(var0 == 1611) {
            class32.field726[++class32.field735 - 1] = var71.textColor;
            var3 = 1;
         } else if(var0 == 1612) {
            class32.field726[++class32.field735 - 1] = var71.field2232;
            var3 = 1;
         } else if(var0 == 1613) {
            class32.field726[++class32.field735 - 1] = var71.field2236.vmethod4107();
            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 1800) {
         return Client.method608(var0, var1, var2);
      } else {
         int[] var55;
         int var65;
         int var68;
         if(var0 < 1900) {
            var71 = var2?class32.field731:class108.field1738;
            if(var0 == 1800) {
               var55 = class32.field726;
               var6 = ++class32.field735 - 1;
               var65 = MessageNode.method220(var71);
               var68 = var65 >> 11 & 63;
               var55[var6] = var68;
               var3 = 1;
            } else if(var0 == 1801) {
               var5 = class32.field726[--class32.field735];
               --var5;
               if(var71.actions != null && var5 < var71.actions.length && var71.actions[var5] != null) {
                  class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var71.actions[var5];
               } else {
                  class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
               }

               var3 = 1;
            } else if(var0 == 1802) {
               if(var71.name == null) {
                  class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
               } else {
                  class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var71.name;
               }

               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 2000) {
            return FrameMap.method1786(var0, var1, var2);
         } else if(var0 < 2100) {
            return PlayerComposition.method3255(var0, var1, var2);
         } else if(var0 < 2200) {
            return ScriptState.method161(var0, var1, var2);
         } else if(var0 < 2300) {
            return class22.method223(var0, var1, var2);
         } else if(var0 < 2400) {
            return class152.method2868(var0, var1, var2);
         } else if(var0 < 2500) {
            return class8.method107(var0, var1, var2);
         } else if(var0 < 2600) {
            return Actor.method627(var0, var1, var2);
         } else if(var0 < 2700) {
            var71 = ChatLineBuffer.method993(class32.field726[--class32.field735]);
            if(var0 == 2600) {
               class32.field726[++class32.field735 - 1] = var71.scrollX;
               var3 = 1;
            } else if(var0 == 2601) {
               class32.field726[++class32.field735 - 1] = var71.scrollY;
               var3 = 1;
            } else if(var0 == 2602) {
               class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var71.text;
               var3 = 1;
            } else if(var0 == 2603) {
               class32.field726[++class32.field735 - 1] = var71.scrollWidth;
               var3 = 1;
            } else if(var0 == 2604) {
               class32.field726[++class32.field735 - 1] = var71.scrollHeight;
               var3 = 1;
            } else if(var0 == 2605) {
               class32.field726[++class32.field735 - 1] = var71.field2260;
               var3 = 1;
            } else if(var0 == 2606) {
               class32.field726[++class32.field735 - 1] = var71.rotationX;
               var3 = 1;
            } else if(var0 == 2607) {
               class32.field726[++class32.field735 - 1] = var71.rotationY;
               var3 = 1;
            } else if(var0 == 2608) {
               class32.field726[++class32.field735 - 1] = var71.rotationZ;
               var3 = 1;
            } else if(var0 == 2609) {
               class32.field726[++class32.field735 - 1] = var71.opacity;
               var3 = 1;
            } else if(var0 == 2610) {
               class32.field726[++class32.field735 - 1] = var71.field2196;
               var3 = 1;
            } else if(var0 == 2611) {
               class32.field726[++class32.field735 - 1] = var71.textColor;
               var3 = 1;
            } else if(var0 == 2612) {
               class32.field726[++class32.field735 - 1] = var71.field2232;
               var3 = 1;
            } else if(var0 == 2613) {
               class32.field726[++class32.field735 - 1] = var71.field2236.vmethod4107();
               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 2800) {
            return class8.method104(var0, var1, var2);
         } else if(var0 < 2900) {
            return ChatLineBuffer.method982(var0, var1, var2);
         } else if(var0 < 3000) {
            return FrameMap.method1786(var0, var1, var2);
         } else {
            boolean var42;
            String var52;
            String var54;
            String var56;
            if(var0 < 3200) {
               if(var0 == 3100) {
                  var52 = class32.scriptStringStack[--class30.scriptStringStackSize];
                  class88.sendGameMessage(0, "", var52);
                  var3 = 1;
               } else if(var0 == 3101) {
                  class32.field735 -= 2;
                  class37.method816(WidgetNode.localPlayer, class32.field726[class32.field735], class32.field726[class32.field735 + 1]);
                  var3 = 1;
               } else if(var0 == 3103) {
                  Client.field332.method3144(200);

                  for(WidgetNode var70 = (WidgetNode)Client.componentTable.method2440(); var70 != null; var70 = (WidgetNode)Client.componentTable.method2441()) {
                     if(var70.field176 == 0 || var70.field176 == 3) {
                        class18.method203(var70, true);
                     }
                  }

                  if(Client.field543 != null) {
                     ChatLineBuffer.method996(Client.field543);
                     Client.field543 = null;
                  }

                  var3 = 1;
               } else if(var0 == 3104) {
                  var52 = class32.scriptStringStack[--class30.scriptStringStackSize];
                  var5 = 0;
                  var42 = class165.method3230(var52, 10, true);
                  if(var42) {
                     var5 = GameObject.method2019(var52);
                  }

                  Client.field332.method3144(164);
                  Client.field332.method2874(var5);
                  var3 = 1;
               } else if(var0 == 3105) {
                  var52 = class32.scriptStringStack[--class30.scriptStringStackSize];
                  Client.field332.method3144(158);
                  Client.field332.method2873(var52.length() + 1);
                  Client.field332.method2915(var52);
                  var3 = 1;
               } else if(var0 == 3106) {
                  var52 = class32.scriptStringStack[--class30.scriptStringStackSize];
                  Client.field332.method3144(190);
                  Client.field332.method2873(var52.length() + 1);
                  Client.field332.method2915(var52);
                  var3 = 1;
               } else if(var0 == 3107) {
                  var4 = class32.field726[--class32.field735];
                  var54 = class32.scriptStringStack[--class30.scriptStringStackSize];
                  class7.method96(var4, var54);
                  var3 = 1;
               } else if(var0 == 3108) {
                  class32.field735 -= 3;
                  var4 = class32.field726[class32.field735];
                  var5 = class32.field726[class32.field735 + 1];
                  var6 = class32.field726[class32.field735 + 2];
                  var37 = ChatLineBuffer.method993(var6);
                  class99.method2038(var37, var4, var5);
                  var3 = 1;
               } else if(var0 == 3109) {
                  class32.field735 -= 2;
                  var4 = class32.field726[class32.field735];
                  var5 = class32.field726[class32.field735 + 1];
                  var61 = var2?class32.field731:class108.field1738;
                  class99.method2038(var61, var4, var5);
                  var3 = 1;
               } else if(var0 == 3110) {
                  Client.field291 = class32.field726[--class32.field735] == 1;
                  var3 = 1;
               } else if(var0 == 3111) {
                  class32.field726[++class32.field735 - 1] = ObjectComposition.field2944.field690?1:0;
                  var3 = 1;
               } else if(var0 == 3112) {
                  ObjectComposition.field2944.field690 = class32.field726[--class32.field735] == 1;
                  class146.method2811();
                  var3 = 1;
               } else if(var0 == 3113) {
                  var52 = class32.scriptStringStack[--class30.scriptStringStackSize];
                  boolean var45 = class32.field726[--class32.field735] == 1;
                  if(!var45) {
                     class49.method976(var52, 3, "openjs");
                  } else {
                     label1786: {
                        if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                           try {
                              Desktop.getDesktop().browse(new URI(var52));
                              break label1786;
                           } catch (Exception var32) {
                              ;
                           }
                        }

                        if(class114.field1786.startsWith("win")) {
                           class49.method976(var52, 0, "openjs");
                        } else if(class114.field1786.startsWith("mac")) {
                           class49.method976(var52, 1, "openjs");
                        } else {
                           class49.method976(var52, 2, "openjs");
                        }
                     }
                  }

                  var3 = 1;
               } else if(var0 == 3115) {
                  var4 = class32.field726[--class32.field735];
                  Client.field332.method3144(93);
                  Client.field332.method2872(var4);
                  var3 = 1;
               } else if(var0 == 3116) {
                  var4 = class32.field726[--class32.field735];
                  class30.scriptStringStackSize -= 2;
                  var54 = class32.scriptStringStack[class30.scriptStringStackSize];
                  var56 = class32.scriptStringStack[1 + class30.scriptStringStackSize];
                  if(var54.length() > 500) {
                     var3 = 1;
                  } else if(var56.length() > 500) {
                     var3 = 1;
                  } else {
                     Client.field332.method3144(69);
                     Client.field332.method2872(1 + class165.method3233(var54) + class165.method3233(var56));
                     Client.field332.method2915(var54);
                     Client.field332.method2915(var56);
                     Client.field332.method2911(var4);
                     var3 = 1;
                  }
               } else if(var0 == 3117) {
                  Client.field437 = class32.field726[--class32.field735] == 1;
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 3300) {
               return class47.method960(var0, var1, var2);
            } else {
               int var10;
               int var11;
               byte[] var27;
               if(var0 < 3400) {
                  if(var0 == 3300) {
                     class32.field726[++class32.field735 - 1] = Client.gameCycle;
                     var3 = 1;
                  } else if(var0 == 3301) {
                     class32.field735 -= 2;
                     var4 = class32.field726[class32.field735];
                     var5 = class32.field726[class32.field735 + 1];
                     class32.field726[++class32.field735 - 1] = WallObject.method1984(var4, var5);
                     var3 = 1;
                  } else if(var0 == 3302) {
                     class32.field735 -= 2;
                     var4 = class32.field726[class32.field735];
                     var5 = class32.field726[class32.field735 + 1];
                     class32.field726[++class32.field735 - 1] = class115.method2329(var4, var5);
                     var3 = 1;
                  } else {
                     int[] var60;
                     XItemContainer var63;
                     if(var0 == 3303) {
                        class32.field735 -= 2;
                        var4 = class32.field726[class32.field735];
                        var5 = class32.field726[class32.field735 + 1];
                        var60 = class32.field726;
                        var68 = ++class32.field735 - 1;
                        var63 = (XItemContainer)XItemContainer.itemContainers.method2437((long)var4);
                        if(var63 == null) {
                           var65 = 0;
                        } else if(var5 == -1) {
                           var65 = 0;
                        } else {
                           var10 = 0;

                           for(var11 = 0; var11 < var63.stackSizes.length; ++var11) {
                              if(var5 == var63.itemIds[var11]) {
                                 var10 += var63.stackSizes[var11];
                              }
                           }

                           var65 = var10;
                        }

                        var60[var68] = var65;
                        var3 = 1;
                     } else if(var0 == 3304) {
                        var4 = class32.field726[--class32.field735];
                        var55 = class32.field726;
                        var6 = ++class32.field735 - 1;
                        class186 var41 = (class186)class186.field2772.get((long)var4);
                        class186 var34;
                        if(var41 != null) {
                           var34 = var41;
                        } else {
                           var27 = class186.field2770.getConfigData(5, var4);
                           var41 = new class186();
                           if(var27 != null) {
                              var41.method3493(new Buffer(var27));
                           }

                           class186.field2772.put(var41, (long)var4);
                           var34 = var41;
                        }

                        var55[var6] = var34.field2776;
                        var3 = 1;
                     } else if(var0 == 3305) {
                        var4 = class32.field726[--class32.field735];
                        class32.field726[++class32.field735 - 1] = Client.boostedSkillLevels[var4];
                        var3 = 1;
                     } else if(var0 == 3306) {
                        var4 = class32.field726[--class32.field735];
                        class32.field726[++class32.field735 - 1] = Client.realSkillLevels[var4];
                        var3 = 1;
                     } else if(var0 == 3307) {
                        var4 = class32.field726[--class32.field735];
                        class32.field726[++class32.field735 - 1] = Client.skillExperiences[var4];
                        var3 = 1;
                     } else if(var0 == 3308) {
                        var4 = CollisionData.plane;
                        var5 = Player.baseX + (WidgetNode.localPlayer.x >> 7);
                        var6 = SecondaryBufferProvider.baseY + (WidgetNode.localPlayer.y >> 7);
                        class32.field726[++class32.field735 - 1] = var6 + (var5 << 14) + (var4 << 28);
                        var3 = 1;
                     } else if(var0 == 3309) {
                        var4 = class32.field726[--class32.field735];
                        class32.field726[++class32.field735 - 1] = var4 >> 14 & 16383;
                        var3 = 1;
                     } else if(var0 == 3310) {
                        var4 = class32.field726[--class32.field735];
                        class32.field726[++class32.field735 - 1] = var4 >> 28;
                        var3 = 1;
                     } else if(var0 == 3311) {
                        var4 = class32.field726[--class32.field735];
                        class32.field726[++class32.field735 - 1] = var4 & 16383;
                        var3 = 1;
                     } else if(var0 == 3312) {
                        class32.field726[++class32.field735 - 1] = Client.isMembers?1:0;
                        var3 = 1;
                     } else if(var0 == 3313) {
                        class32.field735 -= 2;
                        var4 = class32.field726[class32.field735] + '耀';
                        var5 = class32.field726[class32.field735 + 1];
                        class32.field726[++class32.field735 - 1] = WallObject.method1984(var4, var5);
                        var3 = 1;
                     } else if(var0 == 3314) {
                        class32.field735 -= 2;
                        var4 = '耀' + class32.field726[class32.field735];
                        var5 = class32.field726[1 + class32.field735];
                        class32.field726[++class32.field735 - 1] = class115.method2329(var4, var5);
                        var3 = 1;
                     } else if(var0 == 3315) {
                        class32.field735 -= 2;
                        var4 = class32.field726[class32.field735] + '耀';
                        var5 = class32.field726[1 + class32.field735];
                        var60 = class32.field726;
                        var68 = ++class32.field735 - 1;
                        var63 = (XItemContainer)XItemContainer.itemContainers.method2437((long)var4);
                        if(var63 == null) {
                           var65 = 0;
                        } else if(var5 == -1) {
                           var65 = 0;
                        } else {
                           var10 = 0;

                           for(var11 = 0; var11 < var63.stackSizes.length; ++var11) {
                              if(var63.itemIds[var11] == var5) {
                                 var10 += var63.stackSizes[var11];
                              }
                           }

                           var65 = var10;
                        }

                        var60[var68] = var65;
                        var3 = 1;
                     } else if(var0 == 3316) {
                        if(Client.field425 >= 2) {
                           class32.field726[++class32.field735 - 1] = Client.field425;
                        } else {
                           class32.field726[++class32.field735 - 1] = 0;
                        }

                        var3 = 1;
                     } else if(var0 == 3317) {
                        class32.field726[++class32.field735 - 1] = Client.field498;
                        var3 = 1;
                     } else if(var0 == 3318) {
                        class32.field726[++class32.field735 - 1] = Client.world;
                        var3 = 1;
                     } else if(var0 == 3321) {
                        class32.field726[++class32.field735 - 1] = Client.energy;
                        var3 = 1;
                     } else if(var0 == 3322) {
                        class32.field726[++class32.field735 - 1] = Client.weight;
                        var3 = 1;
                     } else if(var0 == 3323) {
                        if(Client.field458) {
                           class32.field726[++class32.field735 - 1] = 1;
                        } else {
                           class32.field726[++class32.field735 - 1] = 0;
                        }

                        var3 = 1;
                     } else if(var0 == 3324) {
                        class32.field726[++class32.field735 - 1] = Client.flags;
                        var3 = 1;
                     } else {
                        var3 = 2;
                     }
                  }

                  return var3;
               } else if(var0 < 3500) {
                  if(var0 == 3400) {
                     class32.field735 -= 2;
                     var4 = class32.field726[class32.field735];
                     var5 = class32.field726[class32.field735 + 1];
                     class195 var59 = class142.method2763(var4);
                     if(var59.field2862 != 115) {
                        ;
                     }

                     for(var68 = 0; var68 < var59.field2865; ++var68) {
                        if(var5 == var59.field2866[var68]) {
                           class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var59.field2859[var68];
                           var59 = null;
                           break;
                        }
                     }

                     if(null != var59) {
                        class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var59.field2863;
                     }

                     var3 = 1;
                  } else if(var0 == 3408) {
                     class32.field735 -= 4;
                     var4 = class32.field726[class32.field735];
                     var5 = class32.field726[class32.field735 + 1];
                     var6 = class32.field726[2 + class32.field735];
                     var68 = class32.field726[3 + class32.field735];
                     class195 var40 = class142.method2763(var6);
                     if(var40.field2861 == var4 && var5 == var40.field2862) {
                        for(var9 = 0; var9 < var40.field2865; ++var9) {
                           if(var40.field2866[var9] == var68) {
                              if(var5 == 115) {
                                 class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var40.field2859[var9];
                              } else {
                                 class32.field726[++class32.field735 - 1] = var40.field2864[var9];
                              }

                              var40 = null;
                              break;
                           }
                        }

                        if(var40 != null) {
                           if(var5 == 115) {
                              class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var40.field2863;
                           } else {
                              class32.field726[++class32.field735 - 1] = var40.field2868;
                           }
                        }

                        var3 = 1;
                     } else {
                        if(var5 == 115) {
                           class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "null";
                        } else {
                           class32.field726[++class32.field735 - 1] = 0;
                        }

                        var3 = 1;
                     }
                  } else {
                     var3 = 2;
                  }

                  return var3;
               } else if(var0 < 3700) {
                  return GameEngine.method2239(var0, var1, var2);
               } else if(var0 < 4000) {
                  return Ignore.method206(var0, var1, var2);
               } else if(var0 < 4100) {
                  return VertexNormal.method1722(var0, var1, var2);
               } else {
                  int[] var22;
                  if(var0 < 4200) {
                     if(var0 == 4100) {
                        var52 = class32.scriptStringStack[--class30.scriptStringStackSize];
                        var5 = class32.field726[--class32.field735];
                        class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var52 + var5;
                        var3 = 1;
                     } else if(var0 == 4101) {
                        class30.scriptStringStackSize -= 2;
                        var52 = class32.scriptStringStack[class30.scriptStringStackSize];
                        var54 = class32.scriptStringStack[1 + class30.scriptStringStackSize];
                        class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var52 + var54;
                        var3 = 1;
                     } else if(var0 == 4102) {
                        var52 = class32.scriptStringStack[--class30.scriptStringStackSize];
                        var5 = class32.field726[--class32.field735];
                        class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var52 + class157.method3138(var5, true);
                        var3 = 1;
                     } else if(var0 == 4103) {
                        var52 = class32.scriptStringStack[--class30.scriptStringStackSize];
                        class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var52.toLowerCase();
                        var3 = 1;
                     } else if(var0 == 4104) {
                        var4 = class32.field726[--class32.field735];
                        long var28 = 86400000L * ((long)var4 + 11745L);
                        class32.field732.setTime(new Date(var28));
                        var68 = class32.field732.get(5);
                        var65 = class32.field732.get(2);
                        var9 = class32.field732.get(1);
                        class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var68 + "-" + class32.field733[var65] + "-" + var9;
                        var3 = 1;
                     } else if(var0 == 4105) {
                        class30.scriptStringStackSize -= 2;
                        var52 = class32.scriptStringStack[class30.scriptStringStackSize];
                        var54 = class32.scriptStringStack[class30.scriptStringStackSize + 1];
                        if(null != WidgetNode.localPlayer.composition && WidgetNode.localPlayer.composition.isFemale) {
                           class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var54;
                        } else {
                           class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var52;
                        }

                        var3 = 1;
                     } else if(var0 == 4106) {
                        var4 = class32.field726[--class32.field735];
                        class32.scriptStringStack[++class30.scriptStringStackSize - 1] = Integer.toString(var4);
                        var3 = 1;
                     } else if(var0 == 4107) {
                        class30.scriptStringStackSize -= 2;
                        var22 = class32.field726;
                        var5 = ++class32.field735 - 1;
                        String var38 = class32.scriptStringStack[class30.scriptStringStackSize];
                        String var62 = class32.scriptStringStack[class30.scriptStringStackSize + 1];
                        var10 = Client.field428;
                        var11 = var38.length();
                        int var12 = var62.length();
                        int var13 = 0;
                        int var14 = 0;
                        byte var15 = 0;
                        byte var16 = 0;

                        label1518:
                        while(true) {
                           if(var13 - var15 >= var11 && var14 - var16 >= var12) {
                              int var48 = Math.min(var11, var12);

                              int var49;
                              char var53;
                              for(var49 = 0; var49 < var48; ++var49) {
                                 char var50 = var38.charAt(var49);
                                 var53 = var62.charAt(var49);
                                 if(var50 != var53 && Character.toUpperCase(var50) != Character.toUpperCase(var53)) {
                                    var50 = Character.toLowerCase(var50);
                                    var53 = Character.toLowerCase(var53);
                                    if(var50 != var53) {
                                       var68 = KitDefinition.method3565(var50, var10) - KitDefinition.method3565(var53, var10);
                                       break label1518;
                                    }
                                 }
                              }

                              var49 = var11 - var12;
                              if(var49 != 0) {
                                 var68 = var49;
                                 break;
                              }

                              for(int var51 = 0; var51 < var48; ++var51) {
                                 var53 = var38.charAt(var51);
                                 char var21 = var62.charAt(var51);
                                 if(var21 != var53) {
                                    var68 = KitDefinition.method3565(var53, var10) - KitDefinition.method3565(var21, var10);
                                    break label1518;
                                 }
                              }

                              var68 = 0;
                              break;
                           }

                           if(var13 - var15 >= var11) {
                              var68 = -1;
                              break;
                           }

                           if(var14 - var16 >= var12) {
                              var68 = 1;
                              break;
                           }

                           char var17;
                           if(var15 != 0) {
                              var17 = (char)var15;
                              boolean var46 = false;
                           } else {
                              var17 = var38.charAt(var13++);
                           }

                           char var18;
                           if(var16 != 0) {
                              var18 = (char)var16;
                              boolean var47 = false;
                           } else {
                              var18 = var62.charAt(var14++);
                           }

                           byte var19;
                           if(var17 == 198) {
                              var19 = 69;
                           } else if(var17 == 230) {
                              var19 = 101;
                           } else if(var17 == 223) {
                              var19 = 115;
                           } else if(var17 == 338) {
                              var19 = 69;
                           } else if(var17 == 339) {
                              var19 = 101;
                           } else {
                              var19 = 0;
                           }

                           var15 = var19;
                           byte var20;
                           if(var18 == 198) {
                              var20 = 69;
                           } else if(var18 == 230) {
                              var20 = 101;
                           } else if(var18 == 223) {
                              var20 = 115;
                           } else if(var18 == 338) {
                              var20 = 69;
                           } else if(var18 == 339) {
                              var20 = 101;
                           } else {
                              var20 = 0;
                           }

                           var16 = var20;
                           var17 = class150.method2855(var17, var10);
                           var18 = class150.method2855(var18, var10);
                           if(var18 != var17 && Character.toUpperCase(var17) != Character.toUpperCase(var18)) {
                              var17 = Character.toLowerCase(var17);
                              var18 = Character.toLowerCase(var18);
                              if(var17 != var18) {
                                 var68 = KitDefinition.method3565(var17, var10) - KitDefinition.method3565(var18, var10);
                                 break;
                              }
                           }
                        }

                        byte var35;
                        if(var68 > 0) {
                           var35 = 1;
                        } else if(var68 < 0) {
                           var35 = -1;
                        } else {
                           var35 = 0;
                        }

                        var22[var5] = var35;
                        var3 = 1;
                     } else {
                        byte[] var33;
                        Font var39;
                        if(var0 == 4108) {
                           var52 = class32.scriptStringStack[--class30.scriptStringStackSize];
                           class32.field735 -= 2;
                           var5 = class32.field726[class32.field735];
                           var6 = class32.field726[class32.field735 + 1];
                           var33 = GroundObject.field1308.getConfigData(var6, 0);
                           var39 = new Font(var33);
                           class32.field726[++class32.field735 - 1] = var39.method3907(var52, var5);
                           var3 = 1;
                        } else if(var0 == 4109) {
                           var52 = class32.scriptStringStack[--class30.scriptStringStackSize];
                           class32.field735 -= 2;
                           var5 = class32.field726[class32.field735];
                           var6 = class32.field726[1 + class32.field735];
                           var33 = GroundObject.field1308.getConfigData(var6, 0);
                           var39 = new Font(var33);
                           class32.field726[++class32.field735 - 1] = var39.method3938(var52, var5);
                           var3 = 1;
                        } else if(var0 == 4110) {
                           class30.scriptStringStackSize -= 2;
                           var52 = class32.scriptStringStack[class30.scriptStringStackSize];
                           var54 = class32.scriptStringStack[1 + class30.scriptStringStackSize];
                           if(class32.field726[--class32.field735] == 1) {
                              class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var52;
                           } else {
                              class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var54;
                           }

                           var3 = 1;
                        } else if(var0 == 4111) {
                           var52 = class32.scriptStringStack[--class30.scriptStringStackSize];
                           class32.scriptStringStack[++class30.scriptStringStackSize - 1] = FontTypeFace.method3949(var52);
                           var3 = 1;
                        } else if(var0 == 4112) {
                           var52 = class32.scriptStringStack[--class30.scriptStringStackSize];
                           var5 = class32.field726[--class32.field735];
                           class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var52 + (char)var5;
                           var3 = 1;
                        } else if(var0 == 4113) {
                           var4 = class32.field726[--class32.field735];
                           class32.field726[++class32.field735 - 1] = Widget.method3326((char)var4)?1:0;
                           var3 = 1;
                        } else {
                           char var66;
                           boolean var69;
                           if(var0 == 4114) {
                              var4 = class32.field726[--class32.field735];
                              var55 = class32.field726;
                              var6 = ++class32.field735 - 1;
                              var66 = (char)var4;
                              var69 = var66 >= 48 && var66 <= 57 || var66 >= 65 && var66 <= 90 || var66 >= 97 && var66 <= 122;
                              var55[var6] = var69?1:0;
                              var3 = 1;
                           } else if(var0 == 4115) {
                              var4 = class32.field726[--class32.field735];
                              var55 = class32.field726;
                              var6 = ++class32.field735 - 1;
                              var66 = (char)var4;
                              var69 = var66 >= 65 && var66 <= 90 || var66 >= 97 && var66 <= 122;
                              var55[var6] = var69?1:0;
                              var3 = 1;
                           } else if(var0 == 4116) {
                              var4 = class32.field726[--class32.field735];
                              var55 = class32.field726;
                              var6 = ++class32.field735 - 1;
                              var66 = (char)var4;
                              var69 = var66 >= 48 && var66 <= 57;
                              var55[var6] = var69?1:0;
                              var3 = 1;
                           } else if(var0 == 4117) {
                              var52 = class32.scriptStringStack[--class30.scriptStringStackSize];
                              if(null != var52) {
                                 class32.field726[++class32.field735 - 1] = var52.length();
                              } else {
                                 class32.field726[++class32.field735 - 1] = 0;
                              }

                              var3 = 1;
                           } else if(var0 == 4118) {
                              var52 = class32.scriptStringStack[--class30.scriptStringStackSize];
                              class32.field735 -= 2;
                              var5 = class32.field726[class32.field735];
                              var6 = class32.field726[1 + class32.field735];
                              class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var52.substring(var5, var6);
                              var3 = 1;
                           } else if(var0 == 4119) {
                              var52 = class32.scriptStringStack[--class30.scriptStringStackSize];
                              StringBuilder var64 = new StringBuilder(var52.length());
                              var42 = false;

                              for(var68 = 0; var68 < var52.length(); ++var68) {
                                 var66 = var52.charAt(var68);
                                 if(var66 == 60) {
                                    var42 = true;
                                 } else if(var66 == 62) {
                                    var42 = false;
                                 } else if(!var42) {
                                    var64.append(var66);
                                 }
                              }

                              class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var64.toString();
                              var3 = 1;
                           } else if(var0 == 4120) {
                              var52 = class32.scriptStringStack[--class30.scriptStringStackSize];
                              var5 = class32.field726[--class32.field735];
                              class32.field726[++class32.field735 - 1] = var52.indexOf(var5);
                              var3 = 1;
                           } else if(var0 == 4121) {
                              class30.scriptStringStackSize -= 2;
                              var52 = class32.scriptStringStack[class30.scriptStringStackSize];
                              var54 = class32.scriptStringStack[class30.scriptStringStackSize + 1];
                              var6 = class32.field726[--class32.field735];
                              class32.field726[++class32.field735 - 1] = var52.indexOf(var54, var6);
                              var3 = 1;
                           } else {
                              var3 = 2;
                           }
                        }
                     }

                     return var3;
                  } else if(var0 < 4300) {
                     if(var0 == 4200) {
                        var4 = class32.field726[--class32.field735];
                        class32.scriptStringStack[++class30.scriptStringStackSize - 1] = ChatLineBuffer.getItemDefinition(var4).name;
                        var3 = 1;
                     } else {
                        ItemComposition var58;
                        if(var0 == 4201) {
                           class32.field735 -= 2;
                           var4 = class32.field726[class32.field735];
                           var5 = class32.field726[1 + class32.field735];
                           var58 = ChatLineBuffer.getItemDefinition(var4);
                           if(var5 >= 1 && var5 <= 5 && null != var58.groundActions[var5 - 1]) {
                              class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var58.groundActions[var5 - 1];
                           } else {
                              class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
                           }

                           var3 = 1;
                        } else if(var0 == 4202) {
                           class32.field735 -= 2;
                           var4 = class32.field726[class32.field735];
                           var5 = class32.field726[class32.field735 + 1];
                           var58 = ChatLineBuffer.getItemDefinition(var4);
                           if(var5 >= 1 && var5 <= 5 && var58.inventoryActions[var5 - 1] != null) {
                              class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var58.inventoryActions[var5 - 1];
                           } else {
                              class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
                           }

                           var3 = 1;
                        } else if(var0 == 4203) {
                           var4 = class32.field726[--class32.field735];
                           class32.field726[++class32.field735 - 1] = ChatLineBuffer.getItemDefinition(var4).price;
                           var3 = 1;
                        } else if(var0 == 4204) {
                           var4 = class32.field726[--class32.field735];
                           class32.field726[++class32.field735 - 1] = ChatLineBuffer.getItemDefinition(var4).isStackable == 1?1:0;
                           var3 = 1;
                        } else {
                           ItemComposition var57;
                           if(var0 == 4205) {
                              var4 = class32.field726[--class32.field735];
                              var57 = ChatLineBuffer.getItemDefinition(var4);
                              if(var57.notedTemplate == -1 && var57.note >= 0) {
                                 class32.field726[++class32.field735 - 1] = var57.note;
                              } else {
                                 class32.field726[++class32.field735 - 1] = var4;
                              }

                              var3 = 1;
                           } else if(var0 == 4206) {
                              var4 = class32.field726[--class32.field735];
                              var57 = ChatLineBuffer.getItemDefinition(var4);
                              if(var57.notedTemplate >= 0 && var57.note >= 0) {
                                 class32.field726[++class32.field735 - 1] = var57.note;
                              } else {
                                 class32.field726[++class32.field735 - 1] = var4;
                              }

                              var3 = 1;
                           } else if(var0 == 4207) {
                              var4 = class32.field726[--class32.field735];
                              class32.field726[++class32.field735 - 1] = ChatLineBuffer.getItemDefinition(var4).isMembers?1:0;
                              var3 = 1;
                           } else if(var0 == 4208) {
                              var4 = class32.field726[--class32.field735];
                              var57 = ChatLineBuffer.getItemDefinition(var4);
                              if(var57.field2999 == -1 && var57.field3001 >= 0) {
                                 class32.field726[++class32.field735 - 1] = var57.field3001;
                              } else {
                                 class32.field726[++class32.field735 - 1] = var4;
                              }

                              var3 = 1;
                           } else if(var0 == 4209) {
                              var4 = class32.field726[--class32.field735];
                              var57 = ChatLineBuffer.getItemDefinition(var4);
                              if(var57.field2999 >= 0 && var57.field3001 >= 0) {
                                 class32.field726[++class32.field735 - 1] = var57.field3001;
                              } else {
                                 class32.field726[++class32.field735 - 1] = var4;
                              }

                              var3 = 1;
                           } else if(var0 == 4210) {
                              var52 = class32.scriptStringStack[--class30.scriptStringStackSize];
                              var5 = class32.field726[--class32.field735];
                              class108.method2130(var52, var5 == 1);
                              class32.field726[++class32.field735 - 1] = class119.field1855;
                              var3 = 1;
                           } else if(var0 == 4211) {
                              if(class41.field838 != null && class185.field2767 < class119.field1855) {
                                 class32.field726[++class32.field735 - 1] = class41.field838[++class185.field2767 - 1] & '\uffff';
                              } else {
                                 class32.field726[++class32.field735 - 1] = -1;
                              }

                              var3 = 1;
                           } else if(var0 == 4212) {
                              class185.field2767 = 0;
                              var3 = 1;
                           } else {
                              var3 = 2;
                           }
                        }
                     }

                     return var3;
                  } else if(var0 < 5100) {
                     if(var0 == 5000) {
                        class32.field726[++class32.field735 - 1] = Client.field507;
                        var3 = 1;
                     } else if(var0 == 5001) {
                        class32.field735 -= 3;
                        Client.field507 = class32.field726[class32.field735];
                        ItemComposition.field3003 = class40.method829(class32.field726[1 + class32.field735]);
                        if(ItemComposition.field3003 == null) {
                           ItemComposition.field3003 = class216.field3183;
                        }

                        Client.field445 = class32.field726[class32.field735 + 2];
                        Client.field332.method3144(237);
                        Client.field332.method2873(Client.field507);
                        Client.field332.method2873(ItemComposition.field3003.field3186);
                        Client.field332.method2873(Client.field445);
                        var3 = 1;
                     } else if(var0 == 5002) {
                        var52 = class32.scriptStringStack[--class30.scriptStringStackSize];
                        class32.field735 -= 2;
                        var5 = class32.field726[class32.field735];
                        var6 = class32.field726[class32.field735 + 1];
                        Client.field332.method3144(139);
                        Client.field332.method2873(class165.method3233(var52) + 2);
                        Client.field332.method2915(var52);
                        Client.field332.method2873(var5 - 1);
                        Client.field332.method2873(var6);
                        var3 = 1;
                     } else if(var0 == 5003) {
                        class32.field735 -= 2;
                        var4 = class32.field726[class32.field735];
                        var5 = class32.field726[class32.field735 + 1];
                        MessageNode var24 = class185.method3490(var4, var5);
                        if(null != var24) {
                           class32.field726[++class32.field735 - 1] = var24.id;
                           class32.field726[++class32.field735 - 1] = var24.tick;
                           class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var24.name != null?var24.name:"";
                           class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var24.sender != null?var24.sender:"";
                           class32.scriptStringStack[++class30.scriptStringStackSize - 1] = null != var24.value?var24.value:"";
                        } else {
                           class32.field726[++class32.field735 - 1] = -1;
                           class32.field726[++class32.field735 - 1] = 0;
                           class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
                           class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
                           class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
                        }

                        var3 = 1;
                     } else if(var0 == 5004) {
                        var4 = class32.field726[--class32.field735];
                        MessageNode var23 = (MessageNode)class47.field943.method2404((long)var4);
                        if(var23 != null) {
                           class32.field726[++class32.field735 - 1] = var23.type;
                           class32.field726[++class32.field735 - 1] = var23.tick;
                           class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var23.name != null?var23.name:"";
                           class32.scriptStringStack[++class30.scriptStringStackSize - 1] = null != var23.sender?var23.sender:"";
                           class32.scriptStringStack[++class30.scriptStringStackSize - 1] = null != var23.value?var23.value:"";
                        } else {
                           class32.field726[++class32.field735 - 1] = -1;
                           class32.field726[++class32.field735 - 1] = 0;
                           class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
                           class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
                           class32.scriptStringStack[++class30.scriptStringStackSize - 1] = "";
                        }

                        var3 = 1;
                     } else if(var0 == 5005) {
                        if(null == ItemComposition.field3003) {
                           class32.field726[++class32.field735 - 1] = -1;
                        } else {
                           class32.field726[++class32.field735 - 1] = ItemComposition.field3003.field3186;
                        }

                        var3 = 1;
                     } else if(var0 == 5008) {
                        var52 = class32.scriptStringStack[--class30.scriptStringStackSize];
                        var5 = class32.field726[--class32.field735];
                        var56 = var52.toLowerCase();
                        byte var26 = 0;
                        if(var56.startsWith("yellow:")) {
                           var26 = 0;
                           var52 = var52.substring("yellow:".length());
                        } else if(var56.startsWith("red:")) {
                           var26 = 1;
                           var52 = var52.substring("red:".length());
                        } else if(var56.startsWith("green:")) {
                           var26 = 2;
                           var52 = var52.substring("green:".length());
                        } else if(var56.startsWith("cyan:")) {
                           var26 = 3;
                           var52 = var52.substring("cyan:".length());
                        } else if(var56.startsWith("purple:")) {
                           var26 = 4;
                           var52 = var52.substring("purple:".length());
                        } else if(var56.startsWith("white:")) {
                           var26 = 5;
                           var52 = var52.substring("white:".length());
                        } else if(var56.startsWith("flash1:")) {
                           var26 = 6;
                           var52 = var52.substring("flash1:".length());
                        } else if(var56.startsWith("flash2:")) {
                           var26 = 7;
                           var52 = var52.substring("flash2:".length());
                        } else if(var56.startsWith("flash3:")) {
                           var26 = 8;
                           var52 = var52.substring("flash3:".length());
                        } else if(var56.startsWith("glow1:")) {
                           var26 = 9;
                           var52 = var52.substring("glow1:".length());
                        } else if(var56.startsWith("glow2:")) {
                           var26 = 10;
                           var52 = var52.substring("glow2:".length());
                        } else if(var56.startsWith("glow3:")) {
                           var26 = 11;
                           var52 = var52.substring("glow3:".length());
                        } else if(Client.field428 != 0) {
                           if(var56.startsWith("yellow:")) {
                              var26 = 0;
                              var52 = var52.substring("yellow:".length());
                           } else if(var56.startsWith("red:")) {
                              var26 = 1;
                              var52 = var52.substring("red:".length());
                           } else if(var56.startsWith("green:")) {
                              var26 = 2;
                              var52 = var52.substring("green:".length());
                           } else if(var56.startsWith("cyan:")) {
                              var26 = 3;
                              var52 = var52.substring("cyan:".length());
                           } else if(var56.startsWith("purple:")) {
                              var26 = 4;
                              var52 = var52.substring("purple:".length());
                           } else if(var56.startsWith("white:")) {
                              var26 = 5;
                              var52 = var52.substring("white:".length());
                           } else if(var56.startsWith("flash1:")) {
                              var26 = 6;
                              var52 = var52.substring("flash1:".length());
                           } else if(var56.startsWith("flash2:")) {
                              var26 = 7;
                              var52 = var52.substring("flash2:".length());
                           } else if(var56.startsWith("flash3:")) {
                              var26 = 8;
                              var52 = var52.substring("flash3:".length());
                           } else if(var56.startsWith("glow1:")) {
                              var26 = 9;
                              var52 = var52.substring("glow1:".length());
                           } else if(var56.startsWith("glow2:")) {
                              var26 = 10;
                              var52 = var52.substring("glow2:".length());
                           } else if(var56.startsWith("glow3:")) {
                              var26 = 11;
                              var52 = var52.substring("glow3:".length());
                           }
                        }

                        var56 = var52.toLowerCase();
                        byte var25 = 0;
                        if(var56.startsWith("wave:")) {
                           var25 = 1;
                           var52 = var52.substring("wave:".length());
                        } else if(var56.startsWith("wave2:")) {
                           var25 = 2;
                           var52 = var52.substring("wave2:".length());
                        } else if(var56.startsWith("shake:")) {
                           var25 = 3;
                           var52 = var52.substring("shake:".length());
                        } else if(var56.startsWith("scroll:")) {
                           var25 = 4;
                           var52 = var52.substring("scroll:".length());
                        } else if(var56.startsWith("slide:")) {
                           var25 = 5;
                           var52 = var52.substring("slide:".length());
                        } else if(Client.field428 != 0) {
                           if(var56.startsWith("wave:")) {
                              var25 = 1;
                              var52 = var52.substring("wave:".length());
                           } else if(var56.startsWith("wave2:")) {
                              var25 = 2;
                              var52 = var52.substring("wave2:".length());
                           } else if(var56.startsWith("shake:")) {
                              var25 = 3;
                              var52 = var52.substring("shake:".length());
                           } else if(var56.startsWith("scroll:")) {
                              var25 = 4;
                              var52 = var52.substring("scroll:".length());
                           } else if(var56.startsWith("slide:")) {
                              var25 = 5;
                              var52 = var52.substring("slide:".length());
                           }
                        }

                        Client.field332.method3144(27);
                        Client.field332.method2873(0);
                        var9 = Client.field332.offset;
                        Client.field332.method2873(var5);
                        Client.field332.method2873(var26);
                        Client.field332.method2873(var25);
                        class159 var30 = Client.field332;
                        var11 = var30.offset;
                        byte[] var31 = Client.method612(var52);
                        var30.method3017(var31.length);
                        var30.offset += class210.field3129.method2799(var31, 0, var31.length, var30.payload, var30.offset);
                        Client.field332.method2883(Client.field332.offset - var9);
                        var3 = 1;
                     } else if(var0 == 5009) {
                        class30.scriptStringStackSize -= 2;
                        var52 = class32.scriptStringStack[class30.scriptStringStackSize];
                        var54 = class32.scriptStringStack[class30.scriptStringStackSize + 1];
                        Client.field332.method3144(173);
                        Client.field332.method2872(0);
                        var6 = Client.field332.offset;
                        Client.field332.method2915(var52);
                        class159 var7 = Client.field332;
                        var65 = var7.offset;
                        var27 = Client.method612(var54);
                        var7.method3017(var27.length);
                        var7.offset += class210.field3129.method2799(var27, 0, var27.length, var7.payload, var7.offset);
                        Client.field332.method2882(Client.field332.offset - var6);
                        var3 = 1;
                     } else if(var0 == 5015) {
                        if(WidgetNode.localPlayer != null && null != WidgetNode.localPlayer.name) {
                           var52 = WidgetNode.localPlayer.name;
                        } else {
                           var52 = "";
                        }

                        class32.scriptStringStack[++class30.scriptStringStackSize - 1] = var52;
                        var3 = 1;
                     } else if(var0 == 5016) {
                        class32.field726[++class32.field735 - 1] = Client.field445;
                        var3 = 1;
                     } else if(var0 == 5017) {
                        var4 = class32.field726[--class32.field735];
                        var55 = class32.field726;
                        var6 = ++class32.field735 - 1;
                        ChatLineBuffer var8 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var4));
                        if(var8 == null) {
                           var68 = 0;
                        } else {
                           var68 = var8.method984();
                        }

                        var55[var6] = var68;
                        var3 = 1;
                     } else {
                        MessageNode var36;
                        if(var0 == 5018) {
                           var4 = class32.field726[--class32.field735];
                           var55 = class32.field726;
                           var6 = ++class32.field735 - 1;
                           var36 = (MessageNode)class47.field943.method2404((long)var4);
                           if(var36 == null) {
                              var68 = -1;
                           } else if(var36.previous == class47.field944.field1903) {
                              var68 = -1;
                           } else {
                              var68 = ((MessageNode)var36.previous).id;
                           }

                           var55[var6] = var68;
                           var3 = 1;
                        } else if(var0 == 5019) {
                           var4 = class32.field726[--class32.field735];
                           var55 = class32.field726;
                           var6 = ++class32.field735 - 1;
                           var36 = (MessageNode)class47.field943.method2404((long)var4);
                           if(var36 == null) {
                              var68 = -1;
                           } else if(var36.next == class47.field944.field1903) {
                              var68 = -1;
                           } else {
                              var68 = ((MessageNode)var36.next).id;
                           }

                           var55[var6] = var68;
                           var3 = 1;
                        } else if(var0 == 5020) {
                           var52 = class32.scriptStringStack[--class30.scriptStringStackSize];
                           class185.method3482(var52);
                           var3 = 1;
                        } else if(var0 == 5021) {
                           Client.field509 = class32.scriptStringStack[--class30.scriptStringStackSize].toLowerCase().trim();
                           var3 = 1;
                        } else if(var0 == 5022) {
                           class32.scriptStringStack[++class30.scriptStringStackSize - 1] = Client.field509;
                           var3 = 1;
                        } else {
                           var3 = 2;
                        }
                     }

                     return var3;
                  } else if(var0 >= 5400) {
                     if(var0 < 5600) {
                        return class110.method2165(var0, var1, var2);
                     } else if(var0 < 5700) {
                        if(var0 == 5630) {
                           Client.field342 = 250;
                           var3 = 1;
                        } else {
                           var3 = 2;
                        }

                        return var3;
                     } else {
                        return var0 < 6300?ItemLayer.method1545(var0, var1, var2):(var0 < 6600?CollisionData.method2377(var0, var1, var2):2);
                     }
                  } else {
                     if(var0 == 5306) {
                        var22 = class32.field726;
                        var5 = ++class32.field735 - 1;
                        var6 = Client.isResized?2:1;
                        var22[var5] = var6;
                        var3 = 1;
                     } else if(var0 == 5307) {
                        var4 = class32.field726[--class32.field735];
                        if(var4 == 1 || var4 == 2) {
                           Client.field330 = 0L;
                           if(var4 >= 2) {
                              Client.isResized = true;
                           } else {
                              Client.isResized = false;
                           }

                           FaceNormal.method1988();
                           if(Client.gameState >= 25) {
                              class140.method2705();
                           }

                           GameEngine.field1778 = true;
                        }

                        var3 = 1;
                     } else if(var0 == 5308) {
                        class32.field726[++class32.field735 - 1] = ObjectComposition.field2944.field697;
                        var3 = 1;
                     } else if(var0 == 5309) {
                        var4 = class32.field726[--class32.field735];
                        if(var4 == 1 || var4 == 2) {
                           ObjectComposition.field2944.field697 = var4;
                           class146.method2811();
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

   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "1352201755"
   )
   static String method11(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.field309 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field309 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field309 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field309 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field309 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(Client.field303 != null) {
         var3 = "/p=" + Client.field303;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field428 + "/a=" + class6.field44 + var3 + "/";
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[Lclass177;",
      garbageValue = "1290308548"
   )
   public static class177[] method12() {
      return new class177[]{class177.field2663, class177.field2659, class177.field2666, class177.field2661, class177.field2662, class177.field2668};
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;B)V",
      garbageValue = "0"
   )
   public static void method13(class182 var0) {
      class189.field2793 = var0;
   }
}
