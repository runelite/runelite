import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kk")
public class class288 {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   @Export("ItemDefinition_modelIndexCache")
   public static IndexDataBase ItemDefinition_modelIndexCache;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgb;I)V",
      garbageValue = "-1915704053"
   )
   @Export("initializeGPI")
   static final void initializeGPI(PacketBuffer var0) {
      var0.bitAccess();
      int var1 = Client.localInteractingIndex;
      Player var2 = TotalQuantityComparator.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field845 = var1;
      int var3 = var0.getBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - WorldMapType1.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.getSize() << 6);
      var2.pathY[0] = var6 - Enum.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.getSize() << 6);
      class36.plane = var2.field844 = var4;
      if(class93.field1412[var1] != null) {
         var2.decodeApperance(class93.field1412[var1]);
      }

      class93.playerIndexesCount = 0;
      class93.playerIndices[++class93.playerIndexesCount - 1] = var1;
      class93.field1403[var1] = 0;
      class93.field1408 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.getBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class93.Players_regions[var7] = (var10 << 14) + var11 + (var9 << 28);
            class93.Players_orientations[var7] = 0;
            class93.Players_targetIndices[var7] = -1;
            class93.field1409[++class93.field1408 - 1] = var7;
            class93.field1403[var7] = 0;
         }
      }

      var0.byteAccess();
   }
}
