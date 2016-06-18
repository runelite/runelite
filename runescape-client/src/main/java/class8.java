import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Desktop.Action;
import java.net.URI;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class8 {
   @ObfuscatedName("d")
   boolean field128;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 764603745
   )
   int field131 = 1;
   @ObfuscatedName("j")
   boolean field132;
   @ObfuscatedName("y")
   LinkedHashMap field133 = new LinkedHashMap();
   @ObfuscatedName("nk")
   @ObfuscatedGetter(
      intValue = -1330065925
   )
   static int field134;
   @ObfuscatedName("c")
   public static int[] field135;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2004312153
   )
   static int field136 = 4;
   @ObfuscatedName("al")
   static class168 field137;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1760138983"
   )
   static void method96() {
      class227 var0 = null;

      try {
         var0 = class139.method2974("", client.field570.field2274, true);
         class119 var1 = class162.field2637.method116();
         var0.method4127(var1.field1982, 0, var1.field1976);
      } catch (Exception var3) {
         ;
      }

      try {
         if(null != var0) {
            var0.method4116();
         }
      } catch (Exception var2) {
         ;
      }

   }

   class8(class119 var1) {
      if(var1 != null && null != var1.field1982) {
         int var2 = var1.method2514();
         if(var2 >= 0 && var2 <= field136) {
            if(var1.method2514() == 1) {
               this.field132 = true;
            }

            if(var2 > 1) {
               this.field128 = var1.method2514() == 1;
            }

            if(var2 > 3) {
               this.field131 = var1.method2514();
            }

            if(var2 > 2) {
               int var3 = var1.method2514();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2519();
                  int var6 = var1.method2519();
                  this.field133.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method97(true);
         }
      } else {
         this.method97(true);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1741228735"
   )
   void method97(boolean var1) {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass224;Lclass224;B)V",
      garbageValue = "-1"
   )
   static void method101(class224 var0, class224 var1) {
      if(null == class123.field2015) {
         class123.field2015 = class46.method960(class129.field2038, "sl_back", "");
      }

      if(class166.field2659 == null) {
         class166.field2659 = class20.method554(class129.field2038, "sl_flags", "");
      }

      if(null == class87.field1502) {
         class87.field1502 = class20.method554(class129.field2038, "sl_arrows", "");
      }

      if(class82.field1405 == null) {
         class82.field1405 = class20.method554(class129.field2038, "sl_stars", "");
      }

      class79.method1865(class31.field695, 23, 765, 480, 0);
      class79.method1804(class31.field695, 0, 125, 23, 12425273, 9135624);
      class79.method1804(class31.field695 + 125, 0, 640, 23, 5197647, 2697513);
      var0.method4035("Select a world", class31.field695 + 62, 15, 0, -1);
      if(class82.field1405 != null) {
         class82.field1405[1].method1873(class31.field695 + 140, 1);
         var1.method4033("Members only world", class31.field695 + 152, 10, 16777215, -1);
         class82.field1405[0].method1873(140 + class31.field695, 12);
         var1.method4033("Free world", class31.field695 + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(null != class87.field1502) {
         int var2 = class31.field695 + 280;
         if(class25.field639[0] == 0 && class25.field647[0] == 0) {
            class87.field1502[2].method1873(var2, 4);
         } else {
            class87.field1502[0].method1873(var2, 4);
         }

         if(class25.field639[0] == 0 && class25.field647[0] == 1) {
            class87.field1502[3].method1873(var2 + 15, 4);
         } else {
            class87.field1502[1].method1873(15 + var2, 4);
         }

         var0.method4033("World", 32 + var2, 17, 16777215, -1);
         int var3 = class31.field695 + 390;
         if(class25.field639[0] == 1 && class25.field647[0] == 0) {
            class87.field1502[2].method1873(var3, 4);
         } else {
            class87.field1502[0].method1873(var3, 4);
         }

         if(class25.field639[0] == 1 && class25.field647[0] == 1) {
            class87.field1502[3].method1873(15 + var3, 4);
         } else {
            class87.field1502[1].method1873(var3 + 15, 4);
         }

         var0.method4033("Players", var3 + 32, 17, 16777215, -1);
         var4 = class31.field695 + 500;
         if(class25.field639[0] == 2 && class25.field647[0] == 0) {
            class87.field1502[2].method1873(var4, 4);
         } else {
            class87.field1502[0].method1873(var4, 4);
         }

         if(class25.field639[0] == 2 && class25.field647[0] == 1) {
            class87.field1502[3].method1873(15 + var4, 4);
         } else {
            class87.field1502[1].method1873(var4 + 15, 4);
         }

         var0.method4033("Location", 32 + var4, 17, 16777215, -1);
         var5 = class31.field695 + 610;
         if(class25.field639[0] == 3 && class25.field647[0] == 0) {
            class87.field1502[2].method1873(var5, 4);
         } else {
            class87.field1502[0].method1873(var5, 4);
         }

         if(class25.field639[0] == 3 && class25.field647[0] == 1) {
            class87.field1502[3].method1873(15 + var5, 4);
         } else {
            class87.field1502[1].method1873(var5 + 15, 4);
         }

         var0.method4033("Type", 32 + var5, 17, 16777215, -1);
      }

      class79.method1865(708 + class31.field695, 4, 50, 16, 0);
      var1.method4035("Cancel", class31.field695 + 708 + 25, 16, 16777215, -1);
      class31.field728 = -1;
      if(class123.field2015 != null) {
         byte var23 = 88;
         byte var24 = 19;
         var4 = 765 / (1 + var23);
         var5 = 480 / (var24 + 1);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if((var4 - 1) * var5 >= class25.field627) {
               --var4;
            }

            if(var4 * (var5 - 1) >= class25.field627) {
               --var5;
            }

            if(var4 * (var5 - 1) >= class25.field627) {
               --var5;
            }
         } while(var5 != var6 || var7 != var4);

         var6 = (765 - var23 * var4) / (var4 + 1);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var24 * var5) / (1 + var5);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var23 * var4 - (var4 - 1) * var6) / 2;
         int var9 = (480 - var5 * var24 - (var5 - 1) * var7) / 2;
         int var10 = 23 + var9;
         int var11 = var8 + class31.field695;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < class25.field627; ++var14) {
            class25 var15 = class25.field635[var14];
            boolean var16 = true;
            String var17 = Integer.toString(var15.field638);
            if(var15.field638 == -1) {
               var17 = "OFF";
               var16 = false;
            } else if(var15.field638 > 1980) {
               var17 = "FULL";
               var16 = false;
            }

            int var19 = 0;
            byte var18;
            if(var15.method600()) {
               if(var15.method627()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method614()) {
               var19 = 16711680;
               if(var15.method627()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method611()) {
               if(var15.method627()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method627()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(class140.field2134 >= var11 && class140.field2135 >= var10 && class140.field2134 < var11 + var23 && class140.field2135 < var24 + var10 && var16) {
               class31.field728 = var14;
               class123.field2015[var18].method1718(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               class123.field2015[var18].method1771(var11, var10);
            }

            if(null != class166.field2659) {
               class166.field2659[(var15.method627()?8:0) + var15.field641].method1873(29 + var11, var10);
            }

            var0.method4035(Integer.toString(var15.field636 == 374?666:var15.field636), 15 + var11, var10 + var24 / 2 + 5, var19, -1);
            var1.method4035(var17, var11 + 60, 5 + var10 + var24 / 2, 268435455, -1);
            var10 += var7 + var24;
            ++var12;
            if(var12 >= var5) {
               var10 = 23 + var9;
               var11 += var23 + var6;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method4028(class25.field635[class31.field728].field646) + 6;
            int var20 = 8 + var1.field3190;
            class79.method1865(class140.field2134 - var14 / 2, 5 + class140.field2135 + 20, var14, var20, 16777120);
            class79.method1852(class140.field2134 - var14 / 2, 20 + class140.field2135 + 5, var14, var20, 0);
            var1.method4035(class25.field635[class31.field728].field646, class140.field2134, 4 + var1.field3190 + 20 + class140.field2135 + 5, 0, -1);
         }
      }

      try {
         Graphics var21 = class46.field1040.getGraphics();
         class48.field1049.vmethod1887(var21, 0, 0);
      } catch (Exception var22) {
         class46.field1040.repaint();
      }

   }

   class8() {
      this.method97(true);
   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)Z",
      garbageValue = "-1461139894"
   )
   static final boolean method110(class173 var0) {
      int var1 = var0.field2768;
      if(var1 == 205) {
         client.field399 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            client.field339.method3487(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            client.field339.method3488(var2, var3 == 1);
         }

         if(var1 == 324) {
            client.field339.method3520(false);
         }

         if(var1 == 325) {
            client.field339.method3520(true);
         }

         if(var1 == 326) {
            client.field331.method2781(130);
            client.field339.method3492(client.field331);
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZI)V",
      garbageValue = "-522074323"
   )
   public static void method111(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class138.field2112.startsWith("win")) {
            class22.method567(var0, 0, "openjs");
            return;
         }

         if(class138.field2112.startsWith("mac")) {
            class22.method567(var0, 1, var2);
            return;
         }

         class22.method567(var0, 2, "openjs");
      } else {
         class22.method567(var0, 3, "openjs");
      }

   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(Lclass173;II)Ljava/lang/String;",
      garbageValue = "1394881889"
   )
   static String method113(class173 var0, int var1) {
      int var3 = class34.method734(var0);
      boolean var2 = (var3 >> var1 + 1 & 1) != 0;
      return !var2 && null == var0.field2848?null:(var0.field2822 != null && var0.field2822.length > var1 && var0.field2822[var1] != null && var0.field2822[var1].trim().length() != 0?var0.field2822[var1]:null);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "-104"
   )
   public static int method114(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ class119.field1984[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Lclass37;IIIIII)V",
      garbageValue = "1546450281"
   )
   static final void method115(class37 var0, int var1, int var2, int var3, int var4, int var5) {
      if(null != var0 && var0.vmethod760()) {
         if(var0 instanceof class34) {
            class39 var6 = ((class34)var0).field762;
            if(var6.field889 != null) {
               var6 = var6.method773();
            }

            if(var6 == null) {
               return;
            }
         }

         int var10 = class32.field738;
         int[] var7 = class32.field739;
         int var8;
         if(var1 < var10) {
            var8 = 30;
            class2 var9 = (class2)var0;
            if(var9.field40) {
               return;
            }

            if(var9.field35 != -1 || var9.field28 != -1) {
               class3.method36(var0, 15 + var0.field839);
               if(client.field395 > -1) {
                  if(var9.field35 != -1) {
                     class161.field2632[var9.field35].method1767(var2 + client.field395 - 12, var3 + client.field544 - var8);
                     var8 += 25;
                  }

                  if(var9.field28 != -1) {
                     class113.field1946[var9.field28].method1767(var2 + client.field395 - 12, var3 + client.field544 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && client.field323 == 10 && var7[var1] == client.field306) {
               class3.method36(var0, var0.field839 + 15);
               if(client.field395 > -1) {
                  class110.field1933[1].method1767(var2 + client.field395 - 12, var3 + client.field544 - var8);
               }
            }
         } else {
            class39 var12 = ((class34)var0).field762;
            if(var12.field889 != null) {
               var12 = var12.method773();
            }

            if(var12.field870 >= 0 && var12.field870 < class113.field1946.length) {
               class3.method36(var0, 15 + var0.field839);
               if(client.field395 > -1) {
                  class113.field1946[var12.field870].method1767(var2 + client.field395 - 12, var3 + client.field544 - 30);
               }
            }

            if(client.field323 == 1 && client.field318[var1 - var10] == client.field305 && client.field296 % 20 < 10) {
               class3.method36(var0, var0.field839 + 15);
               if(client.field395 > -1) {
                  class110.field1933[0].method1767(var2 + client.field395 - 12, client.field544 + var3 - 28);
               }
            }
         }

         if(null != var0.field803 && (var1 >= var10 || !var0.field805 && (client.field355 == 4 || !var0.field841 && (client.field355 == 0 || client.field355 == 3 || client.field355 == 1 && class11.method147(((class2)var0).field26, false))))) {
            class3.method36(var0, var0.field839);
            if(client.field395 > -1 && client.field489 < client.field384) {
               client.field388[client.field489] = class162.field2636.method4028(var0.field803) / 2;
               client.field455[client.field489] = class162.field2636.field3190;
               client.field385[client.field489] = client.field395;
               client.field386[client.field489] = client.field544;
               client.field389[client.field489] = var0.field807;
               client.field457[client.field489] = var0.field804;
               client.field391[client.field489] = var0.field806;
               client.field392[client.field489] = var0.field803;
               ++client.field489;
            }
         }

         if(var0.field812 > client.field296) {
            class3.method36(var0, var0.field839 + 15);
            if(client.field395 > -1) {
               if(var1 < var10) {
                  var8 = 30;
               } else {
                  class39 var13 = ((class34)var0).field762;
                  var8 = var13.field895;
               }

               int var11 = var0.field794 * var8 / var0.field814;
               if(var11 > var8) {
                  var11 = var8;
               } else if(var11 == 0 && var0.field794 > 0) {
                  var11 = 1;
               }

               class79.method1865(var2 + client.field395 - var8 / 2, client.field544 + var3 - 3, var11, 5, '\uff00');
               class79.method1865(var11 + (client.field395 + var2 - var8 / 2), client.field544 + var3 - 3, var8 - var11, 5, 16711680);
            }
         }

         for(var8 = 0; var8 < 4; ++var8) {
            if(var0.field790[var8] > client.field296) {
               class3.method36(var0, var0.field839 / 2);
               if(client.field395 > -1) {
                  if(var8 == 1) {
                     client.field544 -= 20;
                  }

                  if(var8 == 2) {
                     client.field395 -= 15;
                     client.field544 -= 10;
                  }

                  if(var8 == 3) {
                     client.field395 += 15;
                     client.field544 -= 10;
                  }

                  class154.field2279[var0.field810[var8]].method1767(var2 + client.field395 - 12, var3 + client.field544 - 12);
                  class43.field986.method4035(Integer.toString(var0.field809[var8]), var2 + client.field395 - 1, 3 + var3 + client.field544, 16777215, 0);
               }
            }
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lclass119;",
      garbageValue = "-336751134"
   )
   class119 method116() {
      class119 var1 = new class119(100);
      var1.method2650(field136);
      var1.method2650(this.field132?1:0);
      var1.method2650(this.field128?1:0);
      var1.method2650(this.field131);
      var1.method2650(this.field133.size());
      Iterator var2 = this.field133.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2502(((Integer)var3.getKey()).intValue());
         var1.method2502(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }
}
