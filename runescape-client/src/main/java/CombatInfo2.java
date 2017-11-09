import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field3420;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   static IndexDataBase field3421;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   public static NodeCache field3416;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("spriteCache")
   static NodeCache spriteCache;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2077767899
   )
   public int field3419;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1236993219
   )
   public int field3422;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1410254641
   )
   public int field3425;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2014883651
   )
   public int field3415;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1107044043
   )
   public int field3427;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 856879843
   )
   public int field3426;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1945234919
   )
   int field3417;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 500310163
   )
   int field3428;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1369098535
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2040892959
   )
   public int field3430;

   static {
      field3416 = new NodeCache(64);
      spriteCache = new NodeCache(64);
   }

   public CombatInfo2() {
      this.field3422 = 255;
      this.field3425 = 255;
      this.field3415 = -1;
      this.field3427 = 1;
      this.field3426 = 70;
      this.field3417 = -1;
      this.field3428 = -1;
      this.healthScale = 30;
      this.field3430 = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfv;B)V",
      garbageValue = "-125"
   )
   public void method4572(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4573(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfv;II)V",
      garbageValue = "-453910253"
   )
   void method4573(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3422 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3425 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3415 = 0;
      } else if(var2 == 5) {
         this.field3426 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3417 = var1.method3301();
      } else if(var2 == 8) {
         this.field3428 = var1.method3301();
      } else if(var2 == 11) {
         this.field3415 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3430 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Lkd;",
      garbageValue = "-3"
   )
   public SpritePixels method4574() {
      if(this.field3417 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3417);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class21.method176(field3421, this.field3417, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3417);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Lkd;",
      garbageValue = "659605663"
   )
   public SpritePixels method4584() {
      if(this.field3428 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3428);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class21.method176(field3421, this.field3428, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3428);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "964737463"
   )
   static void method4592() {
      for(class81 var0 = (class81)class81.field1250.getFront(); var0 != null; var0 = (class81)class81.field1250.getNext()) {
         if(var0.field1245 != null) {
            class268.field3675.method1984(var0.field1245);
            var0.field1245 = null;
         }

         if(var0.field1243 != null) {
            class268.field3675.method1984(var0.field1243);
            var0.field1243 = null;
         }
      }

      class81.field1250.clear();
   }
}
