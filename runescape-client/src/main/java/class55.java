import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
public class class55 extends class109 {
   @ObfuscatedName("p")
   SourceDataLine field661;
   @ObfuscatedName("j")
   byte[] field662;
   @ObfuscatedName("n")
   AudioFormat field663;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -976474757
   )
   int field664;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "16"
   )
   protected int vmethod1995() {
      return this.field664 - (this.field661.available() >> (class109.field1630?2:1));
   }

   @ObfuscatedName("j")
   protected void vmethod2022() {
      int var1 = 256;
      if(class109.field1630) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1636[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field662[var2 * 2] = (byte)(var3 >> 8);
         this.field662[var2 * 2 + 1] = (byte)(var3 >> 16);
      }

      this.field661.write(this.field662, 0, var1 << 1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-647845185"
   )
   protected void vmethod2002(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field663, var1 << (class109.field1630?2:1));
         this.field661 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field661.open();
         this.field661.start();
         this.field664 = var1;
      } catch (LineUnavailableException var5) {
         int var4 = (var1 & 1431655765) + (var1 >>> 1 & 1431655765);
         var4 = (var4 & 858993459) + (var4 >>> 2 & 858993459);
         var4 = var4 + (var4 >>> 4) & 252645135;
         var4 += var4 >>> 8;
         var4 += var4 >>> 16;
         int var3 = var4 & 255;
         if(var3 != 1) {
            this.vmethod2002(class13.method88(var1));
         } else {
            this.field661 = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-93901902"
   )
   protected void vmethod2017() {
      if(this.field661 != null) {
         this.field661.close();
         this.field661 = null;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1357874836"
   )
   protected void vmethod2005() {
      this.field661.flush();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "902341640"
   )
   protected void vmethod2001() {
      this.field663 = new AudioFormat((float)class109.field1633, 16, class109.field1630?2:1, true, false);
      this.field662 = new byte[256 << (class109.field1630?2:1)];
   }
}
