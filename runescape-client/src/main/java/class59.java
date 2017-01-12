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
public class class59 extends class57 {
   @ObfuscatedName("al")
   SourceDataLine field1068;
   @ObfuscatedName("ag")
   AudioFormat field1069;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -257117733
   )
   int field1070;
   @ObfuscatedName("af")
   byte[] field1071;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "804385944"
   )
   void vmethod1069(Component var1) {
      this.field1069 = new AudioFormat((float)class7.field65, 16, class57.field1055?2:1, true, false);
      this.field1071 = new byte[256 << (class57.field1055?2:1)];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-425903907"
   )
   int vmethod1070() {
      return this.field1070 - (this.field1068.available() >> (class57.field1055?2:1));
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "540541292"
   )
   void vmethod1072() {
      if(null != this.field1068) {
         this.field1068.close();
         this.field1068 = null;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "56360630"
   )
   void vmethod1073() {
      this.field1068.flush();
   }

   @ObfuscatedName("k")
   void vmethod1075() {
      int var1 = 256;
      if(class57.field1055) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1035[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1071[var2 * 2] = (byte)(var3 >> 8);
         this.field1071[var2 * 2 + 1] = (byte)(var3 >> 16);
      }

      this.field1068.write(this.field1071, 0, var1 << 1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2060669672"
   )
   void vmethod1080(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1069, var1 << (class57.field1055?2:1));
         this.field1068 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1068.open();
         this.field1068.start();
         this.field1070 = var1;
      } catch (LineUnavailableException var5) {
         if(Widget.method3215(var1) != 1) {
            int var4 = var1 - 1;
            var4 |= var4 >>> 1;
            var4 |= var4 >>> 2;
            var4 |= var4 >>> 4;
            var4 |= var4 >>> 8;
            var4 |= var4 >>> 16;
            int var3 = var4 + 1;
            this.vmethod1080(var3);
         } else {
            this.field1068 = null;
            throw var5;
         }
      }
   }
}
