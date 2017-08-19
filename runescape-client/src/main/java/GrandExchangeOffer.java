import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
   @ObfuscatedName("cp")
   static boolean field302;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = -28979245
   )
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "Lbz;"
   )
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("j")
   @Export("progress")
   byte progress;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 736264791
   )
   @Export("price")
   public int price;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1319253797
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1656326559
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1479355271
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 180604949
   )
   @Export("spent")
   public int spent;

   public GrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      signature = "(Lfb;Z)V",
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "74"
   )
   void method102(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1993853332"
   )
   void method103(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-1"
   )
   public int method101() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-5"
   )
   public int method100() {
      return this.progress & 7;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lia;Lia;IZI)Lef;",
      garbageValue = "-1106224306"
   )
   public static Frames method104(IndexDataBase var0, IndexDataBase var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.getChilds(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.getChild(var2, var5[var6]);
         if(var7 == null) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9;
            if(var3) {
               var9 = var1.getChild(0, var8);
            } else {
               var9 = var1.getChild(var8, 0);
            }

            if(var9 == null) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new Frames(var0, var1, var2, var3);
         } catch (Exception var11) {
            return null;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Leo;II)V",
      garbageValue = "-1466285049"
   )
   public static final void method117(Model var0, int var1) {
      for(int var2 = 0; var2 < var0.field1934; ++var2) {
         if(var0.field1940[var2] != -2) {
            int var3 = var0.indices1[var2];
            int var4 = var0.indices2[var2];
            int var5 = var0.indices3[var2];
            int var6 = Model.field1952[var3];
            int var7 = Model.field1952[var4];
            int var8 = Model.field1952[var5];
            class212.method3937(Model.field1968[var3], Model.field1968[var4], Model.field1968[var5], var6, var7, var8, var1);
         }
      }

   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "126094077"
   )
   static final void method98() {
      int var0 = Client.menuX;
      int var1 = Sequence.menuY;
      int var2 = menuWidth;
      int var3 = class15.menuHeight;
      int var4 = 6116423;
      Rasterizer2D.method4968(var0, var1, var2, var3, var4);
      Rasterizer2D.method4968(var0 + 1, var1 + 1, var2 - 2, 16, 0);
      Rasterizer2D.drawRectangle(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
      class61.field765.method4780("Choose Option", var0 + 3, var1 + 14, var4, -1);
      int var5 = MouseInput.field734;
      int var6 = MouseInput.field735;

      int var7;
      int var8;
      int var9;
      for(var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         var8 = var1 + 31 + (Client.menuOptionCount - 1 - var7) * 15;
         var9 = 16777215;
         if(var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < var8 + 3) {
            var9 = 16776960;
         }

         Font var10 = class61.field765;
         String var11;
         if(var7 < 0) {
            var11 = "";
         } else if(Client.menuTargets[var7].length() > 0) {
            var11 = Client.menuOptions[var7] + " " + Client.menuTargets[var7];
         } else {
            var11 = Client.menuOptions[var7];
         }

         var10.method4780(var11, var0 + 3, var8, var9, 0);
      }

      var7 = Client.menuX;
      var8 = Sequence.menuY;
      var9 = menuWidth;
      int var12 = class15.menuHeight;

      for(int var13 = 0; var13 < Client.field1129; ++var13) {
         if(Client.widgetBoundsWidth[var13] + Client.widgetPositionX[var13] > var7 && Client.widgetPositionX[var13] < var7 + var9 && Client.widgetBoundsHeight[var13] + Client.widgetPositionY[var13] > var8 && Client.widgetPositionY[var13] < var8 + var12) {
            Client.field1132[var13] = true;
         }
      }

   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1815596144"
   )
   static void method116() {
      if(Client.spellSelected) {
         Widget var0 = class205.method3812(class29.field434, Client.field1082);
         if(var0 != null && var0.field2741 != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.widget = var0;
            var1.field856 = var0.field2741;
            Coordinates.method3942(var1);
         }

         Client.spellSelected = false;
         class90.method1723(var0);
      }
   }
}
