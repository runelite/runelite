import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
@Implements("Sequence")
public class class44 extends class207 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1562702123
   )
   public int field1019 = -1;
   @ObfuscatedName("l")
   static class170 field1020;
   @ObfuscatedName("h")
   static class196 field1021 = new class196(64);
   @ObfuscatedName("r")
   static class196 field1022 = new class196(100);
   @ObfuscatedName("a")
   public int[] field1023;
   @ObfuscatedName("o")
   public int[] field1024;
   @ObfuscatedName("u")
   public int[] field1025;
   @ObfuscatedName("c")
   static class170 field1026;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2043294755
   )
   public int field1027 = -1;
   @ObfuscatedName("i")
   @Export("interleaveLeave")
   int[] field1028;
   @ObfuscatedName("q")
   @Export("stretches")
   public boolean field1029 = false;
   @ObfuscatedName("b")
   int[] field1030;
   @ObfuscatedName("e")
   static class170 field1031;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1479200069
   )
   public int field1032 = -1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1361104243
   )
   @Export("maxLoops")
   public int field1033 = 99;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 424107517
   )
   @Export("precedenceAnimating")
   public int field1034 = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 205690627
   )
   public int field1035 = -1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1777935343
   )
   @Export("replyMode")
   public int field1036 = 2;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 480331935
   )
   public int field1038 = 5;
   @ObfuscatedName("qg")
   @Export("bufferProvider")
   public static class80 field1039;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass122;IB)V",
      garbageValue = "21"
   )
   void method917(class122 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2612();
         this.field1025 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1025[var4] = var1.method2612();
         }

         this.field1023 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1023[var4] = var1.method2612();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1023[var4] += var1.method2612() << 16;
         }
      } else if(var2 == 2) {
         this.field1027 = var1.method2612();
      } else if(var2 == 3) {
         var3 = var1.method2610();
         this.field1028 = new int[var3 + 1];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1028[var4] = var1.method2610();
         }

         this.field1028[var3] = 9999999;
      } else if(var2 == 4) {
         this.field1029 = true;
      } else if(var2 == 5) {
         this.field1038 = var1.method2610();
      } else if(var2 == 6) {
         this.field1019 = var1.method2612();
      } else if(var2 == 7) {
         this.field1032 = var1.method2612();
      } else if(var2 == 8) {
         this.field1033 = var1.method2610();
      } else if(var2 == 9) {
         this.field1034 = var1.method2610();
      } else if(var2 == 10) {
         this.field1035 = var1.method2610();
      } else if(var2 == 11) {
         this.field1036 = var1.method2610();
      } else if(var2 == 12) {
         var3 = var1.method2610();
         this.field1030 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1030[var4] = var1.method2612();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1030[var4] += var1.method2612() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.method2610();
         this.field1024 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1024[var4] = var1.method2703();
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-439920584"
   )
   void method918() {
      if(this.field1034 == -1) {
         if(this.field1028 != null) {
            this.field1034 = 2;
         } else {
            this.field1034 = 0;
         }
      }

      if(this.field1035 == -1) {
         if(null != this.field1028) {
            this.field1035 = 2;
         } else {
            this.field1035 = 0;
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass108;IS)Lclass108;",
      garbageValue = "352"
   )
   public class108 method919(class108 var1, int var2) {
      var2 = this.field1023[var2];
      class106 var3 = class62.method1367(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method2452(true);
      } else {
         class108 var4 = var1.method2452(!var3.method2372(var2));
         var4.method2384(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass108;II)Lclass108;",
      garbageValue = "514529708"
   )
   class108 method921(class108 var1, int var2) {
      var2 = this.field1023[var2];
      class106 var3 = class62.method1367(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method2446(true);
      } else {
         class108 var4 = var1.method2446(!var3.method2372(var2));
         var4.method2384(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(Lclass176;IIB)V",
      garbageValue = "64"
   )
   static final void method922(class176 var0, int var1, int var2) {
      if(null == client.field492 && !client.field540) {
         if(var0 != null) {
            class176 var5 = var0;
            int var8 = class157.method3255(class27.method644(var0));
            class176 var4;
            int var7;
            if(var8 == 0) {
               var4 = null;
            } else {
               var7 = 0;

               while(true) {
                  if(var7 >= var8) {
                     var4 = var5;
                     break;
                  }

                  var5 = class19.method212(var5.field2813);
                  if(null == var5) {
                     var4 = null;
                     break;
                  }

                  ++var7;
               }
            }

            class176 var6 = var4;
            if(var4 == null) {
               var6 = var0.field2869;
            }

            if(null != var6) {
               client.field492 = var0;
               var5 = var0;
               var8 = class157.method3255(class27.method644(var0));
               if(var8 == 0) {
                  var4 = null;
               } else {
                  var7 = 0;

                  while(true) {
                     if(var7 >= var8) {
                        var4 = var5;
                        break;
                     }

                     var5 = class19.method212(var5.field2813);
                     if(var5 == null) {
                        var4 = null;
                        break;
                     }

                     ++var7;
                  }
               }

               var6 = var4;
               if(var4 == null) {
                  var6 = var0.field2869;
               }

               client.field403 = var6;
               client.field481 = var1;
               client.field470 = var2;
               client.field479 = 0;
               client.field424 = false;
               if(client.field435 > 0) {
                  class5.method73(client.field435 - 1);
               }

               return;
            }
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass108;II)Lclass108;",
      garbageValue = "459603350"
   )
   public class108 method923(class108 var1, int var2) {
      int var3 = this.field1023[var2];
      class106 var4 = class62.method1367(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method2452(true);
      } else {
         class106 var5 = null;
         int var6 = 0;
         if(null != this.field1030 && var2 < this.field1030.length) {
            var6 = this.field1030[var2];
            var5 = class62.method1367(var6 >> 16);
            var6 &= '\uffff';
         }

         class108 var7;
         if(null != var5 && var6 != '\uffff') {
            var7 = var1.method2452(!var4.method2372(var3) & !var5.method2372(var6));
            var7.method2384(var4, var3);
            var7.method2384(var5, var6);
            return var7;
         } else {
            var7 = var1.method2452(!var4.method2372(var3));
            var7.method2384(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass108;ILclass44;II)Lclass108;",
      garbageValue = "-1824374289"
   )
   public class108 method932(class108 var1, int var2, class44 var3, int var4) {
      var2 = this.field1023[var2];
      class106 var5 = class62.method1367(var2 >> 16);
      var2 &= '\uffff';
      if(null == var5) {
         return var3.method919(var1, var4);
      } else {
         var4 = var3.field1023[var4];
         class106 var6 = class62.method1367(var4 >> 16);
         var4 &= '\uffff';
         class108 var7;
         if(null == var6) {
            var7 = var1.method2452(!var5.method2372(var2));
            var7.method2384(var5, var2);
            return var7;
         } else {
            var7 = var1.method2452(!var5.method2372(var2) & !var6.method2372(var4));
            var7.method2385(var5, var2, var6, var4, this.field1028);
            return var7;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass108;IIB)Lclass108;",
      garbageValue = "0"
   )
   class108 method940(class108 var1, int var2, int var3) {
      var2 = this.field1023[var2];
      class106 var4 = class62.method1367(var2 >> 16);
      var2 &= '\uffff';
      if(null == var4) {
         return var1.method2452(true);
      } else {
         class108 var5 = var1.method2452(!var4.method2372(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2389();
         } else if(var3 == 2) {
            var5.method2388();
         } else if(var3 == 3) {
            var5.method2387();
         }

         var5.method2384(var4, var2);
         if(var3 == 1) {
            var5.method2387();
         } else if(var3 == 2) {
            var5.method2388();
         } else if(var3 == 3) {
            var5.method2389();
         }

         return var5;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "-66"
   )
   void method952(class122 var1) {
      while(true) {
         int var2 = var1.method2610();
         if(var2 == 0) {
            return;
         }

         this.method917(var1, var2);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIILclass42;II)V",
      garbageValue = "127034806"
   )
   static void method959(int var0, int var1, int var2, class42 var3, int var4) {
      class24 var5 = new class24();
      var5.field627 = var0;
      var5.field640 = var1 * 128;
      var5.field629 = var2 * 128;
      int var6 = var3.field959;
      int var7 = var3.field1000;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.field1000;
         var7 = var3.field959;
      }

      var5.field630 = (var1 + var6) * 128;
      var5.field631 = (var7 + var2) * 128;
      var5.field633 = var3.field1003;
      var5.field626 = var3.field1004 * 128;
      var5.field635 = var3.field1005;
      var5.field636 = var3.field975;
      var5.field637 = var3.field1007;
      if(var3.field969 != null) {
         var5.field632 = var3;
         var5.method582();
      }

      class24.field628.method3895(var5);
      if(var5.field637 != null) {
         var5.field638 = var5.field635 + (int)(Math.random() * (double)(var5.field636 - var5.field635));
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1551373052"
   )
   static final void method960(int var0, int var1, int var2, int var3) {
      client.field389 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class34.field804;
      int[] var7 = class34.field807;

      int var8;
      for(var8 = 0; var8 < var6 + client.field332; ++var8) {
         Object var9;
         if(var8 < var6) {
            var9 = client.field467[var7[var8]];
            if(client.field425 == var7[var8]) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var9 = client.field331[client.field333[var8 - var6]];
         }

         class132.method2938((class39)var9, var8, var0, var1, var2, var3);
      }

      if(var4) {
         class132.method2938(client.field467[client.field425], var5, var0, var1, var2, var3);
      }

      for(var8 = 0; var8 < client.field389; ++var8) {
         int var18 = client.field410[var8];
         int var10 = client.field392[var8];
         int var11 = client.field391[var8];
         int var12 = client.field393[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var14 = 0; var14 < var8; ++var14) {
               if(var10 + 2 > client.field392[var14] - client.field393[var14] && var10 - var12 < client.field392[var14] + 2 && var18 - var11 < client.field391[var14] + client.field410[var14] && var11 + var18 > client.field410[var14] - client.field391[var14] && client.field392[var14] - client.field393[var14] < var10) {
                  var10 = client.field392[var14] - client.field393[var14];
                  var13 = true;
               }
            }
         }

         client.field401 = client.field410[var8];
         client.field322 = client.field392[var8] = var10;
         String var19 = client.field398[var8];
         if(client.field456 == 0) {
            int var15 = 16776960;
            if(client.field480[var8] < 6) {
               var15 = client.field512[client.field480[var8]];
            }

            if(client.field480[var8] == 6) {
               var15 = client.field400 % 20 < 10?16711680:16776960;
            }

            if(client.field480[var8] == 7) {
               var15 = client.field400 % 20 < 10?255:'\uffff';
            }

            if(client.field480[var8] == 8) {
               var15 = client.field400 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(client.field480[var8] == 9) {
               var16 = 150 - client.field397[var8];
               if(var16 < 50) {
                  var15 = 16711680 + var16 * 1280;
               } else if(var16 < 100) {
                  var15 = 16776960 - 327680 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = '\uff00' + (var16 - 100) * 5;
               }
            }

            if(client.field480[var8] == 10) {
               var16 = 150 - client.field397[var8];
               if(var16 < 50) {
                  var15 = 5 * var16 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16711935 - 327680 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = 255 + 327680 * (var16 - 100) - (var16 - 100) * 5;
               }
            }

            if(client.field480[var8] == 11) {
               var16 = 150 - client.field397[var8];
               if(var16 < 50) {
                  var15 = 16777215 - 327685 * var16;
               } else if(var16 < 100) {
                  var15 = 327685 * (var16 - 50) + '\uff00';
               } else if(var16 < 150) {
                  var15 = 16777215 - 327680 * (var16 - 100);
               }
            }

            if(client.field453[var8] == 0) {
               class146.field2233.method4119(var19, client.field401 + var0, client.field322 + var1, var15, 0);
            }

            if(client.field453[var8] == 1) {
               class146.field2233.method4117(var19, client.field401 + var0, client.field322 + var1, var15, 0, client.field400);
            }

            if(client.field453[var8] == 2) {
               class146.field2233.method4118(var19, client.field401 + var0, var1 + client.field322, var15, 0, client.field400);
            }

            if(client.field453[var8] == 3) {
               class146.field2233.method4107(var19, client.field401 + var0, var1 + client.field322, var15, 0, client.field400, 150 - client.field397[var8]);
            }

            if(client.field453[var8] == 4) {
               var16 = (150 - client.field397[var8]) * (class146.field2233.method4179(var19) + 100) / 150;
               class82.method1884(var0 + client.field401 - 50, var1, 50 + var0 + client.field401, var3 + var1);
               class146.field2233.method4177(var19, 50 + client.field401 + var0 - var16, client.field322 + var1, var15, 0);
               class82.method1934(var0, var1, var0 + var2, var3 + var1);
            }

            if(client.field453[var8] == 5) {
               var16 = 150 - client.field397[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               class82.method1884(var0, var1 + client.field322 - class146.field2233.field3242 - 1, var0 + var2, var1 + client.field322 + 5);
               class146.field2233.method4119(var19, var0 + client.field401, var17 + client.field322 + var1, var15, 0);
               class82.method1934(var0, var1, var0 + var2, var1 + var3);
            }
         } else {
            class146.field2233.method4119(var19, var0 + client.field401, client.field322 + var1, 16776960, 0);
         }
      }

   }
}
