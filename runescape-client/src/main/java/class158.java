import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class158 extends class163 {
   @ObfuscatedName("n")
   ByteBuffer field2244;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-213456903"
   )
   byte[] vmethod3210() {
      byte[] var1 = new byte[this.field2244.capacity()];
      this.field2244.position(0);
      this.field2244.get(var1);
      return var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1727335232"
   )
   void vmethod3199(byte[] var1) {
      this.field2244 = ByteBuffer.allocateDirect(var1.length);
      this.field2244.position(0);
      this.field2244.put(var1);
   }
}
