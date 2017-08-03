import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class14 {
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = 1793916571
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = 1627705121
   )
   @Export("menuHeight")
   static int menuHeight;
   @ObfuscatedName("e")
   String field281;
   @ObfuscatedName("y")
   String field280;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = 7040212038536650279L
   )
   public final long field278;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 724043817
   )
   public final int field277;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lw;"
   )
   public final XGrandExchangeOffer field279;

   @ObfuscatedSignature(
      signature = "(Lfw;BI)V"
   )
   class14(Buffer var1, byte var2, int var3) {
      this.field280 = var1.readString();
      this.field281 = var1.readString();
      this.field277 = var1.readUnsignedShort();
      this.field278 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.field279 = new XGrandExchangeOffer();
      this.field279.method101(2);
      this.field279.method100(var2);
      this.field279.price = var4;
      this.field279.totalQuantity = var5;
      this.field279.quantitySold = 0;
      this.field279.spent = 0;
      this.field279.itemId = var3;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-28"
   )
   public String method79() {
      return this.field280;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "112"
   )
   public String method83() {
      return this.field281;
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(Lcy;III)V",
      garbageValue = "1831874412"
   )
   static final void method78(class89 var0, int var1, int var2) {
      class214.menuAction(var0.field1373, var0.field1366, var0.field1367, var0.field1371, var0.field1369, var0.field1369, var1, var2);
   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1672276155"
   )
   static final void method86(int var0, int var1) {
      if(class7.loadWidget(var0)) {
         class73.method1143(class170.widgets[var0], var1);
      }
   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(I)Lkl;",
      garbageValue = "1616513732"
   )
   static RenderOverview method80() {
      return class7.renderOverview;
   }
}
