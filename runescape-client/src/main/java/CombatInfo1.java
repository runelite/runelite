import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("t")
   static int[] field1189;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1601973829
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1616408329
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 664186193
   )
   @Export("health")
   int health;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 104636013
   )
   @Export("int2")
   int int2;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.cycle = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.int2 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1829541162"
   )
   @Export("set")
   void set(int var1, int var2, int var3, int var4) {
      this.cycle = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.int2 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "-1393995156"
   )
   @Export("initializeGPI")
   static final void initializeGPI(PacketBuffer var0) {
      var0.bitAccess();
      int var1 = Client.localInteractingIndex;
      Player var2 = UrlRequest.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field810 = var1;
      int var3 = var0.getBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class46.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.getSize() << 6);
      var2.pathY[0] = var6 - Client.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.getSize() << 6);
      BoundingBox2D.plane = var2.field821 = var4;
      if(class94.field1392[var1] != null) {
         var2.decodeApperance(class94.field1392[var1]);
      }

      class94.playerIndexesCount = 0;
      class94.playerIndices[++class94.playerIndexesCount - 1] = var1;
      class94.field1389[var1] = 0;
      class94.field1394 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.getBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class94.Players_regions[var7] = (var10 << 14) + var11 + (var9 << 28);
            class94.Players_orientations[var7] = 0;
            class94.Players_targetIndices[var7] = -1;
            class94.field1395[++class94.field1394 - 1] = var7;
            class94.field1389[var7] = 0;
         }
      }

      var0.byteAccess();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1350801763"
   )
   static final int method1490(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }
}
