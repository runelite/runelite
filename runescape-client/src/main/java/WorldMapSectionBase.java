import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lah;I)V",
      garbageValue = "634115433"
   )
   void vmethod767(WorldMapData var1);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "29"
   )
   @Export("containsCoord")
   boolean containsCoord(int var1, int var2, int var3);

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "230864345"
   )
   boolean vmethod768(int var1, int var2);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIB)[I",
      garbageValue = "40"
   )
   int[] vmethod753(int var1, int var2, int var3);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIB)Lix;",
      garbageValue = "-31"
   )
   Coordinates vmethod758(int var1, int var2);

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgc;I)V",
      garbageValue = "-2042290425"
   )
   void vmethod754(Buffer var1);
}
