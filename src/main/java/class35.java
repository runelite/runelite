import java.applet.Applet;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("ae")
@Implements("MessageNode")
public class class35 extends class204 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1884618565
   )
   int field789;
   @ObfuscatedName("gt")
   static class173 field790;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1554208499
   )
   @Export("type")
   int field791;
   @ObfuscatedName("y")
   @Export("value")
   String field792;
   @ObfuscatedName("e")
   @Export("sender")
   String field793;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -579076469
   )
   int field794 = class25.method623();
   @ObfuscatedName("bg")
   static class168 field795;
   @ObfuscatedName("p")
   String field796;

   @ObfuscatedName("w")
   public static boolean method749(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class138.field2151.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var11 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var11.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var5) {
            return false;
         }
      } else if(1 == var1) {
         try {
            Object var10 = class132.method2849(class138.field2148, var2, new Object[]{(new URL(class138.field2148.getCodeBase(), var0)).toString()});
            return var10 != null;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class138.field2148.getAppletContext().showDocument(new URL(class138.field2148.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(3 == var1) {
         try {
            Applet var3 = class138.field2148;
            JSObject.getWindow(var3).call("loggedout", (Object[])null);
         } catch (Throwable var9) {
            ;
         }

         try {
            class138.field2148.getAppletContext().showDocument(new URL(class138.field2148.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("w")
   void method750(int var1, String var2, String var3, String var4) {
      int var5 = ++class11.field192 - 1;
      this.field794 = var5;
      this.field789 = client.field305;
      this.field791 = var1;
      this.field796 = var2;
      this.field793 = var3;
      this.field792 = var4;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "-37"
   )
   static final void method753(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class3.field75.method1927(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class3.field75.method1938(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class7.field143.field1406;
         var11 = 4 * var1 + 24624 + 2048 * (103 - var2);
         var12 = var5 >> 14 & 32767;
         class40 var13 = class22.method592(var12);
         if(-1 != var13.field955) {
            class80 var14 = class93.field1610[var13.field955];
            if(var14 != null) {
               int var15 = (var13.field979 * 4 - var14.field1425) / 2;
               int var16 = (var13.field942 * 4 - var14.field1423) / 2;
               var14.method1855(var15 + 4 * var1 + 48, var16 + 48 + 4 * (104 - var2 - var13.field942));
            }
         } else {
            if(var8 == 0 || 2 == var8) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[1024 + var11] = var9;
                  var10[var11 + 1536] = var9;
               } else if(1 == var7) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[3 + var11] = var9;
                  var10[3 + var11 + 512] = var9;
                  var10[3 + var11 + 1024] = var9;
                  var10[1536 + 3 + var11] = var9;
               } else if(var7 == 3) {
                  var10[1536 + var11] = var9;
                  var10[1 + var11 + 1536] = var9;
                  var10[2 + 1536 + var11] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(1 == var7) {
                  var10[3 + var11] = var9;
               } else if(2 == var7) {
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(2 == var8) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[512 + var11] = var9;
                  var10[var11 + 1024] = var9;
                  var10[1536 + var11] = var9;
               } else if(0 == var7) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[3 + var11] = var9;
               } else if(1 == var7) {
                  var10[var11 + 3] = var9;
                  var10[512 + var11 + 3] = var9;
                  var10[1024 + var11 + 3] = var9;
                  var10[1536 + var11 + 3] = var9;
               } else if(2 == var7) {
                  var10[var11 + 1536] = var9;
                  var10[1 + 1536 + var11] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class3.field75.method1936(var0, var1, var2);
      if(var5 != 0) {
         var6 = class3.field75.method1938(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         class40 var19 = class22.method592(var9);
         int var23;
         if(-1 != var19.field955) {
            class80 var21 = class93.field1610[var19.field955];
            if(null != var21) {
               var12 = (var19.field979 * 4 - var21.field1425) / 2;
               var23 = (var19.field942 * 4 - var21.field1423) / 2;
               var21.method1855(var12 + 4 * var1 + 48, 48 + (104 - var2 - var19.field942) * 4 + var23);
            }
         } else if(9 == var8) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = class7.field143.field1406;
            var23 = (103 - var2) * 2048 + 4 * var1 + 24624;
            if(0 != var7 && 2 != var7) {
               var22[var23] = var11;
               var22[1 + var23 + 512] = var11;
               var22[2 + 1024 + var23] = var11;
               var22[var23 + 1536 + 3] = var11;
            } else {
               var22[var23 + 1536] = var11;
               var22[1 + 1024 + var23] = var11;
               var22[2 + 512 + var23] = var11;
               var22[var23 + 3] = var11;
            }
         }
      }

      var5 = class3.field75.method1978(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         class40 var17 = class22.method592(var6);
         if(-1 != var17.field955) {
            class80 var18 = class93.field1610[var17.field955];
            if(null != var18) {
               var9 = (var17.field979 * 4 - var18.field1425) / 2;
               int var20 = (var17.field942 * 4 - var18.field1423) / 2;
               var18.method1855(var9 + var1 * 4 + 48, var20 + 48 + (104 - var2 - var17.field942) * 4);
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass122;ILclass2;II)V",
      garbageValue = "-479540409"
   )
   static final void method754(class122 var0, int var1, class2 var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 32) != 0) {
         var5 = var0.method2506();
         byte[] var6 = new byte[var5];
         class119 var7 = new class119(var6);
         var0.method2531(var6, 0, var5);
         class32.field749[var1] = var7;
         var2.method22(var7);
      }

      if((var3 & 1) != 0) {
         var2.field59 = var0.method2683();
         class32.field750[var1] = var2.field59;
      }

      int var13;
      if((var3 & 64) != 0) {
         var5 = var0.method2508();
         if('\uffff' == var5) {
            var5 = -1;
         }

         var13 = var0.method2506();
         class17.method186(var2, var5, var13);
      }

      if(0 != (var3 & 8)) {
         var2.field851 = var0.method2508();
         if(var2.field851 == '\uffff') {
            var2.field851 = -1;
         }
      }

      if((var3 & 128) != 0) {
         var2.field831 = var0.method2683();
         if(var2.field831.charAt(0) == 126) {
            var2.field831 = var2.field831.substring(1);
            class103.method2289(2, var2.field59, var2.field831);
         } else if(class167.field2692 == var2) {
            class103.method2289(2, var2.field59, var2.field831);
         }

         var2.field832 = false;
         var2.field835 = 0;
         var2.field871 = 0;
         var2.field834 = 150;
      }

      if((var3 & 16) != 0) {
         var5 = var0.method2508();
         var13 = var0.method2506();
         var2.method770(var5, var13, client.field305);
         var2.field840 = client.field305 + 300;
         var2.field841 = var0.method2506();
         var2.field848 = var0.method2506();
      }

      if(0 != (var3 & 4)) {
         var2.field876 = var0.method2508();
         if(var2.field818 == 0) {
            var2.field847 = var2.field876;
            var2.field876 = -1;
         }
      }

      if((var3 & 2048) != 0) {
         var5 = var0.method2508();
         class152 var14 = (class152)class23.method606(class96.method2188(), var0.method2506());
         boolean var15 = var0.method2506() == 1;
         int var8 = var0.method2506();
         int var9 = var0.field2011;
         if(var2.field59 != null && null != var2.field47) {
            boolean var10 = false;
            if(var14.field2292 && class45.method991(var2.field59)) {
               var10 = true;
            }

            if(!var10 && 0 == client.field414 && !var2.field43) {
               class32.field760.field2011 = 0;
               var0.method2531(class32.field760.field2012, 0, var8);
               class32.field760.field2011 = 0;
               String var11 = class223.method4103(class75.method1600(class106.method2377(class32.field760)));
               var2.field831 = var11.trim();
               var2.field835 = var5 >> 8;
               var2.field871 = var5 & 255;
               var2.field834 = 150;
               var2.field832 = var15;
               var2.field833 = var2 != class167.field2692 && var14.field2292 && "" != client.field514 && var11.toLowerCase().indexOf(client.field514) == -1;
               int var12;
               if(var14.field2291) {
                  var12 = var15?91:1;
               } else {
                  var12 = var15?90:2;
               }

               if(-1 != var14.field2284) {
                  class103.method2289(var12, class134.method2878(var14.field2284) + var2.field59, var11);
               } else {
                  class103.method2289(var12, var2.field59, var11);
               }
            }
         }

         var0.field2011 = var9 + var8;
      }

      if(0 != (var3 & 256)) {
         var2.field854 = var0.method2508();
         var5 = var0.method2511();
         var2.field858 = var5 >> 16;
         var2.field857 = client.field305 + (var5 & '\uffff');
         var2.field869 = 0;
         var2.field856 = 0;
         if(var2.field857 > client.field305) {
            var2.field869 = -1;
         }

         if('\uffff' == var2.field854) {
            var2.field854 = -1;
         }
      }

      if((var3 & 4096) != 0) {
         var2.field859 = var0.method2524();
         var2.field830 = var0.method2524();
         var2.field860 = var0.method2524();
         var2.field862 = var0.method2524();
         var2.field863 = var0.method2508() + client.field305;
         var2.field855 = var0.method2508() + client.field305;
         var2.field836 = var0.method2508();
         if(var2.field61) {
            var2.field859 += var2.field58;
            var2.field830 += var2.field63;
            var2.field860 += var2.field58;
            var2.field862 += var2.field63;
            var2.field818 = 0;
         } else {
            var2.field859 += var2.field872[0];
            var2.field830 += var2.field873[0];
            var2.field860 += var2.field872[0];
            var2.field862 += var2.field873[0];
            var2.field818 = 1;
         }

         var2.field875 = 0;
      }

      if((var3 & 8192) != 0) {
         var5 = var0.method2508();
         var13 = var0.method2506();
         var2.method770(var5, var13, client.field305);
         var2.field840 = client.field305 + 300;
         var2.field841 = var0.method2506();
         var2.field848 = var0.method2506();
      }

      if((var3 & 1024) != 0) {
         class32.field754[var1] = var0.method2524();
      }

      if((var3 & 512) != 0) {
         var4 = var0.method2524();
      }

      if(0 != (var3 & 16384)) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.field42[var5] = var0.method2683();
         }
      }

      if(var2.field61) {
         if(127 == var4) {
            var2.method17(var2.field58, var2.field63);
         } else {
            byte var16;
            if(var4 != -1) {
               var16 = var4;
            } else {
               var16 = class32.field754[var1];
            }

            var2.method16(var2.field58, var2.field63, var16);
         }
      }

   }

   class35(int var1, String var2, String var3, String var4) {
      this.field789 = client.field305;
      this.field791 = var1;
      this.field796 = var2;
      this.field793 = var3;
      this.field792 = var4;
   }

   @ObfuscatedName("w")
   static long method756() {
      try {
         URL var0 = new URL(class36.method763("services", false) + "m=accountappeal/login.ws");
         URLConnection var1 = var0.openConnection();
         var1.setRequestProperty("connection", "close");
         var1.setDoInput(true);
         var1.setDoOutput(true);
         var1.setConnectTimeout(5000);
         OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
         var2.write("data1=req");
         var2.flush();
         InputStream var3 = var1.getInputStream();
         class119 var4 = new class119(new byte[1000]);

         do {
            int var5 = var3.read(var4.field2012, var4.field2011, 1000 - var4.field2011);
            if(-1 == var5) {
               var4.field2011 = 0;
               long var8 = var4.method2512();
               return var8;
            }

            var4.field2011 += var5;
         } while(var4.field2011 < 1000);

         return 0L;
      } catch (Exception var7) {
         return 0L;
      }
   }
}
