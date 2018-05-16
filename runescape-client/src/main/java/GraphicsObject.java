import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
@Implements("GraphicsObject")
public final class GraphicsObject extends Renderable {
   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   static BuildType field1042;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 930375409
   )
   @Export("id")
   int id;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 655944159
   )
   @Export("startCycle")
   int startCycle;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 611659329
   )
   @Export("level")
   int level;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 469231961
   )
   @Export("x")
   int x;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1901568555
   )
   @Export("y")
   int y;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2001790593
   )
   @Export("height")
   int height;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   Sequence field1038;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1488825937
   )
   int field1039;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -271875461
   )
   int field1040;
   @ObfuscatedName("a")
   @Export("finished")
   boolean finished;

   @Hook(
      value = "onGraphicsObjectCreated",
      end = true
   )
   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1039 = 0;
      this.field1040 = 0;
      this.finished = false;
      this.id = var1;
      this.level = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.startCycle = var7 + var6;
      int var8 = ScriptState.getSpotAnimType(this.id).field3292;
      if(var8 != -1) {
         this.finished = false;
         this.field1038 = class137.getAnimation(var8);
      } else {
         this.finished = true;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "677069676"
   )
   final void method1812(int var1) {
      if(!this.finished) {
         this.field1040 += var1;

         while(this.field1040 > this.field1038.frameLengths[this.field1039]) {
            this.field1040 -= this.field1038.frameLengths[this.field1039];
            ++this.field1039;
            if(this.field1039 >= this.field1038.frameIDs.length) {
               this.finished = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Ldk;",
      garbageValue = "111"
   )
   protected final Model getModel() {
      Spotanim var1 = ScriptState.getSpotAnimType(this.id);
      Model var2;
      if(!this.finished) {
         var2 = var1.getModel(this.field1039);
      } else {
         var2 = var1.getModel(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Lcs;",
      garbageValue = "-74"
   )
   static Script method1806(int var0) {
      Script var1 = (Script)Script.field1214.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = TotalQuantityComparator.indexScripts.getConfigData(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = class143.newScript(var2);
            Script.field1214.put(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "24362530"
   )
   static final boolean method1813(char var0) {
      return var0 == 160 || var0 == ' ' || var0 == '_' || var0 == '-';
   }
}
