import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public class class118 extends class125 {
   @ObfuscatedName("s")
   ByteBuffer field2004;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1672873160"
   )
   byte[] vmethod2795() {
      byte[] var1 = new byte[this.field2004.capacity()];
      this.field2004.position(0);
      this.field2004.get(var1);
      return var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1354385809"
   )
   void vmethod2785(byte[] var1) {
      this.field2004 = ByteBuffer.allocateDirect(var1.length);
      this.field2004.position(0);
      this.field2004.put(var1);
   }
}
