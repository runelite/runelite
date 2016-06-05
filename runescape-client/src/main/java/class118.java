import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
public class class118 extends class125 {
   @ObfuscatedName("t")
   ByteBuffer field1998;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "812924816"
   )
   void vmethod2754(byte[] var1) {
      this.field1998 = ByteBuffer.allocateDirect(var1.length);
      this.field1998.position(0);
      this.field1998.put(var1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "-102"
   )
   byte[] vmethod2753() {
      byte[] var1 = new byte[this.field1998.capacity()];
      this.field1998.position(0);
      this.field1998.get(var1);
      return var1;
   }
}
