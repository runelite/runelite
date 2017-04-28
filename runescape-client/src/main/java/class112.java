import java.awt.Component;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public abstract class class112 {
   @ObfuscatedName("z")
   public static short[][] field1761;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1297902759"
   )
   public static void method2101(boolean var0) {
      if(class187.field2759 != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class187.field2759.queueForWrite(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class187.field2759.method2093();
            } catch (Exception var3) {
               ;
            }

            ++class187.field2770;
            class187.field2759 = null;
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "1"
   )
   public abstract void vmethod2102(Component var1);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "59"
   )
   public abstract void vmethod2103(Component var1);

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-82198780"
   )
   static void method2109(int var0, int var1, int var2, int var3) {
      Widget var4 = class0.method13(var0, var1);
      if(var4 != null && var4.field2261 != null) {
         class18 var5 = new class18();
         var5.field189 = var4;
         var5.field196 = var4.field2261;
         Script.method910(var5, 200000);
      }

      Client.field537 = var3;
      Client.field440 = true;
      XClanMember.field269 = var0;
      Client.field441 = var1;
      class159.field2071 = var2;
      class124.method2350(var4);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1491596698"
   )
   public static boolean method2112(int var0) {
      if(Widget.validInterfaces[var0]) {
         return true;
      } else if(!Widget.field2197.method3298(var0)) {
         return false;
      } else {
         int var1 = Widget.field2197.method3305(var0);
         if(var1 == 0) {
            Widget.validInterfaces[var0] = true;
            return true;
         } else {
            if(class133.widgets[var0] == null) {
               class133.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(class133.widgets[var0][var2] == null) {
                  byte[] var3 = Widget.field2197.getConfigData(var0, var2);
                  if(var3 != null) {
                     class133.widgets[var0][var2] = new Widget();
                     class133.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        class133.widgets[var0][var2].method3189(new Buffer(var3));
                     } else {
                        class133.widgets[var0][var2].method3218(new Buffer(var3));
                     }
                  }
               }
            }

            Widget.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1065815514"
   )
   public abstract int vmethod2113();

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-263976734"
   )
   static void method2114() {
      class41.username = class41.username.trim();
      if(class41.username.length() == 0) {
         class45.method854("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = class118.method2289();
         byte var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            String var4 = class41.username;
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

            var6.method2483(class36.field764, class36.field765);
            var7.putByte(10);

            for(var9 = 0; var9 < 3; ++var9) {
               var7.putInt(var5.nextInt());
            }

            var7.putLong(var5.nextLong());
            var7.put48bitLong(var5.nextLong());
            class65.method1195(var7);
            var7.putLong(var5.nextLong());
            var7.method2483(class36.field764, class36.field765);
            var9 = class36.method753(var4);
            if(var9 % 8 != 0) {
               var9 += 8 - var9 % 8;
            }

            Buffer var10 = new Buffer(var9);
            var10.method2504(var4);
            var10.offset = var9;
            var10.encryptXtea2(var8);
            Buffer var11 = new Buffer(var6.offset + 5 + var7.offset + var10.offset);
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
               var16.append(class213.field3144[var18 >>> 2]);
               if(var17 < var15 - 1) {
                  var19 = var13[var17 + 1] & 255;
                  var16.append(class213.field3144[(var18 & 3) << 4 | var19 >>> 4]);
                  if(var17 < var15 - 2) {
                     int var20 = var13[var17 + 2] & 255;
                     var16.append(class213.field3144[(var19 & 15) << 2 | var20 >>> 6]).append(class213.field3144[var20 & 63]);
                  } else {
                     var16.append(class213.field3144[(var19 & 15) << 2]).append("=");
                  }
               } else {
                  var16.append(class213.field3144[(var18 & 3) << 4]).append("==");
               }
            }

            String var14 = var16.toString();
            var14 = var14;

            byte var3;
            try {
               URL var21 = new URL(Friend.method184("services", false) + "m=accountappeal/login.ws");
               URLConnection var26 = var21.openConnection();
               var26.setDoInput(true);
               var26.setDoOutput(true);
               var26.setConnectTimeout(5000);
               OutputStreamWriter var22 = new OutputStreamWriter(var26.getOutputStream());
               var22.write("data2=" + class219.method4063(var14) + "&dest=" + class219.method4063("passwordchoice.ws"));
               var22.flush();
               InputStream var23 = var26.getInputStream();
               var11 = new Buffer(new byte[1000]);

               while(true) {
                  var19 = var23.read(var11.payload, var11.offset, 1000 - var11.offset);
                  if(var19 == -1) {
                     var22.close();
                     var23.close();
                     String var24 = new String(var11.payload);
                     if(var24.startsWith("OFFLINE")) {
                        var3 = 4;
                     } else if(var24.startsWith("WRONG")) {
                        var3 = 7;
                     } else if(var24.startsWith("RELOAD")) {
                        var3 = 3;
                     } else if(var24.startsWith("Not permitted for social network accounts.")) {
                        var3 = 6;
                     } else {
                        var11.decryptXtea(var8);

                        while(var11.offset > 0 && var11.payload[var11.offset - 1] == 0) {
                           --var11.offset;
                        }

                        var24 = new String(var11.payload, 0, var11.offset);
                        if(CombatInfo1.method599(var24)) {
                           class128.method2366(var24, true, "openjs", false);
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
            } catch (Throwable var25) {
               var25.printStackTrace();
               var3 = 5;
            }

            var0 = var3;
         }

         switch(var0) {
         case 2:
            class45.method854("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class41.loginIndex = 6;
            break;
         case 3:
            class45.method854("", "Error connecting to server.", "");
            break;
         case 4:
            class45.method854("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class45.method854("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class45.method854("", "Error connecting to server.", "");
            break;
         case 7:
            class45.method854("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }
}
