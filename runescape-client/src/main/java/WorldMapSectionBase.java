import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lal;I)V",
      garbageValue = "1038625343"
   )
   void vmethod724(WorldMapData var1);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "952023960"
   )
   boolean vmethod728(int var1, int var2, int var3);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-27"
   )
   boolean vmethod716(int var1, int var2);

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-495685061"
   )
   int[] vmethod717(int var1, int var2, int var3);

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)Lhp;",
      garbageValue = "1"
   )
   Coordinates vmethod741(int var1, int var2);

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lfr;I)V",
      garbageValue = "-1975557779"
   )
   void vmethod719(Buffer var1);
}
