package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("aq")
public class class44 extends class203 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -56223219
   )
   public static int field1008;
   @ObfuscatedName("m")
   public static class166 field1009;
   @ObfuscatedName("w")
   public boolean field1010 = false;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1846105755
   )
   public int field1011 = -1;
   @ObfuscatedName("j")
   public static class166 field1012;
   @ObfuscatedName("a")
   int[] field1013;
   @ObfuscatedName("h")
   short[] field1014;
   @ObfuscatedName("i")
   short[] field1015;
   @ObfuscatedName("t")
   short[] field1016;
   @ObfuscatedName("k")
   short[] field1017;
   @ObfuscatedName("s")
   int[] field1018 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("aj")
   static class167 field1019;
   @ObfuscatedName("l")
   public static class192 field1020 = new class192(64);
   @ObfuscatedName("pq")
   static class133 field1022;

   @ObfuscatedName("u")
   public class99 method960() {
      if(null == this.field1013) {
         return null;
      } else {
         class99[] var1 = new class99[this.field1013.length];

         for(int var2 = 0; var2 < this.field1013.length; ++var2) {
            var1[var2] = class99.method2218(field1009, this.field1013[var2], 0);
         }

         class99 var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new class99(var1, var1.length);
         }

         int var3;
         if(this.field1014 != null) {
            for(var3 = 0; var3 < this.field1014.length; ++var3) {
               var4.method2298(this.field1014[var3], this.field1015[var3]);
            }
         }

         if(null != this.field1016) {
            for(var3 = 0; var3 < this.field1016.length; ++var3) {
               var4.method2233(this.field1016[var3], this.field1017[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("a")
   public boolean method963() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field1018[var2] != -1 && !field1009.method3314(this.field1018[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("h")
   public class99 method964() {
      class99[] var1 = new class99[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(-1 != this.field1018[var3]) {
            var1[var2++] = class99.method2218(field1009, this.field1018[var3], 0);
         }
      }

      class99 var5 = new class99(var1, var2);
      int var4;
      if(this.field1014 != null) {
         for(var4 = 0; var4 < this.field1014.length; ++var4) {
            var5.method2298(this.field1014[var4], this.field1015[var4]);
         }
      }

      if(null != this.field1016) {
         for(var4 = 0; var4 < this.field1016.length; ++var4) {
            var5.method2233(this.field1016[var4], this.field1017[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("m")
   void method971(class118 var1) {
      while(true) {
         int var2 = var1.method2536();
         if(0 == var2) {
            return;
         }

         this.method975(var1, var2);
      }
   }

   @ObfuscatedName("l")
   public boolean method973() {
      if(null == this.field1013) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field1013.length; ++var2) {
            if(!field1009.method3314(this.field1013[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("f")
   void method975(class118 var1, int var2) {
      if(1 == var2) {
         this.field1011 = var1.method2536();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.method2536();
            this.field1013 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1013[var4] = var1.method2538();
            }
         } else if(3 == var2) {
            this.field1010 = true;
         } else if(var2 == 40) {
            var3 = var1.method2536();
            this.field1014 = new short[var3];
            this.field1015 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1014[var4] = (short)var1.method2538();
               this.field1015[var4] = (short)var1.method2538();
            }
         } else if(41 == var2) {
            var3 = var1.method2536();
            this.field1016 = new short[var3];
            this.field1017 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1016[var4] = (short)var1.method2538();
               this.field1017[var4] = (short)var1.method2538();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field1018[var2 - 60] = var1.method2538();
         }
      }

   }
}
