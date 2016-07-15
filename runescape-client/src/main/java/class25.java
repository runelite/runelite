import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
@Implements("XClanMember")
public class class25 extends class211 {
   @ObfuscatedName("e")
   @Export("username")
   String field646;
   @ObfuscatedName("l")
   String field647;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1902525489
   )
   @Export("world")
   int field648;
   @ObfuscatedName("h")
   @Export("rank")
   byte field649;
   @ObfuscatedName("g")
   static String field650;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Lclass43;",
      garbageValue = "1006303736"
   )
   public static class43 method583(int var0) {
      class43 var1 = (class43)class43.field1008.method3834((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class43.field1012.method3340(1, var0);
         var1 = new class43();
         if(var2 != null) {
            var1.method891(new class122(var2), var0);
         }

         var1.method890();
         class43.field1008.method3836(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2010116468"
   )
   static final void method584() {
      short var0 = 256;
      int var1;
      if(class33.field769 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class33.field769 > 768) {
               class110.field1954[var1] = class79.method1737(class79.field1456[var1], class33.field785[var1], 1024 - class33.field769);
            } else if(class33.field769 > 256) {
               class110.field1954[var1] = class33.field785[var1];
            } else {
               class110.field1954[var1] = class79.method1737(class33.field785[var1], class79.field1456[var1], 256 - class33.field769);
            }
         }
      } else if(class33.field783 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class33.field783 > 768) {
               class110.field1954[var1] = class79.method1737(class79.field1456[var1], class101.field1744[var1], 1024 - class33.field783);
            } else if(class33.field783 > 256) {
               class110.field1954[var1] = class101.field1744[var1];
            } else {
               class110.field1954[var1] = class79.method1737(class101.field1744[var1], class79.field1456[var1], 256 - class33.field783);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class110.field1954[var1] = class79.field1456[var1];
         }
      }

      class82.method1934(class33.field758, 9, 128 + class33.field758, 7 + var0);
      class33.field761.method1800(class33.field758, 0);
      class82.method1882();
      var1 = 0;
      int var2 = class33.field758 + class44.field1039.field1459 * 9;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = (var0 - var3) * class33.field767[var3] / var0;
         var5 = 22 + var4;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class33.field771[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class110.field1954[var7];
               var10 = class44.field1039.field1464[var2];
               class44.field1039.field1464[var2++] = ((var10 & '\uff00') * var9 + (var7 & '\uff00') * var8 & 16711680) + (var8 * (var7 & 16711935) + (var10 & 16711935) * var9 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + class44.field1039.field1459 - 128;
      }

      class82.method1934(765 + class33.field758 - 128, 9, class33.field758 + 765, var0 + 7);
      class8.field151.method1800(382 + class33.field758, 0);
      class82.method1882();
      var1 = 0;
      var2 = 637 + class44.field1039.field1459 * 9 + 24 + class33.field758;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class33.field767[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class33.field771[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class110.field1954[var7];
               var10 = class44.field1039.field1464[var2];
               class44.field1039.field1464[var2++] = ((var7 & 16711935) * var8 + (var10 & 16711935) * var9 & -16711936) + (var8 * (var7 & '\uff00') + var9 * (var10 & '\uff00') & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += class44.field1039.field1459 - var5 - var4;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([Lclass115;II)Lclass115;",
      garbageValue = "2108342429"
   )
   public static class115 method585(class115[] var0, int var1) {
      class115[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class115 var4 = var2[var3];
         if(var1 == var4.vmethod3262()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1975454813"
   )
   @Export("sendGameMessage")
   static void method586(int var0, String var1, String var2) {
      class78.method1710(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-1314679573"
   )
   @Export("menuAction")
   static final void method587(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      class36 var8;
      if(var2 == 1003) {
         client.field491 = var6;
         client.field547 = var7;
         client.field406 = 2;
         client.field405 = 0;
         var8 = client.field331[var3];
         if(null != var8) {
            class41 var9 = var8.field825;
            if(var9.field948 != null) {
               var9 = var9.method824();
            }

            if(null != var9) {
               client.field336.method2854(173);
               client.field336.method2637(var9.field922);
            }
         }
      }

      if(var2 == 35) {
         client.field336.method2854(115);
         client.field336.method2598(var1);
         client.field336.method2642(var3);
         client.field336.method2781(var0);
         client.field578 = 0;
         class9.field160 = class19.method212(var1);
         client.field555 = var0;
      }

      if(var2 == 39) {
         client.field336.method2854(97);
         client.field336.method2781(var0);
         client.field336.method2598(var1);
         client.field336.method2642(var3);
         client.field578 = 0;
         class9.field160 = class19.method212(var1);
         client.field555 = var0;
      }

      class2 var11;
      if(var2 == 51) {
         var11 = client.field467[var3];
         if(null != var11) {
            client.field491 = var6;
            client.field547 = var7;
            client.field406 = 2;
            client.field405 = 0;
            client.field529 = var0;
            client.field530 = var1;
            client.field336.method2854(168);
            client.field336.method2732(var3);
            client.field336.method2795(class140.field2160[82]?1:0);
         }
      }

      if(var2 == 11) {
         var8 = client.field331[var3];
         if(null != var8) {
            client.field491 = var6;
            client.field547 = var7;
            client.field406 = 2;
            client.field405 = 0;
            client.field529 = var0;
            client.field530 = var1;
            client.field336.method2854(218);
            client.field336.method2642(var3);
            client.field336.method2805(class140.field2160[82]?1:0);
         }
      }

      if(var2 == 44) {
         var11 = client.field467[var3];
         if(null != var11) {
            client.field491 = var6;
            client.field547 = var7;
            client.field406 = 2;
            client.field405 = 0;
            client.field529 = var0;
            client.field530 = var1;
            client.field336.method2854(32);
            client.field336.method2795(class140.field2160[82]?1:0);
            client.field336.method2781(var3);
         }
      }

      if(var2 == 4) {
         client.field491 = var6;
         client.field547 = var7;
         client.field406 = 2;
         client.field405 = 0;
         client.field529 = var0;
         client.field530 = var1;
         client.field336.method2854(244);
         client.field336.method2635(class140.field2160[82]?1:0);
         client.field336.method2732(var3 >> 14 & 32767);
         client.field336.method2642(class19.field286 + var0);
         client.field336.method2642(class6.field128 + var1);
      }

      if(var2 == 8) {
         var8 = client.field331[var3];
         if(var8 != null) {
            client.field491 = var6;
            client.field547 = var7;
            client.field406 = 2;
            client.field405 = 0;
            client.field529 = var0;
            client.field530 = var1;
            client.field336.method2854(39);
            client.field336.method2637(client.field450);
            client.field336.method2795(class140.field2160[82]?1:0);
            client.field336.method2742(client.field344);
            client.field336.method2637(var3);
         }
      }

      if(var2 == 46) {
         var11 = client.field467[var3];
         if(null != var11) {
            client.field491 = var6;
            client.field547 = var7;
            client.field406 = 2;
            client.field405 = 0;
            client.field529 = var0;
            client.field530 = var1;
            client.field336.method2854(69);
            client.field336.method2807(class140.field2160[82]?1:0);
            client.field336.method2732(var3);
         }
      }

      if(var2 == 1002) {
         client.field491 = var6;
         client.field547 = var7;
         client.field406 = 2;
         client.field405 = 0;
         client.field336.method2854(175);
         client.field336.method2781(var3 >> 14 & 32767);
      }

      if(var2 == 3) {
         client.field491 = var6;
         client.field547 = var7;
         client.field406 = 2;
         client.field405 = 0;
         client.field529 = var0;
         client.field530 = var1;
         client.field336.method2854(92);
         client.field336.method2732(var0 + class19.field286);
         client.field336.method2642(class6.field128 + var1);
         client.field336.method2781(var3 >> 14 & 32767);
         client.field336.method2807(class140.field2160[82]?1:0);
      }

      if(var2 == 17) {
         client.field491 = var6;
         client.field547 = var7;
         client.field406 = 2;
         client.field405 = 0;
         client.field529 = var0;
         client.field530 = var1;
         client.field336.method2854(225);
         client.field336.method2642(var3);
         client.field336.method2732(var1 + class6.field128);
         client.field336.method2642(client.field450);
         client.field336.method2637(var0 + class19.field286);
         client.field336.method2598(client.field344);
         client.field336.method2807(class140.field2160[82]?1:0);
      }

      if(var2 == 50) {
         var11 = client.field467[var3];
         if(var11 != null) {
            client.field491 = var6;
            client.field547 = var7;
            client.field406 = 2;
            client.field405 = 0;
            client.field529 = var0;
            client.field530 = var1;
            client.field336.method2854(162);
            client.field336.method2635(class140.field2160[82]?1:0);
            client.field336.method2781(var3);
         }
      }

      class176 var12;
      if(var2 == 38) {
         class34.method735();
         var12 = class19.method212(var1);
         client.field459 = 1;
         class6.field124 = var0;
         class93.field1624 = var1;
         class1.field28 = var3;
         class51.method1124(var12);
         client.field447 = class117.method2530(16748608) + class9.method108(var3).field1183 + class117.method2530(16777215);
         if(client.field447 == null) {
            client.field447 = "null";
         }

      } else {
         if(var2 == 10) {
            var8 = client.field331[var3];
            if(var8 != null) {
               client.field491 = var6;
               client.field547 = var7;
               client.field406 = 2;
               client.field405 = 0;
               client.field529 = var0;
               client.field530 = var1;
               client.field336.method2854(163);
               client.field336.method2637(var3);
               client.field336.method2795(class140.field2160[82]?1:0);
            }
         }

         if(var2 == 14) {
            var11 = client.field467[var3];
            if(var11 != null) {
               client.field491 = var6;
               client.field547 = var7;
               client.field406 = 2;
               client.field405 = 0;
               client.field529 = var0;
               client.field530 = var1;
               client.field336.method2854(140);
               client.field336.method2742(class93.field1624);
               client.field336.method2642(var3);
               client.field336.method2637(class1.field28);
               client.field336.method2635(class140.field2160[82]?1:0);
               client.field336.method2637(class6.field124);
            }
         }

         if(var2 == 6) {
            client.field491 = var6;
            client.field547 = var7;
            client.field406 = 2;
            client.field405 = 0;
            client.field529 = var0;
            client.field530 = var1;
            client.field336.method2854(145);
            client.field336.method2642(class6.field128 + var1);
            client.field336.method2795(class140.field2160[82]?1:0);
            client.field336.method2642(var3 >> 14 & 32767);
            client.field336.method2642(class19.field286 + var0);
         }

         if(var2 == 1005) {
            var12 = class19.method212(var1);
            if(var12 != null && var12.field2809[var0] >= 100000) {
               method586(27, "", var12.field2809[var0] + " x " + class9.method108(var3).field1183);
            } else {
               client.field336.method2854(76);
               client.field336.method2637(var3);
            }

            client.field578 = 0;
            class9.field160 = class19.method212(var1);
            client.field555 = var0;
         }

         if(var2 == 48) {
            var11 = client.field467[var3];
            if(var11 != null) {
               client.field491 = var6;
               client.field547 = var7;
               client.field406 = 2;
               client.field405 = 0;
               client.field529 = var0;
               client.field530 = var1;
               client.field336.method2854(221);
               client.field336.method2781(var3);
               client.field336.method2795(class140.field2160[82]?1:0);
            }
         }

         if(var2 == 7) {
            var8 = client.field331[var3];
            if(null != var8) {
               client.field491 = var6;
               client.field547 = var7;
               client.field406 = 2;
               client.field405 = 0;
               client.field529 = var0;
               client.field530 = var1;
               client.field336.method2854(255);
               client.field336.method2732(class6.field124);
               client.field336.method2795(class140.field2160[82]?1:0);
               client.field336.method2781(var3);
               client.field336.method2781(class1.field28);
               client.field336.method2652(class93.field1624);
            }
         }

         if(var2 == 34) {
            client.field336.method2854(62);
            client.field336.method2637(var3);
            client.field336.method2637(var0);
            client.field336.method2742(var1);
            client.field578 = 0;
            class9.field160 = class19.method212(var1);
            client.field555 = var0;
         }

         if(var2 == 31) {
            client.field336.method2854(100);
            client.field336.method2642(class6.field124);
            client.field336.method2642(var0);
            client.field336.method2732(var3);
            client.field336.method2642(class1.field28);
            client.field336.method2653(class93.field1624);
            client.field336.method2598(var1);
            client.field578 = 0;
            class9.field160 = class19.method212(var1);
            client.field555 = var0;
         }

         if(var2 == 18) {
            client.field491 = var6;
            client.field547 = var7;
            client.field406 = 2;
            client.field405 = 0;
            client.field529 = var0;
            client.field530 = var1;
            client.field336.method2854(4);
            client.field336.method2642(var0 + class19.field286);
            client.field336.method2642(var3);
            client.field336.method2637(var1 + class6.field128);
            client.field336.method2807(class140.field2160[82]?1:0);
         }

         if(var2 == 13) {
            var8 = client.field331[var3];
            if(var8 != null) {
               client.field491 = var6;
               client.field547 = var7;
               client.field406 = 2;
               client.field405 = 0;
               client.field529 = var0;
               client.field530 = var1;
               client.field336.method2854(50);
               client.field336.method2635(class140.field2160[82]?1:0);
               client.field336.method2642(var3);
            }
         }

         if(var2 == 36) {
            client.field336.method2854(125);
            client.field336.method2653(var1);
            client.field336.method2732(var0);
            client.field336.method2781(var3);
            client.field578 = 0;
            class9.field160 = class19.method212(var1);
            client.field555 = var0;
         }

         if(var2 == 37) {
            client.field336.method2854(29);
            client.field336.method2732(var3);
            client.field336.method2742(var1);
            client.field336.method2642(var0);
            client.field578 = 0;
            class9.field160 = class19.method212(var1);
            client.field555 = var0;
         }

         if(var2 == 49) {
            var11 = client.field467[var3];
            if(null != var11) {
               client.field491 = var6;
               client.field547 = var7;
               client.field406 = 2;
               client.field405 = 0;
               client.field529 = var0;
               client.field530 = var1;
               client.field336.method2854(136);
               client.field336.method2642(var3);
               client.field336.method2635(class140.field2160[82]?1:0);
            }
         }

         if(var2 == 1004) {
            client.field491 = var6;
            client.field547 = var7;
            client.field406 = 2;
            client.field405 = 0;
            client.field336.method2854(76);
            client.field336.method2637(var3);
         }

         if(var2 == 40) {
            client.field336.method2854(56);
            client.field336.method2781(var0);
            client.field336.method2653(var1);
            client.field336.method2781(var3);
            client.field578 = 0;
            class9.field160 = class19.method212(var1);
            client.field555 = var0;
         }

         if(var2 == 30 && null == client.field371) {
            client.field336.method2854(2);
            client.field336.method2732(var0);
            client.field336.method2742(var1);
            client.field371 = class93.method2180(var1, var0);
            class51.method1124(client.field371);
         }

         if(var2 == 24) {
            var12 = class19.method212(var1);
            boolean var10 = true;
            if(var12.field2916 > 0) {
               var10 = class47.method1024(var12);
            }

            if(var10) {
               client.field336.method2854(182);
               client.field336.method2598(var1);
            }
         }

         if(var2 == 32) {
            client.field336.method2854(142);
            client.field336.method2598(client.field344);
            client.field336.method2642(var3);
            client.field336.method2732(client.field450);
            client.field336.method2642(var0);
            client.field336.method2598(var1);
            client.field578 = 0;
            class9.field160 = class19.method212(var1);
            client.field555 = var0;
         }

         if(var2 == 5) {
            client.field491 = var6;
            client.field547 = var7;
            client.field406 = 2;
            client.field405 = 0;
            client.field529 = var0;
            client.field530 = var1;
            client.field336.method2854(117);
            client.field336.method2642(class6.field128 + var1);
            client.field336.method2637(var3 >> 14 & 32767);
            client.field336.method2807(class140.field2160[82]?1:0);
            client.field336.method2642(var0 + class19.field286);
         }

         if(var2 == 19) {
            client.field491 = var6;
            client.field547 = var7;
            client.field406 = 2;
            client.field405 = 0;
            client.field529 = var0;
            client.field530 = var1;
            client.field336.method2854(5);
            client.field336.method2642(var3);
            client.field336.method2781(var1 + class6.field128);
            client.field336.method2732(var0 + class19.field286);
            client.field336.method2635(class140.field2160[82]?1:0);
         }

         if(var2 == 43) {
            client.field336.method2854(103);
            client.field336.method2637(var3);
            client.field336.method2637(var0);
            client.field336.method2742(var1);
            client.field578 = 0;
            class9.field160 = class19.method212(var1);
            client.field555 = var0;
         }

         if(var2 == 9) {
            var8 = client.field331[var3];
            if(var8 != null) {
               client.field491 = var6;
               client.field547 = var7;
               client.field406 = 2;
               client.field405 = 0;
               client.field529 = var0;
               client.field530 = var1;
               client.field336.method2854(150);
               client.field336.method2805(class140.field2160[82]?1:0);
               client.field336.method2732(var3);
            }
         }

         if(var2 == 26) {
            class41.method836();
         }

         if(var2 == 12) {
            var8 = client.field331[var3];
            if(null != var8) {
               client.field491 = var6;
               client.field547 = var7;
               client.field406 = 2;
               client.field405 = 0;
               client.field529 = var0;
               client.field530 = var1;
               client.field336.method2854(169);
               client.field336.method2805(class140.field2160[82]?1:0);
               client.field336.method2642(var3);
            }
         }

         if(var2 == 16) {
            client.field491 = var6;
            client.field547 = var7;
            client.field406 = 2;
            client.field405 = 0;
            client.field529 = var0;
            client.field530 = var1;
            client.field336.method2854(155);
            client.field336.method2732(var3);
            client.field336.method2781(var0 + class19.field286);
            client.field336.method2642(class1.field28);
            client.field336.method2652(class93.field1624);
            client.field336.method2795(class140.field2160[82]?1:0);
            client.field336.method2637(class6.field124);
            client.field336.method2732(var1 + class6.field128);
         }

         if(var2 == 25) {
            var12 = class93.method2180(var1, var0);
            if(null != var12) {
               class34.method735();
               class109.method2460(var1, var0, class182.method3601(class27.method644(var12)), var12.field2914);
               client.field459 = 0;
               client.field452 = class52.method1133(var12);
               if(null == client.field452) {
                  client.field452 = "Null";
               }

               if(var12.field2793) {
                  client.field369 = var12.field2922 + class117.method2530(16777215);
               } else {
                  client.field369 = class117.method2530('\uff00') + var12.field2786 + class117.method2530(16777215);
               }
            }

         } else {
            int var13;
            if(var2 == 28) {
               client.field336.method2854(182);
               client.field336.method2598(var1);
               var12 = class19.method212(var1);
               if(var12.field2906 != null && var12.field2906[0][0] == 5) {
                  var13 = var12.field2906[0][1];
                  class179.field2944[var13] = 1 - class179.field2944[var13];
                  class118.method2536(var13);
               }
            }

            if(var2 == 41) {
               client.field336.method2854(193);
               client.field336.method2781(var3);
               client.field336.method2732(var0);
               client.field336.method2742(var1);
               client.field578 = 0;
               class9.field160 = class19.method212(var1);
               client.field555 = var0;
            }

            if(var2 == 22) {
               client.field491 = var6;
               client.field547 = var7;
               client.field406 = 2;
               client.field405 = 0;
               client.field529 = var0;
               client.field530 = var1;
               client.field336.method2854(172);
               client.field336.method2642(var3);
               client.field336.method2795(class140.field2160[82]?1:0);
               client.field336.method2781(class6.field128 + var1);
               client.field336.method2732(class19.field286 + var0);
            }

            if(var2 == 58) {
               var12 = class93.method2180(var1, var0);
               if(null != var12) {
                  client.field336.method2854(67);
                  client.field336.method2637(client.field451);
                  client.field336.method2781(client.field450);
                  client.field336.method2742(var1);
                  client.field336.method2652(client.field344);
                  client.field336.method2637(var12.field2914);
                  client.field336.method2732(var0);
               }
            }

            if(var2 == 29) {
               client.field336.method2854(182);
               client.field336.method2598(var1);
               var12 = class19.method212(var1);
               if(var12.field2906 != null && var12.field2906[0][0] == 5) {
                  var13 = var12.field2906[0][1];
                  if(class179.field2944[var13] != var12.field2908[0]) {
                     class179.field2944[var13] = var12.field2908[0];
                     class118.method2536(var13);
                  }
               }
            }

            if(var2 == 1001) {
               client.field491 = var6;
               client.field547 = var7;
               client.field406 = 2;
               client.field405 = 0;
               client.field529 = var0;
               client.field530 = var1;
               client.field336.method2854(127);
               client.field336.method2732(class19.field286 + var0);
               client.field336.method2795(class140.field2160[82]?1:0);
               client.field336.method2637(var3 >> 14 & 32767);
               client.field336.method2642(class6.field128 + var1);
            }

            if(var2 == 20) {
               client.field491 = var6;
               client.field547 = var7;
               client.field406 = 2;
               client.field405 = 0;
               client.field529 = var0;
               client.field530 = var1;
               client.field336.method2854(30);
               client.field336.method2642(var3);
               client.field336.method2795(class140.field2160[82]?1:0);
               client.field336.method2642(class19.field286 + var0);
               client.field336.method2642(class6.field128 + var1);
            }

            if(var2 == 1) {
               client.field491 = var6;
               client.field547 = var7;
               client.field406 = 2;
               client.field405 = 0;
               client.field529 = var0;
               client.field530 = var1;
               client.field336.method2854(51);
               client.field336.method2732(class1.field28);
               client.field336.method2653(class93.field1624);
               client.field336.method2807(class140.field2160[82]?1:0);
               client.field336.method2637(var0 + class19.field286);
               client.field336.method2642(class6.field124);
               client.field336.method2637(var1 + class6.field128);
               client.field336.method2781(var3 >> 14 & 32767);
            }

            if(var2 == 23) {
               class79.field1453.method2046(class50.field1119, var0, var1);
            }

            if(var2 == 21) {
               client.field491 = var6;
               client.field547 = var7;
               client.field406 = 2;
               client.field405 = 0;
               client.field529 = var0;
               client.field530 = var1;
               client.field336.method2854(24);
               client.field336.method2642(class6.field128 + var1);
               client.field336.method2805(class140.field2160[82]?1:0);
               client.field336.method2637(var0 + class19.field286);
               client.field336.method2642(var3);
            }

            if(var2 == 42) {
               client.field336.method2854(153);
               client.field336.method2598(var1);
               client.field336.method2637(var3);
               client.field336.method2732(var0);
               client.field578 = 0;
               class9.field160 = class19.method212(var1);
               client.field555 = var0;
            }

            if(var2 == 47) {
               var11 = client.field467[var3];
               if(null != var11) {
                  client.field491 = var6;
                  client.field547 = var7;
                  client.field406 = 2;
                  client.field405 = 0;
                  client.field529 = var0;
                  client.field530 = var1;
                  client.field336.method2854(222);
                  client.field336.method2635(class140.field2160[82]?1:0);
                  client.field336.method2781(var3);
               }
            }

            if(var2 == 15) {
               var11 = client.field467[var3];
               if(null != var11) {
                  client.field491 = var6;
                  client.field547 = var7;
                  client.field406 = 2;
                  client.field405 = 0;
                  client.field529 = var0;
                  client.field530 = var1;
                  client.field336.method2854(27);
                  client.field336.method2598(client.field344);
                  client.field336.method2805(class140.field2160[82]?1:0);
                  client.field336.method2732(client.field450);
                  client.field336.method2637(var3);
               }
            }

            if(var2 == 45) {
               var11 = client.field467[var3];
               if(var11 != null) {
                  client.field491 = var6;
                  client.field547 = var7;
                  client.field406 = 2;
                  client.field405 = 0;
                  client.field529 = var0;
                  client.field530 = var1;
                  client.field336.method2854(104);
                  client.field336.method2795(class140.field2160[82]?1:0);
                  client.field336.method2781(var3);
               }
            }

            if(var2 == 33) {
               client.field336.method2854(151);
               client.field336.method2637(var3);
               client.field336.method2781(var0);
               client.field336.method2598(var1);
               client.field578 = 0;
               class9.field160 = class19.method212(var1);
               client.field555 = var0;
            }

            if(var2 == 2) {
               client.field491 = var6;
               client.field547 = var7;
               client.field406 = 2;
               client.field405 = 0;
               client.field529 = var0;
               client.field530 = var1;
               client.field336.method2854(217);
               client.field336.method2781(var3 >> 14 & 32767);
               client.field336.method2635(class140.field2160[82]?1:0);
               client.field336.method2653(client.field344);
               client.field336.method2637(client.field450);
               client.field336.method2781(class6.field128 + var1);
               client.field336.method2642(var0 + class19.field286);
            }

            if(var2 == 57 || var2 == 1007) {
               var12 = class93.method2180(var1, var0);
               if(var12 != null) {
                  class56.method1236(var3, var1, var0, var12.field2914, var5);
               }
            }

            if(client.field459 != 0) {
               client.field459 = 0;
               class51.method1124(class19.method212(class93.field1624));
            }

            if(client.field448) {
               class34.method735();
            }

            if(class9.field160 != null && client.field578 == 0) {
               class51.method1124(class9.field160);
            }

         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)[Lclass193;",
      garbageValue = "8"
   )
   public static class193[] method588() {
      return new class193[]{class193.field3113, class193.field3100, class193.field3101, class193.field3109, class193.field3112, class193.field3103, class193.field3105, class193.field3102, class193.field3111, class193.field3110, class193.field3106, class193.field3104, class193.field3099, class193.field3107, class193.field3098};
   }
}
