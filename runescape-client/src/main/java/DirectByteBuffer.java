import java.nio.ByteBuffer;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
@Implements("DirectByteBuffer")
public class DirectByteBuffer extends AbstractByteBuffer {
   @ObfuscatedName("m")
   @Export("buffer")
   ByteBuffer buffer;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "2025274732"
   )
   @Export("get")
   byte[] get() {
      byte[] var1 = new byte[this.buffer.capacity()];
      this.buffer.position(0);
      this.buffer.get(var1);
      return var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1395414743"
   )
   @Export("put")
   void put(byte[] var1) {
      this.buffer = ByteBuffer.allocateDirect(var1.length);
      this.buffer.position(0);
      this.buffer.put(var1);
   }
}
