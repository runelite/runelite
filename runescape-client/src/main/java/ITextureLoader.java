import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("ITextureLoader")
public interface ITextureLoader {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-79"
   )
   @Export("getAverageTextureRGB")
   int getAverageTextureRGB(int var1);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "803388249"
   )
   int[] load(int var1);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "83"
   )
   boolean vmethod2952(int var1);

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1690267600"
   )
   boolean vmethod2950(int var1);
}
