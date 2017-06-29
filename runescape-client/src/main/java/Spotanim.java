import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("a")
   static NodeCache field3330;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 699885181
   )
   public int field3332;
   @ObfuscatedName("t")
   static NodeCache field3333;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2136317673
   )
   int field3334;
   @ObfuscatedName("j")
   short[] field3335;
   @ObfuscatedName("k")
   short[] field3336;
   @ObfuscatedName("y")
   short[] field3337;
   @ObfuscatedName("w")
   public static IndexDataBase field3338;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -402846049
   )
   int field3339;
   @ObfuscatedName("e")
   short[] field3340;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1688514667
   )
   int field3341;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -498472597
   )
   int field3342;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 315907969
   )
   int field3343;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 139718341
   )
   int field3344;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1669362253
   )
   int field3345;
   @ObfuscatedName("i")
   public static IndexDataBase field3347;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1639642304"
   )
   void method4337(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3345 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3332 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field3341 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field3342 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field3343 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3344 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3339 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3337 = new short[var3];
            this.field3335 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3337[var4] = (short)var1.readUnsignedShort();
               this.field3335[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3336 = new short[var3];
            this.field3340 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3336[var4] = (short)var1.readUnsignedShort();
               this.field3340[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)LModel;",
      garbageValue = "92"
   )
   public final Model method4338(int var1) {
      Model var2 = (Model)field3333.get((long)this.field3334);
      if(var2 == null) {
         ModelData var3 = ModelData.method2414(field3338, this.field3345, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3337 != null) {
            for(var4 = 0; var4 < this.field3337.length; ++var4) {
               var3.method2422(this.field3337[var4], this.field3335[var4]);
            }
         }

         if(this.field3336 != null) {
            for(var4 = 0; var4 < this.field3336.length; ++var4) {
               var3.method2450(this.field3336[var4], this.field3340[var4]);
            }
         }

         var2 = var3.light(this.field3344 + 64, this.field3339 + 850, -30, -50, -30);
         field3333.put(var2, (long)this.field3334);
      }

      Model var5;
      if(this.field3332 != -1 && var1 != -1) {
         var5 = class224.getAnimation(this.field3332).method4693(var2, var1);
      } else {
         var5 = var2.method2500(true);
      }

      if(this.field3341 != 128 || this.field3342 != 128) {
         var5.method2566(this.field3341, this.field3342, this.field3341);
      }

      if(this.field3343 != 0) {
         if(this.field3343 == 90) {
            var5.method2487();
         }

         if(this.field3343 == 180) {
            var5.method2487();
            var5.method2487();
         }

         if(this.field3343 == 270) {
            var5.method2487();
            var5.method2487();
            var5.method2487();
         }
      }

      return var5;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1744372001"
   )
   void method4341(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4337(var1, var2);
      }
   }

   static {
      field3330 = new NodeCache(64);
      field3333 = new NodeCache(30);
   }

   Spotanim() {
      this.field3332 = -1;
      this.field3341 = 128;
      this.field3342 = 128;
      this.field3343 = 0;
      this.field3344 = 0;
      this.field3339 = 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1799643911"
   )
   static void method4355(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class286.field3798 = var1.readUnsignedShort();
      class286.field3799 = new int[class286.field3798];
      class286.field3800 = new int[class286.field3798];
      class7.field239 = new int[class286.field3798];
      class226.field3146 = new int[class286.field3798];
      class210.field2609 = new byte[class286.field3798][];
      var1.offset = var0.length - 7 - class286.field3798 * 8;
      class286.field3801 = var1.readUnsignedShort();
      class286.field3796 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class286.field3798; ++var3) {
         class286.field3799[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class286.field3798; ++var3) {
         class286.field3800[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class286.field3798; ++var3) {
         class7.field239[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class286.field3798; ++var3) {
         class226.field3146[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class286.field3798 * 8 - (var2 - 1) * 3;
      class278.field3745 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class278.field3745[var3] = var1.read24BitInt();
         if(class278.field3745[var3] == 0) {
            class278.field3745[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class286.field3798; ++var3) {
         int var4 = class7.field239[var3];
         int var5 = class226.field3146[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         class210.field2609[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var10 * var4 + var9] = var1.readByte();
               }
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZIZI)I",
      garbageValue = "1796230676"
   )
   static int method4356(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = GameObject.method2892(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = GameObject.method2892(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }
}
