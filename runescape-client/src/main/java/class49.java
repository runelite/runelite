import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class49 implements WorldMapSectionBase {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   static Widget field604;
   @ObfuscatedName("ll")
   @ObfuscatedGetter(
      intValue = -720450017
   )
   static int field605;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -36621507
   )
   int field598;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1569986351
   )
   int field595;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -221068245
   )
   int field596;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1725946647
   )
   int field594;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 134430425
   )
   int field601;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1984403179
   )
   int field599;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 516974989
   )
   int field602;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -340727535
   )
   int field597;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 345701283
   )
   int field600;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1642940785
   )
   int field603;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Las;I)V",
      garbageValue = "1011910161"
   )
   public void vmethod763(WorldMapData var1) {
      if(var1.minX > this.field601) {
         var1.minX = this.field601;
      }

      if(var1.field448 < this.field601) {
         var1.field448 = this.field601;
      }

      if(var1.minY > this.field599) {
         var1.minY = this.field599;
      }

      if(var1.field450 < this.field599) {
         var1.field450 = this.field599;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "516050332"
   )
   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.field598 && var1 < this.field598 + this.field595?var2 >= (this.field596 << 6) + (this.field602 << 3) && var2 <= (this.field596 << 6) + (this.field602 << 3) + 7 && var3 >= (this.field594 << 6) + (this.field597 << 3) && var3 <= (this.field594 << 6) + (this.field597 << 3) + 7:false;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "2066198604"
   )
   public boolean vmethod766(int var1, int var2) {
      return var1 >= (this.field601 << 6) + (this.field600 << 3) && var1 <= (this.field601 << 6) + (this.field600 << 3) + 7 && var2 >= (this.field599 << 6) + (this.field603 << 3) && var2 <= (this.field599 << 6) + (this.field603 << 3) + 7;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIB)[I",
      garbageValue = "-3"
   )
   public int[] vmethod767(int var1, int var2, int var3) {
      if(!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field601 * 64 - this.field596 * 64 + var2 + (this.field600 * 8 - this.field602 * 8), var3 + (this.field599 * 64 - this.field594 * 64) + (this.field603 * 8 - this.field597 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)Lio;",
      garbageValue = "0"
   )
   public Coordinates vmethod768(int var1, int var2) {
      if(!this.vmethod766(var1, var2)) {
         return null;
      } else {
         int var3 = this.field596 * 64 - this.field601 * 64 + (this.field602 * 8 - this.field600 * 8) + var1;
         int var4 = this.field594 * 64 - this.field599 * 64 + var2 + (this.field597 * 8 - this.field603 * 8);
         return new Coordinates(this.field598, var3, var4);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lgg;B)V",
      garbageValue = "67"
   )
   public void vmethod769(Buffer var1) {
      this.field598 = var1.readUnsignedByte();
      this.field595 = var1.readUnsignedByte();
      this.field596 = var1.readUnsignedShort();
      this.field602 = var1.readUnsignedByte();
      this.field594 = var1.readUnsignedShort();
      this.field597 = var1.readUnsignedByte();
      this.field601 = var1.readUnsignedShort();
      this.field600 = var1.readUnsignedByte();
      this.field599 = var1.readUnsignedShort();
      this.field603 = var1.readUnsignedByte();
      this.method770();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1532199875"
   )
   void method770() {
   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-575062564"
   )
   static final void method773() {
      if(Size.field361) {
         if(LoginPacket.clanMemberManager != null) {
            LoginPacket.clanMemberManager.method5362();
         }

         class20.method163();
         Size.field361 = false;
      }

   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1782706719"
   )
   static final void method788() {
      int var0 = Varcs.menuX;
      int var1 = class90.menuY;
      int var2 = ISAACCipher.field2620;
      int var3 = GameEngine.field685;
      int var4 = 6116423;
      Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, var4);
      Rasterizer2D.Rasterizer2D_fillRectangle(var0 + 1, var1 + 1, var2 - 2, 16, 0);
      Rasterizer2D.drawRectangle(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
      class22.fontBold12.method5630("Choose Option", var0 + 3, var1 + 14, var4, -1);
      int var5 = MouseInput.mouseLastX;
      int var6 = MouseInput.mouseLastY;

      int var7;
      int var8;
      int var9;
      for(var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         var8 = (Client.menuOptionCount - 1 - var7) * 15 + var1 + 31;
         var9 = 16777215;
         if(var5 > var0 && var5 < var2 + var0 && var6 > var8 - 13 && var6 < var8 + 3) {
            var9 = 16776960;
         }

         class22.fontBold12.method5630(Huffman.method3524(var7), var0 + 3, var8, var9, 0);
      }

      var7 = Varcs.menuX;
      var8 = class90.menuY;
      var9 = ISAACCipher.field2620;
      int var10 = GameEngine.field685;

      for(int var11 = 0; var11 < Client.widgetCount; ++var11) {
         if(Client.widgetBoundsWidth[var11] + Client.widgetPositionX[var11] > var7 && Client.widgetPositionX[var11] < var9 + var7 && Client.widgetBoundsHeight[var11] + Client.widgetPositionY[var11] > var8 && Client.widgetPositionY[var11] < var10 + var8) {
            Client.field1056[var11] = true;
         }
      }

   }
}
