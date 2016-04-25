import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class10 extends class107 {
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = 876635683
   )
   static int field160;
   @ObfuscatedName("bd")
   static class80 field162;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1026743465
   )
   public static int field166;
   @ObfuscatedName("ib")
   @ObfuscatedGetter(
      intValue = -237914187
   )
   static int field167;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "1023669998"
   )
   static final byte[] method133(byte[] var0) {
      class119 var1 = new class119(var0);
      int var2 = var1.method2500();
      int var3 = var1.method2505();
      if(var3 >= 0 && (0 == class167.field2661 || var3 <= class167.field2661)) {
         if(var2 == 0) {
            byte[] var6 = new byte[var3];
            var1.method2511(var6, 0, var3);
            return var6;
         } else {
            int var4 = var1.method2505();
            if(var4 >= 0 && (0 == class167.field2661 || var4 <= class167.field2661)) {
               byte[] var5 = new byte[var4];
               if(1 == var2) {
                  class117.method2450(var5, var4, var0, var3, 9);
               } else {
                  class167.field2664.method2444(var1, var5);
               }

               return var5;
            } else {
               throw new RuntimeException();
            }
         }
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)Z",
      garbageValue = "1"
   )
   static boolean method134(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(45 == var8) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  return false;
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               return false;
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var1 * var5 + var10;
            if(var5 != var9 / var1) {
               return false;
            }

            var5 = var9;
            var4 = true;
         }

         return var4;
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-604817996"
   )
   static final String method135(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class219.method3968('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class219.method3968(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class219.method3968(16776960) + var1 + "</col>");
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1196323969"
   )
   static final int method136(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return (var2 * (var1 & 16711935) + (var0 & 16711935) * var3 & -16711936) + (var3 * (var0 & '\uff00') + var2 * (var1 & '\uff00') & 16711680) >> 8;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIILclass108;I)Z",
      garbageValue = "85503227"
   )
   protected boolean vmethod2375(int var1, int var2, int var3, class108 var4) {
      return super.field1861 == var2 && super.field1859 == var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;B)Ljava/lang/String;",
      garbageValue = "-65"
   )
   static String method139(Throwable var0) throws IOException {
      String var1;
      if(var0 instanceof class148) {
         class148 var2 = (class148)var0;
         var1 = var2.field2204 + " | ";
         var0 = var2.field2206;
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
}
