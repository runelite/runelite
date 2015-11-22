package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ce")
public class class94 implements class91 {
   @ObfuscatedName("h")
   class166 field1602;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1662586649
   )
   int field1603 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1077194989
   )
   int field1604;
   @ObfuscatedName("u")
   double field1606 = 1.0D;
   @ObfuscatedName("j")
   class82[] field1607;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 905499573
   )
   int field1608 = 128;
   @ObfuscatedName("m")
   class198 field1613 = new class198();

   @ObfuscatedName("g")
   public void method2185(double var1) {
      this.field1606 = var1;
      this.method2190();
   }

   @ObfuscatedName("m")
   public int vmethod2187(int var1) {
      return this.field1607[var1] != null?this.field1607[var1].field1420:0;
   }

   @ObfuscatedName("f")
   public boolean vmethod2188(int var1) {
      return this.field1607[var1].field1421;
   }

   @ObfuscatedName("l")
   public boolean vmethod2189() {
      return this.field1608 == 64;
   }

   @ObfuscatedName("n")
   public void method2190() {
      for(int var1 = 0; var1 < this.field1607.length; ++var1) {
         if(this.field1607[var1] != null) {
            this.field1607[var1].method1911();
         }
      }

      this.field1613 = new class198();
      this.field1603 = this.field1604;
   }

   @ObfuscatedName("y")
   public void method2191(int var1) {
      for(int var2 = 0; var2 < this.field1607.length; ++var2) {
         class82 var3 = this.field1607[var2];
         if(var3 != null && 0 != var3.field1426 && var3.field1429) {
            var3.method1909(var1);
            var3.field1429 = false;
         }
      }

   }

   @ObfuscatedName("j")
   public int[] vmethod2195(int var1) {
      class82 var2 = this.field1607[var1];
      if(var2 != null) {
         if(var2.field1424 != null) {
            this.field1613.method3867(var2);
            var2.field1429 = true;
            return var2.field1424;
         }

         boolean var3 = var2.method1907(this.field1606, this.field1608, this.field1602);
         if(var3) {
            if(this.field1603 == 0) {
               class82 var4 = (class82)this.field1613.method3866();
               var4.method1911();
            } else {
               --this.field1603;
            }

            this.field1613.method3867(var2);
            var2.field1429 = true;
            return var2.field1424;
         }
      }

      return null;
   }

   public class94(class166 var1, class166 var2, int var3, double var4, int var6) {
      this.field1602 = var2;
      this.field1604 = var3;
      this.field1603 = this.field1604;
      this.field1606 = var4;
      this.field1608 = var6;
      int[] var7 = var1.method3321(0);
      int var8 = var7.length;
      this.field1607 = new class82[var1.method3322(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         class118 var10 = new class118(var1.method3352(0, var7[var9]));
         this.field1607[var7[var9]] = new class82(var10);
      }

   }

   @ObfuscatedName("e")
   static void method2205(byte[] var0) {
      class118 var1 = new class118(var0);
      var1.field1981 = var0.length - 2;
      class76.field1379 = var1.method2538();
      class76.field1366 = new int[class76.field1379];
      class76.field1370 = new int[class76.field1379];
      class76.field1371 = new int[class76.field1379];
      class76.field1373 = new int[class76.field1379];
      class17.field236 = new byte[class76.field1379][];
      var1.field1981 = var0.length - 7 - class76.field1379 * 8;
      class76.field1367 = var1.method2538();
      class76.field1368 = var1.method2538();
      int var2 = (var1.method2536() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class76.field1379; ++var3) {
         class76.field1366[var3] = var1.method2538();
      }

      for(var3 = 0; var3 < class76.field1379; ++var3) {
         class76.field1370[var3] = var1.method2538();
      }

      for(var3 = 0; var3 < class76.field1379; ++var3) {
         class76.field1371[var3] = var1.method2538();
      }

      for(var3 = 0; var3 < class76.field1379; ++var3) {
         class76.field1373[var3] = var1.method2538();
      }

      var1.field1981 = var0.length - 7 - class76.field1379 * 8 - 3 * (var2 - 1);
      class76.field1369 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class76.field1369[var3] = var1.method2540();
         if(class76.field1369[var3] == 0) {
            class76.field1369[var3] = 1;
         }
      }

      var1.field1981 = 0;

      for(var3 = 0; var3 < class76.field1379; ++var3) {
         int var4 = class76.field1371[var3];
         int var5 = class76.field1373[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class17.field236[var3] = var7;
         int var8 = var1.method2536();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.method2537();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var4 * var10 + var9] = var1.method2537();
               }
            }
         }
      }

   }
}
