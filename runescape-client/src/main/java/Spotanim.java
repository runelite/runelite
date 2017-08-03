import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   static NodeCache field3307;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("spotanims")
   static NodeCache spotanims;
   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   static Task field3320;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   public static IndexDataBase field3318;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   public static IndexDataBase field3310;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 905873819
   )
   @Export("id")
   int id;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1572846505
   )
   public int field3309;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -272671689
   )
   int field3306;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1136597933
   )
   int field3315;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -544796869
   )
   int field3316;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -350513263
   )
   int field3304;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1189341009
   )
   int field3308;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -884834735
   )
   int field3319;
   @ObfuscatedName("t")
   short[] field3311;
   @ObfuscatedName("r")
   short[] field3305;
   @ObfuscatedName("i")
   short[] field3312;
   @ObfuscatedName("g")
   short[] field3314;

   static {
      spotanims = new NodeCache(64);
      field3307 = new NodeCache(30);
   }

   Spotanim() {
      this.field3309 = -1;
      this.field3315 = 128;
      this.field3316 = 128;
      this.field3304 = 0;
      this.field3308 = 0;
      this.field3319 = 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfw;II)V",
      garbageValue = "-2076912658"
   )
   void method4313(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3306 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3309 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field3315 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field3316 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field3304 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3308 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3319 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3311 = new short[var3];
            this.field3312 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3311[var4] = (short)var1.readUnsignedShort();
               this.field3312[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3305 = new short[var3];
            this.field3314 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3305[var4] = (short)var1.readUnsignedShort();
               this.field3314[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)Lev;",
      garbageValue = "-407013775"
   )
   public final Model method4310(int var1) {
      Model var2 = (Model)field3307.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2477(field3318, this.field3306, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3311 != null) {
            for(var4 = 0; var4 < this.field3311.length; ++var4) {
               var3.recolor(this.field3311[var4], this.field3312[var4]);
            }
         }

         if(this.field3305 != null) {
            for(var4 = 0; var4 < this.field3305.length; ++var4) {
               var3.method2429(this.field3305[var4], this.field3314[var4]);
            }
         }

         var2 = var3.light(this.field3308 + 64, this.field3319 + 850, -30, -50, -30);
         field3307.put(var2, (long)this.id);
      }

      Model var5;
      if(this.field3309 != -1 && var1 != -1) {
         var5 = class40.getAnimation(this.field3309).method4688(var2, var1);
      } else {
         var5 = var2.method2527(true);
      }

      if(this.field3315 != 128 || this.field3316 != 128) {
         var5.method2521(this.field3315, this.field3316, this.field3315);
      }

      if(this.field3304 != 0) {
         if(this.field3304 == 90) {
            var5.method2516();
         }

         if(this.field3304 == 180) {
            var5.method2516();
            var5.method2516();
         }

         if(this.field3304 == 270) {
            var5.method2516();
            var5.method2516();
            var5.method2516();
         }
      }

      return var5;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfw;I)V",
      garbageValue = "-2115051497"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4313(var1, var2);
      }
   }
}
