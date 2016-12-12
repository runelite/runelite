import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public final class class33 extends Renderable {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1359532133
   )
   int field734;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2022013523
   )
   int field736;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1836172385
   )
   int field737;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1166740921
   )
   int field738;
   @ObfuscatedName("a")
   Sequence field739;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1870278689
   )
   int field740 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -641454761
   )
   int field741 = 0;
   @ObfuscatedName("nl")
   @ObfuscatedGetter(
      intValue = 1982551333
   )
   static int field744;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2024479637
   )
   int field746;
   @ObfuscatedName("v")
   boolean field747 = false;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1148773371
   )
   int field748;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "7"
   )
   protected final Model getModel() {
      class190 var1 = Ignore.method193(this.field746);
      Model var2;
      if(!this.field747) {
         var2 = var1.method3414(this.field740);
      } else {
         var2 = var1.method3414(-1);
      }

      return null == var2?null:var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-333042081"
   )
   final void method660(int var1) {
      if(!this.field747) {
         this.field741 += var1;

         while(this.field741 > this.field739.frameLenghts[this.field740]) {
            this.field741 -= this.field739.frameLenghts[this.field740];
            ++this.field740;
            if(this.field740 >= this.field739.frameIDs.length) {
               this.field747 = true;
               break;
            }
         }

      }
   }

   class33(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field746 = var1;
      this.field738 = var2;
      this.field736 = var3;
      this.field737 = var4;
      this.field748 = var5;
      this.field734 = var6 + var7;
      int var8 = Ignore.method193(this.field746).field2797;
      if(var8 != -1) {
         this.field747 = false;
         this.field739 = GameEngine.getAnimation(var8);
      } else {
         this.field747 = true;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "55"
   )
   static int method664(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method2311((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }
}
