import java.awt.Component;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public class class59 extends class57 {
   @ObfuscatedName("ag")
   AudioFormat field1074;
   @ObfuscatedName("au")
   SourceDataLine field1075;
   @ObfuscatedName("ae")
   byte[] field1076;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1533097707
   )
   int field1077;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "-44"
   )
   void vmethod1090(Component var1) {
      this.field1074 = new AudioFormat((float)class57.field1042, 16, class57.field1044?2:1, true, false);
      this.field1076 = new byte[256 << (class57.field1044?2:1)];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1096175189"
   )
   void vmethod1091(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1074, var1 << (class57.field1044?2:1));
         this.field1075 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1075.open();
         this.field1075.start();
         this.field1077 = var1;
      } catch (LineUnavailableException var3) {
         if(class94.method1871(var1) != 1) {
            this.vmethod1091(WallObject.method1840(var1));
         } else {
            this.field1075 = null;
            throw var3;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-680825398"
   )
   int vmethod1092() {
      return this.field1077 - (this.field1075.available() >> (class57.field1044?2:1));
   }

   @ObfuscatedName("i")
   void vmethod1093() {
      int var1 = 256;
      if(class57.field1044) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1038[var2];
         if((8388608 + var3 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1076[var2 * 2] = (byte)(var3 >> 8);
         this.field1076[2 * var2 + 1] = (byte)(var3 >> 16);
      }

      this.field1075.write(this.field1076, 0, var1 << 1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-80529995"
   )
   void vmethod1094() {
      if(this.field1075 != null) {
         this.field1075.close();
         this.field1075 = null;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1595086682"
   )
   void vmethod1095() {
      this.field1075.flush();
   }
}
