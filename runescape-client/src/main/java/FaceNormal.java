import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = -1169588033
   )
   static int field1583;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 448217247
   )
   @Export("z")
   int z;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 754299569
   )
   @Export("x")
   int x;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1047901595
   )
   @Export("y")
   int y;
   @ObfuscatedName("qi")
   static class109 field1590;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1969238286"
   )
   static void method1931(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.method2417((long)var0);
      if(var4 == null) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.method2418(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)LWidget;",
      garbageValue = "224315095"
   )
   public static Widget method1932(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(Widget.widgets[var1] == null || Widget.widgets[var1][var2] == null) {
         boolean var3 = Ignore.method178(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-723041870"
   )
   static final String method1933(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + XItemContainer.method153('ﾀ') + var1.substring(0, var1.length() - 8) + "M  (" + var1 + ")</col>":(var1.length() > 6?" " + XItemContainer.method153(16777215) + var1.substring(0, var1.length() - 4) + "K  (" + var1 + ")</col>":" " + XItemContainer.method153(16776960) + var1 + "</col>");
   }
}
