import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class189 {
   @ObfuscatedName("s")
   @Export("worldServersDownload")
   static class18 field3050;
   @ObfuscatedName("eb")
   static class78 field3051;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "16"
   )
   static long method3780() {
      try {
         URL var0 = new URL(class84.method1963("services", false) + "m=accountappeal/login.ws");
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
            int var5 = var3.read(var4.field2000, var4.field1998, 1000 - var4.field1998);
            if(var5 == -1) {
               var4.field1998 = 0;
               long var8 = var4.method2560();
               return var8;
            }

            var4.field1998 += var5;
         } while(var4.field1998 < 1000);

         return 0L;
      } catch (Exception var7) {
         return 0L;
      }
   }
}
