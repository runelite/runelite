import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static IndexDataBase field3447;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static IndexDataBase field3443;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   static NodeCache field3442;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("spriteCache")
   static NodeCache spriteCache;
   @ObfuscatedName("ar")
   static java.awt.Font field3457;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -268771295
   )
   public int field3448;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1025430515
   )
   public int field3449;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1530570721
   )
   public int field3445;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -19541547
   )
   public int field3450;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1487722645
   )
   public int field3451;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2135812517
   )
   public int field3452;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 790467273
   )
   int field3453;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1260090253
   )
   int field3446;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1052161583
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 445719529
   )
   public int field3456;

   static {
      field3442 = new NodeCache(64);
      spriteCache = new NodeCache(64);
   }

   CombatInfo2() {
      this.field3449 = 255;
      this.field3445 = 255;
      this.field3450 = -1;
      this.field3451 = 1;
      this.field3452 = 70;
      this.field3453 = -1;
      this.field3446 = -1;
      this.healthScale = 30;
      this.field3456 = 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "1585173146"
   )
   @Export("read")
   void read(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "2043380151"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3449 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3445 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3450 = 0;
      } else if(var2 == 5) {
         this.field3452 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3453 = var1.method3715();
      } else if(var2 == 8) {
         this.field3446 = var1.method3715();
      } else if(var2 == 11) {
         this.field3450 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3456 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Lki;",
      garbageValue = "918901773"
   )
   public SpritePixels method4794() {
      if(this.field3453 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3453);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ScriptEvent.method1074(field3443, this.field3453, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3453);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Lki;",
      garbageValue = "1313818477"
   )
   public SpritePixels method4795() {
      if(this.field3446 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3446);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ScriptEvent.method1074(field3443, this.field3446, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3446);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lir;III)[Lki;",
      garbageValue = "-401646347"
   )
   static SpritePixels[] method4796(IndexDataBase var0, int var1, int var2) {
      return !class35.method484(var0, var1, var2)?null:class54.method753();
   }
}
