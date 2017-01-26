import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -554055715
   )
   @Export("id")
   int id;
   @ObfuscatedName("pl")
   static GarbageCollectorMXBean field884;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1240057355
   )
   @Export("quantity")
   int quantity;
   @ObfuscatedName("k")
   public static class182 field887;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "2063755858"
   )
   protected final Model getModel() {
      return class36.getItemDefinition(this.id).getModel(this.quantity);
   }
}
