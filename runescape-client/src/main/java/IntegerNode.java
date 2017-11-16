import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gc")
@Implements("IntegerNode")
public class IntegerNode extends Node {
   @ObfuscatedName("b")
   @Export("value")
   public int value;

   public IntegerNode(int var1) {
      this.value = var1;
   }
}
