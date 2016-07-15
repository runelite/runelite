import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class189 extends class69 {
   @ObfuscatedName("l")
   class202 field3043 = new class202();
   @ObfuscatedName("e")
   class187 field3044;
   @ObfuscatedName("c")
   class58 field3047 = new class58();

   @ObfuscatedName("a")
   protected class69 vmethod3803() {
      class190 var1 = (class190)this.field3043.method3899();
      return (class69)(null == var1?null:(null != var1.field3061?var1.field3061:this.vmethod3804()));
   }

   @ObfuscatedName("b")
   protected class69 vmethod3804() {
      class190 var1;
      do {
         var1 = (class190)this.field3043.method3918();
         if(var1 == null) {
            return null;
         }
      } while(null == var1.field3061);

      return var1.field3061;
   }

   @ObfuscatedName("u")
   protected int vmethod3805() {
      return 0;
   }

   @ObfuscatedName("o")
   protected void vmethod3806(int[] var1, int var2, int var3) {
      this.field3047.vmethod3806(var1, var2, var3);

      for(class190 var6 = (class190)this.field3043.method3899(); null != var6; var6 = (class190)this.field3043.method3918()) {
         if(!this.field3044.method3726(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field3068) {
                  this.method3808(var6, var1, var4, var5, var4 + var5);
                  var6.field3068 -= var5;
                  break;
               }

               this.method3808(var6, var1, var4, var6.field3068, var4 + var5);
               var4 += var6.field3068;
               var5 -= var6.field3068;
            } while(!this.field3044.method3781(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("i")
   protected void vmethod3807(int var1) {
      this.field3047.vmethod3807(var1);

      for(class190 var3 = (class190)this.field3043.method3899(); null != var3; var3 = (class190)this.field3043.method3918()) {
         if(!this.field3044.method3726(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field3068) {
                  this.method3809(var3, var2);
                  var3.field3068 -= var2;
                  break;
               }

               this.method3809(var3, var3.field3068);
               var2 -= var3.field3068;
            } while(!this.field3044.method3781(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass190;[IIIII)V",
      garbageValue = "-1903885029"
   )
   void method3808(class190 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field3044.field3016[var1.field3067] & 4) != 0 && var1.field3063 < 0) {
         int var6 = this.field3044.field3021[var1.field3067] / class59.field1260;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field3069) / var6;
            if(var7 > var4) {
               var1.field3069 += var4 * var6;
               break;
            }

            var1.field3061.vmethod3806(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field3069 += var7 * var6 - 1048576;
            int var8 = class59.field1260 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class67 var10 = var1.field3061;
            if(this.field3044.field3018[var1.field3067] == 0) {
               var1.field3061 = class67.method1409(var1.field3050, var10.method1424(), var10.method1442(), var10.method1453());
            } else {
               var1.field3061 = class67.method1409(var1.field3050, var10.method1424(), 0, var10.method1453());
               this.field3044.method3695(var1, var1.field3062.field2970[var1.field3054] < 0);
               var1.field3061.method1420(var8, var10.method1442());
            }

            if(var1.field3062.field2970[var1.field3054] < 0) {
               var1.field3061.method1411(-1);
            }

            var10.method1428(var8);
            var10.vmethod3806(var2, var3, var5 - var3);
            if(var10.method1426()) {
               this.field3047.method1241(var10);
            }
         }
      }

      var1.field3061.vmethod3806(var2, var3, var4);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass190;IB)V",
      garbageValue = "10"
   )
   void method3809(class190 var1, int var2) {
      if((this.field3044.field3016[var1.field3067] & 4) != 0 && var1.field3063 < 0) {
         int var3 = this.field3044.field3021[var1.field3067] / class59.field1260;
         int var4 = (var3 + 1048575 - var1.field3069) / var3;
         var1.field3069 = var1.field3069 + var2 * var3 & 1048575;
         if(var4 <= var2) {
            if(this.field3044.field3018[var1.field3067] == 0) {
               var1.field3061 = class67.method1409(var1.field3050, var1.field3061.method1424(), var1.field3061.method1442(), var1.field3061.method1453());
            } else {
               var1.field3061 = class67.method1409(var1.field3050, var1.field3061.method1424(), 0, var1.field3061.method1453());
               this.field3044.method3695(var1, var1.field3062.field2970[var1.field3054] < 0);
            }

            if(var1.field3062.field2970[var1.field3054] < 0) {
               var1.field3061.method1411(-1);
            }

            var2 = var1.field3069 / var3;
         }
      }

      var1.field3061.vmethod3807(var2);
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "256"
   )
   static final void method3817(boolean var0) {
      client.field419 = 0;
      client.field334 = 0;
      class97.method2262();
      class5.method76(var0);
      class8.method103();

      int var1;
      for(var1 = 0; var1 < client.field419; ++var1) {
         int var2 = client.field315[var1];
         if(client.field567 != client.field331[var2].field899) {
            client.field331[var2].field825 = null;
            client.field331[var2] = null;
         }
      }

      if(client.field338.field2061 != client.field532) {
         throw new RuntimeException(client.field338.field2061 + "," + client.field532);
      } else {
         for(var1 = 0; var1 < client.field332; ++var1) {
            if(null == client.field331[client.field333[var1]]) {
               throw new RuntimeException(var1 + "," + client.field332);
            }
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SI)V",
      garbageValue = "1462114121"
   )
   public static void method3821(String[] var0, short[] var1) {
      class2.method5(var0, var1, 0, var0.length - 1);
   }

   class189(class187 var1) {
      this.field3044 = var1;
   }
}
