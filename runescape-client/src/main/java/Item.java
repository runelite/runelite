import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("f")
   public static short[][] field1399;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 917387703
   )
   @Export("id")
   int id;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1171675487
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Les;",
      garbageValue = "-17"
   )
   protected final Model getModel() {
      return class115.getItemDefinition(this.id).getModel(this.quantity);
   }
}
