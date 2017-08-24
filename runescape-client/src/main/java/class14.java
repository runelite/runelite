import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
public class class14 {
   @ObfuscatedName("v")
   static int[][][] field300;
   @ObfuscatedName("o")
   String field294;
   @ObfuscatedName("r")
   String field297;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 5726933110767021897L
   )
   public final long field295;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -844894711
   )
   public final int field298;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lz;"
   )
   public final GrandExchangeOffer field296;

   @ObfuscatedSignature(
      signature = "(Lfp;BI)V"
   )
   class14(Buffer var1, byte var2, int var3) {
      this.field297 = var1.readString();
      this.field294 = var1.readString();
      this.field298 = var1.readUnsignedShort();
      this.field295 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.field296 = new GrandExchangeOffer();
      this.field296.method127(2);
      this.field296.method115(var2);
      this.field296.price = var4;
      this.field296.totalQuantity = var5;
      this.field296.quantitySold = 0;
      this.field296.spent = 0;
      this.field296.itemId = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-2137966317"
   )
   public String method88() {
      return this.field297;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1124352196"
   )
   public String method91() {
      return this.field294;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "8"
   )
   static final boolean method92() {
      return class133.field2011;
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "118"
   )
   static final void method87(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field1065; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field966[var4] = true;
         }
      }

   }
}
