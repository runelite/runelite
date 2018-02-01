import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field3423;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field3420;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   public static NodeCache field3421;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   @Export("spriteCache")
   public static NodeCache spriteCache;
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "Lkk;"
   )
   @Export("rasterProvider")
   public static BufferProvider rasterProvider;
   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   static IndexedSprite field3434;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1845726097
   )
   public int field3432;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1119778357
   )
   public int field3425;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1202221267
   )
   public int field3430;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1949517409
   )
   public int field3427;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 796299125
   )
   public int field3428;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 735421205
   )
   public int field3429;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -57395329
   )
   int field3435;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 402642621
   )
   int field3419;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 317009499
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 990033145
   )
   public int field3433;

   static {
      field3421 = new NodeCache(64);
      spriteCache = new NodeCache(64);
   }

   public CombatInfo2() {
      this.field3425 = 255;
      this.field3430 = 255;
      this.field3427 = -1;
      this.field3428 = 1;
      this.field3429 = 70;
      this.field3435 = -1;
      this.field3419 = -1;
      this.healthScale = 30;
      this.field3433 = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgj;I)V",
      garbageValue = "882930548"
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgj;II)V",
      garbageValue = "-2117042214"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3425 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3430 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3427 = 0;
      } else if(var2 == 5) {
         this.field3429 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3435 = var1.method3414();
      } else if(var2 == 8) {
         this.field3419 = var1.method3414();
      } else if(var2 == 11) {
         this.field3427 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3433 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Lko;",
      garbageValue = "-1220140553"
   )
   public SpritePixels method4657() {
      if(this.field3435 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3435);
         if(var1 != null) {
            return var1;
         } else {
            var1 = BaseVarType.method17(field3420, this.field3435, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3435);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Lko;",
      garbageValue = "-901681418"
   )
   public SpritePixels method4669() {
      if(this.field3419 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3419);
         if(var1 != null) {
            return var1;
         } else {
            var1 = BaseVarType.method17(field3420, this.field3419, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3419);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "84"
   )
   static final void method4674(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class213.loadWidget(var0)) {
         CombatInfo1.method1599(FileRequest.widgets[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }
}
