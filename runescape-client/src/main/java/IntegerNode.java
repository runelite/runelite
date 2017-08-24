import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gu")
@Implements("IntegerNode")
public class IntegerNode extends Node {
   @ObfuscatedName("i")
   @Export("value")
   public int value;

   public IntegerNode(int var1) {
      this.value = var1;
   }
}
