import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
public class class121 extends class128 {
   @ObfuscatedName("x")
   ByteBuffer field2049;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "904637177"
   )
   void vmethod2852(byte[] var1) {
      this.field2049 = ByteBuffer.allocateDirect(var1.length);
      this.field2049.position(0);
      this.field2049.put(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "543168377"
   )
   byte[] vmethod2858() {
      byte[] var1 = new byte[this.field2049.capacity()];
      this.field2049.position(0);
      this.field2049.get(var1);
      return var1;
   }
}
