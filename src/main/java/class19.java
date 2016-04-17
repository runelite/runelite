import java.io.EOFException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("h")
public class class19 {
   @ObfuscatedName("bl")
   static class168 field279;
   @ObfuscatedName("d")
   boolean[] field282;
   @ObfuscatedName("y")
   int[] field283;
   @ObfuscatedName("k")
   String[] field284;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 3881817168213788245L
   )
   long field286;
   @ObfuscatedName("c")
   boolean[] field287;
   @ObfuscatedName("r")
   boolean field288 = false;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-514636001"
   )
   void method230(int var1, int var2) {
      this.field283[var1] = var2;
      if(this.field282[var1]) {
         this.field288 = true;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-1387481618"
   )
   void method232(int var1, String var2) {
      this.field284[var1] = var2;
      if(this.field287[var1]) {
         this.field288 = true;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-102"
   )
   String method233(int var1) {
      return this.field284[var1];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ZB)Lclass227;",
      garbageValue = "1"
   )
   class227 method235(boolean var1) {
      return class11.method188("2", class1.field21.field2280, var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1315775618"
   )
   void method237() {
      class227 var1 = this.method235(false);

      label192: {
         try {
            byte[] var2 = new byte[(int)var1.method4203()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method4205(var2, var3, var2.length - var3);
               if(var4 == -1) {
                  throw new EOFException();
               }
            }

            class119 var23 = new class119(var2);
            if(var23.field1993.length - var23.field1992 >= 1) {
               int var5 = var23.method2613();
               if(var5 < 0 || var5 > 1) {
                  return;
               }

               int var6 = var23.method2615();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var23.method2615();
                  var9 = var23.method2618();
                  if(this.field282[var8]) {
                     this.field283[var8] = var9;
                  }
               }

               var7 = var23.method2615();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label192;
                  }

                  var9 = var23.method2615();
                  String var10 = var23.method2621();
                  if(this.field287[var9]) {
                     this.field284[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var21) {
            break label192;
         } finally {
            try {
               var1.method4202();
            } catch (Exception var20) {
               ;
            }

         }

         return;
      }

      this.field288 = false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1475503844"
   )
   void method238() {
      if(this.field288 && this.field286 < class127.method2941() - 60000L) {
         this.method242();
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-37"
   )
   boolean method239() {
      return this.field288;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2123678899"
   )
   void method242() {
      class227 var1 = this.method235(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field283.length; ++var4) {
            if(this.field282[var4] && -1 != this.field283[var4]) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.field284.length; ++var5) {
            if(this.field287[var5] && this.field284[var5] != null) {
               var2 += 2 + class104.method2383(this.field284[var5]);
               ++var4;
            }
         }

         class119 var17 = new class119(var2);
         var17.method2603(1);
         var17.method2599(var3);

         int var6;
         for(var6 = 0; var6 < this.field283.length; ++var6) {
            if(this.field282[var6] && -1 != this.field283[var6]) {
               var17.method2599(var6);
               var17.method2786(this.field283[var6]);
            }
         }

         var17.method2599(var4);

         for(var6 = 0; var6 < this.field284.length; ++var6) {
            if(this.field287[var6] && this.field284[var6] != null) {
               var17.method2599(var6);
               var17.method2694(this.field284[var6]);
            }
         }

         var1.method4201(var17.field1993, 0, var17.field1992);
      } catch (Exception var15) {
         ;
      } finally {
         try {
            var1.method4202();
         } catch (Exception var14) {
            ;
         }

      }

      this.field288 = false;
      this.field286 = class127.method2941();
   }

   class19() {
      this.field283 = new int[class29.field709.method3372(19)];
      this.field284 = new String[class29.field709.method3372(15)];
      this.field282 = new boolean[this.field283.length];

      int var1;
      for(var1 = 0; var1 < this.field283.length; ++var1) {
         class45 var2 = class189.method3830(var1);
         this.field282[var1] = var2.field1055;
      }

      this.field287 = new boolean[this.field284.length];

      for(var1 = 0; var1 < this.field284.length; ++var1) {
         class49 var3 = (class49)class49.field1098.method3840((long)var1);
         class49 var5;
         if(null != var3) {
            var5 = var3;
         } else {
            byte[] var4 = class49.field1101.method3403(15, var1);
            var3 = new class49();
            if(var4 != null) {
               var3.method1110(new class119(var4));
            }

            class49.field1098.method3842(var3, (long)var1);
            var5 = var3;
         }

         this.field287[var1] = var5.field1099;
      }

      for(var1 = 0; var1 < this.field283.length; ++var1) {
         this.field283[var1] = -1;
      }

      this.method237();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-9"
   )
   int method248(int var1) {
      return this.field283[var1];
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-186967501"
   )
   void method252() {
      int var1;
      for(var1 = 0; var1 < this.field283.length; ++var1) {
         if(!this.field282[var1]) {
            this.field283[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.field284.length; ++var1) {
         if(!this.field287[var1]) {
            this.field284[var1] = null;
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass167;S)V",
      garbageValue = "181"
   )
   public static void method257(class167 var0) {
      class109.field1907 = var0;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1651090563"
   )
   static final void method258(int var0, int var1, int var2, int var3) {
      if(1 == client.field467) {
         class138.field2134[client.field404 / 100].method1798(client.field402 - 8, client.field403 - 8);
      }

      if(2 == client.field467) {
         class138.field2134[client.field404 / 100 + 4].method1798(client.field402 - 8, client.field403 - 8);
      }

      client.field366 = 0;
      int var4 = (class5.field93.field844 >> 7) + class144.field2204;
      int var5 = (class5.field93.field819 >> 7) + class3.field67;
      if(var4 >= 3053 && var4 <= 3156 && var5 >= 3056 && var5 <= 3136) {
         client.field366 = 1;
      }

      if(var4 >= 3072 && var4 <= 3118 && var5 >= 9492 && var5 <= 9535) {
         client.field366 = 1;
      }

      if(client.field366 == 1 && var4 >= 3139 && var4 <= 3199 && var5 >= 3008 && var5 <= 3062) {
         client.field366 = 0;
      }

   }

   @ObfuscatedName("ea")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-174732175"
   )
   static void method259(String var0) {
      class14.field220 = var0;

      try {
         String var1 = client.field294.getParameter(class190.field3060.field3075);
         String var2 = client.field294.getParameter(class190.field3069.field3075);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var3 = var3 + "; Expires=" + class116.method2557(class127.method2941() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         client var4 = client.field294;
         String var5 = "document.cookie=\"" + var3 + "\"";
         JSObject.getWindow(var4).eval(var5);
      } catch (Throwable var6) {
         ;
      }

   }
}
