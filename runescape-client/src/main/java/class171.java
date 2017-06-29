import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public class class171 extends class176 {
   @ObfuscatedName("i")
   ByteBuffer field2357;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "104"
   )
   byte[] vmethod3363() {
      byte[] var1 = new byte[this.field2357.capacity()];
      this.field2357.position(0);
      this.field2357.get(var1);
      return var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1013128189"
   )
   void vmethod3351(byte[] var1) {
      this.field2357 = ByteBuffer.allocateDirect(var1.length);
      this.field2357.position(0);
      this.field2357.put(var1);
   }
}
