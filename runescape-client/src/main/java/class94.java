import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("DecorativeObject")
public final class class94 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 968174999
   )
   @Export("floor")
   int field1613;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1447335613
   )
   @Export("x")
   int field1614;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -38505297
   )
   @Export("y")
   int field1615;
   @ObfuscatedName("d")
   @Export("renderable2")
   public class85 field1616;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 807137529
   )
   int field1617;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1390120507
   )
   int field1618;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 9519993
   )
   @Export("hash")
   public int field1619 = 0;
   @ObfuscatedName("s")
   @Export("renderable1")
   public class85 field1620;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1604663101
   )
   int field1621;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -480786221
   )
   int field1623 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 972478267
   )
   int field1625;

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-2"
   )
   static void method2124() {
      int var0 = class144.field2226;
      int var1 = class144.field2242;
      int var2 = class126.field2049 - class10.field162 - var0;
      int var3 = class109.field1915 - class41.field966 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = client.field280.method3051();
            int var5 = 0;
            int var6 = 0;
            if(class43.field1022 == var4) {
               Insets var7 = class43.field1022.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class109.field1915);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class126.field2049, var1);
            }

            if(var2 > 0) {
               var9.fillRect(var5 + class126.field2049 - var2, var6, var2, class109.field1915);
            }

            if(var3 > 0) {
               var9.fillRect(var5, var6 + class109.field1915 - var3, class126.field2049, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }
}
