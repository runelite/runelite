import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   static NodeCache field3360;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("spriteCache")
   static NodeCache spriteCache;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   static IndexDataBase field3367;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   static IndexDataBase field3369;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -75760411
   )
   int field3359;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1177676849
   )
   int field3372;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 686934467
   )
   public int field3361;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 936722299
   )
   public int field3365;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1663135793
   )
   public int field3366;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1453356703
   )
   public int field3368;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2067937291
   )
   public int field3362;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1566433677
   )
   public int field3370;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 451550863
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1074468931
   )
   public int field3364;

   static {
      field3360 = new NodeCache(64);
      spriteCache = new NodeCache(64);
   }

   CombatInfo2() {
      this.field3361 = 255;
      this.field3365 = 255;
      this.field3366 = -1;
      this.field3370 = 1;
      this.field3368 = 70;
      this.field3359 = -1;
      this.field3372 = -1;
      this.healthScale = 30;
      this.field3364 = 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfz;IB)V",
      garbageValue = "25"
   )
   void method4466(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3361 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3365 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3366 = 0;
      } else if(var2 == 5) {
         this.field3368 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3359 = var1.method3264();
      } else if(var2 == 8) {
         this.field3372 = var1.method3264();
      } else if(var2 == 11) {
         this.field3366 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3364 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfz;B)V",
      garbageValue = "89"
   )
   void method4482(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4466(var1, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Lky;",
      garbageValue = "-1525146751"
   )
   public SpritePixels method4468() {
      if(this.field3372 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3372);
         if(var1 != null) {
            return var1;
         } else {
            var1 = BuildType.method4173(field3369, this.field3372, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3372);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lky;",
      garbageValue = "-32747742"
   )
   public SpritePixels method4484() {
      if(this.field3359 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3359);
         if(var1 != null) {
            return var1;
         } else {
            var1 = BuildType.method4173(field3369, this.field3359, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3359);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Leh;IIII)V",
      garbageValue = "-1376378602"
   )
   public static final void method4464(Model var0, int var1, int var2, int var3) {
      if(class244.method4400(var0, var1, var2, var3)) {
         class7.field241.method3651(new class10(var0, var1, var2, var3, -65281));
      } else if(class7.field240 == class11.field275) {
         class7.field241.method3651(new class10(var0, var1, var2, var3, -16776961));
      }

   }
}
