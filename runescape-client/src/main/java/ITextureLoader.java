import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
@Implements("ITextureLoader")
public interface ITextureLoader {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "56"
   )
   @Export("getAverageTextureRGB")
   int getAverageTextureRGB(int var1);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "1718409907"
   )
   int[] load(int var1);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "-30594"
   )
   boolean vmethod2909(int var1);

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "29"
   )
   boolean vmethod2908(int var1);
}
