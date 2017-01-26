import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public class class99 extends class109 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 358624131
   )
   int field1641 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 838873785
   )
   int field1642 = 256;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = -6169581202828107237L
   )
   long field1643 = FrameMap.method1695();
   @ObfuscatedName("p")
   long[] field1644 = new long[10];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1565041767
   )
   int field1645 = 1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 377903623
   )
   int field1646;
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = 1425500615
   )
   static int field1647;
   @ObfuscatedName("ji")
   static Widget[] field1648;
   @ObfuscatedName("bx")
   static class184 field1649;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "683063643"
   )
   public void vmethod2044() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1644[var1] = 0L;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1908807561"
   )
   int vmethod2041(int var1, int var2) {
      int var3 = this.field1642;
      int var4 = this.field1645;
      this.field1642 = 300;
      this.field1645 = 1;
      this.field1643 = FrameMap.method1695();
      if(0L == this.field1644[this.field1646]) {
         this.field1642 = var3;
         this.field1645 = var4;
      } else if(this.field1643 > this.field1644[this.field1646]) {
         this.field1642 = (int)((long)(2560 * var1) / (this.field1643 - this.field1644[this.field1646]));
      }

      if(this.field1642 < 25) {
         this.field1642 = 25;
      }

      if(this.field1642 > 256) {
         this.field1642 = 256;
         this.field1645 = (int)((long)var1 - (this.field1643 - this.field1644[this.field1646]) / 10L);
      }

      if(this.field1645 > var1) {
         this.field1645 = var1;
      }

      this.field1644[this.field1646] = this.field1643;
      this.field1646 = (this.field1646 + 1) % 10;
      int var5;
      if(this.field1645 > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(this.field1644[var5] != 0L) {
               this.field1644[var5] += (long)this.field1645;
            }
         }
      }

      if(this.field1645 < var2) {
         this.field1645 = var2;
      }

      class104.method1988((long)this.field1645);

      for(var5 = 0; this.field1641 < 256; this.field1641 += this.field1642) {
         ++var5;
      }

      this.field1641 &= 255;
      return var5;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1645525144"
   )
   static final void method1939() {
      int var0 = class185.menuX;
      int var1 = class103.menuY;
      int var2 = XClanMember.menuWidth;
      int var3 = class175.menuHeight;
      int var4 = 6116423;
      Rasterizer2D.method4020(var0, var1, var2, var3, var4);
      Rasterizer2D.method4020(1 + var0, var1 + 1, var2 - 2, 16, 0);
      Rasterizer2D.method3997(1 + var0, var1 + 18, var2 - 2, var3 - 19, 0);
      Tile.field1346.method3875("Choose Option", var0 + 3, var1 + 14, var4, -1);
      int var5 = class115.field1805;
      int var6 = class115.field1814;

      for(int var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         int var8 = 31 + var1 + 15 * (Client.menuOptionCount - 1 - var7);
         int var9 = 16777215;
         if(var5 > var0 && var5 < var2 + var0 && var6 > var8 - 13 && var6 < 3 + var8) {
            var9 = 16776960;
         }

         Font var10 = Tile.field1346;
         String var11;
         if(Client.menuTargets[var7].length() > 0) {
            var11 = Client.menuOptions[var7] + " " + Client.menuTargets[var7];
         } else {
            var11 = Client.menuOptions[var7];
         }

         var10.method3875(var11, var0 + 3, var8, var9, 0);
      }

      class165.method3119(class185.menuX, class103.menuY, XClanMember.menuWidth, class175.menuHeight);
   }

   class99() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1644[var1] = this.field1643;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "741694132"
   )
   public static boolean method1940(int var0) {
      return (var0 >> 30 & 1) != 0;
   }
}
