import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
@Implements("ITextureLoader")
public interface ITextureLoader {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-509217315"
   )
   int[] load(int var1);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "76"
   )
   @Export("getAverageTextureRGB")
   int getAverageTextureRGB(int var1);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "28"
   )
   boolean vmethod3099(int var1);

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "245038345"
   )
   boolean vmethod3100(int var1);
}
