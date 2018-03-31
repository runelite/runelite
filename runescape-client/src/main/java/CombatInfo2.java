import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jo")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      intValue = 53282281
   )
   static int field3523;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static NodeCache field3525;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static NodeCache field3518;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1488961773
   )
   public int field3529;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1410397953
   )
   public int field3520;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1657176423
   )
   public int field3521;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1926633055
   )
   public int field3522;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1339626341
   )
   public int field3517;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1403177961
   )
   public int field3524;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1982574749
   )
   int field3519;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1127106873
   )
   int field3526;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 839223867
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -844312507
   )
   public int field3528;

   static {
      field3525 = new NodeCache(64);
      field3518 = new NodeCache(64);
   }

   CombatInfo2() {
      this.field3520 = 255;
      this.field3521 = 255;
      this.field3522 = -1;
      this.field3517 = 1;
      this.field3524 = 70;
      this.field3519 = -1;
      this.field3526 = -1;
      this.healthScale = 30;
      this.field3528 = 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgp;I)V",
      garbageValue = "419725527"
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgp;II)V",
      garbageValue = "-1540761505"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3520 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3521 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3522 = 0;
      } else if(var2 == 5) {
         this.field3524 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3519 = var1.method3603();
      } else if(var2 == 8) {
         this.field3526 = var1.method3603();
      } else if(var2 == 11) {
         this.field3522 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3528 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Lla;",
      garbageValue = "69"
   )
   public SpritePixels method4860() {
      if(this.field3519 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3518.get((long)this.field3519);
         if(var1 != null) {
            return var1;
         } else {
            var1 = BufferProvider.method5831(class316.field3919, this.field3519, 0);
            if(var1 != null) {
               field3518.put(var1, (long)this.field3519);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Lla;",
      garbageValue = "0"
   )
   public SpritePixels method4873() {
      if(this.field3526 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3518.get((long)this.field3526);
         if(var1 != null) {
            return var1;
         } else {
            var1 = BufferProvider.method5831(class316.field3919, this.field3526, 0);
            if(var1 != null) {
               field3518.put(var1, (long)this.field3526);
            }

            return var1;
         }
      }
   }
}
