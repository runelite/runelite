import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("GraphicsObject")
public final class GraphicsObject extends Renderable {
   @ObfuscatedName("el")
   @ObfuscatedGetter(
      intValue = 2011022665
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1727106221
   )
   @Export("id")
   int id;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1363715003
   )
   @Export("startCycle")
   int startCycle;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   Sequence field1280;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2045090739
   )
   @Export("level")
   int level;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 663400687
   )
   @Export("x")
   int x;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 466568023
   )
   @Export("y")
   int y;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1008757159
   )
   @Export("height")
   int height;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1050875749
   )
   int field1284;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 403874075
   )
   int field1282;
   @ObfuscatedName("f")
   @Export("finished")
   boolean finished;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1284 = 0;
      this.field1282 = 0;
      this.finished = false;
      this.id = var1;
      this.level = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.startCycle = var7 + var6;
      int var8 = NPCComposition.getSpotAnimType(this.id).field3419;
      if(var8 != -1) {
         this.finished = false;
         this.field1280 = class45.getAnimation(var8);
      } else {
         this.finished = true;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1083675993"
   )
   final void method1687(int var1) {
      if(!this.finished) {
         this.field1282 += var1;

         while(this.field1282 > this.field1280.frameLenghts[this.field1284]) {
            this.field1282 -= this.field1280.frameLenghts[this.field1284];
            ++this.field1284;
            if(this.field1284 >= this.field1280.frameIDs.length) {
               this.finished = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Les;",
      garbageValue = "-17"
   )
   protected final Model getModel() {
      Spotanim var1 = NPCComposition.getSpotAnimType(this.id);
      Model var2;
      if(!this.finished) {
         var2 = var1.getModel(this.field1284);
      } else {
         var2 = var1.getModel(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("ka")
   @ObfuscatedSignature(
      signature = "(Lhq;I)I",
      garbageValue = "1856910148"
   )
   @Export("getWidgetConfig")
   static int getWidgetConfig(Widget var0) {
      IntegerNode var1 = (IntegerNode)Client.widgetFlags.get(((long)var0.id << 32) + (long)var0.index);
      return var1 != null?var1.value:var0.config;
   }
}
