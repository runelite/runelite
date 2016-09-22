import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public final class class31 extends Renderable {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1688330865
   )
   int field710;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2056800229
   )
   int field712;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 968598363
   )
   int field713;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -508155855
   )
   int field715;
   @ObfuscatedName("n")
   Sequence field716;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1949268189
   )
   int field717 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1805414549
   )
   int field718;
   @ObfuscatedName("m")
   boolean field719 = false;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = 1603001181
   )
   protected static int field720;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1843970837
   )
   int field721;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -795031047
   )
   int field722 = 0;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-241195043"
   )
   final void method685(int var1) {
      if(!this.field719) {
         this.field722 += var1;

         while(this.field722 > this.field716.field1015[this.field717]) {
            this.field722 -= this.field716.field1015[this.field717];
            ++this.field717;
            if(this.field717 >= this.field716.field1009.length) {
               this.field719 = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "1853658170"
   )
   protected final Model getModel() {
      class45 var1 = class49.method1029(this.field713);
      Model var2;
      if(!this.field719) {
         var2 = var1.method940(this.field717);
      } else {
         var2 = var1.method940(-1);
      }

      return var2 == null?null:var2;
   }

   class31(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field713 = var1;
      this.field710 = var2;
      this.field721 = var3;
      this.field718 = var4;
      this.field715 = var5;
      this.field712 = var6 + var7;
      int var8 = class49.method1029(this.field713).field1034;
      if(var8 != -1) {
         this.field719 = false;
         this.field716 = Friend.getAnimation(var8);
      } else {
         this.field719 = true;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;Lclass170;I)V",
      garbageValue = "-958245125"
   )
   public static void method692(class170 var0, class170 var1, class170 var2) {
      class51.field1134 = var0;
      class51.field1124 = var1;
      class51.field1125 = var2;
   }
}
