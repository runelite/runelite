import java.awt.Component;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
public class class59 extends class57 {
   @ObfuscatedName("at")
   SourceDataLine field1094;
   @ObfuscatedName("aq")
   AudioFormat field1095;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 625333185
   )
   int field1096;
   @ObfuscatedName("am")
   byte[] field1097;

   @ObfuscatedName("z")
   void vmethod1174() {
      int var1 = 256;
      if(class57.field1070) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1066[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1097[var2 * 2] = (byte)(var3 >> 8);
         this.field1097[1 + var2 * 2] = (byte)(var3 >> 16);
      }

      this.field1094.write(this.field1097, 0, var1 << 1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1873899603"
   )
   void vmethod1175(Component var1) {
      this.field1095 = new AudioFormat((float)class57.field1061, 16, class57.field1070?2:1, true, false);
      this.field1097 = new byte[256 << (class57.field1070?2:1)];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "693082780"
   )
   int vmethod1177() {
      return this.field1096 - (this.field1094.available() >> (class57.field1070?2:1));
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "424306066"
   )
   void vmethod1178(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1095, var1 << (class57.field1070?2:1));
         this.field1094 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1094.open();
         this.field1094.start();
         this.field1096 = var1;
      } catch (LineUnavailableException var5) {
         int var4 = (var1 & 1431655765) + (var1 >>> 1 & 1431655765);
         var4 = (var4 >>> 2 & 858993459) + (var4 & 858993459);
         var4 = var4 + (var4 >>> 4) & 252645135;
         var4 += var4 >>> 8;
         var4 += var4 >>> 16;
         int var3 = var4 & 255;
         if(var3 != 1) {
            this.vmethod1178(Actor.method634(var1));
         } else {
            this.field1094 = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1570225197"
   )
   void vmethod1179() {
      if(this.field1094 != null) {
         this.field1094.close();
         this.field1094 = null;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "16930"
   )
   void vmethod1180() {
      this.field1094.flush();
   }
}
