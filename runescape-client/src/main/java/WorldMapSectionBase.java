import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-198305855"
   )
   boolean vmethod715(int var1, int var2);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIS)Z",
      garbageValue = "4496"
   )
   boolean vmethod714(int var1, int var2, int var3);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lae;B)V",
      garbageValue = "103"
   )
   void vmethod713(WorldMapData var1);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)Lhy;",
      garbageValue = "-93"
   )
   Coordinates vmethod717(int var1, int var2);

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIB)[I",
      garbageValue = "32"
   )
   int[] vmethod716(int var1, int var2, int var3);

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfw;I)V",
      garbageValue = "996105043"
   )
   void vmethod718(Buffer var1);
}
