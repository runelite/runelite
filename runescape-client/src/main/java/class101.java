import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("GameObject")
public final class class101 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 196583627
   )
   int field1729;
   @ObfuscatedName("r")
   @Export("renderable")
   public class88 field1730;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 604617205
   )
   @Export("x")
   int field1731;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -463504105
   )
   @Export("flags")
   int field1732 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1439893337
   )
   @Export("plane")
   int field1733;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -846595585
   )
   @Export("orientation")
   int field1734;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1649953965
   )
   @Export("relativeX")
   int field1735;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -411631429
   )
   @Export("offsetX")
   int field1736;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1959022611
   )
   @Export("relativeY")
   int field1737;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1964533543
   )
   @Export("offsetY")
   int field1738;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -571555419
   )
   @Export("height")
   int field1739;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 811783885
   )
   int field1740;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1644114939
   )
   @Export("hash")
   public int field1741 = 0;
   @ObfuscatedName("x")
   public static String[] field1742;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1042722935
   )
   @Export("y")
   int field1743;
   @ObfuscatedName("v")
   static int[] field1744;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -267011117
   )
   static int field1745;
   @ObfuscatedName("em")
   static class81[] field1747;

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1458795280"
   )
   static void method2285() {
      int var0 = class147.field2249;
      int var1 = class147.field2250;
      int var2 = class116.field2025 - class142.field2191 - var0;
      int var3 = class16.field246 - class132.field2109 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = client.field289.method3122();
            int var5 = 0;
            int var6 = 0;
            if(class105.field1845 == var4) {
               Insets var7 = class105.field1845.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class16.field246);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class116.field2025, var1);
            }

            if(var2 > 0) {
               var9.fillRect(var5 + class116.field2025 - var2, var6, var2, class16.field246);
            }

            if(var3 > 0) {
               var9.fillRect(var5, class16.field246 + var6 - var3, class116.field2025, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "2113695815"
   )
   public static boolean method2286(int var0) {
      return (var0 >> 31 & 1) != 0;
   }
}
