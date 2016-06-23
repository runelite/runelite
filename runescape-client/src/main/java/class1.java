import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class1 {
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = 2127445275
   )
   @Export("cameraZ")
   static int field27;
   @ObfuscatedName("kn")
   @ObfuscatedGetter(
      intValue = 181052003
   )
   static int field34;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "10"
   )
   public static void method6(int var0) {
      class183.field2953 = 1;
      class20.field582 = null;
      class21.field589 = -1;
      class213.field3145 = -1;
      class183.field2956 = 0;
      class20.field583 = false;
      class183.field2957 = var0;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "18"
   )
   static final void method8() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var6;
      int var7;
      int var9;
      int var10;
      int var11;
      int var12;
      int var29;
      int var30;
      if(client.field325 == 230) {
         var0 = client.field335.method2554();
         var1 = (var0 >> 4 & 7) + class12.field188;
         var2 = (var0 & 7) + class103.field1771;
         var3 = var1 + client.field335.method2538();
         var4 = var2 + client.field335.method2538();
         var29 = client.field335.method2557();
         var6 = client.field335.method2556();
         var7 = client.field335.method2554() * 4;
         var30 = client.field335.method2554() * 4;
         var9 = client.field335.method2556();
         var10 = client.field335.method2556();
         var11 = client.field335.method2554();
         var12 = client.field335.method2554();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
            var1 = 64 + 128 * var1;
            var2 = var2 * 128 + 64;
            var3 = var3 * 128 + 64;
            var4 = 64 + var4 * 128;
            class6 var13 = new class6(var6, class14.field212, var1, var2, class74.method1659(var1, var2, class14.field212) - var7, client.field301 + var9, client.field301 + var10, var11, var12, var29, var30);
            var13.method96(var3, var4, class74.method1659(var3, var4, class14.field212) - var30, client.field301 + var9);
            client.field549.method3877(var13);
         }

      } else if(client.field325 == 16) {
         var0 = client.field335.method2556();
         var1 = client.field335.method2581();
         var2 = class12.field188 + (var1 >> 4 & 7);
         var3 = (var1 & 7) + class103.field1771;
         var4 = client.field335.method2579();
         var29 = var4 >> 2;
         var6 = var4 & 3;
         var7 = client.field287[var29];
         if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
            class21.method606(class14.field212, var2, var3, var7, var0, var29, var6, 0, -1);
         }

      } else {
         if(client.field325 == 225) {
            var0 = client.field335.method2554();
            var1 = (var0 >> 4 & 7) + class12.field188;
            var2 = class103.field1771 + (var0 & 7);
            var3 = client.field335.method2556();
            var4 = client.field335.method2554();
            var29 = var4 >> 4 & 15;
            var6 = var4 & 7;
            var7 = client.field335.method2554();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               var30 = var29 + 1;
               if(class15.field225.field875[0] >= var1 - var30 && class15.field225.field875[0] <= var1 + var30 && class15.field225.field876[0] >= var2 - var30 && class15.field225.field876[0] <= var30 + var2 && client.field349 != 0 && var6 > 0 && client.field554 < 50) {
                  client.field531[client.field554] = var3;
                  client.field532[client.field554] = var6;
                  client.field533[client.field554] = var7;
                  client.field392[client.field554] = null;
                  client.field521[client.field554] = var29 + (var2 << 8) + (var1 << 16);
                  ++client.field554;
               }
            }
         }

         if(client.field325 == 46) {
            var0 = client.field335.method2554();
            var1 = class12.field188 + (var0 >> 4 & 7);
            var2 = (var0 & 7) + class103.field1771;
            var3 = client.field335.method2556();
            var4 = client.field335.method2556();
            var29 = client.field335.method2556();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               class199 var40 = client.field572[class14.field212][var1][var2];
               if(var40 != null) {
                  for(class28 var32 = (class28)var40.method3852(); null != var32; var32 = (class28)var40.method3857()) {
                     if(var32.field682 == (var3 & 32767) && var32.field681 == var4) {
                        var32.field681 = var29;
                        break;
                     }
                  }

                  class160.method3204(var1, var2);
               }
            }

         } else if(client.field325 == 229) {
            var0 = client.field335.method2554();
            var1 = (var0 >> 4 & 7) + class12.field188;
            var2 = (var0 & 7) + class103.field1771;
            var3 = client.field335.method2556();
            var4 = client.field335.method2554();
            var29 = client.field335.method2556();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               var1 = 64 + var1 * 128;
               var2 = 64 + var2 * 128;
               class29 var31 = new class29(var3, class14.field212, var1, var2, class74.method1659(var1, var2, class14.field212) - var4, var29, client.field301);
               client.field423.method3877(var31);
            }

         } else if(client.field325 == 175) {
            var0 = client.field335.method2695();
            var1 = client.field335.method2580();
            var2 = class12.field188 + (var1 >> 4 & 7);
            var3 = class103.field1771 + (var1 & 7);
            var4 = client.field335.method2554();
            var29 = var4 >> 2;
            var6 = var4 & 3;
            var7 = client.field287[var29];
            if(var2 >= 0 && var3 >= 0 && var2 < 103 && var3 < 103) {
               if(var7 == 0) {
                  class87 var8 = class129.field2056.method1997(class14.field212, var2, var3);
                  if(var8 != null) {
                     var9 = var8.field1544 >> 14 & 32767;
                     if(var29 == 2) {
                        var8.field1536 = new class12(var9, 2, var6 + 4, class14.field212, var2, var3, var0, false, var8.field1536);
                        var8.field1539 = new class12(var9, 2, 1 + var6 & 3, class14.field212, var2, var3, var0, false, var8.field1539);
                     } else {
                        var8.field1536 = new class12(var9, var29, var6, class14.field212, var2, var3, var0, false, var8.field1536);
                     }
                  }
               }

               if(var7 == 1) {
                  class94 var36 = class129.field2056.method2118(class14.field212, var2, var3);
                  if(var36 != null) {
                     var9 = var36.field1617 >> 14 & 32767;
                     if(var29 != 4 && var29 != 5) {
                        if(var29 == 6) {
                           var36.field1616 = new class12(var9, 4, var6 + 4, class14.field212, var2, var3, var0, false, var36.field1616);
                        } else if(var29 == 7) {
                           var36.field1616 = new class12(var9, 4, 4 + (var6 + 2 & 3), class14.field212, var2, var3, var0, false, var36.field1616);
                        } else if(var29 == 8) {
                           var36.field1616 = new class12(var9, 4, 4 + var6, class14.field212, var2, var3, var0, false, var36.field1616);
                           var36.field1609 = new class12(var9, 4, 4 + (var6 + 2 & 3), class14.field212, var2, var3, var0, false, var36.field1609);
                        }
                     } else {
                        var36.field1616 = new class12(var9, 4, var6, class14.field212, var2, var3, var0, false, var36.field1616);
                     }
                  }
               }

               if(var7 == 2) {
                  class98 var37 = class129.field2056.method1999(class14.field212, var2, var3);
                  if(var29 == 11) {
                     var29 = 10;
                  }

                  if(null != var37) {
                     var37.field1664 = new class12(var37.field1672 >> 14 & 32767, var29, var6, class14.field212, var2, var3, var0, false, var37.field1664);
                  }
               }

               if(var7 == 3) {
                  class93 var38 = class129.field2056.method2000(class14.field212, var2, var3);
                  if(null != var38) {
                     var38.field1605 = new class12(var38.field1603 >> 14 & 32767, 22, var6, class14.field212, var2, var3, var0, false, var38.field1605);
                  }
               }
            }

         } else {
            if(client.field325 == 206) {
               byte var35 = client.field335.method2559();
               var1 = client.field335.method2556();
               var2 = client.field335.method2581();
               var3 = (var2 >> 4 & 7) + class12.field188;
               var4 = class103.field1771 + (var2 & 7);
               byte var39 = client.field335.method2583();
               var6 = client.field335.method2597();
               var7 = client.field335.method2695();
               var30 = client.field335.method2581();
               var9 = var30 >> 2;
               var10 = var30 & 3;
               var11 = client.field287[var9];
               var12 = client.field335.method2695();
               byte var33 = client.field335.method2559();
               byte var14 = client.field335.method2583();
               class2 var15;
               if(client.field411 == var1) {
                  var15 = class15.field225;
               } else {
                  var15 = client.field302[var1];
               }

               if(null != var15) {
                  class40 var16 = class150.method3166(var12);
                  int var17;
                  int var18;
                  if(var10 != 1 && var10 != 3) {
                     var17 = var16.field945;
                     var18 = var16.field937;
                  } else {
                     var17 = var16.field937;
                     var18 = var16.field945;
                  }

                  int var19 = (var17 >> 1) + var3;
                  int var20 = var3 + (1 + var17 >> 1);
                  int var21 = var4 + (var18 >> 1);
                  int var22 = var4 + (var18 + 1 >> 1);
                  int[][] var23 = class5.field99[class14.field212];
                  int var24 = var23[var19][var21] + var23[var20][var21] + var23[var19][var22] + var23[var20][var22] >> 2;
                  int var25 = (var17 << 6) + (var3 << 7);
                  int var26 = (var18 << 6) + (var4 << 7);
                  class105 var27 = var16.method847(var9, var10, var23, var25, var24, var26);
                  if(var27 != null) {
                     class21.method606(class14.field212, var3, var4, var11, -1, 0, 0, 1 + var7, 1 + var6);
                     var15.field54 = client.field301 + var7;
                     var15.field48 = var6 + client.field301;
                     var15.field43 = var27;
                     var15.field45 = 64 * var17 + 128 * var3;
                     var15.field47 = 64 * var18 + var4 * 128;
                     var15.field44 = var24;
                     byte var28;
                     if(var39 > var14) {
                        var28 = var39;
                        var39 = var14;
                        var14 = var28;
                     }

                     if(var35 > var33) {
                        var28 = var35;
                        var35 = var33;
                        var33 = var28;
                     }

                     var15.field49 = var3 + var39;
                     var15.field51 = var14 + var3;
                     var15.field50 = var35 + var4;
                     var15.field52 = var4 + var33;
                  }
               }
            }

            if(client.field325 == 38) {
               var0 = client.field335.method2554();
               var1 = class12.field188 + (var0 >> 4 & 7);
               var2 = (var0 & 7) + class103.field1771;
               var3 = client.field335.method2554();
               var4 = var3 >> 2;
               var29 = var3 & 3;
               var6 = client.field287[var4];
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  class21.method606(class14.field212, var1, var2, var6, -1, var4, var29, 0, -1);
               }

            } else {
               class28 var5;
               if(client.field325 == 138) {
                  var0 = client.field335.method2695();
                  var1 = client.field335.method2556();
                  var2 = client.field335.method2579();
                  var3 = class12.field188 + (var2 >> 4 & 7);
                  var4 = (var2 & 7) + class103.field1771;
                  if(var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                     var5 = new class28();
                     var5.field682 = var0;
                     var5.field681 = var1;
                     if(null == client.field572[class14.field212][var3][var4]) {
                        client.field572[class14.field212][var3][var4] = new class199();
                     }

                     client.field572[class14.field212][var3][var4].method3877(var5);
                     class160.method3204(var3, var4);
                  }

               } else if(client.field325 == 90) {
                  var0 = client.field335.method2588();
                  var1 = client.field335.method2554();
                  var2 = (var1 >> 4 & 7) + class12.field188;
                  var3 = class103.field1771 + (var1 & 7);
                  if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
                     class199 var34 = client.field572[class14.field212][var2][var3];
                     if(null != var34) {
                        for(var5 = (class28)var34.method3852(); null != var5; var5 = (class28)var34.method3857()) {
                           if(var5.field682 == (var0 & 32767)) {
                              var5.method3946();
                              break;
                           }
                        }

                        if(var34.method3852() == null) {
                           client.field572[class14.field212][var2][var3] = null;
                        }

                        class160.method3204(var2, var3);
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIIB)Z",
      garbageValue = "124"
   )
   static final boolean method9(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      class119 var4 = new class119(var0);
      int var5 = -1;

      label76:
      while(true) {
         int var6 = var4.method2567();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.method2567();
               if(var9 == 0) {
                  continue label76;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.method2554() >> 2;
               int var13 = var1 + var11;
               int var14 = var2 + var10;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  class40 var15 = class150.method3166(var5);
                  if(var12 != 22 || !client.field296 || var15.field955 != 0 || var15.field953 == 1 || var15.field977) {
                     if(!var15.method845()) {
                        ++client.field347;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.method2567();
            if(var9 == 0) {
               break;
            }

            var4.method2554();
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-444423679"
   )
   static void method10() {
      class11.field178.clear();
      class11.field182.method3843();
      class11.field179.method3886();
      class11.field180 = 0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass136;Ljava/awt/Component;III)Lclass56;",
      garbageValue = "-226204327"
   )
   public static final class56 method11(class136 var0, Component var1, int var2, int var3) {
      if(class56.field1196 == 0) {
         throw new IllegalStateException();
      } else if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class69 var7 = new class69();
            var7.field1191 = new int[256 * (class56.field1200?2:1)];
            var7.field1197 = var3;
            var7.vmethod1576(var1);
            var7.field1202 = 1024 + (var3 & -1024);
            if(var7.field1202 > 16384) {
               var7.field1202 = 16384;
            }

            var7.vmethod1575(var7.field1202);
            if(class56.field1188 > 0 && null == class38.field888) {
               class38.field888 = new class72();
               class38.field888.field1370 = var0;
               var0.method2903(class38.field888, class56.field1188);
            }

            if(class38.field888 != null) {
               if(null != class38.field888.field1364[var2]) {
                  throw new IllegalArgumentException();
               }

               class38.field888.field1364[var2] = var7;
            }

            return var7;
         } catch (Throwable var6) {
            try {
               class54 var4 = new class54(var0, var2);
               var4.field1191 = new int[256 * (class56.field1200?2:1)];
               var4.field1197 = var3;
               var4.vmethod1576(var1);
               var4.field1202 = 16384;
               var4.vmethod1575(var4.field1202);
               if(class56.field1188 > 0 && null == class38.field888) {
                  class38.field888 = new class72();
                  class38.field888.field1370 = var0;
                  var0.method2903(class38.field888, class56.field1188);
               }

               if(null != class38.field888) {
                  if(class38.field888.field1364[var2] != null) {
                     throw new IllegalArgumentException();
                  }

                  class38.field888.field1364[var2] = var4;
               }

               return var4;
            } catch (Throwable var5) {
               return new class56();
            }
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)Lclass43;",
      garbageValue = "87"
   )
   public static class43 method12(int var0) {
      class43 var1 = (class43)class43.field1025.method3797((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class43.field1038.method3286(13, var0);
         var1 = new class43();
         var1.field1024 = var0;
         if(var2 != null) {
            var1.method940(new class119(var2));
         }

         class43.field1025.method3788(var1, (long)var0);
         return var1;
      }
   }
}
