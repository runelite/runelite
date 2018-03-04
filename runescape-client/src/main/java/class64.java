import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
public class class64 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   final IndexData field762;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -764738801
   )
   final int field763;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 906625113
   )
   int field764;

   @ObfuscatedSignature(
      signature = "(Ljs;Ljava/lang/String;)V"
   )
   class64(IndexData var1, String var2) {
      this.field764 = 0;
      this.field762 = var1;
      this.field763 = var1.size();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "8"
   )
   boolean method1063() {
      this.field764 = 0;

      for(int var1 = 0; var1 < this.field763; ++var1) {
         if(!this.field762.method4783(var1) || this.field762.method4782(var1)) {
            ++this.field764;
         }
      }

      return this.field764 >= this.field763;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1346013282"
   )
   public static void method1062(int var0, int var1) {
      Varbit var3 = (Varbit)Varbit.varbits.get((long)var0);
      Varbit var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var8 = Varbit.varbit_ref.getConfigData(14, var0);
         var3 = new Varbit();
         if(var8 != null) {
            var3.decode(new Buffer(var8));
         }

         Varbit.varbits.put(var3, (long)var0);
         var2 = var3;
      }

      int var4 = var2.configId;
      int var5 = var2.leastSignificantBit;
      int var6 = var2.mostSignificantBit;
      int var7 = class237.varpsMasks[var6 - var5];
      if(var1 < 0 || var1 > var7) {
         var1 = 0;
      }

      var7 <<= var5;
      class237.widgetSettings[var4] = class237.widgetSettings[var4] & ~var7 | var1 << var5 & var7;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIII)I",
      garbageValue = "1348994556"
   )
   static final int method1068(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - Graphics3D.COSINE[var2 * 1024 / var3] >> 1;
      return ((65536 - var4) * var0 >> 16) + (var4 * var1 >> 16);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-108"
   )
   protected static final void method1065() {
      class315.timer.vmethod3369();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field687[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field712[var0] = 0L;
      }

      GameEngine.field703 = 0;
   }

   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1301288970"
   )
   static void method1067(int var0, int var1, int var2) {
      if(Client.field1084 != 0 && var1 != 0 && Client.queuedSoundEffectCount < 50) {
         Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = var0;
         Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var1;
         Client.unknownSoundValues2[Client.queuedSoundEffectCount] = var2;
         Client.audioEffects[Client.queuedSoundEffectCount] = null;
         Client.soundLocations[Client.queuedSoundEffectCount] = 0;
         ++Client.queuedSoundEffectCount;
      }

   }

   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "(Liw;IIIB)V",
      garbageValue = "61"
   )
   static final void method1066(Widget var0, int var1, int var2, int var3) {
      Huffman.method3510();
      class236 var4 = var0.method4563(false);
      if(var4 != null) {
         Rasterizer2D.setDrawRegion(var1, var2, var4.field2777 + var1, var2 + var4.field2775);
         if(Client.field1080 != 2 && Client.field1080 != 5) {
            int var5 = Client.mapAngle & 2047;
            int var6 = TotalQuantityComparator.localPlayer.x / 32 + 48;
            int var7 = 464 - TotalQuantityComparator.localPlayer.y / 32;
            class25.minimapSprite.method5938(var1, var2, var4.field2777, var4.field2775, var6, var7, var5, 256, var4.field2778, var4.field2779);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < Client.field1006; ++var8) {
               var9 = Client.field1075[var8] * 4 + 2 - TotalQuantityComparator.localPlayer.x / 32;
               var10 = Client.field1064[var8] * 4 + 2 - TotalQuantityComparator.localPlayer.y / 32;
               PendingSpawn.drawDot(var1, var2, var9, var10, Client.mapIcons[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  Deque var15 = Client.groundItemDeque[class36.plane][var8][var9];
                  if(var15 != null) {
                     var11 = var8 * 4 + 2 - TotalQuantityComparator.localPlayer.x / 32;
                     var12 = var9 * 4 + 2 - TotalQuantityComparator.localPlayer.y / 32;
                     PendingSpawn.drawDot(var1, var2, var11, var12, WorldMapType3.mapDots[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < Client.npcIndexesCount; ++var8) {
               NPC var16 = Client.cachedNPCs[Client.npcIndices[var8]];
               if(var16 != null && var16.hasConfig()) {
                  NPCComposition var18 = var16.composition;
                  if(var18 != null && var18.configs != null) {
                     var18 = var18.transform();
                  }

                  if(var18 != null && var18.isMinimapVisible && var18.field3718) {
                     var11 = var16.x / 32 - TotalQuantityComparator.localPlayer.x / 32;
                     var12 = var16.y / 32 - TotalQuantityComparator.localPlayer.y / 32;
                     PendingSpawn.drawDot(var1, var2, var11, var12, WorldMapType3.mapDots[1], var4);
                  }
               }
            }

            var8 = class93.playerIndexesCount;
            int[] var19 = class93.playerIndices;

            for(var10 = 0; var10 < var8; ++var10) {
               Player var17 = Client.cachedPlayers[var19[var10]];
               if(var17 != null && var17.hasConfig() && !var17.hidden && var17 != TotalQuantityComparator.localPlayer) {
                  var12 = var17.x / 32 - TotalQuantityComparator.localPlayer.x / 32;
                  int var13 = var17.y / 32 - TotalQuantityComparator.localPlayer.y / 32;
                  boolean var14 = false;
                  if(TotalQuantityComparator.localPlayer.team != 0 && var17.team != 0 && var17.team == TotalQuantityComparator.localPlayer.team) {
                     var14 = true;
                  }

                  if(var17.isFriend()) {
                     PendingSpawn.drawDot(var1, var2, var12, var13, WorldMapType3.mapDots[3], var4);
                  } else if(var14) {
                     PendingSpawn.drawDot(var1, var2, var12, var13, WorldMapType3.mapDots[4], var4);
                  } else if(var17.isClanMember()) {
                     PendingSpawn.drawDot(var1, var2, var12, var13, WorldMapType3.mapDots[5], var4);
                  } else {
                     PendingSpawn.drawDot(var1, var2, var12, var13, WorldMapType3.mapDots[2], var4);
                  }
               }
            }

            if(Client.hintArrowTargetType != 0 && Client.gameCycle % 20 < 10) {
               if(Client.hintArrowTargetType == 1 && Client.hintArrowNpcTargetIdx >= 0 && Client.hintArrowNpcTargetIdx < Client.cachedNPCs.length) {
                  NPC var20 = Client.cachedNPCs[Client.hintArrowNpcTargetIdx];
                  if(var20 != null) {
                     var11 = var20.x / 32 - TotalQuantityComparator.localPlayer.x / 32;
                     var12 = var20.y / 32 - TotalQuantityComparator.localPlayer.y / 32;
                     NetWriter.worldToMinimap(var1, var2, var11, var12, BaseVarType.mapMarkers[1], var4);
                  }
               }

               if(Client.hintArrowTargetType == 2) {
                  var10 = Client.hintArrowX * 4 - WorldMapType1.baseX * 4 + 2 - TotalQuantityComparator.localPlayer.x / 32;
                  var11 = Client.hintArrowY * 4 - Enum.baseY * 4 + 2 - TotalQuantityComparator.localPlayer.y / 32;
                  NetWriter.worldToMinimap(var1, var2, var10, var11, BaseVarType.mapMarkers[1], var4);
               }

               if(Client.hintArrowTargetType == 10 && Client.hintArrowPlayerTargetIdx >= 0 && Client.hintArrowPlayerTargetIdx < Client.cachedPlayers.length) {
                  Player var21 = Client.cachedPlayers[Client.hintArrowPlayerTargetIdx];
                  if(var21 != null) {
                     var11 = var21.x / 32 - TotalQuantityComparator.localPlayer.x / 32;
                     var12 = var21.y / 32 - TotalQuantityComparator.localPlayer.y / 32;
                     NetWriter.worldToMinimap(var1, var2, var11, var12, BaseVarType.mapMarkers[1], var4);
                  }
               }
            }

            if(Client.destinationX != 0) {
               var10 = Client.destinationX * 4 + 2 - TotalQuantityComparator.localPlayer.x / 32;
               var11 = Client.destinationY * 4 + 2 - TotalQuantityComparator.localPlayer.y / 32;
               PendingSpawn.drawDot(var1, var2, var10, var11, BaseVarType.mapMarkers[0], var4);
            }

            if(!TotalQuantityComparator.localPlayer.hidden) {
               Rasterizer2D.Rasterizer2D_fillRectangle(var4.field2777 / 2 + var1 - 1, var4.field2775 / 2 + var2 - 1, 3, 3, 16777215);
            }
         } else {
            Rasterizer2D.method5820(var1, var2, 0, var4.field2778, var4.field2779);
         }

         Client.field1043[var3] = true;
      }
   }
}
