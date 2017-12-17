import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lax;I)V",
      garbageValue = "-2145049745"
   )
   void vmethod695(WorldMapData var1);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "1120247978"
   )
   boolean vmethod708(int var1, int var2, int var3);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1865125342"
   )
   boolean vmethod698(int var1, int var2);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1197920526"
   )
   int[] vmethod700(int var1, int var2, int var3);

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)Lhc;",
      garbageValue = "-879620257"
   )
   Coordinates vmethod714(int var1, int var2);

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgh;I)V",
      garbageValue = "1638498953"
   )
   void vmethod701(Buffer var1);
}
