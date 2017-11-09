import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public final class class81 extends Node {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   static Deque field1250;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1820977215
   )
   int field1244;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1328823663
   )
   int field1239;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 238848311
   )
   int field1240;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1775270147
   )
   int field1237;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -543253857
   )
   int field1242;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1578033557
   )
   int field1241;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1482538967
   )
   int field1238;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ldp;"
   )
   class116 field1245;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1089837385
   )
   int field1246;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1652838451
   )
   int field1247;
   @ObfuscatedName("a")
   int[] field1248;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1297328563
   )
   int field1249;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ldp;"
   )
   class116 field1243;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   ObjectComposition field1251;

   static {
      field1250 = new Deque();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2007871833"
   )
   void method1689() {
      int var1 = this.field1238;
      ObjectComposition var2 = this.field1251.getImpostor();
      if(var2 != null) {
         this.field1238 = var2.ambientSoundId;
         this.field1241 = var2.field3511 * 128;
         this.field1246 = var2.field3533;
         this.field1247 = var2.field3534;
         this.field1248 = var2.field3535;
      } else {
         this.field1238 = -1;
         this.field1241 = 0;
         this.field1246 = 0;
         this.field1247 = 0;
         this.field1248 = null;
      }

      if(var1 != this.field1238 && this.field1245 != null) {
         class268.field3675.method1984(this.field1245);
         this.field1245 = null;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lik;IIS)[Lko;",
      garbageValue = "-13278"
   )
   static IndexedSprite[] method1694(IndexDataBase var0, int var1, int var2) {
      if(!class72.method1184(var0, var1, var2)) {
         return null;
      } else {
         IndexedSprite[] var4 = new IndexedSprite[class295.field3854];

         for(int var5 = 0; var5 < class295.field3854; ++var5) {
            IndexedSprite var6 = var4[var5] = new IndexedSprite();
            var6.width = class295.field3850;
            var6.originalHeight = class295.field3851;
            var6.offsetX = class295.field3853[var5];
            var6.offsetY = class37.offsetsY[var5];
            var6.originalWidth = ItemContainer.field745[var5];
            var6.height = class31.field428[var5];
            var6.palette = class295.field3852;
            var6.pixels = class295.spritePixels[var5];
         }

         class276.method5044();
         return var4;
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Ldq;I)V",
      garbageValue = "-918379410"
   )
   static final void method1699(class118 var0) {
      var0.field1636 = false;
      if(var0.field1635 != null) {
         var0.field1635.field1667 = 0;
      }

      for(class118 var1 = var0.vmethod4047(); var1 != null; var1 = var0.vmethod4048()) {
         method1699(var1);
      }

   }
}
