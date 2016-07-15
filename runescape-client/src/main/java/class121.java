import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
public class class121 extends class128 {
   @ObfuscatedName("e")
   ByteBuffer field2052;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-663862977"
   )
   void vmethod2905(byte[] var1) {
      this.field2052 = ByteBuffer.allocateDirect(var1.length);
      this.field2052.position(0);
      this.field2052.put(var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1238789013"
   )
   byte[] vmethod2906() {
      byte[] var1 = new byte[this.field2052.capacity()];
      this.field2052.position(0);
      this.field2052.get(var1);
      return var1;
   }
}
