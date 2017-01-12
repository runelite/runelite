import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -918229737
   )
   @Export("quantity")
   int quantity;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 272636753
   )
   @Export("id")
   int id;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "25"
   )
   protected final Model getModel() {
      return class88.getItemDefinition(this.id).getModel(this.quantity);
   }
}
