import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public final class class29 {
   @ObfuscatedName("nx")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   @Export("minimapSprite")
   static SpritePixels minimapSprite;
   @ObfuscatedName("r")
   static byte[][][] field392;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 343614309
   )
   int field395;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1046054261
   )
   int field391;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1154355813
   )
   int field394;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 481720557
   )
   int field390;
   // $FF: synthetic field
   @ObfuscatedSignature(
      signature = "Law;"
   )
   final class41 this$0;

   @ObfuscatedSignature(
      signature = "(Law;)V"
   )
   class29(class41 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-428879106"
   )
   @Export("setItemTableSlot")
   static void setItemTableSlot(int var0, int var1, int var2, int var3) {
      ItemContainer var4 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var4 == null) {
         var4 = new ItemContainer();
         ItemContainer.itemContainers.put(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(ZLgd;I)V",
      garbageValue = "1881523668"
   )
   static final void method259(boolean var0, PacketBuffer var1) {
      Client.field929 = 0;
      Client.pendingNpcFlagsCount = 0;
      PacketBuffer var2 = Client.field867.packetBuffer;
      var2.bitAccess();
      int var3 = var2.getBits(8);
      int var4;
      if(var3 < Client.npcIndexesCount) {
         for(var4 = var3; var4 < Client.npcIndexesCount; ++var4) {
            Client.field930[++Client.field929 - 1] = Client.npcIndices[var4];
         }
      }

      if(var3 > Client.npcIndexesCount) {
         throw new RuntimeException("");
      } else {
         Client.npcIndexesCount = 0;

         for(var4 = 0; var4 < var3; ++var4) {
            int var5 = Client.npcIndices[var4];
            NPC var6 = Client.cachedNPCs[var5];
            int var7 = var2.getBits(1);
            if(var7 == 0) {
               Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
               var6.npcCycle = Client.gameCycle;
            } else {
               int var8 = var2.getBits(2);
               if(var8 == 0) {
                  Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
                  var6.npcCycle = Client.gameCycle;
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var5;
               } else {
                  int var9;
                  int var10;
                  if(var8 == 1) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
                     var6.npcCycle = Client.gameCycle;
                     var9 = var2.getBits(3);
                     var6.method1820(var9, (byte)1);
                     var10 = var2.getBits(1);
                     if(var10 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var5;
                     }
                  } else if(var8 == 2) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
                     var6.npcCycle = Client.gameCycle;
                     var9 = var2.getBits(3);
                     var6.method1820(var9, (byte)2);
                     var10 = var2.getBits(3);
                     var6.method1820(var10, (byte)2);
                     int var11 = var2.getBits(1);
                     if(var11 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var5;
                     }
                  } else if(var8 == 3) {
                     Client.field930[++Client.field929 - 1] = var5;
                  }
               }
            }
         }

         PacketNode.updateNpcs(var0, var1);
         class84.method1840(var1);

         int var12;
         for(var12 = 0; var12 < Client.field929; ++var12) {
            var3 = Client.field930[var12];
            if(Client.cachedNPCs[var3].npcCycle != Client.gameCycle) {
               Client.cachedNPCs[var3].composition = null;
               Client.cachedNPCs[var3] = null;
            }
         }

         if(var1.offset != Client.field867.packetLength) {
            throw new RuntimeException(var1.offset + "," + Client.field867.packetLength);
         } else {
            for(var12 = 0; var12 < Client.npcIndexesCount; ++var12) {
               if(Client.cachedNPCs[Client.npcIndices[var12]] == null) {
                  throw new RuntimeException(var12 + "," + Client.npcIndexesCount);
               }
            }

         }
      }
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(Lbc;IIII)V",
      garbageValue = "-1364895639"
   )
   static final void method257(Player var0, int var1, int var2, int var3) {
      if(class36.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.totalLevel == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + ScriptEvent.method1083(var0.combatLevel, class36.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.totalLevel + ")" + var0.actions[2];
            }

            int var5;
            if(Client.itemSelectionState == 1) {
               class3.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + class1.getColTags(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.spellSelected) {
               if((GameCanvas.field603 & 8) == 8) {
                  class3.addMenuEntry(Client.field1001, Client.field966 + " " + "->" + " " + class1.getColTags(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(Client.playerOptions[var5] != null) {
                     short var6 = 0;
                     if(Client.playerOptions[var5].equalsIgnoreCase("Attack")) {
                        if(Client.playerAttackOption == AttackOption.AttackOption_hidden) {
                           continue;
                        }

                        if(AttackOption.AttackOption_alwaysRightClick == Client.playerAttackOption || Client.playerAttackOption == AttackOption.AttackOption_dependsOnCombatLevels && var0.combatLevel > class36.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(class36.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == class36.localPlayer.team) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriorities[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = Client.playerMenuTypes[var5] + var6;
                     class3.addMenuEntry(Client.playerOptions[var5], class1.getColTags(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = class1.getColTags(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
