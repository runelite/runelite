import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
public class class90 {
   @ObfuscatedName("l")
   public static class224 field1567;
   @ObfuscatedName("j")
   static class167 field1568;
   @ObfuscatedName("em")
   static class78[] field1570;
   @ObfuscatedName("p")
   static class167 field1571;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;B)V",
      garbageValue = "-33"
   )
   public static void method2067(String var0, Throwable var1) {
      try {
         String var2 = "";
         if(null != var1) {
            Throwable var3 = var1;
            String var4;
            if(var1 instanceof class148) {
               class148 var5 = (class148)var1;
               var4 = var5.field2234 + " | ";
               var3 = var5.field2235;
            } else {
               var4 = "";
            }

            StringWriter var17 = new StringWriter();
            PrintWriter var6 = new PrintWriter(var17);
            var3.printStackTrace(var6);
            var6.close();
            String var7 = var17.toString();
            BufferedReader var8 = new BufferedReader(new StringReader(var7));
            String var9 = var8.readLine();

            while(true) {
               String var10 = var8.readLine();
               if(null == var10) {
                  var4 = var4 + "| " + var9;
                  var2 = var4;
                  break;
               }

               int var11 = var10.indexOf(40);
               int var12 = var10.indexOf(41, 1 + var11);
               if(var11 >= 0 && var12 >= 0) {
                  String var13 = var10.substring(var11 + 1, var12);
                  int var14 = var13.indexOf(".java:");
                  if(var14 >= 0) {
                     var13 = var13.substring(0, var14) + var13.substring(5 + var14);
                     var4 = var4 + var13 + ' ';
                     continue;
                  }

                  var10 = var10.substring(0, var11);
               }

               var10 = var10.trim();
               var10 = var10.substring(var10.lastIndexOf(32) + 1);
               var10 = var10.substring(var10.lastIndexOf(9) + 1);
               var4 = var4 + var10 + ' ';
            }
         }

         if(null != var0) {
            if(null != var1) {
               var2 = var2 + " | ";
            }

            var2 = var2 + var0;
         }

         System.out.println("Error: " + var2);
         var2 = var2.replace(':', '.');
         var2 = var2.replace('@', '_');
         var2 = var2.replace('&', '_');
         var2 = var2.replace('#', '_');
         if(null == class126.field2052) {
            return;
         }

         URL var16 = new URL(class126.field2052.getCodeBase(), "clienterror.ws?c=" + class148.field2236 + "&u=" + class148.field2233 + "&v1=" + class136.field2115 + "&v2=" + class124.field2046 + "&e=" + var2);
         DataInputStream var18 = new DataInputStream(var16.openStream());
         var18.read();
         var18.close();
      } catch (Exception var15) {
         ;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass25;I)V",
      garbageValue = "1547722373"
   )
   @Export("selectWorld")
   static void method2068(class25 var0) {
      if(var0.method580() != client.field447) {
         client.field447 = var0.method580();
         class1.method1(var0.method580());
      }

      class127.field2059 = var0.field635;
      client.field551 = var0.field632;
      client.field279 = var0.field633;
      class59.field1223 = 0 == client.field281?'ꩊ':'鱀' + var0.field632;
      class176.field2922 = client.field281 == 0?443:'썐' + var0.field632;
      class52.field1170 = class59.field1223;
   }
}
