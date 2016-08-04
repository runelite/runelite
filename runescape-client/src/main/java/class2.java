import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
@Implements("Player")
public final class class2 extends class39 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1274859667
   )
   int field30 = -1;
   @ObfuscatedName("g")
   @Export("composition")
   class182 field31;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 392241571
   )
   int field32;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 819523527
   )
   int field33 = -1;
   @ObfuscatedName("o")
   @Export("model")
   class108 field36;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 141852359
   )
   @Export("combatLevel")
   int field37;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2035540803
   )
   int field38;
   @ObfuscatedName("v")
   boolean field39;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -555241161
   )
   int field40;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1383654013
   )
   int field41;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 270967865
   )
   int field42;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 609066455
   )
   @Export("totalLevel")
   int field43;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1689323681
   )
   @Export("team")
   int field44;
   @ObfuscatedName("a")
   boolean field45;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 301986747
   )
   int field46;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 743291311
   )
   int field47;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1972707463
   )
   int field48;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1512373433
   )
   int field49;
   @ObfuscatedName("s")
   @Export("actions")
   String[] field50 = new String[3];
   @ObfuscatedName("x")
   boolean field51;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -660823467
   )
   int field52;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1061991469
   )
   int field53;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1689800831
   )
   int field54;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -721741739
   )
   int field55;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 751539513
   )
   int field56;
   @ObfuscatedName("ej")
   static class81[] field57;
   @ObfuscatedName("l")
   @Export("name")
   String field58;

   class2() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.field50[var1] = "";
      }

      this.field37 = 0;
      this.field54 = 0;
      this.field43 = 0;
      this.field40 = 0;
      this.field39 = false;
      this.field44 = 0;
      this.field51 = false;
      this.field45 = false;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1896549502"
   )
   int method15() {
      return this.field31 != null && this.field31.field2972 != -1?class16.method202(this.field31.field2972).field913:1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lclass108;",
      garbageValue = "503322838"
   )
   protected final class108 vmethod1990() {
      if(this.field31 == null) {
         return null;
      } else {
         class44 var1 = super.field863 != -1 && super.field864 == 0?class22.method585(super.field863):null;
         class44 var2 = super.field860 == -1 || this.field39 || super.field838 == super.field860 && var1 != null?null:class22.method585(super.field860);
         class108 var3 = this.field31.method3667(var1, super.field836, var2, super.field861);
         if(var3 == null) {
            return null;
         } else {
            var3.method2402();
            super.field837 = var3.field1538;
            class108 var4;
            class108[] var5;
            if(!this.field39 && super.field868 != -1 && super.field890 != -1) {
               var4 = class110.method2488(super.field868).method952(super.field890);
               if(var4 != null) {
                  var4.method2412(0, -super.field872, 0);
                  var5 = new class108[]{var3, var4};
                  var3 = new class108(var5, 2);
               }
            }

            if(!this.field39 && null != this.field36) {
               if(client.field305 >= this.field40) {
                  this.field36 = null;
               }

               if(client.field305 >= this.field43 && client.field305 < this.field40) {
                  var4 = this.field36;
                  var4.method2412(this.field41 - super.field875, this.field42 - this.field38, this.field32 - super.field832);
                  if(super.field882 == 512) {
                     var4.method2455();
                     var4.method2455();
                     var4.method2455();
                  } else if(super.field882 == 1024) {
                     var4.method2455();
                     var4.method2455();
                  } else if(super.field882 == 1536) {
                     var4.method2455();
                  }

                  var5 = new class108[]{var3, var4};
                  var3 = new class108(var5, 2);
                  if(super.field882 == 512) {
                     var4.method2455();
                  } else if(super.field882 == 1024) {
                     var4.method2455();
                     var4.method2455();
                  } else if(super.field882 == 1536) {
                     var4.method2455();
                     var4.method2455();
                     var4.method2455();
                  }

                  var4.method2412(super.field875 - this.field41, this.field38 - this.field42, super.field832 - this.field32);
               }
            }

            var3.field1892 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "256653882"
   )
   final void method18(int var1, int var2, byte var3) {
      if(super.field863 != -1 && class22.method585(super.field863).field1028 == 1) {
         super.field863 = -1;
      }

      super.field859 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.field886[0] >= 0 && super.field886[0] < 104 && super.field887[0] >= 0 && super.field887[0] < 104) {
            if(var3 == 2) {
               class2 var4 = this;
               int var5 = super.field886[0];
               int var6 = super.field887[0];
               int var7 = this.method15();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var8 = class45.method967(var5, var6, this.method15(), class164.method3333(var1, var2), client.field354[this.field52], true, client.field574, client.field575);
                  if(var8 >= 1) {
                     for(int var9 = 0; var9 < var8 - 1; ++var9) {
                        var4.method20(client.field574[var9], client.field575[var9], (byte)2);
                     }
                  }
               }
            }

            this.method20(var1, var2, var3);
         } else {
            this.method19(var1, var2);
         }
      } else {
         this.method19(var1, var2);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1575812819"
   )
   void method19(int var1, int var2) {
      super.field849 = 0;
      super.field839 = 0;
      super.field889 = 0;
      super.field886[0] = var1;
      super.field887[0] = var2;
      int var3 = this.method15();
      super.field875 = 64 * var3 + super.field886[0] * 128;
      super.field832 = 128 * super.field887[0] + var3 * 64;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIBS)V",
      garbageValue = "502"
   )
   final void method20(int var1, int var2, byte var3) {
      if(super.field849 < 9) {
         ++super.field849;
      }

      for(int var4 = super.field849; var4 > 0; --var4) {
         super.field886[var4] = super.field886[var4 - 1];
         super.field887[var4] = super.field887[var4 - 1];
         super.field888[var4] = super.field888[var4 - 1];
      }

      super.field886[0] = var1;
      super.field887[0] = var2;
      super.field888[0] = var3;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-26697968"
   )
   static void method28(byte[] var0) {
      class122 var1 = new class122(var0);
      var1.field2050 = var0.length - 2;
      class79.field1466 = var1.method2635();
      class79.field1457 = new int[class79.field1466];
      class180.field2962 = new int[class79.field1466];
      class192.field3106 = new int[class79.field1466];
      class79.field1458 = new int[class79.field1466];
      class145.field2236 = new byte[class79.field1466][];
      var1.field2050 = var0.length - 7 - class79.field1466 * 8;
      class79.field1454 = var1.method2635();
      class79.field1456 = var1.method2635();
      int var2 = (var1.method2633() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class79.field1466; ++var3) {
         class79.field1457[var3] = var1.method2635();
      }

      for(var3 = 0; var3 < class79.field1466; ++var3) {
         class180.field2962[var3] = var1.method2635();
      }

      for(var3 = 0; var3 < class79.field1466; ++var3) {
         class192.field3106[var3] = var1.method2635();
      }

      for(var3 = 0; var3 < class79.field1466; ++var3) {
         class79.field1458[var3] = var1.method2635();
      }

      var1.field2050 = var0.length - 7 - class79.field1466 * 8 - (var2 - 1) * 3;
      class79.field1459 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class79.field1459[var3] = var1.method2637();
         if(class79.field1459[var3] == 0) {
            class79.field1459[var3] = 1;
         }
      }

      var1.field2050 = 0;

      for(var3 = 0; var3 < class79.field1466; ++var3) {
         int var4 = class192.field3106[var3];
         int var5 = class79.field1458[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         class145.field2236[var3] = var7;
         int var8 = var1.method2633();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.method2634();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var10 * var4] = var1.method2634();
               }
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "8"
   )
   final void method29(class122 var1) {
      var1.field2050 = 0;
      int var2 = var1.method2633();
      this.field30 = var1.method2634();
      this.field33 = var1.method2634();
      int var3 = -1;
      this.field44 = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var9 = 0; var9 < 12; ++var9) {
         var6 = var1.method2633();
         if(var6 == 0) {
            var4[var9] = 0;
         } else {
            var7 = var1.method2633();
            var4[var9] = (var6 << 8) + var7;
            if(var9 == 0 && var4[0] == '\uffff') {
               var3 = var1.method2635();
               break;
            }

            if(var4[var9] >= 512) {
               int var8 = class1.method14(var4[var9] - 512).field1189;
               if(var8 != 0) {
                  this.field44 = var8;
               }
            }
         }
      }

      int[] var5 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.method2633();
         if(var7 < 0 || var7 >= class175.field2794[var6].length) {
            var7 = 0;
         }

         var5[var6] = var7;
      }

      super.field838 = var1.method2635();
      if(super.field838 == '\uffff') {
         super.field838 = -1;
      }

      super.field866 = var1.method2635();
      if(super.field866 == '\uffff') {
         super.field866 = -1;
      }

      super.field853 = super.field866;
      super.field879 = var1.method2635();
      if(super.field879 == '\uffff') {
         super.field879 = -1;
      }

      super.field840 = var1.method2635();
      if(super.field840 == '\uffff') {
         super.field840 = -1;
      }

      super.field841 = var1.method2635();
      if(super.field841 == '\uffff') {
         super.field841 = -1;
      }

      super.field831 = var1.method2635();
      if(super.field831 == '\uffff') {
         super.field831 = -1;
      }

      super.field843 = var1.method2635();
      if(super.field843 == '\uffff') {
         super.field843 = -1;
      }

      this.field58 = var1.method2663();
      if(class3.field65 == this) {
         class151.field2287 = this.field58;
      }

      this.field37 = var1.method2633();
      this.field54 = var1.method2635();
      this.field51 = var1.method2633() == 1;
      if(client.field297 == 0 && client.field460 >= 2) {
         this.field51 = false;
      }

      if(null == this.field31) {
         this.field31 = new class182();
      }

      this.field31.method3634(var4, var5, var2 == 1, var3);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1252680142"
   )
   @Export("xteaChanged")
   static final void method33(boolean var0) {
      client.field355 = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!client.field355) {
         var1 = client.field339.method2635();
         var2 = client.field339.method2749();
         var3 = client.field339.method2635();
         class101.field1747 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class101.field1747[var4][var5] = client.field339.method2620();
            }
         }

         class7.field135 = new int[var3];
         class119.field2037 = new int[var3];
         class3.field66 = new int[var3];
         class127.field2086 = new byte[var3][];
         class109.field1944 = new byte[var3][];
         boolean var13 = false;
         if((var2 / 8 == 48 || var2 / 8 == 49) && var1 / 8 == 48) {
            var13 = true;
         }

         if(var2 / 8 == 48 && var1 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var2 - 6) / 8; var5 <= (6 + var2) / 8; ++var5) {
            for(var6 = (var1 - 6) / 8; var6 <= (var1 + 6) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var13 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class7.field135[var3] = var7;
                  class119.field2037[var3] = class80.field1476.method3410("m" + var5 + "_" + var6);
                  class3.field66[var3] = class80.field1476.method3410("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class92.method2161(var2, var1);
      } else {
         var1 = client.field339.method2749();
         var2 = client.field339.method2803();
         var3 = client.field339.method2635();
         client.field339.method2899();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field339.method2907(1);
                  if(var7 == 1) {
                     client.field356[var4][var5][var6] = client.field339.method2907(26);
                  } else {
                     client.field356[var4][var5][var6] = -1;
                  }
               }
            }
         }

         client.field339.method2900();
         class101.field1747 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class101.field1747[var4][var5] = client.field339.method2620();
            }
         }

         class7.field135 = new int[var3];
         class119.field2037 = new int[var3];
         class3.field66 = new int[var3];
         class127.field2086 = new byte[var3][];
         class109.field1944 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field356[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = (var8 / 8 << 8) + var9 / 8;

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(var10 == class7.field135[var11]) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        class7.field135[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class119.field2037[var3] = class80.field1476.method3410("m" + var11 + "_" + var12);
                        class3.field66[var3] = class80.field1476.method3410("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class92.method2161(var2, var1);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "76"
   )
   final boolean vmethod794() {
      return null != this.field31;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "417329951"
   )
   @Export("loadWorlds")
   static boolean method38() {
      try {
         if(null == class117.field2027) {
            class117.field2027 = new class18(class125.field2070, new URL(class15.field223));
         } else {
            byte[] var0 = class117.field2027.method212();
            if(var0 != null) {
               class122 var1 = new class122(var0);
               class27.field663 = var1.method2635();
               class27.field662 = new class27[class27.field663];

               class27 var3;
               for(int var2 = 0; var2 < class27.field663; var3.field673 = var2++) {
                  var3 = class27.field662[var2] = new class27();
                  var3.field667 = var1.method2635();
                  var3.field668 = var1.method2620();
                  var3.field670 = var1.method2663();
                  var3.field680 = var1.method2663();
                  var3.field672 = var1.method2633();
                  var3.field669 = var1.method2636();
               }

               class9.method133(class27.field662, 0, class27.field662.length - 1, class27.field666, class27.field665);
               class117.field2027 = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class117.field2027 = null;
      }

      return false;
   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(Lclass176;B)I",
      garbageValue = "55"
   )
   static int method39(class176 var0) {
      class204 var1 = (class204)client.field435.method3936((long)var0.field2813 + ((long)var0.field2807 << 32));
      return null != var1?var1.field3159:var0.field2872;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-767246248"
   )
   public static int method41() {
      return class140.field2182;
   }
}
