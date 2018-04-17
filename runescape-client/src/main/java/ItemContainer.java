import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
@Implements("ItemContainer")
public class ItemContainer extends Node {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   @Export("itemContainers")
   static HashTable itemContainers;
   @ObfuscatedName("fg")
   @Export("landMapFileIds")
   static int[] landMapFileIds;
   @ObfuscatedName("k")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("t")
   @Export("stackSizes")
   int[] stackSizes;

   static {
      itemContainers = new HashTable(32);
   }

   ItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-44"
   )
   static final int method1131(int var0, int var1) {
      int var2 = WallObject.getSmoothNoise(var0 + 45365, var1 + 91923, 4) - 128 + (WallObject.getSmoothNoise(10294 + var0, 37821 + var1, 2) - 128 >> 1) + (WallObject.getSmoothNoise(var0, var1, 1) - 128 >> 2);
      var2 = (int)(0.3D * (double)var2) + 35;
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }
}
