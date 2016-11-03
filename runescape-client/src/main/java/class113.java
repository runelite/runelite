import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
public final class class113 {
   @ObfuscatedName("m")
   byte[] field1971;
   @ObfuscatedName("q")
   final int field1972 = 16;
   @ObfuscatedName("f")
   final int field1973 = 258;
   @ObfuscatedName("c")
   final int field1974 = 6;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1112368463
   )
   int field1975;
   @ObfuscatedName("j")
   final int field1976 = 18002;
   @ObfuscatedName("z")
   int[] field1977 = new int[256];
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 620521849
   )
   int field1978 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 867157913
   )
   int field1979;
   @ObfuscatedName("av")
   byte[] field1980 = new byte[256];
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1984373389
   )
   int field1981;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 801314529
   )
   int field1982;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -621017241
   )
   int field1983;
   @ObfuscatedName("e")
   byte field1984;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -886310069
   )
   int field1985;
   @ObfuscatedName("v")
   final int field1986 = 50;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1232703813
   )
   int field1987 = 0;
   @ObfuscatedName("k")
   final int field1988 = 4096;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -186911839
   )
   int field1989;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1687531009
   )
   int field1990;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2118019877
   )
   int field1991;
   @ObfuscatedName("ar")
   int[] field1992 = new int[6];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 71148601
   )
   int field1993;
   @ObfuscatedName("d")
   int[] field1994 = new int[257];
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 80363865
   )
   int field1995;
   @ObfuscatedName("aq")
   boolean[] field1996 = new boolean[256];
   @ObfuscatedName("al")
   boolean[] field1997 = new boolean[16];
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1381288949
   )
   int field1998;
   @ObfuscatedName("ad")
   byte[] field1999 = new byte[4096];
   @ObfuscatedName("at")
   int[] field2000 = new int[16];
   @ObfuscatedName("aj")
   byte[] field2001 = new byte[18002];
   @ObfuscatedName("am")
   byte[] field2002 = new byte[18002];
   @ObfuscatedName("ay")
   byte[][] field2003 = new byte[6][258];
   @ObfuscatedName("ag")
   int[][] field2004 = new int[6][258];
   @ObfuscatedName("aa")
   int[][] field2005 = new int[6][258];
   @ObfuscatedName("h")
   byte[] field2006;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -836001013
   )
   int field2008;
   @ObfuscatedName("ak")
   int[][] field2011 = new int[6][258];

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass170;Lclass170;ZIB)V",
      garbageValue = "16"
   )
   static void method2488(Component var0, class170 var1, class170 var2, boolean var3, int var4) {
      if(class33.field745) {
         if(var4 == 4) {
            class33.loginIndex = 4;
         }

      } else {
         class33.loginIndex = var4;
         class82.method1867();
         byte[] var5 = var1.method3297("title.jpg", "");
         class33.field748 = new SpritePixels(var5, var0);
         class33.field732 = class33.field748.method1749();
         if((Client.flags & 536870912) != 0) {
            class33.field733 = VertexNormal.method2267(var2, "logo_deadman_mode", "");
         } else {
            class33.field733 = VertexNormal.method2267(var2, "logo", "");
         }

         class33.field730 = VertexNormal.method2267(var2, "titlebox", "");
         class232.field3280 = VertexNormal.method2267(var2, "titlebutton", "");
         class14.field209 = class48.method984(var2, "runes", "");
         class5.field76 = class48.method984(var2, "title_mute", "");
         Ignore.field128 = VertexNormal.method2267(var2, "options_radio_buttons,0", "");
         class50.field1109 = VertexNormal.method2267(var2, "options_radio_buttons,2", "");
         class23.field594 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class23.field594[var6] = var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class23.field594[var6 + 64] = var6 * 1024 + 16711680;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class23.field594[var6 + 128] = 16776960 + var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class23.field594[var6 + 192] = 16777215;
         }

         class33.field738 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field738[var6] = var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field738[var6 + 64] = '\uff00' + 4 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field738[128 + var6] = var6 * 262144 + '\uffff';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class33.field738[192 + var6] = 16777215;
         }

         class21.field582 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class21.field582[var6] = var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class21.field582[64 + var6] = 262144 * var6 + 255;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class21.field582[var6 + 128] = 16711935 + 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class21.field582[var6 + 192] = 16777215;
         }

         class178.field2945 = new int[256];
         class217.field3202 = new int['耀'];
         class31.field715 = new int['耀'];
         XItemContainer.method160((ModIcon)null);
         class9.field153 = new int['耀'];
         class33.field741 = new int['耀'];
         if(var3) {
            class33.username = "";
            class33.field754 = "";
         }

         class33.field756 = 0;
         class23.authCode = "";
         class33.field757 = true;
         class33.worldSelectShown = false;
         if(!class130.field2102.field140) {
            class171 var9 = Client.field423;
            int var7 = var9.method3327("scape main");
            int var8 = var9.method3325(var7, "");
            class162.method3196(2, var9, var7, var8, 255, false);
         } else {
            XItemContainer.method167(2);
         }

         class125.method2808(false);
         class33.field745 = true;
         class33.field729 = (GroundObject.field1652 - Client.field495) / 2;
         class33.loginWindowX = class33.field729 + 202;
         class33.field748.method1767(class33.field729, 0);
         class33.field732.method1767(382 + class33.field729, 0);
         class33.field733.method1911(382 + class33.field729 - class33.field733.originalWidth / 2, 18);
      }
   }
}
