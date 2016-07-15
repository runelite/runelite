import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
public class class117 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;ZB)V",
      garbageValue = "-111"
   )
   public static void method2528(class170 var0, class170 var1, boolean var2) {
      class229.field3258 = var0;
      class42.field998 = var1;
      class42.field989 = var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "-110"
   )
   static void method2529(String var0, String var1, String var2) {
      class33.field772 = var0;
      class33.field781 = var1;
      class33.field791 = var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "16"
   )
   static String method2530(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Lclass2;III)V",
      garbageValue = "-29529774"
   )
   static void method2531(class2 var0, int var1, int var2) {
      if(var0.field890 == var1 && var1 != -1) {
         int var3 = class13.method153(var1).field1036;
         if(var3 == 1) {
            var0.field865 = 0;
            var0.field884 = 0;
            var0.field904 = var2;
            var0.field886 = 0;
         }

         if(var3 == 2) {
            var0.field886 = 0;
         }
      } else if(var1 == -1 || var0.field890 == -1 || class13.method153(var1).field1038 >= class13.method153(var0.field890).field1038) {
         var0.field890 = var1;
         var0.field865 = 0;
         var0.field884 = 0;
         var0.field904 = var2;
         var0.field886 = 0;
         var0.field909 = var0.field852;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "254734709"
   )
   static void method2532(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(class27.field681[var5] != var0) {
            var2[var4] = class27.field681[var5];
            var3[var4] = class27.field675[var5];
            ++var4;
         }
      }

      class27.field681 = var2;
      class27.field675 = var3;
      class78.method1732(class118.field2032, 0, class118.field2032.length - 1, class27.field681, class27.field675);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass170;IIB)Lclass81;",
      garbageValue = "2"
   )
   public static class81 method2533(class170 var0, int var1, int var2) {
      return !class42.method884(var0, var1, var2)?null:class4.method41();
   }
}
