import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Laz;I)V",
      garbageValue = "1173479592"
   )
   void vmethod762(WorldMapData var1);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-52"
   )
   @Export("containsCoord")
   boolean containsCoord(int var1, int var2, int var3);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "53"
   )
   boolean vmethod764(int var1, int var2);

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-653420606"
   )
   int[] vmethod765(int var1, int var2, int var3);

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)Lik;",
      garbageValue = "-2033075237"
   )
   Coordinates vmethod770(int var1, int var2);

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgb;I)V",
      garbageValue = "1382348566"
   )
   void vmethod761(Buffer var1);
}
