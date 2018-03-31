import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public abstract class class28 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1933136371
   )
   int field390;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -966457239
   )
   int field387;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -968862399
   )
   int field386;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -876930749
   )
   int field389;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 255482217
   )
   int field392;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1335733053
   )
   int field391;
   @ObfuscatedName("z")
   short[][][] field388;
   @ObfuscatedName("p")
   short[][][] field393;
   @ObfuscatedName("w")
   byte[][][] field394;
   @ObfuscatedName("r")
   byte[][][] field395;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[[[[Lak;"
   )
   @Export("decorations")
   WorldMapDecoration[][][][] decorations;

   class28() {
      new LinkedList();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IILgp;I)V",
      garbageValue = "-668155890"
   )
   void method241(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method243(var1, var2, var3, var4);
         } else {
            this.method244(var1, var2, var3, var4);
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IILgp;II)V",
      garbageValue = "-439600063"
   )
   void method243(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field393[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field388[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IILgp;II)V",
      garbageValue = "-1570259589"
   )
   void method244(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field388[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var10 = var3.readUnsignedByte();
            if(var10 != 0) {
               this.field393[var9][var1][var2] = (short)var10;
               var11 = var3.readUnsignedByte();
               this.field394[var9][var1][var2] = (byte)(var11 >> 2);
               this.field395[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               WorldMapDecoration[] var14 = this.decorations[var8][var1][var2] = new WorldMapDecoration[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method3603();
                  int var13 = var3.readUnsignedByte();
                  var14[var11] = new WorldMapDecoration(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "74"
   )
   int method264(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field388[0][var1][var2] - 1:-1):-1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1347687077"
   )
   int method260() {
      return this.field386;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "373399447"
   )
   int method247() {
      return this.field389;
   }

   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "(Lib;IIII)V",
      garbageValue = "-1019322065"
   )
   static final void method268(Widget var0, int var1, int var2, int var3) {
      class33.method384();
      class236 var4 = var0.method4475(false);
      if(var4 != null) {
         Rasterizer2D.setDrawRegion(var1, var2, var4.field2765 + var1, var2 + var4.field2763);
         if(Client.field1087 != 2 && Client.field1087 != 5) {
            int var5 = Client.mapAngle & 2047;
            int var6 = WorldComparator.localPlayer.x / 32 + 48;
            int var7 = 464 - WorldComparator.localPlayer.y / 32;
            ServerPacket.minimapSprite.method5886(var1, var2, var4.field2765, var4.field2763, var6, var7, var5, 256, var4.field2766, var4.field2768);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < Client.field1081; ++var8) {
               var9 = Client.field1082[var8] * 4 + 2 - WorldComparator.localPlayer.x / 32;
               var10 = Client.field1083[var8] * 4 + 2 - WorldComparator.localPlayer.y / 32;
               BaseVarType.drawDot(var1, var2, var9, var10, Client.mapIcons[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  Deque var15 = Client.groundItemDeque[class237.plane][var8][var9];
                  if(var15 != null) {
                     var11 = var8 * 4 + 2 - WorldComparator.localPlayer.x / 32;
                     var12 = var9 * 4 + 2 - WorldComparator.localPlayer.y / 32;
                     BaseVarType.drawDot(var1, var2, var11, var12, SceneTilePaint.mapDots[0], var4);
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

                  if(var18 != null && var18.isMinimapVisible && var18.field3729) {
                     var11 = var16.x / 32 - WorldComparator.localPlayer.x / 32;
                     var12 = var16.y / 32 - WorldComparator.localPlayer.y / 32;
                     BaseVarType.drawDot(var1, var2, var11, var12, SceneTilePaint.mapDots[1], var4);
                  }
               }
            }

            var8 = class93.playerIndexesCount;
            int[] var19 = class93.playerIndices;

            for(var10 = 0; var10 < var8; ++var10) {
               Player var17 = Client.cachedPlayers[var19[var10]];
               if(var17 != null && var17.hasConfig() && !var17.hidden && var17 != WorldComparator.localPlayer) {
                  var12 = var17.x / 32 - WorldComparator.localPlayer.x / 32;
                  int var13 = var17.y / 32 - WorldComparator.localPlayer.y / 32;
                  boolean var14 = false;
                  if(WorldComparator.localPlayer.team != 0 && var17.team != 0 && var17.team == WorldComparator.localPlayer.team) {
                     var14 = true;
                  }

                  if(var17.isFriend()) {
                     BaseVarType.drawDot(var1, var2, var12, var13, SceneTilePaint.mapDots[3], var4);
                  } else if(var14) {
                     BaseVarType.drawDot(var1, var2, var12, var13, SceneTilePaint.mapDots[4], var4);
                  } else if(var17.isClanMember()) {
                     BaseVarType.drawDot(var1, var2, var12, var13, SceneTilePaint.mapDots[5], var4);
                  } else {
                     BaseVarType.drawDot(var1, var2, var12, var13, SceneTilePaint.mapDots[2], var4);
                  }
               }
            }

            if(Client.hintArrowTargetType != 0 && Client.gameCycle % 20 < 10) {
               if(Client.hintArrowTargetType == 1 && Client.hintArrowNpcTargetIdx >= 0 && Client.hintArrowNpcTargetIdx < Client.cachedNPCs.length) {
                  NPC var20 = Client.cachedNPCs[Client.hintArrowNpcTargetIdx];
                  if(var20 != null) {
                     var11 = var20.x / 32 - WorldComparator.localPlayer.x / 32;
                     var12 = var20.y / 32 - WorldComparator.localPlayer.y / 32;
                     Signlink.worldToMinimap(var1, var2, var11, var12, class64.mapMarkers[1], var4);
                  }
               }

               if(Client.hintArrowTargetType == 2) {
                  var10 = Client.hintArrowX * 4 - PacketNode.baseX * 4 + 2 - WorldComparator.localPlayer.x / 32;
                  var11 = Client.hintArrowY * 4 - BaseVarType.baseY * 4 + 2 - WorldComparator.localPlayer.y / 32;
                  Signlink.worldToMinimap(var1, var2, var10, var11, class64.mapMarkers[1], var4);
               }

               if(Client.hintArrowTargetType == 10 && Client.hintArrowPlayerTargetIdx >= 0 && Client.hintArrowPlayerTargetIdx < Client.cachedPlayers.length) {
                  Player var21 = Client.cachedPlayers[Client.hintArrowPlayerTargetIdx];
                  if(var21 != null) {
                     var11 = var21.x / 32 - WorldComparator.localPlayer.x / 32;
                     var12 = var21.y / 32 - WorldComparator.localPlayer.y / 32;
                     Signlink.worldToMinimap(var1, var2, var11, var12, class64.mapMarkers[1], var4);
                  }
               }
            }

            if(Client.destinationX != 0) {
               var10 = Client.destinationX * 4 + 2 - WorldComparator.localPlayer.x / 32;
               var11 = Client.destinationY * 4 + 2 - WorldComparator.localPlayer.y / 32;
               BaseVarType.drawDot(var1, var2, var10, var11, class64.mapMarkers[0], var4);
            }

            if(!WorldComparator.localPlayer.hidden) {
               Rasterizer2D.Rasterizer2D_fillRectangle(var4.field2765 / 2 + var1 - 1, var4.field2763 / 2 + var2 - 1, 3, 3, 16777215);
            }
         } else {
            Rasterizer2D.method5759(var1, var2, 0, var4.field2766, var4.field2768);
         }

         Client.field1061[var3] = true;
      }
   }
}
