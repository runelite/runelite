import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
@Implements("ITextureLoader")
public interface ITextureLoader {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "1553030192"
   )
   int[] load(int var1);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-84803768"
   )
   @Export("getAverageTextureRGB")
   int getAverageTextureRGB(int var1);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "19136896"
   )
   boolean vmethod2988(int var1);

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "-8858"
   )
   boolean vmethod2993(int var1);
}
