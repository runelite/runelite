import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   static IndexDataBase field3452;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   public static NodeCache field3443;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   @Export("spriteCache")
   public static NodeCache spriteCache;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1415084779
   )
   public int field3455;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -962726841
   )
   public int field3447;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -969717461
   )
   public int field3448;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 639263169
   )
   public int field3449;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 632784511
   )
   public int field3450;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1965666463
   )
   public int field3451;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2140939835
   )
   int field3442;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2032713791
   )
   int field3453;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -500589715
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -599235073
   )
   public int field3445;

   static {
      field3443 = new NodeCache(64);
      spriteCache = new NodeCache(64);
   }

   CombatInfo2() {
      this.field3447 = 255;
      this.field3448 = 255;
      this.field3449 = -1;
      this.field3450 = 1;
      this.field3451 = 70;
      this.field3442 = -1;
      this.field3453 = -1;
      this.healthScale = 30;
      this.field3445 = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgh;I)V",
      garbageValue = "-1624378745"
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgh;II)V",
      garbageValue = "1009114757"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3447 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3448 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3449 = 0;
      } else if(var2 == 5) {
         this.field3451 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3442 = var1.method3372();
      } else if(var2 == 8) {
         this.field3453 = var1.method3372();
      } else if(var2 == 11) {
         this.field3449 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3445 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Lks;",
      garbageValue = "-1368876635"
   )
   public SpritePixels method4536() {
      if(this.field3442 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3442);
         if(var1 != null) {
            return var1;
         } else {
            var1 = SocketSession.getSprite(class188.field2537, this.field3442, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3442);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Lks;",
      garbageValue = "2050097180"
   )
   public SpritePixels method4549() {
      if(this.field3453 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3453);
         if(var1 != null) {
            return var1;
         } else {
            var1 = SocketSession.getSprite(class188.field2537, this.field3453, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3453);
            }

            return var1;
         }
      }
   }
}
