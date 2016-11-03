import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public class class157 implements class115 {
   @ObfuscatedName("ev")
   static SpritePixels field2325;
   @ObfuscatedName("q")
   static final class157 field2326 = new class157("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("f")
   static final class157 field2327 = new class157("game3", "Game 3", 2);
   @ObfuscatedName("m")
   public final String field2328;
   @ObfuscatedName("k")
   static final class157 field2329 = new class157("runescape", "RuneScape", 0);
   @ObfuscatedName("j")
   public static final class157 field2330 = new class157("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("c")
   static final class157 field2332 = new class157("game4", "Game 4", 3);
   @ObfuscatedName("v")
   static final class157 field2333 = new class157("game5", "Game 5", 4);
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1221535885
   )
   final int field2334;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-116"
   )
   public int vmethod3197() {
      return this.field2334;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class157(String var1, String var2, int var3) {
      this.field2328 = var1;
      this.field2334 = var3;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1302895751"
   )
   static final void method3190() {
      int var0 = Client.menuX;
      int var1 = class0.menuY;
      int var2 = class43.menuWidth;
      int var3 = class26.menuHeight;
      int var4 = 6116423;
      class82.method1885(var0, var1, var2, var3, var4);
      class82.method1885(var0 + 1, 1 + var1, var2 - 2, 16, 0);
      class82.method1845(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
      PlayerComposition.field2977.method4118("Choose Option", 3 + var0, 14 + var1, var4, -1);
      int var5 = class143.field2200;
      int var6 = class143.field2204;

      for(int var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         int var8 = var1 + 31 + 15 * (Client.menuOptionCount - 1 - var7);
         int var9 = 16777215;
         if(var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < var8 + 3) {
            var9 = 16776960;
         }

         class227 var10 = PlayerComposition.field2977;
         String var11;
         if(Client.menuTargets[var7].length() > 0) {
            var11 = Client.menuOptions[var7] + " " + Client.menuTargets[var7];
         } else {
            var11 = Client.menuOptions[var7];
         }

         var10.method4118(var11, 3 + var0, var8, var9, 0);
      }

      Buffer.method2597(Client.menuX, class0.menuY, class43.menuWidth, class26.menuHeight);
   }
}
