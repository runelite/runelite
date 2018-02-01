import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("ItemContainer")
public class ItemContainer extends Node {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("itemContainers")
   static HashTable itemContainers;
   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = 373583939
   )
   @Export("myWorldPort")
   static int myWorldPort;
   @ObfuscatedName("i")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("w")
   @Export("stackSizes")
   int[] stackSizes;

   static {
      itemContainers = new HashTable(32);
   }

   ItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-889468565"
   )
   static void method1067(int var0) {
      if(var0 == -1 && !Client.field1014) {
         class214.field2595.method3962();
         class214.field2596 = 1;
         Item.field1369 = null;
      } else if(var0 != -1 && var0 != Client.field1041 && Client.field1040 != 0 && !Client.field1014) {
         IndexData var1 = class148.indexTrack1;
         int var2 = Client.field1040;
         class214.field2596 = 1;
         Item.field1369 = var1;
         GZipDecompressor.field2420 = var0;
         class186.field2505 = 0;
         class214.field2597 = var2;
         class214.field2594 = false;
         class85.field1268 = 2;
      }

      Client.field1041 = var0;
   }
}
