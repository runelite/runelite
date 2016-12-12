import java.awt.Component;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
public class class59 extends class57 {
   @ObfuscatedName("ay")
   byte[] field1078;
   @ObfuscatedName("aq")
   SourceDataLine field1079;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 282327157
   )
   int field1080;
   @ObfuscatedName("ai")
   AudioFormat field1081;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-321887627"
   )
   void vmethod1086(Component var1) {
      this.field1081 = new AudioFormat((float)class57.field1053, 16, class57.field1062?2:1, true, false);
      this.field1078 = new byte[256 << (class57.field1062?2:1)];
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "1967"
   )
   void vmethod1087(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1081, var1 << (class57.field1062?2:1));
         this.field1079 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1079.open();
         this.field1079.start();
         this.field1080 = var1;
      } catch (LineUnavailableException var5) {
         int var4 = (var1 & 1431655765) + (var1 >>> 1 & 1431655765);
         var4 = (var4 & 858993459) + (var4 >>> 2 & 858993459);
         var4 = (var4 >>> 4) + var4 & 252645135;
         var4 += var4 >>> 8;
         var4 += var4 >>> 16;
         int var3 = var4 & 255;
         if(var3 != 1) {
            this.vmethod1087(class5.method70(var1));
         } else {
            this.field1079 = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1328991728"
   )
   int vmethod1088() {
      return this.field1080 - (this.field1079.available() >> (class57.field1062?2:1));
   }

   @ObfuscatedName("r")
   void vmethod1089() {
      int var1 = 256;
      if(class57.field1062) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1066[var2];
         if((8388608 + var3 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1078[2 * var2] = (byte)(var3 >> 8);
         this.field1078[1 + var2 * 2] = (byte)(var3 >> 16);
      }

      this.field1079.write(this.field1078, 0, var1 << 1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void vmethod1090() {
      if(null != this.field1079) {
         this.field1079.close();
         this.field1079 = null;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1060492503"
   )
   void vmethod1102() {
      this.field1079.flush();
   }
}
