import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   static NodeCache field3362;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("spriteCache")
   static NodeCache spriteCache;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   public static IndexDataBase field3357;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   public static IndexDataBase field3355;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 303027823
   )
   int field3358;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 628158287
   )
   int field3364;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1530119305
   )
   public int field3359;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 730618307
   )
   public int field3360;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1157743717
   )
   public int field3365;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2102523895
   )
   public int field3363;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -191407063
   )
   public int field3356;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -929602855
   )
   public int field3368;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 462909261
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1379414537
   )
   public int field3354;

   static {
      field3362 = new NodeCache(64);
      spriteCache = new NodeCache(64);
   }

   CombatInfo2() {
      this.field3359 = 255;
      this.field3360 = 255;
      this.field3365 = -1;
      this.field3368 = 1;
      this.field3363 = 70;
      this.field3364 = -1;
      this.field3358 = -1;
      this.healthScale = 30;
      this.field3354 = 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfh;II)V",
      garbageValue = "85721279"
   )
   void method4406(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3359 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3360 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3365 = 0;
      } else if(var2 == 5) {
         this.field3363 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3364 = var1.method3190();
      } else if(var2 == 8) {
         this.field3358 = var1.method3190();
      } else if(var2 == 11) {
         this.field3365 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3354 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfh;I)V",
      garbageValue = "138502640"
   )
   void method4410(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4406(var1, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Lkn;",
      garbageValue = "-2075197183"
   )
   public SpritePixels method4409() {
      if(this.field3358 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3358);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class64.method1087(field3355, this.field3358, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3358);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Lkn;",
      garbageValue = "-1611926161"
   )
   public SpritePixels method4407() {
      if(this.field3364 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3364);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class64.method1087(field3355, this.field3364, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3364);
            }

            return var1;
         }
      }
   }
}
