import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public class class14 {
   @ObfuscatedName("v")
   String field300;
   @ObfuscatedName("r")
   String field299;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 1346984612903991971L
   )
   public final long field296;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -230433603
   )
   public final int field301;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   public final XGrandExchangeOffer field297;

   @ObfuscatedSignature(
      signature = "(Lfe;BI)V"
   )
   class14(Buffer var1, byte var2, int var3) {
      this.field299 = var1.readString();
      this.field300 = var1.readString();
      this.field301 = var1.readUnsignedShort();
      this.field296 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.field297 = new XGrandExchangeOffer();
      this.field297.method114(2);
      this.field297.method111(var2);
      this.field297.price = var4;
      this.field297.totalQuantity = var5;
      this.field297.quantitySold = 0;
      this.field297.spent = 0;
      this.field297.itemId = var3;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1827097735"
   )
   public String method79() {
      return this.field299;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1456592655"
   )
   public String method83() {
      return this.field300;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1477968803"
   )
   protected static final void method78() {
      class48.timer.vmethod2974();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field690[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field700[var0] = 0L;
      }

      class277.field3737 = 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lif;Lif;I)I",
      garbageValue = "1402451631"
   )
   static int method86(IndexDataBase var0, IndexDataBase var1) {
      int var2 = 0;
      if(var0.method4101("title.jpg", "")) {
         ++var2;
      }

      if(var1.method4101("logo", "")) {
         ++var2;
      }

      if(var1.method4101("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method4101("titlebox", "")) {
         ++var2;
      }

      if(var1.method4101("titlebutton", "")) {
         ++var2;
      }

      if(var1.method4101("runes", "")) {
         ++var2;
      }

      if(var1.method4101("title_mute", "")) {
         ++var2;
      }

      if(var1.method4101("options_radio_buttons,0", "")) {
         ++var2;
      }

      if(var1.method4101("options_radio_buttons,2", "")) {
         ++var2;
      }

      var1.method4101("sl_back", "");
      var1.method4101("sl_flags", "");
      var1.method4101("sl_arrows", "");
      var1.method4101("sl_stars", "");
      var1.method4101("sl_button", "");
      return var2;
   }
}
