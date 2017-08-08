import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "[[Lhg;"
   )
   @Export("widgets")
   public static Widget[][] widgets;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1862762843
   )
   @Export("id")
   int id;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2008059299
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lew;",
      garbageValue = "-2113451941"
   )
   protected final Model getModel() {
      return ClassInfo.getItemDefinition(this.id).getModel(this.quantity);
   }
}
