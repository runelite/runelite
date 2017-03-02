import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("b")
   @Export("progress")
   byte progress;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -546343121
   )
   @Export("price")
   public int price;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1699108977
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 93137959
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -949924095
   )
   @Export("spent")
   public int spent;
   @ObfuscatedName("p")
   public static class60 field41;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 1593243145
   )
   static int field42;
   @ObfuscatedName("f")
   static ModIcon field43;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 381943037
   )
   @Export("itemId")
   public int itemId;

   public XGrandExchangeOffer() {
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-512244331"
   )
   public int method46() {
      return this.progress & 7;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "2"
   )
   public int method47() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-6218"
   )
   void method48(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;I)V",
      garbageValue = "-2019347617"
   )
   public static void method51(File var0, File var1) {
      try {
         FileOnDisk var2 = new FileOnDisk(class104.field1677, "rw", 10000L);
         Buffer var3 = new Buffer(500);
         var3.method3010(3);
         var3.method3010(null != var1?1:0);
         var3.method2886(var0.getPath());
         if(null != var1) {
            var3.method2886("");
         }

         var2.method1468(var3.payload, 0, var3.offset);
         var2.method1471();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-946142235"
   )
   static final void method65(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = 6 + var2;
      int var4 = 6 + var2;
      int var5 = XItemContainer.field119.method3971(var0, 250);
      int var6 = XItemContainer.field119.method3982(var0, 250) * 13;
      Rasterizer2D.method4099(var3 - var2, var4 - var2, var2 + var2 + var5, var6 + var2 + var2, 0);
      Rasterizer2D.method4104(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2, 16777215);
      XItemContainer.field119.method4042(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class105.method2076(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6);
      if(var1) {
         try {
            Graphics var7 = class0.canvas.getGraphics();
            class22.bufferProvider.draw(var7, 0, 0);
         } catch (Exception var8) {
            class0.canvas.repaint();
         }
      } else {
         class8.method113(var3, var4, var5, var6);
      }

   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "3"
   )
   static final void method66() {
      int var0 = MessageNode.menuX;
      int var1 = class137.menuY;
      int var2 = class36.menuWidth;
      int var3 = class212.menuHeight;
      int var4 = 6116423;
      Rasterizer2D.method4099(var0, var1, var2, var3, var4);
      Rasterizer2D.method4099(var0 + 1, 1 + var1, var2 - 2, 16, 0);
      Rasterizer2D.method4104(1 + var0, var1 + 18, var2 - 2, var3 - 19, 0);
      class16.field170.method3974("Choose Option", var0 + 3, 14 + var1, var4, -1);
      int var5 = class115.field1802;
      int var6 = class115.field1801;

      for(int var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         int var8 = 15 * (Client.menuOptionCount - 1 - var7) + var1 + 31;
         int var9 = 16777215;
         if(var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < 3 + var8) {
            var9 = 16776960;
         }

         class16.field170.method3974(class57.method1161(var7), var0 + 3, var8, var9, 0);
      }

      class8.method113(MessageNode.menuX, class137.menuY, class36.menuWidth, class212.menuHeight);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "87"
   )
   static void method67() {
      int var0 = GameEngine.field1761;
      int var1 = GameEngine.field1780;
      int var2 = FaceNormal.field1553 - class2.field21 - var0;
      int var3 = class85.field1445 - class20.field216 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = Client.field279.method2220();
            int var5 = 0;
            int var6 = 0;
            if(var4 == Item.field881) {
               Insets var7 = Item.field881.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class85.field1445);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, FaceNormal.field1553, var1);
            }

            if(var2 > 0) {
               var9.fillRect(FaceNormal.field1553 + var5 - var2, var6, var2, class85.field1445);
            }

            if(var3 > 0) {
               var9.fillRect(var5, var6 + class85.field1445 - var3, FaceNormal.field1553, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass159;I)I",
      garbageValue = "1358669092"
   )
   static int method68(class159 var0) {
      int var1 = var0.method3119(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method3119(5);
      } else if(var1 == 2) {
         var2 = var0.method3119(8);
      } else {
         var2 = var0.method3119(11);
      }

      return var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1065351988"
   )
   void method69(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lclass184;",
      garbageValue = "-1149211787"
   )
   static class184 method70(int var0, boolean var1, boolean var2, boolean var3) {
      class116 var4 = null;
      if(class104.field1683 != null) {
         var4 = new class116(var0, class104.field1683, class116.field1821[var0], 1000000);
      }

      return new class184(var4, class41.field852, var0, var1, var2, var3);
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1778198589"
   )
   static final void method71() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < Client.menuOptionCount - 1; ++var1) {
            if(Client.menuTypes[var1] < 1000 && Client.menuTypes[1 + var1] > 1000) {
               String var2 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
               Client.menuTargets[var1 + 1] = var2;
               String var3 = Client.menuOptions[var1];
               Client.menuOptions[var1] = Client.menuOptions[1 + var1];
               Client.menuOptions[var1 + 1] = var3;
               int var4 = Client.menuTypes[var1];
               Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
               Client.menuTypes[1 + var1] = var4;
               var4 = Client.menuActionParams0[var1];
               Client.menuActionParams0[var1] = Client.menuActionParams0[1 + var1];
               Client.menuActionParams0[var1 + 1] = var4;
               var4 = Client.menuActionParams1[var1];
               Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               Client.menuActionParams1[1 + var1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[1 + var1];
               Client.menuIdentifiers[1 + var1] = var4;
               if(Client.field432 != -1) {
                  if(var1 == Client.field432) {
                     Client.field432 = 1 + var1;
                  } else if(Client.field432 == var1 + 1) {
                     Client.field432 = var1;
                  }
               }

               var0 = false;
            }
         }
      }

   }
}
