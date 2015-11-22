package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gr")
public class class185 extends class66 {
   @ObfuscatedName("m")
   class198 field2986 = new class198();
   @ObfuscatedName("f")
   class55 field2987 = new class55();
   @ObfuscatedName("j")
   class183 field2988;

   @ObfuscatedName("h")
   protected class66 vmethod3770() {
      class186 var1;
      do {
         var1 = (class186)this.field2986.method3873();
         if(null == var1) {
            return null;
         }
      } while(null == var1.field3009);

      return var1.field3009;
   }

   @ObfuscatedName("i")
   protected int vmethod3772() {
      return 0;
   }

   @ObfuscatedName("m")
   void method3773(class186 var1, int var2) {
      if(0 != (this.field2988.field2959[var1.field3006] & 4) && var1.field3005 < 0) {
         int var3 = this.field2988.field2964[var1.field3006] / class56.field1183;
         int var4 = (var3 + 1048575 - var1.field3011) / var3;
         var1.field3011 = var3 * var2 + var1.field3011 & 1048575;
         if(var4 <= var2) {
            if(0 == this.field2988.field2946[var1.field3006]) {
               var1.field3009 = class64.method1421(var1.field2998, var1.field3009.method1476(), var1.field3009.method1352(), var1.field3009.method1353());
            } else {
               var1.field3009 = class64.method1421(var1.field2998, var1.field3009.method1476(), 0, var1.field3009.method1353());
               this.field2988.method3734(var1, var1.field2992.field2914[var1.field2996] < 0);
            }

            if(var1.field2992.field2914[var1.field2996] < 0) {
               var1.field3009.method1348(-1);
            }

            var2 = var1.field3011 / var3;
         }
      }

      var1.field3009.vmethod3787(var2);
   }

   @ObfuscatedName("a")
   protected class66 vmethod3774() {
      class186 var1 = (class186)this.field2986.method3871();
      return (class66)(var1 == null?null:(var1.field3009 != null?var1.field3009:this.vmethod3770()));
   }

   @ObfuscatedName("j")
   void method3776(class186 var1, int[] var2, int var3, int var4, int var5) {
      if(0 != (this.field2988.field2959[var1.field3006] & 4) && var1.field3005 < 0) {
         int var6 = this.field2988.field2964[var1.field3006] / class56.field1183;

         while(true) {
            int var7 = (1048575 + var6 - var1.field3011) / var6;
            if(var7 > var4) {
               var1.field3011 += var4 * var6;
               break;
            }

            var1.field3009.vmethod3784(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field3011 += var6 * var7 - 1048576;
            int var8 = class56.field1183 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class64 var10 = var1.field3009;
            if(this.field2988.field2946[var1.field3006] == 0) {
               var1.field3009 = class64.method1421(var1.field2998, var10.method1476(), var10.method1352(), var10.method1353());
            } else {
               var1.field3009 = class64.method1421(var1.field2998, var10.method1476(), 0, var10.method1353());
               this.field2988.method3734(var1, var1.field2992.field2914[var1.field2996] < 0);
               var1.field3009.method1357(var8, var10.method1352());
            }

            if(var1.field2992.field2914[var1.field2996] < 0) {
               var1.field3009.method1348(-1);
            }

            var10.method1402(var8);
            var10.vmethod3784(var2, var3, var5 - var3);
            if(var10.method1363()) {
               this.field2987.method1200(var10);
            }
         }
      }

      var1.field3009.vmethod3784(var2, var3, var4);
   }

   class185(class183 var1) {
      this.field2988 = var1;
   }

   @ObfuscatedName("t")
   protected void vmethod3784(int[] var1, int var2, int var3) {
      this.field2987.vmethod3784(var1, var2, var3);

      for(class186 var6 = (class186)this.field2986.method3871(); null != var6; var6 = (class186)this.field2986.method3873()) {
         if(!this.field2988.method3686(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2999) {
                  this.method3776(var6, var1, var4, var5, var4 + var5);
                  var6.field2999 -= var5;
                  break;
               }

               this.method3776(var6, var1, var4, var6.field2999, var4 + var5);
               var4 += var6.field2999;
               var5 -= var6.field2999;
            } while(!this.field2988.method3758(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("s")
   protected void vmethod3787(int var1) {
      this.field2987.vmethod3787(var1);

      for(class186 var3 = (class186)this.field2986.method3871(); null != var3; var3 = (class186)this.field2986.method3873()) {
         if(!this.field2988.method3686(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2999) {
                  this.method3773(var3, var2);
                  var3.field2999 -= var2;
                  break;
               }

               this.method3773(var3, var3.field2999);
               var2 -= var3.field2999;
            } while(!this.field2988.method3758(var3, (int[])null, 0, var2));
         }
      }

   }
}
