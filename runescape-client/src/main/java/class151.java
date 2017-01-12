import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public class class151 extends class156 {
   @ObfuscatedName("u")
   ByteBuffer field2028;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-1241589171"
   )
   byte[] vmethod3000() {
      byte[] var1 = new byte[this.field2028.capacity()];
      this.field2028.position(0);
      this.field2028.get(var1);
      return var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "659635151"
   )
   void vmethod2996(byte[] var1) {
      this.field2028 = ByteBuffer.allocateDirect(var1.length);
      this.field2028.position(0);
      this.field2028.put(var1);
   }
}
