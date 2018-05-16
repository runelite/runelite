import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
public class class224 extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1466502535
   )
   public final int field2570;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -889955413
   )
   public final int field2575;
   @ObfuscatedName("q")
   public final int[] field2572;
   @ObfuscatedName("b")
   public final int[] field2573;

   class224(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2570 = var1;
      this.field2575 = var2;
      this.field2572 = var3;
      this.field2573 = var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1611464927"
   )
   public boolean method4459(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2573.length) {
         int var3 = this.field2573[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2572[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II)I",
      garbageValue = "-385243999"
   )
   public static int method4460(CharSequence var0, int var1) {
      return GrandExchangeEvents.parseInt(var0, var1, true);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/io/File;",
      garbageValue = "0"
   )
   public static File method4458(String var0) {
      if(!class158.field2001) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class158.field2002.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class158.field2000, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class158.field2002.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Llh;",
      garbageValue = "44372009"
   )
   static IndexedSprite method4461() {
      IndexedSprite var0 = new IndexedSprite();
      var0.originalWidth = class319.indexedSpriteWidth;
      var0.originalHeight = class275.indexedSpriteHeight;
      var0.offsetX = class319.indexedSpriteOffsetXs[0];
      var0.offsetY = class319.indexedSpriteOffsetYs[0];
      var0.width = class192.indexSpriteWidths[0];
      var0.height = class319.indexedSpriteHeights[0];
      var0.palette = class319.indexedSpritePalette;
      var0.pixels = class294.spritePixels[0];
      class319.indexedSpriteOffsetXs = null;
      class319.indexedSpriteOffsetYs = null;
      class192.indexSpriteWidths = null;
      class319.indexedSpriteHeights = null;
      class319.indexedSpritePalette = null;
      class294.spritePixels = null;
      return var0;
   }
}
