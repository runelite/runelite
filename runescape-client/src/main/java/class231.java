import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class class231 {
   @ObfuscatedName("c")
   static final class231 field3176;
   @ObfuscatedName("i")
   static final class231 field3177;
   @ObfuscatedName("e")
   static final class231 field3178;
   @ObfuscatedName("v")
   static final class231 field3179;
   @ObfuscatedName("b")
   public final String field3180;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1683602653
   )
   public final int field3181;
   @ObfuscatedName("ac")
   @Export("authCode")
   static String authCode;

   static {
      field3177 = new class231("LIVE", 0);
      field3176 = new class231("BUILDLIVE", 3);
      field3178 = new class231("RC", 1);
      field3179 = new class231("WIP", 2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "343906247"
   )
   static void method4098() {
      class92.username = class92.username.trim();
      if(class92.username.length() == 0) {
         WorldMapType2.method496("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1;
         try {
            URL var3 = new URL(class60.method1007("services", false) + "m=accountappeal/login.ws");
            URLConnection var4 = var3.openConnection();
            var4.setRequestProperty("connection", "close");
            var4.setDoInput(true);
            var4.setDoOutput(true);
            var4.setConnectTimeout(5000);
            OutputStreamWriter var5 = new OutputStreamWriter(var4.getOutputStream());
            var5.write("data1=req");
            var5.flush();
            InputStream var6 = var4.getInputStream();
            Buffer var7 = new Buffer(new byte[1000]);

            while(true) {
               int var8 = var6.read(var7.payload, var7.offset, 1000 - var7.offset);
               if(var8 == -1) {
                  var7.offset = 0;
                  long var10 = var7.readLong();
                  var1 = var10;
                  break;
               }

               var7.offset += var8;
               if(var7.offset >= 1000) {
                  var1 = 0L;
                  break;
               }
            }
         } catch (Exception var14) {
            var1 = 0L;
         }

         int var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            var0 = WorldMapData.method327(var1, class92.username);
         }

         switch(var0) {
         case 2:
            WorldMapType2.method496("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class92.loginIndex = 6;
            break;
         case 3:
            WorldMapType2.method496("", "Error connecting to server.", "");
            break;
         case 4:
            WorldMapType2.method496("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            WorldMapType2.method496("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            WorldMapType2.method496("", "Error connecting to server.", "");
            break;
         case 7:
            WorldMapType2.method496("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   public static void method4099() {
      while(true) {
         Deque var1 = class236.field3238;
         class233 var0;
         synchronized(class236.field3238) {
            var0 = (class233)class236.field3235.method3595();
         }

         if(var0 == null) {
            return;
         }

         var0.field3200.method4223(var0.field3199, (int)var0.hash, var0.field3198, false);
      }
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class231(String var1, int var2) {
      this.field3180 = var1;
      this.field3181 = var2;
   }
}
