import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public class class77 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1896363617
   )
   int field1189;
   @ObfuscatedName("i")
   byte[] field1190;
   @ObfuscatedName("v")
   byte[] field1191;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -280477563
   )
   int field1192;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 3798814088879397815L
   )
   long field1193;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1196201245
   )
   int field1194;
   @ObfuscatedName("u")
   class153 field1195;
   @ObfuscatedName("cy")
   @Export("indexSprites")
   static IndexData indexSprites;
   @ObfuscatedName("q")
   DataInputStream field1197;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-1741469993"
   )
   byte[] method1517() throws IOException {
      if(class226.method4147() > this.field1193) {
         throw new IOException();
      } else {
         if(this.field1189 == 0) {
            if(this.field1195.field2209 == 2) {
               throw new IOException();
            }

            if(this.field1195.field2209 == 1) {
               this.field1197 = (DataInputStream)this.field1195.field2211;
               this.field1189 = 1;
            }
         }

         if(this.field1189 == 1) {
            this.field1192 += this.field1197.read(this.field1190, this.field1192, this.field1190.length - this.field1192);
            if(this.field1192 == 4) {
               int var1 = (new Buffer(this.field1190)).readInt();
               this.field1191 = new byte[var1];
               this.field1189 = 2;
            }
         }

         if(this.field1189 == 2) {
            this.field1194 += this.field1197.read(this.field1191, this.field1194, this.field1191.length - this.field1194);
            if(this.field1191.length == this.field1194) {
               return this.field1191;
            }
         }

         return null;
      }
   }

   class77(class154 var1, URL var2) {
      this.field1190 = new byte[4];
      this.field1195 = var1.method2971(var2);
      this.field1189 = 0;
      this.field1193 = class226.method4147() + 30000L;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "666952529"
   )
   static void method1521() {
      class92.username = class92.username.trim();
      if(class92.username.length() == 0) {
         Buffer.method3383("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1;
         try {
            URL var3 = new URL(class26.method179("services", false) + "m=accountappeal/login.ws");
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
            var0 = NPC.method1729(var1, class92.username);
         }

         switch(var0) {
         case 2:
            Buffer.method3383("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class92.loginIndex = 6;
            break;
         case 3:
            Buffer.method3383("", "Error connecting to server.", "");
            break;
         case 4:
            Buffer.method3383("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            Buffer.method3383("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            Buffer.method3383("", "Error connecting to server.", "");
            break;
         case 7:
            Buffer.method3383("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }
}
