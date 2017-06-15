import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class208 extends class119 {
   @ObfuscatedName("m")
   Deque field2599;
   @ObfuscatedName("p")
   class204 field2601;
   @ObfuscatedName("e")
   class102 field2603;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass205;IB)V",
      garbageValue = "7"
   )
   void method3770(class205 var1, int var2) {
      if((this.field2601.field2537[var1.field2575] & 4) != 0 && var1.field2572 < 0) {
         int var3 = this.field2601.field2542[var1.field2575] / class109.field1635;
         int var4 = (var3 + 1048575 - var1.field2568) / var3;
         var1.field2568 = var1.field2568 + var2 * var3 & 1048575;
         if(var4 <= var2) {
            if(this.field2601.field2552[var1.field2575] == 0) {
               var1.field2565 = class117.method2039(var1.field2559, var1.field2565.method2124(), var1.field2565.method2107(), var1.field2565.method2046());
            } else {
               var1.field2565 = class117.method2039(var1.field2559, var1.field2565.method2124(), 0, var1.field2565.method2046());
               this.field2601.method3609(var1, var1.field2555.field2590[var1.field2574] < 0);
            }

            if(var1.field2555.field2590[var1.field2574] < 0) {
               var1.field2565.method2149(-1);
            }

            var2 = var1.field2568 / var3;
         }
      }

      var1.field2565.vmethod3773(var2);
   }

   @ObfuscatedName("z")
   protected class119 vmethod3771() {
      class205 var1 = (class205)this.field2599.method3487();
      return (class119)(var1 == null?null:(var1.field2565 != null?var1.field2565:this.vmethod3780()));
   }

   @ObfuscatedName("c")
   protected int vmethod3772() {
      return 0;
   }

   @ObfuscatedName("n")
   protected void vmethod3773(int var1) {
      this.field2603.vmethod3773(var1);

      for(class205 var3 = (class205)this.field2599.method3487(); var3 != null; var3 = (class205)this.field2599.method3512()) {
         if(!this.field2601.method3573(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2573) {
                  this.method3770(var3, var2);
                  var3.field2573 -= var2;
                  break;
               }

               this.method3770(var3, var3.field2573);
               var2 -= var3.field2573;
            } while(!this.field2601.method3607(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("o")
   protected void vmethod3775(int[] var1, int var2, int var3) {
      this.field2603.vmethod3775(var1, var2, var3);

      for(class205 var6 = (class205)this.field2599.method3487(); var6 != null; var6 = (class205)this.field2599.method3512()) {
         if(!this.field2601.method3573(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2573) {
                  this.method3776(var6, var1, var4, var5, var5 + var4);
                  var6.field2573 -= var5;
                  break;
               }

               this.method3776(var6, var1, var4, var6.field2573, var5 + var4);
               var4 += var6.field2573;
               var5 -= var6.field2573;
            } while(!this.field2601.method3607(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass205;[IIIII)V",
      garbageValue = "-670480810"
   )
   void method3776(class205 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2601.field2537[var1.field2575] & 4) != 0 && var1.field2572 < 0) {
         int var6 = this.field2601.field2542[var1.field2575] / class109.field1635;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2568) / var6;
            if(var7 > var4) {
               var1.field2568 += var4 * var6;
               break;
            }

            var1.field2565.vmethod3775(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2568 += var7 * var6 - 1048576;
            int var8 = class109.field1635 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class117 var10 = var1.field2565;
            if(this.field2601.field2552[var1.field2575] == 0) {
               var1.field2565 = class117.method2039(var1.field2559, var10.method2124(), var10.method2107(), var10.method2046());
            } else {
               var1.field2565 = class117.method2039(var1.field2559, var10.method2124(), 0, var10.method2046());
               this.field2601.method3609(var1, var1.field2555.field2590[var1.field2574] < 0);
               var1.field2565.method2050(var8, var10.method2107());
            }

            if(var1.field2555.field2590[var1.field2574] < 0) {
               var1.field2565.method2149(-1);
            }

            var10.method2052(var8);
            var10.vmethod3775(var2, var3, var5 - var3);
            if(var10.method2151()) {
               this.field2603.method1806(var10);
            }
         }
      }

      var1.field2565.vmethod3775(var2, var3, var4);
   }

   @ObfuscatedName("j")
   protected class119 vmethod3780() {
      class205 var1;
      do {
         var1 = (class205)this.field2599.method3512();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2565 == null);

      return var1.field2565;
   }

   class208(class204 var1) {
      this.field2599 = new Deque();
      this.field2603 = new class102();
      this.field2601 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;Ljava/lang/String;B)I",
      garbageValue = "69"
   )
   public static int method3796(Buffer var0, String var1) {
      int var2 = var0.offset;
      int var4 = var1.length();
      byte[] var5 = new byte[var4];

      for(int var6 = 0; var6 < var4; ++var6) {
         char var7 = var1.charAt(var6);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var5[var6] = (byte)var7;
         } else if(var7 == 8364) {
            var5[var6] = -128;
         } else if(var7 == 8218) {
            var5[var6] = -126;
         } else if(var7 == 402) {
            var5[var6] = -125;
         } else if(var7 == 8222) {
            var5[var6] = -124;
         } else if(var7 == 8230) {
            var5[var6] = -123;
         } else if(var7 == 8224) {
            var5[var6] = -122;
         } else if(var7 == 8225) {
            var5[var6] = -121;
         } else if(var7 == 710) {
            var5[var6] = -120;
         } else if(var7 == 8240) {
            var5[var6] = -119;
         } else if(var7 == 352) {
            var5[var6] = -118;
         } else if(var7 == 8249) {
            var5[var6] = -117;
         } else if(var7 == 338) {
            var5[var6] = -116;
         } else if(var7 == 381) {
            var5[var6] = -114;
         } else if(var7 == 8216) {
            var5[var6] = -111;
         } else if(var7 == 8217) {
            var5[var6] = -110;
         } else if(var7 == 8220) {
            var5[var6] = -109;
         } else if(var7 == 8221) {
            var5[var6] = -108;
         } else if(var7 == 8226) {
            var5[var6] = -107;
         } else if(var7 == 8211) {
            var5[var6] = -106;
         } else if(var7 == 8212) {
            var5[var6] = -105;
         } else if(var7 == 732) {
            var5[var6] = -104;
         } else if(var7 == 8482) {
            var5[var6] = -103;
         } else if(var7 == 353) {
            var5[var6] = -102;
         } else if(var7 == 8250) {
            var5[var6] = -101;
         } else if(var7 == 339) {
            var5[var6] = -100;
         } else if(var7 == 382) {
            var5[var6] = -98;
         } else if(var7 == 376) {
            var5[var6] = -97;
         } else {
            var5[var6] = 63;
         }
      }

      var0.method3031(var5.length);
      var0.offset += class265.field3660.method2963(var5, 0, var5.length, var0.payload, var0.offset);
      return var0.offset - var2;
   }
}
