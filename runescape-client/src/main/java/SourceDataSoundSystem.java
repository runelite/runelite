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

@ObfuscatedName("bf")
@Implements("SourceDataSoundSystem")
public class SourceDataSoundSystem extends AbstractSoundSystem {
   @ObfuscatedName("b")
   @Export("audioFormat")
   AudioFormat audioFormat;
   @ObfuscatedName("q")
   @Export("source")
   SourceDataLine source;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1817193483
   )
   @Export("size")
   int size;
   @ObfuscatedName("p")
   @Export("bytes")
   byte[] bytes;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "849505812"
   )
   protected void vmethod2209() {
      this.audioFormat = new AudioFormat((float)AbstractSoundSystem.sampleRate, 16, Frames.audioHighMemory?2:1, true, false);
      this.bytes = new byte[256 << (Frames.audioHighMemory?2:1)];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-84"
   )
   @Export("create")
   protected void create(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.audioFormat, var1 << (Frames.audioHighMemory?2:1));
         this.source = (SourceDataLine)AudioSystem.getLine(var2);
         this.source.open();
         this.source.start();
         this.size = var1;
      } catch (LineUnavailableException var3) {
         if(class44.method648(var1) != 1) {
            this.create(class156.nextPowerOfTwo(var1));
         } else {
            this.source = null;
            throw var3;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1337442219"
   )
   @Export("size")
   protected int size() {
      return this.size - (this.source.available() >> (Frames.audioHighMemory?2:1));
   }

   @ObfuscatedName("p")
   @Export("write")
   protected void write() {
      int var1 = 256;
      if(Frames.audioHighMemory) {
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-359113654"
   )
   @Export("close")
   protected void close() {
      if(this.source != null) {
         this.source.close();
         this.source = null;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "2686"
   )
   @Export("flush")
   protected void flush() {
      this.source.flush();
   }
}
