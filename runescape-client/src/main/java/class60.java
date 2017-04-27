import java.awt.Component;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
public class class60 extends class57 {
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -2124739565
   )
   int field1064;
   @ObfuscatedName("ao")
   SourceDataLine field1065;
   @ObfuscatedName("aa")
   byte[] field1066;
   @ObfuscatedName("az")
   AudioFormat field1067;

   @ObfuscatedName("i")
   void vmethod1142() {
      int var1 = 256;
      if(class57.field1047) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1031[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1066[var2 * 2] = (byte)(var3 >> 8);
         this.field1066[var2 * 2 + 1] = (byte)(var3 >> 16);
      }

      this.field1065.write(this.field1066, 0, var1 << 1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "-35"
   )
   void vmethod1143(Component var1) {
      this.field1067 = new AudioFormat((float)class57.field1032, 16, class57.field1047?2:1, true, false);
      this.field1066 = new byte[256 << (class57.field1047?2:1)];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-962953816"
   )
   void vmethod1144(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1067, var1 << (class57.field1047?2:1));
         this.field1065 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1065.open();
         this.field1065.start();
         this.field1064 = var1;
      } catch (LineUnavailableException var5) {
         int var4 = (var1 >>> 1 & 1431655765) + (var1 & 1431655765);
         var4 = (var4 & 858993459) + (var4 >>> 2 & 858993459);
         var4 = var4 + (var4 >>> 4) & 252645135;
         var4 += var4 >>> 8;
         var4 += var4 >>> 16;
         int var3 = var4 & 255;
         if(var3 != 1) {
            this.vmethod1144(CombatInfo1.method596(var1));
         } else {
            this.field1065 = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-87"
   )
   int vmethod1145() {
      return this.field1064 - (this.field1065.available() >> (class57.field1047?2:1));
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "52"
   )
   void vmethod1147() {
      if(this.field1065 != null) {
         this.field1065.close();
         this.field1065 = null;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1843028020"
   )
   void vmethod1154() {
      this.field1065.flush();
   }
}
