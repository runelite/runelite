import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
public class class86 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "873978136"
   )
   @Export("getLength")
   public static int getLength(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILct;ZI)I",
      garbageValue = "-1818381209"
   )
   static int method1718(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = ItemLayer.method2454(class81.intStack[--class278.intStackSize]);
      } else {
         var3 = var2?class251.field3392:class164.field2314;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class81.intStack[--class278.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.method4077(var4, class81.scriptStringStack[--class266.scriptStringStackSize]);
            return 1;
         } else {
            --class266.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class278.intStackSize -= 2;
         var4 = class81.intStack[class278.intStackSize];
         int var5 = class81.intStack[class278.intStackSize + 1];
         var3.dragParent = class215.method4064(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2720 = class81.intStack[--class278.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2718 = class81.intStack[--class278.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.field2688 = class81.intStack[--class278.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class81.scriptStringStack[--class266.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.selectedAction = class81.scriptStringStack[--class266.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-2110216567"
   )
   public static String method1719(CharSequence var0) {
      long var3 = 0L;
      int var5 = var0.length();

      for(int var6 = 0; var6 < var5; ++var6) {
         var3 *= 37L;
         char var7 = var0.charAt(var6);
         if(var7 >= 'A' && var7 <= 'Z') {
            var3 += (long)(var7 + 1 - 65);
         } else if(var7 >= 'a' && var7 <= 'z') {
            var3 += (long)(var7 + 1 - 97);
         } else if(var7 >= '0' && var7 <= '9') {
            var3 += (long)(var7 + 27 - 48);
         }

         if(var3 >= 177917621779460413L) {
            break;
         }
      }

      while(var3 % 37L == 0L && 0L != var3) {
         var3 /= 37L;
      }

      String var8 = Overlay.method4776(var3);
      if(var8 == null) {
         var8 = "";
      }

      return var8;
   }
}
