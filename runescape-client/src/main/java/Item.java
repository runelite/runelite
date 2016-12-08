import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1147355779
   )
   @Export("quantity")
   int quantity;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1557714735
   )
   @Export("id")
   int id;
   @ObfuscatedName("v")
   public static class182 field892;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-12"
   )
   protected final Model getModel() {
      return class137.getItemDefinition(this.id).getModel(this.quantity);
   }
}
