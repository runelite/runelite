import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("v")
   public static NodeCache field3321;
   @ObfuscatedName("e")
   public static NodeCache field3322;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 200506057
   )
   int field3324;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -414290629
   )
   int field3325;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -387244481
   )
   public int field3326;
   @ObfuscatedName("x")
   short[] field3327;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 71363113
   )
   int field3328;
   @ObfuscatedName("i")
   public static IndexDataBase field3329;
   @ObfuscatedName("a")
   short[] field3330;
   @ObfuscatedName("n")
   short[] field3331;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 664306371
   )
   int field3332;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1995235777
   )
   int field3333;
   @ObfuscatedName("f")
   short[] field3334;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 797699877
   )
   int field3335;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -393053521
   )
   int field3336;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;IS)V",
      garbageValue = "128"
   )
   void method4338(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3325 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3326 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field3335 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field3336 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field3333 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3332 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3328 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3327 = new short[var3];
            this.field3334 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3327[var4] = (short)var1.readUnsignedShort();
               this.field3334[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3331 = new short[var3];
            this.field3330 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3331[var4] = (short)var1.readUnsignedShort();
               this.field3330[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-741309143"
   )
   void method4339(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4338(var1, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)LModel;",
      garbageValue = "73"
   )
   public final Model method4341(int var1) {
      Model var2 = (Model)field3321.get((long)this.field3324);
      if(var2 == null) {
         ModelData var3 = ModelData.method2427(class12.field270, this.field3325, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3327 != null) {
            for(var4 = 0; var4 < this.field3327.length; ++var4) {
               var3.method2409(this.field3327[var4], this.field3334[var4]);
            }
         }

         if(this.field3331 != null) {
            for(var4 = 0; var4 < this.field3331.length; ++var4) {
               var3.method2450(this.field3331[var4], this.field3330[var4]);
            }
         }

         var2 = var3.method2417(this.field3332 + 64, this.field3328 + 850, -30, -50, -30);
         field3321.put(var2, (long)this.field3324);
      }

      Model var5;
      if(this.field3326 != -1 && var1 != -1) {
         var5 = class227.getAnimation(this.field3326).method4696(var2, var1);
      } else {
         var5 = var2.method2515(true);
      }

      if(this.field3335 != 128 || this.field3336 != 128) {
         var5.method2507(this.field3335, this.field3336, this.field3335);
      }

      if(this.field3333 != 0) {
         if(this.field3333 == 90) {
            var5.method2502();
         }

         if(this.field3333 == 180) {
            var5.method2502();
            var5.method2502();
         }

         if(this.field3333 == 270) {
            var5.method2502();
            var5.method2502();
            var5.method2502();
         }
      }

      return var5;
   }

   Spotanim() {
      this.field3326 = -1;
      this.field3335 = 128;
      this.field3336 = 128;
      this.field3333 = 0;
      this.field3332 = 0;
      this.field3328 = 0;
   }

   static {
      field3322 = new NodeCache(64);
      field3321 = new NodeCache(30);
   }
}
