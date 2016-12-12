import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public class class151 extends class156 {
   @ObfuscatedName("i")
   ByteBuffer field2049;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1914510908"
   )
   byte[] vmethod2952() {
      byte[] var1 = new byte[this.field2049.capacity()];
      this.field2049.position(0);
      this.field2049.get(var1);
      return var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-22"
   )
   void vmethod2953(byte[] var1) {
      this.field2049 = ByteBuffer.allocateDirect(var1.length);
      this.field2049.position(0);
      this.field2049.put(var1);
   }
}
