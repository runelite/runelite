import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
final class class5 implements class0 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1779408929
   )
   @Export("revision")
   public static int revision;
   @ObfuscatedName("ad")
   static int[] field37;

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "([Lhx;IIIZB)V",
      garbageValue = "66"
   )
   static void method11(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            class13.method82(var6, var2, var3, var4);
            class237.method4225(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class64.method1114(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "108"
   )
   static final void method9() {
      int var0 = class239.menuX;
      int var1 = class43.menuY;
      int var2 = class88.menuWidth;
      int var3 = class12.menuHeight;
      int var4 = 6116423;
      Rasterizer2D.method4890(var0, var1, var2, var3, var4);
      Rasterizer2D.method4890(var0 + 1, var1 + 1, var2 - 2, 16, 0);
      Rasterizer2D.drawRectangle(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
      class73.field897.method4773("Choose Option", var0 + 3, var1 + 14, var4, -1);
      int var5 = MouseInput.field752;
      int var6 = MouseInput.field747;

      for(int var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         int var8 = var1 + (Client.menuOptionCount - 1 - var7) * 15 + 31;
         int var9 = 16777215;
         if(var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < var8 + 3) {
            var9 = 16776960;
         }

         Font var10 = class73.field897;
         String var11;
         if(var7 < 0) {
            var11 = "";
         } else if(Client.menuTargets[var7].length() > 0) {
            var11 = Client.menuOptions[var7] + " " + Client.menuTargets[var7];
         } else {
            var11 = Client.menuOptions[var7];
         }

         var10.method4773(var11, var0 + 3, var8, var9, 0);
      }

      class14.method87(class239.menuX, class43.menuY, class88.menuWidth, class12.menuHeight);
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIS)V",
      garbageValue = "24167"
   )
   static final void method8(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class13.loadWidget(var0)) {
         class39.field549 = null;
         GraphicsObject.gameDraw(class268.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class39.field549 != null) {
            GraphicsObject.gameDraw(class39.field549, -1412584499, var1, var2, var3, var4, class12.field280, Preferences.field1322, var7);
            class39.field549 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1110[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1110[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1996325776"
   )
   public static void method13() {
      ItemComposition.items.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfn;II)V",
      garbageValue = "-900143998"
   )
   @Export("decodeMovement")
   static void decodeMovement(PacketBuffer var0, int var1) {
      boolean var2 = var0.getBits(1) == 1;
      if(var2) {
         class95.field1510[++class95.field1514 - 1] = var1;
      }

      int var3 = var0.getBits(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field909 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class95.field1502[var1] = (class67.baseY + var4.pathY[0] >> 13) + (var4.field910 << 28) + (class149.baseX + var4.pathX[0] >> 13 << 14);
            if(var4.field1257 != -1) {
               class95.field1512[var1] = var4.field1257;
            } else {
               class95.field1512[var1] = var4.orientation;
            }

            class95.field1508[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.getBits(1) != 0) {
               ItemContainer.decodeRegionHash(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.getBits(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1153(var6, var7);
               var4.field909 = false;
            } else if(var2) {
               var4.field909 = true;
               var4.field905 = var6;
               var4.field926 = var7;
            } else {
               var4.field909 = false;
               var4.method1152(var6, var7, class95.field1513[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.getBits(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1153(var6, var7);
               var4.field909 = false;
            } else if(var2) {
               var4.field909 = true;
               var4.field905 = var6;
               var4.field926 = var7;
            } else {
               var4.field909 = false;
               var4.method1152(var6, var7, class95.field1513[var1]);
            }

         } else {
            var5 = var0.getBits(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.getBits(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.pathX[0];
               var11 = var9 + var4.pathY[0];
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field909 = true;
                     var4.field905 = var10;
                     var4.field926 = var11;
                  } else {
                     var4.field909 = false;
                     var4.method1152(var10, var11, class95.field1513[var1]);
                  }
               } else {
                  var4.method1153(var10, var11);
                  var4.field909 = false;
               }

               var4.field910 = (byte)(var7 + var4.field910 & 3);
               if(Client.localInteractingIndex == var1) {
                  class27.plane = var4.field910;
               }

            } else {
               var6 = var0.getBits(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + class149.baseX + var4.pathX[0] & 16383) - class149.baseX;
               var11 = (var9 + class67.baseY + var4.pathY[0] & 16383) - class67.baseY;
               if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method1153(var10, var11);
                  var4.field909 = false;
               } else if(var2) {
                  var4.field909 = true;
                  var4.field905 = var10;
                  var4.field926 = var11;
               } else {
                  var4.field909 = false;
                  var4.method1152(var10, var11, class95.field1513[var1]);
               }

               var4.field910 = (byte)(var7 + var4.field910 & 3);
               if(Client.localInteractingIndex == var1) {
                  class27.plane = var4.field910;
               }

            }
         }
      }
   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(Lir;IIII)V",
      garbageValue = "1750171280"
   )
   static final void method12(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.transform();
         }

         if(var0 != null) {
            if(var0.field3579) {
               if(!var0.field3581 || Client.field1099 == var1) {
                  String var4 = var0.name;
                  if(var0.combatLevel != 0) {
                     var4 = var4 + Client.method1514(var0.combatLevel, Player.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3581 && Client.field1047) {
                     class36.addMenuEntry("Examine", Friend.getColTags(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.itemSelectionState == 1) {
                     class36.addMenuEntry("Use", Client.field1085 + " " + "->" + " " + Friend.getColTags(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.spellSelected) {
                     if((class67.field845 & 2) == 2) {
                        class36.addMenuEntry(Client.field1089, Client.field1090 + " " + "->" + " " + Friend.getColTags(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var5 = var0.field3581 && Client.field1047?2000:0;
                     String[] var6 = var0.actions;
                     if(Client.field1102) {
                        var6 = class171.method3220(var6);
                     }

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

                              class36.addMenuEntry(var6[var7], Friend.getColTags(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var6[var7] != null && var6[var7].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(class90.field1426 != Client.field968) {
                                 if(Client.field968 == class90.field1424 || class90.field1431 == Client.field968 && var0.combatLevel > Player.localPlayer.combatLevel) {
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

                                 class36.addMenuEntry(var6[var7], Friend.getColTags(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3581 || !Client.field1047) {
                        class36.addMenuEntry("Examine", Friend.getColTags(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }
}
