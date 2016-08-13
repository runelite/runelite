import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
public class class133 {
   @ObfuscatedName("nn")
   @ObfuscatedGetter(
      intValue = -1706500535
   )
   static int field2106;
   @ObfuscatedName("g")
   public static final class133 field2107 = new class133(1);
   @ObfuscatedName("r")
   public static final class133 field2108 = new class133(2);
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 388134783
   )
   public final int field2109;
   @ObfuscatedName("l")
   public static final class133 field2110 = new class133(0);
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1448891525
   )
   static int field2112;

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class133(int var1) {
      this.field2109 = var1;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1342484159"
   )
   static final void method2976() {
      int var0 = class13.menuX;
      int var1 = class14.menuY;
      int var2 = Item.menuWidth;
      int var3 = class77.menuHeight;
      int var4 = 6116423;
      class82.method1907(var0, var1, var2, var3, var4);
      class82.method1907(1 + var0, var1 + 1, var2 - 2, 16, 0);
      class82.method1893(1 + var0, var1 + 18, var2 - 2, var3 - 19, 0);
      class59.field1268.method4170("Choose Option", var0 + 3, var1 + 14, var4, -1);
      int var5 = class143.field2206;
      int var6 = class143.field2209;

      for(int var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         int var8 = (Client.menuOptionCount - 1 - var7) * 15 + var1 + 31;
         int var9 = 16777215;
         if(var5 > var0 && var5 < var2 + var0 && var6 > var8 - 13 && var6 < var8 + 3) {
            var9 = 16776960;
         }

         class59.field1268.method4170(Tile.method2382(var7), var0 + 3, var8, var9, 0);
      }

      XItemContainer.method187(class13.menuX, class14.menuY, Item.menuWidth, class77.menuHeight);
   }
}
