import java.awt.Component;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
public class class59 extends class57 {
   @ObfuscatedName("an")
   AudioFormat field1096;
   @ObfuscatedName("aq")
   SourceDataLine field1097;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1332589653
   )
   int field1098;
   @ObfuscatedName("ag")
   byte[] field1099;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-267320797"
   )
   void vmethod1147() {
      if(this.field1097 != null) {
         this.field1097.close();
         this.field1097 = null;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "261119249"
   )
   void vmethod1149(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1096, var1 << (class57.field1078?2:1));
         this.field1097 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1097.open();
         this.field1097.start();
         this.field1098 = var1;
      } catch (LineUnavailableException var5) {
         int var4 = (var1 >>> 1 & 1431655765) + (var1 & 1431655765);
         var4 = (var4 >>> 2 & 858993459) + (var4 & 858993459);
         var4 = (var4 >>> 4) + var4 & 252645135;
         var4 += var4 >>> 8;
         var4 += var4 >>> 16;
         int var3 = var4 & 255;
         if(var3 != 1) {
            this.vmethod1149(World.method601(var1));
         } else {
            this.field1097 = null;
            throw var5;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-2092069393"
   )
   void vmethod1150(Component var1) {
      this.field1096 = new AudioFormat((float)class57.field1077, 16, class57.field1078?2:1, true, false);
      this.field1099 = new byte[256 << (class57.field1078?2:1)];
   }

   @ObfuscatedName("p")
   void vmethod1151() {
      int var1 = 256;
      if(class57.field1078) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1064[var2];
         if((8388608 + var3 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1099[2 * var2] = (byte)(var3 >> 8);
         this.field1099[1 + var2 * 2] = (byte)(var3 >> 16);
      }

      this.field1097.write(this.field1099, 0, var1 << 1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-606735368"
   )
   void vmethod1153() {
      this.field1097.flush();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "202879557"
   )
   int vmethod1155() {
      return this.field1098 - (this.field1097.available() >> (class57.field1078?2:1));
   }
}
