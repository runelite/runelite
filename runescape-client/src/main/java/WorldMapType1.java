import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 321879283
   )
   static int field399;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = -1945852199
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1394076849
   )
   int field398;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 371840151
   )
   int field406;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2093208749
   )
   int field409;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1049202217
   )
   int field400;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2111951457
   )
   int field401;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1547200489
   )
   int field402;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -540406951
   )
   int field403;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 668822953
   )
   int field404;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -343186573
   )
   int field411;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -393116519
   )
   int field405;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lax;I)V",
      garbageValue = "-2145049745"
   )
   public void vmethod695(WorldMapData var1) {
      if(var1.field424 > this.field403) {
         var1.field424 = this.field403;
      }

      if(var1.field417 < this.field411) {
         var1.field417 = this.field411;
      }

      if(var1.field425 > this.field404) {
         var1.field425 = this.field404;
      }

      if(var1.field431 < this.field405) {
         var1.field431 = this.field405;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "1120247978"
   )
   public boolean vmethod708(int var1, int var2, int var3) {
      return var1 >= this.field398 && var1 < this.field398 + this.field406?var2 >> 6 >= this.field409 && var2 >> 6 <= this.field401 && var3 >> 6 >= this.field400 && var3 >> 6 <= this.field402:false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1865125342"
   )
   public boolean vmethod698(int var1, int var2) {
      return var1 >> 6 >= this.field403 && var1 >> 6 <= this.field411 && var2 >> 6 >= this.field404 && var2 >> 6 <= this.field405;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1197920526"
   )
   public int[] vmethod700(int var1, int var2, int var3) {
      if(!this.vmethod708(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field403 * 64 - this.field409 * 64 + var2, var3 + (this.field404 * 64 - this.field400 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)Lhc;",
      garbageValue = "-879620257"
   )
   public Coordinates vmethod714(int var1, int var2) {
      if(!this.vmethod698(var1, var2)) {
         return null;
      } else {
         int var3 = this.field409 * 64 - this.field403 * 64 + var1;
         int var4 = this.field400 * 64 - this.field404 * 64 + var2;
         return new Coordinates(this.field398, var3, var4);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgh;I)V",
      garbageValue = "1638498953"
   )
   public void vmethod701(Buffer var1) {
      this.field398 = var1.readUnsignedByte();
      this.field406 = var1.readUnsignedByte();
      this.field409 = var1.readUnsignedShort();
      this.field400 = var1.readUnsignedShort();
      this.field401 = var1.readUnsignedShort();
      this.field402 = var1.readUnsignedShort();
      this.field403 = var1.readUnsignedShort();
      this.field404 = var1.readUnsignedShort();
      this.field411 = var1.readUnsignedShort();
      this.field405 = var1.readUnsignedShort();
      this.method250();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-986429372"
   )
   void method250() {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1471526799"
   )
   static void method245(Component var0) {
      var0.removeMouseListener(MouseInput.mouse);
      var0.removeMouseMotionListener(MouseInput.mouse);
      var0.removeFocusListener(MouseInput.mouse);
      MouseInput.MouseHandler_currentButton = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1626914826"
   )
   @Export("ilog")
   public static int ilog(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lef;IIIB)Z",
      garbageValue = "-96"
   )
   @Export("boundingBox3DContainsMouse")
   static final boolean boundingBox3DContainsMouse(Model var0, int var1, int var2, int var3) {
      if(!FriendLoginUpdate.method1040()) {
         return false;
      } else {
         int var4;
         int var5;
         int var6;
         int var7;
         int var10;
         int var11;
         int var12;
         int var15;
         int var16;
         if(!class133.Viewport_false0) {
            var4 = Region.pitchSin;
            var5 = Region.pitchCos;
            var6 = Region.yawSin;
            var7 = Region.yawCos;
            byte var8 = 50;
            short var9 = 3500;
            var10 = (class133.Viewport_mouseX - Graphics3D.centerX) * var8 / Graphics3D.Rasterizer3D_zoom;
            var11 = (class133.Viewport_mouseY - Graphics3D.centerY) * var8 / Graphics3D.Rasterizer3D_zoom;
            var12 = (class133.Viewport_mouseX - Graphics3D.centerX) * var9 / Graphics3D.Rasterizer3D_zoom;
            int var13 = (class133.Viewport_mouseY - Graphics3D.centerY) * var9 / Graphics3D.Rasterizer3D_zoom;
            int var14 = Graphics3D.method2676(var11, var8, var5, var4);
            var15 = Graphics3D.method2627(var11, var8, var5, var4);
            var11 = var14;
            var14 = Graphics3D.method2676(var13, var9, var5, var4);
            var16 = Graphics3D.method2627(var13, var9, var5, var4);
            var13 = var14;
            var14 = Graphics3D.method2624(var10, var15, var7, var6);
            var15 = Graphics3D.method2625(var10, var15, var7, var6);
            var10 = var14;
            var14 = Graphics3D.method2624(var12, var16, var7, var6);
            var16 = Graphics3D.method2625(var12, var16, var7, var6);
            class225.field2744 = (var14 + var10) / 2;
            class133.field1884 = (var13 + var11) / 2;
            Varbit.field3462 = (var15 + var16) / 2;
            FriendLoginUpdate.field754 = (var14 - var10) / 2;
            class133.field1881 = (var13 - var11) / 2;
            class2.field15 = (var16 - var15) / 2;
            class133.field1886 = Math.abs(FriendLoginUpdate.field754);
            class260.field3456 = Math.abs(class133.field1881);
            class296.field3843 = Math.abs(class2.field15);
         }

         var4 = var0.field1842 + var1;
         var5 = var2 + var0.field1843;
         var6 = var3 + var0.field1844;
         var7 = var0.field1845;
         var15 = var0.field1824;
         var16 = var0.field1847;
         var10 = class225.field2744 - var4;
         var11 = class133.field1884 - var5;
         var12 = Varbit.field3462 - var6;
         return Math.abs(var10) > var7 + class133.field1886?false:(Math.abs(var11) > var15 + class260.field3456?false:(Math.abs(var12) > var16 + class296.field3843?false:(Math.abs(var12 * class133.field1881 - var11 * class2.field15) > var15 * class296.field3843 + var16 * class260.field3456?false:(Math.abs(var10 * class2.field15 - var12 * FriendLoginUpdate.field754) > var16 * class133.field1886 + var7 * class296.field3843?false:Math.abs(var11 * FriendLoginUpdate.field754 - var10 * class133.field1881) <= var7 * class260.field3456 + var15 * class133.field1886))));
      }
   }
}
