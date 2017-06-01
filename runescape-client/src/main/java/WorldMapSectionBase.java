import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "952872297"
   )
   boolean vmethod696(int var1, int var2, int var3);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-106764697"
   )
   boolean vmethod707(int var1, int var2);

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-56"
   )
   void vmethod700(Buffer var1);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;B)V",
      garbageValue = "-1"
   )
   void vmethod695(WorldMapData var1);

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)LCoordinates;",
      garbageValue = "730410078"
   )
   Coordinates vmethod699(int var1, int var2);

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-578749739"
   )
   int[] vmethod698(int var1, int var2, int var3);
}
