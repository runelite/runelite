import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
@Implements("ITextureLoader")
public interface ITextureLoader {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "-4101"
   )
   boolean vmethod2875(int var1);

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1662598982"
   )
   @Export("getAverageTextureRGB")
   int getAverageTextureRGB(int var1);

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "349268549"
   )
   boolean vmethod2878(int var1);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "750752520"
   )
   int[] load(int var1);
}
