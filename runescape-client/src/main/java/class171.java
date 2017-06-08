import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class171 extends class176 {
   @ObfuscatedName("n")
   ByteBuffer field2357;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1888028960"
   )
   byte[] vmethod3361() {
      byte[] var1 = new byte[this.field2357.capacity()];
      this.field2357.position(0);
      this.field2357.get(var1);
      return var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-118"
   )
   void vmethod3374(byte[] var1) {
      this.field2357 = ByteBuffer.allocateDirect(var1.length);
      this.field2357.position(0);
      this.field2357.put(var1);
   }
}
