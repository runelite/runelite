import java.nio.ByteBuffer;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
@Implements("DirectByteBuffer")
public class DirectByteBuffer extends AbstractByteBuffer {
   @ObfuscatedName("c")
   @Export("buffer")
   ByteBuffer buffer;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-227926536"
   )
   @Export("get")
   byte[] get() {
      byte[] var1 = new byte[this.buffer.capacity()];
      this.buffer.position(0);
      this.buffer.get(var1);
      return var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-834931198"
   )
   @Export("put")
   void put(byte[] var1) {
      this.buffer = ByteBuffer.allocateDirect(var1.length);
      this.buffer.position(0);
      this.buffer.put(var1);
   }
}
