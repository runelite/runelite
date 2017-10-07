import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ge")
@Implements("ObjectNode")
public class ObjectNode extends Node {
   @ObfuscatedName("d")
   @Export("value")
   public final Object value;

   public ObjectNode(Object var1) {
      this.value = var1;
   }
}
