import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
@Implements("ITextureLoader")
public interface ITextureLoader {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "664221956"
   )
   @Export("getAverageTextureRGB")
   int getAverageTextureRGB(int var1);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "899946592"
   )
   int[] load(int var1);

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "562063917"
   )
   boolean vmethod2931(int var1);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "811109479"
   )
   boolean vmethod2928(int var1);
}
