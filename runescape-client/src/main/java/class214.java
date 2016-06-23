import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
public class class214 {
   @ObfuscatedName("b")
   String field3146;
   @ObfuscatedName("x")
   public final class220 field3147;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = -1243632026664691563L
   )
   public final long field3148;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1220818001
   )
   public final int field3149;
   @ObfuscatedName("l")
   String field3150;

   class214(class119 var1, byte var2, int var3) {
      this.field3146 = var1.method2668();
      this.field3150 = var1.method2668();
      this.field3149 = var1.method2556();
      this.field3148 = var1.method2560();
      int var4 = var1.method2696();
      int var5 = var1.method2696();
      this.field3147 = new class220();
      this.field3147.method4015(2);
      this.field3147.method4033(var2);
      this.field3147.field3169 = var4;
      this.field3147.field3172 = var5;
      this.field3147.field3171 = 0;
      this.field3147.field3170 = 0;
      this.field3147.field3168 = var3;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "548683495"
   )
   public String method3974() {
      return this.field3146;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-181200932"
   )
   public String method3975() {
      return this.field3150;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([Lclass25;II[I[IB)V",
      garbageValue = "1"
   )
   static void method3982(class25[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = 1 + var2;
         int var7 = (var1 + var2) / 2;
         class25 var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].field646;
                     var12 = var8.field646;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].field638;
                     var12 = var8.field638;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method646()?1:0;
                     var12 = var8.method646()?1:0;
                  } else {
                     var11 = var0[var6].field640;
                     var12 = var8.field640;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].field646;
                     var12 = var8.field646;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].field638;
                     var12 = var8.field638;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method646()?1:0;
                     var12 = var8.method646()?1:0;
                  } else {
                     var11 = var0[var5].field640;
                     var12 = var8.field640;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               class25 var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method3982(var0, var1, var6, var3, var4);
         method3982(var0, 1 + var6, var2, var3, var4);
      }

   }
}
