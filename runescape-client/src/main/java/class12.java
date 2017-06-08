import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;
import java.util.Comparator;
import java.util.Random;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
final class class12 implements Comparator {
   @ObfuscatedName("e")
   public static IndexDataBase field272;
   @ObfuscatedName("pn")
   @ObfuscatedGetter(
      intValue = -738305513
   )
   static int field273;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-576643978"
   )
   public static void method74(String var0, String var1, int var2, int var3) throws IOException {
      class155.field2253 = var3;
      class228.field3159 = var2;

      try {
         class271.field3689 = System.getProperty("os.name");
      } catch (Exception var14) {
         class271.field3689 = "Unknown";
      }

      GameObject.field2203 = class271.field3689.toLowerCase();

      try {
         class2.field14 = System.getProperty("user.home");
         if(class2.field14 != null) {
            class2.field14 = class2.field14 + "/";
         }
      } catch (Exception var13) {
         ;
      }

      try {
         if(GameObject.field2203.startsWith("win")) {
            if(class2.field14 == null) {
               class2.field14 = System.getenv("USERPROFILE");
            }
         } else if(class2.field14 == null) {
            class2.field14 = System.getenv("HOME");
         }

         if(class2.field14 != null) {
            class2.field14 = class2.field14 + "/";
         }
      } catch (Exception var12) {
         ;
      }

      if(class2.field14 == null) {
         class2.field14 = "~/";
      }

      class35.field499 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class2.field14, "/tmp/", ""};
      class155.field2260 = new String[]{".jagex_cache_" + class228.field3159, ".file_store_" + class228.field3159};
      int var9 = 0;

      int var7;
      File var8;
      label132:
      while(var9 < 4) {
         class21.field347 = Player.method1100(var0, var1, var9);
         if(!class21.field347.exists()) {
            class21.field347.mkdirs();
         }

         File[] var5 = class21.field347.listFiles();
         if(var5 == null) {
            break;
         }

         File[] var6 = var5;
         var7 = 0;

         while(true) {
            if(var7 >= var6.length) {
               break label132;
            }

            var8 = var6[var7];
            if(!WidgetNode.method1066(var8, false)) {
               ++var9;
               break;
            }

            ++var7;
         }
      }

      File var4 = class21.field347;
      class157.field2268 = var4;
      if(!class157.field2268.exists()) {
         throw new RuntimeException("");
      } else {
         class157.field2270 = true;

         try {
            File var16 = new File(class2.field14, "random.dat");
            if(var16.exists()) {
               class155.field2257 = new class123(new FileOnDisk(var16, "rw", 25L), 24, 0);
            } else {
               label112:
               for(int var10 = 0; var10 < class155.field2260.length; ++var10) {
                  for(var7 = 0; var7 < class35.field499.length; ++var7) {
                     var8 = new File(class35.field499[var7] + class155.field2260[var10] + File.separatorChar + "random.dat");
                     if(var8.exists()) {
                        class155.field2257 = new class123(new FileOnDisk(var8, "rw", 25L), 24, 0);
                        break label112;
                     }
                  }
               }
            }

            if(class155.field2257 == null) {
               RandomAccessFile var17 = new RandomAccessFile(var16, "rw");
               var7 = var17.read();
               var17.seek(0L);
               var17.write(var7);
               var17.seek(0L);
               var17.close();
               class155.field2257 = new class123(new FileOnDisk(var16, "rw", 25L), 24, 0);
            }
         } catch (IOException var15) {
            ;
         }

         class155.field2254 = new class123(new FileOnDisk(class25.method205("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
         class155.field2259 = new class123(new FileOnDisk(class25.method205("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
         class29.field432 = new class123[class155.field2253];

         for(int var11 = 0; var11 < class155.field2253; ++var11) {
            class29.field432[var11] = new class123(new FileOnDisk(class25.method205("main_file_cache.idx" + var11), "rw", 1048576L), 6000, 0);
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "-372651998"
   )
   int method75(class14 var1, class14 var2) {
      return var1.field292 < var2.field292?-1:(var1.field292 == var2.field292?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method75((class14)var1, (class14)var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1446675645"
   )
   static int method80(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method3545((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1820159642"
   )
   static void method82() {
      for(class82 var0 = (class82)class82.field1325.method3622(); var0 != null; var0 = (class82)class82.field1325.method3608()) {
         if(var0.field1330 != null) {
            WorldMapType0.field613.method1862(var0.field1330);
            var0.field1330 = null;
         }

         if(var0.field1335 != null) {
            WorldMapType0.field613.method1862(var0.field1335);
            var0.field1335 = null;
         }
      }

      class82.field1325.method3601();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "6"
   )
   static void method83() {
      class92.username = class92.username.trim();
      if(class92.username.length() == 0) {
         class15.method115("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1;
         try {
            URL var3 = new URL(class39.method542("services", false) + "m=accountappeal/login.ws");
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
         if(var1 == 0L) {
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

            var24.method3180(class87.field1383, class87.field1382);
            var9.putByte(10);

            for(var11 = 0; var11 < 3; ++var11) {
               var9.putInt(var30.nextInt());
            }

            var9.putLong(var30.nextLong());
            var9.method3174(var30.nextLong());
            class220.method4084(var9);
            var9.putLong(var30.nextLong());
            var9.method3180(class87.field1383, class87.field1382);
            var11 = Script.method1836(var29);
            if(var11 % 8 != 0) {
               var11 += 8 - var11 % 8;
            }

            Buffer var12 = new Buffer(var11);
            var12.method3150(var29);
            var12.offset = var11;
            var12.encryptXtea2(var10);
            Buffer var13 = new Buffer(var12.offset + var9.offset + var24.offset + 5);
            var13.putByte(2);
            var13.putByte(var24.offset);
            var13.putBytes(var24.payload, 0, var24.offset);
            var13.putByte(var9.offset);
            var13.putBytes(var9.payload, 0, var9.offset);
            var13.putShort(var12.offset);
            var13.putBytes(var12.payload, 0, var12.offset);
            String var14 = class229.method4106(var13.payload);

            byte var25;
            try {
               URL var15 = new URL(class39.method542("services", false) + "m=accountappeal/login.ws");
               URLConnection var16 = var15.openConnection();
               var16.setDoInput(true);
               var16.setDoOutput(true);
               var16.setConnectTimeout(5000);
               OutputStreamWriter var17 = new OutputStreamWriter(var16.getOutputStream());
               var17.write("data2=" + FrameMap.method2672(var14) + "&dest=" + FrameMap.method2672("passwordchoice.ws"));
               var17.flush();
               InputStream var18 = var16.getInputStream();
               var13 = new Buffer(new byte[1000]);

               while(true) {
                  int var19 = var18.read(var13.payload, var13.offset, 1000 - var13.offset);
                  if(var19 == -1) {
                     var17.close();
                     var18.close();
                     String var26 = new String(var13.payload);
                     if(var26.startsWith("OFFLINE")) {
                        var25 = 4;
                     } else if(var26.startsWith("WRONG")) {
                        var25 = 7;
                     } else if(var26.startsWith("RELOAD")) {
                        var25 = 3;
                     } else if(var26.startsWith("Not permitted for social network accounts.")) {
                        var25 = 6;
                     } else {
                        var13.decryptXtea(var10);

                        while(var13.offset > 0 && var13.payload[var13.offset - 1] == 0) {
                           --var13.offset;
                        }

                        var26 = new String(var13.payload, 0, var13.offset);
                        if(Player.method1116(var26)) {
                           class7.method44(var26, true, "openjs", false);
                           var25 = 2;
                        } else {
                           var25 = 5;
                        }
                     }
                     break;
                  }

                  var13.offset += var19;
                  if(var13.offset >= 1000) {
                     var25 = 5;
                     break;
                  }
               }
            } catch (Throwable var27) {
               var27.printStackTrace();
               var25 = 5;
            }

            var0 = var25;
         }

         switch(var0) {
         case 2:
            class15.method115("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class92.loginIndex = 6;
            break;
         case 3:
            class15.method115("", "Error connecting to server.", "");
            break;
         case 4:
            class15.method115("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class15.method115("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class15.method115("", "Error connecting to server.", "");
            break;
         case 7:
            class15.method115("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }
}
