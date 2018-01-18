import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Laz;I)V",
      garbageValue = "1596430382"
   )
   void vmethod695(WorldMapData var1);

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-76"
   )
   boolean vmethod696(int var1, int var2, int var3);

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-870088204"
   )
   boolean vmethod697(int var1, int var2);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "438384537"
   )
   int[] vmethod716(int var1, int var2, int var3);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)Lht;",
      garbageValue = "1662378690"
   )
   Coordinates vmethod694(int var1, int var2);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgv;I)V",
      garbageValue = "1961822977"
   )
   void vmethod700(Buffer var1);
}
