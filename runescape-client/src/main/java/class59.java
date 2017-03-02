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
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -622631377
   )
   int field1058;
   @ObfuscatedName("ab")
   SourceDataLine field1059;
   @ObfuscatedName("aj")
   AudioFormat field1060;
   @ObfuscatedName("aw")
   byte[] field1061;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "445771997"
   )
   void vmethod1176(Component var1) {
      this.field1060 = new AudioFormat((float)class202.field3079, 16, class57.field1032?2:1, true, false);
      this.field1061 = new byte[256 << (class57.field1032?2:1)];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1188142474"
   )
   void vmethod1177(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1060, var1 << (class57.field1032?2:1));
         this.field1059 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1059.open();
         this.field1059.start();
         this.field1058 = var1;
      } catch (LineUnavailableException var5) {
         if(class178.method3337(var1) != 1) {
            int var4 = var1 - 1;
            var4 |= var4 >>> 1;
            var4 |= var4 >>> 2;
            var4 |= var4 >>> 4;
            var4 |= var4 >>> 8;
            var4 |= var4 >>> 16;
            int var3 = 1 + var4;
            this.vmethod1177(var3);
         } else {
            this.field1059 = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "67"
   )
   int vmethod1178() {
      return this.field1058 - (this.field1059.available() >> (class57.field1032?2:1));
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-625584532"
   )
   void vmethod1181() {
      this.field1059.flush();
   }

   @ObfuscatedName("q")
   void vmethod1183() {
      int var1 = 256;
      if(class57.field1032) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1027[var2];
         if((8388608 + var3 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1061[var2 * 2] = (byte)(var3 >> 8);
         this.field1061[var2 * 2 + 1] = (byte)(var3 >> 16);
      }

      this.field1059.write(this.field1061, 0, var1 << 1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1782972313"
   )
   void vmethod1185() {
      if(this.field1059 != null) {
         this.field1059.close();
         this.field1059 = null;
      }

   }
}
