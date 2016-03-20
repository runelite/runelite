import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class12 extends class84 {
   @ObfuscatedName("p")
   static int[] field172;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1787814531
   )
   int field173;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1527020079
   )
   int field174;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1634959033
   )
   int field175;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1280624945
   )
   int field176;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 648069501
   )
   int field177;
   @ObfuscatedName("g")
   class42 field178;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1830237087
   )
   int field179;
   @ObfuscatedName("br")
   static class167 field181;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 7057401
   )
   int field182;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1600377333
   )
   int field183;
   @ObfuscatedName("my")
   static byte field184;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "11525"
   )
   static void method171(int var0, int var1, int var2, int var3) {
      for(class23 var4 = (class23)class23.field606.method3860(); var4 != null; var4 = (class23)class23.field606.method3861()) {
         if(-1 != var4.field613 || null != var4.field617) {
            int var5 = 0;
            if(var1 > var4.field610) {
               var5 += var1 - var4.field610;
            } else if(var1 < var4.field609) {
               var5 += var4.field609 - var1;
            }

            if(var2 > var4.field611) {
               var5 += var2 - var4.field611;
            } else if(var2 < var4.field619) {
               var5 += var4.field619 - var2;
            }

            if(var5 - 64 <= var4.field612 && client.field535 != 0 && var4.field607 == var0) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field612 - var5) * client.field535 / var4.field612;
               if(var4.field614 == null) {
                  if(var4.field613 >= 0) {
                     class58 var7 = class58.method1272(field181, var4.field613, 0);
                     if(null != var7) {
                        class62 var8 = var7.method1270().method1305(class9.field150);
                        class64 var9 = class64.method1432(var8, 100, var6);
                        var9.method1329(-1);
                        class40.field973.method1152(var9);
                        var4.field614 = var9;
                     }
                  }
               } else {
                  var4.field614.method1330(var6);
               }

               if(var4.field608 == null) {
                  if(var4.field617 != null && (var4.field618 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.field617.length);
                     class58 var12 = class58.method1272(field181, var4.field617[var11], 0);
                     if(null != var12) {
                        class62 var13 = var12.method1270().method1305(class9.field150);
                        class64 var10 = class64.method1432(var13, 100, var6);
                        var10.method1329(0);
                        class40.field973.method1152(var10);
                        var4.field608 = var10;
                        var4.field618 = var4.field615 + (int)(Math.random() * (double)(var4.field616 - var4.field615));
                     }
                  }
               } else {
                  var4.field608.method1330(var6);
                  if(!var4.field608.method3944()) {
                     var4.field608 = null;
                  }
               }
            } else {
               if(null != var4.field614) {
                  class40.field973.method1153(var4.field614);
                  var4.field614 = null;
               }

               if(var4.field608 != null) {
                  class40.field973.method1153(var4.field608);
                  var4.field608 = null;
               }
            }
         }
      }

   }

   @ObfuscatedName("f")
   protected final class104 vmethod1919() {
      if(null != this.field178) {
         int var1 = client.field303 - this.field175;
         if(var1 > 100 && this.field178.field1000 * -1 > 0) {
            var1 = 100;
         }

         label65: {
            do {
               do {
                  if(var1 <= this.field178.field990[this.field179]) {
                     break label65;
                  }

                  var1 -= this.field178.field990[this.field179];
                  ++this.field179;
               } while(this.field179 < this.field178.field988.length);

               this.field179 -= this.field178.field1000 * -1;
            } while(this.field179 >= 0 && this.field179 < this.field178.field988.length);

            this.field178 = null;
         }

         this.field175 = client.field303 - var1;
      }

      class40 var12 = class156.method3176(this.field182);
      if(null != var12.field955) {
         var12 = var12.method848();
      }

      if(null == var12) {
         return null;
      } else {
         int var2;
         int var3;
         if(1 != this.field174 && this.field174 != 3) {
            var2 = var12.field938;
            var3 = var12.field939;
         } else {
            var2 = var12.field939;
            var3 = var12.field938;
         }

         int var4 = (var2 >> 1) + this.field176;
         int var5 = this.field176 + (1 + var2 >> 1);
         int var6 = this.field177 + (var3 >> 1);
         int var7 = this.field177 + (var3 + 1 >> 1);
         int[][] var8 = class5.field86[this.field183];
         int var9 = var8[var5][var7] + var8[var4][var7] + var8[var5][var6] + var8[var4][var6] >> 2;
         int var10 = (var2 << 6) + (this.field176 << 7);
         int var11 = (var3 << 6) + (this.field177 << 7);
         return var12.method813(this.field173, this.field174, var8, var10, var9, var11, this.field178, this.field179);
      }
   }

   class12(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, class84 var9) {
      this.field182 = var1;
      this.field173 = var2;
      this.field174 = var3;
      this.field183 = var4;
      this.field176 = var5;
      this.field177 = var6;
      if(-1 != var7) {
         this.field178 = class134.method2875(var7);
         this.field179 = 0;
         this.field175 = client.field303 - 1;
         if(this.field178.field1001 == 0 && null != var9 && var9 instanceof class12) {
            class12 var10 = (class12)var9;
            if(this.field178 == var10.field178) {
               this.field179 = var10.field179;
               this.field175 = var10.field175;
               return;
            }
         }

         if(var8 && this.field178.field1000 * -1 != -1) {
            this.field179 = (int)(Math.random() * (double)this.field178.field988.length);
            this.field175 -= (int)(Math.random() * (double)this.field178.field990[this.field179]);
         }
      }

   }

   @ObfuscatedName("aa")
   static final void method175(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = client.field441 + (client.field550 - client.field441) * var5 / 100;
      int var7 = 512 * var3 * var6 / (var2 * 334);
      int var8;
      int var9;
      short var14;
      if(var7 < client.field325) {
         var14 = client.field325;
         var6 = var14 * var2 * 334 / (512 * var3);
         if(var6 > client.field372) {
            var6 = client.field372;
            var8 = 512 * var3 * var6 / (var14 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               class79.method1873();
               class79.method1830(var0, var1, var9, var3, -16777216);
               class79.method1830(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > client.field556) {
         var14 = client.field556;
         var6 = 334 * var14 * var2 / (var3 * 512);
         if(var6 < client.field553) {
            var6 = client.field553;
            var8 = 334 * var14 * var2 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               class79.method1873();
               class79.method1830(var0, var1, var2, var9, -16777216);
               class79.method1830(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (client.field457 - client.field551) * var5 / 100 + client.field551;
      client.field347 = var8 * var6 * var3 / 85504 << 1;
      if(client.field559 != var2 || var3 != client.field560) {
         int[] var15 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 15 + var10 * 32 + 128;
            int var12 = 3 * var11 + 600;
            int var13 = class90.field1572[var11];
            var15[var10] = var13 * var12 >> 16;
         }

         class85.method1994(var15, 500, 800, var2, var3);
      }

      client.field557 = var0;
      client.field558 = var1;
      client.field559 = var2;
      client.field560 = var3;
   }

   @ObfuscatedName("n")
   public static boolean method176(class166 var0, int var1, int var2) {
      byte[] var3 = var0.method3263(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         class77.method1725(var3);
         return true;
      }
   }
}
