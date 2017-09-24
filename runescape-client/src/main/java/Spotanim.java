import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   public static NodeCache field3329;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("spotanims")
   public static NodeCache spotanims;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   public static IndexDataBase field3336;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   public static IndexDataBase field3331;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1546318791
   )
   @Export("id")
   int id;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 824781531
   )
   public int field3332;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1526640035
   )
   int field3326;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 318714527
   )
   int field3337;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1550985055
   )
   int field3338;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 301136411
   )
   int field3339;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 633759847
   )
   int field3340;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1269533305
   )
   int field3341;
   @ObfuscatedName("b")
   short[] field3333;
   @ObfuscatedName("s")
   short[] field3335;
   @ObfuscatedName("k")
   short[] field3334;
   @ObfuscatedName("d")
   short[] field3327;

   static {
      spotanims = new NodeCache(64);
      field3329 = new NodeCache(30);
   }

   Spotanim() {
      this.field3332 = -1;
      this.field3337 = 128;
      this.field3338 = 128;
      this.field3339 = 0;
      this.field3340 = 0;
      this.field3341 = 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "269879949"
   )
   void method4332(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3326 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3332 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field3337 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field3338 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field3339 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3340 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3341 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3333 = new short[var3];
            this.field3334 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3333[var4] = (short)var1.readUnsignedShort();
               this.field3334[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3335 = new short[var3];
            this.field3327 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3335[var4] = (short)var1.readUnsignedShort();
               this.field3327[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Lem;",
      garbageValue = "-1410500669"
   )
   public final Model method4339(int var1) {
      Model var2 = (Model)field3329.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2414(field3336, this.field3326, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3333 != null) {
            for(var4 = 0; var4 < this.field3333.length; ++var4) {
               var3.recolor(this.field3333[var4], this.field3334[var4]);
            }
         }

         if(this.field3335 != null) {
            for(var4 = 0; var4 < this.field3335.length; ++var4) {
               var3.method2465(this.field3335[var4], this.field3327[var4]);
            }
         }

         var2 = var3.light(this.field3340 + 64, this.field3341 + 850, -30, -50, -30);
         field3329.put(var2, (long)this.id);
      }

      Model var5;
      if(this.field3332 != -1 && var1 != -1) {
         var5 = class216.getAnimation(this.field3332).method4669(var2, var1);
      } else {
         var5 = var2.method2530(true);
      }

      if(this.field3337 != 128 || this.field3338 != 128) {
         var5.method2550(this.field3337, this.field3338, this.field3337);
      }

      if(this.field3339 != 0) {
         if(this.field3339 == 90) {
            var5.method2509();
         }

         if(this.field3339 == 180) {
            var5.method2509();
            var5.method2509();
         }

         if(this.field3339 == 270) {
            var5.method2509();
            var5.method2509();
            var5.method2509();
         }
      }

      return var5;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfp;B)V",
      garbageValue = "65"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4332(var1, var2);
      }
   }
}
