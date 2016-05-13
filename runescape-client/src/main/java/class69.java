import java.awt.Component;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("by")
public class class69 extends class56 {
   @ObfuscatedName("s")
   AudioFormat field1289;
   @ObfuscatedName("j")
   SourceDataLine field1290;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 946388125
   )
   int field1291;
   @ObfuscatedName("ap")
   byte[] field1292;

   @ObfuscatedName("d")
   void vmethod1491() {
      if(null != this.field1290) {
         this.field1290.close();
         this.field1290 = null;
      }

   }

   @ObfuscatedName("s")
   void vmethod1492(Component var1) {
      this.field1289 = new AudioFormat((float)class56.field1186, 16, class56.field1180?2:1, true, false);
      this.field1292 = new byte[256 << (class56.field1180?2:1)];
   }

   @ObfuscatedName("j")
   void vmethod1493(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1289, var1 << (class56.field1180?2:1));
         this.field1290 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1290.open();
         this.field1290.start();
         this.field1291 = var1;
      } catch (LineUnavailableException var7) {
         int var3 = (var1 >>> 1 & 1431655765) + (var1 & 1431655765);
         var3 = (var3 & 858993459) + (var3 >>> 2 & 858993459);
         var3 = var3 + (var3 >>> 4) & 252645135;
         var3 += var3 >>> 8;
         var3 += var3 >>> 16;
         int var4 = var3 & 255;
         if(var4 == 1) {
            this.field1290 = null;
            throw var7;
         }

         int var5 = var1 - 1;
         var5 |= var5 >>> 1;
         var5 |= var5 >>> 2;
         var5 |= var5 >>> 4;
         var5 |= var5 >>> 8;
         var5 |= var5 >>> 16;
         int var6 = var5 + 1;
         this.vmethod1493(var6);
      }

   }

   @ObfuscatedName("x")
   void vmethod1495() {
      int var1 = 256;
      if(class56.field1180) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1200[var2];
         if((8388608 + var3 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1292[var2 * 2] = (byte)(var3 >> 8);
         this.field1292[2 * var2 + 1] = (byte)(var3 >> 16);
      }

      this.field1290.write(this.field1292, 0, var1 << 1);
   }

   @ObfuscatedName("u")
   void vmethod1503() {
      this.field1290.flush();
   }

   @ObfuscatedName("p")
   int vmethod1510() {
      return this.field1291 - (this.field1290.available() >> (class56.field1180?2:1));
   }
}
