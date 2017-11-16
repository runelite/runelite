import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
@Implements("ITextureLoader")
public interface ITextureLoader {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)[I",
      garbageValue = "0"
   )
   int[] load(int var1);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "1"
   )
   @Export("getAverageTextureRGB")
   int getAverageTextureRGB(int var1);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "299358493"
   )
   boolean vmethod2893(int var1);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2027405994"
   )
   boolean vmethod2885(int var1);
}
