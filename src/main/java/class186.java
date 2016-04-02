import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class186 extends class66 {
   @ObfuscatedName("s")
   class55 field3002 = new class55();
   @ObfuscatedName("f")
   class199 field3003 = new class199();
   @ObfuscatedName("e")
   class184 field3004;

   @ObfuscatedName("h")
   protected class66 vmethod3713() {
      class187 var1 = (class187)this.field3003.method3825();
      return (class66)(var1 == null?null:(null != var1.field3020?var1.field3020:this.vmethod3733()));
   }

   @ObfuscatedName("a")
   protected int vmethod3715() {
      return 0;
   }

   @ObfuscatedName("r")
   protected void vmethod3716(int[] var1, int var2, int var3) {
      this.field3002.vmethod3716(var1, var2, var3);

      for(class187 var6 = (class187)this.field3003.method3825(); var6 != null; var6 = (class187)this.field3003.method3827()) {
         if(!this.field3004.method3622(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field3024) {
                  this.method3723(var6, var1, var4, var5, var4 + var5);
                  var6.field3024 -= var5;
                  break;
               }

               this.method3723(var6, var1, var4, var6.field3024, var5 + var4);
               var4 += var6.field3024;
               var5 -= var6.field3024;
            } while(!this.field3004.method3623(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("m")
   protected void vmethod3717(int var1) {
      this.field3002.vmethod3717(var1);

      for(class187 var3 = (class187)this.field3003.method3825(); null != var3; var3 = (class187)this.field3003.method3827()) {
         if(!this.field3004.method3622(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field3024) {
                  this.method3719(var3, var2);
                  var3.field3024 -= var2;
                  break;
               }

               this.method3719(var3, var3.field3024);
               var2 -= var3.field3024;
            } while(!this.field3004.method3623(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass187;IB)V",
      garbageValue = "-9"
   )
   void method3719(class187 var1, int var2) {
      if(0 != (this.field3004.field2975[var1.field3016] & 4) && var1.field3009 < 0) {
         int var3 = this.field3004.field2980[var1.field3016] / class56.field1153;
         int var4 = (1048575 + var3 - var1.field3005) / var3;
         var1.field3005 = var2 * var3 + var1.field3005 & 1048575;
         if(var4 <= var2) {
            if(0 == this.field3004.field2978[var1.field3016]) {
               var1.field3020 = class64.method1300(var1.field3007, var1.field3020.method1396(), var1.field3020.method1364(), var1.field3020.method1307());
            } else {
               var1.field3020 = class64.method1300(var1.field3007, var1.field3020.method1396(), 0, var1.field3020.method1307());
               this.field3004.method3600(var1, var1.field3011.field2933[var1.field3010] < 0);
            }

            if(var1.field3011.field2933[var1.field3010] < 0) {
               var1.field3020.method1441(-1);
            }

            var2 = var1.field3005 / var3;
         }
      }

      var1.field3020.vmethod3717(var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass187;[IIIIB)V",
      garbageValue = "98"
   )
   void method3723(class187 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field3004.field2975[var1.field3016] & 4) != 0 && var1.field3009 < 0) {
         int var6 = this.field3004.field2980[var1.field3016] / class56.field1153;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field3005) / var6;
            if(var7 > var4) {
               var1.field3005 += var6 * var4;
               break;
            }

            var1.field3020.vmethod3716(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field3005 += var7 * var6 - 1048576;
            int var8 = class56.field1153 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class64 var10 = var1.field3020;
            if(this.field3004.field2978[var1.field3016] == 0) {
               var1.field3020 = class64.method1300(var1.field3007, var10.method1396(), var10.method1364(), var10.method1307());
            } else {
               var1.field3020 = class64.method1300(var1.field3007, var10.method1396(), 0, var10.method1307());
               this.field3004.method3600(var1, var1.field3011.field2933[var1.field3010] < 0);
               var1.field3020.method1311(var8, var10.method1364());
            }

            if(var1.field3011.field2933[var1.field3010] < 0) {
               var1.field3020.method1441(-1);
            }

            var10.method1444(var8);
            var10.vmethod3716(var2, var3, var5 - var3);
            if(var10.method1317()) {
               this.field3002.method1128(var10);
            }
         }
      }

      var1.field3020.vmethod3716(var2, var3, var4);
   }

   class186(class184 var1) {
      this.field3004 = var1;
   }

   @ObfuscatedName("g")
   protected class66 vmethod3733() {
      class187 var1;
      do {
         var1 = (class187)this.field3003.method3827();
         if(null == var1) {
            return null;
         }
      } while(var1.field3020 == null);

      return var1.field3020;
   }
}
