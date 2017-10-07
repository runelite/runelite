import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   public static NodeCache field3323;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("spotanims")
   public static NodeCache spotanims;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   static IndexDataBase field3320;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   static IndexDataBase field3321;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 898170275
   )
   static int field3336;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1272852755
   )
   @Export("id")
   int id;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -32404851
   )
   public int field3326;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 135820299
   )
   int field3325;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -133447525
   )
   int field3331;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1781996839
   )
   int field3332;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 933727301
   )
   int field3333;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1286471205
   )
   int field3334;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1874012675
   )
   int field3335;
   @ObfuscatedName("g")
   short[] field3327;
   @ObfuscatedName("t")
   short[] field3329;
   @ObfuscatedName("v")
   short[] field3328;
   @ObfuscatedName("y")
   short[] field3330;

   static {
      spotanims = new NodeCache(64);
      field3323 = new NodeCache(30);
   }

   Spotanim() {
      this.field3326 = -1;
      this.field3331 = 128;
      this.field3332 = 128;
      this.field3333 = 0;
      this.field3334 = 0;
      this.field3335 = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfg;II)V",
      garbageValue = "-1025853693"
   )
   void method4438(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3325 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3326 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field3331 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field3332 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field3333 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3334 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3335 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3327 = new short[var3];
            this.field3328 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3327[var4] = (short)var1.readUnsignedShort();
               this.field3328[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3329 = new short[var3];
            this.field3330 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3329[var4] = (short)var1.readUnsignedShort();
               this.field3330[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Leb;",
      garbageValue = "-156921975"
   )
   public final Model method4436(int var1) {
      Model var2 = (Model)field3323.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2498(field3320, this.field3325, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3327 != null) {
            for(var4 = 0; var4 < this.field3327.length; ++var4) {
               var3.recolor(this.field3327[var4], this.field3328[var4]);
            }
         }

         if(this.field3329 != null) {
            for(var4 = 0; var4 < this.field3329.length; ++var4) {
               var3.method2513(this.field3329[var4], this.field3330[var4]);
            }
         }

         var2 = var3.light(this.field3334 + 64, this.field3335 + 850, -30, -50, -30);
         field3323.put(var2, (long)this.id);
      }

      Model var5;
      if(this.field3326 != -1 && var1 != -1) {
         var5 = class204.getAnimation(this.field3326).method4785(var2, var1);
      } else {
         var5 = var2.method2591(true);
      }

      if(this.field3331 != 128 || this.field3332 != 128) {
         var5.method2606(this.field3331, this.field3332, this.field3331);
      }

      if(this.field3333 != 0) {
         if(this.field3333 == 90) {
            var5.method2656();
         }

         if(this.field3333 == 180) {
            var5.method2656();
            var5.method2656();
         }

         if(this.field3333 == 270) {
            var5.method2656();
            var5.method2656();
            var5.method2656();
         }
      }

      return var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfg;B)V",
      garbageValue = "-103"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4438(var1, var2);
      }
   }
}
