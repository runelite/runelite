import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -783929309
   )
   public int field3372;
   @ObfuscatedName("w")
   static IndexDataBase field3373;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2043221263
   )
   int field3374;
   @ObfuscatedName("a")
   public static NodeCache field3375;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2083383579
   )
   public int field3376;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1538707863
   )
   public int field3378;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1245291667
   )
   public int field3379;
   @ObfuscatedName("i")
   public static IndexDataBase field3380;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1464769615
   )
   public int field3381;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 738766821
   )
   public int field3382;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 644349987
   )
   int field3383;
   @ObfuscatedName("t")
   @Export("spriteCache")
   public static NodeCache spriteCache;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 800773671
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -188952331
   )
   public int field3386;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;IS)V",
      garbageValue = "2122"
   )
   void method4402(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3372 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3379 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3378 = 0;
      } else if(var2 == 5) {
         this.field3382 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3383 = var1.method3130();
      } else if(var2 == 8) {
         this.field3374 = var1.method3130();
      } else if(var2 == 11) {
         this.field3378 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3386 = var1.readUnsignedByte();
      }

   }

   static {
      field3375 = new NodeCache(64);
      spriteCache = new NodeCache(64);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1940924409"
   )
   public SpritePixels method4405() {
      if(this.field3383 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3383);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ObjectComposition.method4574(field3373, this.field3383, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3383);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-393579221"
   )
   public SpritePixels method4410() {
      if(this.field3374 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3374);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ObjectComposition.method4574(field3373, this.field3374, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3374);
            }

            return var1;
         }
      }
   }

   public CombatInfo2() {
      this.field3372 = 255;
      this.field3379 = 255;
      this.field3378 = -1;
      this.field3381 = 1;
      this.field3382 = 70;
      this.field3383 = -1;
      this.field3374 = -1;
      this.healthScale = 30;
      this.field3386 = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1575469522"
   )
   public void method4418(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4402(var1, var2);
      }
   }
}
