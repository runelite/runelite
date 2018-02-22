import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   public static IndexDataBase field3468;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   public static IndexDataBase field3454;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static NodeCache field3455;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("spriteCache")
   public static NodeCache spriteCache;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = -1217217181
   )
   static int field3469;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 348864235
   )
   public int field3465;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1973733621
   )
   public int field3453;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1405779521
   )
   public int field3461;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1889703285
   )
   public int field3462;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 706051311
   )
   public int field3463;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 685646679
   )
   public int field3460;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -993175685
   )
   int field3457;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1240083533
   )
   int field3466;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 574564449
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1552162577
   )
   public int field3464;

   static {
      field3455 = new NodeCache(64);
      spriteCache = new NodeCache(64);
   }

   public CombatInfo2() {
      this.field3453 = 255;
      this.field3461 = 255;
      this.field3462 = -1;
      this.field3463 = 1;
      this.field3460 = 70;
      this.field3457 = -1;
      this.field3466 = -1;
      this.healthScale = 30;
      this.field3464 = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgn;I)V",
      garbageValue = "-1462572742"
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgn;II)V",
      garbageValue = "567216827"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3453 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3461 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3462 = 0;
      } else if(var2 == 5) {
         this.field3460 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3457 = var1.method3732();
      } else if(var2 == 8) {
         this.field3466 = var1.method3732();
      } else if(var2 == 11) {
         this.field3462 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3464 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Llm;",
      garbageValue = "-48"
   )
   public SpritePixels method4841() {
      if(this.field3457 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3457);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class19.method165(field3454, this.field3457, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3457);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Llm;",
      garbageValue = "-123"
   )
   public SpritePixels method4842() {
      if(this.field3466 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3466);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class19.method165(field3454, this.field3466, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3466);
            }

            return var1;
         }
      }
   }
}
