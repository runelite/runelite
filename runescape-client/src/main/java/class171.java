import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public class class171 extends class176 {
   @ObfuscatedName("i")
   ByteBuffer field2365;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "95"
   )
   byte[] vmethod3366() {
      byte[] var1 = new byte[this.field2365.capacity()];
      this.field2365.position(0);
      this.field2365.get(var1);
      return var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "55737015"
   )
   void vmethod3358(byte[] var1) {
      this.field2365 = ByteBuffer.allocateDirect(var1.length);
      this.field2365.position(0);
      this.field2365.put(var1);
   }
}
