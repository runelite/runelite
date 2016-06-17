import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
public class class118 extends class125 {
   @ObfuscatedName("b")
   ByteBuffer field1974;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-391690139"
   )
   void vmethod2827(byte[] var1) {
      this.field1974 = ByteBuffer.allocateDirect(var1.length);
      this.field1974.position(0);
      this.field1974.put(var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "77"
   )
   byte[] vmethod2826() {
      byte[] var1 = new byte[this.field1974.capacity()];
      this.field1974.position(0);
      this.field1974.get(var1);
      return var1;
   }
}
