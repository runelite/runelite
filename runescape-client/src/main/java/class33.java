import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public final class class33 extends Renderable {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1993168307
   )
   int field757;
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = -146579383
   )
   protected static int field758;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -847142391
   )
   int field759;
   @ObfuscatedName("l")
   Sequence field760;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1901909791
   )
   int field762;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1353976791
   )
   int field763;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -688804857
   )
   int field764 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1371257669
   )
   int field765 = 0;
   @ObfuscatedName("w")
   boolean field766 = false;
   @ObfuscatedName("b")
   static String field767;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1286721683
   )
   int field768;
   @ObfuscatedName("er")
   static SpritePixels[] field771;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -985438679
   )
   int field772;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 881442911
   )
   static int field773;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-42"
   )
   final void method711(int var1) {
      if(!this.field766) {
         this.field765 += var1;

         while(this.field765 > this.field760.frameLenghts[this.field764]) {
            this.field765 -= this.field760.frameLenghts[this.field764];
            ++this.field764;
            if(this.field764 >= this.field760.frameIDs.length) {
               this.field766 = true;
               break;
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "1"
   )
   protected final Model getModel() {
      Spotanim var1 = class145.method2800(this.field763);
      Model var2;
      if(!this.field766) {
         var2 = var1.method3517(this.field764);
      } else {
         var2 = var1.method3517(-1);
      }

      return var2 == null?null:var2;
   }

   class33(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field763 = var1;
      this.field759 = var2;
      this.field757 = var3;
      this.field768 = var4;
      this.field762 = var5;
      this.field772 = var6 + var7;
      int var8 = class145.method2800(this.field763).field2808;
      if(var8 != -1) {
         this.field766 = false;
         this.field760 = Friend.getAnimation(var8);
      } else {
         this.field766 = true;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "72"
   )
   public static void method717(Component var0) {
      var0.removeKeyListener(class105.keyboard);
      var0.removeFocusListener(class105.keyboard);
      class105.field1743 = -1;
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "61"
   )
   static final void method718(int var0, int var1) {
      if(Ignore.method178(var0)) {
         Projectile.method826(Widget.widgets[var0], var1);
      }

   }
}
