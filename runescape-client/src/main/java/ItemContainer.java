import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
@Implements("ItemContainer")
public class ItemContainer extends Node {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   @Export("itemContainers")
   static HashTable itemContainers;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = -1133885729
   )
   static int field756;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = -334036713
   )
   static int field754;
   @ObfuscatedName("i")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("o")
   @Export("stackSizes")
   int[] stackSizes;

   static {
      itemContainers = new HashTable(32);
   }

   ItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }
}
