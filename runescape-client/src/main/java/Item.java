import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -717928919
   )
   @Export("id")
   int id;
   @ObfuscatedName("pe")
   public static class139 field699;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 653824763
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1714992488"
   )
   protected final Model getModel() {
      return class22.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-804465209"
   )
   public static int method673(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + BufferProvider.method1732(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Lclass134;",
      garbageValue = "9"
   )
   public static class134 method674() {
      try {
         return new class148();
      } catch (Throwable var1) {
         return null;
      }
   }
}
