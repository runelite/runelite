import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   public static IndexDataBase field3404;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   public static IndexDataBase field3394;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("spotanims")
   public static NodeCache spotanims;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   public static NodeCache field3396;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -233073101
   )
   @Export("id")
   int id;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1733485207
   )
   int field3398;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -832145035
   )
   public int field3393;
   @ObfuscatedName("t")
   short[] field3399;
   @ObfuscatedName("p")
   short[] field3401;
   @ObfuscatedName("r")
   short[] field3400;
   @ObfuscatedName("l")
   short[] field3403;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 958592559
   )
   int field3402;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 24227449
   )
   int field3405;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 273348759
   )
   int field3406;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1580516675
   )
   int field3407;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1214887899
   )
   int field3408;

   static {
      spotanims = new NodeCache(64);
      field3396 = new NodeCache(30);
   }

   Spotanim() {
      this.field3393 = -1;
      this.field3402 = 128;
      this.field3405 = 128;
      this.field3406 = 0;
      this.field3407 = 0;
      this.field3408 = 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfr;I)V",
      garbageValue = "1613103659"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4493(var1, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfr;II)V",
      garbageValue = "712425166"
   )
   void method4493(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3398 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3393 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field3402 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field3405 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field3406 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3407 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3408 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3399 = new short[var3];
            this.field3401 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3399[var4] = (short)var1.readUnsignedShort();
               this.field3401[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3400 = new short[var3];
            this.field3403 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3400[var4] = (short)var1.readUnsignedShort();
               this.field3403[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Leh;",
      garbageValue = "1872388478"
   )
   public final Model method4494(int var1) {
      Model var2 = (Model)field3396.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2510(field3394, this.field3398, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3399 != null) {
            for(var4 = 0; var4 < this.field3399.length; ++var4) {
               var3.recolor(this.field3399[var4], this.field3401[var4]);
            }
         }

         if(this.field3400 != null) {
            for(var4 = 0; var4 < this.field3400.length; ++var4) {
               var3.method2523(this.field3400[var4], this.field3403[var4]);
            }
         }

         var2 = var3.light(this.field3407 + 64, this.field3408 + 850, -30, -50, -30);
         field3396.put(var2, (long)this.id);
      }

      Model var5;
      if(this.field3393 != -1 && var1 != -1) {
         var5 = class13.getAnimation(this.field3393).method4884(var2, var1);
      } else {
         var5 = var2.method2620(true);
      }

      if(this.field3402 != 128 || this.field3405 != 128) {
         var5.method2626(this.field3402, this.field3405, this.field3402);
      }

      if(this.field3406 != 0) {
         if(this.field3406 == 90) {
            var5.method2630();
         }

         if(this.field3406 == 180) {
            var5.method2630();
            var5.method2630();
         }

         if(this.field3406 == 270) {
            var5.method2630();
            var5.method2630();
            var5.method2630();
         }
      }

      return var5;
   }
}
