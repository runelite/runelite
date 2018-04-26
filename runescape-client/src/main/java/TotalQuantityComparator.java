import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
@Implements("TotalQuantityComparator")
final class TotalQuantityComparator implements Comparator {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   @Export("SpotAnimationDefinition_modelIndexCache")
   static IndexDataBase SpotAnimationDefinition_modelIndexCache;
   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   static JagexGame field296;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lp;Lp;I)I",
      garbageValue = "94217140"
   )
   int method92(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.totalQuantity < var2.grandExchangeOffer.totalQuantity?-1:(var2.grandExchangeOffer.totalQuantity == var1.grandExchangeOffer.totalQuantity?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method92((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIIB)V",
      garbageValue = "50"
   )
   static void method106(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method106(var0, var1, var2, var5 - 1);
         method106(var0, var1, var5 + 1, var3);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1551531619"
   )
   static void method108(boolean var0) {
      class90.loginMessage1 = "";
      class90.loginMessage2 = "Enter your username/email & password.";
      class90.loginMessage3 = "";
      class90.loginIndex = 2;
      if(var0) {
         class90.password = "";
      }

      ScriptState.method1129();
      UrlRequest.method3183();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-83"
   )
   public static boolean method104(int var0) {
      return var0 == WorldMapDecorationType.field2998.rsOrdinal;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-558175594"
   )
   public static void method91() {
      Area.areaSpriteCache.reset();
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-2108865004"
   )
   static final void method107(boolean var0) {
      for(int var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.npcIndices[var1]];
         int var3 = (Client.npcIndices[var1] << 14) + 536870912;
         if(var2 != null && var2.hasConfig() && var2.composition.isVisible == var0 && var2.composition.method5194()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field1143 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field948[var4][var5] == Client.field1093) {
                     continue;
                  }

                  Client.field948[var4][var5] = Client.field1093;
               }

               if(!var2.composition.field3739) {
                  var3 -= Integer.MIN_VALUE;
               }

               var2.field1144 = Client.gameCycle;
               GameSocket.region.method2958(ScriptVarType.plane, var2.x, var2.y, GrandExchangeEvent.getTileHeight(var2.field1143 * 64 - 64 + var2.x, var2.field1143 * 64 - 64 + var2.y, ScriptVarType.plane), var2.field1143 * 64 - 64 + 60, var2, var2.angle, var3, var2.field1142);
            }
         }
      }

   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "1"
   )
   static final void method105(int var0, int var1, int var2, int var3) {
      Client.overheadTextCount = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = -1;
      int var7 = class93.playerIndexesCount;
      int[] var8 = class93.playerIndices;

      int var9;
      for(var9 = 0; var9 < var7 + Client.npcIndexesCount; ++var9) {
         Object var10;
         if(var9 < var7) {
            var10 = Client.cachedPlayers[var8[var9]];
            if(var8[var9] == Client.field978) {
               var4 = true;
               var5 = var9;
               continue;
            }

            if(var10 == class265.localPlayer) {
               var6 = var9;
               continue;
            }
         } else {
            var10 = Client.cachedNPCs[Client.npcIndices[var9 - var7]];
         }

         MilliTimer.draw2DExtras((Actor)var10, var9, var0, var1, var2, var3);
      }

      if(Client.field928 && var6 != -1) {
         MilliTimer.draw2DExtras(class265.localPlayer, var6, var0, var1, var2, var3);
      }

      if(var4) {
         MilliTimer.draw2DExtras(Client.cachedPlayers[Client.field978], var5, var0, var1, var2, var3);
      }

      for(var9 = 0; var9 < Client.overheadTextCount; ++var9) {
         int var19 = Client.overheadTextsX[var9];
         int var11 = Client.overheadTextsY[var9];
         int var12 = Client.overheadTextsOffsetX[var9];
         int var13 = Client.overheadTextsOffsetY[var9];
         boolean var14 = true;

         while(var14) {
            var14 = false;

            for(int var15 = 0; var15 < var9; ++var15) {
               if(var11 + 2 > Client.overheadTextsY[var15] - Client.overheadTextsOffsetY[var15] && var11 - var13 < Client.overheadTextsY[var15] + 2 && var19 - var12 < Client.overheadTextsX[var15] + Client.overheadTextsOffsetX[var15] && var12 + var19 > Client.overheadTextsX[var15] - Client.overheadTextsOffsetX[var15] && Client.overheadTextsY[var15] - Client.overheadTextsOffsetY[var15] < var11) {
                  var11 = Client.overheadTextsY[var15] - Client.overheadTextsOffsetY[var15];
                  var14 = true;
               }
            }
         }

         Client.screenX = Client.overheadTextsX[var9];
         Client.screenY = Client.overheadTextsY[var9] = var11;
         String var20 = Client.overheadTexts[var9];
         if(Client.field1014 == 0) {
            int var16 = 16776960;
            if(Client.field944[var9] < 6) {
               var16 = Client.field1076[Client.field944[var9]];
            }

            if(Client.field944[var9] == 6) {
               var16 = Client.field1093 % 20 < 10?16711680:16776960;
            }

            if(Client.field944[var9] == 7) {
               var16 = Client.field1093 % 20 < 10?255:'\uffff';
            }

            if(Client.field944[var9] == 8) {
               var16 = Client.field1093 % 20 < 10?'뀀':8454016;
            }

            int var17;
            if(Client.field944[var9] == 9) {
               var17 = 150 - Client.overheadTextsCyclesRemaining[var9];
               if(var17 < 50) {
                  var16 = var17 * 1280 + 16711680;
               } else if(var17 < 100) {
                  var16 = 16776960 - (var17 - 50) * 327680;
               } else if(var17 < 150) {
                  var16 = (var17 - 100) * 5 + 65280;
               }
            }

            if(Client.field944[var9] == 10) {
               var17 = 150 - Client.overheadTextsCyclesRemaining[var9];
               if(var17 < 50) {
                  var16 = var17 * 5 + 16711680;
               } else if(var17 < 100) {
                  var16 = 16711935 - (var17 - 50) * 327680;
               } else if(var17 < 150) {
                  var16 = (var17 - 100) * 327680 + 255 - (var17 - 100) * 5;
               }
            }

            if(Client.field944[var9] == 11) {
               var17 = 150 - Client.overheadTextsCyclesRemaining[var9];
               if(var17 < 50) {
                  var16 = 16777215 - var17 * 327685;
               } else if(var17 < 100) {
                  var16 = (var17 - 50) * 327685 + 65280;
               } else if(var17 < 150) {
                  var16 = 16777215 - (var17 - 100) * 327680;
               }
            }

            if(Client.field945[var9] == 0) {
               class22.fontBold12.drawTextCentered(var20, var0 + Client.screenX, Client.screenY + var1, var16, 0);
            }

            if(Client.field945[var9] == 1) {
               class22.fontBold12.method5600(var20, var0 + Client.screenX, Client.screenY + var1, var16, 0, Client.field1093);
            }

            if(Client.field945[var9] == 2) {
               class22.fontBold12.method5576(var20, var0 + Client.screenX, Client.screenY + var1, var16, 0, Client.field1093);
            }

            if(Client.field945[var9] == 3) {
               class22.fontBold12.method5577(var20, var0 + Client.screenX, Client.screenY + var1, var16, 0, Client.field1093, 150 - Client.overheadTextsCyclesRemaining[var9]);
            }

            if(Client.field945[var9] == 4) {
               var17 = (150 - Client.overheadTextsCyclesRemaining[var9]) * (class22.fontBold12.getTextWidth(var20) + 100) / 150;
               Rasterizer2D.setInnerDrawRegion(var0 + Client.screenX - 50, var1, var0 + Client.screenX + 50, var3 + var1);
               class22.fontBold12.method5630(var20, var0 + Client.screenX + 50 - var17, Client.screenY + var1, var16, 0);
               Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
            }

            if(Client.field945[var9] == 5) {
               var17 = 150 - Client.overheadTextsCyclesRemaining[var9];
               int var18 = 0;
               if(var17 < 25) {
                  var18 = var17 - 25;
               } else if(var17 > 125) {
                  var18 = var17 - 125;
               }

               Rasterizer2D.setInnerDrawRegion(var0, Client.screenY + var1 - class22.fontBold12.verticalSpace - 1, var0 + var2, Client.screenY + var1 + 5);
               class22.fontBold12.drawTextCentered(var20, var0 + Client.screenX, var18 + Client.screenY + var1, var16, 0);
               Rasterizer2D.setDrawRegion(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            class22.fontBold12.drawTextCentered(var20, var0 + Client.screenX, Client.screenY + var1, 16776960, 0);
         }
      }

   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(Lje;IIII)V",
      garbageValue = "-2049884551"
   )
   static final void method101(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.transform();
         }

         if(var0 != null) {
            if(var0.field3739) {
               if(!var0.field3741 || Client.field1057 == var1) {
                  String var4 = var0.name;
                  if(var0.combatLevel != 0) {
                     var4 = var4 + GameCanvas.method843(var0.combatLevel, class265.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3741 && Client.field1111) {
                     class150.addMenuEntry("Examine", DynamicObject.getColTags(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.itemSelectionState == 1) {
                     class150.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + DynamicObject.getColTags(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.spellSelected) {
                     if((class49.field605 & 2) == 2) {
                        class150.addMenuEntry(Client.field1010, Client.field1063 + " " + "->" + " " + DynamicObject.getColTags(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var5 = var0.field3741 && Client.field1111?2000:0;
                     String[] var6 = var0.actions;
                     int var7;
                     int var8;
                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var6[var7] != null && !var6[var7].equalsIgnoreCase("Attack")) {
                              var8 = 0;
                              if(var7 == 0) {
                                 var8 = var5 + 9;
                              }

                              if(var7 == 1) {
                                 var8 = var5 + 10;
                              }

                              if(var7 == 2) {
                                 var8 = var5 + 11;
                              }

                              if(var7 == 3) {
                                 var8 = var5 + 12;
                              }

                              if(var7 == 4) {
                                 var8 = var5 + 13;
                              }

                              class150.addMenuEntry(var6[var7], DynamicObject.getColTags(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var6[var7] != null && var6[var7].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(Client.npcAttackOption != AttackOption.AttackOption_hidden) {
                                 if(AttackOption.AttackOption_alwaysRightClick == Client.npcAttackOption || Client.npcAttackOption == AttackOption.AttackOption_dependsOnCombatLevels && var0.combatLevel > class265.localPlayer.combatLevel) {
                                    var9 = 2000;
                                 }

                                 var8 = 0;
                                 if(var7 == 0) {
                                    var8 = var9 + 9;
                                 }

                                 if(var7 == 1) {
                                    var8 = var9 + 10;
                                 }

                                 if(var7 == 2) {
                                    var8 = var9 + 11;
                                 }

                                 if(var7 == 3) {
                                    var8 = var9 + 12;
                                 }

                                 if(var7 == 4) {
                                    var8 = var9 + 13;
                                 }

                                 class150.addMenuEntry(var6[var7], DynamicObject.getColTags(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3741 || !Client.field1111) {
                        class150.addMenuEntry("Examine", DynamicObject.getColTags(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "867165652"
   )
   static void method102(boolean var0) {
      Client.field998 = var0;
   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "(Liz;I)V",
      garbageValue = "890365011"
   )
   static void method100(Widget var0) {
      if(var0.loopCycle == Client.field1054) {
         Client.field1055[var0.boundsIndex] = true;
      }

   }
}
