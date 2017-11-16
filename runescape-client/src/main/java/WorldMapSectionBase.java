import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lam;I)V",
      garbageValue = "1999614542"
   )
   void vmethod670(WorldMapData var1);

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "16"
   )
   boolean vmethod667(int var1, int var2, int var3);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "748684240"
   )
   boolean vmethod668(int var1, int var2);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1806249195"
   )
   int[] vmethod682(int var1, int var2, int var3);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)Lhk;",
      garbageValue = "-98479540"
   )
   Coordinates vmethod669(int var1, int var2);

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfs;I)V",
      garbageValue = "-1450864888"
   )
   void vmethod665(Buffer var1);
}
