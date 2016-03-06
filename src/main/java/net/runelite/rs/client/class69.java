package net.runelite.rs.client;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ba")
public class class69 extends class56 {
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1576915139
   )
   int field1291;
   @ObfuscatedName("l")
   SourceDataLine field1292;
   @ObfuscatedName("j")
   AudioFormat field1293;
   @ObfuscatedName("az")
   byte[] field1294;

   @ObfuscatedName("j")
   void vmethod1501() {
      this.field1293 = new AudioFormat((float)class102.field1780, 16, class56.field1191?2:1, true, false);
      this.field1294 = new byte[256 << (class56.field1191?2:1)];
   }

   @ObfuscatedName("l")
   void vmethod1502(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1293, var1 << (class56.field1191?2:1));
         this.field1292 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1292.open();
         this.field1292.start();
         this.field1291 = var1;
      } catch (LineUnavailableException var3) {
         if(class19.method233(var1) != 1) {
            this.vmethod1502(class72.method1567(var1));
         } else {
            this.field1292 = null;
            throw var3;
         }
      }
   }

   @ObfuscatedName("i")
   void vmethod1503() {
      int var1 = 256;
      if(class56.field1191) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1200[var2];
         if(0 != (var3 + 8388608 & -16777216)) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1294[var2 * 2] = (byte)(var3 >> 8);
         this.field1294[1 + var2 * 2] = (byte)(var3 >> 16);
      }

      this.field1292.write(this.field1294, 0, var1 << 1);
   }

   @ObfuscatedName("f")
   void vmethod1511() {
      if(this.field1292 != null) {
         this.field1292.close();
         this.field1292 = null;
      }

   }

   @ObfuscatedName("m")
   void vmethod1520() {
      this.field1292.flush();
   }

   @ObfuscatedName("a")
   int vmethod1521() {
      return this.field1291 - (this.field1292.available() >> (class56.field1191?2:1));
   }
}
