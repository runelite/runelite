import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
public class class152 implements class112 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 32879551
   )
   public final int field2284;
   @ObfuscatedName("p")
   static final class152 field2285 = new class152(3, 2, false, false, true);
   @ObfuscatedName("t")
   static final class152 field2286 = new class152(2, 1, true, true, false);
   @ObfuscatedName("w")
   static final class152 field2287 = new class152(0, -1, true, false, true);
   @ObfuscatedName("e")
   static final class152 field2288 = new class152(4, 3, false, false, true);
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 204041321
   )
   final int field2289;
   @ObfuscatedName("c")
   public final boolean field2291;
   @ObfuscatedName("v")
   public final boolean field2292;
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = -888054087
   )
   static int field2295;
   @ObfuscatedName("x")
   static final class152 field2296 = new class152(1, 0, true, true, true);

   @ObfuscatedName("w")
   public int vmethod3196() {
      return this.field2289;
   }

   class152(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2289 = var1;
      this.field2284 = var2;
      this.field2291 = var4;
      this.field2292 = var5;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass119;IIIIIII)V",
      garbageValue = "-1618626085"
   )
   static final void method3178(class119 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class5.field109[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.method2506();
            if(0 == var7) {
               if(0 == var1) {
                  int[] var14 = class5.field96[0][var2];
                  int var11 = 932731 + var2 + var4;
                  int var12 = var3 + 556238 + var5;
                  int var13 = class111.method2435(var11 + '넵', var12 + 91923, 4) - 128 + (class111.method2435(var11 + 10294, '鎽' + var12, 2) - 128 >> 1) + (class111.method2435(var11, var12, 1) - 128 >> 2);
                  var13 = (int)((double)var13 * 0.3D) + 35;
                  if(var13 < 10) {
                     var13 = 10;
                  } else if(var13 > 60) {
                     var13 = 60;
                  }

                  var14[var3] = -var13 * 8;
               } else {
                  class5.field96[var1][var2][var3] = class5.field96[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(1 == var7) {
               int var8 = var0.method2506();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(0 == var1) {
                  class5.field96[0][var2][var3] = 8 * -var8;
               } else {
                  class5.field96[var1][var2][var3] = class5.field96[var1 - 1][var2][var3] - 8 * var8;
               }
               break;
            }

            if(var7 <= 49) {
               class5.field93[var1][var2][var3] = var0.method2524();
               class137.field2147[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class114.field1985[var1][var2][var3] = (byte)(var6 + (var7 - 2) & 3);
            } else if(var7 <= 81) {
               class5.field109[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class34.field782[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.method2506();
            if(0 == var7) {
               break;
            }

            if(var7 == 1) {
               var0.method2506();
               break;
            }

            if(var7 <= 49) {
               var0.method2506();
            }
         }
      }

   }

   @ObfuscatedName("w")
   public static int method3179(int var0) {
      class47 var2 = (class47)class47.field1079.method3771((long)var0);
      class47 var1;
      if(var2 != null) {
         var1 = var2;
      } else {
         byte[] var3 = class47.field1083.method3335(14, var0);
         var2 = new class47();
         if(null != var3) {
            var2.method1011(new class119(var3));
         }

         class47.field1079.method3773(var2, (long)var0);
         var1 = var2;
      }

      int var7 = var1.field1085;
      int var4 = var1.field1081;
      int var5 = var1.field1082;
      int var6 = class176.field2918[var5 - var4];
      return class176.field2916[var7] >> var4 & var6;
   }
}
