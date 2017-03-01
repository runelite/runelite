import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1143230111
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -508686825
   )
   @Export("price")
   public int price;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1292829107
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("x")
   @Export("progress")
   byte progress;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -601301355
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("cp")
   static class110 field30;
   @ObfuscatedName("t")
   static int[] field34;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1929096285
   )
   @Export("spent")
   public int spent;

   @ObfuscatedName("sz")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/awt/Color;ZI)V",
      garbageValue = "-434544297"
   )
   protected static final void method47(int var0, String var1, Color var2, boolean var3) {
      try {
         Graphics var4 = class110.canvas.getGraphics();
         if(TextureProvider.field1214 == null) {
            TextureProvider.field1214 = new java.awt.Font("Helvetica", 1, 13);
            CombatInfo1.field663 = class110.canvas.getFontMetrics(TextureProvider.field1214);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, RSCanvas.field1756, class65.field1128);
         }

         if(null == var2) {
            var2 = new Color(140, 17, 17);
         }

         try {
            if(class63.field1108 == null) {
               class63.field1108 = class110.canvas.createImage(304, 34);
            }

            Graphics var5 = class63.field1108.getGraphics();
            var5.setColor(var2);
            var5.drawRect(0, 0, 303, 33);
            var5.fillRect(2, 2, 3 * var0, 30);
            var5.setColor(Color.black);
            var5.drawRect(1, 1, 301, 31);
            var5.fillRect(var0 * 3 + 2, 2, 300 - 3 * var0, 30);
            var5.setFont(TextureProvider.field1214);
            var5.setColor(Color.white);
            var5.drawString(var1, (304 - CombatInfo1.field663.stringWidth(var1)) / 2, 22);
            var4.drawImage(class63.field1108, RSCanvas.field1756 / 2 - 152, class65.field1128 / 2 - 18, (ImageObserver)null);
         } catch (Exception var8) {
            int var6 = RSCanvas.field1756 / 2 - 152;
            int var7 = class65.field1128 / 2 - 18;
            var4.setColor(var2);
            var4.drawRect(var6, var7, 303, 33);
            var4.fillRect(2 + var6, var7 + 2, 3 * var0, 30);
            var4.setColor(Color.black);
            var4.drawRect(var6 + 1, var7 + 1, 301, 31);
            var4.fillRect(3 * var0 + 2 + var6, var7 + 2, 300 - 3 * var0, 30);
            var4.setFont(TextureProvider.field1214);
            var4.setColor(Color.white);
            var4.drawString(var1, var6 + (304 - CombatInfo1.field663.stringWidth(var1)) / 2, var7 + 22);
         }
      } catch (Exception var9) {
         class110.canvas.repaint();
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "667980861"
   )
   public int method50() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1350955524"
   )
   void method51(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1548967667"
   )
   public int method54() {
      return this.progress & 7;
   }

   public XGrandExchangeOffer() {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "1847427105"
   )
   static void method68(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = CombatInfoListHolder.worldList[var6];
         CombatInfoListHolder.worldList[var6] = CombatInfoListHolder.worldList[var1];
         CombatInfoListHolder.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(class152.method2869(CombatInfoListHolder.worldList[var9], var8, var2, var3, var4, var5) <= 0) {
               World var10 = CombatInfoListHolder.worldList[var9];
               CombatInfoListHolder.worldList[var9] = CombatInfoListHolder.worldList[var7];
               CombatInfoListHolder.worldList[var7++] = var10;
            }
         }

         CombatInfoListHolder.worldList[var1] = CombatInfoListHolder.worldList[var7];
         CombatInfoListHolder.worldList[var7] = var8;
         method68(var0, var7 - 1, var2, var3, var4, var5);
         method68(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "1234602506"
   )
   static final void method69(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = class15.field162.method3938(var0, 250);
      int var6 = class15.field162.method3907(var0, 250) * 13;
      Rasterizer2D.method4056(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2, 0);
      Rasterizer2D.method4012(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var6 + var2, 16777215);
      class15.field162.method3913(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      Item.method880(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2);
      if(var1) {
         try {
            Graphics var7 = class110.canvas.getGraphics();
            class57.bufferProvider.draw(var7, 0, 0);
         } catch (Exception var8) {
            class110.canvas.repaint();
         }
      } else {
         class13.method187(var3, var4, var5, var6);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1760538039"
   )
   void method70(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }
}
