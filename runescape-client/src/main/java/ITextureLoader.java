import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
@Implements("ITextureLoader")
public interface ITextureLoader {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)[I",
      garbageValue = "-57"
   )
   int[] load(int var1);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1895350108"
   )
   @Export("getAverageTextureRGB")
   int getAverageTextureRGB(int var1);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "1"
   )
   boolean vmethod3069(int var1);

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1396024550"
   )
   boolean vmethod3077(int var1);
}
