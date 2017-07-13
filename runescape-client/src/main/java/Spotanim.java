import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("r")
   public static NodeCache field3327;
   @ObfuscatedName("n")
   @Export("spotanims")
   public static NodeCache spotanims;
   @ObfuscatedName("j")
   static IndexDataBase field3324;
   @ObfuscatedName("a")
   static IndexDataBase field3337;
   @ObfuscatedName("ad")
   protected static String field3340;
   @ObfuscatedName("q")
   static int[] field3339;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1920925885
   )
   @Export("id")
   int id;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1325085135
   )
   public int field3329;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1253440665
   )
   int field3334;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1850619791
   )
   int field3331;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1816141671
   )
   int field3335;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1695575337
   )
   int field3336;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1785558529
   )
   int field3326;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1738665771
   )
   int field3338;
   @ObfuscatedName("s")
   short[] field3323;
   @ObfuscatedName("p")
   short[] field3332;
   @ObfuscatedName("w")
   short[] field3330;
   @ObfuscatedName("m")
   short[] field3333;

   static {
      spotanims = new NodeCache(64);
      field3327 = new NodeCache(30);
   }

   Spotanim() {
      this.field3329 = -1;
      this.field3331 = 128;
      this.field3335 = 128;
      this.field3336 = 0;
      this.field3326 = 0;
      this.field3338 = 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1799084945"
   )
   void method4291(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3334 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3329 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field3331 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field3335 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field3336 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3326 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3338 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3323 = new short[var3];
            this.field3330 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3323[var4] = (short)var1.readUnsignedShort();
               this.field3330[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3332 = new short[var3];
            this.field3333 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3332[var4] = (short)var1.readUnsignedShort();
               this.field3333[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)LModel;",
      garbageValue = "13"
   )
   public final Model method4283(int var1) {
      Model var2 = (Model)field3327.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2396(field3324, this.field3334, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3323 != null) {
            for(var4 = 0; var4 < this.field3323.length; ++var4) {
               var3.recolor(this.field3323[var4], this.field3330[var4]);
            }
         }

         if(this.field3332 != null) {
            for(var4 = 0; var4 < this.field3332.length; ++var4) {
               var3.method2410(this.field3332[var4], this.field3333[var4]);
            }
         }

         var2 = var3.light(this.field3326 + 64, this.field3338 + 850, -30, -50, -30);
         field3327.put(var2, (long)this.id);
      }

      Model var5;
      if(this.field3329 != -1 && var1 != -1) {
         var5 = class112.getAnimation(this.field3329).method4635(var2, var1);
      } else {
         var5 = var2.method2496(true);
      }

      if(this.field3331 != 128 || this.field3335 != 128) {
         var5.method2524(this.field3331, this.field3335, this.field3331);
      }

      if(this.field3336 != 0) {
         if(this.field3336 == 90) {
            var5.method2506();
         }

         if(this.field3336 == 180) {
            var5.method2506();
            var5.method2506();
         }

         if(this.field3336 == 270) {
            var5.method2506();
            var5.method2506();
            var5.method2506();
         }
      }

      return var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-705078404"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4291(var1, var2);
      }
   }
}
