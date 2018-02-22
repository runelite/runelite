import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
@Implements("ITextureLoader")
public interface ITextureLoader {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-1038419006"
   )
   int[] load(int var1);

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1120814065"
   )
   @Export("getAverageTextureRGB")
   int getAverageTextureRGB(int var1);

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-120"
   )
   boolean vmethod3058(int var1);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "146160731"
   )
   boolean vmethod3059(int var1);
}
