import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 93039809
   )
   @Export("id")
   int id;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 274535397
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lee;",
      garbageValue = "-1967116980"
   )
   protected final Model getModel() {
      return NetWriter.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1061563213"
   )
   public static int method2020(CharSequence var0) {
      return class46.parseInt(var0, 10, true);
   }
}
