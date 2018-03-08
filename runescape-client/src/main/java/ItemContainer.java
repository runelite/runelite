import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
@Implements("ItemContainer")
public class ItemContainer extends Node {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   @Export("itemContainers")
   static HashTable itemContainers;
   @ObfuscatedName("f")
   static int[] field750;
   @ObfuscatedName("mr")
   @ObfuscatedGetter(
      intValue = -1149056761
   )
   static int field746;
   @ObfuscatedName("q")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("i")
   @Export("stackSizes")
   int[] stackSizes;

   static {
      itemContainers = new HashTable(32);
   }

   ItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1947681682"
   )
   static final void method1148(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.widgetCount; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field904[var4] = true;
         }
      }

   }
}
