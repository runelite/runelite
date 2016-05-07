import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class48 extends class204 {
   @ObfuscatedName("j")
   static class193 field1073 = new class193(64);
   @ObfuscatedName("p")
   public char field1075;
   @ObfuscatedName("x")
   public char field1076;
   @ObfuscatedName("c")
   public String[] field1077;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1049064461
   )
   public int field1078;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -873116571
   )
   public int field1079 = 0;
   @ObfuscatedName("b")
   public int[] field1080;
   @ObfuscatedName("k")
   public int[] field1081;
   @ObfuscatedName("pi")
   @ObfuscatedGetter(
      intValue = -2060773005
   )
   static int field1083;
   @ObfuscatedName("s")
   public static class167 field1084;
   @ObfuscatedName("d")
   public String field1087 = "null";

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)I",
      garbageValue = "1733614446"
   )
   static int method962(class173 var0) {
      class201 var1 = (class201)client.field479.method3777((long)var0.field2766 + ((long)var0.field2826 << 32));
      return var1 != null?var1.field3111:var0.field2814;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "2129423004"
   )
   void method963(class119 var1) {
      while(true) {
         int var2 = var1.method2492();
         if(var2 == 0) {
            return;
         }

         this.method964(var1, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass119;IS)V",
      garbageValue = "4032"
   )
   void method964(class119 var1, int var2) {
      if(var2 == 1) {
         this.field1075 = (char)var1.method2492();
      } else if(2 == var2) {
         this.field1076 = (char)var1.method2492();
      } else if(var2 == 3) {
         this.field1087 = var1.method2500();
      } else if(var2 == 4) {
         this.field1078 = var1.method2497();
      } else {
         int var3;
         if(5 == var2) {
            this.field1079 = var1.method2584();
            this.field1080 = new int[this.field1079];
            this.field1077 = new String[this.field1079];

            for(var3 = 0; var3 < this.field1079; ++var3) {
               this.field1080[var3] = var1.method2497();
               this.field1077[var3] = var1.method2500();
            }
         } else if(6 == var2) {
            this.field1079 = var1.method2584();
            this.field1080 = new int[this.field1079];
            this.field1081 = new int[this.field1079];

            for(var3 = 0; var3 < this.field1079; ++var3) {
               this.field1080[var3] = var1.method2497();
               this.field1081[var3] = var1.method2497();
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;I)I",
      garbageValue = "1363634742"
   )
   static final int method965(long var0, String var2) {
      Random var3 = new Random();
      class119 var4 = new class119(128);
      class119 var5 = new class119(128);
      int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
      var4.method2477(10);

      int var7;
      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2480(var3.nextInt());
      }

      var4.method2480(var6[0]);
      var4.method2480(var6[1]);
      var4.method2482(var0);
      var4.method2482(0L);

      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2480(var3.nextInt());
      }

      var4.method2512(class9.field161, class9.field158);
      var5.method2477(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.method2480(var3.nextInt());
      }

      var5.method2482(var3.nextLong());
      var5.method2528(var3.nextLong());
      class101.method2267(var5);
      var5.method2482(var3.nextLong());
      var5.method2512(class9.field161, class9.field158);
      var7 = class30.method647(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      class119 var8 = new class119(var7);
      var8.method2483(var2);
      var8.field2005 = var7;
      var8.method2508(var6);
      class119 var9 = new class119(var8.field2005 + var5.field2005 + 5 + var4.field2005);
      var9.method2477(2);
      var9.method2477(var4.field2005);
      var9.method2486(var4.field2007, 0, var4.field2005);
      var9.method2477(var5.field2005);
      var9.method2486(var5.field2007, 0, var5.field2005);
      var9.method2661(var8.field2005);
      var9.method2486(var8.field2007, 0, var8.field2005);
      String var10 = class124.method2781(var9.field2007);

      try {
         URL var11 = new URL(class122.method2758("services", false) + "m=accountappeal/login.ws");
         URLConnection var12 = var11.openConnection();
         var12.setDoInput(true);
         var12.setDoOutput(true);
         var12.setConnectTimeout(5000);
         OutputStreamWriter var13 = new OutputStreamWriter(var12.getOutputStream());
         var13.write("data2=" + class164.method3209(var10) + "&dest=" + class164.method3209("passwordchoice.ws"));
         var13.flush();
         InputStream var14 = var12.getInputStream();
         var9 = new class119(new byte[1000]);

         do {
            int var15 = var14.read(var9.field2007, var9.field2005, 1000 - var9.field2005);
            if(var15 == -1) {
               var13.close();
               var14.close();
               String var17 = new String(var9.field2007);
               if(var17.startsWith("OFFLINE")) {
                  return 4;
               } else if(var17.startsWith("WRONG")) {
                  return 7;
               } else if(var17.startsWith("RELOAD")) {
                  return 3;
               } else if(var17.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var9.method2543(var6);

                  while(var9.field2005 > 0 && 0 == var9.field2007[var9.field2005 - 1]) {
                     --var9.field2005;
                  }

                  var17 = new String(var9.field2007, 0, var9.field2005);
                  if(class142.method2958(var17)) {
                     class103.method2275(var17, true, "openjs", false);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var9.field2005 += var15;
         } while(var9.field2005 < 1000);

         return 5;
      } catch (Throwable var16) {
         var16.printStackTrace();
         return 5;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1989990046"
   )
   public static void method972() {
      class52.field1162.method3750();
   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1718879384"
   )
   static void method973(int var0) {
      class16.field231 = new class30();
      class16.field231.field713 = client.field420[var0];
      class16.field231.field704 = client.field421[var0];
      class16.field231.field705 = client.field422[var0];
      class16.field231.field711 = client.field378[var0];
      class16.field231.field703 = client.field424[var0];
   }
}
