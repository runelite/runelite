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

@ObfuscatedName("by")
@Implements("SourceDataSoundSystem")
public class SourceDataSoundSystem extends AbstractSoundSystem {
   @ObfuscatedName("n")
   @Export("audioFormat")
   AudioFormat audioFormat;
   @ObfuscatedName("v")
   @Export("source")
   SourceDataLine source;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1518684947
   )
   @Export("size")
   int size;
   @ObfuscatedName("r")
   @Export("bytes")
   byte[] bytes;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2071014398"
   )
   protected void vmethod2091() {
      this.audioFormat = new AudioFormat((float)AbstractSoundSystem.sampleRate, 16, class2.highMemory?2:1, true, false);
      this.bytes = new byte[256 << (class2.highMemory?2:1)];
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-3112"
   )
   @Export("create")
   protected void create(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.audioFormat, var1 << (class2.highMemory?2:1));
         this.source = (SourceDataLine)AudioSystem.getLine(var2);
         this.source.open();
         this.source.start();
         this.size = var1;
      } catch (LineUnavailableException var3) {
         if(PacketNode.method3255(var1) != 1) {
            this.create(class234.nextPowerOfTwo(var1));
         } else {
            this.source = null;
            throw var3;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1441335077"
   )
   @Export("size")
   protected int size() {
      return this.size - (this.source.available() >> (class2.highMemory?2:1));
   }

   @ObfuscatedName("r")
   @Export("write")
   protected void write() {
      int var1 = 256;
      if(class2.highMemory) {
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1628319647"
   )
   @Export("close")
   protected void close() {
      if(this.source != null) {
         this.source.close();
         this.source = null;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-118"
   )
   @Export("flush")
   protected void flush() {
      this.source.flush();
   }
}
