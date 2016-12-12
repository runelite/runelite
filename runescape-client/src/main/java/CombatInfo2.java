import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -96149601
   )
   public int field2830 = 1;
   @ObfuscatedName("e")
   public static class182 field2831;
   @ObfuscatedName("i")
   public static class182 field2832;
   @ObfuscatedName("k")
   static NodeCache field2833 = new NodeCache(64);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -641123837
   )
   public int field2834;
   @ObfuscatedName("f")
   static NodeCache field2837 = new NodeCache(64);
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1027918735
   )
   public int field2838 = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1614036705
   )
   public int field2839 = 255;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1007244253
   )
   @Export("healthScale")
   public int healthScale = 30;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1444016015
   )
   public int field2841 = 70;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1796100725
   )
   int field2842 = -1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1668533885
   )
   int field2843 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2011046657
   )
   public int field2844 = 255;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1819611809
   )
   public int field2845 = 0;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1725947190"
   )
   void method3469(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3472(var1, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "4"
   )
   public SpritePixels method3470() {
      if(this.field2842 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2833.get((long)this.field2842);
         if(null != var1) {
            return var1;
         } else {
            var1 = Player.method218(field2831, this.field2842, 0);
            if(var1 != null) {
               field2833.put(var1, (long)this.field2842);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "-84"
   )
   public SpritePixels method3471() {
      if(this.field2843 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field2833.get((long)this.field2843);
         if(var1 != null) {
            return var1;
         } else {
            var1 = Player.method218(field2831, this.field2843, 0);
            if(var1 != null) {
               field2833.put(var1, (long)this.field2843);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-39"
   )
   void method3472(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field2844 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field2839 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field2838 = 0;
      } else if(var2 == 5) {
         this.field2841 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field2842 = var1.method2774();
      } else if(var2 == 8) {
         this.field2843 = var1.method2774();
      } else if(var2 == 11) {
         this.field2838 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field2845 = var1.readUnsignedByte();
      }

   }
}
