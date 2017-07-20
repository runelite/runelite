import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
@Implements("ITextureLoader")
public interface ITextureLoader {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "76"
   )
   @Export("getAverageTextureRGB")
   int getAverageTextureRGB(int var1);

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)[I",
      garbageValue = "55"
   )
   int[] load(int var1);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "3"
   )
   boolean vmethod2816(int var1);

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "647122249"
   )
   boolean vmethod2825(int var1);
}
