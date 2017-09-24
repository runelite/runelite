import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   public static NodeCache field3366;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("spriteCache")
   public static NodeCache spriteCache;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   public static IndexDataBase field3370;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   static IndexDataBase field3367;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1541865927
   )
   int field3375;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1257996799
   )
   int field3374;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1581297833
   )
   public int field3364;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1713140159
   )
   public int field3368;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1692417737
   )
   public int field3371;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2024007577
   )
   public int field3373;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 408860433
   )
   public int field3369;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1569001803
   )
   public int field3372;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2049922205
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -958512553
   )
   public int field3377;

   static {
      field3366 = new NodeCache(64);
      spriteCache = new NodeCache(64);
   }

   public CombatInfo2() {
      this.field3364 = 255;
      this.field3368 = 255;
      this.field3371 = -1;
      this.field3372 = 1;
      this.field3373 = 70;
      this.field3374 = -1;
      this.field3375 = -1;
      this.healthScale = 30;
      this.field3377 = 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "-1440267958"
   )
   void method4405(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3364 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3368 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3371 = 0;
      } else if(var2 == 5) {
         this.field3373 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3374 = var1.method3262();
      } else if(var2 == 8) {
         this.field3375 = var1.method3262();
      } else if(var2 == 11) {
         this.field3371 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3377 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lfp;B)V",
      garbageValue = "3"
   )
   public void method4397(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4405(var1, var2);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Lkd;",
      garbageValue = "-2145883167"
   )
   public SpritePixels method4398() {
      if(this.field3375 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3375);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class255.method4507(field3367, this.field3375, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3375);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Lkd;",
      garbageValue = "1069742855"
   )
   public SpritePixels method4400() {
      if(this.field3374 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3374);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class255.method4507(field3367, this.field3374, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3374);
            }

            return var1;
         }
      }
   }
}
