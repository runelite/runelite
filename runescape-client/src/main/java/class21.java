import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class21 {
   @ObfuscatedName("ak")
   static int[] field312;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1207708341"
   )
   static void method153() {
      class91.username = class91.username.trim();
      if(class91.username.length() == 0) {
         BaseVarType.method14("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1;
         try {
            URL var3 = new URL(GZipDecompressor.method3130("services", false) + "m=accountappeal/login.ws");
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
                  long var24 = var7.readLong();
                  var1 = var24;
                  break;
               }

               var7.offset += var8;
               if(var7.offset >= 1000) {
                  var1 = 0L;
                  break;
               }
            }
         } catch (Exception var37) {
            var1 = 0L;
         }

         byte var0;
         if(var1 == 0L) {
            var0 = 5;
         } else {
            String var38 = class91.username;
            Random var39 = new Random();
            Buffer var28 = new Buffer(128);
            Buffer var9 = new Buffer(128);
            int[] var10 = new int[]{var39.nextInt(), var39.nextInt(), (int)(var1 >> 32), (int)var1};
            var28.putByte(10);

            int var11;
            for(var11 = 0; var11 < 4; ++var11) {
               var28.putInt(var39.nextInt());
            }

            var28.putInt(var10[0]);
            var28.putInt(var10[1]);
            var28.putLong(var1);
            var28.putLong(0L);

            for(var11 = 0; var11 < 4; ++var11) {
               var28.putInt(var39.nextInt());
            }

            var28.encryptRsa(class86.field1290, class86.field1293);
            var9.putByte(10);

            for(var11 = 0; var11 < 3; ++var11) {
               var9.putInt(var39.nextInt());
            }

            var9.putLong(var39.nextLong());
            var9.method3349(var39.nextLong());
            class235.method4095(var9);
            var9.putLong(var39.nextLong());
            var9.encryptRsa(class86.field1290, class86.field1293);
            var11 = class23.getLength(var38);
            if(var11 % 8 != 0) {
               var11 += 8 - var11 % 8;
            }

            Buffer var12 = new Buffer(var11);
            var12.putString(var38);
            var12.offset = var11;
            var12.encryptXtea2(var10);
            Buffer var13 = new Buffer(var12.offset + var28.offset + var9.offset + 5);
            var13.putByte(2);
            var13.putByte(var28.offset);
            var13.putBytes(var28.payload, 0, var28.offset);
            var13.putByte(var9.offset);
            var13.putBytes(var9.payload, 0, var9.offset);
            var13.putShort(var12.offset);
            var13.putBytes(var12.payload, 0, var12.offset);
            byte[] var15 = var13.payload;
            int var17 = var15.length;
            StringBuilder var18 = new StringBuilder();

            int var21;
            for(int var19 = 0; var19 < var17 + 0; var19 += 3) {
               int var20 = var15[var19] & 255;
               var18.append(class276.field3724[var20 >>> 2]);
               if(var19 < var17 - 1) {
                  var21 = var15[var19 + 1] & 255;
                  var18.append(class276.field3724[(var20 & 3) << 4 | var21 >>> 4]);
                  if(var19 < var17 - 2) {
                     int var22 = var15[var19 + 2] & 255;
                     var18.append(class276.field3724[(var21 & 15) << 2 | var22 >>> 6]).append(class276.field3724[var22 & 63]);
                  } else {
                     var18.append(class276.field3724[(var21 & 15) << 2]).append("=");
                  }
               } else {
                  var18.append(class276.field3724[(var20 & 3) << 4]).append("==");
               }
            }

            String var16 = var18.toString();
            var16 = var16;

            byte var33;
            try {
               URL var29 = new URL(GZipDecompressor.method3130("services", false) + "m=accountappeal/login.ws");
               URLConnection var40 = var29.openConnection();
               var40.setDoInput(true);
               var40.setDoOutput(true);
               var40.setConnectTimeout(5000);
               OutputStreamWriter var30 = new OutputStreamWriter(var40.getOutputStream());
               var30.write("data2=" + class153.method2950(var16) + "&dest=" + class153.method2950("passwordchoice.ws"));
               var30.flush();
               InputStream var31 = var40.getInputStream();
               var13 = new Buffer(new byte[1000]);

               while(true) {
                  var21 = var31.read(var13.payload, var13.offset, 1000 - var13.offset);
                  if(var21 == -1) {
                     var30.close();
                     var31.close();
                     String var32 = new String(var13.payload);
                     if(var32.startsWith("OFFLINE")) {
                        var33 = 4;
                     } else if(var32.startsWith("WRONG")) {
                        var33 = 7;
                     } else if(var32.startsWith("RELOAD")) {
                        var33 = 3;
                     } else if(var32.startsWith("Not permitted for social network accounts.")) {
                        var33 = 6;
                     } else {
                        var13.decryptXtea(var10);

                        while(var13.offset > 0 && var13.payload[var13.offset - 1] == 0) {
                           --var13.offset;
                        }

                        var32 = new String(var13.payload, 0, var13.offset);
                        boolean var41;
                        if(var32 == null) {
                           var41 = false;
                        } else {
                           label148: {
                              try {
                                 new URL(var32);
                              } catch (MalformedURLException var35) {
                                 var41 = false;
                                 break label148;
                              }

                              var41 = true;
                           }
                        }

                        if(!var41) {
                           var33 = 5;
                        } else {
                           label143: {
                              if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                                 try {
                                    Desktop.getDesktop().browse(new URI(var32));
                                    break label143;
                                 } catch (Exception var34) {
                                    ;
                                 }
                              }

                              if(class56.field629.startsWith("win")) {
                                 World.method1561(var32, 0);
                              } else if(class56.field629.startsWith("mac")) {
                                 ScriptState.method1000(var32, 1, "openjs");
                              } else {
                                 World.method1561(var32, 2);
                              }
                           }

                           var33 = 2;
                        }
                     }
                     break;
                  }

                  var13.offset += var21;
                  if(var13.offset >= 1000) {
                     var33 = 5;
                     break;
                  }
               }
            } catch (Throwable var36) {
               var36.printStackTrace();
               var33 = 5;
            }

            var0 = var33;
         }

         switch(var0) {
         case 2:
            BaseVarType.method14("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class91.loginIndex = 6;
            break;
         case 3:
            BaseVarType.method14("", "Error connecting to server.", "");
            break;
         case 4:
            BaseVarType.method14("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            BaseVarType.method14("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            BaseVarType.method14("", "Error connecting to server.", "");
            break;
         case 7:
            BaseVarType.method14("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "35"
   )
   @Export("getSmoothNoise")
   static final int getSmoothNoise(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = getSmoothNoise2D(var3, var5);
      int var8 = getSmoothNoise2D(var3 + 1, var5);
      int var9 = getSmoothNoise2D(var3, var5 + 1);
      int var10 = getSmoothNoise2D(var3 + 1, var5 + 1);
      int var11 = SceneTilePaint.method2686(var7, var8, var4, var2);
      int var12 = SceneTilePaint.method2686(var9, var10, var4, var2);
      return SceneTilePaint.method2686(var11, var12, var6, var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "8"
   )
   @Export("getSmoothNoise2D")
   static final int getSmoothNoise2D(int var0, int var1) {
      int var2 = BaseVarType.method10(var0 - 1, var1 - 1) + BaseVarType.method10(1 + var0, var1 - 1) + BaseVarType.method10(var0 - 1, 1 + var1) + BaseVarType.method10(var0 + 1, 1 + var1);
      int var3 = BaseVarType.method10(var0 - 1, var1) + BaseVarType.method10(1 + var0, var1) + BaseVarType.method10(var0, var1 - 1) + BaseVarType.method10(var0, var1 + 1);
      int var4 = BaseVarType.method10(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }
}
