import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class50 extends class207 {
   @ObfuscatedName("l")
   public static class196 field1110 = new class196(64);
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1332483699
   )
   public int field1112;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1858564463
   )
   public int field1113;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -977745103
   )
   public int field1114;
   @ObfuscatedName("e")
   public static class170 field1115;
   @ObfuscatedName("gl")
   @ObfuscatedGetter(
      intValue = -930579279
   )
   @Export("plane")
   static int field1119;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "12"
   )
   public static boolean method1077(char var0) {
      return var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "-1879189625"
   )
   void method1079(class122 var1, int var2) {
      if(var2 == 1) {
         this.field1112 = var1.method2612();
         this.field1113 = var1.method2610();
         this.field1114 = var1.method2610();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "705425594"
   )
   public void method1080(class122 var1) {
      while(true) {
         int var2 = var1.method2610();
         if(var2 == 0) {
            return;
         }

         this.method1079(var1, var2);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1771496552"
   )
   static final void method1085() {
      try {
         if(client.field420 == 0) {
            if(null != class8.field150) {
               class8.field150.method3088();
               class8.field150 = null;
            }

            class24.field645 = null;
            client.field553 = false;
            client.field565 = 0;
            client.field420 = 1;
         }

         if(client.field420 == 1) {
            if(null == class24.field645) {
               class24.field645 = class107.field1869.method2994(client.field330, class101.field1745);
            }

            if(class24.field645.field2264 == 2) {
               throw new IOException();
            }

            if(class24.field645.field2264 == 1) {
               class8.field150 = new class146((Socket)class24.field645.field2260, class107.field1869);
               class24.field645 = null;
               client.field420 = 2;
            }
         }

         if(client.field420 == 2) {
            client.field336.field2061 = 0;
            client.field336.method2795(14);
            class8.field150.method3083(client.field336.field2054, 0, 1);
            client.field338.field2061 = 0;
            client.field420 = 3;
         }

         int var0;
         if(client.field420 == 3) {
            if(null != class34.field809) {
               class34.field809.method1278();
            }

            if(null != class31.field744) {
               class31.field744.method1278();
            }

            var0 = class8.field150.method3080();
            if(null != class34.field809) {
               class34.field809.method1278();
            }

            if(class31.field744 != null) {
               class31.field744.method1278();
            }

            if(var0 != 0) {
               class48.method1049(var0);
               return;
            }

            client.field338.field2061 = 0;
            client.field420 = 5;
         }

         int var1;
         int var2;
         if(client.field420 == 5) {
            int[] var7 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            client.field336.field2061 = 0;
            client.field336.method2795(1);
            client.field336.method2795(class33.field770.vmethod3262());
            client.field336.method2598(var7[0]);
            client.field336.method2598(var7[1]);
            client.field336.method2598(var7[2]);
            client.field336.method2598(var7[3]);
            switch(class33.field770.field2648) {
            case 0:
            case 2:
               client.field336.method2675(class180.field2948);
               client.field336.field2061 += 5;
               break;
            case 1:
               client.field336.method2598(((Integer)client.field571.field147.get(Integer.valueOf(class22.method569(class33.field784)))).intValue());
               client.field336.field2061 += 4;
               break;
            case 3:
               client.field336.field2061 += 8;
            }

            client.field336.method2601(class33.field780);
            client.field336.method2746(class4.field69, class4.field75);
            client.field493.field2061 = 0;
            if(client.field301 == 40) {
               client.field493.method2795(18);
            } else {
               client.field493.method2795(16);
            }

            client.field493.method2781(0);
            var1 = client.field493.field2061;
            client.field493.method2598(118);
            client.field493.method2604(client.field336.field2054, 0, client.field336.field2061);
            var2 = client.field493.field2061;
            client.field493.method2601(class33.field784);
            client.field493.method2795((client.field509?1:0) << 1 | (client.field298?1:0));
            client.field493.method2781(class142.field2191);
            client.field493.method2781(class132.field2109);
            class125 var3 = client.field493;
            byte[] var4 = new byte[24];

            int var5;
            try {
               class152.field2283.method4252(0L);
               class152.field2283.method4234(var4);

               for(var5 = 0; var5 < 24 && var4[var5] == 0; ++var5) {
                  ;
               }

               if(var5 >= 24) {
                  throw new IOException();
               }
            } catch (Exception var12) {
               for(int var6 = 0; var6 < 24; ++var6) {
                  var4[var6] = -1;
               }
            }

            var3.method2604(var4, 0, 24);
            client.field493.method2601(class28.field702);
            client.field493.method2598(client.field300);
            class122 var17 = new class122(class99.field1706.method3270());
            class99.field1706.method3269(var17);
            client.field493.method2604(var17.field2054, 0, var17.field2054.length);
            client.field493.method2795(class155.field2308);
            client.field493.method2598(class49.field1099.field2720);
            client.field493.method2598(class126.field2076.field2720);
            client.field493.method2598(class172.field2748.field2720);
            client.field493.method2598(class172.field2741.field2720);
            client.field493.method2598(class17.field254.field2720);
            client.field493.method2598(class4.field68.field2720);
            client.field493.method2598(class109.field1948.field2720);
            client.field493.method2598(class48.field1083.field2720);
            client.field493.method2598(class230.field3263.field2720);
            client.field493.method2598(class90.field1595.field2720);
            client.field493.method2598(class192.field3097.field2720);
            client.field493.method2598(class104.field1813.field2720);
            client.field493.method2598(class0.field11.field2720);
            client.field493.method2598(class23.field623.field2720);
            client.field493.method2598(class127.field2086.field2720);
            client.field493.method2598(class18.field269.field2720);
            client.field493.method2628(var7, var2, client.field493.field2061);
            client.field493.method2606(client.field493.field2061 - var1);
            class8.field150.method3083(client.field493.field2054, 0, client.field493.field2061);
            client.field336.method2855(var7);

            for(var5 = 0; var5 < 4; ++var5) {
               var7[var5] += 50;
            }

            client.field338.method2855(var7);
            client.field420 = 6;
         }

         if(client.field420 == 6 && class8.field150.method3081() > 0) {
            var0 = class8.field150.method3080();
            if(var0 == 21 && client.field301 == 20) {
               client.field420 = 7;
            } else if(var0 == 2) {
               client.field420 = 9;
            } else if(var0 == 15 && client.field301 == 40) {
               client.field532 = -1;
               client.field420 = 13;
            } else if(var0 == 23 && client.field328 < 1) {
               ++client.field328;
               client.field420 = 0;
            } else {
               if(var0 != 29) {
                  class48.method1049(var0);
                  return;
               }

               client.field420 = 11;
            }
         }

         if(client.field420 == 7 && class8.field150.method3081() > 0) {
            client.field329 = (class8.field150.method3080() + 3) * 60;
            client.field420 = 8;
         }

         if(client.field420 == 8) {
            client.field565 = 0;
            class117.method2529("You have only just left another world.", "Your profile will be transferred in:", client.field329 / 60 + " seconds.");
            if(--client.field329 <= 0) {
               client.field420 = 0;
            }

         } else {
            boolean var15;
            if(client.field420 == 9 && class8.field150.method3081() >= 13) {
               boolean var14 = class8.field150.method3080() == 1;
               class8.field150.method3082(client.field338.field2054, 0, 4);
               client.field338.field2061 = 0;
               var15 = false;
               if(var14) {
                  var1 = client.field338.method2865() << 24;
                  var1 |= client.field338.method2865() << 16;
                  var1 |= client.field338.method2865() << 8;
                  var1 |= client.field338.method2865();
                  var2 = class22.method569(class33.field784);
                  if(client.field571.field147.size() >= 10 && !client.field571.field147.containsKey(Integer.valueOf(var2))) {
                     Iterator var16 = client.field571.field147.entrySet().iterator();
                     var16.next();
                     var16.remove();
                  }

                  client.field571.field147.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class49.method1062();
               }

               client.field439 = class8.field150.method3080();
               client.field463 = class8.field150.method3080() == 1;
               client.field417 = class8.field150.method3080();
               client.field417 <<= 8;
               client.field417 += class8.field150.method3080();
               client.field418 = class8.field150.method3080();
               class8.field150.method3082(client.field338.field2054, 0, 1);
               client.field338.field2061 = 0;
               client.field549 = client.field338.method2865();
               class8.field150.method3082(client.field338.field2054, 0, 2);
               client.field338.field2061 = 0;
               client.field532 = client.field338.method2612();

               try {
                  class135.method2971(client.field289, "zap");
               } catch (Throwable var11) {
                  ;
               }

               client.field420 = 10;
            }

            if(client.field420 != 10) {
               if(client.field420 == 11 && class8.field150.method3081() >= 2) {
                  client.field338.field2061 = 0;
                  class8.field150.method3082(client.field338.field2054, 0, 2);
                  client.field338.field2061 = 0;
                  class10.field179 = client.field338.method2612();
                  client.field420 = 12;
               }

               if(client.field420 == 12 && class8.field150.method3081() >= class10.field179) {
                  client.field338.field2061 = 0;
                  class8.field150.method3082(client.field338.field2054, 0, class10.field179);
                  client.field338.field2061 = 0;
                  String var19 = client.field338.method2617();
                  String var20 = client.field338.method2617();
                  String var9 = client.field338.method2617();
                  class117.method2529(var19, var20, var9);
                  class92.method2179(10);
               }

               if(client.field420 == 13) {
                  if(client.field532 == -1) {
                     if(class8.field150.method3081() < 2) {
                        return;
                     }

                     class8.field150.method3082(client.field338.field2054, 0, 2);
                     client.field338.field2061 = 0;
                     client.field532 = client.field338.method2612();
                  }

                  if(class8.field150.method3081() >= client.field532) {
                     class8.field150.method3082(client.field338.field2054, 0, client.field532);
                     client.field338.field2061 = 0;
                     var0 = client.field532;
                     class134.method2945();
                     class165.method3279(client.field338);
                     if(var0 != client.field338.field2061) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++client.field565;
                  if(client.field565 > 2000) {
                     if(client.field328 < 1) {
                        if(class101.field1745 == class62.field1280) {
                           class101.field1745 = class40.field911;
                        } else {
                           class101.field1745 = class62.field1280;
                        }

                        ++client.field328;
                        client.field420 = 0;
                     } else {
                        class48.method1049(-3);
                     }
                  }
               }
            } else {
               if(class8.field150.method3081() >= client.field532) {
                  client.field338.field2061 = 0;
                  class8.field150.method3082(client.field338.field2054, 0, client.field532);
                  client.field304 = -1L;
                  client.field307 = -1;
                  class175.field2782.field214 = 0;
                  class59.field1263 = true;
                  client.field538 = true;
                  client.field521 = -1L;
                  class214.field3177 = new class205();
                  client.field336.field2061 = 0;
                  client.field338.field2061 = 0;
                  client.field549 = -1;
                  client.field343 = -1;
                  client.field434 = -1;
                  client.field345 = -1;
                  client.field442 = 0;
                  client.field310 = 0;
                  client.field478 = 0;
                  client.field294 = 0;
                  client.field435 = 0;
                  client.field540 = false;
                  class218.method4041(0);
                  class20.method538();
                  client.field459 = 0;
                  client.field448 = false;
                  client.field535 = 0;
                  client.field358 = (int)(Math.random() * 100.0D) - 50;
                  client.field360 = (int)(Math.random() * 110.0D) - 55;
                  client.field362 = (int)(Math.random() * 80.0D) - 40;
                  client.field365 = (int)(Math.random() * 120.0D) - 60;
                  client.field327 = (int)(Math.random() * 30.0D) - 20;
                  client.field514 = (int)(Math.random() * 20.0D) - 10 & 2047;
                  client.field531 = 0;
                  client.field554 = -1;
                  client.field529 = 0;
                  client.field530 = 0;
                  client.field320 = class21.field594;
                  client.field321 = class21.field594;
                  client.field332 = 0;
                  class33.method716();

                  for(var0 = 0; var0 < 2048; ++var0) {
                     client.field467[var0] = null;
                  }

                  for(var0 = 0; var0 < '耀'; ++var0) {
                     client.field331[var0] = null;
                  }

                  client.field425 = -1;
                  client.field428.method3917();
                  client.field429.method3917();

                  for(var0 = 0; var0 < 4; ++var0) {
                     for(var1 = 0; var1 < 104; ++var1) {
                        for(var2 = 0; var2 < 104; ++var2) {
                           client.field426[var0][var1][var2] = null;
                        }
                     }
                  }

                  client.field427 = new class202();
                  client.field416 = 0;
                  client.field511 = 0;
                  client.field346 = 0;

                  for(var0 = 0; var0 < class56.field1229; ++var0) {
                     class56 var10 = class113.method2510(var0);
                     if(var10 != null) {
                        class179.field2946[var0] = 0;
                        class179.field2944[var0] = 0;
                     }
                  }

                  class11.field187.method186();
                  client.field462 = -1;
                  if(client.field454 != -1) {
                     var0 = client.field454;
                     if(var0 != -1 && class176.field2785[var0]) {
                        class176.field2834.method3359(var0);
                        if(null != class176.field2811[var0]) {
                           var15 = true;

                           for(var2 = 0; var2 < class176.field2811[var0].length; ++var2) {
                              if(class176.field2811[var0][var2] != null) {
                                 if(class176.field2811[var0][var2].field2796 != 2) {
                                    class176.field2811[var0][var2] = null;
                                 } else {
                                    var15 = false;
                                 }
                              }
                           }

                           if(var15) {
                              class176.field2811[var0] = null;
                           }

                           class176.field2785[var0] = false;
                        }
                     }
                  }

                  for(class3 var18 = (class3)client.field455.method3867(); null != var18; var18 = (class3)client.field455.method3868()) {
                     class214.method4018(var18, true);
                  }

                  client.field454 = -1;
                  client.field455 = new class199(8);
                  client.field371 = null;
                  client.field540 = false;
                  client.field435 = 0;
                  client.field568.method3569((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

                  for(var0 = 0; var0 < 8; ++var0) {
                     client.field422[var0] = null;
                     client.field423[var0] = false;
                  }

                  class6.method92();
                  client.field302 = true;

                  for(var0 = 0; var0 < 100; ++var0) {
                     client.field500[var0] = true;
                  }

                  class87.method1995();
                  client.field522 = null;
                  class21.field596 = 0;
                  class22.field603 = null;

                  for(var0 = 0; var0 < 8; ++var0) {
                     client.field487[var0] = new class223();
                  }

                  class9.field172 = null;
                  class165.method3279(client.field338);
                  class13.field215 = -1;
                  class134.method2961(false);
                  client.field549 = -1;
               }

            }
         }
      } catch (IOException var13) {
         if(client.field328 < 1) {
            if(class101.field1745 == class62.field1280) {
               class101.field1745 = class40.field911;
            } else {
               class101.field1745 = class62.field1280;
            }

            ++client.field328;
            client.field420 = 0;
         } else {
            class48.method1049(-2);
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)V",
      garbageValue = "869467871"
   )
   static final void method1086(class125 var0) {
      for(int var1 = 0; var1 < class34.field806; ++var1) {
         int var2 = class34.field796[var1];
         class2 var3 = client.field467[var2];
         int var4 = var0.method2610();
         if((var4 & 2) != 0) {
            var4 += var0.method2610() << 8;
         }

         class26.method595(var0, var2, var3, var4);
      }

   }
}
