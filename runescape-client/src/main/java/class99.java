import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public class class99 extends class109 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 635101643306262619L
   )
   long field1626 = class72.method1385();
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1469150353
   )
   int field1627 = 256;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 132981061
   )
   int field1628 = 1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1903178343
   )
   int field1631;
   @ObfuscatedName("i")
   long[] field1632 = new long[10];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -879985237
   )
   int field1635 = 0;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1760425484"
   )
   void vmethod2017() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1632[var1] = 0L;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-4"
   )
   int vmethod2018(int var1, int var2) {
      int var3 = this.field1627;
      int var4 = this.field1628;
      this.field1627 = 300;
      this.field1628 = 1;
      this.field1626 = class72.method1385();
      if(0L == this.field1632[this.field1631]) {
         this.field1627 = var3;
         this.field1628 = var4;
      } else if(this.field1626 > this.field1632[this.field1631]) {
         this.field1627 = (int)((long)(2560 * var1) / (this.field1626 - this.field1632[this.field1631]));
      }

      if(this.field1627 < 25) {
         this.field1627 = 25;
      }

      if(this.field1627 > 256) {
         this.field1627 = 256;
         this.field1628 = (int)((long)var1 - (this.field1626 - this.field1632[this.field1631]) / 10L);
      }

      if(this.field1628 > var1) {
         this.field1628 = var1;
      }

      this.field1632[this.field1631] = this.field1626;
      this.field1631 = (1 + this.field1631) % 10;
      int var5;
      if(this.field1628 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field1632[var5]) {
               this.field1632[var5] += (long)this.field1628;
            }
         }
      }

      if(this.field1628 < var2) {
         this.field1628 = var2;
      }

      class10.method149((long)this.field1628);

      for(var5 = 0; this.field1635 < 256; this.field1635 += this.field1627) {
         ++var5;
      }

      this.field1635 &= 255;
      return var5;
   }

   class99() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1632[var1] = this.field1626;
      }

   }
}
