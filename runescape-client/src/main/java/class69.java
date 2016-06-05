import java.awt.Component;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bv")
public class class69 extends class56 {
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -545583909
   )
   int field1287;
   @ObfuscatedName("i")
   SourceDataLine field1288;
   @ObfuscatedName("t")
   AudioFormat field1289;
   @ObfuscatedName("av")
   byte[] field1290;

   @ObfuscatedName("t")
   void vmethod1466(Component var1) {
      this.field1289 = new AudioFormat((float)class56.field1194, 16, class21.field575?2:1, true, false);
      this.field1290 = new byte[256 << (class21.field575?2:1)];
   }

   @ObfuscatedName("g")
   int vmethod1468() {
      return this.field1287 - (this.field1288.available() >> (class21.field575?2:1));
   }

   @ObfuscatedName("r")
   void vmethod1469() {
      this.field1288.flush();
   }

   @ObfuscatedName("h")
   void vmethod1470() {
      int var1 = 256;
      if(class21.field575) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1197[var2];
         if((8388608 + var3 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1290[2 * var2] = (byte)(var3 >> 8);
         this.field1290[2 * var2 + 1] = (byte)(var3 >> 16);
      }

      this.field1288.write(this.field1290, 0, var1 << 1);
   }

   @ObfuscatedName("z")
   void vmethod1471() {
      if(null != this.field1288) {
         this.field1288.close();
         this.field1288 = null;
      }

   }

   @ObfuscatedName("i")
   void vmethod1476(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1289, var1 << (class21.field575?2:1));
         this.field1288 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1288.open();
         this.field1288.start();
         this.field1287 = var1;
      } catch (LineUnavailableException var3) {
         if(class56.method1133(var1) != 1) {
            this.vmethod1476(class24.method575(var1));
         } else {
            this.field1288 = null;
            throw var3;
         }
      }
   }
}
