import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class14 {
   @ObfuscatedName("x")
   class23 field203;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1516099363
   )
   int field204 = -1;
   @ObfuscatedName("nq")
   static class58 field205;
   @ObfuscatedName("z")
   String[] field206;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -874787325
   )
   static int field207;
   @ObfuscatedName("gm")
   static Widget field208;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = -609433933
   )
   static int field211;
   @ObfuscatedName("j")
   int[] field215;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;S)I",
      garbageValue = "22129"
   )
   static int method164(class170 var0, class170 var1) {
      int var2 = 0;
      if(var0.method3294("title.jpg", "")) {
         ++var2;
      }

      if(var1.method3294("logo", "")) {
         ++var2;
      }

      if(var1.method3294("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method3294("titlebox", "")) {
         ++var2;
      }

      if(var1.method3294("titlebutton", "")) {
         ++var2;
      }

      if(var1.method3294("runes", "")) {
         ++var2;
      }

      if(var1.method3294("title_mute", "")) {
         ++var2;
      }

      if(var1.method3307("options_radio_buttons,0")) {
         ++var2;
      }

      if(var1.method3307("options_radio_buttons,2")) {
         ++var2;
      }

      var1.method3294("sl_back", "");
      var1.method3294("sl_flags", "");
      var1.method3294("sl_arrows", "");
      var1.method3294("sl_stars", "");
      var1.method3294("sl_button", "");
      return var2;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "35"
   )
   public static int method165(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return 1 + var0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-790835561"
   )
   static void method166() {
      class33.username = class33.username.trim();
      if(class33.username.length() == 0) {
         class20.method546("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1;
         try {
            URL var3 = new URL(class127.method2847("services", false) + "m=accountappeal/login.ws");
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
                  long var40 = var7.method2562();
                  var1 = var40;
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
         if(0L == var1) {
            var0 = 5;
         } else {
            String var38 = class33.username;
            Random var39 = new Random();
            Buffer var25 = new Buffer(128);
            Buffer var9 = new Buffer(128);
            int[] var10 = new int[]{var39.nextInt(), var39.nextInt(), (int)(var1 >> 32), (int)var1};
            var25.method2715(10);

            int var11;
            for(var11 = 0; var11 < 4; ++var11) {
               var25.method2544(var39.nextInt());
            }

            var25.method2544(var10[0]);
            var25.method2544(var10[1]);
            var25.method2546(var1);
            var25.method2546(0L);

            for(var11 = 0; var11 < 4; ++var11) {
               var25.method2544(var39.nextInt());
            }

            var25.method2577(class9.field149, class9.field146);
            var9.method2715(10);

            for(var11 = 0; var11 < 3; ++var11) {
               var9.method2544(var39.nextInt());
            }

            var9.method2546(var39.nextLong());
            var9.method2545(var39.nextLong());
            byte[] var26 = new byte[24];

            try {
               class152.field2286.method4159(0L);
               class152.field2286.method4161(var26);

               int var12;
               for(var12 = 0; var12 < 24 && var26[var12] == 0; ++var12) {
                  ;
               }

               if(var12 >= 24) {
                  throw new IOException();
               }
            } catch (Exception var36) {
               for(int var13 = 0; var13 < 24; ++var13) {
                  var26[var13] = -1;
               }
            }

            var9.method2550(var26, 0, 24);
            var9.method2546(var39.nextLong());
            var9.method2577(class9.field149, class9.field146);
            var11 = class43.method857(var38);
            if(var11 % 8 != 0) {
               var11 += 8 - var11 % 8;
            }

            Buffer var27 = new Buffer(var11);
            var27.method2616(var38);
            var27.offset = var11;
            var27.method2573(var10);
            Buffer var28 = new Buffer(var9.offset + 5 + var25.offset + var27.offset);
            var28.method2715(2);
            var28.method2715(var25.offset);
            var28.method2550(var25.payload, 0, var25.offset);
            var28.method2715(var9.offset);
            var28.method2550(var9.payload, 0, var9.offset);
            var28.method2542(var27.offset);
            var28.method2550(var27.payload, 0, var27.offset);
            byte[] var15 = var28.payload;
            int var17 = var15.length;
            StringBuilder var18 = new StringBuilder();

            int var21;
            for(int var19 = 0; var19 < 0 + var17; var19 += 3) {
               int var20 = var15[var19] & 255;
               var18.append(class164.field2705[var20 >>> 2]);
               if(var19 < var17 - 1) {
                  var21 = var15[1 + var19] & 255;
                  var18.append(class164.field2705[(var20 & 3) << 4 | var21 >>> 4]);
                  if(var19 < var17 - 2) {
                     int var22 = var15[var19 + 2] & 255;
                     var18.append(class164.field2705[(var21 & 15) << 2 | var22 >>> 6]).append(class164.field2705[var22 & 63]);
                  } else {
                     var18.append(class164.field2705[(var21 & 15) << 2]).append("=");
                  }
               } else {
                  var18.append(class164.field2705[(var20 & 3) << 4]).append("==");
               }
            }

            String var16 = var18.toString();
            var16 = var16;

            byte var32;
            try {
               URL var29 = new URL(class127.method2847("services", false) + "m=accountappeal/login.ws");
               URLConnection var41 = var29.openConnection();
               var41.setDoInput(true);
               var41.setDoOutput(true);
               var41.setConnectTimeout(5000);
               OutputStreamWriter var30 = new OutputStreamWriter(var41.getOutputStream());
               var30.write("data2=" + World.method620(var16) + "&dest=" + World.method620("passwordchoice.ws"));
               var30.flush();
               InputStream var31 = var41.getInputStream();
               var28 = new Buffer(new byte[1000]);

               while(true) {
                  var21 = var31.read(var28.payload, var28.offset, 1000 - var28.offset);
                  if(var21 == -1) {
                     var30.close();
                     var31.close();
                     String var33 = new String(var28.payload);
                     if(var33.startsWith("OFFLINE")) {
                        var32 = 4;
                     } else if(var33.startsWith("WRONG")) {
                        var32 = 7;
                     } else if(var33.startsWith("RELOAD")) {
                        var32 = 3;
                     } else if(var33.startsWith("Not permitted for social network accounts.")) {
                        var32 = 6;
                     } else {
                        var28.method2574(var10);

                        while(var28.offset > 0 && var28.payload[var28.offset - 1] == 0) {
                           --var28.offset;
                        }

                        var33 = new String(var28.payload, 0, var28.offset);
                        boolean var42;
                        if(var33 == null) {
                           var42 = false;
                        } else {
                           label151: {
                              try {
                                 new URL(var33);
                              } catch (MalformedURLException var34) {
                                 var42 = false;
                                 break label151;
                              }

                              var42 = true;
                           }
                        }

                        if(var42) {
                           class114.method2482(var33, true, false);
                           var32 = 2;
                        } else {
                           var32 = 5;
                        }
                     }
                     break;
                  }

                  var28.offset += var21;
                  if(var28.offset >= 1000) {
                     var32 = 5;
                     break;
                  }
               }
            } catch (Throwable var35) {
               var35.printStackTrace();
               var32 = 5;
            }

            var0 = var32;
         }

         switch(var0) {
         case 2:
            class20.method546("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class33.loginIndex = 6;
            break;
         case 3:
            class20.method546("", "Error connecting to server.", "");
            break;
         case 4:
            class20.method546("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class20.method546("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class20.method546("", "Error connecting to server.", "");
            break;
         case 7:
            class20.method546("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2050692904"
   )
   static void method167(int var0) {
      Client.field492 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      class77.method1624();
      if(Client.gameState >= 25) {
         class221.method4001();
      }

      GameEngine.field2257 = true;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1749914195"
   )
   static final void method168(boolean var0) {
      class92.method2127();
      ++Client.field313;
      if(Client.field313 >= 50 || var0) {
         Client.field313 = 0;
         if(!Client.field348 && Item.field694 != null) {
            Client.field323.method2818(185);

            try {
               Item.field694.method3043(Client.field323.payload, 0, Client.field323.offset);
               Client.field323.offset = 0;
            } catch (IOException var2) {
               Client.field348 = true;
            }
         }

      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIIB)Ljava/lang/String;",
      garbageValue = "2"
   )
   public static String method169(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class168.field2724[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass125;II)V",
      garbageValue = "1823242995"
   )
   static final void method170(class125 var0, int var1) {
      int var2 = var0.offset;
      class34.field762 = 0;
      int var3 = 0;
      var0.method2824();

      int var4;
      int var5;
      int var6;
      for(var4 = 0; var4 < class34.field760; ++var4) {
         var5 = class34.field755[var4];
         if((class34.field757[var5] & 1) == 0) {
            if(var3 > 0) {
               --var3;
               class34.field757[var5] = (byte)(class34.field757[var5] | 2);
            } else {
               var6 = var0.method2827(1);
               if(var6 == 0) {
                  var3 = ChatLineBuffer.method647(var0);
                  class34.field757[var5] = (byte)(class34.field757[var5] | 2);
               } else {
                  class10.method124(var0, var5);
               }
            }
         }
      }

      var0.method2822();
      if(var3 != 0) {
         throw new RuntimeException();
      } else {
         var0.method2824();

         for(var4 = 0; var4 < class34.field760; ++var4) {
            var5 = class34.field755[var4];
            if((class34.field757[var5] & 1) != 0) {
               if(var3 > 0) {
                  --var3;
                  class34.field757[var5] = (byte)(class34.field757[var5] | 2);
               } else {
                  var6 = var0.method2827(1);
                  if(var6 == 0) {
                     var3 = ChatLineBuffer.method647(var0);
                     class34.field757[var5] = (byte)(class34.field757[var5] | 2);
                  } else {
                     class10.method124(var0, var5);
                  }
               }
            }
         }

         var0.method2822();
         if(var3 != 0) {
            throw new RuntimeException();
         } else {
            var0.method2824();

            for(var4 = 0; var4 < class34.field764; ++var4) {
               var5 = class34.field763[var4];
               if((class34.field757[var5] & 1) != 0) {
                  if(var3 > 0) {
                     --var3;
                     class34.field757[var5] = (byte)(class34.field757[var5] | 2);
                  } else {
                     var6 = var0.method2827(1);
                     if(var6 == 0) {
                        var3 = ChatLineBuffer.method647(var0);
                        class34.field757[var5] = (byte)(class34.field757[var5] | 2);
                     } else if(ChatLineBuffer.method645(var0, var5)) {
                        class34.field757[var5] = (byte)(class34.field757[var5] | 2);
                     }
                  }
               }
            }

            var0.method2822();
            if(var3 != 0) {
               throw new RuntimeException();
            } else {
               var0.method2824();

               for(var4 = 0; var4 < class34.field764; ++var4) {
                  var5 = class34.field763[var4];
                  if((class34.field757[var5] & 1) == 0) {
                     if(var3 > 0) {
                        --var3;
                        class34.field757[var5] = (byte)(class34.field757[var5] | 2);
                     } else {
                        var6 = var0.method2827(1);
                        if(var6 == 0) {
                           var3 = ChatLineBuffer.method647(var0);
                           class34.field757[var5] = (byte)(class34.field757[var5] | 2);
                        } else if(ChatLineBuffer.method645(var0, var5)) {
                           class34.field757[var5] = (byte)(class34.field757[var5] | 2);
                        }
                     }
                  }
               }

               var0.method2822();
               if(var3 != 0) {
                  throw new RuntimeException();
               } else {
                  class34.field760 = 0;
                  class34.field764 = 0;

                  for(var4 = 1; var4 < 2048; ++var4) {
                     class34.field757[var4] = (byte)(class34.field757[var4] >> 1);
                     Player var7 = Client.cachedPlayers[var4];
                     if(var7 != null) {
                        class34.field755[++class34.field760 - 1] = var4;
                     } else {
                        class34.field763[++class34.field764 - 1] = var4;
                     }
                  }

                  GroundObject.method2219(var0);
                  if(var0.offset - var2 != var1) {
                     throw new RuntimeException(var0.offset - var2 + " " + var1);
                  }
               }
            }
         }
      }
   }
}
