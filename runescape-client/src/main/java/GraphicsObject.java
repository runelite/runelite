import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("GraphicsObject")
public final class GraphicsObject extends Renderable {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ljv;"
   )
   @Export("currentRequest")
   static FileRequest currentRequest;
   @ObfuscatedName("bc")
   @Export("sessionToken")
   static String sessionToken;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1927183795
   )
   @Export("id")
   int id;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1362767529
   )
   @Export("startCycle")
   int startCycle;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1796546393
   )
   @Export("level")
   int level;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2000708757
   )
   @Export("x")
   int x;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1059478129
   )
   @Export("y")
   int y;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -650341429
   )
   @Export("height")
   int height;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   Sequence field1288;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 449457039
   )
   int field1289;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 65111647
   )
   int field1290;
   @ObfuscatedName("r")
   @Export("finished")
   boolean finished;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1289 = 0;
      this.field1290 = 0;
      this.finished = false;
      this.id = var1;
      this.level = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.startCycle = var7 + var6;
      int var8 = class249.getSpotAnimType(this.id).field3494;
      if(var8 != -1) {
         this.finished = false;
         this.field1288 = ISAACCipher.getAnimation(var8);
      } else {
         this.finished = true;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "95"
   )
   final void method1804(int var1) {
      if(!this.finished) {
         this.field1290 += var1;

         while(this.field1290 > this.field1288.frameLengths[this.field1289]) {
            this.field1290 -= this.field1288.frameLengths[this.field1289];
            ++this.field1289;
            if(this.field1289 >= this.field1288.frameIDs.length) {
               this.finished = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Led;",
      garbageValue = "-83"
   )
   protected final Model getModel() {
      Spotanim var1 = class249.getSpotAnimType(this.id);
      Model var2;
      if(!this.finished) {
         var2 = var1.getModel(this.field1289);
      } else {
         var2 = var1.getModel(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("i")
   public static String method1798(long var0) {
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
               var8 = class316.field3922[(int)(var6 - var0 * 37L)];
               if(var8 == '_') {
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)[Ljl;",
      garbageValue = "851676325"
   )
   static HorizontalAlignment[] method1805() {
      return new HorizontalAlignment[]{HorizontalAlignment.field3694, HorizontalAlignment.field3690, HorizontalAlignment.field3691};
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "1467091323"
   )
   static int method1797(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class3.getWidget(class81.intStack[--SceneTilePaint.intStackSize]);
      } else {
         var3 = var2?class336.field4073:class61.field713;
      }

      if(var0 == 1927) {
         if(class81.field1278 >= 10) {
            throw new RuntimeException();
         } else if(var3.onResizeListener == null) {
            return 0;
         } else {
            ScriptEvent var4 = new ScriptEvent();
            var4.widget = var3;
            var4.objs = var3.onResizeListener;
            var4.field788 = class81.field1278 + 1;
            Client.field1054.addFront(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }
}
