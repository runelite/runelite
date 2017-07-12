import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class134 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2101081929
   )
   static int field2001;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -905297415
   )
   static int field2002;
   @ObfuscatedName("i")
   public static boolean field2003;
   @ObfuscatedName("t")
   public static boolean field2004;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1129093421
   )
   static int field2006;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1655042721
   )
   static int field2007;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1872474617
   )
   public static int field2008;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1324248827
   )
   static int field2009;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1371151497
   )
   public static int field2010;
   @ObfuscatedName("c")
   public static int[] field2011;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1377207279
   )
   public static int field2014;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-103"
   )
   @Export("ilog")
   public static int ilog(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;I)I",
      garbageValue = "659140844"
   )
   static final int method2576(long var0, String var2) {
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

      var4.encryptRsa(class87.field1404, class87.field1405);
      var5.putByte(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.putInt(var3.nextInt());
      }

      var5.putLong(var3.nextLong());
      var5.method3135(var3.nextLong());
      class73.method1152(var5);
      var5.putLong(var3.nextLong());
      var5.encryptRsa(class87.field1404, class87.field1405);
      var7 = class261.getLength(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      Buffer var8 = new Buffer(var7);
      var8.putString(var2);
      var8.offset = var7;
      var8.encryptXtea2(var6);
      Buffer var9 = new Buffer(var8.offset + var5.offset + var4.offset + 5);
      var9.putByte(2);
      var9.putByte(var4.offset);
      var9.putBytes(var4.payload, 0, var4.offset);
      var9.putByte(var5.offset);
      var9.putBytes(var5.payload, 0, var5.offset);
      var9.putShort(var8.offset);
      var9.putBytes(var8.payload, 0, var8.offset);
      byte[] var10 = var9.payload;
      int var11 = var10.length;
      StringBuilder var12 = new StringBuilder();

      int var13;
      for(int var14 = 0; var14 < var11 + 0; var14 += 3) {
         int var15 = var10[var14] & 255;
         var12.append(class269.field3684[var15 >>> 2]);
         if(var14 < var11 - 1) {
            var13 = var10[var14 + 1] & 255;
            var12.append(class269.field3684[(var15 & 3) << 4 | var13 >>> 4]);
            if(var14 < var11 - 2) {
               int var16 = var10[var14 + 2] & 255;
               var12.append(class269.field3684[(var13 & 15) << 2 | var16 >>> 6]).append(class269.field3684[var16 & 63]);
            } else {
               var12.append(class269.field3684[(var13 & 15) << 2]).append("=");
            }
         } else {
            var12.append(class269.field3684[(var15 & 3) << 4]).append("==");
         }
      }

      String var24 = var12.toString();
      var24 = var24;

      try {
         URL var25 = new URL(WorldMapType1.method263("services", false) + "m=accountappeal/login.ws");
         URLConnection var26 = var25.openConnection();
         var26.setDoInput(true);
         var26.setDoOutput(true);
         var26.setConnectTimeout(5000);
         OutputStreamWriter var17 = new OutputStreamWriter(var26.getOutputStream());
         var17.write("data2=" + NPC.method1693(var24) + "&dest=" + NPC.method1693("passwordchoice.ws"));
         var17.flush();
         InputStream var18 = var26.getInputStream();
         var9 = new Buffer(new byte[1000]);

         do {
            var13 = var18.read(var9.payload, var9.offset, 1000 - var9.offset);
            if(var13 == -1) {
               var17.close();
               var18.close();
               String var19 = new String(var9.payload);
               if(var19.startsWith("OFFLINE")) {
                  return 4;
               } else if(var19.startsWith("WRONG")) {
                  return 7;
               } else if(var19.startsWith("RELOAD")) {
                  return 3;
               } else if(var19.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var9.decryptXtea(var6);

                  while(var9.offset > 0 && var9.payload[var9.offset - 1] == 0) {
                     --var9.offset;
                  }

                  var19 = new String(var9.payload, 0, var9.offset);
                  boolean var20;
                  if(var19 == null) {
                     var20 = false;
                  } else {
                     label84: {
                        try {
                           new URL(var19);
                        } catch (MalformedURLException var22) {
                           var20 = false;
                           break label84;
                        }

                        var20 = true;
                     }
                  }

                  if(var20) {
                     Player.method1175(var19, true, false);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var9.offset += var13;
         } while(var9.offset < 1000);

         return 5;
      } catch (Throwable var23) {
         var23.printStackTrace();
         return 5;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([LRSEnum;IS)LRSEnum;",
      garbageValue = "-21134"
   )
   @Export("forOrdinal")
   public static RSEnum forOrdinal(RSEnum[] var0, int var1) {
      RSEnum[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         RSEnum var4 = var2[var3];
         if(var1 == var4.rsOrdinal()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILclass219;I)I",
      garbageValue = "-1925881653"
   )
   public static int method2579(int var0, class219 var1) {
      return (var0 << 8) + var1.field2804;
   }

   static {
      field2003 = false;
      field2014 = 0;
      field2008 = 0;
      field2004 = false;
      field2010 = 0;
      field2011 = new int[1000];
   }
}
