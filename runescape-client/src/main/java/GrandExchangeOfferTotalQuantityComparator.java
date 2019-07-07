import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("GrandExchangeOfferTotalQuantityComparator")
final class GrandExchangeOfferTotalQuantityComparator implements Comparator {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ll;Ll;I)I",
      garbageValue = "-573736433"
   )
   @Export("compareTyped")
   int compareTyped(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.totalQuantity < var2.grandExchangeOffer.totalQuantity ? -1 : (var2.grandExchangeOffer.totalQuantity == var1.grandExchangeOffer.totalQuantity ? 0 : 1);
   }

   public int compare(Object var1, Object var2) {
      return this.compareTyped((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgr;IIIIIIB)V",
      garbageValue = "46"
   )
   @Export("loadTerrain")
   static final void loadTerrain(Buffer buffer, int plane, int x, int y, int x0, int y0, int var6) {
      int var7;
      if (x >= 0 && x < 104 && y >= 0 && y < 104) {
         Tiles.Tiles_renderFlags[plane][x][y] = 0;

         while (true) {
            var7 = buffer.readUnsignedByte();
            if (var7 == 0) {
               if (plane == 0) {
                  int[] var12 = Tiles.Tiles_heights[0][x];
                  int var9 = x + x0 + 932731;
                  int var10 = y + y0 + 556238;
                  int var11 = Script.method2204(var9 + 45365, var10 + 91923, 4) - 128 + (Script.method2204(10294 + var9, 37821 + var10, 2) - 128 >> 1) + (Script.method2204(var9, var10, 1) - 128 >> 2);
                  var11 = (int)((double)var11 * 0.3D) + 35;
                  if (var11 < 10) {
                     var11 = 10;
                  } else if (var11 > 60) {
                     var11 = 60;
                  }

                  var12[y] = -var11 * 8;
               } else {
                  Tiles.Tiles_heights[plane][x][y] = Tiles.Tiles_heights[plane - 1][x][y] - 240;
               }
               break;
            }

            if (var7 == 1) {
               int var8 = buffer.readUnsignedByte();
               if (var8 == 1) {
                  var8 = 0;
               }

               if (plane == 0) {
                  Tiles.Tiles_heights[0][x][y] = -var8 * 8;
               } else {
                  Tiles.Tiles_heights[plane][x][y] = Tiles.Tiles_heights[plane - 1][x][y] - var8 * 8;
               }
               break;
            }

            if (var7 <= 49) {
               Fonts.field350[plane][x][y] = buffer.readByte();
               class32.field1157[plane][x][y] = (byte)((var7 - 2) / 4);
               class307.field1155[plane][x][y] = (byte)(var7 - 2 + var6 & 3);
            } else if (var7 <= 81) {
               Tiles.Tiles_renderFlags[plane][x][y] = (byte)(var7 - 49);
            } else {
               Tiles.field908[plane][x][y] = (byte)(var7 - 81);
            }
         }
      } else {
         while (true) {
            var7 = buffer.readUnsignedByte();
            if (var7 == 0) {
               break;
            }

            if (var7 == 1) {
               buffer.readUnsignedByte();
               break;
            }

            if (var7 <= 49) {
               buffer.readUnsignedByte();
            }
         }
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(ILhu;ZI)V",
      garbageValue = "466862614"
   )
   static void method96(int var0, Coord var1, boolean var2) {
      WorldMapArea var3 = BufferedFile.worldMap().getMapArea(var0);
      int var4 = Canvas.localPlayer.plane;
      int var5 = (Canvas.localPlayer.x >> 7) + class50.baseX;
      int var6 = (Canvas.localPlayer.y >> 7) + GraphicsObject.baseY;
      Coord var7 = new Coord(var4, var5, var6);
      BufferedFile.worldMap().method367(var3, var7, var1, var2);
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(Lbr;IIII)V",
      garbageValue = "835715563"
   )
   @Export("addPlayerToMenu")
   static final void addPlayerToMenu(Player player, int menuArg0, int menuArg1, int menuArg2) {
      if (Canvas.localPlayer != player && Client.menuOptionsCount < 400) {
         String var4;
         int var5;
         if (player.skillLevel == 0) {
            String var6 = player.actions[0] + player.username + player.actions[1];
            var5 = player.combatLevel;
            int var7 = Canvas.localPlayer.combatLevel;
            int var8 = var7 - var5;
            String var9;
            if (var8 < -9) {
               var9 = BufferedFile.colorStartTag(16711680);
            } else if (var8 < -6) {
               var9 = BufferedFile.colorStartTag(16723968);
            } else if (var8 < -3) {
               var9 = BufferedFile.colorStartTag(16740352);
            } else if (var8 < 0) {
               var9 = BufferedFile.colorStartTag(16756736);
            } else if (var8 > 9) {
               var9 = BufferedFile.colorStartTag(65280);
            } else if (var8 > 6) {
               var9 = BufferedFile.colorStartTag(4259584);
            } else if (var8 > 3) {
               var9 = BufferedFile.colorStartTag(8453888);
            } else if (var8 > 0) {
               var9 = BufferedFile.colorStartTag(12648192);
            } else {
               var9 = BufferedFile.colorStartTag(16776960);
            }

            var4 = var6 + var9 + "  (level-" + player.combatLevel + ")" + player.actions[2];
         } else {
            var4 = player.actions[0] + player.username + player.actions[1] + "  (skill-" + player.skillLevel + ")" + player.actions[2];
         }

         int var10;
         if (Client.isItemSelected == 1) {
            Tiles.insertMenuItemNoShift("Use", Client.selectedItemName + " -> " + BufferedFile.colorStartTag(16777215) + var4, 14, menuArg0, menuArg1, menuArg2);
         } else if (Client.isSpellSelected) {
            if ((FloorDecoration.selectedSpellFlags & 8) == 8) {
               Tiles.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " -> " + BufferedFile.colorStartTag(16777215) + var4, 15, menuArg0, menuArg1, menuArg2);
            }
         } else {
            for (var10 = 7; var10 >= 0; --var10) {
               if (Client.playerMenuActions[var10] != null) {
                  short var11 = 0;
                  if (Client.playerMenuActions[var10].equalsIgnoreCase("Attack")) {
                     if (AttackOption.AttackOption_hidden == Client.playerAttackOption) {
                        continue;
                     }

                     if (AttackOption.AttackOption_alwaysRightClick == Client.playerAttackOption || AttackOption.AttackOption_dependsOnCombatLevels == Client.playerAttackOption && player.combatLevel > Canvas.localPlayer.combatLevel) {
                        var11 = 2000;
                     }

                     if (Canvas.localPlayer.team != 0 && player.team != 0) {
                        if (player.team == Canvas.localPlayer.team) {
                           var11 = 2000;
                        } else {
                           var11 = 0;
                        }
                     }
                  } else if (Client.playerOptionsPriorities[var10]) {
                     var11 = 2000;
                  }

                  boolean var12 = false;
                  var5 = Client.playerMenuOpcodes[var10] + var11;
                  Tiles.insertMenuItemNoShift(Client.playerMenuActions[var10], BufferedFile.colorStartTag(16777215) + var4, var5, menuArg0, menuArg1, menuArg2);
               }
            }
         }

         for (var10 = 0; var10 < Client.menuOptionsCount; ++var10) {
            if (Client.menuOpcodes[var10] == 23) {
               Client.menuTargetNames[var10] = BufferedFile.colorStartTag(16777215) + var4;
               break;
            }
         }
      }

   }
}
