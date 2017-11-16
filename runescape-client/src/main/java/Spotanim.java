import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   public static IndexDataBase field3378;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   public static IndexDataBase field3385;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("spotanims")
   public static NodeCache spotanims;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   public static NodeCache field3376;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -95772713
   )
   @Export("id")
   int id;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2089901653
   )
   int field3374;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 793910469
   )
   public int field3387;
   @ObfuscatedName("t")
   short[] field3380;
   @ObfuscatedName("k")
   short[] field3386;
   @ObfuscatedName("n")
   short[] field3382;
   @ObfuscatedName("d")
   short[] field3383;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1972358529
   )
   int field3384;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1449035683
   )
   int field3375;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 663127895
   )
   int field3379;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1162509475
   )
   int field3381;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 836754815
   )
   int field3388;

   static {
      spotanims = new NodeCache(64);
      field3376 = new NodeCache(30);
   }

   Spotanim() {
      this.field3387 = -1;
      this.field3384 = 128;
      this.field3375 = 128;
      this.field3379 = 0;
      this.field3381 = 0;
      this.field3388 = 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfs;B)V",
      garbageValue = "-79"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4320(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfs;II)V",
      garbageValue = "1328999209"
   )
   void method4320(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3374 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3387 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field3384 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field3375 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field3379 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3381 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3388 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3380 = new short[var3];
            this.field3386 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3380[var4] = (short)var1.readUnsignedShort();
               this.field3386[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3382 = new short[var3];
            this.field3383 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3382[var4] = (short)var1.readUnsignedShort();
               this.field3383[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Lev;",
      garbageValue = "101"
   )
   public final Model method4321(int var1) {
      Model var2 = (Model)field3376.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2419(field3385, this.field3374, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3380 != null) {
            for(var4 = 0; var4 < this.field3380.length; ++var4) {
               var3.recolor(this.field3380[var4], this.field3386[var4]);
            }
         }

         if(this.field3382 != null) {
            for(var4 = 0; var4 < this.field3382.length; ++var4) {
               var3.method2432(this.field3382[var4], this.field3383[var4]);
            }
         }

         var2 = var3.light(this.field3381 + 64, this.field3388 + 850, -30, -50, -30);
         field3376.put(var2, (long)this.id);
      }

      Model var5;
      if(this.field3387 != -1 && var1 != -1) {
         var5 = class90.getAnimation(this.field3387).method4703(var2, var1);
      } else {
         var5 = var2.method2512(true);
      }

      if(this.field3384 != 128 || this.field3375 != 128) {
         var5.method2505(this.field3384, this.field3375, this.field3384);
      }

      if(this.field3379 != 0) {
         if(this.field3379 == 90) {
            var5.method2518();
         }

         if(this.field3379 == 180) {
            var5.method2518();
            var5.method2518();
         }

         if(this.field3379 == 270) {
            var5.method2518();
            var5.method2518();
            var5.method2518();
         }
      }

      return var5;
   }
}
