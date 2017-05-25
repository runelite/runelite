import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1356106375
   )
   int field3310;
   @ObfuscatedName("h")
   public static IndexDataBase field3311;
   @ObfuscatedName("u")
   public static NodeCache field3312;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 1207496515
   )
   static int field3313;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1460748415
   )
   int field3314;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1901122753
   )
   int field3315;
   @ObfuscatedName("a")
   short[] field3316;
   @ObfuscatedName("p")
   short[] field3317;
   @ObfuscatedName("l")
   short[] field3318;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1951187357
   )
   public int field3319;
   @ObfuscatedName("k")
   short[] field3320;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 997079771
   )
   int field3321;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1855886159
   )
   int field3322;
   @ObfuscatedName("i")
   public static IndexDataBase field3323;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 887562113
   )
   int field3324;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 638107153
   )
   int field3325;
   @ObfuscatedName("q")
   public static NodeCache field3328;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "245024857"
   )
   void method4405(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4406(var1, var2);
      }
   }

   Spotanim() {
      this.field3319 = -1;
      this.field3321 = 128;
      this.field3322 = 128;
      this.field3314 = 0;
      this.field3324 = 0;
      this.field3325 = 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;IS)V",
      garbageValue = "1847"
   )
   void method4406(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3315 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3319 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field3321 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field3322 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field3314 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3324 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3325 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3317 = new short[var3];
            this.field3318 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3317[var4] = (short)var1.readUnsignedShort();
               this.field3318[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3316 = new short[var3];
            this.field3320 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3316[var4] = (short)var1.readUnsignedShort();
               this.field3320[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)LModel;",
      garbageValue = "1877457953"
   )
   public final Model method4407(int var1) {
      Model var2 = (Model)field3328.get((long)this.field3310);
      if(var2 == null) {
         ModelData var3 = ModelData.method2443(field3311, this.field3315, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3317 != null) {
            for(var4 = 0; var4 < this.field3317.length; ++var4) {
               var3.method2505(this.field3317[var4], this.field3318[var4]);
            }
         }

         if(this.field3316 != null) {
            for(var4 = 0; var4 < this.field3316.length; ++var4) {
               var3.method2511(this.field3316[var4], this.field3320[var4]);
            }
         }

         var2 = var3.method2487(this.field3324 + 64, this.field3325 + 850, -30, -50, -30);
         field3328.put(var2, (long)this.field3310);
      }

      Model var5;
      if(this.field3319 != -1 && var1 != -1) {
         var5 = class165.getAnimation(this.field3319).method4757(var2, var1);
      } else {
         var5 = var2.method2558(true);
      }

      if(this.field3321 != 128 || this.field3322 != 128) {
         var5.method2533(this.field3321, this.field3322, this.field3321);
      }

      if(this.field3314 != 0) {
         if(this.field3314 == 90) {
            var5.method2546();
         }

         if(this.field3314 == 180) {
            var5.method2546();
            var5.method2546();
         }

         if(this.field3314 == 270) {
            var5.method2546();
            var5.method2546();
            var5.method2546();
         }
      }

      return var5;
   }

   static {
      field3312 = new NodeCache(64);
      field3328 = new NodeCache(30);
   }
}
