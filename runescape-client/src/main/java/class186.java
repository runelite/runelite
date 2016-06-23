import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class186 extends class66 {
   @ObfuscatedName("x")
   class55 field3001 = new class55();
   @ObfuscatedName("f")
   class184 field3002;
   @ObfuscatedName("bg")
   static class168 field3004;
   @ObfuscatedName("u")
   class199 field3005 = new class199();

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass187;[IIIII)V",
      garbageValue = "-735154507"
   )
   void method3750(class187 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field3002.field2974[var1.field3018] & 4) != 0 && var1.field3021 < 0) {
         int var6 = this.field3002.field2978[var1.field3018] / class56.field1196;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field3024) / var6;
            if(var7 > var4) {
               var1.field3024 += var6 * var4;
               break;
            }

            var1.field3025.vmethod3764(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field3024 += var7 * var6 - 1048576;
            int var8 = class56.field1196 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class64 var10 = var1.field3025;
            if(this.field3002.field2960[var1.field3018] == 0) {
               var1.field3025 = class64.method1362(var1.field3009, var10.method1407(), var10.method1460(), var10.method1369());
            } else {
               var1.field3025 = class64.method1362(var1.field3009, var10.method1407(), 0, var10.method1369());
               this.field3002.method3654(var1, var1.field3008.field2931[var1.field3012] < 0);
               var1.field3025.method1461(var8, var10.method1460());
            }

            if(var1.field3008.field2931[var1.field3012] < 0) {
               var1.field3025.method1383(-1);
            }

            var10.method1375(var8);
            var10.vmethod3764(var2, var3, var5 - var3);
            if(var10.method1505()) {
               this.field3001.method1229(var10);
            }
         }
      }

      var1.field3025.vmethod3764(var2, var3, var4);
   }

   @ObfuscatedName("n")
   protected class66 vmethod3752() {
      class187 var1;
      do {
         var1 = (class187)this.field3005.method3857();
         if(null == var1) {
            return null;
         }
      } while(null == var1.field3025);

      return var1.field3025;
   }

   @ObfuscatedName("m")
   protected int vmethod3753() {
      return 0;
   }

   @ObfuscatedName("r")
   protected void vmethod3755(int var1) {
      this.field3001.vmethod3755(var1);

      for(class187 var3 = (class187)this.field3005.method3852(); null != var3; var3 = (class187)this.field3005.method3857()) {
         if(!this.field3002.method3705(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field3026) {
                  this.method3757(var3, var2);
                  var3.field3026 -= var2;
                  break;
               }

               this.method3757(var3, var3.field3026);
               var2 -= var3.field3026;
            } while(!this.field3002.method3671(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1777455993"
   )
   static final byte[] method3756(byte[] var0) {
      class119 var1 = new class119(var0);
      int var2 = var1.method2554();
      int var3 = var1.method2696();
      if(var3 >= 0 && (class167.field2681 == 0 || var3 <= class167.field2681)) {
         if(var2 == 0) {
            byte[] var4 = new byte[var3];
            var1.method2565(var4, 0, var3);
            return var4;
         } else {
            int var6 = var1.method2696();
            if(var6 < 0 || class167.field2681 != 0 && var6 > class167.field2681) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var6];
               if(var2 == 1) {
                  class117.method2505(var5, var6, var0, var3, 9);
               } else {
                  class167.field2677.method2501(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass187;IB)V",
      garbageValue = "0"
   )
   void method3757(class187 var1, int var2) {
      if((this.field3002.field2974[var1.field3018] & 4) != 0 && var1.field3021 < 0) {
         int var3 = this.field3002.field2978[var1.field3018] / class56.field1196;
         int var4 = (var3 + 1048575 - var1.field3024) / var3;
         var1.field3024 = var2 * var3 + var1.field3024 & 1048575;
         if(var4 <= var2) {
            if(this.field3002.field2960[var1.field3018] == 0) {
               var1.field3025 = class64.method1362(var1.field3009, var1.field3025.method1407(), var1.field3025.method1460(), var1.field3025.method1369());
            } else {
               var1.field3025 = class64.method1362(var1.field3009, var1.field3025.method1407(), 0, var1.field3025.method1369());
               this.field3002.method3654(var1, var1.field3008.field2931[var1.field3012] < 0);
            }

            if(var1.field3008.field2931[var1.field3012] < 0) {
               var1.field3025.method1383(-1);
            }

            var2 = var1.field3024 / var3;
         }
      }

      var1.field3025.vmethod3755(var2);
   }

   @ObfuscatedName("d")
   protected class66 vmethod3760() {
      class187 var1 = (class187)this.field3005.method3852();
      return (class66)(var1 == null?null:(var1.field3025 != null?var1.field3025:this.vmethod3752()));
   }

   @ObfuscatedName("g")
   protected void vmethod3764(int[] var1, int var2, int var3) {
      this.field3001.vmethod3764(var1, var2, var3);

      for(class187 var6 = (class187)this.field3005.method3852(); null != var6; var6 = (class187)this.field3005.method3857()) {
         if(!this.field3002.method3705(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field3026) {
                  this.method3750(var6, var1, var4, var5, var4 + var5);
                  var6.field3026 -= var5;
                  break;
               }

               this.method3750(var6, var1, var4, var6.field3026, var5 + var4);
               var4 += var6.field3026;
               var5 -= var6.field3026;
            } while(!this.field3002.method3671(var6, var1, var4, var5));
         }
      }

   }

   class186(class184 var1) {
      this.field3002 = var1;
   }
}
