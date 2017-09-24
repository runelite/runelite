import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("n")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1799952887
   )
   @Export("swColor")
   int swColor;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1047988369
   )
   @Export("rgb")
   int rgb;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1873407219
   )
   @Export("seColor")
   int seColor;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -829260313
   )
   @Export("neColor")
   int neColor;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1627856457
   )
   @Export("nwColor")
   int nwColor;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -93874639
   )
   @Export("texture")
   int texture;

   SceneTilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.flatShade = true;
      this.swColor = var1;
      this.seColor = var2;
      this.neColor = var3;
      this.nwColor = var4;
      this.texture = var5;
      this.rgb = var6;
      this.flatShade = var7;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   static void method2706() {
      class91.username = class91.username.trim();
      if(class91.username.length() == 0) {
         class228.method4112("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = FrameMap.method2707();
         byte var0;
         if(var1 == 0L) {
            var0 = 5;
         } else {
            String var4 = class91.username;
            Random var5 = new Random();
            Buffer var6 = new Buffer(128);
            Buffer var7 = new Buffer(128);
            int[] var8 = new int[]{var5.nextInt(), var5.nextInt(), (int)(var1 >> 32), (int)var1};
            var6.putByte(10);

            int var9;
            for(var9 = 0; var9 < 4; ++var9) {
               var6.putInt(var5.nextInt());
            }

            var6.putInt(var8[0]);
            var6.putInt(var8[1]);
            var6.putLong(var1);
            var6.putLong(0L);

            for(var9 = 0; var9 < 4; ++var9) {
               var6.putInt(var5.nextInt());
            }

            var6.encryptRsa(class86.field1387, class86.field1383);
            var7.putByte(10);

            for(var9 = 0; var9 < 3; ++var9) {
               var7.putInt(var5.nextInt());
            }

            var7.putLong(var5.nextLong());
            var7.method3300(var5.nextLong());
            if(Client.field979 != null) {
               var7.putBytes(Client.field979, 0, Client.field979.length);
            } else {
               byte[] var22 = Widget.method4075();
               var7.putBytes(var22, 0, var22.length);
            }

            var7.putLong(var5.nextLong());
            var7.encryptRsa(class86.field1387, class86.field1383);
            var9 = ClanMember.getLength(var4);
            if(var9 % 8 != 0) {
               var9 += 8 - var9 % 8;
            }

            Buffer var10 = new Buffer(var9);
            var10.putString(var4);
            var10.offset = var9;
            var10.encryptXtea2(var8);
            Buffer var11 = new Buffer(var10.offset + var7.offset + var6.offset + 5);
            var11.putByte(2);
            var11.putByte(var6.offset);
            var11.putBytes(var6.payload, 0, var6.offset);
            var11.putByte(var7.offset);
            var11.putBytes(var7.payload, 0, var7.offset);
            var11.putShort(var10.offset);
            var11.putBytes(var10.payload, 0, var10.offset);
            byte[] var13 = var11.payload;
            int var15 = var13.length;
            StringBuilder var16 = new StringBuilder();

            int var19;
            for(int var17 = 0; var17 < var15 + 0; var17 += 3) {
               int var18 = var13[var17] & 255;
               var16.append(class270.field3675[var18 >>> 2]);
               if(var17 < var15 - 1) {
                  var19 = var13[var17 + 1] & 255;
                  var16.append(class270.field3675[(var18 & 3) << 4 | var19 >>> 4]);
                  if(var17 < var15 - 2) {
                     int var20 = var13[var17 + 2] & 255;
                     var16.append(class270.field3675[(var19 & 15) << 2 | var20 >>> 6]).append(class270.field3675[var20 & 63]);
                  } else {
                     var16.append(class270.field3675[(var19 & 15) << 2]).append("=");
                  }
               } else {
                  var16.append(class270.field3675[(var18 & 3) << 4]).append("==");
               }
            }

            String var14 = var16.toString();
            var14 = var14;

            byte var3;
            try {
               URL var23 = new URL(class86.method1709("services", false) + "m=accountappeal/login.ws");
               URLConnection var29 = var23.openConnection();
               var29.setDoInput(true);
               var29.setDoOutput(true);
               var29.setConnectTimeout(5000);
               OutputStreamWriter var24 = new OutputStreamWriter(var29.getOutputStream());
               var24.write("data2=" + PendingSpawn.method1520(var14) + "&dest=" + PendingSpawn.method1520("passwordchoice.ws"));
               var24.flush();
               InputStream var25 = var29.getInputStream();
               var11 = new Buffer(new byte[1000]);

               while(true) {
                  var19 = var25.read(var11.payload, var11.offset, 1000 - var11.offset);
                  if(var19 == -1) {
                     var24.close();
                     var25.close();
                     String var26 = new String(var11.payload);
                     if(var26.startsWith("OFFLINE")) {
                        var3 = 4;
                     } else if(var26.startsWith("WRONG")) {
                        var3 = 7;
                     } else if(var26.startsWith("RELOAD")) {
                        var3 = 3;
                     } else if(var26.startsWith("Not permitted for social network accounts.")) {
                        var3 = 6;
                     } else {
                        var11.decryptXtea(var8);

                        while(var11.offset > 0 && var11.payload[var11.offset - 1] == 0) {
                           --var11.offset;
                        }

                        var26 = new String(var11.payload, 0, var11.offset);
                        boolean var30;
                        if(var26 == null) {
                           var30 = false;
                        } else {
                           label118: {
                              try {
                                 new URL(var26);
                              } catch (MalformedURLException var27) {
                                 var30 = false;
                                 break label118;
                              }

                              var30 = true;
                           }
                        }

                        if(var30) {
                           class35.method517(var26, true, false);
                           var3 = 2;
                        } else {
                           var3 = 5;
                        }
                     }
                     break;
                  }

                  var11.offset += var19;
                  if(var11.offset >= 1000) {
                     var3 = 5;
                     break;
                  }
               }
            } catch (Throwable var28) {
               var28.printStackTrace();
               var3 = 5;
            }

            var0 = var3;
         }

         switch(var0) {
         case 2:
            class228.method4112("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class91.loginIndex = 6;
            break;
         case 3:
            class228.method4112("", "Error connecting to server.", "");
            break;
         case 4:
            class228.method4112("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class228.method4112("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class228.method4112("", "Error connecting to server.", "");
            break;
         case 7:
            class228.method4112("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "(Ljw;IIIB)V",
      garbageValue = "73"
   )
   static void method2705(Sequence var0, int var1, int var2, int var3) {
      if(Client.field1172 < 50 && Client.field1171 != 0) {
         if(var0.field3599 != null && var1 < var0.field3599.length) {
            int var4 = var0.field3599[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field1173[Client.field1172] = var5;
               Client.field1174[Client.field1172] = var6;
               Client.field1001[Client.field1172] = 0;
               Client.audioEffects[Client.field1172] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field1176[Client.field1172] = var7 + (var9 << 8) + (var8 << 16);
               ++Client.field1172;
            }
         }
      }
   }
}
