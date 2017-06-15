import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;I)V",
      garbageValue = "-466828627"
   )
   void vmethod680(WorldMapData var1);

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "630255391"
   )
   int[] vmethod682(int var1, int var2, int var3);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)LCoordinates;",
      garbageValue = "-1537373407"
   )
   Coordinates vmethod685(int var1, int var2);

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1315256502"
   )
   void vmethod684(Buffer var1);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "108"
   )
   boolean vmethod679(int var1, int var2);

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-2095092414"
   )
   boolean vmethod678(int var1, int var2, int var3);
}
