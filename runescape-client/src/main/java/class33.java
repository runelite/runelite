import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class33 {
   @ObfuscatedName("x")
   @Export("userHome")
   static String userHome;
   @ObfuscatedName("d")
   public static boolean field472;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -301076189
   )
   static int field469;
   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("indexTrack2")
   static IndexData indexTrack2;
   @ObfuscatedName("o")
   static int[] field473;
   @ObfuscatedName("e")
   String field471;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lj;"
   )
   class24 field477;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -800640515
   )
   int field470;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 238423427
   )
   int field478;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IILj;)V"
   )
   class33(String var1, int var2, int var3, class24 var4) {
      this.field471 = var1;
      this.field470 = var2;
      this.field478 = var3;
      this.field477 = var4;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "-12"
   )
   static final void method352(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int[] var7 = Region.method2763(var0, var1, var2);
      int[] var8 = Region.method2763(var3, var4, var5);
      Rasterizer2D.drawLine(var7[0], var7[1], var8[0], var8[1], var6);
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-1372574044"
   )
   @Export("drawWidget")
   static final void drawWidget(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class10.loadWidget(var0)) {
         Player.field906 = null;
         WorldMapType3.gameDraw(Item.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(Player.field906 != null) {
            WorldMapType3.gameDraw(Player.field906, -1412584499, var1, var2, var3, var4, class14.field295, class91.field1399, var7);
            Player.field906 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1107[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1107[var8] = true;
            }
         }

      }
   }
}
