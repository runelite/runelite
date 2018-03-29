import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
@Implements("ITextureLoader")
public interface ITextureLoader {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IS)[I",
      garbageValue = "1306"
   )
   int[] load(int var1);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1373867862"
   )
   @Export("getAverageTextureRGB")
   int getAverageTextureRGB(int var1);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1901285645"
   )
   boolean vmethod3087(int var1);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "583682207"
   )
   boolean vmethod3086(int var1);
}
