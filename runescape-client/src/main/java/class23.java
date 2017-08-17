import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class23 {
   @ObfuscatedName("kc")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   static Widget field359;

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "([Lhi;IIIZB)V",
      garbageValue = "-106"
   )
   static void method183(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            WorldMapType2.method555(var6, var2, var3, var4);
            class17.method131(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class51.method812(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;I)I",
      garbageValue = "1495566971"
   )
   static final int method184(long var0, String var2) {
      Random var3 = new Random();
      Buffer var4 = new Buffer(128);
      Buffer var5 = new Buffer(128);
      int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
      var4.putByte(10);

      int var7;
      for(var7 = 0; var7 < 4; ++var7) {
         var4.putInt(var3.nextInt());
      }

      var4.putInt(var6[0]);
      var4.putInt(var6[1]);
      var4.putLong(var0);
      var4.putLong(0L);

      for(var7 = 0; var7 < 4; ++var7) {
         var4.putInt(var3.nextInt());
      }

      var4.encryptRsa(class88.field1387, class88.field1388);
      var5.putByte(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.putInt(var3.nextInt());
      }

      var5.putLong(var3.nextLong());
      var5.method3163(var3.nextLong());
      if(Client.field971 != null) {
         var5.putBytes(Client.field971, 0, Client.field971.length);
      } else {
         byte[] var21 = class163.method3085();
         var5.putBytes(var21, 0, var21.length);
      }

      var5.putLong(var3.nextLong());
      var5.encryptRsa(class88.field1387, class88.field1388);
      var7 = class169.getLength(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      Buffer var8 = new Buffer(var7);
      var8.putString(var2);
      var8.offset = var7;
      var8.encryptXtea2(var6);
      Buffer var9 = new Buffer(var4.offset + var5.offset + var8.offset + 5);
      var9.putByte(2);
      var9.putByte(var4.offset);
      var9.putBytes(var4.payload, 0, var4.offset);
      var9.putByte(var5.offset);
      var9.putBytes(var5.payload, 0, var5.offset);
      var9.putShort(var8.offset);
      var9.putBytes(var8.payload, 0, var8.offset);
      byte[] var11 = var9.payload;
      String var10 = CombatInfo2.method4434(var11, 0, var11.length);
      String var12 = var10;

      try {
         URL var13 = new URL(CombatInfo1.method1553("services", false) + "m=accountappeal/login.ws");
         URLConnection var14 = var13.openConnection();
         var14.setDoInput(true);
         var14.setDoOutput(true);
         var14.setConnectTimeout(5000);
         OutputStreamWriter var15 = new OutputStreamWriter(var14.getOutputStream());
         var15.write("data2=" + ISAACCipher.method3445(var12) + "&dest=" + ISAACCipher.method3445("passwordchoice.ws"));
         var15.flush();
         InputStream var16 = var14.getInputStream();
         var9 = new Buffer(new byte[1000]);

         do {
            int var17 = var16.read(var9.payload, var9.offset, 1000 - var9.offset);
            if(var17 == -1) {
               var15.close();
               var16.close();
               String var20 = new String(var9.payload);
               if(var20.startsWith("OFFLINE")) {
                  return 4;
               } else if(var20.startsWith("WRONG")) {
                  return 7;
               } else if(var20.startsWith("RELOAD")) {
                  return 3;
               } else if(var20.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var9.decryptXtea(var6);

                  while(var9.offset > 0 && var9.payload[var9.offset - 1] == 0) {
                     --var9.offset;
                  }

                  var20 = new String(var9.payload, 0, var9.offset);
                  boolean var18;
                  if(var20 == null) {
                     var18 = false;
                  } else {
                     label83: {
                        try {
                           new URL(var20);
                        } catch (MalformedURLException var22) {
                           var18 = false;
                           break label83;
                        }

                        var18 = true;
                     }
                  }

                  if(var18) {
                     class31.method292(var20, true, false);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var9.offset += var17;
         } while(var9.offset < 1000);

         return 5;
      } catch (Throwable var23) {
         var23.printStackTrace();
         return 5;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)[B",
      garbageValue = "850703073"
   )
   public static byte[] method182(CharSequence var0) {
      int var1 = var0.length();
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 > 0 && var4 < 128 || var4 >= 160 && var4 <= 255) {
            var2[var3] = (byte)var4;
         } else if(var4 == 8364) {
            var2[var3] = -128;
         } else if(var4 == 8218) {
            var2[var3] = -126;
         } else if(var4 == 402) {
            var2[var3] = -125;
         } else if(var4 == 8222) {
            var2[var3] = -124;
         } else if(var4 == 8230) {
            var2[var3] = -123;
         } else if(var4 == 8224) {
            var2[var3] = -122;
         } else if(var4 == 8225) {
            var2[var3] = -121;
         } else if(var4 == 710) {
            var2[var3] = -120;
         } else if(var4 == 8240) {
            var2[var3] = -119;
         } else if(var4 == 352) {
            var2[var3] = -118;
         } else if(var4 == 8249) {
            var2[var3] = -117;
         } else if(var4 == 338) {
            var2[var3] = -116;
         } else if(var4 == 381) {
            var2[var3] = -114;
         } else if(var4 == 8216) {
            var2[var3] = -111;
         } else if(var4 == 8217) {
            var2[var3] = -110;
         } else if(var4 == 8220) {
            var2[var3] = -109;
         } else if(var4 == 8221) {
            var2[var3] = -108;
         } else if(var4 == 8226) {
            var2[var3] = -107;
         } else if(var4 == 8211) {
            var2[var3] = -106;
         } else if(var4 == 8212) {
            var2[var3] = -105;
         } else if(var4 == 732) {
            var2[var3] = -104;
         } else if(var4 == 8482) {
            var2[var3] = -103;
         } else if(var4 == 353) {
            var2[var3] = -102;
         } else if(var4 == 8250) {
            var2[var3] = -101;
         } else if(var4 == 339) {
            var2[var3] = -100;
         } else if(var4 == 382) {
            var2[var3] = -98;
         } else if(var4 == 376) {
            var2[var3] = -97;
         } else {
            var2[var3] = 63;
         }
      }

      return var2;
   }
}
