import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-5"
   )
   boolean vmethod724(int var1, int var2, int var3);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "892960012"
   )
   int[] vmethod717(int var1, int var2, int var3);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Lclass212;",
      garbageValue = "-820164631"
   )
   Coordinates vmethod718(int var1, int var2);

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1671424373"
   )
   void vmethod719(Buffer var1);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass32;I)V",
      garbageValue = "-228062308"
   )
   void vmethod715(WorldMapData var1);

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "437687546"
   )
   boolean vmethod716(int var1, int var2);
}
