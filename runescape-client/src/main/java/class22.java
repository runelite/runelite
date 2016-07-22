import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
final class class22 implements Comparator {
   @ObfuscatedName("m")
   public static class170 field583;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;
   @ObfuscatedName("az")
   static class171 field584;
   @ObfuscatedName("ny")
   @ObfuscatedGetter(
      intValue = 1406515493
   )
   static int field585;
   @ObfuscatedName("ez")
   static class81[] field589;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "722151694"
   )
   static long method569() {
      try {
         URL var0 = new URL(class177.method3494("services", false) + "m=accountappeal/login.ws");
         URLConnection var1 = var0.openConnection();
         var1.setRequestProperty("connection", "close");
         var1.setDoInput(true);
         var1.setDoOutput(true);
         var1.setConnectTimeout(5000);
         OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
         var2.write("data1=req");
         var2.flush();
         InputStream var3 = var1.getInputStream();
         class122 var4 = new class122(new byte[1000]);

         do {
            int var5 = var3.read(var4.field2047, var4.field2045, 1000 - var4.field2045);
            if(var5 == -1) {
               var4.field2045 = 0;
               long var8 = var4.method2578();
               return var8;
            }

            var4.field2045 += var5;
         } while(var4.field2045 < 1000);

         return 0L;
      } catch (Exception var7) {
         return 0L;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;B)I",
      garbageValue = "0"
   )
   int method570(class217 var1, class217 var2) {
      if(var2.field3201 == var1.field3201) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(client.field272 == var1.field3201) {
               return -1;
            }

            if(client.field272 == var2.field3201) {
               return 1;
            }
         }

         return var1.field3201 < var2.field3201?-1:1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method570((class217)var1, (class217)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   class22(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "557899641"
   )
   static void method572(int var0, int var1, int var2) {
      if(client.field510 != 0 && var1 != 0 && client.field274 < 50) {
         client.field513[client.field274] = var0;
         client.field346[client.field274] = var1;
         client.field434[client.field274] = var2;
         client.field450[client.field274] = null;
         client.field288[client.field274] = 0;
         ++client.field274;
      }

   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(IIIB)Lclass3;",
      garbageValue = "-104"
   )
   static final class3 method576(int var0, int var1, int var2) {
      class3 var3 = new class3();
      var3.field66 = var1;
      var3.field64 = var2;
      client.field535.method3849(var3, (long)var0);
      class117.method2508(var1);
      class176 var4 = class34.method720(var0);
      class92.method2164(var4);
      if(client.field402 != null) {
         class92.method2164(client.field402);
         client.field402 = null;
      }

      class145.method3039();
      client.method551(class176.field2814[var0 >> 16], var4, false);
      class104.method2358(var1);
      if(client.field430 != -1) {
         class178.method3501(client.field430, 1);
      }

      return var3;
   }
}
