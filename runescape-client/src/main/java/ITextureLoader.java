import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
@Implements("ITextureLoader")
public interface ITextureLoader {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "769753382"
   )
   @Export("getAverageTextureRGB")
   int getAverageTextureRGB(int var1);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "883752153"
   )
   int[] load(int var1);

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-16711936"
   )
   boolean vmethod2877(int var1);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-31277212"
   )
   boolean vmethod2875(int var1);
}
