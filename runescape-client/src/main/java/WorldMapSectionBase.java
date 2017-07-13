import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-2141582860"
   )
   boolean vmethod722(int var1, int var2);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-1671303044"
   )
   boolean vmethod721(int var1, int var2, int var3);

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;I)V",
      garbageValue = "-1824757307"
   )
   void vmethod720(WorldMapData var1);

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)LCoordinates;",
      garbageValue = "665140774"
   )
   Coordinates vmethod743(int var1, int var2);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIB)[I",
      garbageValue = "13"
   )
   int[] vmethod731(int var1, int var2, int var3);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1909314997"
   )
   void vmethod746(Buffer var1);
}
