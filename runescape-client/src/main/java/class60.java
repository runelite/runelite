import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
public class class60 {
   @ObfuscatedName("n")
   class182 field1090;
   @ObfuscatedName("g")
   XHashTable field1091 = new XHashTable(256);
   @ObfuscatedName("v")
   XHashTable field1092 = new XHashTable(256);
   @ObfuscatedName("x")
   class182 field1095;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II[IB)Lclass55;",
      garbageValue = "16"
   )
   class55 method1217(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class55 var7 = (class55)this.field1092.method2437(var5);
      if(null != var7) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class53 var8 = class53.method1064(this.field1095, var1, var2);
         if(null == var8) {
            return null;
         } else {
            var7 = var8.method1058();
            this.field1092.method2438(var7, var5);
            if(null != var3) {
               var3[0] -= var7.field1034.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I[IB)Lclass55;",
      garbageValue = "-25"
   )
   public class55 method1219(int var1, int[] var2) {
      if(this.field1095.method3366() == 1) {
         return this.method1217(0, var1, var2);
      } else if(this.field1095.method3352(var1) == 1) {
         return this.method1217(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass55;",
      garbageValue = "2106811300"
   )
   public class55 method1220(int var1, int[] var2) {
      if(this.field1090.method3366() == 1) {
         return this.method1221(0, var1, var2);
      } else if(this.field1090.method3352(var1) == 1) {
         return this.method1221(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass55;",
      garbageValue = "-1672850132"
   )
   class55 method1221(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class55 var7 = (class55)this.field1092.method2437(var5);
      if(null != var7) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class54 var8 = (class54)this.field1091.method2437(var5);
         if(var8 == null) {
            var8 = class54.method1074(this.field1090, var1, var2);
            if(null == var8) {
               return null;
            }

            this.field1091.method2438(var8, var5);
         }

         var7 = var8.method1076(var3);
         if(null == var7) {
            return null;
         } else {
            var8.unlink();
            this.field1092.method2438(var7, var5);
            return var7;
         }
      }
   }

   public class60(class182 var1, class182 var2) {
      this.field1095 = var1;
      this.field1090 = var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass228;I)Ljava/lang/String;",
      garbageValue = "-1850515479"
   )
   public static String method1229(CharSequence var0, class228 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && class20.method211(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && class20.method211(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1) {
            byte var6;
            if(null == var1) {
               var6 = 12;
            } else {
               switch(var1.field3253) {
               case 0:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var4 <= var6) {
               StringBuilder var9 = new StringBuilder(var4);

               for(int var10 = var2; var10 < var3; ++var10) {
                  char var7 = var0.charAt(var10);
                  if(class150.method2859(var7)) {
                     char var8 = class107.method2128(var7);
                     if(var8 != 0) {
                        var9.append(var8);
                     }
                  }
               }

               if(var9.length() == 0) {
                  return null;
               }

               return var9.toString();
            }
         }

         return null;
      }
   }
}
