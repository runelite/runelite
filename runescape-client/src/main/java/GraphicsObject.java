import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("GraphicsObject")
public final class GraphicsObject extends Renderable {
   @ObfuscatedName("c")
   boolean field1342;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 655361033
   )
   int field1343;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 281170273
   )
   @Export("level")
   int level;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -785575623
   )
   @Export("x")
   int x;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1214162851
   )
   @Export("id")
   int id;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1710281423
   )
   @Export("height")
   int height;
   @ObfuscatedName("j")
   Sequence field1348;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1030930641
   )
   int field1349;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -593223415
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1176910351
   )
   int field1351;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1857156594"
   )
   final void method1562(int var1) {
      if(!this.field1342) {
         this.field1349 += var1;

         while(this.field1349 > this.field1348.frameLenghts[this.field1351]) {
            this.field1349 -= this.field1348.frameLenghts[this.field1351];
            ++this.field1351;
            if(this.field1351 >= this.field1348.frameIDs.length) {
               this.field1342 = true;
               break;
            }
         }
      }

   }

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1351 = 0;
      this.field1349 = 0;
      this.field1342 = false;
      this.id = var1;
      this.level = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.field1343 = var7 + var6;
      int var8 = Area.method4176(this.id).field3335;
      if(var8 != -1) {
         this.field1342 = false;
         this.field1348 = GameEngine.getAnimation(var8);
      } else {
         this.field1342 = true;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-2066149273"
   )
   protected final Model getModel() {
      Spotanim var1 = Area.method4176(this.id);
      Model var2;
      if(!this.field1342) {
         var2 = var1.method4213(this.field1351);
      } else {
         var2 = var1.method4213(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;I)V",
      garbageValue = "-222148195"
   )
   public static void method1565(IndexDataBase var0) {
      class217.field2793 = var0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;LIndexDataBase;I)V",
      garbageValue = "-44243372"
   )
   public static void method1566(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
      class95.field1484 = var0;
      Sequence.field3614 = var1;
      Sequence.field3609 = var2;
   }
}
