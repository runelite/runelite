import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
public class class186 extends class66 {
   @ObfuscatedName("q")
   public static short[] field3018;
   @ObfuscatedName("d")
   class199 field3019 = new class199();
   @ObfuscatedName("a")
   class184 field3020;
   @ObfuscatedName("c")
   class55 field3021 = new class55();

   @ObfuscatedName("q")
   protected void vmethod3796(int[] var1, int var2, int var3) {
      this.field3021.vmethod3796(var1, var2, var3);

      for(class187 var6 = (class187)this.field3019.method3926(); null != var6; var6 = (class187)this.field3019.method3902()) {
         if(!this.field3020.method3711(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field3041) {
                  this.method3818(var6, var1, var4, var5, var5 + var4);
                  var6.field3041 -= var5;
                  break;
               }

               this.method3818(var6, var1, var4, var6.field3041, var4 + var5);
               var4 += var6.field3041;
               var5 -= var6.field3041;
            } while(!this.field3020.method3758(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("r")
   protected class66 vmethod3797() {
      class187 var1;
      do {
         var1 = (class187)this.field3019.method3902();
         if(var1 == null) {
            return null;
         }
      } while(var1.field3040 == null);

      return var1.field3040;
   }

   class186(class184 var1) {
      this.field3020 = var1;
   }

   @ObfuscatedName("e")
   protected void vmethod3800(int var1) {
      this.field3021.vmethod3800(var1);

      for(class187 var3 = (class187)this.field3019.method3926(); null != var3; var3 = (class187)this.field3019.method3902()) {
         if(!this.field3020.method3711(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field3041) {
                  this.method3801(var3, var2);
                  var3.field3041 -= var2;
                  break;
               }

               this.method3801(var3, var3.field3041);
               var2 -= var3.field3041;
            } while(!this.field3020.method3758(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass187;IB)V",
      garbageValue = "0"
   )
   void method3801(class187 var1, int var2) {
      if((this.field3020.field2985[var1.field3031] & 4) != 0 && var1.field3036 < 0) {
         int var3 = this.field3020.field2993[var1.field3031] / class40.field973;
         int var4 = (1048575 + var3 - var1.field3042) / var3;
         var1.field3042 = var1.field3042 + var2 * var3 & 1048575;
         if(var4 <= var2) {
            if(this.field3020.field2976[var1.field3031] == 0) {
               var1.field3040 = class64.method1397(var1.field3032, var1.field3040.method1538(), var1.field3040.method1403(), var1.field3040.method1404());
            } else {
               var1.field3040 = class64.method1397(var1.field3032, var1.field3040.method1538(), 0, var1.field3040.method1404());
               this.field3020.method3689(var1, var1.field3023.field2944[var1.field3039] < 0);
            }

            if(var1.field3023.field2944[var1.field3039] < 0) {
               var1.field3040.method1399(-1);
            }

            var2 = var1.field3042 / var3;
         }
      }

      var1.field3040.vmethod3800(var2);
   }

   @ObfuscatedName("k")
   protected class66 vmethod3806() {
      class187 var1 = (class187)this.field3019.method3926();
      return (class66)(var1 == null?null:(var1.field3040 != null?var1.field3040:this.vmethod3797()));
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1240575306"
   )
   static final void method3809(int var0) {
      if(var0 >= 0) {
         int var1 = client.field435[var0];
         int var2 = client.field525[var0];
         int var3 = client.field437[var0];
         int var4 = client.field500[var0];
         String var5 = client.field439[var0];
         String var6 = client.field440[var0];
         class4.method56(var1, var2, var3, var4, var5, var6, class140.field2160, class140.field2159);
      }
   }

   @ObfuscatedName("p")
   protected int vmethod3810() {
      return 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass187;[IIIII)V",
      garbageValue = "740771635"
   )
   void method3818(class187 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field3020.field2985[var1.field3031] & 4) != 0 && var1.field3036 < 0) {
         int var6 = this.field3020.field2993[var1.field3031] / class40.field973;

         while(true) {
            int var7 = (1048575 + var6 - var1.field3042) / var6;
            if(var7 > var4) {
               var1.field3042 += var4 * var6;
               break;
            }

            var1.field3040.vmethod3796(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field3042 += var6 * var7 - 1048576;
            int var8 = class40.field973 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class64 var10 = var1.field3040;
            if(0 == this.field3020.field2976[var1.field3031]) {
               var1.field3040 = class64.method1397(var1.field3032, var10.method1538(), var10.method1403(), var10.method1404());
            } else {
               var1.field3040 = class64.method1397(var1.field3032, var10.method1538(), 0, var10.method1404());
               this.field3020.method3689(var1, var1.field3023.field2944[var1.field3039] < 0);
               var1.field3040.method1492(var8, var10.method1403());
            }

            if(var1.field3023.field2944[var1.field3039] < 0) {
               var1.field3040.method1399(-1);
            }

            var10.method1410(var8);
            var10.vmethod3796(var2, var3, var5 - var3);
            if(var10.method1451()) {
               this.field3021.method1253(var10);
            }
         }
      }

      var1.field3040.vmethod3796(var2, var3, var4);
   }
}
