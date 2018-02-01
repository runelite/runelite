import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
   @ObfuscatedName("pv")
   @ObfuscatedGetter(
      intValue = -2118148425
   )
   static int field294;
   @ObfuscatedName("r")
   static ScheduledExecutorService field295;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field297;
   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("socket")
   static Task socket;
   @ObfuscatedName("eq")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   @Export("fontPlain11")
   static Font fontPlain11;
   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "[Lko;"
   )
   @Export("headIconsPk")
   static SpritePixels[] headIconsPk;
   @ObfuscatedName("p")
   @Export("progress")
   byte progress;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -421167325
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1798796603
   )
   @Export("price")
   public int price;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -117398897
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -177841987
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2022385445
   )
   @Export("spent")
   public int spent;

   public GrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(Lgj;Z)V",
      garbageValue = "0"
   )
   public GrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1969117980"
   )
   @Export("status")
   public int status() {
      return this.progress & 7;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-128"
   )
   @Export("type")
   public int type() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2079213590"
   )
   void method126(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-25"
   )
   void method111(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-589564288"
   )
   static void method125() {
      if(class192.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
         KeyFocusListener.KeyHandler_keyCodes[186] = 57;
         KeyFocusListener.KeyHandler_keyCodes[187] = 27;
         KeyFocusListener.KeyHandler_keyCodes[188] = 71;
         KeyFocusListener.KeyHandler_keyCodes[189] = 26;
         KeyFocusListener.KeyHandler_keyCodes[190] = 72;
         KeyFocusListener.KeyHandler_keyCodes[191] = 73;
         KeyFocusListener.KeyHandler_keyCodes[192] = 58;
         KeyFocusListener.KeyHandler_keyCodes[219] = 42;
         KeyFocusListener.KeyHandler_keyCodes[220] = 74;
         KeyFocusListener.KeyHandler_keyCodes[221] = 43;
         KeyFocusListener.KeyHandler_keyCodes[222] = 59;
         KeyFocusListener.KeyHandler_keyCodes[223] = 28;
      } else {
         KeyFocusListener.KeyHandler_keyCodes[44] = 71;
         KeyFocusListener.KeyHandler_keyCodes[45] = 26;
         KeyFocusListener.KeyHandler_keyCodes[46] = 72;
         KeyFocusListener.KeyHandler_keyCodes[47] = 73;
         KeyFocusListener.KeyHandler_keyCodes[59] = 57;
         KeyFocusListener.KeyHandler_keyCodes[61] = 27;
         KeyFocusListener.KeyHandler_keyCodes[91] = 42;
         KeyFocusListener.KeyHandler_keyCodes[92] = 74;
         KeyFocusListener.KeyHandler_keyCodes[93] = 43;
         KeyFocusListener.KeyHandler_keyCodes[192] = 28;
         KeyFocusListener.KeyHandler_keyCodes[222] = 58;
         KeyFocusListener.KeyHandler_keyCodes[520] = 59;
      }

   }

   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "624478382"
   )
   @Export("prependIndices")
   static final String[] prependIndices(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }
}
