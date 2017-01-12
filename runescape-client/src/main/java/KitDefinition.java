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

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var1 * var5 + var10;
            if(var5 != var9 / var1) {
               throw new NumberFormatException();
            }

            var5 = var9;
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
         long var1;
         try {
            URL var3 = new URL(class164.method3113("services", false) + "m=accountappeal/login.ws");
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
                  long var35 = var7.method2908();
                  var1 = var35;
                  break;
               }

               var7.offset += var8;
               if(var7.offset >= 1000) {
                  var1 = 0L;
                  break;
               }
            }
         } catch (Exception var32) {
            var1 = 0L;
         }

         byte var0;
         if(var1 == 0L) {
            var0 = 5;
         } else {
            String var33 = class41.username;
            Random var34 = new Random();
            Buffer var23 = new Buffer(128);
            Buffer var9 = new Buffer(128);
            int[] var10 = new int[]{var34.nextInt(), var34.nextInt(), (int)(var1 >> 32), (int)var1};
            var23.method2760(10);

            int var11;
            for(var11 = 0; var11 < 4; ++var11) {
               var23.method2763(var34.nextInt());
            }

            var23.method2763(var10[0]);
            var23.method2763(var10[1]);
            var23.method2933(var1);
            var23.method2933(0L);

            for(var11 = 0; var11 < 4; ++var11) {
               var23.method2763(var34.nextInt());
            }

            var23.method2796(class36.field767, class36.field766);
            var9.method2760(10);

            for(var11 = 0; var11 < 3; ++var11) {
               var9.method2763(var34.nextInt());
            }

            var9.method2933(var34.nextLong());
            var9.method2764(var34.nextLong());
            byte[] var24 = new byte[24];

            try {
               class104.field1682.method1335(0L);
               class104.field1682.method1337(var24);

               int var12;
               for(var12 = 0; var12 < 24 && var24[var12] == 0; ++var12) {
                  ;
               }

               if(var12 >= 24) {
                  throw new IOException();
               }
            } catch (Exception var31) {
               for(int var13 = 0; var13 < 24; ++var13) {
                  var24[var13] = -1;
               }
            }

            var9.method2769(var24, 0, 24);
            var9.method2933(var34.nextLong());
            var9.method2796(class36.field767, class36.field766);
            var11 = class148.method2740(var33);
            if(var11 % 8 != 0) {
               var11 += 8 - var11 % 8;
            }

            Buffer var25 = new Buffer(var11);
            var25.method2811(var33);
            var25.offset = var11;
            var25.method2886(var10);
            Buffer var26 = new Buffer(var25.offset + var9.offset + var23.offset + 5);
            var26.method2760(2);
            var26.method2760(var23.offset);
            var26.method2769(var23.payload, 0, var23.offset);
            var26.method2760(var9.offset);
            var26.method2769(var9.payload, 0, var9.offset);
            var26.method2918(var25.offset);
            var26.method2769(var25.payload, 0, var25.offset);
            String var14 = class57.method1057(var26.payload);

            byte var27;
            try {
               URL var15 = new URL(class164.method3113("services", false) + "m=accountappeal/login.ws");
               URLConnection var16 = var15.openConnection();
               var16.setDoInput(true);
               var16.setDoOutput(true);
               var16.setConnectTimeout(5000);
               OutputStreamWriter var17 = new OutputStreamWriter(var16.getOutputStream());
               var17.write("data2=" + class156.method3010(var14) + "&dest=" + class156.method3010("passwordchoice.ws"));
               var17.flush();
               InputStream var18 = var16.getInputStream();
               var26 = new Buffer(new byte[1000]);

               while(true) {
                  int var19 = var18.read(var26.payload, var26.offset, 1000 - var26.offset);
                  if(var19 == -1) {
                     var17.close();
                     var18.close();
                     String var28 = new String(var26.payload);
                     if(var28.startsWith("OFFLINE")) {
                        var27 = 4;
                     } else if(var28.startsWith("WRONG")) {
                        var27 = 7;
                     } else if(var28.startsWith("RELOAD")) {
                        var27 = 3;
                     } else if(var28.startsWith("Not permitted for social network accounts.")) {
                        var27 = 6;
                     } else {
                        var26.method2793(var10);

                        while(var26.offset > 0 && var26.payload[var26.offset - 1] == 0) {
                           --var26.offset;
                        }

                        var28 = new String(var26.payload, 0, var26.offset);
                        boolean var20;
                        if(var28 == null) {
                           var20 = false;
                        } else {
                           label133: {
                              try {
                                 new URL(var28);
                              } catch (MalformedURLException var29) {
                                 var20 = false;
                                 break label133;
                              }

                              var20 = true;
                           }
                        }

                        if(var20) {
                           class156.method2998(var28, true, false);
                           var27 = 2;
                        } else {
                           var27 = 5;
                        }
                     }
                     break;
                  }

                  var26.offset += var19;
                  if(var26.offset >= 1000) {
                     var27 = 5;
                     break;
                  }
               }
            } catch (Throwable var30) {
               var30.printStackTrace();
               var27 = 5;
            }

            var0 = var27;
         }

         switch(var0) {
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
