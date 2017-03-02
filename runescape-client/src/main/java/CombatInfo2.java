import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1601259127
   )
   int field2830 = -1;
   @ObfuscatedName("l")
   static class182 field2831;
   @ObfuscatedName("i")
   public static NodeCache field2832 = new NodeCache(64);
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1452048295
   )
   public int field2833 = 0;
   @ObfuscatedName("t")
   public static NodeCache field2834 = new NodeCache(64);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 25072483
   )
   public int field2836 = 255;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1223789149
   )
   public int field2838 = -1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2078096871
   )
   public int field2839 = 1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -920863411
   )
   public int field2840 = 70;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -460523505
   )
   public int field2841 = 255;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 296520107
   )
   public int field2842;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -787991527
   )
   @Export("healthScale")
   public int healthScale = 30;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -4187883
   )
   int field2844 = -1;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = 2033451435
   )
   static int field2845;
   @ObfuscatedName("b")
   static class182 field2848;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "11"
   )
   void method3598(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3599(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1161735813"
   )
   void method3599(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2836 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2841 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field2838 = 0;
      } else if(var2 == 5) {
         this.field2840 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field2830 = var1.method2966();
      } else if(var2 == 8) {
         this.field2844 = var1.method2966();
      } else if(var2 == 11) {
         this.field2838 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field2833 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "88"
   )
   public SpritePixels method3600() {
      if(this.field2830 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2834.get((long)this.field2830);
         if(var1 != null) {
            return var1;
         } else {
            var1 = NPCComposition.method3812(field2831, this.field2830, 0);
            if(null != var1) {
               field2834.put(var1, (long)this.field2830);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "14"
   )
   public SpritePixels method3601() {
      if(this.field2844 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2834.get((long)this.field2844);
         if(null != var1) {
            return var1;
         } else {
            var1 = NPCComposition.method3812(field2831, this.field2844, 0);
            if(var1 != null) {
               field2834.put(var1, (long)this.field2844);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass159;IB)Z",
      garbageValue = "57"
   )
   static boolean method3616(class159 var0, int var1) {
      int var2 = var0.method3119(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method3119(1) != 0) {
            method3616(var0, var1);
         }

         var3 = var0.method3119(13);
         var4 = var0.method3119(13);
         boolean var12 = var0.method3119(1) == 1;
         if(var12) {
            class45.field894[++class45.field906 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var11 = Client.cachedPlayers[var1] = new Player();
            var11.field261 = var1;
            if(null != class45.field899[var1]) {
               var11.method227(class45.field899[var1]);
            }

            var11.field652 = class45.field904[var1];
            var11.interacting = class45.field905[var1];
            var7 = class45.field903[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var11.field658[0] = class45.field897[var1];
            var11.field260 = (byte)var8;
            var11.method230((var9 << 13) + var3 - MessageNode.baseX, var4 + (var10 << 13) - class2.baseY);
            var11.field242 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method3119(2);
         var4 = class45.field903[var1];
         class45.field903[var1] = (((var4 >> 28) + var3 & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var6;
         if(var2 == 2) {
            var3 = var0.method3119(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var6 = class45.field903[var1];
            var7 = var4 + (var6 >> 28) & 3;
            var8 = var6 >> 14 & 255;
            var9 = var6 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class45.field903[var1] = (var7 << 28) + (var8 << 14) + var9;
            return false;
         } else {
            var3 = var0.method3119(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var6 = var3 & 255;
            var7 = class45.field903[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = (var7 >> 14) + var5 & 255;
            var10 = var6 + var7 & 255;
            class45.field903[var1] = var10 + (var9 << 14) + (var8 << 28);
            return false;
         }
      }
   }
}
