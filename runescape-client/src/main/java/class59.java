import java.awt.Component;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
public class class59 extends class57 {
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -152704523
   )
   int field1067;
   @ObfuscatedName("ay")
   SourceDataLine field1068;
   @ObfuscatedName("aw")
   AudioFormat field1069;
   @ObfuscatedName("ai")
   byte[] field1070;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2028462161"
   )
   void vmethod1108(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1069, var1 << (class57.field1046?2:1));
         this.field1068 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1068.open();
         this.field1068.start();
         this.field1067 = var1;
      } catch (LineUnavailableException var5) {
         int var4 = (var1 >>> 1 & 1431655765) + (var1 & 1431655765);
         var4 = (var4 >>> 2 & 858993459) + (var4 & 858993459);
         var4 = (var4 >>> 4) + var4 & 252645135;
         var4 += var4 >>> 8;
         var4 += var4 >>> 16;
         int var3 = var4 & 255;
         if(var3 != 1) {
            this.vmethod1108(class195.method3615(var1));
         } else {
            this.field1068 = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1033997061"
   )
   int vmethod1109() {
      return this.field1067 - (this.field1068.available() >> (class57.field1046?2:1));
   }

   @ObfuscatedName("f")
   void vmethod1110() {
      int var1 = 256;
      if(class57.field1046) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1035[var2];
         if((8388608 + var3 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1070[2 * var2] = (byte)(var3 >> 8);
         this.field1070[1 + 2 * var2] = (byte)(var3 >> 16);
      }

      this.field1068.write(this.field1070, 0, var1 << 1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-652516171"
   )
   void vmethod1111() {
      if(null != this.field1068) {
         this.field1068.close();
         this.field1068 = null;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "4"
   )
   void vmethod1115(Component var1) {
      this.field1069 = new AudioFormat((float)class57.field1031, 16, class57.field1046?2:1, true, false);
      this.field1070 = new byte[256 << (class57.field1046?2:1)];
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1498636174"
   )
   void vmethod1117() {
      this.field1068.flush();
   }
}
