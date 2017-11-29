import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
@Implements("BoundingBox2D")
public final class BoundingBox2D extends BoundingBox {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1530214519
   )
   public static int field237;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 865420211
   )
   @Export("xMin")
   final int xMin;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1329651037
   )
   @Export("yMin")
   final int yMin;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1655366545
   )
   @Export("xMax")
   final int xMax;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1672924857
   )
   @Export("yMax")
   final int yMax;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -582465759
   )
   @Export("color")
   final int color;

   public BoundingBox2D(int var1, int var2, int var3, int var4, int var5) {
      this.xMin = var1;
      this.yMin = var2;
      this.xMax = var3;
      this.yMax = var4;
      this.color = var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "106"
   )
   final void draw() {
      Rasterizer2D.drawRectangle(this.xMin + Rasterizer2D.draw_region_x, this.yMin + Rasterizer2D.drawingAreaTop, this.xMax - this.xMin, this.yMax - this.yMin, this.color);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "153582003"
   )
   static void method41(Component var0) {
      var0.removeMouseListener(MouseInput.mouse);
      var0.removeMouseMotionListener(MouseInput.mouse);
      var0.removeFocusListener(MouseInput.mouse);
      MouseInput.MouseHandler_currentButton = 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "217103166"
   )
   static void method45(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(KeyFocusListener.keyboard);
      var0.addFocusListener(KeyFocusListener.keyboard);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1398444578"
   )
   static void method40() {
      try {
         File var0 = new File(Enum.userHome, "random.dat");
         int var2;
         if(var0.exists()) {
            class156.randomDat = new CacheFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
         } else {
            label38:
            for(int var4 = 0; var4 < class18.field309.length; ++var4) {
               for(var2 = 0; var2 < ContextMenuRow.cacheLocations.length; ++var2) {
                  File var3 = new File(ContextMenuRow.cacheLocations[var2] + class18.field309[var4] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class156.randomDat = new CacheFile(new FileOnDisk(var3, "rw", 25L), 24, 0);
                     break label38;
                  }
               }
            }
         }

         if(class156.randomDat == null) {
            RandomAccessFile var1 = new RandomAccessFile(var0, "rw");
            var2 = var1.read();
            var1.seek(0L);
            var1.write(var2);
            var1.seek(0L);
            var1.close();
            class156.randomDat = new CacheFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1527734686"
   )
   static int method46(int var0) {
      MessageNode var1 = (MessageNode)class96.messages.get((long)var0);
      return var1 == null?-1:(var1.previous == class96.field1435.sentinel?-1:((MessageNode)var1.previous).id);
   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-79487742"
   )
   static void method48(int var0) {
      FontName.topContextMenuRow = new ContextMenuRow();
      FontName.topContextMenuRow.param0 = Client.menuActionParams0[var0];
      FontName.topContextMenuRow.param1 = Client.menuActionParams1[var0];
      FontName.topContextMenuRow.type = Client.menuTypes[var0];
      FontName.topContextMenuRow.identifier = Client.menuIdentifiers[var0];
      FontName.topContextMenuRow.option = Client.menuOptions[var0];
   }

   @ObfuscatedName("kk")
   @ObfuscatedSignature(
      signature = "(Lhx;II)Ljava/lang/String;",
      garbageValue = "-2022815194"
   )
   static String method44(Widget var0, int var1) {
      int var3 = ClanMember.getWidgetConfig(var0);
      boolean var2 = (var3 >> var1 + 1 & 1) != 0;
      return !var2 && var0.field2803 == null?null:(var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }
}
