import java.awt.Component;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bz")
public class class69 extends class56 {
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1788683345
   )
   int field1299;
   @ObfuscatedName("u")
   SourceDataLine field1300;
   @ObfuscatedName("f")
   AudioFormat field1301;
   @ObfuscatedName("aj")
   byte[] field1302;

   @ObfuscatedName("d")
   void vmethod1562() {
      this.field1300.flush();
   }

   @ObfuscatedName("b")
   void vmethod1566() {
      int var1 = 256;
      if(class56.field1200) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1191[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1302[2 * var2] = (byte)(var3 >> 8);
         this.field1302[var2 * 2 + 1] = (byte)(var3 >> 16);
      }

      this.field1300.write(this.field1302, 0, var1 << 1);
   }

   @ObfuscatedName("l")
   void vmethod1567() {
      if(null != this.field1300) {
         this.field1300.close();
         this.field1300 = null;
      }

   }

   @ObfuscatedName("u")
   void vmethod1575(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1301, var1 << (class56.field1200?2:1));
         this.field1300 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1300.open();
         this.field1300.start();
         this.field1299 = var1;
      } catch (LineUnavailableException var7) {
         int var4 = (var1 & 1431655765) + (var1 >>> 1 & 1431655765);
         var4 = (var4 >>> 2 & 858993459) + (var4 & 858993459);
         var4 = var4 + (var4 >>> 4) & 252645135;
         var4 += var4 >>> 8;
         var4 += var4 >>> 16;
         int var3 = var4 & 255;
         if(var3 != 1) {
            int var6 = var1 - 1;
            var6 |= var6 >>> 1;
            var6 |= var6 >>> 2;
            var6 |= var6 >>> 4;
            var6 |= var6 >>> 8;
            var6 |= var6 >>> 16;
            int var5 = var6 + 1;
            this.vmethod1575(var5);
         } else {
            this.field1300 = null;
            throw var7;
         }
      }
   }

   @ObfuscatedName("f")
   void vmethod1576(Component var1) {
      this.field1301 = new AudioFormat((float)class56.field1196, 16, class56.field1200?2:1, true, false);
      this.field1302 = new byte[256 << (class56.field1200?2:1)];
   }

   @ObfuscatedName("x")
   int vmethod1585() {
      return this.field1299 - (this.field1300.available() >> (class56.field1200?2:1));
   }
}
