import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dk")
public class class117 extends class124 {
   @ObfuscatedName("a")
   ByteBuffer field1978;

   @ObfuscatedName("a")
   byte[] vmethod2792() {
      byte[] var1 = new byte[this.field1978.capacity()];
      this.field1978.position(0);
      this.field1978.get(var1);
      return var1;
   }

   @ObfuscatedName("r")
   void vmethod2803(byte[] var1) {
      this.field1978 = ByteBuffer.allocateDirect(var1.length);
      this.field1978.position(0);
      this.field1978.put(var1);
   }
}
