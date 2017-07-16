import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   public static NodeCache field3364;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("spriteCache")
   static NodeCache spriteCache;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   public static IndexDataBase field3373;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1082279979
   )
   int field3374;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 589599629
   )
   int field3371;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -650680179
   )
   public int field3368;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1200837151
   )
   public int field3365;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 65479459
   )
   public int field3369;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -168432271
   )
   public int field3372;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1785813931
   )
   public int field3363;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2015857139
   )
   public int field3366;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1224973585
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1101286281
   )
   public int field3376;

   static {
      field3364 = new NodeCache(64);
      spriteCache = new NodeCache(64);
   }

   public CombatInfo2() {
      this.field3368 = 255;
      this.field3369 = 255;
      this.field3365 = -1;
      this.field3363 = 1;
      this.field3372 = 70;
      this.field3371 = -1;
      this.field3374 = -1;
      this.healthScale = 30;
      this.field3376 = 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfe;II)V",
      garbageValue = "-1722354429"
   )
   void method4348(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3368 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3369 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3365 = 0;
      } else if(var2 == 5) {
         this.field3372 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3371 = var1.method3221();
      } else if(var2 == 8) {
         this.field3374 = var1.method3221();
      } else if(var2 == 11) {
         this.field3365 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3376 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfe;B)V",
      garbageValue = "28"
   )
   public void method4352(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4348(var1, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Ljt;",
      garbageValue = "-1271518056"
   )
   public SpritePixels method4351() {
      if(this.field3374 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3374);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class27.method217(class293.field3898, this.field3374, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3374);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Ljt;",
      garbageValue = "245787093"
   )
   public SpritePixels method4342() {
      if(this.field3371 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3371);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class27.method217(class293.field3898, this.field3371, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3371);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1124839790"
   )
   @Export("getSmoothNoise2D")
   static final int getSmoothNoise2D(int var0, int var1) {
      int var2 = Varcs.method1804(var0 - 1, var1 - 1) + Varcs.method1804(var0 + 1, var1 - 1) + Varcs.method1804(var0 - 1, var1 + 1) + Varcs.method1804(var0 + 1, var1 + 1);
      int var3 = Varcs.method1804(var0 - 1, var1) + Varcs.method1804(var0 + 1, var1) + Varcs.method1804(var0, var1 - 1) + Varcs.method1804(var0, var1 + 1);
      int var4 = Varcs.method1804(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }
}
