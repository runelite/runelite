import java.applet.Applet;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("di")
public class class118 {
   @ObfuscatedName("br")
   static ModIcon[] field1840;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1940280513
   )
   public static int field1842;
   @ObfuscatedName("q")
   public static int[][] field1843;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -720767597
   )
   public static int field1844;
   @ObfuscatedName("n")
   public static int[][] field1845;
   @ObfuscatedName("z")
   public static int[] field1846;
   @ObfuscatedName("l")
   public static int[] field1847;
   @ObfuscatedName("nk")
   static class65 field1848;
   @ObfuscatedName("di")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("po")
   @ObfuscatedGetter(
      intValue = -194491501
   )
   static int field1853;

   class118() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "(LWidget;IIIIIII)V",
      garbageValue = "808217686"
   )
   static final void method2283(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.field282) {
         Client.field365 = 32;
      } else {
         Client.field365 = 0;
      }

      Client.field282 = false;
      int var7;
      if(class115.field1799 == 1 || !CombatInfo1.field662 && class115.field1799 == 4) {
         if(var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
            var0.scrollY -= 4;
            class124.method2350(var0);
         } else if(var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var2 + var3) {
            var0.scrollY += 4;
            class124.method2350(var0);
         } else if(var5 >= var1 - Client.field365 && var5 < var1 + 16 + Client.field365 && var6 >= var2 + 16 && var6 < var2 + var3 - 16) {
            var7 = (var3 - 32) * var3 / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = (var4 - var3) * var8 / var9;
            class124.method2350(var0);
            Client.field282 = true;
         }
      }

      if(Client.field483 != 0) {
         var7 = var0.width;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var2 + var3) {
            var0.scrollY += Client.field483 * 45;
            class124.method2350(var0);
         }
      }

   }

   static {
      field1845 = new int[128][128];
      field1843 = new int[128][128];
      field1846 = new int[4096];
      field1847 = new int[4096];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "39"
   )
   static long method2289() {
      try {
         URL var0 = new URL(Friend.method184("services", false) + "m=accountappeal/login.ws");
         URLConnection var1 = var0.openConnection();
         var1.setRequestProperty("connection", "close");
         var1.setDoInput(true);
         var1.setDoOutput(true);
         var1.setConnectTimeout(5000);
         OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
         var2.write("data1=req");
         var2.flush();
         InputStream var3 = var1.getInputStream();
         Buffer var4 = new Buffer(new byte[1000]);

         do {
            int var5 = var3.read(var4.payload, var4.offset, 1000 - var4.offset);
            if(var5 == -1) {
               var4.offset = 0;
               long var7 = var4.readLong();
               return var7;
            }

            var4.offset += var5;
         } while(var4.offset < 1000);

         return 0L;
      } catch (Exception var9) {
         return 0L;
      }
   }

   @ObfuscatedName("em")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1798412927"
   )
   static final void method2290(String var0) {
      if(var0 != null) {
         String var1 = class108.method2059(var0, NPC.field757);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
               Ignore var3 = Client.ignores[var2];
               String var4 = var3.name;
               String var5 = class108.method2059(var4, NPC.field757);
               if(TextureProvider.method1474(var0, var1, var4, var5)) {
                  --Client.ignoreCount;

                  for(int var6 = var2; var6 < Client.ignoreCount; ++var6) {
                     Client.ignores[var6] = Client.ignores[var6 + 1];
                  }

                  Client.field478 = Client.field311;
                  Client.secretPacketBuffer1.putOpcode(11);
                  Client.secretPacketBuffer1.putByte(class36.method753(var0));
                  Client.secretPacketBuffer1.method2504(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;B)Z",
      garbageValue = "11"
   )
   static boolean method2291(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class114.field1788.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var13 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var13.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var8) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Applet var7 = class114.field1793;
            Object[] var5 = new Object[]{(new URL(class114.field1793.getCodeBase(), var0)).toString()};
            Object var3 = JSObject.getWindow(var7).call(var2, var5);
            return var3 != null;
         } catch (Throwable var9) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class114.field1793.getAppletContext().showDocument(new URL(class114.field1793.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class100.method1950(class114.field1793, "loggedout");
         } catch (Throwable var12) {
            ;
         }

         try {
            class114.field1793.getAppletContext().showDocument(new URL(class114.field1793.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var11) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIIB)V",
      garbageValue = "77"
   )
   public static void method2292(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var2 + var3) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method2292(var0, var1, var2, var5 - 1);
         method2292(var0, var1, var5 + 1, var3);
      }

   }
}
