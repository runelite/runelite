package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("co")
public class class87 {
   @ObfuscatedName("f")
   static int[] field1520 = new int[500];
   @ObfuscatedName("m")
   static int[] field1521 = new int[500];
   @ObfuscatedName("s")
   boolean field1522 = false;
   @ObfuscatedName("l")
   static int[] field1523 = new int[500];
   @ObfuscatedName("j")
   static int[] field1524 = new int[500];
   @ObfuscatedName("a")
   int field1525 = -1;
   @ObfuscatedName("h")
   int[] field1526;
   @ObfuscatedName("i")
   int[] field1527;
   @ObfuscatedName("t")
   int[] field1528;
   @ObfuscatedName("k")
   int[] field1529;
   @ObfuscatedName("u")
   class101 field1530 = null;

   class87(byte[] var1, class101 var2) {
      this.field1530 = var2;
      class118 var3 = new class118(var1);
      class118 var4 = new class118(var1);
      var3.field1981 = 2;
      int var5 = var3.method2536();
      int var6 = -1;
      int var7 = 0;
      var4.field1981 = var3.field1981 + var5;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.method2536();
         if(var9 > 0) {
            if(this.field1530.field1742[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1530.field1742[var10] == 0) {
                     field1524[var7] = var10;
                     field1521[var7] = 0;
                     field1520[var7] = 0;
                     field1523[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1524[var7] = var8;
            short var11 = 0;
            if(this.field1530.field1742[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1521[var7] = var4.method2666();
            } else {
               field1521[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1520[var7] = var4.method2666();
            } else {
               field1520[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1523[var7] = var4.method2666();
            } else {
               field1523[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1530.field1742[var8] == 5) {
               this.field1522 = true;
            }
         }
      }

      if(var4.field1981 != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1525 = var7;
         this.field1526 = new int[var7];
         this.field1527 = new int[var7];
         this.field1528 = new int[var7];
         this.field1529 = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1526[var8] = field1524[var8];
            this.field1527[var8] = field1521[var8];
            this.field1528[var8] = field1520[var8];
            this.field1529[var8] = field1523[var8];
         }

      }
   }
}
