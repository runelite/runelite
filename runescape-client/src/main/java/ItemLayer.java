import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 635853981
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1559675429
   )
   @Export("x")
   int x;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1695005949
   )
   @Export("y")
   int y;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   @Export("top")
   Renderable top;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1385237001
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 221142183
   )
   @Export("height")
   int height;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "1384374911"
   )
   public static void method2658(String var0, Throwable var1) {
      var1.printStackTrace();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;I)I",
      garbageValue = "-1803341699"
   )
   static final int method2657(long var0, String var2) {
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

      var4.encryptRsa(class85.field1293, class85.field1296);
      var5.putByte(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.putInt(var3.nextInt());
      }

      var5.putLong(var3.nextLong());
      var5.method3569(var3.nextLong());
      MouseRecorder.method1099(var5);
      var5.putLong(var3.nextLong());
      var5.encryptRsa(class85.field1293, class85.field1296);
      var7 = class29.getLength(var2);
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
      byte[] var11 = var9.payload;
      int var13 = var11.length;
      StringBuilder var14 = new StringBuilder();

      int var17;
      for(int var15 = 0; var15 < var13 + 0; var15 += 3) {
         int var16 = var11[var15] & 255;
         var14.append(class317.field3917[var16 >>> 2]);
         if(var15 < var13 - 1) {
            var17 = var11[var15 + 1] & 255;
            var14.append(class317.field3917[(var16 & 3) << 4 | var17 >>> 4]);
            if(var15 < var13 - 2) {
               int var18 = var11[var15 + 2] & 255;
               var14.append(class317.field3917[(var17 & 15) << 2 | var18 >>> 6]).append(class317.field3917[var18 & 63]);
            } else {
               var14.append(class317.field3917[(var17 & 15) << 2]).append("=");
            }
         } else {
            var14.append(class317.field3917[(var16 & 3) << 4]).append("==");
         }
      }

      String var12 = var14.toString();
      var12 = var12;

      try {
         URL var19 = new URL(class281.method5109("services", false) + "m=accountappeal/login.ws");
         URLConnection var24 = var19.openConnection();
         var24.setDoInput(true);
         var24.setDoOutput(true);
         var24.setConnectTimeout(5000);
         OutputStreamWriter var20 = new OutputStreamWriter(var24.getOutputStream());
         var20.write("data2=" + class37.method507(var12) + "&dest=" + class37.method507("passwordchoice.ws"));
         var20.flush();
         InputStream var21 = var24.getInputStream();
         var9 = new Buffer(new byte[1000]);

         do {
            var17 = var21.read(var9.payload, var9.offset, 1000 - var9.offset);
            if(var17 == -1) {
               var20.close();
               var21.close();
               String var22 = new String(var9.payload);
               if(var22.startsWith("OFFLINE")) {
                  return 4;
               } else if(var22.startsWith("WRONG")) {
                  return 7;
               } else if(var22.startsWith("RELOAD")) {
                  return 3;
               } else if(var22.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var9.decryptXtea(var6);

                  while(var9.offset > 0 && var9.payload[var9.offset - 1] == 0) {
                     --var9.offset;
                  }

                  var22 = new String(var9.payload, 0, var9.offset);
                  if(DState.method3562(var22)) {
                     TotalQuantityComparator.method98(var22, true, false);
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
}
