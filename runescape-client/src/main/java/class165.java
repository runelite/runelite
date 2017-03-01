import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class165 {
   @ObfuscatedName("x")
   public static int[] field2163 = new int[32];
   @ObfuscatedName("n")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("g")
   @Export("widgetSettings")
   public static int[] widgetSettings;

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2163[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)Z",
      garbageValue = "1424912901"
   )
   public static boolean method3230(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  return false;
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               return false;
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var10 + var5 * var1;
            if(var5 != var9 / var1) {
               return false;
            }

            var5 = var9;
            var4 = true;
         }

         return var4;
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)LKitDefinition;",
      garbageValue = "990062466"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.field2830.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.field2829.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(null != var2) {
            var1.method3559(new Buffer(var2));
         }

         KitDefinition.field2830.put(var1, (long)var0);
         return var1;
      }
   }

   class165() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "625902221"
   )
   public static int method3233(String var0) {
      return var0.length() + 1;
   }
}
