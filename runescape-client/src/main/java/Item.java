import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -650261999
   )
   @Export("id")
   int id;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1778300201
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Leb;",
      garbageValue = "1172124455"
   )
   protected final Model getModel() {
      return class46.getItemDefinition(this.id).getModel(this.quantity);
   }
}
