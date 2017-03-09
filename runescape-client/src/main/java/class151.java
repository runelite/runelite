import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
public class class151 extends class156 {
   @ObfuscatedName("x")
   ByteBuffer field2043;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1745524473"
   )
   void vmethod3049(byte[] var1) {
      this.field2043 = ByteBuffer.allocateDirect(var1.length);
      this.field2043.position(0);
      this.field2043.put(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1676279760"
   )
   byte[] vmethod3063() {
      byte[] var1 = new byte[this.field2043.capacity()];
      this.field2043.position(0);
      this.field2043.get(var1);
      return var1;
   }
}
