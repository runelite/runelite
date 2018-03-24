import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
@Implements("ITextureLoader")
public interface ITextureLoader {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)[I",
      garbageValue = "97"
   )
   int[] load(int var1);

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1653541214"
   )
   @Export("getAverageTextureRGB")
   int getAverageTextureRGB(int var1);

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "0"
   )
   boolean vmethod3057(int var1);

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1413725464"
   )
   boolean vmethod3066(int var1);
}
