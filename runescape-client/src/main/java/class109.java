import java.awt.Canvas;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
public class class109 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1108965087
   )
   public static int field1948;
   @ObfuscatedName("v")
   public static int[][] field1949 = new int[128][128];
   @ObfuscatedName("r")
   public static int[][] field1950 = new int[128][128];
   @ObfuscatedName("i")
   public static int[] field1953 = new int[4096];
   @ObfuscatedName("g")
   public static int[] field1954 = new int[4096];
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = 1877541417
   )
   static int field1955;

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-123"
   )
   static void method2391() {
      Canvas var0 = class79.canvas;
      var0.removeKeyListener(class140.keyboard);
      var0.removeFocusListener(class140.keyboard);
      class140.field2193 = -1;
      class127.method2824(class79.canvas);
      if(null != KitDefinition.field1060) {
         KitDefinition.field1060.vmethod3142(class79.canvas);
      }

      Client.field277.method3069();
      class79.canvas.setBackground(Color.black);
      class34.method746(class79.canvas);
      Canvas var1 = class79.canvas;
      var1.addMouseListener(class143.mouse);
      var1.addMouseMotionListener(class143.mouse);
      var1.addFocusListener(class143.mouse);
      if(KitDefinition.field1060 != null) {
         KitDefinition.field1060.vmethod3136(class79.canvas);
      }

      if(Client.widgetRoot != -1) {
         class47.method989(Client.widgetRoot, class159.field2374, class92.field1643, false);
      }

      GameEngine.field2265 = true;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IZIZI)V",
      garbageValue = "966697131"
   )
   static void method2398(int var0, boolean var1, int var2, boolean var3) {
      if(World.worldList != null) {
         GameEngine.method3134(0, World.worldList.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;I)Ljava/lang/String;",
      garbageValue = "-1749849363"
   )
   static String method2400(Throwable var0) throws IOException {
      String var1;
      if(var0 instanceof class151) {
         class151 var2 = (class151)var0;
         var1 = var2.field2289 + " | ";
         var0 = var2.field2292;
      } else {
         var1 = "";
      }

      StringWriter var12 = new StringWriter();
      PrintWriter var3 = new PrintWriter(var12);
      var0.printStackTrace(var3);
      var3.close();
      String var4 = var12.toString();
      BufferedReader var5 = new BufferedReader(new StringReader(var4));
      String var6 = var5.readLine();

      while(true) {
         while(true) {
            String var7 = var5.readLine();
            if(null == var7) {
               var1 = var1 + "| " + var6;
               return var1;
            }

            int var8 = var7.indexOf(40);
            int var9 = var7.indexOf(41, var8 + 1);
            if(var8 >= 0 && var9 >= 0) {
               String var10 = var7.substring(var8 + 1, var9);
               int var11 = var10.indexOf(".java:");
               if(var11 >= 0) {
                  var10 = var10.substring(0, var11) + var10.substring(5 + var11);
                  var1 = var1 + var10 + ' ';
                  continue;
               }

               var7 = var7.substring(0, var8);
            }

            var7 = var7.trim();
            var7 = var7.substring(var7.lastIndexOf(32) + 1);
            var7 = var7.substring(var7.lastIndexOf(9) + 1);
            var1 = var1 + var7 + ' ';
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lclass49;",
      garbageValue = "-247813459"
   )
   public static class49 method2401(int var0) {
      class49 var1 = (class49)class49.field1099.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class49.field1098.method3309(33, var0);
         var1 = new class49();
         if(var2 != null) {
            var1.method1009(new Buffer(var2));
         }

         class49.field1099.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;B)I",
      garbageValue = "7"
   )
   static final int method2402(long var0, String var2) {
      Random var3 = new Random();
      Buffer var4 = new Buffer(128);
      Buffer var5 = new Buffer(128);
      int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
      var4.method2513(10);

      int var7;
      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2600(var3.nextInt());
      }

      var4.method2600(var6[0]);
      var4.method2600(var6[1]);
      var4.method2527(var0);
      var4.method2527(0L);

      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2600(var3.nextInt());
      }

      var4.method2612(class9.field154, class9.field145);
      var5.method2513(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.method2600(var3.nextInt());
      }

      var5.method2527(var3.nextLong());
      var5.method2517(var3.nextLong());
      byte[] var18 = new byte[24];

      try {
         class152.field2299.method4209(0L);
         class152.field2299.method4200(var18);

         int var8;
         for(var8 = 0; var8 < 24 && var18[var8] == 0; ++var8) {
            ;
         }

         if(var8 >= 24) {
            throw new IOException();
         }
      } catch (Exception var24) {
         for(int var9 = 0; var9 < 24; ++var9) {
            var18[var9] = -1;
         }
      }

      var5.method2667(var18, 0, 24);
      var5.method2527(var3.nextLong());
      var5.method2612(class9.field154, class9.field145);
      var7 = ChatMessages.method229(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      Buffer var19 = new Buffer(var7);
      var19.method2519(var2);
      var19.offset = var7;
      var19.method2545(var6);
      Buffer var20 = new Buffer(var4.offset + 5 + var5.offset + var19.offset);
      var20.method2513(2);
      var20.method2513(var4.offset);
      var20.method2667(var4.payload, 0, var4.offset);
      var20.method2513(var5.offset);
      var20.method2667(var5.payload, 0, var5.offset);
      var20.method2514(var19.offset);
      var20.method2667(var19.payload, 0, var19.offset);
      String var10 = class155.method3188(var20.payload);

      try {
         URL var11 = new URL(Friend.method189("services", false) + "m=accountappeal/login.ws");
         URLConnection var12 = var11.openConnection();
         var12.setDoInput(true);
         var12.setDoOutput(true);
         var12.setConnectTimeout(5000);
         OutputStreamWriter var13 = new OutputStreamWriter(var12.getOutputStream());
         var13.write("data2=" + class35.method749(var10) + "&dest=" + class35.method749("passwordchoice.ws"));
         var13.flush();
         InputStream var14 = var12.getInputStream();
         var20 = new Buffer(new byte[1000]);

         do {
            int var15 = var14.read(var20.payload, var20.offset, 1000 - var20.offset);
            if(var15 == -1) {
               var13.close();
               var14.close();
               String var21 = new String(var20.payload);
               if(var21.startsWith("OFFLINE")) {
                  return 4;
               } else if(var21.startsWith("WRONG")) {
                  return 7;
               } else if(var21.startsWith("RELOAD")) {
                  return 3;
               } else if(var21.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var20.method2516(var6);

                  while(var20.offset > 0 && var20.payload[var20.offset - 1] == 0) {
                     --var20.offset;
                  }

                  var21 = new String(var20.payload, 0, var20.offset);
                  boolean var16;
                  if(null == var21) {
                     var16 = false;
                  } else {
                     label99: {
                        try {
                           new URL(var21);
                        } catch (MalformedURLException var22) {
                           var16 = false;
                           break label99;
                        }

                        var16 = true;
                     }
                  }

                  if(var16) {
                     SecondaryBufferProvider.method1682(var21, true, false);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var20.offset += var15;
         } while(var20.offset < 1000);

         return 5;
      } catch (Throwable var23) {
         var23.printStackTrace();
         return 5;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-2054946277"
   )
   public static int method2403(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.field2071[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }
}
