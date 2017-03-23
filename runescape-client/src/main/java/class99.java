import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
public class class99 extends class109 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1242809013
   )
   int field1664;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1322001661
   )
   int field1665 = 1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -2053663086758900979L
   )
   long field1666 = class45.method867();
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -842700415
   )
   int field1667 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -946972249
   )
   int field1670 = 256;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -1328794889
   )
   static int field1671;
   @ObfuscatedName("f")
   long[] field1672 = new long[10];

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "299182090"
   )
   void vmethod2090() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1672[var1] = 0L;
      }

   }

   class99() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1672[var1] = this.field1666;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1101349845"
   )
   int vmethod2091(int var1, int var2) {
      int var3 = this.field1670;
      int var4 = this.field1665;
      this.field1670 = 300;
      this.field1665 = 1;
      this.field1666 = class45.method867();
      if(0L == this.field1672[this.field1664]) {
         this.field1670 = var3;
         this.field1665 = var4;
      } else if(this.field1666 > this.field1672[this.field1664]) {
         this.field1670 = (int)((long)(2560 * var1) / (this.field1666 - this.field1672[this.field1664]));
      }

      if(this.field1670 < 25) {
         this.field1670 = 25;
      }

      if(this.field1670 > 256) {
         this.field1670 = 256;
         this.field1665 = (int)((long)var1 - (this.field1666 - this.field1672[this.field1664]) / 10L);
      }

      if(this.field1665 > var1) {
         this.field1665 = var1;
      }

      this.field1672[this.field1664] = this.field1666;
      this.field1664 = (1 + this.field1664) % 10;
      int var5;
      if(this.field1665 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field1672[var5]) {
               this.field1672[var5] += (long)this.field1665;
            }
         }
      }

      if(this.field1665 < var2) {
         this.field1665 = var2;
      }

      class115.method2300((long)this.field1665);

      for(var5 = 0; this.field1667 < 256; this.field1667 += this.field1670) {
         ++var5;
      }

      this.field1667 &= 255;
      return var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)[LSpritePixels;",
      garbageValue = "1040416138"
   )
   public static SpritePixels[] method1981(class182 var0, String var1, String var2) {
      int var3 = var0.method3351(var1);
      int var4 = var0.method3352(var3, var2);
      return class103.method2027(var0, var3, var4);
   }
}
