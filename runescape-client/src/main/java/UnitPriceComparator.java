import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
@Implements("UnitPriceComparator")
final class UnitPriceComparator implements Comparator {
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      intValue = -276451405
   )
   static int field294;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   @Export("seq_ref")
   public static IndexDataBase seq_ref;
   @ObfuscatedName("x")
   @Export("audioHighMemory")
   public static boolean audioHighMemory;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   @Export("widgetIndex")
   public static IndexDataBase widgetIndex;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ll;Ll;I)I",
      garbageValue = "215643968"
   )
   int method126(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.price < var2.grandExchangeOffer.price?-1:(var2.grandExchangeOffer.price == var1.grandExchangeOffer.price?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method126((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljm;I)V",
      garbageValue = "-105858561"
   )
   public static void method128(IndexDataBase var0) {
      Enum.EnumDefinition_indexCache = var0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-1984723451"
   )
   public static int method139(String var0) {
      return var0.length() + 2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-913678176"
   )
   public static void method140() {
      Widget.field2808.reset();
      Widget.Widget_cachedModels.reset();
      Widget.Widget_cachedFonts.reset();
      Widget.field2858.reset();
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "1886255408"
   )
   static final void method138(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(Name.loadWidget(var0)) {
         Client.field1095 = null;
         VarCString.gameDraw(class189.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(Client.field1095 != null) {
            VarCString.gameDraw(Client.field1095, -1412584499, var1, var2, var3, var4, WorldMapManager.field537, SoundTask.field1582, var7);
            Client.field1095 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1060[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1060[var8] = true;
            }
         }

      }
   }
}
