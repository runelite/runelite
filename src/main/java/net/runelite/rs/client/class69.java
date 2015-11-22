package net.runelite.rs.client;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bs")
public class class69 extends class56 {
   @ObfuscatedName("j")
   AudioFormat field1271;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -217823061
   )
   int field1272;
   @ObfuscatedName("m")
   SourceDataLine field1273;
   @ObfuscatedName("ai")
   byte[] field1274;

   @ObfuscatedName("j")
   void vmethod1529() {
      this.field1271 = new AudioFormat((float)class56.field1183, 16, class228.field3215?2:1, true, false);
      this.field1274 = new byte[256 << (class228.field3215?2:1)];
   }

   @ObfuscatedName("m")
   void vmethod1530(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.field1271, var1 << (class228.field3215?2:1));
         this.field1273 = (SourceDataLine)AudioSystem.getLine(var2);
         this.field1273.open();
         this.field1273.start();
         this.field1272 = var1;
      } catch (LineUnavailableException var7) {
         int var4 = (var1 & 1431655765) + (var1 >>> 1 & 1431655765);
         var4 = (var4 & 858993459) + (var4 >>> 2 & 858993459);
         var4 = var4 + (var4 >>> 4) & 252645135;
         var4 += var4 >>> 8;
         var4 += var4 >>> 16;
         int var3 = var4 & 255;
         if(1 != var3) {
            int var6 = var1 - 1;
            var6 |= var6 >>> 1;
            var6 |= var6 >>> 2;
            var6 |= var6 >>> 4;
            var6 |= var6 >>> 8;
            var6 |= var6 >>> 16;
            int var5 = 1 + var6;
            this.vmethod1530(var5);
         } else {
            this.field1273 = null;
            throw var7;
         }
      }
   }

   @ObfuscatedName("l")
   void vmethod1532() {
      int var1 = 256;
      if(class228.field3215) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.field1165[var2];
         if(0 != (var3 + 8388608 & -16777216)) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.field1274[2 * var2] = (byte)(var3 >> 8);
         this.field1274[var2 * 2 + 1] = (byte)(var3 >> 16);
      }

      this.field1273.write(this.field1274, 0, var1 << 1);
   }

   @ObfuscatedName("a")
   void vmethod1533() {
      this.field1273.flush();
   }

   @ObfuscatedName("u")
   void vmethod1540() {
      if(this.field1273 != null) {
         this.field1273.close();
         this.field1273 = null;
      }

   }

   @ObfuscatedName("f")
   int vmethod1541() {
      return this.field1272 - (this.field1273.available() >> (class228.field3215?2:1));
   }
}
