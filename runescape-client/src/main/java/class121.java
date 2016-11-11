import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
public class class121 extends class128 {
   @ObfuscatedName("i")
   ByteBuffer field2041;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-2034994711"
   )
   void vmethod2823(byte[] var1) {
      this.field2041 = ByteBuffer.allocateDirect(var1.length);
      this.field2041.position(0);
      this.field2041.put(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "27"
   )
   byte[] vmethod2822() {
      byte[] var1 = new byte[this.field2041.capacity()];
      this.field2041.position(0);
      this.field2041.get(var1);
      return var1;
   }
}
