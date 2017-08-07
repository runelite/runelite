import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   static NodeCache field3318;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("spotanims")
   static NodeCache spotanims;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   static IndexDataBase field3316;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   static IndexDataBase field3322;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1444316309
   )
   @Export("id")
   int id;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -256540037
   )
   public int field3331;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 174464101
   )
   int field3320;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2031911797
   )
   int field3326;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1008916159
   )
   int field3329;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 421245411
   )
   int field3328;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1105093419
   )
   int field3323;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1439663829
   )
   int field3330;
   @ObfuscatedName("z")
   short[] field3315;
   @ObfuscatedName("u")
   short[] field3324;
   @ObfuscatedName("r")
   short[] field3321;
   @ObfuscatedName("d")
   short[] field3325;

   static {
      spotanims = new NodeCache(64);
      field3318 = new NodeCache(30);
   }

   Spotanim() {
      this.field3331 = -1;
      this.field3326 = 128;
      this.field3329 = 128;
      this.field3328 = 0;
      this.field3323 = 0;
      this.field3330 = 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lfh;IB)V",
      garbageValue = "127"
   )
   void method4335(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3320 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3331 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field3326 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field3329 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field3328 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3323 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3330 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3315 = new short[var3];
            this.field3321 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3315[var4] = (short)var1.readUnsignedShort();
               this.field3321[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3324 = new short[var3];
            this.field3325 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3324[var4] = (short)var1.readUnsignedShort();
               this.field3325[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lew;",
      garbageValue = "1521061038"
   )
   public final Model method4337(int var1) {
      Model var2 = (Model)field3318.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2434(field3316, this.field3320, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3315 != null) {
            for(var4 = 0; var4 < this.field3315.length; ++var4) {
               var3.recolor(this.field3315[var4], this.field3321[var4]);
            }
         }

         if(this.field3324 != null) {
            for(var4 = 0; var4 < this.field3324.length; ++var4) {
               var3.method2447(this.field3324[var4], this.field3325[var4]);
            }
         }

         var2 = var3.light(this.field3323 + 64, this.field3330 + 850, -30, -50, -30);
         field3318.put(var2, (long)this.id);
      }

      Model var5;
      if(this.field3331 != -1 && var1 != -1) {
         var5 = Ignore.getAnimation(this.field3331).method4717(var2, var1);
      } else {
         var5 = var2.method2554(true);
      }

      if(this.field3326 != 128 || this.field3329 != 128) {
         var5.method2531(this.field3326, this.field3329, this.field3326);
      }

      if(this.field3328 != 0) {
         if(this.field3328 == 90) {
            var5.method2556();
         }

         if(this.field3328 == 180) {
            var5.method2556();
            var5.method2556();
         }

         if(this.field3328 == 270) {
            var5.method2556();
            var5.method2556();
            var5.method2556();
         }
      }

      return var5;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfh;I)V",
      garbageValue = "-172334859"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4335(var1, var2);
      }
   }
}
