import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
@Implements("ITextureLoader")
public interface ITextureLoader {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-1277684059"
   )
   int[] load(int var1);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "68"
   )
   @Export("getAverageTextureRGB")
   int getAverageTextureRGB(int var1);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-20"
   )
   boolean vmethod2891(int var1);

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-979915637"
   )
   boolean vmethod2892(int var1);
}
