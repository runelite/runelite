import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
public class class121 extends class128 {
   @ObfuscatedName("m")
   ByteBuffer field2043;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1950818508"
   )
   void vmethod2843(byte[] var1) {
      this.field2043 = ByteBuffer.allocateDirect(var1.length);
      this.field2043.position(0);
      this.field2043.put(var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1384004890"
   )
   byte[] vmethod2842() {
      byte[] var1 = new byte[this.field2043.capacity()];
      this.field2043.position(0);
      this.field2043.get(var1);
      return var1;
   }
}
