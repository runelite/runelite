import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("p")
   public static IndexDataBase field3372;
   @ObfuscatedName("t")
   @Export("spriteCache")
   public static NodeCache spriteCache;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 402650451
   )
   public int field3374;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 430455505
   )
   public int field3375;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 502005545
   )
   public int field3376;
   @ObfuscatedName("e")
   public static NodeCache field3377;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 168561639
   )
   int field3378;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1992400461
   )
   public int field3379;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1443561883
   )
   int field3380;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1219491937
   )
   public int field3381;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1413584657
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1669804959
   )
   public int field3383;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1705020909
   )
   public int field3384;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-81"
   )
   public void method4276(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4282(var1, var2);
      }
   }

   public CombatInfo2() {
      this.field3375 = 255;
      this.field3376 = 255;
      this.field3384 = -1;
      this.field3381 = 1;
      this.field3379 = 70;
      this.field3380 = -1;
      this.field3378 = -1;
      this.healthScale = 30;
      this.field3383 = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1522822141"
   )
   public SpritePixels method4278() {
      if(this.field3378 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3378);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class262.method4613(class280.field3751, this.field3378, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3378);
            }

            return var1;
         }
      }
   }

   static {
      field3377 = new NodeCache(64);
      spriteCache = new NodeCache(64);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-18"
   )
   public static void method4279() {
      Overlay.field3597.reset();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "2132505954"
   )
   public SpritePixels method4280() {
      if(this.field3380 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3380);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class262.method4613(class280.field3751, this.field3380, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3380);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "503703102"
   )
   void method4282(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3375 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3376 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3384 = 0;
      } else if(var2 == 5) {
         this.field3379 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3380 = var1.method3048();
      } else if(var2 == 8) {
         this.field3378 = var1.method3048();
      } else if(var2 == 11) {
         this.field3384 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3383 = var1.readUnsignedByte();
      }

   }
}
