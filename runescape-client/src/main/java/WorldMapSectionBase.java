import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Las;I)V",
      garbageValue = "269119455"
   )
   void vmethod751(WorldMapData var1);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "520265099"
   )
   @Export("containsCoord")
   boolean containsCoord(int var1, int var2, int var3);

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIS)Z",
      garbageValue = "9376"
   )
   boolean vmethod758(int var1, int var2);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "174791792"
   )
   int[] vmethod754(int var1, int var2, int var3);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)Lim;",
      garbageValue = "-64"
   )
   Coordinates vmethod777(int var1, int var2);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgp;I)V",
      garbageValue = "-314407075"
   )
   void vmethod756(Buffer var1);
}
