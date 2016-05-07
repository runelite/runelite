import java.io.File;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
public class class114 {
   @ObfuscatedName("aa")
   static class146 field1975;
   @ObfuscatedName("x")
   public static File field1977;
   @ObfuscatedName("ng")
   static class55 field1978;
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = -1191397665
   )
   @Export("baseY")
   static int field1981;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Lclass133;",
      garbageValue = "1560389661"
   )
   static class133 method2436() {
      try {
         return new class147();
      } catch (Throwable var1) {
         return new class141();
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "-105"
   )
   static long method2437() {
      try {
         URL var0 = new URL(class122.method2758("services", false) + "m=accountappeal/login.ws");
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
            int var5 = var3.read(var4.field2007, var4.field2005, 1000 - var4.field2005);
            if(-1 == var5) {
               var4.field2005 = 0;
               long var8 = var4.method2498();
               return var8;
            }

            var4.field2005 += var5;
         } while(var4.field2005 < 1000);

         return 0L;
      } catch (Exception var7) {
         return 0L;
      }
   }
}
