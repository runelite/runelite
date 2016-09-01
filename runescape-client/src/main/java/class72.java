import java.awt.Component;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public class class72 extends class59 {
   @ObfuscatedName("ag")
   SourceDataLine field1327;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 590844029
   )
   int field1328;
   @ObfuscatedName("an")
   AudioFormat field1329;
   @ObfuscatedName("aq")
   byte[] field1330;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "-75"
   )
   void vmethod1532(Component var1) {
      this.field1329 = new AudioFormat((float)class59.field1228, 16, class59.field1229?2:1, true, false);
      this.field1330 = new byte[256 << (class59.field1229?2:1)];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1062421140"
   )
   void vmethod1533(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1329, var1 << (class59.field1229?2:1));
         this.field1327 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1327.open();
         this.field1327.start();
         this.field1328 = var1;
      } catch (LineUnavailableException var3) {
         if(class13.method158(var1) != 1) {
            this.vmethod1533(class14.method165(var1));
         } else {
            this.field1327 = null;
            throw var3;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2130031761"
   )
   int vmethod1534() {
      return this.field1328 - (this.field1327.available() >> (class59.field1229?2:1));
   }

   @ObfuscatedName("g")
   void vmethod1536() {
      int var1 = 256;
      if(class59.field1229) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1225[var2];
         if((8388608 + var3 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1330[var2 * 2] = (byte)(var3 >> 8);
         this.field1330[var2 * 2 + 1] = (byte)(var3 >> 16);
      }

      this.field1327.write(this.field1330, 0, var1 << 1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-464337916"
   )
   void vmethod1539() {
      this.field1327.flush();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1255925384"
   )
   void vmethod1544() {
      if(this.field1327 != null) {
         this.field1327.close();
         this.field1327 = null;
      }

   }
}
