import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dg")
public final class class121 extends class118 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1244073237
   )
   int field1997;
   @ObfuscatedName("n")
   static final int[] field1998 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("ex")
   static class78[] field2000;
   @ObfuscatedName("j")
   class122 field2002;

   @ObfuscatedName("hp")
   public int method2750(int var1) {
      int var2 = this.field1997 >> 3;
      int var3 = 8 - (this.field1997 & 7);
      int var4 = 0;

      for(this.field1997 += var1; var1 > var3; var3 = 8) {
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

   @ObfuscatedName("he")
   public void method2751(int[] var1) {
      this.field2002 = new class122(var1);
   }

   @ObfuscatedName("hr")
   public int method2752() {
      return super.field1980[++super.field1979 - 1] - this.field2002.method2781() & 255;
   }

   @ObfuscatedName("hy")
   public void method2753(int var1) {
      super.field1980[++super.field1979 - 1] = (byte)(var1 + this.field2002.method2781());
   }

   @ObfuscatedName("ha")
   public void method2754() {
      this.field1997 = super.field1979 * 8;
   }

   public class121(int var1) {
      super(var1);
   }

   @ObfuscatedName("hq")
   public void method2755() {
      super.field1979 = (7 + this.field1997) / 8;
   }

   @ObfuscatedName("hl")
   public int method2756(int var1) {
      return 8 * var1 - this.field1997;
   }

   @ObfuscatedName("a")
   static int method2772(int var0, int var1) {
      class15 var2 = (class15)class15.field225.method3824((long)var0);
      return null == var2?-1:(var1 >= 0 && var1 < var2.field215.length?var2.field215[var1]:-1);
   }
}
