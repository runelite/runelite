import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
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
            Throwable var4 = var1;
            String var5;
            if(var1 instanceof class148) {
               class148 var6 = (class148)var1;
               var5 = var6.field2234 + " | ";
               var4 = var6.field2235;
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
                  String var14 = var11.substring(var12 + 1, var13);
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

         URL var3 = new URL(class126.field2052.getCodeBase(), "clienterror.ws?c=" + class148.field2236 + "&u=" + class148.field2233 + "&v1=" + class136.field2115 + "&v2=" + class124.field2046 + "&e=" + var2);
         DataInputStream var17 = new DataInputStream(var3.openStream());
         var17.read();
         var17.close();
      } catch (Exception var16) {
         ;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass25;I)V",
      garbageValue = "1547722373"
   )
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
