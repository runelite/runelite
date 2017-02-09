import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public class class158 extends class163 {
   @ObfuscatedName("k")
   ByteBuffer field2217;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "2117218087"
   )
   byte[] vmethod3147() {
      byte[] var1 = new byte[this.field2217.capacity()];
      this.field2217.position(0);
      this.field2217.get(var1);
      return var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-2095375693"
   )
   void vmethod3148(byte[] var1) {
      this.field2217 = ByteBuffer.allocateDirect(var1.length);
      this.field2217.position(0);
      this.field2217.put(var1);
   }
}
