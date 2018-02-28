import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
@Implements("MapIcon")
public class MapIcon {
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = -532701509
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1731237697
   )
   @Export("areaId")
   public final int areaId;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   public final Coordinates field490;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   public final Coordinates field491;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1263344719
   )
   final int field496;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2138786075
   )
   final int field492;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Laq;"
   )
   final MapLabel field493;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1351679715
   )
   int field494;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 166915299
   )
   int field495;

   @ObfuscatedSignature(
      signature = "(ILhp;Lhp;Laq;)V"
   )
   MapIcon(int var1, Coordinates var2, Coordinates var3, MapLabel var4) {
      this.areaId = var1;
      this.field491 = var2;
      this.field490 = var3;
      this.field493 = var4;
      Area var5 = class330.mapAreaType[this.areaId];
      SpritePixels var6 = var5.getMapIcon(false);
      if(var6 != null) {
         this.field496 = var6.width;
         this.field492 = var6.height;
      } else {
         this.field496 = 0;
         this.field492 = 0;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-564282255"
   )
   boolean method558(int var1, int var2) {
      return this.method549(var1, var2)?true:this.method548(var1, var2);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "2083885645"
   )
   boolean method549(int var1, int var2) {
      Area var3 = class330.mapAreaType[this.areaId];
      switch(var3.field3390.field3623) {
      case 0:
         if(var1 > this.field494 - this.field496 && var1 <= this.field494) {
            break;
         }

         return false;
      case 1:
         if(var1 >= this.field494 - this.field496 / 2 && var1 <= this.field496 / 2 + this.field494) {
            break;
         }

         return false;
      case 2:
         if(var1 < this.field494 || var1 >= this.field494 + this.field496) {
            return false;
         }
      }

      switch(var3.field3407.field3378) {
      case 0:
         if(var2 > this.field495 - this.field492 && var2 <= this.field495) {
            break;
         }

         return false;
      case 1:
         if(var2 < this.field495 || var2 >= this.field495 + this.field492) {
            return false;
         }
         break;
      case 2:
         if(var2 < this.field495 - this.field492 / 2 || var2 > this.field492 / 2 + this.field495) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1050819582"
   )
   boolean method548(int var1, int var2) {
      return this.field493 == null?false:(var1 >= this.field494 - this.field493.field436 / 2 && var1 <= this.field493.field436 / 2 + this.field494?var2 >= this.field495 && var2 <= this.field493.field432 + this.field495:false);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1737583768"
   )
   static void method559(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field1166[var5] != var0) {
            var2[var4] = World.field1166[var5];
            var3[var4] = World.field1168[var5];
            ++var4;
         }
      }

      World.field1166 = var2;
      World.field1168 = var3;
      BoundingBox3DDrawMode.method52(World.worldList, 0, World.worldList.length - 1, World.field1166, World.field1168);
   }

   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "889678715"
   )
   static void method557() {
      Client.mouseLastLastPressedTimeMillis = 1L;
      Client.field833 = -1;
      class31.mouseRecorder.index = 0;
      class166.field2176 = true;
      Client.field1018 = true;
      Client.field909 = -1L;
      DecorativeObject.method3071();
      Client.field863.method2031();
      Client.field863.packetBuffer.offset = 0;
      Client.field863.serverPacket = null;
      Client.field863.field1441 = null;
      Client.field863.field1442 = null;
      Client.field863.field1443 = null;
      Client.field863.packetLength = 0;
      Client.field863.field1439 = 0;
      Client.field836 = 0;
      Client.field864 = 0;
      Client.hintArrowTargetType = 0;
      class272.method4902();
      class223.method4132(0);
      class94.chatLineMap.clear();
      class94.messages.clear();
      class94.field1397.clear();
      class94.field1400 = 0;
      Client.itemSelectionState = 0;
      Client.spellSelected = false;
      Client.queuedSoundEffectCount = 0;
      Client.mapAngle = 0;
      Client.field834 = 0;
      Client.field1077 = -1;
      Client.destinationX = 0;
      Client.destinationY = 0;
      Client.playerAttackOption = AttackOption.AttackOption_hidden;
      Client.npcAttackOption = AttackOption.AttackOption_hidden;
      Client.npcIndexesCount = 0;
      class94.method1984();

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      for(var0 = 0; var0 < 32768; ++var0) {
         Client.cachedNPCs[var0] = null;
      }

      Client.field972 = -1;
      Client.projectiles.clear();
      Client.graphicsObjectDeque.clear();

      for(var0 = 0; var0 < 4; ++var0) {
         for(int var1 = 0; var1 < 104; ++var1) {
            for(int var2 = 0; var2 < 104; ++var2) {
               Client.groundItemDeque[var0][var1][var2] = null;
            }
         }
      }

      Client.pendingSpawns = new Deque();
      ContextMenuRow.friendManager.method1710();

      for(var0 = 0; var0 < class197.field2566; ++var0) {
         VarPlayerType var3 = PendingSpawn.method1617(var0);
         if(var3 != null) {
            class231.settings[var0] = 0;
            class231.widgetSettings[var0] = 0;
         }
      }

      class60.chatMessages.reset();
      Client.field996 = -1;
      if(Client.widgetRoot != -1) {
         class56.method845(Client.widgetRoot);
      }

      for(WidgetNode var4 = (WidgetNode)Client.componentTable.first(); var4 != null; var4 = (WidgetNode)Client.componentTable.next()) {
         AbstractByteBuffer.method3808(var4, true);
      }

      Client.widgetRoot = -1;
      Client.componentTable = new HashTable(8);
      Client.field930 = null;
      class272.method4902();
      Client.field1068.method4392((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.playerOptions[var0] = null;
         Client.playerOptionsPriorities[var0] = false;
      }

      ItemContainer.itemContainers = new HashTable(32);
      Client.field828 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field979[var0] = true;
      }

      Resampler.method2310();
      class2.clanMemberManager = null;

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new GrandExchangeOffer();
      }

      class1.grandExchangeEvents = null;
   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "455280101"
   )
   static final void method560() {
      for(Projectile var0 = (Projectile)Client.projectiles.getFront(); var0 != null; var0 = (Projectile)Client.projectiles.getNext()) {
         if(var0.floor == class230.plane && Client.gameCycle <= var0.endCycle) {
            if(Client.gameCycle >= var0.startMovementCycle) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.moveProjectile(var1.x, var1.y, WorldMapType1.getTileHeight(var1.x, var1.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(var2 == Client.localInteractingIndex) {
                     var3 = OwnWorldComparator.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.moveProjectile(var3.x, var3.y, WorldMapType1.getTileHeight(var3.x, var3.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               var0.update(Client.field878);
               GameObject.region.method2930(class230.plane, (int)var0.x, (int)var0.y, (int)var0.z, 60, var0, var0.rotationX, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1620866164"
   )
   static final void method551(int var0, int var1, int var2, int var3, int var4) {
      int var5 = GameObject.region.method2941(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = GameObject.region.getObjectFlags(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class131.minimapSprite.pixels;
         var11 = var1 * 4 + (103 - var2) * 2048 + 24624;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = Preferences.getObjectDefinition(var12);
         if(var13.mapSceneId != -1) {
            IndexedSprite var14 = class2.mapscene[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.width * 4 - var14.originalWidth) / 2;
               int var16 = (var13.length * 4 - var14.height) / 2;
               var14.method5783(var1 * 4 + var15 + 48, (104 - var2 - var13.length) * 4 + var16 + 48);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = GameObject.region.method2911(var0, var1, var2);
      if(var5 != 0) {
         var6 = GameObject.region.getObjectFlags(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = Preferences.getObjectDefinition(var9);
         int var18;
         if(var23.mapSceneId != -1) {
            IndexedSprite var17 = class2.mapscene[var23.mapSceneId];
            if(var17 != null) {
               var12 = (var23.width * 4 - var17.originalWidth) / 2;
               var18 = (var23.length * 4 - var17.height) / 2;
               var17.method5783(var12 + var1 * 4 + 48, var18 + (104 - var2 - var23.length) * 4 + 48);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = class131.minimapSprite.pixels;
            var18 = var1 * 4 + (103 - var2) * 2048 + 24624;
            if(var7 != 0 && var7 != 2) {
               var22[var18] = var11;
               var22[var18 + 1 + 512] = var11;
               var22[var18 + 1024 + 2] = var11;
               var22[var18 + 1536 + 3] = var11;
            } else {
               var22[var18 + 1536] = var11;
               var22[var18 + 1 + 1024] = var11;
               var22[var18 + 512 + 2] = var11;
               var22[var18 + 3] = var11;
            }
         }
      }

      var5 = GameObject.region.method2912(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var19 = Preferences.getObjectDefinition(var6);
         if(var19.mapSceneId != -1) {
            IndexedSprite var20 = class2.mapscene[var19.mapSceneId];
            if(var20 != null) {
               var9 = (var19.width * 4 - var20.originalWidth) / 2;
               int var21 = (var19.length * 4 - var20.height) / 2;
               var20.method5783(var9 + var1 * 4 + 48, (104 - var2 - var19.length) * 4 + var21 + 48);
            }
         }
      }

   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)V",
      garbageValue = "-3254"
   )
   static final void method547(String var0) {
      if(class2.clanMemberManager != null) {
         PacketNode var1 = class61.method1076(ClientPacket.field2424, Client.field863.field1434);
         var1.packetBuffer.putByte(class43.getLength(var0));
         var1.packetBuffer.putString(var0);
         Client.field863.method2039(var1);
      }
   }
}
