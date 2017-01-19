import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class41 {
   @ObfuscatedName("aq")
   static String field810;
   @ObfuscatedName("a")
   static ModIcon[] field811;
   @ObfuscatedName("s")
   static boolean field812;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1836549201
   )
   static int field814 = 0;
   @ObfuscatedName("g")
   static SpritePixels field815;
   @ObfuscatedName("u")
   static ModIcon field816;
   @ObfuscatedName("x")
   static ModIcon field817;
   @ObfuscatedName("r")
   static ModIcon field818;
   @ObfuscatedName("f")
   static ModIcon field819;
   @ObfuscatedName("i")
   static int[] field820;
   @ObfuscatedName("t")
   static int[] field821;
   @ObfuscatedName("al")
   static String field822;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -664738975
   )
   static int field823;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1236855913
   )
   static int field824;
   @ObfuscatedName("ap")
   @Export("authCode")
   static String authCode;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1466546139
   )
   static int field826;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 265684895
   )
   static int field827;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1455042449
   )
   static int field828;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -514750725
   )
   static int field829;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1516319003
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("aw")
   static String field831;
   @ObfuscatedName("ah")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -797321953
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("ay")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("as")
   @Export(value = "username", setter = true)
   static String username;
   @ObfuscatedName("ar")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("ac")
   static boolean field837;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 453273341
   )
   static int field838;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1765235473
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("h")
   static ModIcon field840;
   @ObfuscatedName("au")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("bw")
   static ModIcon[] field845;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -594137485
   )
   static int field846;
   @ObfuscatedName("af")
   static class97 field847;
   @ObfuscatedName("eb")
   static SpritePixels[] field848;

   static {
      loginWindowX = 202 + field814;
      field820 = new int[256];
      field829 = 0;
      field823 = 0;
      field824 = 0;
      field838 = 0;
      field826 = 0;
      field827 = 0;
      field828 = 10;
      field822 = "";
      loginIndex = 0;
      field831 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      field810 = "";
      field847 = class97.field1636;
      field837 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field846 = -1;
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIZI)V",
      garbageValue = "-587417466"
   )
   static void method754(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(null != var6 && var6.parentId == var1) {
            class94.method1861(var6, var2, var3, var4);
            class10.method99(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class1.method14(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "29853161"
   )
   static final int method755(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
