import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class51 implements class103 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)LAbstractSoundSystem;",
      garbageValue = "77"
   )
   public AbstractSoundSystem vmethod1927() {
      return new SourceDataSoundSystem();
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
            if(var9 / var1 != var5) {
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1576687965"
   )
   @Export("resetMapInfo")
   static void resetMapInfo() {
      class61.underlayIds = null;
      class61.overlayIds = null;
      class36.overlayPaths = null;
      class67.overlayRotations = null;
      class39.field555 = null;
      class61.field771 = null;
      class61.field774 = null;
      class17.blendedHue = null;
      Permission.blendedSaturation = null;
      class10.field258 = null;
      Timer.field2273 = null;
      Buffer.field2406 = null;
   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "82"
   )
   static void method791() {
      if(Client.spellSelected) {
         Widget var0 = class202.method3650(class208.field2598, Client.field1158);
         if(var0 != null && var0.field2746 != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.widget = var0;
            var1.field857 = var0.field2746;
            class14.method76(var1);
         }

         Client.spellSelected = false;
         class88.method1714(var0);
      }
   }
}
