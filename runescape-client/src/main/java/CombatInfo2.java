import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   public static IndexDataBase field3442;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   public static NodeCache field3432;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("spriteCache")
   static NodeCache spriteCache;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1125107845
   )
   public int field3439;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 892550485
   )
   public int field3444;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1741431987
   )
   public int field3437;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1090500473
   )
   public int field3438;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -959261487
   )
   public int field3436;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 125610261
   )
   public int field3440;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -703173573
   )
   int field3441;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2006972847
   )
   int field3434;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -790609031
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 4957129
   )
   public int field3431;

   static {
      field3432 = new NodeCache(64);
      spriteCache = new NodeCache(64);
   }

   public CombatInfo2() {
      this.field3444 = 255;
      this.field3437 = 255;
      this.field3438 = -1;
      this.field3436 = 1;
      this.field3440 = 70;
      this.field3441 = -1;
      this.field3434 = -1;
      this.healthScale = 30;
      this.field3431 = 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfr;I)V",
      garbageValue = "1686064451"
   )
   public void method4547(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4554(var1, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfr;II)V",
      garbageValue = "831015198"
   )
   void method4554(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3444 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3437 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3438 = 0;
      } else if(var2 == 5) {
         this.field3440 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3441 = var1.method3444();
      } else if(var2 == 8) {
         this.field3434 = var1.method3444();
      } else if(var2 == 11) {
         this.field3438 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3431 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Lky;",
      garbageValue = "355451949"
   )
   public SpritePixels method4549() {
      if(this.field3441 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3441);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ClassInfo.method5123(class74.field864, this.field3441, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3441);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Lky;",
      garbageValue = "1266240834"
   )
   public SpritePixels method4550() {
      if(this.field3434 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3434);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ClassInfo.method5123(class74.field864, this.field3434, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3434);
            }

            return var1;
         }
      }
   }
}
