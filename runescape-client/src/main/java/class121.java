import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
public class class121 extends class128 {
   @ObfuscatedName("a")
   ByteBuffer field2068;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-298012552"
   )
   byte[] vmethod2825() {
      byte[] var1 = new byte[this.field2068.capacity()];
      this.field2068.position(0);
      this.field2068.get(var1);
      return var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-345387204"
   )
   void vmethod2826(byte[] var1) {
      this.field2068 = ByteBuffer.allocateDirect(var1.length);
      this.field2068.position(0);
      this.field2068.put(var1);
   }
}
