package net.runelite.rs.client;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("el")
public class class153 implements class111 {
   @ObfuscatedName("u")
   static final class153 field2269 = new class153("game5", "Game 5", 4);
   @ObfuscatedName("j")
   static final class153 field2270 = new class153("runescape", "RuneScape", 0);
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -950918131
   )
   final int field2271;
   @ObfuscatedName("l")
   static final class153 field2272 = new class153("game4", "Game 4", 3);
   @ObfuscatedName("a")
   public static final class153 field2273 = new class153("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("f")
   static final class153 field2274 = new class153("game3", "Game 3", 2);
   @ObfuscatedName("h")
   public final String field2275;
   @ObfuscatedName("m")
   static final class153 field2276 = new class153("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("pm")
   static class8 field2277;
   @ObfuscatedName("bg")
   static class167 field2278;

   @ObfuscatedName("dw")
   static boolean method3195(class172 var0) {
      if(client.field442) {
         if(class7.method126(var0) != 0) {
            return false;
         }

         if(var0.field2736 == 0) {
            return false;
         }
      }

      return var0.field2724;
   }

   @ObfuscatedName("m")
   public int vmethod3208() {
      return this.field2271;
   }

   @ObfuscatedName("l")
   static char method3199(char var0) {
      switch(var0) {
      case ' ':
      case '-':
      case '_':
      case ' ':
         return '_';
      case '#':
      case '[':
      case ']':
         return var0;
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
         return 'a';
      case 'Ç':
      case 'ç':
         return 'c';
      case 'È':
      case 'É':
      case 'Ê':
      case 'Ë':
      case 'è':
      case 'é':
      case 'ê':
      case 'ë':
         return 'e';
      case 'Í':
      case 'Î':
      case 'Ï':
      case 'í':
      case 'î':
      case 'ï':
         return 'i';
      case 'Ñ':
      case 'ñ':
         return 'n';
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
         return 'o';
      case 'Ù':
      case 'Ú':
      case 'Û':
      case 'Ü':
      case 'ù':
      case 'ú':
      case 'û':
      case 'ü':
         return 'u';
      case 'ß':
         return 'b';
      case 'ÿ':
      case 'Ÿ':
         return 'y';
      default:
         return Character.toLowerCase(var0);
      }
   }

   @ObfuscatedName("j")
   public static void method3200() {
      if(class135.field2089.toLowerCase().indexOf("microsoft") != -1) {
         class136.field2098[186] = 57;
         class136.field2098[187] = 27;
         class136.field2098[188] = 71;
         class136.field2098[189] = 26;
         class136.field2098[190] = 72;
         class136.field2098[191] = 73;
         class136.field2098[192] = 58;
         class136.field2098[219] = 42;
         class136.field2098[220] = 74;
         class136.field2098[221] = 43;
         class136.field2098[222] = 59;
         class136.field2098[223] = 28;
      } else {
         class136.field2098[44] = 71;
         class136.field2098[45] = 26;
         class136.field2098[46] = 72;
         class136.field2098[47] = 73;
         class136.field2098[59] = 57;
         class136.field2098[61] = 27;
         class136.field2098[91] = 42;
         class136.field2098[92] = 74;
         class136.field2098[93] = 43;
         class136.field2098[192] = 28;
         class136.field2098[222] = 58;
         class136.field2098[520] = 59;
      }

   }

   class153(String var1, String var2, int var3) {
      this.field2275 = var1;
      this.field2271 = var3;
   }

   @ObfuscatedName("j")
   static long method3201() {
      try {
         URL var0 = new URL(class22.method617("services", false) + "m=accountappeal/login.ws");
         URLConnection var1 = var0.openConnection();
         var1.setRequestProperty("connection", "close");
         var1.setDoInput(true);
         var1.setDoOutput(true);
         var1.setConnectTimeout(5000);
         OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
         var2.write("data1=req");
         var2.flush();
         InputStream var3 = var1.getInputStream();
         class118 var4 = new class118(new byte[1000]);

         do {
            int var5 = var3.read(var4.field1980, var4.field1981, 1000 - var4.field1981);
            if(var5 == -1) {
               var4.field1981 = 0;
               long var7 = var4.method2734();
               return var7;
            }

            var4.field1981 += var5;
         } while(var4.field1981 < 1000);

         return 0L;
      } catch (Exception var6) {
         return 0L;
      }
   }
}
