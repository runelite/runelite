import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public class class151 extends class156 {
   @ObfuscatedName("o")
   ByteBuffer field2062;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "601702101"
   )
   byte[] vmethod2937() {
      byte[] var1 = new byte[this.field2062.capacity()];
      this.field2062.position(0);
      this.field2062.get(var1);
      return var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "542069126"
   )
   void vmethod2938(byte[] var1) {
      this.field2062 = ByteBuffer.allocateDirect(var1.length);
      this.field2062.position(0);
      this.field2062.put(var1);
   }
}
