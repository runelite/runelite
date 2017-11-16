import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   public static IndexDataBase field3413;
   @ObfuscatedName("s")
   public static String field3421;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   public static NodeCache field3424;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("spriteCache")
   public static NodeCache spriteCache;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 883121465
   )
   public int field3414;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 996129277
   )
   public int field3415;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -620724283
   )
   public int field3416;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2097872433
   )
   public int field3417;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1929188697
   )
   public int field3412;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1958135965
   )
   public int field3411;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 73960029
   )
   int field3420;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1894737523
   )
   int field3419;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1610633527
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1828960431
   )
   public int field3423;

   static {
      field3424 = new NodeCache(64);
      spriteCache = new NodeCache(64);
   }

   CombatInfo2() {
      this.field3415 = 255;
      this.field3416 = 255;
      this.field3417 = -1;
      this.field3412 = 1;
      this.field3411 = 70;
      this.field3420 = -1;
      this.field3419 = -1;
      this.healthScale = 30;
      this.field3423 = 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfs;I)V",
      garbageValue = "-772812684"
   )
   void method4389(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4387(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfs;II)V",
      garbageValue = "756834059"
   )
   void method4387(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3415 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3416 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3417 = 0;
      } else if(var2 == 5) {
         this.field3411 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3420 = var1.method3201();
      } else if(var2 == 8) {
         this.field3419 = var1.method3201();
      } else if(var2 == 11) {
         this.field3417 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3423 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Lkb;",
      garbageValue = "24"
   )
   public SpritePixels method4385() {
      if(this.field3420 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3420);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class163.method3082(class18.field294, this.field3420, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3420);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lkb;",
      garbageValue = "-1837947450"
   )
   public SpritePixels method4393() {
      if(this.field3419 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3419);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class163.method3082(class18.field294, this.field3419, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3419);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgu;III)I",
      garbageValue = "110565234"
   )
   static int method4400(IterableHashTable var0, int var1, int var2) {
      if(var0 == null) {
         return var2;
      } else {
         IntegerNode var3 = (IntegerNode)var0.get((long)var1);
         return var3 == null?var2:var3.value;
      }
   }
}
