import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
public class class185 extends class66 {
   @ObfuscatedName("kn")
   static class130 field2998;
   @ObfuscatedName("l")
   class198 field2999 = new class198();
   @ObfuscatedName("j")
   class183 field3000;
   @ObfuscatedName("a")
   class55 field3001 = new class55();

   @ObfuscatedName("r")
   protected void vmethod3676(int var1) {
      this.field3001.vmethod3676(var1);

      for(class186 var3 = (class186)this.field2999.method3773(); null != var3; var3 = (class186)this.field2999.method3772()) {
         if(!this.field3000.method3652(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field3022) {
                  this.method3683(var3, var2);
                  var3.field3022 -= var2;
                  break;
               }

               this.method3683(var3, var3.field3022);
               var2 -= var3.field3022;
            } while(!this.field3000.method3584(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("m")
   protected class66 vmethod3677() {
      class186 var1 = (class186)this.field2999.method3773();
      return (class66)(var1 == null?null:(var1.field3018 != null?var1.field3018:this.vmethod3678()));
   }

   @ObfuscatedName("o")
   protected class66 vmethod3678() {
      class186 var1;
      do {
         var1 = (class186)this.field2999.method3772();
         if(var1 == null) {
            return null;
         }
      } while(var1.field3018 == null);

      return var1.field3018;
   }

   @ObfuscatedName("h")
   protected int vmethod3679() {
      return 0;
   }

   @ObfuscatedName("n")
   protected void vmethod3680(int[] var1, int var2, int var3) {
      this.field3001.vmethod3680(var1, var2, var3);

      for(class186 var6 = (class186)this.field2999.method3773(); var6 != null; var6 = (class186)this.field2999.method3772()) {
         if(!this.field3000.method3652(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field3022) {
                  this.method3681(var6, var1, var4, var5, var5 + var4);
                  var6.field3022 -= var5;
                  break;
               }

               this.method3681(var6, var1, var4, var6.field3022, var4 + var5);
               var4 += var6.field3022;
               var5 -= var6.field3022;
            } while(!this.field3000.method3584(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("j")
   void method3681(class186 var1, int[] var2, int var3, int var4, int var5) {
      if(0 != (this.field3000.field2971[var1.field3012] & 4) && var1.field3017 < 0) {
         int var6 = this.field3000.field2976[var1.field3012] / class102.field1780;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field3010) / var6;
            if(var7 > var4) {
               var1.field3010 += var4 * var6;
               break;
            }

            var1.field3018.vmethod3680(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field3010 += var7 * var6 - 1048576;
            int var8 = class102.field1780 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class64 var10 = var1.field3018;
            if(this.field3000.field2974[var1.field3012] == 0) {
               var1.field3018 = class64.method1355(var1.field3015, var10.method1297(), var10.method1308(), var10.method1309());
            } else {
               var1.field3018 = class64.method1355(var1.field3015, var10.method1297(), 0, var10.method1309());
               this.field3000.method3641(var1, var1.field3004.field2927[var1.field3008] < 0);
               var1.field3018.method1313(var8, var10.method1308());
            }

            if(var1.field3004.field2927[var1.field3008] < 0) {
               var1.field3018.method1304(-1);
            }

            var10.method1315(var8);
            var10.vmethod3680(var2, var3, var5 - var3);
            if(var10.method1302()) {
               this.field3001.method1152(var10);
            }
         }
      }

      var1.field3018.vmethod3680(var2, var3, var4);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass186;II)V",
      garbageValue = "-584142135"
   )
   void method3683(class186 var1, int var2) {
      if((this.field3000.field2971[var1.field3012] & 4) != 0 && var1.field3017 < 0) {
         int var3 = this.field3000.field2976[var1.field3012] / class102.field1780;
         int var4 = (1048575 + var3 - var1.field3010) / var3;
         var1.field3010 = var2 * var3 + var1.field3010 & 1048575;
         if(var4 <= var2) {
            if(0 == this.field3000.field2974[var1.field3012]) {
               var1.field3018 = class64.method1355(var1.field3015, var1.field3018.method1297(), var1.field3018.method1308(), var1.field3018.method1309());
            } else {
               var1.field3018 = class64.method1355(var1.field3015, var1.field3018.method1297(), 0, var1.field3018.method1309());
               this.field3000.method3641(var1, var1.field3004.field2927[var1.field3008] < 0);
            }

            if(var1.field3004.field2927[var1.field3008] < 0) {
               var1.field3018.method1304(-1);
            }

            var2 = var1.field3010 / var3;
         }
      }

      var1.field3018.vmethod3676(var2);
   }

   class185(class183 var1) {
      this.field3000 = var1;
   }
}
