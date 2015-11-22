package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("de")
public final class class121 extends class118 {
   @ObfuscatedName("k")
   static final int[] field1998 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 333154139
   )
   int field1999;
   @ObfuscatedName("t")
   class122 field2001;

   @ObfuscatedName("ht")
   public void method2782(int[] var1) {
      this.field2001 = new class122(var1);
   }

   @ObfuscatedName("hk")
   public void method2785(int var1) {
      super.field1980[++super.field1981 - 1] = (byte)(var1 + this.field2001.method2807());
   }

   @ObfuscatedName("hu")
   public int method2786(int var1) {
      int var2 = this.field1999 >> 3;
      int var3 = 8 - (this.field1999 & 7);
      int var4 = 0;

      for(this.field1999 += var1; var1 > var3; var3 = 8) {
         var4 += (super.field1980[var2++] & field1998[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.field1980[var2] & field1998[var3];
      } else {
         var4 += super.field1980[var2] >> var3 - var1 & field1998[var1];
      }

      return var4;
   }

   @ObfuscatedName("ho")
   public void method2787() {
      this.field1999 = super.field1981 * 8;
   }

   @ObfuscatedName("he")
   public int method2788(int var1) {
      return var1 * 8 - this.field1999;
   }

   public class121(int var1) {
      super(var1);
   }

   @ObfuscatedName("hj")
   public int method2796() {
      return super.field1980[++super.field1981 - 1] - this.field2001.method2807() & 255;
   }

   @ObfuscatedName("hm")
   public void method2800() {
      super.field1981 = (7 + this.field1999) / 8;
   }
}
