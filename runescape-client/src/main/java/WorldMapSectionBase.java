import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-203277119"
   )
   boolean vmethod713(int var1, int var2);

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)LCoordinates;",
      garbageValue = "1721490041"
   )
   Coordinates vmethod696(int var1, int var2);

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-2062162233"
   )
   void vmethod697(Buffer var1);

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-126"
   )
   boolean vmethod693(int var1, int var2, int var3);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIB)[I",
      garbageValue = "-1"
   )
   int[] vmethod695(int var1, int var2, int var3);

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;B)V",
      garbageValue = "101"
   )
   void vmethod692(WorldMapData var1);
}
