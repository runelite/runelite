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

      for(class205 var2 = (class205)this.field2599.method3487(); var2 != null; var2 = (class205)this.field2599.method3512()) {
         if(!this.field2601.method3573(var2)) {
            int var3 = var1;

            do {
               if(var3 <= var2.field2573) {
                  this.method3770(var2, var3);
                  var2.field2573 -= var3;
                  break;
               }

               this.method3770(var2, var2.field2573);
               var3 -= var2.field2573;
            } while(!this.field2601.method3607(var2, (int[])null, 0, var3));
         }
      }

   }

   @ObfuscatedName("o")
   protected void vmethod3775(int[] var1, int var2, int var3) {
      this.field2603.vmethod3775(var1, var2, var3);

      for(class205 var4 = (class205)this.field2599.method3487(); var4 != null; var4 = (class205)this.field2599.method3512()) {
         if(!this.field2601.method3573(var4)) {
            int var5 = var2;
            int var6 = var3;

            do {
               if(var6 <= var4.field2573) {
                  this.method3776(var4, var1, var5, var6, var6 + var5);
                  var4.field2573 -= var6;
                  break;
               }

               this.method3776(var4, var1, var5, var4.field2573, var6 + var5);
               var5 += var4.field2573;
               var6 -= var4.field2573;
            } while(!this.field2601.method3607(var4, var1, var5, var6));
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
      int var3 = var1.length();
      byte[] var4 = new byte[var3];

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var1.charAt(var5);
         if((var6 <= 0 || var6 >= 128) && (var6 < 160 || var6 > 255)) {
            if(var6 == 8364) {
               var4[var5] = -128;
            } else if(var6 == 8218) {
               var4[var5] = -126;
            } else if(var6 == 402) {
               var4[var5] = -125;
            } else if(var6 == 8222) {
               var4[var5] = -124;
            } else if(var6 == 8230) {
               var4[var5] = -123;
            } else if(var6 == 8224) {
               var4[var5] = -122;
            } else if(var6 == 8225) {
               var4[var5] = -121;
            } else if(var6 == 710) {
               var4[var5] = -120;
            } else if(var6 == 8240) {
               var4[var5] = -119;
            } else if(var6 == 352) {
               var4[var5] = -118;
            } else if(var6 == 8249) {
               var4[var5] = -117;
            } else if(var6 == 338) {
               var4[var5] = -116;
            } else if(var6 == 381) {
               var4[var5] = -114;
            } else if(var6 == 8216) {
               var4[var5] = -111;
            } else if(var6 == 8217) {
               var4[var5] = -110;
            } else if(var6 == 8220) {
               var4[var5] = -109;
            } else if(var6 == 8221) {
               var4[var5] = -108;
            } else if(var6 == 8226) {
               var4[var5] = -107;
            } else if(var6 == 8211) {
               var4[var5] = -106;
            } else if(var6 == 8212) {
               var4[var5] = -105;
            } else if(var6 == 732) {
               var4[var5] = -104;
            } else if(var6 == 8482) {
               var4[var5] = -103;
            } else if(var6 == 353) {
               var4[var5] = -102;
            } else if(var6 == 8250) {
               var4[var5] = -101;
            } else if(var6 == 339) {
               var4[var5] = -100;
            } else if(var6 == 382) {
               var4[var5] = -98;
            } else if(var6 == 376) {
               var4[var5] = -97;
            } else {
               var4[var5] = 63;
            }
         } else {
            var4[var5] = (byte)var6;
         }
      }

      var0.method3031(var4.length);
      var0.offset += class265.field3660.method2963(var4, 0, var4.length, var0.payload, var0.offset);
      return var0.offset - var2;
   }
}
