import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public class class118 extends class125 {
   @ObfuscatedName("j")
   ByteBuffer field1969;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "14"
   )
   byte[] vmethod2773() {
      byte[] var1 = new byte[this.field1969.capacity()];
      this.field1969.position(0);
      this.field1969.get(var1);
      return var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1250119583"
   )
   void vmethod2768(byte[] var1) {
      this.field1969 = ByteBuffer.allocateDirect(var1.length);
      this.field1969.position(0);
      this.field1969.put(var1);
   }
}
