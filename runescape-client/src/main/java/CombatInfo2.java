import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jb")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   public static IndexDataBase field3525;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static NodeCache field3527;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static NodeCache field3526;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 351419871
   )
   public int field3536;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -559703545
   )
   public int field3528;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 828806111
   )
   public int field3529;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1274481057
   )
   public int field3530;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1712411297
   )
   public int field3524;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -14536517
   )
   public int field3532;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 812646165
   )
   int field3533;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1904092279
   )
   int field3534;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1505543635
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -747496313
   )
   public int field3531;

   static {
      field3527 = new NodeCache(64);
      field3526 = new NodeCache(64);
   }

   public CombatInfo2() {
      this.field3528 = 255;
      this.field3529 = 255;
      this.field3530 = -1;
      this.field3524 = 1;
      this.field3532 = 70;
      this.field3533 = -1;
      this.field3534 = -1;
      this.healthScale = 30;
      this.field3531 = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgb;I)V",
      garbageValue = "-2078182693"
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgb;IB)V",
      garbageValue = "49"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3528 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3529 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3530 = 0;
      } else if(var2 == 5) {
         this.field3532 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3533 = var1.method3553();
      } else if(var2 == 8) {
         this.field3534 = var1.method3553();
      } else if(var2 == 11) {
         this.field3530 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3531 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Lla;",
      garbageValue = "1478558181"
   )
   public SpritePixels method4858() {
      if(this.field3533 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3526.get((long)this.field3533);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class1.method1(class229.field2678, this.field3533, 0);
            if(var1 != null) {
               field3526.put(var1, (long)this.field3533);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Lla;",
      garbageValue = "-3"
   )
   public SpritePixels method4867() {
      if(this.field3534 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3526.get((long)this.field3534);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class1.method1(class229.field2678, this.field3534, 0);
            if(var1 != null) {
               field3526.put(var1, (long)this.field3534);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljc;Ljava/lang/String;Ljava/lang/String;I)[Lla;",
      garbageValue = "-522363653"
   )
   @Export("getSprites")
   public static SpritePixels[] getSprites(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      byte[] var7 = var0.getConfigData(var3, var4);
      boolean var6;
      if(var7 == null) {
         var6 = false;
      } else {
         Widget.decodeSprite(var7);
         var6 = true;
      }

      SpritePixels[] var5;
      if(!var6) {
         var5 = null;
      } else {
         var5 = FontName.method5478();
      }

      return var5;
   }
}
