import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("bl")
   static class184 field137;
   @ObfuscatedName("d")
   @Export("itemIds")
   int[] itemIds = new int[]{-1};
   @ObfuscatedName("h")
   @Export("stackSizes")
   int[] stackSizes = new int[]{0};
   @ObfuscatedName("cz")
   static class102 field143;
   @ObfuscatedName("q")
   @Export("itemContainers")
   static XHashTable itemContainers = new XHashTable(32);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "1404792513"
   )
   public static void method157(class182 var0) {
      class186.field2772 = var0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1830143793"
   )
   public static int method159(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class3.method39(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIIS)Ljava/lang/String;",
      garbageValue = "-4477"
   )
   public static String method164(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;
      int var5 = var1;

      int var8;
      for(int var6 = var1 + var2; var5 < var6; var3[var4++] = (char)var8) {
         int var7 = var0[var5++] & 255;
         if(var7 < 128) {
            if(var7 == 0) {
               var8 = '�';
            } else {
               var8 = var7;
            }
         } else if(var7 < 192) {
            var8 = '�';
         } else if(var7 < 224) {
            if(var5 < var6 && (var0[var5] & 192) == 128) {
               var8 = (var7 & 31) << 6 | var0[var5++] & 63;
               if(var8 < 128) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 240) {
            if(1 + var5 < var6 && (var0[var5] & 192) == 128 && (var0[1 + var5] & 192) == 128) {
               var8 = (var7 & 15) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 < 2048) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 248) {
            if(var5 + 2 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128 && (var0[var5 + 2] & 192) == 128) {
               var8 = (var7 & 7) << 18 | (var0[var5++] & 63) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 >= 65536 && var8 <= 1114111) {
                  var8 = '�';
               } else {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else {
            var8 = '�';
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2138588970"
   )
   public static boolean method166(int var0) {
      return (var0 >> 31 & 1) != 0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILclass182;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "-1982464065"
   )
   public static void method167(int var0, class182 var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.method3335(var2);
      int var7 = var1.method3319(var6, var3);
      class152.method2815(var0, var1, var6, var7, var4, var5);
   }
}
