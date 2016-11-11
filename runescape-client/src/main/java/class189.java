import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
public class class189 extends class69 {
   @ObfuscatedName("h")
   Deque field3059 = new Deque();
   @ObfuscatedName("i")
   class187 field3060;
   @ObfuscatedName("v")
   public static class175 field3062;
   @ObfuscatedName("e")
   class58 field3064 = new class58();
   @ObfuscatedName("nd")
   @ObfuscatedGetter(
      intValue = 834118617
   )
   static int field3065;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass190;[IIIII)V",
      garbageValue = "1864497251"
   )
   void method3742(class190 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field3060.field3035[var1.field3077] & 4) != 0 && var1.field3080 < 0) {
         int var6 = this.field3060.field3028[var1.field3077] / class59.field1239;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field3086) / var6;
            if(var7 > var4) {
               var1.field3086 += var4 * var6;
               break;
            }

            var1.field3084.vmethod3746(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field3086 += var6 * var7 - 1048576;
            int var8 = class59.field1239 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class67 var10 = var1.field3084;
            if(this.field3060.field3033[var1.field3077] == 0) {
               var1.field3084 = class67.method1348(var1.field3085, var10.method1363(), var10.method1354(), var10.method1491());
            } else {
               var1.field3084 = class67.method1348(var1.field3085, var10.method1363(), 0, var10.method1491());
               this.field3060.method3712(var1, var1.field3066.field2987[var1.field3075] < 0);
               var1.field3084.method1396(var8, var10.method1354());
            }

            if(var1.field3066.field2987[var1.field3075] < 0) {
               var1.field3084.method1376(-1);
            }

            var10.method1361(var8);
            var10.vmethod3746(var2, var3, var5 - var3);
            if(var10.method1365()) {
               this.field3064.method1177(var10);
            }
         }
      }

      var1.field3084.vmethod3746(var2, var3, var4);
   }

   @ObfuscatedName("y")
   protected void vmethod3743(int var1) {
      this.field3064.vmethod3743(var1);

      for(class190 var3 = (class190)this.field3059.method3845(); null != var3; var3 = (class190)this.field3059.method3847()) {
         if(!this.field3060.method3658(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field3067) {
                  this.method3766(var3, var2);
                  var3.field3067 -= var2;
                  break;
               }

               this.method3766(var3, var3.field3067);
               var2 -= var3.field3067;
            } while(!this.field3060.method3732(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("d")
   protected class69 vmethod3744() {
      class190 var1;
      do {
         var1 = (class190)this.field3059.method3847();
         if(var1 == null) {
            return null;
         }
      } while(var1.field3084 == null);

      return var1.field3084;
   }

   @ObfuscatedName("l")
   protected int vmethod3745() {
      return 0;
   }

   @ObfuscatedName("m")
   protected void vmethod3746(int[] var1, int var2, int var3) {
      this.field3064.vmethod3746(var1, var2, var3);

      for(class190 var6 = (class190)this.field3059.method3845(); var6 != null; var6 = (class190)this.field3059.method3847()) {
         if(!this.field3060.method3658(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field3067) {
                  this.method3742(var6, var1, var4, var5, var5 + var4);
                  var6.field3067 -= var5;
                  break;
               }

               this.method3742(var6, var1, var4, var6.field3067, var4 + var5);
               var4 += var6.field3067;
               var5 -= var6.field3067;
            } while(!this.field3060.method3732(var6, var1, var4, var5));
         }
      }

   }

   class189(class187 var1) {
      this.field3060 = var1;
   }

   @ObfuscatedName("u")
   protected class69 vmethod3756() {
      class190 var1 = (class190)this.field3059.method3845();
      return (class69)(null == var1?null:(var1.field3084 != null?var1.field3084:this.vmethod3744()));
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass190;II)V",
      garbageValue = "422864190"
   )
   void method3766(class190 var1, int var2) {
      if((this.field3060.field3035[var1.field3077] & 4) != 0 && var1.field3080 < 0) {
         int var3 = this.field3060.field3028[var1.field3077] / class59.field1239;
         int var4 = (var3 + 1048575 - var1.field3086) / var3;
         var1.field3086 = var3 * var2 + var1.field3086 & 1048575;
         if(var4 <= var2) {
            if(this.field3060.field3033[var1.field3077] == 0) {
               var1.field3084 = class67.method1348(var1.field3085, var1.field3084.method1363(), var1.field3084.method1354(), var1.field3084.method1491());
            } else {
               var1.field3084 = class67.method1348(var1.field3085, var1.field3084.method1363(), 0, var1.field3084.method1491());
               this.field3060.method3712(var1, var1.field3066.field2987[var1.field3075] < 0);
            }

            if(var1.field3066.field2987[var1.field3075] < 0) {
               var1.field3084.method1376(-1);
            }

            var2 = var1.field3086 / var3;
         }
      }

      var1.field3084.vmethod3743(var2);
   }
}
