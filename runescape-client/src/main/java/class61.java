import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
public final class class61 {
   @ObfuscatedName("lq")
   @ObfuscatedSignature(
      signature = "Lcb;"
   )
   @Export("chatMessages")
   static Varcs chatMessages;
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = -358234779
   )
   static int field693;
   @ObfuscatedName("p")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("i")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 367183531
   )
   static int field686;
   @ObfuscatedName("j")
   static byte[][][] field687;
   @ObfuscatedName("a")
   static byte[][][] field688;
   @ObfuscatedName("x")
   static int[] field685;
   @ObfuscatedName("n")
   static int[][][] field690;
   @ObfuscatedName("f")
   static final int[] field698;
   @ObfuscatedName("k")
   static final int[] field697;
   @ObfuscatedName("e")
   static final int[] field694;
   @ObfuscatedName("u")
   static final int[] field695;
   @ObfuscatedName("g")
   static final int[] field696;
   @ObfuscatedName("z")
   static final int[] field692;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 515727351
   )
   static int field699;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -487119341
   )
   static int field684;
   @ObfuscatedName("bz")
   @Export("sessionToken")
   static String sessionToken;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field686 = 99;
      field698 = new int[]{1, 2, 4, 8};
      field697 = new int[]{16, 32, 64, 128};
      field694 = new int[]{1, 0, -1, 0};
      field695 = new int[]{0, -1, 0, 1};
      field696 = new int[]{1, -1, -1, 1};
      field692 = new int[]{-1, -1, 1, 1};
      field699 = (int)(Math.random() * 17.0D) - 8;
      field684 = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "26"
   )
   static int method1046() {
      return ++class94.field1402 - 1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "2002602832"
   )
   public static String method1049(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.' && var4 != '-' && var4 != '*' && var4 != '_') {
            if(var4 == ' ') {
               var2.append('+');
            } else {
               byte var5 = WorldComparator.charToByteCp1252(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-1"
   )
   public static int method1026() {
      return KeyFocusListener.keyboardIdleTicks;
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1476578031"
   )
   static void method1048() {
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
   }
}
