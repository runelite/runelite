import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   public static NodeCache field3350;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("spriteCache")
   public static NodeCache spriteCache;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   public static IndexDataBase field3349;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   public static IndexDataBase field3359;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1177072907
   )
   int field3354;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -871142343
   )
   int field3358;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1691829415
   )
   public int field3348;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 94217861
   )
   public int field3355;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1008465909
   )
   public int field3353;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1035741005
   )
   public int field3357;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1495871795
   )
   public int field3360;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1351280805
   )
   public int field3352;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1222116663
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -752757863
   )
   public int field3361;

   static {
      field3350 = new NodeCache(64);
      spriteCache = new NodeCache(64);
   }

   public CombatInfo2() {
      this.field3348 = 255;
      this.field3353 = 255;
      this.field3355 = -1;
      this.field3360 = 1;
      this.field3357 = 70;
      this.field3358 = -1;
      this.field3354 = -1;
      this.healthScale = 30;
      this.field3361 = 0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lfb;IB)V",
      garbageValue = "-1"
   )
   void method4421(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3348 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3353 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3355 = 0;
      } else if(var2 == 5) {
         this.field3357 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3358 = var1.method3189();
      } else if(var2 == 8) {
         this.field3354 = var1.method3189();
      } else if(var2 == 11) {
         this.field3355 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3361 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfb;I)V",
      garbageValue = "-557879734"
   )
   public void method4420(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4421(var1, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Lkp;",
      garbageValue = "-2009797315"
   )
   public SpritePixels method4423() {
      if(this.field3354 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3354);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class252.method4470(field3359, this.field3354, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3354);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Lkp;",
      garbageValue = "-1697429008"
   )
   public SpritePixels method4427() {
      if(this.field3358 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3358);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class252.method4470(field3359, this.field3358, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3358);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "1121513385"
   )
   public static String method4434(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var2 + var1; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class270.field3665[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class270.field3665[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class270.field3665[(var6 & 15) << 2 | var7 >>> 6]).append(class270.field3665[var7 & 63]);
            } else {
               var3.append(class270.field3665[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class270.field3665[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }
}
