import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
public class class117 {
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -528131235
   )
   public static int field2047;
   @ObfuscatedName("jw")
   @ObfuscatedGetter(
      intValue = 804921739
   )
   static int field2048;
   @ObfuscatedName("w")
   public static Buffer field2050;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "446107821"
   )
   static long method2464() {
      try {
         URL var0 = new URL(Friend.method189("services", false) + "m=accountappeal/login.ws");
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
               long var8 = var4.method2534();
               return var8;
            }

            var4.offset += var5;
         } while(var4.offset < 1000);

         return 0L;
      } catch (Exception var7) {
         return 0L;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;I)V",
      garbageValue = "1631192360"
   )
   public static void method2465(class170 var0, class170 var1) {
      class45.field1031 = var0;
      class221.field3216 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "2"
   )
   static final int method2466(int var0, int var1) {
      int var2 = var0 + 57 * var1;
      var2 ^= var2 << 13;
      int var3 = 1376312589 + var2 * (789221 + var2 * var2 * 15731) & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }
}
