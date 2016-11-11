import java.awt.Component;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
public class class93 {
   @ObfuscatedName("i")
   public static String field1614;
   @ObfuscatedName("ny")
   @ObfuscatedGetter(
      intValue = 1102222077
   )
   static int field1617;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "-66"
   )
   public static void method2138(Component var0) {
      var0.removeMouseListener(class143.mouse);
      var0.removeMouseMotionListener(class143.mouse);
      var0.removeFocusListener(class143.mouse);
      class143.field2205 = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "1486139008"
   )
   public static void method2139(String var0, Throwable var1) {
      try {
         String var2 = "";
         if(var1 != null) {
            Throwable var4 = var1;
            String var5;
            if(var1 instanceof class151) {
               class151 var6 = (class151)var1;
               var5 = var6.field2274 + " | ";
               var4 = var6.field2275;
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
               if(var11 == null) {
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
         if(null == class151.field2278) {
            return;
         }

         URL var3 = new URL(class151.field2278.getCodeBase(), "clienterror.ws?c=" + class151.field2273 + "&u=" + class112.field1956 + "&v1=" + field1614 + "&v2=" + class139.field2140 + "&e=" + var2);
         DataInputStream var17 = new DataInputStream(var3.openStream());
         var17.read();
         var17.close();
      } catch (Exception var16) {
         ;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass170;B)V",
      garbageValue = "-50"
   )
   public static void method2140(class170 var0) {
      class47.field1064 = var0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass215;I)Ljava/lang/String;",
      garbageValue = "2055631408"
   )
   public static String method2141(CharSequence var0, class215 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && class153.method3180(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && class153.method3180(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1 && var4 <= class50.method1021(var1)) {
            StringBuilder var5 = new StringBuilder(var4);

            for(int var6 = var2; var6 < var3; ++var6) {
               char var7 = var0.charAt(var6);
               if(class143.method2985(var7)) {
                  char var8;
                  switch(var7) {
                  case ' ':
                  case '-':
                  case '_':
                  case ' ':
                     var8 = 95;
                     break;
                  case '#':
                  case '[':
                  case ']':
                     var8 = var7;
                     break;
                  case 'À':
                  case 'Á':
                  case 'Â':
                  case 'Ã':
                  case 'Ä':
                  case 'à':
                  case 'á':
                  case 'â':
                  case 'ã':
                  case 'ä':
                     var8 = 97;
                     break;
                  case 'Ç':
                  case 'ç':
                     var8 = 99;
                     break;
                  case 'È':
                  case 'É':
                  case 'Ê':
                  case 'Ë':
                  case 'è':
                  case 'é':
                  case 'ê':
                  case 'ë':
                     var8 = 101;
                     break;
                  case 'Í':
                  case 'Î':
                  case 'Ï':
                  case 'í':
                  case 'î':
                  case 'ï':
                     var8 = 105;
                     break;
                  case 'Ñ':
                  case 'ñ':
                     var8 = 110;
                     break;
                  case 'Ò':
                  case 'Ó':
                  case 'Ô':
                  case 'Õ':
                  case 'Ö':
                  case 'ò':
                  case 'ó':
                  case 'ô':
                  case 'õ':
                  case 'ö':
                     var8 = 111;
                     break;
                  case 'Ù':
                  case 'Ú':
                  case 'Û':
                  case 'Ü':
                  case 'ù':
                  case 'ú':
                  case 'û':
                  case 'ü':
                     var8 = 117;
                     break;
                  case 'ß':
                     var8 = 98;
                     break;
                  case 'ÿ':
                  case 'Ÿ':
                     var8 = 121;
                     break;
                  default:
                     var8 = Character.toLowerCase(var7);
                  }

                  if(var8 != 0) {
                     var5.append(var8);
                  }
               }
            }

            if(var5.length() == 0) {
               return null;
            } else {
               return var5.toString();
            }
         } else {
            return null;
         }
      }
   }
}
