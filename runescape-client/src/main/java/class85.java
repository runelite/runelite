import java.net.URL;
import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("Renderable")
public abstract class class85 extends class204 {
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = -1743758001
   )
   @Export("baseY")
   static int field1434;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -417538431
   )
   @Export("modelHeight")
   public int field1436 = 1000;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIZB)Ljava/lang/String;",
      garbageValue = "30"
   )
   public static String method1911(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var0 < 0) {
            return Integer.toString(var0, var1);
         } else {
            int var3 = 2;

            for(int var4 = var0 / var1; var4 != 0; ++var3) {
               var4 /= var1;
            }

            char[] var5 = new char[var3];
            var5[0] = 43;

            for(int var6 = var3 - 1; var6 > 0; --var6) {
               int var7 = var0;
               var0 /= var1;
               int var8 = var7 - var0 * var1;
               if(var8 >= 10) {
                  var5[var6] = (char)(var8 + 87);
               } else {
                  var5[var6] = (char)(48 + var8);
               }
            }

            return new String(var5);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "853773613"
   )
   @Export("getModel")
   protected class105 vmethod1913() {
      return null;
   }

   @ObfuscatedName("ag")
   void vmethod2313(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      class105 var10 = this.vmethod1913();
      if(null != var10) {
         this.field1436 = var10.field1436;
         var10.vmethod2313(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Lclass44;",
      garbageValue = "1598258864"
   )
   @Export("getKitDefinition")
   public static class44 method1919(int var0) {
      class44 var1 = (class44)class44.field1008.method3764((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class44.field1012.method3266(3, var0);
         var1 = new class44();
         if(null != var2) {
            var1.method928(new class119(var2));
         }

         class44.field1008.method3759(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("b")
   public static String method1920(long var0) {
      class111.field1940.setTime(new Date(var0));
      int var2 = class111.field1940.get(7);
      int var3 = class111.field1940.get(5);
      int var4 = class111.field1940.get(2);
      int var5 = class111.field1940.get(1);
      int var6 = class111.field1940.get(11);
      int var7 = class111.field1940.get(12);
      int var8 = class111.field1940.get(13);
      return class111.field1939[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class111.field1941[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "-1734833207"
   )
   static final void method1921(int var0, int var1, int var2, boolean var3) {
      if(class84.method1909(var0)) {
         class52.method1074(class173.field2750[var0], -1, var1, var2, var3);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass167;IIIZI)V",
      garbageValue = "1486997217"
   )
   public static void method1922(class167 var0, int var1, int var2, int var3, boolean var4) {
      class183.field2953 = 1;
      class50.field1075 = var0;
      class177.field2903 = var1;
      class183.field2951 = var2;
      class181.field2929 = var3;
      class183.field2956 = var4;
      class183.field2955 = 10000;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1618911639"
   )
   @Export("loadWorlds")
   static boolean method1923() {
      try {
         if(null == class155.field2283) {
            class155.field2283 = new class18(class40.field924, new URL(class98.field1634));
         } else {
            byte[] var0 = class155.field2283.method183();
            if(var0 != null) {
               class119 var1 = new class119(var0);
               class25.field627 = var1.method2516();
               class25.field635 = new class25[class25.field627];

               class25 var3;
               for(int var2 = 0; var2 < class25.field627; var3.field642 = var2++) {
                  var3 = class25.field635[var2] = new class25();
                  var3.field636 = var1.method2516();
                  var3.field640 = var1.method2519();
                  var3.field637 = var1.method2522();
                  var3.field646 = var1.method2522();
                  var3.field641 = var1.method2514();
                  var3.field638 = var1.method2517();
               }

               class16.method177(class25.field635, 0, class25.field635.length - 1, class25.field639, class25.field647);
               class155.field2283 = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class155.field2283 = null;
      }

      return false;
   }
}
