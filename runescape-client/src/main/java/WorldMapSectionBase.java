import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIS)Z",
      garbageValue = "-1713"
   )
   boolean vmethod676(int var1, int var2);

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-762941504"
   )
   boolean vmethod675(int var1, int var2, int var3);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lab;S)V",
      garbageValue = "-29128"
   )
   void vmethod693(WorldMapData var1);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Lhs;",
      garbageValue = "861336956"
   )
   Coordinates vmethod696(int var1, int var2);

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-1119600547"
   )
   int[] vmethod677(int var1, int var2, int var3);

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lfp;B)V",
      garbageValue = "-58"
   )
   void vmethod678(Buffer var1);
}
