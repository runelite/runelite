import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("TextureProvider")
public class TextureProvider implements class95 {
   @ObfuscatedName("pe")
   @ObfuscatedGetter(
      intValue = -861333793
   )
   protected static int field1702;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1025101293
   )
   int field1703 = 128;
   @ObfuscatedName("a")
   class86[] field1704;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1079794749
   )
   int field1705 = 0;
   @ObfuscatedName("z")
   double field1706 = 1.0D;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -578892877
   )
   int field1707;
   @ObfuscatedName("d")
   Deque field1708 = new Deque();
   @ObfuscatedName("n")
   class170 field1710;
   @ObfuscatedName("mw")
   static SpritePixels field1712;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "56"
   )
   public void method2200(int var1) {
      for(int var2 = 0; var2 < this.field1704.length; ++var2) {
         class86 var3 = this.field1704[var2];
         if(var3 != null && var3.field1528 != 0 && var3.field1531) {
            var3.method1930(var1);
            var3.field1531 = false;
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-617916756"
   )
   public boolean vmethod2201(int var1) {
      return this.field1703 == 64;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "638574059"
   )
   @Export("load")
   public int[] load(int var1) {
      class86 var2 = this.field1704[var1];
      if(var2 != null) {
         if(null != var2.field1525) {
            this.field1708.method3877(var2);
            var2.field1531 = true;
            return var2.field1525;
         }

         boolean var3 = var2.method1934(this.field1706, this.field1703, this.field1710);
         if(var3) {
            if(this.field1705 == 0) {
               class86 var4 = (class86)this.field1708.method3853();
               var4.method1929();
            } else {
               --this.field1705;
            }

            this.field1708.method3877(var2);
            var2.field1531 = true;
            return var2.field1525;
         }
      }

      return null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-106"
   )
   public int vmethod2203(int var1) {
      return null != this.field1704[var1]?this.field1704[var1].field1522:0;
   }

   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;IDI)V",
      garbageValue = "64"
   )
   public TextureProvider(class170 var1, class170 var2, int var3, double var4, int var6) {
      this.field1710 = var2;
      this.field1707 = var3;
      this.field1705 = this.field1707;
      this.field1706 = var4;
      this.field1703 = var6;
      int[] var7 = var1.method3330(0);
      int var8 = var7.length;
      this.field1704 = new class86[var1.method3319(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.method3309(0, var7[var9]));
         this.field1704[var7[var9]] = new class86(var10);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "26"
   )
   public void method2205() {
      for(int var1 = 0; var1 < this.field1704.length; ++var1) {
         if(this.field1704[var1] != null) {
            this.field1704[var1].method1929();
         }
      }

      this.field1708 = new Deque();
      this.field1705 = this.field1707;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "14"
   )
   public boolean vmethod2207(int var1) {
      return this.field1704[var1].field1523;
   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZB)V",
      garbageValue = "8"
   )
   static final void method2217(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1) {
         class162.method3212(var2);
      }

      ObjectComposition.method882(var2);
      Widget var4 = class24.method600(var3);
      if(null != var4) {
         class53.method1101(var4);
      }

      Friend.method191();
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(class93.method2114(var5)) {
            ItemComposition.method1119(Widget.widgets[var5], 1);
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method2221(double var1) {
      this.field1706 = var1;
      this.method2205();
   }
}
