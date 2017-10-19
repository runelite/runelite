import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "2005574810"
   )
   boolean vmethod700(int var1, int var2);

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "2147483647"
   )
   boolean vmethod699(int var1, int var2, int var3);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lat;I)V",
      garbageValue = "1123585680"
   )
   void vmethod720(WorldMapData var1);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Lhg;",
      garbageValue = "-1413226110"
   )
   Coordinates vmethod702(int var1, int var2);

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "880778915"
   )
   int[] vmethod709(int var1, int var2, int var3);

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lfz;B)V",
      garbageValue = "15"
   )
   void vmethod703(Buffer var1);
}
