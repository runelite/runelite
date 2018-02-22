import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lai;B)V",
      garbageValue = "59"
   )
   void vmethod736(WorldMapData var1);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "2052357031"
   )
   boolean vmethod737(int var1, int var2, int var3);

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "1"
   )
   boolean vmethod745(int var1, int var2);

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-1022148607"
   )
   int[] vmethod738(int var1, int var2, int var3);

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)Lhp;",
      garbageValue = "-1642348517"
   )
   Coordinates vmethod739(int var1, int var2);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgn;I)V",
      garbageValue = "1338328003"
   )
   void vmethod741(Buffer var1);
}
