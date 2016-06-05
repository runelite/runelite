import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("VertexNormal")
public class class96 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 446902091
   )
   int field1638;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -100761863
   )
   int field1639;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2096030597
   )
   int field1640;
   @ObfuscatedName("d")
   static class212 field1641;
   @ObfuscatedName("ae")
   @Export("authCode")
   static String field1643;
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = 265830863
   )
   static int field1644;
   @ObfuscatedName("qs")
   @Export("bufferProvider")
   public static class77 field1646;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1476028109
   )
   int field1647;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;I)I",
      garbageValue = "540148151"
   )
   static final int method2151(long var0, String var2) {
      Random var3 = new Random();
      class119 var4 = new class119(128);
      class119 var5 = new class119(128);
      int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
      var4.method2453(10);

      int var7;
      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2456(var3.nextInt());
      }

      var4.method2456(var6[0]);
      var4.method2456(var6[1]);
      var4.method2463(var0);
      var4.method2463(0L);

      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2456(var3.nextInt());
      }

      var4.method2640(class9.field150, class9.field159);
      var5.method2453(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.method2456(var3.nextInt());
      }

      var5.method2463(var3.nextLong());
      var5.method2457(var3.nextLong());
      class44.method920(var5);
      var5.method2463(var3.nextLong());
      var5.method2640(class9.field150, class9.field159);
      var7 = class102.method2237(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      class119 var8 = new class119(var7);
      var8.method2586(var2);
      var8.field2000 = var7;
      var8.method2660(var6);
      class119 var9 = new class119(var5.field2000 + var4.field2000 + 5 + var8.field2000);
      var9.method2453(2);
      var9.method2453(var4.field2000);
      var9.method2462(var4.field2001, 0, var4.field2000);
      var9.method2453(var5.field2000);
      var9.method2462(var5.field2001, 0, var5.field2000);
      var9.method2454(var8.field2000);
      var9.method2462(var8.field2001, 0, var8.field2000);
      byte[] var11 = var9.field2001;
      int var13 = var11.length;
      StringBuilder var14 = new StringBuilder();

      int var17;
      for(int var15 = 0; var15 < 0 + var13; var15 += 3) {
         int var16 = var11[var15] & 255;
         var14.append(class161.field2668[var16 >>> 2]);
         if(var15 < var13 - 1) {
            var17 = var11[1 + var15] & 255;
            var14.append(class161.field2668[(var16 & 3) << 4 | var17 >>> 4]);
            if(var15 < var13 - 2) {
               int var18 = var11[2 + var15] & 255;
               var14.append(class161.field2668[(var17 & 15) << 2 | var18 >>> 6]).append(class161.field2668[var18 & 63]);
            } else {
               var14.append(class161.field2668[(var17 & 15) << 2]).append("=");
            }
         } else {
            var14.append(class161.field2668[(var16 & 3) << 4]).append("==");
         }
      }

      String var12 = var14.toString();
      var12 = var12;

      try {
         URL var19 = new URL(class17.method167("services", false) + "m=accountappeal/login.ws");
         URLConnection var24 = var19.openConnection();
         var24.setDoInput(true);
         var24.setDoOutput(true);
         var24.setConnectTimeout(5000);
         OutputStreamWriter var20 = new OutputStreamWriter(var24.getOutputStream());
         var20.write("data2=" + class135.method2851(var12) + "&dest=" + class135.method2851("passwordchoice.ws"));
         var20.flush();
         InputStream var21 = var24.getInputStream();
         var9 = new class119(new byte[1000]);

         do {
            var17 = var21.read(var9.field2001, var9.field2000, 1000 - var9.field2000);
            if(var17 == -1) {
               var20.close();
               var21.close();
               String var22 = new String(var9.field2001);
               if(var22.startsWith("OFFLINE")) {
                  return 4;
               } else if(var22.startsWith("WRONG")) {
                  return 7;
               } else if(var22.startsWith("RELOAD")) {
                  return 3;
               } else if(var22.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var9.method2485(var6);

                  while(var9.field2000 > 0 && var9.field2001[var9.field2000 - 1] == 0) {
                     --var9.field2000;
                  }

                  var22 = new String(var9.field2001, 0, var9.field2000);
                  if(class49.method975(var22)) {
                     class135.method2850(var22, true, false);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var9.field2000 += var17;
         } while(var9.field2000 < 1000);

         return 5;
      } catch (Throwable var23) {
         var23.printStackTrace();
         return 5;
      }
   }

   class96() {
   }

   class96(class96 var1) {
      this.field1640 = var1.field1640;
      this.field1638 = var1.field1638;
      this.field1639 = var1.field1639;
      this.field1647 = var1.field1647;
   }
}
