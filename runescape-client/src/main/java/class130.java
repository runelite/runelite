import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
public class class130 {
   @ObfuscatedName("u")
   static class62 field2083;
   @ObfuscatedName("cw")
   public static char field2084;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      longValue = -3183904738692211371L
   )
   static long field2085;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;II)I",
      garbageValue = "143466112"
   )
   public static int method2820(CharSequence var0, CharSequence var1, int var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      char var7 = 0;
      char var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if(var5 - var7 >= var3) {
            return -1;
         }

         if(var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if(var7 != 0) {
            var9 = var7;
            boolean var14 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var10;
         if(var8 != 0) {
            var10 = var8;
            boolean var15 = false;
         } else {
            var10 = var1.charAt(var6++);
         }

         var7 = Buffer.method2622(var9);
         var8 = Buffer.method2622(var10);
         var9 = class140.method2900(var9, var2);
         var10 = class140.method2900(var10, var2);
         if(var10 != var9 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
            var9 = Character.toLowerCase(var9);
            var10 = Character.toLowerCase(var10);
            if(var10 != var9) {
               return KitDefinition.method942(var9, var2) - KitDefinition.method942(var10, var2);
            }
         }
      }

      int var16 = Math.min(var3, var4);

      char var12;
      int var17;
      for(var17 = 0; var17 < var16; ++var17) {
         char var11 = var0.charAt(var17);
         var12 = var1.charAt(var17);
         if(var12 != var11 && Character.toUpperCase(var11) != Character.toUpperCase(var12)) {
            var11 = Character.toLowerCase(var11);
            var12 = Character.toLowerCase(var12);
            if(var12 != var11) {
               return KitDefinition.method942(var11, var2) - KitDefinition.method942(var12, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var18 = 0; var18 < var16; ++var18) {
            var12 = var0.charAt(var18);
            char var13 = var1.charAt(var18);
            if(var12 != var13) {
               return KitDefinition.method942(var12, var2) - KitDefinition.method942(var13, var2);
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "378984361"
   )
   static void method2821() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3780(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3785()) {
         int var1 = var0.id;
         if(class174.method3393(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(null != var3[var4]) {
                  var2 = var3[var4].field2797;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class92.method2078(var4);
               if(var5 != null) {
                  class32.method685(var5);
               }
            }
         }
      }

   }
}
