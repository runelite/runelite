import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class14 {
   @ObfuscatedName("b")
   String field284;
   @ObfuscatedName("bs")
   static ModIcon[] field285;
   @ObfuscatedName("e")
   public final XGrandExchangeOffer field286;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -563613447
   )
   public final int field288;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = -8083564129742579667L
   )
   public final long field290;
   @ObfuscatedName("v")
   String field293;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "843001575"
   )
   public String method70() {
      return this.field284;
   }

   class14(Buffer var1, byte var2, int var3) {
      this.field293 = var1.readString();
      this.field284 = var1.readString();
      this.field288 = var1.readUnsignedShort();
      this.field290 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.field286 = new XGrandExchangeOffer();
      this.field286.method95(2);
      this.field286.method88(var2);
      this.field286.price = var4;
      this.field286.totalQuantity = var5;
      this.field286.quantitySold = 0;
      this.field286.spent = 0;
      this.field286.itemId = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1773514553"
   )
   public String method72() {
      return this.field293;
   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "700912425"
   )
   static final void method74(Widget var0, int var1, int var2) {
      if(Client.field1164 == null && !Client.isMenuOpen) {
         if(var0 != null && class60.method1005(var0) != null) {
            Client.field1164 = var0;
            Client.field1104 = class60.method1005(var0);
            Client.field1105 = var1;
            Client.field1141 = var2;
            class64.field799 = 0;
            Client.field1114 = false;
            int var3 = class67.method1080();
            if(var3 != -1) {
               class20.field319 = new class89();
               class20.field319.field1428 = Client.menuActionParams0[var3];
               class20.field319.field1421 = Client.menuActionParams1[var3];
               class20.field319.field1420 = Client.menuTypes[var3];
               class20.field319.field1423 = Client.menuIdentifiers[var3];
               class20.field319.field1422 = Client.menuOptions[var3];
            }

         }
      }
   }
}
