import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
public final class class122 extends class119 {
   @ObfuscatedName("kb")
   static class131 field2018;
   @ObfuscatedName("g")
   class123 field2019;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -786582131
   )
   int field2020;
   @ObfuscatedName("s")
   static final int[] field2022 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-1697450718"
   )
   public void method2772(int[] var1) {
      this.field2019 = new class123(var1);
   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1264080010"
   )
   public void method2773(int var1) {
      super.field2000[++super.field1998 - 1] = (byte)(var1 + this.field2019.method2796());
   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "84"
   )
   public void method2775() {
      this.field2020 = super.field1998 * 8;
   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1791375478"
   )
   public int method2776(int var1) {
      int var2 = this.field2020 >> 3;
      int var3 = 8 - (this.field2020 & 7);
      int var4 = 0;

      for(this.field2020 += var1; var1 > var3; var3 = 8) {
         var4 += (super.field2000[var2++] & field2022[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var1 == var3) {
         var4 += super.field2000[var2] & field2022[var3];
      } else {
         var4 += super.field2000[var2] >> var3 - var1 & field2022[var1];
      }

      return var4;
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1069487815"
   )
   public int method2779(int var1) {
      return 8 * var1 - this.field2020;
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1558424337"
   )
   public int method2787() {
      return super.field2000[++super.field1998 - 1] - this.field2019.method2796() & 255;
   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1374759722"
   )
   public void method2791() {
      super.field1998 = (this.field2020 + 7) / 8;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public class122(int var1) {
      super(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "-18"
   )
   @Export("addChatMessage")
   static void method2795(int var0, String var1, String var2, String var3) {
      class27 var4 = (class27)class11.field178.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new class27();
         class11.field178.put(Integer.valueOf(var0), var4);
      }

      class35 var5 = var4.method690(var0, var1, var2, var3);
      class11.field182.method3842(var5, (long)var5.field793);
      class11.field179.method3887(var5);
      client.field481 = client.field563;
   }
}
