import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class20 {
   @ObfuscatedName("c")
   static int[] field310;
   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("indexTrack2")
   static IndexData indexTrack2;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lib;I)V",
      garbageValue = "-824377581"
   )
   public static void method146(IndexDataBase var0) {
      class254.field3400 = var0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-95"
   )
   static int method148(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-941345002"
   )
   public static int method147() {
      return ++MouseInput.mouseIdleTicks - 1;
   }
}
