import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class0 extends class208 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 36100349
   )
   int field1;
   @ObfuscatedName("d")
   class173 field2;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1367838427
   )
   int field3;
   @ObfuscatedName("a")
   Object[] field4;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1675452687
   )
   int field5;
   @ObfuscatedName("r")
   class173 field6;
   @ObfuscatedName("w")
   boolean field8;
   @ObfuscatedName("m")
   String field9;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -573398773
   )
   int field10;
   @ObfuscatedName("ey")
   static class78[] field13;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1843229033
   )
   int field14;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1225047445
   )
   int field16;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;IZI)Lclass103;",
      garbageValue = "0"
   )
   public static class103 method0(class167 var0, class167 var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.method3368(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.method3432(var2, var5[var6]);
         if(var7 == null) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9 = var1.method3432(var8, 0);
            if(var9 == null) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new class103(var0, var1, var2, var3);
         } catch (Exception var10) {
            return null;
         }
      }
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "232572883"
   )
   static final void method1(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class16 var9 = null;

      for(class16 var10 = (class16)client.field426.method3926(); var10 != null; var10 = (class16)client.field426.method3902()) {
         if(var0 == var10.field242 && var10.field238 == var1 && var2 == var10.field243 && var10.field237 == var3) {
            var9 = var10;
            break;
         }
      }

      if(null == var9) {
         var9 = new class16();
         var9.field242 = var0;
         var9.field237 = var3;
         var9.field238 = var1;
         var9.field243 = var2;
         class106.method2478(var9);
         client.field426.method3900(var9);
      }

      var9.field241 = var4;
      var9.field250 = var5;
      var9.field244 = var6;
      var9.field239 = var7;
      var9.field247 = var8;
   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "127"
   )
   static final void method2(int var0) {
      class39.method871();
      method5();
      int var1 = class43.method1009(var0).field1171;
      if(0 != var1) {
         int var2 = class176.field2905[var0];
         if(var1 == 1) {
            if(1 == var2) {
               class91.method2174(0.9D);
               ((class95)class91.field1575).method2261(0.9D);
            }

            if(var2 == 2) {
               class91.method2174(0.8D);
               ((class95)class91.field1575).method2261(0.8D);
            }

            if(3 == var2) {
               class91.method2174(0.7D);
               ((class95)class91.field1575).method2261(0.7D);
            }

            if(var2 == 4) {
               class91.method2174(0.6D);
               ((class95)class91.field1575).method2261(0.6D);
            }

            class51.field1146.method3843();
         }

         if(var1 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(2 == var2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(4 == var2) {
               var3 = 0;
            }

            if(var3 != client.field531) {
               if(0 == client.field531 && client.field532 != -1) {
                  class144.method3157(class38.field884, client.field532, 0, var3, false);
                  client.field299 = false;
               } else if(0 == var3) {
                  class9.method163();
                  client.field299 = false;
               } else {
                  class74.method1702(var3);
               }

               client.field531 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               client.field466 = 127;
            }

            if(1 == var2) {
               client.field466 = 96;
            }

            if(2 == var2) {
               client.field466 = 64;
            }

            if(var2 == 3) {
               client.field466 = 32;
            }

            if(4 == var2) {
               client.field466 = 0;
            }
         }

         if(var1 == 5) {
            client.field432 = var2;
         }

         if(6 == var1) {
            client.field454 = var2;
         }

         if(9 == var1) {
            client.field455 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               client.field514 = 127;
            }

            if(var2 == 1) {
               client.field514 = 96;
            }

            if(var2 == 2) {
               client.field514 = 64;
            }

            if(3 == var2) {
               client.field514 = 32;
            }

            if(var2 == 4) {
               client.field514 = 0;
            }
         }

         if(var1 == 17) {
            client.field460 = var2 & '\uffff';
         }

         if(18 == var1) {
            client.field322 = (class20)class125.method2926(class37.method844(), var2);
            if(null == client.field322) {
               client.field322 = class20.field587;
            }
         }

         if(var1 == 19) {
            if(-1 == var2) {
               client.field424 = -1;
            } else {
               client.field424 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            client.field508 = (class20)class125.method2926(class37.method844(), var2);
            if(client.field508 == null) {
               client.field508 = class20.field587;
            }
         }

      }
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   static final void method3() {
      boolean var0 = false;

      int var1;
      int var4;
      while(!var0) {
         var0 = true;

         for(var1 = 0; var1 < client.field434 - 1; ++var1) {
            if(client.field437[var1] < 1000 && client.field437[1 + var1] > 1000) {
               String var2 = client.field440[var1];
               client.field440[var1] = client.field440[1 + var1];
               client.field440[var1 + 1] = var2;
               String var3 = client.field439[var1];
               client.field439[var1] = client.field439[var1 + 1];
               client.field439[var1 + 1] = var3;
               var4 = client.field437[var1];
               client.field437[var1] = client.field437[1 + var1];
               client.field437[1 + var1] = var4;
               var4 = client.field435[var1];
               client.field435[var1] = client.field435[var1 + 1];
               client.field435[var1 + 1] = var4;
               var4 = client.field525[var1];
               client.field525[var1] = client.field525[var1 + 1];
               client.field525[1 + var1] = var4;
               var4 = client.field500[var1];
               client.field500[var1] = client.field500[var1 + 1];
               client.field500[1 + var1] = var4;
               var0 = false;
            }
         }
      }

      if(null == class3.field65) {
         if(null == client.field465) {
            int var10;
            int var11;
            label315: {
               int var9 = class140.field2157;
               int var6;
               int var8;
               if(client.field433) {
                  if(var9 != 1 && (class7.field143 || var9 != 4)) {
                     var1 = class140.field2151;
                     var10 = class140.field2161;
                     if(var1 < class2.field59 - 10 || var1 > 10 + class2.field59 + class42.field996 || var10 < class72.field1355 - 10 || var10 > 10 + class3.field69 + class72.field1355) {
                        client.field433 = false;
                        class31.method756(class2.field59, class72.field1355, class42.field996, class3.field69);
                     }
                  }

                  if(var9 == 1 || !class7.field143 && 4 == var9) {
                     var1 = class2.field59;
                     var10 = class72.field1355;
                     var11 = class42.field996;
                     var4 = class140.field2160;
                     int var12 = class140.field2159;
                     var6 = -1;

                     for(int var14 = 0; var14 < client.field434; ++var14) {
                        var8 = 15 * (client.field434 - 1 - var14) + 31 + var10;
                        if(var4 > var1 && var4 < var1 + var11 && var12 > var8 - 13 && var12 < 3 + var8) {
                           var6 = var14;
                        }
                     }

                     if(var6 != -1) {
                        class186.method3809(var6);
                     }

                     client.field433 = false;
                     class31.method756(class2.field59, class72.field1355, class42.field996, class3.field69);
                  }
               } else {
                  if((1 == var9 || !class7.field143 && 4 == var9) && client.field434 > 0) {
                     var1 = client.field437[client.field434 - 1];
                     if(var1 == 39 || var1 == 40 || 41 == var1 || var1 == 42 || var1 == 43 || var1 == 33 || var1 == 34 || 35 == var1 || 36 == var1 || var1 == 37 || 38 == var1 || var1 == 1005) {
                        var10 = client.field435[client.field434 - 1];
                        var11 = client.field525[client.field434 - 1];
                        class173 var13 = class20.method641(var11);
                        var6 = class31.method776(var13);
                        boolean var5 = (var6 >> 28 & 1) != 0;
                        if(var5) {
                           break label315;
                        }

                        var8 = class31.method776(var13);
                        boolean var7 = 0 != (var8 >> 29 & 1);
                        if(var7) {
                           break label315;
                        }
                     }
                  }

                  if((var9 == 1 || !class7.field143 && 4 == var9) && (1 == client.field432 && client.field434 > 2 || class17.method220(client.field434 - 1))) {
                     var9 = 2;
                  }

                  if((var9 == 1 || !class7.field143 && var9 == 4) && client.field434 > 0) {
                     class186.method3809(client.field434 - 1);
                  }

                  if(2 == var9 && client.field434 > 0) {
                     class10.method171(class140.field2160, class140.field2159);
                  }
               }

               return;
            }

            if(class3.field65 != null && !client.field412 && 1 != client.field432 && !class17.method220(client.field434 - 1) && client.field434 > 0) {
               class5.method113(client.field414, client.field377);
            }

            client.field412 = false;
            client.field413 = 0;
            if(null != class3.field65) {
               class23.method657(class3.field65);
            }

            class3.field65 = class20.method641(var11);
            client.field408 = var10;
            client.field414 = class140.field2160;
            client.field377 = class140.field2159;
            if(client.field434 > 0) {
               class16.method214(client.field434 - 1);
            }

            class23.method657(class3.field65);
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;III)Lclass224;",
      garbageValue = "236975516"
   )
   public static class224 method4(class167 var0, class167 var1, int var2, int var3) {
      return !class30.method748(var0, var2, var3)?null:class82.method1981(var1.method3403(var2, var3));
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-872711638"
   )
   static void method5() {
      for(class23 var0 = (class23)class23.field627.method3926(); null != var0; var0 = (class23)class23.field627.method3902()) {
         if(null != var0.field612) {
            var0.method658();
         }
      }

   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "92552174"
   )
   static final void method6(int var0, int var1, int var2, boolean var3) {
      if(class9.method161(var0)) {
         class35.method825(class173.field2886[var0], -1, var1, var2, var3);
      }
   }
}
