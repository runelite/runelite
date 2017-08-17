import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "122"
   )
   boolean vmethod762(int var1, int var2);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "1"
   )
   boolean vmethod741(int var1, int var2, int var3);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lab;I)V",
      garbageValue = "239959050"
   )
   void vmethod740(WorldMapData var1);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)Lhh;",
      garbageValue = "0"
   )
   Coordinates vmethod744(int var1, int var2);

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "216213566"
   )
   int[] vmethod759(int var1, int var2, int var3);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfb;I)V",
      garbageValue = "-2081425823"
   )
   void vmethod742(Buffer var1);
}
