import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("l")
   static int[] field2051;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1385427501
   )
   @Export("x")
   int x;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2098014185
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1737554589
   )
   @Export("z")
   int z;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1408308335"
   )
   static long method2977() {
      try {
         URL var0 = new URL(class24.method198("services", false) + "m=accountappeal/login.ws");
         URLConnection var1 = var0.openConnection();
         var1.setRequestProperty("connection", "close");
         var1.setDoInput(true);
         var1.setDoOutput(true);
         var1.setConnectTimeout(5000);
         OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
         var2.write("data1=req");
         var2.flush();
         InputStream var3 = var1.getInputStream();
         Buffer var4 = new Buffer(new byte[1000]);

         do {
            int var5 = var3.read(var4.payload, var4.offset, 1000 - var4.offset);
            if(var5 == -1) {
               var4.offset = 0;
               long var7 = var4.readLong();
               return var7;
            }

            var4.offset += var5;
         } while(var4.offset < 1000);

         return 0L;
      } catch (Exception var9) {
         return 0L;
      }
   }
}
