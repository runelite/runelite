import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bt")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("c")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("e")
   @Export("stackSizes")
   int[] stackSizes;
   @ObfuscatedName("dc")
   @ObfuscatedGetter(
      intValue = 523801497
   )
   static int field790;
   @ObfuscatedName("kh")
   static Widget field791;
   @ObfuscatedName("fk")
   static int[] field794;
   @ObfuscatedName("i")
   @Export("itemContainers")
   static XHashTable itemContainers;

   static {
      itemContainers = new XHashTable(32);
   }

   XItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }
}
