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

@ObfuscatedName("ax")
@Implements("DevicePcmPlayer")
public class DevicePcmPlayer extends PcmPlayer {
   @ObfuscatedName("m")
   @Export("format")
   AudioFormat format;
   @ObfuscatedName("f")
   @Export("line")
   SourceDataLine line;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -106586673
   )
   @Export("capacity2")
   int capacity2;
   @ObfuscatedName("w")
   @Export("byteSamples")
   byte[] byteSamples;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "949670609"
   )
   @Export("init")
   protected void init() {
      this.format = new AudioFormat((float)class309.PcmPlayer_sampleRate, 16, PcmPlayer.isStereo?2:1, true, false);
      this.byteSamples = new byte[256 << (PcmPlayer.isStereo?2:1)];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1738349775"
   )
   @Export("open")
   protected void open(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.format, var1 << (PcmPlayer.isStereo?2:1));
         this.line = (SourceDataLine)AudioSystem.getLine(var2);
         this.line.open();
         this.line.start();
         this.capacity2 = var1;
      } catch (LineUnavailableException var5) {
         int var3 = (var1 >>> 1 & 1431655765) + (var1 & 1431655765);
         var3 = (var3 >>> 2 & 858993459) + (var3 & 858993459);
         var3 = (var3 >>> 4) + var3 & 252645135;
         var3 += var3 >>> 8;
         var3 += var3 >>> 16;
         int var4 = var3 & 255;
         if(var4 == 1) {
            this.line = null;
            throw var5;
         }

         this.open(World.method1759(var1));
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   @Export("position")
   protected int position() {
      return this.capacity2 - (this.line.available() >> (PcmPlayer.isStereo?2:1));
   }

   @ObfuscatedName("w")
   @Export("write")
   protected void write() {
      int var1 = 256;
      if(PcmPlayer.isStereo) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.samples[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.byteSamples[var2 * 2] = (byte)(var3 >> 8);
         this.byteSamples[var2 * 2 + 1] = (byte)(var3 >> 16);
      }

      this.line.write(this.byteSamples, 0, var1 << 1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "244995961"
   )
   @Export("close")
   protected void close() {
      if(this.line != null) {
         this.line.close();
         this.line = null;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-191421600"
   )
   @Export("discard")
   protected void discard() {
      this.line.flush();
   }
}
