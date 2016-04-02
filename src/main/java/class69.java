import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ba")
public class class69 extends class56 {
   @ObfuscatedName("w")
   SourceDataLine field1255;
   @ObfuscatedName("az")
   byte[] field1256;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -525465595
   )
   int field1257;
   @ObfuscatedName("e")
   AudioFormat field1258;

   @ObfuscatedName("e")
   void vmethod1510() {
      this.field1258 = new AudioFormat((float)class56.field1153, 16, class56.field1160?2:1, true, false);
      this.field1256 = new byte[256 << (class56.field1160?2:1)];
   }

   @ObfuscatedName("h")
   void vmethod1511() {
      this.field1255.flush();
   }

   @ObfuscatedName("f")
   int vmethod1512() {
      return this.field1257 - (this.field1255.available() >> (class56.field1160?2:1));
   }

   @ObfuscatedName("p")
   void vmethod1513() {
      if(this.field1255 != null) {
         this.field1255.close();
         this.field1255 = null;
      }

   }

   @ObfuscatedName("s")
   void vmethod1514() {
      int var1 = 256;
      if(class56.field1160) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1151[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1256[var2 * 2] = (byte)(var3 >> 8);
         this.field1256[2 * var2 + 1] = (byte)(var3 >> 16);
      }

      this.field1255.write(this.field1256, 0, var1 << 1);
   }

   @ObfuscatedName("w")
   void vmethod1526(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1258, var1 << (class56.field1160?2:1));
         this.field1255 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1255.open();
         this.field1255.start();
         this.field1257 = var1;
      } catch (LineUnavailableException var3) {
         if(class75.method1637(var1) != 1) {
            this.vmethod1526(class25.method630(var1));
         } else {
            this.field1255 = null;
            throw var3;
         }
      }
   }
}
