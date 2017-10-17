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

@ObfuscatedName("bc")
@Implements("SourceDataSoundSystem")
public class SourceDataSoundSystem extends AbstractSoundSystem {
   @ObfuscatedName("d")
   AudioFormat field690;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -222126409
   )
   @Export("size")
   int size;
   @ObfuscatedName("k")
   @Export("source")
   SourceDataLine source;
   @ObfuscatedName("p")
   @Export("bytes")
   byte[] bytes;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1570571941"
   )
   protected void vmethod2096() {
      this.source.flush();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-529989113"
   )
   @Export("close")
   protected void close() {
      if(this.source != null) {
         this.source.close();
         this.source = null;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2135777451"
   )
   @Export("create")
   protected void create(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field690, var1 << (class33.highMemory?2:1));
         this.source = (SourceDataLine)AudioSystem.getLine(var2);
         this.source.open();
         this.source.start();
         this.size = var1;
      } catch (LineUnavailableException var3) {
         if(class15.method98(var1) != 1) {
            this.create(class88.method1780(var1));
         } else {
            this.source = null;
            throw var3;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-106"
   )
   @Export("size")
   protected int size() {
      return this.size - (this.source.available() >> (class33.highMemory?2:1));
   }

   @ObfuscatedName("p")
   @Export("write")
   protected void write() {
      int var1 = 256;
      if(class33.highMemory) {
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   protected void vmethod2133() {
      this.field690 = new AudioFormat((float)class31.sampleRate, 16, class33.highMemory?2:1, true, false);
      this.bytes = new byte[256 << (class33.highMemory?2:1)];
   }
}
