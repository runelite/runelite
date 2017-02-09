import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public final class class33 extends Renderable {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 270900129
   )
   int field735 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1676259475
   )
   int field736;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1597363733
   )
   int field738;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1143348563
   )
   int field739;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1672434585
   )
   int field740;
   @ObfuscatedName("y")
   Sequence field741;
   @ObfuscatedName("ea")
   static SpritePixels[] field742;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1952626311
   )
   int field743 = 0;
   @ObfuscatedName("c")
   boolean field744 = false;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -702736503
   )
   int field746;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1409004601
   )
   int field748;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "956508335"
   )
   final void method717(int var1) {
      if(!this.field744) {
         this.field743 += var1;

         while(this.field743 > this.field741.frameLenghts[this.field735]) {
            this.field743 -= this.field741.frameLenghts[this.field735];
            ++this.field735;
            if(this.field735 >= this.field741.frameIDs.length) {
               this.field744 = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "637530507"
   )
   protected final Model getModel() {
      Spotanim var1 = XItemContainer.method187(this.field740);
      Model var2;
      if(!this.field744) {
         var2 = var1.method3458(this.field735);
      } else {
         var2 = var1.method3458(-1);
      }

      return var2 == null?null:var2;
   }

   class33(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field740 = var1;
      this.field748 = var2;
      this.field738 = var3;
      this.field739 = var4;
      this.field746 = var5;
      this.field736 = var6 + var7;
      int var8 = XItemContainer.method187(this.field740).field2778;
      if(var8 != -1) {
         this.field744 = false;
         this.field741 = TextureProvider.getAnimation(var8);
      } else {
         this.field744 = true;
      }

   }
}
