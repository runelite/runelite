import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class31 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1903510289
   )
   static int field696 = 0;
   @ObfuscatedName("x")
   static class80[] field697;
   @ObfuscatedName("aa")
   @Export("username")
   static String field698;
   @ObfuscatedName("j")
   static boolean field699;
   @ObfuscatedName("i")
   static class78 field700;
   @ObfuscatedName("c")
   static class80 field701;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2046490465
   )
   static int field702;
   @ObfuscatedName("t")
   static int[] field703;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 373627255
   )
   static int field704;
   @ObfuscatedName("z")
   static class80 field705;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -975000005
   )
   static int field707;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -2072542597
   )
   static int field708;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1164658507
   )
   static int field709;
   @ObfuscatedName("ah")
   static String field710;
   @ObfuscatedName("ao")
   static String field711;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1698693903
   )
   static int field712;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 744341203
   )
   static int field713;
   @ObfuscatedName("az")
   static String field714;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1637311355
   )
   static int field715;
   @ObfuscatedName("ax")
   static String field716;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -568209787
   )
   static int field717;
   @ObfuscatedName("ad")
   static class78[] field718;
   @ObfuscatedName("as")
   static String field719;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1926503709
   )
   static int field720;
   @ObfuscatedName("ar")
   static boolean field721;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 267771209
   )
   static int field722;
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = 77824729
   )
   protected static int field724;
   @ObfuscatedName("al")
   static boolean field726;
   @ObfuscatedName("ai")
   static class159 field727;
   @ObfuscatedName("dw")
   static byte[][] field728;
   @ObfuscatedName("av")
   static String field729;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1467939909
   )
   static int field730;
   @ObfuscatedName("m")
   static class80 field731;

   static {
      field702 = 202 + field696;
      field703 = new int[256];
      field704 = 0;
      field713 = 0;
      field715 = 0;
      field707 = 0;
      field708 = 0;
      field709 = 0;
      field730 = 10;
      field711 = "";
      field712 = 0;
      field719 = "";
      field714 = "";
      field729 = "";
      field716 = "";
      field698 = "";
      field710 = "";
      field727 = class159.field2591;
      field721 = true;
      field722 = 0;
      field726 = false;
      field717 = -1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)[Lclass78;",
      garbageValue = "-1503945872"
   )
   static class78[] method681() {
      class78[] var0 = new class78[class76.field1368];

      for(int var1 = 0; var1 < class76.field1368; ++var1) {
         class78 var2 = var0[var1] = new class78();
         var2.field1387 = class76.field1364;
         var2.field1388 = class129.field2027;
         var2.field1385 = class76.field1366[var1];
         var2.field1382 = class76.field1367[var1];
         var2.field1383 = class52.field1145[var1];
         var2.field1384 = class76.field1371[var1];
         int var3 = var2.field1384 * var2.field1383;
         byte[] var4 = client.field557[var1];
         var2.field1392 = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.field1392[var5] = class227.field3220[var4[var5] & 255];
         }
      }

      class157.method3133();
      return var0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2032491781"
   )
   static int method689(int var0, int var1) {
      class15 var2 = (class15)class15.field210.method3742((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.field211.length?var2.field211[var1]:-1);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass167;III)Z",
      garbageValue = "-1671517271"
   )
   static boolean method691(class167 var0, int var1, int var2) {
      byte[] var3 = var0.method3217(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         class4.method37(var3);
         return true;
      }
   }
}
