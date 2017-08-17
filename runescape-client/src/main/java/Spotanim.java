import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   public static NodeCache field3323;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("spotanims")
   public static NodeCache spotanims;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   public static IndexDataBase field3311;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   public static IndexDataBase field3312;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1127049847
   )
   @Export("id")
   int id;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -202991385
   )
   public int field3316;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1645946781
   )
   int field3315;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 704094797
   )
   int field3321;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 941259583
   )
   int field3325;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -190744447
   )
   int field3313;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1061039127
   )
   int field3324;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1459816365
   )
   int field3318;
   @ObfuscatedName("l")
   short[] field3317;
   @ObfuscatedName("b")
   short[] field3319;
   @ObfuscatedName("w")
   short[] field3322;
   @ObfuscatedName("o")
   short[] field3320;

   static {
      spotanims = new NodeCache(64);
      field3323 = new NodeCache(30);
   }

   Spotanim() {
      this.field3316 = -1;
      this.field3321 = 128;
      this.field3325 = 128;
      this.field3313 = 0;
      this.field3324 = 0;
      this.field3318 = 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfb;II)V",
      garbageValue = "2092755531"
   )
   void method4363(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3315 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3316 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field3321 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field3325 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field3313 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3324 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3318 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3317 = new short[var3];
            this.field3322 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3317[var4] = (short)var1.readUnsignedShort();
               this.field3322[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3319 = new short[var3];
            this.field3320 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3319[var4] = (short)var1.readUnsignedShort();
               this.field3320[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Leo;",
      garbageValue = "1486622088"
   )
   public final Model method4367(int var1) {
      Model var2 = (Model)field3323.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2431(field3311, this.field3315, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3317 != null) {
            for(var4 = 0; var4 < this.field3317.length; ++var4) {
               var3.recolor(this.field3317[var4], this.field3322[var4]);
            }
         }

         if(this.field3319 != null) {
            for(var4 = 0; var4 < this.field3319.length; ++var4) {
               var3.method2446(this.field3319[var4], this.field3320[var4]);
            }
         }

         var2 = var3.light(this.field3324 + 64, this.field3318 + 850, -30, -50, -30);
         field3323.put(var2, (long)this.id);
      }

      Model var5;
      if(this.field3316 != -1 && var1 != -1) {
         var5 = PendingSpawn.getAnimation(this.field3316).method4718(var2, var1);
      } else {
         var5 = var2.method2526(true);
      }

      if(this.field3321 != 128 || this.field3325 != 128) {
         var5.method2539(this.field3321, this.field3325, this.field3321);
      }

      if(this.field3313 != 0) {
         if(this.field3313 == 90) {
            var5.method2535();
         }

         if(this.field3313 == 180) {
            var5.method2535();
            var5.method2535();
         }

         if(this.field3313 == 270) {
            var5.method2535();
            var5.method2535();
            var5.method2535();
         }
      }

      return var5;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lfb;I)V",
      garbageValue = "781361993"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4363(var1, var2);
      }
   }
}
