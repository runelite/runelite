import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
@Implements("ITextureLoader")
public interface ITextureLoader {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-802368556"
   )
   int[] load(int var1);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "975899805"
   )
   @Export("getAverageTextureRGB")
   int getAverageTextureRGB(int var1);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1297239195"
   )
   boolean vmethod3127(int var1);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "68"
   )
   boolean vmethod3136(int var1);
}
