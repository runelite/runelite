import java.nio.ByteBuffer;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
@Implements("DirectByteBuffer")
public class DirectByteBuffer extends AbstractByteBuffer {
   @ObfuscatedName("a")
   @Export("buffer")
   ByteBuffer buffer;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1971888309"
   )
   @Export("get")
   byte[] get() {
      byte[] var1 = new byte[this.buffer.capacity()];
      this.buffer.position(0);
      this.buffer.get(var1);
      return var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1446419567"
   )
   @Export("put")
   void put(byte[] var1) {
      this.buffer = ByteBuffer.allocateDirect(var1.length);
      this.buffer.position(0);
      this.buffer.put(var1);
   }
}
