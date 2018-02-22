import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gw")
@Implements("ObjectNode")
public class ObjectNode extends Node {
   @ObfuscatedName("b")
   @Export("value")
   public final Object value;

   public ObjectNode(Object var1) {
      this.value = var1;
   }
}
