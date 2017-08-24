import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
final class class12 implements Comparator {
   @ObfuscatedName("ju")
   @ObfuscatedGetter(
      intValue = -569190743
   )
   @Export("menuHeight")
   static int menuHeight;
   @ObfuscatedName("le")
   @ObfuscatedGetter(
      intValue = -28199497
   )
   static int field280;
   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "[Lkd;"
   )
   @Export("hitmarks")
   static SpritePixels[] hitmarks;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lv;Lv;I)I",
      garbageValue = "-868324621"
   )
   int method66(class14 var1, class14 var2) {
      return var1.field298 < var2.field298?-1:(var2.field298 == var1.field298?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method66((class14)var1, (class14)var2);
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(IIIILkd;Lhc;I)V",
      garbageValue = "-1417107318"
   )
   static final void method68(int var0, int var1, int var2, int var3, SpritePixels var4, class211 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle & 2047;
         int var8 = Graphics3D.SINE[var7];
         int var9 = Graphics3D.COSINE[var7];
         int var10 = var3 * var8 + var9 * var2 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = var5.field2600 / 2 - 25;
         int var15 = (int)(Math.sin(var12) * (double)var14);
         int var16 = (int)(Math.cos(var12) * (double)var14);
         byte var17 = 20;
         Friend.mapedge.method5006(var15 + (var0 + var5.field2600 / 2 - var17 / 2), var5.field2599 / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
      } else {
         IndexData.drawDot(var0, var1, var2, var3, var4, var5);
      }

   }
}
