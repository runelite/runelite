import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public final class class8 extends class9 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 480848205
   )
   final int field243;
   @ObfuscatedName("c")
   static IndexDataBase field244;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1299512575
   )
   final int field245;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 668353969
   )
   final int field246;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 145028369
   )
   final int field247;
   @ObfuscatedName("i")
   public static short[][] field249;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1233833441
   )
   final int field251;

   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "(LWidget;II)Ljava/lang/String;",
      garbageValue = "-1592171908"
   )
   static String method40(Widget var0, int var1) {
      int var2 = class15.method92(var0);
      boolean var3 = (var2 >> var1 + 1 & 1) != 0;
      return !var3 && var0.field2657 == null?null:(var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-4"
   )
   public final void vmethod55() {
      Rasterizer2D.method4888(this.field251 + Rasterizer2D.field3752, this.field243 + Rasterizer2D.drawingAreaTop, this.field247 - this.field251, this.field245 - this.field243, this.field246);
   }

   class8(int var1, int var2, int var3, int var4, int var5) {
      this.field251 = var1;
      this.field243 = var2;
      this.field247 = var3;
      this.field245 = var4;
      this.field246 = var5;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "-764108374"
   )
   public static void method43(String var0, Throwable var1) {
      var1.printStackTrace();
   }
}
