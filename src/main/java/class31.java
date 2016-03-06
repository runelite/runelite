import java.awt.Font;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ac")
public class class31 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2028885567
   )
   static int field707;
   @ObfuscatedName("qc")
   protected static Font field708;
   @ObfuscatedName("a")
   static class80 field709;
   @ObfuscatedName("i")
   static class80 field710;
   @ObfuscatedName("aa")
   static String field711;
   @ObfuscatedName("o")
   static class78 field712;
   @ObfuscatedName("h")
   static class80 field713;
   @ObfuscatedName("j")
   static boolean field715;
   @ObfuscatedName("d")
   static int[] field716;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 25268225
   )
   static int field717;
   @ObfuscatedName("an")
   static String field718;
   @ObfuscatedName("ab")
   static int[] field719;
   @ObfuscatedName("af")
   static String field720;
   @ObfuscatedName("av")
   static boolean field721;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -555804669
   )
   static int field722;
   @ObfuscatedName("ai")
   static String field723;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1717866167
   )
   static int field724;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -942120685
   )
   static int field725;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -143912787
   )
   static int field726;
   @ObfuscatedName("as")
   static String field728;
   @ObfuscatedName("ag")
   static String field729;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1525306593
   )
   static int field730;
   @ObfuscatedName("ao")
   @Export("username")
   static String field731;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1335087571
   )
   static int field732 = 0;
   @ObfuscatedName("at")
   static class158 field733;
   @ObfuscatedName("ae")
   static boolean field734;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1275440585
   )
   static int field735;
   @ObfuscatedName("f")
   static class80[] field736;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -353930311
   )
   static int field737;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 19503579
   )
   static int field738;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -59688389
   )
   static int field739;
   @ObfuscatedName("bv")
   static class167 field740;

   static {
      field738 = field732 + 202;
      field716 = new int[256];
      field717 = 0;
      field707 = 0;
      field725 = 0;
      field737 = 0;
      field730 = 0;
      field726 = 0;
      field724 = 10;
      field723 = "";
      field722 = 0;
      field711 = "";
      field728 = "";
      field729 = "";
      field720 = "";
      field731 = "";
      field718 = "";
      field733 = class158.field2607;
      field734 = true;
      field735 = 0;
      field721 = false;
      field739 = -1;
   }

   @ObfuscatedName("l")
   public static class78 method689(class166 var0, int var1, int var2) {
      return !class11.method148(var0, var1, var2)?null:class92.method2136();
   }

   @ObfuscatedName("l")
   public static class172 method698(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(null == class172.field2757[var1] || class172.field2757[var1][var2] == null) {
         boolean var3 = class149.method3102(var1);
         if(!var3) {
            return null;
         }
      }

      return class172.field2757[var1][var2];
   }

   @ObfuscatedName("j")
   public static void method699(class166 var0) {
      class48.field1083 = var0;
   }
}
