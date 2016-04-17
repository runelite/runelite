import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class11 {
   @ObfuscatedName("w")
   static final class198 field181 = new class198(1024);
   @ObfuscatedName("d")
   static final class200 field182 = new class200();
   @ObfuscatedName("a")
   static final Map field183 = new HashMap();
   @ObfuscatedName("jn")
   @ObfuscatedGetter(
      intValue = -871272097
   )
   static int field184;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1842221773
   )
   static int field185 = 0;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = -1456309681
   )
   static int field187;
   @ObfuscatedName("le")
   static class130 field189;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIILclass40;II)V",
      garbageValue = "-1654161914"
   )
   static void method175(int var0, int var1, int var2, class40 var3, int var4) {
      class23 var5 = new class23();
      var5.field624 = var0;
      var5.field618 = var1 * 128;
      var5.field613 = var2 * 128;
      int var6 = var3.field938;
      int var7 = var3.field939;
      if(1 == var4 || var4 == 3) {
         var6 = var3.field939;
         var7 = var3.field938;
      }

      var5.field614 = (var1 + var6) * 128;
      var5.field619 = (var2 + var7) * 128;
      var5.field620 = var3.field967;
      var5.field616 = var3.field968 * 128;
      var5.field610 = var3.field962;
      var5.field617 = var3.field948;
      var5.field621 = var3.field971;
      if(null != var3.field925) {
         var5.field612 = var3;
         var5.method658();
      }

      class23.field627.method3900(var5);
      if(null != var5.field621) {
         var5.field622 = var5.field610 + (int)(Math.random() * (double)(var5.field617 - var5.field610));
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Lclass51;",
      garbageValue = "187512093"
   )
   public static class51 method178(int var0) {
      class51 var1 = (class51)class51.field1151.method3840((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class129.field2052.method3403(10, var0);
         var1 = new class51();
         var1.field1123 = var0;
         if(null != var2) {
            var1.method1126(new class119(var2));
         }

         var1.method1125();
         if(-1 != var1.field1156) {
            var1.method1144(method178(var1.field1156), method178(var1.field1155));
         }

         if(var1.field1128 != -1) {
            var1.method1129(method178(var1.field1128), method178(var1.field1130));
         }

         if(var1.field1144 != -1) {
            var1.method1130(method178(var1.field1144), method178(var1.field1119));
         }

         if(!class51.field1117 && var1.field1138) {
            var1.field1125 = "Members object";
            var1.field1166 = false;
            var1.field1139 = null;
            var1.field1140 = null;
            var1.field1133 = 0;
         }

         class51.field1151.method3842(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1790788077"
   )
   public static void method187() {
      class46.field1065.method3843();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZB)Lclass227;",
      garbageValue = "-52"
   )
   public static class227 method188(String var0, String var1, boolean var2) {
      File var3 = new File(class149.field2233, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            class227 var10 = new class227(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class72.field1361 == 33) {
         var4 = "_rc";
      } else if(34 == class72.field1361) {
         var4 = "_wip";
      }

      File var5 = new File(class23.field626, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      class227 var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new class227(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new class227(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }
}
