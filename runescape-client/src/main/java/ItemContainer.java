import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("ItemContainer")
public class ItemContainer extends Node {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("itemContainers")
   static HashTable itemContainers;
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      intValue = 1217716857
   )
   static int field802;
   @ObfuscatedName("h")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("f")
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
