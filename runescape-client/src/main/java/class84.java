import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("FaceNormal")
public class class84 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -276477217
   )
   int field1460;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1622989871
   )
   int field1461;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1309712875
   )
   int field1462;
   @ObfuscatedName("w")
   static int[] field1463;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = 1641896347
   )
   static int field1465;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "1"
   )
   public static final boolean method1962() {
      class137 var0 = class137.field2118;
      synchronized(class137.field2118) {
         if(class137.field2127 == class137.field2116) {
            return false;
         } else {
            class101.field1756 = class137.field2120[class137.field2116];
            class13.field198 = class137.field2119[class137.field2116];
            class137.field2116 = 1 + class137.field2116 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("ei")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZS)Ljava/lang/String;",
      garbageValue = "-23841"
   )
   static String method1963(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(client.field293 == 1) {
         var0 = var0 + "-wtrc";
      } else if(client.field293 == 2) {
         var0 = var0 + "-wtqa";
      } else if(client.field293 == 3) {
         var0 = var0 + "-wtwip";
      } else if(client.field293 == 5) {
         var0 = var0 + "-wti";
      } else if(client.field293 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(client.field413 != null) {
         var3 = "/p=" + client.field413;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + client.field297 + "/a=" + class14.field220 + var3 + "/";
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Lclass153;",
      garbageValue = "-2106686238"
   )
   public static class153 method1964(int var0) {
      class153[] var1 = class21.method604();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class153 var3 = var1[var2];
         if(var3.field2270 == var0) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "929986138"
   )
   static final void method1965(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class135.method2897(var0)) {
         class173.field2890 = null;
         class46.method1020(class173.field2770[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(null != class173.field2890) {
            class46.method1020(class173.field2890, -1412584499, var1, var2, var3, var4, class22.field594, class1.field34, var7);
            class173.field2890 = null;
         }

      } else {
         if(var7 != -1) {
            client.field516[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               client.field516[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILclass134;Lclass168;I)V",
      garbageValue = "-1240965519"
   )
   static void method1966(int var0, class134 var1, class168 var2) {
      byte[] var3 = null;
      class199 var4 = class170.field2707;
      synchronized(class170.field2707) {
         for(class169 var5 = (class169)class170.field2707.method3852(); null != var5; var5 = (class169)class170.field2707.method3857()) {
            if((long)var0 == var5.field3115 && var1 == var5.field2698 && var5.field2697 == 0) {
               var3 = var5.field2696;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method3367(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method2883(var0);
         var2.method3367(var1, var0, var8, true);
      }
   }
}
