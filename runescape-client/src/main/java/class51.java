import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class51 implements class103 {
   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "82"
   )
   static void method791() {
      if(Client.field1082) {
         Widget var0 = class202.method3650(class208.field2598, Client.field1158);
         if(var0 != null && var0.field2746 != null) {
            class69 var1 = new class69();
            var1.field849 = var0;
            var1.field857 = var0.field2746;
            class14.method76(var1);
         }

         Client.field1082 = false;
         class88.method1714(var0);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Lclass109;",
      garbageValue = "77"
   )
   public class109 vmethod1927() {
      return new class55();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1576687965"
   )
   static void method794() {
      class61.underlayIds = null;
      class61.overlayIds = null;
      class36.overlayPaths = null;
      class67.overlayRotations = null;
      class39.field555 = null;
      class61.field771 = null;
      class61.field774 = null;
      class17.field316 = null;
      class230.field3190 = null;
      class10.field258 = null;
      class158.field2273 = null;
      Buffer.field2406 = null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)Z",
      garbageValue = "-1679080523"
   )
   public static boolean method795(CharSequence var0, int var1, boolean var2) {
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
}
