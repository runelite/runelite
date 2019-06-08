import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public final class class68 extends Node {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1439936951
   )
   int field911;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1471611383
   )
   int field906;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1059464897
   )
   int field913;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1306474107
   )
   int field901;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1889242993
   )
   int field903;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 318288659
   )
   int field904;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 629071861
   )
   int field905;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1986990761
   )
   int field899;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1768602131
   )
   int field907;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1989829133
   )
   int field908;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -715662659
   )
   int field909;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2141472019
   )
   int field910;

   class68() {
      this.field909 = 0;
      this.field910 = -1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "100"
   )
   public static void method1694() {
      class322.reflectionChecks = new IterableNodeDeque();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1641191614"
   )
   public static void method1695(int var0, int var1) {
      VarbitDefinition var2 = Occluder.method3255(var0);
      int var3 = var2.varp;
      int var4 = var2.lowBit;
      int var5 = var2.highBit;
      int var6 = Varps.Varps_masks[var5 - var4];
      if(var1 < 0 || var1 > var6) {
         var1 = 0;
      }

      var6 <<= var4;
      Varps.Varps_main[var3] = Varps.Varps_main[var3] & ~var6 | var1 << var4 & var6;
   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-1792684945"
   )
   @Export("drawLoadingMessage")
   static final void drawLoadingMessage(String var0, boolean var1) {
      if(Client.showLoadingMessages) {
         byte var2 = 4;
         int var3 = var2 + 6;
         int var4 = var2 + 6;
         int var5 = DevicePcmPlayerProvider.fontPlain12.lineWidth(var0, 250);
         int var6 = DevicePcmPlayerProvider.fontPlain12.lineCount(var0, 250) * 13;
         Rasterizer2D.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
         Rasterizer2D.Rasterizer2D_drawRectangle(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var2 + var6, 16777215);
         DevicePcmPlayerProvider.fontPlain12.drawLines(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
         Players.method2112(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2);
         if(var1) {
            class197.rasterProvider.drawFull(0, 0);
         } else {
            int var7 = var3;
            int var8 = var4;
            int var9 = var5;
            int var10 = var6;

            for(int var11 = 0; var11 < Client.rootWidgetCount; ++var11) {
               if(Client.rootWidgetWidths[var11] + Client.rootWidgetXs[var11] > var7 && Client.rootWidgetXs[var11] < var9 + var7 && Client.rootWidgetHeights[var11] + Client.rootWidgetYs[var11] > var8 && Client.rootWidgetYs[var11] < var10 + var8) {
                  Client.__client_ot[var11] = true;
               }
            }
         }

      }
   }
}
