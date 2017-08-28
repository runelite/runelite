import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("p")
final class class19 implements Comparator {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   static SpritePixels field336;
   @ObfuscatedName("al")
   static int[] field335;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      longValue = 6076107287823729201L
   )
   static long field334;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lv;Lv;S)I",
      garbageValue = "128"
   )
   int method161(class14 var1, class14 var2) {
      return var1.field295 < var2.field295?-1:(var2.field295 == var1.field295?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method161((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   static final void method171() {
      ScriptEvent.method1131();
      class208.method3930();
      IndexFile.method3098();
      ObjectComposition.objects.reset();
      ObjectComposition.field3437.reset();
      ObjectComposition.cachedModels.reset();
      ObjectComposition.field3442.reset();
      NPCComposition.npcs.reset();
      NPCComposition.npcModelCache.reset();
      class5.method13();
      ItemLayer.method2412();
      Spotanim.spotanims.reset();
      Spotanim.field3329.reset();
      class175.method3454();
      VarPlayerType.varplayers.reset();
      ClanMember.method1169();
      CombatInfo2.field3366.reset();
      CombatInfo2.spriteCache.reset();
      class253.field3399.reset();
      class252.field3389.reset();
      Area.skeletonsIndex.reset();
      class28.method262();
      Widget.field2652.reset();
      Widget.field2741.reset();
      Widget.field2761.reset();
      Widget.field2655.reset();
      ((TextureProvider)Graphics3D.textureLoader).reset();
      Script.field1546.reset();
      Player.indexInterfaces.reset();
      class89.indexSoundEffects.reset();
      DState.field2389.reset();
      class178.field2419.reset();
      RSCanvas.indexMaps.reset();
      class45.indexTrack1.reset();
      class272.indexModels.reset();
      GrandExchangeOffer.indexSprites.reset();
      class18.indexTextures.reset();
      InvType.field3283.reset();
      class46.indexTrack2.reset();
      class67.indexScripts.reset();
   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(Lbn;I)V",
      garbageValue = "-863332173"
   )
   static final void method173(class66 var0) {
      if(Player.localPlayer.x >> 7 == Client.destinationX && Player.localPlayer.y >> 7 == Client.destinationY) {
         Client.destinationX = 0;
      }

      int var1 = class95.field1507;
      int[] var2 = class95.field1511;
      int var3 = var1;
      if(class66.field828 == var0 || class66.field829 == var0) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(class66.field828 == var0) {
            var5 = Player.localPlayer;
            var6 = Player.localPlayer.field923 << 14;
         } else if(class66.field829 == var0) {
            var5 = Client.cachedPlayers[Client.field1060];
            var6 = Client.field1060 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(class66.field830 == var0 && var2[var4] == Client.field1060) {
               continue;
            }
         }

         if(var5 != null && var5.hasConfig() && !var5.hidden) {
            var5.field919 = false;
            if((Client.lowMemory && var1 > 50 || var1 > 200) && class66.field828 != var0 && var5.poseAnimation == var5.idlePoseAnimation) {
               var5.field919 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.model != null && Client.gameCycle >= var5.field929 && Client.gameCycle < var5.field921) {
                  var5.field919 = false;
                  var5.field908 = class227.getTileHeight(var5.x, var5.y, class27.plane);
                  ScriptState.region.method2724(class27.plane, var5.x, var5.y, var5.field908, 60, var5, var5.angle, var6, var5.field915, var5.field916, var5.field922, var5.field900);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field1034[var7][var8] == Client.field1035) {
                        continue;
                     }

                     Client.field1034[var7][var8] = Client.field1035;
                  }

                  var5.field908 = class227.getTileHeight(var5.x, var5.y, class27.plane);
                  ScriptState.region.method2877(class27.plane, var5.x, var5.y, var5.field908, 60, var5, var5.angle, var6, var5.field1284);
               }
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "1545252838"
   )
   static int method165(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class82.intStack[--Ignore.intStackSize];
         var3 = GZipDecompressor.method3177(var4);
      } else {
         var3 = var2?class31.field452:class23.field366;
      }

      if(var0 == 1100) {
         Ignore.intStackSize -= 2;
         var3.scrollX = class82.intStack[Ignore.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class82.intStack[Ignore.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         class7.method34(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class82.intStack[--Ignore.intStackSize];
         class7.method34(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.field2687 = class82.intStack[--Ignore.intStackSize] == 1;
         class7.method34(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class82.intStack[--Ignore.intStackSize];
         class7.method34(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.field2691 = class82.intStack[--Ignore.intStackSize];
         class7.method34(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class82.intStack[--Ignore.intStackSize];
         class7.method34(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.textureId = class82.intStack[--Ignore.intStackSize];
         class7.method34(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.field2696 = class82.intStack[--Ignore.intStackSize] == 1;
         class7.method34(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class82.intStack[--Ignore.intStackSize];
         class7.method34(var3);
         return 1;
      } else if(var0 == 1109) {
         Ignore.intStackSize -= 6;
         var3.field2707 = class82.intStack[Ignore.intStackSize];
         var3.field2647 = class82.intStack[Ignore.intStackSize + 1];
         var3.rotationX = class82.intStack[Ignore.intStackSize + 2];
         var3.rotationZ = class82.intStack[Ignore.intStackSize + 3];
         var3.rotationY = class82.intStack[Ignore.intStackSize + 4];
         var3.modelZoom = class82.intStack[Ignore.intStackSize + 5];
         class7.method34(var3);
         return 1;
      } else {
         int var9;
         if(var0 == 1110) {
            var9 = class82.intStack[--Ignore.intStackSize];
            if(var9 != var3.field2783) {
               var3.field2783 = var9;
               var3.field2780 = 0;
               var3.field2734 = 0;
               class7.method34(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2694 = class82.intStack[--Ignore.intStackSize] == 1;
            class7.method34(var3);
            return 1;
         } else if(var0 == 1112) {
            String var7 = class82.scriptStringStack[--class169.scriptStringStackSize];
            if(!var7.equals(var3.text)) {
               var3.text = var7;
               class7.method34(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class82.intStack[--Ignore.intStackSize];
            class7.method34(var3);
            return 1;
         } else if(var0 == 1114) {
            Ignore.intStackSize -= 3;
            var3.field2721 = class82.intStack[Ignore.intStackSize];
            var3.field2722 = class82.intStack[Ignore.intStackSize + 1];
            var3.field2731 = class82.intStack[Ignore.intStackSize + 2];
            class7.method34(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.textShadowed = class82.intStack[--Ignore.intStackSize] == 1;
            class7.method34(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class82.intStack[--Ignore.intStackSize];
            class7.method34(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class82.intStack[--Ignore.intStackSize];
            class7.method34(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class82.intStack[--Ignore.intStackSize] == 1;
            class7.method34(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class82.intStack[--Ignore.intStackSize] == 1;
            class7.method34(var3);
            return 1;
         } else if(var0 == 1120) {
            Ignore.intStackSize -= 2;
            var3.scrollWidth = class82.intStack[Ignore.intStackSize];
            var3.scrollHeight = class82.intStack[Ignore.intStackSize + 1];
            class7.method34(var3);
            if(var4 != -1 && var3.type == 0) {
               class64.method1114(class268.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            var9 = var3.id;
            int var6 = var3.index;
            Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_ADVANCE_DIALOGUE);
            Client.secretPacketBuffer1.putShortLE(var6);
            Client.secretPacketBuffer1.putLEShortA(var9);
            Client.field1086 = var3;
            class7.method34(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2668 = class82.intStack[--Ignore.intStackSize];
            class7.method34(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2684 = class82.intStack[--Ignore.intStackSize];
            class7.method34(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2690 = class82.intStack[--Ignore.intStackSize];
            class7.method34(var3);
            return 1;
         } else if(var0 == 1125) {
            var9 = class82.intStack[--Ignore.intStackSize];
            class284 var8 = (class284)class88.forOrdinal(class39.method561(), var9);
            if(var8 != null) {
               var3.field2688 = var8;
               class7.method34(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class82.intStack[--Ignore.intStackSize] == 1;
            var3.field2692 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }
}
