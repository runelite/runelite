import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("ITextureLoader")
public interface ITextureLoader {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)[I",
      garbageValue = "8"
   )
   int[] load(int var1);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-12"
   )
   @Export("getAverageTextureRGB")
   int getAverageTextureRGB(int var1);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "868418969"
   )
   boolean vmethod2943(int var1);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-111"
   )
   boolean vmethod2946(int var1);
}
