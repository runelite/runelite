import java.nio.ByteBuffer;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
@Implements("DirectByteBuffer")
public class DirectByteBuffer extends AbstractByteBuffer {
   @ObfuscatedName("o")
   @Export("buffer")
   ByteBuffer buffer;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1478494474"
   )
   @Export("get")
   byte[] get() {
      byte[] var1 = new byte[this.buffer.capacity()];
      this.buffer.position(0);
      this.buffer.get(var1);
      return var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-855579517"
   )
   @Export("put")
   void put(byte[] var1) {
      this.buffer = ByteBuffer.allocateDirect(var1.length);
      this.buffer.position(0);
      this.buffer.put(var1);
   }
}
