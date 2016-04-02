import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
public class class52 extends class204 {
   @ObfuscatedName("e")
   static class167 field1134;
   @ObfuscatedName("f")
   static class193 field1135 = new class193(64);
   @ObfuscatedName("bq")
   static class80[] field1138;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2006363229
   )
   public int field1140 = 0;

   @ObfuscatedName("f")
   void method1064(class119 var1) {
      while(true) {
         int var2 = var1.method2523();
         if(var2 == 0) {
            return;
         }

         this.method1066(var1, var2);
      }
   }

   @ObfuscatedName("s")
   void method1066(class119 var1, int var2) {
      if(var2 == 5) {
         this.field1140 = var1.method2700();
      }

   }

   @ObfuscatedName("e")
   static class80[] method1069(class167 var0, int var1, int var2) {
      return !class23.method586(var0, var1, var2)?null:class139.method2923();
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-340910534"
   )
   static final void method1081() {
      class9.method133(client.field451);
      ++class7.field139;
      if(client.field459 && client.field509) {
         int var0 = class140.field2140;
         int var1 = class140.field2141;
         var0 -= client.field453;
         var1 -= client.field517;
         if(var0 < client.field527) {
            var0 = client.field527;
         }

         if(client.field451.field2770 + var0 > client.field452.field2770 + client.field527) {
            var0 = client.field452.field2770 + client.field527 - client.field451.field2770;
         }

         if(var1 < client.field458) {
            var1 = client.field458;
         }

         if(var1 + client.field451.field2834 > client.field458 + client.field452.field2834) {
            var1 = client.field452.field2834 + client.field458 - client.field451.field2834;
         }

         int var2 = var0 - client.field460;
         int var3 = var1 - client.field294;
         int var4 = client.field451.field2854;
         if(class7.field139 > client.field451.field2755 && (var2 > var4 || var2 < -var4 || var3 > var4 || var3 < -var4)) {
            client.field462 = true;
         }

         int var5 = var0 - client.field527 + client.field452.field2776;
         int var6 = client.field452.field2815 + (var1 - client.field458);
         class0 var7;
         if(null != client.field451.field2844 && client.field462) {
            var7 = new class0();
            var7.field2 = client.field451;
            var7.field3 = var5;
            var7.field4 = var6;
            var7.field11 = client.field451.field2844;
            class93.method2183(var7);
         }

         if(class140.field2136 == 0) {
            if(client.field462) {
               if(null != client.field451.field2871) {
                  var7 = new class0();
                  var7.field2 = client.field451;
                  var7.field3 = var5;
                  var7.field4 = var6;
                  var7.field6 = client.field455;
                  var7.field11 = client.field451.field2871;
                  class93.method2183(var7);
               }

               if(client.field455 != null && class135.method2869(client.field451) != null) {
                  client.field321.method2762(141);
                  client.field321.method2563(client.field455.field2794);
                  client.field321.method2617(client.field451.field2794);
                  client.field321.method2556(client.field451.field2816);
                  client.field321.method2556(client.field451.field2822);
                  client.field321.method2713(client.field455.field2816);
                  client.field321.method2548(client.field455.field2822);
               }
            } else {
               label144: {
                  int var8;
                  label117: {
                     if(client.field417 != 1) {
                        var8 = client.field420 - 1;
                        boolean var10;
                        if(var8 < 0) {
                           var10 = false;
                        } else {
                           int var9 = client.field301[var8];
                           if(var9 >= 2000) {
                              var9 -= 2000;
                           }

                           if(var9 == 1007) {
                              var10 = true;
                           } else {
                              var10 = false;
                           }
                        }

                        if(!var10) {
                           break label117;
                        }
                     }

                     if(client.field420 > 2) {
                        class82.method1905(client.field460 + client.field453, client.field294 + client.field517);
                        break label144;
                     }
                  }

                  if(client.field420 > 0) {
                     int var11 = client.field453 + client.field460;
                     var8 = client.field294 + client.field517;
                     class44.method945(class177.field2910, var11, var8);
                     class177.field2910 = null;
                  }
               }
            }

            client.field451 = null;
         }

      } else {
         if(class7.field139 > 1) {
            client.field451 = null;
         }

      }
   }

   @ObfuscatedName("v")
   static final void method1083() {
      if(client.field507 != class48.field1063) {
         client.field507 = class48.field1063;
         class102.method2311(class48.field1063);
      }

   }

   @ObfuscatedName("e")
   static long method1085() {
      try {
         URL var0 = new URL(class25.method631("services", false) + "m=accountappeal/login.ws");
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
            int var5 = var3.read(var4.field1980, var4.field1976, 1000 - var4.field1976);
            if(-1 == var5) {
               var4.field1976 = 0;
               long var8 = var4.method2529();
               return var8;
            }

            var4.field1976 += var5;
         } while(var4.field1976 < 1000);

         return 0L;
      } catch (Exception var7) {
         return 0L;
      }
   }
}
