import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("du")
public class class118 extends class125 {
   @ObfuscatedName("w")
   ByteBuffer field2004;

   @ObfuscatedName("x")
   void vmethod2795(byte[] var1) {
      this.field2004 = ByteBuffer.allocateDirect(var1.length);
      this.field2004.position(0);
      this.field2004.put(var1);
   }

   @ObfuscatedName("w")
   byte[] vmethod2794() {
      byte[] var1 = new byte[this.field2004.capacity()];
      this.field2004.position(0);
      this.field2004.get(var1);
      return var1;
   }
}
