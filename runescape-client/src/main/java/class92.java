import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
public final class class92 {
   @ObfuscatedName("b")
   boolean field1598 = true;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2131263723
   )
   int field1599;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -454654979
   )
   int field1600;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1270858489
   )
   int field1601;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1092278449
   )
   int field1602;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1314804715
   )
   int field1603;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = -756332617
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 499614767
   )
   int field1606;
   @ObfuscatedName("ps")
   static short[] field1611;

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1870987184"
   )
   static int method2124() {
      return Client.isResized?2:1;
   }

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class92(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1602 = var1;
      this.field1606 = var2;
      this.field1599 = var3;
      this.field1600 = var4;
      this.field1601 = var5;
      this.field1603 = var6;
      this.field1598 = var7;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-2074829828"
   )
   public static void method2125(Component var0) {
      var0.removeKeyListener(class140.keyboard);
      var0.removeFocusListener(class140.keyboard);
      class140.field2170 = -1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1623355749"
   )
   static final void method2126(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class5.tileHeights[var0][var3 + var1][var2 + var4] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class5.tileHeights[var0][var1][var2 + var3] = class5.tileHeights[var0][var1 - 1][var2 + var3];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class5.tileHeights[var0][var3 + var1][var2] = class5.tileHeights[var0][var1 + var3][var2 - 1];
         }
      }

      if(var1 > 0 && class5.tileHeights[var0][var1 - 1][var2] != 0) {
         class5.tileHeights[var0][var1][var2] = class5.tileHeights[var0][var1 - 1][var2];
      } else if(var2 > 0 && class5.tileHeights[var0][var1][var2 - 1] != 0) {
         class5.tileHeights[var0][var1][var2] = class5.tileHeights[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class5.tileHeights[var0][var1 - 1][var2 - 1] != 0) {
         class5.tileHeights[var0][var1][var2] = class5.tileHeights[var0][var1 - 1][var2 - 1];
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1618145191"
   )
   static final void method2127() {
      if(class138.field2135 != null) {
         class138.field2135.method1215();
      }

      if(null != FaceNormal.field1492) {
         FaceNormal.field1492.method1215();
      }

   }
}
