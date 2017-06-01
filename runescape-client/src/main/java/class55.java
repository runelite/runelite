import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
public class class55 extends class109 {
   @ObfuscatedName("i")
   AudioFormat field681;
   @ObfuscatedName("c")
   SourceDataLine field682;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1966734295
   )
   int field683;
   @ObfuscatedName("v")
   byte[] field684;

   @ObfuscatedName("v")
   protected void vmethod2022() {
      int var1 = 256;
      if(class275.field3732) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1641[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field684[var2 * 2] = (byte)(var3 >> 8);
         this.field684[var2 * 2 + 1] = (byte)(var3 >> 16);
      }

      this.field682.write(this.field684, 0, var1 << 1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "426457422"
   )
   protected void vmethod2020(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field681, var1 << (class275.field3732?2:1));
         this.field682 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field682.open();
         this.field682.start();
         this.field683 = var1;
      } catch (LineUnavailableException var5) {
         int var4 = (var1 & 1431655765) + (var1 >>> 1 & 1431655765);
         var4 = (var4 & 858993459) + (var4 >>> 2 & 858993459);
         var4 = var4 + (var4 >>> 4) & 252645135;
         var4 += var4 >>> 8;
         var4 += var4 >>> 16;
         int var3 = var4 & 255;
         if(var3 != 1) {
            this.vmethod2020(class29.method228(var1));
         } else {
            this.field682 = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2130181861"
   )
   protected void vmethod2019() {
      this.field681 = new AudioFormat((float)class109.field1640, 16, class275.field3732?2:1, true, false);
      this.field684 = new byte[256 << (class275.field3732?2:1)];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "548209644"
   )
   protected void vmethod2023() {
      if(this.field682 != null) {
         this.field682.close();
         this.field682 = null;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-362612567"
   )
   protected int vmethod2021() {
      return this.field683 - (this.field682.available() >> (class275.field3732?2:1));
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "99"
   )
   protected void vmethod2024() {
      this.field682.flush();
   }
}
