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
   @ObfuscatedName("p")
   AudioFormat field677;
   @ObfuscatedName("m")
   SourceDataLine field678;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -222702375
   )
   int field679;
   @ObfuscatedName("t")
   byte[] field680;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1015812313"
   )
   protected void vmethod1919() {
      this.field677 = new AudioFormat((float)class109.field1635, 16, class222.field2849?2:1, true, false);
      this.field680 = new byte[256 << (class222.field2849?2:1)];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-685274721"
   )
   protected int vmethod1958() {
      return this.field679 - (this.field678.available() >> (class222.field2849?2:1));
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-859545744"
   )
   protected void vmethod1941(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field677, var1 << (class222.field2849?2:1));
         this.field678 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field678.open();
         this.field678.start();
         this.field679 = var1;
      } catch (LineUnavailableException var3) {
         if(FrameMap.method2576(var1) == 1) {
            this.field678 = null;
            throw var3;
         }

         this.vmethod1941(class231.method3979(var1));
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "467486870"
   )
   protected void vmethod1923() {
      if(this.field678 != null) {
         this.field678.close();
         this.field678 = null;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "25"
   )
   protected void vmethod1924() {
      this.field678.flush();
   }

   @ObfuscatedName("t")
   protected void vmethod1920() {
      int var1 = 256;
      if(class222.field2849) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1639[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field680[var2 * 2] = (byte)(var3 >> 8);
         this.field680[var2 * 2 + 1] = (byte)(var3 >> 16);
      }

      this.field678.write(this.field680, 0, var1 << 1);
   }
}
