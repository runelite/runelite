import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class171 extends class176 {
   @ObfuscatedName("p")
   ByteBuffer field2366;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-33"
   )
   void vmethod3260(byte[] var1) {
      this.field2366 = ByteBuffer.allocateDirect(var1.length);
      this.field2366.position(0);
      this.field2366.put(var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(S)[B",
      garbageValue = "128"
   )
   byte[] vmethod3256() {
      byte[] var1 = new byte[this.field2366.capacity()];
      this.field2366.position(0);
      this.field2366.get(var1);
      return var1;
   }
}
