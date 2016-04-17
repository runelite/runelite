import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
public class class95 implements class92 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1661062271
   )
   int field1619 = 128;
   @ObfuscatedName("a")
   class83[] field1620;
   @ObfuscatedName("w")
   class199 field1621 = new class199();
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 680734591
   )
   int field1622 = 0;
   @ObfuscatedName("y")
   double field1623 = 1.0D;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1054774481
   )
   int field1624;
   @ObfuscatedName("r")
   class167 field1625;

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(IIIILclass78;Lclass175;B)V",
      garbageValue = "-85"
   )
   static final void method2255(int var0, int var1, int var2, int var3, class78 var4, class175 var5) {
      if(null != var4) {
         int var6 = client.field443 + client.field379 & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = class91.field1593[var6];
            int var9 = class91.field1594[var6];
            var8 = 256 * var8 / (256 + client.field368);
            var9 = 256 * var9 / (256 + client.field368);
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var3 * var9 - var2 * var8 >> 16;
            if(var7 > 2500) {
               var4.method1808(var5.field2901 / 2 + var10 - var4.field1405 / 2, var5.field2900 / 2 - var11 - var4.field1407 / 2, var0, var1, var5.field2901, var5.field2900, var5.field2902, var5.field2899);
            } else {
               var4.method1798(var10 + var5.field2901 / 2 + var0 - var4.field1405 / 2, var1 + var5.field2900 / 2 - var11 - var4.field1407 / 2);
            }

         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2060301059"
   )
   public int vmethod2257(int var1) {
      return this.field1620[var1] != null?this.field1620[var1].field1444:0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "1"
   )
   public boolean vmethod2258(int var1) {
      return this.field1620[var1].field1450;
   }

   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;IDI)V",
      garbageValue = "20"
   )
   public class95(class167 var1, class167 var2, int var3, double var4, int var6) {
      this.field1625 = var2;
      this.field1624 = var3;
      this.field1622 = this.field1624;
      this.field1623 = var4;
      this.field1619 = var6;
      int[] var7 = var1.method3368(0);
      int var8 = var7.length;
      this.field1620 = new class83[var1.method3372(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         class119 var10 = new class119(var1.method3403(0, var7[var9]));
         this.field1620[var7[var9]] = new class83(var10);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "60974495"
   )
   public void method2259() {
      for(int var1 = 0; var1 < this.field1620.length; ++var1) {
         if(this.field1620[var1] != null) {
            this.field1620[var1].method1984();
         }
      }

      this.field1621 = new class199();
      this.field1622 = this.field1624;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "344786508"
   )
   public void method2260(int var1) {
      for(int var2 = 0; var2 < this.field1620.length; ++var2) {
         class83 var3 = this.field1620[var2];
         if(var3 != null && 0 != var3.field1453 && var3.field1452) {
            var3.method1986(var1);
            var3.field1452 = false;
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.8"
   )
   public void method2261(double var1) {
      this.field1623 = var1;
      this.method2259();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)[I",
      garbageValue = "-6"
   )
   public int[] vmethod2262(int var1) {
      class83 var2 = this.field1620[var1];
      if(null != var2) {
         if(null != var2.field1441) {
            this.field1621.method3901(var2);
            var2.field1452 = true;
            return var2.field1441;
         }

         boolean var3 = var2.method1985(this.field1623, this.field1619, this.field1625);
         if(var3) {
            if(0 == this.field1622) {
               class83 var4 = (class83)this.field1621.method3908();
               var4.method1984();
            } else {
               --this.field1622;
            }

            this.field1621.method3901(var2);
            var2.field1452 = true;
            return var2.field1441;
         }
      }

      return null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "888922795"
   )
   public boolean vmethod2270(int var1) {
      return this.field1619 == 64;
   }
}
