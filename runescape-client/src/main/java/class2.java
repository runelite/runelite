import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class2 {
   @ObfuscatedName("i")
   public final XGrandExchangeOffer field15;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = -676636107
   )
   static int field16;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -8223196780820069427L
   )
   public final long field17;
   @ObfuscatedName("a")
   String field18;
   @ObfuscatedName("f")
   String field19;
   @ObfuscatedName("nf")
   @ObfuscatedGetter(
      intValue = -2058878297
   )
   static int field20;
   @ObfuscatedName("pc")
   static class30 field21;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1204721571
   )
   public final int field22;

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZI)V",
      garbageValue = "789121162"
   )
   static void method17(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2197 == 0) {
         var0.width = var0.field2237;
      } else if(var0.field2197 == 1) {
         var0.width = var1 - var0.field2237;
      } else if(var0.field2197 == 2) {
         var0.width = var1 * var0.field2237 >> 14;
      }

      if(var0.field2193 == 0) {
         var0.height = var0.field2279;
      } else if(var0.field2193 == 1) {
         var0.height = var2 - var0.field2279;
      } else if(var0.field2193 == 2) {
         var0.height = var2 * var0.field2279 >> 14;
      }

      if(var0.field2197 == 4) {
         var0.width = var0.height * var0.field2202 / var0.field2221;
      }

      if(var0.field2193 == 4) {
         var0.height = var0.field2221 * var0.width / var0.field2202;
      }

      if(Client.field414 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field452 = var0;
      }

      if(var3 && var0.field2227 != null && (var4 != var0.width || var5 != var0.height)) {
         class18 var6 = new class18();
         var6.field195 = var0;
         var6.field203 = var0.field2227;
         Client.field479.method2394(var6);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-707508221"
   )
   public String method18() {
      return this.field18;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIB)I",
      garbageValue = "-1"
   )
   static final int method19(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class84.field1428[var2 * 1024 / var3] >> 1;
      return (var4 * var1 >> 16) + (var0 * (65536 - var4) >> 16);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1407773383"
   )
   public String method20() {
      return this.field19;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZI)V",
      garbageValue = "1640180700"
   )
   public static void method24(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class114.field1775.startsWith("win") && !var3) {
            Sequence.method3783(var0, 0, "openjs");
            return;
         }

         if(class114.field1775.startsWith("mac")) {
            Sequence.method3783(var0, 1, var2);
            return;
         }

         Sequence.method3783(var0, 2, "openjs");
      } else {
         Sequence.method3783(var0, 3, "openjs");
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass184;IIIBZB)V",
      garbageValue = "0"
   )
   static void method25(class184 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)(var2 + (var1 << 16));
      class181 var8 = (class181)class185.field2724.method2339(var6);
      if(var8 == null) {
         var8 = (class181)class185.field2726.method2339(var6);
         if(null == var8) {
            var8 = (class181)class185.field2727.method2339(var6);
            if(null != var8) {
               if(var5) {
                  var8.method2413();
                  class185.field2724.method2340(var8, var6);
                  --class185.field2734;
                  ++class185.field2725;
               }
            } else {
               if(!var5) {
                  var8 = (class181)class185.field2731.method2339(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new class181();
               var8.field2680 = var0;
               var8.field2678 = var3;
               var8.field2677 = var4;
               if(var5) {
                  class185.field2724.method2340(var8, var6);
                  ++class185.field2725;
               } else {
                  class185.field2728.method2292(var8);
                  class185.field2727.method2340(var8, var6);
                  ++class185.field2734;
               }
            }
         }
      }

   }

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-2087962034"
   )
   static final boolean method26(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field336 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field560.method3120(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field560.method3121(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field560.method3155(false);
         }

         if(var1 == 325) {
            Client.field560.method3155(true);
         }

         if(var1 == 326) {
            Client.field326.method3029(130);
            Client.field560.method3123(Client.field326);
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-471686663"
   )
   static final void method28(int var0, int var1, int var2, int var3) {
      Client.field376 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class45.field888;
      int[] var7 = class45.field892;

      int var8;
      for(var8 = 0; var8 < var6 + Client.field322; ++var8) {
         Object var9;
         if(var8 < var6) {
            var9 = Client.cachedPlayers[var7[var8]];
            if(Client.field412 == var7[var8]) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var9 = Client.cachedNPCs[Client.field483[var8 - var6]];
         }

         class44.method796((Actor)var9, var8, var0, var1, var2, var3);
      }

      if(var4) {
         class44.method796(Client.cachedPlayers[Client.field412], var5, var0, var1, var2, var3);
      }

      for(var8 = 0; var8 < Client.field376; ++var8) {
         int var18 = Client.field378[var8];
         int var10 = Client.field439[var8];
         int var11 = Client.field381[var8];
         int var12 = Client.field380[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var14 = 0; var14 < var8; ++var14) {
               if(2 + var10 > Client.field439[var14] - Client.field380[var14] && var10 - var12 < 2 + Client.field439[var14] && var18 - var11 < Client.field378[var14] + Client.field381[var14] && var11 + var18 > Client.field378[var14] - Client.field381[var14] && Client.field439[var14] - Client.field380[var14] < var10) {
                  var10 = Client.field439[var14] - Client.field380[var14];
                  var13 = true;
               }
            }
         }

         Client.field388 = Client.field378[var8];
         Client.field491 = Client.field439[var8] = var10;
         String var19 = Client.field423[var8];
         if(Client.field445 == 0) {
            int var15 = 16776960;
            if(Client.field443[var8] < 6) {
               var15 = Client.field497[Client.field443[var8]];
            }

            if(Client.field443[var8] == 6) {
               var15 = Client.field387 % 20 < 10?16711680:16776960;
            }

            if(Client.field443[var8] == 7) {
               var15 = Client.field387 % 20 < 10?255:'\uffff';
            }

            if(Client.field443[var8] == 8) {
               var15 = Client.field387 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(Client.field443[var8] == 9) {
               var16 = 150 - Client.field384[var8];
               if(var16 < 50) {
                  var15 = 1280 * var16 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16776960 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = '\uff00' + 5 * (var16 - 100);
               }
            }

            if(Client.field443[var8] == 10) {
               var16 = 150 - Client.field384[var8];
               if(var16 < 50) {
                  var15 = 16711680 + var16 * 5;
               } else if(var16 < 100) {
                  var15 = 16711935 - 327680 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = 255 + 327680 * (var16 - 100) - 5 * (var16 - 100);
               }
            }

            if(Client.field443[var8] == 11) {
               var16 = 150 - Client.field384[var8];
               if(var16 < 50) {
                  var15 = 16777215 - 327685 * var16;
               } else if(var16 < 100) {
                  var15 = '\uff00' + (var16 - 50) * 327685;
               } else if(var16 < 150) {
                  var15 = 16777215 - 327680 * (var16 - 100);
               }
            }

            if(Client.field407[var8] == 0) {
               class97.field1621.method3870(var19, Client.field388 + var0, Client.field491 + var1, var15, 0);
            }

            if(Client.field407[var8] == 1) {
               class97.field1621.method3913(var19, Client.field388 + var0, Client.field491 + var1, var15, 0, Client.field387);
            }

            if(Client.field407[var8] == 2) {
               class97.field1621.method3925(var19, Client.field388 + var0, var1 + Client.field491, var15, 0, Client.field387);
            }

            if(Client.field407[var8] == 3) {
               class97.field1621.method3898(var19, Client.field388 + var0, var1 + Client.field491, var15, 0, Client.field387, 150 - Client.field384[var8]);
            }

            if(Client.field407[var8] == 4) {
               var16 = (150 - Client.field384[var8]) * (class97.field1621.method3874(var19) + 100) / 150;
               class219.method4000(Client.field388 + var0 - 50, var1, var0 + Client.field388 + 50, var3 + var1);
               class97.field1621.method3867(var19, 50 + Client.field388 + var0 - var16, Client.field491 + var1, var15, 0);
               class219.method3965(var0, var1, var0 + var2, var1 + var3);
            }

            if(Client.field407[var8] == 5) {
               var16 = 150 - Client.field384[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               class219.method4000(var0, var1 + Client.field491 - class97.field1621.field3087 - 1, var0 + var2, Client.field491 + var1 + 5);
               class97.field1621.method3870(var19, Client.field388 + var0, var1 + Client.field491 + var17, var15, 0);
               class219.method3965(var0, var1, var0 + var2, var1 + var3);
            }
         } else {
            class97.field1621.method3870(var19, var0 + Client.field388, Client.field491 + var1, 16776960, 0);
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-115"
   )
   static final int method29(int var0, int var1) {
      int var2 = var0 + var1 * 57;
      var2 ^= var2 << 13;
      int var3 = 1376312589 + var2 * (789221 + var2 * var2 * 15731) & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;S)V",
      garbageValue = "128"
   )
   public static void method30(class182 var0, class182 var1) {
      NPCComposition.field3002 = var0;
      Widget.field2321 = var1;
   }

   class2(Buffer var1, byte var2, int var3) {
      this.field18 = var1.method2965();
      this.field19 = var1.method2965();
      this.field22 = var1.readUnsignedShort();
      this.field17 = var1.method2908();
      int var4 = var1.method2780();
      int var5 = var1.method2780();
      this.field15 = new XGrandExchangeOffer();
      this.field15.method62(2);
      this.field15.method47(var2);
      this.field15.price = var4;
      this.field15.totalQuantity = var5;
      this.field15.quantitySold = 0;
      this.field15.spent = 0;
      this.field15.itemId = var3;
   }
}
