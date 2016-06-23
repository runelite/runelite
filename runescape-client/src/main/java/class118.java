import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
public class class118 extends class125 {
   @ObfuscatedName("f")
   ByteBuffer field1996;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "541753250"
   )
   byte[] vmethod2817() {
      byte[] var1 = new byte[this.field1996.capacity()];
      this.field1996.position(0);
      this.field1996.get(var1);
      return var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "101"
   )
   void vmethod2816(byte[] var1) {
      this.field1996 = ByteBuffer.allocateDirect(var1.length);
      this.field1996.position(0);
      this.field1996.put(var1);
   }
}
