package net.runelite.rs.client;
import java.applet.Applet;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import netscape.javascript.JSObject;

@ObfuscatedName("j")
public class class0 extends class207 {
   @ObfuscatedName("r")
   int field0;
   @ObfuscatedName("l")
   boolean field1;
   @ObfuscatedName("a")
   class172 field2;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1932562255
   )
   int field3;
   @ObfuscatedName("cb")
   static class223 field4;
   @ObfuscatedName("j")
   Object[] field5;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1542973383
   )
   int field6;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1907899959
   )
   int field7;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1332473207
   )
   int field8;
   @ObfuscatedName("k")
   String field9;
   @ObfuscatedName("eh")
   static class78 field10;
   @ObfuscatedName("o")
   class172 field11;
   @ObfuscatedName("bd")
   static class167 field13;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 655214789
   )
   int field14;

   @ObfuscatedName("j")
   static long method0() {
      try {
         URL var0 = new URL(class135.method2838("services", false) + "m=accountappeal/login.ws");
         URLConnection var1 = var0.openConnection();
         var1.setRequestProperty("connection", "close");
         var1.setDoInput(true);
         var1.setDoOutput(true);
         var1.setConnectTimeout(5000);
         OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
         var2.write("data1=req");
         var2.flush();
         InputStream var3 = var1.getInputStream();
         class118 var4 = new class118(new byte[1000]);

         do {
            int var5 = var3.read(var4.field1995, var4.field1998, 1000 - var4.field1998);
            if(var5 == -1) {
               var4.field1998 = 0;
               long var7 = var4.method2632();
               return var7;
            }

            var4.field1998 += var5;
         } while(var4.field1998 < 1000);

         return 0L;
      } catch (Exception var6) {
         return 0L;
      }
   }

   @ObfuscatedName("i")
   public static class226 method1(String var0, String var1, boolean var2) {
      File var3 = new File(class148.field2236, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            class226 var10 = new class226(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(33 == class13.field200) {
         var4 = "_rc";
      } else if(class13.field200 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class26.field663, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      class226 var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new class226(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new class226(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("i")
   static boolean method2(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class137.field2147.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var12 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var13 = 0; var13 < var0.length(); ++var13) {
                  if(var12.indexOf(var0.charAt(var13)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var7) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Applet var4 = class137.field2143;
            Object[] var5 = new Object[]{(new URL(class137.field2143.getCodeBase(), var0)).toString()};
            Object var3 = JSObject.getWindow(var4).call(var2, var5);
            return var3 != null;
         } catch (Throwable var8) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class137.field2143.getAppletContext().showDocument(new URL(class137.field2143.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var9) {
            return false;
         }
      } else if(3 == var1) {
         try {
            class131.method2776(class137.field2143, "loggedout");
         } catch (Throwable var11) {
            ;
         }

         try {
            class137.field2143.getAppletContext().showDocument(new URL(class137.field2143.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("q")
   public static int method3(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }

   @ObfuscatedName("f")
   static void method4(class121 var0, int var1) {
      boolean var2 = var0.method2689(1) == 1;
      if(var2) {
         class32.field748[++class32.field756 - 1] = var1;
      }

      int var3 = var0.method2689(2);
      class2 var4 = client.field410[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field49 = false;
         } else if(var1 == client.field477) {
            throw new RuntimeException();
         } else {
            class32.field752[var1] = (class92.field1598 + var4.field817[0] >> 6) + (var4.field55 << 28) + (var4.field864[0] + class98.field1683 >> 6 << 14);
            if(-1 != var4.field853) {
               class32.field754[var1] = var4.field853;
            } else {
               class32.field754[var1] = var4.field860;
            }

            class32.field753[var1] = var4.field835;
            client.field410[var1] = null;
            if(var0.method2689(1) != 0) {
               class33.method722(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method2689(3);
            var6 = var4.field864[0];
            var7 = var4.field817[0];
            if(0 == var5) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(3 == var5) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(5 == var5) {
               --var6;
               ++var7;
            } else if(6 == var5) {
               ++var7;
            } else if(7 == var5) {
               ++var6;
               ++var7;
            }

            if(client.field477 != var1 || var4.field839 >= 1536 && var4.field848 >= 1536 && var4.field839 < 11776 && var4.field848 < 11776) {
               if(var2) {
                  var4.field49 = true;
                  var4.field57 = var6;
                  var4.field35 = var7;
               } else {
                  var4.field49 = false;
                  var4.method26(var6, var7, class32.field747[var1]);
               }
            } else {
               var4.method12(var6, var7);
               var4.field49 = false;
            }

         } else if(2 == var3) {
            var5 = var0.method2689(4);
            var6 = var4.field864[0];
            var7 = var4.field817[0];
            if(0 == var5) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(2 == var5) {
               var7 -= 2;
            } else if(3 == var5) {
               ++var6;
               var7 -= 2;
            } else if(4 == var5) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(8 == var5) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(13 == var5) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(15 == var5) {
               var6 += 2;
               var7 += 2;
            }

            if(var1 == client.field477 && (var4.field839 < 1536 || var4.field848 < 1536 || var4.field839 >= 11776 || var4.field848 >= 11776)) {
               var4.method12(var6, var7);
               var4.field49 = false;
            } else if(var2) {
               var4.field49 = true;
               var4.field57 = var6;
               var4.field35 = var7;
            } else {
               var4.field49 = false;
               var4.method26(var6, var7, class32.field747[var1]);
            }

         } else {
            var5 = var0.method2689(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(0 == var5) {
               var6 = var0.method2689(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var4.field864[0] + var8;
               var11 = var4.field817[0] + var9;
               if(client.field477 == var1 && (var4.field839 < 1536 || var4.field848 < 1536 || var4.field839 >= 11776 || var4.field848 >= 11776)) {
                  var4.method12(var10, var11);
                  var4.field49 = false;
               } else if(var2) {
                  var4.field49 = true;
                  var4.field57 = var10;
                  var4.field35 = var11;
               } else {
                  var4.field49 = false;
                  var4.method26(var10, var11, class32.field747[var1]);
               }

               var4.field55 = (byte)(var7 + var4.field55 & 3);
               if(var1 == client.field477) {
                  class75.field1386 = var4.field55;
               }

            } else {
               var6 = var0.method2689(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (class98.field1683 + var4.field864[0] + var8 & 16383) - class98.field1683;
               var11 = (var9 + var4.field817[0] + class92.field1598 & 16383) - class92.field1598;
               if(var1 != client.field477 || var4.field839 >= 1536 && var4.field848 >= 1536 && var4.field839 < 11776 && var4.field848 < 11776) {
                  if(var2) {
                     var4.field49 = true;
                     var4.field57 = var10;
                     var4.field35 = var11;
                  } else {
                     var4.field49 = false;
                     var4.method26(var10, var11, class32.field747[var1]);
                  }
               } else {
                  var4.method12(var10, var11);
                  var4.field49 = false;
               }

               var4.field55 = (byte)(var7 + var4.field55 & 3);
               if(var1 == client.field477) {
                  class75.field1386 = var4.field55;
               }

            }
         }
      }
   }
}
