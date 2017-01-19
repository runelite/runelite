import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
public class class151 extends class156 {
   @ObfuscatedName("s")
   ByteBuffer field2055;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "-65"
   )
   byte[] vmethod2931() {
      byte[] var1 = new byte[this.field2055.capacity()];
      this.field2055.position(0);
      this.field2055.get(var1);
      return var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-12"
   )
   void vmethod2930(byte[] var1) {
      this.field2055 = ByteBuffer.allocateDirect(var1.length);
      this.field2055.position(0);
      this.field2055.put(var1);
   }
}
