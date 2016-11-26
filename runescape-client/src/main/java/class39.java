import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigInteger;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class39 {
   @ObfuscatedName("n")
   static final BigInteger field801 = new BigInteger("10001", 16);
   @ObfuscatedName("iw")
   static Widget field802;
   @ObfuscatedName("d")
   static final BigInteger field803 = new BigInteger("8a3893476f5083243fc90a6b9de6b3d3f9708fca2cd791329d6dd76f9f3b9cfeeb9925ab3cc383dd074b0af98ce0f4c1d939e1d678d1814a41c8f5539b6d6312eab5dc2aecb74214c806d0ffe18ac2ac71994b46ba668926df3a2babc02aaacf78b166cc23a82a319280a0f91a390285d12dba6b795c263f8ce19552e4d7821f", 16);

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "2073007622"
   )
   public static int method771(CharSequence var0) {
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "-1263810495"
   )
   @Export("reportException")
   public static void reportException(String var0, Throwable var1) {
      try {
         String var2 = "";
         if(null != var1) {
            Throwable var4 = var1;
            String var5;
            if(var1 instanceof class101) {
               class101 var6 = (class101)var1;
               var5 = var6.field1646 + " | ";
               var4 = var6.field1647;
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
                     var14 = var14.substring(0, var15) + var14.substring(5 + var15);
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

         if(var0 != null) {
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
         if(null == class101.field1643) {
            return;
         }

         URL var3 = new URL(class101.field1643.getCodeBase(), "clienterror.ws?c=" + class101.field1650 + "&u=" + class101.field1644 + "&v1=" + class103.field1672 + "&v2=" + class103.field1667 + "&e=" + var2);
         DataInputStream var17 = new DataInputStream(var3.openStream());
         var17.read();
         var17.close();
      } catch (Exception var16) {
         ;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILclass182;Ljava/lang/String;Ljava/lang/String;IZB)V",
      garbageValue = "1"
   )
   public static void method773(int var0, class182 var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.method3350(var2);
      int var7 = var1.method3345(var6, var3);
      class138.field1917 = 1;
      class1.field12 = var1;
      class138.field1918 = var6;
      Frames.field1566 = var7;
      class101.field1649 = var4;
      class34.field742 = var5;
      class114.field1792 = var0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-57"
   )
   public static void method774() {
      class190.field2796.reset();
      class190.field2797.reset();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1518372162"
   )
   public static void method775() {
      class227.field3232 = new class126();
   }
}
