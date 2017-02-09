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
public class class59 extends class57 {
   @ObfuscatedName("ah")
   byte[] field1074;
   @ObfuscatedName("aw")
   SourceDataLine field1075;
   @ObfuscatedName("aq")
   AudioFormat field1076;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1833303543
   )
   int field1077;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1680339984"
   )
   void vmethod1125(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1076, var1 << (class57.field1057?2:1));
         this.field1075 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1075.open();
         this.field1075.start();
         this.field1077 = var1;
      } catch (LineUnavailableException var3) {
         if(class39.method766(var1) != 1) {
            this.vmethod1125(class152.method2857(var1));
         } else {
            this.field1075 = null;
            throw var3;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "688812939"
   )
   int vmethod1126() {
      return this.field1077 - (this.field1075.available() >> (class57.field1057?2:1));
   }

   @ObfuscatedName("t")
   void vmethod1127() {
      int var1 = 256;
      if(class57.field1057) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1051[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1074[var2 * 2] = (byte)(var3 >> 8);
         this.field1074[2 * var2 + 1] = (byte)(var3 >> 16);
      }

      this.field1075.write(this.field1074, 0, var1 << 1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "127"
   )
   void vmethod1128() {
      if(null != this.field1075) {
         this.field1075.close();
         this.field1075 = null;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2102006809"
   )
   void vmethod1129() {
      this.field1075.flush();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "48"
   )
   void vmethod1141(Component var1) {
      this.field1076 = new AudioFormat((float)class57.field1045, 16, class57.field1057?2:1, true, false);
      this.field1074 = new byte[256 << (class57.field1057?2:1)];
   }
}
