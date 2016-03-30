import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class0 extends class208 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1933628779
   )
   int field0;
   @ObfuscatedName("x")
   boolean field1;
   @ObfuscatedName("t")
   class173 field2;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1921972113
   )
   int field3;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -443081437
   )
   int field5;
   @ObfuscatedName("m")
   class173 field6;
   @ObfuscatedName("w")
   Object[] field7;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1242502131
   )
   int field8;
   @ObfuscatedName("l")
   String field9;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2115727135
   )
   int field10;
   @ObfuscatedName("iy")
   static class173 field12;
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      intValue = -1880456803
   )
   static int field13;
   @ObfuscatedName("hi")
   @ObfuscatedGetter(
      intValue = 335736755
   )
   static int field14;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1275363153
   )
   int field19;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;S)V",
      garbageValue = "17707"
   )
   public static void method0(String var0, Throwable var1) {
      try {
         String var2 = "";
         if(null != var1) {
            Throwable var4 = var1;
            String var5;
            if(var1 instanceof class148) {
               class148 var6 = (class148)var1;
               var5 = var6.field2244 + " | ";
               var4 = var6.field2245;
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
               int var13 = var11.indexOf(41, 1 + var12);
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
         if(null == class148.field2251) {
            return;
         }

         URL var3 = new URL(class148.field2251.getCodeBase(), "clienterror.ws?c=" + class148.field2243 + "&u=" + class148.field2242 + "&v1=" + class136.field2112 + "&v2=" + class34.field786 + "&e=" + var2);
         DataInputStream var17 = new DataInputStream(var3.openStream());
         var17.read();
         var17.close();
      } catch (Exception var16) {
         ;
      }

   }

   @ObfuscatedName("i")
   static final void method1() {
      class46.field1060.method3776();
      class74.method1599();
      class44.field1033.method3776();
      class127.method2825();
      class19.method229();
      class51.field1117.method3776();
      class51.field1118.method3776();
      class51.field1119.method3776();
      class42.field993.method3776();
      class42.field994.method3776();
      class43.field1014.method3776();
      class43.field1015.method3776();
      class191.method3763();
      class52.field1169.method3776();
      class170.method3402();
      class28.method662();
      ((class95)class91.field1591).method2166();
      class22.field607.method3776();
      class148.field2246.method3298();
      class114.field1988.method3298();
      class22.field608.method3298();
      class47.field1086.method3298();
      class18.field271.method3298();
      class19.field289.method3298();
      class8.field152.method3298();
      class35.field795.method3298();
      class8.field151.method3298();
      class4.field82.method3298();
      class39.field917.method3298();
      class9.field169.method3298();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1765207675"
   )
   static final void method2() {
      short var0 = 256;
      int var1;
      if(class31.field716 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class31.field716 > 768) {
               class229.field3232[var1] = class119.method2705(class96.field1645[var1], class122.field2025[var1], 1024 - class31.field716);
            } else if(class31.field716 > 256) {
               class229.field3232[var1] = class122.field2025[var1];
            } else {
               class229.field3232[var1] = class119.method2705(class122.field2025[var1], class96.field1645[var1], 256 - class31.field716);
            }
         }
      } else if(class31.field721 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class31.field721 > 768) {
               class229.field3232[var1] = class119.method2705(class96.field1645[var1], class106.field1883[var1], 1024 - class31.field721);
            } else if(class31.field721 > 256) {
               class229.field3232[var1] = class106.field1883[var1];
            } else {
               class229.field3232[var1] = class119.method2705(class106.field1883[var1], class96.field1645[var1], 256 - class31.field721);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class229.field3232[var1] = class96.field1645[var1];
         }
      }

      class79.method1773(class31.field720, 9, 128 + class31.field720, 7 + var0);
      class161.field2668.method1697(class31.field720, 0);
      class79.method1772();
      var1 = 0;
      int var2 = class31.field720 + class42.field991.field1396 * 9;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = (var0 - var3) * class31.field719[var3] / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class48.field1097[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class229.field3232[var7];
               var10 = class42.field991.field1395[var2];
               class42.field991.field1395[var2++] = (var8 * (var7 & '\uff00') + (var10 & '\uff00') * var9 & 16711680) + ((var10 & 16711935) * var9 + (var7 & 16711935) * var8 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + class42.field991.field1396 - 128;
      }

      class79.method1773(765 + class31.field720 - 128, 9, class31.field720 + 765, 7 + var0);
      class213.field3152.method1697(class31.field720 + 382, 0);
      class79.method1772();
      var1 = 0;
      var2 = class31.field720 + 637 + class42.field991.field1396 * 9 + 24;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class31.field719[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class48.field1097[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class229.field3232[var7];
               var10 = class42.field991.field1395[var2];
               class42.field991.field1395[var2++] = (var8 * (var7 & '\uff00') + var9 * (var10 & '\uff00') & 16711680) + ((var10 & 16711935) * var9 + (var7 & 16711935) * var8 & -16711936) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += class42.field991.field1396 - var5 - var4;
      }

   }
}
