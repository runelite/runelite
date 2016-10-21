import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -105260601
   )
   @Export("quantity")
   int quantity;
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = 743215721
   )
   static int field687;
   @ObfuscatedName("ps")
   @ObfuscatedGetter(
      intValue = -103157211
   )
   static int field688;
   @ObfuscatedName("bb")
   static class171 field690;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = -635062373
   )
   static int field691;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 986946269
   )
   @Export("id")
   int id;
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      intValue = 2065007429
   )
   static int field693;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "3"
   )
   protected final Model getModel() {
      return class45.getItemDefinition(this.id).getModel(this.quantity);
   }
}
