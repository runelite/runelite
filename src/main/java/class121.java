import java.awt.event.ActionEvent;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
public class class121 {
   @ObfuscatedName("k")
   static byte[][] field2002 = new byte[50][];
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1442298565
   )
   static int field2003 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 372647197
   )
   static int field2004 = 0;
   @ObfuscatedName("c")
   static byte[][] field2005 = new byte[1000][];
   @ObfuscatedName("y")
   static byte[][] field2006 = new byte[250][];
   @ObfuscatedName("l")
   static class13 field2008;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -637744013
   )
   static int field2009 = 0;
   @ObfuscatedName("ri")
   protected static boolean field2010;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "-72"
   )
   static synchronized byte[] method2857(int var0) {
      byte[] var1;
      if(100 == var0 && field2009 > 0) {
         var1 = field2005[--field2009];
         field2005[field2009] = null;
         return var1;
      } else if(var0 == 5000 && field2003 > 0) {
         var1 = field2006[--field2003];
         field2006[field2003] = null;
         return var1;
      } else if(30000 == var0 && field2004 > 0) {
         var1 = field2002[--field2004];
         field2002[field2004] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1613880209"
   )
   static void method2859() {
      class31.field749 = class31.field749.trim();
      if(class31.field749.length() == 0) {
         class39.method878("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1;
         try {
            URL var3 = new URL(class17.method218("services", false) + "m=accountappeal/login.ws");
            URLConnection var4 = var3.openConnection();
            var4.setRequestProperty("connection", "close");
            var4.setDoInput(true);
            var4.setDoOutput(true);
            var4.setConnectTimeout(5000);
            OutputStreamWriter var5 = new OutputStreamWriter(var4.getOutputStream());
            var5.write("data1=req");
            var5.flush();
            InputStream var6 = var4.getInputStream();
            class119 var7 = new class119(new byte[1000]);

            while(true) {
               int var8 = var6.read(var7.field1993, var7.field1992, 1000 - var7.field1992);
               if(-1 == var8) {
                  var7.field1992 = 0;
                  long var11 = var7.method2619();
                  var1 = var11;
                  break;
               }

               var7.field1992 += var8;
               if(var7.field1992 >= 1000) {
                  var1 = 0L;
                  break;
               }
            }
         } catch (Exception var10) {
            var1 = 0L;
         }

         int var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            var0 = class108.method2503(var1, class31.field749);
         }

         switch(var0) {
         case 2:
            class39.method878("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class31.field726 = 6;
            break;
         case 3:
            class39.method878("", "Error connecting to server.", "");
            break;
         case 4:
            class39.method878("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class39.method878("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class39.method878("", "Error connecting to server.", "");
            break;
         case 7:
            class39.method878("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass136;Ljava/lang/Object;I)V",
      garbageValue = "1109822106"
   )
   public static void method2860(class136 var0, Object var1) {
      if(var0.field2098 != null) {
         for(int var2 = 0; var2 < 50 && var0.field2098.peekEvent() != null; ++var2) {
            class4.method55(1L);
         }

         if(var1 != null) {
            var0.field2098.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "3715"
   )
   public static boolean method2861(int var0) {
      return (var0 >> 31 & 1) != 0;
   }
}
