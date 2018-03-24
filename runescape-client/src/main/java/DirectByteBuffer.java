import java.nio.ByteBuffer;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
@Implements("DirectByteBuffer")
public class DirectByteBuffer extends AbstractByteBuffer {
   @ObfuscatedName("t")
   @Export("buffer")
   ByteBuffer buffer;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "38"
   )
   @Export("get")
   byte[] get() {
      byte[] var1 = new byte[this.buffer.capacity()];
      this.buffer.position(0);
      this.buffer.get(var1);
      return var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-818307234"
   )
   @Export("put")
   void put(byte[] var1) {
      this.buffer = ByteBuffer.allocateDirect(var1.length);
      this.buffer.position(0);
      this.buffer.put(var1);
   }
}
