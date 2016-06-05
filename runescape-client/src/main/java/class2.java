import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
@Implements("Player")
public final class class2 extends class37 {
   @ObfuscatedName("b")
   @Export("model")
   class105 field35;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1272843495
   )
   int field36;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1209748053
   )
   int field37 = -1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -833737119
   )
   int field38 = -1;
   @ObfuscatedName("t")
   @Export("name")
   String field39;
   @ObfuscatedName("r")
   @Export("actions")
   String[] field40 = new String[3];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1485672055
   )
   @Export("combatLevel")
   int field41;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1054068673
   )
   int field43;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 670783279
   )
   int field44;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1875489861
   )
   int field45;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2071638525
   )
   int field46;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -5419885
   )
   int field47;
   @ObfuscatedName("w")
   boolean field48;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 203906655
   )
   int field49;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1920388611
   )
   int field50;
   @ObfuscatedName("n")
   boolean field51;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2097263981
   )
   int field52;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 293629555
   )
   @Export("totalLevel")
   int field53;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1872319173
   )
   int field54;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1462462951
   )
   @Export("team")
   int field55;
   @ObfuscatedName("x")
   boolean field56;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2071017941
   )
   int field57;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1693817943
   )
   int field58;
   @ObfuscatedName("i")
   @Export("composition")
   class179 field59;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1955566581
   )
   int field60;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 2065674839
   )
   int field61;
   @ObfuscatedName("pe")
   static class160 field62;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "2124236572"
   )
   protected final class105 vmethod1862() {
      if(null == this.field59) {
         return null;
      } else {
         class42 var1 = super.field834 != -1 && super.field824 == 0?class18.method177(super.field834):null;
         class42 var2 = super.field827 == -1 || this.field51 || super.field827 == super.field808 && null != var1?null:class18.method177(super.field827);
         class105 var3 = this.field59.method3436(var1, super.field819, var2, super.field832);
         if(var3 == null) {
            return null;
         } else {
            var3.method2258();
            super.field852 = var3.field1466;
            class105 var4;
            class105[] var5;
            if(!this.field51 && super.field836 != -1 && super.field840 != -1) {
               var4 = class16.method162(super.field836).method883(super.field840);
               if(var4 != null) {
                  var4.method2268(0, -super.field803, 0);
                  var5 = new class105[]{var3, var4};
                  var3 = new class105(var5, 2);
               }
            }

            if(!this.field51 && this.field35 != null) {
               if(client.field332 >= this.field45) {
                  this.field35 = null;
               }

               if(client.field332 >= this.field53 && client.field332 < this.field45) {
                  var4 = this.field35;
                  var4.method2268(this.field46 - super.field809, this.field47 - this.field43, this.field52 - super.field804);
                  if(super.field831 == 512) {
                     var4.method2264();
                     var4.method2264();
                     var4.method2264();
                  } else if(super.field831 == 1024) {
                     var4.method2264();
                     var4.method2264();
                  } else if(super.field831 == 1536) {
                     var4.method2264();
                  }

                  var5 = new class105[]{var3, var4};
                  var3 = new class105(var5, 2);
                  if(super.field831 == 512) {
                     var4.method2264();
                  } else if(super.field831 == 1024) {
                     var4.method2264();
                     var4.method2264();
                  } else if(super.field831 == 1536) {
                     var4.method2264();
                     var4.method2264();
                     var4.method2264();
                  }

                  var4.method2268(super.field809 - this.field46, this.field43 - this.field47, super.field804 - this.field52);
               }
            }

            var3.field1806 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-208292887"
   )
   final void method11(int var1, int var2, byte var3) {
      if(super.field834 != -1 && class18.method177(super.field834).field992 == 1) {
         super.field834 = -1;
      }

      super.field830 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.field847[0] >= 0 && super.field847[0] < 104 && super.field839[0] >= 0 && super.field839[0] < 104) {
            if(var3 == 2) {
               class2 var4 = this;
               int var5 = super.field847[0];
               int var6 = super.field839[0];
               int var7 = this.method30();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var10 = this.method30();
                  client.field324.field1883 = var1;
                  client.field324.field1887 = var2;
                  client.field324.field1884 = 1;
                  client.field324.field1889 = 1;
                  class10 var11 = client.field324;
                  int var12 = class89.method2046(var5, var6, var10, var11, client.field344[this.field57], true, client.field563, client.field435);
                  if(var12 >= 1) {
                     for(int var13 = 0; var13 < var12 - 1; ++var13) {
                        var4.method13(client.field563[var13], client.field435[var13], (byte)2);
                     }
                  }
               }
            }

            this.method13(var1, var2, var3);
         } else {
            this.method29(var1, var2);
         }
      } else {
         this.method29(var1, var2);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-348291421"
   )
   final void method12(class119 var1) {
      var1.field2000 = 0;
      int var2 = var1.method2494();
      this.field37 = var1.method2469();
      this.field38 = var1.method2469();
      int var3 = -1;
      this.field55 = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var5 = 0; var5 < 12; ++var5) {
         var6 = var1.method2494();
         if(var6 == 0) {
            var4[var5] = 0;
         } else {
            var7 = var1.method2494();
            var4[var5] = (var6 << 8) + var7;
            if(var5 == 0 && var4[0] == '\uffff') {
               var3 = var1.method2470();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = class123.method2743(var4[var5] - 512).field1157;
               if(var8 != 0) {
                  this.field55 = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.method2494();
         if(var7 < 0 || var7 >= class127.field2060[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.field808 = var1.method2470();
      if(super.field808 == '\uffff') {
         super.field808 = -1;
      }

      super.field837 = var1.method2470();
      if(super.field837 == '\uffff') {
         super.field837 = -1;
      }

      super.field810 = super.field837;
      super.field811 = var1.method2470();
      if(super.field811 == '\uffff') {
         super.field811 = -1;
      }

      super.field812 = var1.method2470();
      if(super.field812 == '\uffff') {
         super.field812 = -1;
      }

      super.field814 = var1.method2470();
      if(super.field814 == '\uffff') {
         super.field814 = -1;
      }

      super.field857 = var1.method2470();
      if(super.field857 == '\uffff') {
         super.field857 = -1;
      }

      super.field815 = var1.method2470();
      if(super.field815 == '\uffff') {
         super.field815 = -1;
      }

      this.field39 = var1.method2476();
      if(class152.field2301 == this) {
         class139.field2169 = this.field39;
      }

      this.field41 = var1.method2494();
      this.field54 = var1.method2470();
      this.field56 = var1.method2494() == 1;
      if(client.field384 == 0 && client.field449 >= 2) {
         this.field56 = false;
      }

      if(null == this.field59) {
         this.field59 = new class179();
      }

      this.field59.method3431(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "251106559"
   )
   final void method13(int var1, int var2, byte var3) {
      if(super.field856 < 9) {
         ++super.field856;
      }

      for(int var4 = super.field856; var4 > 0; --var4) {
         super.field847[var4] = super.field847[var4 - 1];
         super.field839[var4] = super.field839[var4 - 1];
         super.field859[var4] = super.field859[var4 - 1];
      }

      super.field847[0] = var1;
      super.field839[0] = var2;
      super.field859[0] = var3;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-98"
   )
   @Export("setGameState")
   static void method14(int var0) {
      if(client.field462 != var0) {
         if(client.field462 == 0) {
            class159.field2626 = null;
            class148.field2262 = null;
            class45.field1050 = null;
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            client.field316 = 0;
            client.field317 = 0;
            client.field318 = 0;
         }

         if(var0 != 20 && var0 != 40 && null != class89.field1561) {
            class89.field1561.method2960();
            class89.field1561 = null;
         }

         if(client.field462 == 25) {
            client.field403 = 0;
            client.field338 = 0;
            client.field339 = 1;
            client.field340 = 0;
            client.field341 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class130.method2794(class59.field1221, class138.field2161, class13.field203, true, client.field462 == 11?4:0);
            } else if(var0 == 11) {
               class130.method2794(class59.field1221, class138.field2161, class13.field203, false, 4);
            } else if(class31.field716) {
               class131.field2081 = null;
               class31.field704 = null;
               class109.field1916 = null;
               class49.field1100 = null;
               class31.field705 = null;
               class135.field2101 = null;
               class31.field711 = null;
               class4.field71 = null;
               class84.field1465 = null;
               class167.field2717 = null;
               class110.field1956 = null;
               class12.field186 = null;
               class44.field1039 = null;
               class87.field1541 = null;
               class119.field2005 = null;
               class95.field1634 = null;
               class19.field271 = null;
               class46.field1064 = null;
               class162.field2678 = null;
               class30.field700 = null;
               class32.field752 = null;
               class7.field136 = null;
               class20.method549(2);
               if(null != class43.field1023) {
                  try {
                     class119 var1 = new class119(4);
                     var1.method2453(2);
                     var1.method2455(0);
                     class43.field1023.method2964(var1.field2001, 0, 4);
                  } catch (IOException var4) {
                     try {
                        class43.field1023.method2960();
                     } catch (Exception var3) {
                        ;
                     }

                     ++class171.field2752;
                     class43.field1023 = null;
                  }
               }

               class31.field716 = false;
            }
         } else {
            class130.method2794(class59.field1221, class138.field2161, class13.field203, true, 0);
         }

         client.field462 = var0;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2099638997"
   )
   final boolean vmethod735() {
      return this.field59 != null;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "256"
   )
   void method29(int var1, int var2) {
      super.field856 = 0;
      super.field861 = 0;
      super.field860 = 0;
      super.field847[0] = var1;
      super.field839[0] = var2;
      int var3 = this.method30();
      super.field809 = 64 * var3 + super.field847[0] * 128;
      super.field804 = 128 * super.field839[0] + var3 * 64;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1332943264"
   )
   int method30() {
      return this.field59 != null && this.field59.field2941 != -1?class17.method169(this.field59.field2941).field881:1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lclass168;",
      garbageValue = "0"
   )
   static class168 method32(int var0, boolean var1, boolean var2, boolean var3) {
      class134 var4 = null;
      if(null != class149.field2264) {
         var4 = new class134(var0, class149.field2264, class134.field2093[var0], 1000000);
      }

      return new class168(var4, class24.field620, var0, var1, var2, var3);
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIB)V",
      garbageValue = "-126"
   )
   @Export("addMenuEntry")
   static final void method33(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!client.field423) {
         if(client.field294 < 500) {
            client.field429[client.field294] = var0;
            client.field337[client.field294] = var1;
            client.field392[client.field294] = var2;
            client.field502[client.field294] = var3;
            client.field425[client.field294] = var4;
            client.field426[client.field294] = var5;
            ++client.field294;
         }

      }
   }

   @ObfuscatedName("g")
   public static String method34(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class162.field2674[(int)(var6 - 37L * var0)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   class2() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.field40[var1] = "";
      }

      this.field41 = 0;
      this.field54 = 0;
      this.field53 = 0;
      this.field45 = 0;
      this.field51 = false;
      this.field55 = 0;
      this.field56 = false;
      this.field48 = false;
   }
}
