import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
public class class121 extends class128 {
   @ObfuscatedName("f")
   ByteBuffer field2050;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "1"
   )
   void vmethod2810(byte[] var1) {
      this.field2050 = ByteBuffer.allocateDirect(var1.length);
      this.field2050.position(0);
      this.field2050.put(var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "0"
   )
   byte[] vmethod2809() {
      byte[] var1 = new byte[this.field2050.capacity()];
      this.field2050.position(0);
      this.field2050.get(var1);
      return var1;
   }
}
