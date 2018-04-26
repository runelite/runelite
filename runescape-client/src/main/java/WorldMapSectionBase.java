import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Las;I)V",
      garbageValue = "1011910161"
   )
   void vmethod763(WorldMapData var1);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "516050332"
   )
   @Export("containsCoord")
   boolean containsCoord(int var1, int var2, int var3);

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "2066198604"
   )
   boolean vmethod766(int var1, int var2);

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIB)[I",
      garbageValue = "-3"
   )
   int[] vmethod767(int var1, int var2, int var3);

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)Lio;",
      garbageValue = "0"
   )
   Coordinates vmethod768(int var1, int var2);

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lgg;B)V",
      garbageValue = "67"
   )
   void vmethod769(Buffer var1);
}
