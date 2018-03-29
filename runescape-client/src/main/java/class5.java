import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
final class class5 implements class0 {
   @ObfuscatedName("al")
   static int[] field34;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      longValue = 6079803649789686173L
   )
   static long field35;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lgf;S)V",
      garbageValue = "1602"
   )
   @Export("initializeGPI")
   static final void initializeGPI(PacketBuffer var0) {
      var0.bitAccess();
      int var1 = Client.localInteractingIndex;
      Player var2 = WorldComparator.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field843 = var1;
      int var3 = var0.getBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - PacketNode.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.getSize() << 6);
      var2.pathY[0] = var6 - BaseVarType.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.getSize() << 6);
      class237.plane = var2.field842 = var4;
      if(class93.field1413[var1] != null) {
         var2.decodeApperance(class93.field1413[var1]);
      }

      class93.playerIndexesCount = 0;
      class93.playerIndices[++class93.playerIndexesCount - 1] = var1;
      class93.field1411[var1] = 0;
      class93.field1416 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.getBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class93.Players_regions[var7] = (var10 << 14) + var11 + (var9 << 28);
            class93.Players_orientations[var7] = 0;
            class93.Players_targetIndices[var7] = -1;
            class93.field1418[++class93.field1416 - 1] = var7;
            class93.field1411[var7] = 0;
         }
      }

      var0.byteAccess();
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1521419694"
   )
   @Export("decodeContainer")
   static final byte[] decodeContainer(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 < 0 || IndexDataBase.field3383 != 0 && var3 > IndexDataBase.field3383) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var4 = new byte[var3];
         var1.readBytes(var4, 0, var3);
         return var4;
      } else {
         int var6 = var1.readInt();
         if(var6 >= 0 && (IndexDataBase.field3383 == 0 || var6 <= IndexDataBase.field3383)) {
            byte[] var5 = new byte[var6];
            if(var2 == 1) {
               class188.Bzip2Decompressor_decompress(var5, var6, var0, var3, 9);
            } else {
               IndexDataBase.gzip.decompress(var1, var5);
            }

            return var5;
         } else {
            throw new RuntimeException();
         }
      }
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1453085921"
   )
   @Export("getTileHeight")
   static final int getTileHeight(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class62.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = class62.tileHeights[var5][var3 + 1][var4] * var6 + (128 - var6) * class62.tileHeights[var5][var3][var4] >> 7;
         int var9 = class62.tileHeights[var5][var3][var4 + 1] * (128 - var6) + var6 * class62.tileHeights[var5][var3 + 1][var4 + 1] >> 7;
         return var7 * var9 + var8 * (128 - var7) >> 7;
      } else {
         return 0;
      }
   }
}
