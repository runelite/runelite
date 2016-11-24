import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
public class class99 extends class109 {
   @ObfuscatedName("n")
   long[] field1634 = new long[10];
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -635159213
   )
   int field1635 = 256;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2072882069
   )
   int field1636 = 1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -2563127881495663421L
   )
   long field1637 = class202.method3838();
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1427905325
   )
   int field1639;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1280135949
   )
   int field1642 = 0;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1778689612"
   )
   int vmethod2091(int var1, int var2) {
      int var3 = this.field1635;
      int var4 = this.field1636;
      this.field1635 = 300;
      this.field1636 = 1;
      this.field1637 = class202.method3838();
      if(this.field1634[this.field1639] == 0L) {
         this.field1635 = var3;
         this.field1636 = var4;
      } else if(this.field1637 > this.field1634[this.field1639]) {
         this.field1635 = (int)((long)(var1 * 2560) / (this.field1637 - this.field1634[this.field1639]));
      }

      if(this.field1635 < 25) {
         this.field1635 = 25;
      }

      if(this.field1635 > 256) {
         this.field1635 = 256;
         this.field1636 = (int)((long)var1 - (this.field1637 - this.field1634[this.field1639]) / 10L);
      }

      if(this.field1636 > var1) {
         this.field1636 = var1;
      }

      this.field1634[this.field1639] = this.field1637;
      this.field1639 = (this.field1639 + 1) % 10;
      int var5;
      if(this.field1636 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field1634[var5]) {
               this.field1634[var5] += (long)this.field1636;
            }
         }
      }

      if(this.field1636 < var2) {
         this.field1636 = var2;
      }

      class0.method12((long)this.field1636);

      for(var5 = 0; this.field1642 < 256; this.field1642 += this.field1635) {
         ++var5;
      }

      this.field1642 &= 255;
      return var5;
   }

   class99() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1634[var1] = this.field1637;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1528878866"
   )
   void vmethod2090() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1634[var1] = 0L;
      }

   }
}
