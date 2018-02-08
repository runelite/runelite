import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
@Implements("WorldMapSectionBase")
public interface WorldMapSectionBase {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Las;I)V",
      garbageValue = "-1901809840"
   )
   void vmethod681(WorldMapData var1);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-76"
   )
   boolean vmethod682(int var1, int var2, int var3);

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1516873803"
   )
   boolean vmethod683(int var1, int var2);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-28346373"
   )
   int[] vmethod684(int var1, int var2, int var3);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)Lhv;",
      garbageValue = "-92"
   )
   Coordinates vmethod700(int var1, int var2);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "1352125466"
   )
   void vmethod686(Buffer var1);
}
