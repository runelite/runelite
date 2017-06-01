import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1547642001
   )
   int field3361;
   @ObfuscatedName("e")
   public static NodeCache field3362;
   @ObfuscatedName("v")
   @Export("spriteCache")
   public static NodeCache spriteCache;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -561918135
   )
   public int field3364;
   @ObfuscatedName("c")
   public static IndexDataBase field3365;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1654283003
   )
   public int field3366;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1465010611
   )
   public int field3367;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2114076103
   )
   public int field3368;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -130467439
   )
   public int field3369;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1370642371
   )
   public int field3370;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1217782983
   )
   int field3371;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1729546445
   )
   public int field3372;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1904694843
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("i")
   public static IndexDataBase field3374;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1720103568"
   )
   void method4397(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4408(var1, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "-73"
   )
   public SpritePixels method4399() {
      if(this.field3361 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3361);
         if(var1 != null) {
            return var1;
         } else {
            var1 = GameEngine.method827(field3365, this.field3361, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3361);
            }

            return var1;
         }
      }
   }

   CombatInfo2() {
      this.field3366 = 255;
      this.field3367 = 255;
      this.field3368 = -1;
      this.field3369 = 1;
      this.field3370 = 70;
      this.field3361 = -1;
      this.field3371 = -1;
      this.healthScale = 30;
      this.field3372 = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "-78"
   )
   public SpritePixels method4403() {
      if(this.field3371 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3371);
         if(var1 != null) {
            return var1;
         } else {
            var1 = GameEngine.method827(field3365, this.field3371, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3371);
            }

            return var1;
         }
      }
   }

   static {
      field3362 = new NodeCache(64);
      spriteCache = new NodeCache(64);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;IS)V",
      garbageValue = "-18379"
   )
   void method4408(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3366 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3367 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3368 = 0;
      } else if(var2 == 5) {
         this.field3370 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3361 = var1.method3156();
      } else if(var2 == 8) {
         this.field3371 = var1.method3156();
      } else if(var2 == 11) {
         this.field3368 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3372 = var1.readUnsignedByte();
      }

   }
}
