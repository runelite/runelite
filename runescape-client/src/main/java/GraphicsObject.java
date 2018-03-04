import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("GraphicsObject")
public final class GraphicsObject extends Renderable {
   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "[Lly;"
   )
   static SpritePixels[] field1281;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2105942087
   )
   @Export("id")
   int id;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1037460267
   )
   @Export("height")
   int height;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -48673085
   )
   @Export("startCycle")
   int startCycle;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1166398559
   )
   @Export("level")
   int level;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -355086313
   )
   @Export("x")
   int x;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   Sequence field1273;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1602381041
   )
   @Export("y")
   int y;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2129634309
   )
   int field1278;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 970573433
   )
   int field1279;
   @ObfuscatedName("x")
   @Export("finished")
   boolean finished;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1278 = 0;
      this.field1279 = 0;
      this.finished = false;
      this.id = var1;
      this.level = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.startCycle = var7 + var6;
      int var8 = class55.getSpotAnimType(this.id).field3484;
      if(var8 != -1) {
         this.finished = false;
         this.field1273 = class270.getAnimation(var8);
      } else {
         this.finished = true;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1028369468"
   )
   final void method1835(int var1) {
      if(!this.finished) {
         this.field1279 += var1;

         while(this.field1279 > this.field1273.frameLenghts[this.field1278]) {
            this.field1279 -= this.field1273.frameLenghts[this.field1278];
            ++this.field1278;
            if(this.field1278 >= this.field1273.frameIDs.length) {
               this.finished = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lel;",
      garbageValue = "2099798459"
   )
   protected final Model getModel() {
      Spotanim var1 = class55.getSpotAnimType(this.id);
      Model var2;
      if(!this.finished) {
         var2 = var1.getModel(this.field1278);
      } else {
         var2 = var1.getModel(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("d")
   public static final int method1845(double var0, double var2, double var4) {
      double var6 = var4;
      double var8 = var4;
      double var10 = var4;
      if(var2 != 0.0D) {
         double var12;
         if(var4 < 0.5D) {
            var12 = var4 * (1.0D + var2);
         } else {
            var12 = var4 + var2 - var4 * var2;
         }

         double var14 = 2.0D * var4 - var12;
         double var16 = 0.3333333333333333D + var0;
         if(var16 > 1.0D) {
            --var16;
         }

         double var20 = var0 - 0.3333333333333333D;
         if(var20 < 0.0D) {
            ++var20;
         }

         if(var16 * 6.0D < 1.0D) {
            var6 = var14 + var16 * 6.0D * (var12 - var14);
         } else if(var16 * 2.0D < 1.0D) {
            var6 = var12;
         } else if(3.0D * var16 < 2.0D) {
            var6 = (0.6666666666666666D - var16) * (var12 - var14) * 6.0D + var14;
         } else {
            var6 = var14;
         }

         if(var0 * 6.0D < 1.0D) {
            var8 = var14 + var0 * 6.0D * (var12 - var14);
         } else if(2.0D * var0 < 1.0D) {
            var8 = var12;
         } else if(3.0D * var0 < 2.0D) {
            var8 = (0.6666666666666666D - var0) * (var12 - var14) * 6.0D + var14;
         } else {
            var8 = var14;
         }

         if(6.0D * var20 < 1.0D) {
            var10 = var20 * (var12 - var14) * 6.0D + var14;
         } else if(var20 * 2.0D < 1.0D) {
            var10 = var12;
         } else if(3.0D * var20 < 2.0D) {
            var10 = var14 + 6.0D * (var12 - var14) * (0.6666666666666666D - var20);
         } else {
            var10 = var14;
         }
      }

      int var22 = (int)(var6 * 256.0D);
      int var13 = (int)(var8 * 256.0D);
      int var23 = (int)(var10 * 256.0D);
      int var15 = var23 + (var13 << 8) + (var22 << 16);
      return var15;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "35"
   )
   static int method1841(int var0) {
      MessageNode var1 = (MessageNode)class95.messages.get((long)var0);
      return var1 == null?-1:(var1.next == class95.field1431.sentinel?-1:((MessageNode)var1.next).id);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-374903958"
   )
   public static void method1847() {
      Area.areaSpriteCache.reset();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "839199366"
   )
   static String method1842() {
      String var0 = "";

      MessageNode var2;
      for(Iterator var1 = class95.messages.iterator(); var1.hasNext(); var0 = var0 + var2.name + ':' + var2.value + '\n') {
         var2 = (MessageNode)var1.next();
      }

      return var0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "53"
   )
   public static int method1844(String var0) {
      return var0.length() + 2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljk;IB)Z",
      garbageValue = "1"
   )
   static boolean method1846(IndexDataBase var0, int var1) {
      byte[] var2 = var0.takeRecordFlat(var1);
      if(var2 == null) {
         return false;
      } else {
         FontName.decodeSprite(var2);
         return true;
      }
   }
}
