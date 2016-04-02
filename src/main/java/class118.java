import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dh")
public class class118 extends class125 {
   @ObfuscatedName("e")
   ByteBuffer field1974;

   @ObfuscatedName("w")
   void vmethod2795(byte[] var1) {
      this.field1974 = ByteBuffer.allocateDirect(var1.length);
      this.field1974.position(0);
      this.field1974.put(var1);
   }

   @ObfuscatedName("e")
   byte[] vmethod2794() {
      byte[] var1 = new byte[this.field1974.capacity()];
      this.field1974.position(0);
      this.field1974.get(var1);
      return var1;
   }
}
