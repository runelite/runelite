import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
public class class151 extends class156 {
   @ObfuscatedName("x")
   ByteBuffer field2043;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "306247809"
   )
   void vmethod3112(byte[] var1) {
      this.field2043 = ByteBuffer.allocateDirect(var1.length);
      this.field2043.position(0);
      this.field2043.put(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "89"
   )
   byte[] vmethod3115() {
      byte[] var1 = new byte[this.field2043.capacity()];
      this.field2043.position(0);
      this.field2043.get(var1);
      return var1;
   }
}
