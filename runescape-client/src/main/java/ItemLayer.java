import java.awt.Component;
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

@ObfuscatedName("dg")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("q")
   static int[] field1669;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1309619837
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 736594393
   )
   @Export("x")
   int x;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -350771215
   )
   @Export("y")
   int y;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lec;"
   )
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lec;"
   )
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lec;"
   )
   @Export("top")
   Renderable top;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1075045165
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -611675831
   )
   @Export("height")
   int height;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-295001093"
   )
   public static int method2563(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lik;S)V",
      garbageValue = "128"
   )
   public static void method2560(IndexDataBase var0) {
      class255.field3380 = var0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1647651513"
   )
   static void method2561(Component var0) {
      var0.removeMouseListener(MouseInput.mouse);
      var0.removeMouseMotionListener(MouseInput.mouse);
      var0.removeFocusListener(MouseInput.mouse);
      MouseInput.MouseHandler_currentButton = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;B)I",
      garbageValue = "15"
   )
   static final int method2562(long var0, String var2) {
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

      var4.encryptRsa(class84.field1262, class84.field1263);
      var5.putByte(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.putInt(var3.nextInt());
      }

      var5.putLong(var3.nextLong());
      var5.method3501(var3.nextLong());
      if(Client.field1015 != null) {
         var5.putBytes(Client.field1015, 0, Client.field1015.length);
      } else {
         byte[] var8 = new byte[24];

         try {
            class157.randomDat.seek(0L);
            class157.randomDat.read(var8);

            int var9;
            for(var9 = 0; var9 < 24 && var8[var9] == 0; ++var9) {
               ;
            }

            if(var9 >= 24) {
               throw new IOException();
            }
         } catch (Exception var24) {
            for(int var10 = 0; var10 < 24; ++var10) {
               var8[var10] = -1;
            }
         }

         var5.putBytes(var8, 0, var8.length);
      }

      var5.putLong(var3.nextLong());
      var5.encryptRsa(class84.field1262, class84.field1263);
      var7 = ContextMenuRow.getLength(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      Buffer var25 = new Buffer(var7);
      var25.putString(var2);
      var25.offset = var7;
      var25.encryptXtea2(var6);
      Buffer var18 = new Buffer(var25.offset + var4.offset + var5.offset + 5);
      var18.putByte(2);
      var18.putByte(var4.offset);
      var18.putBytes(var4.payload, 0, var4.offset);
      var18.putByte(var5.offset);
      var18.putBytes(var5.payload, 0, var5.offset);
      var18.putShort(var25.offset);
      var18.putBytes(var25.payload, 0, var25.offset);
      String var20 = ChatLineBuffer.method2017(var18.payload);

      try {
         URL var11 = new URL(ISAACCipher.method3697("services", false) + "m=accountappeal/login.ws");
         URLConnection var12 = var11.openConnection();
         var12.setDoInput(true);
         var12.setDoOutput(true);
         var12.setConnectTimeout(5000);
         OutputStreamWriter var13 = new OutputStreamWriter(var12.getOutputStream());
         var13.write("data2=" + class61.method1049(var20) + "&dest=" + class61.method1049("passwordchoice.ws"));
         var13.flush();
         InputStream var14 = var12.getInputStream();
         var18 = new Buffer(new byte[1000]);

         do {
            int var15 = var14.read(var18.payload, var18.offset, 1000 - var18.offset);
            if(var15 == -1) {
               var13.close();
               var14.close();
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
                  boolean var16;
                  if(var21 == null) {
                     var16 = false;
                  } else {
                     label104: {
                        try {
                           new URL(var21);
                        } catch (MalformedURLException var22) {
                           var16 = false;
                           break label104;
                        }

                        var16 = true;
                     }
                  }

                  if(var16) {
                     class18.method153(var21, true, "openjs", false);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var18.offset += var15;
         } while(var18.offset < 1000);

         return 5;
      } catch (Throwable var23) {
         var23.printStackTrace();
         return 5;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1831126724"
   )
   public static boolean method2565(int var0) {
      return (var0 >> 28 & 1) != 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgj;J)V"
   )
   static void method2564(Buffer var0, long var1) {
      var1 /= 10L;
      if(var1 < 0L) {
         var1 = 0L;
      } else if(var1 > 65535L) {
         var1 = 65535L;
      }

      var0.putShort((int)var1);
   }
}
