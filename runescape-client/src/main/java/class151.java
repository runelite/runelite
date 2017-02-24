import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public class class151 extends class156 {
   @ObfuscatedName("q")
   ByteBuffer field2046;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1187628193"
   )
   void vmethod3045(byte[] var1) {
      this.field2046 = ByteBuffer.allocateDirect(var1.length);
      this.field2046.position(0);
      this.field2046.put(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "-26"
   )
   byte[] vmethod3042() {
      byte[] var1 = new byte[this.field2046.capacity()];
      this.field2046.position(0);
      this.field2046.get(var1);
      return var1;
   }
}
