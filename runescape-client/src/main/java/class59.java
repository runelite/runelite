import java.awt.Component;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public class class59 extends class57 {
   @ObfuscatedName("ad")
   SourceDataLine field1075;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 139297591
   )
   int field1076;
   @ObfuscatedName("am")
   AudioFormat field1077;
   @ObfuscatedName("aj")
   byte[] field1078;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "124"
   )
   void vmethod1086(Component var1) {
      this.field1077 = new AudioFormat((float)class57.field1047, 16, class57.field1042?2:1, true, false);
      this.field1078 = new byte[256 << (class57.field1042?2:1)];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-484375625"
   )
   void vmethod1088(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1077, var1 << (class57.field1042?2:1));
         this.field1075 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1075.open();
         this.field1075.start();
         this.field1076 = var1;
      } catch (LineUnavailableException var5) {
         if(class16.method185(var1) != 1) {
            int var4 = var1 - 1;
            var4 |= var4 >>> 1;
            var4 |= var4 >>> 2;
            var4 |= var4 >>> 4;
            var4 |= var4 >>> 8;
            var4 |= var4 >>> 16;
            int var3 = var4 + 1;
            this.vmethod1088(var3);
         } else {
            this.field1075 = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("n")
   void vmethod1090() {
      int var1 = 256;
      if(class57.field1042) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1045[var2];
         if((8388608 + var3 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1078[var2 * 2] = (byte)(var3 >> 8);
         this.field1078[var2 * 2 + 1] = (byte)(var3 >> 16);
      }

      this.field1075.write(this.field1078, 0, var1 << 1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-403371012"
   )
   void vmethod1091() {
      if(this.field1075 != null) {
         this.field1075.close();
         this.field1075 = null;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1017408769"
   )
   int vmethod1092() {
      return this.field1076 - (this.field1075.available() >> (class57.field1042?2:1));
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1403695221"
   )
   void vmethod1097() {
      this.field1075.flush();
   }
}
