import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
public class class121 extends class128 {
   @ObfuscatedName("l")
   ByteBuffer field2048;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1831239624"
   )
   byte[] vmethod2938() {
      byte[] var1 = new byte[this.field2048.capacity()];
      this.field2048.position(0);
      this.field2048.get(var1);
      return var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1484954424"
   )
   void vmethod2940(byte[] var1) {
      this.field2048 = ByteBuffer.allocateDirect(var1.length);
      this.field2048.position(0);
      this.field2048.put(var1);
   }
}
