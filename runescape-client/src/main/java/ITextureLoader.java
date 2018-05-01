import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
@Implements("ITextureLoader")
public interface ITextureLoader {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "1381079357"
   )
   int[] load(int var1);

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-699855363"
   )
   @Export("getAverageTextureRGB")
   int getAverageTextureRGB(int var1);

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "254038017"
   )
   boolean vmethod3152(int var1);

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-79"
   )
   boolean vmethod3155(int var1);
}
