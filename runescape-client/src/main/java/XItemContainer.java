import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -264803311
   )
   static int field771;
   @ObfuscatedName("m")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("e")
   @Export("stackSizes")
   int[] stackSizes;
   @ObfuscatedName("f")
   static int[][] field774;
   @ObfuscatedName("p")
   @Export("itemContainers")
   static XHashTable itemContainers;

   XItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }

   static {
      itemContainers = new XHashTable(32);
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(LWidget;B)V",
      garbageValue = "94"
   )
   static void method1020(Widget var0) {
      if(Client.field1110 == var0.field2786) {
         Client.field1111[var0.boundsIndex] = true;
      }

   }
}
