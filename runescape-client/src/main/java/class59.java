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
   @ObfuscatedName("ad")
   SourceDataLine field1075;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1210106077
   )
   int field1076;
   @ObfuscatedName("ao")
   byte[] field1077;
   @ObfuscatedName("ai")
   AudioFormat field1078;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-276519453"
   )
   void vmethod1061(Component var1) {
      this.field1078 = new AudioFormat((float)class57.field1057, 16, class57.field1052?2:1, true, false);
      this.field1077 = new byte[256 << (class57.field1052?2:1)];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1015404573"
   )
   void vmethod1062(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1078, var1 << (class57.field1052?2:1));
         this.field1075 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1075.open();
         this.field1075.start();
         this.field1076 = var1;
      } catch (LineUnavailableException var5) {
         int var4 = (var1 & 1431655765) + (var1 >>> 1 & 1431655765);
         var4 = (var4 & 858993459) + (var4 >>> 2 & 858993459);
         var4 = var4 + (var4 >>> 4) & 252645135;
         var4 += var4 >>> 8;
         var4 += var4 >>> 16;
         int var3 = var4 & 255;
         if(var3 != 1) {
            this.vmethod1062(class112.method2048(var1));
         } else {
            this.field1075 = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("o")
   void vmethod1063() {
      int var1 = 256;
      if(class57.field1052) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1051[var2];
         if((8388608 + var3 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1077[var2 * 2] = (byte)(var3 >> 8);
         this.field1077[1 + var2 * 2] = (byte)(var3 >> 16);
      }

      this.field1075.write(this.field1077, 0, var1 << 1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1270143511"
   )
   void vmethod1065() {
      this.field1075.flush();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "99639815"
   )
   void vmethod1076() {
      if(this.field1075 != null) {
         this.field1075.close();
         this.field1075 = null;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1667009384"
   )
   int vmethod1077() {
      return this.field1076 - (this.field1075.available() >> (class57.field1052?2:1));
   }
}
