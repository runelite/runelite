import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
@Implements("ITextureLoader")
public interface ITextureLoader {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-914932681"
   )
   @Export("getAverageTextureRGB")
   int getAverageTextureRGB(int var1);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "551692709"
   )
   int[] load(int var1);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "32"
   )
   boolean vmethod2910(int var1);

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "2046980984"
   )
   boolean vmethod2905(int var1);
}
