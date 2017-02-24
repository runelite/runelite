import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public class class101 extends RuntimeException {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1585230683
   )
   static int field1655;
   @ObfuscatedName("q")
   static Applet field1657;
   @ObfuscatedName("p")
   String field1658;
   @ObfuscatedName("j")
   Throwable field1659;
   @ObfuscatedName("d")
   public static String field1660;
   @ObfuscatedName("ba")
   @Export("host")
   static String host;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILclass48;ZI)I",
      garbageValue = "18380328"
   )
   static int method2019(int var0, class48 var1, boolean var2) {
      Widget var3 = var2?XGrandExchangeOffer.field58:class24.field297;
      if(var0 == 1600) {
         class32.field747[++class103.field1686 - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 1601) {
         class32.field747[++class103.field1686 - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 1602) {
         class32.field748[++class32.field749 - 1] = var3.text;
         return 1;
      } else if(var0 == 1603) {
         class32.field747[++class103.field1686 - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 1604) {
         class32.field747[++class103.field1686 - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 1605) {
         class32.field747[++class103.field1686 - 1] = var3.field2259;
         return 1;
      } else if(var0 == 1606) {
         class32.field747[++class103.field1686 - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 1607) {
         class32.field747[++class103.field1686 - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 1608) {
         class32.field747[++class103.field1686 - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 1609) {
         class32.field747[++class103.field1686 - 1] = var3.opacity;
         return 1;
      } else if(var0 == 1610) {
         class32.field747[++class103.field1686 - 1] = var3.field2237;
         return 1;
      } else if(var0 == 1611) {
         class32.field747[++class103.field1686 - 1] = var3.textColor;
         return 1;
      } else if(var0 == 1612) {
         class32.field747[++class103.field1686 - 1] = var3.field2313;
         return 1;
      } else if(var0 == 1613) {
         class32.field747[++class103.field1686 - 1] = var3.field2235.vmethod4101();
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILclass48;ZI)I",
      garbageValue = "143377555"
   )
   static int method2020(int var0, class48 var1, boolean var2) {
      int var3;
      int var4;
      int var6;
      if(var0 == 3400) {
         class103.field1686 -= 2;
         var3 = class32.field747[class103.field1686];
         var4 = class32.field747[class103.field1686 + 1];
         class195 var5 = PlayerComposition.method3198(var3);
         if(var5.field2857 != 115) {
            ;
         }

         for(var6 = 0; var6 < var5.field2858; ++var6) {
            if(var5.field2862[var6] == var4) {
               class32.field748[++class32.field749 - 1] = var5.field2860[var6];
               var5 = null;
               break;
            }
         }

         if(var5 != null) {
            class32.field748[++class32.field749 - 1] = var5.field2861;
         }

         return 1;
      } else if(var0 != 3408) {
         return 2;
      } else {
         class103.field1686 -= 4;
         var3 = class32.field747[class103.field1686];
         var4 = class32.field747[class103.field1686 + 1];
         int var9 = class32.field747[2 + class103.field1686];
         var6 = class32.field747[3 + class103.field1686];
         class195 var7 = PlayerComposition.method3198(var9);
         if(var7.field2856 == var3 && var7.field2857 == var4) {
            for(int var8 = 0; var8 < var7.field2858; ++var8) {
               if(var6 == var7.field2862[var8]) {
                  if(var4 == 115) {
                     class32.field748[++class32.field749 - 1] = var7.field2860[var8];
                  } else {
                     class32.field747[++class103.field1686 - 1] = var7.field2865[var8];
                  }

                  var7 = null;
                  break;
               }
            }

            if(null != var7) {
               if(var4 == 115) {
                  class32.field748[++class32.field749 - 1] = var7.field2861;
               } else {
                  class32.field747[++class103.field1686 - 1] = var7.field2863;
               }
            }

            return 1;
         } else {
            if(var4 == 115) {
               class32.field748[++class32.field749 - 1] = "null";
            } else {
               class32.field747[++class103.field1686 - 1] = 0;
            }

            return 1;
         }
      }
   }
}
