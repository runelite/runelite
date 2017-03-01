import java.awt.Component;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
public class class59 extends class57 {
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 35051859
   )
   int field1085;
   @ObfuscatedName("ac")
   AudioFormat field1086;
   @ObfuscatedName("ae")
   byte[] field1087;
   @ObfuscatedName("au")
   SourceDataLine field1088;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "506438239"
   )
   void vmethod1198(Component var1) {
      this.field1086 = new AudioFormat((float)class57.field1053, 16, class57.field1059?2:1, true, false);
      this.field1087 = new byte[256 << (class57.field1059?2:1)];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1962420274"
   )
   void vmethod1199(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1086, var1 << (class57.field1059?2:1));
         this.field1088 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1088.open();
         this.field1088.start();
         this.field1085 = var1;
      } catch (LineUnavailableException var5) {
         int var4 = (var1 >>> 1 & 1431655765) + (var1 & 1431655765);
         var4 = (var4 & 858993459) + (var4 >>> 2 & 858993459);
         var4 = var4 + (var4 >>> 4) & 252645135;
         var4 += var4 >>> 8;
         var4 += var4 >>> 16;
         int var3 = var4 & 255;
         if(var3 != 1) {
            this.vmethod1199(class25.method614(var1));
         } else {
            this.field1088 = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("b")
   void vmethod1201() {
      int var1 = 256;
      if(class57.field1059) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1050[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1087[var2 * 2] = (byte)(var3 >> 8);
         this.field1087[1 + var2 * 2] = (byte)(var3 >> 16);
      }

      this.field1088.write(this.field1087, 0, var1 << 1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-414252588"
   )
   void vmethod1202() {
      if(this.field1088 != null) {
         this.field1088.close();
         this.field1088 = null;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1087122673"
   )
   void vmethod1203() {
      this.field1088.flush();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "333530633"
   )
   int vmethod1204() {
      return this.field1085 - (this.field1088.available() >> (class57.field1059?2:1));
   }
}
