import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
public class class144 extends class136 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2063682343
   )
   int field2202 = 256;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 301000705
   )
   int field2203 = 1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1542200453
   )
   int field2204;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -200608987
   )
   int field2205 = 0;
   @ObfuscatedName("iu")
   @ObfuscatedGetter(
      intValue = 2120520955
   )
   static int field2208;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 8543358296248338347L
   )
   long field2209 = class113.method2394();
   @ObfuscatedName("s")
   long[] field2211 = new long[10];

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "179567807"
   )
   int vmethod3114(int var1, int var2) {
      int var3 = this.field2202;
      int var4 = this.field2203;
      this.field2202 = 300;
      this.field2203 = 1;
      this.field2209 = class113.method2394();
      if(0L == this.field2211[this.field2204]) {
         this.field2202 = var3;
         this.field2203 = var4;
      } else if(this.field2209 > this.field2211[this.field2204]) {
         this.field2202 = (int)((long)(var1 * 2560) / (this.field2209 - this.field2211[this.field2204]));
      }

      if(this.field2202 < 25) {
         this.field2202 = 25;
      }

      if(this.field2202 > 256) {
         this.field2202 = 256;
         this.field2203 = (int)((long)var1 - (this.field2209 - this.field2211[this.field2204]) / 10L);
      }

      if(this.field2203 > var1) {
         this.field2203 = var1;
      }

      this.field2211[this.field2204] = this.field2209;
      this.field2204 = (1 + this.field2204) % 10;
      int var5;
      if(this.field2203 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(this.field2211[var5] != 0L) {
               this.field2211[var5] += (long)this.field2203;
            }
         }
      }

      if(this.field2203 < var2) {
         this.field2203 = var2;
      }

      class16.method185((long)this.field2203);

      for(var5 = 0; this.field2205 < 256; this.field2205 += this.field2202) {
         ++var5;
      }

      this.field2205 &= 255;
      return var5;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "-839778340"
   )
   public static void method2970(String var0, Throwable var1) {
      try {
         String var2 = "";
         if(var1 != null) {
            Throwable var4 = var1;
            String var5;
            if(var1 instanceof class151) {
               class151 var6 = (class151)var1;
               var5 = var6.field2265 + " | ";
               var4 = var6.field2268;
            } else {
               var5 = "";
            }

            StringWriter var18 = new StringWriter();
            PrintWriter var7 = new PrintWriter(var18);
            var4.printStackTrace(var7);
            var7.close();
            String var8 = var18.toString();
            BufferedReader var9 = new BufferedReader(new StringReader(var8));
            String var10 = var9.readLine();

            while(true) {
               String var11 = var9.readLine();
               if(null == var11) {
                  var5 = var5 + "| " + var10;
                  var2 = var5;
                  break;
               }

               int var12 = var11.indexOf(40);
               int var13 = var11.indexOf(41, var12 + 1);
               if(var12 >= 0 && var13 >= 0) {
                  String var14 = var11.substring(1 + var12, var13);
                  int var15 = var14.indexOf(".java:");
                  if(var15 >= 0) {
                     var14 = var14.substring(0, var15) + var14.substring(var15 + 5);
                     var5 = var5 + var14 + ' ';
                     continue;
                  }

                  var11 = var11.substring(0, var12);
               }

               var11 = var11.trim();
               var11 = var11.substring(var11.lastIndexOf(32) + 1);
               var11 = var11.substring(var11.lastIndexOf(9) + 1);
               var5 = var5 + var11 + ' ';
            }
         }

         if(null != var0) {
            if(var1 != null) {
               var2 = var2 + " | ";
            }

            var2 = var2 + var0;
         }

         System.out.println("Error: " + var2);
         var2 = var2.replace(':', '.');
         var2 = var2.replace('@', '_');
         var2 = var2.replace('&', '_');
         var2 = var2.replace('#', '_');
         if(null == class151.field2266) {
            return;
         }

         URL var3 = new URL(class151.field2266.getCodeBase(), "clienterror.ws?c=" + class114.field1985 + "&u=" + class151.field2264 + "&v1=" + class139.field2137 + "&v2=" + class139.field2136 + "&e=" + var2);
         DataInputStream var17 = new DataInputStream(var3.openStream());
         var17.read();
         var17.close();
      } catch (Exception var16) {
         ;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIZIZB)V",
      garbageValue = "0"
   )
   static void method2971(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var1 + var0) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(class137.method2860(World.worldList[var9], var8, var2, var3, var4, var5) <= 0) {
               World var10 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var10;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method2971(var0, var7 - 1, var2, var3, var4, var5);
         method2971(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1749545983"
   )
   public void vmethod3110() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2211[var1] = 0L;
      }

   }

   class144() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field2211[var1] = this.field2209;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "55372221"
   )
   static final int method2979(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
