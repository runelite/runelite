package net.runelite.rs.client;

import java.awt.Canvas;
import java.awt.Container;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dy")
public class class125 {
   @ObfuscatedName("pg")
   static class159 field2029;

   @ObfuscatedName("ai")
   static void method2846() {
      client var0 = client.field274;
      synchronized(client.field274) {
         Container var1 = client.field274.method3059();
         if(var1 != null) {
            class18.field252 = Math.max(var1.getSize().width, class8.field143);
            class22.field585 = Math.max(var1.getSize().height, class107.field1885);
            if(class39.field902 == var1) {
               Insets var2 = class39.field902.getInsets();
               class18.field252 -= var2.right + var2.left;
               class22.field585 -= var2.top + var2.bottom;
            }

            if(class18.field252 <= 0) {
               class18.field252 = 1;
            }

            if(class22.field585 <= 0) {
               class22.field585 = 1;
            }

            if(class27.method688() == 1) {
               class129.field2048 = client.field511 * 765;
               class136.field2101 = client.field490 * 503;
            } else {
               class129.field2048 = Math.min(class18.field252, 7680);
               class136.field2101 = Math.min(class22.field585, 2160);
            }

            class143.field2188 = (class18.field252 - class129.field2048) / 2;
            class143.field2185 = 0;
            class17.field244.setSize(class129.field2048, class136.field2101);
            int var3 = class129.field2048;
            int var4 = class136.field2101;
            Canvas var5 = class17.field244;

            Object var11;
            try {
               class81 var6 = new class81();
               var6.vmethod1896(var3, var4, var5);
               var11 = var6;
            } catch (Throwable var9) {
               class75 var7 = new class75();
               var7.vmethod1896(var3, var4, var5);
               var11 = var7;
            }

            class84.field1440 = (class77)var11;
            if(var1 == class39.field902) {
               Insets var12 = class39.field902.getInsets();
               class17.field244.setLocation(var12.left + class143.field2188, class143.field2185 + var12.top);
            } else {
               class17.field244.setLocation(class143.field2188, class143.field2185);
            }

            class0.method2();
            if(client.field438 != -1) {
               class24.method639(true);
            }

            class17.method213();
         }
      }
   }

   @ObfuscatedName("l")
   static void method2852() {
      class226 var0 = null;

      try {
         var0 = class75.method1666("", class168.field2687.field2275, true);
         class118 var1 = class153.field2277.method137();
         var0.method4185(var1.field1980, 0, var1.field1981);
      } catch (Exception var3) {
         ;
      }

      try {
         if(null != var0) {
            var0.method4183();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("f")
   static String method2853(Throwable var0) throws IOException {
      String var1;
      if(var0 instanceof class147) {
         class147 var2 = (class147)var0;
         var1 = var2.field2206 + " | ";
         var0 = var2.field2209;
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
            int var9 = var7.indexOf(41, 1 + var8);
            if(var8 >= 0 && var9 >= 0) {
               String var10 = var7.substring(1 + var8, var9);
               int var11 = var10.indexOf(".java:");
               if(var11 >= 0) {
                  var10 = var10.substring(0, var11) + var10.substring(var11 + 5);
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
