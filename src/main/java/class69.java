import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bw")
public class class69 extends class56 {
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -423703243
   )
   int field1283;
   @ObfuscatedName("r")
   SourceDataLine field1284;
   @ObfuscatedName("a")
   AudioFormat field1285;
   @ObfuscatedName("ak")
   byte[] field1286;

   @ObfuscatedName("f")
   int vmethod1542() {
      return this.field1283 - (this.field1284.available() >> (class56.field1173?2:1));
   }

   @ObfuscatedName("r")
   void vmethod1545(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1285, var1 << (class56.field1173?2:1));
         this.field1284 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1284.open();
         this.field1284.start();
         this.field1283 = var1;
      } catch (LineUnavailableException var5) {
         if(class30.method665(var1) != 1) {
            int var4 = var1 - 1;
            var4 |= var4 >>> 1;
            var4 |= var4 >>> 2;
            var4 |= var4 >>> 4;
            var4 |= var4 >>> 8;
            var4 |= var4 >>> 16;
            int var3 = var4 + 1;
            this.vmethod1545(var3);
         } else {
            this.field1284 = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("s")
   void vmethod1546() {
      int var1 = 256;
      if(class56.field1173) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1182[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1286[2 * var2] = (byte)(var3 >> 8);
         this.field1286[1 + 2 * var2] = (byte)(var3 >> 16);
      }

      this.field1284.write(this.field1286, 0, var1 << 1);
   }

   @ObfuscatedName("y")
   void vmethod1547() {
      if(null != this.field1284) {
         this.field1284.close();
         this.field1284 = null;
      }

   }

   @ObfuscatedName("e")
   void vmethod1548() {
      this.field1284.flush();
   }

   @ObfuscatedName("a")
   void vmethod1563() {
      this.field1285 = new AudioFormat((float)class56.field1185, 16, class56.field1173?2:1, true, false);
      this.field1286 = new byte[256 << (class56.field1173?2:1)];
   }
}
