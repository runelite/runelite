import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class34 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1782380205
   )
   static int field770 = 0;
   @ObfuscatedName("e")
   static byte[] field772 = new byte[2048];
   @ObfuscatedName("o")
   static byte[] field773 = new byte[2048];
   @ObfuscatedName("x")
   static int[] field774 = new int[2048];
   @ObfuscatedName("g")
   static class122[] field775 = new class122[2048];
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 288340253
   )
   static int field777 = 0;
   @ObfuscatedName("v")
   static int[] field778 = new int[2048];
   @ObfuscatedName("k")
   static int[] field779 = new int[2048];
   @ObfuscatedName("j")
   static int[] field780 = new int[2048];
   @ObfuscatedName("h")
   static int[] field781 = new int[2048];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 347060463
   )
   static int field782 = 0;
   @ObfuscatedName("y")
   static int[] field783 = new int[2048];
   @ObfuscatedName("p")
   static class122 field786 = new class122(new byte[5000]);
   @ObfuscatedName("hw")
   @ObfuscatedGetter(
      intValue = 912548177
   )
   @Export("menuHeight")
   static int field788;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Lclass176;",
      garbageValue = "828300694"
   )
   public static class176 method720(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(class176.field2814[var1] == null || null == class176.field2814[var1][var2]) {
         boolean var3 = class122.method2739(var1);
         if(!var3) {
            return null;
         }
      }

      return class176.field2814[var1][var2];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass170;III)[Lclass81;",
      garbageValue = "-619610212"
   )
   static class81[] method726(class170 var0, int var1, int var2) {
      return !class33.method708(var0, var1, var2)?null:class128.method2853();
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "16"
   )
   static final void method727() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      class30 var29;
      if(client.field317 == 47) {
         var0 = client.field315.method2606();
         var1 = client.field315.method2718();
         var2 = (var1 >> 4 & 7) + class1.field31;
         var3 = class29.field687 + (var1 & 7);
         var4 = client.field315.method2706();
         if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
            var29 = new class30();
            var29.field699 = var0;
            var29.field694 = var4;
            if(null == client.field403[class51.field1119][var2][var3]) {
               client.field403[class51.field1119][var2][var3] = new class202();
            }

            client.field403[class51.field1119][var2][var3].method3877(var29);
            class142.method3001(var2, var3);
         }

      } else {
         int var5;
         int var6;
         int var7;
         if(client.field317 == 114) {
            var0 = client.field315.method2754();
            var1 = var0 >> 2;
            var2 = var0 & 3;
            var3 = client.field334[var1];
            var4 = client.field315.method2706();
            var5 = client.field315.method2598();
            var6 = (var5 >> 4 & 7) + class1.field31;
            var7 = class29.field687 + (var5 & 7);
            if(var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
               class146.method3064(class51.field1119, var6, var7, var3, var4, var1, var2, 0, -1);
            }

         } else if(client.field317 == 130) {
            var0 = client.field315.method2706();
            var1 = client.field315.method2556();
            var2 = class1.field31 + (var1 >> 4 & 7);
            var3 = (var1 & 7) + class29.field687;
            if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
               class202 var31 = client.field403[class51.field1119][var2][var3];
               if(var31 != null) {
                  for(var29 = (class30)var31.method3882(); null != var29; var29 = (class30)var31.method3891()) {
                     if(var29.field699 == (var0 & 32767)) {
                        var29.method3990();
                        break;
                     }
                  }

                  if(var31.method3882() == null) {
                     client.field403[class51.field1119][var2][var3] = null;
                  }

                  class142.method3001(var2, var3);
               }
            }

         } else {
            int var39;
            if(client.field317 == 98) {
               var0 = client.field315.method2598();
               var1 = (var0 >> 4 & 7) + class1.field31;
               var2 = class29.field687 + (var0 & 7);
               var3 = client.field315.method2754();
               var4 = var3 >> 2;
               var5 = var3 & 3;
               var6 = client.field334[var4];
               var7 = client.field315.method2655();
               if(var1 >= 0 && var2 >= 0 && var1 < 103 && var2 < 103) {
                  if(var6 == 0) {
                     class90 var8 = class5.field91.method2021(class51.field1119, var1, var2);
                     if(null != var8) {
                        var39 = var8.field1606 >> 14 & 32767;
                        if(var4 == 2) {
                           var8.field1604 = new class12(var39, 2, var5 + 4, class51.field1119, var1, var2, var7, false, var8.field1604);
                           var8.field1605 = new class12(var39, 2, 1 + var5 & 3, class51.field1119, var1, var2, var7, false, var8.field1605);
                        } else {
                           var8.field1604 = new class12(var39, var4, var5, class51.field1119, var1, var2, var7, false, var8.field1604);
                        }
                     }
                  }

                  if(var6 == 1) {
                     class97 var36 = class5.field91.method2022(class51.field1119, var1, var2);
                     if(null != var36) {
                        var39 = var36.field1683 >> 14 & 32767;
                        if(var4 != 4 && var4 != 5) {
                           if(var4 == 6) {
                              var36.field1680 = new class12(var39, 4, var5 + 4, class51.field1119, var1, var2, var7, false, var36.field1680);
                           } else if(var4 == 7) {
                              var36.field1680 = new class12(var39, 4, 4 + (2 + var5 & 3), class51.field1119, var1, var2, var7, false, var36.field1680);
                           } else if(var4 == 8) {
                              var36.field1680 = new class12(var39, 4, 4 + var5, class51.field1119, var1, var2, var7, false, var36.field1680);
                              var36.field1681 = new class12(var39, 4, (2 + var5 & 3) + 4, class51.field1119, var1, var2, var7, false, var36.field1681);
                           }
                        } else {
                           var36.field1680 = new class12(var39, 4, var5, class51.field1119, var1, var2, var7, false, var36.field1680);
                        }
                     }
                  }

                  if(var6 == 2) {
                     class101 var37 = class5.field91.method2115(class51.field1119, var1, var2);
                     if(var4 == 11) {
                        var4 = 10;
                     }

                     if(null != var37) {
                        var37.field1740 = new class12(var37.field1739 >> 14 & 32767, var4, var5, class51.field1119, var1, var2, var7, false, var37.field1740);
                     }
                  }

                  if(var6 == 3) {
                     class96 var38 = class5.field91.method2024(class51.field1119, var1, var2);
                     if(null != var38) {
                        var38.field1662 = new class12(var38.field1666 >> 14 & 32767, 22, var5, class51.field1119, var1, var2, var7, false, var38.field1662);
                     }
                  }
               }

            } else if(client.field317 == 157) {
               var0 = client.field315.method2556();
               var1 = class1.field31 + (var0 >> 4 & 7);
               var2 = class29.field687 + (var0 & 7);
               var3 = client.field315.method2706();
               var4 = client.field315.method2556();
               var5 = client.field315.method2706();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  var1 = 64 + var1 * 128;
                  var2 = 64 + var2 * 128;
                  class31 var42 = new class31(var3, class51.field1119, var1, var2, class15.method163(var1, var2, class51.field1119) - var4, var5, client.field282);
                  client.field406.method3877(var42);
               }

            } else if(client.field317 == 202) {
               var0 = client.field315.method2718();
               var1 = class1.field31 + (var0 >> 4 & 7);
               var2 = class29.field687 + (var0 & 7);
               var3 = client.field315.method2598();
               var4 = var3 >> 2;
               var5 = var3 & 3;
               var6 = client.field334[var4];
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  class146.method3064(class51.field1119, var1, var2, var6, -1, var4, var5, 0, -1);
               }

            } else {
               int var11;
               int var12;
               int var30;
               if(client.field317 == 39) {
                  var0 = client.field315.method2556();
                  var1 = class1.field31 + (var0 >> 4 & 7);
                  var2 = class29.field687 + (var0 & 7);
                  var3 = var1 + client.field315.method2573();
                  var4 = var2 + client.field315.method2573();
                  var5 = client.field315.method2575();
                  var6 = client.field315.method2706();
                  var7 = client.field315.method2556() * 4;
                  var30 = client.field315.method2556() * 4;
                  var39 = client.field315.method2706();
                  int var40 = client.field315.method2706();
                  var11 = client.field315.method2556();
                  var12 = client.field315.method2556();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
                     var1 = 64 + 128 * var1;
                     var2 = var2 * 128 + 64;
                     var3 = var3 * 128 + 64;
                     var4 = 64 + var4 * 128;
                     class6 var13 = new class6(var6, class51.field1119, var1, var2, class15.method163(var1, var2, class51.field1119) - var7, var39 + client.field282, client.field282 + var40, var11, var12, var5, var30);
                     var13.method80(var3, var4, class15.method163(var3, var4, class51.field1119) - var30, client.field282 + var39);
                     client.field405.method3877(var13);
                  }

               } else if(client.field317 == 176) {
                  var0 = client.field315.method2556();
                  var1 = class1.field31 + (var0 >> 4 & 7);
                  var2 = (var0 & 7) + class29.field687;
                  var3 = client.field315.method2706();
                  var4 = client.field315.method2706();
                  var5 = client.field315.method2706();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     class202 var32 = client.field403[class51.field1119][var1][var2];
                     if(var32 != null) {
                        for(class30 var33 = (class30)var32.method3882(); var33 != null; var33 = (class30)var32.method3891()) {
                           if((var3 & 32767) == var33.field699 && var33.field694 == var4) {
                              var33.field694 = var5;
                              break;
                           }
                        }

                        class142.method3001(var1, var2);
                     }
                  }

               } else {
                  if(client.field317 == 10) {
                     var0 = client.field315.method2556();
                     var1 = class1.field31 + (var0 >> 4 & 7);
                     var2 = class29.field687 + (var0 & 7);
                     var3 = client.field315.method2706();
                     var4 = client.field315.method2556();
                     var5 = var4 >> 4 & 15;
                     var6 = var4 & 7;
                     var7 = client.field315.method2556();
                     if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                        var30 = var5 + 1;
                        if(class114.field2010.field885[0] >= var1 - var30 && class114.field2010.field885[0] <= var1 + var30 && class114.field2010.field886[0] >= var2 - var30 && class114.field2010.field886[0] <= var30 + var2 && client.field511 != 0 && var6 > 0 && client.field274 < 50) {
                           client.field513[client.field274] = var3;
                           client.field346[client.field274] = var6;
                           client.field434[client.field274] = var7;
                           client.field450[client.field274] = null;
                           client.field288[client.field274] = var5 + (var2 << 8) + (var1 << 16);
                           ++client.field274;
                        }
                     }
                  }

                  if(client.field317 == 172) {
                     byte var35 = client.field315.method2573();
                     var1 = client.field315.method2754();
                     var2 = class1.field31 + (var1 >> 4 & 7);
                     var3 = (var1 & 7) + class29.field687;
                     var4 = client.field315.method2608();
                     var5 = client.field315.method2608();
                     var6 = client.field315.method2606();
                     var7 = client.field315.method2606();
                     byte var41 = client.field315.method2601();
                     byte var9 = client.field315.method2602();
                     byte var10 = client.field315.method2601();
                     var11 = client.field315.method2754();
                     var12 = var11 >> 2;
                     int var34 = var11 & 3;
                     int var14 = client.field334[var12];
                     class2 var15;
                     if(var6 == client.field551) {
                        var15 = class114.field2010;
                     } else {
                        var15 = client.field393[var6];
                     }

                     if(null != var15) {
                        class42 var16 = class7.method100(var4);
                        int var17;
                        int var18;
                        if(var34 != 1 && var34 != 3) {
                           var17 = var16.field976;
                           var18 = var16.field980;
                        } else {
                           var17 = var16.field980;
                           var18 = var16.field976;
                        }

                        int var19 = (var17 >> 1) + var2;
                        int var20 = (var17 + 1 >> 1) + var2;
                        int var21 = var3 + (var18 >> 1);
                        int var22 = (var18 + 1 >> 1) + var3;
                        int[][] var23 = class5.field77[class51.field1119];
                        int var24 = var23[var20][var21] + var23[var19][var21] + var23[var19][var22] + var23[var20][var22] >> 2;
                        int var25 = (var17 << 6) + (var2 << 7);
                        int var26 = (var3 << 7) + (var18 << 6);
                        class108 var27 = var16.method864(var12, var34, var23, var25, var24, var26);
                        if(var27 != null) {
                           class146.method3064(class51.field1119, var2, var3, var14, -1, 0, 0, var5 + 1, 1 + var7);
                           var15.field44 = client.field282 + var5;
                           var15.field36 = client.field282 + var7;
                           var15.field49 = var27;
                           var15.field40 = 64 * var17 + var2 * 128;
                           var15.field48 = 64 * var18 + 128 * var3;
                           var15.field47 = var24;
                           byte var28;
                           if(var35 > var10) {
                              var28 = var35;
                              var35 = var10;
                              var10 = var28;
                           }

                           if(var9 > var41) {
                              var28 = var9;
                              var9 = var41;
                              var41 = var28;
                           }

                           var15.field37 = var2 + var35;
                           var15.field52 = var2 + var10;
                           var15.field51 = var3 + var9;
                           var15.field53 = var41 + var3;
                        }
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2137623502"
   )
   public static void method728() {
      class41.field925.method3814();
      class41.field907.method3814();
   }
}
