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

@ObfuscatedName("bh")
@Implements("SourceDataSoundSystem")
public class SourceDataSoundSystem extends AbstractSoundSystem {
   @ObfuscatedName("c")
   AudioFormat field671;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1144521471
   )
   @Export("size")
   int size;
   @ObfuscatedName("o")
   @Export("source")
   SourceDataLine source;
   @ObfuscatedName("u")
   @Export("bytes")
   byte[] bytes;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "32"
   )
   protected void vmethod1953() {
      this.source.flush();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1951583267"
   )
   @Export("close")
   protected void close() {
      if(this.source != null) {
         this.source.close();
         this.source = null;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "69"
   )
   @Export("create")
   protected void create(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field671, var1 << (class8.highMemory?2:1));
         this.source = (SourceDataLine)AudioSystem.getLine(var2);
         this.source.open();
         this.source.start();
         this.size = var1;
      } catch (LineUnavailableException var3) {
         if(GraphicsObject.method1619(var1) != 1) {
            this.create(class43.method593(var1));
         } else {
            this.source = null;
            throw var3;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-616733124"
   )
   @Export("size")
   protected int size() {
      return this.size - (this.source.available() >> (class8.highMemory?2:1));
   }

   @ObfuscatedName("u")
   @Export("write")
   protected void write() {
      int var1 = 256;
      if(class8.highMemory) {
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1959858206"
   )
   protected void vmethod1948() {
      this.field671 = new AudioFormat((float)CombatInfo1.sampleRate, 16, class8.highMemory?2:1, true, false);
      this.bytes = new byte[256 << (class8.highMemory?2:1)];
   }
}
