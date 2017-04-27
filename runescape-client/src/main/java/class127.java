import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
public class class127 extends class132 {
   @ObfuscatedName("d")
   ByteBuffer field1912;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "0"
   )
   byte[] vmethod2615() {
      byte[] var1 = new byte[this.field1912.capacity()];
      this.field1912.position(0);
      this.field1912.get(var1);
      return var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "339528659"
   )
   void vmethod2616(byte[] var1) {
      this.field1912 = ByteBuffer.allocateDirect(var1.length);
      this.field1912.position(0);
      this.field1912.put(var1);
   }
}
