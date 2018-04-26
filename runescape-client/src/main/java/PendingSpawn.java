import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("j")
   public static String[] field1134;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1557638447
   )
   @Export("level")
   int level;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -452890025
   )
   @Export("type")
   int type;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 966621815
   )
   @Export("x")
   int x;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 963470503
   )
   int field1130;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -723973393
   )
   @Export("y")
   int y;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 178603571
   )
   int field1128;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -424408731
   )
   int field1132;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1062376191
   )
   @Export("id")
   int id;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1580920681
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1112313113
   )
   int field1135;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1646880569
   )
   @Export("delay")
   int delay;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -149955841
   )
   @Export("hitpoints")
   int hitpoints;

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljr;I)V",
      garbageValue = "1127595273"
   )
   public static void method1700(IndexDataBase var0) {
      FloorUnderlayDefinition.underlay_ref = var0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgl;I)V",
      garbageValue = "1166215988"
   )
   @Export("initializeGPI")
   static final void initializeGPI(PacketBuffer var0) {
      var0.bitAccess();
      int var1 = Client.localInteractingIndex;
      Player var2 = class265.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.playerId = var1;
      int var3 = var0.getBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - ClientPacket.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.getSize() << 6);
      var2.pathY[0] = var6 - MapIconReference.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.getSize() << 6);
      ScriptVarType.plane = var2.field831 = var4;
      if(class93.field1404[var1] != null) {
         var2.decodeApperance(class93.field1404[var1]);
      }

      class93.playerIndexesCount = 0;
      class93.playerIndices[++class93.playerIndexesCount - 1] = var1;
      class93.field1415[var1] = 0;
      class93.field1409 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.getBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class93.Players_regions[var7] = (var10 << 14) + var11 + (var9 << 28);
            class93.Players_orientations[var7] = 0;
            class93.Players_targetIndices[var7] = -1;
            class93.field1410[++class93.field1409 - 1] = var7;
            class93.field1415[var7] = 0;
         }
      }

      var0.byteAccess();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-193029915"
   )
   public static final void method1701() {
      while(true) {
         BoundingBox var0 = (BoundingBox)class7.boundingBoxes.removeLast();
         if(var0 == null) {
            return;
         }

         var0.vmethod51();
      }
   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "943377856"
   )
   static final void method1698(int var0, int var1, int var2, boolean var3) {
      if(class85.loadWidget(var0)) {
         class45.method680(GZipDecompressor.widgets[var0], -1, var1, var2, var3);
      }
   }
}
