import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
@Implements("SourceDataSoundSystem")
public class SourceDataSoundSystem extends AbstractSoundSystem {
   @ObfuscatedName("t")
   @Export("audioFormat")
   AudioFormat audioFormat;
   @ObfuscatedName("q")
   @Export("source")
   SourceDataLine source;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -833588839
   )
   @Export("size")
   int size;
   @ObfuscatedName("a")
   @Export("bytes")
   byte[] bytes;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "833376500"
   )
   protected void vmethod2240() {
      this.audioFormat = new AudioFormat((float)AbstractSoundSystem.sampleRate, 16, AbstractSoundSystem.audioHighMemory?2:1, true, false);
      this.bytes = new byte[256 << (AbstractSoundSystem.audioHighMemory?2:1)];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   @Export("create")
   protected void create(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.audioFormat, var1 << (AbstractSoundSystem.audioHighMemory?2:1));
         this.source = (SourceDataLine)AudioSystem.getLine(var2);
         this.source.open();
         this.source.start();
         this.size = var1;
      } catch (LineUnavailableException var5) {
         if(UrlRequester.nextPowerOfTwo(var1) != 1) {
            int var4 = var1 - 1;
            var4 |= var4 >>> 1;
            var4 |= var4 >>> 2;
            var4 |= var4 >>> 4;
            var4 |= var4 >>> 8;
            var4 |= var4 >>> 16;
            int var3 = var4 + 1;
            this.create(var3);
         } else {
            this.source = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "720557872"
   )
   @Export("size")
   protected int size() {
      return this.size - (this.source.available() >> (AbstractSoundSystem.audioHighMemory?2:1));
   }

   @ObfuscatedName("a")
   @Export("write")
   protected void write() {
      int var1 = 256;
      if(AbstractSoundSystem.audioHighMemory) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.samples[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.bytes[var2 * 2] = (byte)(var3 >> 8);
         this.bytes[var2 * 2 + 1] = (byte)(var3 >> 16);
      }

      this.source.write(this.bytes, 0, var1 << 1);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   @Export("close")
   protected void close() {
      if(this.source != null) {
         this.source.close();
         this.source = null;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1807576321"
   )
   @Export("flush")
   protected void flush() {
      this.source.flush();
   }
}
