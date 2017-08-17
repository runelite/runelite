import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("itemContainers")
   static XHashTable itemContainers;
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
      itemContainers = new XHashTable(32);
   }

   XItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }
}
