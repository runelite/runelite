import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cb")
public class class94 implements class91 {
   @ObfuscatedName("r")
   class198 field1606 = new class198();
   @ObfuscatedName("a")
   class82[] field1607;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1060745811
   )
   int field1608 = 0;
   @ObfuscatedName("y")
   double field1609 = 1.0D;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -144190743
   )
   int field1610 = 128;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -173088215
   )
   int field1611;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -786600745
   )
   static int field1612;
   @ObfuscatedName("g")
   class166 field1615;

   @ObfuscatedName("z")
   public void method2185(double var1) {
      this.field1609 = var1;
      this.method2189();
   }

   @ObfuscatedName("a")
   public int[] vmethod2186(int var1) {
      class82 var2 = this.field1607[var1];
      if(var2 != null) {
         if(var2.field1437 != null) {
            this.field1606.method3856(var2);
            var2.field1438 = true;
            return var2.field1437;
         }

         boolean var3 = var2.method1905(this.field1609, this.field1610, this.field1615);
         if(var3) {
            if(0 == this.field1608) {
               class82 var4 = (class82)this.field1606.method3859();
               var4.method1902();
            } else {
               --this.field1608;
            }

            this.field1606.method3856(var2);
            var2.field1438 = true;
            return var2.field1437;
         }
      }

      return null;
   }

   @ObfuscatedName("r")
   public int vmethod2187(int var1) {
      return this.field1607[var1] != null?this.field1607[var1].field1429:0;
   }

   @ObfuscatedName("f")
   public boolean vmethod2188(int var1) {
      return this.field1607[var1].field1430;
   }

   @ObfuscatedName("u")
   public void method2189() {
      for(int var1 = 0; var1 < this.field1607.length; ++var1) {
         if(null != this.field1607[var1]) {
            this.field1607[var1].method1902();
         }
      }

      this.field1606 = new class198();
      this.field1608 = this.field1611;
   }

   @ObfuscatedName("n")
   static final int method2191(int var0, int var1) {
      int var2 = class16.method200(var0 + '넵', var1 + 91923, 4) - 128 + (class16.method200(10294 + var0, '鎽' + var1, 2) - 128 >> 1) + (class16.method200(var0, var1, 1) - 128 >> 2);
      var2 = (int)((double)var2 * 0.3D) + 35;
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }

   @ObfuscatedName("s")
   public boolean vmethod2197() {
      return 64 == this.field1610;
   }

   @ObfuscatedName("t")
   public void method2209(int var1) {
      for(int var2 = 0; var2 < this.field1607.length; ++var2) {
         class82 var3 = this.field1607[var2];
         if(var3 != null && 0 != var3.field1431 && var3.field1438) {
            var3.method1904(var1);
            var3.field1438 = false;
         }
      }

   }

   public class94(class166 var1, class166 var2, int var3, double var4, int var6) {
      this.field1615 = var2;
      this.field1611 = var3;
      this.field1608 = this.field1611;
      this.field1609 = var4;
      this.field1610 = var6;
      int[] var7 = var1.method3272(0);
      int var8 = var7.length;
      this.field1607 = new class82[var1.method3273(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         class118 var10 = new class118(var1.method3263(0, var7[var9]));
         this.field1607[var7[var9]] = new class82(var10);
      }

   }

   @ObfuscatedName("a")
   public static void method2211(class166 var0) {
      class50.field1100 = var0;
   }
}
