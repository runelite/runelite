import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1359106856"
   )
   boolean vmethod722(int var1, int var2);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-1997246299"
   )
   boolean vmethod725(int var1, int var2, int var3);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Las;B)V",
      garbageValue = "125"
   )
   void vmethod723(WorldMapData var1);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)Lhl;",
      garbageValue = "-58"
   )
   Coordinates vmethod727(int var1, int var2);

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-170036108"
   )
   int[] vmethod741(int var1, int var2, int var3);

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfg;B)V",
      garbageValue = "88"
   )
   void vmethod728(Buffer var1);
}
