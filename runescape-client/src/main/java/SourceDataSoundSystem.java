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

@ObfuscatedName("bs")
@Implements("SourceDataSoundSystem")
public class SourceDataSoundSystem extends AbstractSoundSystem {
   @ObfuscatedName("d")
   @Export("audioFormat")
   AudioFormat audioFormat;
   @ObfuscatedName("z")
   @Export("source")
   SourceDataLine source;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1913639869
   )
   @Export("size")
   int size;
   @ObfuscatedName("r")
   @Export("bytes")
   byte[] bytes;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-89"
   )
   protected void vmethod2257() {
      this.audioFormat = new AudioFormat((float)KeyFocusListener.sampleRate, 16, AbstractSoundSystem.audioHighMemory?2:1, true, false);
      this.bytes = new byte[256 << (AbstractSoundSystem.audioHighMemory?2:1)];
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "46"
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
         int var4 = (var1 >>> 1 & 1431655765) + (var1 & 1431655765);
         var4 = (var4 >>> 2 & 858993459) + (var4 & 858993459);
         var4 = (var4 >>> 4) + var4 & 252645135;
         var4 += var4 >>> 8;
         var4 += var4 >>> 16;
         int var3 = var4 & 255;
         if(var3 != 1) {
            this.create(BoundingBox3DDrawMode.nextPowerOfTwo(var1));
         } else {
            this.source = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2073280037"
   )
   @Export("size")
   protected int size() {
      return this.size - (this.source.available() >> (AbstractSoundSystem.audioHighMemory?2:1));
   }

   @ObfuscatedName("r")
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1633999190"
   )
   @Export("close")
   protected void close() {
      if(this.source != null) {
         this.source.close();
         this.source = null;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1659429283"
   )
   @Export("flush")
   protected void flush() {
      this.source.flush();
   }
}
