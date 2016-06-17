import java.awt.Component;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bq")
public class class69 extends class56 {
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -968159409
   )
   int field1251;
   @ObfuscatedName("b")
   AudioFormat field1252;
   @ObfuscatedName("g")
   SourceDataLine field1253;
   @ObfuscatedName("aj")
   byte[] field1254;

   @ObfuscatedName("g")
   void vmethod1517(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1252, var1 << (class21.field581?2:1));
         this.field1253 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1253.open();
         this.field1253.start();
         this.field1251 = var1;
      } catch (LineUnavailableException var3) {
         if(class48.method991(var1) != 1) {
            this.vmethod1517(class46.method967(var1));
         } else {
            this.field1253 = null;
            throw var3;
         }
      }
   }

   @ObfuscatedName("j")
   int vmethod1518() {
      return this.field1251 - (this.field1253.available() >> (class21.field581?2:1));
   }

   @ObfuscatedName("d")
   void vmethod1519() {
      int var1 = 256;
      if(class21.field581) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1148[var2];
         if((8388608 + var3 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1254[var2 * 2] = (byte)(var3 >> 8);
         this.field1254[1 + var2 * 2] = (byte)(var3 >> 16);
      }

      this.field1253.write(this.field1254, 0, var1 << 1);
   }

   @ObfuscatedName("x")
   void vmethod1520() {
      if(this.field1253 != null) {
         this.field1253.close();
         this.field1253 = null;
      }

   }

   @ObfuscatedName("y")
   void vmethod1521() {
      this.field1253.flush();
   }

   @ObfuscatedName("b")
   void vmethod1535(Component var1) {
      this.field1252 = new AudioFormat((float)class56.field1153, 16, class21.field581?2:1, true, false);
      this.field1254 = new byte[256 << (class21.field581?2:1)];
   }
}
