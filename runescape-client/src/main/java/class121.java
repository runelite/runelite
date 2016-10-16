import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
public class class121 extends class128 {
   @ObfuscatedName("s")
   ByteBuffer field2025;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "280327915"
   )
   void vmethod2794(byte[] var1) {
      this.field2025 = ByteBuffer.allocateDirect(var1.length);
      this.field2025.position(0);
      this.field2025.put(var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-1107289273"
   )
   byte[] vmethod2793() {
      byte[] var1 = new byte[this.field2025.capacity()];
      this.field2025.position(0);
      this.field2025.get(var1);
      return var1;
   }
}
