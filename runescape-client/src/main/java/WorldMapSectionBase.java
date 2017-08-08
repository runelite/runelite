import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-39567884"
   )
   boolean vmethod705(int var1, int var2);

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "2062801574"
   )
   boolean vmethod704(int var1, int var2, int var3);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lae;B)V",
      garbageValue = "-3"
   )
   void vmethod703(WorldMapData var1);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Lhq;",
      garbageValue = "578346769"
   )
   Coordinates vmethod728(int var1, int var2);

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-670381390"
   )
   int[] vmethod706(int var1, int var2, int var3);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfh;B)V",
      garbageValue = "0"
   )
   void vmethod716(Buffer var1);
}
