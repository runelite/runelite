import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   public static NodeCache field3340;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("spriteCache")
   static NodeCache spriteCache;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field3336;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field3342;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1303227347
   )
   int field3337;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1927888501
   )
   int field3347;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1449377351
   )
   public int field3341;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -338151717
   )
   public int field3343;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -28310555
   )
   public int field3339;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 584400351
   )
   public int field3346;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 486753517
   )
   public int field3344;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2074073443
   )
   public int field3345;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1223295897
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1830494327
   )
   public int field3349;

   static {
      field3340 = new NodeCache(64);
      spriteCache = new NodeCache(64);
   }

   public CombatInfo2() {
      this.field3341 = 255;
      this.field3339 = 255;
      this.field3343 = -1;
      this.field3344 = 1;
      this.field3346 = 70;
      this.field3337 = -1;
      this.field3347 = -1;
      this.healthScale = 30;
      this.field3349 = 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "-1284723681"
   )
   void method4280(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3341 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3339 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3343 = 0;
      } else if(var2 == 5) {
         this.field3346 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3337 = var1.method3266();
      } else if(var2 == 8) {
         this.field3347 = var1.method3266();
      } else if(var2 == 11) {
         this.field3343 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3349 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "-665904079"
   )
   public void method4279(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4280(var1, var2);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Ljj;",
      garbageValue = "-197692610"
   )
   public SpritePixels method4290() {
      if(this.field3347 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3347);
         if(var1 != null) {
            return var1;
         } else {
            var1 = NPCComposition.method4549(field3342, this.field3347, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3347);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Ljj;",
      garbageValue = "-22"
   )
   public SpritePixels method4281() {
      if(this.field3337 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3337);
         if(var1 != null) {
            return var1;
         } else {
            var1 = NPCComposition.method4549(field3342, this.field3337, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3337);
            }

            return var1;
         }
      }
   }
}
