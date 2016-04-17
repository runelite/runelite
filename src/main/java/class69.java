import java.awt.Component;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bx")
public class class69 extends class56 {
   @ObfuscatedName("a")
   AudioFormat field1291;
   @ObfuscatedName("w")
   SourceDataLine field1292;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -171499407
   )
   int field1293;
   @ObfuscatedName("af")
   byte[] field1294;

   @ObfuscatedName("a")
   void vmethod1614(Component var1) {
      this.field1291 = new AudioFormat((float)class40.field973, 16, class96.field1633?2:1, true, false);
      this.field1294 = new byte[256 << (class96.field1633?2:1)];
   }

   @ObfuscatedName("w")
   void vmethod1615(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1291, var1 << (class96.field1633?2:1));
         this.field1292 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1292.open();
         this.field1292.start();
         this.field1293 = var1;
      } catch (LineUnavailableException var5) {
         if(class102.method2373(var1) != 1) {
            int var4 = var1 - 1;
            var4 |= var4 >>> 1;
            var4 |= var4 >>> 2;
            var4 |= var4 >>> 4;
            var4 |= var4 >>> 8;
            var4 |= var4 >>> 16;
            int var3 = 1 + var4;
            this.vmethod1615(var3);
         } else {
            this.field1292 = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("d")
   int vmethod1617() {
      return this.field1293 - (this.field1292.available() >> (class96.field1633?2:1));
   }

   @ObfuscatedName("y")
   void vmethod1618() {
      if(this.field1292 != null) {
         this.field1292.close();
         this.field1292 = null;
      }

   }

   @ObfuscatedName("c")
   void vmethod1619() {
      int var1 = 256;
      if(class96.field1633) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1188[var2];
         if(0 != (8388608 + var3 & -16777216)) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1294[2 * var2] = (byte)(var3 >> 8);
         this.field1294[1 + 2 * var2] = (byte)(var3 >> 16);
      }

      this.field1292.write(this.field1294, 0, var1 << 1);
   }

   @ObfuscatedName("k")
   void vmethod1621() {
      this.field1292.flush();
   }
}
