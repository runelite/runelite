import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
@Implements("ITextureLoader")
public interface ITextureLoader {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "715076441"
   )
   int[] load(int var1);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "-26255"
   )
   @Export("getAverageTextureRGB")
   int getAverageTextureRGB(int var1);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-156069645"
   )
   boolean vmethod3145(int var1);

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "476495404"
   )
   boolean vmethod3146(int var1);
}
