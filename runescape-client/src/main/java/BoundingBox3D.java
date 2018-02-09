import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
@Implements("BoundingBox3D")
public final class BoundingBox3D extends BoundingBox {
   @ObfuscatedName("f")
   static int[] field247;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -255779647
   )
   @Export("int1")
   final int int1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1127537095
   )
   @Export("int2")
   final int int2;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1926367543
   )
   @Export("int3")
   final int int3;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -651297591
   )
   @Export("int4")
   final int int4;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2006714047
   )
   @Export("int5")
   final int int5;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1566286361
   )
   @Export("int6")
   final int int6;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -420532453
   )
   @Export("color")
   final int color;

   @ObfuscatedSignature(
      signature = "(Les;IIII)V"
   )
   BoundingBox3D(Model var1, int var2, int var3, int var4, int var5) {
      this.int1 = var2 + var1.centerX - var1.extremeX;
      this.int2 = var3 + var1.centerY - var1.extremeY;
      this.int3 = var4 + var1.centerZ - var1.extremeZ;
      this.int4 = var2 + var1.extremeX + var1.centerX;
      this.int5 = var3 + var1.centerY + var1.extremeY;
      this.int6 = var4 + var1.extremeZ + var1.centerZ;
      this.color = var5;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1287124829"
   )
   final void draw() {
      for(int var4 = 0; var4 < 8; ++var4) {
         int var1 = (var4 & 1) == 0?this.int1:this.int4;
         int var2 = (var4 & 2) == 0?this.int2:this.int5;
         int var3 = (var4 & 4) == 0?this.int3:this.int6;
         if((var4 & 1) == 0) {
            TotalQuantityComparator.method98(var1, var2, var3, this.int4, var2, var3, this.color);
         }

         if((var4 & 2) == 0) {
            TotalQuantityComparator.method98(var1, var2, var3, var1, this.int5, var3, this.color);
         }

         if((var4 & 4) == 0) {
            TotalQuantityComparator.method98(var1, var2, var3, var1, var2, this.int6, this.color);
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "770980956"
   )
   static void method53(Component var0) {
      var0.addMouseListener(MouseInput.mouse);
      var0.addMouseMotionListener(MouseInput.mouse);
      var0.addFocusListener(MouseInput.mouse);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-62"
   )
   static final void method49(String var0) {
      SoundTaskDataProvider.sendGameMessage(30, "", var0);
   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "127"
   )
   static final void method52(int var0) {
      if(var0 >= 0) {
         int var1 = Client.menuActionParams0[var0];
         int var2 = Client.menuActionParams1[var0];
         int var3 = Client.menuTypes[var0];
         int var4 = Client.menuIdentifiers[var0];
         String var5 = Client.menuOptions[var0];
         String var6 = Client.menuTargets[var0];
         Client.menuAction(var1, var2, var3, var4, var5, var6, MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
      }
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1118012612"
   )
   static final int method51() {
      return Client.menuOptionCount - 1;
   }
}
