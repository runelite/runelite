import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
@Implements("ITextureLoader")
public interface ITextureLoader {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1886925429"
   )
   @Export("getAverageTextureRGB")
   int getAverageTextureRGB(int var1);

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "1528112396"
   )
   int[] load(int var1);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "4"
   )
   boolean vmethod2919(int var1);

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "87692413"
   )
   boolean vmethod2923(int var1);
}
