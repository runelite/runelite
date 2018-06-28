import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
   @ObfuscatedName("x")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("w")
   @Export("state")
   byte state;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 767568315
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -898523007
   )
   @Export("price")
   public int price;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2052595455
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 256549175
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 696708223
   )
   @Export("spent")
   public int spent;

   public GrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(Lgy;Z)V",
      garbageValue = "0"
   )
   public GrandExchangeOffer(Buffer var1, boolean var2) {
      this.state = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   @Export("status")
   public int status() {
      return this.state & 7;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1682121096"
   )
   @Export("type")
   public int type() {
      return (this.state & 8) == 8?1:0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "32"
   )
   void method52(int var1) {
      this.state &= -8;
      this.state = (byte)(this.state | var1 & 7);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-194001658"
   )
   void method36(int var1) {
      this.state &= -9;
      if(var1 == 1) {
         this.state = (byte)(this.state | 8);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "102125315"
   )
   static void method53(Component var0) {
      var0.removeKeyListener(KeyFocusListener.keyboard);
      var0.removeFocusListener(KeyFocusListener.keyboard);
      KeyFocusListener.field349 = -1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ZZB)Llh;",
      garbageValue = "96"
   )
   static IndexedSprite method54(boolean var0, boolean var1) {
      return var0?(var1?Buffer.field2363:class78.field1110):(var1?CombatInfo1.field944:class78.field1109);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)I",
      garbageValue = "0"
   )
   public static int method56(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-824282945"
   )
   @Export("runWidgetOnLoadListener")
   static void runWidgetOnLoadListener(int var0) {
      if(var0 != -1) {
         if(GameCanvas.loadWidget(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.onLoadListener != null) {
                  ScriptEvent var4 = new ScriptEvent();
                  var4.source = var3;
                  var4.params = var3.onLoadListener;
                  MouseRecorder.runScript(var4, 5000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "(Lhl;IIIB)V",
      garbageValue = "1"
   )
   static final void method57(Widget var0, int var1, int var2, int var3) {
      class224 var4 = var0.method4561(false);
      if(var4 != null) {
         if(Client.field822 < 3) {
            class35.compass.method5948(var1, var2, var4.field2570, var4.field2575, 25, 25, Client.mapAngle, 256, var4.field2573, var4.field2572);
         } else {
            Rasterizer2D.method5786(var1, var2, 0, var4.field2573, var4.field2572);
         }

      }
   }
}
