import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gd")
@Implements("ObjectNode")
public class ObjectNode extends Node {
   @ObfuscatedName("c")
   @Export("value")
   public final Object value;

   public ObjectNode(Object var1) {
      this.value = var1;
   }
}
