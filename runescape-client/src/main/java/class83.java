import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
public class class83 {
   @ObfuscatedName("w")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("messages")
   static final IterableHashTable messages;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   static final IterableDualNodeQueue field1205;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2021624217
   )
   static int field1208;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2076105995
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;
   @ObfuscatedName("ad")
   static int[] field1206;

   static {
      chatLineMap = new HashMap();
      messages = new IterableHashTable(1024);
      field1205 = new IterableDualNodeQueue();
      field1208 = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Liv;Liv;I)V",
      garbageValue = "-927941967"
   )
   public static void method1986(IndexDataBase var0, IndexDataBase var1) {
      KitDefinition.identKit_ref = var0;
      KitDefinition.field3320 = var1;
      KitDefinition.field3319 = KitDefinition.identKit_ref.fileCount(3);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lge;I)V",
      garbageValue = "1737338095"
   )
   @Export("initializeGPI")
   static final void initializeGPI(PacketBuffer var0) {
      var0.bitAccess();
      int var1 = Client.localInteractingIndex;
      Player var2 = MilliTimer.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.playerId = var1;
      int var3 = var0.getBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class178.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.getSize() << 6);
      var2.pathY[0] = var6 - CombatInfoListHolder.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.getSize() << 6);
      class192.plane = var2.field581 = var4;
      if(class81.field1179[var1] != null) {
         var2.decodeApperance(class81.field1179[var1]);
      }

      class81.playerIndexesCount = 0;
      class81.playerIndices[++class81.playerIndexesCount - 1] = var1;
      class81.field1183[var1] = 0;
      class81.field1182 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.getBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class81.Players_regions[var7] = (var10 << 14) + var11 + (var9 << 28);
            class81.Players_orientations[var7] = 0;
            class81.Players_targetIndices[var7] = -1;
            class81.field1175[++class81.field1182 - 1] = var7;
            class81.field1183[var7] = 0;
         }
      }

      var0.byteAccess();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-709266034"
   )
   static final int method1985(int var0, int var1) {
      int var2 = UnitPriceComparator.getSmoothNoise(var0 + 45365, 91923 + var1, 4) - 128 + (UnitPriceComparator.getSmoothNoise(10294 + var0, var1 + 37821, 2) - 128 >> 1) + (UnitPriceComparator.getSmoothNoise(var0, var1, 1) - 128 >> 2);
      var2 = (int)(0.3D * (double)var2) + 35;
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }
}
