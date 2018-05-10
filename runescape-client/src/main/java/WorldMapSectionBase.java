import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Li;I)V",
      garbageValue = "-1657983190"
   )
   void vmethod692(WorldMapData var1);

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "1329615536"
   )
   @Export("containsCoord")
   boolean containsCoord(int var1, int var2, int var3);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1150064833"
   )
   boolean vmethod694(int var1, int var2);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-1657440355"
   )
   int[] vmethod712(int var1, int var2, int var3);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Lhh;",
      garbageValue = "2126255726"
   )
   Coordinates vmethod707(int var1, int var2);

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgy;S)V",
      garbageValue = "255"
   )
   void vmethod697(Buffer var1);
}
