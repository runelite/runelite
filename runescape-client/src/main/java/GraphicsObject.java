import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("GraphicsObject")
public final class GraphicsObject extends Renderable {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 919361389
   )
   @Export("id")
   int id;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1290142819
   )
   @Export("startCycle")
   int startCycle;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1242776535
   )
   @Export("level")
   int level;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1019854305
   )
   @Export("height")
   int height;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2038800075
   )
   @Export("x")
   int x;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1889723369
   )
   @Export("y")
   int y;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lkc;"
   )
   Sequence field1282;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1792899023
   )
   int field1286;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 403675153
   )
   int field1287;
   @ObfuscatedName("h")
   @Export("finished")
   boolean finished;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1286 = 0;
      this.field1287 = 0;
      this.finished = false;
      this.id = var1;
      this.level = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.startCycle = var7 + var6;
      int var8 = WidgetNode.getSpotAnimType(this.id).field3495;
      if(var8 != -1) {
         this.finished = false;
         this.field1282 = NPC.getAnimation(var8);
      } else {
         this.finished = true;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1084773454"
   )
   final void method1914(int var1) {
      if(!this.finished) {
         this.field1287 += var1;

         while(this.field1287 > this.field1282.frameLengths[this.field1286]) {
            this.field1287 -= this.field1282.frameLengths[this.field1286];
            ++this.field1286;
            if(this.field1286 >= this.field1282.frameIDs.length) {
               this.finished = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lee;",
      garbageValue = "-1967116980"
   )
   protected final Model getModel() {
      Spotanim var1 = WidgetNode.getSpotAnimType(this.id);
      Model var2;
      if(!this.finished) {
         var2 = var1.getModel(this.field1286);
      } else {
         var2 = var1.getModel(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljr;I)V",
      garbageValue = "-2136614880"
   )
   public static void method1922(IndexDataBase var0) {
      VarPlayerType.varplayer_ref = var0;
      VarPlayerType.field3446 = VarPlayerType.varplayer_ref.fileCount(16);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "0"
   )
   public static int method1919(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BZB)Ljava/lang/Object;",
      garbageValue = "0"
   )
   @Export("byteArrayToObject")
   public static Object byteArrayToObject(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !AbstractByteBuffer.directBufferUnavailable) {
            try {
               DirectByteBuffer var2 = new DirectByteBuffer();
               var2.put(var0);
               return var2;
            } catch (Throwable var3) {
               AbstractByteBuffer.directBufferUnavailable = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(ZLgl;I)V",
      garbageValue = "-454879532"
   )
   @Hook("onNpcUpdate")
   @Export("updateNpcs")
   static final void updateNpcs(boolean var0, PacketBuffer var1) {
      Client.field972 = 0;
      Client.pendingNpcFlagsCount = 0;
      class28.method244();

      int var2;
      NPC var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      while(var1.bitsAvail(Client.field911.packetLength) >= 27) {
         var2 = var1.getBits(15);
         if(var2 == 32767) {
            break;
         }

         boolean var3 = false;
         if(Client.cachedNPCs[var2] == null) {
            Client.cachedNPCs[var2] = new NPC();
            var3 = true;
         }

         var4 = Client.cachedNPCs[var2];
         Client.npcIndices[++Client.npcIndexesCount - 1] = var2;
         var4.npcCycle = Client.gameCycle;
         if(var0) {
            var5 = var1.getBits(8);
            if(var5 > 127) {
               var5 -= 256;
            }
         } else {
            var5 = var1.getBits(5);
            if(var5 > 15) {
               var5 -= 32;
            }
         }

         if(var0) {
            var6 = var1.getBits(8);
            if(var6 > 127) {
               var6 -= 256;
            }
         } else {
            var6 = var1.getBits(5);
            if(var6 > 15) {
               var6 -= 32;
            }
         }

         var7 = var1.getBits(1);
         var8 = var1.getBits(1);
         if(var8 == 1) {
            Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
         }

         var4.composition = SceneTilePaint.getNpcDefinition(var1.getBits(14));
         var9 = Client.field851[var1.getBits(3)];
         if(var3) {
            var4.orientation = var4.angle = var9;
         }

         var4.field1143 = var4.composition.size;
         var4.field1193 = var4.composition.rotation;
         if(var4.field1193 == 0) {
            var4.angle = 0;
         }

         var4.field1148 = var4.composition.walkingAnimation;
         var4.field1149 = var4.composition.rotate180Animation;
         var4.field1150 = var4.composition.rotate90RightAnimation;
         var4.field1180 = var4.composition.rotate90LeftAnimation;
         var4.idlePoseAnimation = var4.composition.standingAnimation;
         var4.field1189 = var4.composition.field3713;
         var4.field1157 = var4.composition.field3717;
         var4.method1941(class265.localPlayer.pathX[0] + var6, class265.localPlayer.pathY[0] + var5, var7 == 1);
      }

      var1.byteAccess();

      int var14;
      for(var2 = 0; var2 < Client.pendingNpcFlagsCount; ++var2) {
         var14 = Client.pendingNpcFlagsIndices[var2];
         var4 = Client.cachedNPCs[var14];
         var5 = var1.readUnsignedByte();
         if((var5 & 8) != 0) {
            var6 = var1.method3627();
            var7 = var1.method3635();
            var8 = var4.x - (var6 - ClientPacket.baseX - ClientPacket.baseX) * 64;
            var9 = var4.y - (var7 - MapIconReference.baseY - MapIconReference.baseY) * 64;
            if(var8 != 0 || var9 != 0) {
               var4.field1168 = (int)(Math.atan2((double)var8, (double)var9) * 325.949D) & 2047;
            }
         }

         if((var5 & 64) != 0) {
            var4.interacting = var1.readUnsignedShort();
            if(var4.interacting == 65535) {
               var4.interacting = -1;
            }
         }

         if((var5 & 4) != 0) {
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
                  var4.applyActorHitsplat(var8, var10, var9, var11, Client.gameCycle, var12);
               }
            }

            var7 = var1.readUnsignedByte();
            if(var7 > 0) {
               for(var8 = 0; var8 < var7; ++var8) {
                  var9 = var1.getUSmart();
                  var10 = var1.getUSmart();
                  if(var10 != 32767) {
                     var11 = var1.getUSmart();
                     var12 = var1.readUnsignedByte();
                     int var13 = var10 > 0?var1.method3628():var12;
                     var4.setCombatInfo(var9, Client.gameCycle, var10, var11, var12, var13);
                  } else {
                     var4.method1704(var9);
                  }
               }
            }
         }

         if((var5 & 1) != 0) {
            var4.overhead = var1.readString();
            var4.overheadTextCyclesRemaining = 100;
         }

         if((var5 & 32) != 0) {
            var4.graphic = var1.method3636();
            var6 = var1.readInt();
            var4.field1187 = var6 >> 16;
            var4.graphicsDelay = (var6 & 65535) + Client.gameCycle;
            var4.spotAnimFrame = 0;
            var4.spotAnimFrameCycle = 0;
            if(var4.graphicsDelay > Client.gameCycle) {
               var4.spotAnimFrame = -1;
            }

            if(var4.graphic == 65535) {
               var4.graphic = -1;
            }
         }

         if((var5 & 2) != 0) {
            var4.composition = SceneTilePaint.getNpcDefinition(var1.readUnsignedShort());
            var4.field1143 = var4.composition.size;
            var4.field1193 = var4.composition.rotation;
            var4.field1148 = var4.composition.walkingAnimation;
            var4.field1149 = var4.composition.rotate180Animation;
            var4.field1150 = var4.composition.rotate90RightAnimation;
            var4.field1180 = var4.composition.rotate90LeftAnimation;
            var4.idlePoseAnimation = var4.composition.standingAnimation;
            var4.field1189 = var4.composition.field3713;
            var4.field1157 = var4.composition.field3717;
         }

         if((var5 & 16) != 0) {
            var6 = var1.method3635();
            if(var6 == 65535) {
               var6 = -1;
            }

            var7 = var1.method3626();
            if(var6 == var4.animation && var6 != -1) {
               var8 = NPC.getAnimation(var6).replyMode;
               if(var8 == 1) {
                  var4.actionFrame = 0;
                  var4.actionFrameCycle = 0;
                  var4.actionAnimationDisable = var7;
                  var4.field1176 = 0;
               }

               if(var8 == 2) {
                  var4.field1176 = 0;
               }
            } else if(var6 == -1 || var4.animation == -1 || NPC.getAnimation(var6).forcedPriority >= NPC.getAnimation(var4.animation).forcedPriority) {
               var4.animation = var6;
               var4.actionFrame = 0;
               var4.actionFrameCycle = 0;
               var4.actionAnimationDisable = var7;
               var4.field1176 = 0;
               var4.field1178 = var4.queueSize;
            }
         }
      }

      for(var2 = 0; var2 < Client.field972; ++var2) {
         var14 = Client.field973[var2];
         if(Client.cachedNPCs[var14].npcCycle != Client.gameCycle) {
            Client.cachedNPCs[var14].composition = null;
            Client.cachedNPCs[var14] = null;
         }
      }

      if(var1.offset != Client.field911.packetLength) {
         throw new RuntimeException(var1.offset + "," + Client.field911.packetLength);
      } else {
         for(var2 = 0; var2 < Client.npcIndexesCount; ++var2) {
            if(Client.cachedNPCs[Client.npcIndices[var2]] == null) {
               throw new RuntimeException(var2 + "," + Client.npcIndexesCount);
            }
         }

      }
   }

   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1875990607"
   )
   static final void method1920(int var0, int var1) {
      if(class85.loadWidget(var0)) {
         class61.method1091(GZipDecompressor.widgets[var0], var1);
      }
   }
}
