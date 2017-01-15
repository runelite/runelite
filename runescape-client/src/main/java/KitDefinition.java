import java.io.IOException;
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

@ObfuscatedName("go")
@Implements("KitDefinition")
public class KitDefinition extends CacheableNode {
   @ObfuscatedName("c")
   int[] field2797;
   @ObfuscatedName("a")
   static NodeCache field2799 = new NodeCache(64);
   @ObfuscatedName("u")
   static class182 field2800;
   @ObfuscatedName("d")
   short[] field2802;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1480186991
   )
   public int field2803 = -1;
   @ObfuscatedName("g")
   short[] field2804;
   @ObfuscatedName("z")
   short[] field2805;
   @ObfuscatedName("t")
   int[] field2806 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("m")
   public boolean field2807 = false;
   @ObfuscatedName("x")
   static class182 field2810;
   @ObfuscatedName("l")
   short[] field2812;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "76367363"
   )
   void method3481(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3482(var1, var2);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "1"
   )
   void method3482(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field2803 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.readUnsignedByte();
            this.field2797 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2797[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 3) {
            this.field2807 = true;
         } else if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field2802 = new short[var3];
            this.field2812 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2802[var4] = (short)var1.readUnsignedShort();
               this.field2812[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field2804 = new short[var3];
            this.field2805 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field2804[var4] = (short)var1.readUnsignedShort();
               this.field2805[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field2806[var2 - 60] = var1.readUnsignedShort();
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1252443171"
   )
   @Export("ready")
   public boolean ready() {
      if(null == this.field2797) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field2797.length; ++var2) {
            if(!field2810.method3264(this.field2797[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "1446368513"
   )
   @Export("getModelData")
   public ModelData getModelData() {
      if(this.field2797 == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.field2797.length];

         for(int var2 = 0; var2 < this.field2797.length; ++var2) {
            var1[var2] = ModelData.method1463(field2810, this.field2797[var2], 0);
         }

         ModelData var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new ModelData(var1, var1.length);
         }

         int var3;
         if(null != this.field2802) {
            for(var3 = 0; var3 < this.field2802.length; ++var3) {
               var4.method1427(this.field2802[var3], this.field2812[var3]);
            }
         }

         if(null != this.field2804) {
            for(var3 = 0; var3 < this.field2804.length; ++var3) {
               var4.method1469(this.field2804[var3], this.field2805[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-60"
   )
   public boolean method3485() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field2806[var2] != -1 && !field2810.method3264(this.field2806[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "1965610723"
   )
   public ModelData method3486() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.field2806[var3] != -1) {
            var1[var2++] = ModelData.method1463(field2810, this.field2806[var3], 0);
         }
      }

      ModelData var5 = new ModelData(var1, var2);
      int var4;
      if(this.field2802 != null) {
         for(var4 = 0; var4 < this.field2802.length; ++var4) {
            var5.method1427(this.field2802[var4], this.field2812[var4]);
         }
      }

      if(null != this.field2804) {
         for(var4 = 0; var4 < this.field2804.length; ++var4) {
            var5.method1469(this.field2804[var4], this.field2805[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)I",
      garbageValue = "-48"
   )
   public static int method3499(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var9;
            if(var8 >= 48 && var8 <= 57) {
               var9 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var9 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var9 = var8 - 87;
            }

            if(var9 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var9 = -var9;
            }

            int var10 = var1 * var5 + var9;
            if(var5 != var10 / var1) {
               throw new NumberFormatException();
            }

            var5 = var10;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-38786899"
   )
   static void method3507() {
      class41.username = class41.username.trim();
      if(class41.username.length() == 0) {
         class116.method2225("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var0;
         Buffer var6;
         try {
            URL var2 = new URL(class164.method3113("services", false) + "m=accountappeal/login.ws");
            URLConnection var3 = var2.openConnection();
            var3.setRequestProperty("connection", "close");
            var3.setDoInput(true);
            var3.setDoOutput(true);
            var3.setConnectTimeout(5000);
            OutputStreamWriter var4 = new OutputStreamWriter(var3.getOutputStream());
            var4.write("data1=req");
            var4.flush();
            InputStream var5 = var3.getInputStream();
            var6 = new Buffer(new byte[1000]);

            while(true) {
               int var7 = var5.read(var6.payload, var6.offset, 1000 - var6.offset);
               if(var7 == -1) {
                  var6.offset = 0;
                  long var8 = var6.method2908();
                  var0 = var8;
                  break;
               }

               var6.offset += var7;
               if(var6.offset >= 1000) {
                  var0 = 0L;
                  break;
               }
            }
         } catch (Exception var25) {
            var0 = 0L;
         }

         byte var26;
         if(var0 == 0L) {
            var26 = 5;
         } else {
            String var27 = class41.username;
            Random var28 = new Random();
            Buffer var29 = new Buffer(128);
            var6 = new Buffer(128);
            int[] var30 = new int[]{var28.nextInt(), var28.nextInt(), (int)(var0 >> 32), (int)var0};
            var29.method2760(10);

            int var31;
            for(var31 = 0; var31 < 4; ++var31) {
               var29.method2763(var28.nextInt());
            }

            var29.method2763(var30[0]);
            var29.method2763(var30[1]);
            var29.method2933(var0);
            var29.method2933(0L);

            for(var31 = 0; var31 < 4; ++var31) {
               var29.method2763(var28.nextInt());
            }

            var29.method2796(class36.field767, class36.field766);
            var6.method2760(10);

            for(var31 = 0; var31 < 3; ++var31) {
               var6.method2763(var28.nextInt());
            }

            var6.method2933(var28.nextLong());
            var6.method2764(var28.nextLong());
            byte[] var9 = new byte[24];

            try {
               class104.field1682.method1335(0L);
               class104.field1682.method1337(var9);

               int var10;
               for(var10 = 0; var10 < 24 && var9[var10] == 0; ++var10) {
                  ;
               }

               if(var10 >= 24) {
                  throw new IOException();
               }
            } catch (Exception var24) {
               for(int var11 = 0; var11 < 24; ++var11) {
                  var9[var11] = -1;
               }
            }

            var6.method2769(var9, 0, 24);
            var6.method2933(var28.nextLong());
            var6.method2796(class36.field767, class36.field766);
            var31 = class148.method2740(var27);
            if(var31 % 8 != 0) {
               var31 += 8 - var31 % 8;
            }

            Buffer var32 = new Buffer(var31);
            var32.method2811(var27);
            var32.offset = var31;
            var32.method2886(var30);
            Buffer var33 = new Buffer(var32.offset + var6.offset + var29.offset + 5);
            var33.method2760(2);
            var33.method2760(var29.offset);
            var33.method2769(var29.payload, 0, var29.offset);
            var33.method2760(var6.offset);
            var33.method2769(var6.payload, 0, var6.offset);
            var33.method2918(var32.offset);
            var33.method2769(var32.payload, 0, var32.offset);
            String var12 = class57.method1057(var33.payload);

            byte var13;
            try {
               URL var14 = new URL(class164.method3113("services", false) + "m=accountappeal/login.ws");
               URLConnection var15 = var14.openConnection();
               var15.setDoInput(true);
               var15.setDoOutput(true);
               var15.setConnectTimeout(5000);
               OutputStreamWriter var16 = new OutputStreamWriter(var15.getOutputStream());
               var16.write("data2=" + class156.method3010(var12) + "&dest=" + class156.method3010("passwordchoice.ws"));
               var16.flush();
               InputStream var17 = var15.getInputStream();
               var33 = new Buffer(new byte[1000]);

               while(true) {
                  int var18 = var17.read(var33.payload, var33.offset, 1000 - var33.offset);
                  if(var18 == -1) {
                     var16.close();
                     var17.close();
                     String var19 = new String(var33.payload);
                     if(var19.startsWith("OFFLINE")) {
                        var13 = 4;
                     } else if(var19.startsWith("WRONG")) {
                        var13 = 7;
                     } else if(var19.startsWith("RELOAD")) {
                        var13 = 3;
                     } else if(var19.startsWith("Not permitted for social network accounts.")) {
                        var13 = 6;
                     } else {
                        var33.method2793(var30);

                        while(var33.offset > 0 && var33.payload[var33.offset - 1] == 0) {
                           --var33.offset;
                        }

                        var19 = new String(var33.payload, 0, var33.offset);
                        boolean var20;
                        if(var19 == null) {
                           var20 = false;
                        } else {
                           label178: {
                              try {
                                 new URL(var19);
                              } catch (MalformedURLException var22) {
                                 var20 = false;
                                 break label178;
                              }

                              var20 = true;
                           }
                        }

                        if(var20) {
                           class156.method2998(var19, true, false);
                           var13 = 2;
                        } else {
                           var13 = 5;
                        }
                     }
                     break;
                  }

                  var33.offset += var18;
                  if(var33.offset >= 1000) {
                     var13 = 5;
                     break;
                  }
               }
            } catch (Throwable var23) {
               var23.printStackTrace();
               var13 = 5;
            }

            var26 = var13;
         }

         switch(var26) {
         case 2:
            class116.method2225("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class41.loginIndex = 6;
            break;
         case 3:
            class116.method2225("", "Error connecting to server.", "");
            break;
         case 4:
            class116.method2225("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class116.method2225("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class116.method2225("", "Error connecting to server.", "");
            break;
         case 7:
            class116.method2225("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }
      }

   }
}
