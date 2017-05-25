import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class171 extends class176 {
   @ObfuscatedName("i")
   ByteBuffer field2336;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1237361257"
   )
   void vmethod3431(byte[] var1) {
      this.field2336 = ByteBuffer.allocateDirect(var1.length);
      this.field2336.position(0);
      this.field2336.put(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "33"
   )
   byte[] vmethod3421() {
      byte[] var1 = new byte[this.field2336.capacity()];
      this.field2336.position(0);
      this.field2336.get(var1);
      return var1;
   }
}
