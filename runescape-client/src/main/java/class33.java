import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class33 {
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 94318873
   )
   static int field719;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1856613611
   )
   static int field720 = 0;
   @ObfuscatedName("f")
   static boolean field721;
   @ObfuscatedName("t")
   static ModIcon field722;
   @ObfuscatedName("v")
   static ModIcon[] field723;
   @ObfuscatedName("ai")
   static String field724;
   @ObfuscatedName("m")
   static SpritePixels field725;
   @ObfuscatedName("ap")
   static class162 field726;
   @ObfuscatedName("w")
   static ModIcon field727;
   @ObfuscatedName("l")
   static ModIcon field728;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -548650477
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("b")
   static SpritePixels field731;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1742000247
   )
   static int field732;
   @ObfuscatedName("q")
   static int[] field733;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1784267521
   )
   static int field734;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 735595917
   )
   static int field735;
   @ObfuscatedName("aj")
   static int[] field736;
   @ObfuscatedName("j")
   static int[] field737;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1000597407
   )
   static int field738;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1170873737
   )
   static int field739;
   @ObfuscatedName("aq")
   static String field740;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 984652129
   )
   static int field741;
   @ObfuscatedName("aw")
   static String field742;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -875983319
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 346077103
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("at")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("aa")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("as")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("n")
   static ModIcon field748;
   @ObfuscatedName("k")
   static ModIcon field749;
   @ObfuscatedName("az")
   static boolean field751;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 1112134615
   )
   static int field752;
   @ObfuscatedName("ad")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("bc")
   static ModIcon[] field756;
   @ObfuscatedName("ao")
   @Export("username")
   static String username;

   static {
      loginWindowX = field720 + 202;
      field737 = new int[256];
      field734 = 0;
      field735 = 0;
      field739 = 0;
      field732 = 0;
      field719 = 0;
      field738 = 0;
      field741 = 10;
      field742 = "";
      loginIndex = 0;
      field740 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      field724 = "";
      field726 = class162.field2636;
      field751 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field752 = -1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;IZB)LFrames;",
      garbageValue = "9"
   )
   public static Frames method704(class170 var0, class170 var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.method3311(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.method3292(var2, var5[var6]);
         if(null == var7) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9 = var1.method3292(var8, 0);
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

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(LWidget;S)Z",
      garbageValue = "2966"
   )
   static final boolean method717(Widget var0) {
      if(var0.field2901 == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2901.length; ++var1) {
            int var2 = class51.method1069(var0, var1);
            int var3 = var0.field2889[var1];
            if(var0.field2901[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2901[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2901[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }
}
