import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public final class class16 extends class208 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1226281353
   )
   int field224;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 48755241
   )
   int field225;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -436095943
   )
   int field226;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1246101951
   )
   int field227;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 300133353
   )
   int field228;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1834564727
   )
   int field229;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1278168845
   )
   int field230;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 417279815
   )
   int field231;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2064981081
   )
   int field232;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -609084177
   )
   int field233;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 39459437
   )
   int field234 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 575622861
   )
   int field235 = -1;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/String;",
      garbageValue = "24"
   )
   public static String method161(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            char var6;
            if(var5 != 181 && var5 != 402) {
               var6 = Character.toTitleCase(var5);
            } else {
               var6 = var5;
            }

            var5 = var6;
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)Lclass43;",
      garbageValue = "-31"
   )
   public static class43 method162(int var0) {
      class43 var1 = (class43)class43.field1005.method3716((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class177.field2928.method3221(13, var0);
         var1 = new class43();
         var1.field1007 = var0;
         if(var2 != null) {
            var1.method886(new class119(var2));
         }

         class43.field1005.method3724(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "928989306"
   )
   @Export("loadWorlds")
   static boolean method163() {
      try {
         if(class41.field969 == null) {
            class41.field969 = new class18(class77.field1400, new URL(class172.field2766));
         } else {
            byte[] var0 = class41.field969.method172();
            if(null != var0) {
               class119 var1 = new class119(var0);
               class25.field629 = var1.method2470();
               class25.field636 = new class25[class25.field629];

               class25 var3;
               for(int var2 = 0; var2 < class25.field629; var3.field638 = var2++) {
                  var3 = class25.field636[var2] = new class25();
                  var3.field637 = var1.method2470();
                  var3.field645 = var1.method2505();
                  var3.field640 = var1.method2476();
                  var3.field633 = var1.method2476();
                  var3.field642 = var1.method2494();
                  var3.field639 = var1.method2638();
               }

               class8.method103(class25.field636, 0, class25.field636.length - 1, class25.field643, class25.field635);
               class41.field969 = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class41.field969 = null;
      }

      return false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "8684"
   )
   static void method164() {
      class76.field1388 = null;
      class165.field2689 = null;
      class76.field1385 = null;
      class14.field209 = null;
      class14.field213 = null;
      class45.field1045 = (byte[][])null;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Lclass80;",
      garbageValue = "-1415918339"
   )
   static class80 method165() {
      class80 var0 = new class80();
      var0.field1426 = class76.field1386;
      var0.field1422 = class76.field1392;
      var0.field1429 = class76.field1388[0];
      var0.field1427 = class165.field2689[0];
      var0.field1424 = class76.field1385[0];
      var0.field1425 = class14.field209[0];
      var0.field1423 = class14.field213;
      var0.field1428 = class45.field1045[0];
      method164();
      return var0;
   }
}
