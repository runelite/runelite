import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public enum class27 implements RSEnum {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Laf;"
   )
   field411(0, (byte)0),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Laf;"
   )
   field407(2, (byte)1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Laf;"
   )
   field406(1, (byte)2),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Laf;"
   )
   field409(3, (byte)3);

   @ObfuscatedName("v")
   final byte field408;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -365676159
   )
   final int field410;

   class27(int var3, byte var4) {
      this.field410 = var3;
      this.field408 = var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "6"
   )
   public int rsOrdinal() {
      return this.field408;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-612438083"
   )
   public static boolean method222(int var0) {
      return var0 >= class221.field2822.field2825 && var0 <= class221.field2823.field2825;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-181040815"
   )
   static void method218() {
      for(class80 var0 = (class80)class80.field1323.getFront(); var0 != null; var0 = (class80)class80.field1323.getNext()) {
         if(var0.field1317 != null) {
            class11.field278.method1920(var0.field1317);
            var0.field1317 = null;
         }

         if(var0.field1324 != null) {
            class11.field278.method1920(var0.field1324);
            var0.field1324 = null;
         }
      }

      class80.field1323.clear();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1277196757"
   )
   static long method221() {
      try {
         URL var0 = new URL(class12.method71("services", false) + "m=accountappeal/login.ws");
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
