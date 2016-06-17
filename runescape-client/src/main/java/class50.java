import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class50 extends class204 {
   @ObfuscatedName("g")
   static class193 field1069 = new class193(64);
   @ObfuscatedName("b")
   static class167 field1070;
   @ObfuscatedName("bc")
   static class168 field1071;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1277092379
   )
   public int field1072 = 0;
   @ObfuscatedName("x")
   public static class167 field1073;
   @ObfuscatedName("na")
   static class56 field1074;
   @ObfuscatedName("y")
   public static class167 field1075;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2086913592"
   )
   public static void method1007(int var0) {
      if(var0 != -1) {
         if(class173.field2788[var0]) {
            class173.field2739.method3345(var0);
            if(class173.field2750[var0] != null) {
               boolean var1 = true;

               for(int var2 = 0; var2 < class173.field2750[var0].length; ++var2) {
                  if(null != class173.field2750[var0][var2]) {
                     if(class173.field2750[var0][var2].field2833 != 2) {
                        class173.field2750[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  class173.field2750[var0] = null;
               }

               class173.field2788[var0] = false;
            }
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "902900497"
   )
   void method1008(class119 var1) {
      while(true) {
         int var2 = var1.method2514();
         if(var2 == 0) {
            return;
         }

         this.method1009(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "800920474"
   )
   void method1009(class119 var1, int var2) {
      if(var2 == 2) {
         this.field1072 = var1.method2516();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "1634924576"
   )
   public static String method1014(CharSequence var0) {
      String var1 = class103.method2293(class123.method2817(var0));
      if(null == var1) {
         var1 = "";
      }

      return var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-40"
   )
   static void method1016(int var0, int var1, int var2) {
      if(client.field527 != 0 && var1 != 0 && client.field504 < 50) {
         client.field530[client.field504] = var0;
         client.field531[client.field504] = var1;
         client.field532[client.field504] = var2;
         client.field534[client.field504] = null;
         client.field480[client.field504] = 0;
         ++client.field504;
      }

   }
}
