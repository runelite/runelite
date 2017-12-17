import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("z")
   public static int[] field1387;
   @ObfuscatedName("b")
   static int[] field1386;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = -2124720277
   )
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 485193461
   )
   @Export("id")
   int id;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1501899501
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lef;",
      garbageValue = "620909653"
   )
   protected final Model getModel() {
      return KitDefinition.getItemDefinition(this.id).getModel(this.quantity);
   }
}
