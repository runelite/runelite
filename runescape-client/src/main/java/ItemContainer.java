import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
@Implements("ItemContainer")
public class ItemContainer extends Node {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   @Export("itemContainers")
   static HashTable itemContainers;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("widgetIndex")
   public static IndexDataBase widgetIndex;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 271594149
   )
   static int field759;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "[Ldl;"
   )
   @Export("idxFiles")
   public static CacheFile[] idxFiles;
   @ObfuscatedName("ap")
   protected static String field749;
   @ObfuscatedName("x")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("k")
   @Export("stackSizes")
   int[] stackSizes;

   static {
      itemContainers = new HashTable(32);
   }

   ItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2056365485"
   )
   static int method1101() {
      return ++class96.field1436 - 1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(CI)B",
      garbageValue = "776794604"
   )
   @Export("charToByteCp1252")
   public static byte charToByteCp1252(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(var0 == 8364) {
         var1 = -128;
      } else if(var0 == 8218) {
         var1 = -126;
      } else if(var0 == 402) {
         var1 = -125;
      } else if(var0 == 8222) {
         var1 = -124;
      } else if(var0 == 8230) {
         var1 = -123;
      } else if(var0 == 8224) {
         var1 = -122;
      } else if(var0 == 8225) {
         var1 = -121;
      } else if(var0 == 710) {
         var1 = -120;
      } else if(var0 == 8240) {
         var1 = -119;
      } else if(var0 == 352) {
         var1 = -118;
      } else if(var0 == 8249) {
         var1 = -117;
      } else if(var0 == 338) {
         var1 = -116;
      } else if(var0 == 381) {
         var1 = -114;
      } else if(var0 == 8216) {
         var1 = -111;
      } else if(var0 == 8217) {
         var1 = -110;
      } else if(var0 == 8220) {
         var1 = -109;
      } else if(var0 == 8221) {
         var1 = -108;
      } else if(var0 == 8226) {
         var1 = -107;
      } else if(var0 == 8211) {
         var1 = -106;
      } else if(var0 == 8212) {
         var1 = -105;
      } else if(var0 == 732) {
         var1 = -104;
      } else if(var0 == 8482) {
         var1 = -103;
      } else if(var0 == 353) {
         var1 = -102;
      } else if(var0 == 8250) {
         var1 = -101;
      } else if(var0 == 339) {
         var1 = -100;
      } else if(var0 == 382) {
         var1 = -98;
      } else if(var0 == 376) {
         var1 = -97;
      } else {
         var1 = 63;
      }

      return var1;
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "320660166"
   )
   static void method1100() {
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
   }

   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "(Lhx;IIII)V",
      garbageValue = "-1368625535"
   )
   static final void method1099(Widget var0, int var1, int var2, int var3) {
      class25.method190();
      class217 var4 = var0.method4181(false);
      if(var4 != null) {
         Rasterizer2D.setDrawRegion(var1, var2, var4.field2683 + var1, var2 + var4.field2682);
         if(Client.field1088 != 2 && Client.field1088 != 5) {
            int var5 = Client.mapAngle & 2047;
            int var6 = class181.localPlayer.x / 32 + 48;
            int var7 = 464 - class181.localPlayer.y / 32;
            class1.field12.method5272(var1, var2, var4.field2683, var4.field2682, var6, var7, var5, 256, var4.field2684, var4.field2681);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < Client.field1024; ++var8) {
               var9 = Client.field994[var8] * 4 + 2 - class181.localPlayer.x / 32;
               var10 = Client.field1084[var8] * 4 + 2 - class181.localPlayer.y / 32;
               ScriptState.drawDot(var1, var2, var9, var10, Client.mapIcons[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  Deque var17 = Client.groundItemDeque[class233.plane][var8][var9];
                  if(var17 != null) {
                     var11 = var8 * 4 + 2 - class181.localPlayer.x / 32;
                     var12 = var9 * 4 + 2 - class181.localPlayer.y / 32;
                     ScriptState.drawDot(var1, var2, var11, var12, UnitPriceComparator.mapDots[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < Client.npcIndexesCount; ++var8) {
               NPC var18 = Client.cachedNPCs[Client.npcIndices[var8]];
               if(var18 != null && var18.hasConfig()) {
                  NPCComposition var21 = var18.composition;
                  if(var21 != null && var21.configs != null) {
                     var21 = var21.transform();
                  }

                  if(var21 != null && var21.isMinimapVisible && var21.field3627) {
                     var11 = var18.x / 32 - class181.localPlayer.x / 32;
                     var12 = var18.y / 32 - class181.localPlayer.y / 32;
                     ScriptState.drawDot(var1, var2, var11, var12, UnitPriceComparator.mapDots[1], var4);
                  }
               }
            }

            var8 = class94.playerIndexesCount;
            int[] var22 = class94.playerIndices;

            for(var10 = 0; var10 < var8; ++var10) {
               Player var19 = Client.cachedPlayers[var22[var10]];
               if(var19 != null && var19.hasConfig() && !var19.hidden && var19 != class181.localPlayer) {
                  var12 = var19.x / 32 - class181.localPlayer.x / 32;
                  int var13 = var19.y / 32 - class181.localPlayer.y / 32;
                  boolean var14 = false;
                  if(IntegerToken.isFriended(var19.name, true)) {
                     var14 = true;
                  }

                  boolean var15 = false;

                  for(int var16 = 0; var16 < class61.clanChatCount; ++var16) {
                     if(var19.name.equals(class188.clanMembers[var16].username)) {
                        var15 = true;
                        break;
                     }
                  }

                  boolean var20 = false;
                  if(class181.localPlayer.team != 0 && var19.team != 0 && var19.team == class181.localPlayer.team) {
                     var20 = true;
                  }

                  if(var14) {
                     ScriptState.drawDot(var1, var2, var12, var13, UnitPriceComparator.mapDots[3], var4);
                  } else if(var20) {
                     ScriptState.drawDot(var1, var2, var12, var13, UnitPriceComparator.mapDots[4], var4);
                  } else if(var15) {
                     ScriptState.drawDot(var1, var2, var12, var13, UnitPriceComparator.mapDots[5], var4);
                  } else {
                     ScriptState.drawDot(var1, var2, var12, var13, UnitPriceComparator.mapDots[2], var4);
                  }
               }
            }

            if(Client.hintArrowTargetType != 0 && Client.gameCycle % 20 < 10) {
               if(Client.hintArrowTargetType == 1 && Client.hintArrowNpcTargetIdx >= 0 && Client.hintArrowNpcTargetIdx < Client.cachedNPCs.length) {
                  NPC var23 = Client.cachedNPCs[Client.hintArrowNpcTargetIdx];
                  if(var23 != null) {
                     var11 = var23.x / 32 - class181.localPlayer.x / 32;
                     var12 = var23.y / 32 - class181.localPlayer.y / 32;
                     Projectile.worldToMinimap(var1, var2, var11, var12, GameEngine.mapMarkers[1], var4);
                  }
               }

               if(Client.hintArrowTargetType == 2) {
                  var10 = Client.hintArrowX * 4 - IndexDataBase.baseX * 4 + 2 - class181.localPlayer.x / 32;
                  var11 = Client.hintArrowY * 4 - Occluder.baseY * 4 + 2 - class181.localPlayer.y / 32;
                  Projectile.worldToMinimap(var1, var2, var10, var11, GameEngine.mapMarkers[1], var4);
               }

               if(Client.hintArrowTargetType == 10 && Client.hintArrowPlayerTargetIdx >= 0 && Client.hintArrowPlayerTargetIdx < Client.cachedPlayers.length) {
                  Player var24 = Client.cachedPlayers[Client.hintArrowPlayerTargetIdx];
                  if(var24 != null) {
                     var11 = var24.x / 32 - class181.localPlayer.x / 32;
                     var12 = var24.y / 32 - class181.localPlayer.y / 32;
                     Projectile.worldToMinimap(var1, var2, var11, var12, GameEngine.mapMarkers[1], var4);
                  }
               }
            }

            if(Client.destinationX != 0) {
               var10 = Client.destinationX * 4 + 2 - class181.localPlayer.x / 32;
               var11 = Client.destinationY * 4 + 2 - class181.localPlayer.y / 32;
               ScriptState.drawDot(var1, var2, var10, var11, GameEngine.mapMarkers[0], var4);
            }

            if(!class181.localPlayer.hidden) {
               Rasterizer2D.Rasterizer2D_fillRectangle(var4.field2683 / 2 + var1 - 1, var4.field2682 / 2 + var2 - 1, 3, 3, 16777215);
            }
         } else {
            Rasterizer2D.method5159(var1, var2, 0, var4.field2684, var4.field2681);
         }

         Client.field1099[var3] = true;
      }
   }
}
