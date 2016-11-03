import java.awt.Component;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public class class72 extends class59 {
   @ObfuscatedName("al")
   AudioFormat field1342;
   @ObfuscatedName("av")
   SourceDataLine field1343;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1620726587
   )
   int field1344;
   @ObfuscatedName("at")
   byte[] field1345;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "14"
   )
   void vmethod1565(Component var1) {
      this.field1342 = new AudioFormat((float)class59.field1249, 16, class59.field1238?2:1, true, false);
      this.field1345 = new byte[256 << (class59.field1238?2:1)];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1718856519"
   )
   void vmethod1566(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1342, var1 << (class59.field1238?2:1));
         this.field1343 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1343.open();
         this.field1343.start();
         this.field1344 = var1;
      } catch (LineUnavailableException var5) {
         int var4 = (var1 >>> 1 & 1431655765) + (var1 & 1431655765);
         var4 = (var4 & 858993459) + (var4 >>> 2 & 858993459);
         var4 = var4 + (var4 >>> 4) & 252645135;
         var4 += var4 >>> 8;
         var4 += var4 >>> 16;
         int var3 = var4 & 255;
         if(var3 != 1) {
            this.vmethod1566(KitDefinition.method974(var1));
         } else {
            this.field1343 = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "566714973"
   )
   int vmethod1567() {
      return this.field1344 - (this.field1343.available() >> (class59.field1238?2:1));
   }

   @ObfuscatedName("e")
   void vmethod1568() {
      int var1 = 256;
      if(class59.field1238) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1253[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1345[var2 * 2] = (byte)(var3 >> 8);
         this.field1345[var2 * 2 + 1] = (byte)(var3 >> 16);
      }

      this.field1343.write(this.field1345, 0, var1 << 1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "10"
   )
   void vmethod1569() {
      if(null != this.field1343) {
         this.field1343.close();
         this.field1343 = null;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "636351412"
   )
   void vmethod1584() {
      this.field1343.flush();
   }
}
