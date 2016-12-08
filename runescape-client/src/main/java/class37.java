import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class37 {
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = 136199849
   )
   static int field795;
   @ObfuscatedName("do")
   static int[] field797;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "-40"
   )
   static long method719() {
      try {
         URL var0 = new URL(class65.method1162("services", false) + "m=accountappeal/login.ws");
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
               long var8 = var4.method2732();
               return var8;
            }

            var4.offset += var5;
         } while(var4.offset < 1000);

         return 0L;
      } catch (Exception var7) {
         return 0L;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass159;II)V",
      garbageValue = "2020156274"
   )
   static final void method721(class159 var0, int var1) {
      int var2 = var0.offset;
      class45.field904 = 0;
      class36.method707(var0);
      class6.method72(var0);
      if(var1 != var0.offset - var2) {
         throw new RuntimeException(var0.offset - var2 + " " + var1);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1672672204"
   )
   public static void method722() {
      if(class115.mouse != null) {
         class115 var0 = class115.mouse;
         synchronized(class115.mouse) {
            class115.mouse = null;
         }
      }

   }
}
