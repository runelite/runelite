import java.awt.Component;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
public class class72 extends class59 {
   @ObfuscatedName("am")
   byte[] field1354;
   @ObfuscatedName("ac")
   SourceDataLine field1355;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1849189431
   )
   int field1356;
   @ObfuscatedName("as")
   AudioFormat field1357;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1444420017"
   )
   void vmethod1627(Component var1) {
      this.field1357 = new AudioFormat((float)class59.field1254, 16, class59.field1264?2:1, true, false);
      this.field1354 = new byte[256 << (class59.field1264?2:1)];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1853955282"
   )
   void vmethod1628(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1357, var1 << (class59.field1264?2:1));
         this.field1355 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1355.open();
         this.field1355.start();
         this.field1356 = var1;
      } catch (LineUnavailableException var7) {
         int var3 = (var1 >>> 1 & 1431655765) + (var1 & 1431655765);
         var3 = (var3 >>> 2 & 858993459) + (var3 & 858993459);
         var3 = var3 + (var3 >>> 4) & 252645135;
         var3 += var3 >>> 8;
         var3 += var3 >>> 16;
         int var4 = var3 & 255;
         if(var4 == 1) {
            this.field1355 = null;
            throw var7;
         }

         int var5 = var1 - 1;
         var5 |= var5 >>> 1;
         var5 |= var5 >>> 2;
         var5 |= var5 >>> 4;
         var5 |= var5 >>> 8;
         var5 |= var5 >>> 16;
         int var6 = 1 + var5;
         this.vmethod1628(var6);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "885303349"
   )
   int vmethod1629() {
      return this.field1356 - (this.field1355.available() >> (class59.field1264?2:1));
   }

   @ObfuscatedName("w")
   void vmethod1630() {
      int var1 = 256;
      if(class59.field1264) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1248[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1354[2 * var2] = (byte)(var3 >> 8);
         this.field1354[1 + var2 * 2] = (byte)(var3 >> 16);
      }

      this.field1355.write(this.field1354, 0, var1 << 1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   void vmethod1631() {
      if(this.field1355 != null) {
         this.field1355.close();
         this.field1355 = null;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1522696766"
   )
   void vmethod1641() {
      this.field1355.flush();
   }
}
