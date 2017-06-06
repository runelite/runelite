import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
final class class18 implements Comparator {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1326379815
   )
   protected static int field311;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -189313039
   )
   static int field312;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "-725413894"
   )
   int method111(class14 var1, class14 var2) {
      return var1.method72().compareTo(var2.method72());
   }

   public int compare(Object var1, Object var2) {
      return this.method111((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1434145207"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      class151.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-1099162138"
   )
   static final void method118(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var2 - var0;
      int var7 = var3 - var1;
      int var8 = var6 >= 0?var6:-var6;
      int var9 = var7 >= 0?var7:-var7;
      int var10 = var8;
      if(var8 < var9) {
         var10 = var9;
      }

      if(var10 != 0) {
         int var11 = (var6 << 16) / var10;
         int var12 = (var7 << 16) / var10;
         if(var12 <= var11) {
            var11 = -var11;
         } else {
            var12 = -var12;
         }

         int var13 = var5 * var12 >> 17;
         int var14 = var5 * var12 + 1 >> 17;
         int var15 = var11 * var5 >> 17;
         int var16 = var5 * var11 + 1 >> 17;
         var0 -= Rasterizer2D.field3757;
         var1 -= Rasterizer2D.field3752;
         int var17 = var13 + var0;
         int var18 = var0 - var14;
         int var19 = var0 + var6 - var14;
         int var20 = var13 + var6 + var0;
         int var21 = var1 + var15;
         int var22 = var1 - var16;
         int var23 = var7 + var1 - var16;
         int var24 = var7 + var1 + var15;
         class136.setRasterClippingEnabled(var17, var18, var19);
         class136.rasterFlat(var21, var22, var23, var17, var18, var19, var4);
         class136.setRasterClippingEnabled(var17, var19, var20);
         class136.rasterFlat(var21, var23, var24, var17, var19, var20, var4);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1687748341"
   )
   public static void method119() {
      NPCComposition.field3547.reset();
      NPCComposition.npcModelCache.reset();
   }
}
