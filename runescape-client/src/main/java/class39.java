import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class39 {
   @ObfuscatedName("j")
   static int[] field515;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -975845327
   )
   public final int field512;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lht;"
   )
   public final Coordinates field514;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lht;"
   )
   public final Coordinates field509;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -512521611
   )
   final int field507;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 64457865
   )
   final int field511;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lae;"
   )
   final class33 field513;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1177219051
   )
   int field508;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1773897825
   )
   int field510;

   @ObfuscatedSignature(
      signature = "(ILht;Lht;Lae;)V"
   )
   class39(int var1, Coordinates var2, Coordinates var3, class33 var4) {
      this.field512 = var1;
      this.field509 = var2;
      this.field514 = var3;
      this.field513 = var4;
      Area var5 = Area.mapAreaType[this.field512];
      SpritePixels var6 = var5.getMapIcon(false);
      if(var6 != null) {
         this.field507 = var6.width;
         this.field511 = var6.height;
      } else {
         this.field507 = 0;
         this.field511 = 0;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1152623110"
   )
   boolean method532(int var1, int var2) {
      return this.method528(var1, var2)?true:this.method529(var1, var2);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1452903702"
   )
   boolean method528(int var1, int var2) {
      Area var3 = Area.mapAreaType[this.field512];
      switch(var3.field3397.field3627) {
      case 0:
         if(var1 >= this.field508 - this.field507 / 2 && var1 <= this.field507 / 2 + this.field508) {
            break;
         }

         return false;
      case 1:
         if(var1 >= this.field508 && var1 < this.field508 + this.field507) {
            break;
         }

         return false;
      case 2:
         if(var1 <= this.field508 - this.field507 || var1 > this.field508) {
            return false;
         }
      }

      switch(var3.field3380.field3368) {
      case 0:
         if(var2 >= this.field510 && var2 < this.field510 + this.field511) {
            break;
         }

         return false;
      case 1:
         if(var2 <= this.field510 - this.field511 || var2 > this.field510) {
            return false;
         }
         break;
      case 2:
         if(var2 < this.field510 - this.field511 / 2 || var2 > this.field511 / 2 + this.field510) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "117"
   )
   boolean method529(int var1, int var2) {
      return this.field513 == null?false:(var1 >= this.field508 - this.field513.field447 / 2 && var1 <= this.field513.field447 / 2 + this.field508?var2 >= this.field510 && var2 <= this.field513.field450 + this.field510:false);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lil;I)V",
      garbageValue = "-1386340147"
   )
   public static void method535(IndexDataBase var0) {
      class262.field3479 = var0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)[Lkm;",
      garbageValue = "50"
   )
   static IndexedSprite[] method536() {
      IndexedSprite[] var0 = new IndexedSprite[class299.field3872];

      for(int var1 = 0; var1 < class299.field3872; ++var1) {
         IndexedSprite var2 = var0[var1] = new IndexedSprite();
         var2.width = class299.field3868;
         var2.originalHeight = class299.field3867;
         var2.offsetX = class299.field3870[var1];
         var2.offsetY = class299.offsetsY[var1];
         var2.originalWidth = class54.field635[var1];
         var2.height = UrlRequester.field2099[var1];
         var2.palette = class299.field3869;
         var2.pixels = class188.spritePixels[var1];
      }

      class139.method2922();
      return var0;
   }

   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-73588687"
   )
   static final void method534(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(FontName.loadWidget(var0)) {
         WorldMapType1.method238(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }
}
