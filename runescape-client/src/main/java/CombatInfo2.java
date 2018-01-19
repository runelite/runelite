import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   public static IndexDataBase field3455;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   static IndexDataBase field3453;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   public static NodeCache field3452;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   @Export("spriteCache")
   public static NodeCache spriteCache;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 754700615
   )
   public int field3456;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 313077809
   )
   public int field3458;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -811725285
   )
   public int field3454;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1044483327
   )
   public int field3460;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1252029015
   )
   public int field3461;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2078016757
   )
   public int field3462;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1741339031
   )
   int field3463;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1325066053
   )
   int field3464;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 673360983
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1716840249
   )
   public int field3466;

   static {
      field3452 = new NodeCache(64);
      spriteCache = new NodeCache(64);
   }

   public CombatInfo2() {
      this.field3458 = 255;
      this.field3454 = 255;
      this.field3460 = -1;
      this.field3461 = 1;
      this.field3462 = 70;
      this.field3463 = -1;
      this.field3464 = -1;
      this.healthScale = 30;
      this.field3466 = 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lgv;S)V",
      garbageValue = "-2517"
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

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lgv;IB)V",
      garbageValue = "-55"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3458 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3454 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3460 = 0;
      } else if(var2 == 5) {
         this.field3462 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3463 = var1.method3514();
      } else if(var2 == 8) {
         this.field3464 = var1.method3514();
      } else if(var2 == 11) {
         this.field3460 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3466 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lkg;",
      garbageValue = "-2082258610"
   )
   public SpritePixels method4586() {
      if(this.field3463 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3463);
         if(var1 != null) {
            return var1;
         } else {
            var1 = GameCanvas.method772(field3453, this.field3463, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3463);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Lkg;",
      garbageValue = "-642810839"
   )
   public SpritePixels method4587() {
      if(this.field3464 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3464);
         if(var1 != null) {
            return var1;
         } else {
            var1 = GameCanvas.method772(field3453, this.field3464, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3464);
            }

            return var1;
         }
      }
   }
}
