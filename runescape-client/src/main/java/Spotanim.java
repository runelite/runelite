import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("z")
   short[] field3325;
   @ObfuscatedName("n")
   static IndexDataBase field3326;
   @ObfuscatedName("i")
   public static NodeCache field3327;
   @ObfuscatedName("j")
   public static NodeCache field3328;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 794398435
   )
   int field3329;
   @ObfuscatedName("p")
   static IndexDataBase field3330;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2067974443
   )
   int field3331;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -196339231
   )
   int field3332;
   @ObfuscatedName("h")
   short[] field3333;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1471564445
   )
   int field3334;
   @ObfuscatedName("e")
   short[] field3335;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -947409499
   )
   int field3336;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 182302039
   )
   int field3337;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1099147361
   )
   int field3338;
   @ObfuscatedName("g")
   short[] field3339;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1845376843
   )
   public int field3340;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1334633102"
   )
   void method4356(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4357(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-90234993"
   )
   void method4357(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3331 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3340 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field3336 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field3332 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field3338 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3337 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3329 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3325 = new short[var3];
            this.field3333 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3325[var4] = (short)var1.readUnsignedShort();
               this.field3333[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3339 = new short[var3];
            this.field3335 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3339[var4] = (short)var1.readUnsignedShort();
               this.field3335[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)LModel;",
      garbageValue = "759500610"
   )
   public final Model method4358(int var1) {
      Model var2 = (Model)field3328.get((long)this.field3334);
      if(var2 == null) {
         ModelData var3 = ModelData.method2416(field3330, this.field3331, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3325 != null) {
            for(var4 = 0; var4 < this.field3325.length; ++var4) {
               var3.method2490(this.field3325[var4], this.field3333[var4]);
            }
         }

         if(this.field3339 != null) {
            for(var4 = 0; var4 < this.field3339.length; ++var4) {
               var3.method2430(this.field3339[var4], this.field3335[var4]);
            }
         }

         var2 = var3.method2437(this.field3337 + 64, this.field3329 + 850, -30, -50, -30);
         field3328.put(var2, (long)this.field3334);
      }

      Model var5;
      if(this.field3340 != -1 && var1 != -1) {
         var5 = class169.getAnimation(this.field3340).method4731(var2, var1);
      } else {
         var5 = var2.method2512(true);
      }

      if(this.field3336 != 128 || this.field3332 != 128) {
         var5.method2527(this.field3336, this.field3332, this.field3336);
      }

      if(this.field3338 != 0) {
         if(this.field3338 == 90) {
            var5.method2522();
         }

         if(this.field3338 == 180) {
            var5.method2522();
            var5.method2522();
         }

         if(this.field3338 == 270) {
            var5.method2522();
            var5.method2522();
            var5.method2522();
         }
      }

      return var5;
   }

   static {
      field3327 = new NodeCache(64);
      field3328 = new NodeCache(30);
   }

   Spotanim() {
      this.field3340 = -1;
      this.field3336 = 128;
      this.field3332 = 128;
      this.field3338 = 0;
      this.field3337 = 0;
      this.field3329 = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "16711935"
   )
   public static byte[] method4370(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var1?class54.method774(var3):var3;
      } else if(var0 instanceof class176) {
         class176 var2 = (class176)var0;
         return var2.vmethod3361();
      } else {
         throw new IllegalArgumentException();
      }
   }
}
