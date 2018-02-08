import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
@Implements("Occluder")
public final class Occluder {
   @ObfuscatedName("kt")
   @ObfuscatedGetter(
      intValue = -586779583
   )
   static int field2038;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 719869027
   )
   @Export("minTileX")
   int minTileX;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1482029957
   )
   @Export("maxTIleX")
   int maxTIleX;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -263188917
   )
   @Export("minTileZ")
   int minTileZ;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1424196835
   )
   @Export("maxTileZ")
   int maxTileZ;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -149501771
   )
   @Export("type")
   int type;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2028328181
   )
   @Export("minX")
   int minX;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1431353305
   )
   @Export("maxX")
   int maxX;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -561126815
   )
   @Export("minZ")
   int minZ;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2022742569
   )
   @Export("maxZ")
   int maxZ;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1199875495
   )
   @Export("minY")
   int minY;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 397961125
   )
   @Export("maxY")
   int maxY;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 975475243
   )
   @Export("testDirection")
   int testDirection;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -657434259
   )
   int field2025;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1218470777
   )
   int field2037;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 916250069
   )
   @Export("minNormalX")
   int minNormalX;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 914960063
   )
   @Export("maxNormalX")
   int maxNormalX;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -733141735
   )
   @Export("minNormalY")
   int minNormalY;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 730095369
   )
   @Export("maxNormalY")
   int maxNormalY;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "697969039"
   )
   public static final boolean method3140() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         if(KeyFocusListener.field618 == KeyFocusListener.field622) {
            return false;
         } else {
            KeyFocusListener.field608 = KeyFocusListener.field603[KeyFocusListener.field622];
            class237.field3235 = KeyFocusListener.field612[KeyFocusListener.field622];
            KeyFocusListener.field622 = KeyFocusListener.field622 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-8"
   )
   static void method3139(boolean var0) {
      class89.loginMessage1 = "";
      class89.loginMessage2 = "Enter your username/email & password.";
      class89.loginMessage3 = "";
      class89.loginIndex = 2;
      if(var0) {
         class89.password = "";
      }

      if(class89.username == null || class89.username.length() <= 0) {
         if(WorldComparator.preferences.rememberedUsername != null) {
            class89.username = WorldComparator.preferences.rememberedUsername;
            class89.Login_isUsernameRemembered = true;
         } else {
            class89.Login_isUsernameRemembered = false;
         }
      }

      class1.method0();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2112925998"
   )
   public static int method3141(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }
}
