import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
@Implements("ITextureLoader")
public interface ITextureLoader {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "930572073"
   )
   int[] load(int var1);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2049327827"
   )
   @Export("getAverageTextureRGB")
   int getAverageTextureRGB(int var1);

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "105"
   )
   boolean vmethod3003(int var1);

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "513543743"
   )
   boolean vmethod3004(int var1);
}
