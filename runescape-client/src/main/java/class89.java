import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
public class class89 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1322101193
   )
   int field1402;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 882471429
   )
   int field1399;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 473556583
   )
   int field1400;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1417670369
   )
   int field1403;
   @ObfuscatedName("v")
   String field1401;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lbf;I)V",
      garbageValue = "1209899171"
   )
   public static void method1689(ScriptEvent var0) {
      IndexFile.method3018(var0, 200000);
   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-2023080400"
   )
   @Export("drawStatusBox")
   static final void drawStatusBox(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = class5.font_p12full.method4674(var0, 250);
      int var6 = class5.font_p12full.method4675(var0, 250) * 13;
      Rasterizer2D.method4921(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6, 0);
      Rasterizer2D.drawRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6, 16777215);
      class5.font_p12full.method4681(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class39.method549(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6);
      if(var1) {
         GZipDecompressor.field2327.vmethod4942(0, 0);
      } else {
         int var7 = var3;
         int var8 = var4;
         int var9 = var5;
         int var10 = var6;

         for(int var11 = 0; var11 < Client.field1006; ++var11) {
            if(Client.widgetPositionX[var11] + Client.widgetBoundsWidth[var11] > var7 && Client.widgetPositionX[var11] < var9 + var7 && Client.widgetBoundsHeight[var11] + Client.widgetPositionY[var11] > var8 && Client.widgetPositionY[var11] < var10 + var8) {
               Client.field1112[var11] = true;
            }
         }
      }

   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(Lhy;I)Lhy;",
      garbageValue = "-2067760955"
   )
   static Widget method1688(Widget var0) {
      Widget var1 = class77.method1480(var0);
      if(var1 == null) {
         var1 = var0.dragParent;
      }

      return var1;
   }
}
