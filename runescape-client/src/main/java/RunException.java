import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
@Implements("RunException")
public class RunException extends RuntimeException {
   @ObfuscatedName("qh")
   @ObfuscatedSignature(
      signature = "Lct;"
   )
   @Export("friendManager")
   public static FriendManager friendManager;
   @ObfuscatedName("c")
   public static Applet field2178;
   @ObfuscatedName("i")
   public static String field2176;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1591042175
   )
   @Export("revision")
   public static int revision;
   @ObfuscatedName("z")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lfm;"
   )
   @Export("timer")
   static Timer timer;
   @ObfuscatedName("ab")
   static int[] field2181;
   @ObfuscatedName("j")
   String field2184;
   @ObfuscatedName("k")
   @Export("parent")
   Throwable parent;

   RunException(Throwable var1, String var2) {
      this.field2184 = var2;
      this.parent = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)Z",
      garbageValue = "-1595135244"
   )
   static boolean method3229(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == '-') {
                  var3 = true;
                  continue;
               }

               if(var8 == '+') {
                  continue;
               }
            }

            int var10;
            if(var8 >= '0' && var8 <= '9') {
               var10 = var8 - '0';
            } else if(var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - '7';
            } else {
               if(var8 < 'a' || var8 > 'z') {
                  return false;
               }

               var10 = var8 - 'W';
            }

            if(var10 >= var1) {
               return false;
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
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

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIB)V",
      garbageValue = "-78"
   )
   @Export("addMenuEntry")
   public static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      boolean var12 = false;
      if(!Client.isMenuOpen && Client.menuOptionCount < 500) {
         Client.menuOptions[Client.menuOptionCount] = var0;
         Client.menuTargets[Client.menuOptionCount] = var1;
         Client.menuTypes[Client.menuOptionCount] = var2;
         Client.menuIdentifiers[Client.menuOptionCount] = var3;
         Client.menuActionParams0[Client.menuOptionCount] = var4;
         Client.menuActionParams1[Client.menuOptionCount] = var5;
         Client.menuBooleanArray[Client.menuOptionCount] = var12;
         ++Client.menuOptionCount;
      }

   }
}
