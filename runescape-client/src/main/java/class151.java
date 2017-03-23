import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public class class151 extends class156 {
   @ObfuscatedName("f")
   ByteBuffer field2068;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "-57"
   )
   byte[] vmethod3076() {
      byte[] var1 = new byte[this.field2068.capacity()];
      this.field2068.position(0);
      this.field2068.get(var1);
      return var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-932194466"
   )
   void vmethod3077(byte[] var1) {
      this.field2068 = ByteBuffer.allocateDirect(var1.length);
      this.field2068.position(0);
      this.field2068.put(var1);
   }
}
