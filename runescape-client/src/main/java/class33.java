import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class33 {
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -564695551
   )
   static int field735;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2026952529
   )
   static int field736 = 0;
   @ObfuscatedName("v")
   static ModIcon field737;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1682087297
   )
   static int field738;
   @ObfuscatedName("i")
   static ModIcon field739;
   @ObfuscatedName("a")
   static boolean field740;
   @ObfuscatedName("m")
   static ModIcon field741;
   @ObfuscatedName("p")
   static int[] field742;
   @ObfuscatedName("y")
   static int[] field743;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -362505061
   )
   static int field744;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -2124895607
   )
   static int field745;
   @ObfuscatedName("at")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("ai")
   static boolean field747;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1476243893
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1922833743
   )
   static int field749;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1968869181
   )
   static int field750;
   @ObfuscatedName("av")
   static String field751;
   @ObfuscatedName("z")
   static ModIcon[] field753;
   @ObfuscatedName("ax")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = 1800890507
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("ab")
   @Export("username")
   static String username;
   @ObfuscatedName("al")
   static String field758;
   @ObfuscatedName("ad")
   static class162 field759;
   @ObfuscatedName("ae")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1866265333
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -1865277823
   )
   static int field765;
   @ObfuscatedName("aq")
   static String field767;
   @ObfuscatedName("aw")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2058904853
   )
   static int field769;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1790711239
   )
   @Export("loginIndex")
   static int loginIndex;

   static {
      loginWindowX = field736 + 202;
      field742 = new int[256];
      field744 = 0;
      field769 = 0;
      field738 = 0;
      field749 = 0;
      field745 = 0;
      field735 = 0;
      field750 = 10;
      field751 = "";
      loginIndex = 0;
      field767 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      field758 = "";
      field759 = class162.field2665;
      field747 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field765 = -1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;IZI)LFrames;",
      garbageValue = "1860811566"
   )
   public static Frames method713(class170 var0, class170 var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.method3330(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.method3315(var2, var5[var6]);
         if(var7 == null) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9 = var1.method3315(var8, 0);
            if(var9 == null) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new Frames(var0, var1, var2, var3);
         } catch (Exception var11) {
            return null;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1669011145"
   )
   public static void method722() {
      class56.field1235.reset();
   }
}
