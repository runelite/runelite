import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2010427827
   )
   static int field1392;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -504834051
   )
   @Export("canvasHeight")
   protected static int canvasHeight;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1089175611
   )
   @Export("id")
   int id;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 557430893
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lev;",
      garbageValue = "1008738898"
   )
   protected final Model getModel() {
      return class139.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILhf;I)I",
      garbageValue = "1351412808"
   )
   public static int method1752(int var0, class226 var1) {
      return var1.field2860 + (var0 + 40000 << 8);
   }
}
