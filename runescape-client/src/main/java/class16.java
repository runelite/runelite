import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class16 extends class131 {
   @ObfuscatedName("i")
   String field178;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = 1179277671
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("u")
   short field182;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1141022597
   )
   int field183 = (int)(class45.method867() / 1000L);
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = 16996971
   )
   @Export("cameraZ")
   static int cameraZ;

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "2069065901"
   )
   static void method170(Widget var0, int var1, int var2) {
      if(var0.field2351 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2351 == 1) {
         var0.relativeX = (var1 - var0.width) / 2 + var0.originalX;
      } else if(var0.field2351 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2351 == 3) {
         var0.relativeX = var0.originalX * var1 >> 14;
      } else if(var0.field2351 == 4) {
         var0.relativeX = (var1 - var0.width) / 2 + (var1 * var0.originalX >> 14);
      } else {
         var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
      }

      if(var0.field2217 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2217 == 1) {
         var0.relativeY = var0.originalY + (var2 - var0.height) / 2;
      } else if(var0.field2217 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2217 == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.field2217 == 4) {
         var0.relativeY = (var2 - var0.height) / 2 + (var2 * var0.originalY >> 14);
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
      }

      if(Client.field473 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.relativeX + var0.width > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.height + var0.relativeY > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-117896775"
   )
   static void method171() {
      class41.username = class41.username.trim();
      if(class41.username.length() == 0) {
         class65.method1204("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var0;
         try {
            URL var2 = new URL(class173.method3310("services", false) + "m=accountappeal/login.ws");
            URLConnection var3 = var2.openConnection();
            var3.setRequestProperty("connection", "close");
            var3.setDoInput(true);
            var3.setDoOutput(true);
            var3.setConnectTimeout(5000);
            OutputStreamWriter var4 = new OutputStreamWriter(var3.getOutputStream());
            var4.write("data1=req");
            var4.flush();
            InputStream var5 = var3.getInputStream();
            Buffer var6 = new Buffer(new byte[1000]);

            while(true) {
               int var7 = var5.read(var6.payload, var6.offset, 1000 - var6.offset);
               if(var7 == -1) {
                  var6.offset = 0;
                  long var8 = var6.readLong();
                  var0 = var8;
                  break;
               }

               var6.offset += var7;
               if(var6.offset >= 1000) {
                  var0 = 0L;
                  break;
               }
            }
         } catch (Exception var10) {
            var0 = 0L;
         }

         int var11;
         if(var0 == 0L) {
            var11 = 5;
         } else {
            var11 = class168.method3248(var0, class41.username);
         }

         switch(var11) {
         case 2:
            class65.method1204("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class41.loginIndex = 6;
            break;
         case 3:
            class65.method1204("", "Error connecting to server.", "");
            break;
         case 4:
            class65.method1204("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class65.method1204("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class65.method1204("", "Error connecting to server.", "");
            break;
         case 7:
            class65.method1204("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }
      }

   }

   class16(String var1, int var2) {
      this.field178 = var1;
      this.field182 = (short)var2;
   }
}
