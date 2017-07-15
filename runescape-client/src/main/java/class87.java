import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
public class class87 {
   @ObfuscatedName("v")
   static final BigInteger field1380;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = 219621471
   )
   static int field1388;
   @ObfuscatedName("e")
   static final BigInteger field1378;
   @ObfuscatedName("gg")
   @Export("compass")
   static SpritePixels compass;
   @ObfuscatedName("rj")
   @ObfuscatedGetter(
      intValue = -797534487
   )
   static int field1373;

   static {
      field1380 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1378 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "58"
   )
   static void method1681() {
      class92.username = class92.username.trim();
      if(class92.username.length() == 0) {
         class2.method6("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1;
         try {
            URL var3 = new URL(WidgetNode.method1089("services", false) + "m=accountappeal/login.ws");
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
                  long var20 = var7.readLong();
                  var1 = var20;
                  break;
               }

               var7.offset += var8;
               if(var7.offset >= 1000) {
                  var1 = 0L;
                  break;
               }
            }
         } catch (Exception var28) {
            var1 = 0L;
         }

         byte var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            String var29 = class92.username;
            Random var30 = new Random();
            Buffer var24 = new Buffer(128);
            Buffer var9 = new Buffer(128);
            int[] var10 = new int[]{var30.nextInt(), var30.nextInt(), (int)(var1 >> 32), (int)var1};
            var24.putByte(10);

            int var11;
            for(var11 = 0; var11 < 4; ++var11) {
               var24.putInt(var30.nextInt());
            }

            var24.putInt(var10[0]);
            var24.putInt(var10[1]);
            var24.putLong(var1);
            var24.putLong(0L);

            for(var11 = 0; var11 < 4; ++var11) {
               var24.putInt(var30.nextInt());
            }

            var24.encryptRsa(field1380, field1378);
            var9.putByte(10);

            for(var11 = 0; var11 < 3; ++var11) {
               var9.putInt(var30.nextInt());
            }

            var9.putLong(var30.nextLong());
            var9.method3182(var30.nextLong());
            Renderable.method2863(var9);
            var9.putLong(var30.nextLong());
            var9.encryptRsa(field1380, field1378);
            var11 = DecorativeObject.getLength(var29);
            if(var11 % 8 != 0) {
               var11 += 8 - var11 % 8;
            }

            Buffer var12 = new Buffer(var11);
            var12.putString(var29);
            var12.offset = var11;
            var12.encryptXtea2(var10);
            Buffer var13 = new Buffer(var12.offset + var24.offset + 5 + var9.offset);
            var13.putByte(2);
            var13.putByte(var24.offset);
            var13.putBytes(var24.payload, 0, var24.offset);
            var13.putByte(var9.offset);
            var13.putBytes(var9.payload, 0, var9.offset);
            var13.putShort(var12.offset);
            var13.putBytes(var12.payload, 0, var12.offset);
            String var14 = class40.method551(var13.payload);

            byte var26;
            try {
               URL var15 = new URL(WidgetNode.method1089("services", false) + "m=accountappeal/login.ws");
               URLConnection var16 = var15.openConnection();
               var16.setDoInput(true);
               var16.setDoOutput(true);
               var16.setConnectTimeout(5000);
               OutputStreamWriter var17 = new OutputStreamWriter(var16.getOutputStream());
               var17.write("data2=" + class91.method1700(var14) + "&dest=" + class91.method1700("passwordchoice.ws"));
               var17.flush();
               InputStream var18 = var16.getInputStream();
               var13 = new Buffer(new byte[1000]);

               while(true) {
                  int var19 = var18.read(var13.payload, var13.offset, 1000 - var13.offset);
                  if(var19 == -1) {
                     var17.close();
                     var18.close();
                     String var25 = new String(var13.payload);
                     if(var25.startsWith("OFFLINE")) {
                        var26 = 4;
                     } else if(var25.startsWith("WRONG")) {
                        var26 = 7;
                     } else if(var25.startsWith("RELOAD")) {
                        var26 = 3;
                     } else if(var25.startsWith("Not permitted for social network accounts.")) {
                        var26 = 6;
                     } else {
                        var13.decryptXtea(var10);

                        while(var13.offset > 0 && var13.payload[var13.offset - 1] == 0) {
                           --var13.offset;
                        }

                        var25 = new String(var13.payload, 0, var13.offset);
                        if(Widget.method4024(var25)) {
                           class36.method485(var25, true, false);
                           var26 = 2;
                        } else {
                           var26 = 5;
                        }
                     }
                     break;
                  }

                  var13.offset += var19;
                  if(var13.offset >= 1000) {
                     var26 = 5;
                     break;
                  }
               }
            } catch (Throwable var27) {
               var27.printStackTrace();
               var26 = 5;
            }

            var0 = var26;
         }

         switch(var0) {
         case 2:
            class2.method6("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class92.loginIndex = 6;
            break;
         case 3:
            class2.method6("", "Error connecting to server.", "");
            break;
         case 4:
            class2.method6("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class2.method6("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class2.method6("", "Error connecting to server.", "");
            break;
         case 7:
            class2.method6("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }
}
