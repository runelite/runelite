import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1628834211
   )
   int field3351;
   @ObfuscatedName("u")
   static NodeCache field3352;
   @ObfuscatedName("i")
   public static IndexDataBase field3353;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -940504673
   )
   public int field3354;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -809214603
   )
   public int field3357;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -770120419
   )
   public int field3358;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 174005871
   )
   public int field3359;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 152970847
   )
   public int field3360;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -604812389
   )
   int field3362;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -403631785
   )
   public int field3363;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1055542607
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2063815953
   )
   public int field3365;
   @ObfuscatedName("q")
   @Export("spriteCache")
   static NodeCache spriteCache;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1980343374"
   )
   void method4465(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4477(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-382756000"
   )
   public SpritePixels method4467() {
      if(this.field3362 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3362);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class123.method2381(class265.field3654, this.field3362, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3362);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1619381437"
   )
   public SpritePixels method4468() {
      if(this.field3351 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3351);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class123.method2381(class265.field3654, this.field3351, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3351);
            }

            return var1;
         }
      }
   }

   static {
      field3352 = new NodeCache(64);
      spriteCache = new NodeCache(64);
   }

   CombatInfo2() {
      this.field3357 = 255;
      this.field3358 = 255;
      this.field3363 = -1;
      this.field3360 = 1;
      this.field3359 = 70;
      this.field3362 = -1;
      this.field3351 = -1;
      this.healthScale = 30;
      this.field3365 = 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "783142762"
   )
   void method4477(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3357 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3358 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3363 = 0;
      } else if(var2 == 5) {
         this.field3359 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3362 = var1.method3214();
      } else if(var2 == 8) {
         this.field3351 = var1.method3214();
      } else if(var2 == 11) {
         this.field3363 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3365 = var1.readUnsignedByte();
      }

   }
}
