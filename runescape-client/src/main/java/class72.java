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
public class class72 extends class59 {
   @ObfuscatedName("ad")
   SourceDataLine field1337;
   @ObfuscatedName("ak")
   byte[] field1338;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 785950521
   )
   int field1339;
   @ObfuscatedName("as")
   AudioFormat field1340;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "93215286"
   )
   void vmethod1549(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1340, var1 << (class222.field3221?2:1));
         this.field1337 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1337.open();
         this.field1337.start();
         this.field1339 = var1;
      } catch (LineUnavailableException var5) {
         if(class118.method2483(var1) != 1) {
            int var4 = var1 - 1;
            var4 |= var4 >>> 1;
            var4 |= var4 >>> 2;
            var4 |= var4 >>> 4;
            var4 |= var4 >>> 8;
            var4 |= var4 >>> 16;
            int var3 = 1 + var4;
            this.vmethod1549(var3);
         } else {
            this.field1337 = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1952324551"
   )
   void vmethod1550() {
      if(this.field1337 != null) {
         this.field1337.close();
         this.field1337 = null;
      }

   }

   @ObfuscatedName("v")
   void vmethod1551() {
      int var1 = 256;
      if(class222.field3221) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1234[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1338[var2 * 2] = (byte)(var3 >> 8);
         this.field1338[2 * var2 + 1] = (byte)(var3 >> 16);
      }

      this.field1337.write(this.field1338, 0, var1 << 1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1681968704"
   )
   int vmethod1552() {
      return this.field1339 - (this.field1337.available() >> (class222.field3221?2:1));
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1836293824"
   )
   void vmethod1553() {
      this.field1337.flush();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "-67"
   )
   void vmethod1563(Component var1) {
      this.field1340 = new AudioFormat((float)class59.field1239, 16, class222.field3221?2:1, true, false);
      this.field1338 = new byte[256 << (class222.field3221?2:1)];
   }
}
