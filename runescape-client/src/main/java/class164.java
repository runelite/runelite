import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public class class164 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "[Ljw;"
   )
   static IndexedSprite[] field2293;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Lil;",
      garbageValue = "-684145015"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.identKits.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.identKit_ref.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         KitDefinition.identKits.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "16776960"
   )
   @Export("addMenuEntry")
   public static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      class47.method711(var0, var1, var2, var3, var4, var5, false);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IILfu;Lfl;B)Z",
      garbageValue = "27"
   )
   public static final boolean method3118(int var0, int var1, class163 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class162.field2272[var6][var7] = 99;
      class162.field2273[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class162.field2271[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class162.field2282[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var11 != var18) {
         var4 = class162.field2271[var11];
         var5 = class162.field2282[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod3102(2, var4, var5, var3)) {
            class162.field2277 = var4;
            class98.field1497 = var5;
            return true;
         }

         int var15 = class162.field2273[var16][var17] + 1;
         if(var16 > 0 && class162.field2272[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0) {
            class162.field2271[var18] = var4 - 1;
            class162.field2282[var18] = var5;
            var18 = var18 + 1 & 4095;
            class162.field2272[var16 - 1][var17] = 2;
            class162.field2273[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && class162.field2272[var16 + 1][var17] == 0 && (var12[var13 + 2][var14] & 19136899) == 0 && (var12[var13 + 2][var14 + 1] & 19136992) == 0) {
            class162.field2271[var18] = var4 + 1;
            class162.field2282[var18] = var5;
            var18 = var18 + 1 & 4095;
            class162.field2272[var16 + 1][var17] = 8;
            class162.field2273[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class162.field2272[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
            class162.field2271[var18] = var4;
            class162.field2282[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class162.field2272[var16][var17 - 1] = 1;
            class162.field2273[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && 0 == class162.field2272[var16][var17 + 1] && (var12[var13][var14 + 2] & 19136824) == 0 && 0 == (var12[var13 + 1][var14 + 2] & 19136992)) {
            class162.field2271[var18] = var4;
            class162.field2282[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class162.field2272[var16][var17 + 1] = 4;
            class162.field2273[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class162.field2272[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class162.field2271[var18] = var4 - 1;
            class162.field2282[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class162.field2272[var16 - 1][var17 - 1] = 3;
            class162.field2273[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class162.field2272[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && 0 == (var12[var13 + 2][var14] & 19136995)) {
            class162.field2271[var18] = var4 + 1;
            class162.field2282[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class162.field2272[var16 + 1][var17 - 1] = 9;
            class162.field2273[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class162.field2272[var16 - 1][var17 + 1] == 0 && 0 == (var12[var13 - 1][var14 + 1] & 19136830) && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && 0 == (var12[var13][var14 + 2] & 19137016)) {
            class162.field2271[var18] = var4 - 1;
            class162.field2282[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class162.field2272[var16 - 1][var17 + 1] = 6;
            class162.field2273[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 126 && var17 < 126 && 0 == class162.field2272[var16 + 1][var17 + 1] && (var12[var13 + 1][var14 + 2] & 19137016) == 0 && (var12[var13 + 2][var14 + 2] & 19136992) == 0 && (var12[var13 + 2][var14 + 1] & 19136995) == 0) {
            class162.field2271[var18] = var4 + 1;
            class162.field2282[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class162.field2272[var16 + 1][var17 + 1] = 12;
            class162.field2273[var16 + 1][var17 + 1] = var15;
         }
      }

      class162.field2277 = var4;
      class98.field1497 = var5;
      return false;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "-1218462194"
   )
   static int method3120(int var0, Script var1, boolean var2) {
      if(var0 < 1000) {
         return Signlink.method2974(var0, var1, var2);
      } else if(var0 < 1100) {
         return Client.method1272(var0, var1, var2);
      } else if(var0 < 1200) {
         return class40.method552(var0, var1, var2);
      } else if(var0 < 1300) {
         return class60.method1055(var0, var1, var2);
      } else if(var0 < 1400) {
         return class1.method1(var0, var1, var2);
      } else if(var0 < 1500) {
         return class36.method503(var0, var1, var2);
      } else {
         byte var3;
         if(var0 < 1600) {
            Widget var40 = var2?class214.field2615:class73.field851;
            if(var0 == 1500) {
               class83.intStack[++class83.intStackSize - 1] = var40.relativeX;
               var3 = 1;
            } else if(var0 == 1501) {
               class83.intStack[++class83.intStackSize - 1] = var40.relativeY;
               var3 = 1;
            } else if(var0 == 1502) {
               class83.intStack[++class83.intStackSize - 1] = var40.width;
               var3 = 1;
            } else if(var0 == 1503) {
               class83.intStack[++class83.intStackSize - 1] = var40.height;
               var3 = 1;
            } else if(var0 == 1504) {
               class83.intStack[++class83.intStackSize - 1] = var40.isHidden?1:0;
               var3 = 1;
            } else if(var0 == 1505) {
               class83.intStack[++class83.intStackSize - 1] = var40.parentId;
               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else {
            Widget var74;
            if(var0 < 1700) {
               var74 = var2?class214.field2615:class73.field851;
               if(var0 == 1600) {
                  class83.intStack[++class83.intStackSize - 1] = var74.scrollX;
                  var3 = 1;
               } else if(var0 == 1601) {
                  class83.intStack[++class83.intStackSize - 1] = var74.scrollY;
                  var3 = 1;
               } else if(var0 == 1602) {
                  class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var74.text;
                  var3 = 1;
               } else if(var0 == 1603) {
                  class83.intStack[++class83.intStackSize - 1] = var74.scrollWidth;
                  var3 = 1;
               } else if(var0 == 1604) {
                  class83.intStack[++class83.intStackSize - 1] = var74.scrollHeight;
                  var3 = 1;
               } else if(var0 == 1605) {
                  class83.intStack[++class83.intStackSize - 1] = var74.modelZoom;
                  var3 = 1;
               } else if(var0 == 1606) {
                  class83.intStack[++class83.intStackSize - 1] = var74.rotationX;
                  var3 = 1;
               } else if(var0 == 1607) {
                  class83.intStack[++class83.intStackSize - 1] = var74.rotationY;
                  var3 = 1;
               } else if(var0 == 1608) {
                  class83.intStack[++class83.intStackSize - 1] = var74.rotationZ;
                  var3 = 1;
               } else if(var0 == 1609) {
                  class83.intStack[++class83.intStackSize - 1] = var74.opacity;
                  var3 = 1;
               } else if(var0 == 1610) {
                  class83.intStack[++class83.intStackSize - 1] = var74.field2661;
                  var3 = 1;
               } else if(var0 == 1611) {
                  class83.intStack[++class83.intStackSize - 1] = var74.textColor;
                  var3 = 1;
               } else if(var0 == 1612) {
                  class83.intStack[++class83.intStackSize - 1] = var74.field2655;
                  var3 = 1;
               } else if(var0 == 1613) {
                  class83.intStack[++class83.intStackSize - 1] = var74.field2703.rsOrdinal();
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 1800) {
               return ScriptEvent.method1125(var0, var1, var2);
            } else if(var0 < 1900) {
               return Friend.method1108(var0, var1, var2);
            } else if(var0 < 2000) {
               return class28.method236(var0, var1, var2);
            } else if(var0 < 2100) {
               return Client.method1272(var0, var1, var2);
            } else if(var0 < 2200) {
               return class40.method552(var0, var1, var2);
            } else if(var0 < 2300) {
               return class60.method1055(var0, var1, var2);
            } else if(var0 < 2400) {
               return class1.method1(var0, var1, var2);
            } else if(var0 < 2500) {
               return class36.method503(var0, var1, var2);
            } else if(var0 < 2600) {
               return class25.method172(var0, var1, var2);
            } else if(var0 < 2700) {
               return class98.method1855(var0, var1, var2);
            } else {
               int var4;
               if(var0 < 2800) {
                  if(var0 == 2700) {
                     var74 = WallObject.method2901(class83.intStack[--class83.intStackSize]);
                     class83.intStack[++class83.intStackSize - 1] = var74.itemId;
                     var3 = 1;
                  } else if(var0 == 2701) {
                     var74 = WallObject.method2901(class83.intStack[--class83.intStackSize]);
                     if(var74.itemId != -1) {
                        class83.intStack[++class83.intStackSize - 1] = var74.itemQuantity;
                     } else {
                        class83.intStack[++class83.intStackSize - 1] = 0;
                     }

                     var3 = 1;
                  } else if(var0 == 2702) {
                     var4 = class83.intStack[--class83.intStackSize];
                     WidgetNode var55 = (WidgetNode)Client.componentTable.get((long)var4);
                     if(var55 != null) {
                        class83.intStack[++class83.intStackSize - 1] = 1;
                     } else {
                        class83.intStack[++class83.intStackSize - 1] = 0;
                     }

                     var3 = 1;
                  } else if(var0 == 2706) {
                     class83.intStack[++class83.intStackSize - 1] = Client.widgetRoot;
                     var3 = 1;
                  } else {
                     var3 = 2;
                  }

                  return var3;
               } else if(var0 < 2900) {
                  return GameEngine.method854(var0, var1, var2);
               } else if(var0 < 3000) {
                  return class28.method236(var0, var1, var2);
               } else if(var0 < 3200) {
                  return class207.method3887(var0, var1, var2);
               } else if(var0 < 3300) {
                  if(var0 == 3200) {
                     class83.intStackSize -= 3;
                     class71.method1130(class83.intStack[class83.intStackSize], class83.intStack[class83.intStackSize + 1], class83.intStack[class83.intStackSize + 2]);
                     var3 = 1;
                  } else if(var0 == 3201) {
                     var4 = class83.intStack[--class83.intStackSize];
                     if(var4 == -1 && !Client.field1121) {
                        class48.method729();
                     } else if(var4 != -1 && var4 != Client.field1069 && Client.field1119 != 0 && !Client.field1121) {
                        class40.method556(2, class2.indexTrack1, var4, 0, Client.field1119, false);
                     }

                     Client.field1069 = var4;
                     var3 = 1;
                  } else if(var0 == 3202) {
                     class83.intStackSize -= 2;
                     CombatInfoListHolder.method1687(class83.intStack[class83.intStackSize], class83.intStack[class83.intStackSize + 1]);
                     var3 = 1;
                  } else {
                     var3 = 2;
                  }

                  return var3;
               } else {
                  int var6;
                  int var8;
                  int var59;
                  int var60;
                  int[] var62;
                  if(var0 < 3400) {
                     if(var0 == 3300) {
                        class83.intStack[++class83.intStackSize - 1] = Client.gameCycle;
                        var3 = 1;
                     } else {
                        XItemContainer var46;
                        if(var0 == 3301) {
                           class83.intStackSize -= 2;
                           var4 = class83.intStack[class83.intStackSize];
                           var59 = class83.intStack[class83.intStackSize + 1];
                           var62 = class83.intStack;
                           var60 = ++class83.intStackSize - 1;
                           var46 = (XItemContainer)XItemContainer.itemContainers.get((long)var4);
                           if(var46 == null) {
                              var8 = -1;
                           } else if(var59 >= 0 && var59 < var46.itemIds.length) {
                              var8 = var46.itemIds[var59];
                           } else {
                              var8 = -1;
                           }

                           var62[var60] = var8;
                           var3 = 1;
                        } else if(var0 == 3302) {
                           class83.intStackSize -= 2;
                           var4 = class83.intStack[class83.intStackSize];
                           var59 = class83.intStack[class83.intStackSize + 1];
                           class83.intStack[++class83.intStackSize - 1] = class87.method1711(var4, var59);
                           var3 = 1;
                        } else if(var0 == 3303) {
                           class83.intStackSize -= 2;
                           var4 = class83.intStack[class83.intStackSize];
                           var59 = class83.intStack[class83.intStackSize + 1];
                           class83.intStack[++class83.intStackSize - 1] = class227.method4087(var4, var59);
                           var3 = 1;
                        } else if(var0 == 3304) {
                           var4 = class83.intStack[--class83.intStackSize];
                           class83.intStack[++class83.intStackSize - 1] = class8.method41(var4).field3264;
                           var3 = 1;
                        } else if(var0 == 3305) {
                           var4 = class83.intStack[--class83.intStackSize];
                           class83.intStack[++class83.intStackSize - 1] = Client.boostedSkillLevels[var4];
                           var3 = 1;
                        } else if(var0 == 3306) {
                           var4 = class83.intStack[--class83.intStackSize];
                           class83.intStack[++class83.intStackSize - 1] = Client.realSkillLevels[var4];
                           var3 = 1;
                        } else if(var0 == 3307) {
                           var4 = class83.intStack[--class83.intStackSize];
                           class83.intStack[++class83.intStackSize - 1] = Client.skillExperiences[var4];
                           var3 = 1;
                        } else if(var0 == 3308) {
                           var4 = class8.plane;
                           var59 = (class224.localPlayer.x >> 7) + class33.baseX;
                           var6 = (class224.localPlayer.y >> 7) + class17.baseY;
                           class83.intStack[++class83.intStackSize - 1] = (var59 << 14) + var6 + (var4 << 28);
                           var3 = 1;
                        } else if(var0 == 3309) {
                           var4 = class83.intStack[--class83.intStackSize];
                           class83.intStack[++class83.intStackSize - 1] = var4 >> 14 & 16383;
                           var3 = 1;
                        } else if(var0 == 3310) {
                           var4 = class83.intStack[--class83.intStackSize];
                           class83.intStack[++class83.intStackSize - 1] = var4 >> 28;
                           var3 = 1;
                        } else if(var0 == 3311) {
                           var4 = class83.intStack[--class83.intStackSize];
                           class83.intStack[++class83.intStackSize - 1] = var4 & 16383;
                           var3 = 1;
                        } else if(var0 == 3312) {
                           class83.intStack[++class83.intStackSize - 1] = Client.isMembers?1:0;
                           var3 = 1;
                        } else if(var0 == 3313) {
                           class83.intStackSize -= 2;
                           var4 = class83.intStack[class83.intStackSize] + '耀';
                           var59 = class83.intStack[class83.intStackSize + 1];
                           var62 = class83.intStack;
                           var60 = ++class83.intStackSize - 1;
                           var46 = (XItemContainer)XItemContainer.itemContainers.get((long)var4);
                           if(var46 == null) {
                              var8 = -1;
                           } else if(var59 >= 0 && var59 < var46.itemIds.length) {
                              var8 = var46.itemIds[var59];
                           } else {
                              var8 = -1;
                           }

                           var62[var60] = var8;
                           var3 = 1;
                        } else if(var0 == 3314) {
                           class83.intStackSize -= 2;
                           var4 = class83.intStack[class83.intStackSize] + '耀';
                           var59 = class83.intStack[class83.intStackSize + 1];
                           class83.intStack[++class83.intStackSize - 1] = class87.method1711(var4, var59);
                           var3 = 1;
                        } else if(var0 == 3315) {
                           class83.intStackSize -= 2;
                           var4 = class83.intStack[class83.intStackSize] + '耀';
                           var59 = class83.intStack[class83.intStackSize + 1];
                           class83.intStack[++class83.intStackSize - 1] = class227.method4087(var4, var59);
                           var3 = 1;
                        } else if(var0 == 3316) {
                           if(Client.rights >= 2) {
                              class83.intStack[++class83.intStackSize - 1] = Client.rights;
                           } else {
                              class83.intStack[++class83.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        } else if(var0 == 3317) {
                           class83.intStack[++class83.intStackSize - 1] = Client.field908;
                           var3 = 1;
                        } else if(var0 == 3318) {
                           class83.intStack[++class83.intStackSize - 1] = Client.world;
                           var3 = 1;
                        } else if(var0 == 3321) {
                           class83.intStack[++class83.intStackSize - 1] = Client.energy;
                           var3 = 1;
                        } else if(var0 == 3322) {
                           class83.intStack[++class83.intStackSize - 1] = Client.weight;
                           var3 = 1;
                        } else if(var0 == 3323) {
                           if(Client.field1052) {
                              class83.intStack[++class83.intStackSize - 1] = 1;
                           } else {
                              class83.intStack[++class83.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        } else if(var0 == 3324) {
                           class83.intStack[++class83.intStackSize - 1] = Client.flags;
                           var3 = 1;
                        } else if(var0 == 3325) {
                           class83.intStackSize -= 4;
                           var4 = class83.intStack[class83.intStackSize];
                           var59 = class83.intStack[class83.intStackSize + 1];
                           var6 = class83.intStack[class83.intStackSize + 2];
                           var60 = class83.intStack[class83.intStackSize + 3];
                           var4 += var59 << 14;
                           var4 += var6 << 28;
                           var4 += var60;
                           class83.intStack[++class83.intStackSize - 1] = var4;
                           var3 = 1;
                        } else {
                           var3 = 2;
                        }
                     }

                     return var3;
                  } else if(var0 < 3500) {
                     return class60.method1051(var0, var1, var2);
                  } else {
                     int var11;
                     String var25;
                     String var32;
                     String var41;
                     String var43;
                     String var66;
                     if(var0 < 3700) {
                        if(var0 == 3600) {
                           if(Client.field1144 == 0) {
                              class83.intStack[++class83.intStackSize - 1] = -2;
                           } else if(Client.field1144 == 1) {
                              class83.intStack[++class83.intStackSize - 1] = -1;
                           } else {
                              class83.intStack[++class83.intStackSize - 1] = Client.friendCount;
                           }

                           var3 = 1;
                        } else if(var0 == 3601) {
                           var4 = class83.intStack[--class83.intStackSize];
                           if(Client.field1144 == 2 && var4 < Client.friendCount) {
                              class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = Client.friends[var4].name;
                              class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = Client.friends[var4].previousName;
                           } else {
                              class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
                              class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
                           }

                           var3 = 1;
                        } else if(var0 == 3602) {
                           var4 = class83.intStack[--class83.intStackSize];
                           if(Client.field1144 == 2 && var4 < Client.friendCount) {
                              class83.intStack[++class83.intStackSize - 1] = Client.friends[var4].world;
                           } else {
                              class83.intStack[++class83.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        } else if(var0 == 3603) {
                           var4 = class83.intStack[--class83.intStackSize];
                           if(Client.field1144 == 2 && var4 < Client.friendCount) {
                              class83.intStack[++class83.intStackSize - 1] = Client.friends[var4].rank;
                           } else {
                              class83.intStack[++class83.intStackSize - 1] = 0;
                           }

                           var3 = 1;
                        } else if(var0 == 3604) {
                           var66 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                           var59 = class83.intStack[--class83.intStackSize];
                           class64.method1102(var66, var59);
                           var3 = 1;
                        } else if(var0 == 3605) {
                           var66 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                           CombatInfo2.method4384(var66);
                           var3 = 1;
                        } else {
                           Friend var36;
                           boolean var73;
                           if(var0 == 3606) {
                              var66 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                              if(var66 != null) {
                                 var32 = class9.method48(var66, MouseInput.field715);
                                 if(var32 != null) {
                                    for(var6 = 0; var6 < Client.friendCount; ++var6) {
                                       var36 = Client.friends[var6];
                                       var25 = var36.name;
                                       var41 = class9.method48(var25, MouseInput.field715);
                                       if(var66 != null && var25 != null) {
                                          if(!var66.startsWith("#") && !var25.startsWith("#")) {
                                             var73 = var32.equals(var41);
                                          } else {
                                             var73 = var66.equals(var25);
                                          }
                                       } else {
                                          var73 = false;
                                       }

                                       if(var73) {
                                          --Client.friendCount;

                                          for(var11 = var6; var11 < Client.friendCount; ++var11) {
                                             Client.friends[var11] = Client.friends[var11 + 1];
                                          }

                                          Client.field1076 = Client.cycleCntr;
                                          Client.secretPacketBuffer1.putOpcode(136);
                                          Client.secretPacketBuffer1.putByte(VertexNormal.getLength(var66));
                                          Client.secretPacketBuffer1.putString(var66);
                                          break;
                                       }
                                    }
                                 }
                              }

                              var3 = 1;
                           } else {
                              Ignore var37;
                              if(var0 == 3607) {
                                 var66 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                                 if(var66 != null) {
                                    if((Client.ignoreCount < 100 || Client.field1101 == 1) && Client.ignoreCount < 400) {
                                       var32 = class9.method48(var66, MouseInput.field715);
                                       if(var32 != null) {
                                          var6 = 0;

                                          label1681:
                                          while(true) {
                                             if(var6 >= Client.ignoreCount) {
                                                for(var6 = 0; var6 < Client.friendCount; ++var6) {
                                                   var36 = Client.friends[var6];
                                                   var25 = class9.method48(var36.name, MouseInput.field715);
                                                   if(var25 != null && var25.equals(var32)) {
                                                      class202.sendGameMessage(31, "", "Please remove " + var66 + " from your friend list first");
                                                      break label1681;
                                                   }

                                                   if(var36.previousName != null) {
                                                      var41 = class9.method48(var36.previousName, MouseInput.field715);
                                                      if(var41 != null && var41.equals(var32)) {
                                                         class202.sendGameMessage(31, "", "Please remove " + var66 + " from your friend list first");
                                                         break label1681;
                                                      }
                                                   }
                                                }

                                                if(class9.method48(class224.localPlayer.name, MouseInput.field715).equals(var32)) {
                                                   class202.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
                                                } else {
                                                   Client.secretPacketBuffer1.putOpcode(70);
                                                   Client.secretPacketBuffer1.putByte(VertexNormal.getLength(var66));
                                                   Client.secretPacketBuffer1.putString(var66);
                                                }
                                                break;
                                             }

                                             var37 = Client.ignores[var6];
                                             var25 = class9.method48(var37.name, MouseInput.field715);
                                             if(var25 != null && var25.equals(var32)) {
                                                class202.sendGameMessage(31, "", var66 + " is already on your ignore list");
                                                break;
                                             }

                                             if(var37.previousName != null) {
                                                var41 = class9.method48(var37.previousName, MouseInput.field715);
                                                if(var41 != null && var41.equals(var32)) {
                                                   class202.sendGameMessage(31, "", var66 + " is already on your ignore list");
                                                   break;
                                                }
                                             }

                                             ++var6;
                                          }
                                       }
                                    } else {
                                       class202.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                                    }
                                 }

                                 var3 = 1;
                              } else if(var0 == 3608) {
                                 var66 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                                 if(var66 != null) {
                                    var32 = class9.method48(var66, MouseInput.field715);
                                    if(var32 != null) {
                                       for(var6 = 0; var6 < Client.ignoreCount; ++var6) {
                                          var37 = Client.ignores[var6];
                                          var25 = var37.name;
                                          var41 = class9.method48(var25, MouseInput.field715);
                                          if(var66 != null && var25 != null) {
                                             if(!var66.startsWith("#") && !var25.startsWith("#")) {
                                                var73 = var32.equals(var41);
                                             } else {
                                                var73 = var66.equals(var25);
                                             }
                                          } else {
                                             var73 = false;
                                          }

                                          if(var73) {
                                             --Client.ignoreCount;

                                             for(var11 = var6; var11 < Client.ignoreCount; ++var11) {
                                                Client.ignores[var11] = Client.ignores[var11 + 1];
                                             }

                                             Client.field1076 = Client.cycleCntr;
                                             Client.secretPacketBuffer1.putOpcode(42);
                                             Client.secretPacketBuffer1.putByte(VertexNormal.getLength(var66));
                                             Client.secretPacketBuffer1.putString(var66);
                                             break;
                                          }
                                       }
                                    }
                                 }

                                 var3 = 1;
                              } else if(var0 == 3609) {
                                 var66 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                                 Permission[] var54 = new Permission[]{Permission.field3156, Permission.field3154, Permission.field3157, Permission.field3153, Permission.field3155, Permission.field3152};
                                 Permission[] var69 = var54;

                                 for(var60 = 0; var60 < var69.length; ++var60) {
                                    Permission var70 = var69[var60];
                                    if(var70.field3159 != -1) {
                                       var11 = var70.field3159;
                                       var43 = "<img=" + var11 + ">";
                                       if(var66.startsWith(var43)) {
                                          var66 = var66.substring(6 + Integer.toString(var70.field3159).length());
                                          break;
                                       }
                                    }
                                 }

                                 class83.intStack[++class83.intStackSize - 1] = class31.isFriended(var66, false)?1:0;
                                 var3 = 1;
                              } else if(var0 == 3611) {
                                 if(Client.clanChatOwner != null) {
                                    class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = ItemComposition.method4612(Client.clanChatOwner);
                                 } else {
                                    class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
                                 }

                                 var3 = 1;
                              } else if(var0 == 3612) {
                                 if(Client.clanChatOwner != null) {
                                    class83.intStack[++class83.intStackSize - 1] = class21.clanChatCount;
                                 } else {
                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                 }

                                 var3 = 1;
                              } else if(var0 == 3613) {
                                 var4 = class83.intStack[--class83.intStackSize];
                                 if(Client.clanChatOwner != null && var4 < class21.clanChatCount) {
                                    class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = class37.clanMembers[var4].username;
                                 } else {
                                    class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
                                 }

                                 var3 = 1;
                              } else if(var0 == 3614) {
                                 var4 = class83.intStack[--class83.intStackSize];
                                 if(Client.clanChatOwner != null && var4 < class21.clanChatCount) {
                                    class83.intStack[++class83.intStackSize - 1] = class37.clanMembers[var4].world;
                                 } else {
                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                 }

                                 var3 = 1;
                              } else if(var0 == 3615) {
                                 var4 = class83.intStack[--class83.intStackSize];
                                 if(Client.clanChatOwner != null && var4 < class21.clanChatCount) {
                                    class83.intStack[++class83.intStackSize - 1] = class37.clanMembers[var4].rank;
                                 } else {
                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                 }

                                 var3 = 1;
                              } else if(var0 == 3616) {
                                 class83.intStack[++class83.intStackSize - 1] = IndexData.field3231;
                                 var3 = 1;
                              } else if(var0 == 3617) {
                                 var66 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                                 if(class37.clanMembers != null) {
                                    Client.secretPacketBuffer1.putOpcode(137);
                                    Client.secretPacketBuffer1.putByte(VertexNormal.getLength(var66));
                                    Client.secretPacketBuffer1.putString(var66);
                                 }

                                 var3 = 1;
                              } else if(var0 == 3618) {
                                 class83.intStack[++class83.intStackSize - 1] = class67.clanChatRank;
                                 var3 = 1;
                              } else if(var0 == 3619) {
                                 var66 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                                 XGrandExchangeOffer.method112(var66);
                                 var3 = 1;
                              } else if(var0 == 3620) {
                                 Client.secretPacketBuffer1.putOpcode(209);
                                 Client.secretPacketBuffer1.putByte(0);
                                 var3 = 1;
                              } else if(var0 == 3621) {
                                 if(Client.field1144 == 0) {
                                    class83.intStack[++class83.intStackSize - 1] = -1;
                                 } else {
                                    class83.intStack[++class83.intStackSize - 1] = Client.ignoreCount;
                                 }

                                 var3 = 1;
                              } else if(var0 == 3622) {
                                 var4 = class83.intStack[--class83.intStackSize];
                                 if(Client.field1144 != 0 && var4 < Client.ignoreCount) {
                                    class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = Client.ignores[var4].name;
                                    class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = Client.ignores[var4].previousName;
                                 } else {
                                    class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
                                    class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
                                 }

                                 var3 = 1;
                              } else if(var0 == 3623) {
                                 label1590: {
                                    var66 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                                    String var71 = "<img=0>";
                                    if(!var66.startsWith(var71)) {
                                       var25 = "<img=1>";
                                       if(!var66.startsWith(var25)) {
                                          break label1590;
                                       }
                                    }

                                    var66 = var66.substring(7);
                                 }

                                 class83.intStack[++class83.intStackSize - 1] = class64.isIgnored(var66)?1:0;
                                 var3 = 1;
                              } else if(var0 == 3624) {
                                 var4 = class83.intStack[--class83.intStackSize];
                                 if(class37.clanMembers != null && var4 < class21.clanChatCount && class37.clanMembers[var4].username.equalsIgnoreCase(class224.localPlayer.name)) {
                                    class83.intStack[++class83.intStackSize - 1] = 1;
                                 } else {
                                    class83.intStack[++class83.intStackSize - 1] = 0;
                                 }

                                 var3 = 1;
                              } else if(var0 == 3625) {
                                 if(Client.clanChatName != null) {
                                    class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = ItemComposition.method4612(Client.clanChatName);
                                 } else {
                                    class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
                                 }

                                 var3 = 1;
                              } else {
                                 var3 = 2;
                              }
                           }
                        }

                        return var3;
                     } else if(var0 < 4000) {
                        return class210.method3932(var0, var1, var2);
                     } else if(var0 < 4100) {
                        return class114.method2167(var0, var1, var2);
                     } else {
                        boolean var24;
                        if(var0 < 4200) {
                           if(var0 == 4100) {
                              var66 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                              var59 = class83.intStack[--class83.intStackSize];
                              class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var66 + var59;
                              var3 = 1;
                           } else if(var0 == 4101) {
                              Timer.scriptStringStackSize -= 2;
                              var66 = class83.scriptStringStack[Timer.scriptStringStackSize];
                              var32 = class83.scriptStringStack[Timer.scriptStringStackSize + 1];
                              class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var66 + var32;
                              var3 = 1;
                           } else {
                              int var12;
                              int var13;
                              int var16;
                              int var17;
                              if(var0 == 4102) {
                                 var66 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                                 var59 = class83.intStack[--class83.intStackSize];
                                 String[] var68 = class83.scriptStringStack;
                                 var60 = ++Timer.scriptStringStackSize - 1;
                                 if(var59 < 0) {
                                    var41 = Integer.toString(var59);
                                 } else {
                                    var11 = var59;
                                    if(var59 < 0) {
                                       var43 = Integer.toString(var59, 10);
                                    } else {
                                       var12 = 2;

                                       for(var13 = var59 / 10; var13 != 0; ++var12) {
                                          var13 /= 10;
                                       }

                                       char[] var30 = new char[var12];
                                       var30[0] = 43;

                                       for(int var15 = var12 - 1; var15 > 0; --var15) {
                                          var16 = var11;
                                          var11 /= 10;
                                          var17 = var16 - var11 * 10;
                                          if(var17 >= 10) {
                                             var30[var15] = (char)(var17 + 87);
                                          } else {
                                             var30[var15] = (char)(var17 + 48);
                                          }
                                       }

                                       var43 = new String(var30);
                                    }

                                    var41 = var43;
                                 }

                                 var68[var60] = var66 + var41;
                                 var3 = 1;
                              } else if(var0 == 4103) {
                                 var66 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                                 class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var66.toLowerCase();
                                 var3 = 1;
                              } else {
                                 int var28;
                                 if(var0 == 4104) {
                                    var4 = class83.intStack[--class83.intStackSize];
                                    long var26 = (11745L + (long)var4) * 86400000L;
                                    class83.field1311.setTime(new Date(var26));
                                    var60 = class83.field1311.get(5);
                                    var8 = class83.field1311.get(2);
                                    var28 = class83.field1311.get(1);
                                    class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var60 + "-" + class83.field1312[var8] + "-" + var28;
                                    var3 = 1;
                                 } else if(var0 == 4105) {
                                    Timer.scriptStringStackSize -= 2;
                                    var66 = class83.scriptStringStack[Timer.scriptStringStackSize];
                                    var32 = class83.scriptStringStack[Timer.scriptStringStackSize + 1];
                                    if(class224.localPlayer.composition != null && class224.localPlayer.composition.isFemale) {
                                       class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var32;
                                    } else {
                                       class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var66;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 4106) {
                                    var4 = class83.intStack[--class83.intStackSize];
                                    class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = Integer.toString(var4);
                                    var3 = 1;
                                 } else if(var0 == 4107) {
                                    Timer.scriptStringStackSize -= 2;
                                    int[] var72 = class83.intStack;
                                    var59 = ++class83.intStackSize - 1;
                                    String var33 = class83.scriptStringStack[Timer.scriptStringStackSize];
                                    var25 = class83.scriptStringStack[Timer.scriptStringStackSize + 1];
                                    var28 = Client.languageId;
                                    int var29 = var33.length();
                                    var11 = var25.length();
                                    var12 = 0;
                                    var13 = 0;
                                    char var14 = 0;
                                    char var51 = 0;

                                    label1808:
                                    while(true) {
                                       if(var12 - var14 >= var29 && var13 - var51 >= var11) {
                                          var16 = Math.min(var29, var11);

                                          char var19;
                                          for(var17 = 0; var17 < var16; ++var17) {
                                             char var18 = var33.charAt(var17);
                                             var19 = var25.charAt(var17);
                                             if(var18 != var19 && Character.toUpperCase(var18) != Character.toUpperCase(var19)) {
                                                var18 = Character.toLowerCase(var18);
                                                var19 = Character.toLowerCase(var19);
                                                if(var19 != var18) {
                                                   var6 = class162.method3101(var18, var28) - class162.method3101(var19, var28);
                                                   break label1808;
                                                }
                                             }
                                          }

                                          var17 = var29 - var11;
                                          if(var17 != 0) {
                                             var6 = var17;
                                             break;
                                          }

                                          for(int var57 = 0; var57 < var16; ++var57) {
                                             var19 = var33.charAt(var57);
                                             char var20 = var25.charAt(var57);
                                             if(var19 != var20) {
                                                var6 = class162.method3101(var19, var28) - class162.method3101(var20, var28);
                                                break label1808;
                                             }
                                          }

                                          var6 = 0;
                                          break;
                                       }

                                       if(var12 - var14 >= var29) {
                                          var6 = -1;
                                          break;
                                       }

                                       if(var13 - var51 >= var11) {
                                          var6 = 1;
                                          break;
                                       }

                                       char var53;
                                       if(var14 != 0) {
                                          var53 = var14;
                                          boolean var48 = false;
                                       } else {
                                          var53 = var33.charAt(var12++);
                                       }

                                       char var56;
                                       if(var51 != 0) {
                                          var56 = var51;
                                          boolean var52 = false;
                                       } else {
                                          var56 = var25.charAt(var13++);
                                       }

                                       var14 = class10.method49(var53);
                                       var51 = class10.method49(var56);
                                       var53 = DynamicObject.method1869(var53, var28);
                                       var56 = DynamicObject.method1869(var56, var28);
                                       if(var53 != var56 && Character.toUpperCase(var53) != Character.toUpperCase(var56)) {
                                          var53 = Character.toLowerCase(var53);
                                          var56 = Character.toLowerCase(var56);
                                          if(var53 != var56) {
                                             var6 = class162.method3101(var53, var28) - class162.method3101(var56, var28);
                                             break;
                                          }
                                       }
                                    }

                                    var72[var59] = PacketBuffer.method3459(var6);
                                    var3 = 1;
                                 } else {
                                    byte[] var35;
                                    Font var65;
                                    if(var0 == 4108) {
                                       var66 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                                       class83.intStackSize -= 2;
                                       var59 = class83.intStack[class83.intStackSize];
                                       var6 = class83.intStack[class83.intStackSize + 1];
                                       var35 = IndexFile.field2256.getConfigData(var6, 0);
                                       var65 = new Font(var35);
                                       class83.intStack[++class83.intStackSize - 1] = var65.method4791(var66, var59);
                                       var3 = 1;
                                    } else if(var0 == 4109) {
                                       var66 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                                       class83.intStackSize -= 2;
                                       var59 = class83.intStack[class83.intStackSize];
                                       var6 = class83.intStack[class83.intStackSize + 1];
                                       var35 = IndexFile.field2256.getConfigData(var6, 0);
                                       var65 = new Font(var35);
                                       class83.intStack[++class83.intStackSize - 1] = var65.method4766(var66, var59);
                                       var3 = 1;
                                    } else if(var0 == 4110) {
                                       Timer.scriptStringStackSize -= 2;
                                       var66 = class83.scriptStringStack[Timer.scriptStringStackSize];
                                       var32 = class83.scriptStringStack[Timer.scriptStringStackSize + 1];
                                       if(class83.intStack[--class83.intStackSize] == 1) {
                                          class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var66;
                                       } else {
                                          class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var32;
                                       }

                                       var3 = 1;
                                    } else if(var0 == 4111) {
                                       var66 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                                       class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = FontTypeFace.appendTags(var66);
                                       var3 = 1;
                                    } else if(var0 == 4112) {
                                       var66 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                                       var59 = class83.intStack[--class83.intStackSize];
                                       class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var66 + (char)var59;
                                       var3 = 1;
                                    } else {
                                       char var38;
                                       if(var0 == 4113) {
                                          var4 = class83.intStack[--class83.intStackSize];
                                          int[] var49 = class83.intStack;
                                          var6 = ++class83.intStackSize - 1;
                                          var38 = (char)var4;
                                          if(var38 >= 32 && var38 <= 126) {
                                             var24 = true;
                                          } else if(var38 >= 160 && var38 <= 255) {
                                             var24 = true;
                                          } else if(var38 != 8364 && var38 != 338 && var38 != 8212 && var38 != 339 && var38 != 376) {
                                             var24 = false;
                                          } else {
                                             var24 = true;
                                          }

                                          var49[var6] = var24?1:0;
                                          var3 = 1;
                                       } else if(var0 == 4114) {
                                          var4 = class83.intStack[--class83.intStackSize];
                                          class83.intStack[++class83.intStackSize - 1] = Player.method1165((char)var4)?1:0;
                                          var3 = 1;
                                       } else if(var0 == 4115) {
                                          var4 = class83.intStack[--class83.intStackSize];
                                          class83.intStack[++class83.intStackSize - 1] = class236.method4200((char)var4)?1:0;
                                          var3 = 1;
                                       } else if(var0 == 4116) {
                                          var4 = class83.intStack[--class83.intStackSize];
                                          class83.intStack[++class83.intStackSize - 1] = IndexFile.method3055((char)var4)?1:0;
                                          var3 = 1;
                                       } else if(var0 == 4117) {
                                          var66 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                                          if(var66 != null) {
                                             class83.intStack[++class83.intStackSize - 1] = var66.length();
                                          } else {
                                             class83.intStack[++class83.intStackSize - 1] = 0;
                                          }

                                          var3 = 1;
                                       } else if(var0 == 4118) {
                                          var66 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                                          class83.intStackSize -= 2;
                                          var59 = class83.intStack[class83.intStackSize];
                                          var6 = class83.intStack[class83.intStackSize + 1];
                                          class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var66.substring(var59, var6);
                                          var3 = 1;
                                       } else if(var0 == 4119) {
                                          var66 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                                          StringBuilder var50 = new StringBuilder(var66.length());
                                          boolean var45 = false;

                                          for(var60 = 0; var60 < var66.length(); ++var60) {
                                             var38 = var66.charAt(var60);
                                             if(var38 == 60) {
                                                var45 = true;
                                             } else if(var38 == 62) {
                                                var45 = false;
                                             } else if(!var45) {
                                                var50.append(var38);
                                             }
                                          }

                                          class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var50.toString();
                                          var3 = 1;
                                       } else if(var0 == 4120) {
                                          var66 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                                          var59 = class83.intStack[--class83.intStackSize];
                                          class83.intStack[++class83.intStackSize - 1] = var66.indexOf(var59);
                                          var3 = 1;
                                       } else if(var0 == 4121) {
                                          Timer.scriptStringStackSize -= 2;
                                          var66 = class83.scriptStringStack[Timer.scriptStringStackSize];
                                          var32 = class83.scriptStringStack[Timer.scriptStringStackSize + 1];
                                          var6 = class83.intStack[--class83.intStackSize];
                                          class83.intStack[++class83.intStackSize - 1] = var66.indexOf(var32, var6);
                                          var3 = 1;
                                       } else {
                                          var3 = 2;
                                       }
                                    }
                                 }
                              }
                           }

                           return var3;
                        } else if(var0 < 4300) {
                           if(var0 == 4200) {
                              var4 = class83.intStack[--class83.intStackSize];
                              class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = Friend.getItemDefinition(var4).name;
                              var3 = 1;
                           } else {
                              ItemComposition var67;
                              if(var0 == 4201) {
                                 class83.intStackSize -= 2;
                                 var4 = class83.intStack[class83.intStackSize];
                                 var59 = class83.intStack[class83.intStackSize + 1];
                                 var67 = Friend.getItemDefinition(var4);
                                 if(var59 >= 1 && var59 <= 5 && var67.groundActions[var59 - 1] != null) {
                                    class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var67.groundActions[var59 - 1];
                                 } else {
                                    class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
                                 }

                                 var3 = 1;
                              } else if(var0 == 4202) {
                                 class83.intStackSize -= 2;
                                 var4 = class83.intStack[class83.intStackSize];
                                 var59 = class83.intStack[class83.intStackSize + 1];
                                 var67 = Friend.getItemDefinition(var4);
                                 if(var59 >= 1 && var59 <= 5 && var67.inventoryActions[var59 - 1] != null) {
                                    class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var67.inventoryActions[var59 - 1];
                                 } else {
                                    class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
                                 }

                                 var3 = 1;
                              } else if(var0 == 4203) {
                                 var4 = class83.intStack[--class83.intStackSize];
                                 class83.intStack[++class83.intStackSize - 1] = Friend.getItemDefinition(var4).price;
                                 var3 = 1;
                              } else if(var0 == 4204) {
                                 var4 = class83.intStack[--class83.intStackSize];
                                 class83.intStack[++class83.intStackSize - 1] = Friend.getItemDefinition(var4).isStackable == 1?1:0;
                                 var3 = 1;
                              } else {
                                 ItemComposition var47;
                                 if(var0 == 4205) {
                                    var4 = class83.intStack[--class83.intStackSize];
                                    var47 = Friend.getItemDefinition(var4);
                                    if(var47.notedTemplate == -1 && var47.note >= 0) {
                                       class83.intStack[++class83.intStackSize - 1] = var47.note;
                                    } else {
                                       class83.intStack[++class83.intStackSize - 1] = var4;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 4206) {
                                    var4 = class83.intStack[--class83.intStackSize];
                                    var47 = Friend.getItemDefinition(var4);
                                    if(var47.notedTemplate >= 0 && var47.note >= 0) {
                                       class83.intStack[++class83.intStackSize - 1] = var47.note;
                                    } else {
                                       class83.intStack[++class83.intStackSize - 1] = var4;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 4207) {
                                    var4 = class83.intStack[--class83.intStackSize];
                                    class83.intStack[++class83.intStackSize - 1] = Friend.getItemDefinition(var4).isMembers?1:0;
                                    var3 = 1;
                                 } else if(var0 == 4208) {
                                    var4 = class83.intStack[--class83.intStackSize];
                                    var47 = Friend.getItemDefinition(var4);
                                    if(var47.field3520 == -1 && var47.field3519 >= 0) {
                                       class83.intStack[++class83.intStackSize - 1] = var47.field3519;
                                    } else {
                                       class83.intStack[++class83.intStackSize - 1] = var4;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 4209) {
                                    var4 = class83.intStack[--class83.intStackSize];
                                    var47 = Friend.getItemDefinition(var4);
                                    if(var47.field3520 >= 0 && var47.field3519 >= 0) {
                                       class83.intStack[++class83.intStackSize - 1] = var47.field3519;
                                    } else {
                                       class83.intStack[++class83.intStackSize - 1] = var4;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 4210) {
                                    var66 = class83.scriptStringStack[--Timer.scriptStringStackSize];
                                    var59 = class83.intStack[--class83.intStackSize];
                                    WorldMapData.method337(var66, var59 == 1);
                                    class83.intStack[++class83.intStackSize - 1] = GameEngine.field695;
                                    var3 = 1;
                                 } else if(var0 == 4211) {
                                    if(class28.field392 != null && KitDefinition.field3341 < GameEngine.field695) {
                                       class83.intStack[++class83.intStackSize - 1] = class28.field392[++KitDefinition.field3341 - 1] & '\uffff';
                                    } else {
                                       class83.intStack[++class83.intStackSize - 1] = -1;
                                    }

                                    var3 = 1;
                                 } else if(var0 == 4212) {
                                    KitDefinition.field3341 = 0;
                                    var3 = 1;
                                 } else {
                                    var3 = 2;
                                 }
                              }
                           }

                           return var3;
                        } else if(var0 < 5100) {
                           return class2.method2(var0, var1, var2);
                        } else if(var0 < 5400) {
                           if(var0 == 5306) {
                              class83.intStack[++class83.intStackSize - 1] = class10.method52();
                              var3 = 1;
                           } else if(var0 == 5307) {
                              var4 = class83.intStack[--class83.intStackSize];
                              if(var4 == 1 || var4 == 2) {
                                 class15.method93(var4);
                              }

                              var3 = 1;
                           } else if(var0 == 5308) {
                              class83.intStack[++class83.intStackSize - 1] = class170.preferences.screenType;
                              var3 = 1;
                           } else if(var0 == 5309) {
                              var4 = class83.intStack[--class83.intStackSize];
                              if(var4 == 1 || var4 == 2) {
                                 class170.preferences.screenType = var4;
                                 Projectile.method1762();
                              }

                              var3 = 1;
                           } else {
                              var3 = 2;
                           }

                           return var3;
                        } else if(var0 < 5600) {
                           return class20.method143(var0, var1, var2);
                        } else if(var0 < 5700) {
                           return Friend.method1105(var0, var1, var2);
                        } else if(var0 < 6300) {
                           if(var0 == 6200) {
                              class83.intStackSize -= 2;
                              Client.field1070 = (short)class83.intStack[class83.intStackSize];
                              if(Client.field1070 <= 0) {
                                 Client.field1070 = 256;
                              }

                              Client.field1000 = (short)class83.intStack[class83.intStackSize + 1];
                              if(Client.field1000 <= 0) {
                                 Client.field1000 = 205;
                              }

                              var3 = 1;
                           } else if(var0 == 6201) {
                              class83.intStackSize -= 2;
                              Client.field1138 = (short)class83.intStack[class83.intStackSize];
                              if(Client.field1138 <= 0) {
                                 Client.field1138 = 256;
                              }

                              Client.field1017 = (short)class83.intStack[class83.intStackSize + 1];
                              if(Client.field1017 <= 0) {
                                 Client.field1017 = 320;
                              }

                              var3 = 1;
                           } else if(var0 == 6202) {
                              class83.intStackSize -= 4;
                              Client.field1140 = (short)class83.intStack[class83.intStackSize];
                              if(Client.field1140 <= 0) {
                                 Client.field1140 = 1;
                              }

                              Client.field1141 = (short)class83.intStack[class83.intStackSize + 1];
                              if(Client.field1141 <= 0) {
                                 Client.field1141 = 32767;
                              } else if(Client.field1141 < Client.field1140) {
                                 Client.field1141 = Client.field1140;
                              }

                              Client.field1137 = (short)class83.intStack[class83.intStackSize + 2];
                              if(Client.field1137 <= 0) {
                                 Client.field1137 = 1;
                              }

                              Client.field1143 = (short)class83.intStack[class83.intStackSize + 3];
                              if(Client.field1143 <= 0) {
                                 Client.field1143 = 32767;
                              } else if(Client.field1143 < Client.field1137) {
                                 Client.field1143 = Client.field1137;
                              }

                              var3 = 1;
                           } else if(var0 == 6203) {
                              if(Client.field1055 != null) {
                                 Varcs.method1833(0, 0, Client.field1055.width, Client.field1055.height, false);
                                 class83.intStack[++class83.intStackSize - 1] = Client.viewportHeight;
                                 class83.intStack[++class83.intStackSize - 1] = Client.viewportWidth;
                              } else {
                                 class83.intStack[++class83.intStackSize - 1] = -1;
                                 class83.intStack[++class83.intStackSize - 1] = -1;
                              }

                              var3 = 1;
                           } else if(var0 == 6204) {
                              class83.intStack[++class83.intStackSize - 1] = Client.field1138;
                              class83.intStack[++class83.intStackSize - 1] = Client.field1017;
                              var3 = 1;
                           } else if(var0 == 6205) {
                              class83.intStack[++class83.intStackSize - 1] = Client.field1070;
                              class83.intStack[++class83.intStackSize - 1] = Client.field1000;
                              var3 = 1;
                           } else {
                              var3 = 2;
                           }

                           return var3;
                        } else {
                           boolean var22;
                           if(var0 >= 6600) {
                              if(var0 < 6700) {
                                 if(var0 == 6600) {
                                    var4 = class8.plane;
                                    var59 = (class224.localPlayer.x >> 7) + class33.baseX;
                                    var6 = (class224.localPlayer.y >> 7) + class17.baseY;
                                    class14.method80().method5202(var4, var59, var6, true);
                                    var3 = 1;
                                 } else {
                                    WorldMapData var61;
                                    if(var0 == 6601) {
                                       var4 = class83.intStack[--class83.intStackSize];
                                       var32 = "";
                                       var61 = class14.method80().method5218(var4);
                                       if(var61 != null) {
                                          var32 = var61.method286();
                                       }

                                       class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var32;
                                       var3 = 1;
                                    } else if(var0 == 6602) {
                                       var4 = class83.intStack[--class83.intStackSize];
                                       class14.method80().method5203(var4);
                                       var3 = 1;
                                    } else if(var0 == 6603) {
                                       class83.intStack[++class83.intStackSize - 1] = class14.method80().method5215();
                                       var3 = 1;
                                    } else if(var0 == 6604) {
                                       var4 = class83.intStack[--class83.intStackSize];
                                       class14.method80().method5212(var4);
                                       var3 = 1;
                                    } else if(var0 == 6605) {
                                       class83.intStack[++class83.intStackSize - 1] = class14.method80().method5193()?1:0;
                                       var3 = 1;
                                    } else {
                                       Coordinates var58;
                                       if(var0 == 6606) {
                                          var58 = new Coordinates(class83.intStack[--class83.intStackSize]);
                                          class14.method80().method5219(var58.worldX, var58.worldY);
                                          var3 = 1;
                                       } else if(var0 == 6607) {
                                          var58 = new Coordinates(class83.intStack[--class83.intStackSize]);
                                          class14.method80().method5220(var58.worldX, var58.worldY);
                                          var3 = 1;
                                       } else if(var0 == 6608) {
                                          var58 = new Coordinates(class83.intStack[--class83.intStackSize]);
                                          class14.method80().method5221(var58.plane, var58.worldX, var58.worldY);
                                          var3 = 1;
                                       } else if(var0 == 6609) {
                                          var58 = new Coordinates(class83.intStack[--class83.intStackSize]);
                                          class14.method80().method5222(var58.plane, var58.worldX, var58.worldY);
                                          var3 = 1;
                                       } else if(var0 == 6610) {
                                          class83.intStack[++class83.intStackSize - 1] = class14.method80().method5223();
                                          class83.intStack[++class83.intStackSize - 1] = class14.method80().method5347();
                                          var3 = 1;
                                       } else {
                                          WorldMapData var34;
                                          if(var0 == 6611) {
                                             var4 = class83.intStack[--class83.intStackSize];
                                             var34 = class14.method80().method5218(var4);
                                             if(var34 == null) {
                                                class83.intStack[++class83.intStackSize - 1] = 0;
                                             } else {
                                                class83.intStack[++class83.intStackSize - 1] = var34.method318().method3941();
                                             }

                                             var3 = 1;
                                          } else if(var0 == 6612) {
                                             var4 = class83.intStack[--class83.intStackSize];
                                             var34 = class14.method80().method5218(var4);
                                             if(var34 == null) {
                                                class83.intStack[++class83.intStackSize - 1] = 0;
                                                class83.intStack[++class83.intStackSize - 1] = 0;
                                             } else {
                                                class83.intStack[++class83.intStackSize - 1] = (var34.method290() - var34.method289() + 1) * 64;
                                                class83.intStack[++class83.intStackSize - 1] = (var34.method276() - var34.method319() + 1) * 64;
                                             }

                                             var3 = 1;
                                          } else if(var0 == 6613) {
                                             var4 = class83.intStack[--class83.intStackSize];
                                             var34 = class14.method80().method5218(var4);
                                             if(var34 == null) {
                                                class83.intStack[++class83.intStackSize - 1] = 0;
                                                class83.intStack[++class83.intStackSize - 1] = 0;
                                                class83.intStack[++class83.intStackSize - 1] = 0;
                                                class83.intStack[++class83.intStackSize - 1] = 0;
                                             } else {
                                                class83.intStack[++class83.intStackSize - 1] = var34.method289() * 64;
                                                class83.intStack[++class83.intStackSize - 1] = var34.method319() * 64;
                                                class83.intStack[++class83.intStackSize - 1] = var34.method290() * 64 + 64 - 1;
                                                class83.intStack[++class83.intStackSize - 1] = var34.method276() * 64 + 64 - 1;
                                             }

                                             var3 = 1;
                                          } else if(var0 == 6614) {
                                             var4 = class83.intStack[--class83.intStackSize];
                                             var34 = class14.method80().method5218(var4);
                                             if(var34 == null) {
                                                class83.intStack[++class83.intStackSize - 1] = -1;
                                             } else {
                                                class83.intStack[++class83.intStackSize - 1] = var34.method288();
                                             }

                                             var3 = 1;
                                          } else if(var0 == 6615) {
                                             var58 = class14.method80().method5282();
                                             if(var58 == null) {
                                                class83.intStack[++class83.intStackSize - 1] = -1;
                                                class83.intStack[++class83.intStackSize - 1] = -1;
                                             } else {
                                                class83.intStack[++class83.intStackSize - 1] = var58.worldX;
                                                class83.intStack[++class83.intStackSize - 1] = var58.worldY;
                                             }

                                             var3 = 1;
                                          } else if(var0 == 6616) {
                                             class83.intStack[++class83.intStackSize - 1] = class14.method80().method5204();
                                             var3 = 1;
                                          } else if(var0 == 6617) {
                                             var58 = new Coordinates(class83.intStack[--class83.intStackSize]);
                                             var34 = class14.method80().method5342();
                                             if(var34 == null) {
                                                class83.intStack[++class83.intStackSize - 1] = -1;
                                                class83.intStack[++class83.intStackSize - 1] = -1;
                                                var3 = 1;
                                             } else {
                                                var62 = var34.method280(var58.plane, var58.worldX, var58.worldY);
                                                if(var62 == null) {
                                                   class83.intStack[++class83.intStackSize - 1] = -1;
                                                   class83.intStack[++class83.intStackSize - 1] = -1;
                                                } else {
                                                   class83.intStack[++class83.intStackSize - 1] = var62[0];
                                                   class83.intStack[++class83.intStackSize - 1] = var62[1];
                                                }

                                                var3 = 1;
                                             }
                                          } else {
                                             Coordinates var63;
                                             if(var0 == 6618) {
                                                var58 = new Coordinates(class83.intStack[--class83.intStackSize]);
                                                var34 = class14.method80().method5342();
                                                if(var34 == null) {
                                                   class83.intStack[++class83.intStackSize - 1] = -1;
                                                   class83.intStack[++class83.intStackSize - 1] = -1;
                                                   var3 = 1;
                                                } else {
                                                   var63 = var34.method281(var58.worldX, var58.worldY);
                                                   if(var63 == null) {
                                                      class83.intStack[++class83.intStackSize - 1] = -1;
                                                   } else {
                                                      class83.intStack[++class83.intStackSize - 1] = var63.method3941();
                                                   }

                                                   var3 = 1;
                                                }
                                             } else {
                                                Coordinates var39;
                                                if(var0 == 6619) {
                                                   class83.intStackSize -= 2;
                                                   var4 = class83.intStack[class83.intStackSize];
                                                   var39 = new Coordinates(class83.intStack[class83.intStackSize + 1]);
                                                   class238.method4243(var4, var39, false);
                                                   var3 = 1;
                                                } else if(var0 == 6620) {
                                                   class83.intStackSize -= 2;
                                                   var4 = class83.intStack[class83.intStackSize];
                                                   var39 = new Coordinates(class83.intStack[class83.intStackSize + 1]);
                                                   class238.method4243(var4, var39, true);
                                                   var3 = 1;
                                                } else if(var0 == 6621) {
                                                   class83.intStackSize -= 2;
                                                   var4 = class83.intStack[class83.intStackSize];
                                                   var39 = new Coordinates(class83.intStack[class83.intStackSize + 1]);
                                                   var61 = class14.method80().method5218(var4);
                                                   if(var61 == null) {
                                                      class83.intStack[++class83.intStackSize - 1] = 0;
                                                      var3 = 1;
                                                   } else {
                                                      class83.intStack[++class83.intStackSize - 1] = var61.method278(var39.plane, var39.worldX, var39.worldY)?1:0;
                                                      var3 = 1;
                                                   }
                                                } else if(var0 == 6622) {
                                                   class83.intStack[++class83.intStackSize - 1] = class14.method80().method5226();
                                                   class83.intStack[++class83.intStackSize - 1] = class14.method80().method5227();
                                                   var3 = 1;
                                                } else if(var0 == 6623) {
                                                   var58 = new Coordinates(class83.intStack[--class83.intStackSize]);
                                                   var34 = class14.method80().method5264(var58.plane, var58.worldX, var58.worldY);
                                                   if(var34 == null) {
                                                      class83.intStack[++class83.intStackSize - 1] = -1;
                                                   } else {
                                                      class83.intStack[++class83.intStackSize - 1] = var34.method275();
                                                   }

                                                   var3 = 1;
                                                } else if(var0 == 6624) {
                                                   class14.method80().method5228(class83.intStack[--class83.intStackSize]);
                                                   var3 = 1;
                                                } else if(var0 == 6625) {
                                                   class14.method80().method5335();
                                                   var3 = 1;
                                                } else if(var0 == 6626) {
                                                   class14.method80().method5198(class83.intStack[--class83.intStackSize]);
                                                   var3 = 1;
                                                } else if(var0 == 6627) {
                                                   class14.method80().method5280();
                                                   var3 = 1;
                                                } else {
                                                   boolean var42;
                                                   if(var0 == 6628) {
                                                      var42 = class83.intStack[--class83.intStackSize] == 1;
                                                      class14.method80().method5232(var42);
                                                      var3 = 1;
                                                   } else if(var0 == 6629) {
                                                      var4 = class83.intStack[--class83.intStackSize];
                                                      class14.method80().method5370(var4);
                                                      var3 = 1;
                                                   } else if(var0 == 6630) {
                                                      var4 = class83.intStack[--class83.intStackSize];
                                                      class14.method80().method5234(var4);
                                                      var3 = 1;
                                                   } else if(var0 == 6631) {
                                                      class14.method80().method5235();
                                                      var3 = 1;
                                                   } else if(var0 == 6632) {
                                                      var42 = class83.intStack[--class83.intStackSize] == 1;
                                                      class14.method80().method5241(var42);
                                                      var3 = 1;
                                                   } else if(var0 == 6633) {
                                                      class83.intStackSize -= 2;
                                                      var4 = class83.intStack[class83.intStackSize];
                                                      var22 = class83.intStack[class83.intStackSize + 1] == 1;
                                                      class14.method80().method5237(var4, var22);
                                                      var3 = 1;
                                                   } else if(var0 == 6634) {
                                                      class83.intStackSize -= 2;
                                                      var4 = class83.intStack[class83.intStackSize];
                                                      var22 = class83.intStack[class83.intStackSize + 1] == 1;
                                                      class14.method80().method5238(var4, var22);
                                                      var3 = 1;
                                                   } else if(var0 == 6635) {
                                                      class83.intStack[++class83.intStackSize - 1] = class14.method80().method5239()?1:0;
                                                      var3 = 1;
                                                   } else if(var0 == 6636) {
                                                      var4 = class83.intStack[--class83.intStackSize];
                                                      class83.intStack[++class83.intStackSize - 1] = class14.method80().method5327(var4)?1:0;
                                                      var3 = 1;
                                                   } else if(var0 == 6637) {
                                                      var4 = class83.intStack[--class83.intStackSize];
                                                      class83.intStack[++class83.intStackSize - 1] = class14.method80().method5208(var4)?1:0;
                                                      var3 = 1;
                                                   } else if(var0 == 6638) {
                                                      class83.intStackSize -= 2;
                                                      var4 = class83.intStack[class83.intStackSize];
                                                      var39 = new Coordinates(class83.intStack[class83.intStackSize + 1]);
                                                      var63 = class14.method80().method5244(var4, var39);
                                                      if(var63 == null) {
                                                         class83.intStack[++class83.intStackSize - 1] = -1;
                                                      } else {
                                                         class83.intStack[++class83.intStackSize - 1] = var63.method3941();
                                                      }

                                                      var3 = 1;
                                                   } else {
                                                      class39 var64;
                                                      if(var0 == 6639) {
                                                         var64 = class14.method80().method5205();
                                                         if(var64 == null) {
                                                            class83.intStack[++class83.intStackSize - 1] = -1;
                                                            class83.intStack[++class83.intStackSize - 1] = -1;
                                                         } else {
                                                            class83.intStack[++class83.intStackSize - 1] = var64.field505;
                                                            class83.intStack[++class83.intStackSize - 1] = var64.field504.method3941();
                                                         }

                                                         var3 = 1;
                                                      } else if(var0 == 6640) {
                                                         var64 = class14.method80().method5247();
                                                         if(var64 == null) {
                                                            class83.intStack[++class83.intStackSize - 1] = -1;
                                                            class83.intStack[++class83.intStackSize - 1] = -1;
                                                         } else {
                                                            class83.intStack[++class83.intStackSize - 1] = var64.field505;
                                                            class83.intStack[++class83.intStackSize - 1] = var64.field504.method3941();
                                                         }

                                                         var3 = 1;
                                                      } else {
                                                         Area var44;
                                                         if(var0 == 6693) {
                                                            var4 = class83.intStack[--class83.intStackSize];
                                                            var44 = Area.field3286[var4];
                                                            if(var44.name == null) {
                                                               class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
                                                            } else {
                                                               class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var44.name;
                                                            }

                                                            var3 = 1;
                                                         } else if(var0 == 6694) {
                                                            var4 = class83.intStack[--class83.intStackSize];
                                                            var44 = Area.field3286[var4];
                                                            class83.intStack[++class83.intStackSize - 1] = var44.field3283;
                                                            var3 = 1;
                                                         } else if(var0 == 6695) {
                                                            var4 = class83.intStack[--class83.intStackSize];
                                                            var44 = Area.field3286[var4];
                                                            if(var44 == null) {
                                                               class83.intStack[++class83.intStackSize - 1] = -1;
                                                            } else {
                                                               class83.intStack[++class83.intStackSize - 1] = var44.field3295;
                                                            }

                                                            var3 = 1;
                                                         } else if(var0 == 6696) {
                                                            var4 = class83.intStack[--class83.intStackSize];
                                                            var44 = Area.field3286[var4];
                                                            if(var44 == null) {
                                                               class83.intStack[++class83.intStackSize - 1] = -1;
                                                            } else {
                                                               class83.intStack[++class83.intStackSize - 1] = var44.spriteId;
                                                            }

                                                            var3 = 1;
                                                         } else if(var0 == 6697) {
                                                            class83.intStack[++class83.intStackSize - 1] = class41.field519.field568;
                                                            var3 = 1;
                                                         } else if(var0 == 6698) {
                                                            class83.intStack[++class83.intStackSize - 1] = class41.field519.field565.method3941();
                                                            var3 = 1;
                                                         } else if(var0 == 6699) {
                                                            class83.intStack[++class83.intStackSize - 1] = class41.field519.field569.method3941();
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
                              if(var0 == 6500) {
                                 class83.intStack[++class83.intStackSize - 1] = class87.loadWorlds()?1:0;
                                 var3 = 1;
                              } else {
                                 World var21;
                                 if(var0 == 6501) {
                                    var21 = Friend.method1106();
                                    if(var21 != null) {
                                       class83.intStack[++class83.intStackSize - 1] = var21.id;
                                       class83.intStack[++class83.intStackSize - 1] = var21.mask;
                                       class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var21.activity;
                                       class83.intStack[++class83.intStackSize - 1] = var21.location;
                                       class83.intStack[++class83.intStackSize - 1] = var21.playerCount;
                                       class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var21.address;
                                    } else {
                                       class83.intStack[++class83.intStackSize - 1] = -1;
                                       class83.intStack[++class83.intStackSize - 1] = 0;
                                       class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
                                       class83.intStack[++class83.intStackSize - 1] = 0;
                                       class83.intStack[++class83.intStackSize - 1] = 0;
                                       class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
                                    }

                                    var3 = 1;
                                 } else if(var0 == 6502) {
                                    if(World.field1261 < World.worldCount) {
                                       var21 = World.worldList[++World.field1261 - 1];
                                    } else {
                                       var21 = null;
                                    }

                                    if(var21 != null) {
                                       class83.intStack[++class83.intStackSize - 1] = var21.id;
                                       class83.intStack[++class83.intStackSize - 1] = var21.mask;
                                       class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var21.activity;
                                       class83.intStack[++class83.intStackSize - 1] = var21.location;
                                       class83.intStack[++class83.intStackSize - 1] = var21.playerCount;
                                       class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var21.address;
                                    } else {
                                       class83.intStack[++class83.intStackSize - 1] = -1;
                                       class83.intStack[++class83.intStackSize - 1] = 0;
                                       class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
                                       class83.intStack[++class83.intStackSize - 1] = 0;
                                       class83.intStack[++class83.intStackSize - 1] = 0;
                                       class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
                                    }

                                    var3 = 1;
                                 } else {
                                    World var5;
                                    if(var0 == 6506) {
                                       var4 = class83.intStack[--class83.intStackSize];
                                       var5 = null;

                                       for(var6 = 0; var6 < World.worldCount; ++var6) {
                                          if(var4 == World.worldList[var6].id) {
                                             var5 = World.worldList[var6];
                                             break;
                                          }
                                       }

                                       if(var5 != null) {
                                          class83.intStack[++class83.intStackSize - 1] = var5.id;
                                          class83.intStack[++class83.intStackSize - 1] = var5.mask;
                                          class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var5.activity;
                                          class83.intStack[++class83.intStackSize - 1] = var5.location;
                                          class83.intStack[++class83.intStackSize - 1] = var5.playerCount;
                                          class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var5.address;
                                       } else {
                                          class83.intStack[++class83.intStackSize - 1] = -1;
                                          class83.intStack[++class83.intStackSize - 1] = 0;
                                          class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
                                          class83.intStack[++class83.intStackSize - 1] = 0;
                                          class83.intStack[++class83.intStackSize - 1] = 0;
                                          class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
                                       }

                                       var3 = 1;
                                    } else if(var0 == 6507) {
                                       class83.intStackSize -= 4;
                                       var4 = class83.intStack[class83.intStackSize];
                                       var22 = 1 == class83.intStack[class83.intStackSize + 1];
                                       var6 = class83.intStack[class83.intStackSize + 2];
                                       var24 = class83.intStack[class83.intStackSize + 3] == 1;
                                       class7.method35(var4, var22, var6, var24);
                                       var3 = 1;
                                    } else if(var0 == 6511) {
                                       var4 = class83.intStack[--class83.intStackSize];
                                       if(var4 >= 0 && var4 < World.worldCount) {
                                          var5 = World.worldList[var4];
                                          class83.intStack[++class83.intStackSize - 1] = var5.id;
                                          class83.intStack[++class83.intStackSize - 1] = var5.mask;
                                          class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var5.activity;
                                          class83.intStack[++class83.intStackSize - 1] = var5.location;
                                          class83.intStack[++class83.intStackSize - 1] = var5.playerCount;
                                          class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var5.address;
                                       } else {
                                          class83.intStack[++class83.intStackSize - 1] = -1;
                                          class83.intStack[++class83.intStackSize - 1] = 0;
                                          class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
                                          class83.intStack[++class83.intStackSize - 1] = 0;
                                          class83.intStack[++class83.intStackSize - 1] = 0;
                                          class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "";
                                       }

                                       var3 = 1;
                                    } else if(var0 == 6512) {
                                       Client.field1030 = class83.intStack[--class83.intStackSize] == 1;
                                       var3 = 1;
                                    } else {
                                       class251 var23;
                                       if(var0 == 6513) {
                                          class83.intStackSize -= 2;
                                          var4 = class83.intStack[class83.intStackSize];
                                          var59 = class83.intStack[class83.intStackSize + 1];
                                          var23 = Script.method1857(var59);
                                          if(var23.method4404()) {
                                             class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = class60.getNpcDefinition(var4).method4622(var59, var23.field3369);
                                          } else {
                                             class83.intStack[++class83.intStackSize - 1] = class60.getNpcDefinition(var4).method4621(var59, var23.field3371);
                                          }

                                          var3 = 1;
                                       } else if(var0 == 6514) {
                                          class83.intStackSize -= 2;
                                          var4 = class83.intStack[class83.intStackSize];
                                          var59 = class83.intStack[class83.intStackSize + 1];
                                          var23 = Script.method1857(var59);
                                          if(var23.method4404()) {
                                             class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = WidgetNode.getObjectDefinition(var4).method4536(var59, var23.field3369);
                                          } else {
                                             class83.intStack[++class83.intStackSize - 1] = WidgetNode.getObjectDefinition(var4).method4533(var59, var23.field3371);
                                          }

                                          var3 = 1;
                                       } else if(var0 == 6515) {
                                          class83.intStackSize -= 2;
                                          var4 = class83.intStack[class83.intStackSize];
                                          var59 = class83.intStack[class83.intStackSize + 1];
                                          var23 = Script.method1857(var59);
                                          if(var23.method4404()) {
                                             class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = Friend.getItemDefinition(var4).method4552(var59, var23.field3369);
                                          } else {
                                             class83.intStack[++class83.intStackSize - 1] = Friend.getItemDefinition(var4).method4551(var59, var23.field3371);
                                          }

                                          var3 = 1;
                                       } else if(var0 == 6516) {
                                          class83.intStackSize -= 2;
                                          var4 = class83.intStack[class83.intStackSize];
                                          var59 = class83.intStack[class83.intStackSize + 1];
                                          var23 = Script.method1857(var59);
                                          if(var23.method4404()) {
                                             String[] var7 = class83.scriptStringStack;
                                             var8 = ++Timer.scriptStringStackSize - 1;
                                             class252 var10 = (class252)class252.field3373.get((long)var4);
                                             class252 var9;
                                             if(var10 != null) {
                                                var9 = var10;
                                             } else {
                                                byte[] var31 = class95.field1464.getConfigData(34, var4);
                                                var10 = new class252();
                                                if(var31 != null) {
                                                   var10.method4425(new Buffer(var31));
                                                }

                                                var10.method4424();
                                                class252.field3373.put(var10, (long)var4);
                                                var9 = var10;
                                             }

                                             var7[var8] = var9.method4433(var59, var23.field3369);
                                          } else {
                                             class83.intStack[++class83.intStackSize - 1] = class12.method60(var4).method4428(var59, var23.field3371);
                                          }

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
}
