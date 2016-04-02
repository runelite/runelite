import java.awt.Canvas;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public class class12 extends class85 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1862454699
   )
   int field181;
   @ObfuscatedName("bj")
   static class80[] field182;
   @ObfuscatedName("g")
   class42 field183;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2096111175
   )
   int field184;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1840370199
   )
   int field185;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1045486437
   )
   int field186;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1827074475
   )
   int field188;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -604977949
   )
   int field189;
   @ObfuscatedName("en")
   static class80[] field190;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1734345687
   )
   int field191;
   @ObfuscatedName("qn")
   public static Canvas field192;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 469805473
   )
   int field193;

   class12(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, class85 var9) {
      this.field181 = var1;
      this.field193 = var2;
      this.field188 = var3;
      this.field184 = var4;
      this.field185 = var5;
      this.field186 = var6;
      if(var7 != -1) {
         this.field183 = class46.method974(var7);
         this.field191 = 0;
         this.field189 = client.field289 - 1;
         if(0 == this.field183.field971 && var9 != null && var9 instanceof class12) {
            class12 var10 = (class12)var9;
            if(this.field183 == var10.field183) {
               this.field191 = var10.field191;
               this.field189 = var10.field189;
               return;
            }
         }

         if(var8 && this.field183.field965 != -1) {
            this.field191 = (int)(Math.random() * (double)this.field183.field975.length);
            this.field189 -= (int)(Math.random() * (double)this.field183.field968[this.field191]);
         }
      }

   }

   @ObfuscatedName("f")
   protected final class105 vmethod1921() {
      if(this.field183 != null) {
         int var1 = client.field289 - this.field189;
         if(var1 > 100 && this.field183.field965 > 0) {
            var1 = 100;
         }

         label67: {
            do {
               do {
                  if(var1 <= this.field183.field968[this.field191]) {
                     break label67;
                  }

                  var1 -= this.field183.field968[this.field191];
                  ++this.field191;
               } while(this.field191 < this.field183.field975.length);

               this.field191 -= this.field183.field965;
            } while(this.field191 >= 0 && this.field191 < this.field183.field975.length);

            this.field183 = null;
         }

         this.field189 = client.field289 - var1;
      }

      class40 var12 = class26.method633(this.field181);
      if(var12.field923 != null) {
         var12 = var12.method797();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field188 != 1 && this.field188 != 3) {
            var2 = var12.field908;
            var3 = var12.field915;
         } else {
            var2 = var12.field915;
            var3 = var12.field908;
         }

         int var4 = (var2 >> 1) + this.field185;
         int var5 = (var2 + 1 >> 1) + this.field185;
         int var6 = this.field186 + (var3 >> 1);
         int var7 = this.field186 + (1 + var3 >> 1);
         int[][] var8 = class5.field90[this.field184];
         int var9 = var8[var4][var6] + var8[var5][var6] + var8[var4][var7] + var8[var5][var7] >> 2;
         int var10 = (this.field185 << 7) + (var2 << 6);
         int var11 = (var3 << 6) + (this.field186 << 7);
         return var12.method795(this.field193, this.field188, var8, var10, var9, var11, this.field183, this.field191);
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1235611013"
   )
   static final void method161() {
      int var0;
      if(-1 != client.field438) {
         var0 = client.field438;
         if(class113.method2462(var0)) {
            class13.method164(class173.field2837[var0], -1);
         }
      }

      for(var0 = 0; var0 < client.field465; ++var0) {
         if(client.field483[var0]) {
            client.field484[var0] = true;
         }

         client.field414[var0] = client.field483[var0];
         client.field483[var0] = false;
      }

      client.field379 = client.field289;
      client.field511 = -1;
      client.field428 = -1;
      class143.field2182 = null;
      if(-1 != client.field438) {
         client.field465 = 0;
         class17.method182(client.field438, 0, 0, class35.field762, class21.field575, 0, 0, -1);
      }

      class79.method1802();
      if(!client.field331) {
         if(client.field511 != -1) {
            class127.method2812(client.field511, client.field428);
         }
      } else {
         var0 = class126.field2034;
         int var1 = class107.field1857;
         int var2 = class161.field2642;
         int var3 = client.field320;
         int var4 = 6116423;
         class79.method1809(var0, var1, var2, var3, var4);
         class79.method1809(1 + var0, var1 + 1, var2 - 2, 16, 0);
         class79.method1801(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
         class124.field2022.method4019("Choose Option", 3 + var0, var1 + 14, var4, -1);
         int var5 = class140.field2140;
         int var6 = class140.field2141;

         int var7;
         int var8;
         int var9;
         for(var7 = 0; var7 < client.field420; ++var7) {
            var8 = (client.field420 - 1 - var7) * 15 + var1 + 31;
            var9 = 16777215;
            if(var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < 3 + var8) {
               var9 = 16776960;
            }

            class124.field2022.method4019(class84.method1917(var7), 3 + var0, var8, var9, 0);
         }

         var7 = class126.field2034;
         var8 = class107.field1857;
         var9 = class161.field2642;
         int var10 = client.field320;

         for(int var11 = 0; var11 < client.field465; ++var11) {
            if(client.field486[var11] + client.field354[var11] > var7 && client.field486[var11] < var7 + var9 && client.field489[var11] + client.field487[var11] > var8 && client.field487[var11] < var8 + var10) {
               client.field484[var11] = true;
            }
         }
      }

      if(-755309 * client.field490 == 3) {
         for(var0 = 0; var0 < client.field465; ++var0) {
            if(client.field414[var0]) {
               class79.method1808(client.field486[var0], client.field487[var0], client.field354[var0], client.field489[var0], 16711935, 128);
            } else if(client.field484[var0]) {
               class79.method1808(client.field486[var0], client.field487[var0], client.field354[var0], client.field489[var0], 16711680, 128);
            }
         }
      }

      class31.method700(class48.field1063, class20.field572.field804, class20.field572.field814, client.field355);
      client.field355 = 0;
   }

   @ObfuscatedName("w")
   static final int method162(long var0, String var2) {
      Random var3 = new Random();
      class119 var4 = new class119(128);
      class119 var5 = new class119(128);
      int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
      var4.method2565(10);

      int var7;
      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2617(var3.nextInt());
      }

      var4.method2617(var6[0]);
      var4.method2617(var6[1]);
      var4.method2580(var0);
      var4.method2580(0L);

      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2617(var3.nextInt());
      }

      var4.method2641(class9.field154, class9.field161);
      var5.method2565(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.method2617(var3.nextInt());
      }

      var5.method2580(var3.nextLong());
      var5.method2646(var3.nextLong());
      class1.method17(var5);
      var5.method2580(var3.nextLong());
      var5.method2641(class9.field154, class9.field161);
      var7 = class47.method982(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      class119 var8 = new class119(var7);
      var8.method2514(var2);
      var8.field1976 = var7;
      var8.method2539(var6);
      class119 var9 = new class119(5 + var4.field1976 + var5.field1976 + var8.field1976);
      var9.method2565(2);
      var9.method2565(var4.field1976);
      var9.method2517(var4.field1980, 0, var4.field1976);
      var9.method2565(var5.field1976);
      var9.method2517(var5.field1980, 0, var5.field1976);
      var9.method2713(var8.field1976);
      var9.method2517(var8.field1980, 0, var8.field1976);
      String var10 = class134.method2853(var9.field1980);

      try {
         URL var11 = new URL(class25.method631("services", false) + "m=accountappeal/login.ws");
         URLConnection var12 = var11.openConnection();
         var12.setDoInput(true);
         var12.setDoOutput(true);
         var12.setConnectTimeout(5000);
         OutputStreamWriter var13 = new OutputStreamWriter(var12.getOutputStream());
         var13.write("data2=" + class50.method1005(var10) + "&dest=" + class50.method1005("passwordchoice.ws"));
         var13.flush();
         InputStream var14 = var12.getInputStream();
         var9 = new class119(new byte[1000]);

         do {
            int var15 = var14.read(var9.field1980, var9.field1976, 1000 - var9.field1976);
            if(-1 == var15) {
               var13.close();
               var14.close();
               String var20 = new String(var9.field1980);
               if(var20.startsWith("OFFLINE")) {
                  return 4;
               } else if(var20.startsWith("WRONG")) {
                  return 7;
               } else if(var20.startsWith("RELOAD")) {
                  return 3;
               } else if(var20.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var9.method2540(var6);

                  while(var9.field1976 > 0 && 0 == var9.field1980[var9.field1976 - 1]) {
                     --var9.field1976;
                  }

                  var20 = new String(var9.field1980, 0, var9.field1976);
                  boolean var16;
                  if(var20 == null) {
                     var16 = false;
                  } else {
                     label83: {
                        try {
                           new URL(var20);
                        } catch (MalformedURLException var18) {
                           var16 = false;
                           break label83;
                        }

                        var16 = true;
                     }
                  }

                  if(var16) {
                     class144.method3102(var20, true, false);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var9.field1976 += var15;
         } while(var9.field1976 < 1000);

         return 5;
      } catch (Throwable var19) {
         var19.printStackTrace();
         return 5;
      }
   }
}
