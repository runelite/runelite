package net.runelite.rs.client;
import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dm")
public class class117 extends class124 {
   @ObfuscatedName("j")
   ByteBuffer field1990;

   @ObfuscatedName("j")
   byte[] vmethod2728() {
      byte[] var1 = new byte[this.field1990.capacity()];
      this.field1990.position(0);
      this.field1990.get(var1);
      return var1;
   }

   @ObfuscatedName("l")
   void vmethod2734(byte[] var1) {
      this.field1990 = ByteBuffer.allocateDirect(var1.length);
      this.field1990.position(0);
      this.field1990.put(var1);
   }
}
