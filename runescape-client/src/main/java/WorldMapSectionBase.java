import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "202348652"
   )
   boolean vmethod754(int var1, int var2);

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1509988890"
   )
   int[] vmethod730(int var1, int var2, int var3);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "618655756"
   )
   void vmethod732(Buffer var1);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;I)V",
      garbageValue = "98017718"
   )
   void vmethod753(WorldMapData var1);

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)LCoordinates;",
      garbageValue = "-2079571098"
   )
   Coordinates vmethod731(int var1, int var2);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "998947175"
   )
   boolean vmethod728(int var1, int var2, int var3);
}
