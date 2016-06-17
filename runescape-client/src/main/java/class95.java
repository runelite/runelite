import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("TextureProvider")
public class class95 implements class92 {
   @ObfuscatedName("ni")
   static class74 field1589;
   @ObfuscatedName("g")
   class199 field1590 = new class199();
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1302388315
   )
   int field1591;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1683501935
   )
   int field1592 = 0;
   @ObfuscatedName("x")
   double field1593 = 1.0D;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -589342641
   )
   int field1594 = 128;
   @ObfuscatedName("b")
   class83[] field1597;
   @ObfuscatedName("r")
   class167 field1599;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-904224896"
   )
   public boolean vmethod2174(int var1) {
      return this.field1594 == 64;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method2175(double var1) {
      this.field1593 = var1;
      this.method2179();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "818769332"
   )
   public int vmethod2176(int var1) {
      return this.field1597[var1] != null?this.field1597[var1].field1411:0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-39"
   )
   public boolean vmethod2177(int var1) {
      return this.field1597[var1].field1412;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-42"
   )
   public void method2179() {
      for(int var1 = 0; var1 < this.field1597.length; ++var1) {
         if(this.field1597[var1] != null) {
            this.field1597[var1].method1900();
         }
      }

      this.field1590 = new class199();
      this.field1592 = this.field1591;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1694418798"
   )
   public void method2180(int var1) {
      for(int var2 = 0; var2 < this.field1597.length; ++var2) {
         class83 var3 = this.field1597[var2];
         if(null != var3 && var3.field1414 != 0 && var3.field1408) {
            var3.method1901(var1);
            var3.field1408 = false;
         }
      }

   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-84051805"
   )
   static final boolean method2184(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = client.field432[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }

   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;IDI)V",
      garbageValue = "20"
   )
   public class95(class167 var1, class167 var2, int var3, double var4, int var6) {
      this.field1599 = var2;
      this.field1591 = var3;
      this.field1592 = this.field1591;
      this.field1593 = var4;
      this.field1594 = var6;
      int[] var7 = var1.method3307(0);
      int var8 = var7.length;
      this.field1597 = new class83[var1.method3276(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         class119 var10 = new class119(var1.method3266(0, var7[var9]));
         this.field1597[var7[var9]] = new class83(var10);
      }

   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)Z",
      garbageValue = "2123091875"
   )
   static final boolean method2186(class173 var0) {
      if(var0.field2849 == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2849.length; ++var1) {
            int var2 = class4.method42(var0, var1);
            int var3 = var0.field2862[var1];
            if(var0.field2849[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2849[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2849[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Lclass33;I)V",
      garbageValue = "302576405"
   )
   static final void method2190(class33 var0) {
      if(class153.field2262.field813 >> 7 == client.field521 && client.field522 == class153.field2262.field791 >> 7) {
         client.field521 = 0;
      }

      int var1 = class32.field738;
      int[] var2 = class32.field739;
      int var3 = var1;
      if(class33.field753 == var0 || class33.field752 == var0) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         class2 var5;
         int var6;
         if(class33.field753 == var0) {
            var5 = class153.field2262;
            var6 = class153.field2262.field48 << 14;
         } else if(class33.field752 == var0) {
            var5 = client.field410[client.field329];
            var6 = client.field329 << 14;
         } else {
            var5 = client.field410[var2[var4]];
            var6 = var2[var4] << 14;
            if(var0 == class33.field756 && client.field329 == var2[var4]) {
               continue;
            }
         }

         if(null != var5 && var5.vmethod760() && !var5.field40) {
            var5.field44 = false;
            if((client.field383 && var1 > 50 || var1 > 200) && var0 != class33.field753 && var5.field795 == var5.field818) {
               var5.field44 = true;
            }

            int var7 = var5.field813 >> 7;
            int var8 = var5.field791 >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.field25 != null && client.field296 >= var5.field34 && client.field296 < var5.field39) {
                  var5.field44 = false;
                  var5.field33 = class108.method2413(var5.field813, var5.field791, class144.field2193);
                  class150.field2230.method1946(class144.field2193, var5.field813, var5.field791, var5.field33, 60, var5, var5.field792, var6, var5.field46, var5.field41, var5.field42, var5.field27);
               } else {
                  if((var5.field813 & 127) == 64 && (var5.field791 & 127) == 64) {
                     if(client.field393[var7][var8] == client.field565) {
                        continue;
                     }

                     client.field393[var7][var8] = client.field565;
                  }

                  var5.field33 = class108.method2413(var5.field813, var5.field791, class144.field2193);
                  class150.field2230.method1936(class144.field2193, var5.field813, var5.field791, var5.field33, 60, var5, var5.field792, var6, var5.field793);
               }
            }
         }
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1706184626"
   )
   static final void method2191(int var0, int var1, int var2, int var3) {
      ++client.field565;
      method2190(class33.field753);
      boolean var4 = false;
      int var5;
      int var7;
      if(client.field329 >= 0) {
         var5 = class32.field738;
         int[] var19 = class32.field739;

         for(var7 = 0; var7 < var5; ++var7) {
            if(client.field329 == var19[var7]) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         method2190(class33.field752);
      }

      class10.method127(true);
      method2190(var4?class33.field756:class33.field754);
      class10.method127(false);
      class134.method2906();

      for(class29 var20 = (class29)client.field423.method3844(); null != var20; var20 = (class29)client.field423.method3834()) {
         if(class144.field2193 == var20.field675 && !var20.field684) {
            if(client.field296 >= var20.field676) {
               var20.method652(client.field538);
               if(var20.field684) {
                  var20.method3916();
               } else {
                  class150.field2230.method1936(var20.field675, var20.field678, var20.field683, var20.field680, 60, var20, 0, -1, false);
               }
            }
         } else {
            var20.method3916();
         }
      }

      class106.method2383(var0, var1, var2, var3, true);
      var0 = client.field549;
      var1 = client.field550;
      var2 = client.field551;
      var3 = client.field552;
      class79.method1793(var0, var1, var0 + var2, var3 + var1);
      class91.method2126();
      int var6;
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      if(!client.field535) {
         var5 = client.field403;
         if(client.field450 / 256 > var5) {
            var5 = client.field450 / 256;
         }

         if(client.field536[4] && 128 + client.field529[4] > var5) {
            var5 = 128 + client.field529[4];
         }

         var6 = client.field357 + client.field322 & 2047;
         var7 = class116.field1961;
         var8 = class108.method2413(class153.field2262.field813, class153.field2262.field791, class144.field2193) - client.field379;
         var9 = class164.field2648;
         var10 = 600 + var5 * 3;
         var11 = 2048 - var5 & 2047;
         var12 = 2048 - var6 & 2047;
         var13 = 0;
         int var14 = 0;
         int var15 = var10;
         int var16;
         int var17;
         int var18;
         if(var11 != 0) {
            var16 = class91.field1563[var11];
            var17 = class91.field1564[var11];
            var18 = var17 * var14 - var16 * var10 >> 16;
            var15 = var10 * var17 + var16 * var14 >> 16;
            var14 = var18;
         }

         if(var12 != 0) {
            var16 = class91.field1563[var12];
            var17 = class91.field1564[var12];
            var18 = var17 * var13 + var15 * var16 >> 16;
            var15 = var15 * var17 - var13 * var16 >> 16;
            var13 = var18;
         }

         class28.field670 = var7 - var13;
         class59.field1188 = var8 - var14;
         client.field478 = var9 - var15;
         class156.field2286 = var5;
         class149.field2224 = var6;
      }

      if(!client.field535) {
         var5 = class19.method224();
      } else {
         if(class162.field2637.field132) {
            var6 = class144.field2193;
         } else {
            var7 = class108.method2413(class28.field670, client.field478, class144.field2193);
            if(var7 - class59.field1188 < 800 && (class5.field69[class144.field2193][class28.field670 >> 7][client.field478 >> 7] & 4) != 0) {
               var6 = class144.field2193;
            } else {
               var6 = 3;
            }
         }

         var5 = var6;
      }

      var6 = class28.field670;
      var7 = class59.field1188;
      var8 = client.field478;
      var9 = class156.field2286;
      var10 = class149.field2224;

      for(var11 = 0; var11 < 5; ++var11) {
         if(client.field536[var11]) {
            var12 = (int)(Math.random() * (double)(1 + client.field481[var11] * 2) - (double)client.field481[var11] + Math.sin((double)client.field539[var11] / 100.0D * (double)client.field324[var11]) * (double)client.field529[var11]);
            if(var11 == 0) {
               class28.field670 += var12;
            }

            if(var11 == 1) {
               class59.field1188 += var12;
            }

            if(var11 == 2) {
               client.field478 += var12;
            }

            if(var11 == 3) {
               class149.field2224 = var12 + class149.field2224 & 2047;
            }

            if(var11 == 4) {
               class156.field2286 += var12;
               if(class156.field2286 < 128) {
                  class156.field2286 = 128;
               }

               if(class156.field2286 > 383) {
                  class156.field2286 = 383;
               }
            }
         }
      }

      var11 = class140.field2134;
      var12 = class140.field2135;
      if(class140.field2140 != 0) {
         var11 = class140.field2141;
         var12 = class140.field2142;
      }

      if(var11 >= var0 && var11 < var0 + var2 && var12 >= var1 && var12 < var1 + var3) {
         class105.field1792 = true;
         class105.field1843 = 0;
         class105.field1841 = var11 - var0;
         class105.field1822 = var12 - var1;
      } else {
         class105.field1792 = false;
         class105.field1843 = 0;
      }

      class124.method2824();
      class79.method1865(var0, var1, var2, var3, 0);
      class124.method2824();
      var13 = class91.field1558;
      class91.field1558 = client.field553;
      class150.field2230.method1963(class28.field670, class59.field1188, client.field478, class156.field2286, class149.field2224, var5);
      class91.field1558 = var13;
      class124.method2824();
      class150.field2230.method2040();
      class72.method1601(var0, var1, var2, var3);
      method2195(var0, var1);
      ((class95)class91.field1560).method2180(client.field538);
      class220.method3995(var0, var1, var2, var3);
      class28.field670 = var6;
      class59.field1188 = var7;
      client.field478 = var8;
      class156.field2286 = var9;
      class149.field2224 = var10;
      if(client.field295 && class38.method765(true, false) == 0) {
         client.field295 = false;
      }

      if(client.field295) {
         class79.method1865(var0, var1, var2, var3, 0);
         class47.method972("Loading - please wait.", false);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "59"
   )
   public static final boolean method2192() {
      class137 var0 = class137.field2081;
      synchronized(class137.field2081) {
         if(class137.field2082 == class137.field2105) {
            return false;
         } else {
            class10.field158 = class137.field2100[class137.field2082];
            class25.field644 = class137.field2088[class137.field2082];
            class137.field2082 = 1 + class137.field2082 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-1315086805"
   )
   @Export("load")
   public int[] vmethod2193(int var1) {
      class83 var2 = this.field1597[var1];
      if(null != var2) {
         if(var2.field1419 != null) {
            this.field1590.method3820(var2);
            var2.field1408 = true;
            return var2.field1419;
         }

         boolean var3 = var2.method1899(this.field1593, this.field1594, this.field1599);
         if(var3) {
            if(this.field1592 == 0) {
               class83 var4 = (class83)this.field1590.method3818();
               var4.method1900();
            } else {
               --this.field1592;
            }

            this.field1590.method3820(var2);
            var2.field1408 = true;
            return var2.field1419;
         }
      }

      return null;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "47"
   )
   static final void method2195(int var0, int var1) {
      if(client.field323 == 2) {
         class94.method2172(client.field310 + (client.field307 - class4.field62 << 7), client.field458 + (client.field308 - class85.field1434 << 7), client.field309 * 2);
         if(client.field395 > -1 && client.field296 % 20 < 10) {
            class110.field1933[0].method1767(var0 + client.field395 - 12, client.field544 + var1 - 28);
         }

      }
   }
}
