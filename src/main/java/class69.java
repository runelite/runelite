import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("be")
public class class69 extends class56 {
   @ObfuscatedName("w")
   AudioFormat field1289;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1950323719
   )
   int field1290;
   @ObfuscatedName("x")
   SourceDataLine field1291;
   @ObfuscatedName("ai")
   byte[] field1292;

   @ObfuscatedName("w")
   void vmethod1510() {
      this.field1289 = new AudioFormat((float)class129.field2058, 16, class56.field1194?2:1, true, false);
      this.field1292 = new byte[256 << (class56.field1194?2:1)];
   }

   @ObfuscatedName("t")
   int vmethod1512() {
      return this.field1290 - (this.field1291.available() >> (class56.field1194?2:1));
   }

   @ObfuscatedName("p")
   void vmethod1513() {
      int var1 = 256;
      if(class56.field1194) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1193[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1292[2 * var2] = (byte)(var3 >> 8);
         this.field1292[1 + var2 * 2] = (byte)(var3 >> 16);
      }

      this.field1291.write(this.field1292, 0, var1 << 1);
   }

   @ObfuscatedName("e")
   void vmethod1514() {
      if(this.field1291 != null) {
         this.field1291.close();
         this.field1291 = null;
      }

   }

   @ObfuscatedName("x")
   void vmethod1517(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1289, var1 << (class56.field1194?2:1));
         this.field1291 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1291.open();
         this.field1291.start();
         this.field1290 = var1;
      } catch (LineUnavailableException var5) {
         int var4 = (var1 >>> 1 & 1431655765) + (var1 & 1431655765);
         var4 = (var4 & 858993459) + (var4 >>> 2 & 858993459);
         var4 = (var4 >>> 4) + var4 & 252645135;
         var4 += var4 >>> 8;
         var4 += var4 >>> 16;
         int var3 = var4 & 255;
         if(1 != var3) {
            this.vmethod1517(class126.method2812(var1));
         } else {
            this.field1291 = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("y")
   void vmethod1518() {
      this.field1291.flush();
   }
}
