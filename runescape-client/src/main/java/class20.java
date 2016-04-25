import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class20 implements class112 {
   @ObfuscatedName("h")
   static final class20 field559 = new class20(1);
   @ObfuscatedName("m")
   static final class20 field560 = new class20(2);
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 746438407
   )
   final int field562;
   @ObfuscatedName("j")
   static final class20 field563 = new class20(0);
   @ObfuscatedName("z")
   static final class20 field565 = new class20(3);

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)I",
      garbageValue = "-1815565821"
   )
   static int method557(class122 var0) {
      int var1 = var0.method2737(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method2737(5);
      } else if(var1 == 2) {
         var2 = var0.method2737(8);
      } else {
         var2 = var0.method2737(11);
      }

      return var2;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class20(int var1) {
      this.field562 = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "718228985"
   )
   static long method559() {
      try {
         URL var0 = new URL(class59.method1248("services", false) + "m=accountappeal/login.ws");
         URLConnection var1 = var0.openConnection();
         var1.setRequestProperty("connection", "close");
         var1.setDoInput(true);
         var1.setDoOutput(true);
         var1.setConnectTimeout(5000);
         OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
         var2.write("data1=req");
         var2.flush();
         InputStream var3 = var1.getInputStream();
         class119 var4 = new class119(new byte[1000]);

         do {
            int var5 = var3.read(var4.field1973, var4.field1971, 1000 - var4.field1971);
            if(var5 == -1) {
               var4.field1971 = 0;
               long var8 = var4.method2506();
               return var8;
            }

            var4.field1971 += var5;
         } while(var4.field1971 < 1000);

         return 0L;
      } catch (Exception var7) {
         return 0L;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "23"
   )
   public int vmethod3136() {
      return this.field562;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "1888381861"
   )
   static void method561(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         class25 var8 = class25.field616[var6];
         class25.field616[var6] = class25.field616[var1];
         class25.field616[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            class25 var11 = class25.field616[var9];
            int var12 = class90.method2084(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = class90.method2084(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               class25 var14 = class25.field616[var9];
               class25.field616[var9] = class25.field616[var7];
               class25.field616[var7++] = var14;
            }
         }

         class25.field616[var1] = class25.field616[var7];
         class25.field616[var7] = var8;
         method561(var0, var7 - 1, var2, var3, var4, var5);
         method561(1 + var7, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "38"
   )
   public static int method563(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }
}
