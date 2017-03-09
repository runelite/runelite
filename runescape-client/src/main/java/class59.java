import java.awt.Component;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public class class59 extends class57 {
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 887890175
   )
   int field1082;
   @ObfuscatedName("ar")
   AudioFormat field1083;
   @ObfuscatedName("aa")
   SourceDataLine field1084;
   @ObfuscatedName("ax")
   byte[] field1085;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1814248783"
   )
   void vmethod1196(Component var1) {
      this.field1083 = new AudioFormat((float)class148.field2033, 16, class57.field1058?2:1, true, false);
      this.field1085 = new byte[256 << (class57.field1058?2:1)];
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "119"
   )
   int vmethod1197() {
      return this.field1082 - (this.field1084.available() >> (class57.field1058?2:1));
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-61"
   )
   void vmethod1198(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1083, var1 << (class57.field1058?2:1));
         this.field1084 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1084.open();
         this.field1084.start();
         this.field1082 = var1;
      } catch (LineUnavailableException var5) {
         if(class112.method2149(var1) != 1) {
            int var4 = var1 - 1;
            var4 |= var4 >>> 1;
            var4 |= var4 >>> 2;
            var4 |= var4 >>> 4;
            var4 |= var4 >>> 8;
            var4 |= var4 >>> 16;
            int var3 = var4 + 1;
            this.vmethod1198(var3);
         } else {
            this.field1084 = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("m")
   void vmethod1200() {
      int var1 = 256;
      if(class57.field1058) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1053[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1085[2 * var2] = (byte)(var3 >> 8);
         this.field1085[2 * var2 + 1] = (byte)(var3 >> 16);
      }

      this.field1084.write(this.field1085, 0, var1 << 1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   void vmethod1201() {
      if(null != this.field1084) {
         this.field1084.close();
         this.field1084 = null;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-11"
   )
   void vmethod1202() {
      this.field1084.flush();
   }
}
