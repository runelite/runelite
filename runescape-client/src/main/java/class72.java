import java.awt.Component;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
public class class72 extends class59 {
   @ObfuscatedName("ap")
   SourceDataLine field1357;
   @ObfuscatedName("an")
   AudioFormat field1358;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1395694835
   )
   int field1359;
   @ObfuscatedName("ab")
   byte[] field1360;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "2071460094"
   )
   void vmethod1596(Component var1) {
      this.field1358 = new AudioFormat((float)class59.field1268, 16, class59.field1247?2:1, true, false);
      this.field1360 = new byte[256 << (class59.field1247?2:1)];
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1330954291"
   )
   int vmethod1598() {
      return this.field1359 - (this.field1357.available() >> (class59.field1247?2:1));
   }

   @ObfuscatedName("y")
   void vmethod1599() {
      int var1 = 256;
      if(class59.field1247) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1251[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1360[var2 * 2] = (byte)(var3 >> 8);
         this.field1360[2 * var2 + 1] = (byte)(var3 >> 16);
      }

      this.field1357.write(this.field1360, 0, var1 << 1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-554023544"
   )
   void vmethod1601(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1358, var1 << (class59.field1247?2:1));
         this.field1357 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1357.open();
         this.field1357.start();
         this.field1359 = var1;
      } catch (LineUnavailableException var5) {
         int var4 = (var1 & 1431655765) + (var1 >>> 1 & 1431655765);
         var4 = (var4 & 858993459) + (var4 >>> 2 & 858993459);
         var4 = (var4 >>> 4) + var4 & 252645135;
         var4 += var4 >>> 8;
         var4 += var4 >>> 16;
         int var3 = var4 & 255;
         if(var3 != 1) {
            this.vmethod1601(class36.method749(var1));
         } else {
            this.field1357 = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-56"
   )
   void vmethod1604() {
      this.field1357.flush();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1204122107"
   )
   void vmethod1611() {
      if(null != this.field1357) {
         this.field1357.close();
         this.field1357 = null;
      }

   }
}
