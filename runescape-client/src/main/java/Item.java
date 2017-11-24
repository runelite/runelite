import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("i")
   @Export("osName")
   static String osName;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1306463285
   )
   @Export("id")
   int id;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1252821907
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Leh;",
      garbageValue = "-473112722"
   )
   protected final Model getModel() {
      return WorldMapType2.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "1617846097"
   )
   public static void method1829(String var0, Throwable var1) {
      var1.printStackTrace();
   }
}
