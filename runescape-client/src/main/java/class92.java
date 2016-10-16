import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
public final class class92 {
   @ObfuscatedName("cm")
   static class227 field1590;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1055570579
   )
   int field1591;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1153173659
   )
   int field1592;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 169634869
   )
   int field1593;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 743884603
   )
   int field1594;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1052091565
   )
   int field1596;
   @ObfuscatedName("x")
   static String field1598;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1428870223
   )
   int field1599;
   @ObfuscatedName("g")
   boolean field1600 = true;

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class92(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1592 = var1;
      this.field1599 = var2;
      this.field1591 = var3;
      this.field1593 = var4;
      this.field1594 = var5;
      this.field1596 = var6;
      this.field1600 = var7;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)LWidget;",
      garbageValue = "1221487957"
   )
   public static Widget method2078(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(Widget.widgets[var1] == null || Widget.widgets[var1][var2] == null) {
         boolean var3 = class174.method3393(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }
}
