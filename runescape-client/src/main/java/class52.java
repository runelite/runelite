import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
public class class52 extends class204 {
   @ObfuscatedName("p")
   static class193 field1162 = new class193(64);
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 58473945
   )
   public int field1163 = 0;
   @ObfuscatedName("s")
   public static class167 field1167;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -690914647
   )
   static int field1170;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "42387916"
   )
   @Export("addChatMessage")
   static void method1050(int var0, String var1, String var2, String var3) {
      class27 var4 = (class27)class11.field168.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new class27();
         class11.field168.put(Integer.valueOf(var0), var4);
      }

      class35 var5 = var4.method621(var0, var1, var2, var3);
      class11.field167.method3795(var5, (long)var5.field789);
      class11.field171.method3841(var5);
      client.field469 = client.field462;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "676091049"
   )
   void method1051(class119 var1) {
      while(true) {
         int var2 = var1.method2492();
         if(var2 == 0) {
            return;
         }

         this.method1052(var1, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-1005612136"
   )
   void method1052(class119 var1, int var2) {
      if(var2 == 5) {
         this.field1163 = var1.method2584();
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "14500"
   )
   public static void method1053(int var0) {
      class140.field2157 = var0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-688972696"
   )
   public static String method1061(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;
      int var5 = var1;

      int var6;
      for(int var7 = var1 + var2; var5 < var7; var3[var4++] = (char)var6) {
         int var8 = var0[var5++] & 255;
         if(var8 < 128) {
            if(var8 == 0) {
               var6 = '�';
            } else {
               var6 = var8;
            }
         } else if(var8 < 192) {
            var6 = '�';
         } else if(var8 < 224) {
            if(var5 < var7 && 128 == (var0[var5] & 192)) {
               var6 = (var8 & 31) << 6 | var0[var5++] & 63;
               if(var6 < 128) {
                  var6 = '�';
               }
            } else {
               var6 = '�';
            }
         } else if(var8 < 240) {
            if(var5 + 1 < var7 && 128 == (var0[var5] & 192) && 128 == (var0[1 + var5] & 192)) {
               var6 = (var8 & 15) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var6 < 2048) {
                  var6 = '�';
               }
            } else {
               var6 = '�';
            }
         } else if(var8 < 248) {
            if(var5 + 2 < var7 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128 && (var0[2 + var5] & 192) == 128) {
               var6 = (var8 & 7) << 18 | (var0[var5++] & 63) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var6 >= 65536 && var6 <= 1114111) {
                  var6 = '�';
               } else {
                  var6 = '�';
               }
            } else {
               var6 = '�';
            }
         } else {
            var6 = '�';
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "1945539707"
   )
   static final void method1068(class122 var0) {
      int var1 = 0;
      var0.method2739();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class32.field755; ++var2) {
         var3 = class32.field756[var2];
         if((class32.field752[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class32.field752[var3] = (byte)(class32.field752[var3] | 2);
            } else {
               var4 = var0.method2750(1);
               if(0 == var4) {
                  var1 = class76.method1641(var0);
                  class32.field752[var3] = (byte)(class32.field752[var3] | 2);
               } else {
                  class1.method7(var0, var3);
               }
            }
         }
      }

      var0.method2740();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.method2739();

         for(var2 = 0; var2 < class32.field755; ++var2) {
            var3 = class32.field756[var2];
            if(0 != (class32.field752[var3] & 1)) {
               if(var1 > 0) {
                  --var1;
                  class32.field752[var3] = (byte)(class32.field752[var3] | 2);
               } else {
                  var4 = var0.method2750(1);
                  if(var4 == 0) {
                     var1 = class76.method1641(var0);
                     class32.field752[var3] = (byte)(class32.field752[var3] | 2);
                  } else {
                     class1.method7(var0, var3);
                  }
               }
            }
         }

         var0.method2740();
         if(0 != var1) {
            throw new RuntimeException();
         } else {
            var0.method2739();

            for(var2 = 0; var2 < class32.field757; ++var2) {
               var3 = class32.field751[var2];
               if(0 != (class32.field752[var3] & 1)) {
                  if(var1 > 0) {
                     --var1;
                     class32.field752[var3] = (byte)(class32.field752[var3] | 2);
                  } else {
                     var4 = var0.method2750(1);
                     if(var4 == 0) {
                        var1 = class76.method1641(var0);
                        class32.field752[var3] = (byte)(class32.field752[var3] | 2);
                     } else if(class119.method2638(var0, var3)) {
                        class32.field752[var3] = (byte)(class32.field752[var3] | 2);
                     }
                  }
               }
            }

            var0.method2740();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.method2739();

               for(var2 = 0; var2 < class32.field757; ++var2) {
                  var3 = class32.field751[var2];
                  if((class32.field752[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class32.field752[var3] = (byte)(class32.field752[var3] | 2);
                     } else {
                        var4 = var0.method2750(1);
                        if(var4 == 0) {
                           var1 = class76.method1641(var0);
                           class32.field752[var3] = (byte)(class32.field752[var3] | 2);
                        } else if(class119.method2638(var0, var3)) {
                           class32.field752[var3] = (byte)(class32.field752[var3] | 2);
                        }
                     }
                  }
               }

               var0.method2740();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class32.field755 = 0;
                  class32.field757 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class32.field752[var2] = (byte)(class32.field752[var2] >> 1);
                     class2 var5 = client.field491[var2];
                     if(null != var5) {
                        class32.field756[++class32.field755 - 1] = var2;
                     } else {
                        class32.field751[++class32.field757 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1311138763"
   )
   static final void method1069(int var0) {
      class8.method112();
      class6.method98();
      int var1 = class3.method38(var0).field1163;
      if(var1 != 0) {
         int var2 = class176.field2920[var0];
         if(var1 == 1) {
            if(1 == var2) {
               class91.method2094(0.9D);
               ((class95)class91.field1593).method2170(0.9D);
            }

            if(2 == var2) {
               class91.method2094(0.8D);
               ((class95)class91.field1593).method2170(0.8D);
            }

            if(var2 == 3) {
               class91.method2094(0.7D);
               ((class95)class91.field1593).method2170(0.7D);
            }

            if(4 == var2) {
               class91.method2094(0.6D);
               ((class95)class91.field1593).method2170(0.6D);
            }

            class187.method3730();
         }

         if(3 == var1) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(client.field516 != var3) {
               if(0 == client.field516 && client.field370 != -1) {
                  class82.method1869(class102.field1776, client.field370, 0, var3, false);
                  client.field518 = false;
               } else if(0 == var3) {
                  class107.method2373();
                  client.field518 = false;
               } else if(0 != class183.field2973) {
                  class183.field2971 = var3;
               } else {
                  class183.field2972.method3578(var3);
               }

               client.field516 = var3;
            }
         }

         if(var1 == 4) {
            if(0 == var2) {
               client.field519 = 127;
            }

            if(var2 == 1) {
               client.field519 = 96;
            }

            if(2 == var2) {
               client.field519 = 64;
            }

            if(3 == var2) {
               client.field519 = 32;
            }

            if(var2 == 4) {
               client.field519 = 0;
            }
         }

         if(var1 == 5) {
            client.field545 = var2;
         }

         if(var1 == 6) {
            client.field439 = var2;
         }

         if(9 == var1) {
            client.field349 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               client.field520 = 127;
            }

            if(var2 == 1) {
               client.field520 = 96;
            }

            if(2 == var2) {
               client.field520 = 64;
            }

            if(3 == var2) {
               client.field520 = 32;
            }

            if(4 == var2) {
               client.field520 = 0;
            }
         }

         if(17 == var1) {
            client.field445 = var2 & '\uffff';
         }

         if(var1 == 18) {
            client.field304 = (class20)class75.method1616(class3.method34(), var2);
            if(client.field304 == null) {
               client.field304 = class20.field571;
            }
         }

         if(19 == var1) {
            if(var2 == -1) {
               client.field409 = -1;
            } else {
               client.field409 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            class20[] var4 = new class20[]{class20.field572, class20.field565, class20.field567, class20.field571};
            client.field305 = (class20)class75.method1616(var4, var2);
            if(client.field305 == null) {
               client.field305 = class20.field571;
            }
         }
      }

   }
}
