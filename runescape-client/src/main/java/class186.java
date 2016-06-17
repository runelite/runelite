import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
public class class186 extends class66 {
   @ObfuscatedName("b")
   class184 field3001;
   @ObfuscatedName("g")
   class199 field3002 = new class199();
   @ObfuscatedName("j")
   class55 field3003 = new class55();

   @ObfuscatedName("l")
   protected void vmethod3721(int[] var1, int var2, int var3) {
      this.field3003.vmethod3721(var1, var2, var3);

      for(class187 var6 = (class187)this.field3002.method3844(); null != var6; var6 = (class187)this.field3002.method3834()) {
         if(!this.field3001.method3651(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field3026) {
                  this.method3727(var6, var1, var4, var5, var5 + var4);
                  var6.field3026 -= var5;
                  break;
               }

               this.method3727(var6, var1, var4, var6.field3026, var5 + var4);
               var4 += var6.field3026;
               var5 -= var6.field3026;
            } while(!this.field3001.method3642(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("y")
   protected class66 vmethod3722() {
      class187 var1 = (class187)this.field3002.method3844();
      return (class66)(null == var1?null:(null != var1.field3007?var1.field3007:this.vmethod3736()));
   }

   @ObfuscatedName("c")
   protected int vmethod3724() {
      return 0;
   }

   @ObfuscatedName("p")
   protected void vmethod3725(int var1) {
      this.field3003.vmethod3725(var1);

      for(class187 var3 = (class187)this.field3002.method3844(); null != var3; var3 = (class187)this.field3002.method3834()) {
         if(!this.field3001.method3651(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field3026) {
                  this.method3734(var3, var2);
                  var3.field3026 -= var2;
                  break;
               }

               this.method3734(var3, var3.field3026);
               var2 -= var3.field3026;
            } while(!this.field3001.method3642(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass187;[IIIIS)V",
      garbageValue = "32767"
   )
   void method3727(class187 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field3001.field2975[var1.field3014] & 4) != 0 && var1.field3021 < 0) {
         int var6 = this.field3001.field2968[var1.field3014] / class56.field1153;

         while(true) {
            int var7 = (1048575 + var6 - var1.field3027) / var6;
            if(var7 > var4) {
               var1.field3027 += var6 * var4;
               break;
            }

            var1.field3007.vmethod3721(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field3027 += var6 * var7 - 1048576;
            int var8 = class56.field1153 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class64 var10 = var1.field3007;
            if(this.field3001.field2982[var1.field3014] == 0) {
               var1.field3007 = class64.method1312(var1.field3017, var10.method1418(), var10.method1318(), var10.method1319());
            } else {
               var1.field3007 = class64.method1312(var1.field3017, var10.method1418(), 0, var10.method1319());
               this.field3001.method3717(var1, var1.field3008.field2927[var1.field3012] < 0);
               var1.field3007.method1323(var8, var10.method1318());
            }

            if(var1.field3008.field2927[var1.field3012] < 0) {
               var1.field3007.method1314(-1);
            }

            var10.method1362(var8);
            var10.vmethod3721(var2, var3, var5 - var3);
            if(var10.method1329()) {
               this.field3003.method1167(var10);
            }
         }
      }

      var1.field3007.vmethod3721(var2, var3, var4);
   }

   class186(class184 var1) {
      this.field3001 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass187;II)V",
      garbageValue = "1988534013"
   )
   void method3734(class187 var1, int var2) {
      if((this.field3001.field2975[var1.field3014] & 4) != 0 && var1.field3021 < 0) {
         int var3 = this.field3001.field2968[var1.field3014] / class56.field1153;
         int var4 = (var3 + 1048575 - var1.field3027) / var3;
         var1.field3027 = var3 * var2 + var1.field3027 & 1048575;
         if(var4 <= var2) {
            if(this.field3001.field2982[var1.field3014] == 0) {
               var1.field3007 = class64.method1312(var1.field3017, var1.field3007.method1418(), var1.field3007.method1318(), var1.field3007.method1319());
            } else {
               var1.field3007 = class64.method1312(var1.field3017, var1.field3007.method1418(), 0, var1.field3007.method1319());
               this.field3001.method3717(var1, var1.field3008.field2927[var1.field3012] < 0);
            }

            if(var1.field3008.field2927[var1.field3012] < 0) {
               var1.field3007.method1314(-1);
            }

            var2 = var1.field3027 / var3;
         }
      }

      var1.field3007.vmethod3725(var2);
   }

   @ObfuscatedName("r")
   protected class66 vmethod3736() {
      class187 var1;
      do {
         var1 = (class187)this.field3002.method3834();
         if(null == var1) {
            return null;
         }
      } while(var1.field3007 == null);

      return var1.field3007;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Lclass130;",
      garbageValue = "391630862"
   )
   public static class130 method3746(int var0) {
      class130[] var1 = class93.method2170();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class130 var3 = var1[var2];
         if(var0 == var3.field2045) {
            return var3;
         }
      }

      return null;
   }
}
