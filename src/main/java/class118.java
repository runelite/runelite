import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public class class118 extends class125 {
   @ObfuscatedName("a")
   ByteBuffer field1990;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1075955707"
   )
   byte[] vmethod2915() {
      byte[] var1 = new byte[this.field1990.capacity()];
      this.field1990.position(0);
      this.field1990.get(var1);
      return var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "337898845"
   )
   void vmethod2916(byte[] var1) {
      this.field1990 = ByteBuffer.allocateDirect(var1.length);
      this.field1990.position(0);
      this.field1990.put(var1);
   }
}
