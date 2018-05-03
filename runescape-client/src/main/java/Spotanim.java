import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   @Export("SpotAnimationDefinition_indexCache")
   static IndexDataBase SpotAnimationDefinition_indexCache;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   @Export("spotanims")
   static NodeCache spotanims;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   @Export("SpotAnimationDefinition_cachedModels")
   static NodeCache SpotAnimationDefinition_cachedModels;
   @ObfuscatedName("ec")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   static Task field3497;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1398515273
   )
   @Export("id")
   int id;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1190631331
   )
   int field3486;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -771532497
   )
   public int field3495;
   @ObfuscatedName("y")
   short[] field3493;
   @ObfuscatedName("c")
   short[] field3489;
   @ObfuscatedName("h")
   short[] field3487;
   @ObfuscatedName("i")
   short[] field3490;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1797149323
   )
   @Export("widthScale")
   int widthScale;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1010164311
   )
   @Export("heightScale")
   int heightScale;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1105201237
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2047612669
   )
   int field3494;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 163835279
   )
   int field3496;

   static {
      spotanims = new NodeCache(64);
      SpotAnimationDefinition_cachedModels = new NodeCache(30);
   }

   Spotanim() {
      this.field3495 = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.orientation = 0;
      this.field3494 = 0;
      this.field3496 = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgg;I)V",
      garbageValue = "1844779810"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgg;IB)V",
      garbageValue = "97"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3486 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3495 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.widthScale = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.heightScale = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.orientation = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3494 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3496 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3493 = new short[var3];
            this.field3489 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3493[var4] = (short)var1.readUnsignedShort();
               this.field3489[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3487 = new short[var3];
            this.field3490 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3487[var4] = (short)var1.readUnsignedShort();
               this.field3490[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IS)Lee;",
      garbageValue = "8224"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      Model var2 = (Model)SpotAnimationDefinition_cachedModels.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2691(TotalQuantityComparator.SpotAnimationDefinition_modelIndexCache, this.field3486, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3493 != null) {
            for(var4 = 0; var4 < this.field3493.length; ++var4) {
               var3.recolor(this.field3493[var4], this.field3489[var4]);
            }
         }

         if(this.field3487 != null) {
            for(var4 = 0; var4 < this.field3487.length; ++var4) {
               var3.method2704(this.field3487[var4], this.field3490[var4]);
            }
         }

         var2 = var3.light(this.field3494 + 64, this.field3496 + 850, -30, -50, -30);
         SpotAnimationDefinition_cachedModels.put(var2, (long)this.id);
      }

      Model var5;
      if(this.field3495 != -1 && var1 != -1) {
         var5 = NPC.getAnimation(this.field3495).transformSpotAnimModel(var2, var1);
      } else {
         var5 = var2.toSharedSpotAnimModel(true);
      }

      if(this.widthScale != 128 || this.heightScale != 128) {
         var5.scale(this.widthScale, this.heightScale, this.widthScale);
      }

      if(this.orientation != 0) {
         if(this.orientation == 90) {
            var5.rotateY90Ccw();
         }

         if(this.orientation == 180) {
            var5.rotateY90Ccw();
            var5.rotateY90Ccw();
         }

         if(this.orientation == 270) {
            var5.rotateY90Ccw();
            var5.rotateY90Ccw();
            var5.rotateY90Ccw();
         }
      }

      return var5;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1739885827"
   )
   static int method4909(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1072200946"
   )
   static void method4910() {
      Client.mouseLastLastPressedTimeMillis = 1L;
      Client.field866 = -1;
      MapLabel.mouseRecorder.index = 0;
      GameCanvas.field643 = true;
      Client.field867 = true;
      Client.field1074 = -1L;
      BoundingBox3DDrawMode.method58();
      Client.field911.method2133();
      Client.field911.packetBuffer.offset = 0;
      Client.field911.serverPacket = null;
      Client.field911.field1467 = null;
      Client.field911.field1468 = null;
      Client.field911.field1458 = null;
      Client.field911.packetLength = 0;
      Client.field911.field1465 = 0;
      Client.field869 = 0;
      Client.field899 = 0;
      Client.hintArrowTargetType = 0;
      class3.method6();
      class7.method29(0);
      class95.chatLineMap.clear();
      class95.messages.clear();
      class95.field1429.clear();
      class95.field1431 = 0;
      Client.itemSelectionState = 0;
      Client.spellSelected = false;
      Client.queuedSoundEffectCount = 0;
      Client.mapAngle = 0;
      Client.field926 = 0;
      class19.field326 = null;
      Client.field1082 = 0;
      Client.field1075 = -1;
      Client.destinationX = 0;
      Client.destinationY = 0;
      Client.playerAttackOption = AttackOption.AttackOption_hidden;
      Client.npcAttackOption = AttackOption.AttackOption_hidden;
      Client.npcIndexesCount = 0;
      class93.playerIndexesCount = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         class93.field1404[var0] = null;
         class93.field1416[var0] = 1;
      }

      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      for(var0 = 0; var0 < 32768; ++var0) {
         Client.cachedNPCs[var0] = null;
      }

      Client.field978 = -1;
      Client.projectiles.clear();
      Client.graphicsObjectDeque.clear();

      int var2;
      for(var0 = 0; var0 < 4; ++var0) {
         for(int var1 = 0; var1 < 104; ++var1) {
            for(var2 = 0; var2 < 104; ++var2) {
               Client.groundItemDeque[var0][var1][var2] = null;
            }
         }
      }

      Client.pendingSpawns = new Deque();
      CacheFile.friendManager.method1802();

      for(var0 = 0; var0 < VarPlayerType.field3446; ++var0) {
         VarPlayerType var3 = class71.method1204(var0);
         if(var3 != null) {
            class237.serverVarps[var0] = 0;
            class237.clientVarps[var0] = 0;
         }
      }

      class160.varcs.reset();
      Client.field1057 = -1;
      if(Client.widgetRoot != -1) {
         var0 = Client.widgetRoot;
         if(var0 != -1 && class250.validInterfaces[var0]) {
            Widget.widgetIndex.method4675(var0);
            if(GZipDecompressor.widgets[var0] != null) {
               boolean var5 = true;

               for(var2 = 0; var2 < GZipDecompressor.widgets[var0].length; ++var2) {
                  if(GZipDecompressor.widgets[var0][var2] != null) {
                     if(GZipDecompressor.widgets[var0][var2].type != 2) {
                        GZipDecompressor.widgets[var0][var2] = null;
                     } else {
                        var5 = false;
                     }
                  }
               }

               if(var5) {
                  GZipDecompressor.widgets[var0] = null;
               }

               class250.validInterfaces[var0] = false;
            }
         }
      }

      for(WidgetNode var4 = (WidgetNode)Client.componentTable.first(); var4 != null; var4 = (WidgetNode)Client.componentTable.next()) {
         IndexFile.closeWidget(var4, true);
      }

      Client.widgetRoot = -1;
      Client.componentTable = new HashTable(8);
      Client.field1017 = null;
      class3.method6();
      Client.field1113.method4513((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.playerOptions[var0] = null;
         Client.playerOptionsPriorities[var0] = false;
      }

      ItemContainer.itemContainers = new HashTable(32);
      Client.field995 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field1055[var0] = true;
      }

      PacketNode var7 = AbstractSoundSystem.method2350(ClientPacket.field2422, Client.field911.field1460);
      PacketBuffer var6 = var7.packetBuffer;
      var2 = Client.isResized?2:1;
      var6.putByte(var2);
      var7.packetBuffer.putShort(FaceNormal.canvasWidth);
      var7.packetBuffer.putShort(class19.canvasHeight);
      Client.field911.method2135(var7);
      LoginPacket.clanMemberManager = null;

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new GrandExchangeOffer();
      }

      WorldMapType2.grandExchangeEvents = null;
   }
}
