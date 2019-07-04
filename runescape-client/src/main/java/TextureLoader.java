import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
@Implements("TextureLoader")
public interface TextureLoader {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-905309626"
   )
   @Export("load")
   int[] load(int var1);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1641984961"
   )
   int vmethod324(int var1);

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "14"
   )
   boolean vmethod325(int var1);

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1427873761"
   )
   @Export("isLowDetail")
   boolean isLowDetail(int var1);
}
