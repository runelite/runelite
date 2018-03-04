import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lal;B)V",
      garbageValue = "-33"
   )
   void vmethod716(WorldMapData var1);

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-1122721489"
   )
   boolean vmethod712(int var1, int var2, int var3);

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-78"
   )
   boolean vmethod715(int var1, int var2);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "606812260"
   )
   int[] vmethod714(int var1, int var2, int var3);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Lic;",
      garbageValue = "-1902472796"
   )
   Coordinates vmethod717(int var1, int var2);

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "241325114"
   )
   void vmethod718(Buffer var1);
}
