import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
public class class189 extends class69 {
   @ObfuscatedName("d")
   Deque field3064 = new Deque();
   @ObfuscatedName("a")
   class187 field3066;
   @ObfuscatedName("v")
   class58 field3067 = new class58();

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass190;IB)V",
      garbageValue = "-73"
   )
   void method3744(class190 var1, int var2) {
      if((this.field3066.field3037[var1.field3071] & 4) != 0 && var1.field3088 < 0) {
         int var3 = this.field3066.field3042[var1.field3071] / class59.field1265;
         int var4 = (1048575 + var3 - var1.field3090) / var3;
         var1.field3090 = var2 * var3 + var1.field3090 & 1048575;
         if(var4 <= var2) {
            if(this.field3066.field3040[var1.field3071] == 0) {
               var1.field3075 = class67.method1350(var1.field3070, var1.field3075.method1365(), var1.field3075.method1476(), var1.field3075.method1357());
            } else {
               var1.field3075 = class67.method1350(var1.field3070, var1.field3075.method1365(), 0, var1.field3075.method1357());
               this.field3066.method3685(var1, var1.field3069.field2997[var1.field3073] < 0);
            }

            if(var1.field3069.field2997[var1.field3073] < 0) {
               var1.field3075.method1430(-1);
            }

            var2 = var1.field3090 / var3;
         }
      }

      var1.field3075.vmethod3749(var2);
   }

   @ObfuscatedName("t")
   protected class69 vmethod3745() {
      class190 var1 = (class190)this.field3064.method3854();
      return (class69)(null == var1?null:(var1.field3075 != null?var1.field3075:this.vmethod3756()));
   }

   @ObfuscatedName("i")
   protected int vmethod3747() {
      return 0;
   }

   @ObfuscatedName("k")
   protected void vmethod3749(int var1) {
      this.field3067.vmethod3749(var1);

      for(class190 var3 = (class190)this.field3064.method3854(); var3 != null; var3 = (class190)this.field3064.method3869()) {
         if(!this.field3066.method3664(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field3087) {
                  this.method3744(var3, var2);
                  var3.field3087 -= var2;
                  break;
               }

               this.method3744(var3, var3.field3087);
               var2 -= var3.field3087;
            } while(!this.field3066.method3665(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass190;[IIIIB)V",
      garbageValue = "20"
   )
   void method3750(class190 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field3066.field3037[var1.field3071] & 4) != 0 && var1.field3088 < 0) {
         int var6 = this.field3066.field3042[var1.field3071] / class59.field1265;

         while(true) {
            int var7 = (1048575 + var6 - var1.field3090) / var6;
            if(var7 > var4) {
               var1.field3090 += var6 * var4;
               break;
            }

            var1.field3075.vmethod3751(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field3090 += var7 * var6 - 1048576;
            int var8 = class59.field1265 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class67 var10 = var1.field3075;
            if(this.field3066.field3040[var1.field3071] == 0) {
               var1.field3075 = class67.method1350(var1.field3070, var10.method1365(), var10.method1476(), var10.method1357());
            } else {
               var1.field3075 = class67.method1350(var1.field3070, var10.method1365(), 0, var10.method1357());
               this.field3066.method3685(var1, var1.field3069.field2997[var1.field3073] < 0);
               var1.field3075.method1361(var8, var10.method1476());
            }

            if(var1.field3069.field2997[var1.field3073] < 0) {
               var1.field3075.method1430(-1);
            }

            var10.method1453(var8);
            var10.vmethod3751(var2, var3, var5 - var3);
            if(var10.method1367()) {
               this.field3067.method1187(var10);
            }
         }
      }

      var1.field3075.vmethod3751(var2, var3, var4);
   }

   @ObfuscatedName("g")
   protected void vmethod3751(int[] var1, int var2, int var3) {
      this.field3067.vmethod3751(var1, var2, var3);

      for(class190 var6 = (class190)this.field3064.method3854(); var6 != null; var6 = (class190)this.field3064.method3869()) {
         if(!this.field3066.method3664(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field3087) {
                  this.method3750(var6, var1, var4, var5, var5 + var4);
                  var6.field3087 -= var5;
                  break;
               }

               this.method3750(var6, var1, var4, var6.field3087, var4 + var5);
               var4 += var6.field3087;
               var5 -= var6.field3087;
            } while(!this.field3066.method3665(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("n")
   protected class69 vmethod3756() {
      class190 var1;
      do {
         var1 = (class190)this.field3064.method3869();
         if(var1 == null) {
            return null;
         }
      } while(null == var1.field3075);

      return var1.field3075;
   }

   class189(class187 var1) {
      this.field3066 = var1;
   }
}
