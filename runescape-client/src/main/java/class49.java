import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class49 extends class204 {
   @ObfuscatedName("g")
   public boolean field1097 = false;
   @ObfuscatedName("i")
   public static class193 field1098 = new class193(64);
   @ObfuscatedName("t")
   public static class167 field1099;
   @ObfuscatedName("r")
   static class78 field1100;
   @ObfuscatedName("jc")
   @ObfuscatedGetter(
      intValue = 82289813
   )
   static int field1102;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass167;Ljava/lang/String;Ljava/lang/String;B)[Lclass78;",
      garbageValue = "63"
   )
   public static class78[] method973(class167 var0, String var1, String var2) {
      int var3 = var0.method3236(var1);
      int var4 = var0.method3237(var3, var2);
      return class28.method640(var0, var3, var4);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "5"
   )
   public void method974(class119 var1) {
      while(true) {
         int var2 = var1.method2494();
         if(var2 == 0) {
            return;
         }

         this.method981(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "1647107247"
   )
   static boolean method975(String var0) {
      if(var0 == null) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lclass40;",
      garbageValue = "-2046825951"
   )
   @Export("getObjectDefinition")
   public static class40 method980(int var0) {
      class40 var1 = (class40)class40.field932.method3716((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class211.field3140.method3221(6, var0);
         var1 = new class40();
         var1.field921 = var0;
         if(null != var2) {
            var1.method790(new class119(var2));
         }

         var1.method789();
         if(var1.field953) {
            var1.field931 = 0;
            var1.field937 = false;
         }

         class40.field932.method3724(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "348264135"
   )
   void method981(class119 var1, int var2) {
      if(var2 == 2) {
         this.field1097 = true;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Lclass78;",
      garbageValue = "-1404442038"
   )
   static class78 method982() {
      class78 var0 = new class78();
      var0.field1408 = class76.field1386;
      var0.field1411 = class76.field1392;
      var0.field1406 = class76.field1388[0];
      var0.field1407 = class165.field2689[0];
      var0.field1404 = class76.field1385[0];
      var0.field1405 = class14.field209[0];
      int var1 = var0.field1405 * var0.field1404;
      byte[] var2 = class45.field1045[0];
      var0.field1409 = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.field1409[var3] = class14.field213[var2[var3] & 255];
      }

      class16.method164();
      return var0;
   }
}
