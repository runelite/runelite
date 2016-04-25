import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
public class class186 extends class66 {
   @ObfuscatedName("h")
   class199 field3006 = new class199();
   @ObfuscatedName("j")
   class184 field3007;
   @ObfuscatedName("m")
   class55 field3008 = new class55();
   @ObfuscatedName("c")
   static byte[][][] field3009;
   @ObfuscatedName("e")
   static class78 field3010;

   class186(class184 var1) {
      this.field3007 = var1;
   }

   @ObfuscatedName("e")
   protected class66 vmethod3673() {
      class187 var1 = (class187)this.field3006.method3784();
      return (class66)(var1 == null?null:(null != var1.field3035?var1.field3035:this.vmethod3674()));
   }

   @ObfuscatedName("i")
   protected class66 vmethod3674() {
      class187 var1;
      do {
         var1 = (class187)this.field3006.method3777();
         if(var1 == null) {
            return null;
         }
      } while(var1.field3035 == null);

      return var1.field3035;
   }

   @ObfuscatedName("c")
   protected int vmethod3675() {
      return 0;
   }

   @ObfuscatedName("n")
   protected void vmethod3676(int[] var1, int var2, int var3) {
      this.field3008.vmethod3676(var1, var2, var3);

      for(class187 var6 = (class187)this.field3006.method3784(); null != var6; var6 = (class187)this.field3006.method3777()) {
         if(!this.field3007.method3590(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field3034) {
                  this.method3678(var6, var1, var4, var5, var4 + var5);
                  var6.field3034 -= var5;
                  break;
               }

               this.method3678(var6, var1, var4, var6.field3034, var4 + var5);
               var4 += var6.field3034;
               var5 -= var6.field3034;
            } while(!this.field3007.method3594(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("u")
   protected void vmethod3677(int var1) {
      this.field3008.vmethod3677(var1);

      for(class187 var3 = (class187)this.field3006.method3784(); var3 != null; var3 = (class187)this.field3006.method3777()) {
         if(!this.field3007.method3590(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field3034) {
                  this.method3679(var3, var2);
                  var3.field3034 -= var2;
                  break;
               }

               this.method3679(var3, var3.field3034);
               var2 -= var3.field3034;
            } while(!this.field3007.method3594(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass187;[IIIIS)V",
      garbageValue = "128"
   )
   void method3678(class187 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field3007.field2981[var1.field3030] & 4) != 0 && var1.field3026 < 0) {
         int var6 = this.field3007.field2986[var1.field3030] / class56.field1181;

         while(true) {
            int var7 = (1048575 + var6 - var1.field3032) / var6;
            if(var7 > var4) {
               var1.field3032 += var4 * var6;
               break;
            }

            var1.field3035.vmethod3676(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field3032 += var6 * var7 - 1048576;
            int var8 = class56.field1181 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class64 var10 = var1.field3035;
            if(0 == this.field3007.field2984[var1.field3030]) {
               var1.field3035 = class64.method1447(var1.field3013, var10.method1316(), var10.method1307(), var10.method1338());
            } else {
               var1.field3035 = class64.method1447(var1.field3013, var10.method1316(), 0, var10.method1338());
               this.field3007.method3606(var1, var1.field3036.field2931[var1.field3017] < 0);
               var1.field3035.method1312(var8, var10.method1307());
            }

            if(var1.field3036.field2931[var1.field3017] < 0) {
               var1.field3035.method1303(-1);
            }

            var10.method1333(var8);
            var10.vmethod3676(var2, var3, var5 - var3);
            if(var10.method1318()) {
               this.field3008.method1146(var10);
            }
         }
      }

      var1.field3035.vmethod3676(var2, var3, var4);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass187;II)V",
      garbageValue = "-1773514075"
   )
   void method3679(class187 var1, int var2) {
      if((this.field3007.field2981[var1.field3030] & 4) != 0 && var1.field3026 < 0) {
         int var3 = this.field3007.field2986[var1.field3030] / class56.field1181;
         int var4 = (var3 + 1048575 - var1.field3032) / var3;
         var1.field3032 = var1.field3032 + var3 * var2 & 1048575;
         if(var4 <= var2) {
            if(this.field3007.field2984[var1.field3030] == 0) {
               var1.field3035 = class64.method1447(var1.field3013, var1.field3035.method1316(), var1.field3035.method1307(), var1.field3035.method1338());
            } else {
               var1.field3035 = class64.method1447(var1.field3013, var1.field3035.method1316(), 0, var1.field3035.method1338());
               this.field3007.method3606(var1, var1.field3036.field2931[var1.field3017] < 0);
            }

            if(var1.field3036.field2931[var1.field3017] < 0) {
               var1.field3035.method1303(-1);
            }

            var2 = var1.field3032 / var3;
         }
      }

      var1.field3035.vmethod3677(var2);
   }
}
