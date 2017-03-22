import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("c")
   int[] field133;
   @ObfuscatedName("x")
   Script field134;
   @ObfuscatedName("d")
   String[] field136;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1466123699
   )
   int field137 = -1;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "20"
   )
   public static boolean method169(int var0) {
      return (var0 >> 20 & 1) != 0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;I)I",
      garbageValue = "-142990282"
   )
   static final int method170(long var0, String var2) {
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

      var4.method2852(class36.field795, class36.field800);
      var5.putByte(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.putInt(var3.nextInt());
      }

      var5.putLong(var3.nextLong());
      var5.put48bitLong(var3.nextLong());
      if(Client.field349 != null) {
         var5.putBytes(Client.field349, 0, Client.field349.length);
      } else {
         byte[] var8 = new byte[24];

         try {
            class104.field1695.method1446(0L);
            class104.field1695.method1448(var8);

            int var9;
            for(var9 = 0; var9 < 24 && var8[var9] == 0; ++var9) {
               ;
            }

            if(var9 >= 24) {
               throw new IOException();
            }
         } catch (Exception var23) {
            for(int var10 = 0; var10 < 24; ++var10) {
               var8[var10] = -1;
            }
         }

         var5.putBytes(var8, 0, var8.length);
      }

      var5.putLong(var3.nextLong());
      var5.method2852(class36.field795, class36.field800);
      var7 = class164.method3157(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      Buffer var24 = new Buffer(var7);
      var24.method2822(var2);
      var24.offset = var7;
      var24.encryptXtea2(var6);
      Buffer var18 = new Buffer(var24.offset + var5.offset + 5 + var4.offset);
      var18.putByte(2);
      var18.putByte(var4.offset);
      var18.putBytes(var4.payload, 0, var4.offset);
      var18.putByte(var5.offset);
      var18.putBytes(var5.payload, 0, var5.offset);
      var18.putShort(var24.offset);
      var18.putBytes(var24.payload, 0, var24.offset);
      byte[] var11 = var18.payload;
      String var20 = class195.method3574(var11, 0, var11.length);
      String var12 = var20;

      try {
         URL var13 = new URL(GroundObject.method1596("services", false) + "m=accountappeal/login.ws");
         URLConnection var14 = var13.openConnection();
         var14.setDoInput(true);
         var14.setDoOutput(true);
         var14.setConnectTimeout(5000);
         OutputStreamWriter var15 = new OutputStreamWriter(var14.getOutputStream());
         var15.write("data2=" + class47.method962(var12) + "&dest=" + class47.method962("passwordchoice.ws"));
         var15.flush();
         InputStream var16 = var14.getInputStream();
         var18 = new Buffer(new byte[1000]);

         do {
            int var17 = var16.read(var18.payload, var18.offset, 1000 - var18.offset);
            if(var17 == -1) {
               var15.close();
               var16.close();
               String var21 = new String(var18.payload);
               if(var21.startsWith("OFFLINE")) {
                  return 4;
               } else if(var21.startsWith("WRONG")) {
                  return 7;
               } else if(var21.startsWith("RELOAD")) {
                  return 3;
               } else if(var21.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var18.decryptXtea(var6);

                  while(var18.offset > 0 && var18.payload[var18.offset - 1] == 0) {
                     --var18.offset;
                  }

                  var21 = new String(var18.payload, 0, var18.offset);
                  if(class25.method598(var21)) {
                     RSCanvas.method2137(var21, true, false);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var18.offset += var17;
         } while(var18.offset < 1000);

         return 5;
      } catch (Throwable var22) {
         var22.printStackTrace();
         return 5;
      }
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-171693379"
   )
   static void method171() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         if(World.method647(Client.menuTypes[var0])) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var1 = var0; var1 < Client.menuOptionCount - 1; ++var1) {
                  Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
                  Client.menuTargets[var1] = Client.menuTargets[1 + var1];
                  Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
                  Client.menuIdentifiers[var1] = Client.menuIdentifiers[1 + var1];
                  Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
                  Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(CII)Ljava/lang/String;",
      garbageValue = "220003284"
   )
   public static String method172(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }
}
