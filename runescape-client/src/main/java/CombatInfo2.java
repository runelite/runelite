import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static IndexDataBase field3515;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static IndexDataBase field3516;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   public static NodeCache field3527;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   static NodeCache field3517;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 562830341
   )
   public int field3518;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1619343767
   )
   public int field3521;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1723075319
   )
   public int field3526;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -79294923
   )
   public int field3523;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1648251431
   )
   public int field3524;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1395224905
   )
   public int field3525;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -225881905
   )
   int field3531;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1050448615
   )
   int field3522;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1750760177
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 807495615
   )
   public int field3529;

   static {
      field3527 = new NodeCache(64);
      field3517 = new NodeCache(64);
   }

   public CombatInfo2() {
      this.field3521 = 255;
      this.field3526 = 255;
      this.field3523 = -1;
      this.field3524 = 1;
      this.field3525 = 70;
      this.field3531 = -1;
      this.field3522 = -1;
      this.healthScale = 30;
      this.field3529 = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "168331486"
   )
   @Export("read")
   public void read(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "287601448"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3521 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3526 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3523 = 0;
      } else if(var2 == 5) {
         this.field3525 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3531 = var1.method3617();
      } else if(var2 == 8) {
         this.field3522 = var1.method3617();
      } else if(var2 == 11) {
         this.field3523 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3529 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Lly;",
      garbageValue = "1750083223"
   )
   public SpritePixels method4996() {
      if(this.field3531 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3517.get((long)this.field3531);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class45.method640(field3516, this.field3531, 0);
            if(var1 != null) {
               field3517.put(var1, (long)this.field3531);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lly;",
      garbageValue = "-1876617448"
   )
   public SpritePixels method4997() {
      if(this.field3522 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3517.get((long)this.field3522);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class45.method640(field3516, this.field3522, 0);
            if(var1 != null) {
               field3517.put(var1, (long)this.field3522);
            }

            return var1;
         }
      }
   }
}
