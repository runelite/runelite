import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("r")
   @Export("underlayIds")
   static byte[][][] underlayIds;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 615123459
   )
   @Export("id")
   int id;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -698831991
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "19"
   )
   protected final Model getModel() {
      return class83.getItemDefinition(this.id).getModel(this.quantity);
   }
}
