import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lae;I)V",
      garbageValue = "-1518418003"
   )
   void vmethod701(WorldMapData var1);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-2038931748"
   )
   boolean vmethod702(int var1, int var2, int var3);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1297520065"
   )
   boolean vmethod703(int var1, int var2);

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-336358408"
   )
   int[] vmethod711(int var1, int var2, int var3);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Lhn;",
      garbageValue = "1673050917"
   )
   Coordinates vmethod700(int var1, int var2);

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgj;B)V",
      garbageValue = "7"
   )
   void vmethod706(Buffer var1);
}
