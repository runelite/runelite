import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
public class class151 extends class156 {
   @ObfuscatedName("p")
   ByteBuffer field2046;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-338686629"
   )
   byte[] vmethod3013() {
      byte[] var1 = new byte[this.field2046.capacity()];
      this.field2046.position(0);
      this.field2046.get(var1);
      return var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "8"
   )
   void vmethod3014(byte[] var1) {
      this.field2046 = ByteBuffer.allocateDirect(var1.length);
      this.field2046.position(0);
      this.field2046.put(var1);
   }
}
