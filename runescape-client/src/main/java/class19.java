import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
@Implements("ChatMessages")
public class class19 {
   @ObfuscatedName("r")
   @Export("messages")
   String[] field264;
   @ObfuscatedName("g")
   boolean[] field266;
   @ObfuscatedName("h")
   boolean[] field267;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 7554784582843396999L
   )
   long field268;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = -1396226657
   )
   @Export("cameraYaw")
   static int field269;
   @ObfuscatedName("f")
   boolean field270 = false;
   @ObfuscatedName("x")
   static int[] field271;
   @ObfuscatedName("bd")
   static class168 field272;
   @ObfuscatedName("mj")
   @ObfuscatedGetter(
      intValue = 125479439
   )
   static int field274;
   @ObfuscatedName("z")
   int[] field275;
   @ObfuscatedName("mi")
   @Export("clanMembers")
   static class24[] field278;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "243251702"
   )
   void method180(int var1, int var2) {
      this.field275[var1] = var2;
      if(this.field266[var1]) {
         this.field270 = true;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "144155132"
   )
   int method181(int var1) {
      return this.field275[var1];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-194867605"
   )
   void method182(int var1, String var2) {
      this.field264[var1] = var2;
      if(this.field267[var1]) {
         this.field270 = true;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "0"
   )
   String method183(int var1) {
      return this.field264[var1];
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1822251435"
   )
   boolean method184() {
      return this.field270;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZI)Lclass227;",
      garbageValue = "1"
   )
   class227 method185(boolean var1) {
      return class17.method170("2", class214.field3158.field2316, var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-3564"
   )
   void method187() {
      class227 var1 = this.method185(false);

      label192: {
         try {
            byte[] var2 = new byte[(int)var1.method4075()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method4086(var2, var3, var2.length - var3);
               if(var4 == -1) {
                  throw new EOFException();
               }
            }

            class119 var13 = new class119(var2);
            if(var13.field2001.length - var13.field2000 >= 1) {
               int var14 = var13.method2494();
               if(var14 < 0 || var14 > 1) {
                  return;
               }

               int var15 = var13.method2470();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var15; ++var7) {
                  var8 = var13.method2470();
                  var9 = var13.method2505();
                  if(this.field266[var8]) {
                     this.field275[var8] = var9;
                  }
               }

               var7 = var13.method2470();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label192;
                  }

                  var9 = var13.method2470();
                  String var10 = var13.method2476();
                  if(this.field267[var9]) {
                     this.field264[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var24) {
            break label192;
         } finally {
            try {
               var1.method4074();
            } catch (Exception var23) {
               ;
            }

         }

         return;
      }

      this.field270 = false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1830233608"
   )
   void method188() {
      if(this.field270 && this.field268 < class124.method2746() - 60000L) {
         this.method206();
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "328876812"
   )
   static final void method189() {
      int var0;
      if(client.field442 != -1) {
         var0 = client.field442;
         if(class173.method3380(var0)) {
            class27.method628(class216.field3168[var0], -1);
         }
      }

      for(var0 = 0; var0 < client.field485; ++var0) {
         if(client.field396[var0]) {
            client.field488[var0] = true;
         }

         client.field546[var0] = client.field396[var0];
         client.field396[var0] = false;
      }

      client.field468 = client.field332;
      client.field431 = -1;
      client.field375 = -1;
      class11.field177 = null;
      int var1;
      int var2;
      int var3;
      if(client.field442 != -1) {
         client.field485 = 0;
         var0 = client.field442;
         var1 = class10.field162;
         var2 = class41.field966;
         if(!class173.method3380(var0)) {
            for(var3 = 0; var3 < 100; ++var3) {
               client.field396[var3] = true;
            }
         } else {
            class1.field18 = null;
            class5.method65(class216.field3168[var0], -1, 0, 0, var1, var2, 0, 0, -1);
            if(class1.field18 != null) {
               class5.method65(class1.field18, -1412584499, 0, 0, var1, var2, class49.field1102, class24.field624, -1);
               class1.field18 = null;
            }
         }
      }

      class79.method1794();
      int var5;
      int var6;
      int var7;
      if(!client.field423) {
         if(client.field431 != -1) {
            var0 = client.field431;
            var1 = client.field375;
            if(client.field294 >= 2 || client.field379 != 0 || client.field437) {
               String var12;
               if(client.field379 == 1 && client.field294 < 2) {
                  var12 = "Use" + " " + client.field463 + " " + "->";
               } else if(client.field437 && client.field294 < 2) {
                  var12 = client.field432 + " " + client.field441 + " " + "->";
               } else {
                  var12 = class45.method929(client.field294 - 1);
               }

               if(client.field294 > 2) {
                  var12 = var12 + class155.method3132(16777215) + " " + '/' + " " + (client.field294 - 2) + " more options";
               }

               class4.field79.method4002(var12, var0 + 4, 15 + var1, 16777215, 0, client.field332 / 1000);
            }
         }
      } else {
         var0 = class40.field965;
         var1 = class27.field668;
         var2 = class140.field2176;
         var3 = class26.field653;
         int var13 = 6116423;
         class79.method1785(var0, var1, var2, var3, var13);
         class79.method1785(1 + var0, 1 + var1, var2 - 2, 16, 0);
         class79.method1772(1 + var0, 18 + var1, var2 - 2, var3 - 19, 0);
         class4.field79.method3968("Choose Option", var0 + 3, var1 + 14, var13, -1);
         var5 = class140.field2192;
         var6 = class140.field2189;

         for(var7 = 0; var7 < client.field294; ++var7) {
            int var8 = var1 + 31 + 15 * (client.field294 - 1 - var7);
            int var14 = 16777215;
            if(var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < var8 + 3) {
               var14 = 16776960;
            }

            class4.field79.method3968(class45.method929(var7), var0 + 3, var8, var14, 0);
         }

         class99.method2157(class40.field965, class27.field668, class140.field2176, class26.field653);
      }

      if(client.field494 == 3) {
         for(var0 = 0; var0 < client.field485; ++var0) {
            if(client.field546[var0]) {
               class79.method1758(client.field490[var0], client.field436[var0], client.field535[var0], client.field493[var0], 16711935, 128);
            } else if(client.field488[var0]) {
               class79.method1758(client.field490[var0], client.field436[var0], client.field535[var0], client.field493[var0], 16711680, 128);
            }
         }
      }

      var0 = class32.field754;
      var1 = class152.field2301.field809;
      var2 = class152.field2301.field804;
      var3 = client.field330;

      for(class23 var4 = (class23)class23.field599.method3797(); null != var4; var4 = (class23)class23.field599.method3779()) {
         if(var4.field602 != -1 || null != var4.field606) {
            var5 = 0;
            if(var1 > var4.field612) {
               var5 += var1 - var4.field612;
            } else if(var1 < var4.field595) {
               var5 += var4.field595 - var1;
            }

            if(var2 > var4.field605) {
               var5 += var2 - var4.field605;
            } else if(var2 < var4.field609) {
               var5 += var4.field609 - var2;
            }

            if(var5 - 64 <= var4.field601 && client.field374 != 0 && var0 == var4.field596) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               var6 = (var4.field601 - var5) * client.field374 / var4.field601;
               class58 var10000;
               if(null == var4.field603) {
                  if(var4.field602 >= 0) {
                     var10000 = (class58)null;
                     class58 var15 = class58.method1206(class42.field1000, var4.field602, 0);
                     if(var15 != null) {
                        class62 var11 = var15.method1207().method1239(class51.field1164);
                        class64 var9 = class64.method1263(var11, 100, var6);
                        var9.method1266(-1);
                        class129.field2065.method1094(var9);
                        var4.field603 = var9;
                     }
                  }
               } else {
                  var4.field603.method1267(var6);
               }

               if(null == var4.field600) {
                  if(var4.field606 != null && (var4.field607 -= var3) <= 0) {
                     var7 = (int)(Math.random() * (double)var4.field606.length);
                     var10000 = (class58)null;
                     class58 var17 = class58.method1206(class42.field1000, var4.field606[var7], 0);
                     if(null != var17) {
                        class62 var16 = var17.method1207().method1239(class51.field1164);
                        class64 var10 = class64.method1263(var16, 100, var6);
                        var10.method1266(0);
                        class129.field2065.method1094(var10);
                        var4.field600 = var10;
                        var4.field607 = var4.field597 + (int)(Math.random() * (double)(var4.field604 * 992715 - var4.field597));
                     }
                  }
               } else {
                  var4.field600.method1267(var6);
                  if(!var4.field600.method3864()) {
                     var4.field600 = null;
                  }
               }
            } else {
               if(null != var4.field603) {
                  class129.field2065.method1092(var4.field603);
                  var4.field603 = null;
               }

               if(var4.field600 != null) {
                  class129.field2065.method1092(var4.field600);
                  var4.field600 = null;
               }
            }
         }
      }

      client.field330 = 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1734212409"
   )
   void method192() {
      int var1;
      for(var1 = 0; var1 < this.field275.length; ++var1) {
         if(!this.field266[var1]) {
            this.field275[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.field264.length; ++var1) {
         if(!this.field267[var1]) {
            this.field264[var1] = null;
         }
      }

   }

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-992021743"
   )
   static boolean method202(String var0) {
      if(null == var0) {
         return false;
      } else {
         String var1 = class36.method723(var0, class96.field1641);

         for(int var2 = 0; var2 < client.field553; ++var2) {
            class7 var3 = client.field400[var2];
            if(var1.equalsIgnoreCase(class36.method723(var3.field135, class96.field1641))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class36.method723(var3.field134, class96.field1641))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1397486232"
   )
   void method206() {
      class227 var1 = this.method185(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field275.length; ++var4) {
            if(this.field266[var4] && this.field275[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.field264.length; ++var5) {
            if(this.field267[var5] && this.field264[var5] != null) {
               var2 += 2 + class102.method2237(this.field264[var5]);
               ++var4;
            }
         }

         class119 var9 = new class119(var2);
         var9.method2453(1);
         var9.method2454(var3);

         int var6;
         for(var6 = 0; var6 < this.field275.length; ++var6) {
            if(this.field266[var6] && this.field275[var6] != -1) {
               var9.method2454(var6);
               var9.method2456(this.field275[var6]);
            }
         }

         var9.method2454(var4);

         for(var6 = 0; var6 < this.field264.length; ++var6) {
            if(this.field267[var6] && null != this.field264[var6]) {
               var9.method2454(var6);
               var9.method2586(this.field264[var6]);
            }
         }

         var1.method4073(var9.field2001, 0, var9.field2000);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method4074();
         } catch (Exception var16) {
            ;
         }

      }

      this.field270 = false;
      this.field268 = class124.method2746();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-260363935"
   )
   public static void method213() {
      class42.field980.method3717();
      class42.field984.method3717();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;IZI)Lclass103;",
      garbageValue = "0"
   )
   public static class103 method214(class167 var0, class167 var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.method3230(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.method3240(var2, var5[var6]);
         if(var7 == null) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9 = var1.method3240(var8, 0);
            if(null == var9) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new class103(var0, var1, var2, var3);
         } catch (Exception var11) {
            return null;
         }
      }
   }

   class19() {
      this.field275 = new int[class144.field2241.method3231(19)];
      this.field264 = new String[class144.field2241.method3231(15)];
      this.field266 = new boolean[this.field275.length];

      int var1;
      byte[] var4;
      for(var1 = 0; var1 < this.field275.length; ++var1) {
         class45 var3 = (class45)class45.field1042.method3716((long)var1);
         class45 var2;
         if(var3 != null) {
            var2 = var3;
         } else {
            var4 = class45.field1046.method3221(19, var1);
            var3 = new class45();
            if(var4 != null) {
               var3.method922(new class119(var4));
            }

            class45.field1042.method3724(var3, (long)var1);
            var2 = var3;
         }

         this.field266[var1] = var2.field1044;
      }

      this.field267 = new boolean[this.field264.length];

      for(var1 = 0; var1 < this.field264.length; ++var1) {
         class49 var6 = (class49)class49.field1098.method3716((long)var1);
         class49 var5;
         if(var6 != null) {
            var5 = var6;
         } else {
            var4 = class49.field1099.method3221(15, var1);
            var6 = new class49();
            if(var4 != null) {
               var6.method974(new class119(var4));
            }

            class49.field1098.method3724(var6, (long)var1);
            var5 = var6;
         }

         this.field267[var1] = var5.field1097;
      }

      for(var1 = 0; var1 < this.field275.length; ++var1) {
         this.field275[var1] = -1;
      }

      this.method187();
   }
}
