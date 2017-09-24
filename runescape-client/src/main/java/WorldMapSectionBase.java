import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "59"
   )
   boolean vmethod747(int var1, int var2);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "1746025354"
   )
   boolean vmethod746(int var1, int var2, int var3);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lam;I)V",
      garbageValue = "2013920575"
   )
   void vmethod745(WorldMapData var1);

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)Lhs;",
      garbageValue = "1278074658"
   )
   Coordinates vmethod771(int var1, int var2);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1584803853"
   )
   int[] vmethod757(int var1, int var2, int var3);

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "-1644047401"
   )
   void vmethod751(Buffer var1);
}
