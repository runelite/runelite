import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
public class class95 implements class92 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1252179383
   )
   int field1599 = 128;
   @ObfuscatedName("h")
   class199 field1600 = new class199();
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -155079739
   )
   int field1601;
   @ObfuscatedName("i")
   class167 field1602;
   @ObfuscatedName("x")
   double field1603 = 1.0D;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 799273919
   )
   int field1604 = 0;
   @ObfuscatedName("j")
   class83[] field1605;
   @ObfuscatedName("cz")
   static class224 field1606;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1081642299"
   )
   public boolean vmethod2165(int var1) {
      return this.field1605[var1].field1429;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IS)[I",
      garbageValue = "13124"
   )
   public int[] vmethod2166(int var1) {
      class83 var2 = this.field1605[var1];
      if(var2 != null) {
         if(null != var2.field1436) {
            this.field1600.method3780(var2);
            var2.field1427 = true;
            return var2.field1436;
         }

         boolean var3 = var2.method1882(this.field1603, this.field1599, this.field1602);
         if(var3) {
            if(0 == this.field1604) {
               class83 var4 = (class83)this.field1600.method3778();
               var4.method1884();
            } else {
               --this.field1604;
            }

            this.field1600.method3780(var2);
            var2.field1427 = true;
            return var2.field1436;
         }
      }

      return null;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-3844930"
   )
   public int vmethod2167(int var1) {
      return null != this.field1605[var1]?this.field1605[var1].field1428:0;
   }

   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;IDI)V",
      garbageValue = "20"
   )
   public class95(class167 var1, class167 var2, int var3, double var4, int var6) {
      this.field1602 = var2;
      this.field1601 = var3;
      this.field1604 = this.field1601;
      this.field1603 = var4;
      this.field1599 = var6;
      int[] var7 = var1.method3226(0);
      int var8 = var7.length;
      this.field1605 = new class83[var1.method3227(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         class119 var10 = new class119(var1.method3217(0, var7[var9]));
         this.field1605[var7[var9]] = new class83(var10);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-32"
   )
   public boolean vmethod2168(int var1) {
      return this.field1599 == 64;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method2169(double var1) {
      this.field1603 = var1;
      this.method2179();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "663893060"
   )
   public void method2177(int var1) {
      for(int var2 = 0; var2 < this.field1605.length; ++var2) {
         class83 var3 = this.field1605[var2];
         if(var3 != null && 0 != var3.field1433 && var3.field1427) {
            var3.method1885(var1);
            var3.field1427 = false;
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-62"
   )
   public void method2179() {
      for(int var1 = 0; var1 < this.field1605.length; ++var1) {
         if(null != this.field1605[var1]) {
            this.field1605[var1].method1884();
         }
      }

      this.field1600 = new class199();
      this.field1604 = this.field1601;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "802713869"
   )
   static void method2181(int var0) {
      if(var0 != -1) {
         if(class107.method2374(var0)) {
            class173[] var1 = class173.field2735[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               class173 var3 = var1[var2];
               if(null != var3.field2825) {
                  class0 var4 = new class0();
                  var4.field18 = var3;
                  var4.field16 = var3.field2825;
                  class171.method3356(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass167;Ljava/lang/String;Ljava/lang/String;I)[Lclass78;",
      garbageValue = "-127739753"
   )
   public static class78[] method2186(class167 var0, String var1, String var2) {
      int var3 = var0.method3232(var1);
      int var4 = var0.method3233(var3, var2);
      class78[] var5;
      if(!class31.method691(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class31.method681();
      }

      return var5;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)[Lclass153;",
      garbageValue = "-545319791"
   )
   public static class153[] method2187() {
      return new class153[]{class153.field2258, class153.field2263, class153.field2260, class153.field2261};
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)Lclass46;",
      garbageValue = "-94"
   )
   public static class46 method2189(int var0) {
      class46 var1 = (class46)class46.field1031.method3704((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class46.field1043.method3217(4, var0);
         var1 = new class46();
         if(var2 != null) {
            var1.method957(new class119(var2), var0);
         }

         var1.method956();
         class46.field1031.method3706(var1, (long)var0);
         return var1;
      }
   }
}
