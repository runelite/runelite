import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class178 {
   @ObfuscatedName("e")
   static final class178 field2673 = new class178("BUILDLIVE", 3);
   @ObfuscatedName("f")
   static final class178 field2674 = new class178("RC", 1);
   @ObfuscatedName("k")
   static final class178 field2675 = new class178("WIP", 2);
   @ObfuscatedName("g")
   public final String field2676;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 203332065
   )
   final int field2677;
   @ObfuscatedName("eg")
   static SpritePixels field2678;
   @ObfuscatedName("i")
   static final class178 field2679 = new class178("LIVE", 0);
   @ObfuscatedName("ny")
   @ObfuscatedGetter(
      intValue = -1670199511
   )
   static int field2680;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)Z",
      garbageValue = "-2044222569"
   )
   public static boolean method3196(class182 var0, int var1, int var2) {
      byte[] var3 = var0.method3211(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         class204.method3735(var3);
         return true;
      }
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class178(String var1, int var2) {
      this.field2676 = var1;
      this.field2677 = var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass184;IIIBZB)V",
      garbageValue = "7"
   )
   static void method3200(class184 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      class181 var8 = (class181)class185.field2747.method2311(var6);
      if(null == var8) {
         var8 = (class181)class185.field2749.method2311(var6);
         if(var8 == null) {
            var8 = (class181)class185.field2757.method2311(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method2388();
                  class185.field2747.method2312(var8, var6);
                  --class185.field2753;
                  ++class185.field2765;
               }

            } else {
               if(!var5) {
                  var8 = (class181)class185.field2754.method2311(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new class181();
               var8.field2698 = var0;
               var8.field2697 = var3;
               var8.field2701 = var4;
               if(var5) {
                  class185.field2747.method2312(var8, var6);
                  ++class185.field2765;
               } else {
                  class185.field2751.method2258(var8);
                  class185.field2757.method2312(var8, var6);
                  ++class185.field2753;
               }

            }
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-849339272"
   )
   public static String method3201(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = class165.method3062(var5);
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
}
