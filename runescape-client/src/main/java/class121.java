import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
public class class121 extends class128 {
   @ObfuscatedName("k")
   ByteBuffer field2050;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-1988684819"
   )
   byte[] vmethod2852() {
      byte[] var1 = new byte[this.field2050.capacity()];
      this.field2050.position(0);
      this.field2050.get(var1);
      return var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-8"
   )
   void vmethod2853(byte[] var1) {
      this.field2050 = ByteBuffer.allocateDirect(var1.length);
      this.field2050.position(0);
      this.field2050.put(var1);
   }
}
