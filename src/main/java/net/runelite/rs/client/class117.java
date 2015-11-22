package net.runelite.rs.client;

import java.nio.ByteBuffer;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dw")
public class class117 extends class124 {
   @ObfuscatedName("j")
   ByteBuffer field1977;

   @ObfuscatedName("m")
   void vmethod2820(byte[] var1) {
      this.field1977 = ByteBuffer.allocateDirect(var1.length);
      this.field1977.position(0);
      this.field1977.put(var1);
   }

   @ObfuscatedName("j")
   byte[] vmethod2818() {
      byte[] var1 = new byte[this.field1977.capacity()];
      this.field1977.position(0);
      this.field1977.get(var1);
      return var1;
   }
}
