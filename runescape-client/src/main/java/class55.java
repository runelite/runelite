import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
public class class55 extends class109 {
   @ObfuscatedName("w")
   SourceDataLine field695;
   @ObfuscatedName("t")
   byte[] field696;
   @ObfuscatedName("i")
   AudioFormat field697;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 426452675
   )
   int field698;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "420068294"
   )
   protected void vmethod2029() {
      this.field697 = new AudioFormat((float)FileSystem.field3211, 16, class109.field1664?2:1, true, false);
      this.field696 = new byte[256 << (class109.field1664?2:1)];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1370558022"
   )
   protected void vmethod2057(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field697, var1 << (class109.field1664?2:1));
         this.field695 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field695.open();
         this.field695.start();
         this.field698 = var1;
      } catch (LineUnavailableException var3) {
         if(class6.method29(var1) != 1) {
            this.vmethod2057(class56.method849(var1));
         } else {
            this.field695 = null;
            throw var3;
         }
      }
   }

   @ObfuscatedName("t")
   protected void vmethod2033() {
      int var1 = 256;
      if(class109.field1664) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1649[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field696[var2 * 2] = (byte)(var3 >> 8);
         this.field696[2 * var2 + 1] = (byte)(var3 >> 16);
      }

      this.field695.write(this.field696, 0, var1 << 1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "5"
   )
   protected void vmethod2050() {
      if(this.field695 != null) {
         this.field695.close();
         this.field695 = null;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "65497601"
   )
   protected void vmethod2034() {
      this.field695.flush();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-27"
   )
   protected int vmethod2031() {
      return this.field698 - (this.field695.available() >> (class109.field1664?2:1));
   }
}
