package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("q")
public class class12 extends class84 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1720036025
   )
   int field183;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -522671829
   )
   int field184;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 356251237
   )
   int field185;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2135045045
   )
   int field186;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1208964175
   )
   int field187;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1769369587
   )
   int field188;
   @ObfuscatedName("o")
   class42 field189;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1693290611
   )
   int field190;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1098829793
   )
   int field191;
   @ObfuscatedName("do")
   static int[] field192;
   @ObfuscatedName("bw")
   static class80 field193;

   @ObfuscatedName("a")
   protected final class104 vmethod1870() {
      if(null != this.field189) {
         int var1 = client.field394 - this.field191;
         if(var1 > 100 && this.field189.field983 * -1 > 0) {
            var1 = 100;
         }

         label65: {
            do {
               do {
                  if(var1 <= this.field189.field988[this.field183]) {
                     break label65;
                  }

                  var1 -= this.field189.field988[this.field183];
                  ++this.field183;
               } while(this.field183 < this.field189.field986.length);

               this.field183 -= this.field189.field983 * -1;
            } while(this.field183 >= 0 && this.field183 < this.field189.field986.length);

            this.field189 = null;
         }

         this.field191 = client.field394 - var1;
      }

      class40 var12 = class48.method996(this.field190);
      if(var12.field920 != null) {
         var12 = var12.method824();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field185 != 1 && this.field185 != 3) {
            var2 = var12.field932;
            var3 = var12.field933;
         } else {
            var2 = var12.field933;
            var3 = var12.field932;
         }

         int var4 = (var2 >> 1) + this.field187;
         int var5 = (1 + var2 >> 1) + this.field187;
         int var6 = (var3 >> 1) + this.field188;
         int var7 = this.field188 + (1 + var3 >> 1);
         int[][] var8 = class5.field93[this.field186];
         int var9 = var8[var4][var7] + var8[var5][var6] + var8[var4][var6] + var8[var5][var7] >> 2;
         int var10 = (var2 << 6) + (this.field187 << 7);
         int var11 = (this.field188 << 7) + (var3 << 6);
         return var12.method806(this.field184, this.field185, var8, var10, var9, var11, this.field189, this.field183);
      }
   }

   class12(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, class84 var9) {
      this.field190 = var1;
      this.field184 = var2;
      this.field185 = var3;
      this.field186 = var4;
      this.field187 = var5;
      this.field188 = var6;
      if(var7 != -1) {
         this.field189 = class36.method741(var7);
         this.field183 = 0;
         this.field191 = client.field394 - 1;
         if(0 == this.field189.field990 && var9 != null && var9 instanceof class12) {
            class12 var10 = (class12)var9;
            if(var10.field189 == this.field189) {
               this.field183 = var10.field183;
               this.field191 = var10.field191;
               return;
            }
         }

         if(var8 && this.field189.field983 * -1 != -1) {
            this.field183 = (int)(Math.random() * (double)this.field189.field986.length);
            this.field191 -= (int)(Math.random() * (double)this.field189.field988[this.field183]);
         }
      }

   }

   @ObfuscatedName("bk")
   static final void method151() {
      client.field293.method2688();
      int var0 = client.field293.method2689(8);
      int var1;
      if(var0 < client.field561) {
         for(var1 = var0; var1 < client.field561; ++var1) {
            client.field414[++client.field413 - 1] = client.field326[var1];
         }
      }

      if(var0 > client.field561) {
         throw new RuntimeException("");
      } else {
         client.field561 = 0;

         for(var1 = 0; var1 < var0; ++var1) {
            int var2 = client.field326[var1];
            class34 var3 = client.field324[var2];
            int var4 = client.field293.method2689(1);
            if(0 == var4) {
               client.field326[++client.field561 - 1] = var2;
               var3.field858 = client.field394;
            } else {
               int var5 = client.field293.method2689(2);
               if(var5 == 0) {
                  client.field326[++client.field561 - 1] = var2;
                  var3.field858 = client.field394;
                  client.field328[++client.field327 - 1] = var2;
               } else {
                  int var6;
                  int var7;
                  if(1 == var5) {
                     client.field326[++client.field561 - 1] = var2;
                     var3.field858 = client.field394;
                     var6 = client.field293.method2689(3);
                     var3.method727(var6, (byte)1);
                     var7 = client.field293.method2689(1);
                     if(1 == var7) {
                        client.field328[++client.field327 - 1] = var2;
                     }
                  } else if(2 == var5) {
                     client.field326[++client.field561 - 1] = var2;
                     var3.field858 = client.field394;
                     var6 = client.field293.method2689(3);
                     var3.method727(var6, (byte)2);
                     var7 = client.field293.method2689(3);
                     var3.method727(var7, (byte)2);
                     int var8 = client.field293.method2689(1);
                     if(var8 == 1) {
                        client.field328[++client.field327 - 1] = var2;
                     }
                  } else if(3 == var5) {
                     client.field414[++client.field413 - 1] = var2;
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("bt")
   static void method152() {
      if(client.field408) {
         class172 var0 = class142.method2954(class137.field2144, client.field444);
         if(null != var0 && var0.field2814 != null) {
            class0 var1 = new class0();
            var1.field2 = var0;
            var1.field5 = var0.field2814;
            class126.method2751(var1, 200000);
         }

         client.field408 = false;
         class114.method2400(var0);
      }
   }

   @ObfuscatedName("a")
   static int method153(int var0, int var1) {
      class15 var2 = (class15)class15.field225.method3744((long)var0);
      if(var2 == null) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.field229.length; ++var4) {
            if(var1 == var2.field223[var4]) {
               var3 += var2.field229[var4];
            }
         }

         return var3;
      }
   }
}
