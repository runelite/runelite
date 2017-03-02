import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public class class151 extends class156 {
   @ObfuscatedName("b")
   ByteBuffer field2040;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1652791378"
   )
   void vmethod3083(byte[] var1) {
      this.field2040 = ByteBuffer.allocateDirect(var1.length);
      this.field2040.position(0);
      this.field2040.put(var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1427906278"
   )
   byte[] vmethod3082() {
      byte[] var1 = new byte[this.field2040.capacity()];
      this.field2040.position(0);
      this.field2040.get(var1);
      return var1;
   }
}
