import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1710972533
   )
   @Export("id")
   int id;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1858492457
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Lem;",
      garbageValue = "-1455933636"
   )
   protected final Model getModel() {
      return class169.getItemDefinition(this.id).getModel(this.quantity);
   }
}
