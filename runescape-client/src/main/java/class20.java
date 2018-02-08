import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public class class20 {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILcf;ZB)I",
      garbageValue = "-1"
   )
   static int method159(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class94.field1418:ItemLayer.field1668;
      if(var0 == 1700) {
         class80.intStack[++class80.intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 1701) {
         if(var3.itemId != -1) {
            class80.intStack[++class80.intStackSize - 1] = var3.itemQuantity;
         } else {
            class80.intStack[++class80.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 1702) {
         class80.intStack[++class80.intStackSize - 1] = var3.index;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(ZLgt;B)V",
      garbageValue = "-78"
   )
   static final void method157(boolean var0, PacketBuffer var1) {
      Client.field947 = 0;
      Client.pendingNpcFlagsCount = 0;
      WorldComparator.method65();
      ScriptEvent.updateNpcs(var0, var1);

      int var2;
      int var3;
      for(var2 = 0; var2 < Client.pendingNpcFlagsCount; ++var2) {
         var3 = Client.pendingNpcFlagsIndices[var2];
         NPC var4 = Client.cachedNPCs[var3];
         int var5 = var1.readUnsignedByte();
         int var6;
         if((var5 & 1) != 0) {
            var4.graphic = var1.readUnsignedByteNegate();
            var6 = var1.method3557();
            var4.field1168 = var6 >> 16;
            var4.graphicsDelay = (var6 & 65535) + Client.gameCycle;
            var4.field1152 = 0;
            var4.field1153 = 0;
            if(var4.graphicsDelay > Client.gameCycle) {
               var4.field1152 = -1;
            }

            if(var4.graphic == 65535) {
               var4.graphic = -1;
            }
         }

         if((var5 & 16) != 0) {
            var4.overhead = var1.readString();
            var4.overheadTextCyclesRemaining = 100;
         }

         if((var5 & 8) != 0) {
            var4.interacting = var1.method3547();
            if(var4.interacting == 65535) {
               var4.interacting = -1;
            }
         }

         int var7;
         int var8;
         if((var5 & 64) != 0) {
            var6 = var1.readUnsignedShortOb1();
            if(var6 == 65535) {
               var6 = -1;
            }

            var7 = var1.method3538();
            if(var6 == var4.animation && var6 != -1) {
               var8 = FileRequest.getAnimation(var6).replyMode;
               if(var8 == 1) {
                  var4.actionFrame = 0;
                  var4.field1140 = 0;
                  var4.actionAnimationDisable = var7;
                  var4.field1150 = 0;
               }

               if(var8 == 2) {
                  var4.field1150 = 0;
               }
            } else if(var6 == -1 || var4.animation == -1 || FileRequest.getAnimation(var6).forcedPriority >= FileRequest.getAnimation(var4.animation).forcedPriority) {
               var4.animation = var6;
               var4.actionFrame = 0;
               var4.field1140 = 0;
               var4.actionAnimationDisable = var7;
               var4.field1150 = 0;
               var4.field1161 = var4.queueSize;
            }
         }

         int var9;
         if((var5 & 4) != 0) {
            var6 = var1.readUnsignedShortOb1();
            var7 = var1.method3547();
            var8 = var4.x - (var6 - ClanMemberManager.baseX - ClanMemberManager.baseX) * 64;
            var9 = var4.y - (var7 - WorldMapData.baseY - WorldMapData.baseY) * 64;
            if(var8 != 0 || var9 != 0) {
               var4.field1142 = (int)(Math.atan2((double)var8, (double)var9) * 325.949D) & 2047;
            }
         }

         if((var5 & 32) != 0) {
            var4.composition = Spotanim.getNpcDefinition(var1.readUnsignedShortOb1());
            var4.field1127 = var4.composition.field3633;
            var4.field1167 = var4.composition.field3634;
            var4.field1156 = var4.composition.field3627;
            var4.field1123 = var4.composition.field3640;
            var4.field1124 = var4.composition.field3645;
            var4.field1125 = var4.composition.field3642;
            var4.idlePoseAnimation = var4.composition.field3636;
            var4.field1120 = var4.composition.field3637;
            var4.field1121 = var4.composition.field3639;
         }

         if((var5 & 2) != 0) {
            var6 = var1.readUnsignedByte();
            int var10;
            int var11;
            int var12;
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var9 = -1;
                  var10 = -1;
                  var11 = -1;
                  var8 = var1.getUSmart();
                  if(var8 == 32767) {
                     var8 = var1.getUSmart();
                     var10 = var1.getUSmart();
                     var9 = var1.getUSmart();
                     var11 = var1.getUSmart();
                  } else if(var8 != 32766) {
                     var10 = var1.getUSmart();
                  } else {
                     var8 = -1;
                  }

                  var12 = var1.getUSmart();
                  var4.method1597(var8, var10, var9, var11, Client.gameCycle, var12);
               }
            }

            var7 = var1.method3536();
            if(var7 > 0) {
               for(var8 = 0; var8 < var7; ++var8) {
                  var9 = var1.getUSmart();
                  var10 = var1.getUSmart();
                  if(var10 != 32767) {
                     var11 = var1.getUSmart();
                     var12 = var1.method3538();
                     int var13 = var10 > 0?var1.readUnsignedByte():var12;
                     var4.method1598(var9, Client.gameCycle, var10, var11, var12, var13);
                  } else {
                     var4.method1605(var9);
                  }
               }
            }
         }
      }

      for(var2 = 0; var2 < Client.field947; ++var2) {
         var3 = Client.field948[var2];
         if(Client.cachedNPCs[var3].npcCycle != Client.gameCycle) {
            Client.cachedNPCs[var3].composition = null;
            Client.cachedNPCs[var3] = null;
         }
      }

      if(var1.offset != Client.field937.packetLength) {
         throw new RuntimeException(var1.offset + "," + Client.field937.packetLength);
      } else {
         for(var2 = 0; var2 < Client.npcIndexesCount; ++var2) {
            if(Client.cachedNPCs[Client.npcIndices[var2]] == null) {
               throw new RuntimeException(var2 + "," + Client.npcIndexesCount);
            }
         }

      }
   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static void method158() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.first(); var0 != null; var0 = (WidgetNode)Client.componentTable.next()) {
         int var1 = var0.id;
         if(ServerPacket.loadWidget(var1)) {
            boolean var2 = true;
            Widget[] var3 = ScriptState.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class216.getWidget(var4);
               if(var5 != null) {
                  class33.method341(var5);
               }
            }
         }
      }

   }
}
