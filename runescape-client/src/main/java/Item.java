import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1854574669
   )
   @Export("id")
   int id;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -618264655
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lev;",
      garbageValue = "1458652918"
   )
   protected final Model getModel() {
      return Friend.getItemDefinition(this.id).getModel(this.quantity);
   }
}
