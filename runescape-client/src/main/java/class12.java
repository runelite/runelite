import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class12 extends Renderable {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -400085027
   )
   int field176;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -85521833
   )
   int field177;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1117905753
   )
   int field178;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1864244981
   )
   int field179;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1084612317
   )
   int field180;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1877048029
   )
   int field181;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 560067181
   )
   int field183;
   @ObfuscatedName("t")
   static int[] field184;
   @ObfuscatedName("f")
   public static short[][] field185;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1247894753
   )
   int field187;
   @ObfuscatedName("l")
   Sequence field189;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IZB)Ljava/lang/String;",
      garbageValue = "0"
   )
   public static String method147(int var0, boolean var1) {
      if(var1 && var0 >= 0) {
         int var3 = var0;
         String var2;
         if(var1 && var0 >= 0) {
            int var4 = 2;

            for(int var5 = var0 / 10; var5 != 0; ++var4) {
               var5 /= 10;
            }

            char[] var6 = new char[var4];
            var6[0] = 43;

            for(int var7 = var4 - 1; var7 > 0; --var7) {
               int var8 = var3;
               var3 /= 10;
               int var9 = var8 - 10 * var3;
               if(var9 >= 10) {
                  var6[var7] = (char)(var9 + 87);
               } else {
                  var6[var7] = (char)(48 + var9);
               }
            }

            var2 = new String(var6);
         } else {
            var2 = Integer.toString(var0, 10);
         }

         return var2;
      } else {
         return Integer.toString(var0);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1904052091"
   )
   protected final Model getModel() {
      if(null != this.field189) {
         int var1 = Client.gameCycle - this.field179;
         if(var1 > 100 && this.field189.field1002 > 0) {
            var1 = 100;
         }

         label68: {
            do {
               do {
                  if(var1 <= this.field189.field999[this.field183]) {
                     break label68;
                  }

                  var1 -= this.field189.field999[this.field183];
                  ++this.field183;
               } while(this.field183 < this.field189.field1001.length);

               this.field183 -= this.field189.field1002;
            } while(this.field183 >= 0 && this.field183 < this.field189.field1001.length);

            this.field189 = null;
         }

         this.field179 = Client.gameCycle - var1;
      }

      ObjectComposition var12 = class1.getObjectDefinition(this.field187);
      if(null != var12.impostorIds) {
         var12 = var12.getImpostor();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field178 != 1 && this.field178 != 3) {
            var2 = var12.field938;
            var3 = var12.field939;
         } else {
            var2 = var12.field939;
            var3 = var12.field938;
         }

         int var4 = this.field180 + (var2 >> 1);
         int var5 = (1 + var2 >> 1) + this.field180;
         int var6 = (var3 >> 1) + this.field181;
         int var7 = (var3 + 1 >> 1) + this.field181;
         int[][] var8 = class5.tileHeights[this.field176];
         int var9 = var8[var5][var7] + var8[var4][var7] + var8[var4][var6] + var8[var5][var6] >> 2;
         int var10 = (var2 << 6) + (this.field180 << 7);
         int var11 = (var3 << 6) + (this.field181 << 7);
         return var12.method805(this.field177, this.field178, var8, var10, var9, var11, this.field189, this.field183);
      }
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "39"
   )
   static void method152(int var0, int var1) {
      Client.field323.method2818(48);
      Client.field323.method2661(var1);
      Client.field323.method2575(var0);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IS)Lclass23;",
      garbageValue = "-1046"
   )
   static class23 method153(int var0) {
      class23 var1 = (class23)class23.field592.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class188.field3049.method3290(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = new class23();
            Buffer var3 = new Buffer(var2);
            var3.offset = var3.payload.length - 12;
            int var4 = var3.method2561();
            var1.field595 = var3.method2551();
            var1.field596 = var3.method2551();
            var1.field597 = var3.method2551();
            var1.field600 = var3.method2551();
            var3.offset = 0;
            var3.method2563();
            var1.field591 = new int[var4];
            var1.field598 = new int[var4];
            var1.field594 = new String[var4];

            int var6;
            for(int var5 = 0; var3.offset < var3.payload.length - 12; var1.field591[var5++] = var6) {
               var6 = var3.method2551();
               if(var6 == 3) {
                  var1.field594[var5] = var3.method2774();
               } else if(var6 < 100 && var6 != 21 && var6 != 38 && var6 != 39) {
                  var1.field598[var5] = var3.method2561();
               } else {
                  var1.field598[var5] = var3.method2556();
               }
            }

            class23.field592.put(var1, (long)var0);
            return var1;
         }
      }
   }

   class12(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.field187 = var1;
      this.field177 = var2;
      this.field178 = var3;
      this.field176 = var4;
      this.field180 = var5;
      this.field181 = var6;
      if(var7 != -1) {
         this.field189 = class113.getAnimation(var7);
         this.field183 = 0;
         this.field179 = Client.gameCycle - 1;
         if(this.field189.replyMode == 0 && var9 != null && var9 instanceof class12) {
            class12 var10 = (class12)var9;
            if(var10.field189 == this.field189) {
               this.field183 = var10.field183;
               this.field179 = var10.field179;
               return;
            }
         }

         if(var8 && this.field189.field1002 != -1) {
            this.field183 = (int)(Math.random() * (double)this.field189.field1001.length);
            this.field179 -= (int)(Math.random() * (double)this.field189.field999[this.field183]);
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIIS)I",
      garbageValue = "24883"
   )
   static int method154(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.field2050[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }
}
