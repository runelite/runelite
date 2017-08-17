import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 580350279
   )
   @Export("id")
   int id;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -517906217
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Leo;",
      garbageValue = "1214595416"
   )
   protected final Model getModel() {
      return SoundTask.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "-23874"
   )
   static int method1779(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.get((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }
}
