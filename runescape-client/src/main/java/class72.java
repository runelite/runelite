import java.awt.Component;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
public class class72 extends class59 {
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 914195693
   )
   int field1325;
   @ObfuscatedName("ah")
   AudioFormat field1326;
   @ObfuscatedName("am")
   SourceDataLine field1327;
   @ObfuscatedName("ax")
   byte[] field1328;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-240558021"
   )
   void vmethod1518(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1326, var1 << (class59.field1222?2:1));
         this.field1327 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1327.open();
         this.field1327.start();
         this.field1325 = var1;
      } catch (LineUnavailableException var5) {
         if(class24.method588(var1) != 1) {
            int var4 = var1 - 1;
            var4 |= var4 >>> 1;
            var4 |= var4 >>> 2;
            var4 |= var4 >>> 4;
            var4 |= var4 >>> 8;
            var4 |= var4 >>> 16;
            int var3 = var4 + 1;
            this.vmethod1518(var3);
         } else {
            this.field1327 = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2001671099"
   )
   int vmethod1520() {
      return this.field1325 - (this.field1327.available() >> (class59.field1222?2:1));
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-459554410"
   )
   void vmethod1521() {
      if(null != this.field1327) {
         this.field1327.close();
         this.field1327 = null;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1119957445"
   )
   void vmethod1522(Component var1) {
      this.field1326 = new AudioFormat((float)class59.field1219, 16, class59.field1222?2:1, true, false);
      this.field1328 = new byte[256 << (class59.field1222?2:1)];
   }

   @ObfuscatedName("n")
   void vmethod1527() {
      int var1 = 256;
      if(class59.field1222) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1240[var2];
         if((8388608 + var3 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1328[2 * var2] = (byte)(var3 >> 8);
         this.field1328[2 * var2 + 1] = (byte)(var3 >> 16);
      }

      this.field1327.write(this.field1328, 0, var1 << 1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1531665772"
   )
   void vmethod1531() {
      this.field1327.flush();
   }
}
