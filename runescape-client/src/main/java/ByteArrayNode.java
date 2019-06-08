import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gp")
@Implements("ByteArrayNode")
public class ByteArrayNode extends Node {
   @ObfuscatedName("m")
   @Export("byteArray")
   public byte[] byteArray;

   public ByteArrayNode(byte[] var1) {
      this.byteArray = var1;
   }
}
