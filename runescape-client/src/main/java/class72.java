import java.awt.Component;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public class class72 extends class59 {
   @ObfuscatedName("ap")
   byte[] field1355;
   @ObfuscatedName("af")
   SourceDataLine field1356;
   @ObfuscatedName("as")
   AudioFormat field1357;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 184864373
   )
   int field1358;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1930277508"
   )
   void vmethod1561(Component var1) {
      this.field1357 = new AudioFormat((float)class59.field1265, 16, class59.field1262?2:1, true, false);
      this.field1355 = new byte[256 << (class59.field1262?2:1)];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-20243"
   )
   int vmethod1563() {
      return this.field1358 - (this.field1356.available() >> (class59.field1262?2:1));
   }

   @ObfuscatedName("q")
   void vmethod1564() {
      int var1 = 256;
      if(class59.field1262) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1251[var2];
         if((8388608 + var3 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1355[2 * var2] = (byte)(var3 >> 8);
         this.field1355[1 + 2 * var2] = (byte)(var3 >> 16);
      }

      this.field1356.write(this.field1355, 0, var1 << 1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-142755678"
   )
   void vmethod1565() {
      if(null != this.field1356) {
         this.field1356.close();
         this.field1356 = null;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "48"
   )
   void vmethod1566(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1357, var1 << (class59.field1262?2:1));
         this.field1356 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1356.open();
         this.field1356.start();
         this.field1358 = var1;
      } catch (LineUnavailableException var5) {
         int var4 = (var1 & 1431655765) + (var1 >>> 1 & 1431655765);
         var4 = (var4 >>> 2 & 858993459) + (var4 & 858993459);
         var4 = (var4 >>> 4) + var4 & 252645135;
         var4 += var4 >>> 8;
         var4 += var4 >>> 16;
         int var3 = var4 & 255;
         if(var3 != 1) {
            this.vmethod1566(class155.method3191(var1));
         } else {
            this.field1356 = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1830537427"
   )
   void vmethod1571() {
      this.field1356.flush();
   }
}
