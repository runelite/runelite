import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public class class55 extends class109 {
   @ObfuscatedName("h")
   SourceDataLine field669;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -895236213
   )
   int field670;
   @ObfuscatedName("i")
   AudioFormat field671;
   @ObfuscatedName("q")
   byte[] field672;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1616517196"
   )
   protected void vmethod2044(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field671, var1 << (class168.field2315?2:1));
         this.field669 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field669.open();
         this.field669.start();
         this.field670 = var1;
      } catch (LineUnavailableException var3) {
         if(class17.method124(var1) != 1) {
            this.vmethod2044(ChatLineBuffer.method1895(var1));
         } else {
            this.field669 = null;
            throw var3;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-33"
   )
   protected int vmethod2055() {
      return this.field670 - (this.field669.available() >> (class168.field2315?2:1));
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1272424661"
   )
   protected void vmethod2050() {
      if(this.field669 != null) {
         this.field669.close();
         this.field669 = null;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "16261270"
   )
   protected void vmethod2057() {
      this.field669.flush();
   }

   @ObfuscatedName("q")
   protected void vmethod2053() {
      int var1 = 256;
      if(class168.field2315) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1625[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field672[var2 * 2] = (byte)(var3 >> 8);
         this.field672[var2 * 2 + 1] = (byte)(var3 >> 16);
      }

      this.field669.write(this.field672, 0, var1 << 1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "196875046"
   )
   protected void vmethod2073() {
      this.field671 = new AudioFormat((float)class109.field1628, 16, class168.field2315?2:1, true, false);
      this.field672 = new byte[256 << (class168.field2315?2:1)];
   }
}
