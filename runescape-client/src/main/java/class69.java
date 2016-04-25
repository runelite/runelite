import java.awt.Component;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bf")
public class class69 extends class56 {
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1875460665
   )
   int field1266;
   @ObfuscatedName("h")
   SourceDataLine field1267;
   @ObfuscatedName("j")
   AudioFormat field1268;
   @ObfuscatedName("an")
   byte[] field1269;

   @ObfuscatedName("h")
   void vmethod1503(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1268, var1 << (class113.field1944?2:1));
         this.field1267 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1267.open();
         this.field1267.start();
         this.field1266 = var1;
      } catch (LineUnavailableException var7) {
         int var4 = (var1 >>> 1 & 1431655765) + (var1 & 1431655765);
         var4 = (var4 >>> 2 & 858993459) + (var4 & 858993459);
         var4 = (var4 >>> 4) + var4 & 252645135;
         var4 += var4 >>> 8;
         var4 += var4 >>> 16;
         int var3 = var4 & 255;
         if(1 != var3) {
            int var6 = var1 - 1;
            var6 |= var6 >>> 1;
            var6 |= var6 >>> 2;
            var6 |= var6 >>> 4;
            var6 |= var6 >>> 8;
            var6 |= var6 >>> 16;
            int var5 = 1 + var6;
            this.vmethod1503(var5);
         } else {
            this.field1267 = null;
            throw var7;
         }
      }
   }

   @ObfuscatedName("x")
   void vmethod1506() {
      if(this.field1267 != null) {
         this.field1267.close();
         this.field1267 = null;
      }

   }

   @ObfuscatedName("e")
   void vmethod1507() {
      this.field1267.flush();
   }

   @ObfuscatedName("z")
   void vmethod1518() {
      int var1 = 256;
      if(class113.field1944) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1161[var2];
         if(0 != (var3 + 8388608 & -16777216)) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1269[var2 * 2] = (byte)(var3 >> 8);
         this.field1269[var2 * 2 + 1] = (byte)(var3 >> 16);
      }

      this.field1267.write(this.field1269, 0, var1 << 1);
   }

   @ObfuscatedName("m")
   int vmethod1520() {
      return this.field1266 - (this.field1267.available() >> (class113.field1944?2:1));
   }

   @ObfuscatedName("j")
   void vmethod1521(Component var1) {
      this.field1268 = new AudioFormat((float)class56.field1181, 16, class113.field1944?2:1, true, false);
      this.field1269 = new byte[256 << (class113.field1944?2:1)];
   }
}
