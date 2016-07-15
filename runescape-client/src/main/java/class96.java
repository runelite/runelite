import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("GroundObject")
public final class class96 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -605462743
   )
   int field1658;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2009493337
   )
   @Export("y")
   int field1659;
   @ObfuscatedName("h")
   @Export("renderable")
   public class88 field1660;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 152061983
   )
   @Export("hash")
   public int field1661;
   @ObfuscatedName("dy")
   static byte[][] field1662;
   @ObfuscatedName("nk")
   @ObfuscatedGetter(
      intValue = -1490173559
   )
   static int field1663;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1995059607
   )
   @Export("floor")
   int field1665;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 813545765
   )
   @Export("x")
   int field1668;

   @ObfuscatedName("ef")
   @ObfuscatedSignature(
      signature = "(Lclass176;IB)Ljava/lang/String;",
      garbageValue = "-68"
   )
   static String method2258(class176 var0, int var1) {
      return !class54.method1150(class27.method644(var0), var1) && null == var0.field2894?null:(null != var0.field2868 && var0.field2868.length > var1 && var0.field2868[var1] != null && var0.field2868[var1].trim().length() != 0?var0.field2868[var1]:null);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;Lclass170;I)V",
      garbageValue = "831668466"
   )
   public static void method2259(class170 var0, class170 var1, class170 var2) {
      class44.field1031 = var0;
      class44.field1020 = var1;
      class44.field1026 = var2;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-1984683139"
   )
   static final void method2260(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = class104.field1834.method4109(var0, 250);
      int var6 = class104.field1834.method4110(var0, 250) * 13;
      class82.method1911(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var2 + var6, 0);
      class82.method1925(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6, 16777215);
      class104.field1834.method4116(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class8.method104(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2);
      if(var1) {
         try {
            Graphics var7 = class158.field2346.getGraphics();
            class44.field1039.vmethod1975(var7, 0, 0);
         } catch (Exception var8) {
            class158.field2346.repaint();
         }
      } else {
         class26.method600(var3, var4, var5, var6);
      }

   }
}
