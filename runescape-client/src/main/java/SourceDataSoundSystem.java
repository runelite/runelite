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

@ObfuscatedName("bl")
@Implements("SourceDataSoundSystem")
public class SourceDataSoundSystem extends AbstractSoundSystem {
   @ObfuscatedName("m")
   AudioFormat field637;
   @ObfuscatedName("p")
   @Export("source")
   SourceDataLine source;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2077263117
   )
   @Export("size")
   int size;
   @ObfuscatedName("j")
   @Export("bytes")
   byte[] bytes;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1401334584"
   )
   protected void vmethod2113() {
      this.field637 = new AudioFormat((float)AbstractSoundSystem.sampleRate, 16, AbstractSoundSystem.highMemory?2:1, true, false);
      this.bytes = new byte[256 << (AbstractSoundSystem.highMemory?2:1)];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1790157393"
   )
   @Export("create")
   protected void create(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field637, var1 << (AbstractSoundSystem.highMemory?2:1));
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
            this.create(class163.method3173(var1));
         } else {
            this.source = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-753278569"
   )
   @Export("size")
   protected int size() {
      return this.size - (this.source.available() >> (AbstractSoundSystem.highMemory?2:1));
   }

   @ObfuscatedName("j")
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1311794284"
   )
   @Export("close")
   protected void close() {
      if(this.source != null) {
         this.source.close();
         this.source = null;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "123"
   )
   protected void vmethod2128() {
      this.source.flush();
   }
}
