import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
public class class208 extends class119 {
   @ObfuscatedName("c")
   Deque field2594;
   @ObfuscatedName("e")
   class102 field2596;
   @ObfuscatedName("i")
   class204 field2597;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-1877719771"
   )
   public static int method3857(CharSequence var0) {
      return class211.method3909(var0, 10, true);
   }

   @ObfuscatedName("y")
   protected class119 vmethod3858() {
      class205 var1 = (class205)this.field2594.method3576();
      return (class119)(var1 == null?null:(var1.field2563 != null?var1.field2563:this.vmethod3886()));
   }

   @ObfuscatedName("x")
   protected int vmethod3860() {
      return 0;
   }

   @ObfuscatedName("a")
   protected void vmethod3862(int var1) {
      this.field2596.vmethod3862(var1);

      for(class205 var3 = (class205)this.field2594.method3576(); var3 != null; var3 = (class205)this.field2594.method3578()) {
         if(!this.field2597.method3702(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2564) {
                  this.method3864(var3, var2);
                  var3.field2564 -= var2;
                  break;
               }

               this.method3864(var3, var3.field2564);
               var2 -= var3.field2564;
            } while(!this.field2597.method3704(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass205;[IIIII)V",
      garbageValue = "-554656213"
   )
   void method3863(class205 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2597.field2529[var1.field2560] & 4) != 0 && var1.field2559 < 0) {
         int var6 = this.field2597.field2542[var1.field2560] / class109.field1640;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2565) / var6;
            if(var7 > var4) {
               var1.field2565 += var4 * var6;
               break;
            }

            var1.field2563.vmethod3878(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2565 += var6 * var7 - 1048576;
            int var8 = class109.field1640 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class117 var10 = var1.field2563;
            if(this.field2597.field2532[var1.field2560] == 0) {
               var1.field2563 = class117.method2107(var1.field2547, var10.method2256(), var10.method2230(), var10.method2114());
            } else {
               var1.field2563 = class117.method2107(var1.field2547, var10.method2256(), 0, var10.method2114());
               this.field2597.method3680(var1, var1.field2562.field2583[var1.field2561] < 0);
               var1.field2563.method2171(var8, var10.method2230());
            }

            if(var1.field2562.field2583[var1.field2561] < 0) {
               var1.field2563.method2224(-1);
            }

            var10.method2236(var8);
            var10.vmethod3878(var2, var3, var5 - var3);
            if(var10.method2176()) {
               this.field2596.method1884(var10);
            }
         }
      }

      var1.field2563.vmethod3878(var2, var3, var4);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass205;IB)V",
      garbageValue = "-38"
   )
   void method3864(class205 var1, int var2) {
      if((this.field2597.field2529[var1.field2560] & 4) != 0 && var1.field2559 < 0) {
         int var3 = this.field2597.field2542[var1.field2560] / class109.field1640;
         int var4 = (var3 + 1048575 - var1.field2565) / var3;
         var1.field2565 = var1.field2565 + var3 * var2 & 1048575;
         if(var4 <= var2) {
            if(this.field2597.field2532[var1.field2560] == 0) {
               var1.field2563 = class117.method2107(var1.field2547, var1.field2563.method2256(), var1.field2563.method2230(), var1.field2563.method2114());
            } else {
               var1.field2563 = class117.method2107(var1.field2547, var1.field2563.method2256(), 0, var1.field2563.method2114());
               this.field2597.method3680(var1, var1.field2562.field2583[var1.field2561] < 0);
            }

            if(var1.field2562.field2583[var1.field2561] < 0) {
               var1.field2563.method2224(-1);
            }

            var2 = var1.field2565 / var3;
         }
      }

      var1.field2563.vmethod3862(var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)[Lclass276;",
      garbageValue = "70"
   )
   public static class276[] method3865() {
      return new class276[]{class276.field3736, class276.field3735, class276.field3734};
   }

   @ObfuscatedName("f")
   protected void vmethod3878(int[] var1, int var2, int var3) {
      this.field2596.vmethod3878(var1, var2, var3);

      for(class205 var6 = (class205)this.field2594.method3576(); var6 != null; var6 = (class205)this.field2594.method3578()) {
         if(!this.field2597.method3702(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2564) {
                  this.method3863(var6, var1, var4, var5, var5 + var4);
                  var6.field2564 -= var5;
                  break;
               }

               this.method3863(var6, var1, var4, var6.field2564, var5 + var4);
               var4 += var6.field2564;
               var5 -= var6.field2564;
            } while(!this.field2597.method3704(var6, var1, var4, var5));
         }
      }

   }

   class208(class204 var1) {
      this.field2594 = new Deque();
      this.field2596 = new class102();
      this.field2597 = var1;
   }

   @ObfuscatedName("h")
   protected class119 vmethod3886() {
      class205 var1;
      do {
         var1 = (class205)this.field2594.method3578();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2563 == null);

      return var1.field2563;
   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass210;I)V",
      garbageValue = "433497"
   )
   static final void method3889(int var0, int var1, int var2, int var3, SpritePixels var4, class210 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle + Client.mapScale & 2047;
         int var8 = class136.SINE[var7];
         int var9 = class136.COSINE[var7];
         var8 = var8 * 256 / (Client.mapScaleDelta + 256);
         var9 = var9 * 256 / (Client.mapScaleDelta + 256);
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class219.field2788.method5058(var14 + var0 + 94 + 4 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class22.method149(var0, var1, var2, var3, var4, var5);
      }

   }
}
