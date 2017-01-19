import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public final class class33 extends Renderable {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1667481367
   )
   int field740 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1102064015
   )
   int field741;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -718534115
   )
   int field742;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1125299401
   )
   int field743;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1466367783
   )
   int field744;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1015114367
   )
   int field745;
   @ObfuscatedName("k")
   Sequence field747;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1250584227
   )
   int field748;
   @ObfuscatedName("x")
   boolean field749 = false;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1314294583
   )
   int field750 = 0;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1926748565"
   )
   final void method669(int var1) {
      if(!this.field749) {
         this.field740 += var1;

         while(this.field740 > this.field747.frameLenghts[this.field750]) {
            this.field740 -= this.field747.frameLenghts[this.field750];
            ++this.field750;
            if(this.field750 >= this.field747.frameIDs.length) {
               this.field749 = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1061373187"
   )
   static final int method670(int var0, int var1) {
      int var2 = Actor.method579(var0 - 1, var1 - 1) + Actor.method579(var0 + 1, var1 - 1) + Actor.method579(var0 - 1, var1 + 1) + Actor.method579(1 + var0, var1 + 1);
      int var3 = Actor.method579(var0 - 1, var1) + Actor.method579(1 + var0, var1) + Actor.method579(var0, var1 - 1) + Actor.method579(var0, var1 + 1);
      int var4 = Actor.method579(var0, var1);
      return var4 / 4 + var2 / 16 + var3 / 8;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "2062912069"
   )
   protected final Model getModel() {
      class190 var1 = class48.method844(this.field743);
      Model var2;
      if(!this.field749) {
         var2 = var1.method3353(this.field750);
      } else {
         var2 = var1.method3353(-1);
      }

      return null == var2?null:var2;
   }

   class33(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field743 = var1;
      this.field742 = var2;
      this.field741 = var3;
      this.field744 = var4;
      this.field745 = var5;
      this.field748 = var6 + var7;
      int var8 = class48.method844(this.field743).field2801;
      if(var8 != -1) {
         this.field749 = false;
         this.field747 = class110.getAnimation(var8);
      } else {
         this.field749 = true;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;I)V",
      garbageValue = "1485014439"
   )
   public static void method677(class182 var0, class182 var1, class182 var2) {
      Sequence.field3061 = var0;
      Sequence.field3066 = var1;
      Sequence.field3058 = var2;
   }
}
