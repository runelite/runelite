import java.awt.Component;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public class class72 extends class59 {
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1630836203
   )
   int field1353;
   @ObfuscatedName("as")
   SourceDataLine field1354;
   @ObfuscatedName("ak")
   AudioFormat field1355;
   @ObfuscatedName("ao")
   byte[] field1356;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2010510773"
   )
   void vmethod1600() {
      if(this.field1354 != null) {
         this.field1354.close();
         this.field1354 = null;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1465181803"
   )
   void vmethod1602(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1355, var1 << (class59.field1242?2:1));
         this.field1354 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1354.open();
         this.field1354.start();
         this.field1353 = var1;
      } catch (LineUnavailableException var5) {
         int var4 = (var1 >>> 1 & 1431655765) + (var1 & 1431655765);
         var4 = (var4 & 858993459) + (var4 >>> 2 & 858993459);
         var4 = (var4 >>> 4) + var4 & 252645135;
         var4 += var4 >>> 8;
         var4 += var4 >>> 16;
         int var3 = var4 & 255;
         if(var3 != 1) {
            this.vmethod1602(class48.method1033(var1));
         } else {
            this.field1354 = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1337764375"
   )
   int vmethod1603() {
      return this.field1353 - (this.field1354.available() >> (class59.field1242?2:1));
   }

   @ObfuscatedName("j")
   void vmethod1604() {
      int var1 = 256;
      if(class59.field1242) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1247[var2];
         if((8388608 + var3 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1356[var2 * 2] = (byte)(var3 >> 8);
         this.field1356[1 + var2 * 2] = (byte)(var3 >> 16);
      }

      this.field1354.write(this.field1356, 0, var1 << 1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "117"
   )
   void vmethod1610(Component var1) {
      this.field1355 = new AudioFormat((float)class59.field1260, 16, class59.field1242?2:1, true, false);
      this.field1356 = new byte[256 << (class59.field1242?2:1)];
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-43"
   )
   void vmethod1620() {
      this.field1354.flush();
   }
}
