import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class7 {
   @ObfuscatedName("n")
   public static boolean field231;
   @ObfuscatedName("p")
   public static boolean field232;
   @ObfuscatedName("ge")
   static ModIcon[] field233;
   @ObfuscatedName("j")
   public static class11 field234;
   @ObfuscatedName("i")
   public static boolean field235;
   @ObfuscatedName("f")
   static CombatInfoList field236;

   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "1376312589"
   )
   static boolean method29(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = CollisionData.method3023(var0, class13.field281);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(CollisionData.method3023(Client.friends[var3].name, class13.field281)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(CollisionData.method3023(class168.localPlayer.name, class13.field281))) {
            return true;
         } else {
            return false;
         }
      }
   }

   static {
      field231 = false;
      field232 = false;
      field235 = false;
      field234 = class11.field268;
      field236 = new CombatInfoList();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZI)V",
      garbageValue = "2137502630"
   )
   public static void method44(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class56.field669.startsWith("win")) {
            class47.method687(var0, 0, "openjs");
            return;
         }

         if(class56.field669.startsWith("mac")) {
            class47.method687(var0, 1, var2);
            return;
         }

         class47.method687(var0, 2, "openjs");
      } else {
         class47.method687(var0, 3, "openjs");
      }

   }
}
