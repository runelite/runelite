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

@ObfuscatedName("bw")
@Implements("SourceDataSoundSystem")
public class SourceDataSoundSystem extends AbstractSoundSystem {
   @ObfuscatedName("w")
   AudioFormat field687;
   @ObfuscatedName("s")
   @Export("source")
   SourceDataLine source;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -393362063
   )
   @Export("size")
   int size;
   @ObfuscatedName("o")
   @Export("bytes")
   byte[] bytes;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "10"
   )
   protected void vmethod2104() {
      this.field687 = new AudioFormat((float)AbstractSoundSystem.sampleRate, 16, AbstractSoundSystem.highMemory?2:1, true, false);
      this.bytes = new byte[256 << (AbstractSoundSystem.highMemory?2:1)];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "53"
   )
   @Export("create")
   protected void create(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field687, var1 << (AbstractSoundSystem.highMemory?2:1));
         this.source = (SourceDataLine)AudioSystem.getLine(var2);
         this.source.open();
         this.source.start();
         this.size = var1;
      } catch (LineUnavailableException var3) {
         if(ItemLayer.method2450(var1) != 1) {
            this.create(class48.method707(var1));
         } else {
            this.source = null;
            throw var3;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-64"
   )
   @Export("size")
   protected int size() {
      return this.size - (this.source.available() >> (AbstractSoundSystem.highMemory?2:1));
   }

   @ObfuscatedName("o")
   @Export("write")
   protected void write() {
      int var1 = 256;
      if(AbstractSoundSystem.highMemory) {
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1706331776"
   )
   @Export("close")
   protected void close() {
      if(this.source != null) {
         this.source.close();
         this.source = null;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "37"
   )
   protected void vmethod2099() {
      this.source.flush();
   }
}
