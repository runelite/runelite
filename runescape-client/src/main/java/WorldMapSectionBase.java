import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lap;I)V",
      garbageValue = "-695326084"
   )
   void vmethod772(WorldMapData var1);

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "2104062915"
   )
   boolean vmethod778(int var1, int var2, int var3);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "0"
   )
   boolean vmethod774(int var1, int var2);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-579666919"
   )
   int[] vmethod775(int var1, int var2, int var3);

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)Lhq;",
      garbageValue = "1"
   )
   Coordinates vmethod797(int var1, int var2);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfv;S)V",
      garbageValue = "256"
   )
   void vmethod777(Buffer var1);
}
