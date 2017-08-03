import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("GraphicsObject")
public final class GraphicsObject extends Renderable {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ldh;"
   )
   static class105 field1325;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -169788747
   )
   @Export("id")
   int id;
   @ObfuscatedName("r")
   @Export("finished")
   boolean finished;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 108114445
   )
   int field1323;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1036311885
   )
   int field1327;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   Sequence field1321;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 607911205
   )
   @Export("level")
   int level;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1876969309
   )
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 222434989
   )
   @Export("y")
   int y;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 249424869
   )
   @Export("height")
   int height;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2113548905
   )
   @Export("startCycle")
   int startCycle;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1327 = 0;
      this.field1323 = 0;
      this.finished = false;
      this.id = var1;
      this.level = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.startCycle = var7 + var6;
      int var8 = class36.getSpotAnimType(this.id).field3309;
      if(var8 != -1) {
         this.finished = false;
         this.field1321 = class40.getAnimation(var8);
      } else {
         this.finished = true;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lev;",
      garbageValue = "1458652918"
   )
   protected final Model getModel() {
      Spotanim var1 = class36.getSpotAnimType(this.id);
      Model var2;
      if(!this.finished) {
         var2 = var1.method4310(this.field1327);
      } else {
         var2 = var1.method4310(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1348360135"
   )
   final void method1685(int var1) {
      if(!this.finished) {
         this.field1323 += var1;

         while(this.field1323 > this.field1321.frameLenghts[this.field1327]) {
            this.field1323 -= this.field1321.frameLenghts[this.field1327];
            ++this.field1327;
            if(this.field1327 >= this.field1321.frameIDs.length) {
               this.finished = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("q")
   public static String method1686(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class268.field3656[(int)(var6 - 37L * var0)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }
}
