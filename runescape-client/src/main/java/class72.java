import java.awt.Component;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
public class class72 extends class59 {
   @ObfuscatedName("ay")
   AudioFormat field1330;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1705323765
   )
   int field1331;
   @ObfuscatedName("ah")
   SourceDataLine field1332;
   @ObfuscatedName("ar")
   byte[] field1333;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "72413541"
   )
   void vmethod1561(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1330, var1 << (class59.field1219?2:1));
         this.field1332 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1332.open();
         this.field1332.start();
         this.field1331 = var1;
      } catch (LineUnavailableException var5) {
         int var4 = (var1 & 1431655765) + (var1 >>> 1 & 1431655765);
         var4 = (var4 >>> 2 & 858993459) + (var4 & 858993459);
         var4 = var4 + (var4 >>> 4) & 252645135;
         var4 += var4 >>> 8;
         var4 += var4 >>> 16;
         int var3 = var4 & 255;
         if(var3 != 1) {
            this.vmethod1561(class56.method1167(var1));
         } else {
            this.field1332 = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("x")
   void vmethod1566() {
      int var1 = 256;
      if(class59.field1219) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1223[var2];
         if((8388608 + var3 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1333[2 * var2] = (byte)(var3 >> 8);
         this.field1333[1 + var2 * 2] = (byte)(var3 >> 16);
      }

      this.field1332.write(this.field1333, 0, var1 << 1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-18"
   )
   void vmethod1567() {
      this.field1332.flush();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "106"
   )
   void vmethod1573(Component var1) {
      this.field1330 = new AudioFormat((float)class59.field1235, 16, class59.field1219?2:1, true, false);
      this.field1333 = new byte[256 << (class59.field1219?2:1)];
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "97"
   )
   int vmethod1574() {
      return this.field1331 - (this.field1332.available() >> (class59.field1219?2:1));
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   void vmethod1577() {
      if(this.field1332 != null) {
         this.field1332.close();
         this.field1332 = null;
      }

   }
}
